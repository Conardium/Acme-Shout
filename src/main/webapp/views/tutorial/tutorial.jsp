<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Detalle del Tutorial</title>
    <style>
        iframe {
            width: 100%;
            height: 500px;
            border: none;
        }
    </style>
</head>
<body>
    <h1>${tutorial.titulo}</h1>
    <jstl:choose>
        <jstl:when test="${not empty tutorial.video}">
            <iframe 
                src="https://www.youtube.com/embed/${fn:substringAfter(tutorial.video, 'v=')}"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                allowfullscreen>
            </iframe>
        </jstl:when>
        <jstl:otherwise>
            <p>El vídeo no está disponible.</p>
        </jstl:otherwise>
    </jstl:choose>
    <button type="button" onclick="goBack()">Volver</button>
</body>
</html>
