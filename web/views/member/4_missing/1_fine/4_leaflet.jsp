<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  import="java.util.*, com.kh.semi.board.missing.model.vo.*"%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
Missing b = (Missing) request.getAttribute("b");
	ArrayList<MissingAttachment> fileList = 
			(ArrayList<MissingAttachment>) request.getAttribute("fileList");
	MissingAttachment titleImg = fileList.get(0);

	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#totaldiv {
	width: 500px;
	height: 820px;
	margin: 0 auto;
	border: 1px solid gray;
	font-family: 'Sunflower', sans-serif;
}
.dd{
	text-align:center;
	margin: auto;
}
.dddd{

text-align:center;


}
</style>
<link rel="stylesheet" href="/css/bootstrap.css">

</head>
<body>

	<div id="totaldiv">
		<table align="center">
			<tr>
				<td><p style="font-size: 30px">강아지를 찾습니다</p></td>
			</tr>
			<tr>
			<div>
				<td><img src="<%=request.getContextPath()%>/thumbnail_uploadFiles/<%=titleImg.getChangeNm()%>" style="height: 300px; width: 300px"></td>
			</div>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><span>연락처 : <%=b.getMissPhone() %></span></td>
			</tr>
			<tr>
				<td><span>사례금: <%=b.getRewardPc() %>만원</span></td>
			</tr>
			<tr>
				<td><span>실종 장소: <%=b.getMissPlace() %><br>
				<%=b.getMissPlaceDetail()%></span></td>
			</tr>
			<tr>
				<td><span>실종 날짜: <%=b.getMissDt() %></span></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><textarea rows="10" cols="50" readonly placeholder="<%=b.getbCon()%>" class="dddd"></textarea></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			
		</table>
	</div>
	<br><br>
	<div class="dd">

				<button  class="dd" onclick="content_print();">출력하기</button>

</div>
	<script>
		function content_print() {

			var initBody = document.body.innerHTML;
			window.onbeforeprint = function() {
				document.body.innerHTML = document.getElementById('totaldiv').innerHTML; //원하는 div 영역 프린트
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