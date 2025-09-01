package com.devsenior.tutorias.luistriana.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.devsenior.tutorias.luistriana.model.Productos;
import com.devsenior.tutorias.luistriana.excepctions.*;

public class ProductosService {
    private List<Productos> inventario;

    /**
     * Constructor que inicializa el inventario con una lista vacía
     * y carga algunos productos predeterminados.
     */
    public ProductosService() {
        this.inventario = new ArrayList<>();
        verInventario();
    }

    /**
     * Método para cargar productos predeterminados en el inventario.
     */
    public void verInventario() {
        inventario.add(new Productos("computador", "computador super potente pc gaming", 45, 2000000, 20));
        inventario.add(new Productos("celular", "iphone", 24, 6000000, 12));
        inventario.add(new Productos("reloj deportivo", "garmyn", 15, 1200000, 9));
    }

    /**
     * Agrega un producto al inventario.
     * 
     * @param producto El producto a agregar.
     * @return El producto agregado.
     * @throws ProductoExistente Si el producto ya existe en el inventario.
     */
    public Productos addproducto(Productos producto) throws ProductoExistente {
        if (inventario.contains(producto)) {
            throw new ProductoExistente("El producto ya existe en el inventario");
        }
        inventario.add(producto);
        System.out.println("El producto ha sido agregado con éxito");
        return producto;
    }

    /**
     * Busca un producto en el inventario por su ID.
     * 
     * @param id El ID del producto a buscar.
     * @return El producto encontrado.
     * @throws ProductoNoEncontradoExcepcion Si el producto no se encuentra en el inventario.
     */
    public Productos buscarProducto(int id) throws ProductoNoEncontradoExcepcion {
        Optional<Productos> productoEncontrado = inventario.stream()
                .filter(inventario -> inventario.getId() == id)
                .findFirst();

        if (productoEncontrado.isPresent()) {
            return productoEncontrado.get();
        } else {
            throw new ProductoNoEncontradoExcepcion("El producto no fue encontrado");
        }
    }

    /**
     * Devuelve una lista con todos los productos del inventario.
     * 
     * @return Una lista de productos.
     */
    public List<Productos> todosLosProductos() {
        return new ArrayList<>(inventario);
    }

    /**
     * Actualiza un producto en el inventario.
     * 
     * @param nuevoproducto El producto con los nuevos datos.
     * @param id            El ID del producto a actualizar.
     * @return El producto actualizado.
     * @throws ProductoNoEncontradoExcepcion Si el producto no se encuentra en el inventario.
     */
    public Productos actualizaProductos(Productos nuevoproducto, int id) throws ProductoNoEncontradoExcepcion {
        Optional<Productos> productoactualizar = inventario.stream()
                .filter(inventario -> inventario.getId() == id)
                .findFirst();

        if (productoactualizar.isPresent()) {
            Productos original = productoactualizar.get();

            original.setId(nuevoproducto.getId());
            original.setNombre(nuevoproducto.getNombre());
            original.setDescripcion(nuevoproducto.getDescripcion());
            original.setPrecio(nuevoproducto.getPrecio());
            original.setStock(nuevoproducto.getStock());
            return original;
        } else {
            throw new ProductoNoEncontradoExcepcion(
                    "El producto con el ID " + id + " no se puede actualizar porque no fue encontrado");
        }
    }

    /**
     * Elimina un producto del inventario por su ID.
     * 
     * @param id El ID del producto a eliminar.
     * @return El producto eliminado.
     * @throws ProductoNoEncontradoExcepcion Si el producto no se encuentra en el inventario.
     */
    public Productos eliminaProductos(int id) throws ProductoNoEncontradoExcepcion {
        Optional<Productos> productoEliminar = inventario.stream()
                .filter(inventario -> inventario.getId() == id)
                .findFirst();

        if (productoEliminar.isPresent()) {
            Productos productoEliminado = productoEliminar.get();
            inventario.remove(productoEliminado);
            System.out.println("El producto fue eliminado con éxito");
            return productoEliminado;
        } else {
            throw new ProductoNoEncontradoExcepcion("El producto con el ID " + id + " no fue encontrado");
        }
    }
}
