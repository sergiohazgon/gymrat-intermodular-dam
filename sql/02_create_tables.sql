CREATE TABLE ejercicio (
    id_ejercicio INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    grupo_muscular VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255),
    url_video VARCHAR(255)
);

CREATE TABLE rutina (
    id_rutina INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    objetivo VARCHAR(100),
    fecha_creacion DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE rutina_ejercicio (
    id_rutina INT NOT NULL,
    id_ejercicio INT NOT NULL,
    series INT NOT NULL,
    repeticiones INT NOT NULL,
    orden INT NOT NULL,
    PRIMARY KEY (id_rutina, id_ejercicio),
    FOREIGN KEY (id_rutina) REFERENCES rutina(id_rutina),
    FOREIGN KEY (id_ejercicio) REFERENCES ejercicio(id_ejercicio)
);