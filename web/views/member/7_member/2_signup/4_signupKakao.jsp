<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<%
	String userId = request.getParameter("userId");
	String email = request.getParameter("email");
	String userName = request.getParameter("userName");
%>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
	<div style="line-height:200%">
	
		<h5 style="font-family: 'Sunflower', sans-serif;">* 은 필수 입력사항입니다.</h5>
		<br>
		
		<form action="<%= request.getContextPath() %>/kakaosignup" method="post">
			<table id="loginTable">
			
				<tr>
					<td><input type="hidden" name="userId" value="<%=userId %>"></td>
					<td><input type="hidden" name="userName" value="<%=userName%>"></td>
					<td><input type="hidden" name="email" value="<%=email%>"></td>
				</tr>
				
				<tr>
					<td style="font-family: 'Sunflower', sans-serif;" colspan="2">*닉네임</td>
				</tr>
				
				<tr>
					<td><input type="text" name="userNickName" style="width: 330px; height: 50px;" id="nickNm"></td>
					<td>
					<button type="button" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width: 50px; height: 50px;" onclick="checkNickNm();">중복</button>
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
				<td colspan="2"><input type="date" name="birthday" style="width: 400px; height: 50px; font-family: 'Sunflower', sans-serif;" ></td>
			</tr>
				
			<tr>
				<td style="font-family: 'Sunflower', sans-serif;" colspan="2">성별</td>
			</tr>
				
			<tr>
				<td>
					<span class="button-checkbox">
        				<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:50px">남자</button>
        				<input type="checkbox" class="hidden"  name="gender" value="M">
    				</span>
    	
    				<span class="button-checkbox">
       					<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:50px">여자</button>
       					<input type="checkbox" class="hidden" name="gender" value="F" >
    				</span>
				</td>
			</tr>
				
			
			<tr>
				<td style="font-family: 'Sunflower', sans-serif;" colspan="2">주소</td>
			</tr>
				
			<tr>
				<td>
					<input type="text" name="address" id="zipAddr" style="width: 330px; height: 50px;">
				</td>
				
				<td>
					<button type="button" class="btn btn-default" onclick="fn_setAddr();" style="font-family: 'Sunflower', sans-serif; width: 50px; height: 50px;">검색</button>
				</td>
				
			</tr>
				
			<tr>
				<td style="font-family: 'Sunflower', sans-serif;" colspan="2">상세주소</td>
			</tr>
				
			<tr>
				<td colspan="2"><input type="text" name="address2" style="width: 400px; height: 50px;"></td>
			</tr>
			
			
			<tr>
				<td style="font-family: 'Sunflower', sans-serif;" colspan="2">반려견 유무</td>
			</tr>
				
			<tr>
				<td>
					<span class="button-checkbox">
        				<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:50px">있음</button>
        					<input type="checkbox" class="hidden"  name="dogYn" value="Y" id="Y" >
    				</span>
    					
    				<span class="button-checkbox">
        				<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:50px">없음</button>
        					<input type="checkbox" class="hidden"  name="dogYn" value="N" id="N" >
    				</span>
    			</td>
			</tr>
				
			<tr>
				<td style="font-family: 'Sunflower', sans-serif;" colspan="2">가입경로</td>
			</tr>
				
			<tr>
				<td colspan="2">
					<select name="rtcd" style="width: 400px; height: 50px; font-family: 'Sunflower', sans-serif;">
							<option value="E1">SNS</option>
							<option value="E2">검색</option>
							<option value="E3">인터넷광고</option>
							<option value="E4">지인추천</option>
							<option value="E5">기타</option>
					</select>
			</tr>
			
		</table>
			
			<br>
			<br>
			<br>
			<br> 
			
			<input type="submit" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width: 400px" value="회원가입"></input>
		</form>
	</div>



<script type="text/javascript">
	

 	$(function(){
		$('input:checkbox[value=N]').prop('checked', false);
	});

	 $(function(){
		$('input:checkbox[value=Y]').change(function(){

			console.log("eqwe")

			$('input:checkbox[value=N]').prop('checked', false);

		})

	}) 

	 $(document).ready(
			function() {
				$('input[type="checkbox"][name="dogYn"]').change(
						function() {
							console.log("qwewqd")
							if ($(this).prop('checked')) {
								$('input[type="checkbox"][name="dogYn"]')
										.prop('checked', false);
								$(this).prop('checked', true);
							}
						});
			}); 
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

function checkNickNm(){
	var nickNm = $("#nickNm").val();

	$.ajax({
		url:"/sixDestiny/nickNmCheck.user",
		type:"post",
		data:{nickNm:nickNm},
		success:function(data){
			alert(data);
		},
		error:function(){

		}
	});
}
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

	<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>