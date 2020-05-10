package app.estrategias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.interfaces.ComparacionVelocidadStrategy;

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
    public boolean compara(String velocidadRed1, String velocidadRed2) {

        float velocidadMegabits1 = velocidadEnMegabits(velocidadRed1);
        float velocidadMegabits2 = velocidadEnMegabits(velocidadRed2);

        return velocidadMegabits1 > velocidadMegabits2;
    }

    private float velocidadEnMegabits(String velocidadRed) {

        Matcher matcher = PATTERN.matcher(velocidadRed);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("La velocidad de red '" + velocidadRed + "' no es valida");
        }

        String unidadVelocidad = obtenerUnidadVelocidad(matcher);

        switch (unidadVelocidad) {
            case KILOBITS_SEGUNDO:
                return obtenerNumeroVelocidad(matcher) / MULTIPLO_VELOCIDADES;
            case MEGABITS_SEGUNDO:
                return obtenerNumeroVelocidad(matcher);
            case GIBABITS_SEGUNDO:
                return obtenerNumeroVelocidad(matcher) * MULTIPLO_VELOCIDADES;
            default:
                throw new IllegalArgumentException("Velocidad desconocida");
        }

    }

    private static float obtenerNumeroVelocidad(Matcher matcher) {
        return Float.parseFloat(matcher.group(1).replace(",", "."));
    }

    private static String obtenerUnidadVelocidad(Matcher matcher) {
      return matcher.group(2);
    }

}
