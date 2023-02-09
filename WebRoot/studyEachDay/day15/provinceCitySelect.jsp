<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@taglib prefix="c" tagdir=""%> --%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<script type="text/javascript">
/* var json={"username":"tom","age":18};
alert(json.age); */
</script>
<head>
<base href="<%=basePath%>">

<title>My JSP 'provinceCitySelect.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		//页面加载成功 查询所有的省
		$.get("/Day29/selectProvinceServlet", function(data) {
			//$("#provinceId")
			//alert(data);
			var $province = $("#province");
			//alert($province);
			if (data != null) {
				$(data).each(function() {
					$province.append($("<option value=" + this.provinceID + ">" + this.name + "</option>"));
				});
			}
		}, "json");

		//给省份下拉选项派发change事件
		$("#province").change(function() {
			var $pid = $(this).val();
			//alert($pid);
			//发送ajax请求
			$.get("/Day29/selectCityServlet", {
				"provinceID" : $pid
			}, function(data) {
				//alert(data);
				var $city = $("#city");
				$city.html("<option>--请选择--</option>");
				if (data != null) {
					$(data).each(function() {
						$city.append($("<option value=" + this.cityID + ">" + this.name + "</option>"));
					});
				}
			}, "json");
		});

	})
</script>
</head>

<body>
	<center>
		<select id="province" name="province">
			<option>--省份--</option>
			<!-- <option value="1">北京</option> -->
		</select> <select id="city" name="city">
			<option>--请选择--</option>

		</select>
	</center>

</body>
</html>
