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
    <h1>Gestionar Comentarios</h1>

    <!-- Formulario para escribir un nuevo comentario -->
    <h2>Escribir un nuevo comentario</h2>
    <form:form method="post" modelAttribute="nuevoComentario" action="${pageContext.request.contextPath}/createcomment">
        <table>
            <tr>
                <td>Texto:</td>
                <td>
                    <form:textarea path="texto" rows="3" cols="50"/>
                    <form:errors path="texto" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Guardar"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>