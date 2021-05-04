<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.entrance.model.vo.*, com.kh.semi.parcelout.model.vo.*, com.kh.semi.adminboard.model.vo.PageInfo"%>
 <%
	ArrayList<Entrance> list = (ArrayList<Entrance>) request.getAttribute("entranceList");
	ArrayList<ParcelOut> list2 = (ArrayList<ParcelOut>) request.getAttribute("parceloutList");
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

<%@ include file="../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%@ include file="../../common/inner_admin_include.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
  <script src="https://cdn.bootpay.co.kr/js/bootpay-3.0.2.min.js" type="application/javascript"></script>
</head>
<body>
	<div class="container">
  <h1 style="font-family: 'Sunflower', sans-serif;">신청 내역</h1>
  <br><br>
  <p style="font-family: 'Sunflower', sans-serif; font-size:1.3em">육인연 회원들의 입소신청 내역 현황입니다.</p>
  <br>
  <table class="table table-hover">
    <thead>
      <tr>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">내역번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원이름</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청일자</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">면담희망 일자</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청서</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청현황</td>
      </tr>
    </thead>
    <tbody>
      <% for(Entrance et : list) {%>
		<tr>
			<td style="font-family: 'Sunflower', sans-serif;"><%= et.getEntAppNo() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= et.getUserNo() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= et.getUserNm() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= et.getWriteDt() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= et.getSelHopeDt() %></td>
			
			<%--신청서  --%>
			<td>
			<button class="btn btn-default">
			<a href="/sixDestiny/applicationform?entAppNo=<%= et.getEntAppNo() %>" onclick="window.open(this.href,'_blank', 'width=600,height=700');return false;">신청서</a>
			</button>
			</td>
			
			<td style="font-family: 'Sunflower', sans-serif;">
				<% if(et.getAppSit().equals("N")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="entranceApplyKind(<%= et.getEntAppNo() %>);">신청 수락 및 반려</button>
				<% }else if(et.getAppSit().equals("I")){ %>
					<p style="font-family: 'Sunflower', sans-serif;">입소신청 반려</p>
				<% }else if(et.getAppSit().equals("E")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="endEntranceApply(<%= et.getEntAppNo() %>);">입소상담 확정</button>
				<% }else{ %>
					<p style="font-family: 'Sunflower', sans-serif;">입소완료</p>
				<% } %>
			</td>
		</tr>
      <% } %>
    </tbody>
  </table>
  <div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage=1&currentPage2=1'" class="btn btn-default"><<</button>
			<% if(currentPage <= 1){ %>
				<button disabled class="btn btn-default"><</button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage=<%=currentPage-1%>&currentPage2=1'" class="btn btn-default"><</button>
			<% } %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<button disabled class="btn btn-default"><%= p %></button>
			<% 	}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage=<%=p%>&currentPage2=1'" class="btn btn-default"><%=p %></button>
			<%
				}
				}
			%>

			<% if(currentPage >= maxPage){ %>
				<button disabled class="btn btn-default">></button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage=<%=currentPage+1%>&currentPage2=1'" class="btn btn-default">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage=<%=maxPage%>&currentPage2=1'" class="btn btn-default">>></button>
		</div>

  <br><br><br><br><br>
  <p style="font-family: 'Sunflower', sans-serif; font-size:1.3em">육인연 회원들의 분양신청 내역 현황입니다.</p>
  <br>
  <table class="table table-hover">
    <thead>
      <tr>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">내역번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원이름</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청일자</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">면담희망 일자</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청서</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청현황</td>
      </tr>
    </thead>
    <tbody>
      <% for(ParcelOut po : list2) {%>
		<tr>
			<td style="font-family: 'Sunflower', sans-serif;"><%= po.getPcoAppNo() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= po.getUserNo() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= po.getUserNm() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= po.getAnsDt() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= po.getSelAppDt() %></td>

			<%--신청서 --%>
			<td>
			<button class="btn btn-default">
			<a href="/sixDestiny/parceloutform?pcoAppNo=<%=po.getPcoAppNo() %>" onclick="window.open(this.href,'_blank', 'width=700,height=700');return false;">신청서</a>
			</button>
			</td>

			<td style="font-family: 'Sunflower', sans-serif;">
				<% if(po.getPcoSit().equals("N")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="parceloutApplyKind(<%= po.getPcoAppNo() %>);">신청 수락 및 반려</button>
				<% }else if(po.getPcoSit().equals("I")){ %>
					<p style="font-family: 'Sunflower', sans-serif;">분양신청 반려</p>
				<% }else if(po.getPcoSit().equals("E")){ %>
					<p style="font-family: 'Sunflower', sans-serif;">분양상담 확정</p>
				<% }else if(po.getPcoSit().equals("Y")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="endParcelout(<%= po.getPcoAppNo() %>);">분양대기</button>
				<% }else{ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="viewParcleUser(<%= po.getPcoAppNo() %>);">분양완료</button>
				<% } %>
			</td>
		</tr>
      <% } %>
    </tbody>
  </table>
	<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage2=1&currentPage=1'" class="btn btn-default"><<</button>
			<% if(currentPage2 <= 1){ %>
				<button disabled class="btn btn-default"><</button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage2=<%=currentPage2-1%>&currentPage=1'" class="btn btn-default"><</button>
			<% } %>

			<% for(int p = startPage2; p <= endPage2; p++){
				if(currentPage2 == p){
			%>
					<button disabled class="btn btn-default"><%= p %></button>
			<% 	}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage2=<%=p%>&currentPage=1'" class="btn btn-default"><%=p %></button>
			<%
				}
				}
			%>

			<% if(currentPage2 >= maxPage2){ %>
				<button disabled class="btn btn-default">></button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage2=<%=currentPage2+1%>&currentPage=1'" class="btn btn-default">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/selectAllUser.app?currentPage2=<%=maxPage2%>&currentPage=1'" class="btn btn-default">>></button>
		</div>
  </div>
  <script type="text/javascript">
  	function entranceApplyKind(entAppNo) {
  		var entAppNo = entAppNo;
		if(confirm("해당 신청내역을 수락 하시겠습니까?")){
			$.ajax({
				url:"/sixDestiny/okApply.ent",
				type:"post",
				data:{entAppNo:entAppNo},
				success:function(){
					location.href="/sixDestiny/selectAllUser.app"
					console.log("성공!");
				},
				error:function(){

				}
			});
		}else{
			var result = prompt("회원님에게 전송 할 신청 반려사유를 작성하여 주세요");
			console.log(result);
			$.ajax({
				url:"/sixDestiny/noApply.ent",
				type:"post",
				data:{entAppNo:entAppNo, result:result},
				success:function(){
					location.href="/sixDestiny/selectAllUser.app"
					console.log("성공!");
				},
				error:function(){

				}
			});
		}
	}

  	function endEntranceApply(entAppNo) {
  		var entAppNo = entAppNo;
  		if(confirm("해당 상담을 완료하였고, 입소를 확정 시키시겠습니까?")){
			$.ajax({
				url:"/sixDestiny/okEntrance.ent",
				type:"post",
				data:{entAppNo:entAppNo},
				success:function(){
					location.href="/sixDestiny/selectAllUser.app"
					console.log("성공!");
				},
				error:function(){

				}
			});
		}else{
			var result = prompt("회원님에게 전송 할 입소 반려사유를 작성하여 주세요");
			console.log(result);
			$.ajax({
				url:"/sixDestiny/noEntrance.ent",
				type:"post",
				data:{entAppNo:entAppNo, result:result},
				success:function(){
					location.href="/sixDestiny/selectAllUser.app"
					console.log("성공!");
				},
				error:function(){

				}
			});
		}
	}

  	/* function viewEntranceDog(entAppNo) {
		var entAppNo = entAppNo;
		$.ajax({
			url:"/sixDestiny/dogInfo.ent",
			type:"post",
			data:{entAppNo:entAppNo},
			success:function(data){
				var data = data;
				console.log(data);
				windowObj = window.open("/sixDestiny/views/member/7_member/3_mypage/8_entraceDog.jsp?data="+data, "window", "width=500,height=300");
			},
			error:function(){

			}
		});
	}*/

	function parceloutApplyKind(pcoAppNo) {
		var pcoAppNo = pcoAppNo;
		if(confirm("해당 신청내역을 수락 하시겠습니까?")){
			$.ajax({
				url:"/sixDestiny/okApply.pco",
				type:"post",
				data:{pcoAppNo:pcoAppNo},
				success:function(){
					location.href="/sixDestiny/selectAllUser.app"
					console.log("성공!");
				},
				error:function(){

				}
			});
		}else{
			var result = prompt("회원님에게 전송 할 신청 반려사유를 작성하여 주세요");
			console.log(result);
			$.ajax({
				url:"/sixDestiny/noApply.pco",
				type:"post",
				data:{pcoAppNo:pcoAppNo, result:result},
				success:function(){
					location.href="/sixDestiny/selectAllUser.app"
					console.log("성공!");
				},
				error:function(){

				}
			});
		}

	}

	function endParcelout(pcoAppNo) {
		var pcoAppNo = pcoAppNo;
  		if(confirm("해당 상담을 완료하였고, 분양 확정 시키시겠습니까?")){
			$.ajax({
				url:"/sixDestiny/okParcelout.pco",
				type:"post",
				data:{pcoAppNo:pcoAppNo},
				success:function(){
					location.href="/sixDestiny/selectAllUser.app"
					console.log("성공!");
				},
				error:function(){

				}
			});
		}else{
			var result = prompt("회원님에게 전송 할 분양 반려사유를 작성하여 주세요");
			console.log(result);
			$.ajax({
				url:"/sixDestiny/noParcelout.pco",
				type:"post",
				data:{pcoAppNo:pcoAppNo, result:result},
				success:function(){
					location.href="/sixDestiny/selectAllUser.app"
					console.log("성공!");
				},
				error:function(){

				}
			});
		}
	}
  </script>
  <%@ include file="../../common/bottom_Include.jsp"%>
</body>
</html>