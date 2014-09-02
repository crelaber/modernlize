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
<title>菜单管理</title>

<%@include file="common/common_head.jsp" %>

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_dish_manage.js"></script>

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">店铺管理</a></li>
    <li><a href="#">菜单管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">

    <div class="formtitle"><span>菜单管理</span></div>
	<form id="_form_search_default">
		<input type="hidden" name="beanProxy.enable" value="0"/>
		<ul class="seachform">
			<li>	
				<label>添加时间</label>
				<input name="beanProxy.addDatetime_GreaterThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" data-options="showSeconds:false,editable:true"  />
				~ <input name="beanProxy.addDatetime_LessThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" data-options="showSeconds:false,editable:true"  />
			</li>
			
			<li><label>&nbsp;</label><input class="btn _class_search" name="" type="button" class="btn" value="查询"/></li>
		</ul>
	</form>
	
	<div class="xline"></div>
	<div class="box"></div>
	
	<div class="tools">
	
		
		<span style="float:left;">
			<label>菜品类型：</label>
			<input name="beanProxy.addDatetime_LessThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" data-options="showSeconds:false,editable:true"  />
			&nbsp;&nbsp;&nbsp;
		</span>
		
		
		<ul class="toolbar">
		<li class="click _class_btn_add">添加</li>
		<!--
		<li class="click"><span><img src="images/t02.png" /></span>修改</li>
		<li><span><img src="images/t03.png" /></span>删除</li>
		<li><span><img src="images/t04.png" /></span>统计</li> -->
		</ul>
		
		<ul class="toolbar1">
			<!-- <li><span><img src="images/t05.png" /></span>设置</li> -->
		</ul>
	
	</div>
	
	<div id="_id_datagrid_def"></div>
	
	<div id="_id_dialog" class="easyui-dialog" style="width:820px;height:550px;overflow:auto; padding:10px 20px" closed="true" buttons="#dlg-buttons" data-options="modal: true,title: '新窗口'">
		<iframe id="_id_iframe" name="_id_iframe" runat="server" width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="auto" allowtransparency="yes"></iframe>
	</div>

	<div id="dlg-buttons" class="tools">
		
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="_onDialogEnter();">提交</a>
			
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="_onDialogCancel();">关闭</a>

	</div>
	
	
    </div>
	
</body>
</html>
