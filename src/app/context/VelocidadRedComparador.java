package app.context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.estrategias.Formato1Strategy;
import app.estrategias.Formato2Strategy;
import app.estrategias.Formato3Strategy;
import app.interfaces.ComparacionVelocidadStrategy;

public class VelocidadRedComparador {

    private VelocidadRedComparador() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean compara(String velocidadRed1, String velocidadRed2) {

        ComparacionVelocidadStrategy estrategiaVelocidad1 = escogeEstrategia(velocidadRed1);
        ComparacionVelocidadStrategy estrategiaVelocidad2 = escogeEstrategia(velocidadRed2);

        if (!sonVelocidadesMismoFormato(estrategiaVelocidad1, estrategiaVelocidad2)) {
            throw new IllegalArgumentException("las velocidades comparadas no tienen el mismo formato");
        }

        return estrategiaVelocidad1.compara(velocidadRed1, velocidadRed2);
    }

    private static ComparacionVelocidadStrategy escogeEstrategia(String unidadVelocidad) {

        if (tieneFormato1(unidadVelocidad)) {
            return new Formato1Strategy();
        }

        if (tieneFormato2(unidadVelocidad)) {
            return new Formato2Strategy();
        }

        if (tieneFormato3(unidadVelocidad)) {
            return new Formato3Strategy();
        }

        throw new IllegalArgumentException(
                "El formato de Velocidad de red '" + unidadVelocidad + "'' no esta implementado");

    }

    private static boolean sonVelocidadesMismoFormato(ComparacionVelocidadStrategy estrategiaVelocidad1,
            ComparacionVelocidadStrategy estrategiaVelocidad2) {
        return estrategiaVelocidad1.getClass().getCanonicalName()
                .equals(estrategiaVelocidad2.getClass().getCanonicalName());
    }

    /**
     * Formato 1
     * 
     * @param velocidadRed Formato "Acceso VPN IP 1000M/1000M"
     * @return
     */
    private static boolean tieneFormato1(String velocidadRed) {
        String patron = "Acceso VPN IP .*";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(velocidadRed);

        return matcher.matches();
    }

    /**
     * Formato 2
     * 
     * @param velocidadRed Formato "100M-500M" Soporta las unidades M, G
     *                     (megabits,gigabis)
     * @return
     */
    private static boolean tieneFormato2(String velocidadRed) {
        String patron = "\\b\\d+.-\\d+.\\b";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(velocidadRed);

        return matcher.matches();
    }

    /**
     * Formato 3
     * 
     * @param velocidadRed Formato "2 Mbps" soporta las unidades Kbps, Mbps, Gbps y
     *                     los numeros en decimales.
     * @return
     */
    private static boolean tieneFormato3(String velocidadRed) {
        String patron = "\\b\\d+ Kbps\\b|\\b\\d+ Mbps\\b|\\b\\d+ Gbps\\b";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(velocidadRed);

        return matcher.matches();
    }

}