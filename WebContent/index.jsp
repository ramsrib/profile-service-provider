<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!...</title>
</head>
<body>
<h2>Welcome to Profile Manager!...</h1>

<h3>
<a href ="register.jsp">Register</a>
<a href="login.jsp">Login</a>
<a href="createprofile.jsp">Profile</a>
<a href="ListUser">List Users</a>
<a href="ListProfile">List Profiles</a>


<h4>For Debugging :</h4>
<a href="<s:url action="index" namespace="config-browser" />">Launch the configuration browser</a></h3>
</body>
</html>