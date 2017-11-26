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
	<c:if test="${empty userList }">
		<h2>没有用户</h2>
	</c:if>
	<c:if test="${not empty userList }">
		<table border="1">
			<tr><td>用户名称</td><td>用户密码</td><td>用户昵称</td></tr>
			<c:forEach items="${userList }" var="u">
				<tr><td>${u.username }</td><td>${u.password }</td><td>${u.nickname }</td></tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>