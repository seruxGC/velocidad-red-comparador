package app;

import app.context.VelocidadRedComparador;

public class App {
    public static void main(String[] args) {
       


        // Formato 1
        // boolean result1 = VelocidadRedComparador.compara("Acceso VPN IP 1000M/1000M SIN VOZ", "Acceso VPN IP 200M/200M" );

        // System.out.println(result1); 

        // Formato 2 "100M-500M" "100G-500G"
        // boolean result4 = VelocidadRedComparador.compara("100G-500G", "100M-500M" );

        // System.out.println(result4);


      
        // // Formato 3 
        boolean result2 = VelocidadRedComparador.compara("2 Kbps", "1,5 Kbps");
        // boolean result3 = VelocidadRedComparador.compara("2000 Mbps", "2,1 Gbps");
        
        
        System.out.println(result2);
        // System.out.println(result3);

    }
}