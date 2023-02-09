<%@ page import="com.yunhai.util.UUIDUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商品添加</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link
	href="${pageContext.request.contextPath }/css/bootstrap4.6.0/bootstrap.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap4.6.0/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/userJs/contentDoubleClickEdit.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/userJs/recordUpOrDownMove.js"></script>

<style type="text/css">
.moveUpOrDown {
	background-color: #5BC0DE;
	border-radius: 3px;
	cursor: pointer;
	color: #FFFFFF;
	padding: 2px;
	font-size: 12px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("body").on("click", ".moveUpOrDown", function() {
			recordUpOrDownMove(this);
		});
	});
</script>
</head>

<body>
	<h2>
		<center>添加商品</center> 
	</h2>
	<br>
	<%
		String code=UUIDUtils.getCode();
		//将code放入session	后台需要验证
		session.setAttribute("sToken", code);
		//将code放入pagecontext域
		pageContext.setAttribute("rToken", code);
	%>
	<form action="${pageContext.request.contextPath}/addProductServlet" method="post">
	<input type="hidden" name="rToken" value="${rToken }">
	<table border="0" align="center"> 
		<tr align="center">
			<th width="100">产品信息项目</th>
			<th width="80">信息填写</th> 
		</tr> 
		<!-- <tr align="center">
			<td widtd="100">产品记录ID</td> 
			<td><input type="text" id="productId" name="productId"></td>
		</tr> 
		<tr align="center"> 
			<td widtd="80">产品图片</td>   
			<td><input type="text" id="productImage" name="productImage"></td>
		</tr>  -->
		<tr align="center"> 
			<td width="80">产品名称</td>   
			<td><input type="text" id="productName" name="productName"></td>
		</tr> 
		<tr align="center">  
			<td width="70">市场价</td>
			<td><input type="text" id="marketPrice" name="marketPrice"></td>
		</tr> 
		<tr align="center"> 
			<td width="70">采购价</td>  
			<td><input type="text" id="shopPrice" name="shopPrice"></td>
		</tr> 
		<!-- <tr align="center"> 
			<td widtd="100">产品日期</td>  
			<td><input type="text" id="productDate" name="productDate"></td>
		</tr>  -->
		<tr align="center"> 
			<td width="200">产品备注</td> 
			<td><input type="text" id="productDescription" name="productDescription"></td>
		</tr> 
		<tr align="center"> 
			<td colspan="2"><input type="submit" id="productAdd" value="提交">
			<input type="Reset" id="productAddReset" value="重置">
			</td>
		</tr> 
	</table>
	</form>
</body>
</html>
