<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <link href="https://fonts.googleapis.com/css?family=Gaegu|Sunflower:300&display=swap" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table tr td.td1{
		background: rgb(204, 230, 255);
		width: 120px;
		height: 35px;
		font-weight: bold;
		border-radius: 10px;
	}
	
	table tr td.td2{
		padding-left: 5%;
		height: 35px;
	}
	
	#outer{
		margin-left:550px;
		width:500px;
		font-family: 'Sunflower', sans-serif;
	}
	
	#pass{
		width:240px;
	}
	
	#msg{
	
		color:red;
	}


</style>
</head>
<body>
<br>
<br>
<br>
<div id="outer">
	<form action="/sixDestiny/secession.user" method="post">
	<table>
	<tr>
		<td class="td1">비밀번호</td>
		<td class="td2"><input type="password" id="pass" name="password" required></td>
	</tr>
		
	<tr>
		<td><br></td>
		<td><input type="hidden" name="userId" value=<%=loginUser.getUserId()%>></td>
	</tr>
	
	<!-- 	
	<tr>
		<td class="td1">비밀번호 확인</td>
		<td class="td2"><input type="password" id="pass" name="password"></td> 
	</tr> -->
		
	</table>
	
	<br>
	<input type="submit" value="확인" class="btn btn-default">
	<br>
	<h5 id="msg">
	<%if(msg==null){ %>
	<br>
	<%}else{ %>
	<%=msg %>
	<%} %>
	</h5>
	
	</form>
</div>
<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>