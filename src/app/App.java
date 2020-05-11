package app;

import app.velocidad.comparador.contexto.VelocidadRedComparador;

public class App {
    public static void main(String[] args) {

        VelocidadRed velocidad1 = new VelocidadRed("100 Mbps");
        VelocidadRed velocidad2 = new VelocidadRed("1 Gbps");

        boolean result1 = velocidad1.esIgual(velocidad2); // False
        boolean result2 = velocidad1.esMayor(velocidad1); // False
        boolean result3 = velocidad1.esMenor(velocidad2); // True



        VelocidadRed velocidad3 = new VelocidadRed("Acceso VPN IP FTTH0 1000M/1000M SIN VOZ");
        VelocidadRed velocidad4 = new VelocidadRed("ADSL premium 1Gbps - 1Gbps empresas");

        boolean result4 = velocidad3.esIgual(velocidad4); // True
        boolean result5 = velocidad3.esMayor(velocidad4); // False
        boolean result6 = velocidad3.esMenor(velocidad4); // False




        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);

    }
}