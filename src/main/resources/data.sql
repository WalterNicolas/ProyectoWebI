-- Insertar datos en la tabla aptitudes_fisicas con las opciones permitidas
INSERT INTO aptitudFisica (altura, diasEntrenamiento, estadoFisico, horasEntrenamiento, peso)
VALUES (1.75, 5, 'entrenado', 2.0, 70.0),
       (1.80, 3, 'entrenado', 1.5, 75.0),
       (1.65, 4, 'intermedio', 1.0, 60.0);
-- Insertar datos de prueba en Usuario
INSERT INTO usuario (accessLevel, activo, apellido, nombre, email, latitud, longitud, password, rol, aptitudFisica_id)
VALUES (1, TRUE, 'Garcia', 'Juan', 'ni@ni.com', 40.7128, -74.0060, '123', 'user', 1),
       (2, TRUE, 'Lopez', 'Maria', 'da@da.com', 34.0522, -118.2437, '123', 'user', 2),
       (1, TRUE, 'Perez', 'Carlos', 'le@le.com', 41.8781, -87.6298, '123', 'user', 3);

UPDATE aptitudFisica
SET usuario_id = 1
WHERE id = 1;
UPDATE aptitudFisica
SET usuario_id = 2
WHERE id = 2;
UPDATE aptitudFisica
SET usuario_id = 3
WHERE id = 3;

UPDATE usuario
SET aptitudFisica_id = 1
WHERE id = 1;
UPDATE usuario
SET aptitudFisica_id = 2
WHERE id = 2;
UPDATE usuario
SET aptitudFisica_id = 3
WHERE id = 3;


INSERT INTO TipoEntrenamiento (id, nombre, descripcion)
VALUES (1, 'Musculacion', 'Entrenamiento de fuerza');
INSERT INTO TipoEntrenamiento (id, nombre, descripcion)
VALUES (2, 'Cardio', 'Entrenamiento cardiovascular');
INSERT INTO TipoEntrenamiento (id, nombre, descripcion)
VALUES (3, 'Calistenia', 'Entrenamiento con el peso del cuerpo');


INSERT INTO AptitudFisicaTipoEntrenamiento (aptitudFisica_id, tipoEntrenamiento_id)
VALUES (1, 1),
       (1, 2),
       (3, 3),
       (2, 2),
       (2, 1);

-- Insertar datos de prueba en RutinaSemanal
-- INSERT INTO RutinaSemanal (usuario_id) VALUES
-- (1),
-- (2),
-- (3),
-- (4),
-- (5);

-- Insertar datos de prueba en RutinaDiaria
/*INSERT INTO RutinaDiaria (diaSemana, descripcion, rutina_semanal_id) VALUES
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
*/
-- Insertar datos de prueba en Ejercicio

