<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Comentarios</title>
</head>
<body>
	<!-- Listado de comentarios existentes -->
	<table border="1">
		<thead>
			<tr>
				<th>Fecha de Publicación</th>
				<th>Texto</th>
				<th>Actor</th>
				<th>Suscribirse</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="comentario" items="${comentarios}">
				<tr>
					<td><fmt:formatDate value="${comentario.fechaPublicacion}"
							pattern="dd/MM/yyyy HH:mm" /></td>
					<td>${comentario.texto}</td>
					<td>${comentario.actor.userAccount.username}</td>
					<jstl:if test="${nombre != comentario.actor.userAccount.username}">
						<td><form
								action="${pageContext.request.contextPath}/comentario/suscribirseUser"
								method="post">
								<input type="hidden" name="comentarioId"
									value="${comentario.id}" /> <input type="submit"
									value="Suscribirse" />
							</form></td>
					</jstl:if>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
</body>
</html>