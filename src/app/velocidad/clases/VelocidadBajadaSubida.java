package app.velocidad.clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.velocidad.constantes.UnidadVelocidad;
import app.velocidad.util.VelocidadRedCalculo;

public class VelocidadBajadaSubida {

    private static final Pattern PATTERN = Pattern.compile(
            ".*?(\\d+[\\,\\.]??\\d*?)\\s??(Kbps|Mbps|Gbps|K|M|G).*?(\\/|\\-).*?(\\d+[\\,\\.]??\\d?)\\s??(Kbps|Mbps|Gbps|K|M|G).*");

    private String literalVelocidad;
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

        literalVelocidad = literalVelocidadRed;
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

        literalVelocidad = velocidadBajada + " " + unidadBajada.getValor() + " - " + velocidadSubida + " "
                + unidadSubida.getValor();
        this.velocidadBajada = velocidadBajada;
        this.unidadBajada = unidadBajada;
        this.velocidadSubida = velocidadSubida;
        this.unidadSubida = unidadSubida;
        velocidadBajadaMegabits = VelocidadRedCalculo.getVelocidadEnMegabits(velocidadBajada, unidadBajada);
        velocidadSubidaMegabits = VelocidadRedCalculo.getVelocidadEnMegabits(velocidadSubida, unidadSubida);
    }

    public boolean mayorVelocidadBajadaQue(VelocidadBajadaSubida velocidadComparada) {
        return velocidadBajadaMegabits > velocidadComparada.getVelocidadBajadaMegabits();
    }

    public boolean igualVelocidadBajadaQue(VelocidadBajadaSubida velocidadComparada) {
        return velocidadBajadaMegabits == velocidadComparada.getVelocidadBajadaMegabits();
    }
    
    public boolean menorVelocidadBajadaQue(VelocidadBajadaSubida velocidadComparada) {
        return velocidadBajadaMegabits < velocidadComparada.getVelocidadBajadaMegabits();
    }
    
    public boolean mayorVelocidadSubidaQue(VelocidadBajadaSubida velocidadComparada) {
        return velocidadSubidaMegabits > velocidadComparada.getVelocidadSubidaMegabits();
    }

    public boolean igualVelocidadSubidaQue(VelocidadBajadaSubida velocidadComparada) {
        return velocidadSubidaMegabits == velocidadComparada.getVelocidadSubidaMegabits();
    }

    public boolean menorVelocidadSubidaQue(VelocidadBajadaSubida velocidadComparada) {
        return velocidadSubidaMegabits < velocidadComparada.getVelocidadSubida();
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

    public String getLiteralVelocidad() {
        return literalVelocidad;
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