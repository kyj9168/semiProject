<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>

#writerTable {
	margin: 0 auto;
}

#border {
	height: 100%;
	width: 55%;
	margin: 0 auto;
	font-family: 'Sunflower', sans-serif;
}

.starR {
	background:
		url('http://miuu227.godohosting.com/images/icon/ico_review.png')
		no-repeat right 0;
	background-size: auto 100%;
	width: 20px;
	height: 20px;
	display: inline-block;
	text-indent: -9999px;
	cursor: pointer;
}

.starR.on {
	background-position: 0 0;
}
</style>


</head>
<body>


 	<form action="<%= request.getContextPath() %>/upload.po" method="post" encType="multipart/form-data">
		<h3>분양후기 글쓰기</h3>

		<div id="border" align="center">

		<table align="center"> <!-- width="800px" id="writerTable" -->
				<tr>
					<td><label
						style="font-family: 'Sunflower', sans-serif; font-size: 20px;">제목
							&nbsp;</label><input type="text" style="width: 750px; height: 40px"
						name="title"></td>
					<td><input type="hidden" name="starRev" id="starRev"></td>
					<td><input type="text" value="<%= loginUser.getUserNo() %>" style="display:none" name="userNo"></td>
				</tr>
				<tr>

				<td>
						<div class="starRev">
					<label>후기 별점</label>&nbsp;&nbsp;&nbsp;
							<span class="starR" >1</span> <span class="starR">2</span> <span
								class="starR">3</span> <span class="starR" >4</span> <span
								class="starR">5</span>

						</div>

						</td>
				</tr>
				<tr>
					<td><textarea rows="15" cols="106" name="content"></textarea></td>
				</tr>
				<tr>

				</tr>
				<tr>
					<td align="center">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
							</div>
							<div class="custom-file">
								<input type="file" class="custom-file-input"
									id="parcelout_uploadFiles1" aria-describedby="inputGroupFileAddon01" name="parcelout_uploadFiles1">
								<label class="custom-file-label" for="inputGroupFile01">Choose
									file</label>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>

		<br> <br> <input type="submit" value="등록하기"
			class="btn btn-info" style="font-family: 'Sunflower', sans-serif;"></input>



	</form>
	<script>
		$('.starRev span').click(function() {
			$('#starRev').val($(this).text())

			$(this).parent().children('span').removeClass('on');
			$(this).addClass('on').prevAll('span').addClass('on');
			return false;
		});




	</script>
<%@ include file="../../../common/bottom_Include.jsp"%>


</body>
</html>
