<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , com.kh.semi.entrance.model.vo.*"%>
    <%
    String dogInfo = request.getParameter("data");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<title>육 인 연</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}

#outer{
	width:400px;
	text-align:center;
	margin: 0 auto;
	font-family: 'Do Hyeon', sans-serif;
}


@import url('https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap');
</style>
</head>
<script type="text/javascript">
	%(function(){
		console.log(<%=dogInfo%>);
	});
</script>
<body>
<%-- <br>
<div id="outer">
 <%if(u.getGender().equals("F")){ %>
<img src="/sixDestiny/images/female.png" alt="Cinque Terre" width="100" height="100">
<%}else {%>
<img src="/sixDestiny/images/male.png"  alt="Cinque Terre" width="100" height="100">
<%} %>

<h3><%=u.getUserNm() %>님의 정보</h3>
<br>
<table id="outer">

	<tr align="center">
		<td>회원번호</td>
		<td><%=u.getUserNo() %></td>
	</tr>

	<tr>
		<td>아이디</td>
		<td><%=u.getUserId() %></td>
	</tr>

	<tr>
		<td>이름</td>
		<td><%=u.getUserNm() %></td>
	</tr>

	<tr>
		<td>닉네임</td>
		<td><%=u.getNickNm() %></td>
	</tr>

	<tr>
		<td>이메일</td>
		<td><%=u.getEmail() %></td>
	</tr>

	<tr>
		<td>연락처</td>
		<td><%=u.getPhone() %></td>
	</tr>

	<tr>
		<td>생년월일</td>
		<td><%=u.getUserHb() %></td>
	</tr>

	<tr>
		<td>성별</td>
		<td><%=u.getGender() %></td>
	</tr>

	<tr>
		<td>주소</td>
		<td><%=u.getAddress() %></td>
	</tr>

	<tr>
		<td>반려견 유무</td>
		<td><%=u.getDogYn() %></td>
	</tr>

	<tr>
		<td>회원 종류</td>
		<td><%=u.getUserKind()%></td>
	</tr>

	<tr>
		<td>경로 코드</td>
		<td> <%if(u.getRtCd().equals("E1")) { %>
		SNS
		<%}else if(u.getRtCd().equals("E2")) {%>
		검색
		<%}else if(u.getRtCd().equals("E3")) {%>
		광고
		<%}else if(u.getRtCd().equals("E4")) {%>
		지인추천
		<%}else{ %>
		기타
		<%} %>
		</td>
	</tr>
</table>

</div> --%>
</body>
</html>