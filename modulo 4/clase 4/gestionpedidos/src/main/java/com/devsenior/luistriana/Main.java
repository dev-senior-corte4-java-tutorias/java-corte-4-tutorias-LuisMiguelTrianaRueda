package com.devsenior.luistriana;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.devsenior.luistriana.model.City;
import com.devsenior.luistriana.model.EstadoPedido;
import com.devsenior.luistriana.model.Pedido;
import com.devsenior.luistriana.service.Entrega;

public class Main {
    public static void main(String[] args) {
        Entrega entrega = new Entrega();
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("Bienvenido a tu paqueteria.com");
            System.out.println("1. Agregar un pedido");
            System.out.println("2. Eliminar un pedido");
            System.out.println("3. Actualizar un pedido");
            System.out.println("4. Buscar un pedido");
            System.out.println("5. Actualizar estado de un pedido");
            System.out.println("6. Procesar devolución de un pedido");
            System.out.println("7. Ver historial de un pedido");
            System.out.println("8. Ver pedidos por ciudad");
            System.out.println("9. Contar pedidos por ciudad");
            System.out.println("10. Verificar pedidos para un comprador");
            System.out.println("11. Filtrar pedidos por estado");
            System.out.println("12. Obtener pedidos por vencer");
            System.out.println("13. Agrupar pedidos por devolución");
            System.out.println("14. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el ID del pedido:");
                    String id = entrada.nextLine();
                    System.out.println("Ingrese el nombre del cliente:");
                    String cliente = entrada.nextLine();
                    System.out.println("Ingrese el producto:");
                    String producto = entrada.nextLine();
                    System.out.println("Ingrese la ciudad:");
                    String ciudad = entrada.nextLine();
                    System.out.println("Ingrese la dirección:");
                    String direccion = entrada.nextLine();
                    System.out.println("Ingrese el horario:");
                    String horario = entrada.nextLine();

                    City nuevaCiudad = new City(ciudad, direccion, horario);
                    Pedido nuevoPedido = new Pedido(id, cliente, producto, nuevaCiudad);
                    entrega.agregarPedido(nuevoPedido);
                    System.out.println("Pedido agregado exitosamente.");
                    break;

                case 2:
                    System.out.println("Ingrese el ID del pedido a eliminar:");
                    String idEliminar = entrada.nextLine();
                    entrega.eliminarPedido(idEliminar);
                    break;

                case 3:
                    System.out.println("Ingrese el ID del pedido a actualizar:");
                    String idActualizar = entrada.nextLine();
                    System.out.println("Ingrese el nuevo nombre del cliente:");
                    String nuevoCliente = entrada.nextLine();
                    System.out.println("Ingrese el nuevo producto:");
                    String nuevoProducto = entrada.nextLine();
                    System.out.println("Ingrese la nueva ciudad:");
                    String nuevaCiudadNombre = entrada.nextLine();
                    System.out.println("Ingrese la nueva dirección:");
                    String nuevaDireccion = entrada.nextLine();
                    System.out.println("Ingrese el nuevo horario:");
                    String nuevoHorario = entrada.nextLine();

                    City ciudadActualizada = new City(nuevaCiudadNombre, nuevaDireccion, nuevoHorario);
                    Pedido pedidoActualizado = new Pedido(idActualizar, nuevoCliente, nuevoProducto, ciudadActualizada);
                    entrega.actualizarPedido(pedidoActualizado);
                    break;

                case 4:
                    System.out.println("Ingrese el ID del pedido a buscar:");
                    String idBuscar = entrada.nextLine();
                    Pedido pedidoEncontrado = entrega.verPedido(idBuscar).orElse(null);
                    if (pedidoEncontrado != null) {
                        System.out.println("Pedido encontrado: " + pedidoEncontrado);
                    } else {
                        System.out.println("Pedido no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Ingrese el ID del pedido:");
                    String pedidoId = entrada.nextLine();
                    System.out.println("Ingrese el nuevo estado del pedido:");
                    for (EstadoPedido estado : EstadoPedido.values()) {
                        System.out.println("- " + estado.name() + ": " + estado.getDescripcion());
                    }
                    String estadoStr = entrada.nextLine();
                    EstadoPedido nuevoEstado = EstadoPedido.valueOf(estadoStr.toUpperCase());
                    System.out.println("Ingrese la estación:");
                    String estacion = entrada.nextLine();
                    entrega.actualizarEstadoPedido(pedidoId, nuevoEstado, estacion);
                    break;

                case 6:
                    System.out.println("Ingrese el ID del pedido a procesar devolución:");
                    String pedidoDevolucionId = entrada.nextLine();
                    entrega.procesarDevolucionPedido(pedidoDevolucionId);
                    break;

                case 7:
                    System.out.println("Ingrese el ID del pedido para ver su historial:");
                    String pedidoHistorialId = entrada.nextLine();
                    entrega.verHistorialPedido(pedidoHistorialId);
                    break;

                case 8:
                    System.out.println("Ingrese el nombre de la ciudad:");
                    String nombreCiudad = entrada.nextLine();
                    List<Pedido> pedidosCiudad = entrega.verPedidosPorCiudad(nombreCiudad);
                    pedidosCiudad.forEach(System.out::println);
                    break;

                case 9:
                    Map<String, Long> conteoPorCiudad = entrega.ContarPedidosPorciudad();
                    conteoPorCiudad
                            .forEach((ciudadNombre, cantidad) -> System.out.println(ciudadNombre + ": " + cantidad));
                    break;

                case 10:
                    System.out.println("Ingrese el nombre del comprador:");
                    String nombreComprador = entrada.nextLine();
                    boolean existePedido = entrega.existePedidoParaComprador(nombreComprador);
                    System.out.println("¿Existe pedido para el comprador? " + existePedido);
                    break;

                case 11:
                    System.out.println("Ingrese el estado del pedido para filtrar:");
                    for (EstadoPedido estado : EstadoPedido.values()) {
                        System.out.println("- " + estado.name() + ": " + estado.getDescripcion());
                    }
                    String estadoFiltroStr = entrada.nextLine();
                    EstadoPedido estadoFiltro = EstadoPedido.valueOf(estadoFiltroStr.toUpperCase());
                    List<Pedido> pedidosFiltrados = entrega.filtrarPedidosPorEstado(estadoFiltro);
                    pedidosFiltrados.forEach(System.out::println);
                    break;

                case 12:
                    List<Pedido> pedidosPorVencer = entrega.obeterPedidosPorVencer();
                    pedidosPorVencer.forEach(System.out::println);
                    break;

                case 13:
                    Map<Boolean, List<Pedido>> pedidosAgrupados = entrega.agruparPedidosPorDevolucion();
                    System.out.println("Pedidos devueltos:");
                    pedidosAgrupados.getOrDefault(true, List.of()).forEach(System.out::println);
                    System.out.println("Pedidos no devueltos:");
                    pedidosAgrupados.getOrDefault(false, List.of()).forEach(System.out::println);
                    break;

                case 14:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 14);

        entrada.close();
    }
}