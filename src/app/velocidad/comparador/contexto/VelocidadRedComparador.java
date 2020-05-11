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

    // Mapa que contiene todos los patrones de velocidad y la estrategia a utilizar para cada uno
    private static final Map<Pattern, ComparacionVelocidadStrategy> mapaEstrategias;
    
    static {
        Map<Pattern, ComparacionVelocidadStrategy> tempMap = new HashMap<>();

        /**
         * TODO cambiar el lugar de instanciacion y dejar en el mapa solo el nombre de
         * la clase a isntanciar para pasarle como argumentos la velocidad 1 y 2 por el
         * constructor
         */
        tempMap.put(Formato1Strategy.PATTERN, new Formato1Strategy());
        tempMap.put(Formato2Strategy.PATTERN, new Formato2Strategy());

        mapaEstrategias = Collections.unmodifiableMap(tempMap);
    }

    private VelocidadRedComparador() {
        throw new IllegalStateException("Clase de utilidad");
    }


    public static boolean primeraVelocidadEsMayor(String velocidadRed1, String velocidadRed2) {

        ComparacionVelocidadStrategy estrategiaVelocidad1 = escogeEstrategia(velocidadRed1);
        ComparacionVelocidadStrategy estrategiaVelocidad2 = escogeEstrategia(velocidadRed2);

        if (!velocidadesTienenMismoFormato(estrategiaVelocidad1, estrategiaVelocidad2)) {
            throw new IllegalArgumentException("las velocidades comparadas no tienen el mismo formato");
        }

        return estrategiaVelocidad1.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
    }

    public static boolean velocidadesSonIguales(String velocidadRed1, String velocidadRed2) {

        ComparacionVelocidadStrategy estrategiaVelocidad1 = escogeEstrategia(velocidadRed1);
        ComparacionVelocidadStrategy estrategiaVelocidad2 = escogeEstrategia(velocidadRed2);

        if (!velocidadesTienenMismoFormato(estrategiaVelocidad1, estrategiaVelocidad2)) {
            throw new IllegalArgumentException("las velocidades comparadas no tienen el mismo formato");
        }

        return estrategiaVelocidad1.velocidadesSonIguales(velocidadRed1, velocidadRed2);
    }

    private static boolean velocidadesTienenMismoFormato(ComparacionVelocidadStrategy estrategiaVelocidad1,
            ComparacionVelocidadStrategy estrategiaVelocidad2) {
        return estrategiaVelocidad1.getClass().getCanonicalName()
                .equals(estrategiaVelocidad2.getClass().getCanonicalName());
    }

    /**
     * Busca en el mapa de estrategias si hay alguna que cumple con uno de los
     * patrones de velocidad implementados y en caso de que lo encuentre devuelve la
     * estrategia a utilizar
     * 
     * @param velocidadRed
     * @return Devuelve la estrategia a utilizar o IllegalArgumentException en caso
     *         de que no encuentre ninguna.
     */
    private static ComparacionVelocidadStrategy escogeEstrategia(String velocidadRed) {

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