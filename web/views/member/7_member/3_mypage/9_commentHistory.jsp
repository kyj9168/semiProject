<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.board.free.model.vo.*"%>

<%
	ArrayList<Commentub> list = (ArrayList<Commentub>) request.getAttribute("list");
	PageInfoFreeBoard pi = (PageInfoFreeBoard) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
    <%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>

.caption{
  font-size: 20px;
}
#test{
	margin-top: 5%;
}
#test2{
	margin-top:10%
}
#test tr th{
	width: 450px;
}
#test2 tr th{
	width: 300px;
}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%@ include file="../../../common/inner_user_include.jsp" %>
</head>
<body>

<div style="width:60%; text-align:center; margin-left:auto; margin-right:auto;" align="center";>



	<table align="center"  class="table"  id="test2" >
	<caption class="caption"><b>내 댓글 확인</b></caption>
		<thead>
		<tr>
			<th style="text-align:center; width:100px;">게시판 번호</th>
			<th style="text-align:center; width:100px;">게시판 종류</th>
			<th style="text-align:center; width:100px;">게시판 제목</th>
			<th style="text-align:center; width:300px;">댓글 내용</th>
			<th style="text-align:center; width:100px;">작성 날짜</th>
		</tr>
		</thead>
		<tbody>
		<% for(Commentub com : list){ %>
		<tr>
			<td><%= com.getBoardNo() %></td>
			<td><%= com.getBoardKind() %></td>
			<td id="bname"><%= com.getBoardNm() %></td>
			<td><%= com.getCommentCon() %></td>
			<td><%= com.getWriteDay() %></td>
				
		</tr>
		<%} %>
		</tbody>
	</table>


</div>
<%-- 페이징처리 --%>
		<div class="pagingArea" align="center">
		<ul class="pagination">
			
			
			<% if(currentPage != 1){ %>
			<li><a href="<%=request.getContextPath()%>/mypageCom.bo?currentPage=1">◀◀</a></li>
			
			<% }%>
			
			
			<% if(10 >= currentPage){ %>
			
			
			<% }else if(currentPage%10 != 0){ %>
			<li><a href="<%=request.getContextPath()%>/mypageCom.bo?currentPage=<%=(int)(Math.floor(currentPage/10))*10%>">◀</a></li>
			<%}else{ %>
			<li><a href="<%=request.getContextPath()%>/mypageCom.bo?currentPage=<%=(int)(Math.floor((currentPage-1)/10))*10%>">◀</a></li>
			<%} %>
			
			<% for(int p = startPage; p <= endPage; p++){ 
				if(currentPage == p){
			%>
					<li ><a style="background:rgb(240,240,240); font-weight:bold;" href="#" disabled><%= p %></a></li>
					
			<% } else { %>
			<li><a href="<%=request.getContextPath()%>/mypageCom.bo?currentPage=<%=p%>" disabled><%= p %></a></li>
				
			<% 
				}
			   } 
			%>
			
			<% if(currentPage >= maxPage){ %>
			
			<% }else if(Math.floor(maxPage/10)*10 >= currentPage){ %>
			<li><a href="<%=request.getContextPath()%>/mypageCom.bo?currentPage=<%=(int)(Math.ceil(currentPage/10))*10+11%>">▶</a></li>
			
			<% }%>
			
			<% if(currentPage < maxPage){ %>
			<li><a href="<%=request.getContextPath()%>/mypageCom.bo?currentPage=<%=maxPage%>">▶▶</a></li>
			<%} %>
		</ul>
		</div>

<script>

	
	$("#test2 td").mouseenter(function(){
		$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
	}).mouseout(function(){
		$(this).parent().css({"background":"#FFF"});
	}).click(function(){
		var num = $(this).parent().children().eq(0).text();
		
		//console.log(num);
		
		location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num;
	});

	
</script>


<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>