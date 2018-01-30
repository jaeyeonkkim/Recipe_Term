<%@page import="com.java.model.vo.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="top_menu.jsp" />
<jsp:include page="login.jsp" />

	<h2>레시피 조회 결과입니다.</h2>
	<table>
		<thead>
			<tr>
				<th>레시피이름</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Recipe> recipeList = (ArrayList<Recipe>) request.getAttribute("recipeList");
				if (recipeList.size() > 0) {
					for (Recipe recipe : recipeList) {
			%>
			<tr>
				<td><%=recipe.getRecipename()%></td>
				<td><%=recipe.getRtype()%></td>
				<td><%=recipe.getRlevel()%></td>
				<td><%=recipe.getRlike()%></td>
				<td><%=recipe.getRtime()%></td>
				<%-- <td><%= recipe.getRclick() %></td>
		<td><%= recipe.getRcrap() %></td> --%>
			</tr>
			<%
				}
				} else {
			%>
			<tr>
				<td colspan="2">조회결과가 없습니다.</td>
			</tr>

			<%
				}
			%>

		</tbody>
	</table>
</body>
</html>