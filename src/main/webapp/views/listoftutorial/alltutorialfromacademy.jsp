<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
    <title>Lista de Tutoriales</title>
</head>
<body>
    <h1>Lista de Tutoriales</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Título</th>
                <th>Descripción</th>
                <th>Ver</th>
            </tr>
        </thead>
        <tbody>
            <jstl:forEach var="tutorial" items="${tutoriales}">
                <tr>
                    <td>${tutorial.titulo}</td>
                    <td>${tutorial.descripcion}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/tutorial/edittutorial.do" 
                        method="get">
                        <input type="hidden" name="tutorialId" value="${tutorial.id}" />
                            <button type="submit">Editar</button>
                        </form>
                        <form action="${pageContext.request.contextPath}/tutorial/deletetutorial.do" 
                        method="get">
                        <input type="hidden" name="tutorialId" value="${tutorial.id}" />
                            <button type="submit">Borrar</button>
                        </form>
                        <form action="${pageContext.request.contextPath}/tutorial/show_tutorial.do" 
                        method="get">
                        <input type="hidden" name="tutorialId" value="${tutorial.id}" />
                            <button type="submit">Ver</button>
                        </form>
                    </td>
                </tr>
            </jstl:forEach>
        </tbody>
    </table>
    <button type="button" onclick="goBack()">Volver</button>
</body>
</html>
