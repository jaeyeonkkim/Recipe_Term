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
.effect img {
    border-radius: 20px;
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

<h3 class="w3-center w3-padding-64" >
	<span class="w3-tag w3-wide w3-xlarge">오늘의 경쟁</span></h3>

			
			<table style="width: 50%; margin: 0 auto;">
			<%
			ArrayList<ContestInfo> contestList = (ArrayList<ContestInfo>) request.getAttribute("contestList");
			if (contestList.size() > 0) {%>
			<thead>
				<tr>
					<th width="300"></th>
					<th width="300"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
			<%for (ContestInfo result : contestList) { %>
					<td style="padding:10px; padding-top:10px; text-align:center">
						<div class="effect">
						<h4><%=result.getUserid() %>의 <%=result.getRecipename() %></h4>
						<img src="<%=result.getPurl()%>" width="350" height="300"></div>
					<form method="post" action="./count.do?contestnum=<%=result.getContestnum()%>&recipenum=<%=result.getRecipenum()%>">
									<input type="submit" class="btn btn-outline-secondary" value="투표하기"></td>
					</form>
					</td>
			<% }%>
			</tr>
			</tbody>
			<% }%>
</table>


			<form action="./ContestResult.do" method="post">
				<h3>
					<center>
						<input type="submit" class="btn btn-outline-secondary" value="결과보기">
				</h3>
			</form>

		</div>
	</div>
<br><br>

</body>
</html>