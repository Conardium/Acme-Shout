
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Estilos</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th><spring:message code="all.styles.value.1" /></th>
				<th><spring:message code="all.styles.value.2" /></th>
				<th><spring:message code="all.styles.value.3" /></th>
				<th><spring:message code="all.styles.value.4" /></th>
				<jstl:if test="${autoridad == 'ADMINISTRADOR'}">
					<th><spring:message code="all.styles.value.5" /></th>
					<th><spring:message code="all.styles.value.6" /></th>
				</jstl:if>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="estilo" items="${estilos}">
				<tr>
					<td>${estilo.nombre}</td>
					<td>${estilo.descripcion}</td>
					<td>
						<form action="${pageContext.request.contextPath}/estilo/style.do"
							method="get">
							<input type="hidden" name="estiloId" value="${estilo.id}" />
							<button type="submit">
								<spring:message code="all.styles.value.7" />
							</button>
						</form>
					</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/curso/allcoursesfromstyle.do"
							method="get">
							<input type="hidden" name="estiloId" value="${estilo.id}" />
							<button type="submit">
								<spring:message code="all.styles.value.8" />
							</button>
						</form>
					</td>
					<jstl:if test="${autoridad == 'ADMINISTRADOR'}">
						<td>
							<form
								action="${pageContext.request.contextPath}/estilo/form_edit_style.do"
								method="get">
								<input type="hidden" name="estiloId" value="${estilo.id}" />
								<button type="submit">
									<spring:message code="all.styles.value.9" />
								</button>
							</form>
						</td>
						<td>
							<form
								action="${pageContext.request.contextPath}/estilo/delete_style.do"
								method="get">
								<input type="hidden" name="estiloId" value="${estilo.id}" />
								<button type="submit">
									<spring:message code="all.styles.value.6" />
								</button>
							</form>
						</td>
					</jstl:if>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<jstl:if test="${autoridad == 'ADMINISTRADOR'}">
		<form
			action="${pageContext.request.contextPath}/estilo/form_create_style.do"
			method="get">
			<button type="submit">
				<spring:message code="all.styles.value.10" />
			</button>
		</form>
	</jstl:if>
	<button type="button" onclick="goBack()">
		<spring:message code="all.styles.value.11" />
	</button>
</body>
</html>