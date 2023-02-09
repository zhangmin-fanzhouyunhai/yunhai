
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

<title>My JSP 'demo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- <style type="text/css">
	element.style{
		border : 1px solid red;
		width: 171px;
		height: 100px;
		position : relative;
		left: -34px
	}
	</style> -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
	//文本框keyup的时候发送ajax
	$("#keyword").keyup(function(){
		//获取文本框输入的值
		var $keyword=$(this).val();
		//alert($keyword);
		//内容为空的时候不发送ajax
		if($keyword!=null && $keyword!=''){
				$("#did").html("");
		//alert("in if:"+$keyword);
		$.post("/Day29/searchKwServlet","keyword="+$keyword,function(data){
			if(data!=""){
				var arr=data.split(",");
				$(arr).each(function(){
					//alert(this);
					//将每一个值放入 id 为  did 可以将每一个值放入一个div将这个div内部插入到id为didr div中
					$("#did").append($("<div>"+this+"</div>"));
				});
				//将div显示
				$("#did").show();
			}
		});
		}else{
				//将div显示
				$("#did").hide(); 
		}
		 
		 
	}); 
	})
</script>
</head>
<body>
	<A class=style2
		href="${pageContext.request.contextPath}/studyEachDay/day15/index.jsp"
		target=main>原生的ajax</A>
	<center>
		<div>
			<h1>黑马搜索</h1>
			<div>
				<input name="keyword" id="keyword" type="text"><input type="submit" value="搜索一下">
			</div>
			<div id="did" style="border:1px solid red; width: 171px;height:100px;position:relative;left: -34px;display:none">
			</div> 
		</div>
	</center>
</body>
</html>
