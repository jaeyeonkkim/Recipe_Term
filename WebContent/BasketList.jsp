<%@page import="com.java.model.vo.Ingredient"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<title>Basket List</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body,h1,h2,h3,h4,h5,h6 {
    font-family: "Comic Sans MS", cursive, sans-serif;
}
</style>
</head>
<body>
	<jsp:include page="top_menu.jsp" />

	<div style="width: 100%; overflow: hidden; margin: 0 auto">
		<div style="width: 27%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 60%; float: left">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">장바구니</span>
			</h3>
			<table class="w3-table">
				<thead>
					<tr>
						<th><h3>재료명</h3></th>
						<th><h3>수량</h3></th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Ingredient> ingredientList = (ArrayList<Ingredient>) request.getAttribute("ingredientList");
						if (ingredientList.size() > 0) {
							for (Ingredient ingredient : ingredientList) {
					%>
					<tr>
						<td><%=ingredient.getIndName()%></td>
						<td><%=ingredient.getAmount()%></td>
					</tr>
					<%
						}
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

				</tbody>
			</table>
			<p>
				<img
					src="https://images.unsplash.com/photo-1441123285228-1448e608f3d5?auto=format&fit=crop&w=1350&q=80.jpg"
					style="width: 100%; max-width: 1000px" class="w3-margin-top">
			</p>
		</div>
	</div>
</body>
</html>