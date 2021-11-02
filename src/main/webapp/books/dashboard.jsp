<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Dashboard</title>
 <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-secondary text-white">
	<h1 class="d-inline-flex text-warning">Welcome, <c:out value="${user.userName}"/>!</h1>
	<h3 class="text-dark">Books from everyone's shelves:</h3>
	
<table class="table table-dark table-striped table-hover table-bordered">
			<thead >
				<tr>
					<th class="align-middle" >Id</th>
					<th class="align-middle" scope="col">Title</th>
					<th class="align-middle" scope="col">Author</th>
					<th class="align-middle" scope="col">Posted By</th>
					<th class="align-middle" scope="col">Actions</th>
					
				</tr>
			</thead>	
				<tbody>
					<c:forEach  var="i" items="${book}" >
						<tr class="table-secondary ">
							<td class="text-dark"> <c:out value="${i.id}"></c:out> </td>
							<td class="text-dark"><a href="/books/${i.id}"><c:out value="${i.title}"></c:out></a></td>
							<td class="text-dark"> <c:out value="${i.author}"></c:out> </td>
							<td class="text-dark"> <c:out value="${i.user.userName}"></c:out> </td>		
							
							<td><form action="/books/${i.id}/edit" method="post">
							<input type="hidden" name="_method" value="edit">
							<input class="btn btn-light p-1" type="submit" value="Edit Book"></form>
							
							<form action="/books/${i.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete">
							<input class="btn btn-dark p-1" type="submit" value="Delete Book"></form></td>						
						</tr>
					</c:forEach>
				</tbody>
		</table>

	<a href="/new/book" class="d-flex justify-content-end d-inline-flex p-2"><button class="btn btn-warning">Add a book</button></a>
	<a href="/logout" class="d-flex justify-content-end d-inline-flex p-2"><button class="btn btn-light">Logout</button></a>
</body>
</html>