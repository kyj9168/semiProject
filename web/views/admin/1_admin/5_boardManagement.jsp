<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.adminboard.model.vo.PageInfo, com.kh.semi.adminboard.model.vo.*"%>

<%
	ArrayList<AdminUserBoard> list = (ArrayList<AdminUserBoard>) request.getAttribute("list");
	ArrayList<AdminUserBoard> list2 = (ArrayList<AdminUserBoard>) request.getAttribute("list2");
	ArrayList<Integer> report = (ArrayList<Integer>) request.getAttribute("report");
	ArrayList<Integer> recCount = (ArrayList<Integer>) request.getAttribute("recCount");

	PageInfo pi = (PageInfo) request.getAttribute("pi");
	PageInfo pi2 = (PageInfo) request.getAttribute("pi2");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();

	int listCount2 = pi2.getListCount();
	int currentPage2 = pi2.getCurrentPage();
	int maxPage2 = pi2.getMaxPage();
	int startPage2 = pi2.getStartPage();
	int endPage2 = pi2.getEndPage();
%>
    <%@ include file="/views/common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../common/inner_admin_include.jsp" %>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
   td.adtd{
      border-bottom:1px solid #888;
      height:30px;
   }
th {
	text-align: center;
}

</style>
</head>
<body>


   <br><br>

   <div align="left" style="margin-left:300px;">
      <span><h2>회원 게시글 관리</h2></span>
   </div>

   <table class="table" id="listArea" style=" border-spacing: 0px; width:80%;" align="center">
     	<thead>
      <tr class="adtr" style="background:rgb(220,220,220);">
         <th class="adtd" style="width:100px;">No.</th>
         <th class="adtd" style="width:100px;">게시판 종류</th>
         <th class="adtd" style="width:300px;">게시글제목</th>
         <th class="adtd" style="width:200px;">작성자</th>
         <th class="adtd" style="width:100px;">추천수</th>
         <th class="adtd" style="width:100px;">조회수</th>
      </tr>
      </thead>
      <tbody id="remonebody">
     <%
							for (int i = 0; i < list.size(); i++) {
						%>
						 <tr class="adtr">
							<td class="adtd"><%=list.get(i).getBoardNo()%></td>
							<td class="adtd"><%=list.get(i).getbKind()%></td>
							<td class="adtd"><%=list.get(i).getbNm()%></td>
							<td class="adtd"><%=list.get(i).getbUserNick()%></td>
							<td class="adtd"><%= recCount.get(i) %></td>
							<td class="adtd"><%=list.get(i).getInqCon()%></td>
						</tr>
						<%
							}
						%>
