package app;

import app.velocidad.comparador.contexto.VelocidadRedComparador;

public class VelocidadRed {

    private String velocidad;

    public VelocidadRed(String velocidadRed) {
        this.velocidad = velocidadRed;
    }

    public boolean mayorQue(VelocidadRed velocidaComparada) {
        return VelocidadRedComparador.primeraVelocidadEsMayor(this.velocidad, velocidaComparada.getVelocidadRed());
    }
    

    public String getVelocidadRed() {
        return velocidad;
    }
}