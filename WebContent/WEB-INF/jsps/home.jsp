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

Session: <%= session.getAttribute("name") %> <p/>

Request: <%= request.getAttribute("name") %> <p/>

Request (using EL): ${name} <p/>

<c:out value="${name}" ></c:out>

<%-- <sql:query var="rs" dataSource="jdbc/jdni_name">
select id, name, email, text from offers
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    Name: ${row.name}<br/>
    Text: ${row.text}<br/>
</c:forEach> --%>
</body>
</html>