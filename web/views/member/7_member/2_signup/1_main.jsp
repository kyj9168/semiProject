<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
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
	width: 300px;
	height: 50px;
	border:none;
}


</style>
<body>

<%--전체 DIV --%>
<div>
	
		
	<br> <br> <br>
		
	<div>
		<button class="btn btn-info" id="button" onclick="location.href='/sixDestiny/views/member/7_member/2_signup/2_acceptterms.jsp'"
				style="width: 222px; height: 50px; font-family: 'Sunflower', sans-serif;">ID/PW로 회원가입</button>
	</div>
		
	<br>
		
</div>
	<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>