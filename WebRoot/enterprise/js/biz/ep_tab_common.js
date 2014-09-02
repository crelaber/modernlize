$(function(){
	
	if($.isNotNull(_tabcode)){
		$("._tab_common").each(function(idx,obj){
			var _this = $(obj);
			var this_tabcode = $.renderTemplate($.trim(_this.attr("tabcode")),window);
			if(this_tabcode === _tabcode){
				_this.addClass("selected");
				_this.click(function(event){
					event.preventDefault();
					event.stopPropagation();
					return false;
				});
			}else{
				window.this_tabcode = this_tabcode;
				var href = $.renderTemplate(_this.attr("href"),window);
				//var location_href = actual_base_path + href + "?_tabcode=" + this_tabcode;
				//#{actual_base_path}#{href}?_tabcode=#{this_tabcode};
				_this.attr("href",href);
				//_this.click(function(event){
					//location.href = location_href;
				//});
			}
		});
	}
	
});