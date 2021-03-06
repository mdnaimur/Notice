<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<title>Show all Value</title>
</head>
<body>
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
						<td><c:out value="${notice.name}"></c:out></td>
						<td><c:out value="${notice.email}"></c:out></td>
						<td><c:out value="${notice.text}"></c:out></td>
					</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>