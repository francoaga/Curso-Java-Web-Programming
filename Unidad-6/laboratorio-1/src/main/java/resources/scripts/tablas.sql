USE `java-web-programming`;

/*TABLA 'tipos_documentos'*/
CREATE TABLE documentos(
	id_documento INT NOT NULL AUTO_INCREMENT,
    tipo VARCHAR(10) NOT NULL,
    descripcion VARCHAR(30) NOT NULL,
    UNIQUE KEY id_documento_uq(id_documento)
);

/*TABLA 'cursos'*/
CREATE TABLE cursos(
	id_curso INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    UNIQUE KEY id_curso_uq(id_curso)
);

/*TABLA 'alumnos'*/
CREATE TABLE alumnos(
	id_alumno INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
	id_documento INT NOT NULL,
    nro_documento VARCHAR(10) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    fecha_ingreso DATE NOT NULL,
    UNIQUE KEY id_alumno_uq(id_alumno),
    FOREIGN KEY documentos_alumnos(id_documento) REFERENCES documentos(id_documento)
);

/*TABLA 'alumno_curso'*/
CREATE TABLE alumno_curso(
	id_alumno INT NOT NULL,
    id_curso INT NOT NULL,
    FOREIGN KEY alumno_curso_alumnos(id_alumno) REFERENCES alumnos(id_alumno),
    FOREIGN KEY alumno_curso_cursos(id_curso) REFERENCES cursos(id_curso)
);

/*TABLA 'directores'*/
CREATE TABLE directores(
	id_director INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    id_documento INT NOT NULL,
    nro_documento VARCHAR(10) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    carrera VARCHAR(30) NOT NULL,
    fecha_cargo DATE NOT NULL,
    sueldo decimal(10,2),
    UNIQUE KEY id_director_uq(id_director),
    FOREIGN KEY directores_documentos(id_documento) REFERENCES documentos(id_documento)
);

/*TABLA 'administrativos'*/
CREATE TABLE administrativos(
	id_administrativo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    id_documento INT NOT NULL,
    nro_documento VARCHAR(10) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    fecha_cargo DATE NOT NULL,
    sueldo decimal(10,2),
    UNIQUE KEY id_administrativo_uq(id_administrativo),
    FOREIGN KEY administrativos_documentos(id_documento) REFERENCES documentos(id_documento)
);

/*TABLA 'administrativos'*/
CREATE TABLE profesores(
	id_profesor INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    id_documento INT NOT NULL,
    nro_documento VARCHAR(10) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    fecha_cargo DATE NOT NULL,
    sueldo decimal(10,2),
    UNIQUE KEY id_profesor_uq(id_profesor),
    FOREIGN KEY profesores_documentos(id_documento) REFERENCES documentos(id_documento)
);

/*TABLA 'profesor_curso'*/
CREATE TABLE profesor_curso(
	id_profesor INT NOT NULL,
    id_curso INT NOT NULL,
    FOREIGN KEY profesor_curso_alumnos(id_profesor) REFERENCES profesores(id_profesor),
    FOREIGN KEY profesor_curso_cursos(id_curso) REFERENCES cursos(id_curso)
);
