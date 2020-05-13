package app.test;

import org.junit.Assert;
import org.junit.Test;

import app.velocidad.clases.VelocidadRed;

public class VelocidadRedTest {

    @Test
    /** Velocidad1 > velocidad2 Velocidades en kbps */
    public void formato2Test1() {

        VelocidadRed velocidadRed1 = new VelocidadRed("2 Kbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1 Kbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Gbps */
    public void formato2Test2() {

        VelocidadRed velocidadRed1 = new VelocidadRed("2 Gbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1 Gbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Kbps y Mbps */
    public void formato2Test3() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1001 Kbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1 Mbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Kbps y Gbps */
    public void formato2Test4() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1000001 Kbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1 Gbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Mbps y Kbps */
    public void formato2Test6() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1 Mbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("999 Kbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Mbps y Gbps */
    public void formato2Test7() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1001 Mbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1 Gbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con coma */
    public void formato2Test8() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1,5 Kbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1 Kbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con punto */
    public void formato2Test9() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1.5 Kbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1 Kbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con punto diferentes unidades */
    public void formato2Test10() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1.1 Mbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1000 Kbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con coma diferentes unidades */
    public void formato2Test11() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1,1 Gbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1000 Mbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con separador */
    public void formato2SeparadorTest1() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1,1-Gbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1000-Mbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con separador */
    public void formato2SeparadorTest2() {

        VelocidadRed velocidadRed1 = new VelocidadRed("1,1 - Gbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("1000 - Mbps");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en un corchete */
    public void formato2CorcheteTest1() {

        VelocidadRed velocidadRed1 = new VelocidadRed("[1,1-Gbps]");
        VelocidadRed velocidadRed2 = new VelocidadRed("[1000-Mbps]");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en un corchete */
    public void formato2CorcheteTest2() {

        VelocidadRed velocidadRed1 = new VelocidadRed("[1,1 - Gbps]");
        VelocidadRed velocidadRed2 = new VelocidadRed("[1000 - Mbps]");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en una llave */
    public void formato2llaveTest1() {

        VelocidadRed velocidadRed1 = new VelocidadRed("{1,1-Gbps}");
        VelocidadRed velocidadRed2 = new VelocidadRed("{1000-Mbps}");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en una llave */
    public void formato2llaveTest2() {

        VelocidadRed velocidadRed1 = new VelocidadRed("{1,1 - Gbps}");
        VelocidadRed velocidadRed2 = new VelocidadRed("{1000 - Mbps}");

        boolean resultado = velocidadRed1.esMayorQue(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad = velocidad2 */
    public void formato2VelocidadesIgualesTest1() {

        VelocidadRed velocidadRed1 = new VelocidadRed("{1,1 - Gbps}");
        VelocidadRed velocidadRed2 = new VelocidadRed("{1.1 - Gbps}");

        boolean resultado = velocidadRed1.esIgualA(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad = velocidad2 */
    public void formato2VelocidadesIgualesTest2() {

        VelocidadRed velocidadRed1 = new VelocidadRed("100 - Mbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("100 - Mbps");

        boolean resultado = velocidadRed1.esIgualA(velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad != velocidad2 */
    public void formato2VelocidadesIgualesTest3() {

        VelocidadRed velocidadRed1 = new VelocidadRed("100 Mbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("100 Kbps");

        boolean resultado = velocidadRed1.esIgualA(velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad != velocidad2 */
    public void formato2VelocidadesIgualesTest4() {

        VelocidadRed velocidadRed1 = new VelocidadRed("101 Mbps");
        VelocidadRed velocidadRed2 = new VelocidadRed("100 Mbps");

        boolean resultado = velocidadRed1.esIgualA(velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test(expected = IllegalArgumentException.class)
    /** Velocidad usa un formato no implementado */
    public void velocidadNoImplementadaTest1() {

        new VelocidadRed("8 Tbps");
    }

}