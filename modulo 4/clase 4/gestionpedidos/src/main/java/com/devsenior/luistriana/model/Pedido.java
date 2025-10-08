package com.devsenior.luistriana.model;

public class Pedido {
    private String id;
    private String comprador;
    private String productos;
    private City ciudadDeDestino;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComprador() {
        return comprador;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public City getCiudadDeDestino() {
        return ciudadDeDestino;
    }

    public void setCiudadDeDestino(City ciudadDeDestino) {
        this.ciudadDeDestino = ciudadDeDestino;
    }

    public Pedido(String id, String comprador, String productos, City ciudadDeDestino) {
        this.id = id;
        this.comprador = comprador;
        this.productos = productos;
        this.ciudadDeDestino = ciudadDeDestino;
    }

}
