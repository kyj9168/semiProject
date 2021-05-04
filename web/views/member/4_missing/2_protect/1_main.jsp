<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.*, com.kh.semi.board.missing.model.vo.*"%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
   ArrayList<HashMap<String, Object>> list =
         (ArrayList<HashMap<String, Object>>) request.getAttribute("list");

MissingPageInfo pi = (MissingPageInfo) request.getAttribute("pi");
int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();

%>
<!DOCTYPE htm>
<html>

<head>
<meta charset=UTF-8">
<title>Insert title here</title>

<!-- jQuery -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>



<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
table tr td img {
	margin: 10px;
}
.thumb-list {
		width:220px;
		border:1px solid white;
		display:inline-block;

		   margin: 10px;
	}
	.title{
	
	  width: 220px; 
	  height: 220px; 
	
	  align:center;
	}
	

</style>


</head>
<body>


	<div class="container" role="main" style="margin-top: 100px;">

		<h1 style="margin-bottom: 50px; display: inline-block;">강아지를 찾습니다</h1>
		<table align="center">
			<tr>
				<td style="padding: 20px;">
					<h3>실종 강아지를 보호중입니다.</h3>
				</td>
				<td style="padding: 20px;">
									<% if(loginUser != null){ %>
<button type="button" class="btn btn-sm btn-primary" onclick="location.href='/sixDestiny/views/member/4_missing/2_protect/2_write.jsp'">글쓰기</button>
				<% }else{

				%>	<button type="button" onclick='alert("로그인하셔야 사용 가능합니다.")' class="btn btn-sm btn-primary">글쓰기</button>

				<%  } %>

				</td>
				<td style="padding: 20px;"><span>지역</span> <select id="li1">
						<option selected="selected">전체</option>
		<option value="서울시">서울시</option>
                  <option value="인천시">인천시</option>
                  <option value="대전시">대전시</option>
                  <option value="울산시">울산시</option>
                  <option value="부산시">부산시</option>
                  <option value="경기도">경기도</option>
                  <option value="강원도">강원도</option>
                  <option value="세종시">세종시</option>
                  <option value="충정남도">충정남도</option>
                  <option value="충정북도">충정북도</option>
                  <option value="전라남도">전라남도</option>
                  <option value="전라북도">전라북도</option>
                  <option value="경상남도">경상남도</option>
                  <option value="경상북도">경상북도</option>
                  <option value="제주도">제주도</option>
				</select></td>
				<td style="padding: 20px;"><span>성별</span> <select id="li2">
						<option selected="selected">전체</option>
					       <option value="수컷">수컷</option>
                  <option value="암컷">암컷</option>
				</select></td>
				<td style="padding: 20px;"><span>날짜순</span> <select id="li3">
				    <option selected="selected" value="최신순">최신순</option>
                  <option value="오래된순">오래된순</option>
				</select></td>
			</tr>

		</table>
  <div class="ddd"> 
         <%
            for (int i = 0; i < list.size(); i++) {
               HashMap<String, Object> hmap = list.get(i);
         %>
<table class="thumb-list">

         <tr>
        
         <td >
         <div class="title">
            <input type="hidden" value="<%=hmap.get("boardNo")%>" id="Bno">
            <%System.out.print(hmap.get("boardNo")) ;%>
<%if(hmap.get("changeNm") !=null){ %>
            <img src="/sixDestiny/thumbnail_uploadFiles/<%=hmap.get("changeNm")%>"
               style="width: 200px; height: 200px; cursor: pointer;">
              <%}else{ %> 
      
               <% }%>
               </div>
               </td>
         </tr>


         <tr>
            <td ><%=hmap.get("boardNm")%></td>
         </tr>


         <tr>
            <td>성별 : <%=hmap.get("gender")%></td>
         </tr>        
          <%
            }
         %>
               </table>
               
                  </div> 
            
      
               <script>
      $(function() {
         $(".title").click( function() {
        	 <%if(loginUser!=null){%>
        	 	var num=     $(this).children().eq(0).val();
        	 	var uu= $(this).children().eq(1).val();

        	                           console.log(uu);
        	                
        	                     

        	   location.href = "<%=request.getContextPath()%>/proSelectOne.bo?num="+num+"&uu="+uu;
        	   
        		 <%}else{%>
        			var num=     $(this).children().eq(0).val();
        		 

   location.href = "<%=request.getContextPath()%>/proSelectOne.bo?num=" + num ;
	 <%}%>
        		 
        		 });
         });
      </script>
      

      <div class="container" align="center" style="width: 500px;">
 <form  action="<%=request.getContextPath() %>/prosearch.bo" method="post" >
         <table>
            <tr>
        <td><select
                  style="height: 30px; margin-left: 20px; margin-right: 20px;" name="searchVal">
                     <option selected="selected" value="전체">전체</option>
                     <option vlaue="작성자">작성자</option>
                     <option vlaue="제목">제목</option>
               </select></td>
               <td>

                     <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search"
                           name="search">
                                                   <%
            for (int i = 0; i < list.size(); i++) {
               HashMap<String, Object> hmap = list.get(i);
         %>
                                      <input type="hidden" value="<%=hmap.get("boardNo")%>" name="num">
                                      <%} %>
                        <div class="input-group-btn">
                           <button class="btn btn-default" type="submit">
                              <i class="glyphicon glyphicon-search"></i>
                           </button>
                        </div>
                     </div>
                  </form>
               </td>
            </tr>
         </table>


      </div>

