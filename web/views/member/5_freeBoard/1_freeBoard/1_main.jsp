<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.semi.board.free.model.vo.*"%>

<%
	ArrayList<UserBoard> list = (ArrayList<UserBoard>) request.getAttribute("list");
	ArrayList<UserBoard> best = (ArrayList<UserBoard>) request.getAttribute("best");
	String category = request.getParameter("category");
	String search = request.getParameter("search");
	String alignment = request.getParameter("alignment");
	String what = request.getParameter("what");
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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
button.main:hover{
	font-weight: bold;
}




.div1 {
	overflow: hidden;
	text-overflow: ellipsis;
}
.thumbnail:hover{
	background:rgb(240,240,240);
	-webkit-transform:scale(1.1);
	border-radius:15px;
	font-weight:bold;
	-webkit-transition:0.2s;
	
}

.thumbnail{

	-webkit-transition:0.2s;
}

p {
	margin: 0px;
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

div {
	font-family: 'Sunflower', sans-serif;
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

.thumbnail .caption p {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 110px;
	height: 37px;
	display: block;
	padding: 12px;
}

th {
	text-align: center;
}
.pagination li a.on { background:rgb(240,240,240); font-weight:bold; }
</style>
<title>자유게시판 메인</title>

</head>
<body>

	<div style="height: 700px;">
		<h3>인기글 BEST 5</h3>
		<hr>

		<div class="container" style="height: 1000px; width: 70%;">

			<div class="row" style="margin-left: 89px;">
				<%
					for (UserBoard ubbest : best) {
				%>
				<div class="col-md-2">
					<div class="thumbnail"
						style="width: 150px; height: 150px; padding: 0px; margin:0px;">


						<div class="caption" style="padding:18px;">
							<a style="text-decoration:none;"
								href="<%=request.getContextPath()%>/selectOne.bo?num=<%=ubbest.getbNo()%>">
								<p>
									제목:
									<%=ubbest.getbNm()%></p>
								<p>
									카테고리:
									<%=ubbest.getbKind()%></p>
								<p>
									추천수 :
									<%=ubbest.getRecCon()%>
								</p>
						</div>
						</a>
					</div>
				</div>
				<%
					}
				%>
			</div>



			<div style="padding: 30px">

				<div align="right">
					<input type="hidden" value=<%=category %> id="categoryval">
					<select name=category id="categorysel" onchange="letitgo()">
						<option class="optionsel" value="all" >전체</option>
						<option class="optionsel" value="bragging" >자랑</option>
						<option class="optionsel" value="tip">꿀팁</option>
						<option class="optionsel" value="chat">잡담</option>
					</select> 
					<input type="hidden" value=<%=alignment %> id="alignmentval">
					<select id="alignment"  onchange="letitgo()">
						<option value="date">날짜순</option>
						<option value="recommend">추천순</option>
						<option value="inquiry">조회순</option>
					</select>
				</div>
				<table class="table" id="listArea">
					<thead>
						<tr>
							<th width="50px;">No</th>
							<th width="70px;">카테고리</th>
							<th width="200px;">제목</th>
							<th width="70px;">작성자</th>
							<th width="100px;">날짜</th>
							<th width="50px;">조회수</th>
							<th width="50px;">추천수</th>
						</tr>
					</thead>
					<tbody id="remonebody">
						<%
							for (UserBoard ub : list) {
								
						%>
						<tr>
							<td><%=ub.getbNo()%></td>
							<td><%=ub.getbKind()%></td>
							<td id="bname"><%=ub.getbNm()%></td>
							<td><%=ub.getbUserNick()%></td>
							<td><%=ub.getbDate()%></td>
							<td><%=ub.getInqCon()%></td>
							<td id="recCount"><%=ub.getRecCon()%></td>
							
		
							</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>

		</div>

	</div>
	<!-- 전체div -->


	<div align="left" style="margin-left:300px">
	
		<input type="hidden" value=<%=what %> id="whatval">
		<select style="height: 27px; margin: 8px" id="what">
			<option class="search" value="writer">작성자</option>
			<option class="search" value="title">제목</option>
			<option class="search" value="ticon">제목+내용</option>
		</select> <span class="glyphicon glyphicon-search"
			style="display: inline-block; margin-right: 400px;"> 
			<%if(search.equals("")){ %>
			<input type="text" onkeyup="searchstart()" Placeholder="검색" style="width: 250px" name="search" id="searchtext">
			<%}else{ %>
			<input type="text" onkeyup="searchstart()" value=<%=search %> Placeholder="검색" style="width: 250px" name="search" id="searchtext">
			<%} %>
			<button class="main" id="mainsearch" type="button" onclick="letitgo()">검색</button>
		</span>
	
		<%
			if (loginUser != null) {
		%>
		<button class="main"
			onclick="location.href='/sixDestiny/views/member/5_freeBoard/1_freeBoard/2_write.jsp'">글쓰기</button>
		<%
			}
		%>


	</div>
	

	<%-- 페이징처리 --%>

	<div class="pagingArea" align="center">
		<ul class="pagination">


			<%
				if (currentPage != 1) {
			%>
			<li><a
				href="<%=request.getContextPath()%>/selectList.bo?what=<%=what%>&search=<%=search %>&alignment=<%=alignment %>&category=<%=category %>&currentPage=1">◀◀</a></li>

			<%
				}
			%>


			<%
				if (10 >= currentPage) {
			%>


			<%
				} else if (currentPage % 10 != 0) {
			%>
			<li><a
				href="<%=request.getContextPath()%>/selectList.bo?what=<%=what%>&search=<%=search %>&alignment=<%=alignment %>&category=<%=category %>&currentPage=<%=(int) (Math.floor(currentPage / 10)) * 10%>">◀</a></li>
			<%
				} else {
			%>
			<li><a
				href="<%=request.getContextPath()%>/selectList.bo?what=<%=what%>&search=<%=search %>&alignment=<%=alignment %>&category=<%=category %>&currentPage=<%=(int) (Math.floor((currentPage - 1) / 10)) * 10%>">◀</a></li>
			<%
				}
			%>

			<%
				for (int p = startPage; p <= endPage; p++) {
					if (currentPage == p) {
			%>
			<li><a
				style="background: rgb(240, 240, 240); font-weight: bold;" href="#"
				disabled><%=p%></a></li>

			<%
				} else {
			%>
			<li><a
				href="<%=request.getContextPath()%>/selectList.bo?what=<%=what%>&search=<%=search %>&alignment=<%=alignment %>&category=<%=category %>&currentPage=<%=p%>"
				disabled><%=p%></a></li>

			<%
				}
				}
			%>

			<%
				if (currentPage >= maxPage) {
			%>

			<%
				} else if (Math.floor(maxPage / 10) * 10 >= currentPage) {
			%>
			<li><a
				href="<%=request.getContextPath()%>/selectList.bo?what=<%=what%>&search=<%=search %>&alignment=<%=alignment %>&category=<%=category %>&currentPage=<%=(int) (Math.ceil(currentPage / 10)) * 10 + 11%>">▶</a></li>

			<%
				}
			%>

			<%
				if (currentPage < maxPage) {
			%>
			<li><a
				href="<%=request.getContextPath()%>/selectList.bo?what=<%=what%>&search=<%=search %>&alignment=<%=alignment %>&category=<%=category %>&currentPage=<%=maxPage%>">▶▶</a></li>
			<%
				}
			%>
		</ul>
	</div>
	

	<script>
	
	
		// document Ready
		$(function() {
			initListTd();	// td 이벤트 세팅
			initCaption();	// 인기글 이벤트 세팅
			
			 $("#searchtext").keypress(function (e) {
			       if ($("#searchtext").val() != ""){
			    		 if (e.which == 13){
			    			 letitgo()
					        }
			       }
			
				 
			    });
			
			$("#categorysel").val($("#categoryval").val()).attr("selected", "selected");
			$("#alignment").val($("#alignmentval").val()).attr("selected", "selected");
			$("#what").val($("#whatval").val()).attr("selected", "selected");
			  
			  if($("#searchtext" ).val()== ''){
				  $("button#mainsearch").css("color","white").attr('disabled',true);
				  $("#searchtext").val('');
			  }
			  console.log($("#searchtext").val());
		});

		// td 이벤트 세팅
		function initListTd() {
			$("#listArea td")
			.mouseenter(function(){
				$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer","font-weight":"bold" , "-webkit-transition":"background 0.2s"});
			})
			.mouseout(function(){
				$(this).parent().css({"background":"#FFF","font-weight":"normal" , "-webkit-transition":"background 0.2s"});
			})
			.click(function(){
				var num = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num;
				count(num);
			});
		}
		
		// 인기글 이벤트 세팅
		function initCaption() {
			$(".caption a")
			.click(function(){
				var num = $(this).val();
				location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num;
			});
			
			
			
		}
		
		function searchstart(){
			$("button#mainsearch").css("color","black").attr('disabled',false)
			if($("#searchtext" ).val()== ""){
				  $("button#mainsearch").css("color","white").attr('disabled',true);
				
			  }
		}
		function letitgo(){
			if($("#searchtext").val()==""){
				location.href="selectList.bo?what="+$("#what option:selected").val()+"&search=&alignment="+$("#alignment option:selected").val()+"&category="+$("#categorysel option:selected").val()+"&currentPage=1";
			}else{
				location.href="selectList.bo?what="+$("#what option:selected").val()+"&search="+$("#searchtext").val()+"&alignment="+$("#alignment option:selected").val()+"&category="+$("#categorysel option:selected").val()+"&currentPage=1";
			}
			
			
		}
		
		function count(num){
			var thisBoardNo = num
			
			 $.ajax({
					url:"countRec.ub",
					data:{thisBoardNo:thisBoardNo},
					type:"get",
					success:function(data){
						
						console.log("성공")
					}
				})
		
	}
		
		


	</script>


	<%@ include file="../../../common/bottom_Include.jsp"%>


</body>
</html>