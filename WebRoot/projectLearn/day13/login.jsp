<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + ":// " + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录接收页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	    <a href="index.jsp" target=main>
    返回</a> <br> 接受值
	<jsp:useBean id="u" class="com.itheima.user.orm.YunhaiUser"></jsp:useBean>
	<jsp:setProperty property="userName" name="u" />
	<jsp:setProperty property="password" name="u" />
	<br>
	<!-- 打印值 -->
	用户名：<jsp:getProperty property="userName" name="u" />
	<br> 密码：<jsp:getProperty property="password" name="u" />
</body>
</html>
