package app;

public class App {
    public static void main(String[] args) {

    VelocidadRed vel1 = new VelocidadRed("1 Kbps");
    VelocidadRed vel2 = new VelocidadRed("2 Mbps");

    vel1.esMayor(vel2); 

    }
}