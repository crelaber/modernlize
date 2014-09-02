//namespace
var _ns_service = "gdTakeAwayOrderDetailExt";
$(function() {
	
	var _datagrid_init_params = $.extend({},_datagrid_default_params,{
		url : actual_base_path + _ns_service + '_listExt.action?beanProxy.orderId=' + _param_id,
		queryParams:{'beanProxy.enable':0,sort:'add_datetime desc'},
		columns : [ [
			{
				field : 'dishName',
				title : '菜名',
				width : 15,
				align : 'left',
				formatter: function(value,row,index){
					if(!value || value.length < 1) return "获取失败";
					return value;
				}
			},
			{
				field : 'num',
				title : '数量',
				width : 5,
				align : 'right'
			},
			{
				field : 'price',
				title : '单价',
				width : 7,
				align : 'right',
				formatter: function(value,row,index){
					return '<span style="color:green;">￥' + $.toFixedDecimal(value,1) + '</span>';
				}
			},
			{
				field : 'totalPrice',
				title : '总价',
				width : 10,
				align : 'right',
				formatter: function(value,row,index){
					return '<span style="color:red;">￥' + $.toFixedDecimal(value,1) + '</span>';
				}
			},
			{
				field : 'mark',
				title : '备注',
				width : 20,
				align : 'left',
				formatter: function(value,row,index){
					if(!value || value.length < 1) return "无";
					return value;
				}
			}
			] ]
	});
	
	$("#"+gsep_constants.ID_DATAGRID_DEF).datagrid(_datagrid_init_params);
	
	
	
	$('#_form_default').form({
		onBeforeLoad : function(param){
			$.messager.progress();
		},
		onLoadSuccess : function(data) {
			//加载完成之后才构建
			$.messager.progress("close");
			//遍历遍历
			for(var key in data){
				if(!!!key){
					continue;
				}
				var _tempObj = $("#_id_etxt_"+key);
				if(_tempObj.size() > 0){
					//获取data_options
					var dataOptionsStr = _tempObj.attr("data_options");
					if($.isNotNull(dataOptionsStr)){
						var dataOptions = eval("("+"{" + dataOptionsStr + "}"+")");
						if(dataOptions['formatter'] instanceof Function){
							_tempObj.html(dataOptions['formatter'](data[key],data));
							continue;
						}
					}
					_tempObj.html(data[key] || "无");
				}
			}
			
			//判断订单状态
			if(gsep_constants.ORDER_STATE_WAIT_ONLINE_PAY == data.orderState
				|| gsep_constants.ORDER_STATE_WAIT_DELIVERY == data.orderState
				|| gsep_constants.ORDER_STATE_DELIVERYING == data.orderState
				|| gsep_constants.ORDER_STATE_SUCCESS_DELIVERY == data.orderState
				|| gsep_constants.ORDER_STATE_WAIT_USER_CHECK == data.orderState ){
				$(".tools").show();
			}
		},
		onLoadError : function(data) {
			//加载完成之后才构建
			$.messager.progress("close");
			$.messager.alert('提示', "加载内容失败,请重新刷新页面/联系管理员", "error");
		}
	});
	
	//加载数据
	if($.isNotNull(_param_id)){
		//并且让地区不可编辑
		//更新
		$("#_form_default").form('load', 'gdTakeAwayOrderExt_findByPk.action?prefix=&record.id=' + _param_id);
	}
	
});

function _orderStateFormatter(value,data){
	return gsep_constants.ORDER_STATE_CN_MAPPING[value];
}

function _orderPayStateFormatter(value,data){
	return gsep_constants.ORDER_PAY_CN_MAPPING[value];
}

function _orderTotalPriceFormatter(value,data){
	return '<span style="color:red;">￥' + $.toFixedDecimal(value,1) + '</span>';
}
					
function _cancelOrderValidate(value){
	if($.isNull(value)){
		$.messager.alert('提示','退款原因的内容文本长度应该为1-15位之间!','error');
		return false;
	}
	
	if(value.length > 15 || value.length < 1){
		$.messager.alert('提示','退款原因的内容文本长度应该为1-15位之间!','error');
		return false;
	}
	
	return true;
}