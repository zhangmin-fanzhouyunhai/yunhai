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

<title>My JSP 'elDemo.jsp' starting page</title>

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
		request.setAttribute("rkey", "rvalue");
		session.setAttribute("skey", "svalue");
		session.setAttribute("rkey", "svalue");
		application.setAttribute("akey", "avalue");
	%>
	获取request中的数据:
	<br> 老方式：<%=request.getAttribute("rkey")%><br>
	el方式：${requestScope.rkey }
	<br> 获取session中的数据:
	<br> 老方式：<%=session.getAttribute("skey")%><br>
	el方式：${sessionScope.skey }
	<br> 获取application中的数据:
	<br> 老方式：<%=application.getAttribute("akey")%><br>
	el方式：${applicationScope.akey}
	<br>
	<hr>
	获取失败老方式：<%=application.getAttribute("aakey")%><br>
	获取失败el方式：${applicationScope.aakey}
	<br>
	<hr>
	便捷获取：
	${skey},${rkey},${aakey},${akey} 
	<hr>
	${rkey }
	<hr>
	
	
</body>
</html>
