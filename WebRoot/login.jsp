<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="yunhai">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript">
	$(function() {
		$("#accountSubmit").click(
			function() {
				var accountName = $("#accountName").val();
				var accountPassword = $("#accountPassword").val();
				var automaticLoginCheckBox = $("#automaticLoginCheckBox").val();
				var rememberAccountCheckBox = $("#rememberAccountCheckBox").val();
				var verificationCode = $("#verificationCode").val();
				var serveCode = $("#serveCode").val();
				//alert(verificationCode);
				jQuery.ajax({
					type : 'POST',
					dataType : 'json', //提交方式是json，也可以是html和text
					//dataType:'json' 的意思是URL返回值是以JSON的格式传过来的，然后在页面上解析时就要采取JSON格式来展示。 
					url : '/Day29/accountLogin', //提交到servlet中
					cache : false,
					data : {
						userName : accountName,
						password : accountPassword,
						verificationCode : verificationCode,
						automaticLoginCheckBox : automaticLoginCheckBox,
						rememberAccountCheckBox : rememberAccountCheckBox,
						serveCode : serveCode,
					},
					success : function(data, textStatus) {
						//  请求成功时处理
						//alert(data[0].userName); //用这种写法能取出后台传回来的json对象的属性
						if (data[0] != null) {
							//alert("登录成功！");
							var url = getRootPath() + "/customerManager.html"; //获取工程路径 
							//var url = getRootPath() + "/servlet/showMessAction";
							location.href = url;
						}
					},
					error : function() {
						//alert("error,账户密码错误！");
						$("#codeTextMsg").html("账户或密码错误！");
					}
				});
			});
			/* $("#verificationCode").blur(function(){
				//alert("checkCode:" );
				var checkCode=$.cookie('checkCode');
				if(this.value!=checkCode){  
				$("#codeTextMsg").html("验证码输入错误！");
				}else{
				$("#codeTextMsg").html("");
				}
			}); */

		$("#verificationCode").blur(function() {
			var checkCode = this.value;
			jQuery.ajax({
				type : 'POST',
				dataType : 'json', //提交方式是json，也可以是html和text
				//dataType:'json' 的意思是URL返回值是以JSON的格式传过来的，然后在页面上解析时就要采取JSON格式来展示。 
				url : '/Day29/checkCodeConfirm', //提交到servlet中
				cache : false,
				data : {
					checkCode : checkCode,
				},
				success : function(data, textStatus) {
					//  请求成功时处理 
					//alert(data.data);
					if (data.data == "success") {
						$("#codeTextMsg").html("");

					} else {
						$("#codeTextMsg").html("验证码输入错误！");
					}
				},
				error : function() {
					$("#codeTextMsg").html("验证码输入错误！");
				}
			});
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
	function changeImg(obj) {
		//操作src属性
		obj.src = "/Day29/codeServlet?i=" + Math.random();
		//alert(1);

	}
</script>
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
	 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
}
</style>
</head>
<body>




	<!--
            	时间：2021-02-11
            	描述：菜单栏
            -->
	<div class="container-fluid">
		<div class="col-md-4">
			<img src="img/logo2.png" />
		</div>
		<div class="col-md-5">
			<img src="img/header.png" />
		</div>
		<div class="col-md-3" style="padding-top:20px">
			<ol class="list-inline">
				<li><a href="login.jsp">登录</a></li>
				<li><a href="projectLearn/day10/register.html">注册</a></li>
				<li><a href="projectLearn/day11/cart.html">购物车</a></li>
			</ol>
		</div>
	</div>
	<!--
            	时间：2021-12-30
            	描述：导航条
            -->
	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="projectLearn/day11/product_list.jsp">手机数码<span
							class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
	</div>







	<div class="container"
		style="width:100%;height:460px;background:#FF2C4C url('images/loginbg.jpg') no-repeat;">
		<div class="row">
			<div class="col-md-7">
				<!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
			</div>

			<div class="col-md-5">
				<div
					style="width:440px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px;background:#fff;">
					<font>会员登录</font>USER LOGIN

					<div>&nbsp;</div>
					<!-- <form class="form-horizontal"
						action="http://localhost:8080/Day29/login"  
						method="post">-->
					<form class="form-horizontal" method="post">
						<div class="form-group">
							<label for="accountName" class="col-sm-2 control-label">
								用户名 </label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="accountName"
									placeholder="请输入用户名" name="accountName"
									value="${cookie.saveName.value }">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">
								密码</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="accountPassword"
									placeholder="请输入密码" name="accountPassword">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="verificationCode"
									placeholder="请输入验证码"><span id="codeTextMsg"></span>
							</div>
							<div class="col-sm-3">
								<!-- <img src="image/captcha.jpg" /> -->
								<img alt="验证码" src="/Day29/codeServlet" title="看不清楚，换一张"
									onclick="changeImg(this)">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox"
										id="automaticLoginCheckBox"> 自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
										type="checkbox" value="ok" id="rememberAccountCheckBox">
										记住用户名
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">
								服务器</label>
							<div class="col-sm-offset-2 col-sm-10">
								<select id="serveCode" name="serveCode">
									<option value="100000000" selected="selected">服务器一</option>
									<option value="100000001">服务器二</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="button" width="100" value="登录" name="submit"
									border="0" id="accountSubmit"
									style="background: 
									url('images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
    								height:35px;width:100px;color:white;">
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>

	<div style="margin-top:50px;">
		<img src="./image/footer.jpg" width="100%" height="78" alt="我们的优势"
			title="我们的优势" />
	</div>

	<div style="text-align: center;margin-top: 5px;">
		<ul class="list-inline">
			<li><a>关于我们</a></li>
			<li><a>联系我们</a></li>
			<li><a>招贤纳士</a></li>
			<li><a>法律声明</a></li>
			<li><a>友情链接</a></li>
			<li><a target="_blank">支付方式</a></li>
			<li><a target="_blank">配送方式</a></li>
			<li><a>服务声明</a></li>
			<li><a>广告声明</a></li>
		</ul>
	</div>
	<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
		Copyright &copy; 2005-2016 传智商城 版权所有</div>
</body>
</html>
