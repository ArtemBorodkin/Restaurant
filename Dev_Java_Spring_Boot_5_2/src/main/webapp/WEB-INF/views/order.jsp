<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Order</title>
</head>
<body>
<div class="container">
		<div class="row">
			<div class = "col-12">
			<form:form action="/admin/order" method="POST">
				<div class="from-group row">
					<label class="col-2 col-form-label" for="meal">Meals:</label>
					<div class="col-10">
						<select class="form-control" id="meal" name="meal">
							<c:forEach var="meal" items="${meals}">
								<option value="${meal.name}" class="table">
								${meal.name}
								${meal.cuisine}
								price=${meal.price} 
								weight=${meal.weight} 
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="from-group row">
					<label class="col-2 col-form-label" for="place">Place:</label>
					<div class="col-10">
						<select class="form-control" id="place" name="place">
							<c:forEach var="place" items="${places}">
								<option value="${place}">table ${place.number} people ${place.countOfPeople}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Order</button>
							<a href="/admin/order/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
			</form:form>
				<table class ="table table-bordered">
					<tr>
						<th class="text-center">Meal</th>
						<th class="text-center">Place</th>
						<th class="text-center">Option</th>
					</tr>
					<c:forEach var="order" items="${orders}">
						<tr class="text-center">
							<td>${order.meal}</td>
							<td>${order.place}</td>
							<td>
								<a href="/admin/order/update/${order.id}"class="btn btn-outline-warning btn-sm">Update</a>
								<a href="/admin/order/delete/${order.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>