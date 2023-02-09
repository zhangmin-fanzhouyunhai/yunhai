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

<title>My JSP 'caculateEl.jsp' starting page</title>

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
		request.setAttribute("i", 3);
		request.setAttribute("j", 4);
		request.setAttribute("q", "12");
		request.setAttribute("k", "k");
		List list = null;
		request.setAttribute("list", list);
		List arrayList = new ArrayList();
		arrayList.add("22");
		request.setAttribute("arrayList", arrayList);
		User user = null;
		request.setAttribute("user", user);
		User user2 = new User();
		request.setAttribute("user2", user2);
	%><br> ${i+j }
	<br> ${i+q }
	<br> ${q+q }
	<br>
	<%-- ${i+k }<br> --%>
	<hr>
	域中list的长度是否为0：${empty list }
	<hr>
	域中arrayList的长度是否为0：${empty arrayList }
	<hr>
	域中bean的是否为空：${empty user }
	<hr>
	域中bean的是否为空：${empty user2 }
	<hr>
	${3>4?"yes":"no"}<br>
	
	${i==3?"yes":"no"}
	<hr>
	
	
</body>
</html>
