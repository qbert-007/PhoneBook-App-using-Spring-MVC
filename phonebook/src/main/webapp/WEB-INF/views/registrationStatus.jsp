<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.qbert.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
<%
String msg;
int count=(Integer)request.getAttribute("count");
if(count>0) {
	User u=(User)request.getAttribute("userDetail");
	msg="Successfully Registered "+u.getUser_name()+" please login";
%> 
<p class="text-center text-success"><%=msg %></p>       
<%	
	request.getRequestDispatcher("userLoginForm.jsp").include(request, response);
}else{
	msg="Registration Unsuccessfull";
%> 
<p class="text-center text-danger"><%=msg %></p>       
<%
	request.getRequestDispatcher("index.jsp").include(request, response);
}
%>
</body>
</html>