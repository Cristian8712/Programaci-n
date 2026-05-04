drop database if exists fabrica;
create database fabrica;
use fabrica;

create table tecnico (
id int unsigned primary key auto_increment,
nombre varchar(150) not null,
nºempleado int(10) unique not null,
fecha_incorporacion date not null,
calle varchar(100),
nºcasa int(10),
localidad varchar(100),
rango varchar(25),
salario double (10,0),
id_tecnico_formador int unsigned,
foreign key(id_tecnico_formador) references tecnico(id)
);

create table emails_tecnico (
id int unsigned primary key auto_increment,
id_tecnico int unsigned not null,
foreign key(id_tecnico) references tecnico(id),
email varchar(100)
);

create table telefonos_tecnico (
id int unsigned primary key auto_increment,
id_tecnico int unsigned not null,
foreign key(id_tecnico) references tecnico(id),
telefono varchar(20)
);

create table producto (
id int unsigned primary key auto_increment,
fragancia varchar(50) not null,
nombre varchar(50) not null,
nºproducto varchar(50),
frasco varchar(50) not null,
tapon varchar (50) not null,
etiqueta varchar(50) not null,
alarma varchar(50) not null,
caja varchar(50) not null,
fecha_fabricacion date not null
);

create table linea_de_produccion (
id int unsigned primary key auto_increment,
nºlinea varchar(20) not null,
rendimiento varchar(50),
nºorden varchar(50) not null,
producto varchar(50) not null,
cantidad int (10) not null,
tiempo_marcha time not null,
consumo varchar(10),
produccion int(10)not null,
id_producto int unsigned not null,
foreign key(id_producto) references producto(id),
id_tecnico int unsigned not null,
foreign key(id_tecnico) references tecnico(id)
);

create table maquina (
id int unsigned primary key auto_increment,
nombre varchar(20) not null,
tipo enum ('llenadora', 'etiquetadora', 'encajadora'),
modelo varchar(50) not null,
nºserie varchar(50),
producto_dia varchar(50) not null,
potencia varchar (20) not null,
tiempo_marcha time not null,
rendimiento varchar(20),
id_linea_de_produccion int unsigned not null,
foreign key(id_linea_de_produccion) references linea_de_produccion(id)
);

create table intervencion (
id int unsigned primary key auto_increment,
nºregistro varchar(20) not null,
motivo varchar(250) not null,
tipo enum ('preventivo', 'correctivo', 'mejora')  not null,
fecha_solicitud date not null,
fecha_realizacion date not null,
hora_inicio time not null,
hora_fin time not null,
id_maquina int unsigned not null,
foreign key(id_maquina) references maquina(id),
tiempo_parada time
);

create table repuesto (
id int unsigned primary key auto_increment,
nºreferencia varchar(20) not null,
nombre varchar(100) not null,
modelo varchar(150) not null,
stock int (10) not null,
precio double(10,00) not null,
estanteria varchar(10) not null,
pasillo varchar(10) not null,
gaveta varchar(50) not null
);

create table electrico (
id int unsigned primary key auto_increment,
conector varchar(20) not null,
voltaje varchar(10) not null,
amperaje varchar(10) not null,
tamaño varchar(10) not null,
normativa varchar(150),
tipo varchar(50) not null,
id_repuesto int unsigned not null,
foreign key(id_repuesto) references repuesto(id)
);

create table mecanico (
id int unsigned primary key auto_increment,
material varchar(50) not null,
metrica varchar(10) not null,
longitud varchar(10) not null,
acabado varchar(50),
normativa varchar(150),
resistencia varchar(50),
vida_util varchar(50),
tipo varchar(50) not null,
id_repuesto int unsigned not null,
foreign key(id_repuesto) references repuesto(id)
);

create table proveedor (
id int unsigned primary key auto_increment,
nombre varchar(150) not null,
nºcuenta varchar(30) unique not null,
calle varchar(100),
nºlocal int(10),
localidad varchar(100),
nºpedido varchar(25) not null
);

create table emails_proveedor (
id int unsigned primary key auto_increment,
id_proveedor int unsigned not null,
foreign key(id_proveedor) references proveedor(id),
email varchar(100)
);

create table telefonos_proveedor (
id int unsigned primary key auto_increment,
id_proveedor int unsigned not null,
foreign key(id_proveedor) references proveedor(id),
telefono varchar(20)
);

create table almacen (
id int unsigned primary key auto_increment,
nombre varchar(100) not null,
capacidad_total int(10)not null,
tipo enum ('Materias_primas','Material_terminado', 'Residuos') not null
);

create table tecnico_realiza_intervencion (
id_tecnico int unsigned,
foreign key(id_tecnico) references tecnico(id),
id_intervencion int unsigned,
foreign key(id_intervencion) references intervencion(id),
primary key(id_tecnico, id_intervencion)
);

create table intervencion_usa_repuesto (
id_intervencion int unsigned,
foreign key(id_intervencion) references intervencion(id),
id_repuesto int unsigned,
foreign key(id_repuesto) references repuesto(id),
primary key(id_intervencion, id_repuesto),
cantidad_usada int (5) unsigned not null
);

create table proveedor_suministra_repuesto (
id_proveedor int unsigned,
foreign key(id_proveedor) references proveedor(id),
id_repuesto int unsigned,
foreign key(id_repuesto) references repuesto(id),
primary key(id_proveedor, id_repuesto)
);

create table proveedor_suministra_maquina (
id_proveedor int unsigned,
foreign key(id_proveedor) references proveedor(id),
id_maquina int unsigned,
foreign key(id_maquina) references maquina(id),
primary key(id_proveedor, id_maquina)
);

create table repuesto_pertenece_maquina (
id_repuesto int unsigned,
foreign key(id_repuesto) references repuesto(id),
id_maquina int unsigned,
foreign key(id_maquina) references maquina(id),
primary key(id_repuesto, id_maquina)
);

create table almacen_guarda_producto (
id_almacen int unsigned,
zona varchar(50) not null,
pasillo varchar(10) not null,
estanteria varchar(10) not null,
altura varchar(10) not null,
nºpallet int(10)not null,
id_producto int unsigned,
foreign key(id_almacen) references almacen(id),
foreign key(id_producto) references producto(id),
primary key(id_almacen, id_producto)
);

