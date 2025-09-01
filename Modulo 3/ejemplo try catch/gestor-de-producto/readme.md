# Gestor de Productos

## Descripción

Este es un sistema simple de gestión de inventario de productos desarrollado en Java. Permite realizar operaciones básicas como agregar, buscar, actualizar y eliminar productos del inventario.

## Características

- Agregar un nuevo producto al inventario.
- Buscar un producto por su ID.
- Actualizar la información de un producto existente.
- Eliminar un producto del inventario.
- Listar todos los productos existentes.

## Tecnologías

- Java 17
- Maven

## Cómo ejecutar el proyecto

1.  Clonar el repositorio: `git clone <URL_DEL_REPOSITORIO>`
2.  Navegar al directorio del proyecto: `cd gestor-de-producto`
3.  Compilar el proyecto con Maven: `mvn compile`
4.  Ejecutar la aplicación: `mvn exec:java -Dexec.mainClass="com.devsenior.tutorias.luistriana.app.Main"`

## Estructura del Proyecto

```
gestor-de-producto/
├── pom.xml
├── readme.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── devsenior/
    │   │           └── tutorias/
    │   │               └── luistriana/
    │   │                   ├── app/
    │   │                   │   └── Main.java
    │   │                   ├── excepctions/
    │   │                   │   ├── ProductoExistente.java
    │   │                   │   └── ProductoNoEncontradoExcepcion.java
    │   │                   ├── model/
    │   │                   │   └── Productos.java
    │   │                   └── service/
    │   │                       └── ProductosService.java
    │   └── resources/
    └── test/
        └── java/
```

## Clases y Responsabilidades

### `model.Productos`

Clase que representa el modelo de datos para un producto. Contiene los siguientes atributos:

-   `nombre`: Nombre del producto.
-   `descripcion`: Descripción del producto.
-   `id`: Identificador único del producto.
-   `precio`: Precio del producto.
-   `stock`: Cantidad de existencias del producto.

### `service.ProductosService`

Clase que contiene la lógica de negocio para la gestión de productos. Proporciona métodos para:

-   `addproducto(Productos producto)`: Agrega un producto al inventario.
-   `buscarProducto(int id)`: Busca un producto por su ID.
-   `todosLosProductos()`: Devuelve una lista con todos los productos.
-   `actualizaProductos(Productos nuevoproducto, int id)`: Actualiza un producto existente.
-   `eliminaProductos(int id)`: Elimina un producto del inventario.

### `excepctions.ProductoExistente`

Excepción personalizada que se lanza cuando se intenta agregar un producto que ya existe en el inventario.

### `excepctions.ProductoNoEncontradoExcepcion`

Excepción personalizada que se lanza cuando se intenta buscar, actualizar o eliminar un producto que no se encuentra en el inventario.

### `app.Main`

Clase principal que contiene el método `main` para ejecutar la aplicación y probar las funcionalidades del sistema de inventario.

## Explicación de Temas Vistos

El archivo `explicacion.ipynb` en la carpeta `explicacionTemasVistos` contiene una explicación detallada de los siguientes temas:

-   **`Optional`**: Qué es, por qué usarlo y cómo se utiliza en el proyecto.
-   **`Stream`**: Qué son, sus características y cómo se utilizan en el proyecto para procesar colecciones de datos de forma funcional.
