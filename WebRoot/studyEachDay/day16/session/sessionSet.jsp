<%@page import="com.itheima.domain.day16.domain.Person"%>
<%@page import="com.itheima.domain.day16.domain.Person2"%>
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

<title>将person对象添加到session中</title>

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
	<A class=style2
		href="${pageContext.request.contextPath}/studyEachDay/day16/index.jsp"
		target=main>day16/index.jsp</A>
	<br> 将person和person2对象添加到session中
	<%
		/* session.setAttribute("p", new Person(1, "tom")); */
		session.setAttribute("p2", new Person2(2, "jack"));
	%>
</body>
</html>
