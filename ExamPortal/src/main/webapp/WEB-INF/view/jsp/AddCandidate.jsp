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
	<div class="container " align="center">
		<div class="bs-example">
			<br>
			<div class="card2 card border-1 shadow-lg px-4 py-4">
				<h2 class="heading">Add Candidate</h2>
				<br>
				<c:url var="addAction"
					value="/addCandidate/${Exam_Id}/saveCandidate"></c:url>

				<form:form action="${addAction}" method="post">
					<div class="form-group">
						<div>
							<select class="form-control" name="name" id="name">
								<option>select candidate</option>
								<c:forEach var="list" items="${userList}">

									<option>${list.user_Name}</option>
								</c:forEach>
							</select>


						</div>
					</div>

					<div class="form-group row">
						<div class="col-sm-10 offset-sm-1">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<br>

	<div class="container bs-example" align="center">
		<c:if test="${!empty list}">
			<h2 class="heading">Exam_User List</h2>
			<br>
			<table class="table table-bordered-1 table-hover">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">UserId</th>
						<th scope="col">ExamId</th>


						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}">
						<tr>
							<td>${list.id}</td>
							<td>${list.user.user_Id}</td>
							<td>${list.exam.exam_Id}</td>


							<%-- <td><a
										href="<c:url value='/candidate/${Exam_Id}/editCandidate/${exam.exam_Id}' />"><button>Edit</button></a>--%>

							<td><a
								href="<c:url value='/addCandidate/${Exam_Id}/delete/${list.id}' />"><button
										class="btn btn-danger btn-shadow">Delete</button></a></td>
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