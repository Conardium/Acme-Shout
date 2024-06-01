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
<title>Listado de Solicitudes</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Estado</th>
				<th>Fecha</th>
				<th>Curso</th>
				<th>Aceptar</th>
				<th>Rechazar</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="solicitud" items="${solicitudes}" varStatus="status">
				<tr>
					<td>${solicitud.estado}</td>
					<td><fmt:formatDate value="${solicitud.fecha}"
							pattern="dd/MM/yyyy HH:mm" /></td>
					<td>${solicitud.curso.titulo}</td>
					<jstl:choose>
						<jstl:when test="${estadoSolicitudes[status.index] == 'Pendiente'}">
							<td>
								<form
									action="${pageContext.request.contextPath}/solicitud/acceptapplication.do"
									method="post">
									<input type="hidden" name="solicitudId" value="${solicitud.id}" />
									<button type="submit">Aceptar</button>
								</form>
							</td>
							<td>
								<form
									action="${pageContext.request.contextPath}/solicitud/rejectapplication"
									method="post">
									<input type="hidden" name="solicitudId" value="${solicitud.id}" />
									<button type="submit">Rechazar</button>
								</form>
							</td>
						</jstl:when>
						<jstl:otherwise>
							<td></td>
							<td></td>
						</jstl:otherwise>
					</jstl:choose>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>