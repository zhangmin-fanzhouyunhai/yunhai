<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>include頁面</title>
     
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <a href="/Day29/projectLearn/day12/index.jsp">返回</a><br>
    
    include頁面. <br>
    <hr>
    	i1的頁面：<%@include file="/projectLearn/day12/include/i1.jsp" %>
    <hr>
    	i1的頁面：<%@include file="/projectLearn/day12/include/i2.jsp" %>
  </body>
</html>
