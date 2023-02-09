<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<link
	href="${pageContext.request.contextPath }/css/bootstrap4.6.0/bootstrap.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap4.6.0/bootstrap.min.js"></script>

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
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0 >
		<TBODY>
			<TR>
				<TD width=15 background=${pageContext.request.contextPath }
					/images/new_022.jpg><IMG
					src="${pageContext.request.contextPath }/images/new_022.jpg"
					border=0></TD>
				<TD vAlign=top width="100%" bgColor=#ffffff>
					<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
						<TR>
							<TD class=manageHead>当前位置：excel导入&gt;
								原始数据导入</TD>
						</TR>
						<TR>
							<TD height=2></TD>
						</TR>
					</TABLE> 
					<FORM id=form1 name=form1
						action="${pageContext.request.contextPath }/procedure"
						method="post" >
						<TABLE cellSpacing=0 cellPadding=5 border=1  class="table table-striped" >
							<TR>
								<th>参数</th> 
								<th>参数值</th> 
							</TR>
							<TR>
								<td>存储过程名称</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="procedureName"value="MID_ERP_ITEM_A_PROC"></td> 
							</TR>
							<TR>
								<td>数据版本</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="versionValue"value="O_2020_3"></td> 
							</TR>
							<TR>
								<td>来源数据表</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="updateDependentTable"value="ZFI_SWZC"></td> 
							</TR>
							<TR>
								<td>数据存入表</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="targetTable"value="MID_ERP_ITEM"></td> 
							</TR>
							<TR>
								<td>电压等级关联编码</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="voltageRelationCodeValue"value="10001"></td> 
							</TR>
							<TR>
								<td>资产运行状态编码</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="assetUsingRelationColde"value="1000"></td> 
							</TR>
							<TR>
								<td>资产运行状态关联编码</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="equipmentUsingRelationCode" value="1000"></td> 
							</TR> 
							<TR align="center" >  
								<td colspan=2><INPUT class=button id=sButton2 type=submit
									value="导入 " name=sButton2></td>
							</TR>
						</TABLE> 
					</FORM>  
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
	<script type="text/javascript">
	
	</script>
</BODY>
</HTML>
