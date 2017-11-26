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
	<c:if test="${empty privilegeList }">
		<h2>没有权限</h2>
	</c:if>
	<c:if test="${not empty privilegeList }">
		<table border="1">
			<tr><td>权限名称</td><td>权限路径</td><td>权限描述</td></tr>
			<c:forEach items="${privilegeList }" var="p">
				<tr><td>${p.name }</td><td>${p.fnpath }</td><td>${p.description }</td></tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>