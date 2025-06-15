--CLIENTE

-- CLIENTE (con ubicaciones en Santiago de Chile)
INSERT INTO CLIENTE (nombre, direccion, correo, password, ubicacion_cliente) VALUES
('Antonio Torres', 'Av. Apoquindo 3000, Las Condes', 'cliente1@example.com', 'password1', ST_SetSRID(ST_MakePoint(-70.5667, -33.4167), 4326)),
('Laura Sánchez', 'Av. Vicuña Mackenna 4860, Macul', 'cliente2@example.com', 'password2', ST_SetSRID(ST_MakePoint(-70.6101, -33.4978), 4326)),
('José Martínez', 'Calle San Pablo 1450, Santiago Centro', 'cliente3@example.com', 'password3', ST_SetSRID(ST_MakePoint(-70.6667, -33.4372), 4326)),
('Elena Ruiz', 'Av. La Florida 7890, La Florida', 'cliente4@example.com', 'password4', ST_SetSRID(ST_MakePoint(-70.5726, -33.5226), 4326)),
('Carlos López', 'Av. Independencia 1020, Independencia', 'cliente5@example.com', 'password5', ST_SetSRID(ST_MakePoint(-70.6415, -33.4186), 4326)),
('María Gómez', 'Av. Pajaritos 2540, Maipú', 'cliente6@example.com', 'password6', ST_SetSRID(ST_MakePoint(-70.7569, -33.4828), 4326)),
('Miguel Díaz', 'Camino a Melipilla 13700, Padre Hurtado', 'cliente7@example.com', 'password7', ST_SetSRID(ST_MakePoint(-70.8272, -33.5601), 4326)),
('Sara Romero', 'Av. Grecia 2001, Ñuñoa', 'cliente8@example.com', 'password8', ST_SetSRID(ST_MakePoint(-70.5983, -33.4648), 4326)),
('David Navarro', 'Av. Departamental 4500, San Miguel', 'cliente9@example.com', 'password9', ST_SetSRID(ST_MakePoint(-70.6220, -33.4956), 4326)),
('Lucía Ortega', 'Av. Kennedy 6800, Vitacura', 'cliente10@example.com', 'password10', ST_SetSRID(ST_MakePoint(-70.5673, -33.3832), 4326));

-- EMPRESA_ASOCIADA con ubicaciones en Santiago de Chile
INSERT INTO EMPRESA_ASOCIADA (id_empresa_asociada, nombre, ubicacion_empresa_asociada) VALUES
(1, 'RapidExpress', ST_SetSRID(ST_MakePoint(-70.6410, -33.4489), 4326)),  -- Santiago Centro
(2, 'SuperDelivery', ST_SetSRID(ST_MakePoint(-70.6150, -33.4562), 4326)), -- Providencia
(3, 'Logística RM', ST_SetSRID(ST_MakePoint(-70.5720, -33.4497), 4326)),  -- Ñuñoa
(4, 'Entregas Ya', ST_SetSRID(ST_MakePoint(-70.6834, -33.5161), 4326)),   -- Maipú
(5, 'KargoGo', ST_SetSRID(ST_MakePoint(-70.5402, -33.5081), 4326));       -- La Reina

-- DETALLE_PEDIDO
INSERT INTO DETALLE_PEDIDO (entregado, hora_entrega, calificacion) VALUES
(TRUE,  '2025-04-10 10:00:00', NULL),
(FALSE, '2025-04-12 15:30:00', NULL),
(TRUE,  '2025-04-15 11:15:00', NULL),
(TRUE,  '2025-04-18 09:45:00', NULL),
(FALSE, '2025-04-21 13:20:00', NULL),
(TRUE,  '2025-04-25 17:00:00', NULL),
(FALSE, '2025-04-28 12:30:00', NULL),
(TRUE,  '2025-05-02 14:00:00', NULL),
(TRUE,  '2025-05-05 16:45:00', NULL),
(FALSE, '2025-05-08 18:15:00', NULL);

-- MEDIO_PAGO
INSERT INTO MEDIO_PAGO (id_medio_pago, tipo) VALUES
(1, 'Tarjeta'),
(2, 'Efectivo'),
(3, 'Transferencia'),
(4, 'PayPal');

