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
<title>Modificar Academia</title>
</head>
<body>
	<button type="button" onclick="goBack()"><spring:message code="createdit.actor.12" /></button>

	<form:form modelAttribute="academia" method="post"
		action="${pageContext.request.contextPath}/academia/edit_academy.do">
		<table>

			<!-- Campo Id (oculto) -->
			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<!-- Campo Version (oculto) -->
			<tr>
				<td><form:hidden path="version" /></td>
			</tr>
			<!-- Campos Actor -->
			<tr>
				<td><form:label path="nombre"><spring:message code="createdit.actor.1" /></form:label></td>
				<td><form:input path="nombre" />${academia.nombre}</td>
				<td><form:errors path="nombre" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="apellidos"><spring:message code="createdit.actor.2" /></form:label></td>
				<td><form:input path="apellidos" />${academia.apellidos}</td>
				<td><form:errors path="apellidos" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="correo"><spring:message code="createdit.actor.3" /></form:label></td>
				<td><form:input path="correo" pattern=".+@.+\\..+"
						title="El correo debe seguir el formato 'usuario@dominio.com'" /></td>
				<td><form:errors path="correo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono"><spring:message code="createdit.actor.4" /></form:label></td>
				<td><form:input path="telefono" pattern="\\d{2}\\s\\d{4,}"
						title="El tel�fono debe seguir el formato 'xx xxxx...'" /></td>
				<td><form:errors path="telefono" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="direccionPostal"><spring:message code="createdit.actor.5" /></form:label></td>
				<td><form:input path="direccionPostal" />${academia.direccionPostal}</td>
				<td><form:errors path="direccionPostal" cssClass="error" /></td>
			</tr>

			<!-- Campo Academia -->
			<tr>
				<td><form:label path="nombreComercial"><spring:message code="createdit.actor.6" /></form:label></td>
				<td><form:input path="nombreComercial" />${academia.nombreComercial}</td>
				<td><form:errors path="nombreComercial" cssClass="error" /></td>
			</tr>
			<!-- Campo Id (oculto) -->
			<tr>
				<td><form:hidden path="userAccount.id" /></td>
			</tr>
			<!-- Campo Version (oculto) -->
			<tr>
				<td><form:hidden path="userAccount.version" /></td>
			</tr>
			<!-- Campos de UserAccount -->
			<tr>
				<td><form:label path="userAccount.username"><spring:message code="createdit.actor.15" /></form:label></td>
				<td><form:input path="userAccount.username" />${academia.userAccount.username}<</td>
				<td><form:errors path="userAccount.username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="userAccount.password"><spring:message code="createdit.actor.16" /></form:label></td>
				<td><form:password path="userAccount.password" />${academia.userAccount.password}</td>
				<td><form:errors path="userAccount.password" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value=<spring:message code="createdit.actor.13" />/></td>
			</tr>
		</table>
	</form:form>
		<button type="button" onclick="goBack()"><spring:message code="createdit.actor.12" /></button>
</body>
</html>
