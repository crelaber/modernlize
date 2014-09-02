<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div id="_id_dialog" class="easyui-dialog" style="width:90%; height:600px; overflow:auto; padding:10px 20px" closed="true" buttons="#dlg-buttons" data-options="modal: true,title: ' ',maximizable:true">
	<iframe id="_id_iframe" name="_id_iframe" runat="server" width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="auto" allowtransparency="yes"></iframe>
</div>

<div id="dlg-buttons" class="tools">
	
	<a href="javascript:void(0)" class="easyui-linkbutton"
		iconCls="icon-ok" onclick="_onDialogEnter();">提交</a>
		
	<a href="javascript:void(0)" class="easyui-linkbutton"
		iconCls="icon-cancel" onclick="_onDialogCancel();">关闭</a>

</div>