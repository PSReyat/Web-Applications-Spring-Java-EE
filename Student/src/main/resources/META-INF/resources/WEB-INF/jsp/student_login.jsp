<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Login</title>
</head>

<body>

	<div class="container" align = "center">

		<h1>Student login</h1>

		<form action="studentlogin" method="Get">

			<input type="text" name="username" placeholder="Username" /> <br />
			<input type="password" name="password" placeholder="Password" /> <br />
			<button class="btn btn-primary" type="submit">Login</button>

		</form>
		
		<c:if test = "${loginError}">
			<p class = "Error"><font color = "#FF0000">Wrong username or password</font></p>
		</c:if>
		
		<form action = "admin" method = "Post">
			<button class = "btn btn-primary" type = "submit">Admin Login</button>
		</form>
			
		

	</div>

</body>
</html>