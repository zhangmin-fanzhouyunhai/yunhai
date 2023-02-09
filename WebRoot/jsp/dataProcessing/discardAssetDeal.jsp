<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
<script type="text/javascript" src="../../js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(function(){  
	//隐藏b1div
	$("#sButton2").click(function(){  
		//将按钮设置成不可操作
		$("#sButton2").attr('disabled',true);  
		//注意一定要有如下操作，form表单的action才能执行，并不是默认的就自动执行。
		alert("action"+$("#form1").attr("action"));
		$("#form1").submit();
	});
	})
</script>

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
					<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>导入数据分类</td>
								<td>数据版本：</td> 
								<td>日历年（导入年份） ：</td> 
								<td>导入文件（CSV文件)</td>
								<td rowspan=2>提交</td>
							</TR>
					</TABLE> 
					<FORM id=form1 name=form1
						action="${pageContext.request.contextPath }/zfiSwzcDiscIncrAdd"
						method="post" enctype="multipart/form-data">
						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>ERP报废数据（zfiSwzcDiscIncrAdd）</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="versionValue"></td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="calYear"></td>
								<td><INPUT type="file" class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="pathStr"></td>
								<td rowspan=2><INPUT class=button id=sButton2 type=submit
									value="保存 " name=sButton2></td>
							</TR>
						</TABLE> 
					</FORM> 
					
					<FORM id=form1 name=form1
						action="${pageContext.request.contextPath }/oriOpticalCableSectionAdd"
						method="post" enctype="multipart/form-data">
						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>TMS样本数据导入</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="versionValue"></td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="calYear"></td>
								<td><INPUT type="file" class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="pathStr"></td>
								<td rowspan=2><INPUT class=button id=sButton2 type=submit
									value="保存 " name=sButton2></td>
							</TR>
						</TABLE> 
					</FORM> 
					
					<FORM id=form1 name=form1
						action="${pageContext.request.contextPath }/zfiSwzcDiscIncrAdd"
						method="post" enctype="multipart/form-data">
						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>ERP报废数据（zfiSwzcDiscIncrAdd）</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="versionValue"></td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="calYear"></td>
								<td><INPUT type="file" class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="pathStr"></td>
								<td rowspan=2><INPUT class=button id=sButton2 type=submit
									value="保存 " name=sButton2></td>
							</TR>
						</TABLE> 
					</FORM>  
					<FORM id=form1 name=form1
						action="${pageContext.request.contextPath }/zfiSwzcDiscIncrAdd"
						method="post" enctype="multipart/form-data">
						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>ERP报废数据（zfiSwzcDiscIncrAdd）</td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="versionValue"></td> 
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="calYear"></td>
								<td><INPUT type="file" class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="pathStr"></td>
								<td rowspan=2><INPUT class=button id=sButton2 type=submit
									value="保存 " name=sButton2></td>
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
