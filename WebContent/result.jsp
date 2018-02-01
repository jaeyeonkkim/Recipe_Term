<%@page import="com.java.model.vo.ContestResult"%>
<%@page import="java.util.ArrayList"%>
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

<title>Contest Result</title>

<style>
#BackStyle {
	text-align: center;
	margin-top: 1cm;
	margin-bottom: 1cm;
}
</style>


	
</head>
<body>
	<jsp:include page="top_menu.jsp" />


	<div style="width: 100%; overflow: hidden; margin: 0 auto">
		<div style="width: 27%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 60%; float: left">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">투표결과</span>
			</h3>
			<table class="w3-table" border="2">
				<thead>
					<tr>

						<%
							for (int cnt = 1; cnt < 3; cnt++) {
						%>

						<td><center><%=cnt%>번 후보</td>
						<%
							}
						%>
					</tr>
				</thead>

				<tbody>

					<tr>
						<%
							ArrayList<ContestResult> contestResult = (ArrayList<ContestResult>) request.getAttribute("resultList");
							for (ContestResult contestresult : contestResult) {
						%>
						<td><center><%=contestresult.getResult()%>표</td>
						<%
							}
						%>
					</tr>

				</tbody>
			</table>
			<div id=BackStyle>
			<form method="post" action="./contestinfo.do">
			<input type="submit" value="Back"
					class="btn btn-outline-secondary" />
			</form>
			</div>
		</div>
	</div>
</body>
</html>