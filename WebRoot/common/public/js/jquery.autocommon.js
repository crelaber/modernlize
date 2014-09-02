var _common_datagrid_view = $.extend({}, $.fn.datagrid.defaults.view, {
	onAfterRender : function(target) {
		$.fn.datagrid.defaults.view.onAfterRender.call(this, target);
		var opts = $(target).datagrid('options');
		var vc = $(target).datagrid('getPanel').children('div.datagrid-view');
		vc.children('div.datagrid-empty').remove();
		if (!$(target).datagrid('getRows').length) {
			var d = $('<div class="datagrid-empty"></div>').html(
					opts.emptyMsg || 'no records').appendTo(vc);
			d.css({
				position : 'absolute',
				left : 0,
				top : 50,
				width : '100%',
				textAlign : 'center'
			});
		}
	}
});

(function($){
    $.extend({
        /**
		 * 根据键取到请求参数的值
		 * 
		 * @param key
		 *            键
		 * @returns 取到的值
		 */
        parameter : function(key){
            var parameters,url = window.location || {},request={};
            parameters = decodeURI(url.search).slice(1);
            parameters = parameters.split("&");
            //遍历
            for(var i in parameters){
                var parameter = parameters[i].split("=");
                var keyInner = parameter[0];
                if(key == keyInner){
                    //返回查询到的参数
                    return parameter[1];
                }
            }
            return undefined;
        }
        /**
         * 
         * @param key
         * @returns {Array}
         */
        ,parameters : function(key){
            var parameters,url = window.location || {},request={};
            parameters = decodeURI(url.search).slice(1);
            parameters = parameters.split("&");
            var values = [];
            //遍历
            for(var i in parameters){
                var parameter = parameters[i].split("=");
                var keyInner = parameter[0];
                if(key == keyInner){
                    //返回查询到的参数
                    values.push(parameter[1]);
                }
            }
            return values;
        }
        /**
         * 模态窗口
         */
        /*,dialog : function(key,options){
            //如果不指定dialog的键
            if(typeof key == "object"){
                options = key;
            }
            //用参数覆盖默认值
            var opts = $.extend({},$.dialog.defaults,options);
            //内嵌
            var iframe = $('<iframe style="display:block;margin:0 auto;" frameborder="0" scrolling="auto" width="98%" height="98%" src="'+opts.url+'"></iframe>');
            //设置加载地址
            //iframe.attr("src",opts.url);
            //
            
            if(opts.autoSize){
                opts.width = $(document).width();
                opts.height = $(document).height();
            }
            //注册dialog
            var dialog = $('<div/>')
            .attr("title",opts.title)
            .css({width:opts.width,height:opts.height})
            .append(iframe)
            //.appendTo()
            .dialog({
                //top : opts.top
                modal:opts.modal
                ,onClose:function(){
                    $(this).dialog('destroy');
                }
                ,onDestroy:function(){
                    $.closeDialog(key);
                }
            });
            //缓存
            if(typeof key == 'string'){//根据键缓存
                $.data($.dialog.defaults.cacheScope,$.dialog.defaults.keyPrefix + key,dialog);
            }else{//放在dialog栈内
                //获取栈
                var $dialogStack = $.data($.dialog.defaults.cacheScope,$.dialog.defaults.dialogStack);
                //如果栈不存在
                if(!$dialogStack){
                    //新建栈
                    $dialogStack = new Array();
                    //放入缓存
                    $.data($.dialog.defaults.cacheScope,$.dialog.defaults.dialogStack,$dialogStack);
                }
                //把dialog放入栈顶
                $dialogStack.push(dialog);
                
                for(var i in $dialogStack){
                    alert($dialogStack[i]);
                }
            }
        }
        *//**
         * 关闭模态窗口(总是关闭栈顶的模态窗口,或key值指定的模态窗口)
         *//*
        ,closeDialog : function(key,element){
            debugger;
            //声明
            var $dialog;
            //如果是根据key来关闭dialog
            if(typeof key == 'string'){
                if(typeof element != 'object'){
                    element = $.dialog.defaults.cacheScope;
                }
                $dialog = $.data(element,$.dialog.defaults.keyPrefix + key);
                //判断
                if($dialog){
                    try{
                        //销毁
                        $dialog.dialog("destroy");
                    }catch(e){
                        //nothing
                    }
                    //并且从缓存中去除
                    $.removeData($.dialog.defaults.cacheScope,$.dialog.defaults.keyPrefix + key);
                }
            }else{
                if(typeof key != 'object'){
                    key = $.dialog.defaults.cacheScope;
                }
                //否则就是从栈内关闭
                var $dialogStack = $.data(key,$.dialog.defaults.dialogStack);
                if($dialogStack instanceof Array && $dialogStack.length > 0){
                    var $dialog = $dialogStack[$dialogStack.length - 1];
                    //判断
                    if($dialog){
                        try{
                            //销毁
                            $dialog.dialog("destroy");
                        }catch(e){
                            //nothing
                        }
                        //并且从栈顶弹出
                        $dialogStack.pop();
                    }
                }
            }
        }*/
        /**
         * 同步ajax
         */
        ,syncAjax : function(options){
            var opts = $.extend({},$.syncAjax.defaults,options);
            $.ajax({
                type : opts.type
                ,url : opts.url
                ,data : opts.data
                ,dataType : opts.dataType
                ,async : false//同步加载
                ,timeout : opts.timeout
                ,beforeSend : opts.beforeSend
                ,success : opts.success
                ,error : opts.error
                ,cache : opts.cache
            });
        }
        ,treeNode : function(clazzName,id){
            //替换.号为_后的clazzName
            var clazzNameReplace = $.treeNode.defaults.keyPrefix + clazzName.replace(/\./g,'_');
            //声明节点集合
            var nodes;
            //查找缓存里是否存在
            nodes = $.data($.treeNode.defaults.cacheScope,clazzNameReplace);
            if(!(nodes instanceof Array)){
                //同步加载数据
                $.syncAjax({
                    url : $.treeNode.defaults.url
                    ,data : 'clazzName='+clazzName
                    ,success : function(data){
                        nodes = data;
                    }
                });
                //缓存
                $.data($.treeNode.defaults.cacheScope,clazzNameReplace,nodes);
            }
            for(var i in nodes){
                if(id == nodes[i].id){
                    return {id:id,text:nodes[i].text};
                }
            }
            return {id:id,text:'未发现'};
        },
        /**
         * 是否为空
         */
        isNull : function(obj){
            return "" === $.trim(obj) || "undefined" === $.trim(obj);
        },
        /**
         * 是否为空
         */
        isNotNull : function(obj){
        	return !$.isNull(obj);
        },
        arrayToObj : function (array, name, value) {
    		var obj = {};
    		for ( var arr in array) {
    			//submitData
    			var objName = array[arr][name];
    			var objValue = array[arr][value];
    			//判断此属性是否为不设置
    			if(!objValue || objValue.length < 1) continue;
    			if(obj[objName] != undefined){
    				obj[objName] = obj[objName] + ',' + objValue;
    			}else{
    				obj[objName] = objValue;
    			}
    		}
    		return obj;
        },
        createLink : function(obj){
        	var link = $("<a/>");
        	
        	var content = obj["content"];
        	if(content){
        		link.html(content);
        	}
        	
        	var attrs = obj["attrs"];
        	if(attrs){
        		for(var key in attrs){
        			link.attr(key,attrs[key]);
        		}
        	}
        	
        	return $("<span/>").append(link).html();
        },
        renderTemplate : function (template,data) {
			with(data) {
				return template.replace(/\{([_\.a-zA-Z0-9]+)\}/g,function(t,c) {
					return eval("("+c+")");
				});
			}
		},
        /**
         * 制保留n位小数，如：(2,2)，会在2后面补上00.即2.00  
         */
        toFixedDecimal : function(x,n) {
            var f = parseFloat(x);  
            if (isNaN(f)) {  
                return null;  
            }
            
            var f = Math.round(x*100)/100;  
            var s = f.toString();  
            var rs = s.indexOf('.');  
            if (rs < 0) {  
                rs = s.length;  
                s += '.';  
            }
            
            while (s.length <= rs + n) {
                s += '0';  
            }
            return s;  
        }  
    });
    
    /*$.dialog.defaults = {
        top : 0,
        modal : true,
        autoSize : false,
        width : 500,
        height: 500,
        title : '模态窗口',
        url : '',
        keyPrefix : '$dialog_',
        dialogStack : '$dialogStack',
        cacheScope : document
    }*/
    
    $.syncAjax.defaults = {
        timeout : 60000
        ,url : ''
        ,data : ''
        ,beforeSend : function(XMLHttpRequest){}
        ,success : function(data, textStatus, jqXHR){}
        ,error : function(XMLHttpRequest, textStatus, errorThrown){}
        ,dataType : 'JSON'
        ,cache : true
        ,type : 'POST'
    }
    
    $.treeNode.defaults = {
        keyPrefix : '$treeNode_'
        ,cacheScope : document
        ,url : 'eacommon$jsondata$treeNodesByClazzName.action'
    }
    
    $(function(){
        /*$.dialog({title:'1',autoSize:true});
        $.dialog({title:'2'});
        $.dialog({title:'3'});*/
        //alert(top);
        
        $("body").delegate(".auto-textarea","focusin",function(event){
            $(this).css("height","200");
            event.preventDefault();
            return false;
        });
        
        $("body").delegate(".auto-textarea","focusout",function(event){
            $(this).css("height","34");
            event.preventDefault();
            return false;
        });
    	
        /**
         * 返回上一页
         */
        $("body").delegate(".auto-backPrevPage","click",function(event){
            history.back();
            event.preventDefault();
        });
        
        /**
         * 绑定模态搜索框
         */
        $("body").delegate(".auto-search-btn","click",function(event){
            var $this = $(this);
            var $input = $this.siblings(":text")
            var $hidden = $this.siblings(":hidden");
            openDialog($input.attr('url'),$input.attr('title'));
            //回调函数
            dialogCallBack = function(id,text){
                //如果ID为空值
                if(!id || "" == id){
                    text = "";
                }
                $hidden.val(id);
                $input.val(text);
                //当前栈顶上的dialog
                findDialog().dialog("destroy");
            }
            //alert(findOpener());
            //findDialog().dialog("destroy");
            event.preventDefault();
        });
        
        //***************************************************** 最好放在最后面
        //禁止退格键 作用于Firefox、Opera   
        document.onkeypress = banBackSpace;  
        //禁止退格键 作用于IE、Chrome  
        document.onkeydown = banBackSpace;
    });
    
})(jQuery);

