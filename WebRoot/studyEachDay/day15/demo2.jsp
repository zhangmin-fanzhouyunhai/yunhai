
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
	//给username派发一个失去焦点事件，发送ajax请求
	$("input[name='username']").blur(function(){
		//获取输入的值
		var $value=$(this).val();
		//alert($value);
		$.get("/Day29/checkUsername4Ajax","username="+$value,function(data){
			//alert(data);
			if(data==1){
				$("#usernameMsg").html("<font color='green'>用户名可以使用</font>");
			}else{
				$("#usernameMsg").html("<font color='red'>用户名不可使用</font>");
			
			} 
		});
	}); 
	})
</script>
</head>
<body>
	<A class=style2
		href="${pageContext.request.contextPath}/studyEachDay/day15/index.jsp"
		target=main>原生的ajax</A>
	<br>
	<center>注册</center>
	<hr>
	<center>
		<form action="#" method="post">
			<table>
				<tr>
					<td align="right">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
					<td><input type="text" name="username"
						></td>
					<td><span id="usernameMsg"></span></td>
				</tr>
				<tr>
					<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
					<td><input type="password" name="password"></td>
					<td><span id="passwordMsg"></span></td>
				</tr>
				<tr>
					<td align="right">&nbsp;&nbsp;Email&nbsp;&nbsp;&nbsp;:</td>
					<td><input type="text" name="email"></td>
					<td><span id="emailMsg"></span></td>
				</tr>
				<tr>
					<td align="right">用户姓名:</td>
					<td><input type="text" name="name"></td>
					<td></td>
				</tr>
				<tr>
					<td align="right">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
					<td align="center"><input type="radio" name="sex" value="man">男</input>
						&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex"
						value="feman">女</input></td>
					<td></td>
				</tr>
				<tr>
					<td align="right">出生日期:</td>
					<td><input type="text" name="birthday"></td>
					<td></td>
				</tr>
				<tr align="right">
					<td>爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好:</td>
					<td><input type="text" name="hobby"></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input type="submit"
						id="submit" value="提交" > &nbsp;&nbsp;&nbsp;&nbsp; <input
						type="reset" id="reset" value="重置"></td>
					<td></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
