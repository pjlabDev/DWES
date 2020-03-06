<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Mantenimiento Peliculas</title>
</head>
<body>
	
	<nav class="navbar navbar-expand-sm navbar-light bg-light nav-tabs">
			<div class="navbar-brand col-md-3">
				<form action="categoria" method="POST">
					<input type="hidden" name="correo" value="${correo}">
					<input type="hidden" name="clave" value="${clave}">
					<input type="submit" class="btn btn-warning" value="Volver">
				</form>
			</div>
			<h1 style="text-align:center" class="col-md-6">Productos</h1>
        </nav>
	
	<div style="text-align:center">

		<div class="row justify-content-center">
			<div class="col-auto">
				<table
					class="mt-5 table table-striped table-inverse table-responsive table-center table-bordered text-center">
					<caption>Listado de Productos</caption>
					<thead class="thead-inverse">
						<tr>
							<th id="codprod">CodProd</th>
							<th id="nombre">Nombre</th>
							<th id="descripcion">Descripcion</th>
							<th id="peso">Peso</th>
							<th id="stock">Stock</th>
							<th id="categoria">Categoria</th>
							<th id="categoria">Unidades</th>
							<th id="comprar">Comprar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaProd}" var="item">
								<tr>
									<td>${item.codProd}</td>
									<td>${item.nombre}</td>
									<td>${item.descripcion}</td>
									<td>${item.peso}</td>
									<td>${item.stock}</td>
									<td>${item.categoria}</td>
									<form action="productosC" method="POST" accept-charset="UTF-8">
										<input type="hidden" name="codProd" value="${item.codProd}">
										<input type="hidden" name="codCat" value="${codCat}">
										<input type="hidden" name="nombre" value="${item.nombre}">
										<input type="hidden" name="descripcion" value="${item.descripcion}">
										<input type="hidden" name="peso" value="${item.peso}">
										<td><input type="number" name="unidades" min=1 max="${item.stock}"></td>
										<td><input type="submit" class="btn btn-primary" value="Comprar"></td>
									</form>
								</tr>							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<a href="/carrito"><button type="button" class="btn btn-primary">Ver Carrito</button></a>

	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>