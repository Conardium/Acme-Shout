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
				<th><spring:message code="all.comments.value.1" /></th>
				<th><spring:message code="all.comments.value.2" /></th>
				<th><spring:message code="all.comments.value.3" /></th>
				<th><spring:message code="all.comments.value.4" /></th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="comentario" items="${comentarios}">
				<tr>
					<td><fmt:formatDate value="${comentario.fechaPublicacion}"
							pattern="dd/MM/yyyy HH:mm" /></td>
					<td>${comentario.texto}</td>
					<td>${comentario.actor.userAccount.username}</td>
					<jstl:choose>
						<jstl:when
							test="${nombre != comentario.actor.userAccount.username}">
							<td><jstl:choose>
									<jstl:when test="${autoridad == 'ALUMNO'}">
										<form
											action="${pageContext.request.contextPath}/alumno/sub_student.do"
											method="post">
											<input type="hidden" name="actorId"
												value="${comentario.actor.userAccount.id}" /> <input type="submit"
												value="Suscribirse" />
										</form>
									</jstl:when>
									<jstl:otherwise>
										<form
											action="${pageContext.request.contextPath}/academia/sub_academy.do"
											method="post">
											<input type="hidden" name="actorId"
												value="${comentario.actor.userAccount.id}" /> <input type="submit"
												value="Suscribirse" />
										</form>
									</jstl:otherwise>
								</jstl:choose></td>
						</jstl:when>
						<jstl:otherwise>
							<td></td>
						</jstl:otherwise>
					</jstl:choose>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
</body>
</html>