<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
    Error Occurred!...

    <a href ='<s:url value="index"/>'>Go Home</a>

    <s:if test="hasActionErrors()">
        <s:actionerror />
    </s:if>


    <h4>
        Exception Name:
        <s:property value="exception" />
    </h4>

    <h5>
        Exception Details:
        <s:property value="exceptionStack" />
    </h5>
    <!-- click <a href="/ProfileManager/chapterTwo/name">here</a> -->
</body>
</html>