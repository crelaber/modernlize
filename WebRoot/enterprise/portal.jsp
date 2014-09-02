<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String actualBasePath = basePath;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>搜图管理后台</title>
	
<link rel="stylesheet" type="text/css" href="<%=actualBasePath %>enterprise/css/themes/ui-cupertino/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=actualBasePath %>enterprise/css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=actualBasePath %>enterprise/css/demo.css">
<link rel="stylesheet" type="text/css" href="<%=actualBasePath %>enterprise/css/portal.css">
<style type="text/css">
	.title{
		font-size:16px;
		font-weight:bold;
		padding:20px 10px;
		background:#eee;
		overflow:hidden;
		border-bottom:1px solid #ccc;
	}
	.t-list{
		padding:5px;
	}
</style>

<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/jquery.autocommon.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/jquery.autoajax.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/jquery.portal.js"></script>

<script>
	$(function(){
		$('#pp').portal({
			border:false,
			fit:true
		});
		add();
	});
	
	function add(){
		for(var i=0; i<3; i++){
			var p = $('<div/>').appendTo('body');
			p.panel({
				title:'Title'+i,
				content:'<div style="padding:5px;">Content'+(i+1)+'</div>',
				height:100,
				closable:true,
				collapsible:true
			});
			$('#pp').portal('add', {
				panel:p,
				columnIndex:i
			});
		}
		$('#pp').portal('resize');
	}
	
	function remove(){
		$('#pp').portal('remove',$('#pgrid'));
		$('#pp').portal('resize');
	}
</script>
	
</head>

<body class="easyui-layout">
	<div region="north" class="title" border="false" style="height:60px;">
		即搜商家
	</div>
	<div region="center" border="false">
		<div id="pp" style="position:relative">
			<div style="width:30%;">
				<div title="时钟" style="text-align:center;background:#f3eeaf;height:150px;padding:5px;">
					<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="100" height="100">
				      <param name="movie" value="http://www.respectsoft.com/onlineclock/analog.swf">
				      <param name=quality value=high>
				      <param name="wmode" value="transparent">
				      <embed src="http://www.respectsoft.com/onlineclock/analog.swf" width="100" height="100" quality=high pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" wmode="transparent"></embed>
				    </object>
			    </div>
			    
			    <div title="Tutorials" collapsible="true" closable="true" style="height:200px;padding:5px;">
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/datagrid/datagrid1.php">Build border layout for Web Pages</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/panel.php">Complex layout on Panel</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/accordion.php">Create Accordion</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/tabs.php">Create Tabs</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/tabs2.php">Dynamically add tabs</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/panel2.php">Create XP style left panel</a></div>
			    </div>
			</div>
			
			<div style="width:40%;">
				<div id="pgrid" title="DataGrid" closable="true" style="height:200px;">
					<table class="easyui-datagrid" style="width:650px;height:auto"
							fit="true" border="false"
							singleSelect="true"
							idField="itemid" url="datagrid_data.json">
						<thead>
							<tr>
								<th field="itemid" width="60">Item ID</th>
								<th field="productid" width="60">Product ID</th>
								<th field="listprice" width="80" align="right">List Price</th>
								<th field="unitcost" width="80" align="right">Unit Cost</th>
								<th field="attr1" width="120">Attribute</th>
								<th field="status" width="50" align="center">Status</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			
			<div style="width:30%;">
				<div title="Searching" iconCls="icon-search" closable="true" style="height:80px;padding:10px;">
					<input class="easyui-searchbox">
				</div>
				<div title="Graph" closable="true" style="height:200px;text-align:center;">
					<img height="160" src="http://g.hiphotos.baidu.com/image/pic/item/7a899e510fb30f24ec17eee3ca95d143ac4b0344.jpg"></img>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
