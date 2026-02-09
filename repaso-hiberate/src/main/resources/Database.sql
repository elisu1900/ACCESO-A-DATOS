CREATE DATABASE formacion;
USE formacion;

-- Tabla base para herencia
CREATE TABLE persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    email VARCHAR(100),
    tipo_persona VARCHAR(20)
);

-- Alumno (hereda de persona)
CREATE TABLE alumno (
    id INT PRIMARY KEY,
    num_expediente VARCHAR(20),
    FOREIGN KEY (id) REFERENCES persona(id)
);

-- Profesor (hereda de persona)
CREATE TABLE profesor (
    id INT PRIMARY KEY,
    especialidad VARCHAR(50),
    FOREIGN+ KEY (id) REFERENCES persona(id)
);

-- Curso
CREATE TABLE curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    horas INT,
    profesor_id INT,
    FOREIGN KEY (profesor_id) REFERENCES profesor(id)
);

-- Matricula
CREATE TABLE matricula (
    id INT AUTO_INCREMENT PRIMARY KEY,
    alumno_id INT,
    curso_id INT,
    nota DECIMAL(4,2),
    FOREIGN KEY (alumno_id) REFERENCES alumno(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);

-- DATOS DE PRUEBA
INSERT INTO persona (nombre, email, tipo_persona) VALUES
('Ana Torres', 'ana@correo.com', 'ALUMNO'),
('Luis Gómez', 'luis@correo.com', 'ALUMNO'),
('Carlos Ruiz', 'carlos@correo.com', 'PROFESOR');

INSERT INTO alumno VALUES
(1, 'EXP001'),
(2, 'EXP002');

INSERT INTO profesor VALUES
(3, 'Programación');

INSERT INTO curso (nombre, horas, profesor_id) VALUES
('Java', 120, 3),
('Bases de Datos', 80, 3);

INSERT INTO matricula (alumno_id, curso_id, nota) VALUES
(1, 1, 8.5),
(1, 2, 7.0),
(2, 1, 6.5);
