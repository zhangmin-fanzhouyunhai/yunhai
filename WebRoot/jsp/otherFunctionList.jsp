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

<title>Learning</title>

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
	<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
		<TR class=manageHead>
			<TD align="left">当前位置： <A class=style2
				href="${pageContext.request.contextPath}/jsp/otherFunctionList.jsp"
				target=main>其它功能</A>
			</TD>
			<TD align="right">返回首页： <A class=style2 href="/Day29/index.html"
				target=_blank>新页面</A> <A class=style2 href="/Day29/index.html"
				target=_parent>本页面</A>
			</TD>
		</TR>
		<TR>
			<TD height=2></TD>
		</TR>
	</TABLE>
	<table align="center" width="50%">
		<tr align="center">
			<td style="vertical-align: top;">
				<!-- <A class=style2
				href="jsp/wuBiInputMethodWordInput2.jsp" target=main>五笔词组插入</A> -->
				<A class=style2
				href="${pageContext.request.contextPath}/wuBiInputInitial"
				target=main>五笔词组插入</A>
			</td>
			<td style="vertical-align: top;"> 
				<A class=style2
				href="${pageContext.request.contextPath}/wuBiInputInitialReshow"
				target=main>五笔词组插入（带回显版）</A>
			</td>
			<td style="vertical-align: top;"><A class=style2
				href="${pageContext.request.contextPath}/englishWordInputIntial"
				target=main>英文单词</A></td>
			<td style="vertical-align: top;"><A class=style2
				href="${pageContext.request.contextPath}/jsp/pdf/uploadPdfFile.jsp"
				target=main>PDF文件上传合并</A></td>
		</tr>
		<tr align="center">
			<td style="vertical-align: top;"><A class=style2
				href="/Day29/storagePathServlet?owner=admin" target=main>excel文件上传及数据分析</A></td>
			<td style="vertical-align: top;"><A class=style2
				href="/Day29/excelFileListServlet" target=main>excel文件清单</A></td>
			<td style="vertical-align: top;"><A class=style2
				href="/Day29/storagePathServlet?owner=admin" target=main>多个文件导入</A></td>
			<td style="vertical-align: top;"><A class=style2
				href="${pageContext.request.contextPath}/actorAddIntial"
				target=main>演员添加</A></td>
		</tr>
		<tr align="center">
			<td style="vertical-align: top;"><A class=style2
				href="/Day29/encylopediaThinkTankWebSiteList" target=main>MBA智库百科</A></td>
			<td style="vertical-align: top;"><A class=style2
				href="${pageContext.request.contextPath}/jsp/otherWebSite/encyclopediaThinkTankHtmlFileDownload.jsp" target=main>MBA智库百科下载</A></td>
			<td style="vertical-align: top;"><A class=style2
				href="/Day29/storagePathServlet?owner=admin" target=main>多个文件导入</A></td>
			<td style="vertical-align: top;"><A class=style2
				href="${pageContext.request.contextPath}/actorAddIntial"
				target=main>演员添加</A></td>
		</tr>
	</table>
</body>
</html>
