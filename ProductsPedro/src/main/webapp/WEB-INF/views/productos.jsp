<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Productos</title>
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
			<a href="/" style="float: left;"><button type="button" class="btn btn-outline-danger my-2 my-sm-0">Cerrar Sesión</button></a>
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
									<form action="comprar" method="POST">
										<input type="hidden" name="correo" value="${correo}">
										<input type="hidden" name="clave" value="${clave}">
										<input type="hidden" readonly="readonly" name="codCat" value="${codCat}">
										<td><input type="text" readonly="readonly" name="codProd" value="${item.codProd}"></td>
										<td><input type="text" readonly="readonly" name="nombre" value="${item.nombre}"></td>
										<td><input type="text" readonly="readonly" name="descripcion" value="${item.descripcion}"></td>
										<td><input type="text" readonly="readonly" name="peso" value="${item.peso}"></td>
										<td><input type="text" readonly="readonly" name="stock" value="${item.stock}"></td>
										<td><input type="text" readonly="readonly" name="categoria" value="${item.categoria}"></td>
										<td><input type="number" name="unidades" min=1 max="${item.stock}" required></td>
										<td><button class="btn btn-secondary" value="Comprar">Comprar</button></td>
									</form>
								</tr>							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<form action="carrito" method="POST">
			<input type="hidden" name="correo" value="${correo}">
			<input type="hidden" name="clave" value="${clave}">
			<button class="btn btn-primary">Ver Carrito</button>
		</form>

	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>