<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Registration Page</title>
</head>
<body>
<div class="container" style="margin-top: 50px;">
<h2>User Registration Form:</h2>
<form:form action="usersave" method="post" modelAttribute="userDetail">
<div class="form-group">
<label for="user_name">Name:</label>
<form:input path="user_name" class="form-control"/>
</div>
<div class="form-group">
<label for="password">Password:</label>
<form:input type="password" path="user_password" class="form-control"/>
</div>
<div class="form-group">
<label for="user_email">E-Mail:</label>
<form:input path="user_email" class="form-control"/>
</div>
<div class="form-group">
<label for="user_number">Number:</label>
<form:input path="user_number" class="form-control"/>
</div>
<button type="submit" class="btn btn-primary">REGISTER</button>
</form:form>
</div>

</body>
</html>