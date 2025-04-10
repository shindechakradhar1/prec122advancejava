<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Register</h1>
	<form action="studentregister" method="post">
		<lable>Student Roll No:</lable>
		<input type="text" name="rollNo" placeholder="Enter Student Roll No">
		</br>
		<lable>Student name</lable>
		<input type="text" name="name" placeholder="Enter Student Name.">
		</br>
		<lable>Student Age:</lable>
		<input type="text" name="age" placeholder="Enter Student Age.">
		</br>
		<button type="submit">Register</button>
	</form>
</body>
</html>