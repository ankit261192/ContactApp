<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<s:url var="url_logout" value="/logout"></s:url>
<c:if test="${sessionScope.userid==null}">
<%--no  user logged in.It's a guest menu --%>
<s:url var="url_reg_form" value="/reg_form"></s:url>
<a href="#">Home</a> | <a href="#">Login</a> | <a href="${url_reg_form}">Register</a> | <a href="#">About</a> | <a href="#">Help</a>
</c:if>
<c:if test="${sessionScope.userid!=null && sessionScope.role == 1}">
<%--Admin user logged in.It's a Admin menu --%>

<a href="#">Home</a> | <a href="<s:url value="/admin/users"></s:url>">User List</a> | <a href="${url_logout}">Logout</a>
</c:if>
<c:if test="${sessionScope.userid!=null && sessionScope.role == 2}">
<%-- User logged in.It's a general user menu --%>
<s:url var="url_uhome" value="/user/dashboard"></s:url>
<s:url var="url_cform" value="/user/contact_form"></s:url>
<s:url var="url_clist" value="/user/clist"></s:url>
<%-- User logged in.It's a general user menu --%>
<a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_clist}">Contact List</a> | <a href="${url_logout}">Logout</a>
</c:if>