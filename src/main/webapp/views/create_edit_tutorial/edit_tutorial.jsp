<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Modificar Tutorial</title>
</head>
<body>
	<form:form modelAttribute="tutorial" method="post"
		action="${pageContext.request.contextPath}/tutorial/edit_tutorial.do">
		<table>
			<tr>
				<td><form:input path="id" type="hidden" /></td>
			</tr>
			<tr>
				<td><form:input path="version" type="hidden" /></td>
			</tr>
			<tr>
				<td><form:label path="titulo">Título:</form:label></td>
				<td><form:input path="titulo" required="required" /></td>
				<td><form:errors path="titulo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="descripcion">Descripción:</form:label></td>
				<td><form:input path="descripcion" required="required" /></td>
				<td><form:errors path="descripcion" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="video">Video (URL de YouTube):</form:label></td>
				<td><form:input path="video" required="required"
						pattern="https?://.+" /></td>
				<td><form:errors path="video" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:input path="contador" type="hidden" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Modificar Tutorial" /></td>
			</tr>
		</table>
	</form:form>
	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>
