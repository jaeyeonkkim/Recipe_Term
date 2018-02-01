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
#contestStyle {
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

<form id=contestStyle method="post" action="./contestinfo.do">
				<fieldset>
					<legend>레시피 경쟁</legend>
					<div class="form-group">
					<input type="submit" value="contest" class="btn btn-outline-secondary" />
					</div>
				</fieldset>
			</form>

</body>
</html>