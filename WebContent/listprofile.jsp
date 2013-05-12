<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile List</title>
</head>
<body>
    <s:if test="profiles.size > 0">
        <table>
            <s:iterator value="profiles">
                <tr>
                    <li><s:property /></li>
                </tr>
                <tr id="row_<s:property value="id"/>">
                    <td><s:property value="username" /></td>
                    <td><s:property value="profilename" /></td>
                    <!--
                    <td><s:url id="removeUrl" action="remove">
                            <s:param name="id" value="id" />
                        </s:url> <s:a href="%{removeUrl}" theme="ajax" targets="persons">Remove</s:a> <s:a id="a_%{id}"
                            theme="ajax" notifyTopics="/edit">Edit</s:a></td>  -->
                </tr>
            </s:iterator>
        </table>
        </s:if>
</body>
</html>