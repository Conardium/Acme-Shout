
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
<title>Lista de Academias</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th><spring:message code="list.all.academy.value.1" /></th>
				<th><spring:message code="list.all.academy.value.2" /></th>
				<th><spring:message code="list.all.academy.value.3" /></th>
				<th><spring:message code="list.all.academy.value.4" />l</th>
				<th><spring:message code="list.all.academy.value.5" /></th>
				<th><spring:message code="list.all.academy.value.6" /></th>
				<jstl:if test="${autoridad != 'NADA'}">
					<th><spring:message code="list.all.academy.value.7" /></th>
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
							<button type="submit"><spring:message code="list.all.academy.value.8" /></button>
						</form>
					</td>

					<jstl:if test="${autoridad != 'NADA'}">
						<td>
							<form
								action="${pageContext.request.contextPath}/tutorial/alltutorialbyacademy.do"
								method="get">
								<input type="hidden" name="idAcademia" value="${academia.id}" />
								<button type="submit"><spring:message code="list.all.academy.value.9" /></button>
							</form>
						</td>
					</jstl:if>


				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<button type="button" onclick="goBack()"><spring:message code="list.all.academy.value.10" /></button>
</body>
</html>