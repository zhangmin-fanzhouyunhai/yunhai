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

<title>编辑商品</title>

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
	<%
		String code = UUIDUtils.getCode();
		//将code放入session	后台需要验证
		session.setAttribute("sToken", code);
		//将code放入pagecontext域
		pageContext.setAttribute("rToken", code);
	%>
	<input type="hidden" name="rToken" value="${rToken }">
	<form action="${pageContext.request.contextPath}/editProductServlet">
		<!-- 将商品的productId提交过去 -->
		<table border="1" align="center">
			<input type="hidden" name="productId" value="${bean.productId }">
			<tr align="center">
				<td width="100">产品名称</td>
				<td id="productName" align="center"><input type="text"
					name="productName" value="${bean.productName }"></td>
			</tr>
			<tr align="center">
				<td width="100">产品图片</td>
				<td id="productImage" align="center"><img alt=""
					src="${pageContext.request.contextPath}/${bean.productImage }"
					width="60"></td>
			</tr>
			<tr align="center">
				<td width="70">市场价</td>
				<td id="marketPrice" align="center"><input type="text"
					name="marketPrice" value="${bean.marketPrice }"></td>
			</tr>
			<tr align="center">
				<td width="70">采购价</td>
				<td id="shopPrice" align="center"><input type="text"
					name="shopPrice" value="${bean.shopPrice }"></td>
			</tr>
			<tr align="center">
				<td width="100">产品日期</td>
				<td id="productDate" align="center"><input type="text"
					name="productDate" value="${bean.productDate }"></td>
			</tr>
			<tr align="center">
				<td width="200">产品备注</td>
				<td id="productDescription" align="center"><textarea rows="8"
						cols="20" name="productDescription">"${bean.productDescription }"</textarea>

				</td>
			</tr>
			<tr align="center">
				<td width="10" colspan="2"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>
