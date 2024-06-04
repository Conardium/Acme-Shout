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
<title>Modificar Tarjeta de Credito</title>
</head>
<body>
	<button type="button" onclick="goBack()">Volver</button>
	<h2>Modificar Tarjeta de Credito</h2>

	<form:form modelAttribute="tarjeta" method="post"
		action="${pageContext.request.contextPath}/tarjeta/edit_creditcard.do">
		<table>
			<!-- Campos Tarjeta -->
			<tr>
				<td><form:label path="marca">Marca:</form:label></td>
				<td><form:input path="marca"
						title="Falta agregar el tipo de marca" required="required" /></td>
				<td><form:errors path="marca" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="numero">Número de Tarjeta de Crédito:</form:label></td>
				<td><form:input path="numero" pattern="\\d{16}"
						title="El número de tarjeta debe tener 16 dígitos"
						required="required" /></td>
				<td><form:errors path="numero" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="mes">Mes de Expiración:</form:label></td>
				<td><form:input path="mes" type="number" min="1"
						max="12" required="required" /></td>
				<td><form:errors path="mes" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="anio">Año de Expiración:</form:label></td>
				<td><form:input path="anio" type="number"
						min="2024" required="required" /></td>
				<td><form:errors path="anio" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="codigoCVV">Código de Seguridad:</form:label></td>
				<td><form:input path="codigoCVV" pattern="\d{3}"
						title="El CVV debe tener 3 dígitos" required="required" /></td>
				<td><form:errors path="codigoCVV"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Modificar" /></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/scripts/jcomun.js"></script>
</body>
</html>