
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<a href="#"><img src="images/logo.png" alt="Acme Dancer Co., Inc." /></a>
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasRole('ADMINISTRADOR')">
			<li><a class="fNiv"><spring:message	code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="${pageContext.request.contextPath}/estilo/allstyles.do"><spring:message code="master.page.administrator.action.1" /></a></li>
					<li><a href="${pageContext.request.contextPath}/admin/dashboard.do"><spring:message code="master.page.administrator.action.2" /></a></li>					
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('ACADEMIA')">
			<li><a class="fNiv"><spring:message	code="master.page.academy" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="${pageContext.request.contextPath}/curso/coursesbyacademyprofile.do"><spring:message code="master.page.academy.action.1" /></a></li>
					<li><a href="customer/action-2.do"><spring:message code="master.page.academy.action.2" /></a></li>					
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('ALUMNO')">
			<li><a class="fNiv"><spring:message	code="master.page.student" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="customer/action-1.do"><spring:message code="master.page.student.action.1" /></a></li>
					<li><a href="customer/action-2.do"><spring:message code="master.page.student.action.2" /></a></li>					
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
		</security:authorize>
		
		
		
		
		<security:authorize access="hasRole('ADMINISTRADOR')">
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="${pageContext.request.contextPath}/admin/show_profile.do"><spring:message code="master.page.profile.action.1" /></a></li>
					<li><a href="${pageContext.request.contextPath}/admin/form_edit_admin.do"><spring:message code="master.page.profile.action.2" /></a></li>
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
		<security:authorize access="hasRole('ACADEMIA')">
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="${pageContext.request.contextPath}/academia/show_profile.do"><spring:message code="master.page.profile.action.1" /></a></li>
					<li><a href="${pageContext.request.contextPath}/academia/form_edit_academy.do"><spring:message code="master.page.profile.action.2" /></a></li>
					<li><a href="profile/action-3.do"><spring:message code="master.page.profile.action.3" /></a></li>					
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
		<security:authorize access="hasRole('ALUMNO')">
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="${pageContext.request.contextPath}/alumno/show_profile.do"><spring:message code="master.page.profile.action.1" /></a></li>
					<li><a href="${pageContext.request.contextPath}/academia/form_edit_student.do"><spring:message code="master.page.profile.action.2" /></a></li>
					<li><a href="profile/action-3.do"><spring:message code="master.page.profile.action.3" /></a></li>					
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

