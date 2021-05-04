<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int thisCommentNo = Integer.parseInt(request.getParameter("thisCommentNo"));
    int thisBoardNo = Integer.parseInt(request.getParameter("thisBoardNo"));
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

</head>
<body>
	<form action="<%= request.getContextPath() %>/updateCom.ub" method="post">

	<div style="text-align:center;">
	<h2><%=thisCommentNo %>번 댓글 수정</h2>
	<br>
	<textArea id="comcon" name="comcon" style="resize: none; width: 300px; height: 50px; "placeholder="글자 수는 60자로 제한" maxlength="60"></textArea>
	<br>
	<input type="submit" class="btn btn-default" style="outline:none;" value="확인" onclick="msg()">
	</div>
	<input type="hidden" name="thisCommentNo" value="<%=thisCommentNo %>">
	<input type="hidden" name="thisBoardNo" value="<%=thisBoardNo %>">
	</form>
	
	
<script type="text/javascript">

	function msg(){
	

	alert("수정이 완료되었습니다!^^");
	opener.location.reload();
	window.close();
	

}
	
	

</script>
</body>
</html>