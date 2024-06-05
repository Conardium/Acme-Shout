<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="createdit.comment.0" /></title>
</head>
<body>

    <form:form method="post" modelAttribute="comentario" action="${pageContext.request.contextPath}/comentario/create_comment.do">
        <table>
            <tr>
                <td><spring:message code="createdit.comment.1" /></td>
                <td>
                    <form:textarea path="texto" rows="3" cols="50" required="required" maxlength="140"/>
                    <form:errors path="texto" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value=<spring:message code="createdit.comment.2"/>>
                </td>
            </tr>
        </table>
    </form:form>
    	<button type="button" onclick="goBack()"><spring:message code="createdit.comment.3" /></button>
</body>
</html>