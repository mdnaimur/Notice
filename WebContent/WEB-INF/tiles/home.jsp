<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div class="container" class="col-md-6 offset-md-3">
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Notices</th>
			</tr>
		</thead>
		<c:forEach var="notice" items="${notice}">
			<tbody>
				<tr>
					<td><c:out value="${notice.id}"></c:out></td>
					<td><c:out value="${notice.user.name}"></c:out></td>
					<td><c:out value="${notice.user.email}"></c:out></td>
					<td><c:out value="${notice.text}"></c:out></td>
				</tr>
		</c:forEach>
	</table>
</div>

<c:choose>
	<c:when test="${hasNotice}">
		<a href="<c:url value='/createnotice'/>">Edit or Delete</a>

	</c:when>
	<c:otherwise>
		<a href="<c:url value='/createnotice'/>">Add a new Notice</a>

	</c:otherwise>
</c:choose>
<div>
	<!-- 
	<p>
		<a href="${pageContext.request.contextPath}/notices">Show Current
			Notices</a> <br /> <a
			href="${pageContext.request.contextPath }/createnotice">Create
			New Notices</a>
	</p> --->

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
	<sec:authorize access="hasRole('admin')">
		<p>
			<a href="<c:url value='/admin' />">Admin Page</a>
		</p>
	</sec:authorize>
</div>