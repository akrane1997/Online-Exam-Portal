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
<title>Add Question</title>
</head>
<body>
	<jsp:include page="Header.jsp" />


	<div class="container bs-example" align="center">
		<c:if test="${!empty flist}">
			<h2 class="heading">Feedback List</h2>
			<br>
			<table class="table table-bordered-1 table-hover">
				<thead>
					<tr>
						
						<th scope="col">User_name</th>
						<th scope="col">Subject</th>
						<th scope="col">Mobile_number</th>
						<th scope="col">Message</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${flist}">
						<tr>
							
							<td>${list.name}</td>
							<td>${list.subject}</td>
							<td>${list.mobilenumber}</td>
							<td>${list.message}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	<%-- 			<br> <a href="/Examuser/${Exam_Id}"><button>show List</button>e </a> <br />  --%>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>


</body>
</html>