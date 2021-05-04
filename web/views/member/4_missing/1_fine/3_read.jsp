<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.semi.board.missing.model.vo.*,com.kh.semi.user.model.vo.*"%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
Missing b = (Missing) request.getAttribute("b");
	ArrayList<MissingAttachment> fileList = 
			(ArrayList<MissingAttachment>) request.getAttribute("fileList");
	MissingAttachment titleImg = fileList.get(0);
	ArrayList<Comment> cm = (ArrayList<Comment>) request.getAttribute("comment");

	User us = (User) request.getAttribute("User");
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="//code.jquery.com/jquery.min.js"></script> 
<style>

#fff.button{
	font-weight: bold;

	font-family: 'Sunflower', sans-serif;
}


.div2 {
	padding: 10px;
	font-weight: bold;
	/* vertical-align: top; */
	color: skyblue;

	font-family: 'Sunflower', sans-serif;
}

table.type01 {
/* 	border-collapse: collapse; */
	text-align: left;
/* 	line-height: 1.5; */
	font-family: 'Sunflower', sans-serif;
}

table.type01 tbody th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
/* 	border-bottom: 1px solid #ccc; */
	background: white;
	font-family: 'Sunflower', sans-serif;
}

table.type01 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;

	font-family: 'Sunflower', sans-serif;
}

table.type02 {
/* 	border-collapse: collapse; */
	text-align: left;
	line-height: 1.0;
	font-family: 'Sunflower', sans-serif;
}

table.type02 th {
	width: 150px;
	padding: 5px;
	font-weight: bold;
	vertical-align: top;

	background: white;
	font-family: 'Sunflower', sans-serif;
}

table.type02 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;

	font-family: 'Sunflower', sans-serif;
}

textarea {
	width: 100%;
	font-family: 'Sunflower', sans-serif;
}

.reply_reply {

	font-family: 'Sunflower', sans-serif;
}

.reply_modify {

	font-family: 'Sunflower', sans-serif;
}

#commentCh{

opacity:0;
font-family: 'Sunflower', sans-serif;

}
#commentChbtn{
opacity:0;
font-family: 'Sunflower', sans-serif;

}
.a{
color:black;
font-family: 'Sunflower', sans-serif;
}
.bb{
color:black;
font-family: 'Sunflower', sans-serif;
}

.b{
color:red;
font-family: 'Sunflower', sans-serif;
}
#1{
color:gray;
font-family: 'Sunflower', sans-serif;

}
#2{
color:red;
font-family: 'Sunflower', sans-serif;
}

#zz{
font-family: 'Sunflower', sans-serif;
text-align:center;
width:600px;
border:0;

}

</style>
<link rel="stylesheet" href="/css/bootstrap.css">

</head>
<body>

	

	
	
		<caption></caption>
		<colgroup>
			<col width="25%">
			<col width="25%">
			<col width="25%">
			<col width="25%">
		</colgroup>
		<div style="width:70%; margin-left:auto; margin-right:auto;" >
		<table class="type01" >
			<tbody>
				<tr>
					<th>작성자</th>
			 	<td><%=b.getuName()%></td>  
					<th>작성시간</th>
				<td><%=b.getbDate() %></td> 
					<th>추천수</th>
				
				<td id="rec"><%=b.getRecCon() %></td>
		
				
					<th>조회수</th>
					<td><%=b.getInqCon() %></td> 
				</tr>
		
         <tr>   <input type="hidden" value="<%=b.getbNo()%>" name="num" id="num"></tr>


				<hr>
				
			</tbody>
		</table>
		
	</table>
		<table class="type02" >
		<tr>
			<th>실종장소</th>
			<td><span><%=b.getMissPlace() %><span>　</span><%=b.getMissPlaceDetail() %></span></td>
			<th>실종날짜</th>
			<td><%=b.getMissDt() %></td>
			<th>성별</th>
			<td><%=b.getMissGender() %></td>
			<th>사례금</th>
			<td><%=b.getRewardPc() %></td>
 	
		</tr>
				
	</table>






	<div  id="fff" align="right" ">
	<table><tr>
	<%System.out.print("뭐냐고고오오오오옹"+b.getUu()); %>
