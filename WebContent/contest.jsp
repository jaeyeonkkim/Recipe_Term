<%@page import="com.java.model.vo.ContestInfo"%>
<%@page import="com.java.model.vo.Recipe"%>
<%@page import="java.util.ArrayList"%>
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
#scroll {
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

	<c:if test="${successMessage != null}">
		<script type="text/javascript">
			alert("투표하셨습니다.");
		</script>
	</c:if>

	<c:if test="${notduplicate != null}">
		<script type="text/javascript">
			alert("중복투표는 안됩니다.");
		</script>
	</c:if>

	<jsp:include page="top_menu.jsp" />

	<div id="scroll" style="width: 90%; overflow: hidden; margin: 0 auto">
		<div style="width: 30%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 60%; float: left">
			<h1>레시피 경쟁</h1>
			<h2>
				<center>오늘의 경쟁 메뉴 :
			</h2>


			<%
			ArrayList<ContestInfo> contestList = (ArrayList<ContestInfo>) request.getAttribute("contestList");
			if (contestList.size() > 0) {
					for (ContestInfo result : contestList) { 
					%>
			<table style="width: 100%">
				<tr>
					<td>
						<div class=" w3-padding-16 w3-center" id="food"
							style="max-width: 300px"></div>
					</td>
				</tr>
				<tr>
					<th><h4>
							<center><%=result.getUserid() %>의 <%=result.getRecipename() %>
						</h4></th>
				</tr>
				<tr>
					<form method="post" action="./count.do?contestnum=<%=result.getContestnum()%>&recipenum=<%=result.getRecipenum()%>">
						<td><center>
								<img src="<%=result.getPurl()%>" width="350" height="300">
								<center>
									<input type="submit" value="투표하기"></td>
					</form>
				</tr>
			</table>
			<%}
			 }%>


			<form action="./ContestResult.do" method="post">
				<h3>
					<center>
						<input type="submit" class="btn btn-outline-secondary"
							value="결과보기">
				</h3>
			</form>

			<%-- <div id=OpStyle>
				<center>
					<textarea id="commentParentText" class="form-control col-lg-12"
						rows="2"></textarea>
				</center>
			</div>
			<div>
				<center>
					<a href="contest.jsp"><button type="button" id="list"
							class="btn btn-outline-secondary">목록</button> <a
						href="contest.jsp"><button type="button" id="write"
								class="btn btn-outline-secondary">작성</button>
				</center>
			</div> --%>
		</div>
	</div>


</body>
</html>