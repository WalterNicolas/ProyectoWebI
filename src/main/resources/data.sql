-- Insertar datos de prueba en Usuario
INSERT INTO Usuario (email, password, rol, nombre, apellido, activo, longitud, latitud, accessLevel) VALUES
('123@123', '123', 'ADMIN', 'Jane', 'Smith', true, -34.71133532026949, -58.60603627471634, 4),
('1234@1234', '123', 'USER', 'Juan', 'Perez', true, -34.605, -58.38, 1),
('maria@example.com', 'password', 'USER', 'Maria', 'Lopez', true, -34.61, -58.41, 1),
('pedro@example.com', 'password', 'USER', 'Pedro', 'Gonzalez', true, -34.62, -58.42, 1),
('laura@example.com', 'password', 'USER', 'Laura', 'Martinez', true, -34.63, -58.43, 1);


INSERT INTO TipoEntrenamiento (id,nombre, descripcion) VALUES (1,'Cardio', 'Entrenamiento cardiovascular');
INSERT INTO TipoEntrenamiento (id,nombre, descripcion) VALUES (2,'Musculacion', 'Entrenamiento de fuerza');
INSERT INTO TipoEntrenamiento (id,nombre, descripcion) VALUES (3,'Calistenia', 'Entrenamiento con el peso del cuerpo');

INSERT INTO AptitudFisica (altura, diasEntrenamiento, estadoFisico, horasEntrenamiento, peso, usuario_id) VALUES (1.75, 5, 'entrenado', 2.0, 70.0, 1);
INSERT INTO AptitudFisica (altura, diasEntrenamiento, estadoFisico, horasEntrenamiento, peso, usuario_id) VALUES (1.80, 3, 'entrenado', 1.5, 75.0, 2);
INSERT INTO AptitudFisica (altura, diasEntrenamiento, estadoFisico, horasEntrenamiento, peso, usuario_id) VALUES (1.65, 4, 'intermedio', 1.0, 60.0, 3);
INSERT INTO AptitudFisica (altura, diasEntrenamiento, estadoFisico, horasEntrenamiento, peso, usuario_id) VALUES (1.70, 2, 'principiante', 1.0, 65.0, 4);
INSERT INTO AptitudFisica (altura, diasEntrenamiento, estadoFisico, horasEntrenamiento, peso, usuario_id) VALUES (1.85, 4, 'avanzado', 2.5, 80.0, 5);


INSERT INTO AptitudFisicaTipoEntrenamiento (aptitudFisica_id, tipoEntrenamiento_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1),
(5, 2);

-- Insertar datos de prueba en RutinaSemanal
INSERT INTO RutinaSemanal (usuario_id) VALUES
(1),
(2),
(3),
(4),
(5);

-- Insertar datos de prueba en RutinaDiaria
INSERT INTO RutinaDiaria (diaSemana, descripcion, rutina_semanal_id) VALUES
('Lunes', 'Rutina de Lunes', 1),
('Martes', 'Rutina de Martes', 1),
('Miércoles', 'Rutina de Miércoles', 1),
('Jueves', 'Rutina de Jueves', 2),
('Viernes', 'Rutina de Viernes', 2),
('Sábado', 'Rutina de Sábado', 3),
('Domingo', 'Rutina de Domingo', 3),
('Lunes', 'Rutina de Lunes', 4),
('Martes', 'Rutina de Martes', 4),
('Miércoles', 'Rutina de Miércoles', 5);

-- Insertar datos de prueba en Ejercicio
INSERT INTO Ejercicio (nombre, duracion, tipo, descripcion, realizado, primario) VALUES
('Correr', 30, 'Cardio', 'Ejercicio cardiovascular', false, true),
('Nadar', 45, 'Natacion', 'Ejercicio en el agua', false, true),
('Ciclismo', 60, 'Cardio', 'Ejercicio en bicicleta', false, true),
('Press de Banca', 15, 'Musculacion', 'Press de Banca. Realiza 3 series de 12 repeticiones.', false, false),
('Sentadillas', 20, 'Musculacion', 'Sentadillas. Realiza 4 series de 10 repeticiones.', false, false),
('Peso Muerto', 25, 'Musculacion', 'Peso Muerto. Realiza 3 series de 8 repeticiones.', false, false),
('Curl de Bíceps', 15, 'Musculacion', 'Curl de Bíceps. Realiza 3 series de 10 repeticiones.', false, false),
('Press de Hombros', 20, 'Musculacion', 'Press de Hombros. Realiza 3 series de 12 repeticiones.', false, false),
('Remo con Barra', 20, 'Musculacion', 'Remo con Barra. Realiza 3 series de 12 repeticiones.', false, false),
('Dominadas', 20, 'Musculacion', 'Dominadas. Realiza 3 series de 8 repeticiones.', false, false);

-- Insertar datos de prueba en rutina_diaria_ejercicio
INSERT INTO rutina_diaria_ejercicio (rutina_diaria_id, ejercicio_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(3, 6),
(3, 7),
(4, 8),
(4, 9),
(5, 10);

-- Insertar datos de prueba en membresia
INSERT INTO membresia (tipo, duracion, valor, fecha_inicio, fecha_fin,usuario_id) VALUES
('Nivel 0', 30, 0, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 30 DAY),1),
('Nivel 1', 60, 50, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 60 DAY),2),
('Nivel 2', 90, 100, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 90 DAY),3);

-- Insertar datos de prueba en pesoRegistro
INSERT INTO pesoRegistro (usuario_id, fecha, peso) VALUES
(1, '2024-01-01', 71.0),
(1, '2024-02-01', 70.5),
(1, '2024-03-01', 70.0),
(2, '2024-01-01', 76.0),
(2, '2024-02-01', 75.5),
(2, '2024-03-01', 75.0),
(3, '2024-01-01', 61.0),
(3, '2024-02-01', 60.5),
(3, '2024-03-01', 60.0),
(4, '2024-01-01', 68.0),
(4, '2024-02-01', 67.5),
(4, '2024-03-01', 67.0),
(5, '2024-01-01', 80.0),
(5, '2024-02-01', 79.5),
(5, '2024-03-01', 79.0);
