<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.model.vo.Recipe"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recommend Recipe</title>
</head>
<body>

<jsp:include page="top_menu.jsp" />
<jsp:include page="login.jsp" />

		<h1 style = "margin-bottom: 30px; margin-top: 30px;">추천레시피</h1>
		
		<fieldset style="width: 600px">
			<legend>맑은 날</legend>
			<table class="w3-table">
            <tbody>
               <%
                  ArrayList<Recipe> list1 = (ArrayList<Recipe>) request.getAttribute("list");
               if (list1.size() > 0) {
                     for (Recipe recipe : list1) {
               %>
               <tr>
               		<td><img src="<%=recipe.getPurl()%>" alt="image"	width="300" height="300"></td>
               		<td><a href="./searchrecipe.do?recipename=<%=recipe.getRecipename()%>&recipenum=<%=recipe.getRecipenum()%>">
						<%=recipe.getRecipename()%></a></td>
               		<td><%=recipe.getRlevel() %></td>
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
               <% }%>
               </tbody>
			</table>
		</fieldset>

		<fieldset style="width: 600px; float: left">
			<legend>비오는 날</legend>
		
			<table class="w3-table">
            <tbody>
               <%
                  ArrayList<Recipe> list2 = (ArrayList<Recipe>) request.getAttribute("list1");
               if (list2.size() > 0) {
                     for (Recipe recipe : list2) {
               %>
               <tr>
               		<td><img src="<%=recipe.getPurl()%>" alt="image"	width="300" height="300"></td>
               		<td><a href="./searchrecipe.do?recipename=<%=recipe.getRecipename()%>&recipenum=<%=recipe.getRecipenum()%>">
						<%=recipe.getRecipename()%></a></td>
               		<td><%=recipe.getRlevel() %></td>
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
               <% }%>
               </tbody>
			</table>
		</fieldset>
		
		<fieldset style="width: 600px; float: right">
			<legend>주말 저녁</legend>
						<table class="w3-table">
            <tbody>
               <%
                  ArrayList<Recipe> list3 = (ArrayList<Recipe>) request.getAttribute("list2");
               if (list3.size() > 0) {
                     for (Recipe recipe : list3) {
               %>
               <tr>
               		<td><img src="<%=recipe.getPurl()%>" alt="image"	width="300" height="300"></td>
               		<td><a href="./searchrecipe.do?recipename=<%=recipe.getRecipename()%>&recipenum=<%=recipe.getRecipenum()%>">
						<%=recipe.getRecipename()%></a></td>
               		<td><%=recipe.getRlevel() %></td>
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
               <% }%>
               </tbody>
			</table>
		</fieldset>
</body>
</html>