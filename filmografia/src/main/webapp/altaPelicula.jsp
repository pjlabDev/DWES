<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Pelicula</title>
</head>
<body>

	<h2>Bienvenido al alta de Peliculas</h2>
	
	<p>Rellenando el siguiente formulario podrás añadir una nueva pelicula.</p>
	
	<form action="CineController" method="POST">
	
		Nombre director
		<input type="text" name="director" placeholder="Nombre director">
		Titulo pelicula
		<input type="text" name="titulo" placeholder="Titulo pelicula">
		Fecha de alta
		<input type="text" name="fecha" placeholder="YYYY-MM-DD">
		<br>
		<input type="submit" name="action" value="Añadir pelicula">
	
	</form>

</body>
</html>