<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<title>精品投票活动参与人详情</title>
	<%@include file="/common/meta.jsp"%>
	<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
	<link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
	<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
	<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
	<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
	<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
	
	<script type="text/javascript">
		$(function () {
			$(document).keyup(function(event){
			  	if(event.keyCode ==13){
			    	$("#searbut").trigger("click");
			  	}
			});
		});
		
	    //搜索
	    function search(flagId) {
	      	jump(1,' ${pager.pageSize}', flagId);
	    }
	    
	  	//标签页切换
	  	$(document).ready(function(){
	    	//报名中
	    	$('#bmz').click(function() {
	    		$("#jpzz").removeClass("hd-active");
	    		$("#bmz").addClass("hd-active");
	    		$("#tpz").removeClass("hd-active");
	    		
	    		$("#searchId").empty();
	    		var searchDom = '<div class="scroll-box">'
	    			+ '<ul id="oneul">'
	    			+ '<li id="orderBy_" class="navlist"><a href="javascript:;"><span>最新时间排序</span><b class="donbut"><i></i></b></a>'
	    			+ '<input type="hidden" name="orderBy" id="orderBy" value="" />'
	    			+ '<ul class="erjnav">'
	    			+ '<li id="orderBy_code"><a href="javascript:;">按编号排序</a></li>'
	    			+ '</ul>'
	    			+ '</li>'
	    			+ '<li id="comId_" class="navlist"><a href="javascript:;"><span>所有社区</span><b class="donbut"><i></i></b></a> '
	    			+ '<input type="hidden" name="flagId" id="flagId" value="bmz" /> '
	    			+ '<input type="hidden" name="comId" id="comId" value="" /> '
	    			+ '<ul class="erjnav">'
	    			+ '<c:forEach items="${comList }" var="comBean" varStatus="key">'
	    			+ '<li id="comId_${comBean.comId }"><a href="javascript:;">${comBean.comName }</a></li>'
	    			+ '</c:forEach>'
	    			+ '</ul>'
	    			+ '</li>'
	    			+ '<li id="estateId_" class="navlist"><a href="javascript:;"><span>所有小区</span><b class="donbut"><i></i></b></a> '
	    			+ '<input type="hidden" name="estateId" id="estateId" value="" /> '
	    			+ '<ul id="estateUL" class="erjnav"></ul>'
	    			+ '</li>'
	    			+ '</ul>'
	    			+ '</div>'
	    			+ '<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder="标题/内容搜索" /><input id="searbut" type="button" onclick="search(\'bmz\')" value="" /></div></div>';
	    		$("#searchId").append(searchDom);
	    		
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
				
	    		var flagId = "bmz";
		  		var params = {actId: '${businessActivity.actId}', flag: 2};
		  		
	    		$.ajax({
		      		type: 'post',
		            url: '<%=path %>/business/businessActReg/list.do',
		            dataType: 'json',
		            data: params,
		            cache: false,
		            success: function (data) {
		            	$("#rowCount").html("共有<em>" + data.total + "</em>人报名");  // 根据查询条件更新总条数
		                var rows = data.rows;
		                if(rows.length > 0) {
		                	$('#review2-b').html('');
		                	for(var i=0;i<rows.length;i++) {
		                    	var row = rows[i];  
		                    	var flagDiv = "";
		                		if(row.flag == 2) {
		                			flagDiv = '<div class="hd-adetail bmz-start">'
		                    			+ '<a style="cursor:pointer;" onclick="startTPZinfo('+row.regId+', \''+row.picUrl+'\')">开始投票</a>'
		                    			+ '</div>';
		                		}
		                    	var htmlDom = ''
		                    		+ '<div class="cominfo hdinfo">'
		                    		+ '<a class="cominfobox tpbox hdbox bmzbox" href="javascript:;">'
		                    		+ '<span class="rakin">'+row.code+'</span>'
		                    		+ '<p class="hd-img bmz-img"><img src="<%=ctx%>'+row.picUrl+'"/><em>'+row.count+'</em></p>'
		                    		+ '<div class="textinfo tpinfo">'
		                    		+ '<p><span>'+row.nickName+'</span></p>'
		                    		+ '<p class="hd-yzname">'+row.estateName+'</p>'
		                    		+ '<p>提交日期：<span style="font-size:18px">'+(row.regTime != '' && row.regTime != "null" ? row.regTime.substring(0, 16) : '')+'</span></p>'
		                    		+ '</div>'
		                    		+ '<p class="hd-intro">'+row.content+'</p>'
		                    		+ '</a>'
		                    		+ '<div class="hd-adetail bmz-bj">'
		                    		+ '<a style="cursor:pointer;" onclick="updateActReg('+row.regId+')">编辑资料</a>'
		                    		+ '</div>'
		                    		+ flagDiv
		                    		+ '</div>';
		                    	$('#review2-b').append(htmlDom);
		                    }
		                }else{
		                	$('#review2-b').html('');
		                }
		                $('#review2-b').append('<div class="no-float"></div>');
		                
		                var vis = $("#pageUl li:not(#pageUl :first,#pageUl :last):visible");//显示的数量
		               	var liCount = '';  
		                for(var pageno=1; pageno<=(data.pageCount); pageno++){
		                	var flag=false;
		                	for(var i=0;i<vis.size();i++){
		                		if(vis.eq(i).find("span").text()==pageno){
		                			flag=true;
		                		}
		                	}
		                	if(flag){
		                		liCount = liCount + '<li><a   href="javascript:jump('+pageno+','+data.pageSize+', \''+flagId+'\');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
		                	}else{
		                		liCount = liCount + '<li style="display:none";><a  href="javascript:jump('+pageno+','+data.pageSize+', \''+flagId+'\');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
		                	}
		                }
		                var boolnext = '';
		                if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next('+data.pageSize+', \''+flagId+'\');'; }
		                var boolprev = '';
		                if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev('+data.pageSize+', \''+flagId+'\');';  }
			           	var pageDom = ''
			           		+ '<div class="pagec"><ul id="pageUl">'
			           		+ '<li><a id="arrow-l" class="arrow" href="'+boolprev+'"></a></li>'
			           		+ liCount
			           		+ '<li><a id="arrow-r" class="arrow" href="'+boolnext+'"></a></li>'
			           		+ '</ul></div>';
			           	$('.page').html('');
		            	$('.page').html(pageDom);
			            setCurrPageNo(1);
		            },
		            error: function () {
		            	$('#review2-b').html('很抱歉，加载内容出错，我们及时修改问题。');
		            }
		        });
	    	});
	    	
	    	//投票中
	    	$('#tpz').click(function() {
	    		$("#jpzz").removeClass("hd-active");
	    		$("#bmz").removeClass("hd-active");
	    		$("#tpz").addClass("hd-active");
	    		
	    		$("#searchId").empty();
	    		var searchDom = '<div class="scroll-box">'
	    			+ '<ul id="oneul">'
	    			+ '<li id="orderBy_" class="navlist"><a href="javascript:;"><span>按名次排序</span><b class="donbut"><i></i></b></a>'
	    			+ '<input type="hidden" name="orderBy" id="orderBy" value="" />'
	    			+ '<ul class="erjnav">'
	    			+ '<li id="orderBy_code"><a href="javascript:;">按编号排序</a></li>'
	    			+ '</ul>'
	    			+ '</li>'
	    			+ '<li id="comId_" class="navlist"><a href="javascript:;"><span>所有社区</span><b class="donbut"><i></i></b></a> '
	    			+ '<input type="hidden" name="flagId" id="flagId" value="tpz" /> '
	    			+ '<input type="hidden" name="comId" id="comId" value="" /> '
	    			+ '<ul class="erjnav">'
	    			+ '<c:forEach items="${comList }" var="comBean" varStatus="key">'
	    			+ '<li id="comId_${comBean.comId }"><a href="javascript:;">${comBean.comName }</a></li>'
	    			+ '</c:forEach>'
	    			+ '</ul>'
	    			+ '</li>'
	    			+ '<li id="estateId_" class="navlist"><a href="javascript:;"><span>所有小区</span><b class="donbut"><i></i></b></a> '
	    			+ '<input type="hidden" name="estateId" id="estateId" value="" /> '
	    			+ '<ul id="estateUL" class="erjnav"></ul>'
	    			+ '</li>'
	    			+ '</ul>'
	    			+ '</div>'
	    			+ '<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder="标题/内容搜索" /><input id="searbut" type="button" onclick="search(\'tpz\')" value="" /></div></div>';
	    		$("#searchId").append(searchDom);
	    		
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
				
	    		var flagId = "tpz";
		  		var params = {actId: '${businessActivity.actId}', flag: 0};
	    		
	    		$.ajax({
		      		type: 'post',
		            url: '<%=path %>/business/businessActReg/list.do',
		            dataType: 'json',
		            data: params,
		            cache: false,
		            success: function (data) {
		            	$("#rowCount").html("共有<em>" + data.total + "</em>人参与投票");  // 根据查询条件更新总条数
		                var rows = data.rows;
		                if(rows.length > 0) {
		                	$('#review2-b').html('');
		                	for(var i=0;i<rows.length;i++) {
		                    	var row = rows[i];  
		                    	var htmlDom = ''
		                    		+ '<div class="cominfo hdinfo">'
		                    		+ '<a class="cominfobox tpbox hdbox" href="javascript:;">'
		                    		+ '<span class="rakin">'+(i+1) +'</span>'
		                    		+ '<p class="hd-img"><img src="<%=ctx%>'+row.avatar+'"/></p>'
		                    		+ '<div class="textinfo tpinfo">'
		                    		+ '<p><em>'+row.code+'号</em><span>'+row.nickName+'</span></p>'
		                    		+ '<p class="hd-yzname">'+row.estateName+'</p>'
		                    		+ '<p><em>'+row.votes+'</em>票</p>'
		                    		+ '</div>'
		                    		+ '<p class="hd-intro">'+row.content+'</p>'
		                    		+ '</a>'
		                    		+ '<div class="hd-adetail">'
		                    		+ '<a style="cursor:pointer;" onclick="seeTPZDetail('+(i+1) +', '+row.regId+')">查看详情</a>'
		                    		+ '</div>'
		                    		+ '</div>';
		                    	$('#review2-b').append(htmlDom);
		                    }
		                }else{
		                	$('#review2-b').html('');
		                }
		                $('#review2-b').append('<div class="no-float"></div>');
		                
		                var vis = $("#pageUl li:not(#pageUl :first,#pageUl :last):visible");//显示的数量
		               	var liCount = '';  
		                for(var pageno=1; pageno<=(data.pageCount); pageno++){
		                	var flag=false;
		                	for(var i=0;i<vis.size();i++){
		                		if(vis.eq(i).find("span").text()==pageno){
		                			flag=true;
		                		}
		                	}
		                	if(flag){
		                		liCount = liCount + '<li><a   href="javascript:jump('+pageno+','+data.pageSize+', \''+flagId+'\');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
		                	}else{
		                		liCount = liCount + '<li style="display:none";><a  href="javascript:jump('+pageno+','+data.pageSize+', \''+flagId+'\');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
		                	}
		                }
		                var boolnext = '';
		                if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next('+data.pageSize+', \''+flagId+'\');'; }
		                var boolprev = '';
		                if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev('+data.pageSize+', \''+flagId+'\');';  }
			           	var pageDom = ''
			           		+ '<div class="pagec"><ul id="pageUl">'
			           		+ '<li><a id="arrow-l" class="arrow" href="'+boolprev+'"></a></li>'
			           		+ liCount
			           		+ '<li><a id="arrow-r" class="arrow" href="'+boolnext+'"></a></li>'
			           		+ '</ul></div>';
			           	$('.page').html('');
		            	$('.page').html(pageDom);
			            setCurrPageNo(1);
		            },
		            error: function () {
		            	$('#review2-b').html('很抱歉，加载内容出错，我们及时修改问题。');
		            }
		        });
	    	});
	    	
	    	//奖品赞助
	    	$('#jpzz').click(function() {
	    		$("#jpzz").addClass("hd-active");
	    		$("#bmz").removeClass("hd-active");
	    		$("#tpz").removeClass("hd-active");
	    		$("#searchId").empty();
	    		var searchDom = '<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder="标题/内容搜索" /><input id="searbut" type="button" onclick="search(\'jpzz\')" value="" /></div></div>';
	    		$("#searchId").append(searchDom);
	    		
	    		var flagId = "jpzz";
		  		var params = {actId: '${businessActivity.actId}'};
    	  		
	    		$.ajax({
		      		type: 'post',
		            url: '<%=path %>/business/businessSponsor/list.do',
		            dataType: 'json',
		            data: params,
		            cache: false,
		            success: function (data) {
		            	$("#rowCount").html("共有<em>" + data.total + "</em>人提供赞助");  // 根据查询条件更新总条数
		                var rows = data.rows;
		                if(rows.length > 0) {
		                	$('#review2-b').html('');
		                	for(var i=0;i<rows.length;i++) {
		                    	var row = rows[i];  
		                    	var htmlDom = ''
	                    		+ '<div class="cominfo zsinfo">'
	                    		+ '<a class="cominfobox zs-tinfo" href="javascript:;">'
	                    		+ '<div class="zs-info">'
	                    		+ '<p class="zs-name">'+row.sponsorName+'</p>'
	                    		+ '<p class="zs-phone">'+row.sponsorPhone+'</p>'
	                    		+ '</div>'
	                    		+ '<p class="hd-intro">'+row.sponsorContent+'</p>'
	                    		+ '</a>'
	                    		+ '<div class="hd-adetail">'
	                    		+ '<a style="cursor:pointer;" onclick="seeJPZZDetail('+row.sponsorId+')">查看详情</a>'
	                    		+ '</div>'
	                    		+ '</div>';
		                    	$('#review2-b').append(htmlDom);
		                    }
		                }else{
		                	$('#review2-b').html('');
		                }
		                $('#review2-b').append('<div class="no-float"></div>');
		                
		                var vis = $("#pageUl li:not(#pageUl :first,#pageUl :last):visible");//显示的数量
		               	var liCount = '';  
		                for(var pageno=1; pageno<=(data.pageCount); pageno++){
		                	var flag=false;
		                	for(var i=0;i<vis.size();i++){
		                		if(vis.eq(i).find("span").text()==pageno){
		                			flag=true;
		                		}
		                	}
		                	if(flag){
		                		liCount = liCount + '<li><a   href="javascript:jump('+pageno+','+data.pageSize+', \''+flagId+'\');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
		                	}else{
		                		liCount = liCount + '<li style="display:none";><a  href="javascript:jump('+pageno+','+data.pageSize+', \''+flagId+'\');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
		                	}
		                }
		                var boolnext = '';
		                if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next('+data.pageSize+', \''+flagId+'\');'; }
		                var boolprev = '';
		                if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev('+data.pageSize+', \''+flagId+'\');';  }
			           	var pageDom = ''
			           		+ '<div class="pagec"><ul id="pageUl">'
			           		+ '<li><a id="arrow-l" class="arrow" href="'+boolprev+'"></a></li>'
			           		+ liCount
			           		+ '<li><a id="arrow-r" class="arrow" href="'+boolnext+'"></a></li>'
			           		+ '</ul></div>';
			           	$('.page').html('');
		            	$('.page').html(pageDom);
			            setCurrPageNo(1);
		            },
		            error: function () {
		            	$('#review2-b').html('很抱歉，加载内容出错，我们及时修改问题。');
		            }
		        });
	    	});
	  	});
	  	    
	    //跳转页面
	    function jump(pageNo, pageSize, flagId) {
	    	if(flagId == undefined) {
	    		flagId = $('#flagId').val();
	    	}
	    	var params = "";
	    	
	      	if(pageNo != 0) {
	      		params.page = pageNo;
	      	}
	      	var pagesize = '';
	      	if(pageSize == undefined){
	      		 pagesize = '${pager.pageSize}';
	      	} else {
	      		pagesize = pageSize;
	      	}
	      	
	      	var keyWord = $("input[name='keyWord']").val();
	      	var url = "";
	      	if(flagId == 'bmz') {
	      		url = "<%=path %>/business/businessActReg/list.do";
				params = {
							actId: '${businessActivity.actId}', 
							comId: $('#comId').val(), 
							estateId: $('#estateId').val(), 
							orderBy: $('#orderBy').val(),
							flag: 2, 
							keyWord: keyWord
						};
	      	} else if(flagId == 'tpz') {
	      		url = "<%=path %>/business/businessActReg/list.do";
	      		params = {
							actId: '${businessActivity.actId}', 
							comId: $('#comId').val(), 
							estateId: $('#estateId').val(), 
							orderBy: $('#orderBy').val(),
							flag: 0, 
							keyWord: keyWord
						};
	      	} else if(flagId == 'jpzz') {
	      		url = "<%=path %>/business/businessSponsor/list.do";
	      		params = {actId: '${businessActivity.actId}', keyWord: keyWord};
	      	} 
	      	
	      	$.ajax({
	      		type: 'post',
	            url:  url,
	            dataType: 'json',
	            data: params,
	            cache: false,
	            success: function (data) {
	            	if(flagId == 'bmz') {
	            		$("#rowCount").html("共有<em>" + data.total + "</em>人报名");  // 根据查询条件更新总条数
	    	      	} else if(flagId == 'tpz') {
	    	      		$("#rowCount").html("共有<em>" + data.total + "</em>人参与投票");  // 根据查询条件更新总条数
	    	      	} else if(flagId == 'jpzz') {
	    	      		$("#rowCount").html("共有<em>" + data.total + "</em>人提供赞助");  // 根据查询条件更新总条数
	    	      	} 
	                var rows = data.rows;
	                if(rows.length > 0) {
	                	$('#review2-b').html('');
	                	if(flagId == 'bmz') {
	                		for(var i=0;i<rows.length;i++) {
		                    	var row = rows[i];  
		                		var flagDiv = "";
		                		if(row.flag == 2) {
		                			flagDiv = '<div class="hd-adetail bmz-start">'
		                    			+ '<a style="cursor:pointer;" onclick="startTPZinfo('+row.regId+', \''+row.picUrl+'\')">开始投票</a>'
		                    			+ '</div>';
		                		}
		                    	var htmlDom = ''
		                    		+ '<div class="cominfo hdinfo">'
		                    		+ '<a class="cominfobox tpbox hdbox bmzbox" href="javascript:;">'
		                    		+ '<span class="rakin">'+row.code+'</span>'
		                    		+ '<p class="hd-img bmz-img"><img src="<%=ctx%>'+row.picUrl+'"/><em>'+row.count+'</em></p>'
		                    		+ '<div class="textinfo tpinfo">'
		                    		+ '<p><span>'+row.nickName+'</span></p>'
		                    		+ '<p class="hd-yzname">'+row.estateName+'</p>'
		                    		+ '<p>提交日期：<span style="font-size:18px">'+(row.regTime != '' && row.regTime != "null" ? row.regTime.substring(0, 16) : '')+'</span></p>'
		                    		+ '</div>'
		                    		+ '<p class="hd-intro">'+row.content+'</p>'
		                    		+ '</a>'
		                    		+ '<div class="hd-adetail bmz-bj">'
		                    		+ '<a style="cursor:pointer;" onclick="updateActReg('+row.regId+')">编辑资料</a>'
		                    		+ '</div>'
		                    		+ flagDiv
		                    		+ '</div>';
		                    	$('#review2-b').append(htmlDom);
		                    }
	        	      	} else if(flagId == 'tpz') {
	        	      		for(var i=0;i<rows.length;i++) {
		                    	var row = rows[i];  
		                    	var htmlDom = ''
		                    		+ '<div class="cominfo hdinfo">'
		                    		+ '<a class="cominfobox tpbox hdbox" href="javascript:;">'
		                    		+ '<span class="rakin">'+parseInt((pageNo-1)*pagesize +i+1) +'</span>'
		                    		+ '<p class="hd-img"><img src="<%=ctx%>'+row.avatar+'"/></p>'
		                    		+ '<div class="textinfo tpinfo">'
		                    		+ '<p><em>'+row.code+'号</em><span>'+row.nickName+'</span></p>'
		                    		+ '<p class="hd-yzname">'+row.estateName+'</p>'
		                    		+ '<p><em>'+row.votes+'</em>票</p>'
		                    		+ '</div>'
		                    		+ '<p class="hd-intro">'+row.content+'</p>'
		                    		+ '</a>'
		                    		+ '<div class="hd-adetail">'
		                    		+ '<a style="cursor:pointer;" onclick="seeTPZDetail('+parseInt((pageNo-1)*pagesize +i+1) +','+row.regId+')">查看详情</a>'
		                    		+ '</div>'
		                    		+ '</div>';
		                    	$('#review2-b').append(htmlDom);
		                    }
	        	      	} else if(flagId == 'jpzz') {
	        	      		for(var i=0;i<rows.length;i++) {
		                    	var row = rows[i];  
		                    	var htmlDom = ''
	                    		+ '<div class="cominfo zsinfo">'
	                    		+ '<a class="cominfobox zs-tinfo" href="javascript:;">'
	                    		+ '<div class="zs-info">'
	                    		+ '<p class="zs-name">'+row.sponsorName+'</p>'
	                    		+ '<p class="zs-phone">'+row.sponsorPhone+'</p>'
	                    		+ '</div>'
	                    		+ '<p class="hd-intro">'+row.sponsorContent+'</p>'
	                    		+ '</a>'
	                    		+ '<div class="hd-adetail">'
	                    		+ '<a style="cursor:pointer;" onclick="seeJPZZDetail('+row.sponsorId+')">查看详情</a>'
	                    		+ '</div>'
	                    		+ '</div>';
		                    	$('#review2-b').append(htmlDom);
		                    }
	        	      	} 
	                }else{
	                	$('#review2-b').html('');
	                }
	                $('#review2-b').append('<div class="no-float"></div>');
	                
	                if(flagId == 'bmz' || flagId == 'tpz') {
		             	// 获取社区下对于的所有小区
		            	$('.erjnav').eq(2).html('');
		            	var comId = $("#comId").val();
		            	$.ajax({
							type: 'post',
					        url: '<%=path %>/manage/manageEstate/findEstateByComId.do',
					        dataType: 'json',
					        data: {comId : comId},
					 		cache: false,
					        success: function (data) {
					            var rows = data.rows;
			                	var estateId = $("#estateId").val();
				            	var htmlDom = "";
				            	
			                	if(estateId != "") {
				                	htmlDom = '<li id="estateId_"><a href="javascript:;">所有小区</a></li>';
				                	$('.erjnav').eq(2).append(htmlDom);
			                	}
			                	
					            if(rows.length > 0 && comId != "") {
					            	for(var i=0;i<rows.length;i++) {
					                	var row = rows[i];  
					                	if(row.estateId != estateId) {
						                	htmlDom = '<li id="estateId_'+row.estateId+'"><a href="javascript:;">'+row.estateName+'</a></li>';
						                	$('.erjnav').eq(2).append(htmlDom);
					                	}
					            	}
					            	$('#oneul').find('.erjnav:eq(2)>li').each(function(index, obj) {
										bindClick($(obj));
									});
					            }else {
					            	$('.erjnav').eq(2).html('');
					            }
					        },
					        error: function () {
					        	$('.erjnav:eq(2)').html('很抱歉，加载小区内容出错，我们及时修改问题。');
					        }
					    });
	                }
	                
	                var vis = $("#pageUl li:not(#pageUl :first,#pageUl :last):visible");//显示的数量
	               	var liCount = '';  
	                for(var pageno=1; pageno<=(data.pageCount); pageno++){
	                	var flag=false;
	                	for(var i=0;i<vis.size();i++){
	                		if(vis.eq(i).find("span").text()==pageno){
	                			flag=true;
	                		}
	                	}
	                	if(flag){
	                		liCount = liCount + '<li><a   href="javascript:jump('+pageno+','+data.pageSize+', \''+flagId+'\');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
	                	}else{
	                		liCount = liCount + '<li style="display:none";><a  href="javascript:jump('+pageno+','+data.pageSize+', \''+flagId+'\');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
	                	}
	                }
	                var boolnext = '';
	                if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next('+data.pageSize+', \''+flagId+'\');'; }
	                var boolprev = '';
	                if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev('+data.pageSize+', \''+flagId+'\');';  }
		           	var pageDom = ''
		           		+ '<div class="pagec"><ul id="pageUl">'
		           		+ '<li><a id="arrow-l" class="arrow" href="'+boolprev+'"></a></li>'
		           		+ liCount
		           		+ '<li><a id="arrow-r" class="arrow" href="'+boolnext+'"></a></li>'
		           		+ '</ul></div>';
		           	$('.page').html('');
	            	$('.page').html(pageDom);
	            	
		            setCurrPageNo(pageNo);
	            },
	            error: function () {
	            	$('#review2-b').html('很抱歉，加载内容出错，我们及时修改问题。');
	            }
	        });
	    }
	    
	  	//上一页
	    function prev(pageSize, flagId) {
	  		
	    	var currNo = $('#curr').first().text();
	    	var prevNo = parseInt(currNo) - 1;
	    	if(prevNo <= 0) {
	    		prevNo = 1;
	    	}
	    	jump(prevNo, pageSize, flagId);
	    }
	    //下一页
	    function next(pageSize, flagId) {
	    	var currNo = $('#curr').first().text();
	    	var nextNo = parseInt(currNo) + 1;
	    	var pageCount = $('#pageCount').val();
	    	if(nextNo > pageCount) {
	    		nextNo = pageCount;
	    	}
	    	jump(nextNo, pageSize, flagId);
	    }
	    
	    
	  //查看奖品赞助详情 
		function seeJPZZDetail(sponsorId) {
			$('#jpzzLabel').fadeIn('slow');
		    $.ajax({
		  	  url: '<%=path %>/business/businessSponsor/getSponsorById.do',
		  	  dataType: 'json',
		  	  data: {sponsorId: sponsorId},
		  	  method: 'post',
		  	  cache: false, 
		  	  success: function(data) {
		      		$('#sponsorName').text(data.sponsorName);
	      			$('#sponsorPhone').text(data.sponsorPhone);
		            $('#sponsorContent').html(data.sponsorContent);
		  	  }
		    });
		}
	  
		//查看投票详情 
		function seeTPZDetail(bhId, regId) {
			$('#tpzLabel').fadeIn('slow');
            $('#picUrl').html(""); 
		    $.ajax({
		  	  url: '<%=path %>/business/businessActReg/getRegById.do',
		  	  dataType: 'json',
		  	  data: {regId: regId},
		  	  method: 'post',
		  	  cache: false, 
		  	  success: function(data) {
		  			$('#bhId').html(bhId);
		      		$('#code').html("#" +data.code);
	      			$('#nickName').html(data.nickName);
		            $('#content').html(data.content);
		            $('#avatarP').html("<img src='<%=ctx%>"+data.avatar+"'>");
		            $('#votes').html("<em>"+data.votes+"</em>票");
		            $('#estateName').html(data.estateName);
		            if(data.picUrlArr.length > 0) {
	            	 	str=data.picUrlArr.split(",");  
	            	    for (var i=0;i<str.length ;i++ ) {   
	            	    	$('#picUrl').append("<img src='<%=ctx%>"+str[i]+"'>");   
	            	    }   
		            } else {
		            	$('#picUrl').html(""); 
		            }
		  	  }
		    });
		}
		
		//查看投票详情 
		function startTPZinfo(regId, picUrl) {
			if(picUrl != "") {
				$('#picUploadLayerAvatar').fadeIn('slow');
				//初始化上传
	        	uploadInitAvatar('avatar', 'vote', regId);  
			} else {
				alert("您的资料不完整或没有上传个人相册！");
			}
		}
		
		function updateActReg(regId) {
		    window.location.href = '${ctx}/business/businessActReg/updateActReg.do?regId='+regId;
		}
	</script>
