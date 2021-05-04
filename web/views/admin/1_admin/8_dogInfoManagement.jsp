<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.entrance.model.vo.*, com.kh.semi.adminboard.model.vo.PageInfo, com.kh.semi.parcelout.model.vo.*"%>
<%
	ArrayList<EntranceDogInfo> list = (ArrayList<EntranceDogInfo>) request.getAttribute("entranceDogInfo");
	ArrayList<ParcelOutResult> list2 = (ArrayList<ParcelOutResult>) request.getAttribute("parcelOutResult");
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
  <h1 style="font-family: 'Sunflower', sans-serif;">분양 관리</h1>
  <br><br>
  <p style="font-family: 'Sunflower', sans-serif; font-size:1.3em">육인연에 입소된 입소견들 정보</p>
  <br>
  <table class="table table-hover">
    <thead>
      <tr>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">입소견 번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">입소신청 번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">입소견 이름</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">입소견 성별</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">입소견 종류</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">입소현황</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">현황처리</td>
      </tr>
    </thead>
    <tbody>
      <% for(EntranceDogInfo dog : list) {%>
		<tr>
			<td style="font-family: 'Sunflower', sans-serif;"><%= dog.getEntNo() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= dog.getEntAppNo() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= dog.getDogNm() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= dog.getDogGender() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= dog.getDogKind() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= dog.getDogSit() %></td>
			<td style="font-family: 'Sunflower', sans-serif;">
				<% if(dog.getDogSit().equals("분양대기")){ %>
					<button class="btn btn-default" style="font-family: 'Sunflower', sans-serif; background:white;" name="insertMoney" onclick="finalParcelout(<%= dog.getEntNo() %>);">분양처리</button>
				<% }else{ %>
					<p style="font-family: 'Sunflower', sans-serif;">분양처리 완료</p>
				<% } %>
			</td>
		</tr>
      <% } %>
    </tbody>
  </table>
  <div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage=1&currentPage2=1'" class="btn btn-default"><<</button>
			<% if(currentPage <= 1){ %>
				<button disabled class="btn btn-default"><</button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage=<%=currentPage-1%>&currentPage2=1'" class="btn btn-default"><</button>
			<% } %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<button disabled class="btn btn-default"><%= p %></button>
			<% 	}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage=<%=p%>&currentPage2=1'" class="btn btn-default"><%=p %></button>
			<%
				}
				}
			%>

			<% if(currentPage >= maxPage){ %>
				<button disabled class="btn btn-default">></button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage=<%=currentPage+1%>&currentPage2=1'" class="btn btn-default">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage=<%=maxPage%>&currentPage2=1'" class="btn btn-default">>></button>
		</div>
 </div>
  <br><br><br><br><br>
  <p style="font-family: 'Sunflower', sans-serif; font-size:1.3em">새로운 보금자리를 찾아간 분양완료 내역</p>
  <br>
  <table class="table table-hover">
    <thead>
      <tr>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">분양신청 번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">분양완료 날짜</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">입소견 번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">분양 회원명</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">분양견 명</td>
      </tr>
    </thead>
    <tbody>
      <% for(ParcelOutResult por : list2) {%>
		<tr>
			<td style="font-family: 'Sunflower', sans-serif;"><%= por.getPcoAppNo() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= por.getPcoDt() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= por.getEntNo() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= por.getUserNm() %></td>
			<td style="font-family: 'Sunflower', sans-serif;"><%= por.getDogNm() %></td>
		</tr>
      <% } %>
    </tbody>
  </table>
	<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage2=1&currentPage=1'" class="btn btn-default"><<</button>
			<% if(currentPage2 <= 1){ %>
				<button disabled class="btn btn-default"><</button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage2=<%=currentPage2-1%>&currentPage=1'" class="btn btn-default"><</button>
			<% } %>

			<% for(int p = startPage2; p <= endPage2; p++){
				if(currentPage2 == p){
			%>
					<button disabled class="btn btn-default"><%= p %></button>
			<% 	}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage2=<%=p%>&currentPage=1'" class="btn btn-default"><%=p %></button>
			<%
				}
				}
			%>

			<% if(currentPage2 >= maxPage2){ %>
				<button disabled class="btn btn-default">></button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage2=<%=currentPage2+1%>&currentPage=1'" class="btn btn-default">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/selectAlldog.ent?currentPage2=<%=maxPage2%>&currentPage=1'" class="btn btn-default">>></button>
		</div>
  <script type="text/javascript">
  	function finalParcelout(entNo) {
		var entNo = entNo;
		if(confirm("해당 입소견을 분양처리 하시겠습니까?")){
			var userNo = prompt("분양받는 신청의 신청번호를 입력하세요");
			$.ajax({
				url:"/sixDestiny/updateFinal.pco",
				type:"post",
				data:{entNo:entNo, userNo:userNo},
				success:function(){
					location.href="/sixDestiny/selectAlldog.ent";
				},
				error:function(){

				}
			});
		}else{

		}
	}
  </script>
<%@ include file="../../common/bottom_Include.jsp"%>
</body>
</html>