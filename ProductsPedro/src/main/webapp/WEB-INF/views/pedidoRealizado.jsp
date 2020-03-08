<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Pedido realizado</title>
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
			<h1 style="text-align:center" class="col-md-6">Pedido realizado</h1>
        </nav>

	<div class="container">
		<h1 style="text-align:center;">Pedido realizado con exito</h1>
	</div>
	
	<div class="row justify-content-center">
			<div class="col-auto">
				<table
					class="mt-5 table table-striped table-inverse table-responsive table-center table-bordered text-center">
					<caption>Listado de Productos</caption>
					<thead class="thead-inverse">
						<tr>
							<th id="codPed">CodPed</th>
							<th id="fecha">Fecha</th>
							<th id="enviado">Enviado</th>
							<th id="codRes">CodRes</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaPedidos}" var="item">
								<tr>
									<td>${item.codPed}</td>
									<td>${item.fecha}</td>
									<td>${item.enviado}</td>
									<td>${item.codRes}</td>
								</tr>							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	
	

</body>
</html>