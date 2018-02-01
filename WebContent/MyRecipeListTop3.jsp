<%@page import="java.util.ArrayList"%>
<%@page import="com.java.model.vo.Recipe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Recipe</title>
</head>
<body>
	<jsp:include page="top_menu.jsp" />

	<div style="width: 100%; overflow: hidden; margin: 0 auto">
		<div style="width: 27%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 60%; float: left">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">즐겨찾는 레시피</span>
			</h3>
			<jsp:include page="MyPageManu.jsp" />
			<table class="w3-table">
				<thead>
					<tr>
						<th><h3>재료명</h3></th>
						<th><h3>수량</h3></th>
						<th><h3>난이도</h3></th>
						<th><h3>조리시간</h3></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Recipe> myRecipeList = (ArrayList<Recipe>) request.getAttribute("myRecipeList");
						if (myRecipeList.size() > 0) {
							for (Recipe myRecipe : myRecipeList) {
					%>
					<tr>

						<td><a href="./searchrecipe.do?recipename=<%=myRecipe.getRecipename()%>&recipenum=<%=myRecipe.getRecipenum()%>">
							<%=myRecipe.getRecipename()%></a>
						</td>
						<td><%=myRecipe.getRtype()%></td>
						<td><%=myRecipe.getRlevel()%></td>
						<td><%=myRecipe.getRtime()%></td>
						<td><form method="post"
								action="./CancelMyRecipe.do?recipenum=<%=myRecipe.getRecipenum()%>&list=top3">
								<input type="submit" value="취소"
									class="btn btn-outline-secondary" />
							</form></td>
					</tr>
					
					<%
						}%>
						<tr>
						<td>
						<form method="post"action="./MyRecipe.do">
							<input type="submit" value="더보기" class="btn btn-outline-secondary" />
							</form>
						</td>
						</tr>
					<%
						} else {
					%>
					<tr>
						<td colspan="2">
							<h3>조회결과가 없습니다.</h3>
						</td>
					</tr>
					<% }%>
					
				</tbody>
			</table>
			
		</div>
	</div>


</body>
</html>