package com.devsenior.luistriana.api_hamburguesas.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.devsenior.luistriana.api_hamburguesas.model.Pedido;

@Service
public class ServicePedidoImpl implements ServicePedido {

    // creamoss un set para evitar duplicados en pedidos
    private Set<Pedido> listaPedidos;

    public ServicePedidoImpl() {
        this.listaPedidos = new LinkedHashSet<>();
    }

    @Override
    public void agregarPedido(Pedido nuevoPedido) {
        listaPedidos.add(nuevoPedido);
    }

    @Override
    public List<Pedido> verTodosLosPedidos() {
        return new ArrayList<>(listaPedidos);
    }

    @Override
    public Pedido verPedido(String id) {
        return listaPedidos.stream().filter(pedido -> pedido.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("el pedido que esta solicitando no existe"));

    }

    @Override
    public void actualizarPedido(String id, Pedido pedidoActualizado) {
        verPedido(id);
        // eliminamos el pedido viejo (con los valores de los campos antiguos)
        listaPedidos.remove(pedidoActualizado);
        // agregamos el pedido nuevo (con los valores de los campos nuevos)
        listaPedidos.add(pedidoActualizado);
    }

    @Override
    public void eliminarPedido(String id) {
        Pedido pedidoEliminar = verPedido(id);
        listaPedidos.remove(pedidoEliminar);
    }

    @Override
    public void actualizarPedidoParcialmente(String id, Pedido pedido) {
        Pedido pedidoExistente = verPedido(id);

        Optional.ofNullable(pedido.getCliente()).ifPresent(pedidoExistente::setCliente);
        Optional.ofNullable(pedido.getDireccion()).ifPresent(pedidoExistente::setDireccion);
        Optional.ofNullable(pedido.getHoraPedido()).ifPresent(pedidoExistente::setHoraPedido);
        Optional.ofNullable(pedido.getAtentido()).ifPresent(pedidoExistente::setAtentido);
    }

}
