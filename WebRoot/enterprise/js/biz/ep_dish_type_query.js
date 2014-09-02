$(function() {
	$("#dish_type_cache_tree").tree({
		onDblClick : function(node){
			
			if(typeof _callback_id === "string" && _callback_id.length > 0){
				var parentNode = $("#dish_type_cache_tree").tree('getParent',node.target);
				//触发类型改变事件
				parent['_cacheCallbacks'][_callback_id]['onSelect'](node,parentNode);
			}
			//关闭窗口
			parent._doCloseCacheDailog();
			
			//父节点 getParent
		}
	});
	
});

function doSearchDishType(value,name){
	//赛选结果
	$("#dish_type_cache_tree").tree('search',value);
}
