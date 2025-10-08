package com.devsenior.luistriana;

import java.util.Scanner;

import com.devsenior.luistriana.model.City;
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
            System.out.println("5. Salir");
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
                    System.out.println("Pedido eliminado exitosamente.");
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
                    System.out.println("Pedido actualizado exitosamente.");
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
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

        entrada.close();
    }
}