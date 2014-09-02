//生成uuid
function uuid(len, radix) {
    var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
    var uuid = [], i;
    radix = radix || chars.length;
    if (len) {
      // Compact form
      for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
    } else {
      // rfc4122, version 4 form
      var r;
      // rfc4122 requires these characters
      uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
      uuid[14] = '4';
      // Fill in random data.  At i==19 set the high bits of clock sequence as
      // per rfc4122, sec. 4.1.5
      for (i = 0; i < 36; i++) {
        if (!uuid[i]) {
          r = 0 | Math.random()*16;
          uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
        }
      }
    }
    return uuid.join('');
}

function append(text){
	var selected = $('#faq_type_tree').tree('getSelected');
	$('#faq_type_tree').tree('append', {
		parent: null!=selected?selected.target:$('#faq_type_tree').tree('getRoot').target,
		data: [{
			id: uuid(32,32),
			text: text
		}]
	});
}

//修改数据集合
var modifyDataArr = new Array;
var addDataArr = new Array;
var delDataArr = new Array;


/**
 * jia ru shi dan ge node shijian
 * @return
 */
function getIndexById(id,arr){
	if(null==arr||0==arr.length) return -1;
	var i=0;
	for(i=0;i<arr.length;i++){
		if(id==arr[i].id){
			return i;
			break;
		}
	}
	return -1;
}



function append(){
	$('._class_btn_save_type').show();
    var t = $('#faq_type_tree');
    var node = t.tree('getSelected');
    var id=uuid(32,32);
    /*var node = $('#tt').tree('getSelected');
    if (node){
    	$('#tt').tree('insert', {
    		before: node.target,
    		data: {
    			id: 21,
    			text: 'node text'
    		}
    	});
    }*/
    var childs = t.tree('getChildren',node.target);
    t.tree('insert',{
    	before: (childs?childs[0].target:null),
    	data: [{
        	id:id,
            text: '未命名'
        }]
    });
    /*t.tree('append', {
        parent: (node?node.target:null),
        data: [{
        	id:id,
            text: '未命名'
        }]
    });*/
    addDataArr.push(setValue('未命名',id,'add',node.id));//入库到数组
}

function setValue(text,id,flag,parentId){
	   var obj = new Object();
	    obj.text=text;
	    obj.id=id;
	    obj.flag=flag;
	    obj.parentId=parentId;
	    return obj;
}


function removeit(){
    var node = $('#faq_type_tree').tree('getSelected');
    var id = node.id;
    if('-1'==id){
    	$.messager.alert('提示', '不能删除根节点');
    	return;
    }
    $('._class_btn_save_type').show();
    var indexModify = getIndexById(id,modifyDataArr);
    modifyDataArr.splice(indexModify, indexModify);//删除
    var indexAdd = getIndexById(id,addDataArr);
    addDataArr.splice(indexAdd,1);//删除
    if(-1==indexAdd){//不是新增里面的 以前数据库就有的记录 我们放到 删除里面
    	 var indexDel = getIndexById(id,delDataArr);
    	 if(-1==indexDel) delDataArr.push(setValue(node.text, node.id, 'del', node.parentId));//新增删除
    }
    $('#faq_type_tree').tree('remove', node.target);
}
function collapse(){
    var node = $('#faq_type_tree').tree('getSelected');
    $('#faq_type_tree').tree('collapse',node.target);
}
function expand(){
    var node = $('#faq_type_tree').tree('getSelected');
    $('#faq_type_tree').tree('expand',node.target);
}


