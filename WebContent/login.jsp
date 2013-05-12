<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<style type="text/css">
.login {
        background-color:#DDD;
        border:2px solid #FFFFFF;
        width:350px;
        margin-bottom:10px;
}
.errors li{
        list-style: none;
}
</style>

</head>
<body>
<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>


Login here:
<div class="login">
<s:form action="LoginAction">
<s:textfield name="name" label="Your name"/>
<s:password name="password" label="Password" />
<s:submit/>
</s:form>
</div>
</body>
</html>