package app.test;

import org.junit.Assert;
import org.junit.Test;

import app.context.VelocidadRedComparador;

public class Formato1Test {

    /** Test Formato 1 literal exacto */

    @Test
    /** Velocidad1 > velocidad2 Velocidades en megas */
    public void formato1ExactoTest1() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "100M-100M";
        String velocidadRed2 = "50M-50M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 gigas/megas */
    public void formato1ExactoTest2() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1G-1G";
        String velocidadRed2 = "100M-100M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en gigas */
    public void formato1ExactoTest3() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "10G-10G";
        String velocidadRed2 = "1G-1G";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 Velocidades en gigas */
    public void formato1ExactoTest4() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "2G-1G";
        String velocidadRed2 = "1G-2G";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 Velocidades en gigas */
    public void formato1ExactoTest5() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "10G-10G";
        String velocidadRed2 = "15G-2G";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en megas */
    public void formato1ExactoTest6() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "100M/100M";
        String velocidadRed2 = "50M/50M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 gigas/megas */
    public void formato1ExactoTest7() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1G/1G";
        String velocidadRed2 = "100M/100M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en gigas */
    public void formato1ExactoTest8() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "10G/10G";
        String velocidadRed2 = "1G/1G";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 Velocidades en gigas */
    public void formato1ExactoTest9() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "2G/1G";
        String velocidadRed2 = "1G/2G";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en gigas */
    public void formato1CorchetesTest() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "{10G/10G}";
        String velocidadRed2 = "{1G/1G}";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en gigas */
    public void formato1LlavesTest() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "[10G/10G]";
        String velocidadRed2 = "[1G/1G]";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits */
    public void formato1ExactoTest10() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "15K/15K";
        String velocidadRed2 = "10K/10K";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
        
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits */
    public void formato1ExactoTest11() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "15 K / 15 K";
        String velocidadRed2 = "10 K / 10 K";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits megas*/
    public void formato1ExactoTest12() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1 M - 1 M";
        String velocidadRed2 = "999 K - 999 K";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits gigas */
    public void formato1ExactoTest13() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1000001 K - 1000001 K";
        String velocidadRed2 = "1 G - 1 G";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);

    }









    /** Test Fotmato 1 literal velocidad contenido en otro mayor */

    @Test
    /** Velocidad1 > velocidad2 */
    public void formato1Test1() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "Acceso VPN IP 2M/2M SIN VOZ";
        String velocidadRed2 = "Acceso VPN IP 1M/1M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 */
    public void formato1Test2() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "Acceso VPN IP 3M/3M SIN VOZ";
        String velocidadRed2 = "Acceso VPN IP 1M/1M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 La velocidad de subida es menor */
    public void formato1Test3() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "Acceso VPN IP FTTH0 100M/50M SIN VOZ";
        String velocidadRed2 = "Acceso VPN IP 50M/100M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad1 < velocidad2 La velocidad de bajada es menor */
    public void formato1Test4() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "Acceso VPN IP FTTH 100M/500M SIN VOZ";
        String velocidadRed2 = "Acceso VPN IP 200M/200M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad1 = velocidad2 */
    public void formato1Test5() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "Acceso VPN IP FTTH 200M/200M SIN VOZ";
        String velocidadRed2 = "Acceso VPN IP 200M/200M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test
    /**
     * Velocidad1 = velocidad2 literal tiene otros numeros aparte de los de la
     * velocidad
     */
    public void formato1LiteralConMasNumerosTest() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "Acceso VPN IP FTTH 200 250M/250M 200 SIN VOZ";
        String velocidadRed2 = "Acceso VPN IP 20 200M/200M 0";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /**
     * Velocidad1 > velocidad2 literales distintos
     */
    public void formato1LiteralesDistintosTest() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "Acceso VPN IP FTTH 200 250M/250M 200 SIN VOZ";
        String velocidadRed2 = "200M/200M";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /**
     * Velocidad1 < Velocidad2 literales distintos
     */
    public void formato1LiteralesDistintosTest2() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "Acceso VPN IP 100M/1000M";
        String velocidadRed2 = "Adsl 200M-200M Fibra 2.0";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }





    // Test Unidades segundo

    @Test
    /**
     * Velocidad1 > velocidad2
     */
    public void formato1UnidadesSegundoTest1() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "2 Mbps/2 Mbps";
        String velocidadRed2 = "1 Mbps/1 Mbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /**
     * Velocidad1 > velocidad2
     */
    public void formato1UnidadesSegundoTest2() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1 Gbps-1 Gbps";
        String velocidadRed2 = "999 Mbps-999 Mbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1UnidadesSegundoTest3() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1 Gbps - 1 Gbps";
        String velocidadRed2 = "999 Mbps - 999 Mbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1UnidadesSegundoTest4() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "[1 Gbps / 1 Gbps]";
        String velocidadRed2 = "[999 Mbps / 999 Mbps]";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1UnidadesSegundoTest5() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "Fibra oro Telefonica {1999 Mbps / 1999 Mbps}";
        String velocidadRed2 = "Fibra oro Telefonica {2 Gbps / 2 Gbps}";
       
        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits */
    public void formato1UnidadesSegundoTes6() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "15Kbps/15Kbps";
        String velocidadRed2 = "10Kbps/10Kbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits */
    public void formato1UnidadesSegundoTest7() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "15 Kbps / 15 Kbps";
        String velocidadRed2 = "10 Kbps / 10 Kbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits megas */
    public void formato1UnidadesSegundoTest8() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1 M - 1 M";
        String velocidadRed2 = "999 Kbps - 999 Kbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);

    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kilobits gigas */
    public void formato1UnidadesSegundoTest9() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1000001 Kbps - 1000001 Kbps";
        String velocidadRed2 = "1 G - 1 G";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);

    }




    // Test velocidades con decimales


    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1ConDecimalTest1() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "[1,5 Gbps / 1,5 Gbps]";
        String velocidadRed2 = "1.2 Gbps - 1.2 Gbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1ConDecimalTest2() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "{1,5 Gbps} - {1.5 Gbps}";
        String velocidadRed2 = "{1499 Mbps} - {1499 Mbps}";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** * Velocidad1 > velocidad2 */
    public void formato1ConDecimalTest3() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "{1,55 Gbps} - {1.55 Gbps}";
        String velocidadRed2 = "{1499 Mbps} - {1499 Mbps}";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

}