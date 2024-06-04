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
<title>Modificar Academia</title>
</head>
<body>
	<button type="button" onclick="goBack()">Volver</button>

	<form:form modelAttribute="academia" method="post"
		action="${pageContext.request.contextPath}/academia/edit_academy.do">
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
				<td><form:label path="nombre">Nombre Director:</form:label></td>
				<td><form:input path="nombre" />${academia.nombre}</td>
				<td><form:errors path="nombre" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="apellidos">Apellidos Director:</form:label></td>
				<td><form:input path="apellidos" />${academia.apellidos}</td>
				<td><form:errors path="apellidos" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="correo">Correo:</form:label></td>
				<td><form:input path="correo" pattern=".+@.+\\..+"
						title="El correo debe seguir el formato 'usuario@dominio.com'" /></td>
				<td><form:errors path="correo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono">Teléfono:</form:label></td>
				<td><form:input path="telefono" pattern="\\d{2}\\s\\d{4,}"
						title="El teléfono debe seguir el formato 'xx xxxx...'" /></td>
				<td><form:errors path="telefono" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="direccionPostal">Dirección Postal:</form:label></td>
				<td><form:input path="direccionPostal" />${academia.direccionPostal}</td>
				<td><form:errors path="direccionPostal" cssClass="error" /></td>
			</tr>

			<!-- Campo Academia -->
			<tr>
				<td><form:label path="nombreComercial">Nombre Comercial:</form:label></td>
				<td><form:input path="nombreComercial" />${academia.nombreComercial}</td>
				<td><form:errors path="nombreComercial" cssClass="error" /></td>
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
				<td><form:input path="userAccount.username" />${academia.userAccount.username}<</td>
				<td><form:errors path="userAccount.username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="userAccount.password">Contraseña:</form:label></td>
				<td><form:password path="userAccount.password" />${academia.userAccount.password}</td>
				<td><form:errors path="userAccount.password" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Modificar" /></td>
			</tr>
		</table>
	</form:form>
		<button type="button" onclick="goBack()">Volver</button>
</body>
</html>
