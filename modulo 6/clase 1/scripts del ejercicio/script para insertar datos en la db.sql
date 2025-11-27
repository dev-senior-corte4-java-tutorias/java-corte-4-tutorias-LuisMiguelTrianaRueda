-- dml insertando datos en la base de datos
-- insertar datos a mi tabla clientes
INSERT INTO cliente (nombre, email) VALUES
('Ana torres', 'ana@email.com'),
('edwin cante', 'edwin@hotmail.com');

-- insertamos en la tabla perfiles
INSERT INTO perfil (cliente_id, direccion, telefono) VALUES
(1, 'calle 10 #34-35', '555-444'),
(2, 'carrera 5 # 12-45', '555-333');

-- insertamos datos en la tabla producto
INSERT INTO producto (nombre, precio) VALUES
('laptop', 2500000),
('mouse', 75000),
('teclado', 150000);

-- pedidos 
INSERT INTO pedido(cliente_id, fecha) VALUES
(1, '2025-01-15'),
(2,'2025-02-23'),
(2, '2025-03-22');

-- DETALLE PEDIDOS (N:M)
INSERT INTO pedido_producto (pedido_id, producto_id, cantidad) VALUES
(1,1,1),
(1,2,2),
(2,3,1),
(3,2,3); 





