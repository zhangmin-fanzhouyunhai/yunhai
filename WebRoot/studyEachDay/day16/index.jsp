<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>life</title>
    
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
  <A class=style2 href="./jsp/webBasicLearn2.jsp" target=main>－基础Web学习3</A>
														<br>
  	<a href="${pageContext.request.contextPath }/studyEachDay/day16/life/request.jsp">
  		演示request的创建和销毁
  	</a> <br>
  	<a href="${pageContext.request.contextPath }/studyEachDay/day16/life/sessionDis.jsp">
  		演示session销毁
  	</a> <br>
  	<a href="${pageContext.request.contextPath }/studyEachDay/day16/attr/attrSet.jsp">
  		演示添加属性
  	</a> <br>
  	<a href="${pageContext.request.contextPath }/studyEachDay/day16/attr/attrReplace.jsp">
  		演示替换属性
  	</a> <br>
  	<a href="${pageContext.request.contextPath }/studyEachDay/day16/attr/attrRemove.jsp">
  		演示移除属性
  	</a> <br>
  	<a href="${pageContext.request.contextPath }/studyEachDay/day16/session/sessionSet.jsp">
  		javabean绑定到session
  	</a> <br>
  	<a href="${pageContext.request.contextPath }/studyEachDay/day16/session/sessionRem.jsp">
  		javabean从session中解绑
  	</a> <br>
  	
  	
  </body>
</html>
