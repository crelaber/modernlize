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

                var type = $this.attr("auto_type");
                if("prompt" === type){
                	 $.messager.prompt('提示',msg,$.autoajax.defaults.enter($this));
                }else{
                	$.messager.confirm('提示',msg,$.autoajax.defaults.enter($this));
                }
                event.preventDefault();
            });
            return this;
        }
    });
    
    /**
     * 默认值
     */
    $.autoajax.defaults = {
    		enter : function(_this){
    			var $this = _this;
                return function(flag){
                	
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
                    
                   //得到自定义的success的方法
                    var failFnBody = $this.attr("fail");
                    //声明函数
                    var failFn;
                    if(failFnBody){
                        //使用自定义方法体,初始话函数
                    	failFn = new Function('data',failFnBody);
                    }else{
                        //默认初始化函数方法
                    	failFn = new Function('data','');
                    }
                	
                    var _url = $this.attr("url");
                	//如果确认
                    if (true === flag){
                        //$.messager.progress({interval:1000});
                        //调用同步ajax
                    }else if(typeof flag === "string"){
                    	//prompt
                    	//var promptKey = $this.attr("promptKey");
                    	var dataOptionsStr = $this.attr("data_options");
    					if($.isNotNull(dataOptionsStr)){
    						var dataOptions = eval("("+"{" + dataOptionsStr + "}"+")");
    						if(dataOptions['validate'] instanceof Function){
    							var validateFlag = dataOptions['validate'](flag);
    							if(!validateFlag){
    								return false;
    							}
    						}
    					}
                    	_url = _url + flag;
                    }else{
                    	return false;
                    }
                    
                    $.syncAjax({
                        url : _url
                        ,success : function(data){
                            //var jd = eval('(' + data + ')');
                        	var jd = data;
                        	
                			if(!!!jd){
                				$.messager.alert('提示', "未知异常", "error");
                				return false;
                			}
                			
                			if (jd.state > 499) {
                				//$.messager.alert('提示', jd.message, "error");
                				failFn(jd);
                				//异常
                			} else if (jd.state > 199) {
                				//成功
                				//$.messager.alert('提示', '提交成功!');
                				fn(jd);
                			} else if (jd.state > 0) {
                				//失败
                				failFn(jd);
                			}
                            //$.messager.progress("close");
                        }
                    	,error : function(data){
                    		$.messager.alert('提示', "请求超时", "error");
            				return false;
                    	}
                    });
                    
                };
            }
    };
    
    $(function(){
        //$.autoajax("body",".auto-ajax");
        //$.autoajax(".datagrid-body" ,".auto-ajax");
    });
})(jQuery);