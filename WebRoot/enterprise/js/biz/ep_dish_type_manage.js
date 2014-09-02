$(function() {
	var aj_ready = false;
	
	$('#_id_datagrid_def').datagrid({
		url : actual_base_path + 'manageSuppExt_list.action?sort=update_datetime asc',
		fitColumns : true,
		rownumbers : true,
		singleSelect : true,
		pagination : true,
		pageList : [ 25, 50, 100, 200, 500, 1000 ],
		columns : [ [
				{
					field : 'fdSuppName',
					title : '商家名称',
					width : 50,
					formatter: function(value,row,index){
						return value;
					}
				},
				{
					field : 'fdPersonNick',
					title : '提交人',
					width : 30,
					align : 'center',
					formatter: function(value,row,index){
						if(!value || value.length < 1) return "未登陆用户";
						return value;
					}
				},
				{
					field : 'reason',
					title : '申请理由',
					width : 200,
					align : 'left',
					formatter: function(value,row,index){
						var val = value;
						if(value && value.length > 45){
							val = value.substr(0,45) + '..';
						}
						return '<span title="'+val+'">'+val+'</span>';
					}
				},
				{
					field : 'contact',
					title : '联系方式',
					width : 50,
					align : 'left',
					formatter: function(value,row,index){
						return value;
					}
				},
				{
					field : 'updateDatetime',
					title : '提交时间',
					width : 60,
					align : 'center'
				},
				{
					field : 'enable',
					title : '状态',
					width : 40,
					align : 'center',
					formatter: function(value,row,index){
						if(0 == value){
							return "待审核";
						}else if(1 == value){
							return "作废";
						}else if(2 == value){
							return "审核通过";
						}else if(3 == value){
							return "审核不通过";
						}
						return value;
					}
				},
				{
					field : 'id',
					title : '操作',
					width : 80,
					align : 'center',
					formatter : function(value, row, index) {
						value = row.id;
						var sbsp = "　";
						var enter_self = '<a href="#" onClick="openEditDailog(\''+value+'\');"><img src="images/action_reply.png" /></a>';
								
						var del_self = '<a href="#" class="auto-ajax" url="manageSuppExt_adminApplyFail.action?record.id='
								+ value
								+ '" message="你确定要删除这条记录吗?" success="alert(data.message);refreshDatagrid();"><img src="images/action_delete.png" /></a>';
						
						if(row.enable == 0){
							return enter_self + sbsp + del_self;
						}
						return '无';
					}
				} ] ]
		,onLoadSuccess : function(data) {
			if (!aj_ready) {
				$.autoajax(".datagrid-body", ".auto-ajax");
				aj_ready = true;
			}
		}
		,onDblClickRow : function(rowIndex, rowData) {
			openEditDailog(rowData.id);
		}
		,queryParams:{'beanProxy.enable':0}
	});
	
	
	$("._class_btn_add").click(function(e) {
		openAddDialog("ep_dish_type_edit.jsp", function() {
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
function openEditDailog(id){
	openAddDialog("ep_dish_type_edit.jsp?id=" + id, function() {
		_doSubmitFrameForm();
	});
}