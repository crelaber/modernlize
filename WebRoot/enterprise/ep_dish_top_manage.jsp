<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String actualBasePath = basePath;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜品管理</title>

<%@include file="common/common_head.jsp" %>

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_dish_top_manage.js"></script>

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">推荐菜列表</a></li>
    </ul>
    </div>
    
    <div class="formbody">

    <div class="formtitle"><span>推荐菜列表</span></div>
	
	<!-- 
	<div class="tools">
		
		<ul class="toolbar">
			<li class="click">
				<a href="ep_dish_manage.jsp">推荐菜设置</a>
			</li>
		</ul>
		
		<ul class="toolbar1"> -->
			<!-- <li><span><img src="images/t05.png" /></span>设置</li> -->
		<!--</ul>
	
	</div> -->
	
	<%@include file="common/common_datagrid.jsp" %>
	<%@include file="common/common_dialog.jsp" %>
	<%@include file="common/common_cache_dialog.jsp" %>
	
    </div>
	
</body>
</html>
