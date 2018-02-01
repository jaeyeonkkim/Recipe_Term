<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.model.vo.Recipe"%>
<%@page import="java.util.Objects" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recommend Recipe</title>
</head>

<style>
.effect img {
    border-radius: 20px;
}
</style>



<body>

<jsp:include page="top_menu.jsp" />
	<div style="width:30%;float:left">
		<jsp:include page="login.jsp"/>
	</div>

	<div class="w3-content">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">추천레시피</span></h3>
		
		<fieldset style="width: 700px; float: right">
			<legend>맑은 날</legend>
			<table class="w3-table">
            <tbody>
               <%
                  ArrayList<Recipe> list1 = (ArrayList<Recipe>) request.getAttribute("list");
               if (list1.size() > 0) {
                     for (Recipe recipe : list1) {
               %>
               <tr>
               		<td><div class="effect"><img src="<%=recipe.getPurl()%>" alt="image"	width="300" height="300"></div></td>
               		<td><h3><a href="./searchrecipe.do?recipename=<%=recipe.getRecipename()%>&recipenum=<%=recipe.getRecipenum()%>">
						<%=recipe.getRecipename()%></a></h3></td>
               		<td><% if(Objects.equals(recipe.getRlevel(),"초급")) {%>
               				<div class="w3-text-red"><h3>★</h3></div>
               				<%}else if(Objects.equals(recipe.getRlevel(),"중급")){%>
               				<div class="w3-text-red"><h3>★★★</h3></div>
               				<%}else if(Objects.equals(recipe.getRlevel(),"고급")){%>
               				<div class="w3-text-red"><h3>★★★★★</h3></div>
               				<%} %>
               				</td>
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

		<fieldset style="width: 700px; float: right">
			<legend>비오는 날</legend>
			<table class="w3-table">
            <tbody>
               <%
                  ArrayList<Recipe> list2 = (ArrayList<Recipe>) request.getAttribute("list1");
               if (list1.size() > 0) {
                     for (Recipe recipe : list2) {
               %>
               <tr>
               		<td><div class="effect"><img src="<%=recipe.getPurl()%>" alt="image"	width="300" height="300"></div></td>
               		<td><h3><a href="./searchrecipe.do?recipename=<%=recipe.getRecipename()%>&recipenum=<%=recipe.getRecipenum()%>">
						<%=recipe.getRecipename()%></a></h3></td>
               		<td><% if(Objects.equals(recipe.getRlevel(),"초급")) {%>
               				<div class="w3-text-red"><h3>★</h3></div>
               				<%}else if(Objects.equals(recipe.getRlevel(),"중급")){%>
               				<div class="w3-text-red"><h3>★★★</h3></div>
               				<%}else if(Objects.equals(recipe.getRlevel(),"고급")){%>
               				<div class="w3-text-red"><h3>★★★★★</h3></div>
               				<%} %>
               				</td>
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
		
		
		<fieldset style="width: 700px; float: right">
			<legend>주말 저녁</legend>
			<table class="w3-table">
            <tbody>
               <%
                  ArrayList<Recipe> list3 = (ArrayList<Recipe>) request.getAttribute("list2");
               if (list1.size() > 0) {
                     for (Recipe recipe : list3) {
               %>
               <tr>
               		<td><div class="effect"><img src="<%=recipe.getPurl()%>" alt="image"	width="300" height="300"></div></td>
               		<td><h3><a href="./searchrecipe.do?recipename=<%=recipe.getRecipename()%>&recipenum=<%=recipe.getRecipenum()%>">
						<%=recipe.getRecipename()%></a></h3></td>
               		<td><% if(Objects.equals(recipe.getRlevel(),"초급")) {%>
               				<div class="w3-text-red"><h3>★</h3></div>
               				<%}else if(Objects.equals(recipe.getRlevel(),"중급")){%>
               				<div class="w3-text-red"><h3>★★★</h3></div>
               				<%}else if(Objects.equals(recipe.getRlevel(),"고급")){%>
               				<div class="w3-text-red"><h3>★★★★★</h3></div>
               				<%} %>
               				</td>
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
		</div>
	
</body>
</html>