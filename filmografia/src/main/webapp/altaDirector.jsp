<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Director</title>
</head>
<body>
	
	<h2>Bienvenido al alta de Directores Admin.</h2>
	
	<p>Rellenando el siguiente formulario podrás añadir un nuevo director administrador.</p>
	
	<form action="CineController" method="POST">
	
		<p>Nombre director</p>
		<input type="text" name="director" placeholder="Nombre director">
		<p>Contraseña</p>
		<input type="password" name="pass" placeholder="Contraseña">
		<br>
		<input type="submit" name="action" value="Añadir director">
	
	</form>
	
	
</body>
</html>