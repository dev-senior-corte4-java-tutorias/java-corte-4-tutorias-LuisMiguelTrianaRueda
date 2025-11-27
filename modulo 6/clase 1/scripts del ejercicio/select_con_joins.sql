-- select con join 
/*
*
* INNER JOIN -> NOS MUESTRA LO QUE ESTA EN AMBAS TABLAS (INTERSECCION)
*/
-- cliente con su perfil (1:1)
SELECT c.nombre, c.email, p.direccion, p.telefono
FROM cliente c
INNER JOIN perfil p ON c.id = p.cliente_id;

/* demas joins
* INNER JOIN: solo lo que esta en ambas tablas (intersección)
 LEFT JOIN: todo de A + lo que coincide de B 
 RIGHT JOIN: todo de B + LO QUE COINCIDE DE A
 FULL JOIN: todo de ambas
*
*
*/
-- pedidos con un lciente 

SELECT c.nombre, pe.id AS pedido, pe.fecha
FROM cliente c
INNER JOIN pedido pe ON c.id = pe.cliente_id
WHERE c.id = 1;

-- detalle completo de los pedidos 
SELECT c.nombre AS cliente,
pe.fecha,
pr.nombre AS producto,
pp.cantidad,
(pr.precio * pp.cantidad) AS subtotal -- as es un alias que se le da a una operacion 
FROM pedido pe 
INNER JOIN cliente c ON pe.cliente_id = c.id
INNER JOIN pedido_producto pp ON pe.id = pp.pedido_id
INNER JOIN producto pr ON pp.producto_id = pr.id
ORDER BY pe.id;



