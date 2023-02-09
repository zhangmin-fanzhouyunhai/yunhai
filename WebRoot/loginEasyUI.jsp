<%@ page  
language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="width:100%;height:100%;overflow:hidden">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>
<link rel="stylesheet"
	href="js/jquery-easyui-1.9.4/themes/default/easyui.css" type="text/css" />
<link rel="stylesheet" href="js/jquery-easyui-1.9.4/themes/icon.css"
	type="text/css" />
<link rel="stylesheet" href="css/main.css" type="text/css" />
<!-- <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.9.4/jquery.easyui.min.js"></script>
<!-- <script type="text/javascript" src="js/JQuery-formui.js"></script> -->
<script type="text/javascript" src="js/Common.js"></script>

</head>
<body
	style="height:100%;width:100%;overflow:hidden;border:none;visibility:visible;">
	<div id="mianwindow" class="EasyUI-window"
		style="width:500px;height:300px;background:#fafafa;overflow:hidden"
		title="登录" border="false" resizeable="false" draggable="false"
		minimizable="false" maximizable="false" align="center">
		<%-- <div class="header" style="height:35px;">
			<div class="toptitle"
				style="margin-top:25px; font-size:20px;margin-left:60px;">
				<%=PublicinformationUtil.GetProperties("projectname")%>
			</div>
		</div> --%>
		<div style="padding:60px 0;" align="center">
			<div id="loginForm" align="center">
				<div style="padding-left:150px" align="center">
					<table cellpadding="0" cellspacing="3" align="center">
						<tr>
							<td>登录账号</td>
							<td><input id="LOGINNAME" style="width:114px;"></input></td>
						</tr>
						<tr>
							<td>登录密码</td>
							<td><input id="PASSWORD" type="password"
								style="width:114px;"></input></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td></td>
							<td>
							<input type="button" id="btnLogin" value="登录"></input>
							<input type="button"  onclick="clearAll()" value="重置"></input>
							<!-- <a id="btnLogin" class="EasyUI-linkbutton">登录</a> 
							<a class="EasyUI-linkbutton" onclick="clearAll()">重置</a> -->
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function clearAll() {
			document.getElementById("LOGINNAME").value = "";
			document.getElementById("PASSWORD").value = "";
		}
		$("#PASSWORD").keydown(function(event) {
			if (event.keyCode == 13)
				$("#btnLogin").click();
		});
		$("#btnLogin").click(function(){
			var LOGINNAME=$("#LOGINNAME").val();
			var PASSWORD=$("#PASSWORD").val();
			//if(JUDGE.isNull(LOGINNAME)||JUDGE.isNull(PASSWORD))
			if(LOGINNAME==""||PASSWORD=="")
			{
			$.messager.alert("提示消息","用户名、密码都不能为空！","info");
			return;
			}
			alert(LOGINNAME);
			alert(PASSWORD);
			//var condition={"accountName":LOGINNAME,"accountPassword":PASSWORD};
			//condition= JSON.stringify(condition);
			//condition=escape(encodeURIComponent(condition));
			//var url='/Day29/accountLogin?condition='+condition;
			 var url='/Day29/accountLogin';
			$.ajax({
				type : "post",
				dataType : 'json',//提交方式是json，也可以是html和text
			    url : url,
				cache : false,
				//contentType : "text/html",
				data : {
					accountName : LOGINNAME,
					accountPassword : PASSWORD,
					},
				error : function(event,request,settings){
				$.messager.alert("提示消息","请求失败！","info");
				},
				success : function(data){
				if(data[0]!=null){
				   window.location.href=getRootPath()+ "/customerManager.html";
				   }
				   else{
				   $.messager.alert("提示消息","用户名或密码错误！","info");
				   }
				   }
			})
		});
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
 
</body>
</html>