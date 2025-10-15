package com.devsenior.luistriana.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.devsenior.luistriana.model.City;
import com.devsenior.luistriana.model.EstadoPedido;
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

    // == metodos nuevos para los nuevos atributos ==

    public void actualizarEstadoPedido(String pedidoId, EstadoPedido nuevoEstado, String estacion) {
        if (pedidos.containsKey(pedidoId)) {
            Pedido pedido = pedidos.get(pedidoId);

            pedido.setEstado(nuevoEstado);

            pedido.agregarRegistroHistorial(
                    "el pedido paso por la estacion" + estacion + " con estado " + nuevoEstado.name());

        }
    }

    public void procesarDevolucionPedido(String pedidoId) {
        if (pedidos.containsKey(pedidoId)) {

            Pedido pedido = pedidos.get(pedidoId);
            if (pedido.isDevuelto()) {
                System.out.println(" este pedido ya fue devuelto ");
                return;
            }

            if (pedido.getEstado() == EstadoPedido.ENTREGADO || pedido.getEstado() == EstadoPedido.EN_REPARTO) {
                if (LocalDate.now().isAfter(pedido.getFechaMaximaDeReclamo())) {
                    System.out.println(" error: la fecha maxima para reclarmar o devolver el pedido ha expirado");
                    return;
                }
                // si esta dentro del rango de la fecha establecido para este producto entonces
                // ejecute el proceso de devolucion
                pedido.setDevuelto(true);
                pedido.setEstado(EstadoPedido.EN_DEVOLUCION);
                pedido.agregarRegistroHistorial(" se ha iniciado el proceso de devolucion");
                System.out.println(" el pedido " + pedidoId + " ha sido marcado para devolucion");
            } else {
                System.out.println(" no se puede devolver el pedido que ya esta en reparto o fue entregado");
            }

        }

        else {

            System.out.println(" el pedido con este id" + pedidoId + " no se encontro");
        }
    }

    // ver el historial de un solo pedido

    public void verHistorialPedido(String pedidoId) {
        verPedido(pedidoId).ifPresent(pedido -> {
            System.out.println("historial del pedido " + pedidoId + " ---");
            System.out.println(" estado actual" + pedido.getEstado().getDescripcion());
            pedido.getHistorialEstaciones().forEach(registro -> System.out.println("-" + registro));
            System.out.println(" ------------------------------------------------ ");
        }

        );

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

    public List<Pedido> filtrarPedidosPorEstado(EstadoPedido estado) {
        return pedidos.values().stream()
                .filter(pedido -> pedido.getEstado() == estado)
                .collect(Collectors.toList());
    }

    public List<Pedido> obeterPedidosPorVencer() {

        LocalDate fechaLimite = LocalDate.now().plusDays(3);
        return pedidos.values().stream().filter(pedido -> pedido.getEstado() != EstadoPedido.ENTREGADO)
                .filter(pedido -> !pedido.getFechaMaximaDeReclamo().isAfter(fechaLimite))
                .collect(Collectors.toList());

    }

    public Map<Boolean, List<Pedido>> agruparPedidosPorDevolucion() {
        return pedidos.values().stream().collect(Collectors.partitioningBy(pedido -> pedido.isDevuelto()));

    }

}
