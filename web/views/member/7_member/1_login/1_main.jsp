<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<style>
#button {
	background: dimgray;
	Color: white;
}
</style>
<body>
	<div id="div1">
		
		<div>
			<button type="button" class="btn btn-info"
				onclick="location.href='2_login.jsp'"
				style="width: 222px; height: 50px; font-family: 'Sunflower', sans-serif;">ID/PW로 로그인</button>
		</div>
		<br><br>
		<div>
			<%-- 카카오톡 로그인 --%>

			<a id="kakao-login-btn"></a> <a
				href="http://developers.kakao.com/logout"></a>
			<script type='text/javascript'>
				//<![CDATA[
				// 사용할 앱의 JavaScript 키를 설정해 주세요.
				Kakao.init('a8cc106d455abafda8893930cf48c89e');
				// 카카오 로그인 버튼을 생성합니다.
				Kakao.Auth.createLoginButton({
					container : '#kakao-login-btn',
					success : function(authObj) {

						 Kakao.API.request({
							url: '/v1/user/me',
							success : function(res) {
								
								var userId = res.id;
								var email = res.kaccount_email;
								var userName = res.properties['nickname'];
								
								$.ajax({
									
									url : "/sixDestiny/kakaologin",
									data : {userId:userId,email:email,userName:userName},
									type:"post",
									success:function(data){
										console.log(data["userId"]);
										console.log(data["email"]);
										console.log(data["userName"]);
										
										var args = '?';
										args += (data.userId == undefined)? '' : 'userId='+data.userId+'&';
										args += (data.email == undefined)? '' : 'email='+data.email+'&';
										args += (data.userName == undefined)? '' : 'userName='+data.userName+'&';
										location.href = data.returnUrl+args;
									}
								})
								
								alert("카카오톡 로그인에 성공하였습니다");
							}
						})
					},
					fail : function(err) {
						alert(JSON.stringify(err));
						alert("카카오톡 로그인에 실패하였습니다");
					}
					
				});
				
				//]]>
			</script>
			
		</div>
	</div>


   <input type="hidden" id="tocken" name="tocken" value="0">
	<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>