<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enroll Recipe</title>

<style>
#enrollStyle {
	margin: auto;
/* 	text-align: center; */
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
	<jsp:include page="top_menu.jsp" />
	<div style="width:30%;float:left">
		<jsp:include page="login.jsp"/>
	</div>
	
	
	
	<form action="Enroll.do?rlike=0&rclick=0&rscrap=0&purl=0" method="POST" style="display: inherit;">
	
	<div id=enrollStyle>
		<fieldset>
			<legend style="text-align:center">Recipe Enroll</legend>
		레시피이름 : <input type="text"  name="recipename" /> <br /> <br>
		종류 : <select name="rtype">
				<option value="한식">한식</option>
				<option value="중식">중식</option>
				<option value="양식">양식</option>
				<option value="간식">간식</option>
				</select> <br><br>
		난이도 : <select name="rlevel">
				<option value="고급">고급</option>
				<option value="중급">중급</option>
				<option value="초급">초급</option>
				</select> <br> <br>
		조리시간 : <input type="text"  name="rtime" /> <br /><br>
		
		<input type="submit" class="btn btn-outline-primary" value="등록" /> 
		<input type="reset" class="btn btn-outline-primary" value="취소" />
		
		</fieldset>
	</div>
	</form>
</html>