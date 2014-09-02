var _ns_service = "gdTakeAwayAddrConfExt";

$(function() {
	var aj_ready = false;
	
	var _datagrid_init_params = $.extend({},_datagrid_default_params,{
		url : actual_base_path + _ns_service + '_list.action?beanProxy.id='+_supp_id+'&sort=update_datetime asc',
		queryParams:{'beanProxy.enable':0},
		onDblClickRow : function(rowIndex, rowData) {
			openEditDailog(rowData.id,rowData.areaId);
		},
		columns : [ [
				{
					field : 'areaName',
					title : '地区名称',
					width : 50,
					formatter: function(value,row,index){
						return value;
					}
				},
				{
					field : 'sendPrice',
					title : '起送价格',
					width : 30,
					align : 'right',
					formatter: function(value,row,index){
						var val = $.toFixedDecimal(value,1);
						if($.isNull(val)){
							return "价格有误";
						}
						return val + "￥";
					}
				},
				{
					field : 'servicePrice',
					title : '服务/送餐费',
					width : 30,
					align : 'right',
					formatter: function(value,row,index){
						var val = $.toFixedDecimal(value,1);
						if($.isNull(val)){
							return "价格有误";
						}
						return val + "￥";
					}
				},
				{
					field : 'deliveryTime',
					title : '预计送达分钟',
					width : 20,
					align : 'right',
					formatter: function(value,row,index){
						return value + "分钟";
					}
				},
				{
					field : 'senderMobile',
					title : '派送员手机号码',
					width : 60,
					align : 'left',
					formatter: function(value,row,index){
						if($.isNull(value)){
							return "未填写";
						}
						return value;
					}
				},
				{
					field : 'updateDatetime',
					title : '上次更新时间',
					width : 60,
					align : 'center'
				},
				{
					field : 'id',
					title : '操作',
					width : 20,
					align : 'center',
					formatter : function(value, row, index) {
						var sbsp = "　";
						var enter_self = $.createLink({
							content : '<img src="images/action_reply.png" />',
							attrs : {
								href:"#",
								onClick: "openEditDailog('" + value + "','" + row.areaId + "');",
							}
						});
						
						var del_self = $.createLink({
							content : '<img src="images/action_delete.png" />',
							attrs : {
								href:"#",
								"class":"auto-ajax",
								url: "gdTakeAwayAddrConfExt_drop.action?record.id=" + row.id + "&record.areaId=" + row.areaId ,
								message : "你确定要“删除”此条配置吗?",
								success : "doRefreshDatagrid();"
							}
						});
						
						return enter_self + sbsp + del_self;
					}
				} ] ]
	});
	
	$("#"+gsep_constants.ID_DATAGRID_DEF).datagrid(_datagrid_init_params);
	
	$("._class_btn_add").click(function(e) {
		
		//先检查菜品类型是否有值
		/*var dish_type_value = $.trim($("#_id_dish_type_value").val());
		if(dish_type_value.length < 1){
			$.messager.alert('错误','必须先选择(左边)菜品类型','error');
			return false;
		}*/
		
		openAddDialog("ep_takeaway_range_edit.jsp", function() {
			_doSubmitFrameForm();
		});
		e.preventDefault();
		e.stopPropagation();
		return false;
	});
	
});

function _doSubmitFrameForm(){
	window.frames['_id_iframe']._onDefSubmit();
}

/**
* 打开编辑弹出框
**/
function openEditDailog(id,id2){
	openAddDialog("ep_takeaway_range_edit.jsp?id=" + id + "&id2=" + id2, function() {
		_doSubmitFrameForm();
	});
}

function _doSubmitCacheFrameForm(){
	window.frames['_id_cache_iframe']._onDefSubmit();
}