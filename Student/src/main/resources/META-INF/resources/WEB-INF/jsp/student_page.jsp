<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${student.first_name}'s profile</title>
</head>
<body>
	
	<table border = "1" class = "table table-striped table-bordered">
	
		<tr bgcolor = "yellow">
			
			<th>First Name</th>
			<th>Last name</th>
			<th>Degree</th>
		
		</tr>
		
		<tr>
		
			<td>${student.first_name}</td>
			<td>${student.last_name}</td>
			<td>${student.degree}</td>
		
		</tr>
		
	</table>
	
</body>
</html>