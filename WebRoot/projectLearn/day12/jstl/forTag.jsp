<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>forTag标签</title>
    
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
	<c:forEach begin="1" end="10" step="1" var="i">
		${i }
	</c:forEach>
	<%--for(int i=1;i<=10;i++){
		i
	}
	 --%>
	 <hr>
	<c:forEach begin="1" end="50" step="2" var="i" varStatus="vs">
		${i }--${vs.count }--${vs.current }<br>
	</c:forEach>
     <br>
  </body>
</html>
