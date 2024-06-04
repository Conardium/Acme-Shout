<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
<title>Comentario</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Fecha de Publicación</th>
				<th>Texto</th>
				<th>Actor</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><fmt:formatDate value="${comentario.fechaPublicacion}"
							pattern="dd/MM/yyyy HH:mm" /></td>
					<td>${comentario.texto}</td>
					<td>${comentario.actor.nombre}</td>
				</tr>
		</tbody>
	</table>
	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>
