CREATE TABLE Dueno(
    dni VARCHAR(9) NOT NULL PRIMARY KEY,
    nombre_apellidos VARCHAR(50)
);

CREATE TABLE Mascota(
    num_chip INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(30),
    corriente_vacunacion BOOLEAN,
    dni_dueno VARCHAR(9)
);

