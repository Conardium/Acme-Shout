
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lista de Cursos</title>
</head>
<body>
    <h1>Lista de Cursos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Título del Curso</th>
                <th>Estilo</th>
                <th>Nivel</th>
                <th>Fecha de Inicio</th>
                <th>Fecha de Fin</th>
                <th>Día de la Semana</th>
                <th>Hora</th>
                <th>Editar</th>
                <th>Borrar</th>
            </tr>
        </thead>
        <tbody>
            <jstl:forEach var="curso" items="${cursos}">
                <tr>
                    <td>${curso.titulo}</td>
                    <td>${curso.estilo.nombre}</td>
                    <td>${curso.nivel}</td>
                    <td><fmt:formatDate value="${curso.fechaInicio}" pattern="dd/MM/yyyy HH:mm" /></td>
                    <td><fmt:formatDate value="${curso.fechaFin}" pattern="dd/MM/yyyy HH:mm" /></td>
                    <td>${curso.diaSemana}</td>
                    <td><fmt:formatDate value="${curso.hora}" pattern="HH:mm:ss" /></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/editcourse/${curso.id}" method="get">
                            <button type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/deletecourse/${curso.id}" method="get">
                            <button type="submit">Borrar</button>
                        </form>
                    </td>
                </tr>
            </jstl:forEach>
        </tbody>
    </table>
</body>
</html>