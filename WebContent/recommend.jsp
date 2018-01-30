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

		<h1>추천레시피</h1>
		
		<fieldset style="width: 600px">
			<legend>맑은 날</legend>
			<a class = "nav-link" href=""> 
			<img alt="img" src="https://images.unsplash.com/photo-1485963631004-f2f00b1d6606?auto=format&fit=crop&w=1268&q=80.jpg"style="width: 100%"></a>
		</fieldset>

		<fieldset style="width: 600px; float: left">
			<legend>비오는 날</legend>
		
			<table class="w3-table">
            <thead>
               <tr>
                  <th><h5>레시피 이름</h5></th>
                  <th><h5>종류</h5></th>
               </tr>
            </thead>
            <tbody>
               <%
                  ArrayList<Recipe> list1 = (ArrayList<Recipe>) request.getAttribute("list");
               if (list1.size() > 0) {
                     for (Recipe recipe : list1) {
               %>
               <tr>
                  <td><a class = "nav-link" href="./Searchrecipe2.do" title = "recipename"><%=recipe.getRecipename()%></a></td>
                  <td><%=recipe.getRtype() %></td>
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
			<img alt="img"
				src="https://images.unsplash.com/photo-1485963631004-f2f00b1d6606?auto=format&fit=crop&w=1268&q=80.jpg"
				style="width: 100%">

		</fieldset>


</body>

</html>