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

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_tab_common.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_takeaway_order.js"></script>

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">外卖订单管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">

    <!-- <div class="formtitle"><span>外卖订单管理</span></div> -->
	
	<div id="usual1" class="usual"> 
	    <div class="itab">
		  	<ul> 
			    <li><a href="{actual_base_path}enterprise/ep_takeaway_order.jsp?_tabcode={this_tabcode}" tabcode="{gsep_constants.ORDER_STATE_WAIT_DELIVERY}" class="_tab_common">待派送</a></li>
			    <li><a href="{actual_base_path}enterprise/ep_takeaway_order.jsp?_tabcode={this_tabcode}" tabcode="{gsep_constants.ORDER_STATE_WAIT_ONLINE_PAY}" class="_tab_common">待支付</a></li>
			    <li><a href="{actual_base_path}enterprise/ep_takeaway_order.jsp?_tabcode={this_tabcode}" tabcode="{gsep_constants.ORDER_STATE_DELIVERYING}" class="_tab_common">派送中</a></li>
			    <li><a href="{actual_base_path}enterprise/ep_takeaway_order.jsp?_tabcode={this_tabcode}" tabcode="{gsep_constants.ORDER_STATE_SUCCESS_DELIVERY},{gsep_constants.ORDER_STATE_WAIT_USER_CHECK}" class="_tab_common">待(用户)确认</a></li>
			    <li><a href="{actual_base_path}enterprise/ep_takeaway_order.jsp?_tabcode={this_tabcode}" tabcode="{gsep_constants.ORDER_STATE_SUPP_CANCEL},{gsep_constants.ORDER_STATE_USER_CANCEL}" class="_tab_common">已取消</a></li>
			    <li><a href="{actual_base_path}enterprise/ep_takeaway_order.jsp?_tabcode={this_tabcode}" tabcode="{gsep_constants.ORDER_STATE_TOUT}" class="_tab_common">失效订单</a></li>
			    <li><a href="{actual_base_path}enterprise/ep_takeaway_order.jsp?_tabcode={this_tabcode}" tabcode="{gsep_constants.ORDER_STATE_DEAL}" class="_tab_common">交易完成</a></li>
		  	</ul>
	    </div>
    </div>
    
	<form id="_form_search_default">
		<input type="hidden" name="beanProxy.enable" value="0"/>
		<input type="hidden" id="_id_dish_type_value" name="beanProxy.dishType"/>
			
		<ul class="seachform" style="margin-top: 10px;">
			
			<li><label>订单编号</label><input name="beanProxy.id_Like" type="text" class="easyui-textbox _key_search" style="width:125px; height:32px; padding: 3px;"/></li>
			
			<li><label>下单人</label><input name="beanProxy.userNick_Like" type="text" class="easyui-textbox _key_search" style="width:125px; height:32px; padding: 3px;"/></li>
			
			<li><label>联系电话</label><input name="beanProxy.userTelphone_Like" type="text" class="easyui-textbox _key_search" style="width:125px; height:32px; padding: 3px;"/></li>
			
			<li>	
				<label>下单时间</label>
				<input name="beanProxy.addDatetime_GreaterThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" data-options="showSeconds:false,editable:true" style="width:125px; height:32px; padding: 3px;" />
				~ <input name="beanProxy.addDatetime_LessThanOrEqualTo" type="text" class="easyui-validatebox easyui-datetimebox" data-options="showSeconds:false,editable:true"  style="width:125px; height:32px; padding: 3px;"/>
			</li>
			
			<li>
				<label>排序方式</label>
				<select class="easyui-combobox" name="sort" style="width:100px; height:32px; padding: 3px;" data-options="panelHeight:'auto',editable:false">
					<option value="add_datetime desc">下单时间降序</option>
					<option value="add_datetime asc">下单时间升序</option>
					<option value="2">订单总额倒序</option>
					<option value="3">订单总额升序</option>
				</select>
			</li>
			
			<li><label>&nbsp;</label><input class="btn _class_search" name="" type="button" class="btn" value="查询"/></li>
		</ul>
	</form>
	
	<div style="clear: both;"></div>
	<div class="box"></div>
	
	<%@include file="common/common_datagrid.jsp" %>
	<%@include file="common/common_dialog.jsp" %>
	<%@include file="common/common_cache_dialog.jsp" %>
	
	
	
    </div>
	
</body>
</html>
