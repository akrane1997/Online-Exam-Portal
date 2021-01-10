<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<title>show candidate Score</title>

</head>
<body>
<jsp:include page="Header.jsp" />
	<div class="container " align="center">
		<div class="bs-example">
		<br>
			<h1>Score List</h1>
			<br><br>
			<div class="container bs-example" align="center">
				
				<table class="table table-bordered-2 table-hover">
					<thead>
						<tr>
							<th scope="col">Create Exam Date</th>
							<th scope="col">Given Exam Date</th>
							<th scope="col">User Id</th>
							<th scope="col">User Name</th>
							<th scope="col">Exam Id</th>
							<th scope="col">Exam Name</th>
							<th scope="col">Score</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${listOfscore}">
							<tr>
								<td>${list.exam.startDate}</td>
								<td>${list.examdate}</td>
								<td>${list.user.user_Id}</td>
								<td>${list.user.user_Name}</td>
								<td>${list.exam.exam_Id}</td>
								<td>${list.exam.exam_Name}</td>
								<td>${list.score}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
				integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
				crossorigin="anonymous"></script>
		</div>
	</div>

</body>
</html>

</body>
</html>