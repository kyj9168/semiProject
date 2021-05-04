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
			<form action="/sixDestiny/insertsup.re" method="post" name="reguralSupport">
				<fieldset>
					<legend style="font-family: 'Sunflower', sans-serif; font-size:2em;">신청인 정보</legend>
					<table style="width:80%; margin:0 auto;">
						<tr><td><br></td></tr>
						<tr>
							<td style="font-family: 'Sunflower', sans-serif; text-align:left">이름</td>
						</tr>
						<tr>
							<td>
								<input type="text" name="userNm" style="width:400px; height:50px;" value="<%=loginUser.getUserNm()%>" readonly>
								<input type="hidden" name="userNo" style="width:400px; height:50px;" value="<%=loginUser.getUserNo()%>" readonly>
							</td>
						</tr>
						<tr><td><br></td></tr>
						<tr>
							<td style="font-family: 'Sunflower', sans-serif; text-align:left;">닉네임</td>
						</tr>
						<tr>
							<td><input type="text" name="NickNm" style="width:400px; height:50px;" value="<%=loginUser.getNickNm()%>" readonly></td>
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
								<input name="tel1" style="width:27%; height: 50px;" maxlength="3" type="text" placeholder="010">&nbsp; -&nbsp;
								<input name="tel2" style="width:30%; height: 50px;" maxlength="4" type="text" >&nbsp; - &nbsp;
								<input name="tel3" style="width:30%; height: 50px;" maxlength="4" type="text" >
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
					<legend style="font-family: 'Sunflower', sans-serif; font-size:2em;">후원금</legend>
					<table style="width:80%; margin:0 auto;">
						<tr><td><br></td></tr>
						<tr>
							<td style="font-family: 'Sunflower', sans-serif; text-align:left;">금액입력	</td>
						</tr>
						<tr>
							<td><input type="text" name="resultmoney" style="width:400px; height:50px;" placeholder="천원 단위로 입력해주세요." id="money"></td>
						</tr>
						<tr><td><br></td></tr>
						<tr>
							<td>
								<input type="radio" name="supmoney" value="10000" >
								<label style="font-family: 'Sunflower', sans-serif;">10000원</label>&nbsp;&nbsp;&nbsp;
								<input type="radio" name="supmoney" value="50000" >
								<label style="font-family: 'Sunflower', sans-serif;">50000원</label>&nbsp;&nbsp;&nbsp;
								<input type="radio" name="supmoney" value="100000">
								<label style="font-family: 'Sunflower', sans-serif;">100000원</label>&nbsp;&nbsp;&nbsp;
								<input type="radio" name="supmoney" value="200000">
								<label style="font-family: 'Sunflower', sans-serif;">200000원</label>
							</td>
						</tr>
						<tr><td><br></td></tr>
					</table>
				</fieldset>

				<br><br><br>
				<input type="button" value="납입" class="btn btn-default" style="width:200px; font-family: 'Sunflower', sans-serif;" onclick="card();">
				<input type="button" value="취소" class="btn btn-default" style="width:200px; font-family: 'Sunflower', sans-serif;" onclick="cancel();">

			</form>



		</div>

		<br />
		<br />
		<br><br>

		<pre id="pre" style="font-family: 'Sunflower', sans-serif; font-size:1.2em">* 후원금은 결제일로부터 한달 단위로 갱신되고
				한번 후원한 닙입금은 취소불가, 취소 신청은 언제든 가능함을 알려드립니다.</pre>

	</div>
	<script type="text/javascript">
		function card() {
			document.reguralSupport.submit();
		}

		function cancel(){
			location.href="/sixDestiny/index.jsp"
		}
	</script>

<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>