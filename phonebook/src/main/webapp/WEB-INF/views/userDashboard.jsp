<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body> 

<div class="container" style="margin-top: 50px;">
<h3>User Detail:</h3>
<table class="table table-bordered">
<tr>
<td>Name :</td>
<td>${UserObj.getUser_name()}</td>
</tr>
<tr>
<td>Email :</td>
<td>${UserObj.getUser_email()}</td>
</tr>
<tr>
<td>Contact No. :</td>
<td>${UserObj.getUser_number()}</td>
</tr>
<tr>
<td>View All  Contacts :</td>
<td><a href="showContact">Click Here</a></td>
</tr>
</table>
</div>
<jsp:include page="logoutForm.jsp"></jsp:include>

</body>
</html>