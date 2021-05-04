<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.semi.support.money.model.vo.*, com.kh.semi.support.product.model.vo.*, com.kh.semi.adminboard.model.vo.PageInfo"%>
<%@ include file="../../common/top_Include.jsp"%>
<%
	ArrayList<MoneySup> list = (ArrayList<MoneySup>) request.getAttribute("moneyList");
	ArrayList<ProductSup> list2 = (ArrayList<ProductSup>) request.getAttribute("productList");
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%@ include file="../../common/inner_admin_include.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>

</style>
</head>
<body>
	<div class="container">
  <h1 style="font-family: 'Sunflower', sans-serif;">후원 내역</h1>
  <br><br>
  <p style="font-family: 'Sunflower', sans-serif; font-size:1.3em">육인연 회원들의 금전후원 내역 현황입니다.</p>
  <br>
  <table class="table table-hover">
    <thead>
      <tr>
     	<td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">내역번호</td>
      	<td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원번호</td>
      	<td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원이름</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">후원종류</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">후원금액</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">결제일</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">후원현황</td>
      </tr>
    </thead>
    <tbody>
      <% for(MoneySup ms : list) {%>
		<tr>
			<td style="font-family: 'Sunflower', sans-serif;" id="monSupNo"><%=ms.getSupAppNo()%></td>
			<td style="font-family: 'Sunflower', sans-serif;" id="userNo"><%= ms.getUserNo()%></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= ms.getUserNm()%></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= ms.getSupKind() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= ms.getSupPc() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= ms.getSupDt() %></td>
			<td style="font-family: 'Sunflower', sans-serif;">
				<% if(ms.getStatus().equals("S")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif;" name="okApply" onclick="okApply(<%=ms.getSupAppNo()%>);">신청승인</button>
				<% }else if(ms.getStatus().equals("T")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="okMoney" onclick="okMoney(<%=ms.getSupAppNo()%>);">납입확인</button>
				<% }else if(ms.getStatus().equals("N")){ %>
					<p style="font-family: 'Sunflower', sans-serif;">입금대기</p>
				<% }else if(ms.getStatus().equals("C")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="okCancle" onclick="okCancle(<%=ms.getSupAppNo()%>);">취소처리</button>
				<% }else if(ms.getSupKind().equals("정기") && ms.getStatus().equals("Y")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="okCancle" onclick="goRegural(<%=ms.getSupAppNo()%>);">정기결제</button>
				<% }else {%>
					<p style="font-family: 'Sunflower', sans-serif;">후원완료</p>
				<% } %>
			</td>
		</tr>
      <% } %>
    </tbody>
  </table>
  <div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage=1&currentPage2=1'" class="btn btn-default"><<</button>
			<% if(currentPage <= 1){ %>
				<button disabled class="btn btn-default"><</button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage=<%=currentPage-1%>&currentPage2=1'" class="btn btn-default"><</button>
			<% } %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<button disabled class="btn btn-default"><%= p %></button>
			<% 	}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage=<%=p%>&currentPage2=1'" class="btn btn-default"><%=p %></button>
			<%
				}
				}
			%>

			<% if(currentPage >= maxPage){ %>
				<button disabled class="btn btn-default">></button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage=<%=currentPage+1%>&currentPage2=1'" class="btn btn-default">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage=<%=maxPage%>&currentPage2=1'" class="btn btn-default">>></button>
		</div>

  <br><br><br><br><br>
  <p style="font-family: 'Sunflower', sans-serif; font-size:1.3em">육인연 회원들의 물품후원 내역 현황입니다.</p>
  <br>
  <table class="table table-hover">
    <thead>
      <tr>
      	<td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">내역번호</td>
      	<td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원번호</td>
      	<td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원이름</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">카테고리</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">후원물품</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">후원일</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">후원현황</td>
      </tr>
    </thead>
    <tbody>
      <% for(ProductSup ps : list2) {%>
		<tr>
			<td style="font-family: 'Sunflower', sans-serif;"><%= ps.getSupPdNo()%></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= ps.getUserNo()%></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= ps.getUserNm()%></td>
			<td style="font-family: 'Sunflower', sans-serif;">
				<% if(ps.getCtgCd().equals("C1")) {%>
					사료 및 간식
				<% }else if(ps.getCtgCd().equals("C2")) {%>
					이불 및 담요
				<% }else if(ps.getCtgCd().equals("C3")) {%>
					건강용품
				<% }else{ %>
					장난감 및 의류
				<% } %>
			</td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= ps.getPdNm() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= ps.getSupDt() %></td>
			<td style="font-family: 'Sunflower', sans-serif;">
				<% if(ps.getStatus().equals("Y")){ %>
					후원완료
				<%}else{%>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="confirmPost" onclick="confirmPost(<%= ps.getSupPdNo()%>)">인수확인</button>
				<% } %>
			</td>
		</tr>
      <% } %>
    </tbody>
  </table>
	<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage2=1&currentPage=1'" class="btn btn-default"><<</button>
			<% if(currentPage2 <= 1){ %>
				<button disabled class="btn btn-default"><</button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage2=<%=currentPage2-1%>&currentPage=1'" class="btn btn-default"><</button>
			<% } %>

			<% for(int p = startPage2; p <= endPage2; p++){
				if(currentPage2 == p){
			%>
					<button disabled class="btn btn-default"><%= p %></button>
			<% 	}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage2=<%=p%>&currentPage=1'" class="btn btn-default"><%=p %></button>
			<%
				}
				}
			%>

			<% if(currentPage2 >= maxPage2){ %>
				<button disabled class="btn btn-default">></button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage2=<%=currentPage2+1%>&currentPage=1'" class="btn btn-default">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.su?currentPage2=<%=maxPage2%>&currentPage=1'" class="btn btn-default">>></button>
		</div>
  </div>
  <script type="text/javascript">
  	$(function(){
  		setInterval(function()
  			    {
  			       $("button[name=okMoney]").each(function(){
  			    	   console.log("abc");
  			    	  $(this).css("background", "rgb(204, 230, 255)");
  			       });
  			    },500);

  		 setInterval(function()
   			    {
   			       $("button[name=okMoney]").each(function(){
   			    	  $(this).css("background", "white");
   			       });
   			    },1000);

  		setInterval(function()
  			    {
  			       $("button[name=okApply]").each(function(){
  			    	   console.log("갯수");
  			    	  $(this).css("background", "rgb(204, 230, 255)");
  			       });
  			    },500);

  		 setInterval(function()
   			    {
   			       $("button[name=okApply]").each(function(){
   			    	  $(this).css("background", "white");
   			       });
   			    },1000);

  		setInterval(function()
  			    {
  			       $("button[name=okCancle]").each(function(){
  			    	  $(this).css("background", "rgb(204, 230, 255)");
  			       });
  			    },500);

  		 setInterval(function()
   			    {
   			       $("button[name=okCancle]").each(function(){
   			    	  $(this).css("background", "white");
   			       });
   			    },1000);

  		setInterval(function()
  			    {
  			       $("button[name=confirmPost]").each(function(){
  			    	  $(this).css("background", "rgb(204, 230, 255)");
  			       });
  			    },500);

  		 setInterval(function()
   			    {
   			       $("button[name=confirmPost]").each(function(){
   			    	  $(this).css("background", "white");
   			       });
   			    },1000);

  	});

  	function okApply(monSupNo) {
		if(confirm("신청승인 처리 하시겠습니까?")){
			var monSupNo = monSupNo;

			$.ajax({
				url:"/sixDestiny/okApply.mon",
				type:"post",
				data:{monSupNo:monSupNo},
				success:function(data){
					location.href="/sixDestiny/selectAllUser.su";
					console.log("성공성공!")
				},
				error:function(){

				}
			});

		}else{
			return;
		}
	}

  	function okMoney(monSupNo) {
		if(confirm("납입완료 처리 하시겠습니까?")){
			var monSupNo = monSupNo;

			$.ajax({
				url:"/sixDestiny/okMoney.mon",
				type:"post",
				data:{monSupNo:monSupNo},
				success:function(data){
					location.href="/sixDestiny/selectAllUser.su";
					console.log("성공성공!")
				},
				error:function(){

				}
			});

		}else{
			return;
		}
	}

  	function confirmPost(monSupNo) {
		if(confirm("인수완료 처리 하시겠습니까?")){
			var monSupNo = monSupNo;

			$.ajax({
				url:"/sixDestiny/confirmPost.pro",
				type:"post",
				data:{monSupNo:monSupNo},
				success:function(data){
					location.href="/sixDestiny/selectAllUser.su";
					console.log("성공성공!")
				},
				error:function(){

				}
			});

		}else{
			return;
		}
	}

  	function okCancle(monSupNo) {
  		var monSupNo = monSupNo;
  		$.ajax({
  			url:"/sixDestiny/confirmRs.mon",
  			type:"post",
  			data:{monSupNo:monSupNo},
  			success:function(data){
  				console.log("aa");
  				var monSupNo = data["monSupNo"];
  				var result = data["result"];
  				if(confirm("정기후원 취소 처리 하시겠습니까?" +" \n후원취소사유 : " + result)){
  				$.ajax({
  					url:"/sixDestiny/okCancle.pro",
  					type:"post",
  					data:{monSupNo:monSupNo},
  					success:function(data){
  						location.href="/sixDestiny/selectAllUser.su";
  						console.log("성공성공!")
  					},
  					error:function(){

  					}
  				});

  				}else{
  					return;
  				}
  			},
  			error:function(){

  			}
  		});
	}

  	function goRegural(monSupNo) {
  		var monSupNo = monSupNo;
  		var application_id = "5d38293e02f57e00381e9c2e";
  		var private_key = "nM+YsThKJu0Ca+6dbOAXiq6VhH/VHb0GduKLcwtP8rM=";
  		$.ajax({
  			url:"https://api.bootpay.co.kr/request/token",
  			type:"post",
  			dataType:'json',
  			data:{application_id:application_id, private_key:private_key},
  			success:function(data){
				var token = data["data"]["token"];
				$.ajax({
					url:"/sixDestiny/select.bill",
					type:"post",
					data:{monSupNo:monSupNo},
					success:function(data){
						var billing_key = data["billingkey"];
						var order_id = data["order_id"];
						var supportDay = data["supportDay"];
						var day1 = 0;
						console.log(supportDay.length);
						if(supportDay.substr(0,1) == 0){
							day1 = supportDay.substr(1,1);
							console.log("aaaa" + day1);
						}
						var today = new Date();
						var day = today.getDate();

						console.log("bbb"+day);
						var price = 1000;
						if(confirm("정기결제를 진행하시겠습니까?")){
							if(day == day1){
								$.ajax({
									url:"https://api.bootpay.co.kr/subscribe/billing",
									type:"post",
									dataType:'json',
									beforeSend : function(xhr){
							            xhr.setRequestHeader("Authorization", token);
							        },
									data:{billing_key:billing_key, item_name:"정기후원", order_id:order_id, price:price},
									success:function(data){
										var receipt_id = data["data"]["receipt_id"];
										$.ajax({
											url:"/sixDestiny/updateReceipt.id",
											type:"post",
											data:{receipt_id:receipt_id, monSupNo:monSupNo},
											success:function(data){
												alert("결제가 완료되었습니다. \n결제 내역을 회원님의 메일로 전송하였습니다.");
												var eamil = data;
												$.ajax({
													url:"/sixDestiny/sendemail.sup",
													type:"post",
													data:{eamil:eamil, monSupNo:monSupNo},
													success:function(){
														console.log("이메일전송 성공");
													},
													error:function(){

													}
												});
											},
											error:function(){
											}
										});
									},
									error:function(data){
										alert("회원님의 카드사 문제로 결제가 완료되지 않았습니다. \n확인 후 다시 요청 바랍니다.");
									}
								});
							}else{
								alert("해당 정기후원 결제일이 아닙니다");
							}
						}else{
							alert("확인 후 다시 요청 해 주세요.")
						}
					},
					error:function(){

					}
				});
  			},
  			error:function(){

  			}
  		});
	}
  </script>
	<%@ include file="../../common/bottom_Include.jsp"%>
</body>
</html>