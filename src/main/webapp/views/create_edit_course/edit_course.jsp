<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Modificar Curso</title>
</head>
<body>
	<form:form modelAttribute="curso" method="post" 
		action="${pageContext.request.contextPath}/curso/edit_course.do">
		<table>
			<!-- Campo Id (oculto) -->
			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<!-- Campo Version (oculto) -->
			<tr>
				<td><form:hidden path="version" /></td>
			</tr>
			<tr>
				<td><form:label path="titulo">T�tulo:</form:label></td>
				<td><form:input path="titulo" />${curso.titulo}</td>
				<td><form:errors path="titulo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="estilo.id">Estilo:</form:label></td>
				<td><form:select path="estilo.id">
						<form:options items="${estilos}" itemValue="id" itemLabel="nombre" />
					</form:select></td>
				<td><form:errors path="estilo.id" cssClass="error" /></td>
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
				<td><form:label path="diaSemana">D�a de la Semana:</form:label></td>
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
