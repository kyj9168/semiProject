<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div>

		<h1 style="font-family: 'Sunflower', sans-serif;">★ 물품후원 절차 ★</h1>
		<hr>
		<br><br><br>
		<img src="/sixDestiny/images/productSupport.PNG">
		<br><br><br>
		<hr>
		<div>
			<br>
			<strong style="font-family: 'Sunflower', sans-serif;">위의 사항을 충분히 숙지하였고, 약관을 동의하시고 후원신청을 진행하시겠습니까?</strong> &nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="check" id="yes" class="yes" style="font-family: 'Sunflower', sans-serif;"><span style="font-family: 'Sunflower', sans-serif;">예</span>&nbsp;&nbsp;
				<input type="checkbox" name="check" id="no" class="no" style="font-family: 'Sunflower', sans-serif;"><span style="font-family: 'Sunflower', sans-serif;">아니요</span> <br>
			<br><br><input type="button" value="후원신청" onclick="changeView();" style="font-family: 'Sunflower', sans-serif; width:500px" class="btn btn-default">

		</div>

	</div>

	<script type="text/javascript">
		$(document).ready(
				function() {
					$('input[type="checkbox"][name="check"]').click(
							function() {
								if ($(this).prop('checked')) {
									$('input[type="checkbox"][name="check"]')
											.prop('checked', false);
									$(this).prop('checked', true);
								}
							});
				});

		function changeView() {
			if($('.yes').prop("checked")){
				location.href="/sixDestiny/views/member/6_support/3_product/2_application.jsp";
			}else{
				alert("약관을 동의하셔야 후원신청이 가능합니다.")
			}
		}
	</script>
<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>