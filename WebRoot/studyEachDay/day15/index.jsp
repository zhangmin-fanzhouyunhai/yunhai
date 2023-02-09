<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>原生的ajax</title>
    
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
  	原生的ajax<br>
  	<hr>
  	
    <a href="${pageContext.request.contextPath}/studyEachDay/day15/jsAjax/hello.jsp">原生的ajax</a>  
    <a href="${pageContext.request.contextPath}/studyEachDay/day15/jsAjax/get.jsp">原生的ajax-get请求</a>  
    <a href="${pageContext.request.contextPath}/studyEachDay/day15/jsAjax/post.jsp">原生的ajax-post请求</a> 
    <a href="${pageContext.request.contextPath}/studyEachDay/day15/demo1.jsp">原生的案例1－用户名是否占用</a>  
    <hr>jquery的ajax<br><hr>
    <a href="${pageContext.request.contextPath}/studyEachDay/day15/jQueryAjax/ajax.jsp">jQuery的Ajax的四种方式</a>  
    <a href="${pageContext.request.contextPath}/studyEachDay/day15/demo2.jsp">jQuery的Ajax案例1－用户名是否占用</a>  
     <a href="${pageContext.request.contextPath}/studyEachDay/day15/demo3.jsp">jQuery的搜索</a>  
     <br>
     <a href="${pageContext.request.contextPath}/studyEachDay/day15/provinceCitySelect.jsp">jQuery的Ajax省市联动</a>  
    
    
    
  </body>
</html>
