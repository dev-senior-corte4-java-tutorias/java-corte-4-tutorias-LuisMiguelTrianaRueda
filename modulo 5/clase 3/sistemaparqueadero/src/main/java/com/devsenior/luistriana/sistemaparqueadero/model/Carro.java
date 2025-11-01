
package com.devsenior.luistriana.sistemaparqueadero.model;

public class Carro {
    private String placa;
    private Double tiempoDePago;

    public Carro() {
    }

    public Carro(String placa, Double tiempoDePago) {
        this.placa = placa;
        this.tiempoDePago = tiempoDePago;
    }

    public String getPlaca() {
        return placa;
    }

    public Double getTiempoDePago() {
        return tiempoDePago;
    }

    public void setTiempoDePago(Double tiempoDePago) {
        this.tiempoDePago = tiempoDePago;
    }

    // hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((placa == null) ? 0 : placa.hashCode());
        return result;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carro other = (Carro) obj;
        if (placa == null) {
            if (other.placa != null)
                return false;
        } else if (!placa.equals(other.placa))
            return false;

        return true;
    }

}