</div>
</form>
	<div class="paging" align="center">
			<button  class="paging" onclick="location.href='<%=request.getContextPath() %>/proListo.bo?currentPage=1'"><<</button>

			<% if(currentPage <= 1)  { %>

				<button  class="paging" disabled><</button>

			<% } else { %>
				<button  class="paging" onclick="location.href='<%= request.getContextPath() %>/proListo.bo?currentPage=<%= currentPage -1%>'"><</button>

			<% } %>

			<% for(int p = startPage; p <= endPage; p++){
					if(currentPage == p){
				%>
					<button class="paging" disabled><%= p %></button>


					<% }else{ %>
					<button  class="paging" onclick="location.href='<%=request.getContextPath() %>/proListo.bo?currentPage=<%= p %>'"><%= p %></button>

			<%
				}
					} %>



			<% if(currentPage >= maxPage){ %>
				<button  class="pagination" disabled>></button>
			<% }else{ %>
				<button  class="pagination" onclick="location.href='<%=request.getContextPath() %>/proListo.bo?currentPage=<%= currentPage + 1 %>'">></button>
			<% } %> 
			</div>

<script>
$("#li1").change(function(){
		var li = $("#li1").val();
		
		
		$.ajax({
			url:"proorder.bo",
			data:{li:li},
			type:"get",
			success:function(data){
				console.log(data);
				var $div = $(".ddd");
				$div.html("");
	
		  		var $page=	$("#paging");
			$page.html("");
			
				/* var lastkey=data.length-1; */
				
			for(var i=0;i<data.length-1;i++){
				
					var $table=$("<table>").addClass("thumb-list");
					var $div2=$("<div>");
					
					var $tr1 = $("<tr>");
					var $tr2 = $("<tr>");
					//var $tr3 = $("<tr>");
					var $tr4 = $("<tr>");
					var $tr5 = $("<tr>");
					var $br = $("<br>");
					var $image = $("<td>");	
					$image.append($div2);
					$div2.html('<img src="/sixDestiny/thumbnail_uploadFiles/'+data[i].changeNm+'" style="width:100%; height:100%">').css({"width":"200","height":"200"});
					$div2.addClass("title");
			
					$tr5.append($br);
					var $boardNm = $("<td>").text(data[i].boardNm).css("width", "100px");
					var $gender =  $("<td>").text("성별"+data[i].gender).css("width", "100px");
					$tr1.append($image);
			
					$tr2.append($boardNm);
					//$tr2.addClass($div2);
					//$tr3.append($reward);
					$tr4.append($gender);
			
					$table.append($tr1,$tr5,$tr2,$tr4);
					$(".ddd").append($table);
					
					$table.filter(function(){
						var key2 = i;
						$(this).click(function(){
							location.href = "<%=request.getContextPath()%>/missingSelectOne.bo?num=" + data[key2].boardNo ;
						})
					})
							}
			var $vava=$("<br>");
			
			$page.append($vava);
				
					var $btn2=$("<button  class='paging'>");
					var btnvalue2 = $btn2.text('<<');
						$page.append($btn2);
					
				for(var p = data[data.length-1].startPage; p < data[data.length-1].endPage; p++){
					
				var $btn1 = $("<button  class='paging'>");
				var $btn2 = $("<button  class='paging'>");
				console.log("p : " + p);
	

					var btnvalue = $btn1.text(p);
						$page.append($btn1);
					
					$btn1.click(function(){
				   		var result = $(this).text();
						
						$.ajax({
			   				url:"proorder.bo",
			   				data:{li:li, currentPage:result},
			   				type:"get",
			   				success:function(data){
			   					console.log("psadfafaae:  "+result);
								var $div = $(".ddd");
	   							$div.html("");
			   					for(var i=0;i<data.length-1;i++){
			   	   					
			   						var $table=$("<table>").addClass("thumb-list");
			   						var $div2=$("<div>");
			   						
			   						var $tr1 = $("<tr>");
			   						var $tr2 = $("<tr>");
			   						//var $tr3 = $("<tr>");
			   						var $tr4 = $("<tr>");
			   						var $tr5 = $("<tr>");
			   						var $br = $("<br>");
			   						var $image = $("<td>");	
			   						$image.append($div2);
			   						$div2.html('<img src="/sixDestiny/thumbnail_uploadFiles/'+data[i].changeNm+'" style="width:100%; height:100%">').css({"width":"200","height":"200"});
			   						$div2.addClass("title");
			   				
			   						$tr5.append($br);
			   						var $boardNm = $("<td>").text(data[i].boardNm).css("width", "100px");
			   						var $gender =  $("<td>").text("성별"+data[i].gender).css("width", "100px");
			   						$tr1.append($image);
			   						
			   						$tr2.append($boardNm);
			   						//$tr2.addClass($div2);
			   						//$tr3.append($reward);
			   						$tr4.append($gender);
			   				
			   						$table.append($tr1,$tr5,$tr2,$tr4);
			   						$(".ddd").append($table);
			   						
			   						
			   						$table.filter(function(){
			   							var key2 = i;
			   							$(this).click(function(){
			   								location.href = "<%=request.getContextPath()%>/missingSelectOne.bo?num=" + data[key2].boardNo ;
			   							})
			   						})
			   								}
			   				
			   				}
			   				
			   				
			   				
			   				});	
						
					});	
					
					
				}
				
					var $btn3=$("<button  class='paging'>");
					var btnvalue3 = $btn3.text('>>');
					$page.append($btn3);
				
			

				$btn2.click(function(){
   		
					
					$.ajax({
		   				url:"proorder.bo",
		   				data:{li:li, currentPage:1},
		   				type:"get",
		   				success:function(data){
		   					
							var $div = $(".ddd");
   							$div.html("");
		   					for(var i=0;i<data.length-1;i++){
		   	   					
		   						var $table=$("<table>").addClass("thumb-list");
		   						var $div2=$("<div>");
		   						
		   						var $tr1 = $("<tr>");
		   						var $tr2 = $("<tr>");
		   					//	var $tr3 = $("<tr>");
		   						var $tr4 = $("<tr>");
		   						var $tr5 = $("<tr>");
		   						var $br = $("<br>");
		   						var $image = $("<td>");	
		   						$image.append($div2);
		   						$div2.html('<img src="/sixDestiny/thumbnail_uploadFiles/'+data[i].changeNm+'" style="width:100%; height:100%">').css({"width":"200","height":"200"});
		   						$div2.addClass("title");
		   				
		   						$tr5.append($br);
		   						var $boardNm = $("<td>").text(data[i].boardNm).css("width", "100px");
		   						var $gender =  $("<td>").text("성별"+data[i].gender).css("width", "100px");
		   						$tr1.append($image);
		   						
		   						$tr2.append($boardNm);
		   						//$tr2.addClass($div2);
		   						$tr3.append($reward);
		   						$tr4.append($gender);
		   				
		   						$table.append($tr1,$tr5,$tr2,$tr4);
		   						$(".ddd").append($table);
		   						
		   						
		   						$table.filter(function(){
		   							var key2 = i;
		   							$(this).click(function(){
		   								location.href = "<%=request.getContextPath()%>/missingSelectOne.bo?num=" + data[key2].boardNo ;
		   							})
		   						})
		   								}
		   				
		   				}
		   				
		   				
		   				
		   				});	
				
				

				
			
			
			});
			
		
			
				
				
			},
			error:function(err){
				console.log("서버 전송 실패!");
			},
			complete:function(data){
				console.log("무조건 호출되는 함수");
			}
		});
 });
 
 
 
