
# Mapa del Repositorio

Este repositorio contiene varios proyectos de Java que demuestran diferentes conceptos y características del lenguaje.

## Estructura General

```
.
├── Modulo 3
│   ├── ejemplo try catch
│   ├── manejo de logs
│   └── practica-basica-junit5
├── modulo 4
│   ├── clase2-set-list
│   └── gestion-asientos-de-teatro
├── .gitignore
└── README.md
```

## Descripción de Módulos

### `Modulo 3`

Este módulo contiene tres proyectos de Java, cada uno enfocado en un tema específico.

#### 1. `ejemplo try catch`

Este proyecto demuestra el uso de bloques `try-catch` para el manejo de excepciones en Java.

- **`src/main/java/com/devsenior/tutorias/luistriana/`**: Contiene el código fuente de la aplicación.
  - **`app/Main.java`**: Clase principal que ejecuta la aplicación.
  - **`excepctions/`**: Clases de excepciones personalizadas.
    - `ProductoExistente.java`: Excepción para cuando un producto ya existe.
    - `ProductoNoEncontradoExcepcion.java`: Excepción para cuando un producto no se encuentra.
  - **`model/Productos.java`**: Clase que representa un producto.
  - **`service/ProductosService.java`**: Lógica de negocio para la gestión de productos.
- **`pom.xml`**: Archivo de configuración de Maven para el proyecto.

#### 2. `manejo de logs`

Este proyecto muestra cómo implementar un sistema de logs en una aplicación Java para registrar eventos y errores.

- **`src/main/java/com/devsenior/tutorias/luistriana/`**: Contiene el código fuente de la aplicación.
  - **`Main.java`**: Clase principal que ejecuta la aplicación.
  - **`model/cuenta.java`**: Clase que representa una cuenta bancaria.
  - **`service/cajero.java`**: Lógica de negocio para operaciones de cajero automático.
- **`pom.xml`**: Archivo de configuración de Maven para el proyecto.

#### 3. `practica-basica-junit5`

Este proyecto contiene ejemplos de pruebas unitarias utilizando JUnit 5.

- **`src/main/java/com/devsenior/tutorias/luistriana/`**: Contiene el código fuente de la aplicación.
  - **`Calculator.java`**: Clase con operaciones matemáticas básicas.
  - **`GestorDeTareas.java`**: Clase para gestionar una lista de tareas.
  - **`exceptions/tareaDuplicadaException.java`**: Excepción para cuando se intenta agregar una tarea duplicada.
  - **`service/GestorTareasService.java`**: Lógica de negocio para la gestión de tareas.
- **`src/test/java/com/devsenior/luistriana/`**: Contiene las pruebas unitarias.
  - **`calculatorTest.java`**: Pruebas para la clase `Calculator`.
  - **`GestorTareasTest.java`**: Pruebas para la clase `GestorDeTareas`.
- **`pom.xml`**: Archivo de configuración de Maven para el proyecto.

### `modulo 4`

Este módulo se enfoca en estructuras de datos en Java y su aplicación en un proyecto práctico.

#### 1. `clase2-set-list`

Este proyecto contiene ejemplos y ejercicios sobre el uso de las interfaces `Set` y `List` en Java, y sus implementaciones (`ArrayList`, `LinkedList`, `HashSet`, `LinkedHashSet`, `TreeSet`).

- **`src/main/java/com/devsenior/luistriana/`**: Contiene el código fuente.
  - **`ejerciciosbasicos/`**: Implementaciones de ejemplo para varias estructuras de datos.
  - **`List/`**: Ejercicios específicos para `List`.
  - **`set/`**: Ejercicios específicos for `Set`.

#### 2. `gestion-asientos-de-teatro`

Este es un proyecto práctico que simula la gestión de asientos en un teatro, aplicando conceptos de manejo de excepciones y estructuras de datos.

- **`src/main/java/com/devsenior/tutorias/luistriana/`**: Contiene el código fuente de la aplicación.
  - **`exceptions/`**: Clases de excepciones personalizadas para la gestión de asientos.
  - **`model/`**: Clases que modelan los asientos y sus estados.
  - **`service/Teatro.java`**: Lógica de negocio para la gestión del teatro.
  - **`Menu.java`**: Clase para la interacción con el usuario a través de un menú de consola.
  - **`Main.java`**: Clase principal que ejecuta la aplicación.

## Archivos Adicionales

- **`.gitignore`**: Especifica los archivos y directorios que Git debe ignorar.
- **`README.md`**: Este archivo, que proporciona una visión general del repositorio.
