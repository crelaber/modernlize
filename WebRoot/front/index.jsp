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
<title>知识库管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=actualBasePath %>enterprise/css/themes/bootstrap/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=actualBasePath %>enterprise/css/themes/icon.css"/>
<script src="<%=actualBasePath %>enterprise/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=actualBasePath %>enterprise/js/locale/easyui-lang-zh_CN.js"></script>
<link href="<%=actualBasePath %>front/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=actualBasePath %>front/css/main_ext.css" rel="stylesheet" type="text/css" />
<script src="<%=actualBasePath %>front/js/main.js"></script>
<script type="text/javascript">
var actual_base_path = "<%=actualBasePath %>";
</script>
<style type="text/css">
<!--



-->
</style>
</head>

<body>

<div id="pop_grey" class="pop_grey" style="display:none"></div>


<!--#############下为浮动层#################-->
        <div id="openwin1" class="openwin">
        <div class="title_close"><div class="close_icon" onclick="hidewin1();"></div><div class="clearf"></div></div>
            <div class="stitle">
            <div class="stitle_icon config_icon txt16 bb">产品配置</div>
            </div>
<img src="images/config_tab.png" width="1000" height="31" border="0"/>

<div class="config_tab_content">
<img src="images/config_words.png" width="1216" height="933" border="0"/>
</div>
        
        
        </div>
        
        <div id="openwin2" class="openwin">
        <div class="title_close"><div class="close_icon" onclick="hidewin2();"></div><div class="clearf"></div></div>
            <div class="stitle">
            <div class="stitle_icon shop_icon txt16 bb">特约店信息</div>
            </div>



<ul class="search_box" style="margin:10px 142px 10px 142px">
<li class="s_p1 s_p1b">
</li>
<li class="s_p2 txt14 bb">
<div style=" padding:10px 50px 10px 100px; width:500px;">
中心位置：
<input type="text" class="input_s" placeholder="中心位置..." style="width:300px"/>
<input type="button" value="搜 索" class="but_s txt14 bb" />
</div>
</li>
<li class="s_p3"></li>
<div class="clearf"></div>
</ul>

<img src="images/shop_map.png" width="900" height="500" border="0" style=" margin:10px 50px 15px 50px"/>


        
        
        </div>
        
        <div id="openwin3" class="openwin openwin_s">
        <div class="title_close"><div class="close_icon" onclick="hidewin3();"></div><div class="clearf"></div></div>
            <div class="stitle">
            <div class="stitle_icon light_icon txt16 bb">知识更新提醒</div>
            </div>

<!--#################下为知识内容###############-->
<ul class="result_box" style=" margin:15px auto 15px;">
<li class="res_top"></li>
<li class="res_mid">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="result_table" id="mytable2"><tbody >
    <tr>
      <td>
<ul class="words">
<li class="word_l red txt14 bb">1.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />ix35停车后底盘有卡他声，会响很久！啥原因？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: block">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>

        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words">
<li class="word_l red txt14 bb">2.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />伊兰特的正时皮带多少公里换比较好。<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>

        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words">
<li class="word_l red txt14 bb">3.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />配件价格是全国统一的吗?<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>

        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" >
<li class="word_l red txt14 bb">4.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />北京现代伊兰特有没有双燃料车？是否有准确的生产时间？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>

        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words">
<li class="word_l red txt14 bb">5.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />你好！购买现代瑞纳两厢版能不能享受国家补贴？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>

        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words">
<li class="word_l red txt14 bb">6.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />伊兰特两厢车价格是多少，上市了吗？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>

        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words">
<li class="word_l red txt14 bb">7.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />你们会把我们提出的问题向我们当地的特维站反映吗?<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" >
<li class="word_l red txt14 bb">8.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />1.8的发动机是CVVT的么?和1.6CVVT的比哪个省油(手档,相同开法)<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>

        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words">
<li class="word_l red txt14 bb">9.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />请给我解释一下途胜2.0的DOHC CVVT及G4GC是什么意思?<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>

        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words">
