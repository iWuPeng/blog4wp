<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="item" items="${userList }" varStatus="s">
		第<c:out value="${s.index }"></c:out>个用户信息<br/>
		登陆名：<c:out value="${item.loginName }"></c:out><br/>
		密码：<c:out value="${item.password }"></c:out><br/>
		<c:out value="${item.nickName }"></c:out><br/>
		<c:out value="${item.status }"></c:out><br/>
		<c:out value="${item.registeredTime }"></c:out><br/><br/><br/>
	</c:forEach>
</body>
</html>