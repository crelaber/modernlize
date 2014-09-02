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

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_dish_manage.js"></script>

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
	<form id="_form_search_default">
		<input type="hidden" name="beanProxy.enable" value="0"/>
		<input type="hidden" id="_id_dish_type_value" name="beanProxy.typeId"/>
			
		<ul class="seachform">
			
			<li><label>菜品名称</label><input name="beanProxy.dishName_Like" type="text" class="easyui-validatebox easyui-textbox" style="width:125px; height:32px; padding: 3px;"/></li>
			
			<li><label>菜品状态</label>
				<select class="easyui-combobox" name="beanProxy.dishState" style="width:100px; height:32px; padding: 3px;" data-options="panelHeight:'auto',editable:false">
					<option value="">请选择</option>
					<option value="1">上架</option>
					<option value="0">已下架</option>
				</select>
			</li>
			<li>	
				<label>添加时间</label>
				<input name="beanProxy.addDatetime_GreaterThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" style="width:125px; height:32px; padding: 3px;" data-options="showSeconds:false,editable:true"  />
				~ <input name="beanProxy.addDatetime_LessThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" style="width:125px; height:32px; padding: 3px;" data-options="showSeconds:false,editable:true"  />
			</li>
			
			<li><label>&nbsp;</label><input class="btn _class_search" name="" type="button" class="btn" value="查询"/></li>
		</ul>
	</form>
	
	<div class="xline"></div>
	<div class="box"></div>
	
	<div class="tools">
	
		
		<span style="float:left;">
			<label>菜品类型 </label>
			<input id="_id_dish_type" type="text" class="easyui-textbox"  style="width:125px; height:32px; padding: 3px;" data-options="prompt:'选择菜品类型',editable:false"/>
			
			<input type="hidden" id="_id_dish_ptype"/>
			<input type="hidden" id="_id_dish_type_pvalue"/>
			
			<!-- <span class="searchbox-button" id="_id_btn_sdtype" style="height: 32px;"></span> -->
			<a href="#" id="_id_btn_rem_dtype" style="display:inline-block; padding:5px; text-align: center;vertical-align: middle;"><img src="images/action_delete.png"  style="display:inline-block;vertical-align: middle;"></a>
			<!-- <span class="searchbox-button icon-no" id="_id_btn_rem_dtype" style="height: 32px;"></span> -->
			&nbsp;&nbsp;&nbsp;
		</span>
		
		
		<ul class="toolbar">
		<li class="click _class_btn_add">添加菜品</li>
		<!--
		<li class="click"><span><img src="images/t02.png" /></span>修改</li>
		<li><span><img src="images/t03.png" /></span>删除</li>
		<li><span><img src="images/t04.png" /></span>统计</li> -->
		</ul>
		
		<ul class="toolbar1">
			<!-- <li><span><img src="images/t05.png" /></span>设置</li> -->
		</ul>
	
	</div>
	
	<%@include file="common/common_datagrid.jsp" %>
	<%@include file="common/common_dialog.jsp" %>
	<%@include file="common/common_cache_dialog.jsp" %>
	
	<%@include file="common/common_showimg_dialog.jsp" %>
		
    </div>
	
</body>
</html>