function initOther(){//初始化其他
	$('._class_btn_save_type').hide();
	$('._class_btn_add_type').click(function(){
		append('未命名');
	});
	$('._class_btn_save_type').click(function(){
		var sets = {
				url:actual_base_path+'enterprise/urFaqTypeExt_batchDealAll',
				data:{'modifyDataArr':JSON.stringify(modifyDataArr),'addDataArr':JSON.stringify(addDataArr),'delDataArr':JSON.stringify(delDataArr)},
				type:'post',
				dataType:'json',
				success:function(result){
			        if(null!=result){
			        	if(result.state==200){
			        		$.messager.alert('提示', '提交成功!');
			        		$('._class_btn_save_type').hide();
			        	}else{
			        		$.messager.alert('提示', result.message);
			        	}
			        	modifyDataArr = new Array;
			        	addDataArr = new Array;
			        	delDataArr = new Array;
			        	beforText='';
			        	//$('#faq_type_tree').tree('reload');
			        }
				},
				complete:function(){
				}
		  };
		 $.ajax(sets);
	});
	$('.item_add').click(function(){
		//新增
		openEditDailog(1);
	});
}
var beforText='';
function initTreeDate(){
     $('#faq_type_tree').tree({
		url:actual_base_path+'enterprise/urFaqTypeExt_getAllTreeNodelist?requestType=0',
		animate:true,
		lines : true,
		dnd:true,
		onClick: function(node){
        },
        onContextMenu: function(e,node){
            e.preventDefault();
            $(this).tree('select',node.target);
            if(node.id=='-1'){
            	$('#mm_root').menu('show',{
                    left: e.pageX,
                    top: e.pageY
                });
            }else{
            	$('#mm').menu('show',{
                    left: e.pageX,
                    top: e.pageY
                });
            }
        },
        onDblClick:function(node){
        	$(this).tree('beginEdit',node.target);
        },
        onBeforeDrop:function(targetNode, source, point){
        },
        onDrop: function(targetNode, source, point){   
             var targetId = $('#faq_type_tree').tree('getNode', targetNode).id;  
             $('._class_btn_save_type').show();
              if(targetId!=source.parentId){
            	  var indexAdd = getIndexById(source.id,addDataArr);
            	  if(-1!=indexAdd){//拖动新增的子节点
            		  //更新父节点
            		  addDataArr.splice(indexAdd, 1, setValue(source.text,source.id,'add',targetId));
            	  }else{
            		  var indexModify=getIndexById(source.id,modifyDataArr);//编辑的子节点
            		 if(-1!=indexModify){//编辑以前数据库node
              			modifyDataArr.splice(indexModify, 1, setValue(source.text,source.id,'edit',targetId));
              		}else{
              			modifyDataArr.push(setValue(source.text,source.id,'edit',targetId));
              		}
            	  }
              }
        },  
        onBeforeEdit:function(node){//编辑前
        	if('-1'==node.id){
            	$.messager.alert('提示', '不能编辑根节点');
            	return;
            }
        	$('._class_btn_save_type').show();
        	beforText=node.text;
        },
        onAfterEdit:function(node){//编辑以后
        	if(node.text.length>8||node.text.length<=0){
        		$.messager.alert('提示', '长度只能介于1-8之间!');
        		$('#faq_type_tree').tree('update', {
        			target: node.target,
        			text: beforText
        		});
        		return;
        	 }else{
        	  var reg=/^[A-Za-z\u4E00-\u9FA50-9_、，（）。]+$/;
        	  if(!reg.test(node.text)){
        		$.messager.alert('提示', '含有非法字符!');
        		$('#faq_type_tree').tree('update', {
        			target: node.target,
        			text: beforText
        		});
        		return;
        	 }else{
        	 if(node.text!=beforText) {
        		var indexAdd = getIndexById(node.id,addDataArr);
        		if(-1!=indexAdd){//编辑新增的子类
        			addDataArr.splice(indexAdd, 1, setValue(node.text,node.id,'add',$('#faq_type_tree').tree('getParent',node.target).id));
        		}else{
        			var indexModify=getIndexById(node.id,modifyDataArr);
        			if(-1!=indexModify){//编辑以前数据库node
        			modifyDataArr.splice(indexModify, 1, setValue(node.text,node.id,'edit',$('#faq_type_tree').tree('getParent',node.target).id));
        		    }else{
        			modifyDataArr.push(setValue(node.text,node.id,'edit',$('#faq_type_tree').tree('getParent',node.target).id));
        		  }
        		}
        	  }
        	}
          }
        }
	 });
}


//详情 格式 {"items":[{"name":"商家名称","text":"北京现代"},{"name":"上映时间","text":"2010-09-08"}],"img":{"hasImg":true,"path":"127.0.0.1/mycar/save/pic/default.jpg"}}
function getDetail(row){
	var jsonObject= getJsonObject(row);
	var style="<style type=\"text/css\">.dv-table td{border:0;}.dv-label{font-weight:bold;color:#15428B;width:100px;}</style>";
	var table="<table class=\"dv-table\" border=\"0\" style=\"width:100%;\">";
	if(jsonObject.img.hasImg==true){
		table=table+"<tr><td rowspan=\"3\" style=\"width:60px\"><img src=\"" +jsonObject.img.path||'default.jpg' +"\" style=\"margin-right:20px\" width=100 height=100 alt=\" 暂无图片\"/></td></tr>";
	}
	var i;
	for(i=0;i<jsonObject.items.length;i++){
		table=table+"<tr><td class=\"dv-label\">" +jsonObject.items[i].name+"</td><td>"+jsonObject.items[i].text+"</td></tr>";
	}
	table=table+"</table>";
	return style+table;
}

