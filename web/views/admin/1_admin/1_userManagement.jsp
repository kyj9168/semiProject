<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , com.kh.semi.user.model.vo.*"%>
<%@ include file="../../common/top_Include.jsp" %>
<%
   ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");
   ArrayList<Integer> reportC = (ArrayList<Integer>) request.getAttribute("reportC");

PageInfo pi = (PageInfo) request.getAttribute("pi");

int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
<title>Insert title here</title>
	<%@ include file="../../common/inner_admin_include.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	
	function deleteUser(userNo){
	
		
		if(confirm("정말 탈퇴처리 하시겠습니까?")){
			$.ajax({
				url:"/sixDestiny/deleteuser",
				type:"post",
				data:{userNo:userNo},
				success:function(){
					alert("회원탈퇴 완료되었습니다.");
					location.href="/sixDestiny/userManage";
				},
				error:function(){
					alert("탈퇴도중 에러가 났습니다.");
					location.href="/sixDestiny/userManage";
				}
			});
		}
	}
</script>


<style>
   #outer{
      width:1000px;
      margin:0 auto;
      text-align:left;
      font-family: 'Nanum Gothic', sans-serif;
   }

   #order{
      align:center;
   }

   #btn1{

    border-radius: 0.35em;
   	border: 1;
   	outline : 0;
   }

   #btn1:hover{
   	background-color:lightgray;
   }


   #td1:hover{
   	font-weight:bold;
   }
</style>
</head>
<body>

   <div>

   <div id="outer">
 <form name="userData" id="userData">
      <table class="table" style="text-align:center;">
         <thead >
         <tr>
            <th style="text-align:center;">회원번호</th>
            <th style="text-align:center;">아이디</th>
            <th style="text-align:center;">이름</th>
            <th style="text-align:center;">닉네임</th>
            <th style="text-align:center;">성별</th>
            <th style="text-align:center;">이메일</th>
            <th style="text-align:center;">연락처</th>
            <th style="text-align:center;">가입유무</th>
            <th style="text-align:center;">가입일자</th>
            <th style="text-align:center;">신고횟수</th>
            <th style="text-align:center;">탈퇴</th>
         </tr>
         </thead>

        <tbody>
         <% for(int i=0; i<list.size(); i++){ %>

         <tr>
            <td><%=list.get(i).getUserNo() %></td>
            <td><%=list.get(i).getUserId() %></td>
            <td><a href="/sixDestiny/userInfo?userNo=<%=list.get(i).getUserNo() %>" onclick="window.open(this.href,'_blank', 'width=500,height=700');return false;"><%=list.get(i).getUserNm() %></a></td>
            <td><%=list.get(i).getNickNm()%></td>
            
            <td>
            	<%if(list.get(i).getGender()==null) {%>
            	정보없음
            	<%}else{ %>
            	<%=list.get(i).getGender()  %></td>
            	<%} %>
            <td><%=list.get(i).getEmail()%></td>
            <td>
            	<%if(list.get(i).getPhone()==null){ %>
            		정보없음
            	<%}else{ %>
            		<%=list.get(i).getPhone() %>
            	<%} %>
            </td>
            <td><%=list.get(i).getUserSit() %></td>
            <td><%=list.get(i).getEnrollDt() %></td>
            <td><%=reportC.get(i) %></td>
            <td><% if(list.get(i).getUserSit().equals("가입")){%>
            <button class="btn btn-default" id="btn1" onclick="deleteUser(<%=list.get(i).getUserNo() %>);">탈퇴</button>
         	  <% }%>
         	</td>
         </tr>
         <% } %>
         	</tbody>

	</table>
</form>	
	

	</div>

        
  <%-- 페이징처리 --%>
		 <div class="pagingArea" align="center">
		<ul class="pagination">


			<% if(currentPage != 1){ %>
			<li><a href="<%=request.getContextPath()%>/userManage?currentPage=1">◀◀</a></li>

			<% }%>

			<% if(10 >= currentPage){ %>


			<% }else if(currentPage%10 != 0){ %>
			<li><a href="<%=request.getContextPath()%>/userManage?currentPage=<%=(int)(Math.floor(currentPage/10))*10%>">◀</a></li>
			<%}else{ %>
			<li><a href="<%=request.getContextPath()%>/userManage?currentPage=<%=(int)(Math.floor((currentPage-1)/10))*10%>">◀</a></li>
			<%} %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<li ><a style="background:rgb(240,240,240); font-weight:bold;" href="#" disabled><%= p %></a></li>

			<% } else { %>
			<li><a href="<%=request.getContextPath()%>/userManage?currentPage=<%=p%>" disabled><%= p %></a></li>

			<%
				}
			   }
			%>

			<% if(currentPage >= maxPage){ %>

			<% }else if(Math.floor(maxPage/10)*10 >= currentPage){ %>
			<li><a href="<%=request.getContextPath()%>/userManage?currentPage=<%=(int)(Math.ceil(currentPage/10))*10+11%>">▶</a></li>

			<% }%>

			<% if(currentPage < maxPage){ %>
			<li><a href="<%=request.getContextPath()%>/userManage?currentPage=<%=maxPage%>">▶▶</a></li>
			<%} %>
		</ul>
		</div>




   </div>
<%@ include file="../../common/bottom_Include.jsp"%>
</body>
</html>