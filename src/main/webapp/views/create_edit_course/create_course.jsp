<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Registro de Curso</title>
</head>
<body>

	<form:form modelAttribute="curso" method="post"
		action="${pageContext.request.contextPath}/curso/create_course.do">
		<table>
			<tr>
				<td><form:label path="titulo">Título:</form:label></td>
				<td><form:input path="titulo" />${curso.titulo}</td>
				<td><form:errors path="titulo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="estilo">Estilo:</label></td>
				<td><select id="estilo" name="estiloId">
						<jstl:forEach items="${estilos}" var="estilo">
							<option value="${estilo.id}"
								<jstl:if test="${curso.estilo.id == estilo.id}">selected</jstl:if>>${estilo.nombre}</option>
						</jstl:forEach>
				</select></td>
				<td><form:errors path="estilo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="nivel">Nivel:</form:label></td>
				<td><form:select path="nivel">
						<form:options items="${niveles}" />
					</form:select></td>
				<td><form:errors path="nivel" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaInicio">Fecha de Inicio:</form:label></td>
				<td><form:input path="fechaInicio" />${curso.fechaInicio}</td>
				<td><form:errors path="fechaInicio" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaFin">Fecha de Fin:</form:label></td>
				<td><form:input path="fechaFin" />${curso.fechaFin}</td>
				<td><form:errors path="fechaFin" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="diaSemana">Día de la Semana:</form:label></td>
				<td><form:select path="diaSemana">
						<form:options items="${dias}" />
					</form:select></td>
				<td><form:errors path="diaSemana" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="horaCurso">Hora:</label></td>
				<td><input type="text" id="horaCurso" name="horaCurso"
					value="${curso.hora}" /></td>
				<td><form:errors path="hora" cssClass="error" /></td>
			<tr>
				<td colspan="3"><input type="submit" value="Registrar Curso" /></td>
			</tr>
		</table>
	</form:form>
	<button type="button" onclick="goBack()">Volver</button>
</body>
</html>
