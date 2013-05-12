<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Profile</title>
</head>
<body>

<s:form action="AddProfileAction">
<s:textfield name="profile.profilename" label="Profile name"/>
<s:textfield name="profile.username" label="Username" />
<s:select name="profile.lists" label="Options List" list="{'1','2','3'}" />
<s:radio label="Options Radio" list="{'1','2','3'}" />
<s:checkboxlist name="profile.lists" label="Checkbox List" list="{'1','2','3'}"></s:checkboxlist>
<s:submit/>
</s:form>

</body>
</html>