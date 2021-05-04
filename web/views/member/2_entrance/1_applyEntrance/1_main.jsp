<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
#outer{
font-family: 'Sunflower', sans-serif;

}


</style>
</head>
<body>

	<img src="/sixDestiny/images/entrance1.jpg">

	<div id="outer">
		<br><br>
		<strong>위의 절차와 주의사항을 충분히 숙지하였고, 입소신청을 진행하시겠습니까?</strong> <input
			type="checkbox" name="check" id="yes" class="yes">예 <input
			type="checkbox" name="check" id="no" class="no">아니요 <br>
		<br><br>
		<input type="button" value="입소신청" class="btn btn-default" onclick="changeView();">

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
				location.href="/sixDestiny/views/member/2_entrance/1_applyEntrance/2_application.jsp";
			}else{
				alert("약관을 동의하셔야 입소신청이 가능합니다.")
			}
		}
	</script>

	<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>