$("#li2").change(function(){
		var li = $("#li2").val();
		
		
		$.ajax({
			url:"proorder.bo",
			data:{li:li},
			type:"get",
			success:function(data){
				console.log(data);
				var $div = $(".ddd");
				$div.html("");
	
		  		var $page=	$("#paging");
			$page.html("");
			
				/* var lastkey=data.length-1; */
				
			for(var i=0;i<data.length-1;i++){
				
					var $table=$("<table>").addClass("thumb-list");
					var $div2=$("<div>");
					
					var $tr1 = $("<tr>");
					var $tr2 = $("<tr>");
					//var $tr3 = $("<tr>");
					var $tr4 = $("<tr>");
					var $tr5 = $("<tr>");
					var $br = $("<br>");
					var $image = $("<td>");	
					$image.append($div2);
					$div2.html('<img src="/sixDestiny/thumbnail_uploadFiles/'+data[i].changeNm+'" style="width:100%; height:100%">').css({"width":"200","height":"200"});
					$div2.addClass("title");
			
					$tr5.append($br);
					var $boardNm = $("<td>").text(data[i].boardNm).css("width", "100px");
					var $gender =  $("<td>").text("성별"+data[i].gender).css("width", "100px");
					$tr1.append($image);
			
					$tr2.append($boardNm);
					//$tr2.addClass($div2);
					//$tr3.append($reward);
					$tr4.append($gender);
			
					$table.append($tr1,$tr5,$tr2,$tr4);
					$(".ddd").append($table);
					
					$table.filter(function(){
						var key2 = i;
						$(this).click(function(){
							location.href = "<%=request.getContextPath()%>/missingSelectOne.bo?num=" + data[key2].boardNo ;
						})
					})
							}
			var $vava=$("<br>");
			
			$page.append($vava);
				
					var $btn2=$("<button  class='paging'>");
					var btnvalue2 = $btn2.text('<<');
						$page.append($btn2);
					
				for(var p = data[data.length-1].startPage; p < data[data.length-1].endPage; p++){
					
				var $btn1 = $("<button  class='paging'>");
				var $btn2 = $("<button  class='paging'>");
				console.log("p : " + p);
	

					var btnvalue = $btn1.text(p);
						$page.append($btn1);
					
					$btn1.click(function(){
				   		var result = $(this).text();
						
						$.ajax({
			   				url:"proorder.bo",
			   				data:{li:li, currentPage:result},
			   				type:"get",
			   				success:function(data){
			   					console.log("psadfafaae:  "+result);
								var $div = $(".ddd");
	   							$div.html("");
			   					for(var i=0;i<data.length-1;i++){
			   	   					
			   						var $table=$("<table>").addClass("thumb-list");
			   						var $div2=$("<div>");
			   						
			   						var $tr1 = $("<tr>");
			   						var $tr2 = $("<tr>");
			   						//var $tr3 = $("<tr>");
			   						var $tr4 = $("<tr>");
			   						var $tr5 = $("<tr>");
			   						var $br = $("<br>");
			   						var $image = $("<td>");	
			   						$image.append($div2);
			   						$div2.html('<img src="/sixDestiny/thumbnail_uploadFiles/'+data[i].changeNm+'" style="width:100%; height:100%">').css({"width":"200","height":"200"});
			   						$div2.addClass("title");
			   				
			   						$tr5.append($br);
			   						var $boardNm = $("<td>").text(data[i].boardNm).css("width", "100px");
			   						var $gender =  $("<td>").text("성별"+data[i].gender).css("width", "100px");
			   						$tr1.append($image);
			   						
			   						$tr2.append($boardNm);
			   						//$tr2.addClass($div2);
			   					//	$tr3.append($reward);
			   						$tr4.append($gender);
			   				
			   						$table.append($tr1,$tr5,$tr2,$tr4);
			   						$(".ddd").append($table);
			   						
			   						
			   						$table.filter(function(){
			   							var key2 = i;
			   							$(this).click(function(){
			   								location.href = "<%=request.getContextPath()%>/missingSelectOne.bo?num=" + data[key2].boardNo ;
			   							})
			   						})
			   								}
			   				
			   				}
			   				
			   				
			   				
			   				});	
						
					});	
					
					
				}
				
					var $btn3=$("<button  class='paging'>");
					var btnvalue3 = $btn3.text('>>');
					$page.append($btn3);
				
			

				$btn2.click(function(){
   		
					
					$.ajax({
		   				url:"proorder.bo",
		   				data:{li:li, currentPage:1},
		   				type:"get",
		   				success:function(data){
		   					
							var $div = $(".ddd");
   							$div.html("");
		   					for(var i=0;i<data.length-1;i++){
		   	   					
		   						var $table=$("<table>").addClass("thumb-list");
		   						var $div2=$("<div>");
		   						
		   						var $tr1 = $("<tr>");
		   						var $tr2 = $("<tr>");
		   						//var $tr3 = $("<tr>");
		   						var $tr4 = $("<tr>");
		   						var $tr5 = $("<tr>");
		   						var $br = $("<br>");
		   						var $image = $("<td>");	
		   						$image.append($div2);
		   						$div2.html('<img src="/sixDestiny/thumbnail_uploadFiles/'+data[i].changeNm+'" style="width:100%; height:100%">').css({"width":"200","height":"200"});
		   						$div2.addClass("title");
		   				
		   						$tr5.append($br);
		   						var $boardNm = $("<td>").text(data[i].boardNm).css("width", "100px");
		   						var $gender =  $("<td>").text("성별"+data[i].gender).css("width", "100px");
		   						$tr1.append($image);
		   						
		   						$tr2.append($boardNm);
		   						//$tr2.addClass($div2);
		   					//	$tr3.append($reward);
		   						$tr4.append($gender);
		   				
		   						$table.append($tr1,$tr5,$tr2,$tr4);
		   						$(".ddd").append($table);
		   						
		   						
		   						$table.filter(function(){
		   							var key2 = i;
		   							$(this).click(function(){
		   								location.href = "<%=request.getContextPath()%>/missingSelectOne.bo?num=" + data[key2].boardNo ;
		   							})
		   						})
		   								}
		   				
		   				}
		   				
		   				
		   				
		   				});	
				
				

				
			
			
			});
			
		
			
				
				
			},
			error:function(err){
				console.log("서버 전송 실패!");
			},
			complete:function(data){
				console.log("무조건 호출되는 함수");
			}
		});
 });
 
 
 
