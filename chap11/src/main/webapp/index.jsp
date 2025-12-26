<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="FormServlet" method="post">
		名前：<input type="text" name="name"><br>
		性別：<input type="radio" name="gender" value="男">男性
		      <input type="radio" name="gender" value="女">女性<br>
		<input type="submit" value="送信">
	</form>
</body>
</html>