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
<p>
	Exam wll be end in <span id="countdowntimer">10</span> Seconds
</p>

<script type="text/javascript">
		
		var countdown = "60"
			
			function doCount() {
			 document.getElementById("countdowntimer").textContent = countdown;
			    if (countdown > 0) {
			
			        countdown--
			
			    }
			    else{
			setTimeout('document.form1.submit.click()')
			    }
			 window.status=countdown + " seconds left to complete the questionnaire."
			
			setTimeout('doCount()',1000) 
			
			}
			
			doCount()

</script>
</head>
<body>
	<h1 id="remain"></h1>
	<c:url var="addAction" value="/showExams/${Exam_Id}/submitAnswer"></c:url>
	<form:form action="${addAction}" id="form1" name="form1" method="post">
		<fieldset class="form-group container">
			<c:forEach var="question" items="${listOfQuestion}">
				<div class="col-sm-10">
					<input type="hidden" readonly class="form-control-plaintext"
						id="question_Id" name="question_Id"
						value="${question.question_Id}">
				</div>
				<div class="row">
					<div class="col-sm-10">
						<input type="text" readonly class="form-control-plaintext"
							id="staticEmail" value="${question.question}">
					</div>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio"
						name="option_${question.question_Id}" id="gridRadios1"
						value="option1"> <label class="form-check-label"
						for="gridRadios1">${question.option1} </label>
				</div>

				<div class="form-check">
					<input class="form-check-input" type="radio"
						name="option_${question.question_Id}" id="gridRadios2"
						value="option2"> <label class="form-check-label"
						for="gridRadios2">${question.option2} </label>
				</div>

				<div class="form-check">
					<input class="form-check-input" type="radio"
						name="option_${question.question_Id}" id="gridRadios2"
						value="option3"> <label class="form-check-label"
						for="gridRadios2">${question.option3} </label>
				</div>

				<div class="form-check">
					<input class="form-check-input" type="radio"
						name="option_${question.question_Id}" id="gridRadios2"
						value="option4"> <label class="form-check-label"
						for="gridRadios2">${question.option4} </label>
				</div>


				<br>
			</c:forEach>
			<div class="form-group row">
				<div class="col-sm-10 offset-sm-2">
					<input type="submit" name="submit" id="submit" value="submit"
						class="btnbtn-primary">
				</div>
			</div>
		</fieldset>

	</form:form>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>