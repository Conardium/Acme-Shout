
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Suscripciones</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th><spring:message code="list.of.subs.value.1" /></th>
                <th><spring:message code="list.of.subs.value.2" /></th>
            </tr>
        </thead>
        <tbody>
            <jstl:forEach var="subs" items="${suscriptores}">
                <tr>
                    <td>${subs.nombre}</td>
                    <td>${subs.apellidos}</td>
                </tr>
            </jstl:forEach>
        </tbody>
    </table>
    <button type="button" onclick="goBack()"><spring:message code="list.of.subs.value.3" /></button>
</body>
</html>