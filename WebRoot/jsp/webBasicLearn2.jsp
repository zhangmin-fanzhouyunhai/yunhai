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

<title>Learning</title>

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
	<A class=style2
		href="${pageContext.request.contextPath}/html/webBasicLearn.html"
		target=main>webBasicLearn</A>
	<br>
	<table width="80%" align="center">
		<tr>
			<td align="center">序号</td>
			<td align="center">案例链接</td> 
			<td align="center">序号</td>
			<td align="center">案例链接</td> 
		</tr>
		<tr align="center"> 
			<td align="center">1</td>
			<td style="vertical-align: top;"><A class=style2
				href="${pageContext.request.contextPath}/jsp/day13/account.jsp"
				target=main>转账</A>
			</td>
			<td align="center">2</td>
			<td style="vertical-align: top;">
				<A class=style2
				href="${pageContext.request.contextPath}/studyEachDay/day15/index.jsp"
				target=main>原生的ajax</A>
			</td>
		</tr>
		<tr align="center"> 
			<td align="center">3</td>
			<td style="vertical-align: top;"><A class=style2
				href="${pageContext.request.contextPath}/dataProcedure/dataProcedure.jsp"
				target=main>存储过程处理</A>
			</td>
			<td align="center">4</td>
			<td style="vertical-align: top;">
			<A class=style2
				href="${pageContext.request.contextPath}/studyEachDay/day13/model1/form.jsp"
				target=main>javabean</A>
			</td>
		</tr>
		<tr align="center"> 
			<td align="center">5</td>
			<td style="vertical-align: top;">
				<A class=style2
				href="${pageContext.request.contextPath}/studyEachDay/day14/index.jsp"
				target=main>产品管理</A> <br>
			</td>
			<td align="center">6</td>
			<td style="vertical-align: top;">
				<A class=style2
				href="${pageContext.request.contextPath}/studyEachDay/day16/index.jsp"
				target=main>day16/index.jsp</A>
			</td>
		</tr>
	</table>
</body>
</html>
