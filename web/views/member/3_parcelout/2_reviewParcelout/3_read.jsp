<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semi.board.parcelout.model.vo.*, java.util.*, com.kh.semi.user.model.vo.*"%>
<%@ include file="../../../common/top_Include.jsp"%>

<%
	ArrayList<Integer> list2 = null;

	UserBoard ub = (UserBoard) request.getAttribute("ParceloutBoard");

	ArrayList<Attachment> list = (ArrayList<Attachment>) request.getAttribute("filelist");

	User us = (User) request.getAttribute("User");

	ArrayList<Coment> cm = (ArrayList<Coment>) request.getAttribute("coment");

	if(request.getAttribute("list2") != null){
	 list2 = (ArrayList<Integer>) request.getAttribute("list2");

	}

	ArrayList<Integer> list3 = (ArrayList<Integer>) request.getAttribute("list3");

	Attachment Img1 = list.get(0);




%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>분양후기 글보기</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
</head>
<body>

	<div>

		<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
					<td><input style="display: none;" id="bNo" value="<%= ub.getbNo() %>">
					<% if(loginUser != null) {%>
						<input type="hidden" id="uNo" value="<%= loginUser.getUserNo() %>">
					<% } %>
					</td>
						<th>제목 : <%= ub.getbNm() %></th>
						<th>작성자 : <%= us.getNickNm() %></th>
						<th>작성일 : <%= ub.getbDate() %></th>
						<th id="thtest2">조회수 : <%= ub.getInqCon() %></th>
						<th id="thtest">추천수 : <%= list3.get(0) %></th>

						<% if(loginUser != null) {%>
							<%if (list2.get(0) == 1){ %>
							<th class="classt"><button type="button" id="parcleup" style="background: none;  border: none;"><img src="/sixDestiny/images/test1.png" width="30px;" height="30px;" id="imgtest"></button>
							</th>
							<% }else { %>
						<th class="classt"><button type="button" id="parcleup" style="background: none;  border: none;"><img src="/sixDestiny/images/test3.jpeg" width="30px;" height="30px;" id="imgtest"></button>
							<% } %>
						<th><input type="button" value="신고" id="reportPr" class="btn btn-default"></th>
						<% } %>


						<% if(loginUser != null) { %>
							<% if(loginUser.getUserNo() == us.getUserNo() || loginUser.getUserId().equals("admin")){ %>
									<th><input type="button" value="수정" id="modified" class="btn btn-default"></th>
									<th><input type="button" value="삭제" id="deleteBoard" class="btn btn-default"></th>
								<% } %>
							<% } %>
					</tr>
				</thead>
			</table>
		</div>


		<div style="padding: 30px" align="center">
			<img src="/sixDestiny/parcelout_uploadFiles/<%= Img1.getChangeNm()%>" alt="Nature" >
			<input type="hidden" value="/sixDestiny/parcelout_uploadFiles/<%= Img1.getChangeNm()%>" id="modifiedImg">
			<p style="width: 1000px; padding: 80px;">
				<%= ub.getbCon() %>
			</p>
		</div>

		<hr>

		<div align="center" style="padding: 20px">
			<table id="replySelectTable" border="0" align="conter">
				<tbody>
				<% if(cm != null){ %>
				<% for(int i = 0 ; i < cm.size(); i++){ %>
					<tr >
						<td>
						<input type="hidden" value="<%= cm.get(i).getConNo()%>" class="repotCon">
						<input type="hidden" value="<%= cm.get(i).getuNo()%>" class="repotUser">
							<label style="width:100px"><%= cm.get(i).getNickNm() %></label>
							<label style="width:400px"><%= cm.get(i).getComent() %></label>
						<button class="reportCom" style="background: none;  border: none;"><img src="/sixDestiny/images/reportcoment.PNG" width="30px;" height="30px;" id="imgtest"></button>
						<% if(loginUser != null) {%>
						<% if(cm.get(i).getuNo() == loginUser.getUserNo() ) { %>
						<button class="updateCom" style="background: none;  border: none;">수정</button>
						<button class="deleteCom" style="background: none;  border: none;">삭제</button>
						<% } %>
						<% } %>
						</td>
					</tr>
					<% } %>
				<% } %>
				</tbody>
			</table>

			<%-- <% if(loginUser != null &&loginUser.getUserId().equals("admin")){ %>  <button>삭제</button>   <% } %> --%>

			</div>





		</div>
		<hr>

	<% if(loginUser != null) { %>
		댓글 <input type="text" style="width: 600px" id="coment">
		<input type="button" value="댓글 달기" id="comHs" class="btn btn-default">

		<% } %>



	</div>

