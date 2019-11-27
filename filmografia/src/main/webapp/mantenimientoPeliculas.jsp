<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mantenimiento Peliculas</title>
</head>
<body>

	<h2>Mantenimiento de Peliculas</h2>
	
	<table id="tabla" style="align:center" border="1">

		<tr>
			
			<td>Director</td>
			<td>Título</td>
			<td>Fecha</td>

		</tr>


		<c:forEach items="${listaPelis}" var="item">

			<tr>
	
				<td>${item.director}</td>
				<td>${item.titulo}</td>
				<td>${item.fecha}</td>
			</tr>

		</c:forEach>

	</table>
	
	<br>
	<br>
	
	<a href="altaPelicula.jsp"><button>Añadir pelicula</button></a>
	<br>
	<a href="modificarPelicula.jsp"><button>Modificar pelicula</button></a>
	<br>
	<a href="eliminarPelicula.jsp"><button>Eliminar pelicula</button></a>
	<br>
	<a href="index.jsp"><button>Inicio</button></a>

</body>
</html>