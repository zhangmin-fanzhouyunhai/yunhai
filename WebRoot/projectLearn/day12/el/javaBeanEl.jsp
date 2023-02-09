<%@page import="com.itheima.day12.domain.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>javabean导航</title>

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
    <a href="/Day29/projectLearn/day12/index.jsp">返回</a>
	<br>
	<%
		User user = new User();
		user.setId("001");
		user.setUserName("小猫");
		user.setPassword("miaomi");
		//将user放入域中
		request.setAttribute("user", user);
	%>
	获取域中javabean的id值：
	<br> 老方式：<%=((User) request.getAttribute("user")).getId()%>
	<br> el方式：${user.id }
	<!-- 相当于调用getXxx() -->
<hr>
el获取那么：${user.userName } <br>
 
</body>
</html>
