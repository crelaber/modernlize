//namespace
var _ns_service = "gdTakeAwayOrderExt";
$(function() {
	
	var _datagrid_init_params = $.extend({},_datagrid_default_params,{
		url : actual_base_path + _ns_service + '_list.action?beanProxy.orderState_In=' + _tabcode,
		queryParams:{'beanProxy.enable':0,sort:'add_datetime desc'},
		columns : [ [
			{
				field : 'enable',
				title : '操作',
				width : 15,
				align : 'center',
				formatter : function(value, row, index) {
					var id = row.id;
					var orderState = row.orderState;
					
					/*var enter_self = $.createLink({
						content : '<img src="images/action_reply.png" />',
						attrs : {
							href:"#",
							"onClick":"openEditDailog(\'"+value+"\');"
						}
					});*/
					
					var result;
					switch (orderState) {
					case gsep_constants.ORDER_STATE_WAIT_DELIVERY:
						result = $.createLink({
							content : '开始派送',
							attrs : {
								href:"#",
								style:"color:blue;",
								"class":"auto-ajax",
								url: _ns_service + "_deliveryOrder.action?record.id=" + id,
								message : "你确定“开始派送”了吗？",
								success : "doRefreshDatagrid();",
								fail : "$.messager.alert('提示', data.message, 'error');"
							}
						});
						break;
					case gsep_constants.ORDER_STATE_DELIVERYING:
						//result = "派送中";
						result = $.createLink({
							content : '派送完成',
							attrs : {
								href:"#",
								style:"color:blue;",
								"class":"auto-ajax",
								url: _ns_service + "_deliveryCompleteOrder.action?record.id=" + id,
								message : "您确定此订单已“派送完成”了吗？",
								success : "doRefreshDatagrid();",
								fail : "$.messager.alert('提示', data.message, 'error');"
							}
						});
						break;
					case gsep_constants.ORDER_STATE_SUCCESS_DELIVERY:
						//result = "派送完成(待商家确认)";
						result = "无";
						break;
					case gsep_constants.ORDER_STATE_WAIT_USER_CHECK:
						//result = "派送完成(待用户确认)";
						result = "无";
						break;
					case gsep_constants.ORDER_STATE_DEAL:
						//result = "交易完成";
						//break;
					case gsep_constants.ORDER_STATE_SUPP_CANCEL:
						//result = "已取消(商家)";
						//break;
					case gsep_constants.ORDER_STATE_USER_CANCEL:
						//result = "已取消(用户)";
						//break;
					case gsep_constants.ORDER_STATE_USER_REFUNDING:
						//result = "已取消(申请退款中)";
						//break;
					case gsep_constants.ORDER_STATE_TOUT:
						//result = "已失效";
						//break;
					case gsep_constants.ORDER_STATE_CLOSE:
						//result = "已关闭";
						//break;
					default:
						result = "无";
						break;
					}
					
					return result;
				}
			},
			{
				field : 'id',
				title : '订单编号',
				align : 'right',
				width : 35,
				formatter: function(value,row,index){
					return $.createLink({
						content : value,
						attrs : {
							href:"#",
							style:"color:blue;",
							onClick:"openEditDailog('"+ value +"')"
						}
					});
				}
			},
			{
				field : 'userNick',
				title : '下单人',
				width : 20,
				align : 'left',
				formatter: function(value,row,index){
					if(!value || value.length < 1) return "未登陆用户";
					return value;
				}
			},
			{
				field : 'userTelphone',
				title : '联系电话',
				width : 22,
				align : 'center'
			},
			{
				field : 'totalPrice',
				title : '订单总金额',
				width : 20,
				align : 'right',
				formatter: function(value,row,index){
					return '<span style="color:red;">￥' + $.toFixedDecimal(value,1) + '</span>';
				}
			},
			{
				field : 'orderState',
				title : '订单状态',
				width : 30,
				align : 'left',
				formatter: function(value,row,index){
					var result;
					switch (value) {
					case gsep_constants.ORDER_STATE_WAIT_ONLINE_PAY:
						result = "已下单(待支付)";
						break;
					case gsep_constants.ORDER_STATE_WAIT_DELIVERY:
						result = "等待派送";
						break;
					case gsep_constants.ORDER_STATE_DELIVERYING:
						result = "派送中";
						break;
					case gsep_constants.ORDER_STATE_SUCCESS_DELIVERY:
						result = "派送完成(待商家确认)";
						break;
					case gsep_constants.ORDER_STATE_WAIT_USER_CHECK:
						result = "派送完成(待用户确认)";
						break;
					case gsep_constants.ORDER_STATE_DEAL:
						result = "交易完成";
						break;
					case gsep_constants.ORDER_STATE_SUPP_CANCEL:
						result = "已取消(商家)";
						break;
					case gsep_constants.ORDER_STATE_USER_CANCEL:
						result = "已取消(用户)";
						break;
					case gsep_constants.ORDER_STATE_USER_REFUNDING:
						result = "已取消(申请退款中)";
						break;
					case gsep_constants.ORDER_STATE_TOUT:
						result = "已失效";
						break;
					case gsep_constants.ORDER_STATE_CLOSE:
						result = "已关闭";
						break;
					default:
						result = "异常订单";
						break;
					}
					
					return result;
				}
			},
			{
				field : 'payState',
				title : '支付状态',
				width : 30,
				align : 'left',
				formatter: function(value,row,index){
					var result;
					switch (value) {
					case gsep_constants.ORDER_PAY_FACE:
						result = "货到付款";
						break;
					case gsep_constants.ORDER_PAY_ONLINE:
						result = "待支付";
						break;
					case gsep_constants.ORDER_PAY_ONLINE_SUCCESS:
						result = "已支付";
						break;
					case gsep_constants.ORDER_PAY_ONLINE_FAIL:
						result = "支付失败";
						break;
					default:
						result = "异常状态";
						break;
					}
					
					return result;
				}
			},
			{
				field : 'addDatetime',
				title : '下单时间',
				width : 35,
				align : 'center'
			}
			/*{
				field : 'userGsNumber',
				title : '与其交谈',
				width : 20,
				align : 'center',
				formatter : function(value, row, index) {
					var sbsp = "　";
					var enter_self = '<a href="#" onClick="openEditDailog(\''+value+'\');"><span class="websx_icon websx_icon_buddy"><span></a>';
					return enter_self;
				}
			}*/
			] ]
	});
	
	$("#"+gsep_constants.ID_DATAGRID_DEF).datagrid(_datagrid_init_params);
	
});

function _doSubmitFrameForm(){
	window.frames['_id_iframe']._onDefSubmit();
}

/**
* 打开编辑弹出框
**/
function openEditDailog(id){
	openAddDialog("ep_takeaway_order_detail.jsp?id=" + id, function() {
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