</tbody >
   </table >
   <table align="center">
      <tr>
         <td>
            <select id="selectboard">
            	  <option value="selectAll">전체</option>
                  <option value="selectfree">자유게시판</option>
                  <option value="selectparcelout">분양후기</option>
                  <option value="selectmissing">찾습니다</option>
                  <option value="selectmissing2">보호중입니다</option>
            </select>
         </td>

         <td style="width:900px; text-align:right;">

         <form action="<%= request.getContextPath() %>/searchBoard.sb" method="get">

            <select name="boardsearch">
                  <option value="boardNo">글번호</option>
                  <option value="userNick">작성자</option>
            </select>

            <input type="search" name="keyword">
            <input type="submit" value="검색" id="search">
         </form>
         </td>
      </tr>
   </table>


   <script>


   $(function(){


	   $('#boardsearch').change(function(){
		   var value = $(this).val();

	 	  $('#search').click(function(){
	 		  console.log(value);

	 	  })



	   })


   })



   $(function(){
	  $('#selectboard').change(function(){
		  var data = $(this).val();

		if(data == "selectAll" ){
		  $.ajax({
				url:"AjaxBoard.ab",
				data:{data:data},
				type:"get",
				success:function(data){
					console.log(data);
					console.log(data.pi.currentPage);
					var $tbody = $('#remonebody')

					$tbody.children().remove();


				console.log(data.list);
					for(var i = 0; i < data.list.length; i++){

					 	var $tr = $('<tr class="adtr">');
						var $td1 = $('<td class="adtd">');
						var $td2 = $('<td class="adtd">');
						var $td3 = $('<td class="adtd">');
						var $td4 = $('<td class="adtd">');
						var $td5 = $('<td class="adtd">');
						var $td6 = $('<td class="adtd">');

							$td1.text(data.list[i].boardNo);
							$td2.text(data.list[i].bKind);
							$td3.text(data.list[i].bNm);
							$td4.text(data.list[i].bUserNick);
							$td5.text(data.list[i].recCon);
							$td6.text(data.list[i].inqCon);

							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);

							$tbody.append($tr);


					}

					var currentPage = data.pi.currentPage;
					var getListCount = data.pi.getListCount;
					var limit = data.pi.limit;
					var maxPage = data.pi.maxPage;
					var startPage = data.pi.startPage;
					var endPage = data.pi.endPage;

				 	var $ul = $('<ul>');

					var $li1 = $('<li>');
					var $li2 = $('<li>');
					var $li3 = $('<li>');
					var $li4 = $('<li>');
					var $li5 = $('<li>');

					var $a1 = $('<a>');
					var $a2 = $('<a>');

					var $a4 = $('<a>');
					var $a5 = $('<a>');

					$ul.addClass('pagination');

					$a1.attr({'onclick':'selectall(' + 1 + ', "selectAll" '  + ');'});
					$a1.html('◀◀');
					$li1.append($a1);
					$ul.append($li1);

					$a2.attr({'onclick':'selectall(' + -1 +  ', "selectAll" ' +');'});
					$a2.html('◀');
					$li2.append($a2);
					$ul.append($li2);

					for(var p = startPage; p <= endPage; p++){
						$a3 = $('<a>');
						$a3.attr({'onclick':'selectall(' + p + ', "selectAll" ' + ');'});
						$a3.html(p);
						$li3.append($a3);
					$ul.append($li3);
					}

					$a4.attr({'onclick':'selectall(' + +1 + ', "selectAll" ' + ');'});
					$a4.html('▶');
					$li4.append($a4);
					$ul.append($li4);

					$a5.attr({'onclick':'selectall(' + endPage + ', "selectAll" ' + ');'});
					$a5.html('▶▶');
					$li5.append($a5);
					$ul.append($li5);








					$('.pagingArea').children().remove();
					$('.pagingArea').append($ul);



					$("#listArea td").mouseenter(function(){
						$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
					}).mouseout(function(){
						$(this).parent().css({"background":"#FFF"});
					}).click(function(){
						var num = $(this).parent().children().eq(0).text();
						var kind = $(this).parent().children().eq(1).text();
						var uNo = <%= loginUser.getUserNo() %>

						console.log(num);


						if(kind == "분양후기"){

						location.href="<%=request.getContextPath()%>/selectParceloutOne.tn?num=" + num + "&uNo=" + uNo;

						}else if(kind == "잡담" || kind == "꿀팁" || kind == "자랑"){

						location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num ;

						}else if(kind == "실종"){

							location.href="<%=request.getContextPath()%>/missingSelectOne.bo?num=" + num + "&uu=" + uNo;

							}

					});



				}

			});
		}else if(data == "selectfree"){

			 $.ajax({
					url:"AjaxBoard.ab",
					data:{data:data},
					type:"get",
					success:function(data){
						console.log(data.list);
						var $tbody = $('#remonebody')

						$tbody.children().remove();


					console.log(data.list);
						for(var i = 0; i < data.list.length; i++){

							var $tr = $('<tr class="adtr">');
							var $td1 = $('<td class="adtd">');
							var $td2 = $('<td class="adtd">');
							var $td3 = $('<td class="adtd">');
							var $td4 = $('<td class="adtd">');
							var $td5 = $('<td class="adtd">');
							var $td6 = $('<td class="adtd">');

								$td1.text(data.list[i].boardNo);
								$td2.text(data.list[i].bKind);
								$td3.text(data.list[i].bNm);
								$td4.text(data.list[i].bUserNick);
								$td5.text(data.list[i].recCon);
								$td6.text(data.list[i].inqCon);

								$tr.append($td1);
								$tr.append($td2);
								$tr.append($td3);
								$tr.append($td4);
								$tr.append($td5);
								$tr.append($td6);

								$tbody.append($tr);


						}



						var currentPage = data.pi.currentPage;
						var getListCount = data.pi.getListCount;
						var limit = data.pi.limit;
						var maxPage = data.pi.maxPage;
						var startPage = data.pi.startPage;
						var endPage = data.pi.endPage;

					 	var $ul = $('<ul>');

						var $li1 = $('<li>');
						var $li2 = $('<li>');
						var $li3 = $('<li>');
						var $li4 = $('<li>');
						var $li5 = $('<li>');

						var $a1 = $('<a>');
						var $a2 = $('<a>');

						var $a4 = $('<a>');
						var $a5 = $('<a>');

						$ul.addClass('pagination');

						$a1.attr({'onclick':'selectall(' + 1 + ', "selectfree" '  + ');'});
						$a1.html('◀◀');
						$li1.append($a1);
						$ul.append($li1);

						$a2.attr({'onclick':'selectall(' + -1 +  ', "selectfree" ' +');'});
						$a2.html('◀');
						$li2.append($a2);
						$ul.append($li2);

						for(var p = startPage; p <= endPage; p++){
							$a3 = $('<a>');
							$a3.attr({'onclick':'selectall(' + p + ', "selectfree" ' + ');'});
							$a3.html(p);
							$li3.append($a3);
						$ul.append($li3);
						}

						$a4.attr({'onclick':'selectall(' + +1 + ', "selectfree" ' + ');'});
						$a4.html('▶');
						$li4.append($a4);
						$ul.append($li4);

						$a5.attr({'onclick':'selectall(' + endPage + ', "selectfree" ' + ');'});
						$a5.html('▶▶');
						$li5.append($a5);
						$ul.append($li5);




						$('.pagingArea').children().remove();
						$('.pagingArea').append($ul);

						$("#listArea td").mouseenter(function(){
							$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
						}).mouseout(function(){
							$(this).parent().css({"background":"#FFF"});
						}).click(function(){
							var num = $(this).parent().children().eq(0).text();
							var kind = $(this).parent().children().eq(1).text();
							var uNo = <%= loginUser.getUserNo() %>

							console.log(num);


							if(kind == "잡담" || kind == "꿀팁" || kind == "자랑"){

							location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num ;

							}

						});



					}

				});


		 }else if(data == "selectparcelout"){
			 $.ajax({
					url:"AjaxBoard.ab",
					data:{data:data},
					type:"get",
					success:function(data){
						console.log(data.list);
						var $tbody = $('#remonebody')

						$tbody.children().remove();


					console.log(data.list);
						for(var i = 0; i < data.list.length; i++){

							var $tr = $('<tr class="adtr">');
							var $td1 = $('<td class="adtd">');
							var $td2 = $('<td class="adtd">');
							var $td3 = $('<td class="adtd">');
							var $td4 = $('<td class="adtd">');
							var $td5 = $('<td class="adtd">');
							var $td6 = $('<td class="adtd">');

								$td1.text(data.list[i].boardNo);
								$td2.text(data.list[i].bKind);
								$td3.text(data.list[i].bNm);
								$td4.text(data.list[i].bUserNick);
								$td5.text(data.list[i].recCon);
								$td6.text(data.list[i].inqCon);

								$tr.append($td1);
								$tr.append($td2);
								$tr.append($td3);
								$tr.append($td4);
								$tr.append($td5);
								$tr.append($td6);

								$tbody.append($tr);





						}

						var currentPage = data.pi.currentPage;
						var getListCount = data.pi.getListCount;
						var limit = data.pi.limit;
						var maxPage = data.pi.maxPage;
						var startPage = data.pi.startPage;
						var endPage = data.pi.endPage;

					 	var $ul = $('<ul>');

						var $li1 = $('<li>');
						var $li2 = $('<li>');
						var $li3 = $('<li>');
						var $li4 = $('<li>');
						var $li5 = $('<li>');

						var $a1 = $('<a>');
						var $a2 = $('<a>');

						var $a4 = $('<a>');
						var $a5 = $('<a>');

						$ul.addClass('pagination');

						$a1.attr({'onclick':'selectall(' + 1 + ', "selectparcelout" '  + ');'});
						$a1.html('◀◀');
						$li1.append($a1);
						$ul.append($li1);

						$a2.attr({'onclick':'selectall(' + -1 +  ', "selectparcelout" ' +');'});
						$a2.html('◀');
						$li2.append($a2);
						$ul.append($li2);

						for(var p = startPage; p <= endPage; p++){
							$a3 = $('<a>');
							$a3.attr({'onclick':'selectall(' + p + ', "selectparcelout" ' + ');'});
							$a3.html(p);
							$li3.append($a3);
						$ul.append($li3);
						}

						$a4.attr({'onclick':'selectall(' + +1 + ', "selectparcelout" ' + ');'});
						$a4.html('▶');
						$li4.append($a4);
						$ul.append($li4);

						$a5.attr({'onclick':'selectall(' + endPage + ', "selectparcelout" ' + ');'});
						$a5.html('▶▶');
						$li5.append($a5);
						$ul.append($li5);



						$('.pagingArea').children().remove();
						$('.pagingArea').append($ul);

						$("#listArea td").mouseenter(function(){
							$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
						}).mouseout(function(){
							$(this).parent().css({"background":"#FFF"});
						}).click(function(){
							var num = $(this).parent().children().eq(0).text();
							var kind = $(this).parent().children().eq(1).text();
							var uNo = <%= loginUser.getUserNo() %>

							console.log(num);


							if(kind == "분양후기"){

							location.href="<%=request.getContextPath()%>/selectParceloutOne.tn?num=" + num + "&uNo=" + uNo;

							}
						});



					}

				});

		 }else if(data == "selectmissing"){
			 $.ajax({
					url:"AjaxBoard.ab",
					data:{data:data},
					type:"get",
					success:function(data){
						console.log(data.list);
						var $tbody = $('#remonebody')

						$tbody.children().remove();


					console.log(data.list);
						for(var i = 0; i < data.list.length; i++){

							var $tr = $('<tr class="adtr">');
							var $td1 = $('<td class="adtd">');
							var $td2 = $('<td class="adtd">');
							var $td3 = $('<td class="adtd">');
							var $td4 = $('<td class="adtd">');
							var $td5 = $('<td class="adtd">');
							var $td6 = $('<td class="adtd">');

								$td1.text(data.list[i].boardNo);
								$td2.text(data.list[i].bKind);
								$td3.text(data.list[i].bNm);
								$td4.text(data.list[i].bUserNick);
								$td5.text(data.list[i].recCon);
								$td6.text(data.list[i].inqCon);

								$tr.append($td1);
								$tr.append($td2);
								$tr.append($td3);
								$tr.append($td4);
								$tr.append($td5);
								$tr.append($td6);

								$tbody.append($tr);


						}



						var currentPage = data.pi.currentPage;
						var getListCount = data.pi.getListCount;
						var limit = data.pi.limit;
						var maxPage = data.pi.maxPage;
						var startPage = data.pi.startPage;
						var endPage = data.pi.endPage;

					 	var $ul = $('<ul>');

						var $li1 = $('<li>');
						var $li2 = $('<li>');
						var $li3 = $('<li>');
						var $li4 = $('<li>');
						var $li5 = $('<li>');

						var $a1 = $('<a>');
						var $a2 = $('<a>');

						var $a4 = $('<a>');
						var $a5 = $('<a>');

						$ul.addClass('pagination');

						$a1.attr({'onclick':'selectall(' + 1 + ', "selectmissing" '  + ');'});
						$a1.html('◀◀');
						$li1.append($a1);
						$ul.append($li1);

						$a2.attr({'onclick':'selectall(' + -1 +  ', "selectmissing" ' +');'});
						$a2.html('◀');
						$li2.append($a2);
						$ul.append($li2);

						for(var p = startPage; p <= endPage; p++){
							$a3 = $('<a>');
							$a3.attr({'onclick':'selectall(' + p + ', "selectmissing" ' + ');'});
							$a3.html(p);
							$li3.append($a3);
						$ul.append($li3);
						}

						$a4.attr({'onclick':'selectall(' + +1 + ', "selectmissing" ' + ');'});
						$a4.html('▶');
						$li4.append($a4);
						$ul.append($li4);

						$a5.attr({'onclick':'selectall(' + endPage + ', "selectmissing" ' + ');'});
						$a5.html('▶▶');
						$li5.append($a5);
						$ul.append($li5);



						$('.pagingArea').children().remove();
						$('.pagingArea').append($ul);;

						$("#listArea td").mouseenter(function(){
							$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
						}).mouseout(function(){
							$(this).parent().css({"background":"#FFF"});
						}).click(function(){
							var num = $(this).parent().children().eq(0).text();
							var kind = $(this).parent().children().eq(1).text();
							var uNo = <%= loginUser.getUserNo() %>

							console.log(num);


							if(kind == "실종"){

							location.href="<%=request.getContextPath()%>/missingSelectOne.bo?num=" + num + "&uu=" + uNo;

							}
						});



					}

				});


		 }else if(data == "selectmissing2"){

			 $.ajax({
					url:"AjaxBoard.ab",
					data:{data:data},
					type:"get",
					success:function(data){
						console.log(data.list);
						var $tbody = $('#remonebody')

						$tbody.children().remove();


					console.log(data.list);
						for(var i = 0; i < data.list.length; i++){

							var $tr = $('<tr class="adtr">');
							var $td1 = $('<td class="adtd">');
							var $td2 = $('<td class="adtd">');
							var $td3 = $('<td class="adtd">');
							var $td4 = $('<td class="adtd">');
							var $td5 = $('<td class="adtd">');
							var $td6 = $('<td class="adtd">');

								$td1.text(data.list[i].boardNo);
								$td2.text(data.list[i].bKind);
								$td3.text(data.list[i].bNm);
								$td4.text(data.list[i].bUserNick);
								$td5.text(data.list[i].recCon);
								$td6.text(data.list[i].inqCon);

								$tr.append($td1);
								$tr.append($td2);
								$tr.append($td3);
								$tr.append($td4);
								$tr.append($td5);
								$tr.append($td6);

								$tbody.append($tr);


						}

						var currentPage = data.pi.currentPage;
						var getListCount = data.pi.getListCount;
						var limit = data.pi.limit;
						var maxPage = data.pi.maxPage;
						var startPage = data.pi.startPage;
						var endPage = data.pi.endPage;

					 	var $ul = $('<ul>');

						var $li1 = $('<li>');
						var $li2 = $('<li>');
						var $li3 = $('<li>');
						var $li4 = $('<li>');
						var $li5 = $('<li>');

						var $a1 = $('<a>');
						var $a2 = $('<a>');

						var $a4 = $('<a>');
						var $a5 = $('<a>');

						$ul.addClass('pagination');

						$a1.attr({'onclick':'selectall(' + 1 + ', "selectmissing2" '  + ');'});
						$a1.html('◀◀');
						$li1.append($a1);
						$ul.append($li1);

						$a2.attr({'onclick':'selectall(' + -1 +  ', "selectmissing2" ' +');'});
						$a2.html('◀');
						$li2.append($a2);
						$ul.append($li2);

						for(var p = startPage; p <= endPage; p++){
							$a3 = $('<a>');
							$a3.attr({'onclick':'selectall(' + p + ', "selectmissing2" ' + ');'});
							$a3.html(p);
							$li3.append($a3);
						$ul.append($li3);
						}

						$a4.attr({'onclick':'selectall(' + +1 + ', "selectmissing2" ' + ');'});
						$a4.html('▶');
						$li4.append($a4);
						$ul.append($li4);

						$a5.attr({'onclick':'selectall(' + endPage + ', "selectmissing2" ' + ');'});
						$a5.html('▶▶');
						$li5.append($a5);
						$ul.append($li5);



						$('.pagingArea').children().remove();
						$('.pagingArea').append($ul);


						$("#listArea td").mouseenter(function(){
							$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
						}).mouseout(function(){
							$(this).parent().css({"background":"#FFF"});
						}).click(function(){
							var num = $(this).parent().children().eq(0).text();
							var kind = $(this).parent().children().eq(1).text();
							var uNo = <%= loginUser.getUserNo() %>

							console.log(num);


							if(kind == "실종"){

							location.href="<%=request.getContextPath()%>/missingSelectOne.bo?num=" + num + "&uu=" + uNo;

							}
						});



					}

				});



		 }



	  })
   });