INSERT INTO tecnico (nombre, nºempleado, fecha_incorporacion, calle, nºcasa, localidad, rango, salario, id_tecnico_formador) VALUES 
('Carmen López', 1000, '2015-01-10', 'Gran Vía', 1, 'Madrid', 'Jefe Planta', 55000, NULL),
('Luis García', 1001, '2016-03-15', 'Alcalá', 12, 'Madrid', 'Supervisor', 40000, 1),
('Ana Fernández', 1002, '2017-05-20', 'Goya', 45, 'Madrid', 'Supervisor', 40000, 1),
('Raúl Martínez', 1003, '2018-09-01', 'Orense', 8, 'Madrid', 'Supervisor', 40000, 1),
('Marta Sánchez', 2001, '2019-01-10', 'Sol', 3, 'Getafe', 'Técnico', 28000, 2),
('Jorge Gómez', 2002, '2019-04-12', 'Luna', 7, 'Leganés', 'Técnico', 28000, 2),
('Elena Díaz', 2003, '2020-02-15', 'Estrella', 21, 'Alcorcón', 'Técnico', 27000, 2),
('Diego Pérez', 2004, '2020-08-20', 'Mar', 9, 'Móstoles', 'Técnico', 26000, 3),
('Sara Ruiz', 2005, '2021-01-11', 'Río', 14, 'Fuenlabrada', 'Técnico', 26000, 3),
('Pablo Alonso', 2006, '2021-06-05', 'Monte', 33, 'Parla', 'Técnico', 25000, 3),
('Lucía Romero', 2007, '2022-03-10', 'Valle', 2, 'Pinto', 'Técnico', 25000, 4),
('Mario Navarro', 2008, '2022-09-18', 'Bosque', 11, 'Valdemoro', 'Técnico', 24000, 4),
('Paula Torres', 2009, '2023-01-22', 'Flor', 5, 'Aranjuez', 'Técnico', 24000, 4),
('David Domínguez', 2010, '2023-07-30', 'Pino', 19, 'Ciempozuelos', 'Junior', 21000, 4),
('Alba Gil', 2011, '2023-11-05', 'Roble', 8, 'Madrid', 'Junior', 21000, 2);

INSERT INTO emails_tecnico (id_tecnico, email) VALUES 
(1, 'carmen.lopez@fabrica.com'), (2, 'luis.garcia@fabrica.com'), (3, 'ana.fernandez@fabrica.com'),
(4, 'raul.martinez@fabrica.com'), (5, 'marta.sanchez@fabrica.com'), (6, 'jorge.gomez@fabrica.com'),
(7, 'elena.diaz@fabrica.com'), (8, 'diego.perez@fabrica.com'), (9, 'sara.ruiz@fabrica.com'),
(10, 'pablo.alonso@fabrica.com'), (11, 'lucia.romero@fabrica.com'), (12, 'mario.navarro@fabrica.com'),
(13, 'paula.torres@fabrica.com'), (14, 'david.dominguez@fabrica.com'), (15, 'alba.gil@fabrica.com');

INSERT INTO telefonos_tecnico (id_tecnico, telefono) VALUES 
(1, '600100200'), (2, '600100201'), (3, '600100202'), (4, '600100203'), (5, '600100204'),
(6, '600100205'), (7, '600100206'), (8, '600100207'), (9, '600100208'), (10, '600100209'),
(11, '600100210'), (12, '600100211'), (13, '600100212'), (14, '600100213'), (15, '600100214');

INSERT INTO almacen (nombre, capacidad_total, tipo) VALUES 
('Nave Recepción', 10000, 'Materias_primas'),
('Nave Expedición', 15000, 'Material_terminado'),
('Punto Limpio', 2000, 'Residuos'),
('Almacén VIP', 5000, 'Material_terminado'),
('Cuarentena', 1000, 'Materias_primas');

INSERT INTO proveedor (nombre, nºcuenta, calle, nºlocal, localidad, nºpedido) VALUES 
('Suministros SA', 'ES1122334455667788990001', 'Pol. A', 10, 'Zaragoza', 'PED-001'),
('Electrónica Plus', 'ES1122334455667788990002', 'Parque Tec', 5, 'Barcelona', 'PED-002'),
('Mecánica Total', 'ES1122334455667788990003', 'Ronda Sur', 22, 'Valencia', 'PED-003'),
('Global Parts', 'ES1122334455667788990004', 'Av. Norte', 1, 'Bilbao', 'PED-004'),
('Rodamientos Fix', 'ES1122334455667788990005', 'C/ Taller', 8, 'Sevilla', 'PED-005'),
('Sensores y Auto', 'ES1122334455667788990006', 'Pol. B', 15, 'Madrid', 'PED-006'),
('Cables y Más', 'ES1122334455667788990007', 'Vía Augusta', 44, 'Barcelona', 'PED-007'),
('Tornillería Pro', 'ES1122334455667788990008', 'C/ Hierro', 2, 'Alicante', 'PED-008'),
('Motores y Cia', 'ES1122334455667788990009', 'Pol. C', 30, 'Vigo', 'PED-009'),
('Neumática Ibérica', 'ES1122334455667788990010', 'Av. Industria', 9, 'Málaga', 'PED-010');

INSERT INTO emails_proveedor (id_proveedor, email) VALUES 
(1, 'info@suministros.sa'), (2, 'ventas@electronicaplus.com'), (3, 'pedidos@mecanicatotal.es'),
(4, 'contacto@globalparts.com'), (5, 'info@rodamientosfix.es'), (6, 'ventas@sensoresyauto.es'),
(7, 'pedidos@cablesymas.com'), (8, 'info@tornilleriapro.es'), (9, 'ventas@motoresycia.com'), (10, 'contacto@neumaticaiberica.es');

INSERT INTO telefonos_proveedor (id_proveedor, telefono) VALUES 
(1, '976112233'), (2, '933445566'), (3, '961234567'), (4, '944556677'), (5, '954112233'),
(6, '911223344'), (7, '933998877'), (8, '965112233'), (9, '986112233'), (10, '952112233');
INSERT INTO producto (fragancia, nombre, nºproducto, frasco, tapon, etiqueta, alarma, caja, fecha_fabricacion) VALUES 
('Cítrico', 'Ocean Breeze 50', 'PRD-001', 'Cristal 50ml', 'Madera', 'Vinilo L', 'RFID', 'Cartón Premium', '2023-01-10'),
('Cítrico', 'Ocean Breeze 100', 'PRD-002', 'Cristal 100ml', 'Madera', 'Vinilo L', 'RFID', 'Cartón Premium', '2023-01-11'),
('Floral', 'Spring Rose 50', 'PRD-003', 'Mate 50ml', 'Plástico', 'Papel Kraft', 'Pin Magnético', 'Cartón Standard', '2023-01-15'),
('Floral', 'Spring Rose 100', 'PRD-004', 'Mate 100ml', 'Plástico', 'Papel Kraft', 'Pin Magnético', 'Cartón Standard', '2023-01-16'),
('Amaderado', 'Night Wood 75', 'PRD-005', 'Metal 75ml', 'Metal', 'Vinilo S', 'RFID', 'Caja Lata', '2023-02-01'),
('Fresco', 'Ice Water 30', 'PRD-006', 'Cristal 30ml', 'Madera', 'Papel Kraft', 'RFID', 'Cartón Premium', '2023-02-10'),
('Fresco', 'Ice Water 100', 'PRD-007', 'Cristal 100ml', 'Madera', 'Papel Kraft', 'RFID', 'Cartón Premium', '2023-02-11'),
('Dulce', 'Vanilla Sky 50', 'PRD-008', 'Plástico 50ml', 'Plástico', 'Vinilo S', 'Pin Magnético', 'Cartón Standard', '2023-03-05'),
('Dulce', 'Vanilla Sky 100', 'PRD-009', 'Plástico 100ml', 'Plástico', 'Vinilo L', 'Pin Magnético', 'Cartón Standard', '2023-03-06'),
('Cítrico', 'Lemon Drop 50', 'PRD-010', 'Cristal 50ml', 'Metal', 'Vinilo S', 'RFID', 'Cartón Premium', '2023-03-15'),
('Amaderado', 'Oak Forest 100', 'PRD-011', 'Mate 100ml', 'Madera', 'Papel Kraft', 'RFID', 'Caja Lata', '2023-04-01'),
('Floral', 'Jasmine Bloom 30', 'PRD-012', 'Cristal 30ml', 'Plástico', 'Vinilo S', 'Pin Magnético', 'Cartón Standard', '2023-04-10'),
('Fresco', 'Mint Breeze 75', 'PRD-013', 'Metal 75ml', 'Metal', 'Vinilo L', 'RFID', 'Cartón Premium', '2023-04-20'),
('Dulce', 'Cotton Candy 50', 'PRD-014', 'Plástico 50ml', 'Plástico', 'Papel Kraft', 'Pin Magnético', 'Cartón Standard', '2023-05-05'),
('Cítrico', 'Orange Sun 100', 'PRD-015', 'Cristal 100ml', 'Madera', 'Vinilo L', 'RFID', 'Caja Lata', '2023-05-15');

