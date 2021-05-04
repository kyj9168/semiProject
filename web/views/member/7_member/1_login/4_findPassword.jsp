<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
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
		<form action="<%= request.getContextPath() %>/SelectfindPasswod.sp" method="post">
			<table id="loginTable">
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">이름</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="userNm" style="width:400px; height:50px;"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">아이디</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="userId" style="width:400px; height:50px;"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">이메일</td>
				</tr>
				<tr>
					<td>
						<input type="email" name="email" style="width:330px; height:50px;" id="inputEmail">
					</td>
					<td>
						<button type="button" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width:50px; height:50px;"
								onclick="sendMessage();" id="mailbtn">인증</button>
					</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr class="hiddenpwd">
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">인증번호</td>
				</tr>
				<tr class="hiddenpwd">
					<td>
						<input type="email" name="" style="width:330px; height:50px;" id="randomNum">
					</td>
					<td>
						<button type="button" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width:50px; height:50px;" id="pushNum">입력</button>
					</td>
				</tr>

			</table>
		<br><br><br><br>
		<input type="submit" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width:400px" value="비밀번호 찾기" id="pwdbun" disabled></input>
		</form>
	</div>

	<br><br>
	<div>
		<hr style="width:400px; color:black;">
		<a href='/sixDestiny/views/member/7_member/1_login/2_login.jsp' style="font-family: 'Sunflower', sans-serif;" >로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
</div>
<script type="text/javascript">
      $(function(){
         $('#mailbtn').click(function(){
        	var inputEmail = $("#inputEmail").val();

            $('.hiddenpwd').each(function(){
            	$(this).css('opacity','1');
            });

            $.ajax({
            	url:"/sixDestiny/sendMail",
            	type:"post",
            	data:{inputEmail:inputEmail},
            	success:function(data){
					console.log(data);

					$("#randomNum").keyup(function(){
						var num = $("#randomNum").val();

						if(data == num){
							$("#randomNum").css("border-color", "transparent");
						}else{
							$("#randomNum").css("border-color", "red");
						}
					});

					$("#pushNum").click(function(){
						var num = $("#randomNum").val();

						if(data == num){

							$("#randomNum").attr("disabled", "true");
							$("#pwdbun").removeAttr("disabled");

						}else{
							alert("인증번호를 잘못 입력 하셨습니다.");
						}
					})
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