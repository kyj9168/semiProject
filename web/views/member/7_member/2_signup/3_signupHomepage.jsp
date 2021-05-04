<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style>
#button {
	background: dimgray;
	Color: white;
	width: 300px;
	height: 50px;
}

#button2 {
	background: yellow;
	Color: Shaddlebrown;
	width: 300px;
	height: 50px;
	font-weight: bold;
}

.test {
	width: 50%;
	margin: 0 auto;
}

#signuptable {
	margin: 0 auto;
	width: 400px;
}

.lefttd {
	text-align: left;
}

#hiddentr {
	opacity: 0;
}

#loginTable {
	margin: 0 auto;
	width: 400px;
	height: 70px;
	text-align: left;
}

.hiddenpwd {
	opacity: 0;
}
</style>
<body>

<div  id="checkcheck">
<input type="hidden" value="1" id="check1">
</div>
<div  id="checkcheck2">
<input type="hidden"  value="1" id="check2">
</div>
<div  id="checkcheck3">
<input type="hidden" value="1" id="check3">
</div>

	<div>
		<h5 style="font-family: 'Sunflower', sans-serif;">* 은 필수 입력
			사항입니다.</h5>
		<br>
		<form action="<%=request.getContextPath()%>/sign.user" method="post" id="form">
			<table id="loginTable">

				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">*이름</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="userName"
						style="width: 400px; height: 50px;" required></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">*아이디</td>
				</tr>
				<tr>
					<td><input type="text" name="userId" style="width: 330px; height: 50px;" id="userId" required></td>
					<td>
						<button type="button" class="btn btn-default"
							style="font-family: 'Sunflower', sans-serif; width: 50px; height: 50px;" onclick="idCheck();">중복</button>
					</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">*
						비밀번호</td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="password"
						style="width: 400px; height: 50px;" id="passwordArea" required></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">*
						비밀번호확인</td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="password2"
						style="width: 400px; height: 50px;" id="passwordpass" required></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">*닉네임</td>
				</tr>
				<tr>
					<td><input type="text" name="userNickName"
						style="width: 330px; height: 50px;" id="nickNm" required></td>
					<td>
						<button type="button" class="btn btn-default"
							style="font-family: 'Sunflower', sans-serif; width: 50px; height: 50px;" onclick="checkNickNm();">중복</button>
					</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">*이메일</td>
				</tr>
				<tr>
					<td><input type="email" name="email"
						style="width: 330px; height: 50px;" id="inputEmail" required></td>
					<td>
						<button type="button" class="btn btn-default"
							style="font-family: 'Sunflower', sans-serif; width: 50px; height: 50px;"
							id="mailbtn">인증</button>
					</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr class="hiddenpwd">
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">인증번호</td>
				</tr>
				<tr class="hiddenpwd">
					<td><input type="text" name=""
						style="width: 330px; height: 50px;" id="randomNum" required></td>
					<td>
						<button type="button" class="btn btn-default"
							style="font-family: 'Sunflower', sans-serif; width: 50px; height: 50px;"
							id="pushNum">입력</button>
					</td>
				</tr>
			</table>
			<h5 style="font-family: 'Sunflower', sans-serif;">추가 입력 사항</h5>
			<br>
			<table id="loginTable">
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">생년월일</td>
				</tr>
				<tr>
					<td colspan="2"><input type="date" name="birthday"
						style="width: 400px; height: 50px; font-family: 'Sunflower', sans-serif;"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">성별</td>
				</tr>
				<tr>
					<td><span class="button-checkbox">
							<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width: 170px; height: 50px">남자</button>
							<input type="checkbox" class="hidden" name="gender" value="M">
						</span>

						<span class="button-checkbox">
							<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width: 170px; height: 50px">여자</button>
							<input type="checkbox" class="hidden" name="gender" value="F">
						</span>
					</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">주소</td>
				</tr>
				<tr>
					<td><input type="text" name="address" id="zipAddr"
						style="width: 330px; height: 50px;"></td>
					<td>
						<button type="button" class="btn btn-default"
							onclick="fn_setAddr();"
							style="font-family: 'Sunflower', sans-serif; width: 50px; height: 50px;">검색</button>
					</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">
						상세주소</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="address2"
						style="width: 400px; height: 50px;"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">반려견
						유무</td>
				</tr>
				<tr>
					<td><span class="button-checkbox">
							<button type="button" class="btn" data-color="info"
								style="font-family: 'Sunflower', sans-serif; width: 170px; height: 50px">있음</button>
							<input type="checkbox" class="hidden" name="dogYn" value="Y"
							id="Y">
					</span> <span class="button-checkbox">
							<button type="button" class="btn" data-color="info"
								style="font-family: 'Sunflower', sans-serif; width: 170px; height: 50px">없음</button>
							<input type="checkbox" class="hidden" name="dogYn" value="N"
							id="N">
					</span></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">가입경로</td>
				</tr>
				<tr>
					<td colspan="2"><select name="rtcd"
						style="width: 400px; height: 50px; font-family: 'Sunflower', sans-serif;">
							<option value="E1">SNS</option>
							<option value="E2">검색</option>
							<option value="E3">인터넷광고</option>
							<option value="E4">지인추천</option>
							<option value="E5">기타</option>
					</select>
				</tr>
				<tr>
					<td><br></td>
				</tr>
			</table>
			<div>
				<br> <br> <br> <br> 
				

				<input type="button"
					class="btn btn-default finalcheck"
					style="font-family: 'Sunflower', sans-serif; width: 400px" onclick="finalcheck();"
					value="회원가입"></input>
				
	
				
		</form>
	</div>

	<br>
	<br>



	<script type="text/javascript">
      $(function(){
         $('#mailbtn').click(function(){
        	
        	var inputEmail = $("#inputEmail").val();

            $('.hiddenpwd').each(function(){
            	$(this).css('opacity','1');
            });

            $.ajax({
            	url:"/sixDestiny/sendMail",
            	type:"post",
            	data:{inputEmail:inputEmail},
            	success:function(data){
					console.log(data);
					$("#randomNum").keyup(function(){
						var num = $("#randomNum").val();
	;
						if(data == num){
							$("#randomNum").css("border-color", "transparent");
						
							
						}else{
							$("#randomNum").css("border-color", "red");
					
						}
					});

					$("#pushNum").click(function(){
						var num = $("#randomNum").val();
						
						 var $divcheck=$("#checkcheck");
				        	
						if(data == num){
							console.log("인증번호 일치");
							$("#randomNum").attr("disabled", "true");
							$divcheck.html("");
							 var $input=$("<input   type='hidden' id='check1' >");
							console.log("벨류값 : " + $input.val());
							 $input.val("0");
							 console.log("바뀐값 : " + $input.val());
							$divcheck.append($input);
							
						}else{
							alert("인증번호를 잘못 입력 하셨습니다.");
							$divcheck.html("");
							 var $input=$("<input  type='hidden' id='check1' >");
							 $input.val("1");
							$divcheck.append($input);
						
						}
					})
            	},
            	error:function(){

            	}
            });
         });
      });
