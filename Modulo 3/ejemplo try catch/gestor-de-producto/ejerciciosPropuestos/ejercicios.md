# Ejercicios Propuestos



## Ejercicio 1: Sistema de Gestión de Usuarios 👤

**Objetivo**: Crear un sistema simple para gestionar una lista de usuarios en memoria, manejando errores comunes como usuarios duplicados o no encontrados.

### Requisitos:

1. **Define la clase Usuario** con los atributos:
   - `id` (entero)
   - `nombre` (cadena)
   - `email` (cadena)

2. **Crea las siguientes excepciones personalizadas**:
   - `UsuarioYaExisteException`: Se lanzará al intentar crear un usuario con un `id` o `email` que ya existe.
   - `UsuarioNoEncontradoException`: Se lanzará al intentar leer, actualizar o eliminar un usuario que no existe.

3. **Implementa los métodos CRUD**:
   - **Crear (create)**: Añade un nuevo usuario a una lista.
     - **Lógica de error**: Antes de añadir, verifica si ya existe un usuario con el mismo `id` o `email`. Si es así, lanza `UsuarioYaExisteException`.
   - **Leer (read)**: Busca y devuelve un usuario por su `id`.
     - **Lógica de error**: Si no se encuentra ningún usuario con ese `id`, lanza `UsuarioNoEncontradoException`.
   - **Actualizar (update)**: Modifica el `nombre` o `email` de un usuario existente, buscado por `id`.
     - **Lógica de error**: Si el usuario no existe, lanza `UsuarioNoEncontradoException`.
   - **Eliminar (delete)**: Elimina un usuario de la lista por su `id`.
     - **Lógica de error**: Si el usuario a eliminar no se encuentra, lanza `UsuarioNoEncontradoException`.

4. **Prueba tu código**: Escribe un programa principal donde llames a cada método CRUD dentro de bloques `try-catch` para capturar y mostrar mensajes de error amigables para cada una de las excepciones personalizadas.

---

## Ejercicio 2: Inventario de Productos 📦

**Objetivo**: Simular la gestión del inventario de una tienda, controlando que los datos de los productos sean válidos y que no se puedan realizar operaciones sobre productos inexistentes.

### Requisitos:

1. **Define la clase Producto** con los atributos:
   - `sku` (cadena, como "TV-001")
   - `nombre` (cadena)
   - `precio` (decimal)
   - `cantidad` (entero)

2. **Crea las siguientes excepciones personalizadas**:
   - `ProductoNoEncontradoException`: Para operaciones sobre un `sku` que no está en el inventario.
   - `DatosInvalidosException`: Se lanzará si se intenta crear o actualizar un producto con un precio o cantidad negativos.

3. **Implementa los métodos CRUD** (puedes usar un diccionario o mapa para almacenar los productos, con el `sku` como clave):
   - **Crear (create)**: Agrega un nuevo producto al inventario.
     - **Lógica de error**: Lanza `DatosInvalidosException` si el precio o la cantidad son menores que cero. Si el `sku` ya existe, puedes lanzar una excepción genérica como `IllegalArgumentException` o crear una específica como `ProductoYaExisteException`.
   - **Leer (read)**: Obtiene la información de un producto a partir de su `sku`.
     - **Lógica de error**: Si el `sku` no existe, lanza `ProductoNoEncontradoException`.
   - **Actualizar (update)**: Actualiza el precio o la cantidad de un producto.
     - **Lógica de error**: Lanza `ProductoNoEncontradoException` si el `sku` no se encuentra. Lanza `DatosInvalidosException` si los nuevos valores de precio o cantidad son negativos.
   - **Eliminar (delete)**: Elimina un producto del inventario.
     - **Lógica de error**: Lanza `ProductoNoEncontradoException` si el `sku` no existe.

4. **Prueba tu código**: En tu programa principal, intenta agregar productos con datos incorrectos, buscar productos que no existen y actualizar productos con valores inválidos, asegurándote de que tus bloques `try-catch` gestionen correctamente cada error.

---

## Ejercicio 3: Lista de Tareas (To-Do List) ✅

**Objetivo**: Desarrollar un gestor de tareas que controle el estado de las mismas y valide las operaciones, como la creación de tareas sin descripción o la actualización a un estado no válido.

### Requisitos:

1. **Define la clase Tarea** con los atributos:
   - `id` (entero)
   - `descripcion` (cadena)
   - `estado` (cadena, que solo puede ser "pendiente", "en_progreso" o "completada")

2. **Crea las siguientes excepciones personalizadas**:
   - `TareaNoEncontradaException`: Para cuando se busca una tarea por un `id` que no existe.
   - `EstadoInvalidoException`: Si se intenta actualizar una tarea a un estado que no sea uno de los tres permitidos.
   - `DescripcionVaciaException`: Si se intenta crear una tarea con una descripción vacía o nula.

3. **Implementa los métodos CRUD**:
   - **Crear (create)**: Añade una nueva tarea a la lista (por defecto, en estado "pendiente").
     - **Lógica de error**: Si la descripción está vacía, lanza `DescripcionVaciaException`.
   - **Leer (read)**: Devuelve una tarea por su `id`.
     - **Lógica de error**: Si no existe, lanza `TareaNoEncontradaException`.
   - **Actualizar Estado (updateStatus)**: Cambia el estado de una tarea existente.
     - **Lógica de error**: Primero, verifica si la tarea existe; si no, lanza `TareaNoEncontradaException`. Luego, valida que el nuevo estado sea uno de los permitidos ("pendiente", "en_progreso", "completada"); si no lo es, lanza `EstadoInvalidoException`.
   - **Eliminar (delete)**: Borra una tarea de la lista.
     - **Lógica de error**: Si la tarea no se encuentra, lanza `TareaNoEncontradaException`.

4. **Prueba tu código**: Realiza pruebas que fuercen cada una de las excepciones: crea una tarea sin descripción, actualiza una tarea a un estado como "cancelada" y busca una tarea con un `id` inexistente. Maneja cada caso con bloques `try-catch`.