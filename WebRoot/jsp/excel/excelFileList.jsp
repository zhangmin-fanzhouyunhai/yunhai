﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>上传pdf文件清单</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
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
<SCRIPT language=javascript>
	$(function() {
		$("body").on("click", ".moveUpOrDown", function() {
			recordUpOrDownMove(this);
		});
	});
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM
		id="pdfFileMerge" name="pdfFileMerge"
		action="${pageContext.request.contextPath }/pdfFileMerge" method=post>



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
								<TD>当前位置：<A class=style2
									href="${pageContext.request.contextPath}/jsp/otherFunctionList.jsp"
									target=main>其它功能</A> &gt; Excel文件清单
								</TD>
								<TD align="right"><A class=style2
									href="${pageContext.request.contextPath}/jsp/otherFunction.html"
									target=_blank>其它功能(新页面)</A></TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">

												</TR>
												<TR align="center"
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD><input type="checkbox" id="checkAll"
														name="checkAll" onclick="checkAll1(this)"></TD>
													<TD>序号</TD>
													<TD>文件名称</TD>
													<TD>调整顺序</TD>
												</TR>
												<c:forEach items="${fileList }" var="file"
													varStatus="status">
													<TR align="center"
														style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
														<TD><input type="checkbox" id="item" name="item"
															value="${file.excelFileId}" /></TD>
														<TD><input type="text" id="sortIndex"
															name="sortIndex" align="center"
															value="${status.index+1 }" size="1" /></TD>
														<TD> <A
															class=style2
href="${pageContext.request.contextPath}/sheetListServlet?owner=admin&fileName=${file.excelFileName}">${file.excelFileName}</A>
														</TD>
														<TD><span class="moveUpOrDown">上移</span> | <span
															class="moveUpOrDown">下移</span>|
<a id="downLoadFile" href="${pageContext.request.contextPath}/downLoadFile?path=${file.storyPath}&fileName=${file.excelFileName}" target="_blank">下载单个文件</a> | 
<a id="downLoadFileAndZip" href="${pageContext.request.contextPath}/downLoadFileAndZip?path=${file.storyPath}&fileName=${file.excelFileName}" target="_blank">文件打包下载</a>
															</TD>
													</TR>
												</c:forEach>
											</TBODY>
										</TABLE>

									</TD>
								</TR>

								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${total}</B>]条记录,[<B>${totalPage}</B>]页 ,每页显示 <select
													name="pageSize">

													<option value="1"
														<c:if test="${pageSize==1 }">selected</c:if>>1</option>
													<option value="30"
														<c:if test="${pageSize==30 }">selected</c:if>>30</option>
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
						src="${pageContext.request.contextPath }/images/new_023.jpg"
						border=0></TD>
				</TR>
			</TBODY>
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
</BODY>
<script type="text/javascript">

	//全选或全不选
	function checkAll1(obj) {
		//获取jQuery对象变量，对象变量通过prop("属性","属性值")来完成变量的属性赋值，
		//通过prop("属性")读取属性的值
		//alert("Get in!");

		checkAll = $("#checkAll");

		//获取所有的复选框
		var itemArr = document.getElementsByName("item");
		//alert(itemArr.length);
		//遍历数组 修改选中的状态
		if (itemArr.length != 0) {
			for (var i = 0; i < itemArr.length; i++) {
				itemArr[i].checked = obj.checked;
			}
		}

	}
</script>
</HTML>
