<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<title>Lista de Tutoriales</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th><spring:message code="alltutorial.value.1" /></th>
				<th><spring:message code="alltutorial.value.2" /></th>
				<th><spring:message code="alltutorial.value.3" /></th>
				<th><spring:message code="alltutorial.value.4" /></th>
				<th><spring:message code="alltutorial.value.5" /></th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="tutorial" items="${tutoriales}">
				<tr>
					<td>${tutorial.titulo}</td>
					<td>${tutorial.descripcion}</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/tutorial/show_tutorial.do"
							method="get">
							<input type="hidden" name="tutorialId" value="${tutorial.id}" />
							<button type="submit"><spring:message code="alltutorial.value.3" /></button>
						</form>
					<td>
						<form
							action="${pageContext.request.contextPath}/tutorial/form_edit_tutorial.do"
							method="get">
							<input type="hidden" name="tutorialId" value="${tutorial.id}" />
							<button type="submit"><spring:message code="alltutorial.value.4" /></button>
						</form>
					</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/tutorial/delete_tutorial.do"
							method="get">
							<input type="hidden" name="tutorialId" value="${tutorial.id}" />
							<button type="submit"><spring:message code="alltutorial.value.5" /></button>
						</form>
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<form
		action="${pageContext.request.contextPath}/tutorial/form_create_tutorial.do"
		method="get">
		<button type="submit"><spring:message code="alltutorial.value.7" /></button>
	</form>
	<button type="button" onclick="goBack()"><spring:message code="alltutorial.value.8" /></button>
</body>
</html>
