<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.prec.entities.User" %>
<%@ page import="com.prec.entities.Hobby" %>
<%@ page import="com.prec.entities.Movie" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
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
					<li class="nav-item"><a class="nav-link" href="/springmvcuserdata/users">Users</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Update Users</a></li>
				</ul>
			</div>
		</div>
		<form:form action="/springmvcuserdata/users/update" method="POST" modelAttribute="user">
			<div class="row gy-3 mt-5">
				<div class="col-2"></div>
				<div class="col-2">
					<span class="input-group-text" id="addon-wrapping">User Name:</span>
				</div>
				<div class="col-6">
					<div class="input-group flex-nowrap">
						<form:hidden path="id"/>
						<form:input path="name" type="text" class="form-control"
							placeholder="Enter User Name.." aria-label="Username"
							aria-describedby="addon-wrapping" />
					</div>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row gy-3 mt-5">
				<div class="col-2"></div>
				<div class="col-2">
					<span class="input-group-text" id="addon-wrapping">User Age:</span>
				</div>
				<div class="col-6">
					<div class="input-group flex-nowrap">
						<form:input path="age" type="text" class="form-control"
							placeholder="Enter User Age" aria-label="Username"
							aria-describedby="addon-wrapping" />
					</div>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row gy-3 mt-5">
				<div class="col-2"></div>
				<div class="col-2">
					<span class="input-group-text" id="addon-wrapping">Gender:</span>
				</div>
				<div class="col-6">
					<div class="form-check form-check-inline">
						<form:radiobutton class="form-check-input" path="gender" id="inlineRadio1" value="male" />
						<label class="form-check-label" for="inlineRadio1">Male</label>
					</div>
					<div class="form-check form-check-inline">
						<form:radiobutton class="form-check-input" path="gender" id="inlineRadio2" value="female" />
						<label class="form-check-label" for="inlineRadio2">Female</label>
					</div>
					<div class="form-check form-check-inline">
						<form:radiobutton class="form-check-input" path="gender" id="inlineRadio2" value="Others" />
						<label class="form-check-label" for="inlineRadio2">Others</label>
					</div>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row gy-3 mt-5">
				<div class="col-2"></div>
				<div class="col-2">
					<span class="input-group-text" id="addon-wrapping">Area:</span>
				</div>
				<div class="col-6">
					<div class="input-group flex-nowrap">
						<form:input path="address.area" type="text" class="form-control"
							placeholder="Enter Area.." aria-label="Username"
							aria-describedby="addon-wrapping" />
					</div>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row gy-3 mt-5">
				<div class="col-2"></div>
				<div class="col-2">
					<span class="input-group-text" id="addon-wrapping">PinCode:</span>
				</div>
				<div class="col-6">
					<div class="input-group flex-nowrap">
						<form:input path="address.pincode" type="text" class="form-control"
							placeholder="Enter Pincode.." aria-label="Username"
							aria-describedby="addon-wrapping" />
					</div>
				</div>
				<div class="col-2"></div>
			</div>
			<!-- Hobbies -->
			<div class="row gy-3 mt-5">
				<div class="col-2"></div>
				<div class="col-2">
					<span class="input-group-text" id="addon-wrapping">Hobbies: </span>
				</div>
				<div class="col-6">
				<%
					User user=(User)request.getAttribute("user");
					List<Hobby> hobbies=(List<Hobby>)request.getAttribute("hobbiesList");
					for(Hobby hobby:hobbies){
						if(user.getHobbiesSet().contains(hobby)){
				%>
					<div class="form-check form-switch form-check-inline">
						<form:checkbox path="hobbiesSet" value="<%= hobby.getId() %>" class="form-check-input" role="switch" id="flexSwitchCheckDefault" checked="true" /> 
						<label class="form-check-label" for="flexSwitchCheckDefault"><%=hobby.getHobbyName() %></label>
					</div>
				<%
						}else{
				%>	
					<div class="form-check form-switch form-check-inline">
						<form:checkbox path="hobbiesSet" value="<%= hobby.getId() %>" class="form-check-input" role="switch" id="flexSwitchCheckDefault" /> 
						<label class="form-check-label" for="flexSwitchCheckDefault"><%=hobby.getHobbyName() %></label>
					</div>
				<%
						}
					}
				%>
				</div>
				<div class="col-2"></div>
			</div>
			<!-- Movies -->
			<div class="row gy-3 mt-5">
				<div class="col-2"></div>
				<div class="col-2">
					<span class="input-group-text" id="addon-wrapping">Movies: </span>
				</div>
				<div class="col-6">
					<%
					List<Movie> movies=(List<Movie>)request.getAttribute("movieList");
						for(Movie movie:movies){
							if(user.getMovieList().contains(movie)){
					%>
					<div class="form-check form-switch form-check-inline">
						<form:checkbox path="movieList" value="<%=movie.getId() %>" class="form-check-input" role="switch" id="flexSwitchCheckDefault" checked="true" /> 
						<label class="form-check-label" for="flexSwitchCheckDefault"><%=movie.getMovieName() %></label>
					</div>
					<%
							}else{
					%>
					<div class="form-check form-switch form-check-inline">
						<form:checkbox path="movieList" value="<%=movie.getId() %>" class="form-check-input" role="switch" id="flexSwitchCheckDefault" /> 
						<label class="form-check-label" for="flexSwitchCheckDefault"><%=movie.getMovieName() %></label>
					</div>
					<%
							}
						} 
					%>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row mt-5">
				<div class="col-4"></div>
				<div class="col-4 text-center">
					<button type="submit" class="btn btn-success">Update User</button>
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