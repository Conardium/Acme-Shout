<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <title>Modificar Administrador</title>
</head>
<body>
<button type="button" onclick="goBack()">Volver</button>
<h2>Modificar Administrador</h2>

<form:form modelAttribute="admin" method="post" action="${pageContext.request.contextPath}/admin/edit_administrador">
    <table>
           <!-- Campos Actor -->
        <tr>
            <td><form:label path="nombre">Nombre:</form:label></td>
            <td><form:input path="nombre" />${admin.nombre}</td>
            <td><form:errors path="nombre" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="apellidos">Apellidos:</form:label></td>
            <td><form:input path="apellidos" />${admin.apellidos}</td>
            <td><form:errors path="apellidos" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="correo">Correo:</form:label></td>
            <td><form:input path="correo" />${admin.correo}</td>
            <td><form:errors path="correo" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="telefono">Teléfono:</form:label></td>
            <td><form:input path="telefono" />${admin.telefono}</td>
            <td><form:errors path="telefono" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="direccionPostal">Dirección Postal:</form:label></td>
            <td><form:input path="direccionPostal" />${admin.direccionPostal}</td>
            <td><form:errors path="direccionPostal" cssClass="error" /></td>
        </tr>
        
        <!-- Campos de UserAccount -->
        <tr>
            <td><form:label path="userAccount.username">Nombre de Usuario:</form:label></td>
            <td><form:input path="userAccount.username" />${admin.userAccount.username}<</td>
            <td><form:errors path="userAccount.username" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="userAccount.password">Contraseña:</form:label></td>
            <td><form:password path="userAccount.password" />${admin.userAccount.password}</td>
            <td><form:errors path="userAccount.password" cssClass="error" /></td>
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