$(function() {
	
	$("#_id_areaPid").val(_area_id);
	$("#_id_areaPname").val(_area_name);
	
	$('#_form_default').form({
		url : 'gdTakeAwayAddrConfExt_addOrUpdate.action',
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
				$.messager.alert('提示', "未知异常", "error");
				return false;
			}
			
			if (jd.state > 499) {
				$.messager.alert('提示', jd.message, "error");
				//异常
			} else if (jd.state > 199) {
				//成功
				//$.messager.alert('提示', '提交成功!');
				parent.doRefreshDatagrid();
				parent._doCloseDailog();
				
			} else if (jd.state > 0) {
				//失败
				$.messager.alert('提示', jd.message, "error");
			}
		}
	});
	
	if(!$.isNull(_param_id) && !$.isNull(_param_id2)){
		//并且让地区不可编辑
		$("#_id_areaId").combobox({readonly : true});
		//
		$("#_id_areaId_tip2").show();
		$("#_id_areaId_tip1").hide();
		//更新
		$("#_form_default").form('load', 'gdTakeAwayAddrConfExt_findByPk.action?record.id=' + _param_id + '&record.areaId=' + _param_id2);
	}
	
	$("._class_submit").click(function(e){
		_onDefSubmit();
		e.preventDefault();
		e.stopPropagation();
		return false;
	});
	
	
	//监听地区选择事件
	$("#_id_areaId").combobox({
		onSelect: function(record){
			$("#_id_areaName").val(record.text);
        }
	});
	
});

function _onDefSubmit(){
	$('#_form_default').submit();
}