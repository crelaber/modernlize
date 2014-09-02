function doRefreshDatagrid() {
	$('#_id_datagrid_def').datagrid('reload');
}

function setQueryParams(array) {
	var queryParams = $.arrayToObj(array, 'name', 'value');
	// 把查询条件拼接成JSON
	// $.fn.buildpage.methods['arrayToObj'](array,'name','value') || {};
	$('#_id_datagrid_def').datagrid('options').queryParams = queryParams; // 把查询条件赋值给datagrid内部变量
}

function doSearch() {
	var array = $("#_form_search_default").serializeArray();
	setQueryParams(array);
	doRefreshDatagrid(); // 重新加载
}

/**
 * 打开窗口
 */
function openAddDialog(src, onEnter, onCancel) {
	$("#_id_iframe").attr("src", src);
	$("#_id_dialog").dialog("open");

	if (typeof onEnter === "function") {
		_onDialogEnter = onEnter;
	} else {
		_onDialogEnter = _onDialogEnterDef;
	}

	if (typeof onCancel === "function") {
		_onDialogCancel = onCancel;
	} else {
		_onDialogCancel = _onDialogCancelDef;
	}
}

function _doCloseDailog(){
	$("#_id_dialog").dialog("close");
	$("#_id_iframe").attr("src", "");
}


var _cache_dailog_init = false;
function _openCacheDailog(src, onEnter, onCancel) {
	if(_cache_dailog_init){
		$("#_id_cache_dialog").dialog("open");
	}else{
		$("#_id_cache_iframe").attr("src", src);
		$("#_id_cache_dialog").dialog("open");
		
		if (typeof onEnter === "function") {
			_onCacheDialogEnter = onEnter;
		} else {
			_onCacheDialogEnter = _onCacheDialogEnterDef;
		}
		
		if (typeof onCancel === "function") {
			_onCacheDialogCancel = onCancel;
		} else {
			_onCacheDialogCancel = _onCacheDialogCancelDef;
		}
		_cache_dailog_init = true;
	}
}

function _doCloseCacheDailog(){
	$("#_id_cache_dialog").dialog("close");
	//$("#_id_cache_iframe").attr("src", "");
};


var _datagrid_aj_ready = false;
var _datagrid_default_params = {
	fitColumns : true,
	rownumbers : true,
	singleSelect : true,
	pagination : true,
	pageList : [ 25, 50, 100, 200, 500, 1000 ],
	title: "数据列表",
	view: _common_datagrid_view,
	emptyMsg: '没有搜索到相关记录',
	height:450,
	onLoadSuccess : function(data) {
		if (!!!_datagrid_aj_ready) {
			$.autoajax(".datagrid-body", ".auto-ajax");
			_datagrid_aj_ready = true;
		}
		
		/*if(!!!data.total || data.total <=0){
			$('#_id_datagrid_def').datagrid('appendRow',{
				userNick : '没有相关记录'
			});
		}*/
		
	},
	onDblClickRow : function(rowIndex, rowData) {
		openEditDailog(rowData.id);
	},
	queryParams:{'beanProxy.enable':0}
};

$(function(){
	$("._class_search").click(function(e) {
		doSearch();
		e.preventDefault();
		e.stopPropagation();
		return false;
	});
	
	$("._key_search").on("keypress",function(e) {
		switch (e.which) {
		case 13:
			doSearch();
			e.preventDefault();
			e.stopPropagation();
			return true;
		}
	});
	
	$(".easyui-combobox._combobox_search").combobox({
		onSelect:function(rec){
			doSearch();
		}
	});
	
	/**
	 * 监听通用事件
	 */
	//$(document).keypress(function(e) {
		/*switch (e.which) {
		// user presses the "a"  
		case 97:
			showViaKeypress("#home");
			break;

		// user presses the "s" key  
		case 115:
			showViaKeypress("#about");
			break;

		// user presses the "d" key  
		case 100:
			showViaKeypress("#contact");
			break;

		// user presses the "f" key  
		case 102:
			showViaKeypress("#awards");
			break;

		// user presses the "g" key   
		case 103:
			showViaKeypress("#links");
		}*/
	//});
	
});