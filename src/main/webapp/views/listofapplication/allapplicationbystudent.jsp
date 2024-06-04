<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
<title>Listado de Solicitudes del Alumno</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th><spring:message code="all.applications.by.academy.value.1" /></th>
				<th><spring:message code="all.applications.by.academy.value.2" /></th>
				<th><spring:message code="all.applications.by.academy.value.3" /></th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="solicitud" items="${solicitudes}">
				<tr>
					<td>${solicitud.estado}</td>
					<td><fmt:formatDate value="${solicitud.fecha}"
							pattern="dd/MM/yyyy HH:mm" /></td>
					<td>${solicitud.curso.titulo}</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
		<button type="button" onclick="goBack()"><spring:message code="all.applications.by.academy.value.1" /></button>
</body>
</html>