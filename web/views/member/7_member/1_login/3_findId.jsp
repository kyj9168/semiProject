<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
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
		<img src="" style="width:170px;">
	</div>
<br><br><br>
	<div>
		<%-- <form action="<%= request.getContextPath() %>/SelectFindld.sf" method="post"> --%>
			<table id="loginTable">
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;">이름</td>
				</tr>
				<tr>
					<td><input type="text" name="userId" style="width:400px; height:50px;" id="userId"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;">이메일</td>
				</tr>
				<tr>
					<td><input type="email" name="email" style="width:400px; height:50px;" id="email"></td>
				</tr>
			</table>
		<br><br><br><br>
		<input type="button" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width:400px" value="아이디찾기" id="Idsearch"></input>
		<!-- </form> -->
	</div>

	<br><br>
	<div>
		<hr style="width:400px; color:black;">
		<a href='/sixDestiny/views/member/7_member/1_login/2_login.jsp' style="font-family: 'Sunflower', sans-serif;" >로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href='/sixDestiny/views/member/7_member/1_login/4_findPassword.jsp' style="font-family: 'Sunflower', sans-serif;">비밀번호 찾기</a>
	</div>
</div>

<script>

$(function(){

	$('#Idsearch').click(function(){

		var userId = $('#userId').val();
		var email =  $('#email').val();

		$.ajax({
			url:"../../../../SelectFindld.sf",
			data:{userId:userId,email:email},
			type:"post",
			success:function(data){

				if(data.userId != null){

					var length = data.userId.length;

					var idlength = data.userId.substring(0,length-3);

					var idcheck = idlength+"***";

					alert("회원님 의 아이디 는 " + idcheck + " 입니다. ! ");

					location.href="/sixDestiny/views/member/7_member/1_login/2_login.jsp";


				}else{

					alert("일치하는 정보가 없습니다 ! 다시 입력해주세요.");


				}





			}

		})




	})




})

</script>


<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>