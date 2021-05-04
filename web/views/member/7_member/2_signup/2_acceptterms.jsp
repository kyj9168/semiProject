<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/top_Include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Gaegu|Sunflower:300&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>13_입소신청_신청서작성</title>
<style>
#div1{
font-family: 'Sunflower', sans-serif;
}

</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<body>
	<div id="div1">
	<div style="width: 600px; margin: 0 auto; padding:30px">
		<h2>회 원 가 입</h2>
		<br>
		<b>서비스 약관 동의</b><br>
		<br>
		<div style="border: 1px solid; overflow:scroll; width:500px; height:150px; padding:20px;  margin: 0 auto;">
			제1조 목적
			본 이용약관은 “육인원”(이하 "육인원")의 서비스의 이용조건과 운영에 관한 제반사항 규정을 목적으로 합니다.
			<br>
			제2조 용어의 정의
			본 약관에서 사용되는 주요한 용어의 정의는 다음과 같습니다.
			① 회원 : 육인원의 약관에 동의하고 개인정보를 제공하여 회원등록을 한 자로서, 사이트와의 이용계약을 체결하고 육인원을 이용하는 이용자를 말합니다.
			② 이용계약 : 육인원 이용과 관련하여 사이트와 회원간에 체결 하는 계약을 말합니다.
			③ 회원 아이디(이하 "ID") : 육인원회원의 식별과 육인원회원의 서비스 이용을 위하여 회원별로 부여하는 고유한 문자와 숫자의 조합을 말합니다.
			④ 비밀번호 : 육인원회원이 부여받은 ID와 일치된 회원임을 확인하고 회원의 권익보호를 위하여 회원이 선정한 문자와 숫자의 조합을 말합니다.
			⑤ 운영자 : 서비스에 홈페이지를 개설하여 운영하는 운영자를 말합니다.
			⑥ 해지 : 육인원회원이 이용계약을 해약하는 것을 말합니다.
			<br>
			제3조 약관외 준칙
			운영자는 필요한 경우 별도로 운영정책을 공지 안내할 수 있으며, 본 약관과 운영정책이 중첩될 경우 운영정책이 우선 적용됩니다.
			<br>
			제4조 이용계약 체결
			① 이용계약은 회원으로 등록하여 사이트를 이용하려는 자의 본 약관 내용에 대한 동의와 가입신청에 대하여 운영자의 이용승낙으로 성립합니다.
			② 회원으로 등록하여 서비스를 이용하려는 자는 사이트 가입신청시 본 약관을 읽고 아래에 있는 "동의합니다"를 선택하는 것으로 본 약관에 대한 동의 의사 표시를 합니다.
			<br>
			제5조 서비스 이용 신청
			① 회원으로 등록하여 사이트를 이용하려는 이용자는 사이트에서 요청하는 제반정보(이용자ID,비밀번호, 닉네임 등)를 제공해야 합니다.
			② 타인의 정보를 도용하거나 허위의 정보를 등록하는 등 본인의 진정한 정보를 등록하지 않은 회원은 사이트 이용과 관련하여 아무런 권리를 주장할 수 없으며, 관계 법령에 따라 처벌 받을 수 있습니다.
			<br>
			제6조 개인정보처리방침
			사이트 및 운영자는 회원가입시 제공한 개인정보 중 비밀번호를 가지고 있지 않으며 이와 관련된 부분은 사이트의 개인정보처리방침을 따릅니다.
			운영자는 관계법령이 정하는 바에 따라 회원등록정보를 포함한 회원의 개인정보를 보호하기 위하여 노력을 합니다.
			회원의 개인정보보호에 관하여 관계법령 및 사이트가 정하는 개인정보처리방침에 정한 바에 따릅니다.
			단, 회원의 귀책사유로 인해 노출된 정보에 대해 운영자는 일체의 책임을 지지 않습니다.
			운영자는 회원이 미풍양속에 저해되거나 국가안보에 위배되는 게시물 등 위법한 게시물을 등록 · 배포할 경우 관련기관의 요청이 있을시 회원의 자료를 열람 및 해당 자료를 관련기관에 제출할 수 있습니다.
			<br>
			제7조 운영자의 의무
			① 운영자는 이용회원으로부터 제기되는 의견이나 불만이 정당하다고 인정할 경우에는 가급적빨리 처리하여야 합니다. 다만, 개인적인 사정으로 신속한 처리가 곤란한 경우에는 사후에공지 또는 이용회원에게 쪽지, 전자우편 등을 보내는 등 최선을 다합니다.
			② 운영자는 계속적이고 안정적인 사이트 제공을 위하여 설비에 장애가 생기거나 유실된 때에는 이를 지체 없이 수리 또는 복구할 수 있도록 사이트에 요구할 수 있습니다. 다만, 천재지변 또는 사이트나 운영자에 부득이한 사유가 있는 경우, 사이트 운영을 일시 정지할 수 있습니다.
		</div>
		<br>
		<input type="checkbox" name="join_agree1" id="agreebut1">위 내용에 동의합니다. <br>
		<br>
		<br> <b>개인정보 수집 및 이용 동의</b><br>
		<br>
		<div style="border: 1px solid; overflow:scroll; width:500px; height:150px; padding:20px;  margin: 0 auto;">
			1. 개인정보 수집목적 및 이용목적<br>
			가. 육인원의 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산
			콘텐츠 제공 , 구매 및 요금 결제 , 물품배송 또는 청구지 등 발송 , 금융거래 본인 인증 및 금융 서비스
			나. 회원 관리
			회원제 서비스 이용에 따른 본인확인 , 개인 식별 , 불량회원의 부정 이용 방지와 비인가 사용 방지 , 가입 의사 확인 , 연령확인 , 만14세 미만 아동 개인정보 수집 시 법정 대리인 동의여부 확인, 불만처리 등 민원처리 , 고지사항 전달<br>
			2. 수집하는 개인정보 항목 : 이름, 로그인ID , 비밀번호 , 주소, 휴대전화번호 , 이메일 , 14세미만 가입자의 경우 법정대리인의 정보<br>
			3. 개인정보의 보유기간 및 이용기간<br>
			원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 단, 다음의 정보에 대해서는 아래의 이유로 명시한 기간 동안 보존합니다.
			가. 회사 내부 방침에 의한 정보 보유 사유
			o 부정거래 방지 및 운영방침에 따른 보관 : 5년
			관련 법령에 의한 정보보유 사유
			o 계약 또는 청약철회 등에 관한 기록
			-보존이유 : 전자상거래등에서의소비자보호에관한법률
			-보존기간 : 5년
			o 대금 결제 및 재화 등의 공급에 관한 기록
			-보존이유: 전자상거래등에서의소비자보호에관한법률
			-보존기간 : 5년
			o 소비자 불만 또는 분쟁처리에 관한 기록
			-보존이유 : 전자상거래등에서의소비자보호에관한법률
			-보존기간 : 3년
			o 로그 기록
			-보존이유: 통신비밀보호법
			-보존기간 : 3개월<br>
			※ 동의를 거부할 수 있으나 거부시 회원 가입이 불가능합니다.
		</div>
		<br>
		<input type="checkbox" name="join_agree2" id="agreebut2">위 내용에 동의합니다. <br>
		<br>
	</div>
	<input type="button" class="btn btn-default" value="회원가입" id="signbut"><br>



	</div>

	<script type="text/javascript">
		$(function(){
			$('#signbut').click(function(){
				if($('#agreebut1').is(":checked") == true && $('#agreebut2').is(":checked") == true){
					location.href="/sixDestiny/views/member/7_member/2_signup/3_signupHomepage.jsp";
				}else{
					alert("약관을 모두 동의하셔야 회원가입이 가능합니다.")
				}
			});
		});
	</script>


	<%@ include file="../../../common/bottom_Include.jsp"%>
</body>
</html>