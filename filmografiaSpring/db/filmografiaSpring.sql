CREATE DATABASE cine;

USE cine;

CREATE TABLE pelicula (
  director VARCHAR(20),
  titulo VARCHAR(20),
  fecha DATE
);

CREATE TABLE usuario (
	nombre VARCHAR(20),
	password VARCHAR(20)
);

INSERT INTO pelicula VALUES('Pedro','La Casa de Papel',SYSDATE());
INSERT INTO pelicula VALUES('James Gunn','Guardianes de la Galaxia V.1 V.2',SYSDATE());
INSERT INTO pelicula VALUES('Stan Lee','Spiderman',SYSDATE());

INSERT INTO usuario VALUES('Pedro','pedro');
INSERT INTO usuario VALUES('James','james');
INSERT INTO usuario VALUES('stan','stan');