<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semi.board.missing.model.vo.*"%>
<%@ include file="../../../common/top_Include.jsp"%>

    <%

    Missing ub = (Missing) request.getAttribute("ub");

    %>
<!DOCTYPE htm>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>

<!-- jQuery -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>



<!-- Bootstrap CSS -->


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
body{
	text-align: center;
}
.form-control{
	width:400px;
	height:40px

}

td.find{
height:30px;
padding:10px;
text-align: center;
border: 3px solid  rgb(255, 255, 255);
/*border: 1px solid red;*/
}

</style>

</head>
<body>

		<h2>보호중입니다 글작성</h2>
<input type="hidden" value="<%= ub.getUu()%>" class="uu" name="uu">

		<div class="container" style="margin-top:50px;">
		
		 <form  action="<%=request.getContextPath() %>/proUpdate2.bo" method="post" >
		  
<table class="table table-bordered" align="center">


            <tr>
                <td class="find" style="background:rgb(230, 230, 230); border-radius:10px;"><span>제목</span></td>
                <td class="find" style="padding: 0;"><input type="text" value="<%= ub.getbNm()%>" name="title" class="form-control" style="width:486px;"></td>
            </tr>

             <tr>
                <td class="find" style="background:rgb(230, 230, 230); border-radius:10px;"><span>작성자</span></td>
                <td class="find" style="text-align: left;"><span><%=loginUser.getUserNm() %></span></td>

            </tr>
            <tr>
                <td class="find" style="background:rgb(230, 230, 230); border-radius:10px;"><span>발견장소</span></td>
                <td class="find" style="text-align: left; padding:0;" >
                	 <select style="height:35px;" name="place" >
						<option selected="selected" >전체</option>
						<option value="서울시">서울시</option>
						<option value="인천시">인천시</option>
						<option value="대전시">대전시</option>
						<option value="울산시">울산시</option>
						<option value="부산시">부산시</option>
						<option value="경기도">경기도</option>
						<option value="강원도">강원도</option>
						<option value="세종시">세종시</option>
						<option value="충정남도">충정남도</option>
						<option value="충정북도">충정북도</option>
						<option value="전라남도">전라남도</option>
						<option value="전라북도">전라북도</option>
						<option value="경상남도">경상남도</option>
						<option value="경상북도">경상북도</option>
						<option value="제주도">제주도</option>
					</select>
					<input style="padding:0"; type="text"  value="<%=ub.getMissPlaceDetail() %>"  name="placedetail" class="form-control"  >
				</td>
			</tr>
				<tr>
				<td class="find" style="background:rgb(230, 230, 230); border-radius:10px;"><span>발견날짜</span>
				</td>
                <td class="find" style="text-align: left; padding:0;">
                <input  type="date" value="<%= ub.getMissDt()%>" style=" height:20px; padding:8px; width:200px;" name="missdate" class="form-control"  >
					<div class="find" style="display: inline-block; text-align: left;   margin-top:1px;  border-radius: 10px; padding:10px; background:rgb(230, 230, 230); margin-left: 40px;">성별</div>
				 <select style="height:35px;" name="gender">
						<option selected="selected" value="수컷">수컷</option>
						<option value="암컷">암컷</option>
				</select>
				</td>
            </tr>





<input type="text"style="display:none"  value="<%= ub.getbNo() %>" name="boardNo">

             <tr>
                <td class="find" style="background:rgb(230, 230, 230); border-radius:10px;"><span>연락처</span></td>
                <td class="find" style="padding: 0;"><input type="text" value="<%= ub.getMissPhone()%>" name="phone" class="form-control" style="width:486px;"></td>
            </tr>

              <tr>
                <td class="find" style="background:rgb(230, 230, 230); border-radius:10px;"><span>특징</span></td>
                <td class="find" style="padding: 0;"><textarea  rows="5" cols="30" name="content" value="<%= ub.getbCon()%>" class="form-control" style="width:486px; height:200px;"></textarea></td>
            </tr>

             <tr>
                <td class="find" style="background:rgb(230, 230, 230); border-radius:10px;"><span>파일첨부</span></td>
                <td class="find" style="padding: 0px; height:10px;"><input type="file" placeholder="전화번호를 입력하세요. " name="file" class="form-control" style="width:486px; "></td>
            </tr>












            <tr>
                <td class="find" colspan="2">
                    <input type="submit" value="등록"class="pull-right"/>
                </td>
            </tr>


</table>
</form>
</div>




</body>
</html>