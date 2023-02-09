<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
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
    
<table border="1" align="center" width="20%"> 
<tr>
<td>商品名称</td>
<td>商品数量</td>
</tr>
<%
	//1.获取购物车
	Map<String, Integer> map=(Map<String, Integer>)request.getSession().getAttribute("cart");
	//2.判断购物车是否为空
	if(map==null){
	//2.1若为空，亲，购物车空空，先去逛逛...
	out.print("<tr><td colspan='2'>亲，购物车空空，先去逛逛...</td></tr>");
	}else{
	//2.2.若不为空：遍历购物车
	for(String name:map.keySet()){
	
		out.print("<tr>");
		out.print("<td>");
		out.print(name);
		out.print("</td>");
		out.print("<td>");
		out.print(map.get(name));
		out.print("</td>");
		out.print("</tr>");  
		}
	}
 %>
</table>
<hr>
<center>
<a href="/Day29/projectLearn/day11/product_list.jsp">继续购物</a>&nbsp;&nbsp;&nbsp;
<a href="/Day29/clearCartServlet">清空购物车</a>
  </center>
  </body>
</html>
