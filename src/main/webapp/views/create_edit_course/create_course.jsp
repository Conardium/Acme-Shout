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
<title><spring:message code="edit.courses.0" /></title>
</head>
<body>

	<form:form modelAttribute="curso" method="post"
		action="${pageContext.request.contextPath}/curso/create_course.do">
		<table>
			<tr>
				<td><form:label path="titulo"><spring:message code="edit.courses.2" /></form:label></td>
				<td><form:input path="titulo" />${curso.titulo}</td>
				<td><form:errors path="titulo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="estilo"><spring:message code="edit.courses.3" /></label></td>
				<td><select id="estilo" name="estiloId">
						<jstl:forEach items="${estilos}" var="estilo">
							<option value="${estilo.id}"
								<jstl:if test="${curso.estilo.id == estilo.id}">selected</jstl:if>>${estilo.nombre}</option>
						</jstl:forEach>
				</select></td>
				<td><form:errors path="estilo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="nivel"><spring:message code="edit.courses.4" /></form:label></td>
				<td><form:select path="nivel">
						<form:options items="${niveles}" />
					</form:select></td>
				<td><form:errors path="nivel" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaInicio"><spring:message code="edit.courses.5" /></form:label></td>
				<td><form:input path="fechaInicio" />${curso.fechaInicio}</td>
				<td><form:errors path="fechaInicio" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaFin"><spring:message code="edit.courses.6" /></form:label></td>
				<td><form:input path="fechaFin" />${curso.fechaFin}</td>
				<td><form:errors path="fechaFin" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="diaSemana"><spring:message code="edit.courses.7" /></form:label></td>
				<td><form:select path="diaSemana">
						<form:options items="${dias}" />
					</form:select></td>
				<td><form:errors path="diaSemana" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="horaCurso"><spring:message code="edit.courses.8" /></label></td>
				<td><input type="text" id="horaCurso" name="horaCurso"
					value="${curso.hora}" /></td>
				<td><form:errors path="hora" cssClass="error" /></td>
			<tr>
				<td colspan="3"><input type="submit" value=<spring:message code="edit.courses.9" />/></td>
			</tr>
		</table>
	</form:form>
	<button type="button" onclick="goBack()"><spring:message code="edit.courses.10" /></button>
</body>
</html>
