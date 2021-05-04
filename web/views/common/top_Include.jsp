
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semi.user.model.vo.*"%>
<%
	User loginUser = (User)session.getAttribute("loginUser");
	int PagingSelect = 0;
%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Gaegu&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gaegu|Sunflower:300&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<title>육 인 연</title>
<style>
body.main {
	text-align: center;
}
#cattimg{
	width:50px;
	height:50px;
	-webkit-transform:scale(1);
	 -webkit-transition:0.3s;
}
#catt, #catt2{
	background:none;
	border:none;
	outline-style:none;
	margin-right: 24px;

}

#plusfriend-chat-button{
	-webkit-transform:scale(1);
	 -webkit-transition:0.3s;

}
#plusfriend-chat-button:hover{
	-webkit-transform:scale(1.2);


}

#cattimg:hover{
	-webkit-transform:scale(1.2);
}

img.main {
	height: 80px;
}

table.main {
	width: 100%
}

table tr td#log {
	text-align: right;
	padding-right: 130px;
}

#logbu, #regbu {
	margin-right: 20px;
}

#logout {
	margin-right: 20px;
}

div.ico {
	padding: 5px;
	visibility: visible;
	font-weight: bold;
	font-family: 'Gaegu', cursive;
	font-size: 1.5em;
	border-radius: 10px;
	cursor: default;
	margin: 2px;
}

button.main {
	background: #FFF;
	font-family: 'Sunflower', sans-serif;
	border: 0;
	outline: 0;
	cursor: pointer;
}

button.main:hover {
	font-weight: bold;
}

table#bot2 tr td {
	text-align: left;
}

div.topmenu {
	position: absolute;
	list-style: none;
	width: 100%;
	margin-right: auto;
	margin-left: auto;
	background: rgb(204, 230, 255);
	border-radius: 5px;
	margin-top: 20px;
}

div.topmenu  li.meme {
	padding: 0px;
	display: inline-block;
	vertical-align: top;
	width: 16%;
}

@media ( max-width : 1020px ) {
	div.topmenu  li.meme {
		padding: 0px;
		display: inline-block;
		vertical-align: top;
		width: 40%;
	}
}

div.topmenu  li.list {
	width: 20%;
	display: inline-block;
	margin-left: auto;
	margin-right: auto;
	margin-top: 0px;
}

div.topmenu li ul.submenu {
	text-align: center;
	padding: 0px;
	width: 100%;
	height: 0px;
	margin: 0px;
	-webkit-transition: height 0.4s, opacity 0.2s
}

img#main {
	margin-top: 30px;
}

div.topmenu  a {
	text-decoration: none;
	color: #666;
	font-family: 'Sunflower', sans-serif;
	font-weight: bold;
	visibility: hidden;
	-webkit-transition: visibility 0.2s;
}

div#bot {
	border-top: 1px solid rgb(200, 200, 200);
	height: 50px;
	width: 100%;
	padding-top: 20px;
}

div.topmenu  li ul.submenu li {
	vertical-align: top;
	width: 100%;
	visibility: visible;
	opacity: 0;
	height: 0px;
	-webkit-transition: height 0.4s, opacity 0.2s
}

div.topmenu:hover a {
	visibility: visible;
	-webkit-transition: visibility 0.2s;
}

div.topmenu:hover ul.submenu {
	height: 125px;
	opacity: 1;
	-webkit-transition: height 0.5s, opacity 0.5s;
}

div.topmenu:hover ul.submenu li {
	height: 30px;
	opacity: 1;
	-webkit-transition: height 0.5s, opacity 0.5s;
}

td#log {
	border-bottom: 1px solid rgb(200, 200, 200);
	padding-top: 5px;
}

.welcome {
	font-family: 'Sunflower', sans-serif;
}
</style>
</head>
<body class="main">
<script type="text/javascript">
	function logout() {
		location.href="<%=request.getContextPath()%>/logout";
	}
