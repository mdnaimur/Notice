<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<title>Admin page</title>
</head>
<body>
	<h2>Only Admin can access this page</h2>
	
	<div class="container" class="col-md-6 offset-md-3">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Username</th>
					<th scope="col">Email</th>
					<th scope="col">Authorities</th>
					<th scope="col">Enabled</th>
				</tr>
			</thead>
			<c:forEach var="user" items="${users}">
				<tbody>
					<tr>
						<td><c:out value="${user.username}"></c:out></td>
						<td><c:out value="${user.email}"></c:out></td>
						<td><c:out value="${user.authority}"></c:out></td>
						<td><c:out value="${user.enabled}"></c:out></td>
					</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>