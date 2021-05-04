<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , com.kh.semi.entrance.model.vo.*, com.kh.semi.user.model.vo.*" %>
    
    <% Entrance et = (Entrance)request.getAttribute("et"); %>
    <% EntranceDogInfo dogInfo = (EntranceDogInfo)request.getAttribute("dogInfo"); %>
    <% User user = (User)request.getAttribute("user");  %>
    
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
tr:hover {background-color:#f5f5f5;}
</style>
</head>
<body>
	<div id="outer">
	<br>
	<h2>입 소 신 청 서</h2>
	<br>
	<table id="table">
	<tr>
		<td><b>입소신청번호</b></td>
		<td><%=et.getEntAppNo() %></td>
	</tr>
	
	<tr>
		<td><b>이름</b></td>
		<td><%=user.getUserNm() %></td>
	</tr>
	
	<tr>
		<td><b>회원번호</b></td>
		<td><%=et.getUserNo() %></td>
	</tr>
	
	<tr>
		<td><b>연락처</b></td>
		<td><%=user.getPhone() %></td>
	</tr>
	
	<tr>
		<td><b>성별</b></td>
		<td><%=user.getGender() %>
	</tr>
	
	<tr>
		<td><b>생년월일</b></td>
		<td><%=user.getUserHb()%></td>
	</tr>
	
	<tr>
		<td><b>주소</b></td>
		<td><%=user.getAddress() %></td>
	</tr>
		
	<tr>
		<td><b>입소신청일자</b></td>
		<td><%=et.getWriteDt() %></td>
	</tr>
	
	<tr>
		<td><b>면담희망 일자</b></td>
		<td><%=et.getSelHopeDt() %></td>
	</tr>
	
	<tr>
		<td><b>신청현황</b></td>
		<td><%=et.getAppSit() %></td>
	</tr>
	
	<tr>
		<td><b>입소반려사유</b></td>
		<td>
			<%if(et.getCompanionRs()==null) {%>
			정보없음
			<%}else{ %>
			<%=et.getCompanionRs() %>
			<%} %>
		</td>
	</tr>
	
	<tr>
		<td><b>관리번호</b></td>
		<td><%=dogInfo.getEntNo() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 이름</b></td>
		<td><%=dogInfo.getDogNm() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 나이</b></td>
		<td><%=dogInfo.getDogAge() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 성별</b></td>
		<td>
		<%if(dogInfo.getDogGender().equals("M")){ %>
		수컷
		<%}else{%>
		암컷
		<%} %>
		</td>
	</tr>
	
	<tr>
		<td><b>강아지 견종</b></td>
		<td><%=dogInfo.getDogKind()%></td>
	</tr>
	
	<tr>
		<td><b>강아지 몸무게</b></td>
		<td><%=dogInfo.getDogWeight()%> kg</td>
	</tr>
	
	<tr>
		<td><b>강아지 키</b></td>
		<td><%=dogInfo.getDogHeight()%> cm</td>
	</tr>
	
	<tr>
		<td><b>강아지 접종</b></td>
		<td><%=dogInfo.getInoYn() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 병력</b></td>
		<td><%=dogInfo.getDisYn() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 수술여부</b></td>
		<td><%=dogInfo.getOperYn() %>
	</tr>
	
	<tr>
		<td><b>강아지 알레르기</b></td>
		<td><%=dogInfo.getAllegy() %>
	</tr>
	
	<tr>
		<td><b>강아지 취미</b></td>
		<td><%=dogInfo.getDogHobby() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 짖음정도</b></td>
		<td><%=dogInfo.getDogBark() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 배변활동</b></td>
		<td><%=dogInfo.getDogBowel() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 활동량</b></td>
		<td><%=dogInfo.getDogAct() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 분리불안</b></td>
		<td><%=dogInfo.getSeperate() %></td>
	</tr>
	
	<tr>
		<td><b>강아지 모색</b></td>
		<td><%=dogInfo.getFurColor() %>
	</tr>
	
	<tr>
		<td><b>강아지 순종여부</b></td>
		<td><%=dogInfo.getObYn() %>
	</tr>
	
	<tr>
		<td><b>강아지 등록여부</b></td>
		<td><%=dogInfo.getRegYn() %>
	</tr>
	
	<tr>
		<td><b>기타내용</b></td>
		<td><%=dogInfo.getDogChar() %>
	</tr>
	
	<tr>
		<td><b>강아지 입소상태</b></td>
		<td><%=dogInfo.getDogSit() %></td>
	</tr>
		
	</table>
	
	<br><br>
</div>
</body>
</html>