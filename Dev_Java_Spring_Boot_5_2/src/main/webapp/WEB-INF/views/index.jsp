<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Restaurant</title>
</head>
<body>
<div class="container">
	<div class="row">
	<div class="col-12">
	<h2>${message}</h2>
	</div>
	</div>
	<div class="row">
	<div class="col-12">
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="/admin">Admin</a>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<a href="/registration" class="btn btn-sm btn-outline-success">Registration</a>
		<a href="/login" class="btn btn-sm btn-outline-warning">Login</a>
	</sec:authorize>
	</div>
	</div>
	<sec:authorize access="isAuthenticated()">
		<form:form action="/logout">
			<button class="btn btn-sm btn-outline-primary">Logout</button>
		</form:form>
	</sec:authorize>

	</div>
</body>
</html>