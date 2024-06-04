
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

<h2><spring:message code="titulo.parte.0" /></h2>
<ul>
    <li><spring:message code="titulo.parte.7" /> ${minimoCursoPorAcademia}</li>
    <li><spring:message code="titulo.parte.8" /> ${mediaCursoPorAcademia}</li>
    <li><spring:message code="titulo.parte.9" /> ${stdDevCursoPorAcademia}</li>
    <li><spring:message code="titulo.parte.10" /> ${maxCursoPorAcademia}</li>
</ul>

<h2><spring:message code="titulo.parte.1" /></h2>
<ul>
    <li><spring:message code="titulo.parte.7" /> ${minSolicitudPorCurso}</li>
    <li><spring:message code="titulo.parte.8" /> ${mediaSolicitudPorCuros}</li>
    <li><spring:message code="titulo.parte.9" /> ${minSolicitudPorCurso}</li>
    <li><spring:message code="titulo.parte.10" /> ${minSolicitudPorCurso}</li>
</ul>

<h2><spring:message code="titulo.parte.2" /></h2>
<ul>
    <li><spring:message code="titulo.parte.7" /> ${minTutorialPorAcademia}</li>
    <li><spring:message code="titulo.parte.8" /> ${mediaTutorialPorAcademia}</li>
    <li><spring:message code="titulo.parte.10" /> ${maxTutorialPorAcademia}</li>
</ul>

<h2><spring:message code="titulo.parte.3" /></h2>
<ul>
    <li><spring:message code="titulo.parte.7" /> ${minTutorialVecesMostrado}</li>
    <li><spring:message code="titulo.parte.8" /> ${mediaTutorialVecesMostrado}</li>
    <li><spring:message code="titulo.parte.10" /> ${maxTutorialVecesMostrado}</li>
</ul>

<h2><spring:message code="titulo.parte.4" /></h2>
<table>
    <thead>
        <tr>
            <th><spring:message code="titulo.parte.11" /></th>
            <th><spring:message code="titulo.parte.12" /></th>
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

<h2><spring:message code="titulo.parte.5" /></h2>
<ul>
    <li><spring:message code="titulo.parte.8" /> ${mediaComentariosPorActor}</li>
</ul>

<h2><spring:message code="titulo.parte.6" /></h2>
<ul>
    <li><spring:message code="titulo.parte.8" /> ${mediaSuscriptoresPorActor}</li>
</ul>

</body>
</html>

