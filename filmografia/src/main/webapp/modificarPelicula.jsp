<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica la pelicula</title>
</head>
<body>

	<form action="CineController" method="POST">
	
		<p>Titulo de la pelicula a modificar</p>
		<input type="text" name="tituloPeli" placeholder="Titulo pelicula">
		<br>
		<br>
		<p>Director</p>
		<input type="text" name="director" placeholder="Director">
		<p>Titulo</p>
		<input type="text" name="titulo" placeholder="Titulo">
		<p>Fecha</p>
		<input type="text" name="fecha" placeholder="YYYY-MM-DD">
		<br>
		<input type="submit" name="action" value="Modificar pelicula">
		
	</form>

</body>
</html>