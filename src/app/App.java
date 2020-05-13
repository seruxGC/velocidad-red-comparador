package app;

import app.velocidad.clases.VelocidadBajadaSubida;
import app.velocidad.clases.VelocidadRed;
import app.velocidad.constantes.UnidadVelocidad;

public class App {
    public static void main(String[] args) {

        // VelocidadRed Constructor 1
        VelocidadRed vel1 = new VelocidadRed("1 Kbps");
        VelocidadRed vel2 = new VelocidadRed("2 Mbps");

        vel1.esMayor(vel2); // false 
        vel1.esIgual(vel2); // false 
        vel1.esMenor(vel2); // true

       
        // VelocidadRed Constructor 2
        VelocidadRed velLiteral1 = new VelocidadRed(1, UnidadVelocidad.GIGABITS_CARACTER);
        VelocidadRed velLiteral2 = new VelocidadRed(50, UnidadVelocidad.MEGABITS_SEGUNDO);

        velLiteral1.esIgual(velLiteral2); // false
        velLiteral1.esMayor(velLiteral2); // true
        velLiteral2.esMenor(velLiteral2); // false
        

        // VelocidadBajadaSubida Constructor 1
        VelocidadBajadaSubida velBaSu1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH0 100M/50M SIN VOZ");
        VelocidadBajadaSubida velBaSu2 = new VelocidadBajadaSubida("Conexion NASA Fibra 10Mbps - 1Mbps");

        velBaSu1.esMayor(velBaSu2); // true
        velBaSu1.esIgual(velBaSu2); // false 
        velBaSu1.esMenor(velBaSu2); // false

       
        // VelocidadBajadaSubida Constructor 2
        VelocidadBajadaSubida velBaSu3 = new VelocidadBajadaSubida(150, UnidadVelocidad.GIGABITS_SEGUNDO, 100,
                UnidadVelocidad.MEGABITS_SEGUNDO);

        boolean result3 = velBaSu3.esMayor(velBaSu2); // true



        System.out.println(velLiteral1.getLiteralVelocidad());
        System.out.println(velLiteral2.getLiteralVelocidad());
        System.out.println(velBaSu3.getLiteralVelocidad());
        System.out.println(velLiteral2.getLiteralVelocidad());

    }
}