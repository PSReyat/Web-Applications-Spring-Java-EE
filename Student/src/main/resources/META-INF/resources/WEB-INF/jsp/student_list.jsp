<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Students</title>
</head>
<body>

	<div class = "container">

		<table border="1" class="table table-striped table-bordered">
		
			<tr bgcolor = "green">
				
				<th>First Name</th>
				<th>Last name</th>
				<th>Degree</th>
			
			</tr>
		
			<c:forEach items="${student}" var="students">

				<tr>
					<td>${students.first_name}</td>
					<td>${students.last_name}</td>
					<td>${students.degree}</td>
				</tr>

			</c:forEach>

		</table>

	</div>

</body>
</html>