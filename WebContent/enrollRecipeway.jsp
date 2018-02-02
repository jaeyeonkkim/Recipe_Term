<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge" >

<meta charset="utf-8">
<title>Insert title here</title>
<style>
#loginStyle {
	margin: auto;
	text-align: center;
	float: left;
	margin-top: 1cm;
	margin-bottom: 1cm;
	margin-left: 0.5cm;
	margin-right: 0.5cm;
	width: 300px;
}
</style>
</head>
<body>
	<jsp:include page="top_menu.jsp" />

	<div style="width: 90%; overflow: hidden; margin: 0 auto">
		<div style="width: 30%; float: left">
			<jsp:include page="login.jsp" />
		</div>
		
		<%
			int recipenum = 0;
		
			if( request.getParameter("recipenum") != null){
				recipenum = Integer.parseInt(request.getParameter("recipenum"));
			}else{
				recipenum = (Integer)request.getAttribute("recipenum");
			}
			
			int step = 1;
			if(request.getAttribute("step") != null){
				step = (Integer)request.getAttribute("step") +1;
			}
		%>
		
		<form id=loginStyle method="post" enctype="multipart/form-data"
			action="./enrollRecipeway.do">
			
			<fieldset>
				<legend>Recipe</legend>
				<div class="form-group">
					<p for="exampleInputEmail1"> <%=step %>단계 조리법 입력하기</p>
					<input type="text" class="form-control" id="exampleInputEmail1"
						placeholder="" name="recipeway"> 
					<input type="hidden" name="recipenum" value="<%=recipenum%>" />
					<input type="hidden" name="step" value="<%=step%>" />
					<input type="file" name="storyPicture">
						<input type="submit"
						value="조리법등록" class="btn btn-outline-secondary" name="more">
		</form>
		
		<form method="post" action="./main.jsp">

			<input type="submit" value="조리법등록완료"
				class="btn btn-outline-secondary" name="end">
	</div>

	</fieldset>
	</form>
	<!--HTML 코드 작성 끝-->
</body>
</html>










 