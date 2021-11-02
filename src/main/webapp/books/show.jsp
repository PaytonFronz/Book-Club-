<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show book</title>
 <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-secondary text-white">
		<div class="form-group p-2">
        <h1>Book Title: <c:out value="${book.title}"/></h1>
            <h3><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/>, the author is <c:out value="${book.author}"/></h3>            
        <div class="form-group">
            <h4>Here are <c:out value="${book.user.userName}"/>'s thoughts:</h4>
            <h5><c:out value="${book.thoughts}"/></h5>
        </div>
        </div>
         <a href="/dashboard"><button class="btn btn-warning justify-content-end m-2" >Back To My Shelf!</button></a>
</body>
</html>