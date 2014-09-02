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
<title>无标题文档</title>
<%@include file="common/common_head.jsp" %>
<!-- 引入EasyUI -->

<script type="text/javascript" src="<%=actualBasePath%>enterprise/js/jquery-ui-1.10.3.min.js"></script>
<script type="text/javascript" src="<%=actualBasePath%>enterprise/js/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="<%=actualBasePath%>enterprise/js/jquery.fileupload.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_upload_plugin.js"></script>

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_basic_info.js"></script>

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
	<form id="_form_default" method="post">
		<input type="hidden" name="record.logoImgAddr" id="up_icon_hide"/>
		<ul class="forminfo" id="content_content">
			<li>
				<label>营业状态</label>
				
				<select class="easyui-combobox" name="record.businessState"  style="width:35%; height:32px; padding: 3px;" data-options="panelHeight:'auto',editable:false">
					<option value="1">正常营业　</option>
					<option value="0">暂停营业　</option>
				</select>
				
				<i>如果"暂停营业"，用户将不能下单购买</i>
			</li>
			
			<li>
				<label>开启外卖</label>
				
				<select class="easyui-combobox" name="record.takeAwayState" style="width:35%; height:32px; padding: 3px;" data-options="panelHeight:'auto',editable:false">
					<option value="1">是</option>
					<option value="0">否</option>
				</select>
				
				<i>如果"暂停营业"，用户将不能下单购买</i>
			</li>
			
			<li>
				<label>开启订座</label>
				<div style="float: left; height: 42px;">
					<div style="float: left; margin-top: 12px;">
						<input type="radio" value="1" name="record.orderTableState"/><span>是&nbsp;</span> 
						<input type="radio" value="0" name="record.orderTableState"/><span>否&nbsp;</span> 
						<i>如果"暂停营业"，用户将不能下单购买</i>
					<div>
				</div>
			</li>
			
			
			<li>
				<label>开通在线支付</label>
				
				<select class="easyui-combobox" name="record.supportOnlinePay"  style="width:35%; height:32px; padding: 3px;" data-options="panelHeight:'auto',editable:false">
					<option value="1">是　</option>
					<option value="0">否　</option>
				</select>
				
				<i>(<span style="color: green;'">免费</span>)是否开通<a href="#" style="color: blue;">在线支付</a></i>
			</li>
			
			
			<li>
				<label>提供外卖发票</label>
				
				<select class="easyui-combobox" name="record.supprotTaInvoice"  style="width:35%; height:32px; padding: 3px;" data-options="panelHeight:'auto',editable:false">
					<option value="1">是　</option>
					<option value="0" selected="selected">否　</option>
				</select>
				
				<i>外卖发票只会在外卖栏目里面显示给用户</i>
			</li>
			
			
			<li>
				<label>提供消费发票</label>
				
				<select class="easyui-combobox" name="record.supprotInvoice"  style="width:35%; height:32px; padding: 3px;" data-options="panelHeight:'auto',editable:false">
					<option value="1">是　</option>
					<option value="0" selected="selected">否　</option>
				</select>
				
				<i>用户到店消费后，是否能提供发票</i>
			</li>
			
			<li>
				<label>所在城市</label>
				<input type="text" class="dfinput readonly" value="东莞市" readonly="readonly" name="record.cityName"/>
				<i>所在城市不能随意更改,需联系管理员</i>
			</li>
			
			<li>
				<label>店铺名称</label>
				<input name="record.suppName" type="text" class="easyui-textbox" data-options="required:true" style="width:35%;height:32px; padding: 3px;" data-options="prompt:'请输入店铺名称',iconCls:'icon-lock',iconWidth:38" />
				<i>标题不能超过30个字符</i>
			</li>
			
			
			<li><label>营业时间</label><input name="record.suppBusinessTime" type="text" class="easyui-validatebox easyui-textbox" data-options="required:true" style="width:35%;height:32px; padding: 3px;"/><i>如:全年无休，08:00~21:00</i></li>
			<li><label>联系人</label><input name="record.contactName" type="text" class="easyui-validatebox  easyui-textbox" data-options="required:true" style="width:35%;height:32px; padding: 3px;"/><i>多个关键字用,隔开</i></li>
			<li><label>联系电话</label><input name="record.contactMobile" type="text" class="easyui-validatebox easyui-numberbox "  data-options="required:true" style="width:35%;height:32px; padding: 3px;"/></li>
			<li><label>订餐电话</label><input name="record.orderTelphone" type="text" class="easyui-validatebox easyui-numberbox "  data-options="required:true" style="width:35%;height:32px; padding: 3px;"/></li>
			<li><label>店铺地址</label><input name="record.orderAddr" type="text" class="easyui-validatebox easyui-textbox"  data-options="required:true" style="width:35%;height:32px; padding: 3px;"/></li>
			
			
			<li>
				<label>店铺LOGO</label>
				<div class="up_icon_wrap">
					<div class="up_icon_loading_wrap" id="up_icon_loading_wrap">
						<img src="<%=actualBasePath %>auth/img/loading.gif" class="up_icon_loading" id="up_icon_loading" style="display: none;">
					</div>
					
					<div class="up_icon_btn_wrap">
						<a class="btn-fw btn-green up_icon_link" id="up_icon_link">
						  <span id="up_icon_txt" class="up_icon_txt">上传图片</span>
						  <input type="file" name="files" id="up_icon_file" class="up_icon_file">
						</a>
					</div>
				</div>
			</li>
			
			<li><label>店铺基本介绍</label>
				<input class="easyui-textbox" name="record.suppDes"  data-options="multiline:true" style="width:50%;height:100px"/>
			</li>
			
			<li><label>&nbsp;</label><input class="btn _class_submit" name="" type="button" class="btn" value="确认保存"/></li>
		</ul>
	</form>
	
    </div>
	
</body>
</html>
