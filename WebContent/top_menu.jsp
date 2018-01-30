<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
	integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
	crossorigin="anonymous">

<!--minty Theme-->
<link rel="stylesheet"
	href="https://bootswatch.com/4/flatly/bootstrap.css" media="screen">
<link rel="stylesheet"
	href="https://bootswatch.com/4/flatly/bootstrap.min.css">
<link rel="stylesheet"
	href="https://bootswatch.com/4/flatly/_variables.scss">
<link rel="stylesheet"
	href="https://bootswatch.com/4/flatly/_bootswatch.scss">

<!-- w3school Theme -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">




<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
#centerStyle {
	margin: auto;
	text-align: center;
	width:500px;
	margin-top: 1cm;
	margin-bottom: 1cm;
	margin-bottom: 1cm;
	    
}
</style>
</head>
<body>
	<div id="centerStyle">
		<h2>레시피 볼래?</h2>

	</div>

	<div class="w3-row w3-large w2-light-grey">
		<div class="w3-col s3">
			<a href="#" class="w3-button w3-block w3-black">추천 레시피</a>
		</div>
		<div class="w3-col s3">
			<a href="#about" class="w3-button w3-block w3-black">고급 레시피</a>
		</div>
		<div class="w3-col s3">
			<a href="#menu" class="w3-button w3-block w3-black">중급 레시피</a>
		</div>
		<div class="w3-col s3">
			<a href="#where" class="w3-button w3-block w3-black">초급 레시피</a>
		</div>
	</div>

	<div id=centerStyle>
		<div class="form-group">
			<div class="input-group mb-3">
				<form action="enroll.jsp" method="POST" style="display: inherit;">  <!-- ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ -->
					<select name="keyField">
							<option value="all">전체</option>
							<option value="high">고급</option>
							<option value="middle">중급</option>
							<option value="low">초급</option>
					</select>
					<input type="text" class="form-control"
						aria-label="Amount (to the nearest dollar)" name="search" style="width:350px">
						
					<div class="input-group-append">
						<button type="submit" class="btn btn-secondary">검색</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!--HTML 코드 작성 끝-->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
		integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
		crossorigin="anonymous"></script>

</body>
</html>