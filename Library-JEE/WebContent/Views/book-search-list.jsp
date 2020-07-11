<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<link
	href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<body>
	<div class="container">
		<table border="1" class="table table-striped table-bordered">

			<tr class="thead-dark">

				<th>Title</th>
				<th>Author</th>
				<th>Publisher</th>
				<th>ISBN-13</th>
				<th>Actions</th>

			</tr>

			<c:forEach items="${book}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.publisher}</td>
					<td>${book.isbn}</td>
					<td>
						<a href = "${pageContext.request.contextPath}/LibraryController?action=EDIT&id=${book.id}">Edit</a>
						|
						<a href = "${pageContext.request.contextPath}/LibraryController?action=DELETE&id=${book.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</table>

	</div>
</body>
</html>