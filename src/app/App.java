package app;

import app.velocidad.clases.VelocidadBajadaSubida;
import app.velocidad.clases.VelocidadRed;
import app.velocidad.constantes.UnidadVelocidad;

public class App {
    public static void main(String[] args) {

        // VelocidadRed Constructor 1
        VelocidadRed vel1 = new VelocidadRed("1 Kbps");
        VelocidadRed vel2 = new VelocidadRed("2 Mbps");

        boolean esMayor = vel1.esMayor(vel2);
        boolean esIgual = vel1.esIgual(vel2);
        boolean esMenor = vel1.esMenor(vel2);

       
        // VelocidadRed Constructor 2
        VelocidadRed velLiteral1 = new VelocidadRed(1, UnidadVelocidad.GIGABITS_CARACTER);
        VelocidadRed velLiteral2 = new VelocidadRed(50, UnidadVelocidad.MEGABITS_SEGUNDO);

        boolean result = velLiteral1.esIgual(velLiteral2);
        boolean result2 = velLiteral2.esMayor(velLiteral1);

        // VelocidadBajadaSubida Constructor 1
        VelocidadBajadaSubida velBaSu1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH0 100M/50M SIN VOZ");
        VelocidadBajadaSubida velBaSu2 = new VelocidadBajadaSubida("Conexion NASA Fibra 10Mbps - 1Mbps");

        boolean esMayor2 = velBaSu1.esMayor(velBaSu2);
        boolean esIgual2 = velBaSu1.esIgual(velBaSu2);
        boolean esMenor2 = velBaSu1.esMenor(velBaSu2);

       
        // VelocidadBajadaSubida Constructor 2
        VelocidadBajadaSubida velBaSu3 = new VelocidadBajadaSubida(150, UnidadVelocidad.GIGABITS_SEGUNDO, 100,
                UnidadVelocidad.MEGABITS_SEGUNDO);

        boolean result3 = velBaSu3.esMenor(velBaSu2);



        System.out.println("Es mayor:" + esMayor);
        System.out.println("Es igual:" + esIgual);
        System.out.println("Es menor:" + esMenor);
        System.out.println("Es mayor:" + esMayor2);
        System.out.println("Es igual:" + esIgual2);
        System.out.println("Es menor:" + esMenor2);
        System.out.println("Es menor:" + result);
        System.out.println("Es menor:" + result2);
        System.out.println("Es menor:" + result3);


        System.out.println(velLiteral1.getLiteralVelocidad());
        System.out.println(velLiteral2.getLiteralVelocidad());
        System.out.println(velBaSu3.getLiteralVelocidad());
        System.out.println(velLiteral2.getLiteralVelocidad());

    }
}