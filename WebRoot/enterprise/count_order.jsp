<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String actualBasePath = basePath;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<script language="javascript" type="text/javascript" src="<%=actualBasePath %>/enterprise/js/Chart.min.js"></script>

<%@include file="common/easyui.jsp" %>

<script type="text/javascript" src="<%=actualBasePath %>/enterprise/js/modernizr.min.js"></script>

<link href="<%=actualBasePath %>/enterprise/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=actualBasePath %>/js/json2.min.js"></script>


<!--[if lte IE 8]>
	<script type="text/javascript" src="<%=actualBasePath %>/enterprise/excanvas.js"></script>
<![endif]-->
	
<script>
var actual_base_path = "<%=actualBasePath %>";

$(function(){
	$("#_str_start_time").datebox({
		current:new Date() - 3600 * 24 * 30
	});
	
	$("#_str_end_time").datebox({
		current:new Date()
	});
		
	$("._class_search").click(function(){
		queryReport();
		return false;
	});
	
	$("._class_search").click();
});

var queryReport = function(){

	var url = actual_base_path + "gdSupplerBasicConfExt_orderReportByMonth";
	
	var formData = {};
	formData['_str_start_time'] = $("#_str_start_time").datebox('getValue');
	formData['_str_end_time'] = $("#_str_end_time").datebox('getValue');
	
	$.post(url,formData,function(jd){
		if(!!!jd){
			alert("未知异常");
			return false;
		}
		
		if (jd.state > 499) {
			alert(jd.message);
			$("#submit_btn").removeClass("disabled");
			//异常
		} else if (jd.state > 199) {
			//成功
			//$.messager.alert('提示', '提交成功!');
			//跳转到新的页面
			//location.href= _actualBasePath + "auth/auth.jsp";
			//alert(jd);
			var data = jd.data;
			for(var key in data){
				if("reports" == key || key == "labels"){
					continue;
				}
				var val = data[key];
				$("#span_" + key).html(val);
			}
			
			var reports = data['reports'];
			var labels = data['labels'];
			
			var charData = {
				labels : labels,
				datasets : [
					{
						fillColor : "rgba(220,220,220,0.5)",
						strokeColor : "rgba(220,220,220,1)",
						pointColor : "rgba(220,220,220,1)",
						pointStrokeColor : "#fff",
						data : reports
					}/*,
					{
						fillColor : "rgba(151,187,205,0.5)",
						strokeColor : "rgba(151,187,205,1)",
						pointColor : "rgba(151,187,205,1)",
						pointStrokeColor : "#fff",
						data : [28,48,40,19,96,27,100]
					}*/
				]
			};
			
			
			
			console.log("reports:" + JSON.stringify(reports));
			console.log("labels:" + JSON.stringify(labels));
			
			if(!!charData){
				var ctx = document.getElementById("introChart").getContext("2d");
				var globalGraphSettings = {animation : Modernizr.canvas};
				
				var options = {animation: Modernizr.canvas, scaleShowLabels : false, scaleFontColor : "#767C8D"};
				
				new Chart(ctx).Line(charData,options);
				
				/*$.jqplot('order_plot',  [reports], {
					title:'订单统计',
					//axes:{yaxis:{min:0, max:100}},
					//series:[{color:'#5FAB78'}],
					axesDefaults: {
						tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
						tickOptions: {
						  angle: -30,
						  fontSize: '10pt'
						}
					},
					axes: {
					  xaxis: {
						renderer: $.jqplot.CategoryAxisRenderer
					  }
					}
				});*/
			}
						
		} else if (jd.state > 0) {
			alert(jd.message);
			$("#submit_btn").removeClass("disabled");
		}
		
	},"JSON");

}

/*

result.put("balance", accountResult.getBalance());
result.put("turnover_today", todayTurnover);
result.put("ta_order_num_today", todayTaOrderNum);
result.put("ta_order_num", taOrderNum);
result.put("meals_dish_num", mealsDishNum);
*/
</script>

<style>
table._table{width:100%;}
table._table th,td{line-height:25px;}
th._th{width:120px;text-align:right;}
td._td{text-indent:1em;}
</style>

</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>
				<a href="#">订单统计</a>
			</li>
		</ul>
	</div>

	<div class="mainindex">

		<div class="uimakerinfo">
			<b>订单统计</b>
			
			<span>
				<input name="_str_start_time" id="_str_start_time" type="text" class="easyui-validatebox easyui-datebox" style="width:125px; height:32px; padding: 3px;" data-options="showSeconds:false,editable:false"  />
				~ <input name="_str_end_time" id="_str_end_time"  type="text" class="easyui-validatebox easyui-datebox" style="width:125px; height:32px; padding: 3px;" data-options="showSeconds:false,editable:false"  />
			</span>
			
			<span>
				&nbsp;&nbsp;
				<input class="btn _class_search" name="" type="button" value="查询"/>
			</span>
		</div>
		
		<div class="xline"></div>
		
		<canvas id="introChart" width="700" height="400"></canvas>

	</div>

</body>
</html>
