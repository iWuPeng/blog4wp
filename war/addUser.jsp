<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加用户</title>
</head>
<script type="text/javascript" charset="utf-8" ></script>
<body>
	<form action="addUser.do" method="get">
		用户名：<input type="text" name="loginName"  /><br/>
		密     码: <input type="password" name="password" /><br/>
		昵     称: <input type="text" name="nickName" /><br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>