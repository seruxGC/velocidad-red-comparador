package app.velocidad.comparador.estrategias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.velocidad.comparador.config.UnidadVelocidad;
import app.velocidad.comparador.interfaces.ComparacionVelocidadStrategy;

/**
 * Formato 2
 * https://github.com/seruxGC/velocidad-red-comparador/blob/master/README.md#formato-2
 */
public class Formato2Strategy implements ComparacionVelocidadStrategy {

    private static final String REGEX_FORMATO = "^[\\[,\\{]?(\\d+[\\,\\.]?\\d*?)\\s?\\-?\\s?(Kbps|Mbps|Gbps)[\\},\\]]?$";
    public static final Pattern PATTERN = Pattern.compile(REGEX_FORMATO);

    private static final String KILOBITS_SEGUNDO = "Kbps";
    private static final String MEGABITS_SEGUNDO = "Mbps";
    private static final String GIBABITS_SEGUNDO = "Gbps";

    private static final short MULTIPLO_VELOCIDADES = 1000;

    @Override
    public boolean primeraVelocidadEsMayor(String velocidadRed1, String velocidadRed2) {

        float velocidadMegabits1 = velocidadEnMegabits(velocidadRed1);
        float velocidadMegabits2 = velocidadEnMegabits(velocidadRed2);

        return velocidadMegabits1 > velocidadMegabits2;
    }

    @Override
    public boolean velocidadesSonIguales(String velocidadRed1, String velocidadRed2) {

        float velocidadMegabits1 = velocidadEnMegabits(velocidadRed1);
        float velocidadMegabits2 = velocidadEnMegabits(velocidadRed2);

        return velocidadMegabits1 == velocidadMegabits2;

    }

    private float velocidadEnMegabits(String velocidadRed) {

        Matcher matcher = matchPattern(velocidadRed);
         UnidadVelocidad unidadVelocidad = obtenerUnidadVelocidad(matcher);

        if (UnidadVelocidad.KILOBITS_SEGUNDO == unidadVelocidad) {
            return obtenerNumeroVelocidad(matcher) / MULTIPLO_VELOCIDADES;
        }

        if (UnidadVelocidad.MEGABITS_SEGUNDO == unidadVelocidad) {
            return obtenerNumeroVelocidad(matcher);
        }

        if (UnidadVelocidad.GIGABITS_SEGUNDO == unidadVelocidad) {
            return obtenerNumeroVelocidad(matcher) * MULTIPLO_VELOCIDADES;
        }

        throw new IllegalArgumentException("Velocidad desconocida");
    }

    /**
     * Comprueba que la velocidad cumple el patron
     * 
     * @param velocidadRed
     * @return Devuelve un objeto Matcher si encuentra el patron y
     *         IllegalArgumentException en caso contrario
     */
    private Matcher matchPattern(String velocidadRed) {
        Matcher matcher = PATTERN.matcher(velocidadRed);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("La velocidad de red '" + velocidadRed + "' no es valida");
        }
        return matcher;
    }

    private static float obtenerNumeroVelocidad(Matcher matcher) {
        return Float.parseFloat(matcher.group(1).replace(",", "."));
    }

    private static UnidadVelocidad obtenerUnidadVelocidad(Matcher matcher) {
        String unidadVelocidad = matcher.group(2);
        return UnidadVelocidad.fromString(unidadVelocidad);
    }

}
