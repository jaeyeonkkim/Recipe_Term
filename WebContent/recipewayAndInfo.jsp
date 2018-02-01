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
<body>
	<jsp:include page="top_menu.jsp" />

	<div style="width: 100%; overflow: hidden; margin: 0 auto">
		<div style="width: 27%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 73%; float: left">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">레시피</span>
			</h3>
			<table class="w3-table" width="800">
				<thead>
					<tr>
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
						ArrayList<RecipewayAndInfo> recipewayAndInfo = (ArrayList<RecipewayAndInfo>) request
								.getAttribute("recipewayAndInfo");
						if (recipewayAndInfo.size() > 0) {
							for (RecipewayAndInfo recipeway : recipewayAndInfo) {
					%>
					<%
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
						<td width="800"><%=recipeway.getStory()%></td>
					</tr>
			</table>
			<%
				}

				} else {
			%>
			<tr>
				<td colspan="2">
					<h3>조회결과가 없습니다.</h3>
				</td>
			</tr>
			</tbody>
			<%
				}
			%>
			</table>
			<table border="2" width="350">
				<thead>
					<tr>
						<th width="100">재료명</th>
						<th width="150">수량</th>
						<c:if test="${sessionScope.user != null}">
						<th width="100">장바구니</th>
						</c:if>
					</tr>
				</thead>

				<tbody>
					<%
						ArrayList<Ingredient> recipeIngredient = (ArrayList<Ingredient>) request.getAttribute("recipeIngredient");
						if (recipeIngredient.size() > 0) {
							for (Ingredient recipeway : recipeIngredient) {
					%>
					<tr>
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
</body>
</html>