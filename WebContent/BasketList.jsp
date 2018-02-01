<%@page import="com.java.model.vo.Ingredient"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Basket List</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Comic Sans MS", cursive, sans-serif;
}
</style>
</head>
<body>
	<jsp:include page="top_menu.jsp" />

	<div style="width: 100%; overflow: hidden; margin: 0 auto">
		<div style="width: 30%; float: left">
			<jsp:include page="login.jsp" />
		</div>
		
		
		

		<div class="w3-content">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">장바구니</span>
			</h3>
			<jsp:include page="MyPageManu.jsp" />
			<table class="w3-table" width="800">
				<thead>
					<tr>
						<th width="150"><h3>재료명</h3></th>
						<th width="150"><h3>수량</h3></th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Ingredient> ingredientList = (ArrayList<Ingredient>) request.getAttribute("ingredientList");
						if (ingredientList.size() > 0) {
						for (Ingredient ingredient : ingredientList) {
					%>
					<tr>
						<td><%=ingredient.getRecipename()%></td>
						<td><%=ingredient.getIndName()%></td>
						<td><%=ingredient.getAmount()%></td>
						<td><form method="post"
								action="./CancelIngredient.do?indnum=<%=ingredient.getIndnum()%>&list=all">
								<input type="submit" value="취소"
									class="btn btn-outline-secondary" />
							</form></td>
					</tr>
					
					<%
						}%>
						<tr>
						<td>
						<form method="get"action="./Basket.do">
							<input type="submit" value="접기" class="btn btn-outline-secondary" />
							</form>
						</td>
						</tr>
						<%
						} else {
					%>
					<tr>
						<td colspan="2">
							<h3>장바구니에 재료가 없습니다.</h3>
						</td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
			<form method="post" action="./ResetBasket.do">
				<input type="submit" value="비우기" class="btn btn-outline-secondary" />
			</form>
			
		</div>
	</div>
</body>
</html>