function getJsonObject(row){
	var jsonObject = new jsonObject();
	var items = new Array;
	var itemsObj = new Object();
	itemsObj.name="问题";
	itemsObj.text=row.question;
	items.push(itemsObj);
	itemsObj = new Object();
	itemsObj.name="答案";
	itemsObj.text=row.answer;
	items.push(itemsObj);
	itemsObj = new Object();
	itemsObj.name="添加时间";
	itemsObj.text=row.addDatetime;
	items.push(itemsObj);
	jsonObject.items=items;
	jsonObject.img.hasImg=false;
	return jsonObject;
}


function initFaqData(){
	$('#_id_datagrid_def').datagrid({
		url :actual_base_path+'enterprise/urFaqExt_list',
		view: detailview,
		detailFormatter:function(index,row){
	            return '<div class="ddv" style="padding:5px 0"></div>';
	        },
       onExpandRow: function(index,row){
        	var ddv = $(this).datagrid('getRowDetail',index).find('div.ddv');
        	    ddv.panel({
                 height:100,
                 border:false,
                 cache:false,
                 content:getDetail(row),
                 onLoad:function(){
                 $('#_id_datagrid_def').datagrid('fixDetailRowHeight',index);
                   }
                  });
                $('#_id_datagrid_def').datagrid('fixDetailRowHeight',index);
		                   },
				fitcolumns : true,
				nowrap:true,
				width:function(){return document.body.clientWidth*0.9;},
				singleSelect : true,
				pagination : true,
				pageList : [ 25, 50, 100, 200, 500, 1000 ],
				columns : [ [
				{
					field : 'faqTypeName',
					title : '知识类型',
					//width : 50,
					align : 'center',
					formatter: function(value,row,index){
						return value;
					}
				},
				{
					field : 'question',
					title : '问题',
					align : 'center',
					formatter: function(value,row,index){
					if(value!=null && value.length>10) return value.substring(0,10)+'......';
					return value||'';
					}
				},
				{
					field : 'answer',
					title : '回答',
					align : 'center',
					formatter: function(value,row,index){
					if(value!=null && value.length>10) return value.substring(0,10)+'......';
					return value||'';
					}
				},
				{
					field : 'picturePathAny',
					title : '最后添加的图片',
					//width : 80,
					align : 'center',
					styler: function(value,row,index){
					return 'background-color:#ffee00;color:red;';
					// the function can return predefined css class and inline style
					// return {class:'c1',style:'color:red'}
					},
					formatter: function(value,row,index){
						if(value!=null && value.length>10) return value.substring(0,10)+'......';
						return value||'';
						}
				},
				{
					field : 'clickNum',
					title : '点击次数',
					//width : 80,
					align : 'center',
					styler: function(value,row,index){
					//return 'background-color:#ffee00;color:red;';
					// the function can return predefined css class and inline style
					// return {class:'c1',style:'color:red'}
					},
					formatter: function(value,row,index){
						return value;
				  }
				},
				{
					field : 'praiseNum',
					title : '被赞次数',
					//width : 80,
					align : 'center',
					styler: function(value,row,index){
					//return 'background-color:#ffee00;color:red;';
					// the function can return predefined css class and inline style
					// return {class:'c1',style:'color:red'}
					},
					formatter: function(value,row,index){
						return value;
				  }
				},
				{
					field : 'debaseNum',
					title : '被贬低次数',
					//width : 80,
					align : 'center',
					styler: function(value,row,index){
					//return 'background-color:#ffee00;color:red;';
					// the function can return predefined css class and inline style
					// return {class:'c1',style:'color:red'}
					},
					formatter: function(value,row,index){
						return value;
				  }
				},
				{
					field : 'favNum',
					title : '收藏次数',
					align : 'center',
					styler: function(value,row,index){
					//return 'background-color:#ffee00;color:red;';
					// the function can return predefined css class and inline style
					// return {class:'c1',style:'color:red'}
					},
					formatter: function(value,row,index){
						return value;
				  }
				},
				{
					field : 'addDatetime',
					title : '添加时间',
					align : 'center'
				},
				{
					field : 'effectDatetime',
					title : '生效时间',
					align : 'center'
				},
				{
					field : 'invalidDatetime',
					title : '失效时间',
					align : 'center'
				},
				{
					field : 'createUserName',
					title : '创建人',
					align : 'center'
				},
				{
					field : 'updateUserName',
					title : '修改人',
					align : 'center'
				},
				{
					field : 'id',
					title : '操作',
					width : 100,
					align : 'center',
					formatter : function(value, row, index) {
						var sbsp = "　";
						var enter_self = $.createLink({
							content : '<img src="../images/t02.png" />',
							attrs : {
								href:"#",
								onClick: "openEditDailog('" + value + "','"+row.imgPath+"');"
							}
						});
								
						var del_self = $.createLink({
							content : '<img src="../images/t03.png" />',
							attrs : {
								href:"#",
                                onClick: "openDeleteDailog('" + value + "','businessExt_deleteBusiness.action');"
								//"class":"auto-ajax",
								//url: "business_delete.action?record.id=" + value,
								//message : "你确定要删除这条记录吗?",
								//success : "doRefreshDatagrid();"
							}
						});
						
						if(row.enable == 0){
							return enter_self + sbsp + del_self;
						}
						return '无';
					}
				}
				] ]
		,onLoadSuccess : function(data) {
			if (!aj_ready) {
				$.autoajax(".datagrid-body", ".auto-ajax");
				aj_ready = true;
			}
		}
		,onDblClickRow : function(rowIndex, rowData) {
			openEditDailog(rowData.id,rowData.imgPath);
		}
		,queryParams:{'beanProxy.enable':1}
	});
	
}


