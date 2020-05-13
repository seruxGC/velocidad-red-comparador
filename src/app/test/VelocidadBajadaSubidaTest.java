package app.test;

import org.junit.Assert;
import org.junit.Test;

import app.velocidad.clases.VelocidadBajadaSubida;
import app.velocidad.constantes.UnidadVelocidad;

public class VelocidadBajadaSubidaTest {

    

    @Test
    /** Velocidad1 > velocidad2 Velocidades en megas */
    public void formato1ExactoTest1() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("100M-100M");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("50M-50M");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 gigas/megas */
    public void formato1ExactoTest2() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("1G-1G");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("100M-100M");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en gigas */
    public void formato1ExactoTest3() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("10G-10G");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("1G-1G");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 Velocidades en gigas */
    public void formato1ExactoTest4() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("2G-1G");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("1G-2G");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 Velocidades en gigas */
    public void formato1ExactoTest5() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("10G-10G");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("15G-2G");

        boolean resultado = velocidad1.menorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 Velocidades en megas */
    public void formato1ExactoTest6() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("50M/50M");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("100M/100M");
        
        boolean resultado = velocidad1.menorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 gigas/megas */
    public void formato1ExactoTest7() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("1G/1G");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("100M/100M");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en gigas */
    public void formato1ExactoTest8() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("10G/10G");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("1G/1G");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 Velocidades en gigas */
    public void formato1ExactoTest9() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("2G/1G");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("1G/2G");

        boolean resultado = velocidad1.menorVelocidadBajadaQue(velocidad2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en gigas */
    public void formato1CorchetesTest() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("{10G/10G}");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("{1G/1G}");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en gigas */
    public void formato1LlavesTest() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("[10G/10G]");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("[1G/1G]");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits */
    public void formato1ExactoTest10() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("15K/15K");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("10K/10K");

        boolean resultado = velocidad1.igualVelocidadSubidaQue(velocidad2);
        Assert.assertFalse(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits */
    public void formato1ExactoTest11() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("15 K / 15 K");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("10 K / 10 K");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits megas */
    public void formato1ExactoTest12() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("1 M - 1 M");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("999 K - 999 K");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits gigas */
    public void formato1ExactoTest13() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("1000001 K - 1000001 K");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("1 G - 1 G");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);

    }

    /** Test Fotmato 1 literal velocidad contenido en otro mayor */

