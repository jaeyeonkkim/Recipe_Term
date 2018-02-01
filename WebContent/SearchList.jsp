<%@page import="com.java.model.vo.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Objects" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Search List</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}
.effect img { border-radius: 20px;}
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
            <thead>
               <tr>
                  <th width="150"><h3>난이도</h3></th>
                  <th width="150"><h3>레시피명</h3></th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <%
                  ArrayList<Recipe> searchList = (ArrayList<Recipe>) request.getAttribute("searchList");
                   if (searchList.size() > 0) { 
                     for (Recipe result : searchList) {
               %>
               <tr>
               <td><% if(Objects.equals(result.getRlevel(),"초급")) {%>
               				<div class="w3-text-red"><h3>★</h3></div>
               				<%}else if(Objects.equals(result.getRlevel(),"중급")){%>
               				<div class="w3-text-red"><h3>★★★</h3></div>
               				<%}else if(Objects.equals(result.getRlevel(),"고급")){%>
               				<div class="w3-text-red"><h3>★★★★★</h3></div>
               				<%} %></td>
                  <td><h4><a href="./searchrecipe.do?recipename=<%=result.getRecipename()%>&recipenum=<%=result.getRecipenum()%>"><%=result.getRecipename()%></a></h4></td>
                  <td><div class="effect"><img src="<%=result.getPurl()%>"style="width:250px; height:200px; max-width: 1000px" class="w3-margin-top"></div></td>
 
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
      </div>
   </div>
</body>
</html>