INSERT INTO producto (fragancia, nombre, nºproducto, frasco, tapon, etiqueta, alarma, caja, fecha_fabricacion) VALUES
('Amaderado', 'Cedar Spirit 50', 'PRD-016', 'Mate 50ml', 'Metal', 'Papel Kraft', 'Pin Magnético', 'Cartón Premium', '2023-06-01'),
('Floral', 'Lavender Fields 100', 'PRD-017', 'Cristal 100ml', 'Plástico', 'Vinilo S', 'RFID', 'Cartón Standard', '2023-06-10'),
('Fresco', 'Aqua Pure 30', 'PRD-018', 'Metal 30ml', 'Metal', 'Vinilo L', 'RFID', 'Caja Lata', '2023-06-20'),
('Dulce', 'Caramel Dream 75', 'PRD-019', 'Plástico 75ml', 'Plástico', 'Papel Kraft', 'Pin Magnético', 'Cartón Standard', '2023-07-05'),
('Cítrico', 'Grapefruit Glow 50', 'PRD-020', 'Cristal 50ml', 'Madera', 'Vinilo S', 'RFID', 'Cartón Premium', '2023-07-15'),
('Amaderado', 'Pine Valley 100', 'PRD-021', 'Mate 100ml', 'Metal', 'Vinilo L', 'RFID', 'Caja Lata', '2023-08-01'),
('Floral', 'Cherry Blossom 50', 'PRD-022', 'Cristal 50ml', 'Plástico', 'Papel Kraft', 'Pin Magnético', 'Cartón Standard', '2023-08-10'),
('Fresco', 'Ocean Mist 100', 'PRD-023', 'Metal 100ml', 'Metal', 'Vinilo S', 'RFID', 'Cartón Premium', '2023-08-20'),
('Dulce', 'Honey Velvet 30', 'PRD-024', 'Plástico 30ml', 'Plástico', 'Vinilo L', 'Pin Magnético', 'Cartón Standard', '2023-09-05'),
('Cítrico', 'Lime Twist 75', 'PRD-025', 'Cristal 75ml', 'Madera', 'Papel Kraft', 'RFID', 'Caja Lata', '2023-09-15'),
('Amaderado', 'Sandalwood Deep 50', 'PRD-026', 'Mate 50ml', 'Metal', 'Vinilo S', 'Pin Magnético', 'Cartón Premium', '2023-10-01'),
('Floral', 'Lily Pad 100', 'PRD-027', 'Cristal 100ml', 'Plástico', 'Vinilo L', 'RFID', 'Cartón Standard', '2023-10-10'),
('Fresco', 'Cool Rain 50', 'PRD-028', 'Metal 50ml', 'Metal', 'Papel Kraft', 'RFID', 'Caja Lata', '2023-10-20'),
('Dulce', 'Berry Sweet 100', 'PRD-029', 'Plástico 100ml', 'Plástico', 'Vinilo S', 'Pin Magnético', 'Cartón Standard', '2023-11-05'),
('Cítrico', 'Tangerine Burst 30', 'PRD-030', 'Cristal 30ml', 'Madera', 'Vinilo L', 'RFID', 'Cartón Premium', '2023-11-15');

INSERT INTO producto (fragancia, nombre, nºproducto, frasco, tapon, etiqueta, alarma, caja, fecha_fabricacion) VALUES
('Amaderado', 'Mahogany Rich 75', 'PRD-031', 'Mate 75ml', 'Metal', 'Papel Kraft', 'RFID', 'Caja Lata', '2023-12-01'),
('Floral', 'Peony Soft 50', 'PRD-032', 'Cristal 50ml', 'Plástico', 'Vinilo S', 'Pin Magnético', 'Cartón Standard', '2023-12-10'),
('Fresco', 'Glacier Ice 100', 'PRD-033', 'Metal 100ml', 'Metal', 'Vinilo L', 'RFID', 'Cartón Premium', '2023-12-20'),
('Dulce', 'Chocolate Bliss 50', 'PRD-034', 'Plástico 50ml', 'Plástico', 'Papel Kraft', 'Pin Magnético', 'Cartón Standard', '2024-01-05'),
('Cítrico', 'Pomelo Fresh 100', 'PRD-035', 'Cristal 100ml', 'Madera', 'Vinilo S', 'RFID', 'Caja Lata', '2024-01-15'),
('Amaderado', 'Bamboo Zen 30', 'PRD-036', 'Mate 30ml', 'Metal', 'Vinilo L', 'RFID', 'Cartón Premium', '2024-02-01'),
('Floral', 'Orchid Rare 75', 'PRD-037', 'Cristal 75ml', 'Plástico', 'Papel Kraft', 'Pin Magnético', 'Cartón Standard', '2024-02-10'),
('Fresco', 'Morning Dew 50', 'PRD-038', 'Metal 50ml', 'Metal', 'Vinilo S', 'RFID', 'Caja Lata', '2024-02-20'),
('Dulce', 'Marshmallow Cloud 100', 'PRD-039', 'Plástico 100ml', 'Plástico', 'Vinilo L', 'Pin Magnético', 'Cartón Standard', '2024-03-05'),
('Cítrico', 'Yuzu Splash 50', 'PRD-040', 'Cristal 50ml', 'Madera', 'Papel Kraft', 'RFID', 'Cartón Premium', '2024-03-15'),
('Amaderado', 'Teakwood Dark 100', 'PRD-041', 'Mate 100ml', 'Metal', 'Vinilo S', 'RFID', 'Caja Lata', '2024-04-01'),
('Floral', 'Lotus Calm 50', 'PRD-042', 'Cristal 50ml', 'Plástico', 'Vinilo L', 'Pin Magnético', 'Cartón Standard', '2024-04-10'),
('Fresco', 'Sea Salt 30', 'PRD-043', 'Metal 30ml', 'Metal', 'Papel Kraft', 'RFID', 'Cartón Premium', '2024-04-20'),
('Dulce', 'Cinnamon Spice 75', 'PRD-044', 'Plástico 75ml', 'Plástico', 'Vinilo S', 'Pin Magnético', 'Cartón Standard', '2024-05-05'),
('Cítrico', 'Bergamot Zest 100', 'PRD-045', 'Cristal 100ml', 'Madera', 'Vinilo L', 'RFID', 'Caja Lata', '2024-05-15'),
('Amaderado', 'Birch Bark 50', 'PRD-046', 'Mate 50ml', 'Metal', 'Papel Kraft', 'Pin Magnético', 'Cartón Premium', '2024-06-01'),
('Floral', 'Hibiscus Red 100', 'PRD-047', 'Cristal 100ml', 'Plástico', 'Vinilo S', 'RFID', 'Cartón Standard', '2024-06-10'),
('Fresco', 'Arctic Wind 50', 'PRD-048', 'Metal 50ml', 'Metal', 'Vinilo L', 'RFID', 'Caja Lata', '2024-06-20'),
('Dulce', 'Maple Syrup 30', 'PRD-049', 'Plástico 30ml', 'Plástico', 'Papel Kraft', 'Pin Magnético', 'Cartón Standard', '2024-07-05'),
('Cítrico', 'Mandarin Sunrise 75', 'PRD-050', 'Cristal 75ml', 'Madera', 'Vinilo S', 'RFID', 'Cartón Premium', '2024-07-15');

