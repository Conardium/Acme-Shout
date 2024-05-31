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
<title>Estilo</title>
</head>
<body>
	<table>
		<!-- Campos Estilo -->
		<tr>
			<td>Nombre:</td>
			<td><jstl:out value="${estilo.nombre}" /></td>
		</tr>
		<tr>
			<td>Descripcion:</td>
			<td><jstl:out value="${estilo.descripcion}" /></td>
		</tr>
		<tr>
			<td>Imagenes:</td>
			<td><jstl:forEach var="imagen" items="${estilo.imagenes}">
					<a href="${video}" target="_blank">${imagen}</a>
					<br />
				</jstl:forEach></td>
		</tr>
		<tr>
			<td>Videos:</td>
			<td><jstl:forEach var="video" items="${estilo.videos}">
					<a href="${video}" target="_blank">${video}</a>
					<br />
				</jstl:forEach></td>
		</tr>
	</table>
	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>
