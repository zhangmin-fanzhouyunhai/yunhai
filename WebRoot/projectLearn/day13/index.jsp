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

<title>My JSP 'index.jsp' starting page</title>

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

	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0 align="center">
		<TBODY>
			<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
				<TR>
					<TD class=manageHead>当前位置： <a
						href="${pageContext.request.contextPath }/html/webBasicLearn.html">项目学习</a>
						&gt; day13
					</TD>
				</TR>
				<TR>
					<TD height=2></TD>
				</TR>
			</TABLE>
			<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%"
				align=center border=0>
				<TBODY>
					<TR>
						<TD>
							<TABLE id=grid
								style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
								cellSpacing=1 cellPadding=2 rules=all border=0 align="center">
								<TBODY>
									<TR align="center"
										style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
										<TD><a
											href="${pageContext.request.contextPath }/projectLearn/day13/form.jsp">
												javabean在model下的使用</a></TD>
										<TD><a
											href="${pageContext.request.contextPath }/projectLearn/day13/account.jsp">
												账号管理</a></TD>
									</TR>
									<TR align="center"
										style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">

										<TD></TD>
										<TD></TD>
									</tr>

								</TBODY>
							</TABLE>
						</TD>
					</TR>
			</TABLE>
		</TBODY>
	</TABLE>
</body>
</html>
