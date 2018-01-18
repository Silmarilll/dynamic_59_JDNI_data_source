<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
Hi there!


<c:forEach var="row" items="${offers}">
    ID: ${row.id}<br/>
    Name: ${row.name}<br/>
    E-mail: ${row.email}<br/>
    Text: ${row.text}<br/>
    <br/>
</c:forEach> --%>
</body>
</html>