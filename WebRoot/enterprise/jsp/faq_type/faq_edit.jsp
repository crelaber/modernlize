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
<title>知识编辑页面</title>
<%@include file="../../common/common_head.jsp" %>
<script type="text/javascript" src="<%=actualBasePath%>enterprise/js/jquery-ui-1.10.3.min.js"></script>
<script type="text/javascript" src="<%=actualBasePath%>enterprise/js/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="<%=actualBasePath%>enterprise/js/jquery.fileupload.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_upload_plugin.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/jsp/faq_type/js/edit.js"></script>
</head>
<body>
	<form id="_form_default" enctype="multipart/form-data" method="post">
		<input type="hidden" name="record.id" value="${param.id}"/>
		<!--  <input type="hidden" name="record.typePid" id="_id_dish_ptype"/>
		<input type="hidden" name="record.typePname" id="_id_dish_type_pvalue"/>
		<input type="hidden" name="record.imgAddr1" id="up_icon_hide"/>-->
		<ul class="forminfo">
			<li>
				<label>知识类型</label>
					<input id="_id_dish_type" type="text" class="easyui-validatebox dfinput" readonly="readonly"  data-options="required:true"/>
					<span class="searchbox-button" id="_id_btn_sdtype" style="height: 32px;"></span>
					<input type="hidden" id="_id_dish_type_value" name="record.faqTypeId"/>
				<i>请选择知识的类型</i>
			</li>
			<li><label>问题</label><input class="easyui-textbox" name="record.question"  data-options="multiline:true,required:true" style="width:50%;height:100px"/></li>
			<li><label>答案</label><input class="easyui-textbox" name="record.answer"  data-options="multiline:true,required:true" style="width:50%;height:100px"/></li>		
			<li>
				<label>图片</label>
				<div class="up_icon_wrap">
					<div class="up_icon_loading_wrap" id="up_icon_loading_wrap">
						<img src="<%=actualBasePath %>auth/img/loading.gif" class="up_icon_loading" id="up_icon_loading" style="display: none;">
					</div>
					<div class="up_icon_btn_wrap">
						<a class="btn-fw btn-green up_icon_link" id="up_icon_link">
						  <span id="up_icon_txt" class="up_icon_txt" style="background-color: rgb(33, 41, 40);">上传图片</span>
						  <input type="file" name="files" id="up_icon_file" class="up_icon_file">
						</a>
					</div>
				</div>
				<i style="position: relative; left: 66px;">支持图片格式类型jpg;png;最大2.0M</i>
			</li>
			<li>
				<label>附件</label>
				<div class="up_icon_wrap">
					<div class="up_icon_loading_wrap" id="up_icon_loading_wrap">
						<img src="<%=actualBasePath %>auth/img/loading.gif" class="up_icon_loading" id="up_icon_loading" style="display: none;">
					</div>
					<div class="up_icon_btn_wrap">
						<a class="btn-fw btn-green up_icon_link" id="up_icon_link">
						  <span id="up_icon_txt" class="up_icon_txt" style="background-color: rgb(33, 41, 40);">上传附件</span>
						  <input type="file" name="files" id="up_icon_file" class="up_icon_file">
						</a>
					</div>
				</div>
				<i style="position: relative; left: 66px;">支持附件格式类型zip,rar;最大40.0M</i>
			</li>
			<li><label>生效时间</label>
				<input name="record.effectDatetime" type="text" class="easyui-validatebox easyui-datetimebox" style="width:125px; height:32px; padding: 3px;" data-options="showSeconds:false,editable:true"  />
				<i>默认当前时间</i>
			</li>
			<li><label>失效时间</label>
				<input name="record.invalidDatetime" type="text" class="easyui-validatebox easyui-datetimebox" style="width:125px; height:32px; padding: 3px;" data-options="showSeconds:false,editable:true"  />
				<i>默认为空 表示永不失效</i>
			</li>
		</ul>
	</form>
	<%@include file="../../common/common_cache_dialog.jsp" %>
</body>
</html>
