CREATE DATABASE BBDDEXAMEN;
USE BBDDEXAMEN;

CREATE TABLE Vehiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) CHECK (tipo IN ('coche', 'moto', 'barco', 'camion', 'avion')),
    marca VARCHAR(50),
    potencia INT,
    fecha_de_compra DATE
);


-- Datos en la tabla Vehiculos
INSERT INTO Vehiculos (tipo, marca, potencia, fecha_de_compra) VALUES
('coche', 'Toyota', 150, '2021-05-21'),
('moto', 'Yamaha', 90, '2022-03-15'),
('barco', 'Bayliner', 200, '2020-07-10'),
('camion', 'Mercedes-Benz', 320, '2019-11-05'),
('avion', 'Boeing', 2000, '2018-08-30');

SELECT * FROM Vehiculos;


