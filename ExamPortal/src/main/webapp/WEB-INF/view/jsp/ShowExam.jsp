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

<script type="text/javascript">


/* function openFullscreen() {
	var fullScreenElement = document.querySelector('body');
	console.log(fullScreenElement);
	fullScreenElement.requestFullscreen();
	doCount();
} 
 */

var countdown = [[${timmer}]];
	function doCount() {
		document.getElementById("countdowntimer").textContent = countdown;
		if (countdown > 0) {

			countdown--;

		} else {
			setTimeout('document.form1.submit.click()');
		}
		window.status = countdown
				+ " seconds left to complete the questionnaire."
		setTimeout('doCount()', 1000);
	}
	
	window.history.forward();
    function noBack()
    {
        window.history.forward();
    }

		 var i=0;

		function pause() {
			  document.body.classList.add('paused');
			 
			function increase()
			{
				i++;
			window.alert("Warnning!!!"+ " "+(i)+" \n don't click out side of your exam , \n if you click out side of your exam you will get 2 warnings  \n after that your exam will submit automatically."); 
			if (i>2) {
				document.form1.submit.click();			
					} 
			}	
			increase();
			}

			function play() {
			  document.body.classList.remove('paused');
			  
			}

			const log = document.getElementById('bodyContain');

			window.addEventListener('blur', pause);
			window.addEventListener('focus', play);
			
	
</script>

</head>
<body onload="doCount()">

	<div class="container" id="bodyContain">
		<p>
			Exam wll be end in <span id="countdowntimer"></span> Seconds
		</p>
		<div class="card shadow-lg p-3 mb-5 bg-white rounded">
			<div class="card-body">
				<div class="col align-self-center">
					<c:url var="addAction" value="/showExams/${Exam_Id}/submitAnswer"></c:url>
					<form:form action="${addAction}" id="form1" name="form1"
						method="post">

						<fieldset class="form-group container">
							<table class="table table-borderless">
								<c:forEach var="question" items="${listOfQuestion}">
									<div class="col-sm-10">
										<input type="hidden" readonly class="form-control-plaintext"
											id="question_Id" name="question_Id"
											value="${question.question_Id}">
									</div>
									<thead>
										<tr>
											<th scope="col">
												<div class="row">
													<div class="col-sm-10">
														<input type="text" readonly class="form-control-plaintext"
															id="question" value="Q. ${question.question}">
													</div>
												</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<div class="form-check">
													<input class="form-check-input" type="radio"
														name="option_${question.question_Id}" id="gridRadios1"
														value="option1"> <label class="form-check-label"
														for="gridRadios1">${question.option1} </label>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="form-check">
													<input class="form-check-input" type="radio"
														name="option_${question.question_Id}" id="gridRadios1"
														value="option1"> <label class="form-check-label"
														for="gridRadios1">${question.option2} </label>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="form-check">
													<input class="form-check-input" type="radio"
														name="option_${question.question_Id}" id="gridRadios1"
														value="option1"> <label class="form-check-label"
														for="gridRadios1">${question.option3} </label>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="form-check">
													<input class="form-check-input" type="radio"
														name="option_${question.question_Id}" id="gridRadios1"
														value="option1"> <label class="form-check-label"
														for="gridRadios1">${question.option4} </label>
												</div>
											</td>
										</tr>
									</tbody>

								</c:forEach>
							</table>
							<div class="form-group row">
								<div class="col-sm-10 offset-sm-5">
									<input type="submit" name="submit" id="submit" value="submit"
										class="btn btn-primary btn-lg">
								</div>
							</div>
						</fieldset>

					</form:form>
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