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
<title><spring:message code="admin.0" /></title>
</head>
<body>
	<h2><spring:message code="admin.0" /></h2>

	<table>
		<!-- Campos Actor -->
		<tr>
			<td><spring:message code="admin.1" /></td>
			<td><jstl:out value="${admin.nombre}" /></td>
		</tr>
		<tr>
			<td><spring:message code="admin.2" /></td>
			<td><jstl:out value="${admin.apellidos}" /></td>
		</tr>
		<tr>
			<td><spring:message code="admin.3" /></td>
			<td><jstl:out value="${admin.correo}" /></td>
		</tr>
		<tr>
			<td><spring:message code="admin.4" /></td>
			<td><jstl:out value="${admin.telefono}" /></td>
		</tr>
		<tr>
			<td><spring:message code="admin.5" /></td>
			<td><jstl:out value="${admin.direccionPostal}" /></td>
		</tr>
	</table>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/admin/form_edit_admin.do'"><spring:message code="admin.6" /></button>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/admin/dashboard.do'"><spring:message code="admin.7" />
	</button>
	<button type="button" onclick="goBack()"><spring:message code="admin.8" /></button>
</body>
</html>
