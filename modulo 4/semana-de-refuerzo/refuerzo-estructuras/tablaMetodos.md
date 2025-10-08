## Arrays

| **Operación**         | **Descripción (Qué hace)**                                   |
|-----------------------|-------------------------------------------------------------|
| `miArray[indice]`     | Accede al elemento en la posición `indice`.                 |
| `miArray[indice] = valor` | Asigna un valor a la posición `indice`.                   |
| `miArray.length`      | Devuelve el tamaño total (capacidad) del array. Es una propiedad, no un método. |

---

## List (ArrayList/LinkedList)

| **Método**            | **Descripción (Qué hace)**                                   |
|-----------------------|-------------------------------------------------------------|
| `add(elemento)`       | Añade un elemento al final de la lista.                     |
| `add(indice, elemento)` | Inserta un elemento en la posición `indice`.               |
| `get(indice)`         | Devuelve el elemento en la posición `indice`.               |
| `remove(indice)`      | Elimina el elemento en la posición `indice`.                |
| `remove(objeto)`      | Elimina la primera ocurrencia del objeto especificado.      |
| `set(indice, elemento)` | Reemplaza el elemento en la posición `indice` por el nuevo elemento. |
| `size()`              | Devuelve el número de elementos en la lista.               |
| `contains(objeto)`    | Devuelve `true` si la lista contiene el objeto.             |
| `indexOf(objeto)`     | Devuelve el índice de la primera aparición del objeto, o `-1` si no existe. |
| `isEmpty()`           | Devuelve `true` si la lista está vacía.                     |
| `clear()`             | Elimina todos los elementos de la lista.                   |

---

## Set (HashSet/TreeSet/LinkedHashSet)

| **Método**            | **Descripción (Qué hace)**                                   |
|-----------------------|-------------------------------------------------------------|
| `add(elemento)`       | Añade un elemento. Devuelve `false` si el elemento ya existe (no lo añade). |
| `remove(objeto)`      | Elimina el objeto del conjunto.                             |
| `contains(objeto)`    | Devuelve `true` si el conjunto contiene el objeto. Es una operación muy rápida. |
| `size()`              | Devuelve el número de elementos en el conjunto.            |
| `isEmpty()`           | Devuelve `true` si el conjunto está vacío.                 |
| `clear()`             | Elimina todos los elementos del conjunto.                  |

---

## Map (HashMap / TreeMap)

| **Método**            | **Descripción (Qué hace)**                                   |
|-----------------------|-------------------------------------------------------------|
| `put(clave, valor)`   | Asocia una clave a un valor. Si la clave ya existe, reemplaza el valor anterior. |
| `get(clave)`          | Devuelve el valor asociado a la clave, o `null` si no existe. |
| `remove(clave)`       | Elimina el par clave-valor asociado a la clave.             |
| `containsKey(clave)`  | Devuelve `true` si el mapa contiene la clave.               |
| `containsValue(valor)`| Devuelve `true` si el mapa contiene el valor.              |
| `size()`              | Devuelve el número de pares clave-valor.                   |
| `keySet()`            | Devuelve un `Set` con todas las claves del mapa.           |
| `values()`            | Devuelve una `Collection` con todos los valores del mapa.  |
| `entrySet()`          | Devuelve un `Set` de `Map.Entry` (pares clave-valor).      |
| `isEmpty()`           | Devuelve `true` si el mapa está vacío.                     |
| `clear()`             | Elimina todos los pares del mapa.                          |

---

## Stack (Pilas)

| **Método**            | **Descripción (Qué hace)**                                   |
|-----------------------|-------------------------------------------------------------|
| `push(elemento)`      | Añade un elemento a la cima de la pila.                     |
| `pop()`               | Elimina y devuelve el elemento de la cima de la pila.       |
| `peek()`              | Devuelve el elemento de la cima de la pila sin eliminarlo.  |
| `empty()`             | Devuelve `true` si la pila está vacía.                     |
| `search(objeto)`      | Busca un objeto y devuelve su distancia desde la cima (`1` si está en la cima). |

---

## Queue (Colas)

| **Operación**         | **Método que Lanza Excepción** | **Método que Devuelve null/false** | **Descripción (Qué hace)** |
|-----------------------|--------------------------------|------------------------------------|----------------------------|
| Añadir                | `add(e)`                      | `offer(e)`                        | Inserta un elemento al final de la cola. |
| Eliminar              | `remove()`                    | `poll()`                          | Elimina y devuelve el elemento al principio de la cola. |
| Examinar              | `element()`                   | `peek()`                          | Devuelve el elemento al principio de la cola sin eliminarlo. |