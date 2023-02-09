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

<title>My JSP 'pagecontext.jsp' starting page</title>

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
<a href="/Day29/projectLearn/day12/index.jsp">返回</a><br>
    
	<%
		pageContext.setAttribute("rkey", "rvalue",
		 PageContext.REQUEST_SCOPE);
		session.setAttribute("rkey", "svalue");
	%>
	<br>
	通过pagecontext往request中放入一个值，取出来：
	<%=request.getAttribute("rkey") %>
	<hr>
	获取session中的rkey:<%=session.getAttribute("rkey") %>
	<br>
	便捷查找：<%=pageContext.findAttribute("rkey") %>
	<br>
	便捷查找：<%=pageContext.findAttribute("akey") %>
	<br>
</body>
</html>