<td>
<% if(loginUser != null){ %> 
					 <button class="bb" type="button" id="report" onclick="report(<%=loginUser.getUserNo()%>);">신고</button>
					 <div class="ddd">
					 </td>
					 <td id="td">
					 <%if(b.getUu()==0){ %>
					 	<%System.out.print("추천안돼있음"+b.getUu()); %>
					 	<button class="btn-like a"  onclick="upbnt(<%=b.getUu()%>)">추천♡</button>
					 	<%}else{ %>
					 	<%System.out.print("추천ㅇㅋ"+b.getUu()); %>
					 	<button class="btn-like b"    onclick="upbnt(<%=b.getUu()%>)">추천♡</button>
	<%} %>
	</td>
	</div>
	
	<%} %>
	<td>

		<button class="bb"  onclick="location.href='<%=request.getContextPath()%>/missingpaper.bo?num=<%=b.getbNo()%>'" id="paper">전단지 생성</button>
</td>
</tr>
</table>
 
	</div>
	<hr>
	</div>
	<br><br>

					<label text-align="left">제목: </label>
					<label text-align="left"><%=b.getbNm() %></label>
					<br><br>	<br><br>
		


	<div>
	<img style="width:300px; height:auto;" id="titleImg" src="<%=request.getContextPath()%>/thumbnail_uploadFiles/<%=titleImg.getChangeNm()%>">
					
	</div>

<br><br>

	<div>
		<textarea name="" id="zz" cols="90" rows="10" text-align="center"><%=b.getbCon() %></textarea>
		<br>
				<label text-align="center">연락처 : </label>
			<label text-align="center"><%=b.getMissPhone() %></label>
	</div>
	
	<input type="hidden" id="" name="" value="" />
	<div align="center" style="height:10px;">
		</br> </br>
		<table  width="60%">
			<tr>
				<td colspan="2" align="right">

<% if(loginUser != null){ 
          if(loginUser.getUserNo()==b.getuNo() ){%>
					 <button type="button" onclick="location.href='<%=request.getContextPath()%>/missingUpdate.bo?num=<%=b.getbNo()%>'" id="modified">글 수정</button>
	<%} }%>
	
	

						<% if(loginUser != null){
							
							if( loginUser.getUserId().equals("admin") ||loginUser.getUserNo()==b.getuNo() ){ %>
<button type="button" onclick="location.href='<%=request.getContextPath()%>/missingDelete.bo?num=<%=b.getbNo()%>'"  id="deleteBoard">글 삭제</button>
						
				<% }}%>
				<hr>
				
				</td>
				</tr>
				</table>
			
				</div>
				
				<script>
				

				$('#modified').click(function(){

					 location.href="<%= request.getContextPath() %>/missingUpdate.bo?num=<%= b.getbNo() %>" ;
				});

				$('#deleteBoard').click(function(){
				
					location.href="<%= request.getContextPath()%>/missingDelete.bo?num=<%= b.getbNo()%>" ;
				});
				
				$('#paper').click(function(){
				
					location.href="<%= request.getContextPath()%>/missingpaper.bo?num=<%= b.getbNo()%>" ;
				});
				
			
				
				function report(data){
					var test = <%= b.getbNo() %>;
					var test2 = data;		
					var test3 = <%=b.getuNo()%>
					console.log("뀨");
					console.log(test2);
					window.open("/sixDestiny/views/member/4_missing/1_fine/6_report.jsp?test=" + test + "," + test2 + "," + test3 ,"PopupWin","width=480,height=300","resizable=no");
				}

				
				</script>
		

<script>



function upbnt(data){
	console.log("ddddddddd");
	var test = <%= b.getbNo() %>;
	var test2= <%=loginUser.getUserNo()%>;
 	var result= data;
 	
 	/* console.log("1 : " + test);
 	console.log("2 : " + test2);
 	console.log("3 : " + result); */
	$.ajax({
			url:"missingrec.bo",
			data:{test:test,test2:test2,result:result},
			type:"get",
			success:function(data){
				console.log(data + " data?");
				var $div = $("#td");
					$div.html("");
					
				console.log("보드"+test);
				console.log("re"+result);
					var $btn = $("<button>");
					$btn.text("추천♡")
				 
				if(data==0){
					var $div2=$('.rec')
					$div2.html("");
					$div.append($btn).click(function(){upbnt(data);});
					$btn.addClass("a");
	
					
				}else{
					var $div2=$('.rec')
					$div2.html("");
					$div.append($btn).click(function(){upbnt(data);});
					$btn.addClass("b");
				}
				
				
	
				
			}
			
			
			
	});

}


	
	
