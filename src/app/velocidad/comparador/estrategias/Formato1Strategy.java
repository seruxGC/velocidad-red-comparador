package app.velocidad.comparador.estrategias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.velocidad.calculo.VelocidadRedCalculo;
import app.velocidad.comparador.config.UnidadVelocidad;
import app.velocidad.comparador.interfaces.ComparacionVelocidadStrategy;

/**
 * Formato 1
 * https://github.com/seruxGC/velocidad-red-comparador/blob/master/README.md#formato-1
 */
public class Formato1Strategy implements ComparacionVelocidadStrategy {

    private static final String REGEX_FORMATO = ".*?(\\d+[\\,\\.]??\\d*?)\\s??(Kbps|Mbps|Gbps|K|M|G).*?(\\/|\\-).*?(\\d+[\\,\\.]??\\d?)\\s??(Kbps|Mbps|Gbps|K|M|G).*";

    public static final Pattern PATTERN = Pattern.compile(REGEX_FORMATO);

    private static final short MULTIPLO_VELOCIDADES = 1000;

    @Override
    public boolean primeraVelocidadEsMayor(String velocidadRed1, String velocidadRed2) {

        float velocidadBajadaMegabits1 = velocidadBajadaEnMegabits(velocidadRed1);
        float velocidadSubidaMegabits1 = velocidadSubidaEnMegabits(velocidadRed1);

        float velocidadBajadaMegabits2 = velocidadBajadaEnMegabits(velocidadRed2);
        float velocidadSubidaMegabits2 = velocidadSubidaEnMegabits(velocidadRed2);

        return velocidadBajadaMegabits1 > velocidadBajadaMegabits2
                && velocidadSubidaMegabits1 > velocidadSubidaMegabits2;
    }

    @Override
    public boolean velocidadesSonIguales(String velocidadRed1, String velocidadRed2) {
        float velocidadBajadaMegabits1 = velocidadBajadaEnMegabits(velocidadRed1);
        float velocidadSubidaMegabits1 = velocidadSubidaEnMegabits(velocidadRed1);

        float velocidadBajadaMegabits2 = velocidadBajadaEnMegabits(velocidadRed2);
        float velocidadSubidaMegabits2 = velocidadSubidaEnMegabits(velocidadRed2);

        return velocidadBajadaMegabits1 == velocidadBajadaMegabits2
                && velocidadSubidaMegabits1 == velocidadSubidaMegabits2;
    }

    private static float velocidadBajadaEnMegabits(String velocidadRed) {

        Matcher matcher = matchPattern(velocidadRed);

        float numeroVelocidad = obtenerNumeroVelocidadBajada(matcher);
        UnidadVelocidad unidadVelocidad = obtenerUnidadVelocidadBajada(matcher);

        return VelocidadRedCalculo.getVelocidadEnMegabits(numeroVelocidad, unidadVelocidad);
    }

    private static float velocidadSubidaEnMegabits(String velocidadRed) {

        Matcher matcher = matchPattern(velocidadRed);

        float numeroVelocidad = obtenerNumeroVelocidadSubida(matcher);
        UnidadVelocidad unidadVelocidad = obtenerUnidadVelocidaSubida(matcher);

        return VelocidadRedCalculo.getVelocidadEnMegabits(numeroVelocidad, unidadVelocidad);
    }

    /**
     * Comprueba que la velocidad cumple el patron
     * 
     * @param velocidadRed
     * @return Devuelve un objeto Matcher si encuentra el patron y
     *         IllegalArgumentException en caso contrario
     */
    private static Matcher matchPattern(String velocidadRed) {
        Matcher matcher = PATTERN.matcher(velocidadRed);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Error al obtener velocidad de bajada");
        }
        return matcher;
    }

    /**
     * Obtiene la velocidad de bajada del grupo de regex correspondiente y sustituye
     * el caracter ',' por '.' para que en caso de que el decimal tenga una coma no
     * de error al pasarlo a float
     */
    private static float obtenerNumeroVelocidadBajada(Matcher matcher) {
        return Float.parseFloat(matcher.group(1).replace(",", "."));
    }

    private static UnidadVelocidad obtenerUnidadVelocidadBajada(Matcher matcher) {
        String unidadBajada = matcher.group(2);
        return UnidadVelocidad.fromString(unidadBajada);
    }

    /**
     * Obtiene la velocidad de bajada del grupo de regex correspondiente y sustituye
     * el caracter ',' por '.' para que en caso de que el decimal tenga una coma no
     * de error al pasarlo a float
     */
    private static float obtenerNumeroVelocidadSubida(Matcher matcher) {
        return Float.parseFloat(matcher.group(4).replace(",", "."));
    }

    private static UnidadVelocidad obtenerUnidadVelocidaSubida(Matcher matcher) {
        String unidadSubida = matcher.group(5);
        return UnidadVelocidad.fromString(unidadSubida);
    }

}