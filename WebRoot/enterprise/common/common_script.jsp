<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
var _param_id = $.trim("${param.id}");
var _param_id2 = $.trim("${param.id2}");
var _callback_id = $.trim("${param._callback_id}");
var _tabcode = $.trim("${param._tabcode}");
var _supp_id = "testsuppler";
var _area_id = "ed5e827158984bc1acb64048de981af6";
var _area_name = "东莞市";
/*$(function(){
	$("#_supp_id").val(_supp_id);
});*/
var actual_base_path = "<%=actualBasePath %>";
</script>

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_common.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/biz/ep_common_summary.js"></script>