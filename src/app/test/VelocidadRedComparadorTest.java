package app.test;

import org.junit.Assert;
import org.junit.Test;

import app.context.VelocidadRedComparador;

public class VelocidadRedComparadorTest {

	/** Test Formato 3 */
	@Test
	/** Velocidad1 > velocidad2 Velocidades en kbps */
	public void formato3Test1() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "2 Kbps";
		String velocidadRed2 = "1 Kbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad1 > velocidad2 Velocidades en Mbps */
	public void formato3Test2() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "2 Mbps";
		String velocidadRed2 = "1 Mbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad > velocidad2 Velocidades en Gbps */
	public void formato3Test3() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "2 Gbps";
		String velocidadRed2 = "1 Gbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad > velocidad2 Velocidades en Kbps y Mbps */
	public void formato3Test4() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "1001 Kbps";
		String velocidadRed2 = "1 Mbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad > velocidad2 Velocidades en Kbps y Gbps */
	public void formato3Test5() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "1000001 Kbps";
		String velocidadRed2 = "1 Gbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad > velocidad2 Velocidades en Mbps y Kbps */
	public void formato3Test6() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "1 Mbps";
		String velocidadRed2 = "999 Kbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad > velocidad2 Velocidades en Mbps y Gbps */
	public void formato3Test7() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "1001 Mbps";
		String velocidadRed2 = "1 Gbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad > velocidad2 decimal con coma */
	public void formato3Test8() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "1,5 Kbps";
		String velocidadRed2 = "1 Kbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad > velocidad2 decimal con punto */
	public void formato3Test9() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "1.5 Kbps";
		String velocidadRed2 = "1 Kbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad > velocidad2 decimal con punto diferentes unidades */
	public void formato3Test10() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "1.1 Mbps";
		String velocidadRed2 = "1000 Kbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad > velocidad2 decimal con coma diferentes unidades */
	public void formato3Test11() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "1,1 Gbps";
		String velocidadRed2 = "1000 Mbps";

		boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	/** Otros */

	@Test(expected = IllegalArgumentException.class)
	/** Velocidad1 usa un formato no implementado */
	public void velocidadNoImplementadaTest1() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "23 PGKñ";
		String velocidadRed2 = "8 Kbps";

		velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
	}

	@Test(expected = IllegalArgumentException.class)
	/** Velocidad2 usa un formato no implementado */
	public void velocidadNoImplementadaTest2() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "8 Kbps";
		String velocidadRed2 = "23 Ksj";

		velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
	}

	@Test(expected = IllegalArgumentException.class)
	/** La velocidad 2 tiene un formato distinto a la velocidad 1 */
	public void velocidadDistintoFormatoTest1() {
		VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
		String velocidadRed1 = "Acceso VPN IP FTTH 200M/200M SIN VOZ";
		String velocidadRed2 = "13 Kbps";

		velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
	}

}
