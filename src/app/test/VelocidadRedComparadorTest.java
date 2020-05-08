package app.test;

import org.junit.Assert;
import org.junit.Test;

import app.context.VelocidadRedComparador;

public class VelocidadRedComparadorTest {

	/** Test Fotmato 1 */

	@Test
	/** Velocidad1 > velocidad2 */
	public void formato1Test1() {
		String velocidadRed1 = "Acceso VPN IP 2M/2M SIN VOZ";
		String velocidadRed2 = "Acceso VPN IP 1M/1M";
		
		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad1 > velocidad2*/
	public void formato1Test2() {
		String velocidadRed1 = "Acceso VPN IP 3M/3M SIN VOZ";
		String velocidadRed2 = "Acceso VPN IP 1M/1M";

		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad1 < velocidad2   La velocidad de subida es menor*/
	public void formato1Test3() {
		String velocidadRed1 = "Acceso VPN IP FTTH0 100M/50M SIN VOZ";
		String velocidadRed2 = "Acceso VPN IP 50M/100M";

		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertFalse(resultado);
	}

	@Test
	/** Velocidad1 < velocidad2 La velocidad de bajada es menor */
	public void formato1Test4() {
		String velocidadRed1 = "Acceso VPN IP FTTH 100M/500M SIN VOZ";
		String velocidadRed2 = "Acceso VPN IP 200M/200M";

		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertFalse(resultado);
	}

	@Test
	/** Velocidad1 = velocidad2  */
	public void formato1Test5() {
		String velocidadRed1 = "Acceso VPN IP FTTH 200M/200M SIN VOZ";
		String velocidadRed2 = "Acceso VPN IP 200M/200M";

		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertFalse(resultado);
	}

	@Test(expected = IllegalArgumentException.class)
	/** La velocidad 2 tiene un formato distinto a la velocidad 1 */
	public void formato1Test6() {
		String velocidadRed1 = "Acceso VPN IP FTTH 200M/200M SIN VOZ";
		String velocidadRed2 = "13 Kbps";

		VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
	}




	/** Test Fotmato 2 */


	@Test
	/** Velocidad1 > velocidad2  Velocidades en megas */
	public void formato2Test1() {
		String velocidadRed1 = "100M-100M";
		String velocidadRed2 = "50M-50M";

		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad1 > velocidad2  gigas/megas  */
	public void formato2Test2() {
		String velocidadRed1 = "1G-1G";
		String velocidadRed2 = "100M-100M";

		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad1 > velocidad2 Velocidades en gigas */
	public void formato2Test3() {
		String velocidadRed1 = "10G-10G";
		String velocidadRed2 = "1G-1G";

		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

	@Test
	/** Velocidad1 < velocidad2 Velocidades en gigas */
	public void formato2Test4() {
		String velocidadRed1 = "2G-1G";
		String velocidadRed2 = "1G-2G";

		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertFalse(resultado);
	}

	@Test
	/** Velocidad1 < velocidad2 Velocidades en gigas */
	public void formato2Test5() {
		String velocidadRed1 = "10G-10G";
		String velocidadRed2 = "15G-2G";

		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertFalse(resultado);
	}




	/** Otros */

	@Test(expected = IllegalArgumentException.class)
	/** Velocidad1 usa un formato no implementado  */
	public void otroTest1() {
		String velocidadRed1 = "23 PGKñ";
		String velocidadRed2 = "8 Kbps";

		VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
	}

	@Test(expected = IllegalArgumentException.class)
	/** Velocidad2 usa un formato no implementado */
	public void otroTest2() {
		String velocidadRed1 = "8 Kbps";
		String velocidadRed2 = "23 Ksj";

		VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
	}
	



}
