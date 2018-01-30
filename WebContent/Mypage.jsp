<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<title>My Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">

<head>

</head>
<body>
	<jsp:include page="top_menu.jsp" />

	<!-- <div class="w3-container" id="about"> -->
	<table  width="1200">
		<tr>
			<td WIDTH="300">
				<div style="width: 30%; float: left">
					<jsp:include page="login.jsp" />
				</div>
			</td>
			<td WIDTH="450">
				<h3 class="w3-padding-64">
					<span class="w3-tag w3-wide w3-xlarge">My Page</span>
				</h3>
			</td>
			<td WIDTH="450"></td>
		</tr>

		<!-- <div class="w3-content" style="max-width: 800px;"> -->

		<tr>
			<td></td>
			<td>
				<P>
					<a href="./Basket.do">장바구니</a>
				</p>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<P>
					<a href="./MyRecipe.do">내 레시피</a>
				</p>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<P>
					<a href="./Subscriber.do">구독자</a>
				</p>
			</td>
			<td></td>
		</tr>
	</table>

	<p>
		<div float="center">
		<img src="https://www.w3schools.com/w3images/coffeeshop.jpg"
			style="width: 100%; max-width: 1000px" class="w3-margin-top">
		</div>
	</p>

	<!-- 	</div> -->
	<!--  </div> -->
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<title>My Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">

<head>

</head>
<body>
	<jsp:include page="top_menu.jsp" />

	<div style="width: 100%; overflow: hidden; margin: 0 auto">
		<div style="width: 27%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 60%; float: left">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">My Page</span>
			</h3>
			<P>
				<a href="./MyRecipe.do">내 레시피</a>
			</p>
			<P>
				<a href="./Basket.do">장바구니</a>
			</p>
			<P>
				<a href="./Subscriber.do">구독자</a>
			</p>


			<p>
				<img src="https://www.w3schools.com/w3images/coffeeshop.jpg"
					style="width: 100%; max-width: 1000px" class="w3-margin-top">
			</p>
		</div>
	</div>
</body>
</html>