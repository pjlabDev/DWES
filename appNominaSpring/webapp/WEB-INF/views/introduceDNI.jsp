<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Introduce DNI</title>
</head>
<body>
	
	<form action="/mostrarSalario" method="POST">
	
		<input type="text" name="dni">
		<input type="submit" value="Mostrar Salario">
	
	</form>
	
	<form action="/sacarEmpXDni" method="POST">
	
		<input type="text" name="dni">
		<input type="submit" value="Modificar Empleado">
		
	</form>

</body>
</html>