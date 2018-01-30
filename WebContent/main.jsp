<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>레시피 볼래?</title>

</head>
<body>
	<!--HTML 코드 작성 시작-->

	<jsp:include page="top_menu.jsp" />

	<div style="width: 90%; overflow: hidden; margin: 0 auto">
		<div style="width: 30%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 60%; float: left">
			<img
				src="https://images.unsplash.com/photo-1485963631004-f2f00b1d6606?auto=format&fit=crop&w=1268&q=80.jpg"
				width="500" height="300" alt="food1"
				style="display: block; margin: 0 auto" />
		</div>
	</div>
</body>
</html>