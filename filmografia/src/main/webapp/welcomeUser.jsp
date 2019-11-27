<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina de bienvenida</title>
</head>
<body>

	<h1>Bienvenido ${ director }</h1>
	
	<br>
	<br>
	
	<a href="login.jsp"><button>Volver</button></a>
	<br>
	<form action="CineController" method="POST">
	
		<input type="submit" name="action" value="Mantenimiento Peliculas">
	
	</form>
	
	<a href="altaDirector.jsp"><button>Alta Director</button></a>
	


</body>
</html>