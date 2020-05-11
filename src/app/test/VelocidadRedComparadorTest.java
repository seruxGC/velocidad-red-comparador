package app.test;

import org.junit.Test;

import app.velocidad.comparador.contexto.VelocidadRedComparador;

public class VelocidadRedComparadorTest {

	

	/** Otros */

	@Test(expected = IllegalArgumentException.class)
	/** Velocidad1 usa un formato no implementado */
	public void velocidadNoImplementadaTest1() {
		
		String velocidadRed1 = "23 PGKñ";
		String velocidadRed2 = "8 Kbps";

		VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
	}

	@Test(expected = IllegalArgumentException.class)
	/** Velocidad2 usa un formato no implementado */
	public void velocidadNoImplementadaTest2() {
		
		String velocidadRed1 = "8 Kbps";
		String velocidadRed2 = "23 Ksj";

		VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
	}

	@Test(expected = IllegalArgumentException.class)
	/** La velocidad 2 tiene un formato distinto a la velocidad 1 */
	public void velocidadDistintoFormatoTest1() {
		
		String velocidadRed1 = "Acceso VPN IP FTTH 200M/200M SIN VOZ";
		String velocidadRed2 = "13 Kbps";

		VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
	}

}
