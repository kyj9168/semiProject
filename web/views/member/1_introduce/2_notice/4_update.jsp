<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semi.adminboard.model.vo.* , java.util.*"%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
	HashMap<String, Object> ab = (HashMap<String, Object>)request.getAttribute("ab");

	AdminBoard ab1 = (AdminBoard) ab.get("board");
%>
<html>
<head>
<title>Insert title here</title>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>

#writerTable {
	margin: 0 auto;
}

</style>


</head>
<body>
<% if(loginUser != null && loginUser.getUserId().equals("admin")) %>
	<form action="/sixDestiny/update.no" method="post" id="updateForm" name="deleteNotice">
		<div>
		<h4 style="font-family: 'Sunflower', sans-serif;">공지사항 수정</h4>
		<br><br>
			<table width="800px" id="writerTable">
				<tr>
					<td><label style="font-family: 'Sunflower', sans-serif; font-size:20px;" >제목
						&nbsp;</label><input type="text" style="width:750px; height:40px" name="title" value="<%=ab1.getTitle()%>"></td>
					<input type="hidden" value="<%=loginUser.getUserNo()%>" name="userNo" readonly>
					<input type="hidden" value="<%=ab1.getAdBoardNo()%>" name="adBoardNo">
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><textarea align="center" rows="15" cols="106" name="adBoardCon">
					<%=ab1.getAdBoardCon()%>
					</textarea></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				
			</table>
		</div>

		<br> <br> <!-- <input type="submit" value="등록하기" class="btn btn-info" style="font-family: 'Sunflower', sans-serif;"></input> -->
		<div align="center">
			<input type="button" class="btn btn-info"  style="font-family: 'Sunflower', sans-serif"  onclick="complete();" value="작성하기"></button>

			<input type="button" class="btn btn-info" style="font-family: 'Sunflower', sans-serif"  onclick="deleteNotice1(<%=ab1.getAdBoardNo()%>);" value="삭제하기"></button>
		</div>
	</form>
	<script>
	 	function complete(){
			document.deleteNotice.submit();
		} 
		function deleteNotice1(adBoardNo){
			console.log("호출");
			var adBoardNo = adBoardNo;
			$.ajax({
				url:"/sixDestiny/deleteNotice.no",
				type:"post",
				data:{adBoardNo:adBoardNo},
				success:function(data){
					location.href="/sixDestiny/select.no"
				}
			});
		}
		
		
	</script>
	<!-- <script>
		$('.starRev span').click(function() {
			$(this).parent().children('span').removeClass('on');
			$(this).addClass('on').prevAll('span').addClass('on');
			return false;
		});
	</script> -->
	
	<%@ include file="../../../common/bottom_Include.jsp"%>


</body>
</html>