﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加英文单词</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

<script
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery.cookie.js"
	type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css"
	type="text/css" />

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript">
	$(function() {
		$("#wordSave").click(
			function() {
				var words = [];
				$(".textbox").each(function() {
					var value = $(this).val();
					if (value.trim().length != 0) {
						words.push($(this).val());
					}
				//alert("this word="+$(this).val());
				});
				var englishWordVal = $("#englishWordVal").val();
				var phoneticSymbol = $("#phoneticSymbol").val();
				var wordMeaning = $("#wordMeaning").val();
				var englishDetail = $("#englishDetail").val();
				if (words.length == 0) {
					history.go(0);
				} else {
					jQuery.ajax({
						type : 'POST',
						dataType : 'json', //提交方式是json，也可以是html和text
						//dataType:'json' 的意思是URL返回值是以JSON的格式传过来的，然后在页面上解析时就要采取JSON格式来展示。 
						url : '/Day29/englishWord', //提交到servlet中
						cache : false,
						traditional : true, //传数组进后台需要设置该属性1
						//data : JSON.stringify(words),
						//data : {"words" :words,},
						data : {
							englishWordVal : englishWordVal,
							phoneticSymbol : phoneticSymbol,
							wordMeaning : wordMeaning,
							englishDetail : englishDetail,
						},
						success : function(data, textStatus) {
							//  请求成功时处理 
							history.back(0)
						},
						error : function() {
							//alert("error,账户密码错误！");
							history.go(0) //
						}
					});
				}
			});

	});
	//这是一段获取项目路径的js方法

	//js获取项目根路径，如：http://localhost:8099/UniqueduHome 
	function getRootPath() {
		//获取当前网址，如： http://localhost:8099/UniqueduHome/view/error/notAuthorize.jsp 
		var curWwwPath = window.document.location.href;
		//获取主机地址之后的目录，如： UniqueduHome/view/error/notAuthorize.jsp 
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		//获取主机地址，如： http://localhost:8099 
		var localhostPaht = curWwwPath.substring(0, pos);
		//获取带"/"的项目名，如：/UniqueduHome 
		var projectName = pathName.substring(0,
			pathName.substr(1).indexOf('/') + 1);
		return (localhostPaht + projectName);
	}
</script>

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
							<TD>当前位置： <A class=style2
								href="${pageContext.request.contextPath}/jsp/otherFunctionList.jsp"
								target=main>其它功能</A> &gt; 学习的单词
							</TD>
							<TD align="right"><A class=style2
								href="${pageContext.request.contextPath}/jsp/otherFunction.html"
								target=_blank>其它功能(新页面)</A></TD>
						</TR>
						<TR>
							<TD height=2></TD>
						</TR>
					</TABLE>
					<FORM id=form1 name=form1>
						<TABLE cellSpacing=0 cellPadding=5 border=0 align="center">
							<TR>
								<td>英文</td>
								<td><INPUT class=textbox id="englishWordVal"
									style="WIDTH: 180px" maxLength=500 name="englishWordVal"></td>
							</TR>
							<TR>
								<td>音标</td>
								<td><INPUT class=textbox id="phoneticSymbol"
									style="WIDTH: 180px" maxLength=100 name="phoneticSymbol"></td>
							</TR>
							<TR>
								<td>词意</td>
								<td><textarea class="textbox" id="wordMeaning"
										style="WIDTH: 180px" name="wordMeaning" rows="30" cols="100"></textarea></td>
							</TR>

							<TR>
								<td>备注</td>
								<td><textarea class="textbox" id="englishDetail"
										style="WIDTH: 180px" name="englishDetail" rows="30" cols="100"></textarea></td>
							</TR>
							<tr align="center">
								<td colspan="2"><input class=button id="wordSave"
									type="button" value="保存 " name="wordSave"> <input
									class=button id="wordSave" type="reset" value="重置 "
									name="wordSave"></td>
							</tr>
						</TABLE>
					</FORM>
				</TD>
				<TD width=15
					background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
					border=0>
				</TD>
			</TR>
			<TR>
				<TD width=15
					background="${pageContext.request.contextPath}/images/new_022.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_022.jpg"
					border=0>
				</TD>
				<TD vAlign=top width="100%" bgColor=#ffffff align="center"></TD>
				<TD width=15
					background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
					border=0>
				</TD>
			</TR>
			<TR>
				<TD width=15
					background="${pageContext.request.contextPath}/images/new_022.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_022.jpg"
					border=0>
				</TD>
				<TD vAlign=top width="100%" bgColor=#ffffff align="center"></TD>
				<TD width=15
					background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
					border=0>
				</TD>
			</TR>
			<TR>
				<TD width=15
					background="${pageContext.request.contextPath}/images/new_022.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_022.jpg"
					border=0>
				</TD>
				<TD vAlign=top width="100%" bgColor=#ffffff align="center"><b>最新插入单词</b></TD>
				<TD width=15
					background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
					border=0>
				</TD>
			</TR> 
			<TR>
				<TD width=15
					background="${pageContext.request.contextPath}/images/new_022.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_022.jpg"
					border=0>
				</TD>
				<TD vAlign=top width="100%" bgColor=#ffffff>
					<TABLE cellSpacing=0 cellPadding=5 width="98%" border=1>
						<TR align="center">
							<TD><b>英文单词</b></TD>
							<TD><b>音标</b></TD>
							<TD><b>词义</b></TD>
							<TD><b>备注</b></TD>
							<TD><b>创建时间</b></TD>
						</TR>
						<c:forEach items="${wordList }" var="word">
							<TR>
								<TD>${word.englishWord}</TD>
								<TD>${word.phoneticSymbol}</TD>
								<TD>${word.wordMeaning}</TD>
								<TD align="center">${word.englishDetail}</TD>
								<TD align="center">${word.createDate}</TD>
							</TR>
						</c:forEach>
					</TABLE>
				</TD>
				<TD width=15
					background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
					border=0>
				</TD>
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
</BODY>
</HTML>

