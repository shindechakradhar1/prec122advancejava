<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hobbies</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link" href="/springmvcuserdata/hobbies">Hobbies</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Update Hobbies</a></li>
				</ul>
			</div>
		</div>
		<form:form action="/springmvcuserdata/hobbies/update" method="POST" modelAttribute="hobby">
			<div class="row gy-3 mt-5">
				<div class="col-2"></div>
				<div class="col-2">
					<span class="input-group-text" id="addon-wrapping">Hobby Name</span>
				</div>
				<div class="col-6">
					<div class="input-group flex-nowrap">
						<form:hidden path="id" />
						<form:input path="hobbyName" type="text" class="form-control"
							placeholder="Enter Hobbies" aria-label="Username"
							aria-describedby="addon-wrapping" />
					</div>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row mt-5">
				<div class="col-4"></div>
				<div class="col-4 text-center">
					<button type="submit" class="btn btn-success">Update Hobbies</button>
				</div>
				<div class="col-4"></div>
			</div>
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>