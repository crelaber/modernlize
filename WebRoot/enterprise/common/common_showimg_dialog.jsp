<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>	
<div class="easyui-dialog" id="epc_dialog_show_img" title="查看图片" style="width:800px; height:600px; max-width:800px; padding:10px" data-options="
		iconCls:'icon-save',
		onResize:function(){
			$(this).dialog('center');
		}">
	<img src="" id="epc_show_img"/>
</div>

<script>
	function _epcShowImg(url){
		$("#epc_dialog_show_img").dialog('open');
		$("#epc_show_img").attr("src",url);
		return false;
	}
	
	$(function(){
		$("#epc_dialog_show_img").dialog("close");	
	});
</script>

