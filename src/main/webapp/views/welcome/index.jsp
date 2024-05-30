
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<p>
	<spring:message code="welcome.greeting.prefix" />
	${name}
	<spring:message code="welcome.greeting.suffix" />
</p>

<p>
	<spring:message code="welcome.greeting.current.time" />
	${moment}
</p>

<!DOCTYPE html>
<html>
<head>
<title>Menú Principal</title>
<style>
.button-container {
	margin: 20px;
}

.button-container h3 {
	margin-bottom: 10px;
}

.button-container button {
	padding: 10px 20px;
	font-size: 16px;
}
</style>
</head>
<body>

	<h1>Menú Principal</h1>

	<jstl:if test="${autoridad == 'NADA'}">
		<div class="button-container">
			<h3>Registrarse en el sistema como academia o alumno/a</h3>
			<form
				action="${pageContext.request.contextPath}/alumno/form_sing_up_student.do"
				method="get">
				<button type="submit">Registrarse como Alumno</button>
			</form>
			<form
				action="${pageContext.request.contextPath}/academia/form_sing_up_academy.do"
				method="get">
				<button type="submit">Registrarse como Academia</button>
			</form>
		</div>
	</jstl:if>

	<div class="button-container">
		<h3>Navegar por el catálogo de academias</h3>
		<form
			action="${pageContext.request.contextPath}/academia/allacademies.do"
			method="get">
			<button type="submit">Ver Academias</button>
		</form>
	</div>

	<div class="button-container">
		<h3>Navegar por el catálogo de cursos</h3>
		<form action="${pageContext.request.contextPath}/curso/allcourses.do"
			method="get">
			<button type="submit">Ver Cursos</button>
		</form>
	</div>

	<div class="button-container">
		<h3>Navegar por la tipología de estilos</h3>
		<form action="${pageContext.request.contextPath}/estilo/allstyles.do"
			method="get">
			<button type="submit">Ver Estilos</button>
		</form>
	</div>

</body>
</html>
