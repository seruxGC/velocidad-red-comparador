package app.velocidad.calculo;

import app.velocidad.comparador.config.UnidadVelocidad;

public class VelocidadRedCalculo {

    private static final short MULTIPLO_VELOCIDADES = 1000;

    private VelocidadRedCalculo() {
        throw new IllegalStateException("Clase de utilidad");
    }

    public static float getVelocidadEnMegabits(float numeroVelocidad, UnidadVelocidad unidadVelocidad) {

        if (UnidadVelocidad.KILOBITS_CARACTER == unidadVelocidad
                || UnidadVelocidad.KILOBITS_SEGUNDO == unidadVelocidad) {
            return numeroVelocidad / MULTIPLO_VELOCIDADES;
        }

        if (UnidadVelocidad.MEGABITS_CARACTER == unidadVelocidad
                || UnidadVelocidad.MEGABITS_SEGUNDO == unidadVelocidad) {
            return numeroVelocidad;
        }

        if (UnidadVelocidad.GIGABITS_CARACTER == unidadVelocidad
                || UnidadVelocidad.GIGABITS_SEGUNDO == unidadVelocidad) {
            return numeroVelocidad * MULTIPLO_VELOCIDADES;
        }

        throw new IllegalArgumentException("Velocidad desconocida");
    }
}