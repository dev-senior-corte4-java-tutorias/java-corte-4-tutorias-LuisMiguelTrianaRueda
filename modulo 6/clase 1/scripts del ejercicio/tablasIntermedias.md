# Tablas Intermedias - Relaciones N:M (Muchos a Muchos)

## Que son las Tablas Intermedias

Las tablas intermedias son tablas especiales que se utilizan para resolver las **relaciones Muchos a Muchos (N:M)** entre dos entidades en una base de datos relacional.

## Por que se necesitan

En bases de datos relacionales NO podemos crear directamente una relacion N:M entre dos tablas. Por ejemplo:

- Un **pedido** puede tener **multiples productos**
- Un **producto** puede estar en **multiples pedidos**

Si intentamos crear esta relacion directamente, tendriamos problemas de redundancia y normalizacion.

## Como funcionan

La tabla intermedia actua como un "puente" entre las dos tablas principales, convirtiendo una relacion N:M en dos relaciones 1:N.

### Estructura basica

```sql
CREATE TABLE tabla_intermedia (
    tabla_a_id INTEGER,
    tabla_b_id INTEGER,
    -- Campos adicionales (opcional)
    PRIMARY KEY (tabla_a_id, tabla_b_id),
    FOREIGN KEY (tabla_a_id) REFERENCES tabla_a(id),
    FOREIGN KEY (tabla_b_id) REFERENCES tabla_b(id)
);
```

## Ejemplo del Sistema de Pedidos

En nuestro sistema, la tabla `pedido_producto` es la tabla intermedia:

```sql
CREATE TABLE pedido_producto (
    pedido_id INTEGER,
    producto_id INTEGER,
    cantidad INTEGER NOT NULL DEFAULT 1,
    PRIMARY KEY (pedido_id, producto_id),
    FOREIGN KEY (pedido_id) REFERENCES pedido(id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES producto(id) ON DELETE CASCADE
);
```

### Componentes clave:

1. **Claves foraneas**: `pedido_id` y `producto_id` referencian las tablas principales
2. **Clave primaria compuesta**: La combinacion de ambos IDs forma la clave primaria
3. **Campos adicionales**: `cantidad` almacena informacion especifica de la relacion
4. **ON DELETE CASCADE**: Si se elimina un pedido o producto, se eliminan los registros relacionados

## Representacion Visual

```
PEDIDO                 PEDIDO_PRODUCTO              PRODUCTO
+--------+             +-----------+-----------+     +--------+
| id (1) |<----------->| pedido_id | producto_id|<-->| id (1) |
| fecha  |     N:M     | cantidad  |            | M:1| nombre |
+--------+             +-----------+-----------+     | precio |
                                                     +--------+

Relacion N:M convertida en:
- PEDIDO (1) ---- (N) PEDIDO_PRODUCTO
- PRODUCTO (1) --- (N) PEDIDO_PRODUCTO
```

## Ejemplo de Datos

**Tabla: pedido**
| id | cliente_id | fecha      |
|----|------------|------------|
| 1  | 1          | 2025-01-15 |
| 2  | 2          | 2025-02-23 |

**Tabla: producto**
| id | nombre  | precio  |
|----|---------|---------|
| 1  | Laptop  | 2500000 |
| 2  | Mouse   | 75000   |
| 3  | Teclado | 150000  |

**Tabla: pedido_producto** (INTERMEDIA)
| pedido_id | producto_id | cantidad |
|-----------|-------------|----------|
| 1         | 1           | 1        |
| 1         | 2           | 2        |
| 2         | 3           | 1        |

Esto significa:
- El pedido 1 tiene: 1 Laptop y 2 Mouse
- El pedido 2 tiene: 1 Teclado
- La Laptop esta en el pedido 1
- El Mouse esta en el pedido 1
- El Teclado esta en el pedido 2

## Como usar las Tablas Intermedias

### 1. Insertar relaciones

```sql
-- Agregar productos al pedido 1
INSERT INTO pedido_producto (pedido_id, producto_id, cantidad) VALUES
(1, 1, 1),  -- 1 Laptop
(1, 2, 2);  -- 2 Mouse
```

### 2. Consultar datos relacionados

**Obtener todos los productos de un pedido:**
```sql
SELECT pr.nombre, pp.cantidad, pr.precio
FROM pedido_producto pp
INNER JOIN producto pr ON pp.producto_id = pr.id
WHERE pp.pedido_id = 1;
```

