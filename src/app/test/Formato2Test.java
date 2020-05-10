package app.test;

import org.junit.Assert;
import org.junit.Test;

import app.context.VelocidadRedComparador;

public class Formato2Test {

    /** Test Formato 3 */
    @Test
    /** Velocidad1 > velocidad2 Velocidades en kbps */
    public void formato2Test1() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "2 Kbps";
        String velocidadRed2 = "1 Kbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en Mbps */
    public void formato2Test2() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "2 Mbps";
        String velocidadRed2 = "1 Mbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Gbps */
    public void formato2Test3() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "2 Gbps";
        String velocidadRed2 = "1 Gbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Kbps y Mbps */
    public void formato2Test4() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1001 Kbps";
        String velocidadRed2 = "1 Mbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Kbps y Gbps */
    public void formato2Test5() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1000001 Kbps";
        String velocidadRed2 = "1 Gbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Mbps y Kbps */
    public void formato2Test6() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1 Mbps";
        String velocidadRed2 = "999 Kbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Mbps y Gbps */
    public void formato2Test7() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1001 Mbps";
        String velocidadRed2 = "1 Gbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con coma */
    public void formato2Test8() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1,5 Kbps";
        String velocidadRed2 = "1 Kbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con punto */
    public void formato2Test9() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1.5 Kbps";
        String velocidadRed2 = "1 Kbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con punto diferentes unidades */
    public void formato2Test10() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1.1 Mbps";
        String velocidadRed2 = "1000 Kbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con coma diferentes unidades */
    public void formato2Test11() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1,1 Gbps";
        String velocidadRed2 = "1000 Mbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con separador */
    public void formato2SeparadorTest1() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1,1-Gbps";
        String velocidadRed2 = "1000-Mbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con separador */
    public void formato2SeparadorTest2() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "1,1 - Gbps";
        String velocidadRed2 = "1000 - Mbps";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en un corchete  */
    public void formato2CorcheteTest1() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "[1,1-Gbps]";
        String velocidadRed2 = "[1000-Mbps]";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en un corchete */
    public void formato2CorcheteTest2() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "[1,1 - Gbps]";
        String velocidadRed2 = "[1000 - Mbps]";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en una llave */
    public void formato2llaveTest1() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "{1,1-Gbps}";
        String velocidadRed2 = "{1000-Mbps}";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en una llave */
    public void formato2llaveTest2() {
        VelocidadRedComparador velocidadRedComparador = new VelocidadRedComparador();
        String velocidadRed1 = "{1,1 - Gbps}";
        String velocidadRed2 = "{1000 - Mbps}";

        boolean resultado = velocidadRedComparador.compara(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }
    
}