<script>
	$('.updateCom').click(function(){

		var Comment = $(this).prevAll('label').eq(0).text();
		var NickName = $(this).prevAll('label').eq(1).text();

		$(this).prevAll('label').eq(0).remove();

		var $input = $('<input type="text" size="50px">');
			$input.val(Comment);
			$input.addClass('updateComment');

		var $button = $('<button>')
			$button.addClass('updatebutton');
			$button.text("수정");
			$button.css({'background':'none','border':'none'});

		$(this).prevAll('.reportCom').remove();
		$(this).nextAll('.deleteCom').remove();
		$(this).prevAll('label').eq(0).after($button);
		$(this).prevAll('label').eq(0).after($input);
		$(this).remove();


		$('.updatebutton').click(function(){
				var cNo = $(this).prevAll('.repotCon').val();
				var comment = $('.updateComment').val();



				$.ajax({
					url:"UpdateComment.uc?cNo=" + cNo + "&comment=" + comment ,
					data:{cNo:cNo,comment:comment},
					type:"get",
					success:function(data){


						var $label = $('<label>');
						$label.text(data);
						 $label.css('width','400px');
						 var $label2 = $('<label>')
						 $label2.text("수정 완료 !");

						$('.updateComment').remove();

					 	$(".updatebutton").before($label);
					 	$(".updatebutton").after($label2);

						$(".updatebutton").remove();

					}

				})

		});
	});


	$('.deleteCom').click(function(){
		var cNo = $(this).prevAll('.repotCon').val();
		var bNo = $('#bNo').val();
		<% if(loginUser != null){%>
		var uNo = <%= loginUser.getUserNo()%>
		<%}%>

		location.href="<%= request.getContextPath() %>/DeletePa.cm?cNo=" + cNo + "&bNo=" + bNo + "&uNo=" + uNo;



	})

	$('.reportCom').click(function(){
		var cNo = $(this).prevAll('.repotCon').val();
		var uNo = $(this).prevAll('.repotUser').val();
		var u2No = <%= us.getUserNo()%>;

		window.open("/sixDestiny/views/member/3_parcelout/2_reviewParcelout/7_report_coment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");

	})

	$('#parcleup').click(function(){
		var uNo = $('#uNo').val();
		var bNo = $('#bNo').val();



		$.ajax({
			url:"updateRec.po",
			type:"get",
			data:{uNo:uNo,bNo:bNo},
			success:function(data){

				if(data[0] == 1){

					var $parcleup = $('#parcleup');

					var $imgtest = $('#imgtest');

					$imgtest.remove();

					var $img2 = ('<img src="/sixDestiny/images/test1.png" width="30px;" height="30px;" id="imgtest" >');

					$parcleup.append($img2);

					var $table = $('#thtest');

					$table.remove();

					var $th = $('<th id="thtest">');
					$th.text("추천수 : " + data[1]);
					var $th2 = $('#thtest2');


					$th2.after($th);



				}else{

					$.ajax({
						url:"DeleteRec.dr",
						data:{uNo:uNo,bNo:bNo},
						type:"post",
						success:function(data){
							if(data[0] > 0){

								var $parcleup = $('#parcleup');

								var $imgtest = $('#imgtest');

								$imgtest.remove();

								var $img2 = ('<img src="/sixDestiny/images/test3.jpeg" width="30px;" height="30px;" id="imgtest" >');

								$parcleup.append($img2);

								var $table = $('#thtest');

								$table.remove();

								var $th = $('<th id="thtest">');
								$th.text("추천수 : " + data[1]);
								var $th2 = $('#thtest2');


								$th2.after($th);


							}



						}

					})



			}
			}

			});

		});

	$('#modified').click(function(){

		var imgname = $('#modifiedImg').val();


		 location.href="<%= request.getContextPath() %>/ParceloutConUpdate.po?num=<%= ub.getbNo() %>&imgname=" + imgname ;
	})

	$('#deleteBoard').click(function(){

		location.href="<%= request.getContextPath()%>/DeleteParcelout.po?num=<%= ub.getbNo() %>" ;
	})


	$('#reportPr').click(function(){
		var test = <%= ub.getbNo() %>;
		var test2 = $('#uNo').val();
		var test3 = <%= us.getUserNo()%>;
		window.open("/sixDestiny/views/member/3_parcelout/2_reviewParcelout/6_report.jsp?test=" + test + "," + test2 + "," + test3,"PopupWin","width=480,height=300","resizable=no");
	})

	$('#comHs').click(function(){


		var coment = $('#coment').val();
		var uNo = $('#uNo').val();
		var bNo = $('#bNo').val();


		$.ajax({
			url:"Insert.coment",
			data:{coment:coment , uNo:uNo , bNo:bNo},
			type:"get",
			success:function(data){
				console.log(data);


				var $replySelectTable = $('#replySelectTable tbody');
				$replySelectTable.html("");
				var $coment = $('#coment');
				$coment.val("");

			/* 	<button class="updateCom" style="background: none;  border: none;">수정</button> */
				for(var key in data){
					var $tr = $('<tr>');
					var $td = $('<td>');
					var $button = $('<button style="background: none; border:none;" class="reportCom">');
					var $img = $('<img src="/sixDestiny/images/reportcoment.PNG" width="30px;" height="30px;" id="imgtest">');
					var $input = $('<input type="hidden" value=' + data[key].conNo + " >" );
					$input.addClass('repotCon');
					var $input2 = $('<input type="hidden" value=' + data[key].uNo + '>' );
					$input2.addClass('repotUser');
					var $nickNm = $("<label>").text(data[key].nickNm).css("width","100px");
					var $coment = $("<label>").text(data[key].coment).css("width","400px");


					<%if(loginUser != null){%>
					if(data[key].uNo == <%= loginUser.getUserNo()%>){
					var $button2 = $("<button>");
					$button2.addClass('deleteCom');
					 $button2.css({'background':'none','border':'none'});
					 $button2.text("삭제");
					var $button3 = $('<button>');
					$button3.addClass("updateCom");
					$button3.css({'background':'none','border':'none'});
					$button3.text("수정");
					}
					<%}%>


					$button.append($img);
					$td.append($input);
					$td.append($input2);
					$td.append($nickNm);
					$td.append($coment);
					$td.append($button);
					$td.append($button3);

					<% if(loginUser != null){ %>
					if(data[key].uNo == <%= loginUser.getUserNo() %>){
					$td.append($button2);
					}
					<% } %>


					$tr.append($td);

					$replySelectTable.append($tr);


				}

				$('.reportCom').click(function(){
					var cNo = $(this).prevAll('.repotCon').val();
					var uNo = $(this).prevAll('.repotUser').val();
					var u2No = <%= us.getUserNo()%>;

					window.open("/sixDestiny/views/member/3_parcelout/2_reviewParcelout/7_report_coment.jsp?uNo=" + uNo + "&cNo=" + cNo  + "&u2No=" + u2No ,"PopupWin","width=480,height=300","resizable=no");

				});

				$('.deleteCom').click(function(){
					var cNo = $(this).prevAll('.repotCon').val();
					var bNo = $('#bNo').val();
					<% if(loginUser != null){%>
					var uNo = <%= loginUser.getUserNo()%>
					<%}%>

					location.href="<%= request.getContextPath() %>/DeletePa.cm?cNo=" + cNo + "&bNo=" + bNo + "&uNo=" + uNo;



	});
				$('.updateCom').click(function(){

					var Comment = $(this).prevAll('label').eq(0).text();
					var NickName = $(this).prevAll('label').eq(1).text();

					$(this).prevAll('label').eq(0).remove();

					var $input = $('<input type="text" size="50px">');
						$input.val(Comment);
						$input.addClass('updateComment');
					var $button = $('<button>')
						$button.addClass('updatebutton');
						$button.text("수정");
						$button.css({'background':'none','border':'none'});

					$(this).prevAll('.reportCom').remove();
					$(this).nextAll('.deleteCom').remove();
					$(this).prevAll('label').eq(0).after($button);
					$(this).prevAll('label').eq(0).after($input);
					$(this).remove();


					$('.updatebutton').click(function(){
							var cNo = $(this).prevAll('.repotCon').val();
							var comment = $('.updateComment').val();



							$.ajax({
								url:"UpdateComment.uc?cNo=" + cNo + "&comment=" + comment ,
								data:{cNo:cNo,comment:comment},
								type:"get",
								success:function(data){


									var $label = $('<label>');
									$label.text(data);
									 $label.css('width','400px');
									 var $label2 = $('<label>')
									 $label2.text("수정 완료 !");

									$('.updateComment').remove();

								 	$(".updatebutton").before($label);
								 	$(".updatebutton").after($label2);

									$(".updatebutton").remove();

								}

							})

					});
				});


			}
		})

	})




</script>



<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>
