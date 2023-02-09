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

<title>My JSP 'account.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT language=javascript>
	function to_page(page) {
		if (page) {
			$("#page").val(page);
		}
		document.customerForm.submit();

	}


	function edit(element) {
		var oldhtml = element.innerHTML; //获得元素之前的内容
		var newobj = document.createElement('input'); //创建一个input元素
		newobj.type = 'text'; //为newobj元素添加类型
		newobj.value = oldhtml;
		element.innerHTML = ''; //设置元素内容为空
		element.appendChild(newobj); //添加子元素
		newobj.focus(); //获得焦点
		//设置newobj失去焦点的事件
		newobj.onblur = function() {
			//下面应该判断是否做了修改并使用ajax代码请求服务端将id与修改后的数据提交
			alert(element.id + "=" + element.value);
			//当触发时判断newobj的值是否为空，为空则不修改，并返回oldhtml
			element.innerHTML = this.value ? this.value : oldhtml;

		}
	}
</SCRIPT>
</head>

<body>

	<FORM id="accountServlet13" name="accountServlet"
		action="${pageContext.request.contextPath }/accountServlet13" method=post>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0 align="center">
			<TBODY>
				<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
					<TR>
						<TD class=manageHead>
						当前位置：
						<a href="${pageContext.request.contextPath }/html/webBasicLearn.html">项目学习</a>
						&gt; 
						<a href="${pageContext.request.contextPath }/projectLearn/day13/index.jsp">day13</a>
						&gt; 转账
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
											<TD>转出方</TD>
											<TD><input type="text" name="fromUser"></TD>
										</TR>
										<TR align="center"
											style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">

											<TD>转入方</TD>
											<TD><input type="text" name="toUser"></TD>
										</tr>
										<TR align="center"
											style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">

											<TD>转账金额</TD>
											<TD><input type="text" name="money"></TD>
										</tr>
										<TR align="center"
											style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">

											<TD><input type="submit" name="提交"></TD>
											<TD><input type="reset" name="重置"></TD>
										</tr>
									</TBODY>
								</TABLE>
							</TD>
						</TR>
				</TABLE>
			</TBODY>
		</TABLE>
	</FORM>
</body>
</html>
