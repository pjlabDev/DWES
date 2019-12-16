<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Alta Pelicula</title>
</head>
<body>

	<div style="text-align:center">
	
		<h2>Bienvenido al alta de Peliculas</h2>
	
		<p>Rellenando el siguiente formulario podrás añadir una nueva pelicula.</p>
		
		<form action="addPeliculas" method="POST">
			
			<div class="form-group">
			
				<label>Nombre director</label>
				<input class="form-control" type="text" name="director" placeholder="Nombre director" required>
				<label>Titulo pelicula</label>
				<input class="form-control" type="text" name="titulo" placeholder="Titulo pelicula" required>
				<label>Fecha de alta</label>
				<input class="form-control" type="text" name="fecha" placeholder="YYYY-MM-DD" required>
				<small class="form-text text-muted">Formato de fecha YYYY-MM-DD</small>
				<br>
				<input class="btn btn-success" type="submit" value="Anadir pelicula">
				
			</div>
		
		</form>
		
		<a href="MantenimientoPelicula"><button type="button" class="btn btn-danger">Cancelar</button></a>
		
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
</body>
</html>