INSERT INTO linea_de_produccion (nºlinea, rendimiento, nºorden, producto, cantidad, tiempo_marcha, consumo, produccion, id_producto, id_tecnico) VALUES 
('LINEA-01', '95%', 'ORD-100', 'Ocean Breeze 50', 5000, '08:00:00', '120kW', 4800, 1, 2),
('LINEA-02', '90%', 'ORD-101', 'Spring Rose 100', 3000, '08:00:00', '100kW', 2700, 4, 2),
('LINEA-03', '98%', 'ORD-102', 'Night Wood 75', 8000, '16:00:00', '200kW', 7850, 5, 3),
('LINEA-04', '85%', 'ORD-103', 'Ice Water 30', 2000, '06:00:00', '80kW', 1700, 6, 3),
('LINEA-05', '92%', 'ORD-104', 'Vanilla Sky 100', 6000, '12:00:00', '150kW', 5520, 9, 4),
('LINEA-01', '96%', 'ORD-105', 'Lemon Drop 50', 4000, '08:00:00', '110kW', 3850, 10, 2),
('LINEA-02', '89%', 'ORD-106', 'Oak Forest 100', 3500, '08:00:00', '105kW', 3100, 11, 2),
('LINEA-03', '97%', 'ORD-107', 'Mint Breeze 75', 7500, '16:00:00', '190kW', 7200, 13, 3),
('LINEA-04', '88%', 'ORD-108', 'Cotton Candy 50', 2500, '06:00:00', '85kW', 2200, 14, 3),
('LINEA-05', '94%', 'ORD-109', 'Orange Sun 100', 5500, '12:00:00', '140kW', 5150, 15, 4);

INSERT INTO maquina (nombre, tipo, modelo, nºserie, producto_dia, potencia, tiempo_marcha, rendimiento, id_linea_de_produccion) VALUES 
('Llenadora L1', 'llenadora', 'FillMaster 3000', 'SN-001', '5000', '15kW', '08:00:00', '98%', 1),
('Etiquetadora L1', 'etiquetadora', 'LabelPro X', 'SN-002', '5000', '5kW', '08:00:00', '95%', 1),
('Encajadora L1', 'encajadora', 'Boxer 50', 'SN-003', '5000', '10kW', '08:00:00', '96%', 1),
('Llenadora L2', 'llenadora', 'FillMaster 2000', 'SN-004', '3000', '12kW', '08:00:00', '92%', 2),
('Etiquetadora L2', 'etiquetadora', 'LabelPro M', 'SN-005', '3000', '4kW', '08:00:00', '90%', 2),
('Encajadora L2', 'encajadora', 'Boxer 30', 'SN-006', '3000', '8kW', '08:00:00', '89%', 2),
('Llenadora L3', 'llenadora', 'FillMaster 5000', 'SN-007', '8000', '20kW', '16:00:00', '99%', 3),
('Etiquetadora L3', 'etiquetadora', 'LabelPro Max', 'SN-008', '8000', '7kW', '16:00:00', '98%', 3),
('Encajadora L3', 'encajadora', 'Boxer 100', 'SN-009', '8000', '15kW', '16:00:00', '98%', 3),
('Llenadora L4', 'llenadora', 'FillMaster Mini', 'SN-010', '2000', '8kW', '06:00:00', '87%', 4),
('Etiquetadora L4', 'etiquetadora', 'LabelPro S', 'SN-011', '2000', '3kW', '06:00:00', '86%', 4),
('Encajadora L4', 'encajadora', 'Boxer Mini', 'SN-012', '2000', '5kW', '06:00:00', '85%', 4),
('Llenadora L5', 'llenadora', 'FillMaster 4000', 'SN-013', '6000', '18kW', '12:00:00', '94%', 5),
('Etiquetadora L5', 'etiquetadora', 'LabelPro XL', 'SN-014', '6000', '6kW', '12:00:00', '93%', 5),
('Encajadora L5', 'encajadora', 'Boxer 75', 'SN-015', '6000', '12kW', '12:00:00', '91%', 5),
('Llenadora Reserva', 'llenadora', 'FillMaster 3000', 'SN-016', '5000', '15kW', '00:00:00', '100%', 1),
('Etiquetadora Reserva', 'etiquetadora', 'LabelPro X', 'SN-017', '5000', '5kW', '00:00:00', '100%', 2),
('Encajadora Reserva', 'encajadora', 'Boxer 50', 'SN-018', '5000', '10kW', '00:00:00', '100%', 3),
('Llenadora Pruebas', 'llenadora', 'FillMaster 1000', 'SN-019', '1000', '5kW', '02:00:00', '80%', 4),
('Etiquetadora Pruebas', 'etiquetadora', 'LabelPro Mini', 'SN-020', '1000', '2kW', '02:00:00', '80%', 5);

