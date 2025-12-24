<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Mutter, java.util.List" %>
<% 
String loginUser = (String) session.getAttribute("loginUser");
List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= loginUser %>さん、ログイン中</h1>
	<p><a href="logout">ログアウト</a></p>
	<p>
		<form action="Main" method="post">
			<input type="text" name="text">
			<input type="submit" value="つぶやく">
		</form>
	</p>
	<ul>
		<% for (Mutter mutter : mutterList) { %>
			<li><%= mutter.getUserName() %> : <%= mutter.getText() %></li>
		<% } %>
	</ul>	
</body>
</html>