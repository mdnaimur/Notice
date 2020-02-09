<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/notices">Show Current
			Notices</a> <br /> <a
			href="${pageContext.request.contextPath }/createnotice">Create
			New Notices</a>
	</p>

	<sec:authorize access="!isAuthenticated()">
		<p>
			<a href="<c:url value='/login'/>"> Log In</a>
		</p>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<p>
			<a href="<c:url value='/j_spring_security_logout'/>">Log out</a>
		</p>
	</sec:authorize>
	<sec:authorize access="hasRole('admin')" >
		<p>
			<a href="<c:url value='/admin' />">Admin Page</a>
		</p>
	</sec:authorize>
</body>
</html>