$("#listArea td").mouseenter(function(){
	$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
}).mouseout(function(){
	$(this).parent().css({"background":"#FFF"});
}).click(function(){
	var num = $(this).parent().children().eq(0).text();
	var kind = $(this).parent().children().eq(1).text();
	var uNo = <%= loginUser.getUserNo() %>

	console.log(num);


	if(kind == "분양후기"){

	location.href="<%=request.getContextPath()%>/selectParceloutOne.tn?num=" + num + "&uNo=" + uNo;

	}else if(kind == "실종"){
		location.href="<%=request.getContextPath()%>/missingSelectOne.bo?num=" + num + "&uu=" + uNo;
	}else if(kind == "잡담" || kind == "꿀팁" || kind == "자랑"){

	location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num ;
	}


});



</script>

  <div class="pagingArea" align="center">
		<ul class="pagination">


			<% if(currentPage != 1){ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage=1">◀◀</a></li>

			<% }%>


			<% if(10 >= currentPage){ %>


			<% }else if(currentPage%10 != 0){ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage=<%=(int)(Math.floor(currentPage/10))*10%>">◀</a></li>
			<%}else{ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage=<%=(int)(Math.floor((currentPage-1)/10))*10%>">◀</a></li>
			<%} %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<li ><a style="background:rgb(240,240,240); font-weight:bold;" href="#" disabled><%= p %></a></li>

			<% } else { %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage=<%=p%>" disabled><%= p %></a></li>

			<%
				}
			   }
			%>

			<% if(currentPage >= maxPage){ %>

			<% }else if(Math.floor(maxPage/10)*10 >= currentPage){ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage=<%=(int)(Math.ceil(currentPage/10))*10+11%>">▶</a></li>

			<% }%>

			<% if(currentPage < maxPage){ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage=<%=maxPage%>">▶▶</a></li>
			<%} %>
		</ul>
		</div>

   <br><br>

   <div align="left" style="margin-left:300px;">
      <span><h2>신고 게시글 관리</h2></span>
   </div>

   <table class="adta" style=" border-spacing: 0px;" align="center">
      <tr class="adtr" style="background:rgb(220,220,220);">
         <td class="adtd" style="width:100px;">No.</td>
         <td class="adtd" style="width:300px;">게시판 종류</td>
         <td class="adtd" style="width:500px;">게시글제목</td>
          <td class="adtd" style="width:100px;">작성자</td>
         <td class="adtd" style="width:100px;">신고수</td>
         <td class="adtd" style="width:100px;">작성회원번호</td>
      </tr>
      	<tbody id="listArea2">
         <%
							for (int i = 0; i < list2.size(); i++) {
						%>
						 <tr class="adtr">
							<td class="adtd"><%=list2.get(i).getBoardNo()%></td>
							<td class="adtd"><%=list2.get(i).getbKind()%></td>
							<td class="adtd"><%=list2.get(i).getbNm()%></td>
							<td class="adtd"><%=list2.get(i).getbUserNick()%></td>
							<td class="adtd"><%= report.get(i) %></td>
							<td class="adtd"><%=list2.get(i).getuNo()%></td>
						</tr>
						<%
							}
						%>
		</tbody>
   </table >
   <table align="center">
      <tr>
         <td style="width:1100px; text-align:left;">
            <select id="sortlh">
                  <option value="sortlow">신고 낮은순</option>
                  <option value="sortHigh">신고 높은순</option>
            </select>
         </td>

      </tr>
   </table>
   <script>
   $('#sortlh').change(function(){
	   var data = $(this).val();

	   $.ajax({
		   url:"selectcommentsort.ss",
		   data:{data:data},
		   type:"get",
		   success:function(data){

				var $tbody = $("#listArea2");

				$tbody.children().remove();

				for(var i = 0 ; i < data.length-1; i++){
					var cnt = data.length-1;

					var $tr = $('<tr class="adtr">');
					var $td1 = $('<td class="adtd">');
					var $td2 = $('<td class="adtd">');
					var $td3 = $('<td class="adtd">');
					var $td4 = $('<td class="adtd">');
					var $td5 = $('<td class="adtd">');
					var $td6 = $('<td class="adtd">');

					$td1.append(data[i].boardNo);
					$td2.append(data[i].bKind);
					$td3.append(data[i].bNm);
					$td4.append(data[i].bUserNick);
					$td6.append(data[cnt][i]);
					$td5.append(data[i].uNo);

					$tr.append($td1,$td2,$td3,$td4,$td6,$td5);


					$tbody.append($tr);
				}

				 $("#listArea2 td").mouseenter(function(){
						$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
					}).mouseout(function(){
						$(this).parent().css({"background":"#FFF"});
					}).click(function(){
						var num = $(this).parent().children().eq(0).text();
						var kind = $(this).parent().children().eq(1).text();
						var uNo = <%= loginUser.getUserNo() %>


						if(kind == "분양후기"){

							location.href="<%=request.getContextPath()%>/selectParceloutOne.tn?num=" + num + "&uNo=" + uNo;

							}else if(kind == "실종"){

								location.href="<%=request.getContextPath()%>/missingSelectOne.bo?num=" + num + "&uu=" + uNo;

							}else if(kind == "잡담" || kind == "꿀팁" || kind == "자랑"){

							location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num ;

							}

					});








		   }


	   })



   })



   $("#listArea2 td").mouseenter(function(){
		$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
	}).mouseout(function(){
		$(this).parent().css({"background":"#FFF"});
	}).click(function(){
		var num = $(this).parent().children().eq(0).text();
		var kind = $(this).parent().children().eq(1).text();
		var uNo = <%= loginUser.getUserNo() %>


		if(kind == "분양후기"){

			location.href="<%=request.getContextPath()%>/selectParceloutOne.tn?num=" + num + "&uNo=" + uNo;

			}else if(kind == "실종"){
				location.href="<%=request.getContextPath()%>/missingSelectOne.bo?num=" + num + "&uu=" + uNo;
			}else if(kind == "잡담" || kind == "꿀팁" || kind == "자랑"){

			location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num ;
			}

	});

   </script>
   <ul class="pagination">
     <% if(currentPage2 != 1){ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage1=1">◀◀</a></li>

			<% }%>


			<% if(10 >= currentPage2){ %>


			<% }else if(currentPage2%10 != 0){ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage1=<%=(int)(Math.floor(currentPage/10))*10%>">◀</a></li>
			<%}else{ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage1=<%=(int)(Math.floor((currentPage-1)/10))*10%>">◀</a></li>
			<%} %>

			<% for(int p = startPage2; p <= endPage2; p++){
				if(currentPage == p){
			%>
					<li ><a style="background:rgb(240,240,240); font-weight:bold;" href="#" disabled><%= p %></a></li>

			<% } else { %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage1=<%=p%>" disabled><%= p %></a></li>

			<%
				}
			   }
			%>

			<% if(currentPage2 >= maxPage2){ %>

			<% }else if(Math.floor(maxPage2/10)*10 >= currentPage2){ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage1=<%=(int)(Math.ceil(currentPage/10))*10+11%>">▶</a></li>

			<% }%>

			<% if(currentPage2 < maxPage2){ %>
			<li><a href="<%=request.getContextPath()%>/boardList.ad?currentPage1=<%=maxPage%>">▶▶</a></li>
			<%} %>
   </ul>

   <br><br>

    <script>
   	function selectall(curr ,data){
   		var currentPage = curr;
   		var data = data;

   			$.ajax({
   				url:"AjaxBoard.ab",
   				data:{data:data,currentPage:curr},
   				type:"get",
   				success:function(data){
   					var $tbody = $('#remonebody')

					$tbody.children().remove();


				console.log(data.list);
					for(var i = 0; i < data.list.length; i++){

						var $tr = $('<tr class="adtr">');
						var $td1 = $('<td class="adtd">');
						var $td2 = $('<td class="adtd">');
						var $td3 = $('<td class="adtd">');
						var $td4 = $('<td class="adtd">');
						var $td5 = $('<td class="adtd">');
						var $td6 = $('<td class="adtd">');

							$td1.text(data.list[i].boardNo);
							$td2.text(data.list[i].bKind);
							$td3.text(data.list[i].bNm);
							$td4.text(data.list[i].bUserNick);
							$td5.text(data.list[i].recCon);
							$td6.text(data.list[i].inqCon);

							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);

							$tbody.append($tr);


					}


					$("#listArea td").mouseenter(function(){
						$(this).parent().css({"background":"rgb(240,240,240)", "cursor":"pointer"});
					}).mouseout(function(){
						$(this).parent().css({"background":"#FFF"});
					}).click(function(){
						var num = $(this).parent().children().eq(0).text();
						var kind = $(this).parent().children().eq(1).text();
						var uNo = <%= loginUser.getUserNo() %>

						console.log(num);

						if(kind == "분양후기"){

						location.href="<%=request.getContextPath()%>/selectParceloutOne.tn?num=" + num + "&uNo=" + uNo;

						}else if(kind == "잡담" || kind == "꿀팁" || kind == "자랑"){

						location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num ;

						}else if(kind == "실종"){

						location.href="<%=request.getContextPath()%>/missingSelectOne.bo?num=" + num + "&uu=" + uNo;

						}


					});

   				}





   			});





   	}

   </script>

  <%@ include file="/views/common/bottom_Include.jsp"%>
</body>
</html>