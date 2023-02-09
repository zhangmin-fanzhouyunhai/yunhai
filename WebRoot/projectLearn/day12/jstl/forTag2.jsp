<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>jstl-forTag2标签</title>

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
		//往域中放入一个list
		List list=new ArrayList();
		list.add(11);
		list.add(22);
		list.add(33);
		request.setAttribute("list", list);
		//往域中放入一个set
		Set set=new HashSet();
		set.add("11");
		set.add("22");
		set.add("33");
		request.setAttribute("set", set);
		//往域中放入一个map
		Map map=new HashMap();
		map.put("username", "tom");
		map.put("age", 18);
		request.setAttribute("map", map);
		
		
		
	 %>
	 <c:forEach items="${list }"	var="n">
	 	${n }
	 </c:forEach>
	 <!-- 
	 	for(Integer n :list){
	 		i
	 	}
	  -->
	 <hr>
	 <c:forEach items="${set }"	var="s" varStatus="vs">
	 	${s }--${vs.count }<br>
	 </c:forEach>
	 <hr>
	 <c:forEach items="${map }"	var="m" >
	 	${m.key}--${m.value }<br>
	 </c:forEach>
	<br>
</body>
</html>