function initFroms(){
	$('#_form_default_type').form({
		url :actual_base_path + '/faqType/insert',
		onBeforeLoad : function(param){
			$.messager.progress();
		},
		onLoadSuccess : function(data) {
			//加载完成之后才构建
			$.messager.progress("close");
		},
		onLoadError : function(data) {
			//加载完成之后才构建
			$.messager.progress("close");
			$.messager.alert('提示', "加载内容失败,请重新刷新页面/联系管理员", "error");
		},
		onSubmit : function(param) {
			if (!$(this).form("validate")) {
				$.messager.alert('提示', "提交的选项中,有错误内容,请检查", "error");
				return false;
			}
			$.messager.progress();
		},
		success : function(data) {	
			//alert(data);
			$.messager.progress("close");
			var jd = eval('(' + data + ')');
			if(!!!jd){
				$.messager.alert('提示', "未知异常", "error");
				return false;
			}
			
			if (jd.success == false) {
				$.messager.alert('提示', jd.message, "error");
				//异常
			} else  {
				//成功
				$.messager.alert('提示', '提交成功!');
				$('#dlgFaqType').dialog('close');
				$('#faqtype').treegrid('reload');
				//parent.doRefreshDatagrid();
				//parent._doCloseDailog();
				
			} 
		}
	});

}



function updateType(id,pid,text){
	var row=new Object();
	row.id=id;
	row.name=text;
	$('#parentId').combotree({  
	    panelHeight:'auto',
	    width:'auto',
		url : actual_base_path + '/faqType/querySelectTreeType',
		cascadeCheck:true,
		//onlyLeafCheck:true,
		required:true,
		onLoadSuccess:function(){
		  $('#parentId').combotree('setValue',pid);
		},
		onSelect: function(node){  
			var tree = $(this).tree;
 			var isLeaf = tree('isLeaf', node.target);
 			if (isLeaf){
 			  $('#parentId').combotree('clear');
 			}
		  }
	}); 
    $('#_form_default_type').form('clear');
    $('#_form_default_type').form('load',row);
	$('#dlgFaqType').dialog('open').dialog('setTitle','配置类型');
}

function addNextType(id){
	$('#parentId').combotree({  
	    panelHeight:'auto',
	    width:'auto',
		url : actual_base_path + '/faqType/querySelectTreeType',
		cascadeCheck:true,
		onlyLeafCheck:true,
		required:true,
		multiple:true,
		onLoadSuccess:function(){
		  $('#parentId').combotree('setValue',id);
		},
		onSelect: function(node){  
			var tree = $(this).tree;
 			var isLeaf = tree('isLeaf', node.target);
 			if (isLeaf){
 			  $('#parentId').combotree('clear');
 			}
		  }
	}); 
   $('#_form_default_type').form('clear');
   $('#dlgFaqType').dialog('open').dialog('setTitle','配置类型');
}

$(function() {
	initTreeDate();
	initFroms();
	initOther();
	initFaqData();
	function _onDialogEnter(){
		$('#_id_power_type').val(JSON.stringify(arr));
		$('#_form_default').submit();
	}
	
	$("._class_submit").click(function(e){
		e.preventDefault();
		e.stopPropagation();
		return false;
	});
});
	function saveDataType(){
		//$("#_form_default").serialize(),
		$('#_form_default_type').submit();
	}

function _onDefSubmit(){
	$('#my_power_value').attr('value',$('#_id_power_type').combotree('getValues'));
	$('#_form_default').submit();
}
function _doSubmitFrameForm(){
	window.frames['_id_iframe']._onDefSubmit();
}

function openEditDailog(id){
	openAddDialog("faq_edit.jsp?id=" + id, function() {
		_doSubmitFrameForm();
	});
}

