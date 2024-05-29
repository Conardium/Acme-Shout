<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Modificar Curso</title>
</head>
<body>

	<h2>Modificar Curso</h2>

	<form:form modelAttribute="curso" method="post" action="editCourse">
		<table>
			<tr>
				<td><form:label path="titulo">Título:</form:label></td>
				<td><form:input path="titulo" />${curso.titulo}</td>
				<td><form:errors path="titulo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="estilo">Estilo:</form:label></td>
				<td><form:select path="estilo">
						<form:options items="${estilos}" itemValue="id" itemLabel="nombre" />
					</form:select></td>
				<td><form:errors path="estilo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="nivel">Nivel:</form:label></td>
				<td><form:input path="nivel" />${curso.nivel}</td>
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
				<td><form:input path="diaSemana" />${curso.diaSemana}</td>
				<td><form:errors path="diaSemana" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="hora">Hora:</form:label></td>
				<td><form:input path="hora" />${curso.hora}</td>
				<td><form:errors path="hora" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Modificar Curso" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
