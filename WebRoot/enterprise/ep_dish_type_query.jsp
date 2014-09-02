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
<title>菜单类型查询界面（树2）</title>

<%@include file="common/common_head.jsp" %>

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/plugin/plugin_tree_query.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_dish_type_query.js"></script>

</head>

<body>

<div class="tools">
		
	<span style="float:left;">
		<label>菜品类型：</label>
		<input name="beanProxy.addDatetime_LessThanOrEqualTo" type="text" class="easyui-searchbox" style="width:300px" data-options="searcher:doSearchDishType,prompt:'请输入菜品类型'"/>
		&nbsp;&nbsp;&nbsp;
	</span>
	
	<!-- 
	<ul>
		<li><label>&nbsp;</label><input class="btn _class_search" name="" type="button" class="btn" value="选择"/></li>
	</ul>
	 -->
	
	<div style="clear: both;"></div>
	<div class="box"></div>
	
	<div>
		<div class="easyui-panel" style="padding:5px">
	        <ul class="easyui-tree" id="dish_type_cache_tree" data-options="url:'<%=actualBasePath %>enterprise/data/dish_type_cache.json',method:'get',lines:true"></ul>
	    </div>
    </div>
	
</div>
	
</body>

</html>
