<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
    uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filtro de Cursos</title>
</head>
<body>
<button type="button" onclick="goBack()">Volver</button>
    <h1>Lista de Cursos</h1>
    
    <!-- Formulario de búsqueda -->
    <form action="${pageContext.request.contextPath}/buscarCursos" method="get">
        <label for="keyword">Buscar curso:</label>
        <input type="text" id="keyword" name="keyword" required>
        <button type="submit">Buscar</button>
    </form>
    
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
                <th>Academia</th>
                <c:if test="${sessionScope.alumno != null}">
                    <th>Solicitud</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="curso" items="${cursosFiltrados}">
                <tr>
                    <td>${curso.titulo}</td>
                    <td>${curso.estilo.nombre}</td>
                    <td>${curso.nivel}</td>
                    <td><fmt:formatDate value="${curso.fechaInicio}" pattern="dd/MM/yyyy HH:mm" /></td>
                    <td><fmt:formatDate value="${curso.fechaFin}" pattern="dd/MM/yyyy HH:mm" /></td>
                    <td>${curso.diaSemana}</td>
                    <td><fmt:formatDate value="${curso.hora}" pattern="HH:mm:ss" /></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/academiesbycourse/${curso.id}" method="get">
                            <button type="submit">Ver Academia</button>
                        </form>
                    </td>
                    <c:if test="${sessionScope.alumno != null && curso.noTieneSolicitud}">
                        <td>
                            <form action="${pageContext.request.contextPath}/applicationcourse/${curso.id}" method="post">
                                <button type="submit">Solicitar</button>
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jcomun.js"></script>
    
</body>
</html>
