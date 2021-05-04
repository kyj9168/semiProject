<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>


<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../../common/inner_user_include.jsp" %>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	#outer{

		border:none; 
		width:700px; 
		height:auto; 
		margin:0 auto;
		padding-left:30px;
		font-family: 'Nanum Gothic', sans-serif;

	}	
	
	#div1{
		 
		text-align:center;
		border-radius:0.5em;
		margin:0 auto;
		
	
	}
	
	table tr td.td1{
		background: rgb(204, 230, 255);
		width: 95px;
		height: 45px;
		font-weight: bold;	
		border-radius: 10px;
	
	}



</style>
</head>
<body>
<br><br>
	<form action="/sixDestiny/update.user" method="post">
	<div align="center" id="outer" >
	
	<div id="div1">	
	<table>
	<tr>
		<td class="td1">이름</td>
		<td class="td2"><%= loginUser.getUserNm()%></td>
	</tr>
	
	<tr>
		<td><br></td>
	</tr>
	
	<tr>
		<td class="td1">아이디</td>
		<td class="td2"><%= loginUser.getUserId()%><input name="userId" type="hidden" value="<%= loginUser.getUserId()%>"></td>
	</tr>
	
	<tr>
		<td><br></td>
	</tr>

	<tr>
		<td class="td1">닉네임</td>
		<td class="td2"><input type="text" style="margin-left:30px; width:400px;" name="nickNm" value="<%= loginUser.getNickNm()%>" id="nickNm"></td>
	    <td>&emsp;</td>
	    <td class="td2">
	    	<input type="button" id="btn1" class="btn btn-default" value="중복" onclick="checkNickNm();"> 
	    	<input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
	    </td>
	</tr>
	
	<tr>
		<td><br></td>
	</tr>

	<tr>
		<td class="td1">이메일</td>
		<td class="td2"><input type="text" name="email" style="margin-left:30px; width:400px;" value="<%= loginUser.getEmail()%>"></td>
	</tr>
	
	<tr>
		<td><br></td>
	</tr>
	

	<tr>
		<td class="td1">생년월일</td>
		<td class="td2">
		<select name="year">
<%for(int year=1981; year<=1998; year++) {%>
	<%if(loginUser.getUserHb() != null && year == Integer.parseInt(loginUser.getUserHb().toString().substring(0, 4))) { %>
		<option selected><%=year %></option>
	<%} else {%>
		<option><%=year %></option>
	<%}%>
<%} %>
		</select>
		&nbsp;&nbsp;&nbsp;
		
		<select name="month">
		<%for(int month=1; month<=12; month++) {%>
	<%if(loginUser.getUserHb() != null && month == Integer.parseInt(loginUser.getUserHb().toString().substring(5, 7))) { %>
		<option selected><%=month %></option>
	<%} else {%>
		<option><%=month %></option>
	<%}%>
<%} %>
		</select>
		
		&nbsp;&nbsp;&nbsp;
		
		<select name="day">
			<%for(int day=1; day<=31; day++) {%>    
	<%if(loginUser.getUserHb() != null && day == Integer.parseInt(loginUser.getUserHb().toString().substring(8, 10))) { %>
		<option selected><%=day %></option>
	<%} else {%>
		<option><%=day %></option>
	<%}%>
<%} %>
		</select>
		</td>
	</tr>
	
	<tr>
		<td><br></td>
	</tr>

	<tr>
		<td class="td1">성별</td>
		<td class="td2">
		<%if(loginUser.getGender()==null) {%>
		성별이 없어요
		<%}else{ %>
		<%= loginUser.getGender()%></td>
		<%} %>
	</tr>
	
	<tr>
		<td><br></td>
	</tr>

	<tr>
		<td class="td1">주소</td>
		<td class="td2"><input type="text" name="address" style="margin-left:30px; width:400px;" id="zipAddr" value="<%= loginUser.getAddress()%>"></td>
		<td>&emsp;</td>
		<td><button type="button" class="btn btn-default" onclick="fn_setAddr();"
			style="font-family: 'Sunflower', sans-serif; width: 50px; height: 35px;">검색</button>
		</td>
	</tr>
	
	<tr>
		<td><br></td>
	</tr>

	<tr>
		<td class="td1">반려견유무</td>
		<td class="td2">
		
		<%if(loginUser.getDogYn()==null){%>
		<input type="radio" value="Y" name="dogYn" id="radio">키워요
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" value="N" name="dogYn">안키워요	
		<%}else if(loginUser.getDogYn().equals("Y")) {%>
		<input type="radio" value="Y" name="dogYn" id="radio" checked>키워요
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" value="N" name="dogYn">안키워요
		<%}else{%>
		<input type="radio" value="Y" name="dogYn" >키워요
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" value="N" name="dogYn" checked>안키워요
		<%}%>
		
		</td>
	</tr>
	
	</table>
	
	</div>
	<br><br><br>
	<input type="submit" value="수정"  style="width:300px" class="btn btn-default">
	</div>
	</form>
	
	<script>
	function checkNickNm(){
		var nickNm = $("#nickNm").val();

		$.ajax({
			url:"/sixDestiny/nickNmCheck.user",
			type:"post",
			data:{nickNm:nickNm},
			success:function(data){
				alert(data);
			},
			error:function(){
			}
		});
	}
	
	</script>
	
		<script type="text/javascript">
	function fn_setAddr() {
		var width = 500;
		var height = 600;
		daum.postcode.load(function(){
			new daum.Postcode({
				oncomplete: function(data){
					$("#zipAddr").val(data.address);
				}
			}).open({
				left: (window.screen.width / 2) - (width / 2),
				top: (window.screen.height / 2) - (height / 2)
			});
		});
	}

 	
</script>
<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>