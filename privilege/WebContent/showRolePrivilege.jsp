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
	<c:if test="${empty role }">
		<h3>没有这个角色</h3>
	</c:if>
	
	<c:if test="${not empty role }">
		角色名称：&nbsp;&nbsp;&nbsp;&nbsp;${role.name }
		角色描述：&nbsp;&nbsp;&nbsp;&nbsp;${role.description }
		角色具有权限:&nbsp;&nbsp;&nbsp;
		<c:if test="${empty role.priList }">
			没有权限
		</c:if>
		<c:if test="${not empty role.priList }">
			<c:forEach items="${role.priList }" var="p">
				${p.name }&nbsp;&nbsp;&nbsp;
			</c:forEach>
		</c:if>
		<br>
		<br>
		重新分配角色：
		<form action="/privilege/grantRolePrivilege" method="post" target="_top">
			<input type="hidden" name="role_id" value="${role.id }">
			<c:forEach items="${privileges}" var="pri">
				<input type="checkbox" name="pids" value="${pri.id}">${pri.name}&nbsp;&nbsp;
 		</c:forEach>
			<input type="submit" value="重新授权">
		</form>
	</c:if>
</body>
</html>