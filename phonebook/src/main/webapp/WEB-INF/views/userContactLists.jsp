<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
<h3>
<% if ((request.getParameter("count"))!=null){
	out.println("Contact saved successfully");
} %> 
</h3>
<h2 style="background-color: gray; font-family: monospace;">${UserObj.getUser_name()}'s Contacts are:</h2>
<h2 style="font-weight: bold;">
<a href="addCon"><button>ADD CONTACT</button></a>
</h2>
<div class="container" style="width: 1000px;">
<table class="table table-bordered">
<c:forEach var="list" items="${ConList}">
<tr><td>----------------</td></tr>
<tr>
<td class="text-primary font-weight-bold">Name :</td>
<td>${list.getName()}</td>
</tr>
<tr>
<td class="text-primary font-weight-bold">Number :</td>
<td>${list.getNumber()}</td>
</tr>
<tr>
<td class="text-primary font-weight-bold">Address :</td>
<td>${list.getAddress()}</td>
</tr>
<tr>
<td class="text-primary font-weight-bold">Profile Pic :</td>
<td><img style="width:200px;height:200px;" alt="alternate" src="data:image/png;base64,${list.getBase()}"></td>
</tr>
<tr><td>----------------</td></tr>
</c:forEach>
</table>
</div>
<div align="right">
<jsp:include page="logoutForm.jsp"></jsp:include>
</div>
</body>
</html>