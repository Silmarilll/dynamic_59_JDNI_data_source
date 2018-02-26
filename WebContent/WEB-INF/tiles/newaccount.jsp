<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
<table class="formtable">
<tr><td class="label">Username: </td><td><sf:input class="control" name="username" type="text" path="user.username"/><br/><div class="errors"><sf:errors path="user.username"></sf:errors></div></td></tr>
<tr><td class="label">Name: </td><td><sf:input class="control" name="name" type="text" path="user.name"/><br/><div class="errors"><sf:errors path="user.name"></sf:errors></div></td></tr>
<tr><td class="label">Email: </td><td><sf:input class="control" name="email" type="text" path="user.email"/><br/><div class="errors"><sf:errors path="user.email"></sf:errors></div></td></tr>
<tr><td class="label">Password: </td><td><sf:password class="control" name="password" rows="10" cols="10" path="user.password"/><br/><div class="errors"><sf:errors path="user.password"></sf:errors></div></td></tr>
<tr><td class="label">Confirm password: </td><td><input class="control" id="confirmpassword" name="confirmpass" type="password"/><div id="matchpass"></div><br/></td></tr>
<tr><td class="label"> </td><td><input class="control" value="Create advert" type="submit"/></td></tr>
</table>
</form>
