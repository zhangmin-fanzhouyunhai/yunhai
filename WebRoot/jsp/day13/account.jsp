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

<title>My JSP 'account.jsp' starting page</title>

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
	<form method=“post" action="${pageContext.request.contextPath }/accountServlet">
		<tr>
			<td>转出方</td>
			<td><input type="text" name="fromuser"></td>
		</tr>
		<tr>
			<td>转入方</td>
			<td><input type="text" name="touser"></td>
		</tr>
		<tr>
			<td>转账金额</td>
			<td><input type="text" name="money"></td>
		</tr>
		<tr>
			<td>转入方</td>
			<td><input type="submit" name="转账"></td>
		</tr>
	</form>
</body>
</html>
