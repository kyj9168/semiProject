<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html >
<html>
<head>
 <link href="https://fonts.googleapis.com/css?family=Gaegu|Sunflower:300&display=swap" rel="stylesheet">

<style>
#mypage {
	margin-left:600px;
	width:1000px;
	font-family: 'Sunflower', sans-serif;
}

table tr td.category {
	background: rgb(204, 230, 255);
	width: 95px;
	height: 35px;
	font-weight: bold;
	border-radius: 10px;
}

table tr td.category2 {
	padding-left: 5%;

}
.mama{
margin:0;
}

#under{
	margin-left:50px;
} 

</style>

<title>Insert title here</title>
<%@ include file="../../../common/inner_user_include.jsp" %>
</head>
<body>
	<%--전체 div --%>
	<div id="mypage">
		<div>
			<form>
			<br>
				<table>
					<tr>
						<td><br></td>
					</tr>
					<tr class=category3>
						<td class=category><label class="mama">이름 </label></td>
						<td class="category2"><label class="mama"><%=loginUser.getUserNm()%></label></td>
					</tr>
					<tr>
						<td><br></td>
					</tr>
					<tr class=category3>
						<td class=category><label class="mama">아이디 </label></td>
						<td class="category2"><label class="mama"><%=loginUser.getUserId()%></label></td>
					</tr>
					<tr>
						<td><br></td>
					</tr>
					<tr>
						<td class=category><label for="" class="mama">닉네임</label></td>
						<td class="category2"><label class="mama"><%=loginUser.getNickNm()%></label></td>
					</tr>
					<tr>
						<td><br></td>
					</tr>
					<tr>
						<td class=category><label for="" class="mama">이메일</label></td>
						<td class="category2"><label class="mama"><%=loginUser.getEmail()%></label></td>
					</tr>
					<tr>
						<td><br></td>
					</tr>
					
					<tr>
						<td class=category><label for="" class="mama">핸드폰번호</label></td>
						<td class="category2">
							<% if(loginUser.getPhone()==null) { %>
							<label class="mama">정보없음</label>
							<%} else {%>
							<%=loginUser.getPhone()%>
							<%} %>
						</td>
					</tr>
					
					<tr>
						<td><br></td>
					</tr>
					
					<tr>
						<td class=category><label for="" class="mama">생년월일</label></td>
						<td class="category2">
							<%if(loginUser.getUserHb()==null) {%>
							<label class="mama">정보없음</label>
							<%}else{ %>
							<label class="mama"><%=loginUser.getUserHb()%></label>
							<%} %>
						</td>
					</tr>
					<tr>
						<td><br></td>
					</tr>
					<tr>
						<td class=category><label for="" class="mama">성별</label></td>
						<td class="category2" >
							<%if(loginUser.getGender()==null) {%>
							<label class="mama">정보없음</label>
							<%}else{ %>
							<label class="mama"><%=loginUser.getGender()%></label>
							<%} %>
						</td>
					</tr>
					<tr>
						<td><br /></td>
					</tr>
					<tr>
						<td class=category><label for="" class="mama">주소</label></td>
						<td class="category2">
							<%if(loginUser.getAddress()==null) {%>
							<label class="mama">정보없음</label>
							<%}else{ %>
							<label class="mama"><%=loginUser.getAddress()%></label>
							<%} %>
						</td>
					</tr>
					<tr>
						<td><br /></td>
					</tr>
					<tr>
						<td class=category><label class="mama" for="">반려견 유무</label></td>
						<td class="category2" >
							<%if(loginUser.getDogYn()==null) {%>
							<label class="mama">정보없음</label>
							<%}else{%>
							<label class="mama"><%=loginUser.getDogYn()%></label>
							<%} %>
						</td>
					</tr>
					<tr>
						<td><br /></td>
					</tr>
					</table>
				</form>
			</div>	
				
			<br>
				
			<div id="under">
				<table>
					<tr>
						<td><input type="button" value="회원정보 수정"  class="btn btn-default" onclick="location.href='/sixDestiny/views/member/7_member/3_mypage/3_modify.jsp'"></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>&emsp;&emsp;</td>
						<%if(loginUser.getUserKind().equals("자체")) {%>
						<td>
						<input type="button" value="회원 탈퇴" class="btn btn-default" onclick="location.href='/sixDestiny/views/member/7_member/3_mypage/10_secessionPwd.jsp'">
						</td>
						<%}else{ %>
						<td>
						<button type="button" class="btn btn-default disabled" title="카카오 회원의 탈퇴는 Q&A에 문의해주세요">회원탈퇴</button>
						</td>
						<%} %>
					</tr>
				</table>
			</div>
				
			
	</div>


<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>