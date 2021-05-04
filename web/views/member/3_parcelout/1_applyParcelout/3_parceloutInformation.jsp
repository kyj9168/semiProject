<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , com.kh.semi.parcelout.model.vo.*"%>
    
    <% ParcelOut pco = (ParcelOut)request.getAttribute("pco"); %>
    <% ArrayList<parceOutAnswer> poa = (ArrayList<parceOutAnswer>)request.getAttribute("poa"); %>
    <% ArrayList<ParcelOutQuestion> poq = (ArrayList<ParcelOutQuestion>)request.getAttribute("poq");%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<title>신청서 상세내역</title>
<style>
table {
  border-collapse: collapse;
  width: 90%;
  margin:0 auto;
}

#outer{
	text-align:center;
	margin: 0 auto;
	font-family: 'Do Hyeon', sans-serif;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
<div id="outer">
	<br>
	<h2>분 양 신 청 서</h2>
	<br>
	<table id="table">
	<tr>
		<td><b>분양신청번호</b></td>
		<td><%=pco.getPcoAppNo()%><td>
	</tr>
	
	<tr>
		<td><b>회원번호</b></td>
		<td><%=pco.getUserNo() %></td>
	</tr>
	
	<tr>
		<td><b>면담희망 일자</b></td>
		<td><%=pco.getSelAppDt()%></td>
	</tr>
	
	<tr>
		<td><b>상태</b></td>
		<td><%=pco.getPcoSit() %></td>
	</tr>
	
	<tr>
		<td><b>분양반려이유</b></td>
		<td><%=pco.getCompanionRs() %></td>
	</tr>
	
	<tr>
		<%for(int i=0;i<1;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 분양을 원하시는 가장 큰 이유는 무엇인가요?</b></td>
		<td><%=poa.get(i).getAnsCon()%></td>
		<%} %>
	</tr>
	
	<tr>
		<%for(int i=1;i<2;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 분양을 결정하시기까지 얼마나 많은 시간을 고민하셨나요?</b></td>
		<td><%=poa.get(i).getAnsCon()%></td>
		<%} %>
	</tr>
	
	<tr>
		<%for(int i=2;i<3;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 키우고 있는 반려동물이 있으신가요?</b></td>
		<td><%=poa.get(i).getAnsCon()%></td>
		<%} %>
	</tr>
	
	<tr>
		<%for(int i=3;i<4;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 몇인가구 이신가요?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("3")) {%>
		<%=poa.get(i).getAnsCon()%>인가구이상
		<%}else{ %>
		<%=poa.get(i).getAnsCon()%>인가구
		<%} %>
		 </td>
		<%} %>
	</tr>
	
	<tr>
		<%for(int i=4;i<5;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 반려동물을 개인 사정으로 유기 시킨경험이 있으신가요? <br>있으시다면 이유는 무멋인가요?</b></td>
		<td><%=poa.get(i).getAnsCon()%></td>
		<%} %>
	</tr>
	
	<tr>
		<%for(int i=5;i<6;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 분양결정에 가족 모두가 동의 하십니까?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		동의
		<%}else if(poa.get(i).getAnsCon().equals("2")){ %>
		일부동의
		<%}else{ %>
		반대
		<%} %>
		</td>
		<%} %>
	</tr>
	
	<tr>
		<%for(int i=6;i<7;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 주거형태는 어떻게 되시나요?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		단독주택
		<%}else if(poa.get(i).getAnsCon().equals("2")) {%>
		공동주택
		<%}else{ %>
		아파트
		<%} %>
		</td>
		<%} %>
	</tr>
	
	<tr>
		<%for(int i=7;i<8;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 임대주택의 경우 집주인의 동의를 얻으셨나요?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		예
		<%}else{ %>
		아니요
		<%} %>
		</td>
		<%} %>
	</tr>
	
	
	<tr>
		<%for(int i=8;i<9;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 소음이나 위생 등으로 인한 이웃과의 마찰로 분양동물의<br> 양육이 불가능해질 경우 어떻게 하실건가요?</b></td>
		<td><%=poa.get(i).getAnsCon()%></td>
		<%} %>
	</tr>	
	
	<tr>
		<%for(int i=9;i<10;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 이사 또는 해외로 이주 시 반려동물의<br> 거취문제에 대해 어떻게 생각하십니까?</b></td>
		<td><%=poa.get(i).getAnsCon()%></td>
		<%} %>
	</tr>	
	
	<tr>
		<%for(int i=10;i<11;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 앞으로 결혼, 임신, 출산 등 가족의 변화가 있는 경우 <br>반려동물의 거취문제에 대해 어떻게 생각하십니까?</b></td>
		<td><%=poa.get(i).getAnsCon()%></td>
		<%} %>
	</tr>
	
	<tr>
		<%for(int i=11;i<12;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 분양시에, 유기동물의 구조와 치료, 보호비로 사용되는<br> 일정금액의 맞음비
				7만원을 납부해주셔야 합니다.<br> (임시보호의 경우 제외) 동의하십니까?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		예
		<%}else{ %>
		아니요
		<%} %>
		</td>
		<%} %>
	</tr>	
	
	<tr>
		<%for(int i=12;i<13;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 동물 관련 활동경험이 있으신가요? <br>또는 평소 알고 있던 동물단체들이 있다면 아는대로 적어주세요.</b></td>
		<td><%=poa.get(i).getAnsCon()%></td>
		<%} %>
	</tr>
	
	<tr>
		<%for(int i=13;i<14;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 길고양이에게 밥을 주신 적이 있으신가요? 또는 <br>유기동물 구조 경험이 있으신가요?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		예
		<%}else{ %>
		아니요
		<%} %>
		</td>
		<%} %>
	</tr>	
	
	<tr>
		<%for(int i=14;i<15;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 본인에게 병력이나 전염병이 있으신가요?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		예
		<%}else{ %>
		아니요
		<%} %>
		</td>
		<%} %>
	</tr>	
	
	<tr>
		<%for(int i=15;i<16;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 분양받은 반려견들에게 자신의 생활비 제외하고 양육비를<br>얼마정도 예상하시나요?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		0 ~ 50,000 미만 
		<%}else if(poa.get(i).getAnsCon().equals("2")) {%>
		50,000 ~ 100,000 미만
		<%}else{ %>
		100,000 이상
		<%} %>
		</td>
		<%} %>
	</tr>	
	
	<tr>
		<%for(int i=16;i<17;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 분양받은 반려견이 질병에 걸렸을시 얼마정도의 치료비를 <br>사용하실수 있으신가요?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		0 ~ 50,000 미만 
		<%}else if(poa.get(i).getAnsCon().equals("2")) {%>
		50,000 ~ 100,000 미만
		<%}else{ %>
		100,000 이상
		<%} %>
		</td>
		<%} %>
	</tr>	
	
	<tr>
		<%for(int i=17;i<18;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 반려동물의 수명은 15년 이상입니다.<br>10년이상 키우실 수 있으십니까?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		예
		<%}else{ %>
		아니요
		<%} %>
		</td>
		<%} %>
	</tr>	
		
	<tr>
		<%for(int i=18;i<19;i++) {%>
		<td><b><%=poa.get(i).getQuCd()%>. 동물보호법에 대하여 동의하시나요?</b></td>
		<td>
		<%if(poa.get(i).getAnsCon().equals("1")) {%>
		예
		<%}else{ %>
		아니요
		<%} %>
		</td>
		<%} %>
	</tr>			
	
	</table>
<br><br>
</div>
</body>
</html>