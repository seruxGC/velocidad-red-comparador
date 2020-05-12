package app;

public class App {
    public static void main(String[] args) {


        
    VelocidadRed vel1 = new VelocidadRed("1 Kbps");
    VelocidadRed vel2 = new VelocidadRed("2 Mbps");
   
    boolean esMayor = vel1.esMayor(vel2); 
    boolean esIgual = vel1.esIgual(vel2); 
    boolean esMenor = vel1.esMenor(vel2); 

    
    
    VelocidadBajadaSubida velBaSu1 = new VelocidadBajadaSubida("Acceso VPN IP FTTH0 100M/50M SIN VOZ");
    VelocidadBajadaSubida velBaSu2 = new VelocidadBajadaSubida("Conexion Cutre NASA Fibra 10Mbps - 1Mbps");

    boolean esMayor2 =  velBaSu1.esMayor(velBaSu2);
    boolean esIgual2 =  velBaSu1.esIgual(velBaSu2);
    boolean esMenor2 =  velBaSu1.esMenor(velBaSu2);

    System.out.println("Es mayor:" + esMayor);
    System.out.println("Es igual:" + esIgual);
    System.out.println("Es menor:" + esMenor);
    System.out.println("Es mayor:" + esMayor2);
    System.out.println("Es igual:" + esIgual2);
    System.out.println("Es menor:" + esMenor2);


    }
}