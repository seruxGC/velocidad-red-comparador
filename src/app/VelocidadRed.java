package app;

import app.velocidad.comparador.contexto.VelocidadRedComparador;

public class VelocidadRed {

    private String velocidad;

    public VelocidadRed(String velocidadRed) {
        velocidad = velocidadRed;
    }

    public boolean esMayor(VelocidadRed velocidadRed) {
        return VelocidadRedComparador.primeraVelocidadEsMayor(velocidad, velocidadRed.getVelocidad());
    }

    public boolean esIgual(VelocidadRed velocidadRed) {
        return VelocidadRedComparador.velocidadesSonIguales(velocidad, velocidadRed.getVelocidad());
    }

    public boolean esMenor(VelocidadRed velocidadRed) {
        return !VelocidadRedComparador.primeraVelocidadEsMayor(velocidad, velocidadRed.getVelocidad())
                && !VelocidadRedComparador.velocidadesSonIguales(velocidad, velocidadRed.getVelocidad());
    }

    public String getVelocidad() {
        return velocidad;
    }
}