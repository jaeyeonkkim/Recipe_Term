<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
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

<!-- <div style="width:90%;overflow: hidden; margin: 0 auto">
 --><div style="width:30%;float:left">
		<jsp:include page="login.jsp"/>
	</div>
	<%int recipenum = (int)request.getAttribute("recipeNum"); %>
	<form id=enrollStyle method="post" action="./enrollRecipeway.do?recipenum=<%=recipenum%>">
	<fieldset>
		<legend>Recipe Enroll</legend>
			<div class="form-group">
			<input type="text" class="form-control" id="exampleInputEmail1" placeholder="" name="recipeway">
			</div>
	<input type="submit" value="조리법등록" class="btn btn-outline-secondary" name="more">
	</form>
					
	<form method="post" action="./enrollRecipewayComplete.do">
		<input type="submit" value="조리법등록완료" class="btn btn-outline-secondary" name="end">
	</form>
	</fieldset>
			

	<!--HTML 코드 작성 끝-->

</body>
</html>
