package app.velocidad.comparador.estrategias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.velocidad.calculo.VelocidadRedCalculo;
import app.velocidad.comparador.config.UnidadVelocidad;
import app.velocidad.comparador.interfaces.ComparacionVelocidadStrategy;

/**
 * Formato 2
 * https://github.com/seruxGC/velocidad-red-comparador/blob/master/README.md#formato-2
 */
public class Formato2Strategy implements ComparacionVelocidadStrategy {

    public static final Pattern PATTERN = Pattern
            .compile("^[\\[,\\{]?(\\d+[\\,\\.]?\\d*?)\\s?\\-?\\s?(Kbps|Mbps|Gbps)[\\},\\]]?$");

    @Override
    public boolean primeraVelocidadEsMayor(String velocidadRed1, String velocidadRed2) {

        Matcher matcherVel1 = matchPattern(velocidadRed1);
        float velocidad1 = obtenerNumeroVelocidad(matcherVel1);
        UnidadVelocidad unidadVelocidad1 = obtenerUnidadVelocidad(matcherVel1);

        Matcher matcherVel2 = matchPattern(velocidadRed2);
        float velocidad2 = obtenerNumeroVelocidad(matcherVel2);
        UnidadVelocidad unidadVelocidad2 = obtenerUnidadVelocidad(matcherVel2);

        float velocidadMegabits1 = VelocidadRedCalculo.getVelocidadEnMegabits(velocidad1, unidadVelocidad1);
        float velocidadMegabits2 = VelocidadRedCalculo.getVelocidadEnMegabits(velocidad2, unidadVelocidad2);

        return velocidadMegabits1 > velocidadMegabits2;
    }

    @Override
    public boolean velocidadesSonIguales(String velocidadRed1, String velocidadRed2) {

        Matcher matcherVel1 = matchPattern(velocidadRed1);
        float velocidad1 = obtenerNumeroVelocidad(matcherVel1);
        UnidadVelocidad unidadVelocidad1 = obtenerUnidadVelocidad(matcherVel1);

        Matcher matcherVel2 = matchPattern(velocidadRed2);
        float velocidad2 = obtenerNumeroVelocidad(matcherVel2);
        UnidadVelocidad unidadVelocidad2 = obtenerUnidadVelocidad(matcherVel2);

        float velocidadMegabits1 = VelocidadRedCalculo.getVelocidadEnMegabits(velocidad1, unidadVelocidad1);
        float velocidadMegabits2 = VelocidadRedCalculo.getVelocidadEnMegabits(velocidad2, unidadVelocidad2);

        return velocidadMegabits1 == velocidadMegabits2;
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
