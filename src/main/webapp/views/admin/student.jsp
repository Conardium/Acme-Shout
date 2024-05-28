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
	<h2>Estudiante</h2>

	<table>
		<!-- Campos Actor -->
		<tr>
			<td>Nombre:</td>
			<td><jstl:out value="${alumno.nombre}" /></td>
		</tr>
		<tr>
			<td>Apellidos:</td>
			<td><jstl:out value="${alumno.apellidos}" /></td>
		</tr>
		<tr>
			<td>Correo:</td>
			<td><jstl:out value="${alumno.correo}" /></td>
		</tr>
		<tr>
			<td>Teléfono:</td>
			<td><jstl:out value="${alumno.telefono}" /></td>
		</tr>
		<tr>
			<td>Dirección Postal:</td>
			<td><jstl:out value="${alumno.direccionPostal}" /></td>
		</tr>
	</table>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/alumno/form_edit_alumno.do'">Modificar
		Alumno</button>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/tarjeta/form_edit_tarjeta.do'">Modificar
		Tarjeta</button>
	<button type="button" onclick="goBack()">Volver</button>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/scripts/jcomun.js"></script>
</body>
</html>
