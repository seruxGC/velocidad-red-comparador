package app.velocidad.constantes;

public enum UnidadVelocidad {

    KILOBITS_SEGUNDO("Kbps"), MEGABITS_SEGUNDO("Mbps"), GIGABITS_SEGUNDO("Gbps"), KILOBITS_CARACTER("K"), MEGABITS_CARACTER("M"),
    GIGABITS_CARACTER("G");

    private String valor;

    UnidadVelocidad(String unidadVelocidad) {
        this.valor = unidadVelocidad;
    }

    public String getValor() {
        return this.valor;
    }

    public static UnidadVelocidad fromString(String texto) {
        for (UnidadVelocidad unidad : UnidadVelocidad.values()) {
            if (unidad.valor.equalsIgnoreCase(texto)) {
                return unidad;
            }
        }
        throw new IllegalArgumentException("No se ha encontrado ninguna unidad de velocidad con el texto " + texto);
    }

}