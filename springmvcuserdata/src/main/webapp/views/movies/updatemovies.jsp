<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Movies</title>
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

					<li class="nav-item"><a class="nav-link" href="/springmvcuserdata/movies">Movies</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Update Movies</a></li>
				</ul>
			</div>
		</div>
		<form:form action="/springmvcuserdata/movies/update" method="POST" modelAttribute="movie">
			<div class="row gy-3 mt-5">
				<div class="col-4">
					<span class="input-group-text" id="addon-wrapping">Movie Name: </span>
				</div>
				<div class="col-8">
					<div class="input-group flex-nowrap">
						<form:hidden path="id" />
						<form:input path="movieName" type="text" class="form-control"
							placeholder="Username" aria-label="Username"
							aria-describedby="addon-wrapping" />
					</div>
				</div>
			</div>
			<div class="row gy-3 mt-5">
				<div class="col-4">
					<span class="input-group-text" id="addon-wrapping">Release Date:</span>
				</div>
				<div class="col-8">
					<div class="input-group flex-nowrap">
						<form:input path="releaseDate" type="date" class="form-control"
							placeholder="Username" aria-label="Username"
							aria-describedby="addon-wrapping" />
					</div>
				</div>
			</div>
			
			<div class="row gy-3 mt-5">
				<div class="col-4">
					<span class="input-group-text" id="addon-wrapping">Actor Name: </span>
				</div>
				<div class="col-8">
					<div class="input-group flex-nowrap">
						<form:input path="actorName" type="text" class="form-control"
							placeholder="Username" aria-label="Username"
							aria-describedby="addon-wrapping" />
					</div>
				</div>
			</div>
			<div class="row mt-5">
				<div class="col-4"></div>
				<div class="col-4 text-center">
					<button type="submit" class="btn btn-warning">Update Movie</button>
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