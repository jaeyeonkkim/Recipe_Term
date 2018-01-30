<%@page import="com.java.model.vo.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subscriber List</title>
</head>
<body>
	<jsp:include page="top_menu.jsp" />

	<div style="width: 100%; overflow: hidden; margin: 0 auto">
		<div style="width: 27%; float: left">
			<jsp:include page="login.jsp" />
		</div>

		<div style="width: 60%; float: left">
			<h3 class="w3-center w3-padding-64">
				<span class="w3-tag w3-wide w3-xlarge">구독자</span>
			</h3>
			<table class="w3-table">
				<thead>
					<tr>
						<th><h3>구독자ID</h3></th>

					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<User> subscriberList = (ArrayList<User>) request.getAttribute("subscriberList");
						if (subscriberList.size() > 0) {
							for (User subscriber : subscriberList) {
					%>
					<tr>
						<td><%=subscriber.getUserId()%></td>
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
			<p>
				<img
					src="https://images.unsplash.com/photo-1415226581130-91cb7f52f078?auto=format&fit=crop&w=967&q=80.jpg"
					style="width: 100%; max-width: 1000px" class="w3-margin-top">
			</p>
		</div>
	</div>

</body>
</html>