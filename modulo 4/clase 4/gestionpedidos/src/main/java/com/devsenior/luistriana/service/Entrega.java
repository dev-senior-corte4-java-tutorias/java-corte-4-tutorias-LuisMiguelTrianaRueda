package com.devsenior.luistriana.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsenior.luistriana.model.City;
import com.devsenior.luistriana.model.Pedido;

public class Entrega {
    private List<City> ciudad;
    // key Value
    private Map<String, Pedido> pedidos;

    public Entrega() {
        this.ciudad = new ArrayList<>();
        this.pedidos = new HashMap<>();
    }

    public void agregarPedido(Pedido pedido) {
        if (pedidos.containsKey(pedido.getId())) {

            System.out.println(" el pedido ya fue agregado a la lista ");
        }

        else {
            pedidos.put(pedido.getId(), pedido);
            System.out.println(" el pedido ya fue agregado ");
        }
    }

    // metodo para eliminar pedido
    public void eliminarPedido(String id) {
        if (pedidos.containsKey(id)) {
            pedidos.remove(id);
            System.out.println(" el pedido fue elimnado con exito ");
        }

        else {
            System.out.println(" el pedido con ese id no se encontro ");
        }
    }

    // ver pedido
    public Optional<Pedido> verPedido(String id) {
        if (pedidos.containsKey(id)) {
            Pedido pedidoEncontrado = pedidos.get(id);
            // retonar un cajita con el objeto que encontro
            return Optional.of(pedidoEncontrado);
        } else {

            System.out.println(" no se encontro el pedido especifico ");
            // RETORNA UNA CAJITA SIN EL OBJETO (PERO RETORNA ALGO )
            return Optional.empty();
        }

    }

    // actualizar un pedido

    public void actualizarPedido(Pedido pedido) {

        String id = pedido.getId();

        if (pedidos.containsKey(id)) {
            pedidos.put(id, pedido);
            System.out.println(" pedido fue actualizado ");
        }

        else {
            System.out.println(" el pedido no se pudo actualizar ");
        }
    }

    // metodo para filtrar los pedidos que van a una ciudad especifica

    public List<Pedido> verPedidosPorCiudad(String nombreCiudad) {

        return pedidos.values().stream()
                .filter(p -> p.getCiudadDeDestino().getNombre().equalsIgnoreCase(nombreCiudad))
                .collect(Collectors.toList());

    }

    // bogota = 1000
    /*
     * es un metodo public que es de tipo map donde su clave es un string y su valor
     * es un long se llama contadorPedidosPorciudad
     * ahora dentro del retorno del metodo las tres operaciones seran las siguientes
     * 
     * 1. del mapa de pedidos vamos a sacar sus valores los vamos a convertir en un
     * flujo
     * 2. los vamos almacenar dentro de una coleccion y dentro de esa coleccion
     * aplicaremos las funciones de sacar por cada pedido su ciudad de destino y su
     * nombre y
     * con le counting (contar ) contaremos cuantas veces aparecio esa ciudad
     * ejemplo:
     * bogota = 10000
     * medellin = 300
     * bucaramanga = 4500
     * 
     * 
     */
    public Map<String, Long> ContarPedidosPorciudad() {

        return pedidos.values().stream().collect(
                Collectors.groupingBy(
                        pedido -> pedido.getCiudadDeDestino().getNombre(),
                        Collectors.counting()));
    }

    // verificar si hay pedidos para un comprador especifico

    public boolean existePedidoParaComprador(String nombreComprador) {

        return pedidos.values().stream().anyMatch(
                pedido -> pedido.getComprador().equalsIgnoreCase(nombreComprador));
    }

}
