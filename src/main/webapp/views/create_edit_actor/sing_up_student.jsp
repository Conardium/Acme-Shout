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
				<td><form:input path="correo" pattern=".+@.+\\..+"
						title="El correo debe seguir el formato 'usuario@dominio.com'" /></td>
				<td><form:errors path="correo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono">Teléfono:</form:label></td>
				<td><form:input path="telefono" pattern="\\d{2}\\s\\d{4,}"
						title="El teléfono debe seguir el formato 'xx xxxx...'" /></td>
				<td><form:errors path="telefono" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="direccionPostal">Dirección Postal:</form:label></td>
				<td><form:input path="direccionPostal" /></td>
				<td><form:errors path="direccionPostal" cssClass="error" /></td>
			</tr>

			<!-- Campos Alumno -->
			<!-- Número de Tarjeta de Crédito -->
			<tr>
				<td><form:label path="tarjetaCredito.numero">Número de Tarjeta de Crédito:</form:label></td>
				<td><form:input path="tarjetaCredito.numero" pattern="\\d{16}"
						title="El número de tarjeta debe tener 16 dígitos" required="required" /></td>
				<td><form:errors path="tarjetaCredito.numero" cssClass="error" /></td>
			</tr>
		
			<!-- Marca -->
			<tr>
				<td><form:label path="tarjetaCredito.marca">Marca de Tarjeta:</form:label></td>
				<td><form:input path="tarjetaCredito.marca"
						title="Falta agregar el tipo de marca" required="required" /></td>
				<td><form:errors path="tarjetaCredito.marca" cssClass="error" /></td>
			</tr>

			<!-- Mes de Expiración -->
			<tr>
				<td><form:label path="tarjetaCredito.mes">Mes de Expiración:</form:label></td>
				<td><form:input path="tarjetaCredito.mes" type="number" min="1"
						max="12" required="required" /></td>
				<td><form:errors path="tarjetaCredito.mes" cssClass="error" /></td>
			</tr>

			<!-- Año de Expiración -->
			<tr>
				<td><form:label path="tarjetaCredito.anio">Año de Expiración:</form:label></td>
				<td><form:input path="tarjetaCredito.anio" type="number"
						min="2024" required="required" /></td>
				<td><form:errors path="tarjetaCredito.anio" cssClass="error" /></td>
			</tr>

			<!-- CVV -->
			<tr>
				<td><form:label path="tarjetaCredito.codigoCVV">CVV:</form:label></td>
				<td><form:input path="tarjetaCredito.codigoCVV" pattern="\d{3}"
						title="El CVV debe tener 3 dígitos" required="required" /></td>
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
				<td><form:label path="userAccount.password">Contraseña:</form:label></td>
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