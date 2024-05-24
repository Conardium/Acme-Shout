<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <title>Modificar Estilo</title>
</head>
<body>

<h2>Modificar Estilo</h2>

<form:form modelAttribute="estilo" method="post" action="${pageContext.request.contextPath}/updateEstilo">
    <table>
        <!-- Campo Nombre -->
        <tr>
            <td><form:label path="nombre">Nombre:</form:label></td>
            <td><form:input path="nombre" /></td>
            <td><form:errors path="nombre" cssClass="error" /></td>
        </tr>
        <!-- Campo Descripción -->
        <tr>
            <td><form:label path="descripcion">Descripción:</form:label></td>
            <td><form:textarea path="descripcion" rows="3" cols="50"/></td>
            <td><form:errors path="descripcion" cssClass="error" /></td>
        </tr>
        <!-- Campo Imágenes -->
        <tr>
            <td><form:label path="imagenes">Imágenes (URLs, separadas por comas):</form:label></td>
            <td><form:textarea path="imagenes" rows="3" cols="50"/></td>
            <td><form:errors path="imagenes" cssClass="error" /></td>
        </tr>
        <!-- Campo Videos -->
        <tr>
            <td><form:label path="videos">Videos (URLs, separadas por comas):</form:label></td>
            <td><form:textarea path="videos" rows="3" cols="50"/></td>
            <td><form:errors path="videos" cssClass="error" /></td>
        </tr>
        <!-- Botón de submit -->
        <tr>
            <td colspan="3"><input type="submit" value="Guardar Cambios" /></td>
        </tr>
        <!-- Botón de volver -->
        <tr>
            <td colspan="3">
                <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/estilos';">Volver</button>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
