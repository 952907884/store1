<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>添加角色操作</h1>
	<font color="red">${msg}</font>
	<br>
	<form action="/privilege/login" method="post" target="_top">
		用户名称:<input type="text" name="username" size="50"><br>
		用户密码:<input type="password" name="password" size="50"><br>
		<input type="submit" value="用户登录">
	</form>
</body>
</html>