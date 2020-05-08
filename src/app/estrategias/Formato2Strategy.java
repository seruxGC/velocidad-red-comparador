package app.estrategias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.interfaces.ComparacionVelocidadStrategy;

/**
 * Formato 2 
 * "100M-500M" Soporta las unidades M, G (megabits,gigabis)
 */
public class Formato2Strategy implements ComparacionVelocidadStrategy {

    private static final char MEGABITS = 'M';
    private static final char GIGABITS = 'G';
    private static final short MULTIPLO_VELOCIDADES = 1000;

    private static final Pattern patronVelocidad = Pattern.compile("(\\d+)(.)-(\\d+)(.)");

    @Override
    public  boolean compara(String velocidadRed1, String velocidadRed2) {

        float velocidadBajadaMegabits1 = velocidadBajadaEnMegabits(velocidadRed1);
        float velocidadSubidaMegabits1 = velocidadSubidaEnMegabits(velocidadRed1);

        float velocidadBajadaMegabits2 = velocidadBajadaEnMegabits(velocidadRed2);
        float velocidadSubidaMegabits2 = velocidadSubidaEnMegabits(velocidadRed2);

        return velocidadBajadaMegabits1 > velocidadBajadaMegabits2 && 
        velocidadSubidaMegabits1 > velocidadSubidaMegabits2 ;
    }

    private static float velocidadBajadaEnMegabits(String velocidadRed) {

        Matcher matcher = patronVelocidad.matcher(velocidadRed);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Error al obtener velocidad de bajada");
        }

        float numeroVelocidad = obtenerNumeroVelocidadBajada(matcher);
        char unidadVelocidad = obtenerUnidadVelocidadBajada(matcher);
      
        return calculaVelocidadMegabits(numeroVelocidad, unidadVelocidad);
    }

    private static float velocidadSubidaEnMegabits(String velocidadRed) {

        Matcher matcher = patronVelocidad.matcher(velocidadRed);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Error al obtener velocidad de bajada");
        }

        float numeroVelocidad = obtenerNumeroVelocidadSubida(matcher);
        char unidadVelocidad = obtenerUnidadVelocidaSubida(matcher);

        return calculaVelocidadMegabits(numeroVelocidad, unidadVelocidad);
    }


    private static float obtenerNumeroVelocidadBajada(Matcher matcher) {
        return Float.parseFloat(matcher.group(1));
    }

    private static char obtenerUnidadVelocidadBajada(Matcher matcher) {
        return matcher.group(2).charAt(0);
    }

    private static float obtenerNumeroVelocidadSubida(Matcher matcher) {
        return Float.parseFloat(matcher.group(3));
    }

    private static char obtenerUnidadVelocidaSubida(Matcher matcher) {
        return matcher.group(4).charAt(0);
    }

    private static float calculaVelocidadMegabits(float numeroVelocidad, char unidadVelocidad) {
        switch (unidadVelocidad) {
            case MEGABITS:
                return numeroVelocidad;
            case GIGABITS:
                return numeroVelocidad * MULTIPLO_VELOCIDADES;
            default:
                throw new IllegalArgumentException("Velocidad desconocida");
        }
    }

}