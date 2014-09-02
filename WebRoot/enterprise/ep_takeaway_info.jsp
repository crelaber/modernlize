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
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_takeaway_info.js"></script>

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">外卖基本配置</a></li>
    </ul>
    </div>
    
    <div class="formbody">

    <div class="formtitle"><span>外卖基本配置</span></div>
	<form id="_form_default" method="post">
		<ul class="forminfo">			
			
			<li>
				<label>起送价格(平均)</label>
				<input name="record.sendPrice" type="text" class="easyui-numberspinner dfinput" value="0.00" data-options="required:true,min:0,max:100000.0,precision:1,prefix:'￥'" style="width:125px; height:32px; padding: 3px;"/>
				<i>外卖起送价格(最高可输入金额十万元)</i>
			</li>
			
			<li>
				<label>配送费(平均)</label>
				<input name="record.servicePrice" type="text" class="easyui-numberspinner dfinput" value="0.00" data-options="required:true,min:0,max:500.0,precision:1,prefix:'￥'" style="width:125px; height:32px; padding: 3px;"/>
				<i>配送费最高可输入金额伍佰元)</i>
			</li>
			
			<li>
				<label>送达时间(平均)</label>
				<input name="record.deliveryTime" type="text" class="easyui-numberspinner dfinput" value="0" data-options="required:true,min:0,max:240,precision:0,suffix:'分钟'" style="width:125px; height:32px; padding: 3px;"/>
				<i>(单位分钟)最长时间为240分钟</i>
			</li>
			
			<li>
				<label>(周一)开放时间</label>
				<input name="record.startTime1" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/> ~
				<input name="record.endTime1" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/>
				<i>可以用手动输入时间,也可以用鼠标点击箭头快速输入</i>
			</li>
			
			<li>
				<label>(周二)开放时间</label>
				<input name="record.startTime2" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/> ~
				<input name="record.endTime2" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/>
				<i>如果不开放,则输入00:00 ~ 00:00</i>
			</li>
			
			<li>
				<label>(周三)开放时间</label>
				<input name="record.startTime3" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/> ~
				<input name="record.endTime3" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/>
			</li>
			
			<li>
				<label>(周四)开放时间</label>
				<input name="record.startTime4" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/> ~
				<input name="record.endTime4" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/>
			</li>
			
			<li>
				<label>(周五)开放时间</label>
				<input name="record.startTime5" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/> ~
				<input name="record.endTime5" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/>
			</li>
			
			<li>
				<label>(周六)开放时间</label>
				<input name="record.startTime6" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/> ~
				<input name="record.endTime6" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/>
			</li>
			
			<li>
				<label>(周日)开放时间</label>
				<input name="record.startTime7" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/> ~
				<input name="record.endTime7" type="text" class="easyui-timespinner" value="00:00" data-options="required:true,showSeconds:false" style="width:70px; height:32px; padding: 3px;"/>
			</li>
			
			<li>
				<label>外卖公告</label>
				<input class="easyui-textbox" name="record.orderNotice"  data-options="multiline:true,required:true" style="width:50%;height:100px"/>
				<i>0~50个字符,此公告开放给所有查看本店铺的用户</i>
			</li>
			
			<li><label>&nbsp;</label><input class="btn _class_submit" name="" type="button" class="btn" value="确认保存"/></li>
		</ul>
	</form>
	
    </div>
	
</body>
</html>
