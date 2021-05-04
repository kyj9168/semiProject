<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%@ include file="../../../common/inner_user_include.jsp" %>
	<link href="https://fonts.googleapis.com/css?family=Gaegu|Sunflower:300&display=swap" rel="stylesheet">
<style>
#outer{
	margin:0 auto;
	font-family: 'Sunflower', sans-serif;
}

</style>
</head>
<body>

	<div id="outer">
	<br><br>
	<h2><%=loginUser.getUserNm()%>님의 탈퇴사유</h2>
	<br><br>
	<form action="<%=request.getContextPath()%>/usersec" method="post">
		<div id="div1">
			<select name="leaveRsCd" style="width:300px;">
				<option value="L1">서비스 이용 불필요</option>
				<option value="L2">사이트 불신</option>
				<option value="L3">재가입을 위해서</option>
				<option value="L4">컨텐츠 부족</option>
				<option value="L5">기타</option>
			</select>
		</div>
		<br><br>
		<div>
			<button id="submit"  class="btn btn-default"  onclick="location.href='/sixDestiny/index.jsp'">탈퇴하기</button>
		
		</div>
	</form>
	
	
	
	
	
	
	</div>
	
<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>