<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Here</title>
</head>
<body>

    <s:form action="RegisterAction" method="post" enctype="multipart/form-data">
        <s:textfield name="name" label="Your name" />
        <s:textfield name="email" label="Your Email ID" />
        <s:password name="password" label="Password" />
        <s:file name="profilePicture" label="Picture" />
        <s:submit />
    </s:form>


    <s:if test="hasActionErrors()">
        <s:actionerror />
    </s:if>

    <!--<s:if test="hasActionMessages()">
        <div class="welcome">
        <s:actionmessage/>
        </div>
    </s:if>-->

</body>
</html>