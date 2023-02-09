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

<title>数据导入</title>

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

$(function(){
$("#sButton3").click(function(){  
		$("#sButton3").attr('disabled',true);  
	var versionValue=$("#versionValue").val();
	alert("versionValue"+versionValue);
	var calYear=$("#calYear").val();
	alert("calYear"+calYear);
	var action="/Day29/spareEquipmentImportServlet2";
	action+="?versionValue='"+versionValue+"'&calYear='"+calYear+"'&pathStr="+pathStr+"'";
	
	alert("action="+action);
	$("#form3").attr("action",action); 
	$("#form3").submit();
	}); 
});
 </script>
</head>

<body>
	当前位置：excel导入&gt;原始数据导入
	<br>
	<center>
		<big> 原始数据导入</big>
	</center>
	<hr>
		<!-- action="/Day29/spareEquipmentImportServlet2" -->
	<form id="form3" method="post" name="form3"
		enctype="multipart/form-data">
		<table class="table table-striped" width="50%">
			<thead>
				<tr align="center">
					<td>数据模块</td>
					<td>数据版本</td>
					<td>日历年（导入年份）</td>
					<td>导入文件（CSV文件)</td>
					<td>操作</td>
					<td>&nbsp&nbsp</td>
				</tr>

			</thead>
			<tbody>
				<tr align="center">
					<td>备品备件（spareEquipmentImportServlet） <input type="hidden"
						value="spareEquipmentImportServlet" class="ac">
					</td>
					<td><input type="text" class="textbox" id="versionValue"
						style="WIDTH: 180px" maxLength="50" name="versionValue"></td>
					<td><input type="text" class="textbox" id="calYear"
						style="WIDTH: 180px" maxLength="50" name="calYear"></td>
					<td><input type="file" class="textbox" id="pathStr"
						style="WIDTH: 180px" maxLength="50" name="pathStr">
					</td>
					<td><a></a> <input class="button" id="sButton3" type="submit"
						value="保存 " name="sButton3"></td>
					</td>
					<td>&nbsp;&nbsp;</td>
				</tr>
			</tbody>
		</table>

	</form>
</body>
</html>
