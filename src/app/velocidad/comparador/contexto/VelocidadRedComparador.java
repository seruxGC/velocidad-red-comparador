package app.velocidad.comparador.contexto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.velocidad.comparador.estrategias.Formato1Strategy;
import app.velocidad.comparador.estrategias.Formato2Strategy;
import app.velocidad.comparador.interfaces.ComparacionVelocidadStrategy;

public class VelocidadRedComparador {

    /**
     * Mapa que contiene todos los patrones de velocidad y la estrategia a utilizar
     * para cada uno
     */
    private static final Map<Pattern, ComparacionVelocidadStrategy> mapaEstrategias;

    static {
        Map<Pattern, ComparacionVelocidadStrategy> tempMap = new HashMap<>();

        tempMap.put(Formato1Strategy.PATTERN, new Formato1Strategy());
        tempMap.put(Formato2Strategy.PATTERN, new Formato2Strategy());

        mapaEstrategias = Collections.unmodifiableMap(tempMap);
    }

    private VelocidadRedComparador() {
        throw new IllegalStateException("Clase de utilidad");
    }

    public static boolean primeraVelocidadEsMayor(String velocidadRed1, String velocidadRed2) {

        ComparacionVelocidadStrategy estrategiaVelocidad = escogeEstrategia(velocidadRed1, velocidadRed2);

        return estrategiaVelocidad.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
    }

    public static boolean velocidadesSonIguales(String velocidadRed1, String velocidadRed2) {

        ComparacionVelocidadStrategy estrategiaVelocidad = escogeEstrategia(velocidadRed1, velocidadRed2);

        return estrategiaVelocidad.velocidadesSonIguales(velocidadRed1, velocidadRed2);
    }

    /**
     * Busca en el mapa de estrategias si hay alguna que cumple con uno de los
     * patrones de velocidad implementados
     * 
     * @param velocidadRed1
     * @return Devuelve la estrategia a utilizar o IllegalArgumentException en caso
     *         de que no encuentre ninguna.
     */
    private static ComparacionVelocidadStrategy escogeEstrategia(String velocidadRed1, String velocidadRed2) {

        for (Map.Entry<Pattern, ComparacionVelocidadStrategy> estrategia : mapaEstrategias.entrySet()) {

            // Obtenemos el patron de la key del mapa
            Pattern patron = estrategia.getKey();

            Matcher matcher1 = patron.matcher(velocidadRed1);
            Matcher matcher2 = patron.matcher(velocidadRed2);

            // Si el formato de ambas velocidades coinciden con el patron de la estrategia
            // la usamos
            if (matcher1.matches() && matcher2.matches()) {
                return estrategia.getValue();
            }
        }

        throw new IllegalArgumentException(
                "Estrategia no implementada para  '" + velocidadRed1 + "' y  '" + velocidadRed2 + "'");
    }

}