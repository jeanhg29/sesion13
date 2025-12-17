-- Inserta usuarios de prueba (Asegúrate de usar nombres de columnas de tu BD, no de Java)
INSERT INTO usuarios (codigo, nombre, apellido, area, contrasena, estado_activo) VALUES ('admin', 'admin', 'admin', 'admin', 'admin', 1);
INSERT INTO usuarios (codigo, nombre, apellido, area, contrasena, estado_activo) VALUES ('drecalde', 'Diego', 'Recalde', 'Sistemas', '123', 1);

-- Inserta los estados obligatorios
INSERT INTO estados_activo (nombre, descripcion) VALUES (N'En Almacén', N'El activo se encuentra operativo y en el almacén.');
INSERT INTO estados_activo (nombre, descripcion) VALUES (N'Asignado', N'El activo se encuentra asignado a un colaborador.');
INSERT INTO estados_activo (nombre, descripcion) VALUES (N'En Mantenimiento', N'El activo se encuentra en mantenimiento preventivo o correctivo.');
INSERT INTO estados_activo (nombre, descripcion) VALUES (N'Retirado', N'El activo ya cumplió con su ciclo de vida y se encuentra en el almacén.');
INSERT INTO estados_activo (nombre, descripcion) VALUES (N'Dado de baja', N'El activo ya no forma parte de la organización, no se encuentra en instalaciones y no es responsabilidad de la misma.');