</script>
	<table class="main">
		<tr>
			<td id="title"><a href="/sixDestiny"><img class="main"
					src="/sixDestiny/images/mainImage.png" id="main"></a></td>
		</tr>


		<tr>
			<td id="log">
			<% if(loginUser == null){ %>
			<% }else if(loginUser.getUserId().equals("admin")){ %>
			<% }else{ %>
			<span
				style="display: inline-block; margin-right: 140px;" class="welcome"><%= loginUser.getNickNm()%>님
					환영합니다!♥</span>
			<% } %>
			<% if(loginUser == null){ %>
				<button class="main" id="logbu" onclick="location.href='/sixDestiny/views/member/7_member/1_login/1_main.jsp'">로그인</button>
			<% }else{ %>
				<button class="main" id="#logout" onclick="logout();">로그아웃</button>
			<% } %>
			<% if(loginUser == null){ %>
				<button class="main" id="regbu" onclick="location.href='/sixDestiny/views/member/7_member/2_signup/1_main.jsp'">회원가입</button>
			<% }else if(loginUser.getUserId().equals("admin")){ %>
				<button class="main" id="regbu" onclick="location.href='/sixDestiny/userManage'">관리자페이지</button>
			<% }else{ %>
				<button class="main" id="regbu" onclick="location.href='/sixDestiny/views/member/7_member/3_mypage/1_main.jsp'">마이페이지</button>
			<% } %>
		</tr>
	</table>

	<div class='topmenu'>

		<li class="meme"><a><div class="ico">페이지소개</div>
			<ul class="submenu">
				<li class="list"><a href="/sixDestiny/views/member/1_introduce/1_whatPage/1_main.jsp">육인연이란?</a></li>
				<li class="list"><a href="/sixDestiny/select.no">공지사항</a></li>
			</ul></li>
		<li class="meme"><a><div class="ico">입소신청</div></a>
			<ul class="submenu">
				<li class="list"><a onclick="
										<% if(loginUser == null){ %>
											alert('로그인 후 이용하세요.');
										<% }else{ %>
											location.href='/sixDestiny/views/member/2_entrance/1_applyEntrance/1_main.jsp'
										<% } %>
										" style="cursor:pointer;">입소신청</a></li>
				<li class="list"><a href="/sixDestiny/views/member/2_entrance/2_program/1_main.jsp">생활프로그램</a></li>
			</ul></li>
		<li class="meme"><a><div class="ico" >분양신청</div></a>
			<ul class="submenu">
				<li class="list"><a onclick="
										<% if(loginUser == null){ %>
											alert('로그인 후 이용하세요.');
										<% }else{ %>
											location.href='/sixDestiny/views/member/3_parcelout/1_applyParcelout/1_main.jsp'
										<% } %>
										" style="cursor:pointer;">분양신청</a></li>
				<li class="list"><a onclick="location.href='/sixDestiny/selectOutList.tn'" style="cursor:pointer;">분양후기</a></li>
			</ul></li>
		<li class="meme"><a><div class="ico">실종신고</div></a>
			<ul class="submenu">
				<li class="list"><a href="/sixDestiny/missingListo.bo">찾습니다</a></li>
				<li class="list"><a href="/sixDestiny/proListo.bo">보호중입니다</a></li>
			</ul></li>
		<li class="meme"><a><div class="ico">자유게시판</div></a>
			<ul class="submenu">
				<li class="list"><a href="/sixDestiny/selectList.bo?what=writer&search=&alignment=date&category=all&currentPage=1">자유게시판</a></li>

			</ul></li>
		<li class="meme"><a><div class="ico">후원</div></a>
			<ul class="submenu">
				<li class="list"><a onclick="
										<% if(loginUser == null){ %>
											alert('로그인 후 이용하세요.');
										<% }else{ %>
											location.href='/sixDestiny/views/member/6_support/1_regural/1_main.jsp'
										<% } %>
										" style="cursor:pointer;">정기후원</a></li>
				<li class="list"><a onclick="
										<% if(loginUser == null){ %>
											alert('로그인 후 이용하세요.');
										<% }else{ %>
											location.href='/sixDestiny/views/member/6_support/2_onetime/1_main.jsp'
										<% } %>
										" style="cursor:pointer;">일회성후원</a></li>
				<li class="list"><a onclick="
										<% if(loginUser == null){ %>
											alert('로그인 후 이용하세요.');
										<% }else{ %>
											location.href='/sixDestiny/views/member/6_support/3_product/1_main.jsp'
										<% } %>
										" style="cursor:pointer;">물품후원</a></li>
				<li class="list"><a href="/sixDestiny/selectSup.his" style="cursor:pointer;">후원내역</a></li>
			</ul></li>
	</div>
	<div style="height:150px"></div>
	<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
	<div style="position: fixed; left: 92%;top: 80%; " >
		<button type="button" id="catt2"><img src="/sixDestiny/images/chatting.png" id="cattimg"></button>
	</div>
	<%}else if(loginUser != null){ %>
	<div style="position: fixed; left: 92%;top: 80%; " >
		<div id="plusfriend-chat-button"></div>
		<br>
		<button style="margin-left:20px; " type="button" id="catt" onclick="gochat(<%=loginUser.getUserNo()%>);"><img src="/sixDestiny/images/chatting.png" id="cattimg"></button>
	</div>
	<% } %>

<script type="text/javascript">
	var wsUri = "ws://localhost:8002/sixDestiny/confirm";

	function gochat(userNo) {
		console.log("Aaa");
		var userNo = userNo;
		window.open("/sixDestiny/views/common/catting.jsp?userNo="+userNo, "window", "width=400,height=500");
	}

	$(function(){
		confirmChat();
	});

	function confirmChat(){
		websocket = new WebSocket(wsUri);
		websocket.onopen = function(evt) {
            onOpen(evt);
        };

        websocket.onmessage = function(evt) {
            onMessage(evt);
        };

        websocket.onerror = function(evt) {
            /* onError(evt); */
        };

        websocket.onclose = function(event){
        	 $("#catt2").css("-webkit-transform", "scale(1)");
		}
	}

	function onOpen(evt) {

    }

	function onMessage(evt){
		var result = evt.data;
		console.log(result);
		if(result != null){
			var set = setInterval(function()
	  			    {
	  			    	  $("#catt2").css("-webkit-transform", "scale(1)");
	  			    },500);

	  		 var set2 = setInterval(function()
	   			    {
	  			 $("#catt2").css("-webkit-transform", "scale(1.2)");
	   			    },1000);

	  		$("#catt2").click(function(){
		    		window.open("/sixDestiny/views/common/catting_admin.jsp?userNo="+result, result, "width=400,height=500");
		    		clearInterval(set);
		    		clearInterval(set2);
		    	  });
		}
	}

	//3be7cdf5e8cbf48b2a23b8c72856c080
</script>

<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('3be7cdf5e8cbf48b2a23b8c72856c080');
    // 플러스친구 1:1채팅 버튼을 생성합니다.
    Kakao.PlusFriend.createChatButton({
      container: '#plusfriend-chat-button',
      plusFriendId: '_xajlwT' // 플러스친구 홈 URL에 명시된 id로 설정합니다.
    });
  //]]>
</script>
</body>
</html>