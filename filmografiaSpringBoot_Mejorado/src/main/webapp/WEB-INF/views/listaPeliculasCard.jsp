<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Listado de peliculas</title>
</head>
<body>
	
	<h1>Listado de peliculas</h1>
	
	<div class="row justify-content-md-center">
		
			<c:forEach items="${listaPelis}" var="item">
				<div class="card" style="width: 18rem; margin-right: 6px; margin-top: 6px;" class="col-6 col-md-4 col-lg-3">
				<img class="card-img-top" src="${item.foto}" alt="Card image cap" width="120px" height="180px">
					<ul class="list-group list-group-flush">
					<div class="card-header"><b>Titulo:</b> ${item.titulo}</div>
						<li class="list-group-item"><b>Director:</b> ${item.director}</li>
						<li class="list-group-item"><b>Fecha:</b> ${item.fecha}</li>
					</ul>				
				</div>
				<br>
				<br>
			</c:forEach>
		
		</div>
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
</body>
</html>