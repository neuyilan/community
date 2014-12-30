 $(document).ready(function(){
				 
				$(".navlist > a").each(function(index, obj) {
					var sleave;
					$(obj).parent().find("ul").mouseover(function(e) {
	                    sleave=false;
	                });
					$(obj).parent().find("ul").mouseleave(function(e) {
	                    sleave=true;
						if(sleave==true){
						    $(obj).parent().find("ul").slideUp();
							sleave=false;
					  }
	                });

					
					$(obj).click(function(){
						if($(obj).parent().find("ul").is(":hidden")){
						
							$(obj).parent().find("ul").hide();
							$("#oneul li ul").slideUp();
							$(obj).parent().find("ul").slideDown();
						
						}else{
							$(obj).parent().find("ul").slideUp();
						}
				  });
				});		
				
				$('#oneul').find('ul>li').each(function(index, obj) {
					bindClick($(obj));
				});
				
				//日期选择表单
				$( "#dateDialog").dialog({
					autoOpen: false,
					height: 300,
					width: 500,
					modal: true,
					buttons: {
						"确定": function() {
								if($('#setStartTime').val() == '' || $('#setEndTime').val() == '') {
									alert('您必须选择开始和结束日期');return;
								}else{
									$('#timeScope').val('');
									$('#startTime').val($('#setStartTime').val());
									$('#endTime').val($('#setEndTime').val());
									$( this ).dialog( "close" );
									//查询
									jump(0);
									$('#oneul').find(".erjnav").slideUp();
								}
						},
						"取消": function() {
							$('#startTime').val('');
							$('#endTime').val('');
							$( this ).dialog( "close" );
						}
					},
					close: function() {
					}
				});
				
				$( "#setStartTime" ).datepicker({
					//defaultDate: "+1w",
					autoSize: true,
					changeMonth: true,
					changeYear: true,
					numberOfMonths: 1,
					onClose: function( selectedDate ) {
						$( "#setEndTime" ).datepicker( "option", "minDate", selectedDate );
					}
				},
				$.datepicker.regional['zh-CN']);
				
				$( "#setEndTime" ).datepicker({
					//defaultDate: "+1w",
					autoSize: true,
					changeMonth: true,
					changeYear: true,
					numberOfMonths: 1,
					onClose: function( selectedDate ) {
						$( "#setStartTime" ).datepicker( "option", "maxDate", selectedDate );
					}
				},
				$.datepicker.regional['zh-CN']);
				
			});
	
 	 function searchChange(obj) {
 		var idStr = $(obj).attr('id');
		var field = idStr.substring(0, (idStr.indexOf('_')));
		var idKey = idStr.substring(idStr.indexOf('_')+1);
		if(field==="comId"){
			 $('#estateUL').prev().val("");
		     $('#estateUL').prev().prev().find('span').text("所有小区");
		}
		
		//if(idKey != '') {//选中一项
			//判断是字段还是时间范围,如果是字段直接赋值，并显示展示选中项，如果是时间范围则要弹出时间段选择框并赋值开始结束时间,最后提交参数到后台查询数据
			if(idKey != 'scope') {
				//直接赋值并显示展示
				if(field == 'timeScope') {
					$('#startTime').val('');
					$('#endTime').val('');
				}
				$('#'+field).val(idKey);
				//讲置顶项重新构造添加到选项列表
				var text = $('#'+idStr).parent().parent().find('span').text();
				var li_id = $('#'+idStr).parent().parent().attr('id');
				var newLi = '<li id="'+li_id+'"><a href="javascript:;">'+text+'</a></li>';
				$('#'+idStr).parent().append(newLi);
				//获取选择项内容和ID
				var itemText = $('#'+idStr).first().text();
				var itemId = $('#'+idStr).attr('id');
				var ulObj = $('#'+idStr).parent();
				//删除选择项并将其拷贝到置顶项
				$('#'+idStr).remove();
				$(ulObj).parent().find('span').text(itemText);
				$(ulObj).parent().attr('id', itemId);
				//初始化绑定操作
				bindClick($('#'+li_id));
				$('#oneul').find(".erjnav").slideUp();
				//执行搜索
				jump(1);
			}else{
				//弹出时间范围选择框
				$( "#dateDialog" ).dialog( "open" );
			}
 	 }
 	 
 	function bindChange(obj) {
 		var idStr = $(obj).attr('id');
		var field = idStr.substring(0, (idStr.indexOf('_')));
		var idKey = idStr.substring(idStr.indexOf('_')+1);
		//if(idKey != '') {//选中一项
			//判断是字段还是时间范围,如果是字段直接赋值，并显示展示选中项，如果是时间范围则要弹出时间段选择框并赋值开始结束时间,最后提交参数到后台查询数据
			if(idKey != 'scope') {
				//直接赋值并显示展示
				if(field == 'timeScope') {
					$('#startTime').val('');
					$('#endTime').val('');
				}
				$('#'+field).val(idKey);
				//讲置顶项重新构造添加到选项列表
				var text = $('#'+idStr).parent().parent().find('span').text();
				var li_id = $('#'+idStr).parent().parent().attr('id');
				var newLi = '<li id="'+li_id+'"><a href="javascript:;">'+text+'</a></li>';
				$('#'+idStr).parent().append(newLi);
				//获取选择项内容和ID
				var itemText = $('#'+idStr).first().text();
				var itemId = $('#'+idStr).attr('id');
				var ulObj = $('#'+idStr).parent();
				//删除选择项并将其拷贝到置顶项
				$('#'+idStr).remove();
				$(ulObj).parent().find('span').text(itemText);
				$(ulObj).parent().attr('id', itemId);
				//初始化绑定操作
				bindClick($('#'+li_id));
				$('#oneul').find(".erjnav").slideUp();
				//执行搜索
				//jump(1);
			}else{
				//弹出时间范围选择框
				$( "#dateDialog" ).dialog( "open" );
			}
 	 }
 	 
	 function bindClick(obj) {
		$(obj).click(function() {
			searchChange(obj);
		});
	}
	 
    //模糊搜索
	function search() {
		jump(1);
	}
	
	//切换页号样式
	function setCurrPageNo(pageNo) {
		//console.log(pageNo)
		pageNo=parseInt(pageNo)
		var vis = $("#pageUl li:not(#pageUl :first,#pageUl :last):visible");//显示的数量
		var all = $("#pageUl li");
		var size = all.size()-2
		console.log(all)
		console.log("vis",vis)
		if($('#curr').first().text() != pageNo) {
			$('#curr').attr('id', 'old');
			$('#page_'+pageNo).parent().attr('id', 'curr');
		}
		if(all.eq(pageNo).find("span").text()==1 || all.eq(pageNo).find("span").text()==2 || all.eq(pageNo).find("span").text()==3 || all.eq(pageNo).find("span").text()==4){
			$("#pageUl li:not(#pageUl :first,#pageUl :last)").hide();
			$("#pageUl li").eq(1).show();
			$("#pageUl li").eq(2).show();
			$("#pageUl li").eq(3).show();
			$("#pageUl li").eq(4).show();
			$("#pageUl li").eq(5).show();
			return ;
		}else if (all.eq(pageNo).find("span").text()==size || all.eq(pageNo).find("span").text()==size-1 || all.eq(pageNo).find("span").text()==size-2 || all.eq(pageNo).find("span").text()==size-3){
			$("#pageUl li:not(#pageUl :first,#pageUl :last)").hide();
			$("#pageUl li").eq(size).show();
			$("#pageUl li").eq(size-1).show();
			$("#pageUl li").eq(size-2).show();
			$("#pageUl li").eq(size-3).show();
			$("#pageUl li").eq(size-4).show();
			return ;
		}
		//console.log("size",vis.size)
		if(vis.size()==5){
			//console.log("text",vis.eq(0).find("span").text(),all.eq(pageNo).find("span").text());
			if(vis.eq(0).find("span").text()==all.eq(pageNo).find("span").text()){
				//console.log("前")
				$("#pageUl li:not(#pageUl :first,#pageUl :last)").hide();
				$("#pageUl li").eq(pageNo+1).show();
				$("#pageUl li").eq(pageNo).show();
				//alert(pageNo+1)
				$("#pageUl li").eq(pageNo-1).show();
				$("#pageUl li").eq(pageNo-2).show();
				$("#pageUl li").eq(pageNo-3).show();
			}else if (vis.eq(4).find("span").text()==all.eq(pageNo).find("span").text()){
				//console.log("后")
				$("#pageUl li:not(#pageUl :first,#pageUl :last)").hide();
				$("#pageUl li").eq(pageNo-1).show();
				$("#pageUl li").eq(pageNo).show();
				$("#pageUl li").eq(pageNo+1).show();
				$("#pageUl li").eq(pageNo+2).show();
				$("#pageUl li").eq(pageNo+3).show();
			}
		}else{
			//console.log("text",vis.eq(0).find("span").text(),all.eq(pageNo).find("span").text())
			if(vis.eq(0).find("span").text()==all.eq(pageNo).find("span").text()){
				$("#pageUl li:not(#pageUl :first,#pageUl :last)").hide();
				$("#pageUl li").eq(pageNo+1).show();
				$("#pageUl li").eq(pageNo).show();
				//alert(pageNo+1)
				$("#pageUl li").eq(pageNo-1).show();
				$("#pageUl li").eq(pageNo-2).show();
				$("#pageUl li").eq(pageNo-3).show();
			}else{
				$("#pageUl li:not(#pageUl :first,#pageUl :last)").hide();
				
				$("#pageUl li").eq(pageNo+1).show();
				$("#pageUl li").eq(pageNo).show();
				//alert(pageNo+1)
				$("#pageUl li").eq(pageNo-1).show();
				$("#pageUl li").eq(pageNo-2).show();
				$("#pageUl li").eq(pageNo-3).show();
			}
		}
		/*$("#pageUl li:not(#pageUl :first,#pageUl :last)").hide();
		$("#pageUl li").eq(pageNo).show();
		//alert(pageNo+1)
		$("#pageUl li").eq(pageNo+1).show();
		$("#pageUl li").eq(pageNo+2).show();
		
		$("#pageUl li").eq(pageNo+3).show();
		$("#pageUl li").eq(pageNo+4).show();
		console.log($("#pageUl li:not(#pageUl :first,#pageUl :last):visible").eq(0)==$("#pageUl li").eq(pageNo))
		console.log($("#pageUl li:not(#pageUl :first,#pageUl :last):visible").eq(0).find("span").text(),"11")
		console.log($("#pageUl li").eq(pageNo).find("span").text(),"22")
		console.log($("#pageUl li:not(#pageUl :first,#pageUl :last):visible").size())
		//$("#pageUl li").hide();
		//alert(!((pageNo-1)%5))
		if(!((pageNo-1)%5)){
			$("#pageUl li:not(#pageUl :first,#pageUl :last)").hide();
			//alert(pageNo)
			$("#pageUl li").eq(pageNo).show();
			//alert(pageNo+1)
			$("#pageUl li").eq(pageNo+1).show();
			$("#pageUl li").eq(pageNo+2).show();
			
			$("#pageUl li").eq(pageNo+3).show();
			$("#pageUl li").eq(pageNo+4).show();
		}*/
	}
 
