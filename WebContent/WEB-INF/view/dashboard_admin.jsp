<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator DashBoard </title>
<s:url var="url_css" value="/Static/css/style.css"></s:url>
<link href ="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<s:url var="url_bg" value="/Static/images/theme3.jpg"></s:url>
<body background="${url_bg}">
<table border="1" width="80%" align="center">
<tr>
<td height="80px">
<%-- header area--%>
<jsp:include page="include/header.jsp"></jsp:include>
</td>
</tr>
<tr>
<td height="25px">
<%-- menu area--%>
<jsp:include page="include/menu.jsp"></jsp:include>
</td>

</tr>
<tr>
<td height="350px" valign="top">
<%-- page content area .add forms here--%>
<h1>Admin Dashboard</h1>
todo-admin option in this page 
</td>
</tr>
<td height="5px">
<%-- footer area--%>
<jsp:include page="include/footer.jsp"></jsp:include>
</td>
</tr>
</table>
</body>
</html>