</head>
<body style="background:#fff;">
<div class="wrapper" style="overflow:visible;">
    <div class="header-public"><span style="cursor: pointer;" class="return" onclick="history.go(-1)"></span>精品投票活动参与人</div>
	<div class="review" style="top:57px;  position:relative;">
        <div class="review-t">
            <div class="hd-cyr">
                <div class="hd-head">
                    <a id="bmz" class="hd-active" style="cursor:pointer;">报名中</a>
                    <a id="tpz" style="cursor:pointer;">投票中</a>
                    <a id="jpzz" style="cursor:pointer;">奖品赞助</a>
                </div>
                <div id="searchId" class="hd-tj clearfix">
	                <div class="scroll-box">
		                <ul id="oneul">
		                    <li id="orderBy_" class="navlist"><a href="javascript:;"><span>最新时间排序</span><b class="donbut"><i></i></b></a>
		                    	<input type="hidden" name="orderBy" id="orderBy" value="" />
		                    	<ul class="erjnav">
		                            <li id="orderBy_code"><a href="javascript:;">按编号排序</a></li>
		                        </ul>
		                    </li>
		                    
		                    <li id="comId_" class="navlist"><a href="javascript:;"><span>所有社区</span><b class="donbut"><i></i></b></a> 
								<input type="hidden" name="comId" id="comId" value="" /> 
		            			<input type="hidden" name="flagId" id="flagId" value="bmz" /> 
								<ul class="erjnav">
									<c:forEach items="${comList }" var="comBean" varStatus="key">
										<li id="comId_${comBean.comId }"><a href="javascript:;">${comBean.comName }</a></li>
									</c:forEach>
								</ul>
							</li>	
							
							<li id="estateId_" class="navlist"><a href="javascript:;"><span>所有小区</span><b class="donbut"><i></i></b></a> 
								<input type="hidden" name="estateId" id="estateId" value="" /> 
								<ul id="estateUL" class="erjnav"></ul>
							</li>
		                </ul>
		            </div>
		        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='标题/内容搜索' /><input id="searbut" type="button" onclick="search('bmz')" value="" /></div></div>
                </div>
            </div>
            <div class="tp-title" style="font-size:24px">
                <span style="padding:0">${businessActivity.actName}</span>
                <span id="rowCount">共有<em>${baseBean.pager.rowCount}</em>人报名</span>
                <input type="hidden" name="actId" id="actId" value="${businessActivity.actId }" />
            </div>
        </div>
        
        <div id="review2-b" class="review-b">
        	<c:forEach items="${baseBean.list}" var="bean" varStatus="status">
	            <div class="cominfo hdinfo">
	            	<a class="cominfobox tpbox hdbox bmzbox" href="javascript:;">
	                    <span class="rakin">${bean.code}</span>
	                    <p class="hd-img bmz-img"><img src="${ctx}${bean.picUrl}"/><em>${bean.count}</em></p>
	                    <div class="textinfo tpinfo">
	                        <p><span>${bean.nickName}</span></p>
	                        <p class="hd-yzname">${bean.estateName}</p>
	                        <p>提交日期：<span style="font-size:18px"><time><fmt:formatDate value="${bean.regTime}" pattern="yyyy-MM-dd HH:mm" /></time></span></p>
	                    </div>
	                    <p class="hd-intro">${bean.content}</p>
	            	</a>
	                <div class="hd-adetail bmz-bj">
	                    <a style="cursor:pointer;" onclick="updateActReg('${bean.regId}')">编辑资料</a>
	                </div>
                    <c:if test="${bean.flag == 2}">
                    	<div class="hd-adetail bmz-start">
                    		<a style="cursor:pointer;" onclick="startTPZinfo('${bean.regId}','${bean.picUrl}')">开始投票</a>
                    	</div>
                    </c:if>
	            </div>
            </c:forEach>
    	</div>
    	
		<jsp:include page="/common/uploadAvatarJs.jsp" />
		
    	<div class="no-float"></div>
		<div class="page">
			<div class="pagec">
            	<input type="hidden" id="pageCount" value="${pager.pageCount}" />
                <ul id="pageUl">
                	<li><a id="arrow-l" class="arrow" href="javascript:prev(${pager.pageSize}, 'bmz');" <c:if test="${pager.pageId <= 1 }"> disabled </c:if> ></a></li>
                	<c:forEach items="${pager.indexs }" var="pageNo">
                		<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo },${pager.pageSize}, 'bmz');"><span id="page_${pageNo }">${pageNo }</span></a></li>
                	</c:forEach>
                	<li><a id="arrow-r" class="arrow" href="javascript:next(${pager.pageSize}, 'bmz');" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if> ></a></li>
                </ul>
        	</div>
        </div> 
    </div>
