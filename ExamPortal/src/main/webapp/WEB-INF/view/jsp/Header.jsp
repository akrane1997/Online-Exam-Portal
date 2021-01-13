<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--Main Navigation-->
	<header>

		<nav class="navbar navbar-expand-lg navbar-dark badge-dark">
			<!-- 	<a class="navbar-brand" href="#"><img alt=""
				src="/ExamPortal/src/main/webapp/resources/images/8e360d02-2b22-46cb-92be-79ff301af21d_200x200.png"><strong>Navbar</strong></a> -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/">Home
							<span class="sr-only">(current)</span>
					</a></li>


					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<div>
							<li class="nav-item"><a class="nav-link" href="/Exam">Exam</a>
							</li>
						</div>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_USER')">
						<div>

							<li class="nav-item"><a class="nav-link" href="/showExams">Exams</a>
							</li>

						</div>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_USER')">
						<div>
							<li class="nav-item"><a class="nav-link" href="/result">Result</a>
							</li>
						</div>
					</sec:authorize>
					<li class="nav-item"><a class="nav-link" href="/userinfo">User
							Info</a></li>
					<sec:authorize access="hasRole('ROLE_USER')">
						<div>
							<li class="nav-item"><a class="nav-link"
								href="/showcontact">Contact</a></li>
						</div>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<div>
							<li class="nav-item"><a class="nav-link"
								href="/listfeedback">Feedbacks</a></li>
						</div>
					</sec:authorize>
				</ul>
				<ul class="navbar-nav nav-flex-icons">
					<li class="nav-item"><a class="nav-link"><i
							class="fab fa-facebook-f"></i></a></li>
					<li class="nav-item"><a class="nav-link"><i
							class="fab fa-twitter"></i></a></li>
					<li class="nav-item"><a class="nav-link"><i
							class="fab fa-instagram"></i></a></li>
				</ul>

			</div>

			<div>${pageContext.request.remoteUser}</div>
			&nbsp; &nbsp;

			<form:form action="/logout" method="post">
				<input type="submit" value="Logout"></input>
			</form:form>

		</nav>

	</header>
	<!--Main Navigation-->
</body>
</html>
