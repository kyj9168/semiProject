<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int userNo = Integer.parseInt(request.getParameter("userNo"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
  <script src="https://cdn.bootpay.co.kr/js/bootpay-3.0.2.min.js" type="application/javascript"></script>
  <link href="https://fonts.googleapis.com/css?family=Gaegu|Sunflower:300&display=swap" rel="stylesheet">
</head>
<body>
	<br><br>
	<div>
		<table style="margin:0 auto">
			<tr align="center">
				<td style="font-family: 'Sunflower', sans-serif;"><input class="btn btn-default" style="font-family: 'Sunflower', sans-serif;" type="button" onclick="confirmchat();" value="상담수락하기"></td>
			</tr>
			<tr><td><br><br></td></tr>
			<tr>
				<td><textarea rows="15" cols="50" style="resize:none;" readonly id="cahtarea"></textarea></td>
			</tr>
			<tr>
				<td><input id="message" type="text" style="width:75%;" id="message">&nbsp;&nbsp;<input class="btn btn-default" style="font-family: 'Sunflower', sans-serif;" type="button" value="전송하기" id="gomesseage"></td>
			</tr>
		</table>
	</div>

<script type="text/javascript">

	var reset = 0;

	$(function(){
		var userNo2 = <%=userNo%>
		var ws2Uri = "ws://localhost:8002/sixDestiny/storage?userNo:"+userNo2;

		ws = new WebSocket(ws2Uri);
		//서버 시작할 때 동작
		ws.onopen = function(evt){

		}

		//서버로부터 메세지를 전달 받을 때 동작하는 메소드
		ws.onmessage = function(event){
			onMessage(event);
		}

		//서버에서 에러가 발생할 경우 동작할 메소드
		ws.onerror = function(event){
			onError(event);
		}

		//서버와의 연결이 종료될 경우 동작하는 메소드
		ws.onclose = function(event){
			onClose(event);
		}

	});

	function confirmchat(){
		console.log("AAAA");
		var userNo = <%=userNo%>
		var wsUri = "ws://localhost:8002/sixDestiny/start?userNo:"+userNo+"&kind:admin";
		ws = new WebSocket(wsUri);
		//서버 시작할 때 동작
		ws.onopen = function(evt){
			if(reset == 0){
				var message = userNo + "#상담원이 연결되었습니다. 상담을 시작하세요!"
				ws.send(message);
				reset++;
				console.log(reset);
			}else{

			}
		}

		//서버로부터 메세지를 전달 받을 때 동작하는 메소드
		ws.onmessage = function(event){
			onMessage(event);
		}

		//서버에서 에러가 발생할 경우 동작할 메소드
		ws.onerror = function(event){
			onError(event);
		}

		//서버와의 연결이 종료될 경우 동작하는 메소드
		ws.onclose = function(event){
			onClose(event);
		}

		$("#message").keydown(function (key) {
	        if(key.keyCode == 13){
	        	console.log("엔터!");
	        	var message = $("#message").val();
	        	var result = userNo + "#상담원 : " + message
				console.log(result);
				ws.send(result);
				$("#message").val('');
				$("#message").focus();
	        }

	    });

		$("#gomesseage").click(function(){
			console.log("클릭!");

				var message = $("#message").val();
				var result = userNo+ "#상담원 : " + message
				console.log(result);
				ws.send(result);
				$("#message").val('');
				$("#message").focus();

		});

	}

	function onMessage(event){
		var content = event.data;
		console.log(content);
		var $chat = $("#cahtarea");
		$br = $("<br>");

		$chat.append(content);
		$chat.append("&#10;");

	}



</script>
</body>
</html>