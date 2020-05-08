package app.test;

import org.junit.Assert;
import org.junit.Test;

import app.context.VelocidadRedComparador;

public class VelocidadRedComparadorTest {
	
	@Test
	public void formato1Test1() {
		
		String velocidadRed1 = "Acceso VPN IP 2M/2M SIN VOZ";
		String velocidadRed2 = "Acceso VPN IP 1M/1M";
		
		boolean resultado = VelocidadRedComparador.compara(velocidadRed1, velocidadRed2);
		Assert.assertTrue(resultado);
	}

}
