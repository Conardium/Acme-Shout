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
<title>Academia</title>
</head>
<body>
<button type="button" onclick="goBack()"><spring:message code="academy.7" /></button>
	<h2><spring:message code="academy.8" /></h2>
	<table>
		<!-- Campos Actor -->
		<tr>
			<td><spring:message code="academy.0" /></td>
			<td><jstl:out value="${academia.nombre}" /></td>
		</tr>
		<tr>
			<td><spring:message code="academy.1" /></td>
			<td><jstl:out value="${academia.apellidos}" /></td>
		</tr>
		<tr>
			<td><spring:message code="academy.2" /></td>
			<td><jstl:out value="${academia.correo}" /></td>
		</tr>
		<tr>
			<td><spring:message code="academy.3" /></td>
			<td><jstl:out value="${academia.telefono}" /></td>
		</tr>
		<tr>
			<td><spring:message code="academy.4" /></td>
			<td><jstl:out value="${academia.direccionPostal}" /></td>
		</tr>

		<!-- Campo Academia -->
		<tr>
			<td><spring:message code="academy.5" /></td>
			<td><jstl:out value="${academia.nombreComercial}" /></td>
		</tr>
	</table>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jcomun.js"></script>
	
</body>
</html>
