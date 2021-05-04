<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
.supportArea fieldset {
	width:500px;
	margin:0 auto;
}
</style>
<script>
	/* var st = $(":input:radio[name=radio]:checked").val();

	 console.log(st); */

	$(function() {

		$("input:radio").change(function() {
			if ($("input:radio").is(":checked")) {
				console.log($(this).val());
				$("#money").val($(this).val())
			} else {

			}
		});
	});
</script>
</head>
<body>
	<div class="supportArea">
		<div>
			<form action="/sixDestiny/insertsup.on" method="post">
				<fieldset>
					<legend style="font-family: 'Sunflower', sans-serif; font-size:2em;">신청인 정보</legend>
					<table style="width:80%; margin:0 auto;">
						<tr><td><br></td></tr>
						<tr>
							<td style="font-family: 'Sunflower', sans-serif; text-align:left">이름</td>
						</tr>
						<tr>
							<td><input type="text" name="userNm" style="width:400px; height:50px;" value="<%=loginUser.getUserNm()%>" readonly></td>
						</tr>
						<tr><td><br></td></tr>
						<tr>
							<td style="font-family: 'Sunflower', sans-serif; text-align:left"">닉네임</td>
						</tr>
						<tr>
							<td>
								<input type="text" name="userId" style="width:400px; height:50px;" value="<%=loginUser.getNickNm()%>" readonly>
								<input type="hidden" name="userNo" style="width:400px; height:50px;" value="<%=loginUser.getUserNo()%>" readonly>
							</td>
						</tr>
						<tr><td><br></td></tr>
						<tr>
							<td style="font-family: 'Sunflower', sans-serif; text-align:left;">이메일</td>
						</tr>
						<tr>
							<td><input type="text" name="email" style="width:400px; height:50px;" value="<%=loginUser.getEmail()%>" readonly></td>
						</tr>
						<tr><td><br></td></tr>
						<tr>
							<td style="font-family: 'Sunflower', sans-serif; text-align:left;">연락처</td>
						</tr>
						<tr>
							<td colspan="2">
								<input style="width:27%; height: 50px;" maxlength="3" type="text" placeholder="010">&nbsp; -&nbsp;
								<input style="width:30%; height: 50px;" maxlength="4" type="text" >&nbsp; - &nbsp;
								<input style="width:30%; height: 50px;" maxlength="4" type="text" >
							</td>
						</tr>
						<tr><td><br><br></td></tr>
					</table>
				</fieldset>



				<br><br><br>
				<hr style="color:lightgray; width:800px"/>
				<br>
				<br>

				<fieldset>
					<legend style="font-family: 'Sunflower', sans-serif; font-size:2em;">후원물품</legend>
					<table style="width:80%; margin:0 auto;">
						<tr><td><br></td></tr>
						<tr>
							<td style="font-family: 'Sunflower', sans-serif; text-align:left;">카테고리	</td>
						</tr>
						<tr>
							<td>
								<select style="width:400px; height:50px; font-family: 'Sunflower', sans-serif;" name="product">
									<option value="C1">사료 및 간식</option>
									<option value="C2">이불 및 담요</option>
									<option value="C3">건강용품</option>
									<option value="C4">장난감 및 의류</option>
								</select>
							</td>
						</tr>
						<tr><td><br></td></tr>
						<tr>
							<td style="font-family: 'Sunflower', sans-serif; text-align:left;">상세물품</td>
						</tr>
						<tr>
							<td><input type="text" name="detailPro" style="width:400px; height:50px;"></td>
						</tr>
						<tr><td><br></td></tr>
					</table>
				</fieldset>
				<br><br>
				<pre id="pre" style="font-family: 'Sunflower', sans-serif; font-size:1.2em">물품 후원 시 상품 배송은 반드시 선불로 보내주셔야 합니다.
				선불이 아닐 경우, 발송자에게 반송되오니 다시한번 확인하시어 착오 없이 진행해 주시기 바랍니다.
				보내실 배송사는 어느곳이어도 상관없습니다.
				배송지 주소는 다음과 같습니다.
				주소 : 서울특별시 강남구 테헤란로 14길 6 남도빌딩 2F 육인연 담당자 앞</pre>

				<br><br><br>
				<input type="submit" value="신청" class="btn btn-default" style="width:200px; font-family: 'Sunflower', sans-serif;"> <input
					type="reset" value="취소" class="btn btn-default" onclick="location.href='/sixDestiny/index.jsp'" style="width:200px; font-family: 'Sunflower', sans-serif;">

			</form>


		</div>
	</div>


<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>