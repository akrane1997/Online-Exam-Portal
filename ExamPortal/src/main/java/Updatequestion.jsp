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
<title>Insert title here</title>
</head>
<body>
<div class="bs-example">
			<h2 class="heading">Add Question</h2>
			<c:url var="addAction" value="/questionUpdate"></c:url>
			
			<form:form action="${addAction}" method="post"
				modelAttribute="questions">
					<div class="form-group row">
						<form:label path="question_Id" name="question_Id" class="col-sm-2 col-form-label">Question
							Id</</form:label>
						<div class="col-sm-10">
							<form:input class="form-control" name="question_Id" path="question_Id"
								 required="true"></form:input>
						</div>
					</div>
				<div class="form-group row">
					<form:label path="question" class="col-sm-2 col-form-label">Question</form:label>
					<div class="col-sm-10">
						<form:textarea class="form-control" path="question"
							placeholder="Type Question here" required="true" rows="3"></form:textarea>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="option1" class="col-sm-2 col-form-label">Option
						1</form:label>
					<div class="col-sm-10">
						<form:input path="option1" class="form-control"
							placeholder="Type Option 1 here" required="true"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="option2" class="col-sm-2 col-form-label">Option
						2</form:label>
					<div class="col-sm-10">
						<form:input path="option2" class="form-control"
							placeholder="Type Option 2 here" required="true"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="option3" class="col-sm-2 col-form-label">Option3</form:label>
					<div class="col-sm-10">
						<form:input path="option3" class="form-control"
							placeholder="Type Option 3 here" required="ture"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="option4" class="col-sm-2 col-form-label">Option
						4</form:label>
					<div class="col-sm-10">
						<form:input path="option4" class="form-control"
							placeholder="Type Option 4 here" required="ture"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="answer" class="col-sm-2 col-form-label">Answer</form:label>
					<div class="col-sm-10">
						<form:input path="answer" class="form-control"
							placeholder="Type Answer here" required="true"></form:input>
					</div>
				</div>
			
					<div class="form-group row">
						<div class="col-sm-10 offset-sm-2">
							<button type="submit" class="btn btn-primary">update
								Question</button>
						</div>
					</div>
			
			</form:form>
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