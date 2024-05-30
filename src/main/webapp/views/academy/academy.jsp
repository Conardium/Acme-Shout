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
<title>Academia</title>
</head>
<body>
	<h2>Academia</h2>

	<table>
		<!-- Campos Actor -->
		<tr>
			<td>Nombre Director:</td>
			<td><jstl:out value="${academia.nombre}" /></td>
		</tr>
		<tr>
			<td>Apellidos Director:</td>
			<td><jstl:out value="${academia.apellidos}" /></td>
		</tr>
		<tr>
			<td>Correo:</td>
			<td><jstl:out value="${academia.correo}" /></td>
		</tr>
		<tr>
			<td>Teléfono:</td>
			<td><jstl:out value="${academia.telefono}" /></td>
		</tr>
		<tr>
			<td>Dirección Postal:</td>
			<td><jstl:out value="${academia.direccionPostal}" /></td>
		</tr>

		<!-- Campo Academia -->
		<tr>
			<td>Nombre Comercial:</td>
			<td><jstl:out value="${academia.nombreComercial}" /></td>
		</tr>
	</table>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/academia/form_edit_academy.do'">Modificar</button>
	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>
