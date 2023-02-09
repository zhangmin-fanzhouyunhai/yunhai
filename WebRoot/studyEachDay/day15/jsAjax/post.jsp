<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'get.jsp' starting page</title>
    
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
    
	原生的ajax-post方式
	<br>
	<input type="button" value="点击" onclick="btnClick()"> 
  </body>
  <script type="text/javascript">
  	function btnClick(){
  		//1.创建核心对象
		xmlhttp = null;
		if (window.XMLHttpRequest) {
		// code for Firefox, Opera, IE7, etc.
			xmlhttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
		// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		//2.编写回调函数
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				//alert('ok!!!!');
				//接受服务器回送过来的数据
				alert(xmlhttp.responseText);
			}
		}
		//方案1
		//3.open 设置请求的方式和请求路径
		//xmlhttp.open("post","${pageContext.request.contextPath}/ajaxServlet2?username=张三"); 
		//4.send 发送请求
		//xmlhttp.send();
  		
  		//方案2
  		//3.open 设置请求的方式和请求路径
		xmlhttp.open("post","${pageContext.request.contextPath}/ajaxServlet2"); 
		
		//设置请求头
		xmlhttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
		//4.send 发送请求
		xmlhttp.send("username=张三");
  	}
  
  </script>
  
</html>