//上一页
 function prev() {
 	var currNo = $('#curr').first().text();
 	var prevNo = parseInt(currNo) - 1;
 	if(prevNo <= 0) {
 		prevNo = 1;
 	}
 	jump(prevNo);
 }
 
 //下一页
 function next() {
 	var currNo = $('#curr').first().text();
 	var nextNo = parseInt(currNo) + 1;
 	var pageCount = $('#pageCount').val();
 	if(nextNo > pageCount) {
 		nextNo = pageCount;
 	}
 	jump(nextNo);
 }
 
 $(function(){
	 setCurrPageNo(1);
 });
 
 function pv_q(u,w,h){ 
	 var pv=''; 
	 pv += '<object width="'+w+'" height="'+h+'" classid="clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B" codebase="http://www.apple.com/qtactivex/qtplugin.cab">'; 
	 pv += '<param name="src" value="'+u+'">'; 
	 pv += '<param name="controller" value="true">'; 
	 pv += '<param name="type" value="video/quicktime">'; 
	 pv += '<param name="autoplay" value="false">'; 
	 pv += '<param name="target" value="myself">'; 
	 pv += '<param name="bgcolor" value="black">'; 
	 pv += '<param name="pluginspage" value="http://www.apple.com/quicktime/download/index.html">'; 
	 pv += '<embed src="'+u+'" width="'+w+'" height="'+h+'" controller="true" align="middle" bgcolor="black" target="myself" type="video/quicktime" pluginspage="http://www.apple.com/quicktime/download/index.html"></embed>'; 
	 pv += '</object>'; 
	 document.write(pv); 
}