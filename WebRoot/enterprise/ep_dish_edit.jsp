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

<script type="text/javascript" src="<%=actualBasePath%>enterprise/js/jquery-ui-1.10.3.min.js"></script>
<script type="text/javascript" src="<%=actualBasePath%>enterprise/js/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="<%=actualBasePath%>enterprise/js/jquery.fileupload.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_upload_plugin.js"></script>

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_dish_edit.js"></script>

</head>

<body>
	
	<form id="_form_default" enctype="multipart/form-data" method="post">
		<input type="hidden" name="record.id" value="${param.id}"/>
		<input type="hidden" name="record.typePid" id="_id_dish_ptype"/>
		<input type="hidden" name="record.typePname" id="_id_dish_type_pvalue"/>
		<input type="hidden" name="record.imgAddr1" id="up_icon_hide"/>
		
		<ul class="forminfo">
			<li>
				<label>菜品类型</label>
					<input id="_id_dish_type" type="text" class="easyui-validatebox dfinput" readonly="readonly" name="record.typeName" data-options="required:true"/>
					<span class="searchbox-button" id="_id_btn_sdtype" style="height: 32px;"></span>
					<input type="hidden" id="_id_dish_type_value" name="record.typeId"/>
				<i>请选择菜品的类型</i>
			</li>
			
			<li><label>菜品名称</label><input name="record.dishName" type="text" class="easyui-validatebox dfinput" data-options="required:true,validType:['unnormal','length[2,15]']"/><i>长度必须为2~15个字符</i></li>
			
			<li>
				<label>菜品单价</label>
				<input name="record.dishPrice" type="text" class="easyui-numberspinner" value="0.00" data-options="required:true,min:0,max:5000.0,precision:1,prefix:'￥'" style="width:35%;height:32px; padding: 3px;"/>
				<i>菜品的单价(最高可输入金额伍仟元)</i>
			</li>
			
			<li><label>菜品标签</label><input name="record.dishTag" id="_id_dish_tag" type="text" class="easyui-validatebox dfinput" data-options="required:true" /><i>中餐/西餐/四川菜 多个关键字用,隔开</i></li>
			
			<li><label>菜品描述</label><input class="easyui-textbox" name="record.dishDes"  data-options="multiline:true,required:true" style="width:50%;height:100px"/></li>
						
			<li>
				<label>菜品图片</label>
				
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
				
				<i style="position: relative; left: 66px;">支持图片格式类型jpg;png;最大2.0M</i>
				
			</li>
			
			<li><label>菜品状态</label>
				<select class="easyui-combobox" name="record.dishState" style="width:35%; height:32px; padding: 3px;" data-options="panelHeight:'auto',editable:false">
					<option value="1">上架</option>
					<option value="0">已下架</option>
				</select>
			</li>
			
			<li><label>是否推荐</label>
				<select class="easyui-combobox" name="record.top" style="width:35%; height:32px; padding: 3px;" data-options="panelHeight:'auto',editable:false">
					<option value="1">推荐</option>
					<option value="0" selected="selected">不推荐</option>
				</select>
			</li>
			
		</ul>
	</form>
	
	<%@include file="common/common_cache_dialog.jsp" %>
	
</body>

</html>