-- CATEGORIA
INSERT INTO CATEGORIA (id_categoria, nombre) VALUES
(1, 'Comida'),
(2, 'Tecnología'),
(3, 'Ropa'),
(4, 'Hogar'),
(5, 'Juguetes');

-- URGENCIA
INSERT INTO URGENCIA (id_urgencia, tipo) VALUES
(1, 'Alta'),
(2, 'Media'),
(3, 'Baja');

-- REPARTIDOR (con ubicación y distancia recorrida en Santiago de Chile)
INSERT INTO REPARTIDOR (id_repartidor, nombre, id_empresa_asociada, ubicacion_repartidor, distancia_recorrida) VALUES
(1, 'Juan López', 1, ST_SetSRID(ST_MakePoint(-70.6483, -33.4569), 4326), 120.50),
(2, 'María Pérez', 2, ST_SetSRID(ST_MakePoint(-70.5954, -33.4571), 4326), 98.20),
(3, 'Carlos Ruiz', 3, ST_SetSRID(ST_MakePoint(-70.6664, -33.4370), 4326), 142.75),
(4, 'Ana Gómez', 4, ST_SetSRID(ST_MakePoint(-70.6800, -33.5090), 4326), 87.40),
(5, 'Luis Martínez', 5, ST_SetSRID(ST_MakePoint(-70.6050, -33.4698), 4326), 110.30),
(6, 'Carmen Sánchez', 1, ST_SetSRID(ST_MakePoint(-70.5820, -33.5215), 4326), 76.90),
(7, 'Pedro Díaz', 2, ST_SetSRID(ST_MakePoint(-70.7270, -33.5168), 4326), 134.10),
(8, 'Lucía Romero', 3, ST_SetSRID(ST_MakePoint(-70.6795, -33.4321), 4326), 100.00),
(9, 'Jorge Ortega', 4, ST_SetSRID(ST_MakePoint(-70.5802, -33.4487), 4326), 119.80),
(10, 'Elena Navarro', 5, ST_SetSRID(ST_MakePoint(-70.6232, -33.4853), 4326), 95.60);

-- PRODUCTO_SERVICIO
INSERT INTO PRODUCTO_SERVICIO (id_producto_servicio, stock, precio, id_categoria, id_empresa_asociada, es_producto) VALUES
(1,  50,  25.99, 1, 1, TRUE),
(2,  40, 199.99, 2, 2, TRUE),
(3, 100,  15.00, 3, 3, TRUE),
(4,  20,  89.50, 4, 4, TRUE),
(5,  70,  12.75, 5, 5, TRUE),
(6,  60,   9.99, 1, 1, TRUE),
(7,  80, 150.00, 2, 2, TRUE),
(8,  30,  45.25, 3, 3, TRUE),
(9,  90,  30.00, 4, 4, TRUE),
(10,100,   8.00, 5, 5, TRUE),
(11, 0, 120.00, 2, 2, FALSE);  

