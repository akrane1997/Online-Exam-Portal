<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	

body {
	overflow-x: hidden;
	height: 100%;
	/* background-color: #B0BEC5; */
	background-repeat: no-repeat
}

.card0 {
	/* box-shadow: 0px 4px 8px 0px #757575; */
	border-radius: 0px
}

.card2 {
	margin: 70px 70px
}

.logo {
	width: 200px;
	height: 100px;
	margin-top: 20px;
	margin-left: 35px
}

.image {
	width: 360px;
	height: 280px
}

.border-line {
	border-right: 1px solid #EEEEEE
}

/* .facebook {
	background-color: #3b5998;
	color: #fff;
	font-size: 18px;
	padding-top: 5px;
	border-radius: 50%;
	width: 35px;
	height: 35px;
	cursor: pointer
}
 */
/* .twitter {
	background-color: #1DA1F2;
	color: #fff;
	font-size: 18px;
	padding-top: 5px;
	border-radius: 50%;
	width: 35px;
	height: 35px;
	cursor: pointer
}

.linkedin {
	background-color: #2867B2;
	color: #fff;
	font-size: 18px;
	padding-top: 5px;
	border-radius: 50%;
	width: 35px;
	height: 35px;
	cursor: pointer
}

.line {
	height: 1px;
	width: 45%;
	background-color: #E0E0E0;
	margin-top: 10px
}

.or {
	width: 10%;
	font-weight: bold
} */
.text-sm {
	font-size: 14px !important
}

::placeholder {
	color: #BDBDBD;
	opacity: 1;
	font-weight: 300
}

:-ms-input-placeholder {
	color: #BDBDBD;
	font-weight: 300
}

::-ms-input-placeholder {
	color: #BDBDBD;
	font-weight: 300
}

input, textarea {
	padding: 10px 12px 10px 12px;
	border: 1px solid lightgrey;
	border-radius: 2px;
	margin-bottom: 5px;
	margin-top: 2px;
	width: 100%;
	box-sizing: border-box;
	color: #2C3E50;
	font-size: 14px;
	letter-spacing: 1px
}

input:focus, textarea:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	border: 1px solid #304FFE;
	outline-width: 0
}

button:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	outline-width: 0
}

a {
	color: inherit;
	cursor: pointer
}

.btn-blue {
	background-color: #1A237E;
	width: 150px;
	color: #fff;
	border-radius: 2px
}

.btn-blue:hover {
	background-color: #000;
	cursor: pointer
}

.bg-blue {
	color: #fff;
	background-color: #1A237E
}

@media screen and (max-width: 991px) {
	.logo {
		margin-left: 0px
	}
	.image {
		width: 300px;
		height: 220px
	}
	.border-line {
		border-right: none
	}
	.card2 {
		border-top: 1px solid #EEEEEE !important;
		margin: 0px 15px
	}
}
</style> -->
</head>
<body>
	<div class="card card0 border-0">
		<div class="row d-flex">
			<div class="col-lg-6">
				<div class="card1 pb-5">
					<!-- <div class="row">
							<img
								src="/images/8e360d02-2b22-46cb-92be-79ff301af21d_200x200.png"
								class="logo">
						</div> -->
				</div>
			</div>
			<div class="col-lg-6">
				<div class="card2 card border-0 px-4 py-5">
					<form method="POST" th:action="@{/login}" class="form-signin">
						<div class="row px-3">
							<label class="mb-1">
								<h6 class="mb-0 text-sm">User Name</h6>
							</label> <input class="mb-4" type="text" name="username"
								placeholder="Enter a valid user name" autofocus />
						</div>
						<div class="row px-3">
							<label class="mb-1">
								<h6 class="mb-0 text-sm">Password</h6>
							</label> <input type="password" name="password"
								placeholder="Enter password">
						</div>

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

						<div class="row px-3 mb-4">
							<div class="custom-control custom-checkbox custom-control-inline">
								<input id="chk1" type="checkbox" name="chk"
									class="custom-control-input"> <label for="chk1"
									class="custom-control-label text-sm">Remember me</label>
							</div>
						</div>
						<div class="row mb-3 px-3">
							<button type="submit" class="btn btn-blue text-center">Login</button>
						</div>
					</form>
					<div class="row mb-4 px-3">
						<small class="font-weight-bold">Don't have an account? <a
							class="text-danger " href="/registration">Register</a></small>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html> --%>