INSERT INTO repuesto (nºreferencia, nombre, modelo, stock, precio, estanteria, pasillo, gaveta) VALUES 
('REF-001', 'Sensor Óptico', 'Omron E3Z', 25, 45.50, 'A1', 'P1', 'G-01'), ('REF-002', 'Sensor Inductivo', 'Sick IME', 20, 38.00, 'A1', 'P1', 'G-02'),
('REF-003', 'Motor Paso a Paso', 'NEMA 17', 15, 25.00, 'A2', 'P1', 'G-03'), ('REF-004', 'Servomotor', 'Yaskawa SG', 5, 250.00, 'A2', 'P1', 'G-04'),
('REF-005', 'Relé 24V', 'Finder 40.52', 50, 8.50, 'A3', 'P1', 'G-05'), ('REF-006', 'Contactar 220V', 'Schneider LC1', 30, 22.00, 'A3', 'P1', 'G-06'),
('REF-007', 'PLC Básico', 'Siemens S7-1200', 3, 350.00, 'A4', 'P1', 'G-07'), ('REF-008', 'Pantalla HMI', 'Kinco GL070', 2, 180.00, 'A4', 'P1', 'G-08'),
('REF-009', 'Fuente Alimentación', 'MeanWell 24V', 10, 42.00, 'A5', 'P1', 'G-09'), ('REF-010', 'Variador Frecuencia', 'ABB ACS150', 4, 195.00, 'A5', 'P1', 'G-10'),
('REF-011', 'Botón Parada Emerg', 'Eaton M22', 40, 15.00, 'A6', 'P1', 'G-11'), ('REF-012', 'Selector 3 Pos', 'Siemens Sirius', 35, 12.50, 'A6', 'P1', 'G-12'),
('REF-013', 'Cable Ethernet Ind', 'Lapp 5m', 60, 18.00, 'A7', 'P1', 'G-13'), ('REF-014', 'Conector M12', 'Phoenix Contact', 100, 5.50, 'A7', 'P1', 'G-14'),
('REF-015', 'Electrovalvula', 'Festo VUVS', 15, 65.00, 'A8', 'P1', 'G-15'), ('REF-016', 'Presostato', 'SMC IS10', 20, 48.00, 'A8', 'P1', 'G-16'),
('REF-017', 'Fotocélula Reflex', 'IFM O5D', 12, 85.00, 'A9', 'P1', 'G-17'), ('REF-018', 'Encoder Absoluto', 'Sick AHS', 3, 210.00, 'A9', 'P1', 'G-18'),
('REF-019', 'Tira LED Ind', 'Banner WLS', 25, 55.00, 'A10', 'P1', 'G-19'), ('REF-020', 'Baliza Luminosa', 'Werma Kombi', 10, 75.00, 'A10', 'P1', 'G-20'),
('REF-021', 'Fusible 10A', 'Littelfuse', 200, 1.50, 'A11', 'P1', 'G-21'), ('REF-022', 'Interruptor Magneto', 'Schneider iC60', 45, 14.00, 'A11', 'P1', 'G-22'),
('REF-023', 'Termopar Tipo K', 'RS Pro', 30, 28.00, 'A12', 'P1', 'G-23'), ('REF-024', 'Controlador Temp', 'Omron E5CC', 5, 130.00, 'A12', 'P1', 'G-24'),
('REF-025', 'Batería PLC', 'Siemens', 15, 35.00, 'A13', 'P1', 'G-25'),
('REF-026', 'Correa Transmisión', 'Gates 5M', 40, 12.75, 'B1', 'P2', 'G-01'), ('REF-027', 'Correa Dentada', 'Optibelt', 30, 18.50, 'B1', 'P2', 'G-02'),
('REF-028', 'Rodamiento Bolas', 'SKF 6204', 80, 8.20, 'B2', 'P2', 'G-03'), ('REF-029', 'Rodamiento Rodillos', 'FAG 30205', 45, 15.00, 'B2', 'P2', 'G-04'),
('REF-030', 'Eje Acero', 'Inox 20mm', 10, 45.00, 'B3', 'P2', 'G-05'), ('REF-031', 'Piñón Cadena', 'Renold 1/2', 25, 22.00, 'B3', 'P2', 'G-06'),
('REF-032', 'Cadena Rodillos', 'Tsubaki RS40', 15, 60.00, 'B4', 'P2', 'G-07'), ('REF-033', 'Engranaje Recto', 'Mod 2 30D', 20, 35.00, 'B4', 'P2', 'G-08'),
('REF-034', 'Polea Aluminio', 'SPA 100', 30, 28.00, 'B5', 'P2', 'G-09'), ('REF-035', 'Acoplamiento Elast', 'Rotex 24', 12, 42.00, 'B5', 'P2', 'G-10'),
('REF-036', 'Cilindro Neumático', 'Festo DSNU', 18, 55.00, 'B6', 'P2', 'G-11'), ('REF-037', 'Vástago Inox', 'ISO 15552', 8, 38.00, 'B6', 'P2', 'G-12'),
('REF-038', 'Junta Tórica Set', 'NBR 70', 100, 15.00, 'B7', 'P2', 'G-13'), ('REF-039', 'Retén Aceite', 'Simrit', 50, 6.50, 'B7', 'P2', 'G-14'),
('REF-040', 'Boquilla Llenado', 'Inox 316L', 20, 120.00, 'B8', 'P2', 'G-15'), ('REF-041', 'Muelle Compresión', 'Acero C', 200, 2.50, 'B8', 'P2', 'G-16'),
('REF-042', 'Tornillo M8x20', 'DIN 912', 500, 0.20, 'B9', 'P2', 'G-17'), ('REF-043', 'Tuerca M8', 'DIN 934', 500, 0.10, 'B9', 'P2', 'G-18'),
('REF-044', 'Arandela M8', 'DIN 125', 500, 0.05, 'B10', 'P2', 'G-19'), ('REF-045', 'Perfil Aluminio', 'Bosch 45x45', 50, 18.00, 'B10', 'P2', 'G-20'),
('REF-046', 'Escuadra Unión', 'Aluminio', 150, 4.50, 'B11', 'P2', 'G-21'), ('REF-047', 'Pata Niveladora', 'M12', 40, 12.00, 'B11', 'P2', 'G-22'),
('REF-048', 'Ventosa Vacío', 'Schmalz', 60, 16.50, 'B12', 'P2', 'G-23'), ('REF-049', 'Guía Lineal', 'Hiwin 15mm', 10, 85.00, 'B12', 'P2', 'G-24'),
('REF-050', 'Patín Guía', 'Hiwin HGH15', 20, 45.00, 'B13', 'P2', 'G-25');