-- PEDIDO con ubicacion_entrega y ruta_estimada (simulada)
INSERT INTO PEDIDO (
    hora_pedido, id_urgencia, id_detalle_pedido, id_repartidor, 
    id_cliente, id_medio_pago, ubicacion_entrega, ruta_estimada
) VALUES
('2024-03-01 09:00:00', 1, 1, 1, 1, 1,
    ST_SetSRID(ST_MakePoint(-70.6400, -33.4450), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.6410, -33.4489), -- Empresa 1 (RapidExpress)
        ST_MakePoint(-70.6400, -33.4450)  -- Entrega
    ]), 4326)
),
('2024-03-02 14:00:00', 2, 2, 2, 2, 2,
    ST_SetSRID(ST_MakePoint(-70.6120, -33.4600), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.6150, -33.4562), -- Empresa 2 (SuperDelivery)
        ST_MakePoint(-70.6120, -33.4600)
    ]), 4326)
),
('2024-03-03 10:30:00', 3, 3, 3, 3, 3,
    ST_SetSRID(ST_MakePoint(-70.5700, -33.4520), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.5720, -33.4497), -- Empresa 3 (Logística RM)
        ST_MakePoint(-70.5700, -33.4520)
    ]), 4326)
),
('2024-03-04 08:45:00', 1, 4, 4, 4, 4,
    ST_SetSRID(ST_MakePoint(-70.6800, -33.5190), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.6834, -33.5161), -- Empresa 4 (Entregas Ya)
        ST_MakePoint(-70.6800, -33.5190)
    ]), 4326)
),
('2024-03-05 12:15:00', 2, 5, 5, 5, 1,
    ST_SetSRID(ST_MakePoint(-70.5370, -33.5100), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.5402, -33.5081), -- Empresa 5 (KargoGo)
        ST_MakePoint(-70.5370, -33.5100)
    ]), 4326)
),
('2024-03-06 11:20:00', 3, 1, 6, 6, 2,
    ST_SetSRID(ST_MakePoint(-70.6430, -33.4430), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.6410, -33.4489),
        ST_MakePoint(-70.6430, -33.4430)
    ]), 4326)
),
('2024-03-07 16:10:00', 1, 2, 7, 7, 3,
    ST_SetSRID(ST_MakePoint(-70.6170, -33.4580), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.6150, -33.4562),
        ST_MakePoint(-70.6170, -33.4580)
    ]), 4326)
),
('2024-03-08 17:05:00', 2, 3, 8, 8, 4,
    ST_SetSRID(ST_MakePoint(-70.5750, -33.4500), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.5720, -33.4497),
        ST_MakePoint(-70.5750, -33.4500)
    ]), 4326)
),
('2024-03-09 10:50:00', 3, 4, 9, 9, 1,
    ST_SetSRID(ST_MakePoint(-70.6850, -33.5140), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.6834, -33.5161),
        ST_MakePoint(-70.6850, -33.5140)
    ]), 4326)
),
('2024-03-10 13:40:00', 1, 5, 10, 10, 2,
    ST_SetSRID(ST_MakePoint(-70.5425, -33.5070), 4326),
    ST_SetSRID(ST_MakeLine(ARRAY[
        ST_MakePoint(-70.5402, -33.5081),
        ST_MakePoint(-70.5425, -33.5070)
    ]), 4326)
);

-- CALIFICACION
INSERT INTO CALIFICACION (
  id_calificacion,
  total_puntos,
  total_pedidos,
  promedio,
  id_repartidor
) VALUES
(1,  5, 1, 5.00, 1),
(2,  4, 2, 2.00, 2),
(3,  3, 3, 1.00, 3),
(4,  5, 4, 1.25, 4),
(5,  2, 5, 0.40, 5),
(6,  4, 6, 0.67, 6),
(7,  1, 7, 0.14, 7),
(8,  5, 8, 0.63, 8),
(9,  3, 9, 0.33, 9),
(10, 4,10, 0.40, 10);

-- PEDIDO_PRODUCTO
INSERT INTO PEDIDO_PRODUCTO (id_pedido, id_producto_servicio, cantidad) VALUES
(1, 1, 2),
(1, 2, 1),
(2, 3, 4),
(3, 4, 1),
(3, 5, 2),
(4, 6, 1),
(5, 7, 2),
(6, 8, 3),
(7, 9, 1),
(8, 10, 2),
(9, 1, 1),
(10, 2, 3);


INSERT INTO PUNTO_INTERES (nombre, tipo, ubicacion) VALUES
('Hospital Clínico Universidad de Chile', 'hospital', ST_GeogFromText('SRID=4326;POINT(-70.6536 -33.4314)')),
('Hospital Sótero del Río', 'hospital', ST_GeogFromText('SRID=4326;POINT(-70.5762 -33.5096)')),
('Centro Logístico Entregas Ya', 'centro_logistico', ST_GeogFromText('SRID=4326;POINT(-70.6995 -33.6250)')),
('Centro Logístico KargoGo', 'centro_logistico', ST_GeogFromText('SRID=4326;POINT(-70.7405 -33.3695)')),
('Hospital El Pino', 'hospital', ST_GeogFromText('SRID=4326;POINT(-70.6814 -33.5620)'));




UPDATE DETALLE_PEDIDO
SET    calificacion = CASE id_detalle_pedido
                        WHEN 1 THEN 1
                        WHEN 3 THEN 3
                        WHEN 4 THEN 4
                      END
WHERE  id_detalle_pedido IN (1,3,4);