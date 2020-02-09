<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.6">

<link rel="stylesheet"
	href="<c:url value='/static/css/notice-main.css'/>">
<link rel="stylesheet"
	href="<c:url value='/static/lib/bootstrap/css/bootstrap.min.css'/>">

<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>

	<div>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>

	<main role="main" class="container">

		<div class="starter-template">

			<tiles:insertAttribute name="content"></tiles:insertAttribute>

		</div>

	</main>
	<!-- /.container -->

	<div>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>