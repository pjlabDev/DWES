<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar pelicula</title>
</head>
<body>
	
	<form action="CineController" method="POST">
	
		<p>Titulo de la pelicula a eliminar</p>
		<input type="text" name="titulo" placeholder="Titulo pelicula">
		<br>
		<br>
		<input type="submit" name="action" value="Eliminar pelicula">
		
	</form>

</body>
</html>