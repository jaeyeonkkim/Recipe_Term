<%@page import="com.java.model.vo.RecipewayAndInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top_menu.jsp" />

	<div style="width: 100%; overflow: hidden; margin: 0 auto">
		<div style="width: 27%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 60%; float: left">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">레시피</span>
			</h3>
			<table class="w3-table">
				<thead>
					<tr>
						<th><h3>레시피이름</h3></th>
						<th><h3>종류</h3></th>
						<th><h3>난이도</h3></th>
						<th><h3>조리시간</h3></th>
					</tr>
				</thead>
				<tbody>
					<%
						int cnt=0;
						ArrayList<RecipewayAndInfo> recipewayAndInfo = (ArrayList<RecipewayAndInfo>) request.getAttribute("recipewayAndInfo");
						if (recipewayAndInfo.size() > 0) {
							for (RecipewayAndInfo recipeway : recipewayAndInfo) {
					%>
						<% while(cnt<1){%>
					<tr>
						<td><%=recipeway.getRecipename()%></td>
						<td><%=recipeway.getRtype()%></td>
						<td><%=recipeway.getRlevel()%></td>
						<td><%=recipeway.getRtime()%></td>
					</tr>
					<% cnt++;
							
						}
						%>
					<tr>
						<td><%=recipeway.getSequence()%></td>
						<td><%=recipeway.getStory()%></td>
					</tr>
					<%
						}
						} else {
					%>
					<tr>
						<td colspan="2">
							<h3>조회결과가 없습니다.</h3>
						</td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
			
		</div>
	</div>
</body>
</html>