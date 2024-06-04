
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
<meta charset="ISO-8859-1">
<title>Lista de Academias</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th><spring:message code="list.all.academy.value.1" /></th>
				<th>Persona al cargo</th>
				<th>Correo</th>
				<th>Nombre Comercial</th>
				<th>Dirección Postal</th>
				<th>Cursos</th>
				<jstl:if test="${autoridad != 'NADA'}">
					<th>Tutoriales</th>
				</jstl:if>

			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="academia" items="${academias}">
				<tr>
					<td>${academia.nombreComercial}</td>
					<td>${academia.nombre}${academia.apellidos}</td>
					<td>${academia.correo}</td>
					<td>${academia.telefono}</td>
					<td>${academia.direccionPostal}</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/curso/allcoursesfromacademy.do"
							method="get">
							<input type="hidden" name="academiaId" value="${academia.id}" />
							<button type="submit">Ver Cursos</button>
						</form>
					</td>

					<jstl:if test="${autoridad != 'NADA'}">
						<td>
							<form
								action="${pageContext.request.contextPath}/tutorial/alltutorialbyacademy.do"
								method="get">
								<input type="hidden" name="idAcademia" value="${academia.id}" />
								<button type="submit">Ver Tutoriales</button>
							</form>
						</td>
					</jstl:if>


				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>