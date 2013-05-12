<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Profile Home</title>


<style type="text/css">
.welcome {
        background-color:#DDFFDD;
        border:1px solid #009900;
        width:200px;
}
.welcome li{
        list-style: none;
}
</style>


</head>
<body>


<s:property value="getText('welcome.hello')" /> :
<s:property value="profile.username"/>
<br/>
List : <s:property value="profile.lists" />

<!--  most likely this below block never get executed, we receive success messages and errors are redirected to error.jsp  -->

<s:if test="hasActionErrors()">
      <s:actionerror/>
</s:if>

<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>

</body>
</html>