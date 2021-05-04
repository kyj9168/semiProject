<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.semi.adminboard.model.vo.AdminBoard, com.kh.semi.adminboard.model.vo.PageInfo"%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
	ArrayList<AdminBoard> list = (ArrayList<AdminBoard>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.div1 {
	overflow: hidden;
	text-overflow: ellipsis;
}

.row {
	width: 100%;
	padding-left: auto;
	padding-right: auto;
}

.title {
	text-align: left;
	margin: 10 20;
	padding-left: 200px;
}


.text {
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 3; /* 라인수 */
	-webkit-box-orient: vertical;
	word-wrap: break-word;
	line-height: 1.2em;
	height: 150px;
	width: 800px;
}

.table{
	text-align: center;
	font-family: 'Sunflower', sans-serif;
}

#serchDiv {
	width:500px;
	margin:0 auto;
}

#serchTable {
	margin:0 auto;
}

#writerTable{
	text-align:right;
}

/* div {
	border:1px solid black;
} */
</style>
<title>자유게시판 메인</title>

</head>
<body>

	<div align="center">



			<div class="table" style="padding: 30px; margin:0 auto; width:100%;" id="listArea">
				<div style="width:100%; margin:0 auto;" id="writerTable">
				<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
				<table>
						<tr>
							<td><button class="btn btn-default" onclick="location.href='/sixDestiny/views/member/1_introduce/2_notice/2_write.jsp'">글작성</button></td>
						</tr>
				</table>
				<% } %>
				</div>
				<br>
				<table class="table">
						<tr>
							<td width="30px" style="font-weight:bold;" >No</td>
							<td align="center" style="font-weight:bold;">제목</td>
							<td width="150px" style="font-weight:bold;">작성일</td>
							<td width="150px" style="font-weight:bold;">작성자</td>
							<td width="150px" style="font-weight:bold;">조회수</td>
						</tr>
						<% for(AdminBoard ab : list){ %>
							<tr>
								<td><%= ab.getAdBoardNo() %></td>
								<td><a><%= ab.getTitle() %></a></td>
								<td><%= ab.getWriteDt() %></td>
								<td><%= ab.getNickNm() %></td>
								<td><%= ab.getViewCount() %></td>
							</tr>
						<% } %>
				</table>
			</div>

		</div>


	<!-- 전체div -->

	<br>



	<!-- <ul class="pagination">
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
	</ul> -->

	<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/select.no?currentPage=1'" class="btn btn-default"><<</button>
			<% if(currentPage <= 1){ %>
				<button disabled class="btn btn-default"><</button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/select.no?currentPage=<%=currentPage-1%>'" class="btn btn-default"><</button>
			<% } %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<button disabled class="btn btn-default"><%= p %></button>
			<% 	}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/select.no?currentPage=<%=p%>'" class="btn btn-default"><%=p %></button>
			<%
				}
				}
			%>

			<% if(currentPage >= maxPage){ %>
				<button disabled class="btn btn-default">></button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/select.no?currentPage=<%=currentPage+1%>'" class="btn btn-default">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/select.no?currentPage=<%=maxPage%>'" class="btn btn-default">>></button>
		</div>
		<br>
		 <div align="center" id="serchDiv">
		 <form action="<%=request.getContextPath() %>/searchBoard.sb" method="get">
		<table id="serchTable">
			<tr>
			<td>
			<select style="height: 27px; margin: 8px; font-family: 'Sunflower', sans-serif;">
				<option>제목</option>
			</select>
			</td>
			<td> <span class="glyphicon glyphicon-search"></span> 
			<input type="text" style="width:250px" name="boardsearch">
			<td><button style="height: 27px; margin: 8px; font-family: 'Sunflower', sans-serif;" type="submit">검색</button></td>
				<span></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%-- <% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
				<input type="button" value="글쓰기" onclick="location.href='/sixDestiny/views/member/1_introduce/2_notice/2_write.jsp'">
				<% } %> --%>
			</td>
			</tr>
		</table>
		</form>

	</div>
	<script type="text/javascript">
		$("#listArea a").click(function(){
			var num = $(this).parent().parent().children().eq(0).text();
			console.log(num);
			var root = "<%=request.getContextPath()%>/selectOne.no?num=" +num;
			$(this).attr("href", root)
		});
	</script>

</body>
<%@ include file="../../../common/bottom_Include.jsp"%>
</html>