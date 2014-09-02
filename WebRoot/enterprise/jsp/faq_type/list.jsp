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
<title>知识管理</title>
<%@include file="../../common/common_head.jsp" %>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/json2.min.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/plugin/plugin_datagrid-detailview.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/jsp/faq_type/js/index.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">知识管理</a></li>
    <li><a href="#">知识列表</a></li>
    </ul>
 </div>
<!-- 中间部分 --> 
<div style="width: 100%;margin: 5px auto;min-height: 500px;">
<li style="width: 250px;
height: 100%;float: left;">
<div class="formbody" style="padding: 10px 10px" >
<span><a href="#" class="easyui-linkbutton _class_btn_save_type" style="padding: 0 20px;">保存</a></span>
 <div class="easyui-panel" style="padding:5px">
<ul id="faq_type_tree" ></ul></div>

<div id="mm" class="easyui-menu" style="width:120px;float: left;">
        <div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
        <div onclick="removeit()" data-options="iconCls:'icon-remove'">移除</div>
        <div class="menu-sep"></div>
        <div onclick="expand()">展开</div>
        <div onclick="collapse()">收缩</div>
    </div>
    <div id="mm_root" class="easyui-menu" style="width:120px;float: left;">
        <div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
        <div class="menu-sep"></div>
        <div onclick="expand()">展开</div>
        <div onclick="collapse()">收缩</div>
    </div>
</div>
</li>
<li style="width: 945px;
height: 100%;float: left;">
  <div class="formbody" style="padding: 1px 10px" >
    <div class="formtitle"><span>基本信息</span></div>
	<form id="_form_search_default">
		<input type="hidden" name="beanProxy.enable" value="0"/>
		<ul class="seachform" style="margin-top: 10px;">
			<li><label>问题内容</label><input name="beanProxy.nickname" type="text" class="easyui-validatebox scinput" /></li>
			<li><label>答  案 ： </label><input name="beanProxy.cityId" type="text" id="citySearch" class="easyui-validatebox scinput" /></li>
			<li>	
				<label>添加时间</label>
				<input name="beanProxy.addDatetime_GreaterThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" style="width:125px; height:32px; padding: 3px;" data-options="showSeconds:false,editable:true"  />
				~ <input name="beanProxy.addDatetime_LessThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" style="width:125px; height:32px; padding: 3px;" data-options="showSeconds:false,editable:true"  />
			</li>
			<li><label>&nbsp;</label><input class="btn _class_search" name="" type="button" class="btn" value="查询"/></li>
		</ul>
	</form>
	<div class="box"></div>
	<div class="tools">
	<span style="float:left;">
		</span>
		<div class="xline"></div>
		<ul class="toolbar" style="margin-top: 10px;">
		<a href="#" class="easyui-linkbutton item_add" style="width:80px;">增加</a>
        <a href="#" class="easyui-linkbutton" style="width:80px">删除</a>
        <a href="#" class="easyui-linkbutton" style="width:80px">导出</a>
        <a href="#" class="easyui-linkbutton" style="width:80px">导入</a>
        <a href="#" class="easyui-linkbutton" style="width:80px">知识模板</a>
		<!--  <li class="click _class_btn_add"><span><img src="../../images/t01.png" /></span>添加</li>
		<li class="click _class_btn_config"><span><img src="../../images/t02.png" /></span>配置服务</li>
		<li><span><img src="images/t03.png" /></span>删除</li>
		<li><span><img src="images/t04.png" /></span>统计</li> -->
		</ul>
		<ul class="toolbar1">
			<!-- <li><span><img src="images/t05.png" /></span>设置</li> -->
		</ul>
	</div>
	<%@include file="../../common/common_datagrid.jsp" %>
	<%@include file="../../common/common_dialog.jsp" %>
    <%@include file="../../common/common_cache_dialog.jsp" %>	
    </div></li></div>
</body>
</html>
