INSERT INTO Usuario (email, password, rol, activo) VALUES ('usuario1@example.com', 'password1', 'USER', true);
INSERT INTO Usuario (email, password, rol, activo) VALUES ('usuario2@example.com', 'password2', 'USER', true);
INSERT INTO Usuario (email, password, rol, activo) VALUES ('admin@example.com', 'admin123', 'ADMIN', true);
INSERT INTO Usuario (email, password, rol, activo) VALUES ('test@unlam.edu.ar', 'test', 'ADMIN', true);


INSERT INTO Exercise (Name, Day, week, Type, Series, Repeat, usuario_id) VALUES ('Flexiones', 'LUNES', 1, 'PECHO', 4, 12, 1);
INSERT INTO Exercise (Name, Day, week, Type, Series, Repeat, usuario_id) VALUES ('Sentadillas', 'MARTES', 1, 'PIERNAS', 3, 10, 1);
INSERT INTO Exercise (Name, Day, week, Type, Series, Repeat, usuario_id) VALUES ('Abdominales', 'MIERCOLES', 1, 'ABDOMEN', 4, 15, 1);
