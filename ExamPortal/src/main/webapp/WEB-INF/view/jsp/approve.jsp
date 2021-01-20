<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
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
<style type="text/css">
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
</style>
<script type="text/javascript">
	 /*   function approval(){
		var enable=[[${user.enabled}]];
		 var approved=[[${enableStatusApproved}]]; 
		 var enable=[[${enable11}]]; 
		if(enable=="1")
			{
			 document.getElementById("text").innerHTML = "Approved" ;
			}
		 else
			{
			 document.getElementById("text").innerHTML = "Not Approved"; 
			
			}
		}   */
</script>
</head>
<body>
	<!-- Navbar-->
	<div id="navbar">
		<header>
			<nav class="navbar navbar-expand-lg navbar-dark bg-blue">
				<a class="navbar-brand" href="/login">Examinia</a>
			</nav>
		</header>
	</div>
	<br>
	<div align="center">
		<div class="col-lg-7">
			<div class="card2 card border-1 shadow-lg px-4 py-5 ">
				<h1>Check Approval</h1>
				<br>
				<c:url var="addAction" value="/Approval"></c:url>
				<form:form action="${addAction}" method="post" modelAttribute="user">

					<div class="row px-3">
						<form:label path="user_Name" class="mb-1">
							<h4 class="mb-0 text-sm">User Name</h4>
						</form:label>
						<form:input type="text" name="user_Name" path="user_Name"></form:input>
					</div>
					<br>

					<br>
					<div class="row mb-3 px-3">
						<button type="submit" class="btn btn-blue text-center "
							onClick="approval();">Submit</button>
					</div>
				</form:form>
				<div class="row mb-4 px-3">
					<small class="font-weight-bold">Go for <a
						class="text-danger " href="/login">login Page</a></small>
				</div>

				<%-- <c:set var="val" value="${user.enabled}" />
				<c:choose>
					<c:when test="${val == '1'}">
						<h6 class="text-success">approved.</h6>
						<p>Note :- First you must do Forget Password with your User
							Name.</p>
							<p class="text-success">${enableStatusApproved}</p>
					</c:when>
				<c:otherwise>
						<h6 class="text-danger">Not approved.</h6> 
						<p class="text-danger">${enableStatusNotApproved}</p>
					</c:otherwise>
				</c:choose> --%>
				<div>
					<h5 class="text-success">${enableStatusApproved}</h5>
					<h5 class="text-success">${enableStatusApproved1}</h5>
					<h5 class="text-danger">${enableStatusNotApproved}</h5>
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
</html>