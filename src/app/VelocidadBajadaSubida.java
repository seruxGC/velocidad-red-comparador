package app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.velocidad.calculo.VelocidadRedCalculo;
import app.velocidad.comparador.config.UnidadVelocidad;

public class VelocidadBajadaSubida {

    private static final Pattern PATTERN = Pattern.compile(
            ".*?(\\d+[\\,\\.]??\\d*?)\\s??(Kbps|Mbps|Gbps|K|M|G).*?(\\/|\\-).*?(\\d+[\\,\\.]??\\d?)\\s??(Kbps|Mbps|Gbps|K|M|G).*");

    private String litertalVelocidad;
    private float velocidadBajada;
    private UnidadVelocidad unidadBajada;
    private float velocidadSubida;
    private UnidadVelocidad unidadSubida;

    private float velocidadBajadaMegabits;
    private float velocidadSubidaMegabits;

    /**
     * Constructor 1
     * 
     * @param literalVelocidadRed Un String que cumple con el Formato 1
     *                            https://github.com/seruxGC/velocidad-red-comparador/blob/master/README.md#formato-1
     */
    public VelocidadBajadaSubida(String literalVelocidadRed) {

        Matcher matcher = matchPattern(literalVelocidadRed);

        litertalVelocidad = literalVelocidadRed;
        velocidadBajada = obtenerNumeroVelocidadBajada(matcher);
        unidadBajada = obtenerUnidadVelocidadBajada(matcher);
        velocidadSubida = obtenerNumeroVelocidadSubida(matcher);
        unidadSubida = obtenerUnidadVelocidaSubida(matcher);
        velocidadBajadaMegabits = VelocidadRedCalculo.getVelocidadEnMegabits(velocidadBajada, unidadBajada);
        velocidadSubidaMegabits = VelocidadRedCalculo.getVelocidadEnMegabits(velocidadSubida, unidadSubida);
    }

    /**
     * Constructor 2
     * 
     * @param velocidadBajada
     * @param unidadBajada
     * @param velocidadSubida
     * @param unidadSubida
     */
    public VelocidadBajadaSubida(float velocidadBajada, UnidadVelocidad unidadBajada, float velocidadSubida,
            UnidadVelocidad unidadSubida) {

        litertalVelocidad = velocidadBajada + " " + unidadBajada + " - " + velocidadSubida + " " + unidadSubida;
        this.velocidadBajada = velocidadBajada;
        this.unidadBajada = unidadBajada;
        this.velocidadSubida = velocidadSubida;
        this.unidadSubida = unidadSubida;
        velocidadBajadaMegabits = VelocidadRedCalculo.getVelocidadEnMegabits(velocidadBajada, unidadBajada);
        velocidadSubidaMegabits = VelocidadRedCalculo.getVelocidadEnMegabits(velocidadSubida, unidadSubida);
    }

    /**
     * 
     * @param velocidadBajadaSubidaComparada
     * @return True si la velocidad de bajada y subida de la velocidad propia es
     *         mayor que la comparada
     */
    public boolean esMayor(VelocidadBajadaSubida velocidadBajadaSubidaComparada) {
        return velocidadBajadaMegabits > velocidadBajadaSubidaComparada.getVelocidadBajadaMegabits()
                && velocidadSubidaMegabits > velocidadBajadaSubidaComparada.getVelocidadSubidaMegabits();
    }

    public boolean esIgual(VelocidadBajadaSubida velocidadBajadaSubidaComparada) {
        return velocidadBajadaMegabits == velocidadBajadaSubidaComparada.getVelocidadBajadaMegabits()
                && velocidadSubidaMegabits == velocidadBajadaSubidaComparada.getVelocidadSubidaMegabits();
    }

    /**
     * 
     * @param velocidadBajadaSubidaComparada
     * @return rue si la velocidad de bajada y subida de la velocidad propia es
     *         menor que la comparada
     */
    public boolean esMenor(VelocidadBajadaSubida velocidadBajadaSubidaComparada) {
        return velocidadBajadaMegabits < velocidadBajadaSubidaComparada.getVelocidadBajadaMegabits()
                && velocidadSubidaMegabits < velocidadBajadaSubidaComparada.getVelocidadSubidaMegabits();
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

    public String getLitertalVelocidad() {
        return litertalVelocidad;
    }

    public float getVelocidadBajada() {
        return velocidadBajada;
    }

    public UnidadVelocidad getUnidadBajada() {
        return unidadBajada;
    }

    public float getVelocidadSubida() {
        return velocidadSubida;
    }

    public UnidadVelocidad getUnidadSubida() {
        return unidadSubida;
    }

    public float getVelocidadBajadaMegabits() {
        return velocidadBajadaMegabits;
    }

    public float getVelocidadSubidaMegabits() {
        return velocidadSubidaMegabits;
    }
}