INSERT INTO electrico (conector, voltaje, amperaje, tamaño, normativa, tipo, id_repuesto) VALUES 
('M8', '24V DC', '100mA', 'Mini', 'CE', 'Sensor', 1), ('M12', '24V DC', '200mA', 'Mini', 'CE', 'Sensor', 2),
('Cables', '12V DC', '1.5A', 'NEMA 17', 'CE', 'Motor', 3), ('Bornero', '220V AC', '5A', 'Standard', 'CE', 'Motor', 4),
('Zócalo', '24V DC', '10A', 'Relé', 'CE', 'Maniobra', 5), ('Bornero', '220V AC', '25A', 'Standard', 'CE', 'Maniobra', 6),
('Ethernet', '24V DC', '2A', 'Compacto', 'CE', 'Control', 7), ('Ethernet', '24V DC', '1A', '7 Pulgadas', 'CE', 'Visualizacion', 8),
('Bornero', '220V AC', '10A', 'Caja', 'CE', 'Alimentacion', 9), ('Bornero', '380V AC', '15A', 'Caja', 'CE', 'Control', 10),
('Bornes', '24V DC', '5A', '22mm', 'CE', 'Botoneria', 11), ('Bornes', '24V DC', '5A', '22mm', 'CE', 'Botoneria', 12),
('RJ45', 'PoE', '1A', '5m', 'CE', 'Cable', 13), ('M12 5p', '24V DC', '4A', 'Recto', 'CE', 'Conector', 14),
('Din', '24V DC', '500mA', '1/4', 'CE', 'Neumatica', 15), ('M8', '24V DC', '100mA', 'G1/8', 'CE', 'Neumatica', 16),
('M12', '24V DC', '200mA', 'Laser', 'CE', 'Sensor', 17), ('M12 8p', '24V DC', '300mA', 'Eje 6mm', 'CE', 'Sensor', 18),
('M12', '24V DC', '1A', '300mm', 'CE', 'Iluminacion', 19), ('Bornes', '24V DC', '500mA', '3 Colores', 'CE', 'Iluminacion', 20),
('Cilindrico', '250V AC', '10A', '5x20mm', 'CE', 'Proteccion', 21), ('Carril DIN', '220V AC', '16A', '1 Polo', 'CE', 'Proteccion', 22),
('Terminal', 'mV', 'uA', '2m', 'CE', 'Sensor', 23), ('Bornes', '220V AC', '5A', '1/16 DIN', 'CE', 'Control', 24),
('Cable', '3V DC', '1A', 'AA', 'CE', 'Alimentacion', 25);

INSERT INTO mecanico (material, metrica, longitud, acabado, normativa, resistencia, vida_util, tipo, id_repuesto) VALUES 
('Caucho', 'Paso 5', '1000mm', 'Negro', 'ISO', 'Media', '5000h', 'Transmision', 26), ('Caucho', 'T10', '1500mm', 'Negro', 'ISO', 'Alta', '5000h', 'Transmision', 27),
('Acero', 'Int 20', 'Ancho 14', 'Grasa', 'ISO', 'Alta', '10000h', 'Friccion', 28), ('Acero', 'Int 25', 'Ancho 15', 'Grasa', 'ISO', 'Muy Alta', '10000h', 'Friccion', 29),
('Inox 304', 'D20', '1000mm', 'Pulido', 'DIN', 'Alta', 'Infinito', 'Estructura', 30), ('Acero', 'Mod 1', 'D50mm', 'Zingado', 'DIN', 'Alta', '8000h', 'Transmision', 31),
('Acero', 'Paso 1/2', '5m', 'Aceite', 'ISO', 'Muy Alta', '5000h', 'Transmision', 32), ('Acero', 'Mod 2', 'D60mm', 'Zingado', 'DIN', 'Alta', '8000h', 'Transmision', 33),
('Aluminio', 'SPA', 'D100mm', 'Anodizado', 'ISO', 'Media', 'Infinito', 'Transmision', 34), ('Poliuretano', 'Estrella', 'D40mm', 'Rojo', 'ISO', 'Media', '3000h', 'Transmision', 35),
('Aluminio', 'M10', 'Carrera 50', 'Anodizado', 'ISO', 'Media', '500000c', 'Neumatica', 36), ('Inox 304', 'M12', '200mm', 'Cromo', 'ISO', 'Alta', '500000c', 'Neumatica', 37),
('NBR', 'Varias', 'Caja', 'Negro', 'DIN', 'Baja', '1 Año', 'Estanqueidad', 38), ('NBR', 'D30', 'Ancho 7', 'Negro', 'DIN', 'Media', '2000h', 'Estanqueidad', 39),
('Inox 316L', 'G1/2', '150mm', 'Pulido Espejo', 'FDA', 'Alta', 'Infinito', 'Proceso', 40), ('Acero C', 'D2', '50mm', 'Zingado', 'DIN', 'Media', '1000000c', 'Muelle', 41),
('Acero 8.8', 'M8', '20mm', 'Pavonado', 'DIN 912', 'Alta', 'Infinito', 'Tornilleria', 42), ('Acero 8.8', 'M8', 'N/A', 'Zingado', 'DIN 934', 'Alta', 'Infinito', 'Tornilleria', 43),
('Acero', 'M8', 'N/A', 'Zingado', 'DIN 125', 'Media', 'Infinito', 'Tornilleria', 44), ('Aluminio', 'Ranura 10', '2000mm', 'Anodizado', 'Bosch', 'Alta', 'Infinito', 'Estructura', 45),
('Aluminio', '45x45', 'N/A', 'Fundicion', 'Bosch', 'Alta', 'Infinito', 'Estructura', 46), ('Acero/Nylon', 'M12', '100mm', 'Zingado', 'ISO', 'Alta', 'Infinito', 'Estructura', 47),
('Silicona', 'D30', 'N/A', 'Transparente', 'FDA', 'Baja', '100000c', 'Neumatica', 48), ('Acero', '15mm', '1000mm', 'Grasa', 'ISO', 'Muy Alta', '10000h', 'Guiado', 49),
('Acero', '15mm', 'Bloque', 'Grasa', 'ISO', 'Muy Alta', '10000h', 'Guiado', 50);

