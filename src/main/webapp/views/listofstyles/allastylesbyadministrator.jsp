
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
    <title>Lista de Estilos</title>
</head>
<body>
<button type="button" onclick="goBack()">Volver</button>
    <h1>Lista de Estilos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Editar</th>
                <th>Borrar</th>
            </tr>
        </thead>
        <tbody>
            <jstl:forEach var="estilo" items="${estilos}">
                <tr>
                    <td>${estilo.nombre}</td>
                    <td>${estilo.descripcion}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/editstyle/${estilo.id}" method="get">
                            <button type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/deletestyle/${estilo.id}" method="get">
                            <button type="submit">Borrar</button>
                        </form>
                    </td>
                </tr>
            </jstl:forEach>
        </tbody>
    </table>
    	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jcomun.js"></script>
</body>
</html>