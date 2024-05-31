<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Crear Estilos</title>
</head>
<body>

    <!-- Formulario para crear un nuevo estilo -->
    <form:form method="post" modelAttribute="estilo" action="${pageContext.request.contextPath}/estilo/create_style.do">
        <table>
            <!-- Campo para el nombre -->
            <tr>
                <td>Nombre:</td>
                <td>
                    <form:input path="nombre" size="50"/>
                    <form:errors path="nombre" cssClass="error"/>
                </td>
            </tr>
            <!-- Campo para la descripción -->
            <tr>
                <td>Descripción:</td>
                <td>
                    <form:textarea path="descripcion" rows="3" cols="50"/>
                    <form:errors path="descripcion" cssClass="error"/>
                </td>
            </tr>
            <!-- Campo para imágenes -->
            <tr>
                <td>Imágenes (URLs, separadas por comas):</td>
                <td>
                    <form:textarea path="imagenes" rows="3" cols="50"/>
                    <form:errors path="imagenes" cssClass="error"/>
                </td>
            </tr>
            <!-- Campo para videos -->
            <tr>
                <td>Videos (URLs, separadas por comas):</td>
                <td>
                    <form:textarea path="videos" rows="3" cols="50"/>
                    <form:errors path="videos" cssClass="error"/>
                </td>
            </tr>
            <!-- Botón de submit -->
            <tr>
                <td colspan="2">
                    <input type="submit" value="Guardar"/>
                </td>
            </tr>
            <!-- Botón de volver -->
            <tr>
                <td colspan="2">
	<button type="button" onclick="goBack()">Volver</button>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
