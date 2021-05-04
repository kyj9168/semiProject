<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<html>
<head>
<title>Insert title here</title>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
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

</style>


</head>
<body>


	<form action="/sixDestiny/insert.no" method="post" encType="multipart/form-data">
		<div>
			<h4 style="font-family: 'Sunflower', sans-serif;">공지사항 작성</h4>
			<br>
			<br>
			<table width="800px" id="writerTable">
				<tr>
					<td><label
						style="font-family: 'Sunflower', sans-serif; font-size: 20px;">제목
							&nbsp;</label><input type="text" style="width: 750px; height: 40px"
						name="title"></td>
					<input type="hidden" value="<%=loginUser.getUserNo()%>" name="userNo">
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><textarea align="center" rows="15" cols="106" name="content"></textarea></td>
				</tr>
				<tr>
					<td><br></td>
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
	<!-- <script>
		$('.starRev span').click(function() {
			$(this).parent().children('span').removeClass('on');
			$(this).addClass('on').prevAll('span').addClass('on');
			return false;
		});
	</script> -->
	
	<%@ include file="../../../common/bottom_Include.jsp"%>


</body>
</html>