</script>

	<script type="text/javascript">
	function fn_setAddr() {
		var width = 500;
		var height = 600;
		daum.postcode.load(function(){
			new daum.Postcode({
				oncomplete: function(data){
					$("#zipAddr").val(data.address);
				}
			}).open({
				left: (window.screen.width / 2) - (width / 2),
				top: (window.screen.height / 2) - (height / 2)
			});
		});
	}

 	
</script>

	<script>
$(function () {
    $('.button-checkbox').each(function () {

        // Settings
        var $widget = $(this),
            $button = $widget.find('button'),
            $checkbox = $widget.find('input:checkbox'),
            color = $button.data('color'),
            settings = {
                on: {
                    icon: 'glyphicon glyphicon-check'
                },
                off: {
                    icon: 'glyphicon glyphicon-unchecked'
                }
            };

        // Event Handlers
        $button.on('click', function () {
            $checkbox.prop('checked', !$checkbox.is(':checked'));
            $checkbox.triggerHandler('change');
            updateDisplay();
        });
        $checkbox.on('change', function () {
            updateDisplay();
        });

        // Actions
        function updateDisplay() {
            var isChecked = $checkbox.is(':checked');

            // Set the button's state
            $button.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $button.find('.state-icon')
                .removeClass()
                .addClass('state-icon ' + settings[$button.data('state')].icon);

            // Update the button's color
            if (isChecked) {
                $button
                    .removeClass('btn-default')
                    .addClass('btn-' + color + ' active');
            }
            else {
                $button
                    .removeClass('btn-' + color + ' active')
                    .addClass('btn-default');
            }
        }

        // Initialization
        function init() {

            updateDisplay();

            // Inject the icon if applicable
            if ($button.find('.state-icon').length == 0) {
                $button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i> ');
            }
        }
        init();
    });
});
</script>
	<script type="text/javascript">
	$(function(){

		$("#passwordpass").keyup(function(){
			var password = $("#passwordArea").val();
			var password2 = $("#passwordpass").val();

			if(password == password2){
				console.log("같음!");
				$("#passwordpass").css("border-color", "transparent")
			}else{
				console.log("틀림!");
				$("#passwordpass").css("border-color", "red")
			}
		});
	});

	function idCheck(){
		var userId = $("#userId").val();
		 var $divcheck=$("#checkcheck2");
		$.ajax({
			url:"/sixDestiny/idCheck.user",
			type:"post",
			data:{userId:userId},
			success:function(data){
				alert(data);
				if(data=="해당 아이디가 존재합니다!"){
				$divcheck.html("");
				 var $input=$("<input type='hidden'  id='check2' >");
				 $input.val("1");
				$divcheck.append($input);}else{
					$divcheck.html("");
					 var $input=$("<input   type='hidden' id='check2' >");
					 $input.val("0");
					$divcheck.append($input);
					
				}
			},
			error:function(){
			

			}
		});
	}

	function checkNickNm(){
		var nickNm = $("#nickNm").val();
		 var $divcheck=$("#checkcheck3");
		$.ajax({
			url:"/sixDestiny/nickNmCheck.user",
			type:"post",
			data:{nickNm:nickNm},
			success:function(data){
				alert(data);
				if(data=="해당 닉네임이 존재합니다!"){
					$divcheck.html("");
					 var $input=$("<input  type='hidden' id='check3' >");
					 $input.val("1");
					$divcheck.append($input);}else{
						$divcheck.html("");
						 var $input=$("<input  type='hidden' id='check3' >");
						 $input.val("0");
						$divcheck.append($input);
						
					}
			},
			error:function(){

			}
		});
	}
</script>

<script>

function finalcheck(){
	var check1=$("#check1").val();
	var check2=$("#check2").val();
	var check3=$("#check3").val();
	if(check1==0&&check2==0&&check3==0){
		
		document.getElementById('form').submit();


		
	}else{
		
		alert("중복확인이나 인증이 잘못되었습니다. 다시 확인 해주세요!");
	}
	
	
	
	
	
}


</script>


	<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>