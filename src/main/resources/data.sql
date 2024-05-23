/*CREATE DATABASE IF NOT EXISTS tallerwebi;
USE tallerwebi;
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(50),
    activo TINYINT(1),
    latitud DOUBLE,
    longitud DOUBLE
);

CREATE TABLE Lugar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    ubicacion VARCHAR(255),
    longitud DOUBLE,
    latitud DOUBLE
);

CREATE TABLE IF NOT EXISTS Lugar (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   nombre VARCHAR(255) NOT NULL,
   direccion VARCHAR(255),
   latitud DOUBLE,
   longitud DOUBLE
);
INSERT INTO Lugar (nombre, ubicacion, latitud, longitud) VALUES
    ('Gimnasio XYZ', 'Calle Falsa 123', -34.755432, -58.592541),
    ('Parque ABC', 'Avenida Principal 456', -34.748912, -58.579831),
    ('Centro Deportivo DEF', 'Calle Real 789', -34.753621, -58.587421),
    ('Fitness Center', 'Calle Libertad 456', -34.751234, -58.583210),
    ('Parque Central', 'Avenida San Martín 789', -34.746789, -58.575643),
    ('Gimnasio Active', 'Calle Buenos Aires 321', -34.748912, -58.580123),
    ('Polideportivo Municipal', 'Avenida Rivadavia 234', -34.752367, -58.588765),
    ('Club Deportivo Alfa', 'Calle Urquiza 567', -34.755432, -58.590123),
    ('Estadio Omega', 'Avenida Belgrano 890', -34.749012, -58.576543);


INSERT INTO Usuario (email, password, rol, activo, latitud, longitud) VALUES
    ('admin@admin.com', 'password', 'ADMIN', true, -34.71133532026949, -58.60603627471634);*/
/*INSERT INTO usuario (email, password, rol, nombre, apellido, activo, longitud, latitud, access_level) VALUES
    ('user1@example.com', 'password1', 'ROLE_USER', 'John', 'Doe', false, 34.0522, -118.2437, 1),
    ('user2@example.com', 'password2', 'ROLE_ADMIN', 'Jane', 'Smith', true, 40.7128, -74.0060, 2),
    ('admin@admin.com', 'password', 'ADMIN', 'Jane', 'Smith' ,true,-34.71133532026949, -58.60603627471634);*/
