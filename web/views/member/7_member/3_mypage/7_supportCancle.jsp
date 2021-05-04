<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int monSupNo = Integer.parseInt((request.getParameter("monSupNo")));
	System.out.println(monSupNo);
%>

<!DOCTYPE html>
<html  lang="ko">
<head>
<meta charset="UTF-8">

<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap&subset=korean" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
<title>후원취소</title>

<style>

	div{
	font-family: 'Do Hyeon', sans-serif;
	}

@import url('https://fonts.googleapis.com/css?family=Yeon+Sung&display=swap&subset=korean');

</style>
</head>

<body>

<div>
	<table style="margin-left:auto; margin-right:auto; margin-top:30px; width:90%">
		<tr>
			<td style="font-size:2.8em; background:rgb(204, 230, 255); border:1px solid black" align="center">취소사유를 선택하여 주세요</td>
		</tr>
		<tr><td><br><br>	</td></tr>
		<tr>
			<td align="center">
				<select style="width:80%; height:50px" name="cancleResult" id="selectCancle">
					<option value="S1">금전적인 부담 때문에</option>
					<option value="S2">해당 보호소에 대한 불만 때문에</option>
					<option value="S3">타 사이트를 이용하기 위해</option>
					<option value="S4">기타 사유</option>
				</select>
			</td>
		</tr>
		<tr><td><br><br></td></tr>
		<tr>
			<td align="center">

				<button onclick="cancle(<%=monSupNo%>)" class="btn btn-default">취소 신청하기</button>
			</td>
		</tr>
	</table>
</div>

<script type="text/javascript">
	function cancle(monSupNo){
		var monSupNo = monSupNo;
		var selectCancle = $("#selectCancle").val();
		console.log(monSupNo);
		console.log(selectCancle);
		$.ajax({
			url:"/sixDestiny/canclesup.mon",
			type:"post",
			data:{monSupNo:monSupNo, selectCancle:selectCancle},
			success:function(){
				close();
			},
			error:function(){

			}
		});
	}
</script>

</body>
</html>