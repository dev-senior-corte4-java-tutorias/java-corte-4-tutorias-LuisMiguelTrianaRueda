package com.devsenior.luistriana.api_hamburguesas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.luistriana.api_hamburguesas.model.Pedido;
import com.devsenior.luistriana.api_hamburguesas.service.ServicePedido;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {
    private final ServicePedido pedidos;

    public PedidoController(ServicePedido pedidos) {
        this.pedidos = pedidos;
    }

    // ver todos los pedidos
    @GetMapping("/pedidos")
    public List<Pedido> verPedidos() {
        return pedidos.verTodosLosPedidos();
    }

    // ver un solo pedido
    @GetMapping("/pedido/{id}")
    public Pedido verPedido(@PathVariable String id) {
        return pedidos.verPedido(id);
    }

    // crear un pedido
    @PostMapping("/nuevopedido")
    public Pedido agregarPedido(@RequestBody Pedido nuevoPedido) {

        pedidos.agregarPedido(nuevoPedido);
        return nuevoPedido;

    }

    // actualizar un pedido
    @PutMapping("actualizar/pedido/{id}")
    public void actualizarPedido(@PathVariable String id, @RequestBody Pedido pedido) {
        pedidos.actualizarPedido(id, pedido);

    }

    // actualizar parcialmente un pedido
    @PatchMapping("/pedido/{id}")
    public void actualizarPedidoParcialmente(@PathVariable String id, @RequestBody Pedido pedido) {

        pedidos.actualizarPedidoParcialmente(id, pedido);
    }

    // borrar un pedido

    @DeleteMapping("/pedido/{id}")
    public void eliminarPedido(@PathVariable String id) {

        pedidos.eliminarPedido(id);

    }
}
