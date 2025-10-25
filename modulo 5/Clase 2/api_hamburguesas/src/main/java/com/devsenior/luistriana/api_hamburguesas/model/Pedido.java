package com.devsenior.luistriana.api_hamburguesas.model;

import org.springframework.stereotype.Component;

@Component // todo java beans es un pojo pero no todo pojo es un java beans
public class Pedido {
    private String id;
    private String cliente;
    private String tipoPedido;
    private String direccion;
    private Boolean atentido;
    private String horaPedido;

    public Pedido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getAtentido() {
        return atentido;
    }

    public void setAtentido(Boolean atentido) {
        this.atentido = atentido;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public Pedido(String id, String cliente, String tipoPedido, String direccion, Boolean atentido, String horaPedido) {
        this.id = id;
        this.cliente = cliente;
        this.tipoPedido = tipoPedido;
        this.direccion = direccion;
        this.atentido = false;
        this.horaPedido = horaPedido;
    }

    @Override
    public boolean equals(Object o) {
        // 1. verificar si es el mismo objeto en memoria
        if (this == o)
            return true;

        // verifircar si el objeto es null o de ora clase
        if (o == null || getClass() != o.getClass())
            return false;
        Pedido pedido = (Pedido) o;
        // comparamos los dos pedidos si tiene el mismo id
        return id != null && id.equals(pedido.id);
    }

    // metodo hashCode
    @Override
    public int hashCode() {

        return id != null ? id.hashCode() : 0;

    }

}
