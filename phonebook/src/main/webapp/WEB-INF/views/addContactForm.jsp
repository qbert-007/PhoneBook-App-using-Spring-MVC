<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="com.qbert.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
<div class="container">
<h2>Enter details to save the contact:</h2>
<form action="contactsave" method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="name">NAME:</label>
<input type="text" name="name" class="form-control"/>
</div>
<div class="form-group">
<label for="number">NUMBER</label>
<input type="text" name="number" class="form-control"/>
</div>
<div class="form-group">
<label for="address">ADDRESS:</label>
<input type="text" name="address" class="form-control"/>
</div>
<div class="form-group">
<label for="image">PICTURE</label>
<input type="file" name="image" class="form-control"/>
</div>
<div class="form-group">
<button type="submit" class="btn btn-primary">SAVE</button>
</div>
</form>
</div>

</body>
</html>