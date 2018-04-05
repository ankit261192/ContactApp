<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List </title>
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
<h3>Contact List</h3>
<c:if test="${param.act eq 'sv'}">
<p class="success">Contact successfully added to contact list</p>
</c:if>
<c:if test="${param.act eq 'del'}">
<p class="success">Contact successfully deleted from contact list</p>
</c:if>
<table width="100%">
<tr>
<td align="right">
<form action="<s:url value="/user/contact_search"></s:url>">
<input type="text" name="freeText" value="${param.freeText}" placeholder="Enter text to search">
<button>Find</button>
</form>
</td>
</tr>
</table>
<form action="<s:url value="/user/bulk_c_delete"></s:url>">

<button>Delete selected records</button><br/><br/>

<table border="1" cellpadding="3" width="100%">
<tr>
<th>SELECT</th>
<th>C.Id</th>
<th>Name</th>
<th>Phone</th>
<th>Address</th>
<th>Email</th>
<th>Remark</th>
<th>Action</th>
</tr>
<c:if test="${empty contactList}">
<tr>
<td align="center" colspan="8" class="error">No records present </td>   <%--colspan=select all the 8 columns and displays error message --%>
</tr>

</c:if>
<c:forEach var="c" items="${contactList}" varStatus="st">     <%--for all contacts(c)  in contactList,st is for s.no count--%>
<tr>
<td align="center"><input type="checkbox" name="cid" value="${c.contactId}"></td>
<td>${c.contactId}</td>
<td>${c.name}</td>
<td>${c.phone}</td>
<td>${c.address}</td>
<td>${c.email}</td>
<td>${c.remark}</td>
<s:url var="url_del" value="/user/del_contact">
<s:param name="cid" value="${c.contactId}"></s:param>
</s:url>
<s:url var="url_edit" value="/user/edit_contact">
<s:param name="cid" value="${c.contactId}"></s:param>
</s:url>
<td><a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a></td>
</tr>
</c:forEach>
</table>
</form>
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