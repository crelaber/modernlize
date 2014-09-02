function initOther(){
	//初始化时间
	if(_param_id.length > 0){
		//更新
		$("#_form_default").form('load', 'gdMealsDishExt_findByPk.action?record.id=' + _param_id);
	}else{
		//拿出原本设置好的菜品类型
		_doChangeDishType(parent._getDishType(),parent._getDishPType());
	}
	
	$("._class_submit").click(function(e){
		$('#_form_default').submit();
		e.preventDefault();
		e.stopPropagation();
		return false;
	});
	
	$("#_id_btn_sdtype").click(function(e) {
		openDishTypeQuery();
	});
	
	$("#_id_dish_type").click(function(e) {
		openDishTypeQuery();
	});
}
function initFroms(){
	$('#_form_default').form({
		url : 'urFaqExt_addOrUpdate.action',
		onBeforeLoad : function(param){
			$.messager.progress();
		},
		onLoadSuccess : function(data) {
			//显示图片
			$.ep_upload_plugin.initUploadImg("up_icon");
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
}

function _onDefSubmit(){
	$('#_form_default').submit();
}

/**
 * 类型更改触发
 * @param node
 */
function _doChangeDishType(node,parentNode){
	//alert(node);
	$("#_id_dish_type").val(node.text);
	var _id_dish_tag_val = $.trim($("#_id_dish_tag").val());
	//设置标签
	if(typeof _id_dish_tag_val != "string" || _id_dish_tag_val.length < 1){
		$("#_id_dish_tag").val(node.text);
	}
	$("#_id_dish_type_value").val(node.id);
	
	//设置父类型名称 和 父类型ID
	$("#_id_dish_ptype").val(parentNode.text);
	$("#_id_dish_type_pvalue").val(parentNode.id);
	
}

/**
 * 清空菜单类型
 */
function _doClearDishType(){
	$("#_id_dish_type").val("");
	$("#_id_dish_type").validatebox("validate");
	$("#_id_dish_type_value").val("");
	
	//设置父类型名称 和 父类型ID
	$("#_id_dish_ptype").val("");
	$("#_id_dish_type_pvalue").val("");
}

/**
* 打开编辑弹出框
**/
function openDishTypeQuery(id){
	parent._cacheCallbacks['ep_dish_manage_1'] = {
		onSelect : function(node,parentNode){
			_doChangeDishType(node,parentNode);
		},
		onCancel : function(){
			
		}
	}; 
	parent._openCacheDailog("faq_type_query.jsp?_callback_id=ep_dish_manage_1&id=" + id, function() {
		//_doSubmitCacheFrameForm();
	});
}

$(function() {
	initOther();
	initFroms();
});