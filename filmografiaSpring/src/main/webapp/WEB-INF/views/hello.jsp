<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello :: Spring Application</title>
</head>
<body>
	<h1>Hello - Spring Application</h1>
	<p>Greetings, it is now <c:out value="${now}" /></p>

	<br>
    <a href="<c:url value="consultarDirector.htm"/>">Consultar director</a>
    <br>

</body>
</html>