    @Test
    /** Velocidad1 > velocidad2 */
    public void formato1Test1() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP 2M/2M SIN VOZ");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Acceso VPN IP 1M/1M");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 */
    public void formato1Test2() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP 3M/3M SIN VOZ");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Acceso VPN IP 1M/1M");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 La velocidad de subida es menor */
    public void formato1Test3() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH0 100M/50M SIN VOZ");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Acceso VPN IP 50M/100M");

        boolean resultado = velocidad1.menorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 La velocidad de bajada es menor */
    public void formato1Test4() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH 100M/500M SIN VOZ");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Acceso VPN IP 200M/200M");

        boolean resultado = velocidad1.menorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 = velocidad2 */
    public void formato1Test5() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH 200M/200M SIN VOZ");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Acceso VPN IP 200M/200M");

        boolean resultado = velocidad1.igualVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /**
     * Velocidad1 > velocidad2 literal tiene otros numeros aparte de los de la
     * velocidad
     */
    public void formato1LiteralConMasNumerosTest() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH 200 250M/250M 200 SIN VOZ");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Acceso VPN IP 20 200M/200M 0");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /**
     * Velocidad1 > velocidad2 literales distintos
     */
    public void formato1LiteralesDistintosTest() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH 200 250M/250M 200 SIN VOZ");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("200M/200M");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /**
     * Velocidad1 < Velocidad2 literales distintos
     */
    public void formato1LiteralesDistintosTest2() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP 100M/1000M");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Adsl 200M-200M Fibra 2.0");

        boolean resultado = velocidad1.menorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    // Test Unidades segundo

    @Test
    /**
     * Velocidad1 > velocidad2
     */
    public void formato1UnidadesSegundoTest1() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("2 Mbps/2 Mbps");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("1 Mbps/1 Mbps");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /**
     * Velocidad1 > velocidad2
     */
    public void formato1UnidadesSegundoTest2() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("1 Gbps-1 Gbps");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("999 Mbps-999 Mbps");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1UnidadesSegundoTest3() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("1 Gbps - 1 Gbps");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("999 Mbps - 999 Mbps");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1UnidadesSegundoTest4() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("[1 Gbps / 1 Gbps]");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("[999 Mbps / 999 Mbps]");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 < velocidad2 */
    public void formato1UnidadesSegundoTest5() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Fibra oro Telefonica {1999 Mbps / 1999 Mbps}");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Fibra oro Telefonica {2 Gbps / 2 Gbps}");

        boolean resultado = velocidad1.menorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits */
    public void formato1UnidadesSegundoTes6() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("15Kbps/15Kbps");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("10Kbps/10Kbps");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits */
    public void formato1UnidadesSegundoTest7() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("15 Kbps / 15 Kbps");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("10 Kbps / 10 Kbps");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits megas */
    public void formato1UnidadesSegundoTest8() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("1 M - 1 M");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("999 Kbps - 999 Kbps");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits gigas */
    public void formato1UnidadesSegundoTest9() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("1000001 Kbps - 1000001 Kbps");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("1 G - 1 G");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);

    }

    // Test velocidades con decimales

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1ConDecimalTest1() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("[1,5 Gbps / 1,5 Gbps]");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("1.2 Gbps - 1.2 Gbps");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1ConDecimalTest2() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("{1,5 Gbps} - {1.5 Gbps}");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("{1499 Mbps} - {1499 Mbps}");

        boolean resultado = velocidad1.mayorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1ConDecimalTest3() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("{1,55 Gbps} - {1.55 Gbps}");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("{1499 Mbps} - {1499 Mbps}");

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 = velocidad2 */
    public void formato1VelocidadesIgualesTest1() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("{1,55 Gbps} - {1.55 Gbps}");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("{1.55 Gbps} - {1.55 Gbps}");

        boolean resultado = velocidad1.igualVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 = velocidad2 */
    public void formato1VelocidadesIgualesTest2() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("[11,5 Gbps / 11,5 Gbps]");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("[11,5 G / 11,5 G]");

        boolean resultado = velocidad1.igualVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 = velocidad2 */
    public void formato1VelocidadesIgualesTest3() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH 100M/500M SIN VOZ");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("VPN IP ADSL 100Mbps/500Mbps SIN VOZ");

        boolean resultado = velocidad1.igualVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 != velocidad2 */
    public void formato1VelocidadesIgualesTest4() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("1 Kbps - 1 Kbps");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("1 Kbps - 2 Kbps");

        boolean resultado = velocidad1.igualVelocidadSubidaQue(velocidad2);
        Assert.assertFalse(resultado);
    }

    @Test
    public void formato1Constructor2Test1() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida(1,UnidadVelocidad.KILOBITS_SEGUNDO,1,UnidadVelocidad.KILOBITS_SEGUNDO);

        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida(1, UnidadVelocidad.KILOBITS_SEGUNDO, 2,
                UnidadVelocidad.KILOBITS_SEGUNDO);

        boolean resultado = velocidad1.igualVelocidadSubidaQue(velocidad2);
        Assert.assertFalse(resultado);
    }

    @Test
    public void formato1Constructor2Test2() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida(10, UnidadVelocidad.MEGABITS_SEGUNDO, 10,
                UnidadVelocidad.MEGABITS_SEGUNDO);

        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida(10, UnidadVelocidad.MEGABITS_SEGUNDO, 20,
                UnidadVelocidad.MEGABITS_SEGUNDO);

        boolean resultado = velocidad1.mayorVelocidadBajadaQue(velocidad2);
        Assert.assertFalse(resultado);
    }

    @Test
    public void formato1Constructor2Test3() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida(10, UnidadVelocidad.MEGABITS_CARACTER, 10,
                UnidadVelocidad.MEGABITS_CARACTER);

        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida(10, UnidadVelocidad.MEGABITS_SEGUNDO, 10,
                UnidadVelocidad.MEGABITS_SEGUNDO);

        boolean resultado = velocidad1.igualVelocidadBajadaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test
    public void formato1Constructor2Test4() {

        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida(10, UnidadVelocidad.MEGABITS_CARACTER, 10,
                UnidadVelocidad.MEGABITS_CARACTER);

        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida(10, UnidadVelocidad.GIGABITS_SEGUNDO, 20,
                UnidadVelocidad.MEGABITS_SEGUNDO);

        boolean resultado = velocidad1.menorVelocidadSubidaQue(velocidad2);
        Assert.assertTrue(resultado);
    }

    @Test(expected = IllegalArgumentException.class)
    /** Velocidad usa un formato no implementado */
    public void velocidadNoImplementadaTest1() {

      new VelocidadBajadaSubida("asdd2 50 Mbps-432 ");
    }



}