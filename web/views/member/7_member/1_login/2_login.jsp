<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
	String msg = (String) request.getAttribute("msg");
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
  
  
</head>
<style>

#loginTable {
		margin:0 auto;
		width:400px;
		height:70px;
		text-align:left;
	}
</style>
<body>
<div>
	<div>
		<form action="/sixDestiny/login.user" method="post">
			<table id="loginTable">
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;">아이디</td>
				</tr>
				<tr>
					<td><input type="text" name="userId" style="width:400px; height:50px;" id="rememberId"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;">비밀번호</td>
				</tr>
				<tr>
					<td><input type="password" name="password" style="width:400px; height:50px;" id="remember"></td>
				</tr>
			
			</table>
		<br><br><br><br>
		<input type="submit" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width:400px" value="로그인"></input>
		</form>
	</div>

	<div>
		<br><br>
		<h4 id="hiddenMent" style="opacity:0; color:red; font-family: 'Sunflower', sans-serif;"><%= msg %></h4>
		<% if(msg != null){ %>
			<script type="text/javascript">
				$(function(){
					$("#hiddenMent").css("opacity", "1");
				})

				$(function(){
					setTimeout(function(){
						$("#hiddenMent").css("opacity", "0");
					}, 1000);
				})
			</script>
			<% } %>
	</div>
	<div>
		<!-- <hr style="width:400px; color:black;"> -->
		<a href='/sixDestiny/views/member/7_member/1_login/3_findId.jsp' style="font-family: 'Sunflower', sans-serif;">아이디 찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href='/sixDestiny/views/member/7_member/1_login/4_findPassword.jsp' style="font-family: 'Sunflower', sans-serif;">비밀번호 찾기</a>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		$("#remember").focus(function(){
			var userId = $("#rememberId").val();
			console.log(userId);
			$.ajax({
				url:"/sixDestiny/remember.user",
				type:"post",
				data:{userId:userId},
				success:function(data){
					console.log(data);
					$("#remember").val(data);
				},
				error:function(){
				}
			});
		});
	});
</script>
<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>