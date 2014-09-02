(function($) {
	
	$.ep_upload_plugin = {};
	
	function buildUploadImg(key,imgUrl){
		imgUrl = $.trim(imgUrl);
		if(!imgUrl.length){
			return ;
		}
		
		var img = $("#" + key + "_img");
		var wrap = $("#" + key + "_loading_wrap");
		if(img.length){
			img.attr("src", actual_base_path + imgUrl);
		}else{
			img = wrap.append('<img id="' + key + '_img" src="' + actual_base_path + imgUrl + '" />');
		}
		$("#" + key + "_hide").val(imgUrl);
		$("#" + key + "_txt").text("重新上传");
	}
	
	$.ep_upload_plugin.initUploadImg = function(key){
		var _up_icon_hide = $("#" + key + "_hide");
		//alert(_up_icon_hide.attr("value"));
		if(_up_icon_hide){
			var imgUrl = _up_icon_hide.val();
			buildUploadImg(key,imgUrl);
		}
	}
	
	function bindFileupload(key){
		
		$("#" + key + "_file").fileupload({
			url: actual_base_path + 'imageFileExt_uploadForJuf',
			type: "POST",
			dataType: "json",
			sequentialUploads: true,
			submit: function(a, b) {
				return b.files[0].size > 2097152 ? (alert("文件大小超过2M，请重新选择"), !1) : void 0;
			},
			formData:{id:"test1"},
			start : function(e){
				console.log("upload start");
				$("#" + key + "_loading").show();
			},
			stop: function(e){
				console.log("upload stop");
				$("#" + key + "_loading").hide();
			},
			done : function(e,data){
				var jd = data.result;
				if(!!!jd){
					alert("上传文件异常");
				}
			
				if (jd.state > 499) {
					alert(jd.message);
					//异常
				} else if (jd.state > 199) {
					//成功
					//parent.refreshDatagrid();
					//parent.closeWindow();
					//$.messager.alert('提示', '提交成功!');
					//location.reload(true);
					var data = jd.data;
					$("#" + key + "_loading").hide();
					var imgUrl = data.imgUrl; 
					buildUploadImg(key,imgUrl);
                    //c.hasClass("front") ? d.person_certification_image_front = b.result.name: d.person_certification_image_back = b.result.name)
				} else if (jd.state > 0) {
					//失败
					alert(jd.message);
				}
				
				console.log("upload done");
				console.log(data);
			},
			fail: function(e,data){
				console.log("upload fail");
				console.log(data);
			}
		});
	}
	
	$(function(){
		bindFileupload("up_icon");
	});
})(jQuery);