$("#li3").change(function(){
		var li = $("#li3").val();
		
		
		$.ajax({
			url:"proorder.bo",
			data:{li:li},
			type:"get",
			success:function(data){
				console.log(data);
				var $div = $(".ddd");
				$div.html("");
	
		  		var $page=	$("#paging");
			$page.html("");
			
				/* var lastkey=data.length-1; */
				
			for(var i=0;i<data.length-1;i++){
				
					var $table=$("<table>").addClass("thumb-list");
					var $div2=$("<div>");
					
					var $tr1 = $("<tr>");
					var $tr2 = $("<tr>");
					//var $tr3 = $("<tr>");
					var $tr4 = $("<tr>");
					var $tr5 = $("<tr>");
					var $br = $("<br>");
					var $image = $("<td>");	
					$image.append($div2);
					$div2.html('<img src="/sixDestiny/thumbnail_uploadFiles/'+data[i].changeNm+'" style="width:100%; height:100%">').css({"width":"200","height":"200"});
					$div2.addClass("title");
			
					$tr5.append($br);
					var $boardNm = $("<td>").text(data[i].boardNm).css("width", "100px");
					var $gender =  $("<td>").text("성별"+data[i].gender).css("width", "100px");
					$tr1.append($image);
			
					$tr2.append($boardNm);
					//$tr2.addClass($div2);
					//$tr3.append($reward);
					$tr4.append($gender);
			
					$table.append($tr1,$tr5,$tr2,$tr4);
					$(".ddd").append($table);
					
					$table.filter(function(){
						var key2 = i;
						$(this).click(function(){
							location.href = "<%=request.getContextPath()%>/missingSelectOne.bo?num=" + data[key2].boardNo ;
						})
					})
							}
			var $vava=$("<br>");
			
			$page.append($vava);
				
					var $btn2=$("<button  class='paging'>");
					var btnvalue2 = $btn2.text('<<');
						$page.append($btn2);
					
				for(var p = data[data.length-1].startPage; p < data[data.length-1].endPage; p++){
					
				var $btn1 = $("<button  class='paging'>");
				var $btn2 = $("<button  class='paging'>");
				console.log("p : " + p);
	

					var btnvalue = $btn1.text(p);
						$page.append($btn1);
					
					$btn1.click(function(){
				   		var result = $(this).text();
						
						$.ajax({
			   				url:"proorder.bo",
			   				data:{li:li, currentPage:result},
			   				type:"get",
			   				success:function(data){
			   					console.log("psadfafaae:  "+result);
								var $div = $(".ddd");
	   							$div.html("");
			   					for(var i=0;i<data.length-1;i++){
			   	   					
			   						var $table=$("<table>").addClass("thumb-list");
			   						var $div2=$("<div>");
			   						
			   						var $tr1 = $("<tr>");
			   						var $tr2 = $("<tr>");
			   					//	var $tr3 = $("<tr>");
			   						var $tr4 = $("<tr>");
			   						var $tr5 = $("<tr>");
			   						var $br = $("<br>");
			   						var $image = $("<td>");	
			   						$image.append($div2);
			   						$div2.html('<img src="/sixDestiny/thumbnail_uploadFiles/'+data[i].changeNm+'" style="width:100%; height:100%">').css({"width":"200","height":"200"});
			   						$div2.addClass("title");
			   				
			   						$tr5.append($br);
			   						var $boardNm = $("<td>").text(data[i].boardNm).css("width", "100px");
			   						var $gender =  $("<td>").text("성별"+data[i].gender).css("width", "100px");
			   						$tr1.append($image);
			   						
			   						$tr2.append($boardNm);
			   						//$tr2.addClass($div2);
			   						$tr3.append($reward);
			   						$tr4.append($gender);
			   				
			   						$table.append($tr1,$tr5,$tr2,$tr4);
			   						$(".ddd").append($table);
			   						
			   						
			   						$table.filter(function(){
			   							var key2 = i;
			   							$(this).click(function(){
			   								location.href = "<%=request.getContextPath()%>/missingSelectOne.bo?num=" + data[key2].boardNo ;
			   							})
			   						})
			   								}
			   				
			   				}
			   				
			   				
			   				
			   				});	
						
					});	
					
					
				}
				
					var $btn3=$("<button  class='paging'>");
					var btnvalue3 = $btn3.text('>>');
					$page.append($btn3);
				
			

				$btn2.click(function(){
   		
					
					$.ajax({
		   				url:"proorder.bo",
		   				data:{li:li, currentPage:1},
		   				type:"get",
		   				success:function(data){
		   					
							var $div = $(".ddd");
   							$div.html("");
		   					for(var i=0;i<data.length-1;i++){
		   	   					
		   						var $table=$("<table>").addClass("thumb-list");
		   						var $div2=$("<div>");
		   						
		   						var $tr1 = $("<tr>");
		   						var $tr2 = $("<tr>");
		   						//var $tr3 = $("<tr>");
		   						var $tr4 = $("<tr>");
		   						var $tr5 = $("<tr>");
		   						var $br = $("<br>");
		   						var $image = $("<td>");	
		   						$image.append($div2);
		   						$div2.html('<img src="/sixDestiny/thumbnail_uploadFiles/'+data[i].changeNm+'" style="width:100%; height:100%">').css({"width":"200","height":"200"});
		   						$div2.addClass("title");
		   				
		   						$tr5.append($br);
		   						var $boardNm = $("<td>").text(data[i].boardNm).css("width", "100px");
		   						var $gender =  $("<td>").text("성별"+data[i].gender).css("width", "100px");
		   						$tr1.append($image);
		   						
		   						$tr2.append($boardNm);
		   						//$tr2.addClass($div2);
		   						$tr3.append($reward);
		   						$tr4.append($gender);
		   				
		   						$table.append($tr1,$tr5,$tr2,$tr4);
		   						$(".ddd").append($table);
		   						
		   						
		   						$table.filter(function(){
		   							var key2 = i;
		   							$(this).click(function(){
		   								location.href = "<%=request.getContextPath()%>/missingSelectOne.bo?num=" + data[key2].boardNo ;
		   							})
		   						})
		   								}
		   				
		   				}
		   				
		   				
		   				
		   				});	
				
				

				
			
			
			});
			
		
			
				
				
			},
			error:function(err){
				console.log("서버 전송 실패!");
			},
			complete:function(data){
				console.log("무조건 호출되는 함수");
			}
		});
 });
 
 
 
 





</script>

<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>