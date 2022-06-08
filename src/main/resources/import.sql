INSERT INTO clientes(id,nombre, apellido, correo, celular, create_at) VALUES(1,'Pepito', 'Pérez', 'pepito@gmail.com', '3005239011', '2028-03-05');
INSERT INTO clientes(id,nombre, apellido, correo, celular, create_at) VALUES(2, 'Juanita', 'Marín', 'jm@gmail.com', '3014247110', '2027-05-09');

INSERT INTO producto(id_producto,nombre, fecha, cantidad, precio_Venta, precio_Compra) VALUES(1,'Pan', '2022-05-19', 1, 2500, 2000);
INSERT INTO producto(id_producto,nombre, fecha, cantidad, precio_Venta, precio_Compra) VALUES(2, 'Leche', '2022-05-20', 2, 3200, 2500);

INSERT INTO encabezadoPedido(id_encabezado_pedido, id, fecha, celular_destino, direccion_destino, nombre_destino, subtotal, total, descuento, fecha_entrega, estado)
VALUES (1, 1, '2022-06-02', 3014247110, 'crr 46B # 56-13', 'Camila', 25000, 20000, 5000, '2022-06-07', 'pendiente');