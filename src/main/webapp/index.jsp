<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login & Reg</title>
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-secondary text-white">
    <h1 class= "m-2 text-dark">Book Club!</h1>
    <h2 class= "m-2 text-dark">A place for friends to share thoughts on books.</h2>
    <div  class="d-flex flex-row" >
    <form:form action="/register" method="post" modelAttribute="newUser" class="d-flex flex-column m-4">
        <div class="form-group p-2">
        <h2>Register</h2>
            <label>User Name:</label>
            <form:input path="userName" class="form-control" />
            <form:errors path="userName" class="text-warning" />
        </div>
        <div class="form-group p-2">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-warning" />
        </div>
        <div class="form-group p-2">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-warning" />
        </div>
        <div class="form-group">
            <label>Confirm Password:</label>
            <form:password path="confirm" class="form-control" />
            <form:errors path="confirm" class="text-warning" />
        </div>
        <span><input type="submit" value="Register" class="btn btn-dark" /></span>
    </form:form>
    
    <form:form action="/login" method="post" modelAttribute="newLogin" class="d-flex flex-column m-4">
        <div class="form-group p-2">
             <h2>Login</h2>
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-warning" />
        </div> 
        <div class="form-group p-2">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-warning" />
        </div>
        <span><input type="submit" value="Login" class="btn btn-light" /></span>
    </form:form>
    </div>
</body>
</html>