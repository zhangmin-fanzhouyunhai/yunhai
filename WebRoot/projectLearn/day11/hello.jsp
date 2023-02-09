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

<title>My JSP 'hello.jsp' starting page</title>

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
	<A class=style2 href="/Day29/projectLearn/day11/index.jsp" target=main>返回</A>
	<br> hello jsp 你好。
	<br>
	<%
		int i = 3;
		System.out.println(i);
	%>
	<%=i%>
	<%
		out.print("我很好");
	%>
	<%=k%>

	<%!int k = 4;%>
	<%=k%>
</body>
</html>
