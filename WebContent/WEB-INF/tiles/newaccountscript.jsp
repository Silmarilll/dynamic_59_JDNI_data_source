<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function onLoad() {
	$("#password").keyup(checkPasswordsMatch);
	$("#confirmpassword").keyup(checkPasswordsMatch);
	
	$("#details").submit(canSubmit);
}

function canSubmit() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpassword").val();	
	
	return password == confirmpass;

}

function checkPasswordsMatch() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpassword").val();	
	
	if(password.length > 3 || confirmpass.length > 3) {

	 if(password == confirmpass) {
		$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password'/>"); 
		$("#matchpass").addClass("valid"); 
		$("#matchpass").removeClass("errors");
	 } else {
		 $("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password'/>");
		 $("#matchpass").addClass("errors"); 
		 $("#matchpass").removeClass("valid"); 
	 }
	}
}

$(document).ready(onLoad);
</script>