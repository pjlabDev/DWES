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
			<a href="/" style="float: left;"><button type="button" class="btn btn-outline-danger">Cerrar Sesión</button></a>
		</div>
		<h1 style="text-align: center" class="col-md-6">Bienvenido ${correo}</h1>
	</nav>

	<br>

	<!-- <div class="container" style="text-align: center; bg-color: light-gray">
		<div class="row justify-content-center">
			<div class="col-auto">
				<form action="productos" method="POST">
					<input type="hidden" name="correo" value="${correo}">
					<input type="hidden" name="clave" value="${clave}">
					<div class="col-12 mt-3">
	                    <button class="btn btn-primary" id="bebidasCon" name="cod" value="Bebidas Con">Bebidas Con</button>
	                </div>
	                <div class="col-12 mt-3">
	                    <button class="btn btn-primary" id="bebidasSin" name="cod" value="Bebidas Sin">Bebidas Sin</button>
	                </div>
	                <div class="col-12 mt-3">
	                    <button class="btn btn-primary" id="comida" name="cod" value="Comidas">Comidas</button>
	                </div>
				
				</form>
			</div>			
		</div>
	</div> -->
	
	<div class="container" style="text-align: center; bg-color: light-gray">
		<div class="row justify-content-center">
			<div class="col-auto">
				<table style="text-align: center;">
					<tr>
						<td>
							<form  action="productos" method="POST" accept-charset="UTF-8">
								<c:forEach items="${list1}" var="item">
									<input type="hidden" name="correo" value="${correo}">
									<input type="hidden" name="clave" value="${clave}">
									<input type="text" name="cod" value="${item.codCat}">
									<input type="submit" class="btn btn-primary" value="${item.nombre}">
								</c:forEach>
							</form>
						</td>
						<td>
							<form  action="productos" method="POST" accept-charset="UTF-8">
								<c:forEach items="${list2}" var="item">
									<input type="hidden" name="correo" value="${correo}">
									<input type="hidden" name="clave" value="${clave}">
									<input type="text" name="cod" value="${item.codCat}">
									<input type="submit" class="btn btn-primary" value="${item.nombre}">
								</c:forEach>
							</form>
						</td>
						<td>
							<form  action="productos" method="POST" accept-charset="UTF-8">
								<c:forEach items="${list3}" var="item">
									<input type="hidden" name="correo" value="${correo}">
									<input type="hidden" name="clave" value="${clave}">
									<input type="text" name="cod" value="${item.codCat}">
									<input type="submit" class="btn btn-primary" value="${item.nombre}">
								</c:forEach>
							</form>
						</td>
					</tr>
				</table>
			</div>			
		</div>
	</div>


</body>
</html>