
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Lista de Cursos</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/curso/allcoursesfromfilter.do"
		method="get">
		<label for="filtro"><spring:message
				code="all.courses.value.01" /> </label> <input type="text" name="filtro"
			placeholder=<spring:message code="all.courses.value.02" /> /> <input
			type="hidden" name="idVista" value="5" /> <input type="hidden"
			name="idAcademia" value=0 /> <input type="hidden" name="idEstilo"
			value=0 />
		<button type="submit">
			<spring:message code="all.courses.value.03" />
		</button>
	</form>

	<table border="1">
		<thead>
			<tr>
				<th><spring:message code="all.courses.value.1" /></th>
				<th><spring:message code="all.courses.value.2" /></th>
				<th><spring:message code="all.courses.value.3" /></th>
				<th><spring:message code="all.courses.value.4" /></th>
				<th><spring:message code="all.courses.value.5" /></th>
				<th><spring:message code="all.courses.value.6" /></th>
				<th><spring:message code="all.courses.value.7" /></th>
				<th><spring:message code="all.courses.value.8" /></th>
				<th><spring:message code="all.courses.value.9" /></th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="curso" items="${cursos}">
				<tr>
					<td>${curso.titulo}</td>
					<td>${curso.estilo.nombre}</td>
					<td>${curso.nivel}</td>
					<td><fmt:formatDate value="${curso.fechaInicio}"
							pattern="dd/MM/yyyy HH:mm" /></td>
					<td><fmt:formatDate value="${curso.fechaFin}"
							pattern="dd/MM/yyyy HH:mm" /></td>
					<td>${curso.diaSemana}</td>
					<td><fmt:formatDate value="${curso.hora}" pattern="HH:mm:ss" /></td>
					<td>
						<form
							action="${pageContext.request.contextPath}/academia/academybycourse.do"
							method="get">
							<input type="hidden" name="cursoId" value="${curso.id}" />
							<button type="submit"><spring:message code="all.courses.value.8" /></button>
						</form>
					</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/solicitud/apply.do"
							method="get">
							<input type="hidden" name="idCurso" value="${curso.id}" />
							<button type="submit"><spring:message code="all.courses.value.9" /></button>
						</form>
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<button type="button" onclick="goBack()">
		<spring:message code="all.courses.value.0" />
	</button>
</body>
</html>