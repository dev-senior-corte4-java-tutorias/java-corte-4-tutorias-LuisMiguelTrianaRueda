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
│   ├── clase 1
│   │   └── gestion-asientos-de-teatro
│   ├── clase 2
│   │   └── clase2-set-list
│   ├── clase 3
│   │   └── melodi-music-tutoria
│   ├── clase 4
│   │   └── gestionpedidos
│   └── semana-de-refuerzo
│       └── refuerzo-estructuras
├── modulo 5
│   └── Clase1
│       └── tutoria1documentacion
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

Este módulo se enfoca en el manejo de colecciones en Java, incluyendo `List`, `Set` y `Map`. A través de varios proyectos, se exploran las características y usos de estas estructuras de datos.

#### 1. `clase 1/gestion-asientos-de-teatro`

Este es un proyecto práctico que simula la gestión de asientos en un teatro, aplicando conceptos de manejo de excepciones y estructuras de datos.

- **`src/main/java/com/devsenior/tutorias/luistriana/`**: Contiene el código fuente de la aplicación.
  - **`exceptions/`**: Clases de excepciones personalizadas para la gestión de asientos.
  - **`model/`**: Clases que modelan los asientos y sus estados.
  - **`service/Teatro.java`**: Lógica de negocio para la gestión del teatro.
  - **`Menu.java`**: Clase para la interacción con el usuario a través de un menú de consola.
  - **`Main.java`**: Clase principal que ejecuta la aplicación.

#### 2. `clase 2/clase2-set-list`

Este proyecto contiene ejemplos y ejercicios sobre el uso de las interfaces `Set` y `List` en Java, y sus implementaciones (`ArrayList`, `LinkedList`, `HashSet`, `LinkedHashSet`, `TreeSet`).

- **`src/main/java/com/devsenior/luistriana/`**: Contiene el código fuente.
  - **`ejerciciosbasicos/`**: Implementaciones de ejemplo para varias estructuras de datos.
  - **`List/`**: Ejercicios específicos para `List`.
  - **`set/`**: Ejercicios específicos for `Set`.

#### 3. `clase 3/melodi-music-tutoria`

Este proyecto simula una biblioteca de música donde los usuarios pueden gestionar canciones y playlists.

- **`src/main/java/com/devsenior/tutorias/luistriana/`**: Contiene el código fuente de la aplicación.
  - **`model/`**: Clases que modelan las canciones, playlists y usuarios.
    - `Canciones.java`
    - `Playlists.java`
    - `Usuarios.java`
  - **`service/bibliotecaMusical.java`**: Lógica de negocio para la gestión de la biblioteca musical.
  - **`Main.java`**: Clase principal que ejecuta la aplicación.

#### 4. `clase 4/gestionpedidos`

Este proyecto es una aplicación de consola para gestionar pedidos. Permite agregar, eliminar, actualizar y buscar pedidos.

- **`src/main/java/com/devsenior/luistriana/`**: Contiene el código fuente de la aplicación.
    - **`model/`**: Clases que modelan los pedidos y las ciudades.
        - `Pedido.java`
        - `City.java`
    - **`service/Entrega.java`**: Lógica de negocio para la gestión de entregas.
    - **`Main.java`**: Clase principal que ejecuta la aplicación.

#### 5. `semana-de-refuerzo/refuerzo-estructuras`

Este proyecto contiene material de referencia y ejemplos sobre las principales estructuras de datos en Java.

- **`tablaMetodos.md`**: Un archivo markdown con tablas que resumen los métodos más comunes de `Arrays`, `Lists`, `Sets`, `Maps`, `Stacks` y `Queues`.
- **`src/main/java/com/devsenior/luistriana/`**: Contiene ejemplos de código para cada estructura de datos.

### `modulo 5`

Este módulo introduce el desarrollo de aplicaciones web con **Spring Boot**, explorando conceptos fundamentales de este framework para construir APIs REST y servicios web empresariales.

#### 1. `Clase1/tutoria1documentacion`

Este es un proyecto inicial de Spring Boot que implementa un menú de documentación interactivo a través de endpoints REST. El proyecto demuestra conceptos básicos de Spring Boot como inyección de dependencias, controladores REST, y servicios.

- **Tecnologías utilizadas**:
  - Spring Boot 3.5.6
  - Java 21
  - Spring Web (para crear APIs REST)
  - Spring DevTools (para desarrollo)

- **`src/main/java/com/devsenior/luistriana/tutoria1documentacion/`**: Contiene el código fuente de la aplicación.
  - **`controller/menuController.java`**: Controlador REST que expone endpoints para interactuar con el menú de documentación.
    - `GET /menu/bienvenida`: Endpoint de bienvenida personalizado con parámetros.
    - `GET /menu/introduccion`: Retorna una introducción a Spring Boot.
    - `GET /menu/concepto/{concepto}`: Explica conceptos clave (IOC, Bean, MVC, REST).
    - `GET /menu/starter/{starter}`: Información sobre starters de Spring Boot.
    - `POST /menu/starter/comentario`: Permite agregar comentarios sobre starters.
  - **`service/MenuService.java`**: Capa de servicio con la lógica de negocio que gestiona:
    - Saludos de bienvenida personalizados
    - Explicaciones de conceptos de Spring Boot (IoC, Beans, MVC, REST)
    - Información sobre Spring Boot Starters (web, devtools)
    - Sistema de comentarios por starter
    - Glosario de términos de Spring Boot
  - **`Tutoria1documentacionApplication.java`**: Clase principal que inicia la aplicación Spring Boot.

**Conceptos aprendidos**:
- Estructura básica de un proyecto Spring Boot
- Patrón MVC en Spring
- Anotaciones: `@RestController`, `@Service`, `@GetMapping`, `@PostMapping`, `@PathVariable`, `@RequestParam`, `@RequestBody`, `@Autowired`
- Inyección de dependencias
- Creación de APIs REST
- Manejo de parámetros de ruta y query
- Procesamiento de datos JSON

## Archivos Adicionales

- **`.gitignore`**: Especifica los archivos y directorios que Git debe ignorar.
- **`README.md`**: Este archivo, que proporciona una visión general del repositorio.