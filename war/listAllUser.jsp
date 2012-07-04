<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<s:iterator value="#request.userList" var="user" status="offset">
		第<s:property value="#offset.index + 1"/>个用户：<br/>
		登录名：<s:property value="loginName"/> <br/>
		密码：<s:property value="password"/> <br/>
		昵称：<s:property value="nickName"/> <br/>
		状态：<s:property value="status"/> <br/>
		注册时间：<s:date name="registeredTime" format="yyyy-MM-dd"/> <br/><br/><br/>
	</s:iterator>
</body>
</html>