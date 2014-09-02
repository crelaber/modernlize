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

<link href="<%=actualBasePath %>enterprise/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/json2.min.js"></script>

<!--[if lt IE 9]><script language="javascript" type="text/javascript" src="<%=actualBasePath %>enterprise/jqplot/excanvas.min.js"></script><![endif]-->
<script language="javascript" type="text/javascript" src="<%=actualBasePath %>enterprise/jqplot/jquery.jqplot.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=actualBasePath %>enterprise/jqplot/jquery.jqplot.min.css" />
<script>
var actual_base_path = "<%=actualBasePath %>";

$(function(){
	var url = actual_base_path + "gdSupplerBasicConfExt_findBasicInfo";
	var formData = {};
	
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
				if("reports" == key){
					continue;
				}
				var val = data[key];
				$("#span_" + key).html(val);
			}
			
			var reports = data['reports'];
			console.log("reports:" + JSON.stringify(reports));
			if(!!reports){
				$.jqplot('order_plot',  [reports], {
					title:'今日订单统计',
					axes:{yaxis:{min:0, max:100}},
					series:[{color:'#5FAB78'}]
				});
			}
						
		} else if (jd.state > 0) {
			alert(jd.message);
			$("#submit_btn").removeClass("disabled");
		}
		
	},"JSON");
});

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
			<li><a href="#">首页</a>
			</li>
		</ul>
	</div>

	<div class="mainindex">


		<div class="welinfo">
			<span>
				<img src="images/sun.png" alt="天气" />
			</span>
			<span id="span_supp_nick" style="padding-left:8px;">加载中</span> <span>，您好！</span> <!-- <a href="#">帐号设置</a> -->
		</div>

		<div class="welinfo">
			<span><img src="images/time.png" alt="时间" />
			</span> 
			<i>您上次登录的时间：</i> <i id="span_prev_login_time">加载中</i>  <!--（不是您登录的？<a href="#">请点这里</a>） -->
		</div>

		<div class="xline"></div>
		<div class="box"></div>

		<div class="welinfo">
			<span><img src="images/dp.png" alt="提醒" /> </span>
			<span>店铺状态&nbsp;</span>
			<span id="span_busi_state">加载中</span>
			<span><a href="<%=actualBasePath %>/enterprise/ep_basic_info.jsp">更改</a></span>
		</div>

		<div>
			<table width="100%" class="_table">
				<tr>
					
					<th class="_th">
						账户余额：
					</th>
					<td class="_td _txt_num">
						<span id="span_balance">0</span>
					</td>
				</tr>
				
				<tr>
					
					<th class="_th">
						外卖订单：
					</th>
					<td class="_td _txt_num">
						<span id="span_ta_order_num_today">0</span>/<span id="span_ta_order_num">0</span>
					</td>
					
					<th class="_th">
						订座订单：
					</th>
					<td class="_td _txt_num">
						<span id="span_balance">0</span>/<span id="span_balance">0</span>
					</td>
					
					
					<td class="_td _txt_num">
						&nbsp;
					</td>
					
					<td class="_td _txt_num">
						&nbsp;
					</td>
										
					<td class="_td _txt_num">
						&nbsp;
					</td>
					
					<td class="_td _txt_num">
						&nbsp;
					</td>
				</tr>
				
				
				<tr>	
					<th class="_th">
						菜品总量：
					</th>
					<td class="_td _txt_num">
						<span id="span_meals_dish_num">0</span>
					</td>
					
					<th class="_th">
						&nbsp;
					</th>
					<td class="_td _txt_num">
						&nbsp;
					</td>
					
					<th class="_th">
						&nbsp;
					</th>
					<td class="_td _txt_num">
						&nbsp;
					</td>
					
					<th class="_th">
						&nbsp;
					</th>
					<td class="_td _txt_num">
						&nbsp;
					</td>
				</tr>
				
				<tr>
					<th class="_th">
						短消息：
					</th>
					<td class="_td _txt_num">
						<span id="span_sum_msg_today">0</span>/<span id="span_sum_msg">0</span>
					</td>
					
					<th class="_th">
						&nbsp;
					</th>
					<td class="_td _txt_num">
						&nbsp;
					</td>
					
					<th class="_th">
						&nbsp;
					</th>
					<td class="_td _txt_num">
						&nbsp;
					</td>
					
					<th class="_th">
						&nbsp;
					</th>
					<td class="_td _txt_num">
						&nbsp;
					</td>
				</tr>
			</table>
		</div>

		<div class="xline"></div>

		<ul class="iconlist">

			<li><img src="images/icon12.png" />
			<p>
					<a href="<%=actualBasePath %>/enterprise/ep_dish_manage.jsp">菜品管理</a>
				</p>
			</li>
			
			<li><img src="images/icon15.png" />
			<p>
					<a href="<%=actualBasePath %>/enterprise/ep_dish_top_manage.jsp">推荐菜</a>
				</p>
			</li>
			
			<li><img src="images/icon16.png" />
			<p>
					<a href="<%=actualBasePath %>/enterprise/ep_takeaway_order.jsp?_tabcode=201">外卖订单</a>
				</p>
			</li>
			
			<li><img src="images/icon17.png" />
			<p>
					<a href="<%=actualBasePath %>/enterprise/ep_takeaway_order.jsp?_tabcode=201">订座订单</a>
				</p>
			</li>
		</ul>
		
		<!--
		<div class="ibox">
			<a class="ibtn"><img src="images/iadd.png" />添加新的快捷功能</a>
		</div> -->

		<div class="xline"></div>

		<div class="uimakerinfo">
			<b>订单统计</b>
		</div>

		<div id="order_plot"></div>
		<script>
				/*$.jqplot('order_plot',  [[1,0]], {
					title:'今日订单统计',
					axes:{yaxis:{min:0, max:500}},
					series:[{color:'#5FAB78'}]
				});*/
		</script>

	</div>

</body>
</html>
