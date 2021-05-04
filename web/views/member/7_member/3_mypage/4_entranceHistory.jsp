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
    <%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%@ include file="../../../common/inner_user_include.jsp" %>
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
  <p style="font-family: 'Sunflower', sans-serif; font-size:1.3em"><%=loginUser.getNickNm()%>님의 입소신청 내역 현황입니다.</p>
  <br>
  <table class="table table-hover">
    <thead>
      <tr>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청일자</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">상담 희망일자</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청서보기</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청처리</td>
      </tr>
    </thead>
    <tbody>
      <% for(Entrance et : list) {%>
		<tr>
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
					<p style="font-family: 'Sunflower', sans-serif;">신청수락 대기</p>
				<% }else if(et.getAppSit().equals("I")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="entranceReault(<%=et.getEntAppNo()%>);">입소신청 반려</button>
				<% }else if(et.getAppSit().equals("E")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="entranceSel(<%=et.getEntAppNo()%>);">입소상담 수락</button>
				<% }else{ %>
					<p style="font-family: 'Sunflower', sans-serif;">입소완료</p>
				<% } %>
			</td>
		</tr>
      <% } %>
    </tbody>
  </table>
  <div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage=1&currentPage2=1'" class="btn btn-default"><<</button>
			<% if(currentPage <= 1){ %>
				<button disabled class="btn btn-default"><</button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage=<%=currentPage-1%>&currentPage2=1'" class="btn btn-default"><</button>
			<% } %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<button disabled class="btn btn-default"><%= p %></button>
			<% 	}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage=<%=p%>&currentPage2=1'" class="btn btn-default"><%=p %></button>
			<%
				}
				}
			%>

			<% if(currentPage >= maxPage){ %>
				<button disabled class="btn btn-default">></button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage=<%=currentPage+1%>&currentPage2=1'" class="btn btn-default">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage=<%=maxPage%>&currentPage2=1'" class="btn btn-default">>></button>
		</div>

  <br><br><br>
  <p style="font-family: 'Sunflower', sans-serif; font-size:1.3em"><%=loginUser.getNickNm()%>님의 분양신청 내역 현황입니다.</p>
  <br>
  <table class="table table-hover">
    <thead>
      <tr>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청일자</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">상담 희망일자</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청서보기</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청처리</td>
      </tr>
    </thead>
    <tbody>
      <% for(ParcelOut po : list2) {%>
		<tr>
			<td style="font-family: 'Sunflower', sans-serif;"><%= po.getAnsDt() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= po.getSelAppDt() %></td>
			<td>
			<button class="btn btn-default">
			<a href="/sixDestiny/parceloutform?pcoAppNo=<%=po.getPcoAppNo() %>" onclick="window.open(this.href,'_blank', 'width=700,height=700');return false;">신청서</a>
			</button>
			</td>
			<td style="font-family: 'Sunflower', sans-serif;">
				<% if(po.getPcoSit().equals("N")){ %>
					<p style="font-family: 'Sunflower', sans-serif;">신청수락 대기</p>
				<% }else if(po.getPcoSit().equals("I")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="parcelReault(<%=po.getPcoAppNo()%>);">분양신청 반려</button>
				<% }else if(po.getPcoSit().equals("E")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="parcelSel(<%=po.getPcoAppNo()%>);">분양상담 수락</button>
				<% }else if(po.getPcoSit().equals("Y")){ %>
					<p style="font-family: 'Sunflower', sans-serif;">분양대기</p>
				<% }else{ %>
					<p style="font-family: 'Sunflower', sans-serif;">분양완료</p>
				<% } %>
			</td>
		</tr>
      <% } %>
    </tbody>
  </table>
	<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage2=1&currentPage=1'" class="btn btn-default"><<</button>
			<% if(currentPage2 <= 1){ %>
				<button disabled class="btn btn-default"><</button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage2=<%=currentPage2-1%>&currentPage=1'" class="btn btn-default"><</button>
			<% } %>

			<% for(int p = startPage2; p <= endPage2; p++){
				if(currentPage2 == p){
			%>
					<button disabled class="btn btn-default"><%= p %></button>
			<% 	}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage2=<%=p%>&currentPage=1'" class="btn btn-default"><%=p %></button>
			<%
				}
				}
			%>

			<% if(currentPage2 >= maxPage2){ %>
				<button disabled class="btn btn-default">></button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage2=<%=currentPage2+1%>&currentPage=1'" class="btn btn-default">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/myApply.ap?currentPage2=<%=maxPage2%>&currentPage=1'" class="btn btn-default">>></button>
		</div>
  </div>

  <script type="text/javascript">
  	function viewEntranceApply(entAppNo) {
		var entAppNo = entAppNo;
	}

  	function entranceReault(entAppNo){
  		var entAppNo = entAppNo;
  		$.ajax({
  			url:"/sixDestiny/selectReason.ent",
  			type:"post",
  			data:{entAppNo:entAppNo},
  			success:function(data){
  				console.log(data);
				var reason = data;
				alert("회원님의 입소신청 반려 사유  : " + reason);
  			},
  			error:function(data){

  			}
  		});
  	}

  	function entranceSel(entAppNo) {
		var entAppNo = entAppNo;
		$.ajax({
			url:"/sixDestiny/selectSelData.ent",
			type:"post",
			data:{entAppNo:entAppNo},
			success:function(data){
				var date = data
				alert("회원님의 상담 날짜는 " + date + "입니다. \n오프라인 육인연 보호소는 서울특별시 강남구 테헤란로 14길 6 남도빌딩 2F에 위치하여 있습니다.");
			},
			error:function(){

			}
		});
	}

  	function parcelReault(pcoAppNo) {
		var pcoAppNo = pcoAppNo;
		$.ajax({
  			url:"/sixDestiny/selectReason.pco",
  			type:"post",
  			data:{pcoAppNo:pcoAppNo},
  			success:function(data){
  				console.log(data);
				var reason = data;
				alert("회원님의 분양신청 반려 사유  : " + reason);
  			},
  			error:function(data){

  			}
  		});
	}

  	function parcelSel(pcoAppNo) {
		var pcoAppNo = pcoAppNo;
		$.ajax({
			url:"/sixDestiny/selectSelData.pco",
			type:"post",
			data:{pcoAppNo:pcoAppNo},
			success:function(data){
				var date = data
				alert("회원님의 상담 날짜는 " + date + "입니다. \n오프라인 육인연 보호소는 서울특별시 강남구 테헤란로 14길 6 남도빌딩 2F에 위치하여 있습니다.");
			},
			error:function(){

			}
		});
	}
  </script>
  <%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>