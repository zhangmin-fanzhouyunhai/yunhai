<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'complexObjectEl.jsp' starting page</title>
    
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
    	//往request域中放入数组
    	request.setAttribute("arr", new String[]{"aa","bb","cc"});
    	//往request域中放入list
    	List list=new ArrayList();
    	list.add("aaa");
    	list.add("bbb");
    	list.add("ccc");
    	request.setAttribute("list", list);
    	
    	//往request域中放入map
    	Map map=new HashMap();
    	map.put("username", "tome");
    	map.put("age",18);
    	map.put("sex","男");
    	request.setAttribute("map", map);
    	//往域 中放入一个简单数据
    	request.setAttribute("arr.age","18");
     %>
           获取域中数组：<br>
 	 老方式：<%=((String[])request.getAttribute("arr"))[1]%><br>
  	el方式：${arr[1] }<br>
  <hr>
  
           获取域中list：<br>
 	 老方式：<%=((List)request.getAttribute("list")).get(1) %><br>
  	el方式：${list[1]}<br>
  	el方式,list的长度:${list.size()}<br>
  <hr>
  
           获取域中map：<br>
 	 老方式：<%=((Map)request.getAttribute("map")).get("sex") %><br>
  	el方式：${map.sex}<br>
  	el方式：${map.age}<br>
  	el方式：${map.username}<br>
  <hr>
  	获取特殊名字的数据<br> 
  	${requestScope["arr.age"]}<br>
  
  <hr>
  
  
  
     
  </body>
</html>
