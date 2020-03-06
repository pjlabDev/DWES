<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<form action="categoria" method="POST">
					<input type="submit" class="btn btn-warning" value="Volver">
				</form>
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
							<th id="comprar">Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaCarr}" var="item">
								<tr>
									<td>${item.nombre}</td>
									<td>${item.descripcion}</td>
									<td>${item.peso}</td>
									<td>${item.unidades}</td>
									<form action="carrito" method="POST" accept-charset="UTF-8">
										<td><input type="button" class="btn btn-danger" value="Eliminar"></td>
									</form>
								</tr>							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>