<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>PHONEBOOK-HOME</title>
</head>
<body>
<%
//out.println(session.getAttribute("UserObj"));
try{
String msg=(String)request.getAttribute("loginFail");
	if(msg!=null)
		out.println(msg);
}catch(Exception e){
	
}
%>
<div class="container" style="margin-top: 50px;">
<h2>User Log-In Form:</h2>
<form action="userLoginCred" method="post">
<div class="form-group">
<label for="user_email">E-Mail:</label>
<input type="text" name="user_email" placeholder="enter your registered email" class="form-control">
</div>
<div class="form-group">
<label for="user_password">Password:</label>
<input type="password" name="user_password" placeholder="enter password" class="form-control">
</div>
<button type="submit" class="btn btn-primary">Submit</button>
</form>
<div class="form-group">
<p class="help-block"><a href="new">New User.. Register Here</a></p>
</div>
</div>


</body>
</html>