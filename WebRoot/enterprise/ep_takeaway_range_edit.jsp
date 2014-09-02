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
<title>菜品编辑页面</title>

<%@include file="common/common_head.jsp" %>

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_takeaway_range_edit.js"></script>

</head>

<body>
	
	<form id="_form_default" enctype="multipart/form-data" method="post">
		<input type="hidden" name="record.id" value="${param.id}"/>
		<input type="hidden" name="record.areaName" id="_id_areaName"/>
		<input type="hidden" name="record.areaPid" id="_id_areaPid"/>
		<input type="hidden" name="record.areaPname" id="_id_areaPname"/>
		<ul class="forminfo">
			<li>
				<label>派送地区</label>
				<select name="record.areaId" class="easyui-combobox" id="_id_areaId" style="width:200px;" data-options="method:'get', valueField:'id', textField:'text',url:'<%=actualBasePath %>enterprise/data/cache/subarea/ed5e827158984bc1acb64048de981af6.js',editable:false"></select>
				<i id="_id_areaId_tip1" >请设置派送地区</i>
				<i id="_id_areaId_tip2" style="color:red;display:none;">派送地区不能修改</i>
			</li>
			
			<li>
				<label>起送价格</label>
				<input name="record.sendPrice" type="text" class="easyui-numberspinner dfinput" value="0.00" data-options="required:true,min:0,max:100000.0,precision:1,prefix:'￥'"/>
				<i>外卖起送价格(最高可输入金额十万元)</i>
			</li>
			
			<li>
				<label>配送费</label>
				<input name="record.servicePrice" type="text" class="easyui-numberspinner dfinput" value="0.00" data-options="required:true,min:0,max:500.0,precision:1,prefix:'￥'"/>
				<i>配送费最高可输入金额伍佰元)</i>
			</li>
			
			<li>
				<label>预计送达时间</label>
				<input name="record.deliveryTime" type="text" class="easyui-numberspinner dfinput" value="0" data-options="required:true,min:0,max:240,precision:0,suffix:'分钟'"/>
				<i>(单位分钟)最长时间为240分钟</i>
			</li>
			
			<li>
				<label>派送员手机号码</label>
				<input name="record.senderMobile" type="text" class="easyui-validatebox dfinput" data-options="validType:['mobile']"/>
				<i>如:13512345678</i>
			</li>
			
			<li>
				<label>显示顺序</label>
				<input name="record.sort" type="text" class="easyui-numberspinner dfinput" value="0" data-options="required:true,min:0,max:99999,precision:0" />
				<i>显示顺序</i>
			</li>
			
		</ul>
	</form>
	
	<%@include file="common/common_cache_dialog.jsp" %>
	
</body>

</html>
