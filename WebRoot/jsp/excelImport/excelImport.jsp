<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>Learning</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
<script type="text/javascript" src="../../js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		//隐藏b1div
		$("#sButton2").click(function() {
			//将按钮设置成不可操作
			$("#sButton2").attr('disabled', true);
			//注意一定要有如下操作，form表单的action才能执行，并不是默认的就自动执行。
			$("#form1").submit();
		});
	})
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<%-- <FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/customerServlet?method=list"
		method=post> --%>
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
				<TD width=15 background=${pageContext.request.contextPath }
					/images/new_022.jpg><IMG
					src="${pageContext.request.contextPath }/images/new_022.jpg"
					border=0></TD>
				<TD vAlign=top width="100%" bgColor=#ffffff>
					<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
						<TR>
							<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
						</TR>
						<TR>
							<TD height=2></TD>
						</TR>
					</TABLE>
					<FORM id="customerForm" name="customerForm"
						action="${pageContext.request.contextPath }/listCustomer"
						method=post>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="custName"></TD>

													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>

								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>联系人</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
				<TD id="custName" ondblclick="edit(this)">数据类型
				</TD>
				<TD id="custLevel" ondblclick="edit(this)">导入文件
				</TD>
				<TD id="custSource" ondblclick="edit(this)">导入物理表
				</TD>
				<TD id="custLinkman" ondblclick="edit(this)">导入物理表
				</TD>
				<TD id="custPhone" ondblclick="edit(this)">导入物理表
				</TD>
				<TD id="custMobile" ondblclick="edit(this)">导入物理表
				</TD>
				<TD><a
					href="${pageContext.request.contextPath }/customerServlet?method=edit&custId=${customer.custId}">修改</a>
					&nbsp;&nbsp; <a
					href="${pageContext.request.contextPath }/customerServlet?method=delete&custId=${customer.custId}">删除</a>
				</TD>
			</TR>


			<%-- <c:forEach items="${list }" var="customer">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													
													<TD id="custName" ondblclick="edit(this)">${customer.custName } </TD>
													<TD id="custLevel" ondblclick="edit(this)">${customer.custLevel } </TD>
													<TD id="custSource" ondblclick="edit(this)">${customer.custSource } </TD>
													<TD id="custLinkman" ondblclick="edit(this)">${customer.custLinkman } </TD>
													<TD id="custPhone" ondblclick="edit(this)">${customer.custPhone } </TD>
													<TD id="custMobile" ondblclick="edit(this)">${customer.custMobile } </TD>
													<TD>
													<a href="${pageContext.request.contextPath }/customerServlet?method=edit&custId=${customer.custId}">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/customerServlet?method=delete&custId=${customer.custId}">删除</a>
													</TD>
												</TR>
												</c:forEach>--%>
		</TBODY>
	</TABLE>
	</TD>
	</TR>

	<TR>
		<TD><SPAN id=pagelink>
				<DIV style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
					共[<B>${total}</B>]条记录,[<B>${totalPage}</B>]页 ,每页显示 <select
						name="pageSize">

						<option value="15" <c:if test="${pageSize==1 }">selected</c:if>>1</option>
						<option value="30" <c:if test="${pageSize==30 }">selected</c:if>>30</option>
					</select> 条 [<A href="javascript:to_page(${page-1})">前一页</A>] <B>${page}</B>
					[<A href="javascript:to_page(${page+1})">后一页</A>] 到 <input
						type="text" size="3" id="page" name="page" /> 页 <input
						type="button" value="Go" onclick="to_page()" />
				</DIV>
		</SPAN></TD>
	</TR>
	</TBODY>
	</TABLE>
	</TD>
	<TD width=15
		background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
		src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
	</TR>
	</TBODY>
	</TABLE>
	</FORM>
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

	<script type="text/javascript">
	
	</script>
</BODY>
</HTML>
