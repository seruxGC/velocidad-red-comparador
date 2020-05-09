package app.context;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.estrategias.Formato1Strategy;
import app.estrategias.Formato2Strategy;
import app.estrategias.Formato3Strategy;
import app.interfaces.ComparacionVelocidadStrategy;

public class VelocidadRedComparador {

    // Formato 1
    private static final String REGEX_FORMATO_1 = "Acceso VPN IP .*";
    private static final Pattern PATRON_FORMATO_1 = Pattern.compile(REGEX_FORMATO_1);

    // Formato 2
    private static final String REGEX_FORMATO_2 = "\\b\\d+(M|G)?-\\d+(M|G)?\\b";
    private static final Pattern PATRON_FORMATO_2 = Pattern.compile(REGEX_FORMATO_2);

    // Formato 3
    private static final String REGEX_FORMATO_3 = "^[1-9]\\d*((\\.\\d+)?|(,\\d+)?) (Kbps|Mbps|Gbps)$";
    private static final Pattern PATRON_FORMATO_3 = Pattern.compile(REGEX_FORMATO_3);

    private HashMap<Pattern, ComparacionVelocidadStrategy> mapaEstrategias = new HashMap<>();

    public VelocidadRedComparador() {
        mapaEstrategias.put(PATRON_FORMATO_1, new Formato1Strategy());
        mapaEstrategias.put(PATRON_FORMATO_2, new Formato2Strategy());
        mapaEstrategias.put(PATRON_FORMATO_3, new Formato3Strategy());
    }

    /**
     * @param velocidadRed1
     * @param velocidadRed2
     * @return True si velocidadRed1 > velocidadRed2 , False en caso contrario
     */
    public boolean compara(String velocidadRed1, String velocidadRed2) {

        ComparacionVelocidadStrategy estrategiaVelocidad1 = escogeEstrategia(velocidadRed1);
        ComparacionVelocidadStrategy estrategiaVelocidad2 = escogeEstrategia(velocidadRed2);

        if (!velocidadesTienenMismoFormato(estrategiaVelocidad1, estrategiaVelocidad2)) {
            throw new IllegalArgumentException("las velocidades comparadas no tienen el mismo formato");
        }

        return estrategiaVelocidad1.compara(velocidadRed1, velocidadRed2);
    }

    private static boolean velocidadesTienenMismoFormato(ComparacionVelocidadStrategy estrategiaVelocidad1,
            ComparacionVelocidadStrategy estrategiaVelocidad2) {
        return estrategiaVelocidad1.getClass().getCanonicalName()
                .equals(estrategiaVelocidad2.getClass().getCanonicalName());
    }

    /**
     * Busca en el mapa de estrategias si hay alguna que cumple con uno de los
     * patrones implementados y en caso de que lo encuentre devuelve la estrategia a
     * utilizar
     * 
     * @param velocidadRed
     * @return Devuelve la estrategia a utilizar o IllegalArgumentException en caso
     *         de que no encuentre ninguna.
     */
    private ComparacionVelocidadStrategy escogeEstrategia(String velocidadRed) {

        for (Map.Entry<Pattern, ComparacionVelocidadStrategy> estrategia : mapaEstrategias.entrySet()) {
            Pattern patron = estrategia.getKey();
            Matcher matcher = patron.matcher(velocidadRed);

            if (matcher.matches()) {
                return estrategia.getValue();
            }
        }

        throw new IllegalArgumentException("El formato de Velocidad '" + velocidadRed + "' no esta implementado");
    }

}