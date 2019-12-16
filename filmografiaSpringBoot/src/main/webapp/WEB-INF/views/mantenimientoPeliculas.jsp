<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Mantenimiento Peliculas</title>
</head>
<body>

	<div style="text-align:center">

		<h2>Mantenimiento de Peliculas</h2>

		<div class="row justify-content-center">
			<div class="col-auto">
				<table
					class="mt-5 table table-striped table-inverse table-responsive table-center table-bordered text-center">
					<thead class="thead-inverse">
						<tr>
							<td>Director</td>
							<td>Título</td>
							<td>Fecha</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaPelis}" var="item">

							<tr>

								<td>${item.director}</td>
								<td>${item.titulo}</td>
								<td>${item.fecha}</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<a href="formPeliculas"><button type="button" class="btn btn-primary">Añadir pelicula</button></a>
		<br>
		<br>
		<a href="updateFormPeliculas"><button type="button" class="btn btn-primary">Modificar pelicula</button></a>
		<br>
		<br>
		<a href="deleteFormPeliculas"><button type="button" class="btn btn-danger">Eliminar pelicula</button></a>
		<br>
		<br>
		<a href="principal"><button type="button" class="btn btn-success">Inicio</button></a>

	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>