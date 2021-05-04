<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semi.adminboard.model.vo.*, com.kh.semi.board.parcelout.model.vo.Attachment"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE htm>
<html>
<%
	AdminBoard ab = (AdminBoard) (request.getAttribute("ab"));
	Attachment ac = (Attachment) (request.getAttribute("ac"));
	int currentPage = (Integer) request.getAttribute("currentPage");
%>

<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div>
	<h1 style="font-family: 'Sunflower', sans-serif;">금전 후원 내역 살펴보기</h1>
	<br>
	<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
		<div style="width:70%; margin:0 auto;" align="right">
		<button style="font-family: 'Sunflower', sans-serif;" class="btn btn-default" onclick="location.href='/sixDestiny/views/member/6_support/4_history/2_write.jsp'">글작성</button>
		</div>
	<% } %>
	<hr style="width:80%">
	<!-- <table>
		<tr>
			<td style="width:200px">
				<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif;" onclick="print()">영수증 출력하기</button>
			</td>
		</tr>
	</table> -->
	<table style="width:80%; margin:0 auto;">
		<tr>
			<td style="width:200px">
				<button style="border:none; background:none" onclick="location.href='<%=request.getContextPath()%>/selectSup.his?currentPage=<%=currentPage-1%>'"> ◀ </button>
				<span style="font-family: 'Sunflower', sans-serif;"><%=currentPage%>월 사용 내역</span>
				<button style="border:none; background:none" onclick="location.href='<%=request.getContextPath()%>/selectSup.his?currentPage=<%=currentPage+1%>'"> ▶ </button>
			</td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<hr style="width:80%">
	<table style="width:80%; margin:0 auto;">
		<tr>
			<td style="font-family: 'Sunflower', sans-serif; width:200px"><%=ab.getNickNm()%> 님</td>
			<td colspan="2" style="font-family: 'Sunflower', sans-serif;"><%=ab.getTitle() %></td>
			<td style="font-family: 'Sunflower', sans-serif; width:200px"><%=ab.getWriteDt() %></td>
		</tr>
	</table>
	<hr style="width:80%">
	<table style="width:80%; margin:0 auto;">
		<tr>
			<td colspan="4">
				<br>
				<div style="width:50%; margin:0 auto;" id="supImg">
					<% if(ac != null){ %>
					<img style="width:400px; height:500px;" src="<%=request.getContextPath()%>/support_uploadFiles/<%=ac.getChangeNm()%>">
					<% }else{%>
					<h2>사진없음</h2>
					<% } %>
				</div>
				<br>
			</td>
		</tr>
		<tr>
			<td colspan="4" style="font-family: 'Sunflower', sans-serif;">
				<br>
				<div style="border:1px solid lightgray;">
					<%=ab.getAdBoardCon()%>
				</div>
				<br>
			</td>
		</tr>
	</table>

</div>

<script type="text/javascript">
		function print() {
			var initBody = document.body.innerHTML;
			window.onbeforeprint = function() {
				document.body.innerHTML = document.getElementById('#supImg').innerHTML; //원하는 div 영역 프린트
			}
			window.onafterprint = function() {
				document.body.innerHTML = initBody;
			}
			window.print();
		}
</script>


<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>