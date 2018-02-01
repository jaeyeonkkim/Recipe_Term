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

<style type="text/css">
#scroll{
	overflow: auto;
}
#OpStyle {
	text-align: center;
	margin-top: 1cm;
}
</style>

<title>레시피 볼래?</title>

</head>
<body>
	<c:if test="${errorMessage1 != null}">
		<script type="text/javascript">
			alert("로그인 후 시도해주세요.");
		</script>
	</c:if>

	<c:if test="${successMessage1 != null}">
		<script type="text/javascript">
			alert("1번 후보를 선택하였습니다.");
		</script>
	</c:if>

	<c:if test="${successMessage2 != null}">
		<script type="text/javascript">
			alert("2번 후보를 선택하였습니다.");
		</script>
	</c:if>

	<c:if test="${notduplicate != null}">
		<script type="text/javascript">
			alert("중복");
		</script>
	</c:if>

	<jsp:include page="top_menu.jsp" />

	<div  id="scroll" style="width: 90%; overflow: hidden; margin: 0 auto">
		<div style="width: 30%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 60%; float: left">


			<form id='selPic' name='selPic' action='contest.jsp' method="post">
				<h1>레시피 경쟁</h1>
				<h2>
					<center>오늘의 경쟁 메뉴 :
				</h2>
			</form>

			<table style="width: 100%" border="2">
				<tr>
					<th><h4>
							<center>김주영의 김치볶음밥
						</h4></th>
					<th><h4>
							<center>김재연의 김치볶음밥
						</h4></th>
				</tr>
				<tr>
					<form method="post" action="./count1.do">
						<td><center>
								<img
									src="http://dthumb.phinf.naver.net/?src=%22http%3A%2F%2Fdbscthumb.phinf.naver.net%2F4430_000_1%2F20160427163505468_CBW90OWYD.jpg%2Ffe82_10_i1.jpg%3Ftype%3Dw690_fst_n%26wm%3DY%22&twidth=569&theight=530&opts=17"
									width="350" height="300">
								<center>
									<input type="submit" value="투표하기"></td>
					</form>
					<form method="post" action='./count2.do'>
						<td><center>
								<img
									src="http://dthumb.phinf.naver.net/?src=%22http%3A%2F%2Fdbscthumb.phinf.naver.net%2F2756_000_1%2F20131107200047993_FF3ZR777Z.jpg%2F120_i1.jpg%3Ftype%3Dw690_fst_n%26wm%3DY%22&twidth=500&theight=500&opts=17"
									width="350" height="300">
								<center>
									<input type="submit" value="투표하기"></td>
					</form>
				</tr>
			</table>

			<form action="./result.do" method="post">
				<h3>
					<center>
						<input type="submit" class="btn btn-outline-secondary" value="결과보기">
				</h3>
			</form>

			<div id=OpStyle>
				<center>
					<textarea id="commentParentText" class="form-control col-lg-12" rows="2"></textarea>
				</center>
			</div>
			<div>
				<center>
					<a href="contest.jsp"><button type="button" id="list"
							class="btn btn-outline-secondary">목록</button> <a href="contest.jsp"><button
								type="button" id="write" class="btn btn-outline-secondary">작성</button>
				</center>
			</div>
		</div>
	</div>


</body>
</html>