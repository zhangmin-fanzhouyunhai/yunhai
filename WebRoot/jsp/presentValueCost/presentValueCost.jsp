<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Learning</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>

<style>
table{
border-collapse:collapse;border: 1px solid #000000; width:80%;
}
td{
border-collapse:collapse; border: 1px solid #000000; line-height:30px;
}
</style>
  </head>
  
  <body>
 <form >
 <table>
 
 </table>
 </form>
<div id="createTable">

</div>
<script language=javascript>
$(function(){
$.ajax(
{
type:"get",
url:"/jrjbxxlistjson",
dataType:"json",
success:function(res){
var list=res;
var table=$("<table>");
table.appendTo($("#createTable"));
for(var i=0;i<list.length;i++){
	var tr=$("<tr></tr>");
	tr.appendTo(table);
	var td=$("<td>"+list[i].ryid+"</td><td>"+list[i].sfzh + "</td><td>" + list[i].hbh + "</td><td>" + list[i].xm + "</td><td>" + list[i].xb + "</td>");
	td.appendTo(tr);
}
}
});
$("#createTable").append("</table>");
});
</script>
  </body>
</html>
