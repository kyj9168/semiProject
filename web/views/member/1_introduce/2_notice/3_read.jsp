<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semi.adminboard.model.vo.*, java.util.* "%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
	AdminBoard ab = (AdminBoard) request.getAttribute("ab");
	String num = (String) request.getParameter("num");
	ArrayList<NoticeAttachment> fileList = (ArrayList<NoticeAttachment>) request.getAttribute("fileList");
%>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 글보기 </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<h2 align="center" style="font-size:2em; font-weight:bold; font-family: 'Sunflower', sans-serif;">공지사항</h2>
<div class="container">
	<%-- <table border="1" width="100%">
		<tr>
			<td colspan="2" style="font-size:2em; font-weight:bold; font-family: 'Sunflower', sans-serif;">
				<%= ab.getTitle() %>
			</td>
		</tr>
		<tr>
			<td rowspan="3" style="font-weight:bold; font-family: 'Sunflower', sans-serif;">
				<%= ab.getNickNm() %>
			</td>
		</tr>
		<tr>
			<td style="font-weight:bold; font-family: 'Sunflower', sans-serif;">
				<%= ab.getWriteDt() %>
			</td>
		</tr>
		<tr>
			<div id="titleImgArea">
				<td rowspan="4"><img id="titleImg" src="<%=request.getContextPath()%>/imageGroupFile/<%%>"></td>
			</div>
		</tr>
		<tr>
			<td style="font-weight:bold; font-family: 'Sunflower', sans-serif;">
				조회수 : <%= ab.getRecCount() %>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="font-family: 'Sunflower', sans-serif; height:500px;">
				<%= ab.getAdBoardCon() %>
			</td>
		</tr>
	</table> --%>
    <table class="table table-hover">
				<thead>
					<tr>
					<td><input style="display: none;" value="<%= ab.getTitle() %>">
					<% if(loginUser != null) {%>
						<input type="hidden" value="<%= loginUser.getUserNo() %>">
					<% } %>
					</td>
						<th style="font-size:1.2em; font-weight:bold; font-family: 'Sunflower', sans-serif;">제목 : <%= ab.getTitle()%></th>
						<th style="font-size:1.2em; font-weight:bold; font-family: 'Sunflower', sans-serif;">작성자 : 관리자</th>
						<th style="font-size:1.2em; font-weight:bold; font-family: 'Sunflower', sans-serif;">작성일 : <%= ab.getWriteDt()%></th>
						<th id="thtest" style="font-size:1.2em; font-weight:bold; font-family: 'Sunflower', sans-serif;">조회수 : <%= ab.getViewCount()%></th>
					</tr>
				</thead>
			</table>
			<hr>
			<div>
				<img style="width:800px; height:auto;" onerror="this.style.display='none'" id="titleImg" src="<%=request.getContextPath()%>/thumbnail_uploadFiles/<%=fileList.get(0).getChangeNm()%>">
			</div>
			<br><br>
			<div>
				<p align="center" id="content" style="font-family: 'Sunflower', sans-serif;"><%=(ab.getAdBoardCon()).replace("\r\n","<br>")%><br/></p>
			</div>
			
			
			
</div>

<%-- <div style="padding: 30px" align="center">
	<img src="/sixDestiny/inputGroupFile/<%= %>" alt="Nature">
	<p style="width:1000px; padding: 80px;">
		<%= ab.getAdBoardCon()%>
	</p>
</div> --%>
	<hr>
	 <div align="center">
	<% if(loginUser != null) { %>
		<% if(loginUser.getUserId().equals("admin")){ %>
			<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif;" onclick="location.href='<%=request.getContextPath()%>/selectNotice.no?num=<%=num %>'">수정하기</button>
		<% } %>
	<% } %>
		<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif;" onclick="location.href='<%=request.getContextPath()%>/select.no'">메뉴로 돌아가기</button>
	</div>


<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>
