<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<h1>这里是首页</h1>
	<% response.sendRedirect(response.encodeRedirectURL("wellcome")); %> 
</body>
</html>