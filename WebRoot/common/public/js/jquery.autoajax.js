(function($){
    $.extend({
        autoajax : function(parent,select){
            $(parent).delegate(select,"click",function(event){
            //$(select).live("click",function(event){
                var $this = $(this);
                var msg = "你确定执行此操作吗?";
                var msgAttr = $this.attr("message");
                if(msgAttr){
                    msg = msgAttr;
                }
                //
                $.messager.confirm('提示',msg,function(flag){
                    //如果确认
                    if (flag){
                        //得到自定义的success的方法
                        var sfnBody = $this.attr("success");
                        //声明函数
                        var fn;
                        if(sfnBody){
                            //使用自定义方法体,初始话函数
                            fn = new Function('data',sfnBody);
                        }else{
                            //默认初始化函数方法
                            fn = new Function('data','');
                        }
                        //$.messager.progress({interval:1000});
                        //调用同步ajax
                        $.syncAjax({
                            url : $this.attr("url")
                            ,success : function(data){
                                fn(data);
                                //$.messager.progress("close");
                            }
                        });
                    }
                });
                event.preventDefault();
            });
            return this;
        }
    });
    
    /**
     * 默认值
     */
    $.autoajax.defaults = {
    };
    
    $(function(){
        $.autoajax("body",".auto-ajax");
        //$.autoajax(".datagrid-body" ,".auto-ajax");
    });
})(jQuery);