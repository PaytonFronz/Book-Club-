<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit entry</title>
 <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-secondary text-white">
<h1>Edit Entry:</h1>
<form:form action="/books/${book.id}/edit" method="post" modelAttribute="book">
    <input type="hidden" name="_method" value="put">
    <form:hidden path="user" value="${user_id}"/>
    <div class="form-group p-2">
            <label>Title:</label>
            <form:input path="title" class="form-control" />
            <form:errors path="title" class="text-warning" />
        </div>
        <div class="form-group p-2">
            <label>Author:</label>
            <form:input path="author" class="form-control" />
            <form:errors path="author" class="text-warning" />
        </div>
        <div class="form-group">
            <label>Thoughts:</label>
            <form:textarea path="thoughts" class="form-control" />
            <form:errors path="thoughts" class="text-warning" />
        </div>
         <input type="submit" value="Submit" class="btn btn-dark m-2"/>
         <a href="/"><button class="btn btn-warning justify-content-end m-2" >Back To My Shelf!</button></a>
    </form:form>    
</body>
</html>