/**
 * 打开窗口后的回调函数
 */
var dialogCallBack = function(){};

//模态窗口
var dialogs = new Array();
//打开窗口者
var openers = new Array();

/**
 * 打开模态窗口
 * @param url
 * @param title
 * @param opene
 * @returns
 */
var openDialog = function(url,title,opene){
    opene = opene || this;
    //如果父窗口不等于自己,并且父窗口有函数openDialog
    if(parent != window && typeof parent.openDialog == "function"){
        parent.openDialog(url,title,opene);
        return;
    }
    //放入数组
    openers.push(opene);
    var iframe = $('<iframe frameborder="0" scrolling="auto" width="99.9%" height="99.9%" src="'+url+'"></iframe>');
    //注册模态窗口
    var dialog = $('<div title="'+title+'" style="width:1000px;height:800px;"/>')
    .append(iframe)
    .dialog({
        modal:true
        ,width:1000
        ,height:600
        ,onClose : function(){
            $(this).dialog("destroy");
        }
        ,onDestroy : function(){
            openers.pop();
            dialogs.pop();
        }
    });
    //放入数组
    dialogs.push(dialog);
};

var findOpener = function(){
    if(parent != window && typeof parent.findOpener == "function"){
        return parent.findOpener();
    }
    //返回栈顶元素
    return openers[openers.length - 1];
}

