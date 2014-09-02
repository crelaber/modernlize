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
<link href="<%=actualBasePath %>/enterprise/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=actualBasePath %>/enterprise/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<style>
*{margin:0; padding:0;}
</style>

</head>

<body style="background-color:#354b66;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <!--<li><a href="default.html" target="rightFrame" class="selected"><img src="images/icon12.png" title="工作台" /><h2>我的桌面</h2></a></li>
    <li><a href="imgtable.html" target="rightFrame"><img src="images/icon13.png" title="菜品管理" /><h2>基本信息</h2></a></li>
    <li><a href="imglist.html"  target="rightFrame"><img src="images/icon14.png" title="菜单管理" /><h2>菜单管理</h2></a></li>
    <li><a href="tools.html"  target="rightFrame"><img src="images/icon15.png" title="今日推荐菜" /><h2>今日推荐菜</h2></a></li>
    <li><a href="<%=actualBasePath %>/enterprise/ep_takeaway_order.jsp?_tabcode=201" target="rightFrame"><img src="images/icon16.png" title="外卖订单" /><h2>外卖订单</h2></a></li>
    <li><a href="tab.html"  target="rightFrame"><img src="images/icon17.png" title="订座订单" /><h2>订座订单</h2></a></li>
	-->
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="login.html" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>东莞家常菜</span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>

</body>
</html>

