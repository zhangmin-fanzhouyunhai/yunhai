<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Insert title here</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
  </head>
  <script type="text/javascript">
  $(function(){
  	$("#btn").click(function(){
  		var url="/Day29/jqueryAjaxServlet";
  		//var params="username=张三";
  		var params={"username":"张苏纳"};
  		//load方式
  		/* $(this).load(url,params,function(data){
  			alert(data);
  		}); */
  		//get方式
  		/* $.get(url,params,function(data){
  			alert(data);
  		});  */
  		//post方式
  		/* $.post(url,params,function(data){
  			alert(data.msg);
  			alert(data.result);
  		},"json");  */
  		
  		//ajax方式
  		$.ajax({
  			url:url,
  			type:"post",
  			data:params,
  			success:function(data){
  			alert(".ajax"+data.msg);
  			},
  			error:function(){
  			},
  			dataType:"json"  		
  		});
  		
  	});
  })
  </script>
  <body>
    <input type="button" value="点击" id="btn">
  </body>
</html>
