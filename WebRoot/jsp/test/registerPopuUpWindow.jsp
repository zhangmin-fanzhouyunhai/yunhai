<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>弹出窗口测试</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
<style type="text/css">
body {
	margin: 0;
}

#nav {
	background-color: aqua;
	width: 100%;
	padding-left: 10px;
	padding-top: 10px;
	height: 40px;
}

#nav a {
	display: block;
	margin-top: 0px;
}

#head {
	padding-top: 25px;
	border-bottom: 1px solid #000;
}

#head a {
	font-size: 25px;
	margin-left: 10px;
	border-bottom: 2px solid #00FFFF;
}

.tab {
	padding-top: 20px;
	padding-left: 100px;
}

.user {
	display: block;
	margin: 2px 0;
}

.user input {
	border-style: none;
	border: 1px solid #000;
	border-radius: 5px;
	height: 25px;
	width: 250px;
}

.pwd {
	display: block;
	margin: 2px 0;
}

.pwd input {
	border-style: none;
	border: 1px solid #000;
	border-radius: 5px;
	height: 25px;
	width: 250px;
}

.sex {
	display: block;
	margin: 2px 0;
}

.hob {
	display: block;
	margin: 2px 0;
}

.star {
	display: block;
	margin: 2px 0;
}

.remarks {
	display: block;
	margin: 2px 0;
}

.remarks textarea {
	border-style: none;
	border: 1px solid #000;
	border-radius: 5px;
	height: 100px;
}

#reg input {
	border-style: none;
	background-color: #00FFFF;
	color: white;
	width: 80px;
	height: 25px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			var userName = $(":text").val();
			var password = $(":password").val();
			var sex = $(":radio:checked").val();
			var hobby = [];
			var i = 0;
			$(":checkbox:checked").each(function() {
				hobby[i] = $(this).val();
				i++;
			});
			var star = $("#star option:selected").text();
			var remark = $("#remark").val();
			alert("账号：" + userName + "\r" +
				"密码：" + password + "\r" +
				"性别：" + sex + "\r" +
				"爱好：" + hobby + "\r" +
				"星座：" + star + "\r" +
				"备注：" + remark)

		})
	})
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<%-- <FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customerServlet?method=addsubmit"
		method=post> --%>

	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/saveCustomer"
		method="post">

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
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<table class="tab">
							<tr class="user">
								<td>账号：</td>
								<td><input type="text" name="user" id="num"
									placeholder="请输入账号" /></td>
							</tr>
							<tr class="pwd">
								<td>密码：</td>
								<td><input type="password" name="password" id="pwd"
									placeholder="请输入密码" /></td>
							</tr>
							<tr class="sex">
								<td>性别:</td>
								<td><input type="radio" name="sex" value="男" checked />男 <input
									type="radio" name="sex" value="女" />女</td>
							</tr>
							<tr class="hob">
								<td>爱好：</td>
								<td><input type="checkbox" name="hobby" value="唱歌" checked />唱歌
									<input type="checkbox" name="hobby" value="跳舞" />跳舞 <input
									type="checkbox" name="hobby" value="足球" />足球</td>
							</tr>
							<tr class="star">
								<td>星座：</td>
								<td><select name="star" id="star">
										<option value="1">白羊座</option>
										<option value="2" selected>射手座</option>
										<option value="3">巨蟹座</option>
										<option value="4">天秤座</option>
										<option value="5">水瓶座</option>
										<option value="6">双鱼座</option>
										<option value="7">天蝎座</option>
										<option value="8">狮子座</option>
										<option value="9">摩羯座</option>
										<option value="10">处女座</option>
										<option value="11">双子座</option>
										<option value="12">金牛座</option>
								</select></td>
							</tr>
							<tr class="remarks">
								<td style="padding-bottom: 90px;">备注：</td>
								<td><textarea id="remark" rows="4" cols="50"></textarea></td>
							</tr>
							<tr id="reg">
								<td><input id="btn" type="button" value="注册" "/></td>
							</tr>
						</table>


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
	</FORM>
	<a href="${pageContext.request.contextPath }/importPmsItemShuLine">导入数据</a>
</BODY>
</HTML>
