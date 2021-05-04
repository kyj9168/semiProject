<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="views/common/top_Include.jsp"%>

<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Gaegu|Sunflower:300&display=swap" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.mainimgs {
	width: 80%;
}
</style>
<body style="overflow-x:hidden">
<script>
$(function(){
	var msg = "<%= msg %>"
	if(msg.length > 5 ){
		alert("<%= msg%>");
	}
})

</script>
	<img class="mainimgs" src="/sixDestiny/images/mainview.png">

<%@ include file="views/common/bottom_Include.jsp"%>
</body>
</html>