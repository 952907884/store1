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
	<c:if test="${empty roleList }">
		<h2>没有角色</h2>
	</c:if>
	<c:if test="${not empty roleList }">
		<table border="1">
			<tr><td>权限名称</td><td>权限描述</td><td>授权</td></tr>
			<c:forEach items="${roleList }" var="r">
				<tr><td>${r.name }</td><td>${r.description }</td><td><a href="/privilege/showRolePrivilege?role_id=${r.id }">授予权限</a></td></tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>