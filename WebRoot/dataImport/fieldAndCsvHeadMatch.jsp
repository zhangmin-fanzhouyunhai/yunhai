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

<title>字段与表头匹配</title>

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
	var tableStruct = {
		fieldRecordID : "fieldRecord01",
		tableField : "field1",
		tableFieldName : "fieldName1",
		tableFieldDataType : "dataType1",
		csvHeaderName : "csvHeaderName1"
	};
	//定义二维数组
	var arr = new Array(4);
	arr[0] = new Array("哈尔滨", "齐齐哈尔", "大庆", "佳木斯");
	arr[1] = new Array("长春市", "吉林市", "四平市", "通化市");
	arr[2] = new Array("沈阳市", "锦州市", "大连市", "铁岭市");
	arr[3] = new Array("郑州市", "洛阳市", "安阳市", "南阳市");
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</head>

<body bgcolor="white" >
	<form action="${pageContext.request.contextPath }/csvDataImport">
		<table width="60%" align="center" border="1">
			<tr>
				<td align="center" >字段</td>
				<td align="center">字段名</td>
				<td align="center">数据类型</td>
				<td align="center">表头</td>
			</tr>
			<c:forEach items="${fieldList }" var="item">
				<tr align="center">
					<td><select name="field"> 
							<!-- 逐行显示字段列表中的字段 -->
							<c:forEach items="${fieldList }" var="fieldOptionItem">
								<c:if
									test="${ item.fieldRecordID ne fieldOptionItem.fieldRecordID }">
									<option value="${ fieldOptionItem.fieldRecordID}">${ fieldOptionItem.field}
									</option>
								</c:if>
								<c:if
									test="${ item.fieldRecordID eq fieldOptionItem.fieldRecordID }">
									<option value="${ fieldOptionItem.fieldRecordID}" selected="selected">${ fieldOptionItem.field}
									</option>
								</c:if>
							</c:forEach>
					</select></td>
					<td><select name="fieldName"> 
							<!-- 逐行显示字段列表中的字段名 -->
							<c:forEach items="${fieldList }" var="fieldNameOptionItem">
								<c:if
									test="${ item.fieldRecordID ne fieldNameOptionItem.fieldRecordID }">
									<option value="${ fieldNameOptionItem.fieldRecordID}">
										${ fieldNameOptionItem.fieldName}</option>
								</c:if>
								<c:if
									test="${ item.fieldRecordID eq fieldNameOptionItem.fieldRecordID }">
									<option value="${ fieldNameOptionItem.fieldRecordID}" selected="selected">
										${ fieldNameOptionItem.fieldName}</option>
								</c:if>
							</c:forEach>
					</select></td>
					<td><select name="dataType"> 
							<!-- 逐行显示字段列表中的字段数据类型 -->
							<c:forEach items="${dataTypeList }" var="dataTypeOptionItem">
								<c:if
									test="${ item.dataType ne dataTypeOptionItem.dimID }">
									<option value="${ dataTypeOptionItem.dimID}">
										${ dataTypeOptionItem.dimCode}</option>
								</c:if>
								<c:if
									test="${ item.dataType eq dataTypeOptionItem.dimID }">
									<option value="${ dataTypeOptionItem.dimID}" selected="selected">
										${ dataTypeOptionItem.dimCode}</option>
								</c:if>
							</c:forEach>
					</select></td>
					<td><select name="csvHeaderName">  
							<!-- 逐行显示字段列表中的字段可能对应的表头，如果没有则显示为空-->
							<c:forEach items="${CsvHeaderList }" var="csvHeaderNameItem">

								<c:if
									test="${ item.csvHeaderName ne csvHeaderNameItem.csvHeaderValue }">
									<option value="${ csvHeaderNameItem.indexof}" >
										${csvHeaderNameItem.csvHeaderValue}</option>
								</c:if>
								<c:if
									test="${ item.csvHeaderName eq csvHeaderNameItem.csvHeaderValue }">
									<option value="${ csvHeaderNameItem.indexof}" selected="selected">
										${csvHeaderNameItem.csvHeaderValue}</option>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
