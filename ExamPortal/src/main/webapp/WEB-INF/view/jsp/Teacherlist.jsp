<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<Script type="text/javascript">
function disableButton(btn){
	document.getElementById(btn.id).disabled = true;
	alert("Button has been disabled.");
}
 </Script>
</head>
<body>
	<div>
		<jsp:include page="Header.jsp" />
	</div>
	<br>
	<div class="container bs-example" align="center">
		<br>

		<h2 class="heading">Teacher List</h2>

		<table class="table table-bordered-1 table-hover">
			<thead>
				<tr>
					<th scope="col">UserId</th>
					<th scope="col">Username</th>
					<th scope="col">Institute</th>

					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.user_Id}</td>
						<td>${list.user_Name}</td>
						<td>${list.institute}</td>
						<td hidden="true">${list.enabled}</td>
						<td><c:set var="val" value="${userEnable}" /> <c:choose>
								<c:when test="${list.enabled == '1'}">
									<h6 class="text-success">Approved</h6>
								</c:when>
								<c:otherwise>
									<a href="<c:url value='/enableuser/${list.user_Id}' />"><button
											class="btn btn-warning btn-shadow " id="myButton">Approve</button></a>

								</c:otherwise>
							</c:choose> <%-- 	<a href="<c:url value='/enableuser/${list.user_Id}' />"><button onclick=" this.disabled = true;"
									class="btn btn-warning btn-shadow jsclick" id="myButton" value="${text}">${text}</button></a> --%>
							<a href="<c:url value='/deleteuser/${list.user_Id}' />"><button
									class="btn btn-danger btn-shadow">Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
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