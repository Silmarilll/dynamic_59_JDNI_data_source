<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<p>
		<a href="${pageContext.request.contextPath}/offers">Show current
			offers</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/createoffer">Create
			offer</a>
	</p>

<p><c:url var="logoutUrl" value="/logout"/><form action="${logoutUrl}" method="post"> <input type="submit" value="Log out" /> <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></form></p>
</body>
</html>