<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.SimpleDateFormat, java.util.*, com.kh.semi.sel.model.vo.*"%>
<%@ include file="../../common/top_Include.jsp"%>
<%
	ArrayList<SelSit> entrance = (ArrayList<SelSit>) request.getAttribute("entrance");
	ArrayList<SelSit> parcelout = (ArrayList<SelSit>) request.getAttribute("parcelout");
	String[] time = new String[7];
	time[0] = "09:00~10:00";
	time[1] = "10:00~11:00";
	time[2] = "11:00~12:00";
	time[3] = "14:00~15:00";
	time[4] = "15:00~16:00";
	time[5] = "16:00~17:00";
	time[6] = "17:00~18:00";
	String[] result = new String[7];
	result[0] = "0900";
	result[1] = "1000";
	result[2] = "1100";
	result[3] = "1400";
	result[4] = "1500";
	result[5] = "1600";
	result[6] = "1700";
%>
<%
	Calendar cal = Calendar.getInstance();

	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int date = cal.get(Calendar.DATE);

	if(strYear != null){
		year = Integer.parseInt(strYear);
		month = Integer.parseInt(strMonth);
	}else{

	}

	cal.set(year, month, 1);
	int startDay = cal.getMinimum(java.util.Calendar.DATE);
	int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
	int newLine = 0;

 	Calendar todayCal = Calendar.getInstance();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
	int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
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
<style TYPE="text/css">
/* .calender {
	scrollbar-face-color: #F6F6F6;
	scrollbar-highlight-color: #bbbbbb;
	scrollbar-3dlight-color: #FFFFFF;
	scrollbar-shadow-color: #bbbbbb;
	scrollbar-darkshadow-color: #FFFFFF;
	scrollbar-track-color: #FFFFFF;
	scrollbar-arrow-color: #bbbbbb;
	margin-left: "0px";
	margin-right: "0px";
	margin-top: "0px";
	margin-bottom: "0px";
}

.divDotText {
	overflow: hidden;
	text-overflow: ellipsis;
}

A:link {
	font-size: 9pt;
	font-family: 'Sunflower', sans-serif;
	color: #000000;
	text-decoration: none;
}

A:visited {
	font-size: 9pt;
	font-family: 'Sunflower', sans-serif;
	color: #000000;
	text-decoration: none;
}

A:active {
	font-size: 9pt;
	font-family: 'Sunflower', sans-serif;
	color: red;
	text-decoration: none;
}

A:hover {
	font-size: 9pt;
	font-family: 'Sunflower', sans-serif;
	color: red;
	text-decoration: none;
} */

.inline {
 	display:inline-block;
}
</style>
<%@ include file="../../common/inner_admin_include.jsp" %>
</head>
<body class="calender">
		<table>
		<tr>
		<td rowspan="2">
		<div class="inline" id="content" style="width:60%;">
			<table id="KOO" style="margin:0 auto; width:100%;">
				<tr>
					<td height="60">
			<table>
				<tr>
					<td height="10"></td>
				</tr>
				<tr align="center">
					<td align="center" style="font-family: 'Sunflower', sans-serif; width:700px;">
						<a href="/sixDestiny/selectMonth.all?year=<%=year-1%>&amp;month=<%=month%>&days=1" target="_self">
							<b>&lt;&lt;</b><!-- 이전해 -->
						</a>

                    <%if(month > 0 ){ %>
						<a href="/sixDestiny/selectMonth.all?year=<%=year%>&amp;month=<%=month-1%>&days=1" target="_self">
							<b>&lt;</b><!-- 이전달 -->
						</a>
					 <%} else {%>
							<b>&lt;</b>
                    <%} %> &nbsp;&nbsp;

                    <%=year%>년
                    <%=month+1%>월

                    &nbsp;&nbsp;

                    <%if(month < 11 ){ %>

                    <a href="/sixDestiny/selectMonth.all?year=<%=year%>&amp;month=<%=month+1%>&days=1" target="_self">
                           <!-- 다음달 --><b>&gt;</b>
                    </a>
                    <%}else{%>
                           <b>&gt;</b>
                    <%} %>
                    <a href="/sixDestiny/selectMonth.all?year=<%=year+1%>&amp;month=<%=month%>&days=1" target="_self">
                           <!-- 다음해 --><b>&gt;&gt;</b>
                    </a>
             </td>
       </tr>
       <tr>
       <td align ="right">
             <input class="btn btn-default" style="font-family: 'Sunflower', sans-serif;" type="button" onclick="javascript:location.href='/sixDestiny/selectDday.sel'" value="오늘"/>
       </td>
</tr>
       </table>
