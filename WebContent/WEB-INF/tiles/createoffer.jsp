<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">

<form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
<table class="formtable">
<tr><td class="label">Name: </td><td><sf:input class="control" name="name" type="text" path="offer.name"/><br/><sf:errors path="offer.name" cssClass="errors"></sf:errors></td></tr>
<tr><td class="label">Email: </td><td><sf:input class="control" name="email" type="text" path="offer.email"/><br/><sf:errors path="offer.email" cssClass="errors"></sf:errors></td></tr>
<tr><td class="label">Your text: </td><td><sf:textarea class="control" name="text" rows="10" cols="10" path="offer.text"></sf:textarea><br/><sf:errors path="offer.text" cssClass="errors"></sf:errors></td></tr>
<tr><td class="label"> </td><td><input class="control" value="Create advert" type="submit"/></td></tr>
</table>
</form>