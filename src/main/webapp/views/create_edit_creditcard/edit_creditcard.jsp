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
<title><spring:message code="edit.creditcard.1" /></title>
</head>
<body>
	<form:form modelAttribute="tarjeta" method="post"
		action="${pageContext.request.contextPath}/tarjeta/edit_creditcard.do">
		<table>
			<!-- Campos Tarjeta -->
			<tr>
				<td><form:label path="marca"><spring:message code="edit.creditcard.2" /></form:label></td>
				<td><form:input path="marca"
						title="Falta agregar el tipo de marca" required="required" /></td>
				<td><form:errors path="marca" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="numero"><spring:message code="edit.creditcard.3" /></form:label></td>
				<td><form:input path="numero" pattern="\\d{16}"
						title="El número de tarjeta debe tener 16 dígitos"
						required="required" /></td>
				<td><form:errors path="numero" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="mes"><spring:message code="edit.creditcard.4" /></form:label></td>
				<td><form:input path="mes" type="number" min="1"
						max="12" required="required" /></td>
				<td><form:errors path="mes" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="anio"><spring:message code="edit.creditcard.5" /></form:label></td>
				<td><form:input path="anio" type="number"
						min="2024" required="required" /></td>
				<td><form:errors path="anio" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="codigoCVV"><spring:message code="edit.creditcard.6" /></form:label></td>
				<td><form:input path="codigoCVV" pattern="\d{3}"
						title="El CVV debe tener 3 dígitos" required="required" /></td>
				<td><form:errors path="codigoCVV"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value=<spring:message code="edit.creditcard.7" /> /></td>
			</tr>
		</table>
	</form:form>
<button type="button" onclick="goBack()"><spring:message code="edit.creditcard.8" /></button>
</body>
</html>