var vlogin_user;
//vlogin_user.prjRoot
$.ajax({
    type: "GET"
    ,url: "userExt_valiAdminLogin"
    ,dataType: "JSON"
    ,async: false//同步加载
    ,timeout:60000
    ,success:function(data){
        if(data && 200 == data.state){
        	vlogin_user = data.data;
            return;
        }
        top.location.href = "login.html";
    }
	,error:function (XMLHttpRequest, textStatus, errorThrown) {
	    // 通常 textStatus 和 errorThrown 之中
	    // 只有一个会包含信息
	    //this; // 调用本次AJAX请求时传递的options参数
		top.location.href = "login.html";
	}
});