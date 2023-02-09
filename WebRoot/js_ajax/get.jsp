<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'hello.jsp' starting page</title>
</head>

<body>
	<input type="button" value="发送AJAX请求get" onclick="btnClick()">
</body>
<script type="text/javascript">
	function btnClick() {
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
				//接受服务器回送的结果
				alert(xmlhttp.responseText)
			}
		}
		//3.open 设置请求的方式和请求的路径 
		xmlhttp.open("get", "/Day29/ajax2?username=张三", true); //默认是true，即异步
		//4.send 发送请求
		xmlhttp.send();
	}
</script>
</html>