</td>
</tr>
</table>
<br>
<table style="border:1px solid black; margin:0 auto;">

<THEAD>

<TR bgcolor="#CECECE">

       <TD width='100px'>

       <DIV align="center" style="font-family: 'Sunflower', sans-serif;"><font color="red">일</font></DIV>

       </TD>

       <TD width='100px'>

       <DIV align="center" style="font-family: 'Sunflower', sans-serif;">월</DIV>

       </TD>

       <TD width='100px'>

       <DIV align="center" style="font-family: 'Sunflower', sans-serif;">화</DIV>

       </TD>

       <TD width='100px'>

       <DIV align="center" style="font-family: 'Sunflower', sans-serif;">수</DIV>

       </TD>

       <TD width='100px'>

       <DIV align="center" style="font-family: 'Sunflower', sans-serif;">목</DIV>

       </TD>

       <TD width='100px'>

       <DIV align="center" style="font-family: 'Sunflower', sans-serif;">금</DIV>

       </TD>

       <TD width='100px'>

       <DIV align="center" style="font-family: 'Sunflower', sans-serif;"><font color="#529dbc">토</font></DIV>

       </TD>

</TR>
</THEAD>
<TBODY style="font-family: 'Sunflower', sans-serif;">
<TR>

<%

//처음 빈공란 표시
for(int index = 1; index < start ; index++ )
{
  out.println("<TD >&nbsp;</TD>");
  newLine++;
}

for(int index = 1; index <= endDay; index++)
{
       String color = "";

       if(newLine == 0){          color = "RED";
       }else if(newLine == 6){    color = "#529dbc";
       }else{                     color = "BLACK"; };

       String sUseDate = Integer.toString(year);
       sUseDate += Integer.toString(month+1).length() == 1 ? "0" + Integer.toString(month+1) : Integer.toString(month+1);
       sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index) : Integer.toString(index);

       int iUseDate = Integer.parseInt(sUseDate);

       String backColor = "#EFEFEF";

       if(iUseDate == intToday ) {
             backColor = "#c9c9c9";
       }

       out.println("<TD valign='top' name='clickSelect' align='left' height='92px' bgcolor='"+backColor+"' nowrap>");
       %>
       <font color='<%=color%>'>
             <%=index %>
       </font>
       <%
      out.println("<BR>");
       /* out.println(iUseDate); */
       out.println("<BR>");

       //기능 제거
       out.println("</TD>");
       newLine++;

       if(newLine == 7)
       {
         out.println("</TR>");
         if(index <= endDay)
         {
           out.println("<TR>");
         }
         newLine=0;
       }

}


while(newLine > 0 && newLine < 7)
{
  out.println("<TD>&nbsp;</TD>");
  newLine++;
}

%>

</TR>

</TBODY>

</TABLE>

</DIV>
<script type="text/javascript">

</script>
</td>
<td>
<div class="container inline" style="width:500px">
  <br><br>
  <table class="table table-hover" style="width:500px">
    <thead>
      <tr>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">상담시간</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원이름</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">상담현황</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">현황처리</td>
      </tr>
    </thead>
    <tbody id="entranceBody">
    	<% for(int i = 0; i < 7; i++){ %>
    		<tr>
    		<td style="font-family: 'Sunflower', sans-serif;"><p><%= time[i] %></p></td>
   		<% for(SelSit ss : entrance){ %>
			<% if(result[i].equals(ss.getDay())) {%>
						<td style="font-family: 'Sunflower', sans-serif;"><p class="selNo"><%= ss.getSelNo() %></p>
						</td>
						<td style="font-family: 'Sunflower', sans-serif;"><p><%= ss.getUserNm() %></p></td>
						<td style="font-family: 'Sunflower', sans-serif;"><p><%= ss.getSelSit() %></p></td>
						<td style="font-family: 'Sunflower', sans-serif;">
							<% if(ss.getSelSit().equals("상담대기")){ %>
									<h4 class="hide">안녕하세요</h4>
									<button class="btn btn-default clickbtn" name="changeBtn">내역 변경</button>
							<% }else if(ss.getSelSit().equals("상담취소")){ %>
									<p>상담취소</p>
							<% }else{ %>
									<p>상담대기</p>
							<% } %>
						</td>
				<% }else{%>

				<% } %>
    		<% } %>

    		</tr>
    	<% } %>
    </tbody>
  </table>
</div>
</td>
</tr>
<tr>
	<td>
