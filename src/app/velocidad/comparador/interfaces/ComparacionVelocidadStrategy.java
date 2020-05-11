package app.velocidad.comparador.interfaces;

public interface ComparacionVelocidadStrategy {
   
    /**
     * @param velocidadRed1
     * @param velocidadRed2
     * @return True si velocidadRed1 > velocidadRed2 , False en caso contrario
     */
    boolean primeraVelocidadEsMayor(String velocidadRed1, String velocidadRed2);

    boolean velocidadesSonIguales(String velocidadRed1, String velocidadRed2);
}