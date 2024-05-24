
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h1>Dashboard</h1>

<h2>Cursos por Academia</h2>
<ul>
    <li>M�nimo: ${coursesStats.min}</li>
    <li>Media: ${coursesStats.average}</li>
    <li>Desviaci�n T�pica: ${coursesStats.stdDev}</li>
    <li>M�ximo: ${coursesStats.max}</li>
</ul>

<h2>Solicitudes por Curso</h2>
<ul>
    <li>M�nimo: ${requestsStats.min}</li>
    <li>Media: ${requestsStats.average}</li>
    <li>Desviaci�n T�pica: ${requestsStats.stdDev}</li>
    <li>M�ximo: ${requestsStats.max}</li>
</ul>

<h2>Tutoriales por Academia</h2>
<ul>
    <li>M�nimo: ${tutorialsStats.min}</li>
    <li>Media: ${tutorialsStats.average}</li>
    <li>M�ximo: ${tutorialsStats.max}</li>
</ul>

<h2>Veces que son Mostrados los Tutoriales</h2>
<ul>
    <li>M�nimo: ${tutorialsDisplayStats.min}</li>
    <li>Media: ${tutorialsDisplayStats.average}</li>
    <li>M�ximo: ${tutorialsDisplayStats.max}</li>
</ul>

<h2>Listado de Tutoriales (Orden Descendente por Visualizaciones)</h2>
<table>
    <thead>
        <tr>
            <th>T�tulo</th>
            <th>Visualizaciones</th>
        </tr>
    </thead>
    <tbody>
        <jstl:forEach var="tutorial" items="${tutorialsList}">
            <tr>
                <td>${tutorial.title}</td>
                <td>${tutorial.views}</td>
            </tr>
        </jstl:forEach>
    </tbody>
</table>

<h2>Comentarios por Actor</h2>
<ul>
    <li>Media: ${averageCommentsPerActor}</li>
</ul>

<h2>Suscripciones por Actor</h2>
<ul>
    <li>Media: ${averageSubscriptionsPerActor}</li>
</ul>

</body>
</html>

