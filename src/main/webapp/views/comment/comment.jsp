<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
<title>Comentario</title>
</head>
<body>
	<h2>Comentario</h2>

	<table>
		<tr>
			<td>Título:</td>
			<td><c:out value="${curso.titulo}" /></td>
		</tr>
		<tr>
			<td>Estilo:</td>
			<td><jstl:out value="${curso.estilo}" /></td>
		</tr>
		<tr>
			<td>Nivel:</td>
			<td><jstl:out value="${curso.nivel}" /></td>
		</tr>
		<tr>
			<td>Fecha de Inicio:</td>
			<td><fmt:formatDate value="${curso.fechaInicio}"
					pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td>Fecha de Fin:</td>
			<td><fmt:formatDate value="${curso.fechaFin}"
					pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td>Día de la Semana:</td>
			<td><jstl:out value="${curso.diaSemana}" /></td>
		</tr>
		<tr>
			<td>Hora:</td>
			<td><fmt:formatDate value="${curso.hora}" pattern="HH:mm:ss" /></td>
		</tr>
	</table>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/curso/form_edit_course.do'">Modificar
		Curso</button>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/curso/delete_course.do'">Eliminar Curso</button>
	<button type="button" onclick="goBack()">Volver</button>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/scripts/jcomun.js"></script>
</body>
</html>
