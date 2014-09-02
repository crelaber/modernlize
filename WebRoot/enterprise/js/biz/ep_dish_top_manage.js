//$(".auto-ajax",window.frames["rightFrame"].document);

$(function() {
	var aj_ready = false;
	
	$('#_id_datagrid_def').datagrid({
		url : actual_base_path + 'gdMealsDishExt_list.action?suppId='+_supp_id+'&beanProxy.top=1&sort=update_datetime asc',
		fitColumns : true,
		rownumbers : true,
		singleSelect : true,
		pagination : true,
		pageList : [ 25, 50, 100, 200, 500, 1000 ],
		columns : [ [
				{
					field : 'dishName',
					title : '菜品名称',
					width : 50,
					formatter: function(value,row,index){
						return value;
					}
				},
				{
					field : 'typeName',
					title : '菜品类型',
					width : 30,
					align : 'left',
					formatter: function(value,row,index){
						if(!value || value.length < 1) return "未登陆用户";
						return value;
					}
				},
				{
					field : 'dishPrice',
					title : '菜品价格',
					width : 50,
					align : 'right',
					formatter: function(value,row,index){
						var val = value || "0.0";
						if(value && value.length > 45){
							val = value.substr(0,45) + '..';
						}
						return '<span title="'+val+'">'+val+'</span>';
					}
				},
				{
					field : 'dishTag',
					title : '标签',
					width : 50,
					align : 'left',
					formatter: function(value,row,index){
						return value;
					}
				},
				{
					field : 'updateDatetime',
					title : '修改时间',
					width : 60,
					align : 'center'
				},
				{
					field : 'dishState',
					title : '状态',
					width : 40,
					align : 'center',
					formatter: function(value,row,index){
						if(0 == value){
							return "已下架";
						}else if(1 == value){
							return "上架";
						}else if(2 == value){
							return "审核未通过";
						}
						return value;
					}
				},
				{
					field : 'id',
					title : '操作',
					width : 20,
					align : 'center',
					formatter : function(value, row, index) {
						var enter_self = $.createLink({
							content : '<img src="images/action_delete.png" />',
							attrs : {
								href:"#",
								"class":"auto-ajax",
								url: "gdMealsDishExt_addOrUpdate.action?record.id=" + row.id + "&record.top=0",
								message : "你确定要“取消”推荐吗？”注意：不会删除此菜品记录“",
								success : "doRefreshDatagrid();"
							}
						});
						
						return enter_self;
					}
				} ] ]
		,onLoadSuccess : function(data) {
			if (!aj_ready) {
				$.autoajax(".datagrid-body", ".auto-ajax");
				aj_ready = true;
			}
		}
		,onDblClickRow : function(rowIndex, rowData) {
			//openEditDailog(rowData.id);
		}
		,queryParams:{'beanProxy.enable':0}
	});
	
	
	$("._class_btn_add").click(function(e) {
		
		//先检查菜品类型是否有值
		/*var dish_type_value = $.trim($("#_id_dish_type_value").val());
		if(dish_type_value.length < 1){
			$.messager.alert('错误','必须先选择(左边)菜品类型','error');
			return false;
		}*/
		
		openAddDialog("ep_dish_type_edit.jsp", function() {
			_doSubmitFrameForm();
		});
		e.preventDefault();
		e.stopPropagation();
		return false;
	});
	
	$("#_id_btn_sdtype").click(function(e) {
		openCacheDailog();
	});
	
	$("#_id_dish_type").click(function(e) {
		openCacheDailog();
	});
	
	$("#_id_btn_rem_dtype").click(function(e) {
		_doClearDishType();
	});
	
});

function _doSubmitFrameForm(){
	window.frames['_id_iframe']._onDefSubmit();
}

/**
* 打开编辑弹出框
**/
function openEditDailog(id){
	openAddDialog("ep_dish_type_edit.jsp?id=" + id, function() {
		_doSubmitFrameForm();
	});
}

function _doSubmitCacheFrameForm(){
	window.frames['_id_cache_iframe']._onDefSubmit();
}

/**
* 打开编辑弹出框
**/
function openCacheDailog(id){
	
	_cacheCallbacks['ep_dish_manage_1'] = {
		onSelect : function(node){
			_doChangeDishType(node);
		},
		onCancel : function(){
			
		}
	}; 
	_openCacheDailog("ep_dish_type_query.jsp?_callback_id=ep_dish_manage_1&id=" + id, function() {
		//_doSubmitCacheFrameForm();
	});
}

/**
 * 类型更改触发
 * @param node
 */
function _doChangeDishType(node){
	//alert(node);
	$("#_id_dish_type").val(node.text);
	$("#_id_dish_type_value").val(node.id);
}

/**
 * 清空菜单类型
 */
function _doClearDishType(){
	$("#_id_dish_type").val("");
	$("#_id_dish_type_value").val("");
}

/**
 * 得到菜单类型
 * @returns {___anonymous4259_4353}
 */
function _getDishType(){
	return {
		id:$.trim($("#_id_dish_type_value").val()),
		text:$.trim($("#_id_dish_type").val())
	};
}