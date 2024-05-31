
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

<h2>Cursos por Academia</h2>
<ul>
    <li>M�nimo: ${minimoCursoPorAcademia}</li>
    <li>Media: ${mediaCursoPorAcademia}</li>
    <li>Desviaci�n T�pica: ${stdDevCursoPorAcademia}</li>
    <li>M�ximo: ${maxCursoPorAcademia}</li>
</ul>

<h2>Solicitudes por Curso</h2>
<ul>
    <li>M�nimo: ${minSolicitudPorCurso}</li>
    <li>Media: ${mediaSolicitudPorCuros}</li>
    <li>Desviaci�n T�pica: ${minSolicitudPorCurso}</li>
    <li>M�ximo: ${minSolicitudPorCurso}</li>
</ul>

<h2>Tutoriales por Academia</h2>
<ul>
    <li>M�nimo: ${minTutorialPorAcademia}</li>
    <li>Media: ${mediaTutorialPorAcademia}</li>
    <li>M�ximo: ${maxTutorialPorAcademia}</li>
</ul>

<h2>Veces que son Mostrados los Tutoriales</h2>
<ul>
    <li>M�nimo: ${minTutorialVecesMostrado}</li>
    <li>Media: ${mediaTutorialVecesMostrado}</li>
    <li>M�ximo: ${maxTutorialVecesMostrado}</li>
</ul>

<h2>Listado de Tutoriales (Orden Descendente por Visualizaciones</h2>
<table>
    <thead>
        <tr>
            <th>T�tulo</th>
            <th>Visualizaciones</th>
        </tr>
    </thead>
    <tbody>
        <jstl:forEach var="tutorial" items="${listaTutoriales}">
            <tr>
                <td>${tutorial.titulo}</td>
                <td>${tutorial.contador}</td>
            </tr>
        </jstl:forEach>
    </tbody>
</table>

<h2>Comentarios por Actor</h2>
<ul>
    <li>Media: ${mediaComentariosPorActor}</li>
</ul>

<h2>Suscripciones por Actor</h2>
<ul>
    <li>Media: ${mediaSuscriptoresPorActor}</li>
</ul>

</body>
</html>

