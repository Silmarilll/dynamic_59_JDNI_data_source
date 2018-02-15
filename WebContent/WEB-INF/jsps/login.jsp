<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>

<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>
	<c:if test="${param.error != null}">
		<p>Login failed. Check login and password</p>	
	</c:if>
	<form name='f' action="${pageContext.request.contextPath}/login" method='POST'>
		<table class="formtable">
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
						<tr>
				<td>Remember me:</td>
				<td><input type='checkbox' name='remember-me' checked="checked"/></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>
	
	<p><a href="<c:url value="/newaccount"/>">Create new account</a></p>
	</body>
</html>