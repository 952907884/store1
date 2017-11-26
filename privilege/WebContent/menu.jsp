<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${empty sessionScope.existUser }">
		<h2><a href="/privilege/login.jsp" target="main">你还没有登陆请登陆</a></h2>
	</c:if>
	
	<c:if test="${not empty sessionScope.existUser }">
		<c:if test="${existUser.username eq 'admin' }">
		<h3>权限管理</h3>
		<a href="/privilege/addPrivilege.jsp" target="main">添加权限</a>
		</br>
		<a href="/privilege/listPrivilege" target="main">查看权限</a>
		
		<h3>角色管理</h3>
		<a href="/privilege/addRole.jsp" target="main">添加角色</a>
		</br>
		<a href="/privilege/listRole" target="main">查看角色</a>
		
		<h3>用户管理</h3>
		<a href="/privilege/addUser.jsp" target="main">添加用户</a>
		</br>
		<a href="/privilege/listUser" target="main">查看用户</a>
		</br>
		<a href="/privilege/destroySession" target="_top">注销用户</a>
	</c:if>
		<c:if test="${existUser.username!='admin' }">
			<a href='/privilege/functions/addProduct.jsp'>添加商品</a>
			<br>
			<a href='/privilege/functions/delProduct.jsp'>删除商品</a>
			<br>
			<a href='/privilege/functions/pay.jsp'>在线支付</a>
			<br>
			<a href="/privilege/destroySession" target="_top">注销用户</a>
		</c:if>
	</c:if>
	
	
	
</body>
</html>