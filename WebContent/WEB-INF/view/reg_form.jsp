<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form-ContactApp </title>
<s:url var="url_css" value="/Static/css/style.css"></s:url>
<link href ="${url_css}" rel="stylesheet" type="text/css"/>
<s:url var="url_jqlib" value="/Static/javascript/jquery-3.3.1.min.js" ></s:url>
<script src="${url_jqlib}"></script>
<script>
$(document).ready(function(){
	
	$("#id_check_avail").click.(function(){
		$.ajax{(
			url:'check_avail',
			data:{username:$("#id_username").val()},
			success:function(data){
				$("#id_res_div").html(data);
			}
		)}
	});
})
</script>
</head>
<s:url var="url_bg" value="/Static/images/theme3.jpg"></s:url>
<body background="${url_bg}">
<table border="1" width="80%" bordercolor="black" align="center">
<tr>
<td height="80px">
<%--header --%>
<jsp:include page="include/header.jsp"></jsp:include>
</td>
</tr>

<tr>
<td height="25px">
<%--menu --%>
<jsp:include page="include/menu.jsp"></jsp:include>
</td>
</tr>

<tr>
<td height="350px" valign="top">
<%--content --%>
<h3>User Registration Form</h3>
<c:if test="${err!=null}"><%--err is a scoped attrbute and they are accessed as shown --%>
<p class="error">${err}</p>
</c:if>

<s:url var="url_reg" value="/register"></s:url>
<f:form action="${url_reg}" modelAttribute="command">
<table border="1">
<tr>
<td>Name</td>
<td><f:input path="user.name"/></td>
</tr>
<tr>
<td>Phone</td>
<td><f:input path="user.phone"/></td>
</tr>
<tr>
<td>Email-id</td>
<td><f:input path="user.email"/></td>
</tr>
<tr>
<td>Address</td>
<td><f:textarea path="user.address"/></td>
</tr>
<tr>
<td>Username</td>
<td><f:input id="id_username" path="user.loginname"/>
<button type="button" id="id_check_avail">Check Availability</button>
<div id="id_res_div" class="error"></div>
</td>
</tr>
<tr>
<td>Password</td>
<td><f:password path="user.password"/></td>
</tr>

<tr>
<td colspan="2" align="right">
<button>Submit</button><br>
</td>
</tr>
</table>
</f:form>
</td>
</tr>
<tr>
<td height="15px">
<%--footer --%>
<jsp:include page="include/footer.jsp"></jsp:include>
</td>
</tr>
</table>
</body>
</html>