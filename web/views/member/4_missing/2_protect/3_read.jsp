<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.semi.board.missing.model.vo.*"%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
Missing b = (Missing) request.getAttribute("b");
	ArrayList<MissingAttachment> fileList = 
			(ArrayList<MissingAttachment>) request.getAttribute("fileList");
	MissingAttachment titleImg = fileList.get(0);
	ArrayList<Comment> cm = (ArrayList<Comment>) request.getAttribute("comment");

	%>
<!DOCTYPE html>
<html>
<head>

	<script src="//code.jquery.com/jquery.min.js"></script> 
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#bt1 {
/* 	background: dimgray; */
	Color: black;
	width: 100px;
	height: 50px;
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
color:red;
font-family: 'Sunflower', sans-serif;
}
.b{
color:gray
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
height:300px;
border:0;

}

</style>
<link rel="stylesheet" href="/css/bootstrap.css">

</head>
<body>
<div class="div2">
		<img src="views/images/dog.png">
	</div>
	<table align="center">
	

	
	
		<caption></caption>
		<colgroup>
			<col width="25%">
			<col width="25%">
			<col width="25%">
			<col width="25%">
		</colgroup>
		<table class="type01">
			<tbody>
				<tr>
					<th>작성자</th>
				<td><%=b.getuName()%></td> 
					<th>작성시간</th>
					<td><%=b.getbDate() %></td>
					<th>추천수</th>
					<td><%=b.getRecCon() %></td>
					<th>조회수</th>
					<td><%=b.getInqCon() %></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><%=b.getbNm() %></td>
				</tr>
				
         <tr>   <input type="hidden" value="<%=b.getbNo()%>" name="num" id="num"></tr>

				
			</tbody>
				
		</table>
	</table>


	<div align="right">
	<%System.out.print("뭐냐고고오오오오옹"+b.getUu()); %>

<% if(loginUser != null){ %> 
					 <button type="button" id="report" onclick="report(<%=loginUser.getUserNo()%> );">신고하기</button>
					 <div class="ddd">
					 <%if(b.getUu()==0){ %>
					 	<%System.out.print("추천안돼있음"+b.getUu()); %>
					 	<button class="btn-like a"  onclick="upbnt(<%=b.getUu()%>)">추천♡</button>
					 	<%}else{ %>
					 	<%System.out.print("추천ㅇㅋ"+b.getUu()); %>
					 	<button class="btn-like b"    onclick="upbnt(<%=b.getUu()%>)">추천♡</button>
	<%} %>
	</div>
	<%} %>
	
 
	</div>

	<hr>

	
	<div>
	<img id="titleImg" src="<%=request.getContextPath()%>/thumbnail_uploadFiles/<%=titleImg.getChangeNm()%>">
					
	</div>

	<table class="type02">
		<tr>
			<th>발견장소</th>
			<td><span><%=b.getMissPlace() %><span>　</span><%=b.getMissPlaceDetail() %></span></td>
			<th>발견날짜</th>
			<td><%=b.getMissDt() %></td>
			<th>성별</th>
			<td><%=b.getMissGender() %></td>
			<th>연락처</th>
			<td><%=b.getMissPhone() %></td>
		</tr>
	</table>
	<div>
		<textarea name="" id="zz" cols="200" rows="10"></textarea>
	</div>
	<hr>
	
	<input type="hidden" id="" name="" value="" />
	<div align="center">
		</br> </br>
		<table border="1" width="1200px">
			<tr>
				<td colspan="2" align="right">

