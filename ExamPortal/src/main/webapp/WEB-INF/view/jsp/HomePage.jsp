<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div>
		<jsp:include page="Header.jsp" />
	</div>
	<br>
	<%-- <form:form class="form-inline mx-3 my-lg-2 float-right" method="get" action="/ExamList" modelAttribute="exam">
		<form:input class="form-control mr-sm-2" type="search" placeholder="Search exam" path="Exam_Name"
			aria-label="Search"/>
		<button class="btn btn-primary" type="submit">Search </button>
	</form:form> --%>
	<br>
	<h1 class="text-center text-primary">Welcome
		${pageContext.request.remoteUser}</h1>
	<br>
	<br>
	<sec:authorize access="hasRole('ROLE_USER')">
		<div align="center">
			<p>Candidate Portal</p>
			<div class="col-lg-7">
				<div class="card2 card border-1 px-4 py-5 ">
					<h1 class="text-danger">Instructions :-</h1>
					<br>
					<div class="row px-3">
						<ul>
							<li><h5 class="text-left">Candidate can find their
									exams in exams tab in navigation bar.</h5></li>
							<li><h5 class="text-left">All Exams have specific time
									for completing exam.</h5></li>
							<li><h5 class="text-left">candidate should be complete
									their exams in given time.</h5></li>
							<li><h5 class="text-left">During exam candidate cannot
									go outside of exam.</h5></li>
							<li><h5 class="text-left">If candidate go out side of
									exam candidate will get warning after that exam will submit
									automatically.</h5></li>
							<li><h5 class="text-left">Candidate can find their
									results in result tab in navigation bar.</h5></li>
							<li><h5 class="text-left">Candidate can give feedback.</h5></li>
						</ul>
					</div>


				</div>
			</div>

		</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div align="center">
			<p>Teacher Portal</p>
			<div class="col-lg-7">
				<div class="card2 card border-1 px-4 py-5 ">
					<h1 class="text-danger">Instructions :-</h1>
					<br>
					<div class="row px-3">
						<ul>
							<li><h5 class="text-left">Teacher can create their
									exams in exam tab in navigation bar.</h5></li>
						</ul>
					</div>


				</div>
			</div>

		</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_SUPER_ADMIN')">
		<div align="center">
			<p>Institute Portal</p>
			<div class="col-lg-7">
				<div >
					<h1 class="text-uppercase text-success"><b>${institutename}</b></h1>

				</div>
			</div>

		</div>
	</sec:authorize>
	<br>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>