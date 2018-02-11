<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new account</title>
</head>
<body>



<form method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
<table class="formtable">
<tr><td class="label">Username: </td><td><sf:input class="control" name="username" type="text" path="user.username"/><br/><div class="errors"><sf:errors path="user.username"></sf:errors></div></td></tr>
<tr><td class="label">Email: </td><td><sf:input class="control" name="email" type="text" path="user.email"/><br/><div class="errors"><sf:errors path="user.email"></sf:errors></div></td></tr>
<tr><td class="label">Password: </td><td><sf:textarea class="control" name="text" rows="10" cols="10" path="user.password"></sf:textarea><br/><div class="errors"><sf:errors path="user.password"></sf:errors></div></td></tr>
<tr><td class="label">Confirm password: </td><td><input class="control" name="confirmpass" type="text"/><br/></td></tr>
<tr><td class="label"> </td><td><input class="control" value="Create advert" type="submit"/></td></tr>
</table>
</form>
</body>
</html>