INSERT INTO intervencion (nºregistro, motivo, tipo, fecha_solicitud, fecha_realizacion, hora_inicio, hora_fin, id_maquina, tiempo_parada) VALUES 
('INT-001', 'Revisión mensual L1', 'preventivo', '2023-01-15', '2023-01-16', '08:00:00', '10:00:00', 1, '02:00:00'),
('INT-002', 'Atasco botellas', 'correctivo', '2023-01-18', '2023-01-18', '11:00:00', '11:30:00', 1, '00:30:00'),
('INT-003', 'Cambio bobina etiquetas', 'preventivo', '2023-01-20', '2023-01-20', '09:00:00', '09:15:00', 2, '00:15:00'),
('INT-004', 'Sensor óptico fallando', 'correctivo', '2023-02-05', '2023-02-05', '14:00:00', '15:00:00', 3, '01:00:00'),
('INT-005', 'Revisión trimestral L2', 'preventivo', '2023-02-10', '2023-02-11', '08:00:00', '12:00:00', 4, '04:00:00'),
('INT-006', 'Rotura correa', 'correctivo', '2023-02-15', '2023-02-15', '10:00:00', '11:30:00', 5, '01:30:00'),
('INT-007', 'Ruido rodamiento', 'correctivo', '2023-03-01', '2023-03-02', '16:00:00', '18:00:00', 6, '02:00:00'),
('INT-008', 'Actualización PLC', 'mejora', '2023-03-10', '2023-03-12', '08:00:00', '10:00:00', 7, '00:00:00'),
('INT-009', 'Engrase cadenas', 'preventivo', '2023-03-20', '2023-03-20', '09:00:00', '10:00:00', 8, '01:00:00'),
('INT-010', 'Fallo motor', 'correctivo', '2023-04-05', '2023-04-05', '11:00:00', '14:00:00', 9, '03:00:00'),
('INT-011', 'Limpieza inyectores', 'preventivo', '2023-04-15', '2023-04-15', '08:00:00', '09:00:00', 10, '01:00:00'),
('INT-012', 'Cambio formato botella', 'mejora', '2023-04-20', '2023-04-21', '15:00:00', '17:00:00', 11, '00:00:00'),
('INT-013', 'Rotura ventosa', 'correctivo', '2023-05-02', '2023-05-02', '10:00:00', '10:30:00', 12, '00:30:00'),
('INT-014', 'Revisión semestral L3', 'preventivo', '2023-05-10', '2023-05-11', '08:00:00', '14:00:00', 13, '06:00:00'),
('INT-015', 'Fallo fuente 24V', 'correctivo', '2023-05-25', '2023-05-25', '09:00:00', '10:00:00', 14, '01:00:00'),
('INT-016', 'Puesta a punto reserva', 'mejora', '2023-06-05', '2023-06-06', '08:00:00', '16:00:00', 16, '00:00:00'),
('INT-017', 'Cambio correas L4', 'preventivo', '2023-06-15', '2023-06-15', '14:00:00', '16:00:00', 10, '02:00:00'),
('INT-018', 'Cortocircuito', 'correctivo', '2023-06-20', '2023-06-20', '11:00:00', '12:30:00', 11, '01:30:00'),
('INT-019', 'Ajuste de guías', 'preventivo', '2023-07-05', '2023-07-05', '09:00:00', '10:00:00', 12, '01:00:00'),
('INT-020', 'Cambio pantalla HMI', 'correctivo', '2023-07-15', '2023-07-15', '15:00:00', '16:30:00', 13, '01:30:00'),
('INT-021', 'Revisión anual Planta', 'preventivo', '2023-08-01', '2023-08-10', '08:00:00', '16:00:00', 1, '08:00:00'),
('INT-022', 'Revisión anual Planta', 'preventivo', '2023-08-01', '2023-08-10', '08:00:00', '16:00:00', 2, '08:00:00'),
('INT-023', 'Revisión anual Planta', 'preventivo', '2023-08-01', '2023-08-10', '08:00:00', '16:00:00', 3, '08:00:00'),
('INT-024', 'Revisión anual Planta', 'preventivo', '2023-08-01', '2023-08-10', '08:00:00', '16:00:00', 4, '08:00:00'),
('INT-025', 'Fuga de aire', 'correctivo', '2023-09-05', '2023-09-05', '10:00:00', '11:00:00', 5, '01:00:00'),
('INT-026', 'Sustitución cilindro', 'correctivo', '2023-09-15', '2023-09-15', '14:00:00', '15:00:00', 6, '01:00:00'),
('INT-027', 'Calibración báscula', 'preventivo', '2023-10-01', '2023-10-02', '09:00:00', '10:00:00', 7, '01:00:00'),
('INT-028', 'Fallo botón paro', 'correctivo', '2023-10-10', '2023-10-10', '11:30:00', '12:00:00', 8, '00:30:00'),
('INT-029', 'Cambio formato caja', 'mejora', '2023-10-20', '2023-10-20', '15:00:00', '16:00:00', 9, '00:00:00'),
('INT-030', 'Engrase rodamientos', 'preventivo', '2023-11-05', '2023-11-05', '08:00:00', '09:30:00', 10, '01:30:00'),
('INT-031', 'Atasco pegamento', 'correctivo', '2023-11-15', '2023-11-15', '10:00:00', '11:00:00', 11, '01:00:00'),
('INT-032', 'Limpieza profunda', 'preventivo', '2023-12-01', '2023-12-01', '14:00:00', '18:00:00', 12, '04:00:00'),
('INT-033', 'Cambio variador', 'correctivo', '2023-12-10', '2023-12-10', '09:00:00', '11:00:00', 13, '02:00:00'),
('INT-034', 'Revisión motores L5', 'preventivo', '2024-01-10', '2024-01-11', '08:00:00', '12:00:00', 14, '04:00:00'),
('INT-035', 'Ajuste fotocélula', 'correctivo', '2024-01-20', '2024-01-20', '15:00:00', '15:30:00', 15, '00:30:00'),
('INT-036', 'Instalación baliza', 'mejora', '2024-02-05', '2024-02-06', '16:00:00', '17:00:00', 1, '00:00:00'),
('INT-037', 'Cambio juntas', 'preventivo', '2024-02-15', '2024-02-15', '09:00:00', '11:00:00', 2, '02:00:00'),
('INT-038', 'Rotura eje', 'correctivo', '2024-03-01', '2024-03-01', '10:00:00', '14:00:00', 3, '04:00:00'),
('INT-039', 'Revisión L4', 'preventivo', '2024-03-15', '2024-03-16', '08:00:00', '12:00:00', 10, '04:00:00'),
('INT-040', 'Fallo encoder', 'correctivo', '2024-04-05', '2024-04-05', '11:00:00', '12:30:00', 11, '01:30:00'),
('INT-041', 'Sustitución cable RED', 'correctivo', '2024-04-15', '2024-04-15', '14:00:00', '14:45:00', 12, '00:45:00'),
('INT-042', 'Mantenimiento encajadora', 'preventivo', '2024-05-01', '2024-05-02', '09:00:00', '13:00:00', 13, '04:00:00'),
('INT-043', 'Vibración excesiva', 'correctivo', '2024-05-10', '2024-05-10', '10:00:00', '11:30:00', 14, '01:30:00'),
('INT-044', 'Mejora protecciones', 'mejora', '2024-05-20', '2024-05-21', '16:00:00', '18:00:00', 15, '00:00:00'),
('INT-045', 'Cambio aceite grupo', 'preventivo', '2024-06-05', '2024-06-05', '08:00:00', '09:00:00', 1, '01:00:00'),
('INT-046', 'Rotura muelle', 'correctivo', '2024-06-15', '2024-06-15', '11:00:00', '11:30:00', 2, '00:30:00'),
('INT-047', 'Sustitución patines', 'preventivo', '2024-07-01', '2024-07-02', '09:00:00', '12:00:00', 3, '03:00:00'),
('INT-048', 'Fallo relé', 'correctivo', '2024-07-10', '2024-07-10', '14:00:00', '14:30:00', 4, '00:30:00'),
('INT-049', 'Revisión neumática', 'preventivo', '2024-07-20', '2024-07-20', '15:00:00', '17:00:00', 5, '02:00:00'),
('INT-050', 'Actualización HMI', 'mejora', '2024-08-01', '2024-08-02', '16:00:00', '17:00:00', 6, '00:00:00');

