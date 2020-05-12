package app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.velocidad.calculo.VelocidadRedCalculo;
import app.velocidad.comparador.config.UnidadVelocidad;

public class VelocidadRed {

    private static final Pattern PATTERN = Pattern
            .compile("^[\\[,\\{]?(\\d+[\\,\\.]?\\d*?)\\s?\\-?\\s?(Kbps|Mbps|Gbps)[\\},\\]]?$");

    private String litertalVelocidad;
    private float velocidad;
    private UnidadVelocidad unidad;

    private float velocidadMegabits;

    /**
     * Constructor 1
     * @param literalVelocidadRed Un string que cumple el Formato 2
     *                            https://github.com/seruxGC/velocidad-red-comparador/blob/master/README.md#formato-2
     */
    public VelocidadRed(String literalVelocidadRed) {
        
        Matcher matcher = matchPattern(literalVelocidadRed);

        litertalVelocidad = literalVelocidadRed;
        velocidad = obtenerNumeroVelocidad(matcher);
        unidad = obtenerUnidadVelocidad(matcher);
        velocidadMegabits = VelocidadRedCalculo.getVelocidadEnMegabits(velocidad, unidad);
    }

    /**
     * Constructor 2
     * @param velocidad
     * @param unidad
     */
    public VelocidadRed(float velocidad, UnidadVelocidad unidad) {
        this.litertalVelocidad = velocidad + " " + unidad.getValor();
        this.velocidad = velocidad;
        this.unidad = unidad;
        velocidadMegabits = VelocidadRedCalculo.getVelocidadEnMegabits(velocidad, unidad);
    }

    public boolean esMayor(VelocidadRed velocidadRed) {
        return velocidadMegabits > velocidadRed.getVelocidadMegabits();
    }

    public boolean esIgual(VelocidadRed velocidadRed) {
        return velocidadMegabits == velocidadRed.getVelocidadMegabits();
    }

    public boolean esMenor(VelocidadRed velocidadRed) {
        return velocidadMegabits < velocidadRed.getVelocidadMegabits();
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
            throw new IllegalArgumentException("El formato de la velocidad no es correcto");
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

    public String getLiteralVelocidad() {
        return litertalVelocidad;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public UnidadVelocidad getUnidad() {
        return unidad;
    }

    public float getVelocidadMegabits() {
        return velocidadMegabits;
    }

}