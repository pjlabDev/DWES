<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Calificacion - Peliculas</title>
</head>
<body>

	<nav class="navbar navbar-expand-sm navbar-light bg-light nav-tabs">
		<div class="navbar-brand col-md-3">
			<a href="/"><button type="button" class="btn btn-warning">Volver</button></a>
		</div>
		<h1 style="text-align: center" class="col-md-6">Calificacion de peliculas</h1>
	</nav>
	
	<br>
	<br>
	
	<div style="text-align:center">
	
		<form action="calificarPelis" method="POST">
			
			<label>Id Usuario</label>
			<input class="form-control" type="number" name="idUsuario" value="${id}" readonly="readonly"> 
				
			<select class="form-control" name="idPelicula">
	
				<option selected disabled>Peliculas</option>
	
				<c:forEach items="${listaPelis}" var="item">
	
					<option value="${item.id}">${item.titulo}</option>
	
				</c:forEach>
	
			</select>
			
			<select class="form-control" name="calificacion">
	
				<option selected disabled>Calificacion</option>
	
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
				<option>9</option>
				<option>10</option>
	
			</select>
			
			<input class="btn btn-primary" type="submit" value="Calificar">

		</form>
	
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	

</body>
</html>