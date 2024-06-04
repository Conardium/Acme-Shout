
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lista de Suscripciones</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
            </tr>
        </thead>
        <tbody>
            <jstl:forEach var="subs" items="${suscritos}">
                <tr>
                    <td>${subs.nombre}</td>
                    <td>${subs.apellido}</td>
                </tr>
            </jstl:forEach>
        </tbody>
    </table>
    <button type="button" onclick="goBack()">Volver</button>
</body>
</html>