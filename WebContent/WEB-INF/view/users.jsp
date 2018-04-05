<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List </title>
<s:url var="url_css" value="/Static/css/style.css"></s:url>
<link href ="${url_css}" rel="stylesheet" type="text/css"/>
<s:url var="url_jqlib" value="/Static/javascript/jquery-3.3.1.min.js" ></s:url>
<script src="${url_jqlib}"></script>
<script>
function changeStatus(uid,lstatus){
	//alert(userid+","+loginstatus);
	$.ajax({
		url:'/change_status',
		data:{userid:uid,loginstatus:lstatus},
		success: function(data){
			alert:(data);
		}
	})
}
</script>
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
<h3>User List</h3>
<table border="1" >
<tr>
<th>S.No</th>
<th>U.Id</th>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th>Address</th>
<th>Username</th>
<th>Status</th>
</tr>
<c:forEach var="u" items="${userList}" varStatus="st">
<tr>
<td>${st.count}</td>
<td>${u.userid}</td>
<td>${u.name}</td>
<td>${u.email}</td>
<td>${u.phone}</td>
<td>${u.address}</td>
<td>${u.loginname}</td>
<td>
<select id="id_${u.userid}" onchange="changeStatus(${u.userid},$(this).val())"> <%--id_1,id_2 etc. --%>
<option value="1">Active</option>
<option value="2">Block</option>
</select>
<script>
$('#id_${u.userid}').val(${u.loginstatus});
</script>
</td>
</tr>
</c:forEach>
</table>
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