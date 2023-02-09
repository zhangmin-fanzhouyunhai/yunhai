<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'fieldAndCsvHeadMatchTest.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>

<script type="text/javascript">
	//   ../jQuery/case5-leftSelectToRightSelect/下也有一个“案例5-省市联动.html”,好好对比学习学习
	/* var tableStruct={fieldRecordID:"fieldRecord01",tableField:"field1",
				tableFieldName:"fieldName1",tableFieldDataType:"dataType1",
				csvHeaderName:"csvHeaderName1"}; */
	$(function() {
	})
	
	

		//定义二维数组
		var fieldList = new Array(4);
		fieldList[0] = {
			fieldRecordID : "fieldRecord01",
			tableField : "字段1",
			tableFieldName : "fieldName1",
			tableFieldDataType : "类型1",
			csvHeaderName : "csvHeaderName1"
		};
		fieldList[1] = {
			fieldRecordID : "fieldRecord02",
			tableField : "字段2",
			tableFieldName : "fieldName2",
			tableFieldDataType : "类型2",
			csvHeaderName : "csvHeaderName2"
		};
		fieldList[2] = {
			fieldRecordID : "fieldRecord03",
			tableField : "字段3",
			tableFieldName : "fieldName3",
			tableFieldDataType : "类型2",
			csvHeaderName : "csvHeaderName3"
		};
		fieldList[3] = {
			fieldRecordID : "fieldRecord04",
			tableField : "字段4",
			tableFieldName : "fieldName4",
			tableFieldDataType : "类型1",
			csvHeaderName : "csvHeaderName4"
		};
	
</script>
</head>

<body>
	<form action="${pageContext.request.contextPath }/csvDataImport">
		<table border="1" width="60%" align="center">
			<tr>
				<td>字段</td>
				<td>字段名</td>
				<td>数据类型</td>
				<td>表头</td>
			</tr>
			<c:forEach items="${fieldList }" var="item">
				<tr>
					<td><select name="field">
							<option>${ item.field}</option>
							<!-- 逐行显示字段列表中的字段 -->
							<c:forEach items="${fieldList }" var="fieldOptionItem">
								<option value="${ fieldOptionItem.fieldRecordID}">${ fieldOptionItem.field}
								</option>
							</c:forEach>
					</select></td>
					<td><select name="fieldName">
							<option>${ item.fieldName}</option>
							<!-- 逐行显示字段列表中的字段名 -->
							<c:forEach items="${fieldList }" var="fieldNameOptionItem">
								<option value="${ fieldNameOptionItem.fieldRecordID}">
									${ fieldNameOptionItem.fieldName}</option>
							</c:forEach>
					</select></td>
					<td><select name="dataType">
							<option>${ item.dataType}</option>
							<!-- 逐行显示字段列表中的字段数据类型 -->
							<c:forEach items="${fieldList }" var="dataTypeOptionItem">
								<option value="${ dataTypeOptionItem.fieldRecordID}">
									${ fieldNameOptionItem.dataType}</option>
							</c:forEach>
					</select></td>
					<td><select name="csvHeaderName">
							<option>${ item.csvHeaderName}</option>
							<!-- 逐行显示字段列表中的字段可能对应的表头，如果没有则显示为空-->
							<c:forEach items="${CsvHeaderList }" var="csvHeaderNameItem">
								<option value="${ csvHeaderNameItem.csvHeaderNumber}">
									${csvHeaderNameItem.csvHeaderName}</option>
							</c:forEach>
					</select></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
