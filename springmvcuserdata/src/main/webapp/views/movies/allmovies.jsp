<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.prec.entities.Movie" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Movies</title>
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
					<li class="nav-item"><a class="nav-link active"	aria-current="page" href="#">All Movies</a></li>
				</ul>
			</div>
		</div>
		<div class="row gy-3">
			<div class="col-12">
				<table class="table table-striped table-bordered mt-5">
					<thead>
						<tr>
							<td class="text-center text-capitalize font-weight-bold">
								Movie
							</td>
							<td class="text-center text-capitalize font-weight-bold">
								Actor
							</td>
							<td class="text-center text-capitalize font-weight-bold">
								Release Date
							</td>
							<td class="text-center text-capitalize font-weight-bold text-warning">
								Update
							</td>
							<td class="text-center text-capitalize font-weight-bold text-danger">
								Delete
							</td>
						</tr>
					</thead>
					<tbody>	
					<% 
						List<Movie> movies=(List<Movie>)request.getAttribute("moviesList"); 
						for(Movie movie:movies){
					
					%>
						<tr>
							<td class="text-center">
								<%=movie.getMovieName() %>
							</td>
							<td class="text-center">
								<%=movie.getActorName() %>
							</td>
							<td class="text-center">
								<%=movie.getReleaseDate() %>
							</td>
							<td class="text-center">
								<a href="update/id/<%= movie.getId() %>">
									<button type="button" class="btn btn-warning text-center text-capitalize">Update</button>
								</a>
							</td>
							<td class="text-center">
								<a href="delete/id/<%= movie.getId() %>">
									<button type="button" class="btn btn-danger text-center text-capitalize">Delete</button>
								</a>
							</td>
						</tr>
						<%
							} 
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>