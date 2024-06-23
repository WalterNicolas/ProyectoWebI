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
    INSERT INTO pesoregistro (usuario_id, fecha, peso)
VALUES
    (1, '2024-01-01', 71.0),
    (1, '2024-02-01', 70.5),
    (1, '2024-03-01', 70.0),
    (2, '2024-01-01', 76.0),
    (2, '2024-02-01', 75.5),
    (2, '2024-03-01', 75.0),
    (3, '2024-01-01', 61.0),
    (3, '2024-02-01', 60.5),
    (3, '2024-03-01', 60.0);


    INSERT INTO articulo (titulo, subtitulo, imagen, contenido, tipoEntrenamiento) VALUES
    ('Guía Completa para el Entrenamiento de Fuerza', 'Mejora tu fuerza y masa muscular con estos consejos', '/img/ejervicioDos.png', 'El entrenamiento de fuerza es esencial para desarrollar músculo y mejorar tu salud general. Comienza con ejercicios básicos como el press de banca, sentadillas y peso muerto. Asegúrate de aumentar gradualmente el peso para evitar lesiones. Mantén una técnica adecuada y enfócate en la forma correcta durante cada repetición. No te olvides de incluir un calentamiento adecuado antes de cada sesión y de enfriar después del entrenamiento para facilitar la recuperación muscular y prevenir lesiones.', 'Musculacio	n'),

    ('Beneficios del Entrenamiento con Pesas', 'Más allá de los músculos: mejora tu salud', '/img/ejervicioUno.png', 'Levantar pesas no solo aumenta la masa muscular, sino que también mejora la densidad ósea, acelera el metabolismo y reduce el riesgo de enfermedades crónicas. Incorpora pesas en tu rutina para ver estos beneficios. Además, el entrenamiento con pesas puede mejorar tu estado de ánimo y aumentar tu energía diaria, haciéndote sentir más fuerte y seguro.', 'Musculacion'),

    ('Rutina de Hipertrofia para Principiantes', 'Cómo empezar en el mundo de la musculación', '/img/ejervicioTres.png', 'Si eres nuevo en la musculación, una rutina de hipertrofia es ideal para ganar músculo. Enfócate en ejercicios compuestos y realiza de 3 a 4 series de 8 a 12 repeticiones. No olvides calentar antes de entrenar y estirar después. Con el tiempo, podrás aumentar el peso y la intensidad de tus entrenamientos, asegurándote de progresar de manera segura y efectiva.', 'Musculacion'),

    ('Entrenamiento de Cuerpo Completo', 'Ejercicios efectivos para trabajar todos los músculos', '/img/ejervicioCuatro.png', 'Una rutina de cuerpo completo es excelente para aquellos con tiempo limitado. Incluye ejercicios como el press militar, dominadas y remo con barra. Realiza esta rutina 3 veces por semana para obtener mejores resultados. Además, asegúrate de descansar adecuadamente entre sesiones para permitir que tus músculos se recuperen y crezcan.', 'Musculacion'),

    ('Importancia del Descanso en la Musculación', 'Por qué tu cuerpo necesita recuperarse', '/img/ejervicioCinco.png', 'El descanso es crucial para el crecimiento muscular. Asegúrate de dormir al menos 7-8 horas por noche y toma días de descanso entre sesiones intensas de entrenamiento para permitir la recuperación muscular. Sin un descanso adecuado, tus músculos no tendrán la oportunidad de repararse y crecer, lo que podría llevar a lesiones y fatiga.', 'Musculacion'),

    ('Cómo Evitar Estancarte en el Gimnasio', 'Mantén tus progresos en ascenso', '/img/ejervicioDos.pngg', 'Si sientes que te has estancado, prueba a variar tus ejercicios, aumenta la intensidad y asegúrate de comer adecuadamente. La sobrecarga progresiva es clave para seguir avanzando en tus objetivos. Mantén un registro de tus entrenamientos y haz ajustes regularmente para asegurarte de que estás desafiando a tus músculos de nuevas maneras.', 'Musculacion'),

    ('Nutrición para el Crecimiento Muscular', 'Qué comer para maximizar tus ganancias', '/img/ejervicioCinco.png', 'Una dieta rica en proteínas, carbohidratos y grasas saludables es esencial para el crecimiento muscular. Consume alimentos como pollo, arroz integral, aguacates y batidos de proteínas para apoyar tus entrenamientos. Además, asegúrate de mantenerte bien hidratado y de comer una variedad de alimentos para obtener todos los nutrientes necesarios.', 'Musculacion'),

    ('Suplementos para la Musculación', 'Lo que realmente necesitas', '/img/ejervicioTres.png', 'Los suplementos pueden ser útiles, pero no son necesarios para todos. La proteína en polvo, la creatina y los BCAA son populares entre los culturistas. Consulta con un nutricionista antes de comenzar a tomar cualquier suplemento para asegurarte de que sean adecuados para tus necesidades específicas.', 'Musculacion'),

    ('Entrenamiento de Alta Intensidad (HIIT) para la Musculación', 'Aumenta la intensidad y maximiza los resultados', '/img/ejervicioTres.png', 'Incorporar sesiones de HIIT en tu rutina puede mejorar tu resistencia y acelerar la quema de grasa. Combina ejercicios de fuerza con ráfagas cortas de cardio intenso para obtener los beneficios. Este tipo de entrenamiento también puede ayudarte a ahorrar tiempo, ya que las sesiones de HIIT son generalmente más cortas pero más efectivas.', 'Musculacion'),

    ('Consejos para Levantar Pesas de Forma Segura', 'Evita lesiones y mejora tu técnica', '/img/ejervicioUno.png', 'La técnica correcta es crucial para evitar lesiones. Mantén la espalda recta, usa un cinturón de levantamiento si es necesario y no dudes en pedir ayuda si estás levantando pesos pesados. Además, asegúrate de calentar adecuadamente antes de cada sesión de levantamiento y de enfriar después para reducir el riesgo de lesiones.', 'Musculacion'),

    ('Rutina de Entrenamiento para Definición Muscular', 'Cómo lograr un cuerpo definido', '/img/ejervicioDos.png', 'Para definir los músculos, combina entrenamiento de fuerza con cardio y una dieta baja en calorías. Realiza series más largas con menos peso y reduce tu ingesta calórica para quemar grasa corporal. Mantén una dieta equilibrada y asegúrate de mantener un déficit calórico para ver resultados en la definición muscular.', 'Musculacion'),

    ('La Importancia del Calentamiento y Enfriamiento', 'Cómo preparar tu cuerpo para el entrenamiento', '/img/ejervicioCuatro.png', 'El calentamiento prepara tus músculos para el esfuerzo y reduce el riesgo de lesiones. Dedica 10 minutos a actividades ligeras como estiramientos dinámicos antes de empezar tu rutina de entrenamiento. Después de entrenar, realiza estiramientos estáticos para ayudar a la recuperación muscular y reducir la rigidez.', 'Musculacion'),

    ('Mejores Ejercicios para Pecho', 'Desarrolla un pecho fuerte y definido', '/img/ejervicioCuatro.png', 'El press de banca es uno de los mejores ejercicios para desarrollar el pecho. También puedes incluir variaciones como el press inclinado y el press declinado para trabajar diferentes áreas del pecho. No olvides complementar con ejercicios como aperturas con mancuernas y fondos en paralelas.', 'Musculacion'),

    ('Cómo Mejorar tus Sentadillas', 'Técnicas y consejos para un mejor rendimiento', '/img/ejervicioTres.png', 'La sentadilla es un ejercicio fundamental para fortalecer las piernas y glúteos. Asegúrate de mantener una postura adecuada, con la espalda recta y las rodillas alineadas con los pies. Practica la sentadilla profunda para maximizar la activación muscular.', 'Musculacion'),

    ('Entrenamiento con Pesas para Mujeres', 'Rompiendo mitos y obteniendo resultados', '/img/ejervicioCuatro.png', 'El entrenamiento con pesas no hará que las mujeres se vuelvan musculosas de forma exagerada, sino que les ayudará a tonificar y fortalecer su cuerpo. Las mujeres pueden beneficiarse de levantamientos compuestos como el peso muerto y el press de banca. La clave está en la consistencia y en seguir una rutina bien estructurada.', 'Musculacion');

