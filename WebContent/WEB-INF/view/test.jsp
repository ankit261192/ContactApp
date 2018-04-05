<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:url var="url_jqlib" value="/Static/javascript/jquery-3.3.1.min.js" ></s:url>
<script src="${url_jqlib}"></script>
<script>
$(document).ready(function(){
	//alert('jquery is ready and integrated');
	$("#id_get_time").click(function(){
		//alert('Button clicked');
		$.ajax({
			
			url:'get_time',
			success: function (data){
				$("#id_time").html(data);
			}
		});
	});
});
</script>
<title>Insert title here</title>
</head>
<body>
<h1>AJAX test page</h1>
<button id="id_get_time">Get Server Time</button><br/>
<p id="id_time"></p>
</body>
</html>