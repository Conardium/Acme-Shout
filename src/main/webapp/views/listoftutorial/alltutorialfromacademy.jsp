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
				<th>T�tulo</th>
				<th>Descripci�n</th>
				<th>Ver</th>
				<th>Editar</th>
				<th>Borrar</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="tutorial" items="${tutoriales}">
				<tr>
					<td>${tutorial.titulo}</td>
					<td>${tutorial.descripcion}</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/tutorial/form_show_tutorial.do"
							method="get">
							<input type="hidden" name="tutorialId" value="${tutorial.id}" />
							<button type="submit">Ver</button>
						</form>
					<td>
						<form
							action="${pageContext.request.contextPath}/tutorial/form_edit_tutorial.do"
							method="get">
							<input type="hidden" name="tutorialId" value="${tutorial.id}" />
							<button type="submit">Editar</button>
						</form>
					</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/tutorial/delete_tutorial.do"
							method="get">
							<input type="hidden" name="tutorialId" value="${tutorial.id}" />
							<button type="submit">Borrar</button>
						</form>
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<form
		action="${pageContext.request.contextPath}/tutorial/create_tutorial.do"
		method="get">
		<button type="submit">Crear</button>
	</form>
	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>
