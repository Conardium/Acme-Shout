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
<title>Registro de Alumno</title>
</head>
<body>

	<form:form modelAttribute="alumno" method="post"
		action="alumno/sing_up_student.do">
		<table>
			<!-- Campos Actor -->
			<tr>
				<td><form:label path="nombre"><spring:message code="createdit.actor.7" /></form:label></td>
				<td><form:input path="nombre" /></td>
				<td><form:errors path="nombre" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="apellidos"><spring:message code="createdit.actor.8" /></form:label></td>
				<td><form:input path="apellidos" /></td>
				<td><form:errors path="apellidos" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="correo"><spring:message code="createdit.actor.9" /></form:label></td>
				<td><form:input path="correo" pattern=".+@.+\\..+"
						title="El correo debe seguir el formato 'usuario@dominio.com'" /></td>
				<td><form:errors path="correo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono"><spring:message code="createdit.actor.10" /></form:label></td>
				<td><form:input path="telefono" pattern="\\d{2}\\s\\d{4,}"
						title="El teléfono debe seguir el formato 'xx xxxx...'" /></td>
				<td><form:errors path="telefono" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="direccionPostal"><spring:message code="createdit.actor.11" /></form:label></td>
				<td><form:input path="direccionPostal" /></td>
				<td><form:errors path="direccionPostal" cssClass="error" /></td>
			</tr>

			<!-- Campos Alumno -->
			<!-- Número de Tarjeta de Crédito -->
			<tr>
				<td><form:label path="tarjetaCredito.numero"><spring:message code="createdit.actor.17" /></form:label></td>
				<td><form:input path="tarjetaCredito.numero" pattern="\d{16}"
						title="El número de tarjeta debe tener 16 dígitos" required="required" /></td>
				<td><form:errors path="tarjetaCredito.numero" cssClass="error" /></td>
			</tr>
		
			<!-- Marca -->
			<tr>
				<td><form:label path="tarjetaCredito.marca"><spring:message code="createdit.actor.18" /></form:label></td>
				<td><form:input path="tarjetaCredito.marca"
						title="Falta agregar el tipo de marca" required="required" /></td>
				<td><form:errors path="tarjetaCredito.marca" cssClass="error" /></td>
			</tr>

			<!-- Mes de Expiración -->
			<tr>
				<td><form:label path="tarjetaCredito.mes"><spring:message code="createdit.actor.19" /></form:label></td>
				<td><form:input path="tarjetaCredito.mes" type="number" min="1"
						max="12" required="required" /></td>
				<td><form:errors path="tarjetaCredito.mes" cssClass="error" /></td>
			</tr>

			<!-- Año de Expiración -->
			<tr>
				<td><form:label path="tarjetaCredito.anio"><spring:message code="createdit.actor.20" /></form:label></td>
				<td><form:input path="tarjetaCredito.anio" type="number"
						min="2024" required="required" /></td>
				<td><form:errors path="tarjetaCredito.anio" cssClass="error" /></td>
			</tr>

			<!-- CVV -->
			<tr>
				<td><form:label path="tarjetaCredito.codigoCVV"><spring:message code="createdit.actor.21" /></form:label></td>
				<td><form:input path="tarjetaCredito.codigoCVV" pattern="\d{3}"
						title="El CVV debe tener 3 dígitos" required="required" /></td>
				<td><form:errors path="tarjetaCredito.codigoCVV"
						cssClass="error" /></td>
			</tr>


			<!-- Campos UserAccount -->
			<tr>
				<td><form:label path="userAccount.username"><spring:message code="createdit.actor.15" /></form:label></td>
				<td><form:input path="userAccount.username" /></td>
				<td><form:errors path="userAccount.username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="userAccount.password"><spring:message code="createdit.actor.16" /></form:label></td>
				<td><form:password path="userAccount.password" /></td>
				<td><form:errors path="userAccount.password" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value=<spring:message code="createdit.actor.14" /> />
					<button type="button" onclick="goBack()"><spring:message code="createdit.actor.12" /></button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>