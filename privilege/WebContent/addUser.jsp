<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>添加用户</h2>
<form action="/privilege/addUser" method="post">
	用户名称：<input type="text" name="username"size="50"></br>
	用户密码：<input type="text" name="password" size="50"></br>
	用户昵称：<input type="text" name="nickname" size="50"></br>
	<input type="submit" value="添加添加用户">
</form>
</body>
</html>