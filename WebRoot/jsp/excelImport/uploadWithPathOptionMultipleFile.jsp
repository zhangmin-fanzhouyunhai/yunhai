<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>数据文件上传</title>

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
</head>

<body>
	当前位置：
	<a class=style2
		href="${pageContext.request.contextPath}/jsp/otherFunctionList.jsp"
		target=main>其它功能</a>&gt;原始数据导入
	<br>
	<center>
		<big> 上传文件</big>
	</center>
	<hr>
	<FORM id="uploadWithPathForm" name="uploadWithPathForm" method="post"
		action="/Day29/multiFileUploadWithSavePathServlet"
		enctype="multipart/form-data">
		<table class="table table-striped" width="80%" align="center">
			<tbody>
				<tr align="center">
					<td>存放路径：</td>
					<td><select name="savePath" id="savePath">
							<c:forEach items="${pathList }" var="ele">
								<option value="${ele.storagePathValue}">${ele.storagePathName}</option>
							</c:forEach>
					</select></td>
					<td>上传文件：</td>
					<td><INPUT type="file" class=textbox id=sChannel2
						style="WIDTH: 180px" maxLength=50 name="pathStr"
						multiple="multiple"></td>
					<td><INPUT class=button id=sButton2 type=submit value="上传 "
						name=sButton2></td>
					</td>
				</tr>
			</tbody>
		</table>
	</FORM>
</body>
</html>
