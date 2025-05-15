<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
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
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">All Users</a></li>
				</ul>
			</div>
		</div>
		<div class="row gy-3">
			<div class="col-12">
				<table class="table table-striped table-bordered mt-5">
					<thead>
						<tr>
							<td class="text-center text-capitalize font-weight-bold">Name</td>
							<td class="text-center text-capitalize font-weight-bold">Age</td>
							<td class="text-center text-capitalize font-weight-bold">Gender</td>
							<td class="text-center text-capitalize font-weight-bold">Area</td>
							<td class="text-center text-capitalize font-weight-bold">PinCode</td>
							<td class="text-center text-capitalize font-weight-bold text-warning">Update</td>
							<td class="text-center text-capitalize font-weight-bold text-danger">Delete</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center">User 1</td>
							<td class="text-center">21</td>
							<td class="text-center">Male</td>
							<td class="text-center">Loni</td>
							<td class="text-center">410001</td>
							<td class="text-center">
								<a href="#">
									<button type="button" class="btn btn-warning">Update</button>
								</a>
							</td>
							<td class="text-center">
								<a href="#">
									<button type="button" class="btn btn-danger">Delete</button>
								</a>
							</td>
						</tr>
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