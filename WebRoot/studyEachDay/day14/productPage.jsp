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
		<a
			href="${pageContext.request.contextPath}/showProductsByPage?currentPage=1">展示所有商品</a><br>
		<!-- <input type="text" size="50" value="50"> -->
		<!-- <textarea rows="" cols=""></textarea> -->
	</h2>
	<br>
	<table width="90%">
		<tr align="center">
			<FORM id="searchForm" class="form"
				action="${pageContext.request.contextPath }/findProductByConditionServlet"
				method="post">
				<td colspan="10">商品名称：<input name="name" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
					关键词：<input name="keyword" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" name="提交">
				</td>
			</FORM>
		</tr>
	</table>
	<table border="1" align="center" class="table table-striped"
		width="90%">
		<tr align="center">
			<th width="2%"><input type="checkbox" id="allProduct"
				name="allProduct" onclick="checkAllProduct(this)"></th>
			<th width="3%">序号</th>
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
			<FORM id="productFormId" class="form"
				action="${pageContext.request.contextPath }/deleteCheckedProductPage"
				method="get">
				<input type="hidden" id="currentPage" name="currentPage"
					value="${pageBean.currentPage}">
				<c:forEach items="${pageBean.list }" var="element"
					varStatus="status">
					<td width="4" align="center"><input type="checkbox"
						id="productId" name="productId" value="${element.productId }"></td>
					<td width="4" align="center" id="serialNumber">${status.index+1}</td>
					<%-- <td id="productId" ondblclick="edit(this)" align="center" width="10">${element.productId }</td> --%>
					<td id="productImage" align="center"><img alt=""
						src="${pageContext.request.contextPath}/${element.productImage }"
						width="60"></td>
					<td id="productName" ondblclick="edit(this)" align="center">${element.productName }</td>
					<td id="marketPrice" ondblclick="edit(this)" align="center">${element.marketPrice }</td>
					<td id="shopPrice" ondblclick="edit(this)" align="center">${element.shopPrice }</td>
					<td id="productDate" ondblclick="edit(this)" align="center">${element.productDate }</td>
					<td id="productDescription" ondblclick="edit(this)" align="center">
						${element.productDescription }</td>
					<td width="8%" align="center"><a
						href="${pageContext.request.contextPath }/getProductByIdServlet?productId=${element.productId }">修改</a>
						｜ <a href="javascript:void(0)"
						onclick="deleteProduct('${element.productId }')">删除</a></td>
		</tr>
		</c:forEach>
		<%-- 
		<tr>
				<td align="left"><select name="pageSize" id="pageSize">
						<option id="pageSize1" name="pageSize1" value="5">5</option>
						<option id="pageSize2" name="pageSize2" value="10">10</option>
						<option id="pageSize3" name="pageSize3" value="20">20</option>
				</select></td>
				<td colspan="7" align="right"><c:if test="${pageBean.currentPage ==1}">
		[首页]
		[上一页]
		</c:if> <c:if test="${pageBean.currentPage !=1}">
						<a
							href="${pageContext.request.contextPath }/showProductsByPage?currentPage=1">[首页]</a>
						<a
							href="${pageContext.request.contextPath }/showProductsByPage?currentPage=${pageBean.currentPage-1}">[上一页]</a>
					</c:if> 第 <input type="text" id="currentPage" name="currentPage"
					align="center" value="${pageBean.currentPage}" size="1"
					onblur="goToPage(this)"> 页 <c:if
						test="${pageBean.currentPage ==pageBean.totalPageCount}">
		[下一页]
		[尾页] 
		</c:if> <c:if test="${pageBean.currentPage !=pageBean.totalPageCount}">
						<a
							href="${pageContext.request.contextPath }/showProductsByPage?currentPage=${pageBean.currentPage+1}">[下一页]</a>
						<a
							href="${pageContext.request.contextPath }/showProductsByPage?currentPage=${pageBean.totalPageCount}">[尾页]</a>
					</c:if> <c:if test="${!('test' eq 'test1')}">
		第${pageBean.currentPage}页/共${pageBean.totalPageCount}页
		</c:if></td>
			</tr>
			 --%>
		<tr>
			<td align="left" colspan="3">显示记录数：
			<select name="pageSize"
				id="pageSize" onchange="changePageSize()">
					<c:if test="${pageBean.pageSize ==5}">
						<option id="pageSize1" name="pageSize1" value="5"
							selected="selected">5</option>
					</c:if>
					<c:if test="${pageBean.pageSize !=5}">
						<option id="pageSize1" name="pageSize1" value="5">5</option>
					</c:if>
					<c:if test="${pageBean.pageSize ==10}">
						<option id="pageSize1" name="pageSize1" value="10"
							selected="selected">10</option>
					</c:if>
					<c:if test="${pageBean.pageSize !=10}">
						<option id="pageSize1" name="pageSize1" value="10">10</option>
					</c:if>
					<c:if test="${pageBean.pageSize ==20}">
						<option id="pageSize1" name="pageSize1" value="20"
							selected="selected">20</option>
					</c:if>
					<c:if test="${pageBean.pageSize !=20}">
						<option id="pageSize1" name="pageSize1" value="20">20</option>
					</c:if>
			</select></td>
			<td colspan="6" align="right"><c:if
					test="${pageBean.currentPage <=1}">
		[首页]
		[上一页]
		</c:if> <c:if test="${pageBean.currentPage>1}">
					<a href="javascript:void(0)" onclick="showProductsByPage(1)">[首页]</a>
					<a href="javascript:void(0)"
						onclick="showProductsByPage(${pageBean.currentPage-1})">[上一页]</a>
				</c:if> 
				第 
				<select name="currentPage" id="currentPage"
				onchange="goToPage(this)">
					<c:forEach items="${pageNumberList}" var="pageI">
						<c:if test="${pageI==pageBean.currentPage}">
							<option id="pageI" name="${pageI}" value="${pageI}"
								selected="selected">${pageI}</option>
						</c:if>
						<c:if test="${pageI!=pageBean.currentPage}">
							<option id="pageI" name="${pageI}" value="${pageI}">${pageI}</option>
						</c:if>
					</c:forEach>
			</select> 页
			<%--  <c:if test="${ pageBean.currentPage==pageBean.totalPageCount}">
					<c:forEach begin="${pageBean.totalPageCount-2}"
						end="${pageBean.totalPageCount }" var="n">
						<c:if test="${pageBean.currentPage!=n}">
							<a href="javascript:void(0)" onclick="showProductsByPage(${n})">${n}</a>
						</c:if>
						<c:if test="${pageBean.currentPage==n}">
								${n}
							</c:if>
					</c:forEach>
				</c:if>  --%>
				
				<c:if test="${ pageBean.currentPage==pageBean.totalPageCount-1}">
					<c:forEach begin="${pageBean.currentPage-1}"
						end="${pageBean.currentPage+1 }" var="n">
						<c:if test="${pageBean.currentPage!=n}">
							<a href="javascript:void(0)" onclick="showProductsByPage(${n})">${n}</a>
						</c:if>
						<c:if test="${pageBean.currentPage==n}">
								${n}
							</c:if>
					</c:forEach>
				</c:if> <c:if
					test="${(pageBean.totalPageCount>2 && pageBean.currentPage+2<=pageBean.totalPageCount)}">

					<c:if test="${ pageBean.currentPage==1}">
						<c:forEach begin="1" end="3" var="n">
							<c:if test="${pageBean.currentPage!=n}">
								<a href="javascript:void(0)" onclick="showProductsByPage(${n})">${n}</a>
							</c:if>
							<c:if test="${pageBean.currentPage==n}">
						${n}
						</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${ pageBean.currentPage>1}">
						<c:forEach begin="${pageBean.currentPage-1}"
							end="${pageBean.currentPage+1}" var="n">
							<c:if test="${pageBean.currentPage!=n}">
								<a href="javascript:void(0)" onclick="showProductsByPage(${n})">${n}</a>
							</c:if>
							<c:if test="${pageBean.currentPage==n}">
						${n}
						</c:if>
						</c:forEach>
					</c:if>
				</c:if> <c:if test="!${pageBean.totalPageCount>3}">
					<c:forEach begin="1" end="${pageBean.totalPageCount}" var="n">
						<c:if test="${pageBean.currentPage!=n}">
							<a href="javascript:void(0)" onclick="showProductsByPage(${n})">${n}</a>
						</c:if>
						<c:if test="${pageBean.currentPage==n}">
						${n}
						</c:if>
					</c:forEach>
				</c:if> <c:if test="${pageBean.currentPage >=pageBean.totalPageCount}">
		[下一页]
		[尾页] 
		</c:if> <c:if test="${pageBean.currentPage <pageBean.totalPageCount}">
					<a href="javascript:void(0)"
						onclick="showProductsByPage(${pageBean.currentPage+1})">[下一页]</a>
					<a href="javascript:void(0)"
						onclick="showProductsByPage(${pageBean.totalPageCount})">[尾页]</a>
				</c:if> <c:if test="${!('test' eq 'test1')}">
		第${pageBean.currentPage}页/共${pageBean.totalPageCount}页，共${pageBean.totalCount}条记录
		</c:if></td>
		</tr>
		</FORM>
	</table>
	<center>
		<table>

		</table>
	</center>
</body>
<script type="text/javascript">

	//以分页形式显示数据
	function changePageSize() {
		//var oldPageSize=$("#pageSize").val();
		//var oldCurrentPage=$("#currentPage").val();

		//发送请求 
		location.href = "/Day29/changePageSize?pageSize=" + $("#pageSize").val() + "&currentPage=" + $("#currentPage").val();
	}
	//以分页形式显示数据
	function showProductsByPage(obj) {
		//alert("obj:"+obj)
		//发送请求 
		location.href = "/Day29/showProductsByPage?pageSize=" + $("#pageSize").val() + "&currentPage=" + obj;
	}

	//删除商品
	function deleteProduct(obj) {
		//alert($("#currentPage").val()); 
		if (confirm("是否确定删除")) {
			//发送请求
			location.href = "/Day29/deleteProductByIdPage?productId=" + obj + "&currentPage=" + ($("#currentPage").val()) + "&pageSize=" + $("#pageSize").val();

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
	function goToPage(obj) {
		//alert(obj.value);
		//发送请求
		location.href = "/Day29/showProductsByPage?currentPage=" + obj.value + "&pageSize=" + $("#pageSize").val();
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
