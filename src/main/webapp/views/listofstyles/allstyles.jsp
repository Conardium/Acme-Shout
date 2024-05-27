
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
    <h1>Lista de Estilos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Cursos</th>
            </tr>
        </thead>
        <tbody>
            <jstl:forEach var="estilo" items="${estilos}">
                <tr>
                    <td>${estilo.nombre}</td>
                    <td>${estilo.descripcion}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/coursesbystyle/${estilo.id}" method="get">
                            <button type="submit">Ver Cursos</button>
                        </form>
                    </td>
                </tr>
            </jstl:forEach>
        </tbody>
    </table>
</body>
</html>