<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Gestionar Comentarios</title>
</head>
<body>
   <!-- Listado de comentarios existentes -->
    <h2>Listado de Comentarios</h2>
    <table border="1">
        <thead>
            <tr>
                <th><spring:message code="all.comments.value.1" /></th>
                <th><spring:message code="all.comments.value.2" /></th>
                <th><spring:message code="all.comments.value.5" /></th>
            </tr>
        </thead>
        <tbody>
            <jstl:forEach var="comentario" items="${comentarios}">
                <tr>
                    <td><fmt:formatDate value="${comentario.fechaPublicacion}" pattern="dd/MM/yyyy HH:mm"/></td>
                    <td>${comentario.texto}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/deletecomment/${comentario.id}" method="post">
                            <input type="submit" value="Borrar"/>
                        </form>
                    </td>
                </tr>
            </jstl:forEach>
        </tbody>
    </table>
</body>
</html>