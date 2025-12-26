<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common2.jsp" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<%@ include file="common/head.jsp" %>
<body>
<%@ include file="common/header.jsp" %>
<%= name %>さんの<%= today %>の運勢は・・・
<%@ include file="common/footer.jsp" %>
</body>
</html>