<div class="container inline" style="width:500px">
  <br><br>
  <table class="table table-hover" style="width:500px">
    <thead>
      <tr>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">상담시간</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">신청번호</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">회원이름</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">상담현황</td>
        <td style="font-family: 'Sunflower', sans-serif; font-weight:bold;">현황처리</td>
      </tr>
    </thead>
    <tbody id="parceloutBody">

    	<% for(int i = 0; i < 7; i++){ %>
    		<tr>
    		<td style="font-family: 'Sunflower', sans-serif;"><p><%= time[i] %></p></td>
   		<% for(SelSit ss : parcelout){ %>
			<% if(result[i].equals(ss.getDay())) {%>
						<td style="font-family: 'Sunflower', sans-serif;"><p><%= ss.getSelNo() %></p></td>
						<td style="font-family: 'Sunflower', sans-serif;"><p><%= ss.getUserNm() %></p></td>
						<td style="font-family: 'Sunflower', sans-serif;"><p><%= ss.getSelSit() %></p></td>
						<td style="font-family: 'Sunflower', sans-serif;">
							<% if(ss.getSelSit().equals("상담대기")){ %>
									<button class="btn btn-default clickbtn">내역 변경</button>
							<% }else if(ss.getSelSit().equals("상담취소")){ %>
									<p>상담취소</p>
							<% }else{ %>
									<p>상담대기</p>
							<% } %>
						</td>
				<% }else{%>

				<% } %>
    		<% } %>






    		</tr>
    	<% } %>
    	</tbody>
  </table>
