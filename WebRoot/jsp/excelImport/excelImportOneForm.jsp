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

<title>数据导入</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath }/css/bootstrap4.6.0/bootstrap.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap4.6.0/bootstrap.min.js"></script>
<style type="text/css">
.moveUpOrDown {
	background-color: #5BC0DE;
	border-radius: 3px;
	cursor: pointer;
	color: #FFFFFF;
	padding: 2px;
	font-size: 12px;
}
</style>
<script type="text/javascript">

	function getPath(obj) {
		if (obj) {
			if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
				obj.select();
				return document.selection.createRange().text;
			} else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
				if (obj.files) {
					return obj.files.item(0).getAsDataURL();
				}
				return obj.value;
			}
			return obj.value;
		}
	}




	$(function() {
	
	
	 
	//隐藏b1div
	/*$("#sButton2").click(function(){  
		//将按钮设置成不可操作
		$("#sButton2").attr('disabled',true);  
		//注意一定要有如下操作，form表单的action才能执行，并不是默认的就自动执行。
		$("#form1").submit();
	});*/
		/**
		 * 为 上移 、下移 按钮绑定点击事件
		 */
	/* 	$("body").on("click", ".button", function() {
		$(this).attr('disabled',true);
			//获取当前行隐藏输入框中的值
			var acValue = $(this).closest("tr").find("input[type='hidden']").attr("id");
			//
			//alert("action="+acValue);
 
			var versionValue = $(this).closest("tr").find("input[name='versionValue']").val();
			//
			//alert("versionValue="+versionValue);
			var calYear = $(this).closest("tr").find("input[name='calYear']").val(); 
			//alert("calYear="+calYear);  
			var files = $(this).closest("tr").find("input[name='pathStr']")[0].files;
			//alert("files=" + files); 
			//$("#form1").attr("action","/Day29/"+acValue);
			$("#form1").submit();
			
		}); */


		$("#sChannel3").change(
			function() {

				var file = this.files[0];
				alert(file);
				var reader = new FileReader();
				alert("reader=>" + reader);
				//this.ctrl = createThrobber(file);
				var xhr = new XMLHttpRequest();
				this.xhr = xhr;
				var self = this;
				alert("self=>" + self);
				this.xhr.upload.addEventListener("progress", function(e) {
					if (e.lengthComputable) {
						var percentage = Math.round((e.loaded * 100) / e.total);
						self.ctrl.update(percentage);
					}
				}, false);
				alert("xhr=>" + xhr);
				xhr.upload.addEventListener("load", function(e) {
					self.ctrl.update(100);
					var canvas = self.ctrl.ctx.canvas;
					canvas.parentNode.removeChild(canvas);
				}, false);
				xhr.enctype = "multipart/form-data";
				xhr.open("POST", "/Day29/spareEquipmentImportServlet?versionValue='O_2020_1'&calYear='2020-04-03 9:00'");
				xhr.overrideMimeType('text/plain; charset=x-user-defined-binary');
				reader.onload = function(evt) {
					xhr.send(evt.target.result);
				};
				reader.readAsBinaryString(file);
			});
	});


	function test() {
		$("#sChannel3").change(
			function() {

				var obj = this;

				if (obj) {
					if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
						obj.select();
						alert("window" + document.selection.createRange().text);
					} else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
						if (obj.files) {
							alert("Firefox" + obj.files.item(0).getAsDataURL());
						}
						alert("Not Firefox" + obj.value);
					}
					alert("others" + obj.value);
				}
			});
	}

	function edit(element) {
		var oldhtml = $.trim(element.innerHTML); //获得元素之前的内容
		var newobj = document.createElement('input'); //创建一个input元素
		newobj.type = 'text'; //为newobj元素添加类型
		newobj.value = oldhtml;
		element.innerHTML = ''; //设置元素内容为空
		element.appendChild(newobj); //添加子元素
		newobj.focus(); //获得焦点
		//设置newobj失去焦点的事件
		newobj.onblur = function() {
			//下面应该判断是否做了修改并使用ajax代码请求服务端将id与修改后的数据提交
			//alert(element.id);
			//当触发时判断newobj的值是否为空，为空则不修改，并返回oldhtml
			element.innerHTML = $.trim(this.value) ? $.trim(this.value) : $.trim(oldhtml);
		}
	}

	//action="${pageContext.request.contextPath }/zfiSwzcDiscIncrAdd"
</script>
</head>

<body>
	当前位置：excel导入&gt;原始数据导入
	<br>
	<center>
		<big> 原始数据导入</big>
	</center>
	<hr>
<FORM id="form1" name="form1" method="post" 
action="/Day29/oriOpticalCableSectionAdd"
				enctype="multipart/form-data"> 
	<table class="table table-striped" width="50%">
		<thead>
			<tr align="center">
				<td>数据模块</td>
				<td>数据版本</td>
				<td>日历年（导入年份）</td>
				<td>导入文件（CSV文件)</td>
				<td>操作</td>
				<td>&nbsp&nbsp</td>
			</tr>

		</thead>
		<tbody>  
				<tr align="center">
					<td>备品备件（spareEquipmentImportServlet） <input type="hidden" 
					value="2"
						name="ac" id="spareEquipmentImportShowFormServlet">
					</td>
					<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
						maxLength=50 name="versionValue"></td>
					<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
						maxLength=50 name="calYear"></td>
					<td><INPUT type="file" class=textbox id=sChannel2
						style="WIDTH: 180px" maxLength=50 name="pathStr"
						multiple="multiple"></td>
					<td><a></a> 
					  <INPUT class=button id=sButton2 type=submit
						value="保存 " name=sButton2> 
						</td>
					</td>
					<td>&nbsp&nbsp</td>
				</tr> 
		</tbody>
	</table>
 </FORM>
	<INPUT type="file" class="textbox" id="sChannel3" style="WIDTH: 180px"
		maxLength=50 name="pathStr2">
	<br>
	<INPUT class="button1" id="sButton3" type=submit value="保存 "
		name=sButton3>
</body>
</html>