var findDialog = function(){
    if(parent != window && typeof parent.findDialog == "function"){
        return parent.findDialog();
    }
    //返回栈顶元素
    return dialogs[dialogs.length - 1];
}

//处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外   
function banBackSpace(e){
    //alert(event.keyCode)  
    var ev = e || window.event;//获取event对象     
    var obj = ev.target || ev.srcElement;//获取事件源       
    var t = obj.type || obj.getAttribute('type');//获取事件源类型       
    //获取作为判断条件的事件类型   
    var vReadOnly = obj.readOnly;  
    var vDisabled = obj.disabled;  
    //处理undefined值情况   
    vReadOnly = (vReadOnly == undefined) ? false : vReadOnly;  
    vDisabled = (vDisabled == undefined) ? true : vDisabled;  
    //当敲Backspace键时，事件源类型为密码或单行、多行文本的，    
    //并且readOnly属性为true或disabled属性为true的，则退格键失效    
    var flag1 = ev.keyCode == 8 && (t == "password" || t == "text" || t == "textarea") && (vReadOnly == true || vDisabled == true);  
    //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效      
    var flag2 = ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea";  
    //判断      
    if (flag2 || flag1)   
        event.returnValue = false;//这里如果写 return false 无法实现效果   
}

function arrayToObj(array, name, value) {
	var obj = {};
	for ( var arr in array) {
		obj[array[arr][name]] = array[arr][value];
	}
	return obj;
}