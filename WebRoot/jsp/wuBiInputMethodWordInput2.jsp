<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加五笔词组</TITLE>
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
				//alert("words length="+words.length)
				//alert("words length="+words)
				var word1 = $("#word1").val();
				var word2 = $("#word2").val();
				var word3 = $("#word3").val();
				var word4 = $("#word4").val();
				var word5 = $("#word5").val();
				var word6 = $("#word6").val();
				var word7 = $("#word7").val();
				var word8 = $("#word8").val();
				if (words.length == 0) {
					history.go(0);
				} else {
					jQuery.ajax({
						type : 'POST',
						dataType : 'json', //提交方式是json，也可以是html和text
						//dataType:'json' 的意思是URL返回值是以JSON的格式传过来的，然后在页面上解析时就要采取JSON格式来展示。 
						url : '/Day29/saveWords2', //提交到servlet中
						cache : false,
						traditional : true, //传数组进后台需要设置该属性1
						//data : JSON.stringify(words),
						//data : {"words" :words,},
						data : {
							words : words,
							word1 : word1,
							word2 : word2,
							word3 : word3,
							word4 : word4,
							word5 : word5,
							word6 : word6,
							word7 : word7,
							word8 : word8,
						},
						//contentType:"application/json:charset=utf-8",
						success : function(data, textStatus) {
							/* var jsonobj = eval(data) 
							$("#oldword1").text(jsonobj.oldWordMap.oldWord1);
							$("#oldword2").text(jsonobj.oldWordMap.oldWord2);
							$("#oldword3").text(jsonobj.oldWordMap.oldWord3);
							$("#oldword4").text(jsonobj.oldWordMap.oldWord4);
							$("#oldword5").text(jsonobj.oldWordMap.oldWord5);
							$("#oldword6").text(jsonobj.oldWordMap.oldWord6);
							$("#oldword7").text(jsonobj.oldWordMap.oldWord7);
							$("#oldword8").text(jsonobj.oldWordMap.oldWord8);

							//$("#form1").reset()//不可行
							$("#form1")[0].reset() //可行方案1
							//$("#resetButton").click(); //可行方案2 */
							//history.back(0)  
							history.go(0) 
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
					background="${pageContext.request.contextPath }
						/images/new_022.jpg"><IMG
					src="${pageContext.request.contextPath }/images/new_022.jpg"
					border=0></TD>
				<TD vAlign=top width="100%" bgColor=#ffffff>
					<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
						<TR class=manageHead>
							<TD>当前位置： <A class=style2
								href="${pageContext.request.contextPath}/jsp/otherFunctionList.jsp"
								target=main>其它功能</A> &gt; 添加五笔词组
							</TD>
							<TD align="right"><A class=style2
								href="${pageContext.request.contextPath}/jsp/otherFunction.html"
								target=_blank>其它功能(新页面)</A></TD>
						</TR>
						<TR>
							<TD height=2></TD>
						</TR>
					</TABLE>
					<FORM id="form1" name="form1">
						<TABLE cellSpacing=0 cellPadding=5 border=0 align="center">
			<TR align="center">
				<td>序号</td>
				<td>新输入词组</td>
				<td>上次输入词组</td>
			</TR>
			<TR>
				<td>1</td>
				<td><INPUT class=textbox id="word1" style="WIDTH: 180px"
					maxLength=50 name="word" border="0"></td>
				<td id="oldword1">
					<!-- <label id="oldword1"></label> --> <%-- <c:if test="${oldWord1 !=null}">${oldWord1}</c:if> --%>
				</td>
			</TR>

			<TR>

				<td>2</td>
				<td><INPUT class=textbox id="word2" style="WIDTH: 180px"
					maxLength=50 name="word" border="0"></td>
				<td id="oldword2">
					<!-- <label id="oldword2"></label> --> <%-- <c:if test="${oldWord2 !=null}">${oldWord2}</c:if> --%>
				</td>
			</TR>

			<TR>
				<td>3</td>
				<td><INPUT class=textbox id="word3" style="WIDTH: 180px"
					maxLength=50 name="word" border="0"></td>
				<td id="oldword3">
					<!-- <label id="oldword3"></label> --> <%-- <c:if test="${oldWord3 !=null}">${oldWord3}</c:if> --%>
				</td>
			</TR>

			<TR>
				<td>4</td>
				<td><INPUT class=textbox id="word4" style="WIDTH: 180px"
					maxLength=50 name="word"></td>
				<td id="oldword4">
					<!-- <label id="oldword4"></label> --> <!-- <p id="oldword4"></p> -->
					<%-- <c:if test="${oldWord4 !=null}">${oldWord4}</c:if> --%>
				</td>
			</TR>
			<TR>
				<td>5</td>
				<td><INPUT class=textbox id="word5" style="WIDTH: 180px"
					maxLength=50 name="word"></td>
				<td id="oldword5">
					<!-- <label id="oldword5"></label> --> <!-- <p id="oldword5"></p> -->
					<%-- <c:if test="${oldWord5 !=null}">${oldWord5}</c:if> --%>
				</td>
			</TR>
			<TR>
				<td>6</td>
				<td><INPUT class=textbox id="word6" style="WIDTH: 180px"
					maxLength=50 name="word"></td>
				<td id="oldword6">
					<!-- <label id="oldword6"></label> --> <!-- <p id="oldword6"></p> -->
					<%-- <c:if test="${oldWord6 !=null}">${oldWord6}</c:if> --%>
				</td>
			</TR>
			<TR>
				<td>7</td>
				<td><INPUT class=textbox id="word7" style="WIDTH: 180px"
					maxLength=50 name="word"></td>
				<td id="oldword7">
					<!-- <label id="oldword7"></label> --> <!-- <p id="oldword7"></p> -->
					<%-- <c:if test="${oldWord7 !=null}">${oldWord7}</c:if> --%>
				</td>
			</TR>
			<TR>
				<td>8</td>
				<td><INPUT class=textbox id="word8" style="WIDTH: 180px"
					maxLength=50 name="word"></td>
				<td id="oldword8">
					<!-- <label id="oldword8"></label> --> <!-- <p id="oldword8"></p> -->
					<%-- <c:if test="${oldWord8 !=null}">${oldWord8}</c:if> --%>
				</td>
			</TR>
			<tr align="center">
				<td colspan="3"><input class=button id="wordSave" type="button"
					value="保存 " name="wordSave"> <input class=button
					id="resetButton" type="reset" value="重置 " name="resetButton"></td>
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
		<TD vAlign=top width="100%" bgColor=#ffffff align="center"><b>最新插入的词组</b></TD>
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
					<TD><b>序号</b></TD>
					<TD><b>五笔词组</b></TD>
					<TD><b>创建时间</b></TD>
				</TR>
				<c:forEach items="${wordList }" var="word" varStatus="status">
					<TR>
						<TD align="center">${status.index+1 }</TD>
						<TD>${word.wordChineseValue}</TD>
						<TD align="center">${word.createDate}</TD>
					</TR>
				</c:forEach>
			</TABLE>
			<TABLE id="oldInputTenWordTable"></TABLE>
		</TD>
		<TD width=15
			background="${pageContext.request.contextPath }/images/new_023.jpg">
			<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
			border=0>
		</TD>
	</TR>
	</TBODY>
	</TABLE>
	<%-- 		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
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
		</TABLE> --%>

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
