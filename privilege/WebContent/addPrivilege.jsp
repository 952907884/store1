<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>添加权限操作</h2>
<form action="/privilege/addPrivilege" method="post">
	权限名称：<input type="text" name="name"size="50"></br>
	权限路径：<input type="text" name="fnpath" size="50"></br>
	描述信息：<textarea rows="10" cols="38" name="description"></textarea></br>
	<input type="submit" value="添加权限">
</form>
</body>
</html>