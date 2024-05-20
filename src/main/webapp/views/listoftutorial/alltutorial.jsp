<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net/" %>
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
                        <form action="${pageContext.request.contextPath}/tutorial/${tutorial.id}" method="get">
                            <button type="submit">Ver Tutorial</button>
                        </form>
                    </td>
                </tr>
            </jstl:forEach>
        </tbody>
    </table>
</body>
</html>
