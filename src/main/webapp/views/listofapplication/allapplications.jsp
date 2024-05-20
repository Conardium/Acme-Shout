<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <title>Listado de Solicitudes</title>
</head>
<body>

<h2>Listado de Solicitudes</h2>

<display:table name="${solicitudes}" requestURI="" pagesize="10" id="solicitud" class="displaytag">
    <display:column property="estado" title="Estado" sortable="true" />
    <display:column property="fecha" title="Fecha" sortable="true" format="{0,date,dd/MM/yyyy HH:mm}" />
    <display:column property="curso.nombre" title="Curso" sortable="true" />
</display:table>

</body>
</html>