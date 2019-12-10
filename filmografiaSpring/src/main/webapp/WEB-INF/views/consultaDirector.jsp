<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form:form method="post" commandName="consultarDirector">
		<table>
			<tr>
				<td align="right" width="20%">Nombre director:</td>
				<td width="20%"><input type="text" name="usuario" placeholder="Username"></td>
				<td width="60%"><form:errors value="<fmt:message key="heading"/>"/></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Execute">
	</form:form>
	
	
	
	<!-- <div class="form-group">

		<form:form method="post" action="/consultarDirector.htm">

			<label>Nombre director</label>
			<form:input path="usuario" />
			<input type="submit" value="Execute">

		</form:form>

	</div> -->
	
</body>
</html>