<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semi.user.model.vo.*"%>
<%@ include file="../../../common/top_Include.jsp"%>


<%
	User us = (User) request.getAttribute("us");

	String msg = (String) request.getParameter("msg");
%>

<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
  #loginTable {
		margin:0 auto;
		width:400px;
		height:70px;
		text-align:left;
	}
  </style>
</head>
<style>
#loginTable {
		margin:0 auto;
		width:400px;
		height:70px;
		text-align:left;
	}

.hiddenpwd {
 	opacity:0;
}
</style>
<body>
	<div>
	<div>
		<img src="" style="width:170px;">
	</div>
<br><br><br>
	<div>
	<%if(us !=  null){ %>
		<form action="<%= request.getContextPath() %>/UpdateSign.user" method="post">
			<table id="loginTable">

				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" >비밀번호 재설정</td>
					<td><input type="hidden" name="userId" value="<%=us.getUserId() %>"> </td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="password" style="width:400px; height:50px;" id="passwordArea"></td>
				</tr>
				<tr>
					<td  style="font-family: 'Sunflower', sans-serif;" >비밀번호 확인</td>
				</tr>
				<tr>
					<td>
						<input type="password" name="password2" style="width:400px; height:50px;" id="passwordpass">
					</td>
				</tr>


			</table>
		<br><br><br><br>
		<input type="submit" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width:400px" value="확인"></input>
		</form>
		<% }else { %>
		<pre  style="font-family: 'Sunflower', sans-serif;"><%= msg %></pre>
		<%} %>
	</div>

	<br><br>
	<div>
		<hr style="width:400px; color:black;">
		<a href='/sixDestiny/views/member/7_member/1_login/2_login.jsp' style="font-family: 'Sunflower', sans-serif;">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
</div>

<script>
$(function(){

	$("#passwordpass").keyup(function(){
		var password = $("#passwordArea").val();
		var password2 = $("#passwordpass").val();

		if(password == password2){

			$("#passwordpass").css("border-color", "transparent")
		}else{

			$("#passwordpass").css("border-color", "red")
		}
	});
});

</script>


<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>