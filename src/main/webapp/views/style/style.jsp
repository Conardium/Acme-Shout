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
<title>Estilo</title>
</head>
<body>
	<table>
		<!-- Campos Estilo -->
		<tr>
			<td><spring:message code="style.value.1" /></td>
			<td><jstl:out value="${estilo.nombre}" /></td>
		</tr>
		<tr>
			<td><spring:message code="style.value.2" /></td>
			<td><jstl:out value="${estilo.descripcion}" /></td>
		</tr>
		<tr>
			<td><spring:message code="style.value.3" /></td>
			<td><jstl:forEach var="imagen" items="${estilo.imagenes}">
					<a href="${video}" target="_blank">${imagen}</a>
					<br />
				</jstl:forEach></td>
		</tr>
		<tr>
			<td><spring:message code="style.value.4" /></td>
			<td><jstl:forEach var="video" items="${estilo.videos}">
					<a href="${video}" target="_blank">${video}</a>
					<br />
				</jstl:forEach></td>
		</tr>
	</table>
	<button type="button" onclick="goBack()"><spring:message code="style.value.5" /></button>
</body>
</html>
