<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>레시피 볼래?</title>
</head>
<body>

<jsp:include page="top_menu.jsp"/>

<div style="width:90%;flow: hidden; margin: 0 auto">
	<div style="width:30%;float:left">
		<jsp:include page="login.jsp"/>
	</div>

	<div style="width:60%;float:left">
		<jsp:include page="main_contest.jsp" />
		
	</div>
</div>


</body>
</html>