</div>
</td>
</tr>
</table>
<script type="text/javascript">
	/* function goSelDate() {
		console.log($(this).t());
	} */

	$(function(){
		$("[name=clickSelect]").click(function(){
			var day = $(this).text();
			var month = <%=month+1%>
			$.ajax({
				url:"/sixDestiny/selectSel.all",
				type:"post",
				data:{day:day, month:month},
				success:function(data){
					$("#entranceBody tr").remove();
					$("#parceloutBody tr").remove();

		    		var time = new Array("09:00~10:00","10:00~11:00","11:00~12:00","14:00~15:00","15:00~16:00","16:00~17:00","17:00~18:00");
		    		var reuslt = new Array("0900", "1000", "1100", "1400", "1500", "1600", "1700");
		    		for(var i = 0; i < 7; i++){
		    			var $tr = $("<tr>");
		    			var $td = $("<td>");
		    			var $td1 = $("<td>");
    					var $td2 = $("<td>");
    					var $td3 = $("<td>");
    					var $td4 = $("<td>");
    					var $p1 = $("<p class='selNo'>");
    					var $p2 = $("<p>");
    					var $p3 = $("<p>");
    					var $p4 = $("<p>");
    					var $btn = $("<button class='btn btn-default clickbtn' onclick='changePcoSit(this)'>");
		    			$td.css("font-family", "'Sunflower', sans-serif");
		    			var $p = $("<p>");

		    			$p.append(time[i]);
		    			$td.append($p);
		    			for(var j = 0; j < data["parcelout"].length; j++){
		    					console.log("aa");
		    					console.log("result : " + reuslt[i]);
		    					console.log("Data :: " + data["parcelout"][j].day);
		    				if(reuslt[i] == data["parcelout"][j].day){
		    					$btn.append("내역변경");
		    					$td1.css("font-family", "'Sunflower', sans-serif");
		    					$td2.css("font-family", "'Sunflower', sans-serif");
		    					$td3.css("font-family", "'Sunflower', sans-serif");
		    					$td4.css("font-family", "'Sunflower', sans-serif");

		    					if(data["parcelout"][j].selSit == "상담대기"){
		    						$p1.append(data["parcelout"][j].selNo);
		    						$p2.append(data["parcelout"][j].userNm);
		    						$p3.append(data["parcelout"][j].selSit);
		    						$td1.append($p1);
				    				$td2.append($p2);
				    				$td3.append($p3);
		    						$td4.append($btn);
		    					}else if(data["parcelout"][j].day == "상담취소"){
		    						$p1.append(data["parcelout"][j].selNo);
		    						$p2.append(data["parcelout"][j].userNm);
		    						$p3.append(data["parcelout"][j].selSit);
		    						$p4.append("상담취소");
		    						$td1.append($p1);
				    				$td2.append($p2);
				    				$td3.append($p3);
		    						$td4.append($p4);
		    					}else{
		    						$p1.append(data["parcelout"][j].selNo);
		    						$p2.append(data["parcelout"][j].userNm);
		    						$p3.append(data["parcelout"][j].selSit);
		    						$p4.append("상담완료");
		    						$td1.append($p1);
				    				$td2.append($p2);
				    				$td3.append($p3);
		    						$td4.append($p4);
		    					}


		    				}else{
		    					$td1.append($p1);
			    				$td2.append($p2);
			    				$td3.append($p3);
	    						$td4.append($p4);
		    				}

		    			}
							$tr.append($td);
		    				$tr.append($td1);
		    				$tr.append($td2);
		    				$tr.append($td3);
		    				$tr.append($td4);


		    			$("#parceloutBody").append($tr);
		    		}



		    		for(var i = 0; i < 7; i++){
		    			var $tr = $("<tr>");
		    			var $td = $("<td>");
		    			var $td1 = $("<td>");
    					var $td2 = $("<td>");
    					var $td3 = $("<td>");
    					var $td4 = $("<td>");
    					var $p1 = $("<p class='selNo'>");
    					var $p2 = $("<p>");
    					var $p3 = $("<p>");
    					var $p4 = $("<p>");
    					var $btn = $("<button class='btn btn-default clickbtn' onclick='changeEntSit(this)'>");
		    			$td.css("font-family", "'Sunflower', sans-serif");
		    			var $p = $("<p>");
		    			console.log("time" + time[i]);

		    			$p.append(time[i]);
		    			$td.append($p);
		    			console.log(data["entrance"].length);
		    			for(var j = 0; j < data["entrance"].length; j++){
	    					console.log("aa");
	    					console.log("result : " + reuslt[i]);
	    					console.log("Data :: " + data["entrance"][j].day);
	    				if(reuslt[i] == data["entrance"][j].day){
	    					$btn.append("내역변경");
	    					$td1.css("font-family", "'Sunflower', sans-serif");
	    					$td2.css("font-family", "'Sunflower', sans-serif");
	    					$td3.css("font-family", "'Sunflower', sans-serif");
	    					$td4.css("font-family", "'Sunflower', sans-serif");

	    					if(data["entrance"][j].selSit == "상담대기"){
	    						$p1.append(data["entrance"][j].selNo);
	    						$p2.append(data["entrance"][j].userNm);
	    						$p3.append(data["entrance"][j].selSit);
	    						$td1.append($p1);
			    				$td2.append($p2);
			    				$td3.append($p3);
	    						$td4.append($btn);
	    					}else if(data["entrance"][j].day == "상담취소"){
	    						$p1.append(data["entrance"][j].selNo);
	    						$p2.append(data["entrance"][j].userNm);
	    						$p3.append(data["entrance"][j].selSit);
	    						$p4.append("상담취소");
	    						$td1.append($p1);
			    				$td2.append($p2);
			    				$td3.append($p3);
	    						$td4.append($p4);
	    					}else{
	    						$p1.append(data["entrance"][j].selNo);
	    						$p2.append(data["entrance"][j].userNm);
	    						$p3.append(data["entrance"][j].selSit);
	    						$p4.append("상담완료");
	    						$td1.append($p1);
			    				$td2.append($p2);
			    				$td3.append($p3);
	    						$td4.append($p4);
	    					}


	    				}else{
	    					$td1.append($p1);
		    				$td2.append($p2);
		    				$td3.append($p3);
    						$td4.append($p4);
	    				}

	    			}

						$tr.append($td);
	    				$tr.append($td1);
	    				$tr.append($td2);
	    				$tr.append($td3);
	    				$tr.append($td4);

	    			$("#entranceBody").append($tr);
	    		}


				},
				error:function(){

				}
			});
		});
	});

	function changePcoSit(selBtn){
		var selNo = $(selBtn).parent().parent().children().eq(1).children().text();
		var result = prompt("해당 상담의 내역을 처리하시겠습니까? \n(상담완료 : 완료 / 상담취소 : 취소)");
		if(result == "완료" || result == "취소"){
			$.ajax({
				url:"/sixDestiny/updatesit.selpco",
				type:"post",
				data:{selNo:selNo, result:result},
				success:function(data){
					location.href="/sixDestiny/selectDday.sel";
				},
				error:function(data){

				}
			});
		}else{
			alert("잘못 입력하셨습니다!");
		}
		console.log(result);


	}

	function changeEntSit(selBtn) {
		var selNo = $(selBtn).parent().parent().children().eq(1).children().text();
		var result = prompt("해당 상담의 내역을 처리하시겠습니까? \n(상담완료 : 완료 / 상담취소 : 취소)");
		if(result == "완료" || result == "취소"){
			$.ajax({
				url:"/sixDestiny/updatesit.selent",
				type:"post",
				data:{selNo:selNo, result:result},
				success:function(data){
					location.href="/sixDestiny/selectDday.sel";
				},
				error:function(data){

				}
			});
		}else{
			alert("잘못 입력하셨습니다!");
		}
		console.log(result);
	}

</script>

<%@ include file="../../common/bottom_Include.jsp"%>
</body>
</html>