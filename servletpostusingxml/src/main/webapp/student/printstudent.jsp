<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Student Data</h2>
	<%!
		int instanceVar=100;
		int show(){
			return instanceVar;
		}
	%>
	<%
		//int rollNo=(Integer)request.getAttribute("rollNo");
		//String name=(String)request.getAttribute("name");
		//int age=(Integer)request.getAttribute("age");
	%>
	<table border=1>
	<thead>
		<tr>
			<td>Roll No</td>
			<td>Name</td>
			<td>age</td>
		</tr>
	</thead>
	<tbody>
	<tr>

		<td>${ rollNo } </td>
		<td>${ name }</td>
		<td>${ age }</td>
		
		
		
		
	</tr>
	</tbody>
	</table>
	<%= show() %>
</body>
</html>