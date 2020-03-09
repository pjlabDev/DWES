<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Pagina de bienvenida</title>
</head>
<body>

	<nav class="navbar navbar-expand-sm navbar-light bg-light nav-tabs">
		<div class="navbar-brand col-md-3">
		</div>
		<h1 style="text-align: center" class="col-md-6">Bienvenido ${correo}</h1>
		<a href="/" style="float: left;"><button type="button" class="btn btn-outline-danger my-2 my-sm-0">Cerrar Sesión</button></a>
	</nav>

	<br>

	<div class="container" style="text-align: center; bg-color: light-gray">
		<h2>Categorias</h2>
		<br>
		<div class="row justify-content-center">
			<div class="col-auto">
				<table style="text-align: center;">
					<tr>
						<td>
							<form action="productos" method="POST" accept-charset="UTF-8">
								<c:forEach items="${list1}" var="item">
									<input type="hidden" name="correo" value="${correo}">
									<input type="hidden" name="clave" value="${clave}">
									<input type="hidden" name="cod" value="${item.codCat}">
									<input type="submit" class="btn btn-primary"
										value="${item.nombre}">
								</c:forEach>
							</form>
						</td>
						<td>
							<form action="productos" method="POST" accept-charset="UTF-8">
								<c:forEach items="${list2}" var="item">
									<input type="hidden" name="correo" value="${correo}">
									<input type="hidden" name="clave" value="${clave}">
									<input type="hidden" name="cod" value="${item.codCat}">
									<input type="submit" class="btn btn-primary"
										value="${item.nombre}">
								</c:forEach>
							</form>
						</td>
						<td>
							<form action="productos" method="POST" accept-charset="UTF-8">
								<c:forEach items="${list3}" var="item">
									<input type="hidden" name="correo" value="${correo}">
									<input type="hidden" name="clave" value="${clave}">
									<input type="hidden" name="cod" value="${item.codCat}">
									<input type="submit" class="btn btn-primary"
										value="${item.nombre}">
								</c:forEach>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>