<% if(loginUser != null){ 
          if(loginUser.getUserNo()==b.getuNo() ){%>
					 <button type="button" onclick="location.href='<%=request.getContextPath()%>/proUpdate.bo?num=<%=b.getbNo()%>'" id="modified">글 수정</button>
	<%} }%>
	
	

						<% if(loginUser != null){
							
							if( loginUser.getUserId().equals("admin") ||loginUser.getUserNo()==b.getuNo() ){ %>
<button type="button" onclick="location.href='<%=request.getContextPath()%>/proDelete.bo?num=<%=b.getbNo()%>'"  id="deleteBoard">글 삭제</button>
						
				<% }}%>
				
				
				
				<script>
				

				$('#modified').click(function(){

					 location.href="<%= request.getContextPath() %>/proUpdate.bo?num=<%= b.getbNo() %>" ;
				});

				$('#deleteBoard').click(function(){
				
					location.href="<%= request.getContextPath()%>/proDelete.bo?num=<%= b.getbNo()%>" ;
				});
				
					function report(data){
					var test = <%= b.getbNo() %>;

					var test2 = data;				
					
					var test3 = <%=b.getuNo()%>;
					console.log("뀨");
					console.log(test2);
					window.open("/sixDestiny/views/member/4_missing/2_protect/5_report.jsp?test=" + test + "," + test2 + "," + test3 ,"PopupWin","width=480,height=300","resizable=no");
				}
				
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
									var $div = $(".ddd");
										$div.html("");
										
									console.log("보드"+test);
									console.log("re"+result);
										var $btn = $("<button>");
										$btn.text("추천♡")
									 
									if(data==0){
										$div.append($btn).click(function(){upbnt(data);});
										$btn.addClass("a");
									}else{
										$div.append($btn).click(function(){upbnt(data);});
										$btn.addClass("b");
									}
									
									
				
									
								}
								
								
								
						});

					}

				
				</script>
				
				


		<div align="center" style="padding: 20px">
			<table id="replySelectTable" border="0" align="conter">
				<tbody>
				<% if(cm != null){ %>
				<% for(int i = 0 ; i < cm.size(); i++){ %>
					<tr >
						<td>
						<input type="hidden" value="<%= cm.get(i).getConNo()%>" class="repotCon">
						<input type="hidden" value="<%= cm.get(i).getuNo()%>" class="repotUser">
										<input type="hidden" value="<%=b.getbNo()%>" class="num">
														<input type="hidden" value="<%= b.getUu()%>" class="uu">
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
								
								<button class="deleteCo"  onclick="deleteCo(<%=loginUser.getUserNo()%>);" >삭제</button>
								<% } %>
						</td>
					</tr>
					<% } %>
				<% } %>
				</tbody>
			</table>

			</div>


	<hr>
<div>
	<% if(loginUser != null) { %>
		댓글 <input type="text" style="width: 600px" id="comment">
		<input type="button" value="댓글 달기" id="comHs">

		<% } %>



	</div>
	
	
	<script>
	
	
	
	$('#comHs').click(function(){

		var comment = $('#comment').val();
		var uNo = <%=loginUser.getUserNo()%>
		var bNo = $('#num').val();


		$.ajax({
			url:"ProComment",
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
					$td.append($button2);
					$td.append($button3);	
					$tr.append($td);

					$replySelectTable.append($tr);


				}

			$('.reportCom').click(function(){
					var cNo = $(this).prevAll('.repotCon').val();
					var uNo = $(this).prevAll('.repotUser').val();
					var u2No = <%=loginUser.getUserNo()%>

					window.open("/sixDestiny/views/member/4_missing/2_protect/6_report_comment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");

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
					window.open("/sixDestiny/views/member/4_missing/2_protect/6_report_comment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");
	}

	
	function changeCo(data){
		
		var cNo = $('.reportCom').prevAll('.repotCon').val();
		var num = 	$('.reportCom').prevAll('.num').val();
		var uu = 	$('.reportCom').prevAll('.uu').val();
	

		window.open("/sixDestiny/views/member/4_missing/2_protect/7_updateCo.jsp?cNo=" + cNo +"&num="+num+"&uu="+uu,"PopupWin","width=600,height=300","resizable=no");

	
	}
	
	
	$(function(){
		close();
	});
	
<%-- 	$('#comHs').click(function(){
		console.log("aaaaa");
		var comment = $('#comment').val();
		var uNo = <%=loginUser.getUserNo()%>
		var bNo = $('#num').val();


		$.ajax({
			url:"ProComment",
			data:{comment:comment , uNo:uNo , bNo:bNo},
			type:"post",
			success:function(data){

				console.log(data);
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
					$td.append($button2);
					$td.append($button3);					
					$tr.append($td);

					$replySelectTable.append($tr);


				} 

			$('.reportCom').click(function(){
					var cNo = $(this).prevAll('.repotCon').val();
					var uNo = $(this).prevAll('.repotUser').val();
					var u2No = <%=loginUser.getUserNo()%>

					window.open("/sixDestiny/views/member/4_missing/2_protect/6_report_comment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");

				}) 
				
				
				
				
				
				
				
				
				
				

			},
	
		});

		console.log(comment);
		console.log(uNo);
		console.log(bNo);
	})
	
	
	
	
				function report2(data){
		var cNo = $('.reportCom').prevAll('.repotCon').val();
		var uNo = $('.reportCom').prevAll('.repotUser').val();
		var u2No = data;
					console.log("뀨");
					window.open("/sixDestiny/views/member/4_missing/2_protect/6_report_comment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");
	}
	 --%>




	
	</script>
	
	
	
<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>