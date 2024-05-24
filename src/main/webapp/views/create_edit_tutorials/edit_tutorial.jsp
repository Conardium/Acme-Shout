<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Modificar Tutorial</title>
</head>
<body>

    <h2>Modificar Tutorial</h2>

    <form:form modelAttribute="tutorial" method="post" action="editTutorial">
        <table>
            <tr>
                <td><form:label path="titulo">Título:</form:label></td>
                <td><form:input path="titulo" value="${tutorial.titulo}" /></td>
                <td><form:errors path="titulo" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="descripcion">Descripción:</form:label></td>
                <td><form:input path="descripcion" value="${tutorial.descripcion}" /></td>
                <td><form:errors path="descripcion" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="video">Video (URL de YouTube):</form:label></td>
                <td><form:input path="video" value="${tutorial.video}" /></td>
                <td><form:errors path="video" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="contador">Contador:</form:label></td>
                <td><form:input path="contador" value="${tutorial.contador}" /></td>
                <td><form:errors path="contador" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Editar Tutorial" /></td>
            </tr>
        </table>
    </form:form>

</body>
</html>
