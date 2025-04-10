<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

		<h3>Register Student</h3>

		<form action="register" method="POST">
			<div class="row g-3 align-items-center">
				<div class="col-auto">
					<label for="inputPassword6" class="col-form-label">Roll No:</label>
				</div>
				<div class="col-auto">
					<input type="text" id="inputPassword6" class="form-control"
						aria-describedby="passwordHelpInline" name="student_roll_no">
				</div>
				<div class="col-auto">
					<span id="passwordHelpInline" class="form-text"> Must be
						Positive Number </span>
				</div>
			</div>

			<div class="row g-3 align-items-center">
				<div class="col-auto">
					<label for="inputPassword6" class="col-form-label">Student
						Name:</label>
				</div>
				<div class="col-auto">
					<input type="text" id="inputPassword6" class="form-control"
						aria-describedby="passwordHelpInline" name="student_name">
				</div>
				<div class="col-auto">
					<span id="passwordHelpInline" class="form-text"> Name Must
						be Characters Only </span>
				</div>
			</div>

			<div class="row g-3 align-items-center">
				<div class="col-auto">
					<label for="inputPassword6" class="col-form-label">Student
						Age:</label>
				</div>
				<div class="col-auto">
					<input type="text" id="inputPassword6" class="form-control"
						aria-describedby="passwordHelpInline" name="student_age">
				</div>
				<div class="col-auto">
					<span id="passwordHelpInline" class="form-text"> Age Must be
						Greater than 18</span>
				</div>
			</div>

			<div class="row g-3 align-items-center">
				<div class="col-auto">
					<label for="inputPassword6" class="col-form-label">Address
						Area:</label>
				</div>
				<div class="col-auto">
					<input type="text" id="inputPassword6" class="form-control"
						aria-describedby="passwordHelpInline" name="address_area">
				</div>
				<div class="col-auto">
					<span id="passwordHelpInline" class="form-text"> should be
						Characters Only</span>
				</div>
			</div>


			<div class="row g-3 align-items-center">
				<div class="col-auto">
					<label for="inputPassword6" class="col-form-label">Address
						City:</label>
				</div>
				<div class="col-auto">
					<input type="text" id="inputPassword6" class="form-control"
						aria-describedby="passwordHelpInline" name="address_city">
				</div>
				<div class="col-auto">
					<span id="passwordHelpInline" class="form-text"> Must be
						Characters</span>
				</div>
			</div>

			<button type="submit">Register</button>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>