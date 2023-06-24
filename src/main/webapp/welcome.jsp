<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.mvcdemo.model.User" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Login Successful!!!</h1>
	
	<jsp:useBean id="user" class="com.mvcdemo.model.User" scope="request">
		<jsp:setProperty property="userName" name="user" value="New User"/>
	</jsp:useBean>
	
	<h2>Welcome <jsp:getProperty property="userName" name="user"/></h2>
	${user.getUserName()}
</body>
</html>