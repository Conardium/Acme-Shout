<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
<title>Modificar Alumno</title>
</head>
<body>
	<button type="button" onclick="goBack()">Volver</button>
	<h2>Modificar Alumno</h2>

	<form:form modelAttribute="alumno" method="post"
		action="${pageContext.request.contextPath}/alumno/edit_alumno">
		<table>
			<!-- Campo Id (oculto) -->
			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<!-- Campo Version (oculto) -->
			<tr>
				<td><form:hidden path="version" /></td>
			</tr>
			<!-- Campos Actor -->
			<tr>
				<td><form:label path="nombre">Nombre:</form:label></td>
				<td><form:input path="nombre" />${alumno.nombre}</td>
				<td><form:errors path="nombre" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="apellidos">Apellidos:</form:label></td>
				<td><form:input path="apellidos" />${alumno.apellidos}</td>
				<td><form:errors path="apellidos" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="correo">Correo:</form:label></td>
				<td><form:input path="correo" pattern=".+@.+\\..+"
						title="El correo debe seguir el formato 'usuario@dominio.com'" /></td>
				<td><form:errors path="correo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono">Tel�fono:</form:label></td>
				<td><form:input path="telefono" pattern="\\d{2}\\s\\d{4,}"
						title="El tel�fono debe seguir el formato 'xx xxxx...'" /></td>
				<td><form:errors path="telefono" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="direccionPostal">Direcci�n Postal:</form:label></td>
				<td><form:input path="direccionPostal" />${alumno.direccionPostal}</td>
				<td><form:errors path="direccionPostal" cssClass="error" /></td>
			</tr>
			<!-- Campo Id (oculto) -->
			<tr>
				<td><form:hidden path="userAccount.id" /></td>
			</tr>
			<!-- Campo Version (oculto) -->
			<tr>
				<td><form:hidden path="userAccount.version" /></td>
			</tr>
			<!-- Campos de UserAccount -->
			<tr>
				<td><form:label path="userAccount.username">Nombre de Usuario:</form:label></td>
				<td><form:input path="userAccount.username" />${alumno.userAccount.username}<</td>
				<td><form:errors path="userAccount.username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="userAccount.password">Contrase�a:</form:label></td>
				<td><form:password path="userAccount.password" />${alumno.userAccount.password}</td>
				<td><form:errors path="userAccount.password" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Modificar" /></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/scripts/jcomun.js"></script>
</body>
</html>