</script> 



		<div align="center" style="padding: 60px">
			<table id="replySelectTable" border="0" align="center">
				<tbody>
				<br>
				<% if(cm != null){ %>
				<% for(int i = 0 ; i < cm.size(); i++){ %>
					<tr >
						<td>
						<input type="hidden" value="<%= cm.get(i).getConNo()%>" class="repotCon">
						<input type="hidden" value="<%= cm.get(i).getuNo()%>" class="repotUser">
							<input type="hidden" value="<%=b.getbNo()%>" class="num">
														<input type="hidden" value="<%= b.getUu()%>" class="uu" name="uu">
							<label style="width:100px"><%= cm.get(i).getNickNm() %></label>
							 <label style="width:400px" class="Con"><%= cm.get(i).getComment() %></label> 
							<%if(loginUser.getUserId()!=null){ 
							%>
						<button class="reportCom"  onclick="report2(<%=loginUser.getUserNo()%>);"  style="background: none;  border: none;"><img src="/sixDestiny/images/reportcoment.PNG" width="30px;" height="30px;" id="imgtest"></button>
							<% } %>
							
							
								<%if(loginUser.getUserNo()==cm.get(i).getuNo()){ %>
							<button class="changeCo"  onclick="changeCo(<%=loginUser.getUserNo()%>);"  >수정</button>
									
							<% } %>
							
							
								<%if(loginUser.getUserNo()==cm.get(i).getuNo()||loginUser.getUserId().equals("admin")){ %>
								
								<button class="deleteCo"  <%-- onclick="deleteCo(<%=loginUser.getUserNo()%>);" --%> >삭제</button>
								<% } %>	</td>
					</tr>
					<% } %>
				<% } %>
				</tbody>
			</table>

			<%-- <% if(loginUser != null &&loginUser.getUserId().equals("admin")){ %>  <button>삭제</button>   <% } %> --%>

			</div>




