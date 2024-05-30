
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
    <title>Lista de Academias</title>
</head>
<body>
<button type="button" onclick="goBack()">Volver</button>
    <h1>Lista de Academias</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Nombre Comercial</th>
                <th>Persona al cargo</th>
                <th>Correo</th>
                <th>Nombre Comercial</th>
                <th>Dirección Postal</th>
                <th>Cursos</th>
            </tr>
        </thead>
        <tbody>
            <jstl:forEach var="academia" items="${academias}">
                <tr>
                    <td>${academia.nombreComercial}</td>
                    <td>${academia.nombre} ${academia.apellidos}</td>
                    <td>${academia.correo}</td>
                    <td>${academia.telefono}</td>
                    <td>${academia.direccionPostal}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/curso/allcoursesfromacademy.do" 
                        method="get">
                        	<input type="hidden" name="academiaId" value="${academia.id}" />
                            <button type="submit">Ver Cursos</button>
                        </form>
                    </td>
                </tr>
            </jstl:forEach>
        </tbody>
    </table>
</body>
</html>