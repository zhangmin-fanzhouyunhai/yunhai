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
	<a href="/Day29/projectLearn/day12/page.jsp">page指令</a>
	<br>
	<a href="/Day29/projectLearn/day12/include/include.jsp">include指令</a>
	<br>
	<a href="/Day29/projectLearn/day12/pagecontext.jsp">pageContext作用</a>
	<br>
	<a href="/Day29/projectLearn/day12/action/forward.jsp">jsp动作标签-forward</a>
	<br>
	<a href="/Day29/projectLearn/day12/action/jspInclude.jsp">jsp动作标签-include</a>
	<br>
	<a href="/Day29/projectLearn/day12/el/elDemo.jsp">
	el-获取简单数据</a>
	<br>
	<a href="/Day29/projectLearn/day12/el/complexObjectEl.jsp">
	el-获取复杂数据</a>
	<br>
	<a href="/Day29/projectLearn/day12/el/javaBeanEl.jsp">
	el-javabean导航</a>
	<br>
	<a href="/Day29/projectLearn/day12/el/caculateEl.jsp">
	el-执行运算</a>
	<br>
	<a href="/Day29/projectLearn/day12/el/paramInnerObjectEl.jsp?username=tom&password=123&hobby=drink&hobby=sleep">
	el-和参数相关的内置对象(了解)</a>
	<br>
	<a href="/Day29/projectLearn/day12/el/requestHeaderEl.jsp">
	el-请求头相关的el内置对象(了解)</a>
	<br>
	<a href="/Day29/projectLearn/day12/el/wholeSituationEl.jsp">
	el-和全局初始化参数相关的el内置对象(了解)</a>
	<br>
	<a href="/Day29/projectLearn/day12/el/cookieEl.jsp">
	el-cookie内置对象(掌握)</a>
	<br>
	<a href="${pageContext.request.contextPath}/projectLearn/day12/el/pageContextEl.jsp">
	el-在jsp页面中获取项目名(掌握)</a>
	<br>
	<a href="/Day29/projectLearn/day12/jstl/ifCTag.jsp">
	jstl-cIf标签</a>
	<br>
	<a href="/Day29/projectLearn/day12/jstl/forTag.jsp">
	jstl-forTag标签</a>
	<br>
	<a href="/Day29/projectLearn/day12/jstl/forTag2.jsp">
	jstl-forTag2标签</a>
	<br>
	<a href="/Day29/projectLearn/day12/jstl/choose.jsp">
	jstl-分支标签（扩展）</a>
	<br>
	<a href="/Day29/projectLearn/day12/jstl/function.jsp">
	jstl-函数库（扩展）</a>
	<br>
	<a href="/Day29/findAllProduct">
	展示所有商品</a>
	<br>
	<br>
	
	
	
	
	
	
</body>
</html>
