package com.devsenior.luistriana.model;

public class Asiento {
    private EstadoAsiento estado;

    public Asiento() {
        this.estado = EstadoAsiento.LIBRE;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "estado=" + estado +
                '}';
    }

    public boolean isLibre() {
        return this.estado == EstadoAsiento.LIBRE;
    }

}