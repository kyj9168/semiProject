<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.user.model.vo.User, java.util.*, com.kh.semi.board.parcelout.model.vo.*" %>

<% ArrayList<HashMap<String, Object>> list2 = (ArrayList<HashMap<String, Object>>) request.getAttribute("filelist2"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>인기글 BEST 5</h3>

<!--
		<div class="container" style="height: 1000px; width: 70%;">

			<div class="row" style="margin-left: 89px;"> -->
		 	<% for(int i = 0 ; i < list2.size(); i++) {
					HashMap<String,Object> hmap2 = list2.get(i);

					String sub2 = (String) hmap2.get("boardCon2");
				%>

				<div class="col-md-2">
					<div class="thumbnail">
								<input type="hidden" value="<%= hmap2.get("boardNo2") %>">
								<p>제목 : <%= hmap2.get("boardNm2") %></p>
								<p>조회수 : <%= hmap2.get("inqCount2") %></p>
								<p>추천수 : <%= hmap2.get("recCount2") %></p>
								<p>작성자 : <%= hmap2.get("nickNm2") %></p>
						<img src="/sixDestiny/parcelout_uploadFiles/<%=hmap2.get("changeNm2")%>" alt="Lights">
							<div class="caption">
							<%-- 	 <p><%= sub2.substring(0, 3) + "...." %> </p> --%>
							</div>

					</div>
				</div>

				<% } %>


</body>
</html>