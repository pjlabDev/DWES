<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Pagina de bienvenida</title>
</head>
<body>
	
	<div style="text-align: center">
	
		<h1>Bienvenido ${user}</h1>
		
		<br>
		<br>
		
		<a href="loginPage"><button type="button" class="btn btn-warning">Volver</button></a>
		<br>
		<br>
		<a href="MantenimientoPelicula"><button type="button" class="btn btn-primary">Mantenimiento Peliculas</button></a>
		<br>
		<br>
		<a href="addFormUser"><button type="button" class="btn btn-primary">Alta Director</button></a>
		
	</div>


</body>
</html>