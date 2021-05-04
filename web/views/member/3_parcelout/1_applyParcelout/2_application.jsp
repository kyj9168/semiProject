<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>

<html>
<head>
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<style>
#border {
	height: 2150px;
	width: 800px;
	margin-left:auto;
	margin-right:auto;
}



.entancetr {
	margin: 0 auto;
	height: 40px;
}

#ta {
	height: 400px;
	width: 700px;
	margin: 0 auto;
}

.entancetd {
	text-align: left;
}

input[type=text] {
	padding-left: 5px;
}

p {
	text-align: left;
}
#btn{
	margin-top : 1%;
}

</style>


</head>
<body>
<script>
$(function() {
    $( "#testDatepicker" ).datepicker({
    });
});
$(function(){
	$("#testDatepicker").on("change paste keyup", function() {
		   $("#selectEntrance").css("opacity", "1");
	});
});
</script>

	<form action="<%= request.getContextPath() %>/Insert.po" method="post">
		<h1 style="font-family: 'Sunflower', sans-serif;">분양 설문조사</h1>
		<input type="hidden" value="<%= loginUser.getUserNo() %>" name="userNo">
		<div style="width:70%; margin:0 auto;">
			<br><br>

			<table border="1" style="width:100%; height: 30px; text-align:center;">
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;1. 입양을 원하시는 가장 큰 이유는 무엇인가요?</p></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><input type="text" id="q1" size="90" name="applic1" style="width:100%; height:40px;"></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;2. 입양을 결정하시기까지 얼마나 많은 시간을 고민하셨나요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><input type="text" id="q2" size="90" name="applic2" style="width:100%; height:40px;"></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;3. 키우고 있는 반려동물이 있으신가요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><input type="text" id="q3" size="90" name="applic3" style="width:100%; height:40px;"></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;4. 몇인가구이시며 가족구성원이 어떻게 되시나요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="1" name="applic4">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">1인가구</span>&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" value="2" name="applic4">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">2인가구</span>&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" value="3" name="applic4">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">3인가구 이상</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;5. 반려동물을 개인 사정으로 유기 시킨경험이 있으신가요? 있으시다면 이유는 무멋인가요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="applic5" value="Y" >&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">예</span>
						&nbsp;&nbsp;<input type="text" name="applic6" size="40" id="test" >&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" name="applic5" value="N" >&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">아니요</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;6. 입양결정에 가족 모두가 동의 하십니까?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="1" name="applic7">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">동의</span>&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" value="2" name="applic7">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">일부동의</span> &nbsp;&nbsp;&nbsp;&nbsp;<input
						type="radio" value="3" name="applic7">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">반대</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;7. 주거형태는 어떻게 되나요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="1" name="applic8">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">단독주택</span>&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio"  value="2" name="applic8">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">공동주택</span>&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio"  value="3" name="applic8">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">아파트</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;8. 임대주택의 경우 집주인의 동의를 얻으셨나요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="1" name="applic9">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">예</span> &nbsp;&nbsp;&nbsp;&nbsp;<input
						type="radio"  value="2" name="applic9">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">아니요</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;9. 소음이나 위생 등으로 인한 이웃과의 마찰로 입양동물의 양육이 불가능해질 경우 어떻게
							하실건가요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><input type="text" id="q9" size="70" name="applic10" style="width:100%; height:40px;"></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;10. 이사 또는 해외로 이주 시 반려동물의 거취문제에 대해 어떻게 생각하십니까?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><input type="text" id="q10" size="70" name="applic11" style="width:100%; height:40px;"></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;11. 앞으로 결혼, 임신, 출산 등 가족의 변화가 있는 경우 반려동물의 거취문제에 대해
							어떻게 생각하십니까?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><input type="text" id="q11" size="70" name="applic12" style="width:100%; height:40px;"></td>
				</tr>



				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;12. 입양 시에, 유기동물의 구조와 치료, 보호비로 사용되는 일정금액의 맞음비 7만원을
							납부해주셔야 합니다. (임시보호의 경우 제외) 동의하십니까?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="1" name="applic13">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">예</span>&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio"  value="2" name="applic13">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">아니요</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;13. 동물 관련 활동경험이 있으신가요? 또는 평소 알고 있던 동물단체들이 있다면 아는대로
							적어주세요.</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><input type="text" id="q13" size="70" name="applic14" style="width:100%; height:40px;"></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;14. 길고양이에게 밥을 주신 적이 있으신가요? 유기동물 구조 경험이 있으신가요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"value="1" name="applic15">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">예</span> &nbsp;&nbsp;&nbsp;&nbsp;<input
						type="radio" value="2" name="applic15">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">아니요</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;15. 본인에게 병력이나 전염병이 있으신가요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="1" name="applic16">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">예</span>&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" value="2" name="applic16">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">아니요</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;16. 분양받은 반려견들에게 자신의 생활비 제외하고 양육비를 얼마정도 예상하시나요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="1" name="applic17">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">0 ~
						50,000 미만</span>&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"  value="2" name="applic17">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">50,000
						~ 100,000 미만</span>&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"  value="3" name="applic17">
						&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">100,000 이상</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;17. 분양받은 반려견이 질병에 걸렸을시 얼마정도의 치료비를 사용하실수 있으신가요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="1" name="applic18">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">0 ~
						50,000 미만</span> &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="2" name="applic18">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">50,000
						~ 100,000 미만</span>&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="3" name="applic18">
						&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">100,000 이상</span></td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;18. 반려동물의 수명은 15년 이상입니다. 10년이상 키우실 수 있으십니까?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="1" name="applic19">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">예</span>&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" value="2" name="applic19">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">아니요</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd"><p style="font-family: 'Sunflower', sans-serif; font-weight:bold;">&nbsp;&nbsp;19. 동물보호법<a href="/www.law.go.kr/법령/동물보호법">(www.law.go.kr/법령/동물보호법)</a>에 대하여 동의하시나요?</p>
					</td>
				</tr>
				<tr class="entancetr">
					<td class="entancetd">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="1" name="applic20">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">예</span>&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" value="2" name="applic20">&nbsp;&nbsp;<span style="font-family: 'Sunflower', sans-serif;">아니요</span></td>
				</tr >

				<tr class="entancetr">
						<td style="height:30px"><span style="font-family: 'Sunflower', sans-serif; font-weight:bold;">1:1면담 예약</span></td>
					</tr>
						<tr>
						<td>
							<input type="text" style="height:40px; width:100%;" id="testDatepicker" placeholder="클릭하세요" name="applic21">
						</td>
						</tr>
					<tr class="entancetr">
						<td colspan="2">
							<select style="height:40px; width:100%; opacity:0;" id="selectEntrance" name="applic22">
								<option>09:00~10:00</option>
								<option>10:00~11:00</option>
								<option>11:00~12:00</option>
								<option>14:00~15:00</option>
								<option>15:00~16:00</option>
								<option>16:00~17:00</option>
								<option>17:00~18:00</option>
							</select>
						</td>
					</tr>


			</table>
		</div>

	</form>