<li class="word_l red txt14 bb">10.</li>
<li class="word_r blue txt14"><img src="images/new.png" width="21" height="21" border="0" class="ask_but" />冬天早上发动后，是应该停车等怠速在7-800转左右再开车，还是一边开车、一边温车？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h2 class="jobs_notes" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span style="cursor:pointer">不满意：9</span>

        </li>
        
        <div class="clearf"></div>
        </ul>
      </h2>
      </td>
    </tr>
    
    
    
    
    
    


  </tbody></table>
</li>
<li class="res_bot"><div class="pages">上一页&nbsp;&nbsp;&nbsp;下一页&nbsp;&nbsp;&nbsp;1/3页&nbsp;&nbsp;&nbsp;跳转到 <select>
  <option selected="selected">1</option>
  <option>2</option>
  <option>3</option>
</select> 页&nbsp;&nbsp;&nbsp;每页 
<select name="select">
  <option selected="selected">10</option>
  <option>25</option>
  <option>50</option>
</select> 
条&nbsp;&nbsp;&nbsp;共<span class="red">25</span>条</div>
</li>
<div class="clearf"></div>
</ul>

<!--============上为知识内容==============-->
        
        </div>
<!--============上为浮动层==============-->


<div class="header_part"><img src="images/logo_bh.png" width="600" height="64" border="0" /></div>
<!--============上为头部==============-->
<div class="menu_part">
<ul class="menu_lr">
<li class="m_left">
<ul class="menu_list white txt14 bb">
<li class="m_click" onclick="location.href='index.htm';">首页</li>
<li class="" onclick="location.href='notice.htm';">最新通知</li>
<li class="" onclick="location.href='message.htm';">留言建议</li>
<li class="" onclick="location.href='study.htm';">学习天地</li>
<li class="" onclick="location.href='favorite.htm';">个人收藏</li>
<div class="clearf"></div>
</ul>

</li>
<li class="m_right"><span class="m_worksinfo lightblue">坐席姓名：赵玲&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工号：0368</span></li>
<div class="clearf"></div>
</ul>
</div>
<!--============上为菜单==============-->
<div class="main_part">
<ul class="main_p3">
<li class="m_left">
<div class="servicepic"></div>
<ul class="box01">
<li class="left_top">
<div class="tree_title grey555 bb txt14">知识库分类</div>
</li>
<li class="left_mid">
<!-- 知识分类 -->
<!--  <img src="images/left_menu.png" width="166" height="521" border="0"/>-->
<ul id="faq_type_tree"></ul>
</li>
<li class="left_bot"></li>
<div class="clearf"></div>
</ul>
</li>
<!--============上为中左==============-->
<li class="m_center">

<div class="c_things">
<!--#############下为中部内容###############-->
<ul class="search_box">
<li class="s_p1">
<div class="but_bar">
<div class="but_bg" style="margin:0 190px 0 0;" onclick="openwin2();"><div class="sbut1 sbut3 bb">特约店信息</div></div>
<div class="but_bg" style="margin:0 10px 0 0;" onclick="window.open('config.htm','','');"><div class="sbut1 sbut2 bb">产品配置</div></div>
<!--<div class="but_bg"><div class="sbut1 bb">产品价格</div></div>-->
</div>
</li>
<li class="s_p2">
<ul class="search_2s">
<li class="left_s">
<input type="text" class="input_s" placeholder="整句搜索..."/>
<input type="button" value="检 索" class="but_s txt14 bb" />
</li>
<li class="right_s">
<input type="text" class="input_s" placeholder="关键词搜索..."/>
<input type="button" value="检 索" class="but_s txt14 bb" />
</li>
<div class="clearf"></div>
</ul>


</li>
<li class="s_p3"></li>
<div class="clearf"></div>
</ul>
<!--============上为搜索块==============-->
<ul class="result_box">
<li class="res_top"></li>
<li class="res_mid">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="result_table" id="mytable"><tbody >
    <tr>
      <td>
