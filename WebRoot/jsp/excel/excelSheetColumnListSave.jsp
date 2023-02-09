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

.dataAnalysis {
	background-color: #5BC0DE;
	border-radius: 3px;
	cursor: pointer;
	color: #FFFFFF;
	padding: 2px;
	font-size: 12px;
}
</style>
<style type="text/css">
.saveDataType {
	background-color: #FFFFFF;
	border-radius: 3px;
	cursor: pointer;
	color: #000000;
	padding: 2px;
	font-size: 12px;
}

.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 80);
}

.white_content {
	display: none;
	position: absolute;
	top: 10%;
	left: 10%;
	width: 80%;
	height: 80%;
	border: 16pxsolidlightblue;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}

.white_content_small {
	display: none;
	position: absolute;
	top: 20%;
	left: 30%;
	width: 40%;
	height: 50%;
	border: 16pxsolidlightblue;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>
<SCRIPT language=javascript>
	$(function() {
		$("body").on("click", ".moveUpOrDown", function() {
			recordUpOrDownMove(this);
		});
		/* $("#columnAttributSave").click(
			function() {}
		); */
		$(".dataTypeOption").change(
			function() {
				//通过$(this).val()获取元素值
				var dataType = $(this).val()

				var parentEle = $(this).parent().parent()
				/**
				通过parent.parent.children及find找到input元素，并取出元素值
				*/
				var columnIdTd = parentEle.children('td').eq(0)
				var columnId = $(columnIdTd).find("input").val()
				//alert(columnId)
				/**
				通过parent.parent.children及find找到input元素，并取出元素值
				*/
				var sortIndexTd = parentEle.children('td').eq(1)
				var sortIndex = $(sortIndexTd).find("input").val();
				//alert(sortIndex)
				/**
				通过parent.parent.children及html取出元素
				*/
				var excelSheetColumnNameTd = parentEle.children('td').eq(2)
				var excelSheetColumnName = $(excelSheetColumnNameTd).html()
				//alert(excelSheetColumnName)
				/**
				通过parent.parent.children及find找到select元素，并取出元素值
				*/
				var dataTypeTd = parentEle.children('td').eq(3)
				var dataType1 = $(dataTypeTd).find("select").val()
				//alert("dataTypeOption")
				//alert(dataType1)
				jQuery.ajax({
					type : 'POST',
					dataType : 'json', //提交方式是json，也可以是html和text
					//dataType:'json' 的意思是URL返回值是以JSON的格式传过来的，然后在页面上解析时就要采取JSON格式来展示。 
					url : '/Day29/excelSheetColumnDataTypeCodeUpdate', //提交到servlet中
					cache : false,
					traditional : false, //传数组进后台需要设置该属性1 
					data : {
						excelSheetColumnId : columnId,
						dataType : dataType,
					},
					success : function(data, textStatus) {
						//alert("Update successfull..........."+data)
					},
					error : function() {
						//alert("Update failed...........")
					}
				});
			});

		$('#batchUpdateColDataTypeBtn').click(function() {
			var columnElementArr = $('.columnElement')
			var batchUpdateColDataType = $('#batchUpdateColDataTypeSelect')
			var batchUpdateColDataTypeVal = batchUpdateColDataType.val()
			//alert("batchUpdateColDataTypeVal="+batchUpdateColDataTypeVal);
			//alert(columnElementArr.html()) 
			//alert(columnElementArr.length)
			var columnIdArray = [];
			var columnNum = columnElementArr.length
			for (var i = 0; i < columnNum; i++) {
				var ele0 = columnElementArr.eq(i).find('td').eq(0);
				var checkBoxEle = $(ele0).find('input').val()
				var checkBoxEleStatus = $(ele0).find('input').prop('checked')
				if (checkBoxEleStatus == true) {
					columnIdArray.push(checkBoxEle); //

				}
			//alert(checkBoxEle + "," + checkBoxEleStatus)
			}
			//alert(columnIdArray.length)
			if (columnIdArray.length > 0) {
				//alert(columnIdArray + "," + columnIdArray.length)
				jQuery.ajax({
					type : 'POST',
					dataType : 'json', //提交方式是json，也可以是html和text
					//dataType:'json' 的意思是URL返回值是以JSON的格式传过来的，然后在页面上解析时就要采取JSON格式来展示。 
					url : '/Day29/batchUpdateColDataType', //提交到servlet中
					cache : false,
					traditional : true, //传数组进后台需要设置该属性1 
					data : {
						excelSheetColumnIdArray : columnIdArray,
						dataType : batchUpdateColDataTypeVal,
					},
					success : function(data, textStatus) {
						//alert("Update successfull..........."+data)
					},
					error : function() {
						//alert("Update failed...........")
					}
				});
			}
		});
		/**
		*点击后调用打开弹窗，进行对应数据列的取值分布进行数据分布分析
		*并在弹出窗口中进行数据展现
		*/
		$('.dataAnalysis').click(function() {
			var parentEle = $(this).parent().parent();
			var parentValue=parentEle.html();
			//alert(parentValue)
			jQuery.ajax({
				type : 'POST',
				dataType : 'json', //提交方式是json，也可以是html和text
				//dataType:'json' 的意思是URL返回值是以JSON的格式传过来的，然后在页面上解析时就要采取JSON格式来展示。 
				url : '/Day29/columnValueAnalysis', //提交到servlet中
				cache : false,
				traditional : false, //传数组进后台需要设置该属性1 
				data : {
					serverCode : '100000000',
					parentValue : parentValue,
				},
				success : function(data, textStatus) {
					//alert("data="+data['data']);
					//alert("data="+JSON.parse(data));
					//通过从后台获取数据，然后在弹出窗口中显示返回的数据信息。
					//alert("Update successfull..........."+data)
					//var parentEle = $(this).parent().parent();
					//alert(parentValue)
					document.getElementById("MyDiv").style.display = 'block';
					document.getElementById("fade").style.display = 'block';
					var myDiv = document.getElementById("MyDiv");
					/*var str = "";
					str += "<table><thead><TH>序号</TH><TH>列名称</TH><TH>数据类型</TH><TH>数据精度</TH>";
					str += "<TH>字段名称</TH><TH>调整顺序</TH></thead><tbody>"
					str += "<TR>" + parentEle.html();
					str += "</TR></tbody></table>";
					*/
					$(myDiv).html("");
					//$(myDiv).append(str);
					
					$(myDiv).append("<table><tr align=\"center\"><td>分析结果<td></tr><tr><td align=\"center\">");
					$(myDiv).append(data['data']);
					$(myDiv).append("</td></tr></table>")
					//myDiv.append(str)
					//myDiv.innerText="点击阴影处退出！！！";
					var bgdiv = document.getElementById("fade");
					//alert("bgdiv="+bgdiv);
					bgdiv.style.width = document.body.scrollWidth;
					$("#fade").height($(document).height());
				},
				error : function() {
					//alert("Update failed...........")
				}
			});
		});
		//关闭弹出层
		$("#fade").click(function() {
			document.getElementById("MyDiv").style.display = 'none';
			document.getElementById("fade").style.display = 'none';
		});
	});
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>

	<FORM id="columnAttributListForm" name="columnAttributListForm"
		method=post>
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
									href="${pageContext.request.contextPath }/storagePathServlet?owner=admin"
									target=main>文件上传</A> &gt;<A class=style2
									href="${pageContext.request.contextPath }/excelFileInformationServlet?owner=admin&fileName=${fileName}"
									target=main>${fileName}</A> &gt; 数据列属性
								</TD>
								<TD align="right"><A class=style2
									href="${pageContext.request.contextPath}/jsp/otherFunction.html"
									target=_blank>其它功能(新页面)</A></TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR align="center"
								style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
								<TD align="right" style="FONT-WEIGHT: bold;">表名:</TD>
								<TD align="left">${fileName}</TD>
								<TD align="right" style="FONT-WEIGHT: bold;">sheet名称:</TD>
								<TD align="left">${sheetName}</TD>
							</TR>

							<TR align="center"
								style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
								<TD align="right" style="FONT-WEIGHT: bold;">批量修改数据类型：</TD>
								<TD align="center"><select
									name="batchUpdateColDataTypeSelect"
									id="batchUpdateColDataTypeSelect">
										<c:forEach items="${excelColumnValueTypeList }"
											var="dataTypeValue" varStatus="status">
											<c:if
												test="${dataTypeValue.dataTypeCode==column.dataTypeCode }">
												<option title="dataTypeValue" selected="selected"
													value="${dataTypeValue.dataTypeCode}">${dataTypeValue.columnValueTypeName }</option>
											</c:if>
											<c:if
												test="${dataTypeValue.dataTypeCode!=column.dataTypeCode }">
												<option title="dataTypeValue"
													value="${dataTypeValue.dataTypeCode}">${dataTypeValue.columnValueTypeName }</option>
											</c:if>
										</c:forEach>
								</select>
									<button id="batchUpdateColDataTypeBtn">保存</button> <!-- <span class="saveDataType" id="batchUpdateColDataTypeBtn">保存</span> -->
								</TD>
								<TD align="right" style="FONT-WEIGHT: bold;"><button
										id="batchDeleteBtn">批量删除:</button></TD>
								<TD align="left" style="FONT-WEIGHT: bold;"><button
										id="batchAnalysisBtn">批量数据分析</button></TD>
							</TR>
							<TR>
								<TD height=2 colspan="6"></TD>
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
													<TD>列名称</TD>
													<TD>数据类型</TD>
													<TD>数据精度</TD>
													<TD>字段名称</TD>
													<TD>调整顺序</TD>
												</TR>
												<c:forEach items="${sheetColumnList }" var="column"
													varStatus="status">
													<TR align="center" class="columnElement"
														style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
														<TD><input type="checkbox" id="item" name="item"
															value="${column.excelSheetColumnId}" /></TD>
														<TD><input type="text" id="sortIndex"
															name="sortIndex" align="center"
															value="${column.sortIndex }" size="1" /></TD>
														<TD>${column.excelSheetColumnName}</TD>
														<TD><select name="dataType" id="dataType"
															class="dataTypeOption">
																<c:forEach items="${excelColumnValueTypeList }"
																	var="dataTypeValue" varStatus="status">
																	<c:if
																		test="${dataTypeValue.dataTypeCode==column.dataTypeCode }">
																		<option title="dataTypeValue" selected="selected"
																			value="${dataTypeValue.dataTypeCode}">${dataTypeValue.columnValueTypeName }</option>
																	</c:if>
																	<c:if
																		test="${dataTypeValue.dataTypeCode!=column.dataTypeCode }">
																		<option title="dataTypeValue"
																			value="${dataTypeValue.dataTypeCode}">${dataTypeValue.columnValueTypeName }</option>
																	</c:if>
																</c:forEach>
														</select></TD>
														<TD><input type="text" value="100"
															name="lengthPrecision"></TD>
														<TD><input type="text" value="字段名称" name="fieldName"></TD>
														<TD><!-- <span class="moveUpOrDown" id="recordDelete">数据删除</span> -->
														<a class="moveUpOrDown" href="${pageContext.request.contextPath }/columnRecordDelete?method=delete&excelSheetColumnId=${column.excelSheetColumnId}">删除</a>
															| <span class="dataAnalysis">分布分析</span></TD>
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
	<!--弹出层时背景层DIV-->
	<div id="fade" class="black_overlay" style="display:none"></div>
	<!-- 编辑框 可以加自己的样式 -->
	<div id="MyDiv" class="white_content" style="display:none">
		<!-- 点击阴影处退出！！！ -->
	</div>
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
