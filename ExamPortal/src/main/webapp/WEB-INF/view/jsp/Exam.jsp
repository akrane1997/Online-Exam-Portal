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
			<div>
				<div class="card2 card border-1 shadow-lg px-4 py-4">
				<c:if test="${empty exam.exam_Name}">
					<h2 class="heading">Add Exam</h2>
					</c:if>
					<c:if test="${!empty exam.exam_Name}">
					<h2 class="heading">Update Exam</h2>
					</c:if>
					<br>
					<c:url var="addAction" value="/saveExam"></c:url>
					<form:form action="${addAction}" method="post"
						modelAttribute="exam">
						<c:if test="${!empty exam.exam_Name}">
							<div class="form-group row">
								<form:label path="Exam_Id" readonly="ture" name="Exam_Id"
									class="col-sm-2 col-form-label">Exam Id:</form:label>
								<div class="col-sm-10">
									<form:input class="form-control" name="Exam_Id" path="Exam_Id"
										readonly="true"></form:input>
								</div>
							</div>
						</c:if>

						<div class="form-group row">
							<form:label path="Exam_Name" class="col-sm-2 col-form-label">Exam Name:</form:label>
							<div class="col-sm-10">
								<form:textarea class="form-control" path="Exam_Name"
									placeholder="Type Exam Title here" required="true" rows="3"></form:textarea>
							</div>
						</div>
						<div class="form-group row">
							<form:label path="setTime" name="setTime"
								class="col-sm-2 col-form-label">Exam Duration(mins):</form:label>
							<div class="col-sm-10">
								<form:input class="form-control" path="setTime" name="setTime"
									placeholder="Enter Exam Duration in minutes" required="true"
									rows="3"></form:input>
							</div>
						</div>

						<c:if test="${!empty exam.exam_Name}">
							<div class="form-group row">
								<div class="col-sm-10 offset-sm-2">
									<button type="submit" class="btn btn-primary">update
										Exam</button>
								</div>
							</div>
						</c:if>
						<c:if test="${empty exam.exam_Name}">
							<div class="form-group row">
								<div class="col-sm-10 offset-sm-1">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</div>
						</c:if>
					</form:form>
				</div>

			</div>

			<div class="container bs-example" align="center">
				<br>
				<c:if test="${!empty list}">
					<h2 class="heading">Exam List</h2>
					<table class="table table-bordered-1 table-hover">
						<thead>
							<tr>
								<th scope="col">Date</th>
								<th scope="col">Exam Id</th>
								<th scope="col">Exam Name</th>
								<th scope="col">Exam Duration (sec)</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="exam" items="${list}">
								<tr>
									<td>${exam.startDate}</td>
									<td>${exam.exam_Id}</td>
									<td>${exam.exam_Name}</td>
									<td>${exam.setTime}</td>
									<td><a href="<c:url value='/editExam/${exam.exam_Id}' />"><button class="btn btn-warning btn-shadow">Edit</button></a>
										<a href="<c:url value='/deleteExam/${exam.exam_Id}' />"><button class="btn btn-danger btn-shadow">Delete</button></a>
										<a href="<c:url value='/question/${exam.exam_Id}' />"><button class="btn btn-danger btn-shadow">Add Questions</button></a>
										<a href="<c:url value='/addCandidate/${exam.exam_Id}' />"><button class="btn btn-info btn-shadow">Add Candidates</button></a>
										<a href="<c:url value='/showresult/${exam.exam_Id}' />"><button class="btn btn-success btn-shadow">Result</button></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
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