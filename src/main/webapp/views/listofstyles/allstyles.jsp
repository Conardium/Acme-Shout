
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
				<th>Nombre</th>
				<th>Descripcion</th>
				<th>Detalles</th>
				<th>Cursos</th>
				<jstl:if test="${autoridad == 'ADMINISTRADOR'}">
					<th>Editar</th>
					<th>Borrar</th>
				</jstl:if>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach var="estilo" items="${estilos}">
				<tr>
					<td>${estilo.nombre}</td>
					<td>${estilo.descripcion}</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/estilo/style.do"
							method="get">
							<input type="hidden" name="estiloId" value="${estilo.id}" />
							<button type="submit">Detalles</button>
						</form>
					</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/curso/allcoursesfromstyle.do"
							method="get">
							<input type="hidden" name="estiloId" value="${estilo.id}" />
							<button type="submit">Ver Cursos</button>
						</form>
					</td>
					<jstl:if test="${autoridad == 'ADMINISTRADOR'}">
						<td>
							<form
								action="${pageContext.request.contextPath}/estilo/form_edit_style.do"
								method="get">
								<input type="hidden" name="estiloId" value="${estilo.id}" />
								<button type="submit">Editar</button>
							</form>
						</td>
						<td>
							<form
								action="${pageContext.request.contextPath}/estilo/delete_style.do"
								method="get">
								<input type="hidden" name="estiloId" value="${estilo.id}" />
								<button type="submit">Borrar</button>
							</form>
						</td>
					</jstl:if>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<form action="${pageContext.request.contextPath}/estilo/form_create_style.do"
			method="get">
			<button type="submit">Crear</button>
		</form>
	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>