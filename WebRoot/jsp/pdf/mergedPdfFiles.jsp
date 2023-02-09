<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		$("#downLoadFile1").click(
			function() {
				var fileName = $("#fileName").val();
				var path = $("#path").val();
				alert("path="+path + ",fileName="+fileName);
				jQuery.ajax({
					type : 'GET',
					dataType : 'json', //提交方式是json，也可以是html和text
					//dataType:'json' 的意思是URL返回值是以JSON的格式传过来的，然后在页面上解析时就要采取JSON格式来展示。 
					url : 'downLoadFile1', //提交到servlet中
					cache : false,
					data : {
						fileName : fileName,
						path : path,
					},
					success : function(data) {
						//  请求成功时处理
						//alert(data[0].userName); //用这种写法能取出后台传回来的json对象的属性

						//下载成功后，提示下载成功，1.5秒后消失
						alert('Successful!');
						/* $.messager.showBySite({
							title : 'pdf下载', //窗口标题
							msg : '下载成功', //窗口内容
							timeout : 1500, //1.5秒后消失
							showType : 'slide', //弹出的方式。类似ppt里面的图片弹出方式
							//弹出框的样式。居中显示
							style : {
								right : '',
								top : document.body.scrollTop + document.documentElement.scrollCenter,
								bottom : ''
							}
						}) */
					},
					error : function() {
						//alert("error,账户密码错误！");
						//$("#codeTextMsg").html("账户或密码错误！");
						//下载失败后，提示下载失败，1.5秒后消失
						$("#messager").html("Error XMLHttpRequest")
						/* $.messager.showBySite({
							title : 'pdf下载', //窗口标题
							msg : '下载失败', //窗口内容
							timeout : 1500, //1.5秒后消失
							showType : 'slide', //弹出的方式。类似ppt里面的图片弹出方式
							//弹出框的样式。居中显示
							style : {
								right : '',
								top : document.body.scrollTop + document.documentElement.scrollCenter,
								bottom : ''
							}
						}) */
					}
				});
			});
		$("#downLoadFileAndZip1").click(function() {
			var fileName = $("#fileName").val();
			var path = $("#path").val();

			jQuery.ajax({
				type : 'POST',
				dataType : 'json', //提交方式是json，也可以是html和text
				//dataType:'json' 的意思是URL返回值是以JSON的格式传过来的，然后在页面上解析时就要采取JSON格式来展示。 
				url : 'downLoadFileAndZip1', //提交到servlet中
				cache : false,
				data : {
					//checkCode : checkCode,
					fileName : fileName,
					path : path,
				},
				success : function(data, textStatus) {
					//  请求成功时处理 
					//alert(data.data);
					//下载成功后，提示下载成功，1.5秒后消失
					$.messager.showBySite({
						title : 'pdf下载', //窗口标题
						msg : '下载成功', //窗口内容
						timeout : 1500, //1.5秒后消失
						showType : 'slide', //弹出的方式。类似ppt里面的图片弹出方式
						//弹出框的样式。居中显示
						style : {
							right : '',
							top : document.body.scrollTop + document.documentElement.scrollCenter,
							bottom : ''
						}
					})
				},
				error : function() {
					//$("#codeTextMsg").html("验证码输入错误！");
					//下载失败后，提示下载失败，1.5秒后消失
					$.messager.showBySite({
						title : 'pdf下载', //窗口标题
						msg : '下载失败', //窗口内容
						timeout : 1500, //1.5秒后消失
						showType : 'slide', //弹出的方式。类似ppt里面的图片弹出方式
						//弹出框的样式。居中显示
						style : {
							right : '',
							top : document.body.scrollTop + document.documentElement.scrollCenter,
							bottom : ''
						}
					})
				}
			});
		});

	});
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
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
							<TD>当前位置：<A class=style2
								href="${pageContext.request.contextPath}/jsp/otherFunctionList.jsp"
								target=main>其它功能</A> &gt;<A class=style2
								href="${pageContext.request.contextPath }/jsp/pdf/uploadPdfFile.jsp"
								target=main>文件上传</A> &gt;合并后的pdf
							</TD>
								<TD align="right"><A class=style2
									href="${pageContext.request.contextPath}/jsp/otherFunction.html"
									target=_blank>其它功能(新页面)</A></TD>
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
										cellSpacing=1 cellPadding=2 rules=all border=0>
										<TBODY>
											<TR
												style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">

											</TR>
											<TR align="center"
												style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
												<!-- <TD><input type="checkbox" id="checkAll"
													name="checkAll" onclick="checkAll1(this)"></TD> -->
												<TD>序号</TD>
												<TD>文件名称</TD>
												<TD>路径</TD>
												<TD>下载</TD>
											</TR>
											<%-- <c:forEach items="${fileList }" var="file" varStatus="status"> --%>
											<TR align="center"
												style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
												<%-- <TD><input type="checkbox" id="item" name="item"
														value="${file.fileName}" /> <input type="hidden"
														name="path" id="path" value="${file.path}" /></TD> --%>
												<TD><input type="text" id="sortIndex" name="sortIndex"
													align="center" value="${status.index+1 }" size="1" /></TD>
												<TD><input type="hidden" name="fileName" id="fileName"
													value="${mergeFileName}" /> ${mergeFileName}</TD>
												<TD><input type="hidden" name="path" id="path"
													value="${path}" /> ${path}</TD>
												<TD>
<a id="downLoadFile" href="${pageContext.request.contextPath}/downLoadFile?path=${path}&fileName=${mergeFileName}" target="_blank">下载单个文件</a> | 
<a id="downLoadFileAndZip" href="${pageContext.request.contextPath}/downLoadFileAndZip?path=${path}&fileName=${mergeFileName}" target="_blank">文件打包下载</a></TD>
											</TR>
											<%-- </c:forEach> --%>
										</TBODY>
									</TABLE>

								</TD>
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
	<!-- 	</FORM> -->
	<div id="messager"></div>
</BODY>

</HTML>