**Obtener detalle completo (pedido + cliente + productos):**
```sql
SELECT c.nombre AS cliente,
       pe.fecha,
       pr.nombre AS producto,
       pp.cantidad,
       (pr.precio * pp.cantidad) AS subtotal
FROM pedido pe
INNER JOIN cliente c ON pe.cliente_id = c.id
INNER JOIN pedido_producto pp ON pe.id = pp.pedido_id
INNER JOIN producto pr ON pp.producto_id = pr.id
WHERE pe.id = 1;
```

### 3. Actualizar relaciones

```sql
-- Cambiar la cantidad de un producto en un pedido
UPDATE pedido_producto
SET cantidad = 5
WHERE pedido_id = 1 AND producto_id = 2;
```

### 4. Eliminar relaciones

```sql
-- Eliminar un producto especifico de un pedido
DELETE FROM pedido_producto
WHERE pedido_id = 1 AND producto_id = 2;

-- ON DELETE CASCADE eliminara automaticamente las relaciones
-- si eliminamos un pedido o producto padre
DELETE FROM pedido WHERE id = 1;
```

## Ventajas de las Tablas Intermedias

1. **Normalizacion**: Evita redundancia de datos
2. **Flexibilidad**: Permite relaciones complejas entre entidades
3. **Informacion adicional**: Puede almacenar datos especificos de la relacion (como cantidad, fecha, precio)
4. **Integridad**: Mantiene la consistencia mediante claves foraneas
5. **Escalabilidad**: Facil agregar o quitar relaciones sin afectar las tablas principales

## Casos de Uso Comunes

- **Estudiantes - Cursos**: Un estudiante puede tomar multiples cursos, un curso tiene multiples estudiantes
- **Productos - Pedidos**: Como en nuestro ejemplo
- **Autores - Libros**: Un libro puede tener multiples autores, un autor puede escribir multiples libros
- **Usuarios - Roles**: Un usuario puede tener multiples roles, un rol puede asignarse a multiples usuarios
- **Peliculas - Actores**: Una pelicula tiene multiples actores, un actor participa en multiples peliculas

## Reglas Importantes

1. La clave primaria compuesta DEBE incluir las dos claves foraneas
2. No puede haber registros duplicados (misma combinacion de IDs)
3. Los campos adicionales deben ser especificos de la RELACION, no de las entidades
4. Usar nombres descriptivos: `tabla1_tabla2` o `detalle_tabla1`
5. Considerar ON DELETE CASCADE segun las reglas de negocio

## Ejemplo Completo: Sistema Estudiante-Curso

```sql
-- Tabla estudiante (independiente)
CREATE TABLE estudiante (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- Tabla curso (independiente)
CREATE TABLE curso (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    creditos INTEGER
);

-- Tabla intermedia (N:M)
CREATE TABLE estudiante_curso (
    estudiante_id INTEGER,
    curso_id INTEGER,
    fecha_inscripcion DATE DEFAULT CURRENT_DATE,
    calificacion DECIMAL(3,2),
    PRIMARY KEY (estudiante_id, curso_id),
    FOREIGN KEY (estudiante_id) REFERENCES estudiante(id) ON DELETE CASCADE,
    FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE
);

-- Insertar datos
INSERT INTO estudiante (nombre, email) VALUES
('Juan Perez', 'juan@email.com'),
('Maria Lopez', 'maria@email.com');

INSERT INTO curso (nombre, creditos) VALUES
('Bases de Datos', 3),
('Programacion', 4);

-- Inscribir estudiantes en cursos
INSERT INTO estudiante_curso (estudiante_id, curso_id) VALUES
(1, 1),  -- Juan toma Bases de Datos
(1, 2),  -- Juan toma Programacion
(2, 1);  -- Maria toma Bases de Datos

-- Consultar que cursos toma Juan
SELECT c.nombre, c.creditos, ec.fecha_inscripcion
FROM estudiante_curso ec
INNER JOIN curso c ON ec.curso_id = c.id
WHERE ec.estudiante_id = 1;
```

---

**Resumen**: Las tablas intermedias son fundamentales para manejar relaciones N:M en bases de datos relacionales, permitiendo flexibilidad, normalizacion e integridad de datos.
