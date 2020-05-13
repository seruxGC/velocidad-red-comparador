package app;

import app.velocidad.clases.VelocidadBajadaSubida;
import app.velocidad.clases.VelocidadRed;
import app.velocidad.constantes.UnidadVelocidad;

public class App {
    public static void main(String[] args) {

        // VelocidadRed Constructor 1
        VelocidadRed vel1 = new VelocidadRed("1 Kbps");
        VelocidadRed vel2 = new VelocidadRed("2 Mbps");

        vel1.esMayorQue(vel2); // false 
        vel1.esIgualA(vel2); // false 
        vel1.esMenorQue(vel2); // true

       
        // VelocidadRed Constructor 2
        VelocidadRed velLiteral1 = new VelocidadRed(1, UnidadVelocidad.GIGABITS_CARACTER);
        VelocidadRed velLiteral2 = new VelocidadRed(50, UnidadVelocidad.MEGABITS_SEGUNDO);


        // VelocidadBajadaSubida Constructor 1
        VelocidadBajadaSubida velocidad1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH0 100M/50M SIN VOZ");
        VelocidadBajadaSubida velocidad2 = new VelocidadBajadaSubida("Conexion NASA Fibra 10Mbps - 50Mbps");

        velocidad1.igualVelocidadBajadaQue(velocidad2); // false
        velocidad1.mayorVelocidadBajadaQue(velocidad2); // true
        velocidad1.menorVelocidadBajadaQue(velocidad2); // false
        
        velocidad1.igualVelocidadSubidaQue(velocidad2); // true
        velocidad1.mayorVelocidadSubidaQue(velocidad2); // false
        velocidad1.menorVelocidadSubidaQue(velocidad2); // false



       
        // VelocidadBajadaSubida Constructor 2
        VelocidadBajadaSubida velBaSu3 = new VelocidadBajadaSubida(150, UnidadVelocidad.GIGABITS_SEGUNDO, 100,
                UnidadVelocidad.MEGABITS_SEGUNDO);



        System.out.println(velLiteral1.getLiteralVelocidad());
        System.out.println(velLiteral2.getLiteralVelocidad());
        System.out.println(velBaSu3.getLiteralVelocidad());
        System.out.println(velLiteral2.getLiteralVelocidad());

    }
}