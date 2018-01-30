<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enroll Recipe</title>
</head>
<body>
	<jsp:include page="top_menu.jsp" />
	<jsp:include page="login.jsp" />
	<form action="Enroll.do" method="POST" style="display: inherit;">

		레시피이름 : <input type="text" name="recipename" /> <br /> 
		종류 : <input type="text" name="rtype" /> <br /> 
		난이도 : <input type="text"name="rlevel" /> <br /> 
		조리시간 : <input type="text" name="rtime" /> <br />
		
	<!--<input type="submit" value="등록" /> 
		<input type="reset" value="취소" />-->
		
		<input class="btn btn-outline-secondary" type="submit" value="등록" /> 
      	<input class="btn btn-outline-secondary" type="submit" value="취소" />

	</form>
</html>