<br />
	<button type="submit" id="sub"class="btn btn-default" style=" font-family: 'Sunflower', sans-serif; width:200px" onclick="entranceMoney();" disabled>제출</button>
	<br /><br />
	<button type="button" id="btn"class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width:200px" onclick="entranceMoney();">확인</button>





	<script>
		$(document).ready(function() {

			// 라디오버튼 클릭시 이벤트 발생
			$("input:radio[name=applic5]").click(function() {

				if ($("input:radio[name=applic5]:checked").val() == "Y") {

					$("input:text[name=applic6]").attr("disabled", false);

				} else if ($("input[name=applic5]:checked").val() == "N") {
					$("input:text[name=applic6]").attr("disabled", true);

				}
			});
		});





			$('#btn').click(function(){

				var i = 0;

				var deprivation1 = $('input[name=applic7]:checked').val(); //3
				var deprivation2 = $('input[name=applic9]:checked').val(); //2
				var deprivation3 = $('input[name=applic13]:checked').val(); //2
				var deprivation4 = $('input[name=applic20]:checked').val(); //2




				$('input[type=text]').each(function(index, item){

					if($('input[type=text]').eq(index).val() != "" && $('input[type=text]').eq(index).prop("disabled") == false){

					i++;

					}
				})
				$('input[type=radio]').each(function(index, item){
					if($('input[type=radio]').eq(index).is(':checked')){

						i++;
					}
				})

				if($('input[type=radio]').eq(4).is(':checked')){

					if(i <= 18){

						alert("값을 모두 쓰셔야합니다");

					}else{
						if(deprivation1 == 3 || deprivation2 == 2 || deprivation3 == 2 || deprivation4 == 2){
							alert("자격 박탈 되셨습니다.. 신중히 읽어보시고 대답해주세요..")
						}else{
							$('#sub').attr("disabled" , false)

						}


					}

				}else{

					if(i <= 19){

						alert("값을 모두 쓰셔야합니다");

					}else{
						if(deprivation1 == 3 || deprivation2 == 2 || deprivation3 == 2 || deprivation4 == 2){
							alert("자격 박탈 되셨습니다.. 신중히 읽어보시고 대답해주세요..")
						}else{
							$('#sub').attr("disabled" , false)

						}
					}
				}




			})



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
		$("#testDatepicker").change(function(){
			var date = $("#testDatepicker").val();
			console.log(date);
			$.ajax({
				url:"/sixDestiny/selectDay.pco",
				type:"post",
				data:{date:date},
				success:function(data){
					console.log(data);
					$("#selectEntrance option").remove();

					$option1 = $("<option>").val("0900").text("09:00~10:00");
					$option2 = $("<option>").val("1000").text("10:00~11:00");
					$option3 = $("<option>").val("1100").text("11:00~12:00");
					$option4 = $("<option>").val("1400").text("14:00~15:00");
					$option5 = $("<option>").val("1500").text("15:00~16:00");
					$option6 = $("<option>").val("1600").text("16:00~17:00");
					$option7 = $("<option>").val("1700").text("17:00~18:00");

					$("#selectEntrance").append($option1);
					$("#selectEntrance").append($option2);
					$("#selectEntrance").append($option3);
					$("#selectEntrance").append($option4);
					$("#selectEntrance").append($option5);
					$("#selectEntrance").append($option6);
					$("#selectEntrance").append($option7);

					console.log($option1.val());

					for(var i = 0; i < data.length; i++){
						if($option1.val() == data[i]){
							console.log("1");
							$option1.prop("disabled", true);
						}
						if($option2.val() == data[i]){
							console.log("2");
							$option2.prop("disabled", true);
						}
						if($option3.val() == data[i]){
							console.log("3");
							$option3.prop("disabled", true);
						}
						if($option4.val() == data[i]){
							console.log("4");
							$option4.prop("disabled", true);
						}
						if($option5.val() == data[i]){
							console.log("5");
							$option5.prop("disabled", true);
						}
						if($option6.val() == data[i]){
							console.log("6");
							$option6.prop("disabled", true);
						}
						if($option7.val() == data[i]){
							console.log("7");
							$option7.prop("disabled", true);
						}
					}


				},
				error:function(){

				}
			});
		});
	});
</script>


	<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>