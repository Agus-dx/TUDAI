-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2026-04-21 18:43:25.567

-- tables
-- Table: AREA_CONOCIMIENTO
CREATE TABLE AREA_CONOCIMIENTO (
    area char(5)  NOT NULL,
    nombre varchar(50)  NOT NULL,
    descripcion varchar(200)  NOT NULL,
    ubicacion varchar(30)  NULL,
    CONSTRAINT PK_AREA_CONOCIMIENTO PRIMARY KEY (area)
);

-- Table: EJEMPLAR
CREATE TABLE EJEMPLAR (
    nro_libro int  NOT NULL,
    area char(5)  NOT NULL,
    nro_ejemplar int  NOT NULL,
    estado_ejemplar varchar(10)  NOT NULL,
    CONSTRAINT PK_EJEMPLAR PRIMARY KEY (nro_ejemplar,nro_libro,area)
);

-- Table: LIBRO
CREATE TABLE LIBRO (
    nro_libro int  NOT NULL,
    area char(5)  NOT NULL,
    titulo varchar(100)  NOT NULL,
    resumen varchar(500)  NOT NULL,
    autor varchar(50)  NOT NULL,
    editorial varchar(30)  NOT NULL,
    anio_publicacion int  NOT NULL,
    CONSTRAINT PK_LIBRO PRIMARY KEY (nro_libro,area)
);

-- Table: PRESTAMO
CREATE TABLE PRESTAMO (
    nro_usuario int  NOT NULL,
    nro_libro int  NOT NULL,
    area char(5)  NOT NULL,
    nro_ejemplar int  NOT NULL,
    fecha_retiro date  NOT NULL,
    fecha_devolucion date  NULL,
    situacion char(1)  NOT NULL,
    CONSTRAINT PK_PRESTAMO PRIMARY KEY (fecha_retiro,nro_ejemplar,area,nro_libro,nro_usuario)
);

-- Table: USUARIO
CREATE TABLE USUARIO (
    nro_usuario int  NOT NULL,
    apell_nombre varchar(50)  NOT NULL,
    e_mail varchar(50)  NOT NULL,
    telefono varchar(20)  NOT NULL,
    fecha_alta date  NOT NULL,
    categoria char(1)  NULL,
    institucion varchar(30)  NOT NULL,
    CONSTRAINT PK_USUARIO PRIMARY KEY (nro_usuario)
);

-- foreign keys
-- Reference: FK_EJEMPLAR_LIBRO (table: EJEMPLAR)
ALTER TABLE EJEMPLAR ADD CONSTRAINT FK_EJEMPLAR_LIBRO
    FOREIGN KEY (nro_libro, area)
    REFERENCES LIBRO (nro_libro, area)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_LIBRO_AREA_CONOCIMIENTO (table: LIBRO)
ALTER TABLE LIBRO ADD CONSTRAINT FK_LIBRO_AREA_CONOCIMIENTO
    FOREIGN KEY (area)
    REFERENCES AREA_CONOCIMIENTO (area)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_PRESTAMO_EJEMPLAR (table: PRESTAMO)
ALTER TABLE PRESTAMO ADD CONSTRAINT FK_PRESTAMO_EJEMPLAR
    FOREIGN KEY (nro_ejemplar, nro_libro, area)
    REFERENCES EJEMPLAR (nro_ejemplar, nro_libro, area)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_PRESTAMO_USUARIO (table: PRESTAMO)
ALTER TABLE PRESTAMO ADD CONSTRAINT FK_PRESTAMO_USUARIO
    FOREIGN KEY (nro_usuario)
    REFERENCES USUARIO (nro_usuario)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

