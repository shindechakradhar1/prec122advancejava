<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %> 
<%@ page import="java.util.TreeSet" %> 
<%@ page import="in.prec.servletcrudoperation.controllers.entities.Student" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h3 >Student List</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Roll No</td>
					<td>Name</td>
					<td>Age</td>
					<td>Area</td>
					<td>City</td>
					<td>Update</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
			<% 
				Set<Student> sortedSet= (Set<Student>)request.getAttribute("studentList"); 
				for(Student student:sortedSet){
			%>
				<tr>
					<td><%= student.getRollNo() %></td>
					<td><%= student.getName() %></td>
					<td><%= student.getAge() %></td>
					<td><%= student.getAddress().getArea() %></td>
					<td><%= student.getAddress().getCity() %></td>
					<td><a href="update?id=<%=student.getId() %>">update</a></td>
					<td><a href="delete?id=<%=student.getId() %>">delete</a></td>
				</tr>
			<%
				} 
			%>
			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>