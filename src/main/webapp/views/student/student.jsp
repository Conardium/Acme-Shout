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
<title>Estudiante</title>
</head>
<body>

	<table>
		<!-- Campos Actor -->
		<tr>
			<td><spring:message code="student.value.1" /></td>
			<td><jstl:out value="${alumno.nombre}" /></td>
		</tr>
		<tr>
			<td><spring:message code="student.value.2" /></td>
			<td><jstl:out value="${alumno.apellidos}" /></td>
		</tr>
		<tr>
			<td><spring:message code="student.value.3" /></td>
			<td><jstl:out value="${alumno.correo}" /></td>
		</tr>
		<tr>
			<td><spring:message code="student.value.4" /></td>
			<td><jstl:out value="${alumno.telefono}" /></td>
		</tr>
		<tr>
			<td><spring:message code="student.value.5" /></td>
			<td><jstl:out value="${alumno.direccionPostal}" /></td>
		</tr>
	</table>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/alumno/form_edit_student.do'"><spring:message code="student.value.6" /></button>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/tarjeta/show_creditcard.do'"><spring:message code="student.value.7" /></button>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/alumno/listarsolicitudesAlumno.do?idAlumno=${alumno.id}'"><spring:message code="student.value.8" /></button>
	<button type="button" onclick="goBack()"><spring:message code="student.value.9" /></button>
</body>
</html>