<ul class="words" onclick="dirdisplay01()">
<li class="word_l red txt14 bb">1.</li>
<li class="word_r blue txt14"><img src="images/ask.png" width="21" height="21" border="0" class="ask_but" />ix35停车后底盘有卡他声，会响很久！啥原因？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir01" style="display: block">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer1();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer1" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv1();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" onclick="dirdisplay02()">
<li class="word_l red txt14 bb">2.</li>
<li class="word_r blue txt14"><img src="images/ask.png" width="21" height="21" border="0" class="ask_but" /><span class="yellow_bg">伊兰特</span>的正时皮带多少公里换比较好。<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir02" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer2();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer2" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv2();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" onclick="dirdisplay03()">
<li class="word_l red txt14 bb">3.</li>
<li class="word_r blue txt14"><img src="images/ask.png" width="21" height="21" border="0" class="ask_but" />配件价格是全国统一的吗?<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir03" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer3();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer3" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv3();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" onclick="dirdisplay04()">
<li class="word_l red txt14 bb">4.</li>
<li class="word_r blue txt14"><img src="images/ago.png" width="33" height="19" border="0" class="ask_but" />北京现代<span class="yellow_bg">伊兰特</span>有没有双燃料车？是否有准确的生产时间？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir04" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer4();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer4" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv4();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" onclick="dirdisplay05()">
<li class="word_l red txt14 bb">5.</li>
<li class="word_r blue txt14"><img src="images/ask.png" width="21" height="21" border="0" class="ask_but" />你好！购买现代瑞纳两厢版能不能享受国家补贴？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir05" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer5();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer5" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv5();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" onclick="dirdisplay06()">
<li class="word_l red txt14 bb">6.</li>
<li class="word_r blue txt14"><img src="images/ask.png" width="21" height="21" border="0" class="ask_but" /><span class="yellow_bg">伊兰特</span>两厢车价格是多少，上市了吗？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir06" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer6();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer6" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv6();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" onclick="dirdisplay07()">
<li class="word_l red txt14 bb">7.</li>
<li class="word_r blue txt14"><img src="images/ask.png" width="21" height="21" border="0" class="ask_but" />你们会把我们提出的问题向我们当地的特维站反映吗?<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir07" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer7();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer7" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv7();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" onclick="dirdisplay08()">
<li class="word_l red txt14 bb">8.</li>
<li class="word_r blue txt14"><img src="images/ask.png" width="21" height="21" border="0" class="ask_but" />1.8的发动机是CVVT的么?和1.6CVVT的比哪个省油(手档,相同开法)<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir08" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer8();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer8" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv8();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" onclick="dirdisplay09()">
<li class="word_l red txt14 bb">9.</li>
<li class="word_r blue txt14"><img src="images/ask.png" width="21" height="21" border="0" class="ask_but" />请给我解释一下途胜2.0的DOHC CVVT及G4GC是什么意思?<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir09" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer9();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer9" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv9();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    <tr>
      <td>
<ul class="words" onclick="dirdisplay10()">
<li class="word_l red txt14 bb">10.</li>
<li class="word_r blue txt14"><img src="images/ask.png" width="21" height="21" border="0" class="ask_but" />冬天早上发动后，是应该停车等怠速在7-800转左右再开车，还是一边开车、一边温车？<span class="grey txt12 normal">（2010010230521-005）</span></li>
<div class="clearf"></div>
</ul>
      <h1 class="jobs_notes" id="dir10" style="display: none">
      <div class="answer_bar txt14">你好，索纳塔没有振动报警功能。索纳塔电子防盗功能的报警条件是：在电子防盗处于警戒状态下，不使用遥控器打开车门、发动机盖（行李箱盖）时，报警器以27秒钟“ON”、10秒钟“OFF”为周期反复响三次，同时危险警告灯闪烁，起动电路被锁住不能起动动发动机。在警戒状态下使用钥匙或用遥控器上的“TPK”按钮打开行李箱盖时，不发出报警声，如果行李箱盖没有完全开启，2秒钟后可能会报警，在行李箱盖开启状态下车门和发动机盖仍处于警戒状态。</div>
        <ul class="info_bar grey">
        <li class="info1">更新：2014-7-10
        </li>
        <li class="info2">收藏
        </li>
        <li class="info3">点击量：127
        </li>
        <li class="info4">满意：30
        </li>
        <li class="info5"><span onclick="showlayer10();" style="cursor:pointer">不满意：9</span>
        <div id="thelayer10" class="thelayer">
        <div class="title_close"><div class="close_icon" onclick="hidediv10();"></div><div class="clearf"></div></div>
        <textarea name="" cols="" rows="" onfocus="if(value=='不满意的原因...'){value=''}" onblur="if (value ==''){value='不满意的原因...'}" class="textareas">不满意的原因...</textarea><br />
		<input type="button" value="提 交" class="but_s txt12 bb" />
        
        </div>
        </li>
        
        <div class="clearf"></div>
        </ul>
      </h1>
      </td>
    </tr>
    
    
    
    
    
    


  </tbody></table>
