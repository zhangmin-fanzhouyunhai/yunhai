
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
						onblur="checkUsername(this)"></td>
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
<script type="text/javascript">
	//失去焦点发送ajax
	function checkUsername(obj) {
		//alert(obj.value);
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
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//alert('ok!!!!');
				//接受服务器回送过来的数据
				//alert(xmlhttp.responseText);
				if (xmlhttp.responseText == 1) {
					document.getElementById("usernameMsg").innerHTML="<font color='greeen'>用户名可以使用</font>";
					document.getElementById("submit").disabled=false;
					
				} else {
					document.getElementById("usernameMsg").innerHTML="<font color='red'>用户名已被占用</font>";
					document.getElementById("submit").disabled=true;
				}
			}
		}
		//open操作
		xmlhttp.open("get", "${pageContext.request.contextPath}/checkUsername4Ajax?username=" + obj.value);

		//设置请求头
		//xmlhttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
		//4.send 发送请求
		xmlhttp.send();
	}
</script>
</html>
