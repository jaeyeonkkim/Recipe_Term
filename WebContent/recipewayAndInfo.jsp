<%@page import="com.java.model.vo.Ingredient"%>
<%@page import="com.java.model.vo.RecipewayAndInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RecipeWay And Information</title>
</head>
<style>

.effect img {
    border-radius: 20px;
}

</style>
<body>
	<jsp:include page="top_menu.jsp" />
		<div style="width: 30%; float: left">
			<jsp:include page="login.jsp" />
		</div>
<div class="w3-container" id="about">
	<div class="w3-content">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">레시피</span></h3>

				<table class="w3-table" width="800">
					<thead>
						<tr style="text-align:center">
							<th width="150"><h3>레시피이름</h3></th>
							<th width="100"><h3>종류</h3></th>
							<th width="100"><h3>난이도</h3></th>
							<th width="100"><h3>조리시간</h3></th>
							<th width="100"></th>
							<th width="100"></th>
						</tr>
					</thead>
					<tbody>
					<%
						int cnt = 0;
						ArrayList<RecipewayAndInfo> recipewayAndInfo = (ArrayList<RecipewayAndInfo>) request.getAttribute("recipewayAndInfo");
						if (recipewayAndInfo.size() > 0) {
							for (RecipewayAndInfo recipeway : recipewayAndInfo) {
						while (cnt < 1) {
					%>
					<tr>
						<td><%=recipeway.getRecipename()%></td>
						<td><%=recipeway.getRtype()%></td>
						<td><%=recipeway.getRlevel()%></td>
						<td><%=recipeway.getRtime()%></td>
						<c:if test="${sessionScope.user != null}">
							<td>
								<form method="post"
									action="./Scrap.do?recipenum=<%=recipeway.getRecipenum()%>&recipename=<%=recipeway.getRecipename()%>">
									<input type="submit" value="스크랩"
										class="btn btn-outline-secondary" />
								</form>
							</td>
							<td>
								<form method="post"
									action="./SubscribeUser.do?usernum=<%=recipeway.getUsernum()%>&recipename=<%=recipeway.getRecipename()%>&recipenum=<%=recipeway.getRecipenum()%>">
									<input type="submit" value="작성자 구독"
										class="btn btn-outline-secondary" />
								</form>
							</td>
						</c:if>
					</tr>
				</tbody>
			</table>
			<%
				cnt++;
						}
			%>
			<table class="w3-table" width="900">
				<tbody>
				<tr>
				<td width="100"><%=recipeway.getSequence()%></td>
				<% if(recipeway.getRecipenum()>30){ %>
               		<td><div class="effect"><img src="/jay_0129/upload/<%=recipeway.getPicture()%>" alt="image"	width="300" height="300"></div></td>
               	<% }else{%>
               	<td><div class="effect"><img src="/jay_0129/upload/<%=recipeway.getPicture()%>" alt="image"	width="300" height="300"></div></td>
               		<%-- <td><div class="effect"><img src=<%=recipeway.getPicture()%>" alt="image"	width="300" height="300"></div></td> --%>
               	<%} %>
               	<td width="800"><%=recipeway.getStory()%></td>
				</tr>
				</tbody>
			</table>
			<%
				}

				} else {
			%>
			<table>
			<tr>
				<td colspan="2">
					<h3>조회결과가 없습니다.</h3>
				</td>
			</tr>
			</table>
			<%
				}
			%>

			
			<br><br>
			<table>
				<thead>
					<tr class="table-active" style="text-align:center">
					<% ArrayList<Ingredient> recipeIngredient = (ArrayList<Ingredient>) request.getAttribute("recipeIngredient"); %>
						<th scope="row" width="150">재료명</th>
						<th scope="row" width="150">수량</th>
						<c:if test="${sessionScope.user != null}">
							<th scope="row"  width="150">장바구니</th>
						</c:if>
					</tr>
				</thead>

				<tbody>
					<%
						if (recipeIngredient.size() > 0) {
							for (Ingredient recipeway : recipeIngredient) {
					%>
					<tr style="text-align:center">
						<td><%=recipeway.getIndName()%></td>
						<td><%=recipeway.getAmount()%></td>
						<c:if test="${sessionScope.user != null}">
							<td>
								<form method="post"
									action="./InputBasket.do?indnum=<%=recipeway.getIndnum()%>&recipename=<%=recipeway.getRecipename()%>&recipenum=<%=recipeway.getRecipenum()%>">
									<input type="submit" value="담기"
										class="btn btn-outline-secondary" />
								</form>
							</td>
						</c:if>
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
		</div>
		</div>
		<br><br>
</body>
</html>