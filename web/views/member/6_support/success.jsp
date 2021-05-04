<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Gaegu&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gaegu|Sunflower:300&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
.display{
	display: inline;
	font-family: 'Gaegu', cursive;
	font-size: 30px;
}
.Name{
	display: inline;
	font-family: 'Gaegu', cursice;
	font-size: 50px;
}
.mainbutton{
	margin-top: 3%;
	margin-left: 40%;
}


</style>
</head>
<body>


<div>
	<h3 style="font-family: 'Sunflower', sans-serif;"><%= loginUser.getUserNm() %>님의 후원신청이 완료 되었습니다!</h3>
	<hr>
	<h4 style="font-family: 'Sunflower', sans-serif;">물품 후원의 경우 주소를 잘 확인 하시어 꼭 선불로 배송비를 완납한 후 물품을 배송하여 주시고,</h4>
	<h4 style="font-family: 'Sunflower', sans-serif;">금전 후원의 경우에는 영업일 기준 2~3일 이내에 승인 완료 처리를 해드립니다.</h4>
	<h4 style="font-family: 'Sunflower', sans-serif;">회원님의 후원 내역 현황은 상단 마이페이지 > 후원내역에서 확인하실 수 있으며,</h4>
	<h4 style="font-family: 'Sunflower', sans-serif;">다시한번 저희 육인연에 깊은 관심과 후원을 보내주신 <%= loginUser.getUserNm() %>님께 감사말씀 드립니다.</h4>
	<hr>
</div>

<div>
	<br><br>
	<button class="btn btn-default" onclick="location.href='/sixDestiny/mySupport.su'" style="font-family: 'Sunflower', sans-serif;
	">내 후원내역 보기</button>
	<button class="btn btn-default"" onclick="location.href='../../../../sixDestiny'" style="font-family: 'Sunflower', sans-serif;
	">메인으로</button>
</div>



<%@ include file="../../common/bottom_Include.jsp"%>
</body>
</html>