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
#loginStyle {
	margin: auto;
	text-align: center;
	width: 400px;
	position: absolute;
	top:10px;
	right: 10px;
}
</style>
</head>
<body>

	<c:if test="${errorMessage != null}">
		<h5>${errorMessage}</h5>
	</c:if>

	<c:choose>
		<c:when test="${sessionScope.user != null}">
			<div id=loginStyle>
					<div class="form-group">
						${sessionScope.user.userId}님 로그인 중
					</div>
					<a href="./logout.do" class="btn btn-primary">logout</a>
					<a href="./MyRecipe.do" class="btn btn-primary">My page</a>
					<a href="./enroll.jsp" class="btn btn-primary">Recipe</a>
			</div>
		</c:when>
		<c:otherwise>
			<form id=loginStyle method="post" action="./login.do">
					<div class="form-group">
						<label for="exampleInputEmail1" style="text-align: left;">ID</label> <input type="text"
							class="form-control" id="exampleInputEmail1" placeholder="ID" style="width :30%; display: inline-block"
							name="userid">

						<label for="exampleInputPassword1"  style="text-align: left;">PW</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password" name="password" style="width :30%; display: inline-block">
						<input type="submit" value="Login" class="btn btn-primary" />
					</div>					
			</form>
		</c:otherwise>
	</c:choose>
	<hr />


	<!--HTML 코드 작성 끝-->

</body>
</html>