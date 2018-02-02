<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#enrollStyle {
	margin: auto;
 	text-align: center;
	float: left;
	margin-top: 1cm;
	margin-bottom: 1cm;
	margin-left: 0.5cm;
	margin-right: 0.5cm;
	width: 500px;
}
</style>
</head>
<body>
<jsp:include page="top_menu.jsp"/>

 <div style="width:30%;float:left">
		<jsp:include page="login.jsp"/>
	</div>
	<%
			int recipenum = (int) request.getAttribute("recipeNum");
		%>
	<form id=enrollStyle method="post" action="./EnrollIngredientList.do">
	<fieldset>
		<legend>Recipe Ingredient</legend>
			<div class="form-group">
			재료명 : <input type="text" class="form-control" id="exampleInputEmail1" 
			placeholder=""	name="indname">
			수량 : <input type="text" class="form-control" id="exampleInputEmail1" 
			placeholder=""	name="amount">
			<input type="hidden" name="recipenum" value="<%=recipenum%>" />
			<%-- <input type="hidden" name="step" value="<%=step%>" /> --%>
			
			</div>
	<input type="submit" value="재료등록" class="btn btn-outline-secondary" name="more">
	<input type="reset" class="btn btn-outline-primary" value="취소" />
	</form>
					
	<form method="post" action="./enrollRecipeway.jsp?recipenum=<%=recipenum %>">
		<input type="submit" value="재료등록완료" class="btn btn-outline-secondary" name="end">
	</form>
	</fieldset>
			

	<!--HTML 코드 작성 끝-->

</body>
</html>