-- Insertar ejercicios
INSERT INTO ejercicio (descripcion, duracion, nombre, realizado, tipo, primario)
VALUES ('Press de Banca. Realiza 3 series de 12 repeticiones.', 15, 'Press de Banca', 0, 'Musculacion', FALSE),
       ('Sentadillas. Realiza 4 series de 10 repeticiones.', 20, 'Sentadillas', 0, 'Musculacion', FALSE),
       ('Peso Muerto. Realiza 3 series de 8 repeticiones.', 25, 'Peso Muerto', 0, 'Musculacion', FALSE),
       ('Curl de Bíceps. Realiza 3 series de 10 repeticiones.', 15, 'Curl de Bíceps', 0, 'Musculacion', FALSE),
       ('Press de Hombros. Realiza 3 series de 12 repeticiones.', 20, 'Press de Hombros', 0, 'Musculacion', FALSE),
       ('Remo con Barra. Realiza 3 series de 12 repeticiones.', 20, 'Remo con Barra', 0, 'Musculacion', FALSE),
       ('Dominadas. Realiza 3 series de 8 repeticiones.', 20, 'Dominadas', 0, 'Musculacion', FALSE),
       ('Fondos en paralelas. Realiza 3 series de 10 repeticiones.', 15, 'Fondos en Paralelas', 0, 'Musculacion',
        FALSE),
       ('Prensa de Piernas. Realiza 3 series de 12 repeticiones.', 20, 'Prensa de Piernas', 0, 'Musculacion', FALSE),
       ('Extensiones de Tríceps en Polea. Realiza 3 series de 12 repeticiones.', 15, 'Extensiones de Tríceps en Polea',
        0, 'Musculacion', FALSE),
       ('Elevaciones laterales. Realiza 3 series de 12 repeticiones.', 15, 'Elevaciones laterales', 0, 'Musculacion',
        FALSE),
       ('Curl de Femoral. Realiza 3 series de 10 repeticiones.', 20, 'Curl de Femoral', 0, 'Musculacion', FALSE),
       ('Elevaciones de Gemelos. Realiza 3 series de 15 repeticiones.', 20, 'Elevaciones de Gemelos', 0, 'Musculacion',
        FALSE),
       ('Pull Over. Realiza 3 series de 12 repeticiones.', 20, 'Pull Over', 0, 'Musculacion', FALSE),
       ('Pájaros. Realiza 3 series de 12 repeticiones.', 15, 'Pájaros', 0, 'Musculacion', FALSE),
       ('Press de Banca Inclinado. Realiza 3 series de 10 repeticiones.', 20, 'Press de Banca Inclinado', 0,
        'Musculacion', FALSE),
       ('Press Francés. Realiza 3 series de 12 repeticiones.', 15, 'Press Francés', 0, 'Musculacion', FALSE),
       ('Pullover con mancuerna. Realiza 3 series de 12 repeticiones.', 20, 'Pullover con mancuerna', 0, 'Musculacion',
        FALSE),
       ('Aperturas con mancuernas. Realiza 3 series de 12 repeticiones.', 15, 'Aperturas con mancuernas', 0,
        'Musculacion', FALSE),
       ('Press militar. Realiza 3 series de 12 repeticiones.', 20, 'Press militar', 0, 'Musculacion', FALSE),
       ('Flexiones de Brazos', 15, 'Flexiones de Brazos', 0, 'Calistenia', FALSE),
       ('Burpees', 20, 'Burpees', 0, 'Calistenia', FALSE),
       ('Plancha', 20, 'Plancha', 0, 'Calistenia', TRUE),
       ('Dominadas en Barra', 20, 'Dominadas en Barra', 0, 'Calistenia', TRUE),
       ('Flexiones Diamante', 15, 'Flexiones Diamante', 0, 'Calistenia', TRUE),
       ('Flexiones con Palmada', 15, 'Flexiones con Palmada', 0, 'Calistenia', FALSE),
       ('Sentadillas', 20, 'Sentadillas', 0, 'Calistenia', TRUE),
       ('Plancha Lateral', 20, 'Plancha Lateral', 0, 'Calistenia', TRUE),
       ('Flexiones en Pica', 15, 'Flexiones en Pica', 0, 'Calistenia', FALSE),
       ('Abdominales', 15, 'Abdominales', 0, 'Calistenia', TRUE),
       ('Mountain Climbers', 15, 'Mountain Climbers', 0, 'Calistenia', FALSE),
       ('Fondos en Dips', 15, 'Fondos en Dips', 0, 'Calistenia', TRUE),
       ('Flexiones con apoyo', 15, 'Flexiones con apoyo', 0, 'Calistenia', FALSE),
       ('Sentadillas con salto', 20, 'Sentadillas con salto', 0, 'Calistenia', TRUE),
       ('Escaladores', 15, 'Escaladores', 0, 'Calistenia', FALSE),
       ('Plancha con Elevación de Piernas', 20, 'Plancha con Elevación de Piernas', 0, 'Calistenia', TRUE),
       ('Hollow Body Hold', 20, 'Hollow Body Hold', 0, 'Calistenia', TRUE),
       ('Superman', 15, 'Superman', 0, 'Calistenia', TRUE),
       ('Tijeras', 15, 'Tijeras', 0, 'Calistenia', TRUE),
       ('Carrera en el Sitio', 10, 'Carrera en el Sitio', 0, 'Cardio', FALSE),
       ('Jumping Jacks', 15, 'Jumping Jacks', 0, 'Cardio', FALSE),
       ('Burpees', 20, 'Burpees', 0, 'Cardio', TRUE),
       ('Skipping', 10, 'Skipping', 0, 'Cardio', FALSE),
       ('Mountain Climbers', 15, 'Mountain Climbers', 0, 'Cardio', TRUE),
       ('Saltos de Tijera', 15, 'Saltos de Tijera', 0, 'Cardio', FALSE),
       ('Carrera en el Lugar', 10, 'Carrera en el Lugar', 0, 'Cardio', FALSE),
       ('Plancha con Elevación de Piernas', 10, 'Plancha con Elevación de Piernas', 0, 'Cardio', FALSE),
       ('Elevación de Rodillas', 10, 'Elevación de Rodillas', 0, 'Cardio', FALSE),
       ('Skipping con Cuerda', 15, 'Skipping con Cuerda', 0, 'Cardio', FALSE),
       ('Sentadillas con Salto', 10, 'Sentadillas con Salto', 0, 'Cardio', FALSE),
       ('Jump Squats', 10, 'Jump Squats', 0, 'Cardio', TRUE),
       ('Carrera hacia Atrás', 10, 'Carrera hacia Atrás', 0, 'Cardio', FALSE),
       ('Plancha con Palmada', 15, 'Plancha con Palmada', 0, 'Cardio', FALSE),
       ('Carrera con Rodillas Altas', 15, 'Carrera con Rodillas Altas', 0, 'Cardio', FALSE),
       ('Sprints de Corta Distancia', 10, 'Sprints de Corta Distancia', 0, 'Cardio', FALSE),
       ('Escaladores', 15, 'Escaladores', 0, 'Cardio', TRUE),
       ('Flexiones con Salto', 15, 'Flexiones con Salto', 0, 'Cardio', FALSE),
       ('Plancha con Rotación', 15, 'Plancha con Rotación', 0, 'Cardio', FALSE),
       ('Sprints en Pendiente', 15, 'Sprints en Pendiente', 0, 'Cardio', FALSE),
       ('Sentadillas Búlgaras. Realiza 3 series de 12 repeticiones por pierna.', 20, 'Sentadillas Búlgaras', 0,
        'Musculacion', FALSE),
       ('Press Arnold. Realiza 3 series de 10 repeticiones.', 20, 'Press Arnold', 0, 'Musculacion', FALSE),
       ('Fondos en Máquina. Realiza 3 series de 12 repeticiones.', 15, 'Fondos en Máquina', 0, 'Musculacion', FALSE),
       ('Curl de Bíceps con Barra Z. Realiza 3 series de 10 repeticiones.', 15, 'Curl de Bíceps con Barra Z', 0,
        'Musculacion', FALSE),
       ('Peso Muerto Rumano. Realiza 3 series de 8 repeticiones.', 25, 'Peso Muerto Rumano', 0, 'Musculacion', FALSE),
       ('Patada de Tríceps en Máquina. Realiza 3 series de 12 repeticiones.', 15, 'Patada de Tríceps en Máquina', 0,
        'Musculacion', FALSE),
       ('Elevaciones laterales en Polea. Realiza 3 series de 12 repeticiones.', 15, 'Elevaciones laterales en Polea', 0,
        'Musculacion', FALSE),
       ('Curl de Bíceps con Mancuerna. Realiza 3 series de 10 repeticiones por brazo.', 15,
        'Curl de Bíceps con Mancuerna', 0, 'Musculacion', FALSE),
       ('Sentadillas Frontales. Realiza 3 series de 12 repeticiones.', 20, 'Sentadillas Frontales', 0, 'Musculacion',
        FALSE),
       ('Pulldown al Pecho. Realiza 3 series de 12 repeticiones.', 20, 'Pulldown al Pecho', 0, 'Musculacion', FALSE),
       ('Flexiones en Máquina. Realiza 3 series de 12 repeticiones.', 15, 'Flexiones en Máquina', 0, 'Musculacion',
        FALSE),
       ('Curl de Bíceps Martillo. Realiza 3 series de 10 repeticiones.', 15, 'Curl de Bíceps Martillo', 0,
        'Musculacion', FALSE),
       ('Prensa de Hombros con Mancuernas. Realiza 3 series de 12 repeticiones.', 20,
        'Prensa de Hombros con Mancuernas', 0, 'Musculacion', FALSE),
       ('Curl de Bíceps con Barra EZ. Realiza 3 series de 10 repeticiones.', 15, 'Curl de Bíceps con Barra EZ', 0,
        'Musculacion', FALSE),
       ('Pull Over con Polea Alta. Realiza 3 series de 12 repeticiones.', 20, 'Pull Over con Polea Alta', 0,
        'Musculacion', FALSE),
       ('Curl de Bíceps en Polea Baja. Realiza 3 series de 12 repeticiones.', 15, 'Curl de Bíceps en Polea Baja', 0,
        'Musculacion', FALSE),
       ('Pulldown Trasero en Polea. Realiza 3 series de 12 repeticiones.', 20, 'Pulldown Trasero en Polea', 0,
        'Musculacion', FALSE),
       ('Press de Hombros con Barra. Realiza 3 series de 12 repeticiones.', 20, 'Press de Hombros con Barra', 0,
        'Musculacion', FALSE),
       ('Fondos en Máquina con agarre cerrado. Realiza 3 series de 12 repeticiones.', 15,
        'Fondos en Máquina con agarre cerrado', 0, 'Musculacion', FALSE),
       ('Curl de Bíceps en Banco Scott. Realiza 3 series de 10 repeticiones.', 15, 'Curl de Bíceps en Banco Scott', 0,
        'Musculacion', FALSE),
       ('Elevaciones Laterales con Mancuernas. Realiza 3 series de 12 repeticiones.', 15,
        'Elevaciones Laterales con Mancuernas', 0, 'Musculacion', FALSE),
       ('Pulldown al Pecho con agarre cerrado. Realiza 3 series de 12 repeticiones.', 20,
        'Pulldown al Pecho con agarre cerrado', 0, 'Musculacion', FALSE),
       ('Extensiones de Tríceps con Mancuerna. Realiza 3 series de 12 repeticiones.', 15,
        'Extensiones de Tríceps con Mancuerna', 0, 'Musculacion', FALSE),
       ('Curl de Bíceps con Cable. Realiza 3 series de 10 repeticiones.', 15, 'Curl de Bíceps con Cable', 0,
        'Musculacion', FALSE),
       ('Prensa de Hombros con Barra por detrás de la cabeza. Realiza 3 series de 12 repeticiones.', 20,
        'Prensa de Hombros con Barra por detrás de la cabeza', 0, 'Musculacion', TRUE),
       ('Prensa de Hombros con Mancuernas Sentado. Realiza 3 series de 12 repeticiones.', 20,
        'Prensa de Hombros con Mancuernas Sentado', 0, 'Musculacion', TRUE),
       ('Press Francés con Mancuerna. Realiza 3 series de 12 repeticiones.', 15, 'Press Francés con Mancuerna', 0,
        'Musculacion', TRUE),
       ('Press de Banca Declinado. Realiza 3 series de 10 repeticiones.', 20, 'Press de Banca Declinado', 0,
        'Musculacion', TRUE),
       ('Press de Banca con Mancuernas. Realiza 3 series de 12 repeticiones.', 20, 'Press de Banca con Mancuernas', 0,
        'Musculacion', TRUE),
       ('Press Militar con Barra. Realiza 3 series de 12 repeticiones.', 20, 'Press Militar con Barra', 0,
        'Musculacion', TRUE),
       ('Press Francés con Barra. Realiza 3 series de 12 repeticiones.', 15, 'Press Francés con Barra', 0,
        'Musculacion', TRUE),
       ('Elevaciones Frontales con Mancuernas. Realiza 3 series de 12 repeticiones.', 15,
        'Elevaciones Frontales con Mancuernas', 0, 'Musculacion', TRUE),
       ('Curl de Bíceps en Polea Alta. Realiza 3 series de 12 repeticiones.', 15, 'Curl de Bíceps en Polea Alta', 0,
        'Musculacion', TRUE),
       ('Curl de Bíceps Martillo con Mancuernas. Realiza 3 series de 10 repeticiones.', 15,
        'Curl de Bíceps Martillo con Mancuernas', 0, 'Musculacion', TRUE),
       ('Fondos en Máquina con agarre abierto. Realiza 3 series de 12 repeticiones.', 15,
        'Fondos en Máquina con agarre abierto', 0, 'Musculacion', TRUE),
       ('Peso Muerto Convencional. Realiza 3 series de 8 repeticiones.', 25, 'Peso Muerto Convencional', 0,
        'Musculacion', TRUE),
       ('Dominadas con agarre ancho. Realiza 3 series de 8 repeticiones.', 20, 'Dominadas con agarre ancho', 0,
        'Musculacion', TRUE),
       ('Remo con Mancuerna. Realiza 3 series de 12 repeticiones.', 20, 'Remo con Mancuerna', 0, 'Musculacion', TRUE),
       ('Elevaciones Laterales con Cable. Realiza 3 series de 12 repeticiones.', 15, 'Elevaciones Laterales con Cable',
        0, 'Musculacion', TRUE),
       ('Press de Banca Inclinado con Barra. Realiza 3 series de 10 repeticiones.', 20,
        'Press de Banca Inclinado con Barra', 0, 'Musculacion', TRUE),
       ('Curl de Bíceps 21. Realiza 3 series de 21 repeticiones.', 15, 'Curl de Bíceps 21', 0, 'Musculacion', TRUE),
       ('Fondos en Máquina para Tríceps. Realiza 3 series de 12 repeticiones.', 15, 'Fondos en Máquina para Tríceps', 0,
        'Musculacion', TRUE),
       ('Peso Muerto Sumo. Realiza 3 series de 8 repeticiones.', 25, 'Peso Muerto Sumo', 0, 'Musculacion', TRUE),
       ('Pull Over con Mancuerna. Realiza 3 series de 12 repeticiones.', 20, 'Pull Over con Mancuerna', 0,
        'Musculacion', TRUE);