INSERT INTO tecnico_realiza_intervencion (id_tecnico, id_intervencion) VALUES 
(5,1), (6,2), (7,3), (8,4), (9,5), (10,6), (11,7), (12,8), (13,9), (14,10), (15,11), (5,12), (6,13), (7,14),
(8,15), (9,16), (10,17), (11,18), (12,19), (13,20), (5,21), (6,21), (7,21), (8,22), (9,22), (10,23), (11,23),
(12,24), (13,24), (14,25), (15,26), (5,27), (6,28), (7,29), (8,30), (9,31), (10,32), (11,33), (12,34), (13,35),
(14,36), (15,37), (5,38), (6,39), (7,40), (8,41), (9,42), (10,43), (11,44), (12,45), (13,46), (14,47), (15,48),
(5,49), (6,50), (14,50), (15,50);

INSERT INTO intervencion_usa_repuesto (id_intervencion, id_repuesto, cantidad_usada) VALUES 
(2,42,5), (2,43,5), (4,1,1), (6,26,1), (7,28,2), (8,7,1), (10,3,1), (13,48,4), (15,9,1), (18,21,3), 
(20,8,1), (25,15,1), (26,36,1), (28,11,1), (30,28,4), (33,10,1), (35,17,1), (36,20,1), (37,38,10), (38,30,1), 
(40,18,1), (41,13,1), (43,28,2), (46,41,2), (47,50,4), (48,5,1), (49,36,2), (50,8,1);

INSERT INTO proveedor_suministra_repuesto (id_proveedor, id_repuesto) VALUES 
(6,1), (6,2), (9,3), (9,4), (2,5), (2,6), (2,7), (2,8), (2,9), (9,10), (2,11), (2,12), (7,13), (7,14), 
(10,15), (10,16), (6,17), (6,18), (2,19), (2,20), (2,21), (2,22), (6,23), (6,24), (2,25), 
(4,26), (4,27), (5,28), (5,29), (3,30), (3,31), (3,32), (3,33), (4,34), (3,35), (10,36), (10,37), 
(1,38), (1,39), (3,40), (1,41), (8,42), (8,43), (8,44), (1,45), (1,46), (1,47), (10,48), (5,49), (5,50);

INSERT INTO proveedor_suministra_maquina (id_proveedor, id_maquina) VALUES 
(3,1), (2,2), (4,3), (3,4), (2,5), (4,6), (3,7), (2,8), (4,9), (3,10), (2,11), (4,12), (3,13), (2,14), (4,15),
(3,16), (2,17), (4,18), (3,19), (2,20);

INSERT INTO repuesto_pertenece_maquina (id_repuesto, id_maquina) VALUES 
(1,1), (2,1), (15,1), (40,1), (1,2), (3,2), (26,2), (1,3), (36,3), (48,3), 
(1,4), (2,4), (15,4), (40,4), (1,5), (3,5), (26,5), (1,6), (36,6), (48,6),
(1,7), (2,7), (15,7), (40,7), (1,8), (3,8), (26,8), (1,9), (36,9), (48,9),
(1,10), (2,10), (15,10), (40,10), (1,11), (3,11), (26,11), (1,12), (36,12), (48,12),
(1,13), (2,13), (15,13), (40,13), (1,14), (3,14), (26,14), (1,15), (36,15), (48,15),
(21,1), (21,2), (21,3), (21,4), (21,5), (22,1), (22,2), (22,3), (22,4), (22,5);

INSERT INTO almacen_guarda_producto (id_almacen, id_producto, zona, pasillo, estanteria, altura, nºpallet) VALUES 
(2, 1, 'A', 'P1', 'E1', '1', 100), (2, 2, 'A', 'P1', 'E1', '2', 101), (2, 3, 'A', 'P1', 'E2', '1', 102),
(2, 4, 'A', 'P1', 'E2', '2', 103), (2, 5, 'A', 'P2', 'E1', '1', 104), (2, 6, 'A', 'P2', 'E1', '2', 105),
(2, 7, 'B', 'P3', 'E1', '1', 106), (2, 8, 'B', 'P3', 'E1', '2', 107), (2, 9, 'B', 'P3', 'E2', '1', 108),
(2, 10, 'B', 'P3', 'E2', '2', 109), (2, 11, 'B', 'P4', 'E1', '1', 110), (2, 12, 'B', 'P4', 'E1', '2', 111),
(2, 13, 'C', 'P5', 'E1', '1', 112), (2, 14, 'C', 'P5', 'E1', '2', 113), (2, 15, 'C', 'P5', 'E2', '1', 114),
(2, 16, 'C', 'P5', 'E2', '2', 115), (2, 17, 'C', 'P6', 'E1', '1', 116), (2, 18, 'C', 'P6', 'E1', '2', 117),
(2, 19, 'D', 'P7', 'E1', '1', 118), (2, 20, 'D', 'P7', 'E1', '2', 119), (2, 21, 'D', 'P7', 'E2', '1', 120),
(2, 22, 'D', 'P7', 'E2', '2', 121), (2, 23, 'D', 'P8', 'E1', '1', 122), (2, 24, 'D', 'P8', 'E1', '2', 123),
(2, 25, 'E', 'P9', 'E1', '1', 124), (2, 26, 'E', 'P9', 'E1', '2', 125), (2, 27, 'E', 'P9', 'E2', '1', 126),
(2, 28, 'E', 'P9', 'E2', '2', 127), (2, 29, 'E', 'P10', 'E1', '1', 128), (2, 30, 'E', 'P10', 'E1', '2', 129),
(4, 31, 'VIP', 'P1', 'E1', '1', 500), (4, 32, 'VIP', 'P1', 'E1', '2', 501), (4, 33, 'VIP', 'P1', 'E2', '1', 502),
(4, 34, 'VIP', 'P1', 'E2', '2', 503), (4, 35, 'VIP', 'P2', 'E1', '1', 504), (4, 36, 'VIP', 'P2', 'E1', '2', 505),
(4, 37, 'VIP', 'P2', 'E2', '1', 506), (4, 38, 'VIP', 'P2', 'E2', '2', 507), (4, 39, 'VIP', 'P3', 'E1', '1', 508),
(4, 40, 'VIP', 'P3', 'E1', '2', 509), (4, 41, 'VIP', 'P3', 'E2', '1', 510), (4, 42, 'VIP', 'P3', 'E2', '2', 511),
(4, 43, 'VIP', 'P4', 'E1', '1', 512), (4, 44, 'VIP', 'P4', 'E1', '2', 513), (4, 45, 'VIP', 'P4', 'E2', '1', 514),
(4, 46, 'VIP', 'P4', 'E2', '2', 515), (4, 47, 'VIP', 'P5', 'E1', '1', 516), (4, 48, 'VIP', 'P5', 'E1', '2', 517),
(4, 49, 'VIP', 'P5', 'E2', '1', 518), (4, 50, 'VIP', 'P5', 'E2', '2', 519);