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

<title>My JSP 'userNameCheck.jsp' starting page</title>

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
	<form method="post" action="#">
		<table align="center">
			<tr>
				<td>账&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号</td>
				<td><input id="userName" type="text" name="userName"
					onblur="checkUsername(this)" value="ccc"></td>
				<td><span id="usename_msg"></span></td>
			</tr>
			<tr>
				<td>用户密码</td>
				<td><input id="password" type="password" name="password"></td>
				<td></td>
			</tr>
			<tr>
				<td>用户邮箱</td>
				<td><input id="email" type="text" name="email"></td>
				<td></td>
			</tr>
			<tr>
				<td>用户名称</td>
				<td><input id="name" type="text" name="name"></td>
				<td></td>
			</tr>
			<tr>
				<td>性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别</td>
				<td><input id="sex" type="text" name="sex"></td>
				<td></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><input id="birthday" type="text" name="birthday"></td>
				<td></td>
			</tr>
			<tr>
				<td>兴趣爱好</td>
				<td><input id="hobby" type="text" name="hobby"></td>
				<td></td>
			</tr>
			<tr align="center">
				<td></td>
				<td><input type="submit" id="RegisterSubmit"> &nbsp&nbsp&nbsp&nbsp<input
					type="reset"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	//检查失去焦点
	function checkUsername(obj) {
		//alert(obj.value)
		//1.创建核心对象
		xmlhttp = null;
		if (window.XMLHttpRequest) { // code for Firefox, Opera, IE7, etc.
			xmlhttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) { // code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		//2.编写回调函数
		xmlhttp.onreadystatechange = function() {
			//alert(123);
			//alert(xmlhttp.readyState);
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//alert("ok");
				//接受服务器回送的结果
				//alert(xmlhttp.responseText)
				if (xmlhttp.responseText == 1) {
					document.getElementById("usename_msg").innerHTML = "<font color='green'>用户名可以使用</font>";
				document.getElementById("RegisterSubmit").disabled=false;
				} else {
					document.getElementById("usename_msg").innerHTML = "<font color='red'>用户名已被占用</font>";
					document.getElementById("RegisterSubmit").disabled=true;
				}
			}
		}
		//3.open 设置请求的方式和请求的路径
		//alert("${pageContext.request.contextPath}/ajax1");
		//
		xmlhttp.open(
		"post", 
		"${pageContext.request.contextPath}/checkUsername4Ajax?username="
		 + obj.value,
		 true
		 ); //默认是true，即异步
		//4.send 发送请求
		xmlhttp.send();

	}
</script>
</html>
