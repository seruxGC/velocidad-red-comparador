package app.estrategias;

import app.interfaces.ComparacionVelocidadStrategy;

/**
 * Formato 3
 * "2 Mbps" soporta las unidades Kbps, Mbps, Gbps y los numeros en decimales.
 */
public class Formato3Strategy implements ComparacionVelocidadStrategy {

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
       
    	String unidadVelocidad = obtenerUnidadVelocidad(velocidadRed);
        
        switch (unidadVelocidad) {
		case KILOBITS_SEGUNDO:
			return obtenerNumeroVelocidad(velocidadRed) / MULTIPLO_VELOCIDADES;
		case MEGABITS_SEGUNDO:
			return obtenerNumeroVelocidad(velocidadRed);
		case GIBABITS_SEGUNDO:
			return obtenerNumeroVelocidad(velocidadRed) * MULTIPLO_VELOCIDADES;
		default:
			throw new IllegalArgumentException("Velocidad desconocida");
		}
        
    }

    private static float obtenerNumeroVelocidad(String velocidadRed) {

        String[] partesVelocidadRed = velocidadRed.split(" ");
        String velocidadStr = partesVelocidadRed[0];

        velocidadStr = velocidadStr.replace(",", ".").trim();

        try {
            return Float.parseFloat(velocidadStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "La velocidad de red '" + velocidadRed + "' no es valida");
        }
    }

    private static String obtenerUnidadVelocidad(String velocidadRed) {
        String[] partesVelocidadRed = velocidadRed.split(" ");
        return partesVelocidadRed[1].replace(".", " ").trim();
    }

}