-- Insertar datos de prueba en rutina_diaria_ejercicio
-- INSERT INTO rutina_diaria_ejercicio (rutina_diaria_id, ejercicio_id) VALUES
-- (1, 1),
-- (1, 2),
-- (1, 3),
-- (2, 4),
-- (2, 5),
-- (3, 6),
-- (3, 7),
-- (4, 8),
-- (4, 9),
-- (5, 10);

-- Insertar datos de prueba en membresia
-- INSERT INTO membresia (tipo, duracion, valor, fecha_inicio, fecha_fin,usuario_id) VALUES
-- ('Nivel 0', 30, 0, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 30 DAY),1),
-- ('Nivel 1', 60, 50, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 60 DAY),2),
-- ('Nivel 2', 90, 100, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 90 DAY),3);

-- Insertar datos de prueba en pesoRegistro
INSERT INTO pesoRegistro (usuario_id, fecha, peso)
VALUES (1, '2024-01-01', 71.0),
       (1, '2024-02-01', 70.5),
       (1, '2024-03-01', 70.0),
       (2, '2024-01-01', 76.0),
       (2, '2024-02-01', 75.5),
       (2, '2024-03-01', 75.0),
       (3, '2024-01-01', 61.0),
       (3, '2024-02-01', 60.5),
       (3, '2024-03-01', 60.0)
