<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
	<a href="/Day29/html/webBasicLearn.html">返回</a>
	<br>
	<a href="/Day29/projectLearn/day11/hello.jsp">hello jsp 你好。</a>
	<br> 
	<a href="/Day29/helloCookieServlet">a_cookie入门</a>
	<br> 
	<a href="/Day29/remServlet">上一次访问时间</a>
	<br> 
	<a href="/Day29/projectLearn/day11/product_list.jsp">产品列表</a>
	<br> 
	
	
  </body>
</html>
