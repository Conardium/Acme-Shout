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

	<h2>Registro de Alumno</h2>

	<form:form modelAttribute="alumno" method="post" action="register">
		<table>
			<!-- Campos Actor -->
			<tr>
				<td><form:label path="nombre">Nombre:</form:label></td>
				<td><form:input path="nombre" /></td>
				<td><form:errors path="nombre" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="apellidos">Apellidos:</form:label></td>
				<td><form:input path="apellidos" /></td>
				<td><form:errors path="apellidos" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="correo">Correo:</form:label></td>
				<td><form:input path="correo" /></td>
				<td><form:errors path="correo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono">Tel�fono:</form:label></td>
				<td><form:input path="telefono" /></td>
				<td><form:errors path="telefono" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="direccionPostal">Direcci�n Postal:</form:label></td>
				<td><form:input path="direccionPostal" /></td>
				<td><form:errors path="direccionPostal" cssClass="error" /></td>
			</tr>

			<!-- Campos Alumno -->
			<tr>
				<td><form:label path="tarjetaCredito.numero">N�mero de Tarjeta de Cr�dito:</form:label></td>
				<td><form:input path="tarjetaCredito.numero" /></td>
				<td><form:errors path="tarjetaCredito.numero" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="tarjetaCredito.mes">Mes de Expiraci�n:</form:label></td>
				<td><form:input path="tarjetaCredito.mes" />1</td>
				<td><form:errors path="tarjetaCredito.mes"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="tarjetaCredito.anio">A�o de Expiraci�n:</form:label></td>
				<td><form:input path="tarjetaCredito.anio" />2025</td>
				<td><form:errors path="tarjetaCredito.anio"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="tarjetaCredito.codigoCVV">CVV:</form:label></td>
				<td><form:input path="tarjetaCredito.codigoCVV" /></td>
				<td><form:errors path="tarjetaCredito.codigoCVV"
						cssClass="error" /></td>
			</tr>

			<!-- Campos UserAccount -->
			<tr>
				<td><form:label path="userAccount.username">Nombre de Usuario:</form:label></td>
				<td><form:input path="userAccount.username" /></td>
				<td><form:errors path="userAccount.username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="userAccount.password">Contrase�a:</form:label></td>
				<td><form:password path="userAccount.password" /></td>
				<td><form:errors path="userAccount.password" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Registrar" />
					<button type="button" onclick="goBack()">Volver</button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>