package com.devsenior.luistriana.api_hamburguesas.service;

import java.util.List;

import com.devsenior.luistriana.api_hamburguesas.model.Pedido;

public interface ServicePedido {
    // add pedido
    void agregarPedido(Pedido nuevoPedido);

    // consultar todos los pedidos
    List<Pedido> verTodosLosPedidos();

    // leer un solo pedido
    Pedido verPedido(String id);

    // actualizar la informacion de un pedido
    void actualizarPedido(String id, Pedido pedido);

    // eliminar un pedido

    void eliminarPedido(String id);

    // actualizar parcialmente un pedido

    void actualizarPedidoParcialmente(String id, Pedido pedido);
}
