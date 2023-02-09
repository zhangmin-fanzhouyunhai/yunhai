<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<%-- 前位置：
	<A class=style2
		href="${pageContext.request.contextPath}/jsp/otherFunctionList.jsp"
		target=main>其它功能</A> &gt;pdf文件上传
	<br>
	<center>
		<big> pdf文件上传合并</big>
	</center>
	<hr> --%>
	<FORM id="pdfFileUploadForm" name="pdfFileUploadForm"
		action="${pageContext.request.contextPath }/multiplePdfFileUpdateServlet"
		method=post enctype="multipart/form-data">

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%"
						background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg"
						border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR class=manageHead>
								<TD align="left">当前位置：<A class=style2
									href="${pageContext.request.contextPath}/jsp/otherFunctionList.jsp"
									target=main>其它功能</A> &gt;pdf文件上传
								</TD>
								<TD align="right"><A class=style2
									href="${pageContext.request.contextPath}/jsp/otherFunction.html"
									target=_blank>其它功能(新页面)</A></TD>
								<!-- <TD align="right">返回首页： <A class=style2
									href="/Day29/index.html" target=_blank>新页面</A> <A class=style2
									href="/Day29/index.html" target=_parent>本页面</A></TD> -->
							</TR>
							<TR>
								<TD height=2></TD>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR height=40>
								<TD></TD>
							</TR>
							<TR height=40>
								<TD></TD>
							</TR>
						</TABLE>

						<table class="table table-striped" width="50%" align="center">
							<tbody>
								<tr align="center">
									<td><INPUT type="file" class=textbox id=sChannel2
										style="WIDTH: 180px" maxLength=50 name="pathStr"
										multiple="multiple"></td>
									<td><a></a> <INPUT class=button id=sButton2 type=submit
										value="上传 " name=sButton2></td>
									</td>
								</tr>
							</tbody>
						</table>
					</TD>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0 height="420">
			<TR height="420">
				<TD width=15
					background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
					src="${pageContext.request.contextPath }/images/new_022.jpg"
					border=0></TD>
				<TD></TD>
				<TD width=15
					background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
					src="${pageContext.request.contextPath }/images/new_023.jpg"
					border=0></TD>
			</TR>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg"
						height=15></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>

</body>
</html>
