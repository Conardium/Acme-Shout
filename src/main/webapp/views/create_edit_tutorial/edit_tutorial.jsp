<%--
 * action-1.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

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
<title><spring:message code="create.edit.tutorial.value.7" /></title>
</head>
<body>
	<form:form modelAttribute="tutorial" method="post"
		action="${pageContext.request.contextPath}/tutorial/edit_tutorial.do">
		<table>
			<tr>
				<td><form:input path="id" type="hidden" /></td>
			</tr>
			<tr>
				<td><form:input path="version" type="hidden" /></td>
			</tr>
			<tr>
				<td><form:label path="titulo"><spring:message code="create.edit.tutorial.value.1" /></form:label></td>
				<td><form:input path="titulo" required="required" /></td>
				<td><form:errors path="titulo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="descripcion"><spring:message code="create.edit.tutorial.value.1" /></form:label></td>
				<td><form:input path="descripcion" required="required" /></td>
				<td><form:errors path="descripcion" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="video"><spring:message code="create.edit.tutorial.value.6" /></form:label></td>
				<td><form:input path="video" required="required"
						pattern="https?://.+" /></td>
				<td><form:errors path="video" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:input path="contador" type="hidden" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value=<spring:message code="create.edit.tutorial.value.7" /> /></td>
			</tr>
		</table>
	</form:form>
	<button type="button" onclick="goBack()"><spring:message code="create.edit.tutorial.value.5" /></button>
</body>
</html>
