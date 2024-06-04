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
    <title>Comentar</title>
</head>
<body>

    <form:form method="post" modelAttribute="nuevoComentario" action="${pageContext.request.contextPath}/comentario/create_comment">
        <table>
            <tr>
                <td>Comentario:</td>
                <td>
                    <form:textarea path="texto" rows="3" cols="50" required="required" maxlength="140"/>
                    <form:errors path="texto" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Crear"/>
                </td>
            </tr>
        </table>
    </form:form>
    	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>