</div>

<!-- 奖品赞助详情页 -->
<div id="jpzzLabel" class="busswi5 s-xw-bu">
    <div class="sidebar5 s-xw-si s-xw-show"  style="background-color:#efefef;">
        <a onclick="$('#jpzzLabel').fadeOut('slow');" href="javascript:;" title="关闭" id="close5"></a>
        <h2 class="tit4">赞助信息</h2>
        <div class="zz-detail">
            <p id="sponsorName"  class="zs-name"></p>
            <p id="sponsorPhone"  class="zs-phone"></p>
        </div>
        <p id="sponsorContent"  class="zs-intro"></p>
    </div>
</div>

<!-- 投票详情页 -->
<div id="tpzLabel"  class="busswi5 s-xw-bu">
    <div class="sidebar5 s-xw-si s-xw-show"  style="background-color:#efefef;">
        <a onclick="$('#tpzLabel').fadeOut('slow');" href="javascript:;" title="关闭" id="close5"></a>
        <h2 class="tit4">个人展示</h2>
        <div class="zs-detail clearfix">
            <p id="bhId" class=" fleft zs-dmc"></p>
            <p id="avatarP"  class=" fleft zs-dimg"></p>
            <div class=" fleft zs-dinfo">
                <p><em id="code"></em><span id="nickName"></span></p>
                <p id="estateName" class="hd-yzname"></p>
                <p id="votes"></p>
            </div>
        </div>
        <p id="content" class="zs-intro"></p>
        <div id="picUrl" class="zs-img"></div>
    </div>
</div>
</body>
</html>
</html>