</li>
<li class="res_bot"><div class="pages">上一页&nbsp;&nbsp;&nbsp;下一页&nbsp;&nbsp;&nbsp;1/3页&nbsp;&nbsp;&nbsp;跳转到 <select>
  <option selected="selected">1</option>
  <option>2</option>
  <option>3</option>
</select> 页&nbsp;&nbsp;&nbsp;每页 
<select name="select">
  <option selected="selected">10</option>
  <option>25</option>
  <option>50</option>
</select> 
条&nbsp;&nbsp;&nbsp;共<span class="red">25</span>条</div>
</li>
<div class="clearf"></div>
</ul>
<!--============上为中部内容==============-->

</div>

</li>
<!--============上为中中部==============-->
<li class="m_right">

<ul class="box0c">
<li class="left_top">
</li>
<li class="left_mid">
<div class="calendar"></div>
</li>
<li class="left_bot"></li>
<div class="clearf"></div>
</ul>

<ul class="box01">
<li class="left_top">

<ul class="ltitle_b">
<li class="b_left grey555 bb txt14">最新问题
</li>
<li class="b_right"  onclick="openwin3();">
</li>
<div class="clearf"></div>
</ul>

</li>
<li class="left_mid">
<div class="question newq">请问新悦动的地盘是什么类型？</div>
<div class="question newq">伊兰特的正时皮带多少公里换比较好。</div>
<div class="question newq">目前雅绅特的价是多少？</div>
<div class="question">轮胎胎压多少为最佳？</div>
<div class="question">配件价格是全国统一的吗？</div>
<div class="question">冬季发动车辆应注意什么？暖机多长时间最合适？</div>
<div class="question">索钠塔的防盗功能为什么敲打没有警报声？</div>

</li>
<li class="left_bot"></li>
<div class="clearf"></div>
</ul>

<ul class="box01">
<li class="left_top">
<ul class="ltitle_b">
<li class="b_left b_left_hot grey555 bb txt14">热点问题
</li>
<li class="b_right" onclick="openwin1();">
</li>
<div class="clearf"></div>
</ul>

</li>
<li class="left_mid">
<div class="question newq">请问新悦动的地盘是什么类型？</div>
<div class="question newq">伊兰特的正时皮带多少公里换比较好。</div>
<div class="question newq">目前雅绅特的价是多少？</div>
<div class="question">轮胎胎压多少为最佳？</div>
<div class="question">配件价格是全国统一的吗？</div>
<div class="question">冬季发动车辆应注意什么？暖机多长时间最合适？</div>
<div class="question">索钠塔的防盗功能为什么敲打没有警报声？</div>

</li>
<li class="left_bot"></li>
<div class="clearf"></div>
</ul>
</li>
<!--============上为中右==============-->
<div class="clearf"></div>
</ul>
</div>
<!--============上为中间内容==============-->
<div class="footer_part grey"><span class="yahei">&copy;</span> 2014 北京现代知识库管理系统</div>
<!--============上为尾部==============-->
</body>
</html>