<div align="center" style="padding: 50px">
	<% if(loginUser != null) { %>
		 <input type="text" style="width: 600px" id="comment">
		<input type="button" value="댓글 달기" id="comHs">

		<% } %>



	</div>
	
	<div>
	<% if(loginUser != null) { %>
 <input type="text" style="width: 600px" id="commentCh">
	<input type="button" value="댓글 수정" id="commentChbtn">

		<% } %>
	
	</div>
	
	
	<script>
	

	$('#comHs').click(function(){

		var comment = $('#comment').val();
		var uNo = <%=loginUser.getUserNo()%>
		var bNo = $('#num').val();
		var uNo2 = $('.repotUser').val();

		$.ajax({
			url:"MissingComment",
			data:{comment:comment , uNo:uNo , bNo:bNo},
			type:"get",
			success:function(data){


				var $replySelectTable = $('#replySelectTable tbody');
				$replySelectTable.html("");
				var $comment = $('#comment');
				$comment.val("");


				for(var key in data){
					var $tr = $('<tr>');
					var $td = $('<td>');
					var $button = $('<button style="background: none; border:none;" class="reportCom">');
					var $img = $('<img src="/sixDestiny/images/reportcoment.PNG" width="30px;" height="30px;" id="imgtest">');
					var $input = $('<input value=' + data[key].conNo + " >" );
					$input.attr('type','hidden');
					var $input2 = $('<input value=' + data[key].uNo + '>' );
					$input2.attr('type','hidden');
					var $nickNm = $("<label>").text(data[key].nickNm).css("width","100px");
					var $comment = $("<label>").text(data[key].comment).css("width","400px");
			
					var $button2 =$('<button>');
					$button2.text("수정");
					var $button3 =$('<button>');
					$button3.text("삭제");
					

					$button.append($img);
					$td.append($input);
					$td.append($input2);
				
					$td.append($nickNm);
					$td.append($comment);
					$td.append($button);
					if(<%=loginUser.getUserNo()%>==data[key].uNo){
					$td.append($button2);
					}
					

					if(<%=loginUser.getUserNo()%>==data[key].uNo||<%=loginUser.getUserNo()%>==100){ 
					$td.append($button3);
					}
					$tr.append($td);

					$replySelectTable.append($tr);


				}

			$('.reportCom').click(function(){
					var cNo = $(this).prevAll('.repotCon').val();
					var uNo = $(this).prevAll('.repotUser').val();
					var u2No = <%=loginUser.getUserNo()%>
				

					window.open("/sixDestiny/views/member/4_missing/1_fine/7_report_comment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");

				}) 

			}
		})

		console.log(comment);
		console.log(uNo);
		console.log(bNo);
	})
	
	
	
	
				function report2(data){
		var cNo = $('.reportCom').prevAll('.repotCon').val();
		var uNo = $('.reportCom').prevAll('.repotUser').val();
		var u2No = data;
					console.log("뀨");
					window.open("/sixDestiny/views/member/4_missing/1_fine/7_report_comment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");
	}

	$(function(){
		$('.deleteCo').each(function(){
			console.log("Each");
			$(this).click(function(){
				console.log("click");
				var cNo = $(this).prevAll(".repotCon").val();
				console.log(cNo);
				var comment = $('#comment').val();
				var uNo = <%=loginUser.getUserNo()%>
				var bNo = $('#num').val();
				var comment = $('#comment').val();

				
				
				
				
				
				$.ajax({
					url:"CommentDeleteServlet",
					data:{cNo:cNo , uNo:uNo , bNo:bNo},
					type:"get",
					success:function(data){


						var $replySelectTable = $('#replySelectTable tbody');
						$replySelectTable.html("");
						var $comment = $('#comment');
						$comment.val("");


						for(var key in data){
							var $tr = $('<tr>');
							var $td = $('<td>');
							var $button = $('<button style="background: none; border:none;" class="reportCom">');
							var $img = $('<img src="/sixDestiny/images/reportcoment.PNG" width="30px;" height="30px;" id="imgtest">');
							var $input = $('<input value=' + data[key].conNo + " >" );
							$input.attr('type','hidden');
							var $input2 = $('<input value=' + data[key].uNo + '>' );
							$input2.attr('type','hidden');
							var $nickNm = $("<label>").text(data[key].nickNm).css("width","100px");
							var $comment = $("<label>").text(data[key].comment).css("width","400px");
							
							var $button2 =$('<button>');
							$button2.text("수정");
							var $button3 =$('<button>');
							$button3.text("삭제");
							

							$button.append($img);
							$td.append($input);
							$td.append($input2);
							$td.append($nickNm);
							$td.append($comment);
							$td.append($button);
							if(<%=loginUser.getUserNo()%>==data[key].uNo){
							$td.append($button2);
							}
							if(<%=loginUser.getUserNo()%>==data[key].uNo||<%=loginUser.getUserNo()%>==100){ 
							$td.append($button3);
							}
							$tr.append($td);

							$replySelectTable.append($tr);


						}

					$('.reportCom').click(function(){
							var cNo = $(this).prevAll('.repotCon').val();
							var uNo = $(this).prevAll('.repotUser').val();
							var u2No = <%=loginUser.getUserNo()%>

							window.open("/sixDestiny/views/member/4_missing/1_fine/7_report_comment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");

						}) 

					}
				})

				console.log(comment);
				console.log(uNo);
				console.log(bNo);
				
				
			})
		});	
	});
	
	

	
	$(function(){
		$('.changeCo').each(function(){
			console.log("Each");
			var cNo = $(this).prevAll(".repotCon").val();
			var bNo = $('#num').val();
			$(this).click(function(){
		
				$('#commentCh').css("opacity","1");
				
				$('#commentChbtn').css("opacity","1");
				

				$('#commentChbtn').click(function(){
					console.log("click");
					
					$('#commentCh').css("opacity","0");
					
					$('#commentChbtn').css("opacity","0");
					
					
					
				
					var comment = $('#commentCh').val(); 
				

					$.ajax({
						url:"CommentChange2",
						data:{cNo:cNo , comment:comment,bNo:bNo},
						type:"get",
						success:function(data){

							console.log(data);
							var $replySelectTable = $('#replySelectTable tbody');
							$replySelectTable.html("");
					/* 		var $comment = $('#comment');
							$comment.val("");
  */

							for(var key in data){
								var $tr = $('<tr>');
								var $td = $('<td>');
								var $button = $('<button style="background: none; border:none;" class="reportCom">');
								var $img = $('<img src="/sixDestiny/images/reportcoment.PNG" width="30px;" height="30px;" id="imgtest">');
								var $input = $('<input value=' + data[key].conNo + " >" );
								$input.attr('type','hidden');
								var $input2 = $('<input value=' + data[key].uNo + '>' );
								$input2.attr('type','hidden');
								var $nickNm = $("<label>").text(data[key].nickNm).css("width","100px");
								var $comment = $("<label>").text(data[key].comment).css("width","400px");
							
								var $button2 =$('<button>');
								$button2.text("수정");
								var $button3 =$('<button>');
								$button3.text("삭제");
								

								$button.append($img);
								$td.append($input);
								$td.append($input2);
								$td.append($nickNm);
								$td.append($comment);
								$td.append($button);
								if(<%=loginUser.getUserNo()%>==data[key].uNo){
								$td.append($button2);
								}
								if(<%=loginUser.getUserNo()%>==data[key].uNo||<%=loginUser.getUserNo()%>==100){ 
								$td.append($button3);
								}
								$tr.append($td);

								$replySelectTable.append($tr);


							}

						$('.reportCom').click(function(){
								var cNo = $(this).prevAll('.repotCon').val();
								var uNo = $(this).prevAll('.repotUser').val();
								var u2No = <%=loginUser.getUserNo()%>

								window.open("/sixDestiny/views/member/4_missing/1_fine/7_report_comment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");

							}) 

						}
					})

					
				})

	
		
				
				
			})
		});	
	});
	
	
	
	
	
	
	
	
	

			$('#commentChbtn').click(function(){
				console.log("click");
				
				$('#commentCh').css("opacity","0");
				
				$('#commentChbtn').css("opacity","0");
				
				
				
				var cNo = $(this).prevAll(".repotCon").val();
				
				var comment = $('#commentCh').val(); 
			

				$.ajax({
					url:"CommentChange2",
					data:{cNo:cNo , comment:comment},
					type:"get",
					success:function(data){


						var $replySelectTable = $('#replySelectTable tbody');
						$replySelectTable.html("");
						var $comment = $('#comment');
						$comment.val("");


						for(var key in data){
							var $tr = $('<tr>');
							var $td = $('<td>');
							var $button = $('<button style="background: none; border:none;" class="reportCom">');
							var $img = $('<img src="/sixDestiny/images/reportcoment.PNG" width="30px;" height="30px;" id="imgtest">');
							var $input = $('<input value=' + data[key].conNo + " >" );
							$input.attr('type','hidden');
							var $input2 = $('<input value=' + data[key].uNo + '>' );
							$input2.attr('type','hidden');
							var $nickNm = $("<label>").text(data[key].nickNm).css("width","100px");
							var $comment = $("<label>").text(data[key].comment).css("width","400px");
						
							var $button2 =$('<button>');
							$button2.text("수정");
							var $button3 =$('<button>');
							$button3.text("삭제");
							

							$button.append($img);
							$td.append($input);
							$td.append($input2);
							$td.append($nickNm);
							$td.append($comment);
							$td.append($button);
							if(<%=loginUser.getUserNo()%>==data[key].uNo){
							$td.append($button2);
							}
							if(<%=loginUser.getUserNo()%>==data[key].uNo||<%=loginUser.getUserNo()%>==100){ 
							$td.append($button3);
							}
							$tr.append($td);

							$replySelectTable.append($tr);


						}

					$('.reportCom').click(function(){
							var cNo = $(this).prevAll('.repotCon').val();
							var uNo = $(this).prevAll('.repotUser').val();
							var u2No = <%=loginUser.getUserNo()%>

							window.open("/sixDestiny/views/member/4_missing/1_fine/7_report_comment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");

						}) 

					}
				})

				
			})


	
	</script>
	
<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>