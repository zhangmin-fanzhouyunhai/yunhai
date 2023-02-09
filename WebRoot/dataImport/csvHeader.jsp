<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>csv表头</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath }/css/bootstrap4.6.0/bootstrap.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap4.6.0/bootstrap.min.js"></script>
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
		/**
		 * 为 上移 、下移 按钮绑定点击事件
		 */
		$("body").on("click", ".moveUpOrDown", function() { 
			var text = $(this).text();
			/* alert("name="+$(this).attr("name")+",value="+$(this).attr("value")); */
			if (text == "上移") { 
			//alert($.trim($(this)c.parent().find("td").eq(2).text()));
				var prevTr = $(this).parent().parent().prevAll();
				/**如果当前行不是第一行，则上移它*/
				if (prevTr.length > 0) {
					//$(this).parent().parent().find("td").eq(2).html((parseInt(($(this).parent().parent().find("td").eq(2).text())-1))); 
					var preTemp = prevTr.first();//当前行的前一行
					var thisHr = $(this).parent().parent();//当前行
					/* alert($.trim(thisHr.find("td").eq(2).text()));
					alert($.trim(preTemp.find("td").eq(2).text())); */
					var thisIndexof=parseInt(thisHr.find("td").eq(2).text())-1;
					var preTempIndexof=parseInt(preTemp.find("td").eq(2).text())+1;
					preTemp.find("td").eq(2).html(preTempIndexof);
					thisHr.find("td").eq(2).html(thisIndexof);
					//thisHr.html();
					/**将上一行与本行交互内容，replaceWith 方法内容为 html 内容
					 * 可参考文档：http://www.w3school.com.cn/jquery/manipulation_replacewith.asp*/
					thisHr.replaceWith("<tr>" + preTemp.html() + "</tr>");
					preTemp.replaceWith("<tr>" + thisHr.html() + "</tr>");
				}
			} else if (text == "下移") {  
				var nextTr = $(this).parent().parent().next();
				if (nextTr.length > 0) {
					var thisHr = $(this).parent().parent();
					/* alert($.trim(thisHr.find("td").eq(2).text()));
					alert($.trim(nextTr.find("td").eq(2).text())); //获取当前所在行的第3列表格中的文本，可以通过parseInt将其转换成整形，
					转换成浮点型的方法是parseFloat(Str).
					*/
					var thisIndexof=parseInt(thisHr.find("td").eq(2).text())+1; 
					var nextTrIndexof=parseInt(nextTr.find("td").eq(2).text())-1;
					nextTr.find("td").eq(2).html(nextTrIndexof);
					thisHr.find("td").eq(2).html(thisIndexof);
					/**将本行与下一行交互内容，replaceWith 方法内容为 html 内容 */
					thisHr.replaceWith("<tr>" + nextTr.html() + "</tr>");
					nextTr.replaceWith("<tr>" + thisHr.html() + "</tr>");
				}
			}
		});
	});


	function edit(element) {
		var oldhtml = $.trim(element.innerHTML); //获得元素之前的内容
		var newobj = document.createElement('input'); //创建一个input元素
		newobj.type = 'text'; //为newobj元素添加类型
		newobj.value = oldhtml;
		element.innerHTML = ''; //设置元素内容为空
		element.appendChild(newobj); //添加子元素
		newobj.focus(); //获得焦点
		//设置newobj失去焦点的事件
		newobj.onblur = function() {
			//下面应该判断是否做了修改并使用ajax代码请求服务端将id与修改后的数据提交
			//alert(element.id);
			//当触发时判断newobj的值是否为空，为空则不修改，并返回oldhtml
			element.innerHTML = $.trim(this.value) ? $.trim(this.value) :$.trim(oldhtml);
		}
	}
</script>
</head>

<body>
	<A href="/Day29/html/webBasicLearn.html" target=main>返回</A>
	<center>
		<big> 表格中记录的上下移动处理</big>
	</center>
	<hr>

	<table class="table table-striped">
		<thead>
			<tr align="center">
				<td>表头名</td>
				<td>表头取值</td>
				<td>序号</td>
				<td>操作</td>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${CsvHeaderList }" var="csvHeaderNameItem">
				<tr align="center">
					<td id="csvHeaderName" ondblclick="edit(this)">${csvHeaderNameItem.csvHeaderName }
					</td>
					<td id="csvHeaderValue" ondblclick="edit(this)">${csvHeaderNameItem.csvHeaderValue }
					</td>
					<td id="indexof" ondblclick="edit(this)">${csvHeaderNameItem.indexOf }
					</td>
					<td>
						<%-- <a
				href="${pageContext.request.contextPath }/indexOfSaveServlet?indexof=${customer.indexOf}&newIndexOf=${customer.indexOf+1}" class="moveUpOrDown">上移</a>
					&nbsp;&nbsp;
				<a
				href="${pageContext.request.contextPath }/indexOfSaveServlet?custId=${customer.indexOf}&newIndexOf=${customer.indexOf-1}"class="moveUpOrDown">下移</a>
				 --%> 
				<%-- <a
				href="" class="moveUpOrDown" name="${csvHeaderNameItem.indexOf }" value="${csvHeaderNameItem.indexOf }">上移</a>
				  | 
				<a
				href="" class="moveUpOrDown" name="${csvHeaderNameItem.indexOf }" value="${csvHeaderNameItem.indexOf }">下移</a>
				 --%> 
				  <span class="moveUpOrDown" >上移</span>
				  | 
				<span class="moveUpOrDown">下移</span>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
