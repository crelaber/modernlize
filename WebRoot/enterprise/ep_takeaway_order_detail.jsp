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
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_takeaway_order_detail.js"></script>

<style>
._info_table{BORDER-COLLAPSE: collapse;line-height: 25px;width: 100%;border: 1px solid #ccc;}
._info_table td{border: 1px solid #ccc; padding: 4px;}
._info_table th{border: 1px solid #ccc; font-weight:normal; padding: 4px; width: 80px; background-color: #eee;}
h3{padding: 5px;}
</style>
</head>

<body>
	
	<div class="">

		<div class="tools hide">
		
			<ul class="toolbar">
				<li class="click _class_btn_add auto-ajax" 
					data_options="validate:_cancelOrderValidate" 
					url="<%=actualBasePath %>/gdTakeAwayOrderExt_cancelOrderBySupp.action?orderId=${param.id}&cancelRemark=" 
					auto_type="prompt" 
					message = "您确定要取消此订单吗？并且此订单，如果已经支付，那么钱就会自动退回到用户账户。是否继续？并输入你的取消理由(15个字以内)。" 
					success="location.reload(true);parent.doRefreshDatagrid();"
					fail = "$.messager.alert('提示', data.message, 'error');">取消订单</li>
			</ul>
			
			<!-- <ul class="toolbar1">
				<li><span><img src="images/t05.png" /></span>设置</li> 
			</ul>-->
		
		</div>
		
		<div>
			
			<h3>订单详细</h3>
			
			<form id="_form_default" enctype="multipart/form-data" method="post">
				<input type="hidden" name="record.id" value="${param.id}"/>
			</form>
			
			<table class="_info_table" cellSpacing=0  align=center >
				<tr>
					<th>订单编号</th>
					<td colspan="3" id="_id_etxt_id"></td>
				</tr>
				
				<tr>
					<th>送货地址</th>
					<td colspan="3" id="_id_etxt_arrivedAddr"></td>
				</tr>
				
				<tr>
					<th>描述</th>
					<td colspan="3" id="_id_etxt_orderDes"></td>
				</tr>
				
				<tr>
					<th>发票抬头</th>
					<td colspan="3" id="_id_etxt_invoiceTitle"></td>
				</tr>
				
				<tr>
					<th>下单人</th>
					<td id="_id_etxt_userNick"></td>
					
					<th>联系电话</th>
					<td id="_id_etxt_userTelphone"></td>
				</tr>
				
				<tr>
					<th>订单总价</th>
					<td id="_id_etxt_totalPrice" data_options="formatter:_orderTotalPriceFormatter"></td>
					
					<th>下单时间</th>
					<td id="_id_etxt_orderDatetime"></td>
				</tr>
				
				<tr>
					<th>订单状态</th>
					<td id="_id_etxt_orderState" data_options="formatter:_orderStateFormatter"></td>
					
					<th>支付状态</th>
					<td id="_id_etxt_payState" data_options="formatter:_orderPayStateFormatter"></td>
				</tr>
				
			</table>
			
		</div>
		
		<br/>
		
		<div>		
			<h3>菜单列表</h3>
		</div>
		
		<%@include file="common/common_datagrid.jsp" %>
		<%@include file="common/common_dialog.jsp" %>
		<%@include file="common/common_cache_dialog.jsp" %>
	
    </div>
	
</body>
</html>
