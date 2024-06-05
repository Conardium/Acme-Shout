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
<title>Curso</title>
</head>
<body>

	<table>
		<tr>
			<td><spring:message code="course.1" /><spring:message code="course.1" /></td>
			<td><jstl:out value="${curso.titulo}" /></td>
		</tr>
		<tr>
			<td><spring:message code="course.2" /></td>
			<td><jstl:out value="${curso.estilo}" /></td>
		</tr>
		<tr>
			<td><spring:message code="course.3" /></td>
			<td><jstl:out value="${curso.nivel}" /></td>
		</tr>
		<tr>
			<td><spring:message code="course.4" /></td>
			<td><fmt:formatDate value="${curso.fechaInicio}"
					pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td><spring:message code="course.5" /></td>
			<td><fmt:formatDate value="${curso.fechaFin}"
					pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td><spring:message code="course.6" /></td>
			<td><jstl:out value="${curso.diaSemana}" /></td>
		</tr>
		<tr>
			<td><spring:message code="course.7" /></td>
			<td><fmt:formatDate value="${curso.hora}" pattern="HH:mm:ss" /></td>
		</tr>
	</table>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/curso/form_edit_course.do'"><spring:message code="course.8" /></button>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/curso/delete_course.do'"><spring:message code="course.9" /></button>
	<button type="button" onclick="goBack()"><spring:message code="course.10" /></button>
</body>
</html>
