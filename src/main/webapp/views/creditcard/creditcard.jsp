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
<title><spring:message code="creditcard.value.1" /></title>
</head>
<body>
	<table>
		<!-- Campos Tarjeta -->
		<tr>
			<td><spring:message code="creditcard.value.2" /></td>
			<td><jstl:out value="${tarjeta.nombreTitular}" /></td>
		</tr>
		<tr>
			<td><spring:message code="creditcard.value.3" /></td>
			<td><jstl:out value="${tarjeta.marca}" /></td>
		</tr>
		<tr>
			<td><spring:message code="creditcard.value.4" /></td>
			<td><jstl:out value="${tarjeta.numero}" /></td>
		</tr>
		<tr>
			<td><spring:message code="creditcard.value.5" /></td>
			<td><jstl:out value="${tarjeta.mes}" /></td>
		</tr>
		<tr>
			<td><spring:message code="creditcard.value.6" /></td>
			<td><jstl:out value="${tarjeta.anio}" /></td>
		</tr>
		<tr>
			<td><spring:message code="creditcard.value.7" /></td>
			<td><jstl:out value="${tarjeta.codigoCVV}" /></td>
		</tr>
	</table>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/tarjeta/form_edit_creditcard.do'"><spring:message code="creditcard.value.8" /></button>
	<button type="button" onclick="goBack()"><spring:message code="creditcard.value.9" /></button>
</body>
</html>