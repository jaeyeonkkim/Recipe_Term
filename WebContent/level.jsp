<%@page import="com.java.model.vo.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Recipe Level</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Karma">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Karma", sans-serif
}

.w3-bar-block .w3-bar-item {
	padding: 20px
}
</style>
<body>
	<jsp:include page="top_menu.jsp" />
	<jsp:include page="login.jsp" />

	<div class="w3-container" id="about">
		<div class="w3-content" style="max-width: 700px">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">검색결과.</span>
			</h3>

			<table class="w3-table">
				<%
					ArrayList<Recipe> searchList = (ArrayList<Recipe>) request.getAttribute("searchList");
					if (searchList.size() > 0) {
				%>

				<div class="w3-row-padding w3-padding-16 w3-center" id="food">
					<%
						for (Recipe result : searchList) {
					%>
					<div class="w3-quarter">
						<img src="<%=result.getPurl()%>" alt="Sandwich"
							style="width: 100%">
						<h2>
							<a
								href="./searchrecipe.do?recipename=<%=result.getRecipename()%>">
								<%=result.getRecipename()%></a>
						</h2>
					</div>
				</div>
				<%}
					} else {
				%>
				<tr>
					<td colspan="2">
						<h3>조회결과가 없습니다.</h3>
					</td>
				</tr>
				<%
					}
				%>

			</table>
		</div>
	</div>
</body>
</html>
