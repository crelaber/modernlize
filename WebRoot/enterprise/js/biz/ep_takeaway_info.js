$(function() {
	
	$('#_form_default').form({
		url : 'gdTakeAwayBasicConfExt_addOrUpdate.action',
		onBeforeLoad : function(param){
			$.messager.progress();
		},
		onLoadSuccess : function(data) {
			//加载完成之后才构建
			$.messager.progress("close");
		},
		onLoadError : function(data) {
			//加载完成之后才构建
			$.messager.progress("close");
			$.messager.alert('提示', "加载内容失败,请重新刷新页面/联系管理员", "error");
		},
		onSubmit : function(param) {
			if (!$(this).form("validate")) {
				$.messager.alert('提示', "提交的选项中,有错误内容,请检查", "error");
				return false;
			}
			$.messager.progress();
		},
		success : function(data) {	
			$.messager.progress("close");
			
			var jd = eval('(' + data + ')');
			if(!!!jd){
				$.messager.alert('提示', "未知异常");
				return false;
			}
			
			if (jd.state > 499) {
				$.messager.alert('提示', jd.message);
				//异常
			} else if (jd.state > 199) {
				//成功
				//parent.refreshDatagrid();
				//parent.closeWindow();
				//$.messager.alert('提示', '提交成功!');
				location.reload(true);
			} else if (jd.state > 0) {
				//失败
				$.messager.alert('提示', jd.message);
			}
		}
	});
	
	if(typeof _supp_id === "string" && _supp_id.length > 0){
		$("#_form_default").form('load', 'gdTakeAwayBasicConfExt_findByPk.action?record.id=' + _supp_id);
	}
	
	$("._class_submit").click(function(e){
		$('#_form_default').submit();
		e.preventDefault();
		e.stopPropagation();
		return false;
	});
});