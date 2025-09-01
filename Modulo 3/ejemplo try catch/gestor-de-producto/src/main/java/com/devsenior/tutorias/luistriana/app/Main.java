package com.devsenior.tutorias.luistriana.app;

import com.devsenior.tutorias.luistriana.excepctions.ProductoExistente;
import com.devsenior.tutorias.luistriana.excepctions.ProductoNoEncontradoExcepcion;
import com.devsenior.tutorias.luistriana.model.Productos;
import com.devsenior.tutorias.luistriana.service.ProductosService;

public class Main {
  public static void main(String[] args) {
    System.out.println("Prueba del sistema de inventario");

    ProductosService servicio = new ProductosService();

    // Bloque para actualizar productos
    try {
      System.out.println("Inicializando inventario...");
      servicio.actualizaProductos(new Productos("camara", "Camara profesional", 24, 1500000, 10), 24);
      System.out.println("Inventario inicializado");
    } catch (ProductoNoEncontradoExcepcion e) {
      System.out.println("Error al actualizar producto: " + e.getMessage());
    }

    // Bloque para agregar un producto
    try {
      Productos nuevoProducto = new Productos("tablet", "Tablet de última generación", 50, 1200000, 15);
      servicio.addproducto(nuevoProducto);
      System.out.println("Producto agregado exitosamente");
    } catch (ProductoExistente e) {
      System.out.println("Error al agregar producto: " + e.getMessage());
    }

    // Bloque para buscar un producto
    try {
      Productos productoEncontrado = servicio.buscarProducto(24);
      System.out.println("Producto encontrado: " + productoEncontrado.getNombre());
    } catch (ProductoNoEncontradoExcepcion e) {
      System.out.println("Error al buscar producto: " + e.getMessage());
    }

    // Bloque para eliminar un producto
    try {
      servicio.eliminaProductos(24);
      System.out.println("Producto eliminado exitosamente");
    } catch (ProductoNoEncontradoExcepcion e) {
      System.out.println("Error al eliminar producto: " + e.getMessage());
    }
  }
}