<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FreeMaker Test</title>
</head>
<body>
<h4> FreeMaker Test Page </h4>

<@s.property value="ValueStack" />

<a href="<@s.url.action='Home'/>Home Page </a>

    <@s.form action="add" method="post">
        <@s.textfield label="First name" name="user.firstname"/>
        <@s.textfield label="Last name" name="user.lastname"/>
        <@s.submit value="Save"/>
    </@s.form>
</body>
</html>