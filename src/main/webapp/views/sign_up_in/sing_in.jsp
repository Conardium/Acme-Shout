<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión</title>
</head>
<body>

<h2>Escriba usuario y contraseña</h2>

<form:form method="post" action="login">
    <table>
        <tr>
            <td><form:label path="username">Nombre Usuario:</form:label></td>
            <td><form:input path="username" /></td>
            <td><form:errors path="username" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Contraseña:</form:label></td>
            <td><form:password path="password" /></td>
            <td><form:errors path="password" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Iniciar Sesión" /></td>
        </tr>
    </table>
</form:form>

</body>
</html>