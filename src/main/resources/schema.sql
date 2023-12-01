CREATE TABLE Dueno(
    dni VARCHAR(9) NOT NULL PRIMARY KEY,
    nombre_apellidos VARCHAR(50)
);

CREATE TABLE Mascota(
    codigo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    num_chip INT,
    nombre VARCHAR(30),
    corriente_vacunacion BOOLEAN,
    dni_dueno VARCHAR(9),
    FOREIGN KEY (dni_dueno) REFERENCES Dueno(dni)
);

