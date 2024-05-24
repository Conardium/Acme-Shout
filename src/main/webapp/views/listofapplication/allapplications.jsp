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

	<h2>Listado de Solicitudes</h2>

	<display:table name="${solicitudes}" requestURI="" pagesize="10"
		id="solicitud" class="displaytag">
		<display:column property="estado" title="Estado" sortable="true" />
		<display:column property="fecha" title="Fecha" sortable="true"
			format="{0,date,dd/MM/yyyy HH:mm}" />
		<display:column property="curso.nombre" title="Curso" sortable="true" />
	</display:table>
	<table class="displaytag">
		<thead>
			<tr>
				<th>Estado</th>
				<th>Fecha</th>
				<th>Curso</th>
				<th>Aceptar</th>
				<th>Aceptar</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="solicitud" items="${solicitudes}">
				<tr>
					<td>${solicitud.estado}</td>
					<td><fmt:formatDate value="${solicitud.fecha}"
							pattern="dd/MM/yyyy HH:mm" /></td>
					<td>${solicitud.curso.nombre}</td>
					<td>
						<form action="${pageContext.request.contextPath}/aceptarSolicitud"
							method="post">
							<input type="hidden" name="solicitudId" value="${solicitud.id}" />
							<button type="submit">Aceptar</button>
						</form>
					</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/rechazarSolicitud"
							method="post">
							<input type="hidden" name="solicitudId" value="${solicitud.id}" />
							<button type="submit">Rechazar</button>
						</form>
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>

</body>
</html>