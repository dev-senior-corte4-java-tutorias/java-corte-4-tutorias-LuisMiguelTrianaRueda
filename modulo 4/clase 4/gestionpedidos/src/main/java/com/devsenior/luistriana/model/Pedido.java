package com.devsenior.luistriana.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String id;
    private String comprador;
    private String productos;
    private City ciudadDeDestino;

    // === atributos nuevos para el estado del pedido

    private EstadoPedido estado;

    private List<String> historialEstaciones;

    private LocalDate fechaMaximaDeReclamo;

    private boolean devuelto;

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public List<String> getHistorialEstaciones() {
        return historialEstaciones;
    }

    /*
     * no tenemos setter para el historial de pedido para proteger esa variable de
     * cambios mal echos
     */
    public LocalDate getFechaMaximaDeReclamo() {
        return fechaMaximaDeReclamo;
    }

    public void setFechaMaximaDeReclamo(LocalDate fechaMaximaDeReclamo) {
        this.fechaMaximaDeReclamo = fechaMaximaDeReclamo;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

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

        // == variables nuevas inicializadas del estado pedido

        this.estado = EstadoPedido.EN_BODEGA; // se inicializa en bodega 
        this.historialEstaciones = new ArrayList<>();
        this.historialEstaciones.add("pedido creado en bodega de origen");

        this.fechaMaximaDeReclamo = LocalDate.now().plusDays(10); // fecha maxima de reclamo
        this.devuelto = false;
    }

    // se encargara de modificar el atributo de una forma especifica

    public void agregarRegistroHistorial(String regitro) {
        this.historialEstaciones.add(regitro);

    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", comprador=" + comprador + ", productos=" + productos + ", ciudadDeDestino="
                + ciudadDeDestino.getNombre() + ", estado=" + estado
                + ", fechaMaximaDeReclamo=" + fechaMaximaDeReclamo + "]";
    }

}
