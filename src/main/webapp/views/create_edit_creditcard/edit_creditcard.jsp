<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <title>Modificar Tarjeta de Credito</title>
</head>
<body>
<button type="button" onclick="goBack()">Volver</button>
<h2>Modificar Tarjeta de Credito</h2>

<form:form modelAttribute="alumno" method="post" action="register">
    <table>
        <!-- Campos Alumno -->
        <tr>
            <td><form:label path="tarjetaCredito.numero">Número de Tarjeta de Crédito:</form:label></td>
            <td><form:input path="tarjetaCredito.numero" /></td>
            <td><form:errors path="tarjetaCredito.numero" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="tarjetaCredito.fechaExpiracion">Fecha de Expiración:</form:label></td>
            <td><form:input path="tarjetaCredito.fechaExpiracion" /></td>
            <td><form:errors path="tarjetaCredito.fechaExpiracion" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="tarjetaCredito.codigoSeguridad">Código de Seguridad:</form:label></td>
            <td><form:input path="tarjetaCredito.codigoSeguridad" /></td>
            <td><form:errors path="tarjetaCredito.codigoSeguridad" cssClass="error" /></td>
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