package app;

import app.velocidad.comparador.contexto.VelocidadRedComparador;

public class App {
    public static void main(String[] args) {
       

        boolean result2 = VelocidadRedComparador.primeraVelocidadEsMayor("2 Kbps", "1.5 Kbps");
   
        System.out.println(result2);


    }
}