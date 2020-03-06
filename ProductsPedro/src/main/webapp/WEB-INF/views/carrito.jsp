<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Carrito</title>
</head>
<body>

	<nav class="navbar navbar-expand-sm navbar-light bg-light nav-tabs">
			<div class="navbar-brand col-md-3">
			</div>
			<h1 style="text-align:center" class="col-md-6">Carrito</h1>
        </nav>
	
	<div style="text-align:center">

		<div class="row justify-content-center">
			<div class="col-auto">
				<table
					class="mt-5 table table-striped table-inverse table-responsive table-center table-bordered text-center">
					<caption>Productos del carrito</caption>
					<thead class="thead-inverse">
						<tr>
							<th id="nombre">Nombre</th>
							<th id="descripcion">Descripcion</th>
							<th id="peso">Peso</th>
							<th id="categoria">Unidades</th>
							<th id="comprar">U a eliminar</th>
							<th id="eliminar">Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${carrito}" var="item">
								<tr>
									<td>${item.codProd}</td>
									<td>${item.nombre}</td>
									<td>${item.descripcion}</td>
									<td>${item.peso}</td>
									<td>${item.unidades}</td>
									<form action="eliminar" method="POST" accept-charset="UTF-8">
										<input type="hidden" name="codProd" value="${item.codProd}">
										<td><input type="number" name="unidadesNuevas" min=1 max="${item.unidades}"></td>
										<td><input type="submit" class="btn btn-danger" value="Eliminar"></td>
									</form>
								</tr>							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div style="text-align:center;">
			<a href="/pedidoRealizado"><button type="button" class="btn btn-primary">Realizar pedido</button></a>
		</div>
	</div>
</body>
</html>