/* script para crear todas las tablas
* por atomicidad de los datos crear en un solo script las tablas
*
*
*/
--1 cliente 
CREATE TABLE cliente (
-- dentro de los parentesis se colocan las columnas
id SERIAL PRIMARY KEY, -- SERIAL ES AUTO GENERADO OSEA LO MANEJA LA DB 
nombre VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL
);

--2 PERFIL (1:1 cliente )
CREATE TABLE perfil (
Id SERIAL PRIMARY KEY, -- COLUMNA
cliente_id INTEGER UNIQUE NOT NULL, --COLUMNA 
direccion VARCHAR(200),-- COLUMNA 
telefono VARCHAR(15), -- COLUMNA 
-- LLAVE FORANEA
FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE 
/* ON DELETE CASCADE -> se encarga de que cuando nosotros borremos nuestra tabla padre
* osea -> cliente AUTOMATICAMENTE se borren todos sus registros hijos
*
*/
);
-- 3 tabla producto (es una tabla padre osea independiente)
CREATE TABLE producto (
id SERIAL PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
precio DECIMAL(10,2) NOT NULL
);

-- 4 TABLA PEDIDO (1:N con cliente)
CREATE TABLE pedido(
id SERIAL primary KEY,
cliente_id INTEGER NOT NULL,
fecha DATE DEFAULT CURRENT_DATE,
FOREIGN KEY (cliente_id) REFERENCES cliente(id) 
);
-- 5. pedido_producto (N:M)
CREATE TABLE pedido_producto (
pedido_id INTEGER,
producto_id InTEGER,
cantidad INTEGER NOT NULL DEFAULT 1,
PRIMARY KEY (pedido_id, producto_id),
FOREIGN KEY (pedido_id) REFERENCES pedido(id) ON DELETE CASCADE,
FOREIGN KEY (producto_id) REFERENCES producto(id) ON DELETE CASCADE
);
