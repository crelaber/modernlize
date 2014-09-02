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
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>我的店铺</div>
    
    <dl class="leftmenu">
    
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>用户管理
    </div>
    	<ul class="menuson">
			<li class="active"><cite></cite><a href="<%=actualBasePath %>/enterprise/mcenter.jsp" target="rightFrame">用户列表</a><i></i></li>
			<li><cite></cite><a href="<%=actualBasePath %>/enterprise/ep_basic_info.jsp" target="rightFrame">权限列表</a><i></i></li>
			<li><cite></cite><a href="<%=actualBasePath %>/enterprise/ep_dish_manage.jsp" target="rightFrame">角色列表</a><i></i></li>
        </ul>    
    </dd>
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>知识管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=actualBasePath %>/enterprise/jsp/faq_type/list.jsp"target="rightFrame">知识列表</a><i></i></li>
        <li><cite></cite><a href="<%=actualBasePath %>/enterprise/jsp/faq_type/list.jsp"target="rightFrame">趣味知识</a><i></i></li>
        <li><cite></cite><a href="<%=actualBasePath %>/enterprise/jsp/faq_type/list.jsp"target="rightFrame">专有名称</a><i></i></li>
        <li><cite></cite><a href="<%=actualBasePath %>/enterprise/ep_takeaway_range.jsp" target="rightFrame">附件列表</a><i></i></li>
        <li><cite></cite><a href="<%=actualBasePath %>/enterprise/ep_takeaway_range.jsp" target="rightFrame">图片列表</a><i></i></li>
    </ul>    
    </dd>  
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>前台管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">基本配置</a><i></i></li>
        <li><cite></cite><a href="#">订座订单</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>统计信息</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=actualBasePath %>/enterprise/count_order.jsp" target="rightFrame">订单统计</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">成交额统计</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">短信统计</a><i></i></li>
    </ul>
    </dd>   
    
    <!-- 
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>其他操作
    </div>
		<ul class="menuson">
			<li><cite></cite><a href="#">其他</a><i></i></li>
        </ul>     
    </dd>
     -->
    
    </dl>
    
</body>
</html>


