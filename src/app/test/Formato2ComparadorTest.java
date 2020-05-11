package app.test;

import org.junit.Assert;
import org.junit.Test;

import app.velocidad.comparador.contexto.VelocidadRedComparador;

public class Formato2ComparadorTest {

    /** Test Formato 3 */
    @Test
    /** Velocidad1 > velocidad2 Velocidades en kbps */
    public void formato2Test1() {
        
        String velocidadRed1 = "2 Kbps";
        String velocidadRed2 = "1 Kbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad1 > velocidad2 Velocidades en Mbps */
    public void formato2Test2() {
        
        String velocidadRed1 = "2 Mbps";
        String velocidadRed2 = "1 Mbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Gbps */
    public void formato2Test3() {
        
        String velocidadRed1 = "2 Gbps";
        String velocidadRed2 = "1 Gbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Kbps y Mbps */
    public void formato2Test4() {
        
        String velocidadRed1 = "1001 Kbps";
        String velocidadRed2 = "1 Mbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Kbps y Gbps */
    public void formato2Test5() {
        
        String velocidadRed1 = "1000001 Kbps";
        String velocidadRed2 = "1 Gbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Mbps y Kbps */
    public void formato2Test6() {
        
        String velocidadRed1 = "1 Mbps";
        String velocidadRed2 = "999 Kbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 Velocidades en Mbps y Gbps */
    public void formato2Test7() {
        
        String velocidadRed1 = "1001 Mbps";
        String velocidadRed2 = "1 Gbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con coma */
    public void formato2Test8() {
        
        String velocidadRed1 = "1,5 Kbps";
        String velocidadRed2 = "1 Kbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con punto */
    public void formato2Test9() {
        
        String velocidadRed1 = "1.5 Kbps";
        String velocidadRed2 = "1 Kbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con punto diferentes unidades */
    public void formato2Test10() {
        
        String velocidadRed1 = "1.1 Mbps";
        String velocidadRed2 = "1000 Kbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con coma diferentes unidades */
    public void formato2Test11() {
        
        String velocidadRed1 = "1,1 Gbps";
        String velocidadRed2 = "1000 Mbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con separador */
    public void formato2SeparadorTest1() {
        
        String velocidadRed1 = "1,1-Gbps";
        String velocidadRed2 = "1000-Mbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 decimal con separador */
    public void formato2SeparadorTest2() {
        
        String velocidadRed1 = "1,1 - Gbps";
        String velocidadRed2 = "1000 - Mbps";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en un corchete  */
    public void formato2CorcheteTest1() {
        
        String velocidadRed1 = "[1,1-Gbps]";
        String velocidadRed2 = "[1000-Mbps]";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en un corchete */
    public void formato2CorcheteTest2() {
        
        String velocidadRed1 = "[1,1 - Gbps]";
        String velocidadRed2 = "[1000 - Mbps]";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en una llave */
    public void formato2llaveTest1() {
        
        String velocidadRed1 = "{1,1-Gbps}";
        String velocidadRed2 = "{1000-Mbps}";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad > velocidad2 contenido en una llave */
    public void formato2llaveTest2() {
        
        String velocidadRed1 = "{1,1 - Gbps}";
        String velocidadRed2 = "{1000 - Mbps}";

        boolean resultado = VelocidadRedComparador.primeraVelocidadEsMayor(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad = velocidad2*/
    public void formato2VelocidadesIgualesTest1() {

        String velocidadRed1 = "{1,1 - Gbps}";
        String velocidadRed2 = "{1.1 - Gbps}";

        boolean resultado = VelocidadRedComparador.velocidadesSonIguales(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad = velocidad2 */
    public void formato2VelocidadesIgualesTest2() {

        String velocidadRed1 = "100 - Mbps";
        String velocidadRed2 = "100 - Mbps";

        boolean resultado = VelocidadRedComparador.velocidadesSonIguales(velocidadRed1, velocidadRed2);
        Assert.assertTrue(resultado);
    }

    @Test
    /** Velocidad != velocidad2 */
    public void formato2VelocidadesIgualesTest3() {

        String velocidadRed1 = "100 Mbps";
        String velocidadRed2 = "100 Kbps";

        boolean resultado = VelocidadRedComparador.velocidadesSonIguales(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }

    @Test
    /** Velocidad != velocidad2 */
    public void formato2VelocidadesIgualesTest4() {

        String velocidadRed1 = "101 Mbps";
        String velocidadRed2 = "100 Mbps";

        boolean resultado = VelocidadRedComparador.velocidadesSonIguales(velocidadRed1, velocidadRed2);
        Assert.assertFalse(resultado);
    }
    
}