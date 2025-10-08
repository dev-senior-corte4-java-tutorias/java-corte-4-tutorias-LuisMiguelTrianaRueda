
# Explicación del Código

## `Main.java`

Esta clase es el punto de entrada de la aplicación. Contiene el método `main` que se encarga de mostrar un menú de opciones al usuario y de interactuar con las demás clases del sistema.

### Métodos

-   `main(String[] args)`: Este método, el corazón de la aplicación, inicializa un objeto `Entrega` para gestionar los pedidos y un `Scanner` para capturar la entrada del usuario. Presenta un menú interactivo que permite al usuario realizar las siguientes acciones:
    -   **Agregar un pedido**: Solicita al usuario los detalles del pedido (ID, cliente, producto, ciudad, dirección y horario), crea un nuevo objeto `Pedido` y lo agrega a la lista de entregas.
    -   **Eliminar un pedido**: Pide al usuario el ID del pedido que desea eliminar y lo elimina de la lista.
    -   **Actualizar un pedido**: Solicita el ID del pedido a actualizar y los nuevos datos, y actualiza la información del pedido correspondiente.
    -   **Buscar un pedido**: Pide el ID del pedido a buscar y muestra su información si se encuentra.
    -   **Salir**: Termina la ejecución del programa.
    El menú se repite hasta que el usuario elige la opción de salir.

## `model/City.java`

Esta clase representa una ciudad con sus direcciones y horarios de entrega.

### Atributos

-   `nombre`: El nombre de la ciudad.
-   `direcciones`: Las direcciones de entrega en la ciudad.
-   `horarios`: Los horarios de entrega en la ciudad.

### Métodos

-   `getNombre()`: Devuelve el nombre de la ciudad.
-   `getDirecciones()`: Devuelve las direcciones de la ciudad.
-   `setDirecciones(String direcciones)`: Establece las direcciones de la ciudad.
-   `getHorarios()`: Devuelve los horarios de la ciudad.
-   `setHorarios(String horarios)`: Establece los horarios de la ciudad.
-   `City(String nombre, String direcciones, String horarios)`: Constructor para inicializar un objeto `City` con el nombre, las direcciones y los horarios proporcionados.
-   `hashCode()`: Calcula el código hash del objeto basándose en el nombre de la ciudad, útil para comparaciones eficientes.
-   `equals(Object obj)`: Compara si dos objetos `City` son iguales, verificando que todos sus atributos (nombre, direcciones y horarios) coincidan.

## `model/Pedido.java`

Esta clase representa un pedido con su información de comprador, productos y ciudad de destino.

### Atributos

-   `id`: El identificador único del pedido.
-   `comprador`: El nombre del comprador.
-   `productos`: Los productos incluidos en el pedido.
-   `ciudadDeDestino`: La ciudad a la que se enviará el pedido.

### Métodos

-   `getId()`: Devuelve el ID del pedido.
-   `setId(String id)`: Establece el ID del pedido.
-   `getComprador()`: Devuelve el nombre del comprador.
-   `getProductos()`: Devuelve los productos del pedido.
-   `setProductos(String productos)`: Establece los productos del pedido.
-   `getCiudadDeDestino()`: Devuelve la ciudad de destino del pedido.
-   `setCiudadDeDestino(City ciudadDeDestino)`: Establece la ciudad de destino del pedido.
-   `Pedido(String id, String comprador, String productos, City ciudadDeDestino)`: Constructor para crear un nuevo objeto `Pedido` con todos sus datos.

## `service/Entrega.java`

Esta clase gestiona la lógica de negocio de los pedidos, como agregarlos, eliminarlos, actualizarlos y realizar búsquedas y filtros sobre ellos.

### Atributos

-   `ciudad`: Una lista de objetos `City`.
-   `pedidos`: Un mapa que almacena los pedidos, usando el ID del pedido como clave.

### Métodos

-   `Entrega()`: Constructor que inicializa la lista de ciudades y el mapa de pedidos.
-   `agregarPedido(Pedido pedido)`: Agrega un nuevo pedido al mapa. Si el pedido ya existe, muestra un mensaje indicándolo; de lo contrario, lo añade y confirma la acción.
-   `eliminarPedido(String id)`: Elimina un pedido del mapa usando su ID. Informa al usuario si la eliminación fue exitosa o si el pedido no se encontró.
-   `verPedido(String id)`: Busca un pedido por su ID y devuelve un `Optional<Pedido>`. Si el pedido se encuentra, el `Optional` contendrá el objeto `Pedido`; de lo contrario, estará vacío.
-   `actualizarPedido(Pedido pedido)`: Actualiza la información de un pedido existente. Si el pedido se encuentra, lo reemplaza con la nueva información; si no, informa que no se pudo actualizar.
-   `verPedidosPorCiudad(String nombreCiudad)`: Devuelve una lista de todos los pedidos que tienen como destino la ciudad especificada.
-   `ContarPedidosPorciudad()`: Cuenta cuántos pedidos hay para cada ciudad y devuelve un mapa donde la clave es el nombre de la ciudad y el valor es el número de pedidos.
-   `existePedidoParaComprador(String nombreComprador)`: Verifica si existe al menos un pedido para un comprador específico, devolviendo `true` si es así, y `false` en caso contrario.
