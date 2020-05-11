package app.velocidad.comparador.estrategias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.velocidad.comparador.interfaces.ComparacionVelocidadStrategy;



/**
 * Formato 1
 * https://github.com/seruxGC/velocidad-red-comparador/blob/master/README.md#formato-1
 */
public class Formato1Strategy implements ComparacionVelocidadStrategy {

    private static final String REGEX_FORMATO = ".*?(\\d+[\\,\\.]??\\d*?)\\s??(Kbps|Mbps|Gbps|K|M|G).*?(\\/|\\-).*?(\\d+[\\,\\.]??\\d?).??(Kbps|Mbps|Gbps|K|M|G).*";

    public static final Pattern PATTERN = Pattern.compile(REGEX_FORMATO);

    private static final String KILOBITS_SEGUNDO = "Kbps";
    private static final String MEGABITS_SEGUNDO = "Mbps";
    private static final String GIGABITS_SEGUNDO = "Gbps";
    private static final String KILOBITS = "K";
    private static final String MEGABITS = "M";
    private static final String GIGABITS = "G";
    private static final short MULTIPLO_VELOCIDADES = 1000;
    

    @Override
    public boolean compara(String velocidadRed1, String velocidadRed2) {

        float velocidadBajadaMegabits1 = velocidadBajadaEnMegabits(velocidadRed1);
        float velocidadSubidaMegabits1 = velocidadSubidaEnMegabits(velocidadRed1);

        float velocidadBajadaMegabits2 = velocidadBajadaEnMegabits(velocidadRed2);
        float velocidadSubidaMegabits2 = velocidadSubidaEnMegabits(velocidadRed2);

        return velocidadBajadaMegabits1 > velocidadBajadaMegabits2
                && velocidadSubidaMegabits1 > velocidadSubidaMegabits2;
    }

    private static float velocidadBajadaEnMegabits(String velocidadRed) {

        Matcher matcher = PATTERN.matcher(velocidadRed);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Error al obtener velocidad de bajada");
        }

        float numeroVelocidad = obtenerNumeroVelocidadBajada(matcher);
        String unidadVelocidad = obtenerUnidadVelocidadBajada(matcher);

        return calculaVelocidadMegabits(numeroVelocidad, unidadVelocidad);
    }

    private static float velocidadSubidaEnMegabits(String velocidadRed) {

        Matcher matcher = PATTERN.matcher(velocidadRed);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Error al obtener velocidad de bajada");
        }

        float numeroVelocidad = obtenerNumeroVelocidadSubida(matcher);
        String unidadVelocidad = obtenerUnidadVelocidaSubida(matcher);

        return calculaVelocidadMegabits(numeroVelocidad, unidadVelocidad);
    }

    /**
     * Obtiene la velocidad de bajada del grupo de regex correspondiente y sustituye
     * el caracter ',' por '.' para que en caso de que el decimal tenga una coma no
     * de error al pasarlo a float
     */
    private static float obtenerNumeroVelocidadBajada(Matcher matcher) {
        return Float.parseFloat(matcher.group(1).replace(",", "."));
    }

    private static String obtenerUnidadVelocidadBajada(Matcher matcher) {
        return matcher.group(2);
    }

    /**
     * Obtiene la velocidad de bajada del grupo de regex correspondiente y sustituye
     * el caracter ',' por '.' para que en caso de que el decimal tenga una coma no
     * de error al pasarlo a float
     */
    private static float obtenerNumeroVelocidadSubida(Matcher matcher) {
        return Float.parseFloat(matcher.group(4).replace(",", "."));
    }

    private static String obtenerUnidadVelocidaSubida(Matcher matcher) {
        return matcher.group(5);
    }

    private static float calculaVelocidadMegabits(float numeroVelocidad, String unidadVelocidad) {
        
        if(unidadVelocidad.equals(KILOBITS) || unidadVelocidad.equals(KILOBITS_SEGUNDO)) {
            return numeroVelocidad / MULTIPLO_VELOCIDADES;
        }

        if (unidadVelocidad.equals(MEGABITS) || unidadVelocidad.equals(MEGABITS_SEGUNDO)) {
            return numeroVelocidad;
        }

        if (unidadVelocidad.equals(GIGABITS) || unidadVelocidad.equals(GIGABITS_SEGUNDO)) {
            return numeroVelocidad * MULTIPLO_VELOCIDADES;
        }

        throw new IllegalArgumentException("Velocidad desconocida");

    }

}