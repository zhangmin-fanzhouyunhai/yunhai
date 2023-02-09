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

<title>商品清单</title>

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
		<a href="${pageContext.request.contextPath}/findAllProduct">展示所有商品</a><br>
		<!-- <input type="text" size="50" value="50"> -->
		<!-- <textarea rows="" cols=""></textarea> -->
	</h2>
	<br>
	<table border="1" align="center">
		<tr align="center">
		<form id="searchForm"
				action="${pageContext.request.contextPath }/findProductByConditionServlet"
				method="post">
		<td colspan="8"> 
		商品名称：<input name="name" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
		关键词：<input name="keyword" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="提交">
		</td>
		</form>
		</tr>
		<tr align="center">
			<th width="2%"><input type="checkbox" id="allProduct"
				name="allProduct" onclick="checkAllProduct(this)"></th>
			<!-- <th width="10">产品记录ID</th> -->
			<th width="4%">产品图片</th>
			<th width="6%">产品名称</th>
			<th width="5%">市场价</th>
			<th width="5%">采购价</th>
			<th width="8%">产品日期</th>
			<th width="20%">产品备注</th>
			<th width="8%"><a href="javascript:void(0)"
				onclick="deleteCheckedProduct(this)">多条删除</a></th>
		</tr>
		<tr align="center">
			<form id="productFormId"
				action="${pageContext.request.contextPath }/deleteCheckedProductServlet"
				method="get">
				<c:forEach items="${list }" var="element">
					<td width="4" align="center"><input type="checkbox" id="productId"
						name="productId" value="${element.productId }"></td>
					<%-- <td id="productId" ondblclick="edit(this)" align="center" width="10">${element.productId }</td> --%>
					<td id="productImage" align="center">
					<img alt=""
						src="${pageContext.request.contextPath}/${element.productImage }"
						width="60"></td>
					<td id="productName" ondblclick="edit(this)" align="center">${element.productName }</td>
					<td id="marketPrice" ondblclick="edit(this)" align="center">${element.marketPrice }</td>
					<td id="shopPrice" ondblclick="edit(this)" align="center">${element.shopPrice }</td>
					<td id="productDate" ondblclick="edit(this)" align="center">${element.productDate }</td>
					<td id="productDescription" ondblclick="edit(this)" align="center">
						${element.productDescription }</td>
					<td width="8%"  align="center"><a
						href="${pageContext.request.contextPath }/getProductByIdServlet?productId=${element.productId }">修改</a>
						｜ <a href="javascript:void(0)"
						onclick="deleteProduct('${element.productId }')">删除</a></td>
		</tr>
		</c:forEach>
		</form>
	</table>
</body>
<script type="text/javascript">
	//删除商品
	function deleteProduct(obj) {
		//alert(obj);
		if (confirm("是否确定删除")) {
			//发送请求
			location.href = "/Day29/deleteProductByIdServlet?productId=" + obj;
		}
	}

	//删除选中 
	function deleteCheckedProduct() {
		//提交表单
		//document.getElementById("productFormId").submit();
		if (confirm("是否确定删除")) {
			$("#productFormId").submit();
		}
	}
	//全选或全不选
	function checkAllProduct(obj) {
		//获取jQuery对象变量，对象变量通过prop("属性","属性值")来完成变量的属性赋值，
		//通过prop("属性")读取属性的值
		allProduct = $("#allProduct");
		//alert(allProduct.prop("checked"));
		//allProduct.prop("checked",allProduct.prop("checked")) ;
		//alert(allProduct.prop("checked"))
		//allProduct.prop("checked",!allProduct.prop("checked")) ;
		//alert(obj.checked)

		//获取所有的复选框
		var productArr = document.getElementsByName("productId");
		//alert(productArr.length);
		//遍历数组 修改选中的状态
		if (productArr.length != 0) {
			for (var i = 0; i < productArr.length; i++) {
				productArr[i].checked = obj.checked;
			}
		}
	}
</script>




</html>
