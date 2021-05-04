<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.board.missing.model.vo.*"%>
    
    <%
    
    Missing b = (Missing) request.getAttribute("b");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 댓글 수정 </title>
	
	<style type="text/css">
		#wrap {
			width: 550px;
			margin: 0 auto 0 auto;
			text-align :center;
		}
	
		#commentUpdateForm{
			text-align :center;
		}
	</style>
	
	<script type="text/javascript">
	
	/* 	var httpRequest = null;
		
		// httpRequest 객체 생성
		function getXMLHttpRequest(){
			var httpRequest = null;
		
			if(window.ActiveXObject){
				try{
					httpRequest = new ActiveXObject("Msxml2.XMLHTTP");	
				} catch(e) {
					try{
						httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e2) { httpRequest = null; }
				}
			}
			else if(window.XMLHttpRequest){
				httpRequest = new window.XMLHttpRequest();
			}
			return httpRequest;	
		}
	 */
	
		function check()
		{
		 console.log("ddddddddddddddddddddd???????")
		
			var comment_content = document.getElementsByName('comment_content');
			var cNo= document.getElementsByName('cNo');
			if(!comment_content)
			{
				alert("내용을 입력하세요");
				return false;
			}
			else{
				
				var comment_content="comment_content="+comment_content;
				var cNo="cNo="+cNo;
				var num="num="+num;
				var uu="uu="+uu;
	/* 			httpRequest = getXMLHttpRequest();
				httpRequest.onreadystatechange = checkFunc;
				httpRequest.open("POST", "CommentUpdateAction.co", true);	
				httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=EUC-KR'); 
				httpRequest.send(param); */
			}
			return true;
			
			window.close();
		}
	 
	/* 	
		function checkFunc(){
			if(httpRequest.readyState == 4){
				// 결과값을 가져온다.
				var resultText = httpRequest.responseText;
				if(resultText == 1){
					if (opener != null) {
						// 부모창 새로고침
						window.opener.document.location.reload(); 
						opener.updateForm = null;
				        self.close();
					}
				}
			}
		} */
		

		
	</script>
	
</head>
<body>
<div id="wrap">
	<br>
	<b><font size="5" color="gray">댓글수정</font></b>
	<hr size="1" width="550">
	<br>

	<div id="commentUpdateForm">
 <form id="report" name="report" method="post" action="<%= request.getContextPath() %>/CommentChange" onsubmit="return check();">		
			<textarea rows="7" cols="70" name="comment_content" id="comment_content"></textarea>
			<br><br>
							<td><input type="hidden" value="<%= request.getParameter("cNo")%>" name="cNo" id="cNo"></td>
							<input type="hidden"  name="num" value="<%=request.getParameter("num")%>" />
							<input type="hidden"  name="uu" value="<%=request.getParameter("uu")%>" />
			<input type="submit" value="등록">
			<input type="button" value="창닫기" onclick="window.close()">
		</form>
	</div>
</div>

</body>
</html>