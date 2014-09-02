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
<script type="text/javascript" src="<%=actualBasePath %>enterprise/jsp/faq_type/css/ext.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/jsp/faq_type/js/index.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">商家管理</a></li>
    <li><a href="#">商家管理列表</a></li>
    </ul>
 </div>
<!-- 中间部分 --> 
<ul class="main_p3">
<!-- 
<li style="width: 150px;
height: 100%;float: left; background: url(../../images/boxbg3.png) bottom left no-repeat;">
<div class="formbody" style="padding: 10px 10px" >
<ul id="faq_type_tree" ></ul></div></li>
 -->

<li class="m_left">
<ul class="box01">

<li class="left_mid">
<!-- 知识分类 -->
<!--  <img src="images/left_menu.png" width="166" height="521" border="0"/>-->
<ul id="faq_type_tree"></ul>
</li>
<li class="left_bot"></li>
<div class="clearf"></div>
</ul>
</li>






<li class="m_center">
  <div class="formbody" style="padding: 0px 1px" >
    <div class="formtitle"><span>基本信息</span></div>
	<form id="_form_search_default">
		<input type="hidden" name="beanProxy.enable" value="0"/>
		<ul class="seachform" style="margin-top: 10px;">
			<li><label>店铺名称</label><input name="beanProxy.nickname" type="text" class="easyui-validatebox scinput" /></li>
			<li><label>所在城市</label><input name="beanProxy.cityId" type="text" id="citySearch" class="easyui-validatebox scinput" /></li>
			<li><label>所在区域</label><input name="beanProxy.area" type="text"  id="areaSearch" class="easyui-validatebox scinput" /></li>
			<li><label>详细地址</label><input name="beanProxy.address_Like" type="text" class="easyui-validatebox scinput" /></li>
			<li><label>服务类型</label><input name="beanProxy.serverList_In" id="server" class="easyui-validatebox scinput" /></li>
			<li><label>服务评分</label><input name="beanProxy.serviceGradeLevel_LessThanOrEqualTo" type="text" class="easyui-validatebox scinput" /></li>
			<li><label>态度评分</label><input name="beanProxy.attitudeGradeLevel_LessThanOrEqualTo" type="text" class="easyui-validatebox scinput" /></li>
			<li><label>环境评分</label><input name="beanProxy.environmentGradeLevel_LessThanOrEqualTo" type="text" class="easyui-validatebox scinput" /></li>
			<li><label>所在经度</label><input name="beanProxy.lon" type="text" class="easyui-validatebox scinput" /></li>
			<li><label>所在纬度</label><input name="beanProxy.lat" type="text" class="easyui-validatebox scinput" /></li>
			<li><label>是否推荐</label><input name="beanProxy.isRecommend" id="isRecommend" class="easyui-validatebox scinput" /></li>
			<li><label>添加时间</label>
				<input name="beanProxy.addDatetime_GreaterThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" data-options="showSeconds:false,editable:true"  />
				~ <input name="beanProxy.addDatetime_LessThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" data-options="showSeconds:false,editable:true"  />
			</li>
		   <li><label></label><input class="btn _class_search" name="" type="button" class="btn" value="查询"/></li>
		</ul>
	</form>
	<div class="box"></div>
	<div class="tools">
	<span style="float:left;">
		</span>
		<div class="xline"></div>
		<ul class="toolbar">
		<li class="click _class_btn_add"><span><img src="../../images/t01.png" /></span>添加</li>
		<li class="click _class_btn_config"><span><img src="../../images/t02.png" /></span>配置服务</li>
		<!--<li><span><img src="images/t03.png" /></span>删除</li>
		<li><span><img src="images/t04.png" /></span>统计</li> -->
		</ul>
		<ul class="toolbar1">
			<!-- <li><span><img src="images/t05.png" /></span>设置</li> -->
		</ul>
	</div>
	<%@include file="../../common/common_datagrid.jsp" %>
	<%@include file="../../common/common_dialog.jsp" %>
    <%@include file="../../common/common_cache_dialog.jsp" %>	
    </div></li></ul>
</body>
</html>
