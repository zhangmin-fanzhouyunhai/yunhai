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
    
    <title>My JSP 'choose.jsp' starting page</title>
    
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
    <c:set var="day" value="4"></c:set>
    <!-- 相当于pageContext.setAttribute("day",3) -->
     <br>
     <c:choose>
     	<c:when test="${day==1 }">
     		周1
     	</c:when>
     	<c:when test="${day==2 }">
     		周2
     	</c:when>
     	<c:when test="${day==3}">
     		周3
     	</c:when>
     	<c:otherwise>
     		其他
     	</c:otherwise>
     </c:choose>
     <br>
      <br>
      <br>
      <br>
 
  </body>
</html>
