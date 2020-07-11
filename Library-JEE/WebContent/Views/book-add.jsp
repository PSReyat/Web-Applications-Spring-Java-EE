<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your book</title>
</head>

<link
	href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<body>
	<div class="container" align = "center">
	
		<form action = "${pageContext.request.contextPath}/LibraryController" method = "POST">
			Enter book title: <input type="text" name="title" value = "${book.title}"/><br /> 
			Enter author: <input type="text" name="author" value = "${book.author}"/><br /> 
			Enter publisher: <input type="text" name="publisher" value = "${book.publisher}"/><br />
			Enter ISBN-13: <input type = "text" name = "isbn" value = "${book.isbn}"/><br/>
			
			<input type = "hidden" value = "${book.id}" name = "id"/>
			
			<button class="btn btn-primary" type="submit">Save Book</button>
		</form>

	</div>
</body>
</html>