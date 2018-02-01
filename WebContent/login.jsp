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

	<c:if test="${errorMessage != null}">
		<h5>${errorMessage}</h5>
	</c:if>

	<c:choose>
		<c:when test="${sessionScope.user != null}">
			<div id=loginStyle>
				<fieldset>
					<legend>My Page</legend>
					<div class="form-group">
						${sessionScope.user.userId}님 로그인 중
					</div>
					<a href="./logout.do" class="btn btn-outline-secondary">logout</a>
					<a href="./Mypage.jsp" class="btn btn-outline-secondary">My page</a>
					<a href="./enroll.jsp" class="btn btn-outline-secondary">Enroll<br>Recipe</a>
				</fieldset>

			</div>
		</c:when>
		<c:otherwise>
			<form id=loginStyle method="post" action="./login.do">
				<fieldset>
					<legend>Login</legend>
					<div class="form-group">
						<label for="exampleInputEmail1">ID</label> <input type="text"
							class="form-control" id="exampleInputEmail1" placeholder="ID"
							name="userid">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password" name="password">
					</div>
					<input type="submit" value="Login" class="btn btn-outline-secondary" />
					<input type="reset" value="Back" class="btn btn-outline-secondary" />
				</fieldset>
			</form>
		</c:otherwise>
	</c:choose>
	<hr />


	<!--HTML 코드 작성 끝-->

</body>
</html>