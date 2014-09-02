/**
* 默认窗口关闭函数
*/
function _onDialogCancelDef(){
	$('#_id_dialog').dialog('close');
}
var _onDialogCancel = _onDialogCancelDef;

/**
* 默认窗口打开函数
*/
function _onDialogEnterDef(){
}
var _onDialogEnter = _onDialogEnterDef;


/**
* 默认窗口关闭函数
*/
function _onCacheDialogCancelDef(){
	$("#_id_cache_dialog").dialog("close");
}
var _onCacheDialogCancel = _onCacheDialogCancelDef;

/**
* 默认窗口打开函数
*/
function _onCacheDialogEnterDef(){
}
var _onCacheDialogEnter = _onCacheDialogEnterDef;



var _cacheCallbacks = {};

/**
 * 系统常量
 */
var gsep_constants = {};
window.gsep_constants = gsep_constants;

/**
 * 默认数据网格ID
 */
gsep_constants.ID_DATAGRID_DEF = "_id_datagrid_def";

/**
 * 货到付款
 */
gsep_constants.ORDER_PAY_FACE = 0;

/**
 * 等待在线支付
 */
gsep_constants.ORDER_PAY_ONLINE = 1;

/**
 * 在线支付成功
 */
gsep_constants.ORDER_PAY_ONLINE_SUCCESS = 2;

/**
 * 在线支付失败
 */
gsep_constants.ORDER_PAY_ONLINE_FAIL = 3;

/**
 * 已退款
 */
gsep_constants.ORDER_PAY_REFUND_SUCCESS = 4;

/** 
 * 等待在线支付 
 */
gsep_constants.ORDER_STATE_WAIT_ONLINE_PAY = 101;

/**
 * 等待派送
 */
gsep_constants.ORDER_STATE_WAIT_DELIVERY = 201;

/**
 * 正在派送中
 */
gsep_constants.ORDER_STATE_DELIVERYING = 202;

/**
 * 派送成功
 */
gsep_constants.ORDER_STATE_SUCCESS_DELIVERY = 203;

/**
 * 待用户确认 (确认后钱才会打到商家账户)
 */
gsep_constants.ORDER_STATE_WAIT_USER_CHECK = 204;

/**
 * 交易成功(用户确认，钱后自动打到商家账户，如果用户确认时间过期，钱也会自动打到商家账户)
 */
gsep_constants.ORDER_STATE_DEAL = 205;

/**
 * 已取消(商家) 取消订单（填写取消原因，跟着订单流程表走）
 */
gsep_constants.ORDER_STATE_SUPP_CANCEL = 251;

/**
 * 已取消(自己)取消订单（在商家确认钱可以取消订单，填写取消原因，跟着订单流程表走）
 */
gsep_constants.ORDER_STATE_USER_CANCEL = 252;

/**
 * 申请退款中(自己)
 */
gsep_constants.ORDER_STATE_USER_REFUNDING = 253;

/**
 * 订单失效（填写取消原因，跟着订单流程表走）
 */
gsep_constants.ORDER_STATE_TOUT = 261;

/**
 * 订单关闭（正常关闭）
 */
gsep_constants.ORDER_STATE_CLOSE = 262;

/**
 * 订单状态中文集合
 */
gsep_constants.ORDER_STATE_CN_MAPPING = {};
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_WAIT_ONLINE_PAY] = "等待在线支付";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_WAIT_DELIVERY] = "等待派送";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_DELIVERYING] = "正在派送中";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_SUCCESS_DELIVERY] = "派送成功";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_WAIT_USER_CHECK] = "待用户确认";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_DEAL] = "交易完成";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_USER_CANCEL] = "已取消(用户)";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_SUPP_CANCEL] = "已取消(商家)";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_USER_REFUNDING] = "申请退款中";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_TOUT] = "订单失效";
gsep_constants.ORDER_STATE_CN_MAPPING[gsep_constants.ORDER_STATE_CLOSE] = "正常关闭";


/**
 * 支付状态中文集合
 */
gsep_constants.ORDER_PAY_CN_MAPPING = {};

gsep_constants.ORDER_PAY_CN_MAPPING[gsep_constants.ORDER_PAY_FACE] = "货到付款";
gsep_constants.ORDER_PAY_CN_MAPPING[gsep_constants.ORDER_PAY_ONLINE] = "等待在线支付";
gsep_constants.ORDER_PAY_CN_MAPPING[gsep_constants.ORDER_PAY_ONLINE_SUCCESS] = "已支付";
gsep_constants.ORDER_PAY_CN_MAPPING[gsep_constants.ORDER_PAY_ONLINE_FAIL] = "在线支付失败";
gsep_constants.ORDER_PAY_CN_MAPPING[gsep_constants.ORDER_PAY_REFUND_SUCCESS] = "已退款";