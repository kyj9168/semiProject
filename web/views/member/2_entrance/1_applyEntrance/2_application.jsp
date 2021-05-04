<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<title>입소신청</title>
<style>
.entranceDiv td {
	font-family: 'Sunflower', sans-serif;
}

.entranceDiv input {
	border:none;
	text-align:center;
}

#selectarea1, #selectarea2, #selectarea3 {
	opacity:0;
}
</style>
</head>
<body>
	<script type="text/javascript">
	$(function() {
	    $( "#testDatepicker" ).datepicker({
	    });
	});
	</script>
	<div class="entranceDiv">
		<h1 style="font-family: 'Sunflower', sans-serif;">입소신청</h1>
		<br>
		<br><br>
		<form name="entrance" action="<%= request.getContextPath() %>/ApplicationInsert" method="post" encType="multipart/form-data">
		<div align="center">
			<div style="width:70%">
				<table border="1" style="width:100%; height: 30px; text-align:center;">
					<tr>
						<td colspan="3" style="font-size:2em; font-family: 'Sunflower', sans-serif;">신청인정보</td>
					</tr>
					<tr>
						<td style="width:166px">이름</td>
						<td colspan="2"><input readonly style="width:100%; height: 30px;" type="text" value="<%=loginUser.getUserNm()%>" name="entName"></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td colspan="2">
							<input style="width:30%; height: 30px;" type="text" maxlength="3" placeholder="010" name="entPhone1"> -
							<input style="width:30%; height: 30px;" type="text" maxlength="4" name="entPhone2"> -
							<input style="width:30%; height: 30px;" type="text" maxlength="4" name="entPhone3">
						</td>
					</tr>
					<tr>
						<td>성별</td>
						<td colspan="2">
							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">남자</button>
        						<input type="checkbox" class="hidden"  value="M" name="gender">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">여자</button>
        					<input type="checkbox" class="hidden"  value="F" name="gender"> 
    						</span>
						</td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td colspan="2"><input type="date" style="width:100%; height: 30px;" name="birthday"></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="addres" id="zipAddr"
							style="width:100%; height: 30px;"></td>
						<td>
							<button type="button" class="btn btn-default"
								onclick="fn_setAddr();"
								style="font-family: 'Sunflower', sans-serif; width:100%; height: 30px;">검색</button>
						</td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td colspan="2"><input type="text" style="width:100%; height: 30px;" name="addres2"></td>
					</tr>
					<tr>
						<td style="height:30px" rowspan="2">1:1면담 예약</td>
						<td colspan="2" style="height:30px" >
							<input type="text" id="testDatepicker" placeholder="클릭하세요" name="test">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<select style="height:30px; width:100%; opacity:0;" id="selectEntrance" name="test2">
								<option value="0900">09:00~10:00</option>
								<option value="1000">10:00~11:00</option>
								<option value="1100">11:00~12:00</option>
								<option value="1400">14:00~15:00</option>
								<option value="1500">15:00~16:00</option>
								<option value="1600">16:00~17:00</option>
								<option value="1700">17:00~18:00</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<script type="text/javascript">
				$(function(){
					$("#testDatepicker").on("change paste keyup", function() {
						   $("#selectEntrance").css("opacity", "1");
					});
				});

				function open1() {
					$("#selectarea1").css("opacity", "1");
				}

				function open2() {
					$("#selectarea2").css("opacity", "1");
				}

				function open3() {
					$("#selectarea3").css("opacity", "1");
				}
			</script>
			<br><br><br><br><br>
			<div style="width:70%">
				<table style="width:100%; height: 30px; text-align:center;" border="1">
					<tr>
						<td colspan="4" style="font-size:2em;">입소견정보</td>
					</tr>
					<tr>
						<td style="width:166px">이름</td>
						<td colspan="3"><input type="text" style="width:100%; height: 30px;" name="dogNm"></td>
					</tr>
					<tr>
						<td>나이</td>
						<td colspan="3">
							<select id="dogAge" name="dogAge" style="width:100%; height: 30px;">
								<option value="0개월~6개월">0개월 ~ 6개월</option>
								<option value="6개월~1년">6개월 ~ 1년</option>
								<option value="1년~5년">1년 ~ 5년</option>
								<option value="5년~10년">5년 ~ 10년</option>
								<option value="10년이상">10년이상</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>성별</td>
						<td colspan="3"><span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">남자</button>
        						<input type="checkbox" class="hidden" value="M" name="dogGender" id="dogGender1">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">여자</button>
        					<input type="checkbox" class="hidden"  value="F" name="dogGender" id="dogGender2">
    						</span>
    					</td>
					</tr>
					<tr>
						<td>견종</td>
						<td colspan="3">
							<select style="width:100%; height: 30px;" name="dogKind" id="dogKind">
								<option value="코카스파니엘">코카스파니엘</option>
								<option value="요크셔테리어">요크셔테리어</option>
								<option value="푸들">푸들</option>
								<option value="말티즈">말티즈</option>
								<option value="웰시코기">웰시코기</option>
								<option value="포메라니안">포메라니안</option>
								<option value="스피치">스피치</option>
								<option value="닥스훈트">닥스훈트</option>
								<option value="사모예드">사모예드</option>
								<option value="골든리트리버">골든리트리버</option>
								<option value="허스키">허스키</option>
								<option value="쉐퍼드">쉐퍼드</option>
								<option value="믹스">믹스</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>몸무게</td>
						<td colspan="3"><input type="text" style="width:100%; height: 30px;" id="weight" name="dogWeight"></td>
					</tr>
					<tr>
						<td>키</td>
						<td colspan="3"><input type="text" style="width:100%; height: 30px;" name="dogHeight"></td>
					</tr>
					<tr>
						<td style="height:30px" rowspan="2">접종유무</td>
						<td colspan="3">
							<span class="button-checkbox">
        						<button onclick="open1();" type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">유</button>
        						<input type="checkbox" class="hidden"  value="Y" name="inoYn">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">무</button>
        					<input type="checkbox" class="hidden"  value="N" name="inoYn" id="ino">
    						</span>
						</td>
					</tr>
					<tr>
						<td colspan="4" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">
							<div id="selectarea1">
							<input type="checkbox" name="t1" value="I1">종합백신 &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="t1" value="I2">광견병 &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="t1" value="I3">코로나(장염) &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="t1" value="I4">켄넬코프(호흡기) &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="t1" value="I5">신종플루
							</div>
						</td>
					</tr>
					<tr>
						<td style="height:30px" rowspan="2">병력</td>
						<td colspan="3">
							<span class="button-checkbox">
        						<button onclick="open2();"  type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">유</button>
        						<input type="checkbox" class="hidden" id="dis" name="disYn"  value="Y"/>
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">무</button>
        						<input type="checkbox" class="hidden" name="disYn"  value="N"/>
    						</span>
						</td>
					</tr>
					<tr>
						<td colspan="4" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">
						<div id="selectarea2">
							<input type="checkbox" name="tt1" value="D1">귀염증 &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="tt2" value="D2">내부기생충 &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="tt3" value="D3">관절염 &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="tt4" value="D4">위염 &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="tt5" value="D5">옴
						</div>
						</td>
					</tr>
					<tr>
						<td style="height:30px" rowspan="2">수술여부</td>
						<td colspan="3">
							<span class="button-checkbox">
        						<button onclick="open3();"  type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">유</button>
        						<input type="checkbox" class="hidden"  value="Y" name="operYn">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">무</button>
        					<input type="checkbox" class="hidden"  value="N" name="operYn">
    						</span>
						</td>
					</tr>
					<tr>
						<td colspan="4" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">
						<div id="selectarea3">
							<input type="checkbox" name="ttt1" value="O1">중성화 &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="ttt2" value="O2">성대수술 &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="ttt3" value="O3">쓸개골탈구 &nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="ttt4" value="O4">심장수술
						</div>
						</td>
					</tr>
					<tr>
						<td>취미</td>
						<td colspan="4"><input type="text" style="width:100%; height: 30px;" name="dogHobby"></td>
					</tr>
					<tr>
						<td>알레르기</td>
						<td colspan="4"><input type="text" style="width:100%; height: 30px;" name="allegy" id="allergy"></td>
					</tr>
					<tr>
						<td>짖음정도</td>
						<td colspan="4"><span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">상</button>
        						<input type="checkbox" class="hidden"  name="dogBark" value="상">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">중</button>
        					<input type="checkbox" class="hidden"  name="dogBark" value="중">
    						</span>
    						<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">하</button>
        						<input type="checkbox" class="hidden"  name="dogBark" value="하">
    						</span>
    					</td>
					</tr>
					<tr>
						<td>배변활동</td>
						<td colspan="4">
							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">상</button>
        						<input type="checkbox" class="hidden"  name="dogBowel" value="상">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">중</button>
        					<input type="checkbox" class="hidden"  name="dogBowel" value="중">
    						</span>
    						<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">하</button>
        						<input type="checkbox" class="hidden"  name="dogBowel" value="하">
    						</span>
						</td>
					</tr>
					<tr>
						<td>활동량</td>
						<td colspan="4">
							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">상</button>
        						<input type="checkbox" class="hidden" name="dogAct" value="상">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">중</button>
        					<input type="checkbox" class="hidden" name="dogAct" value="중">
    						</span>
    						<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">하</button>
        						<input type="checkbox" class="hidden" name="dogAct" value="하">
    						</span>
						</td>
					</tr>
					<tr>
						<td>분리불안</td>
						<td colspan="4">
							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">유</button>
        						<input type="checkbox" class="hidden" name="seperate" value="Y">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">무</button>
        					<input type="checkbox" class="hidden" name="seperate" value="N">
    						</span>
						</td>
					</tr>
					<tr>
						<td>모색</td>
						<td colspan="4"><input type="text" style="width:100%; height: 30px;" name="furColor"></td>
					</tr>
					<tr>
						<td>순종여부</td>
						<td colspan="4">
							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">예</button>
        						<input type="checkbox" class="hidden" name="obYn" value="Y">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">아니요</button>
        					<input type="checkbox" class="hidden" name="obYn" value="N">
    						</span>
						</td>
					</tr>
					<tr>
						<td>등록여부</td>
						<td colspan="4">
							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">예</button>
        						<input type="checkbox" class="hidden" name="regYn" value="Y">
    						</span>
    							<span class="button-checkbox">
        						<button type="button" class="btn" data-color="info" style="font-family: 'Sunflower', sans-serif; width:170px; height:30px">아니요</button>
        					<input type="checkbox" class="hidden" name="regYn" value="N">
    						</span>
						</td>
					</tr>
					<tr>
						<td>사진</td>
						<td>
							<div id="contentImgArea1">
								<img id="contentImg1" src="/sixDestiny/images/imageSelect.png" width="120" height="100">
							</div>
						</td>
						<td>
							<div id="contentImgArea2">
								<img id="contentImg2" src="/sixDestiny/images/imageSelect.png" width="120" height="100">
							</div>
						</td>
						<td>
							<div id="contentImgArea3">
								<img id="contentImg3" src="/sixDestiny/images/imageSelect.png" width="120" height="100">
							</div>
						</td>
					</tr>
					<tr>
						<td style="height:150px">기타사항</td>
						<td colspan="4"><textarea style="width:98%; height:80%; resize: none; border:none;" name="dogChar" placeholder=" 강아지들의 안전하고 행복한 입소생활을 위헤 솔직하고 자세하게 작성하여 주세요."></textarea></td>
					</tr>
				</table>
			</div>
		</div>
		<br><br><br>
		<button type="button" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width:200px" onclick="entranceMoney();">최소 입소비용 감정받기</button>
		<button type="button" class="btn btn-default" style="font-family: 'Sunflower', sans-serif; width:200px" onclick="applyEntrance();">신청서 제출</button>
		<input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
		<div id="fileArea">
					<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this, 1)">
					<input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="loadImg(this, 2)">
					<input type="file" id="thumbnailImg3" name="thumbnailImg3" onchange="loadImg(this, 3)">
		</div>
		</form>
	</div>

		<script type="text/javascript">
		$(function(){
			$('.filehidden1').click(function(){
				$('#fileopa1').css('opacity','1');
			});
		});

	$(function(){
		$('.fileopacity2').click(function(){
			$('#fileopa2').css('opacity','1');
		});
	});

	$(function(){
		$('.filehidden1').click(function(){
			$('#fileopa1').css('opacity','0');
		});
	});

	$(function(){
		$('.filehidden2').click(function(){
			$('#fileopa2').css('opacity','0');
		});
	});

	<%-- $(document).ready(
			$(function() {
				<%for (int i = 1; i < 11; i++) {%>
				$('input[type="checkbox"]["id=check<%=i%>").click(
						function() {
							if ($(this).prop('checked')) {
								$('input[type="checkbox"]["id=check<%=i%>]").prop('checked', false);
								$(this).prop('checked', true);
							}
						});
				<%}%>
			}); --%>
	</script>
		<script type="text/javascript">
		 $(function(){
	            $("#fileArea").hide();

	            $("#contentImgArea1").click(function(){
	               $("#thumbnailImg1").click();
	            });
	            $("#contentImgArea2").click(function(){
	               $("#thumbnailImg2").click();
	            });
	            $("#contentImgArea3").click(function(){
	               $("#thumbnailImg3").click();
	            });
	         });

		 function loadImg(value, num) {
	            if(value.files && value.files[0]) {
	               var reader = new FileReader();

	               reader.onload = function(e) {
	                  switch(num){
	                     case 1 : $("#contentImg1").attr("src", e.target.result); break;
	                     case 2 : $("#contentImg2").attr("src", e.target.result); break;
	                     case 3 : $("#contentImg3").attr("src", e.target.result); break;
	                  }
	               }

	               reader.readAsDataURL(value.files[0]);
	            }
	         }

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
	function entranceMoney(){
		console.log("AAA")
		/* 나이 : 0~6개월(25) 6개월~1년(20)1년~5년(15)5년~10년(10)10년이상(5) / 성별:남()여(5) / 견종:코카스파니엘(20)요크셔테리어(10)푸들(10)말티즈(15)웰시코기(20)포메라니안(20)스피치(20)닥스훈트(20)사모예드(25)골든리트리버(25)허스키(30)쉐퍼드(25)믹스(5)
		몸무게 : 0~5()5~13(5)13이상(10) 접종유무:했다()안했다(5) 병력:있다(10)없다() 알레르기:있다(5)없다() */
		var dogAge = $("#dogAge").val();
		var dogGender2 = $("#dogGender2").is(":checked");
		var dogKind = $("#dogKind").val();
		var weight = $("#weight").val();
		var ino = $("#ino").is(":checked");
		var dis = $("#dis").is(":checked");
		var allergy = $("#allergy").val();

		var price = 0;

		if(dogAge == "age1"){
			price += 25;
		}else if(dogAge == "age2"){
			price += 20;
		}else if(dogAge == "age3"){
			price += 15;
		}else if(dogAge == "age4"){
			price += 10;
		}else{
			price += 5;
		}

		if(dogGender2){
			price += 5;
		}

		if(dogKind == "dog1"){
			price += 20;
		}else if(dogKind == "dog2"){
			price += 10;
		}else if(dogKind == "dog3"){
			price += 10;
		}else if(dogKind == "dog4"){
			price += 15;
		}else if(dogKind == "dog5"){
			price += 20;
		}else if(dogKind == "dog6"){
			price += 20;
		}else if(dogKind == "dog7"){
			price += 20;
		}else if(dogKind == "dog8"){
			price += 20;
		}else if(dogKind == "dog9"){
			price += 25;
		}else if(dogKind == "dog10"){
			price += 25;
		}else if(dogKind == "dog11"){
			price += 30;
		}else if(dogKind == "dog12"){
			price += 25;
		}else{
			price += 5;
		}

		if(weight < 5){
			price += 0;
		}else if(weight >= 13){
			price += 5
		}else{
			price += 10;
		}

		if(ino){
			price += 5;
		}

		if(dis){
			price += 10;
		}

		if(allergy != null){
			price += 5;
		}

		alert("회원님의 입소견 최소 입소비용은 " + price + "만원 이며 \n추후 오프라인 을 통하여 변동 될 수 있음을 안내해 드립니다.");

	}

	function applyEntrance(){
		document.entrance.submit();
	}

	$(function(){
		$("#testDatepicker").change(function(){
			var date = $("#testDatepicker").val();
			console.log(date);
			$.ajax({
				url:"/sixDestiny/selectDay.sel",
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