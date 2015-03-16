<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>爆料管理</title>
	<%@include file="/common/meta.jsp"%>
	<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
	<link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
</head>

<div class="max-height">

	<div class="wrapper wrapos">

		<!--左导航开始-->
		<%@include file="/common/leftNav.jsp"%>
		<!--左导航结束-->

		<!--右部主体内容开始-->
		<div class="mainr">
			<%@include file="/common/header.jsp"%>
			<div class="scroll">
				<div class="scroll-box">
					<ul id="oneul">
						<li id="state_" class="active navlist">
							<a href="javascript:;"><span>全部爆料</span><b class="donbut"><i></i></b></a> 
							<input type="hidden" name="state" id="state" value="${state}" />
							<ul class="erjnav">
								<li id="state_0"><a href="javascript:;">未回复</a></li>
								<li id="state_1"><a href="javascript:;">已回复</a></li>
							</ul>
						</li>
						
						<li id="isUsed_" class="active navlist">
							<a href="javascript:;"><span>所有选用</span><b class="donbut"><i></i></b></a> 
							<input type="hidden" name="isUsed" id="isUsed" value="" />
							<ul class="erjnav">
								<li id="isUsed_0"><a href="javascript:;">未选用</a></li>
								<li id="isUsed_1"><a href="javascript:;">已选用</a></li>
							</ul>
						</li>
						
						<li id="timeScope_" class="navlist"><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a>
                    		<input type="hidden" name="timeScope" id="timeScope" value="" />
                    		<input type="hidden" name="startTime" id="startTime" value="" />
                    		<input type="hidden" name="endTime" id="endTime" value="" />
	                    	<ul class="erjnav">
	                    		<li id="timeScope_0"><a href="javascript:;">当日</a></li>
	                            <li id="timeScope_7"><a href="javascript:;">7天内</a></li>
	                            <li id="timeScope_30"><a href="javascript:;">30天内</a></li>
	                            <li id="timeScope_90"><a href="javascript:;">90天内</a></li>
	                            <li id="timeScope_365"><a href="javascript:;">365天内</a></li>
	                            <li id="timeScope_scope"><a href="javascript:;">选择时间范围</a></li>
	                        </ul>
	                    </li>

						<li id="orderBy_" class="navlist"><a href="javascript:;"><span>最新时间排序</span><b class="donbut"><i></i></b></a> 
								<input type="hidden" name="orderBy" id="orderBy" value="" />
							<ul class="erjnav">
								<li id="orderBy_selectedNum"><a href="javascript:;">选用量高到低</a></li>
							</ul>
						</li>
						<p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
					</ul>
				</div>

				<div id="search">
					<div class="borbox">
						<input id="searbox" type="text" name="keyWord" value=""  placeholder='爆料人/内容/电话搜索' />
						<input id="searbut" type="button" onclick="search()" value="" />
					</div>
				</div>
			</div>

			<div class="column">
				<c:forEach items="${baseBean.list }" var="breakInfo" varStatus="key">
					<div class="manbox" <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if>>
						<a class="nopotr2 s-baoliao-no" href="javascript:;" style="height:296px;"> 
							<div class="info">
			                    <span>爆料时间：<time><fmt:formatDate value="${breakInfo.breakTime }" pattern="yyyy-MM-dd HH:mm"/></time></span>
								<span class="s-xw-sq">所属社区：${breakInfo.comName }</span>
							</div>
							<hr class="link">
							<h2 class="title_h">
								<span class="poht">
									<img style="width: 100%;" src="<%=ctx %>${breakInfo.portrait}">
								</span>
								<em style="font-style: normal; line-height: 31px;">${breakInfo.breakerName }</em><br />
								<strong style="font-weight: normal; font-size: 14px;">${breakInfo.address}</strong>
							</h2>
							
							<div class="state">
								<c:if test="${breakInfo.state == 0 }"><span class="relsta cgreen"> 未回复</span></c:if>
								<c:if test="${breakInfo.state == 1 }"><span class="relsta cred"> 已回复</span></c:if>
								<div class="s-baoliao-tick">
									<i class="baoliao-tick" >已被选用至新鲜事<span style="color: #3EAF0E;"> ${breakInfo.selectedNum} </span>次</i>
								</div>
							</div>

							<p class="text2 s-baoliao-text"><c:if test="${breakInfo.picCount != 0 }"><i></i></c:if>${breakInfo.breakContent }</p> 
							<div style="height:24px;">
							<c:if test="${breakInfo.state == 1 }">
								<span class="hf">已回复${breakInfo.comments}条 最后时间 <time><fmt:formatDate value="${breakInfo.lastCommentTime }" pattern="yyyy-MM-dd HH:mm"/></time></span>
							</c:if>
							</div>
							<hr class="link y-qz-hr">
							<shiro:hasPermission name="break_view_detail">
							<div class="operate operate2 blop" style="margin:0;" >
								<span class="see" style="position:relative; height:50px;" id="block5" title="查看爆料详情" onclick="window.location.href='checkBreakDetail.do?breakId=${breakInfo.breakId}<c:if test="${breakInfo.newsCount > 0 }">&isNew=1</c:if>' ">
								<c:if test="${breakInfo.newsCount > 0 }"><img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" /></c:if>
								</span>
							</div>
							</shiro:hasPermission>
						</a>
					</div>
				</c:forEach>
				<div class="no-float"></div>
			</div>
			<div class="page">
				<div class="pagec">
	            	<input type="hidden" id="pageCount" value="${pager.pageCount}" />
	                <ul id="pageUl">
	                	<li><a id="arrow-l" class="arrow" href="javascript:prev();" <c:if test="${pager.pageId <= 1 }"> disabled </c:if> ></a></li>
	                	<c:forEach items="${pager.indexs }" var="pageNo">
	                		<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo });"><span id="page_${pageNo }">${pageNo }</span></a></li>
	                	</c:forEach>
	                	<li><a id="arrow-r" class="arrow" href="javascript:next();" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if> ></a></li>
	                </ul>
	        	</div>
	        </div>
			<div class="no-float"></div>
			<%@include file="/common/footer.jsp"%>
		</div>
		<!--右部主体内容结束-->
	</div>
</div>
</html>

<!-- 开始时间设置 -->
<div id="dateDialog" title="选择日期范围">
	<div>
		<label for="setStartTime">开始日期</label> <input type="text"
			class="iptnewtit" name="setStartTime" id="setStartTime" value="" />
		<label for="setEndTime">结束日期</label> <input type="text"
			class="iptnewtit" name="setEndTime" id="setEndTime" value="" />
	</div>
</div>
<!-- 开始时间设置 -->

<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function () {
		$(document).keyup(function(event){
			  if(event.keyCode ==13){
			    $("#searbut").trigger("click");
			  }
		});
	});

	// 初始化判断是否首页跳转过来的链接并更改默认搜索条件
	$(function(){  
		if($('#state').val() != undefined && $('#state').val() != '') {
			var objId = 'state_'+$('#state').val();
			bindChange($('#'+objId));
		}
	}); 
	
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $("input[name='keyWord']").val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					state: $('#state').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime: $('#endTime').val(),
					orderBy: $('#orderBy').val(),
					isUsed: $('#isUsed').val()
			};
		}
		return params;
	}
    
    //跳转页面
    function jump(pageNo) {
    	$('.column').html('');
    	$('#loading').css('display', 'block');
    	var params = getParams();
    	if(pageNo != undefined && pageNo != 0) {
    		params.page = pageNo;
    	}else{
    		params.page = 1;
    	}
    	$.ajax({
    		type: 'post',
            url: '<%=path %>/business/businessBreak/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                var rows = data.rows;
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                    	var row = rows[i];  
                    	var styleStr = '';
                    	if(i % 3 == 0) {
                    		styleStr = 'style="margin-left:0;"';
                    	}
                    	var state = '';
                    	if(row.state == 0) {
                    		state = '<span class="relsta cgreen"> 未回复</span>';
    		            }else{
    		            	state = '<span class="relsta cred"> 已回复</span>';
    		            }
                    	var htmlDom = ''
                    	+ '<div class="manbox" '+styleStr+'>'
                    	+ '<a class="nopotr2 s-baoliao-no" href="javascript:;"  style="height:296px;">' 
                    	+ '<div class="info">'
                    	+ '<span>爆料时间：<time>'+(row.breakTime != '' ? row.breakTime.substring(0, 16) : '')+'</time></span>'
                    	+ '<span class="s-xw-sq">所属社区：'+row.comName+'</span>'
                    	+ '</div>'
                    	+ '<hr class="link">'
                    	+ '<h2 class="title_h"><span class="poht"><img style="width:100%;" src="<%=ctx %>'+row.portrait+'"></span><em style="font-style:normal; line-height:31px;">'+row.breakerName+'</em><br> <strong style="font-weight:normal; font-size:14px;">'+row.address+'</strong></h2>'
                    	+ '<div class="state">'+state+ '<div class="s-baoliao-tick"><i class="baoliao-tick" >'+row.selectedNum+'</i></div></div>'
                    	+ '<p class="text2 s-baoliao-text">'+(row. picCount != 0? '<i></i>' : '')+row.breakContent+'</p>'
                    	+'<div style="height:24px;">'
                    	+(row. state == 1? '<span class="hf">已回复'+row.comments+'条 最后时间 '+(row.lastCommentTime != 'null'? row.lastCommentTime.substring(0, 16) : '')+'</span>' : ' ') 
                    	+'</div>'
                    	+ '<hr class="link y-qz-hr">'
                    	<shiro:hasPermission name="break_view_detail">
                    	+ '<div class="operate operate2 blop" style="margin:0;" >'
                    	+ '<span class="see" style="position:relative; height:50px;" id="block5" title="查看爆料详情" onclick="window.location.href=\'checkBreakDetail.do?breakId='+row.breakId+(row.newsCount>0?'&isNew=1':'')+'\'">'
                    	+ (row.newsCount>0?'<img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" />':'')
                    	+ '</span></div>'
                    	</shiro:hasPermission>
                    	+ '</a>'
                    	+ '</div>';
                    	
                    	$('.column').append(htmlDom);
                    }
                }else{
                	$('.column').html('很抱歉，没有相关记录。');
                }
                $('.column').append('<div class="no-float"></div>');
                $('#loading').css('display', 'none');
                
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
                		liCount = liCount + '<li><a   href="javascript:jump('+pageno+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                	}else{
                		liCount = liCount + '<li style="display:none";><a  href="javascript:jump('+pageno+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                	}
                	
                }
                var boolnext = '';
                if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next();'; }
                var boolprev = '';
                if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev();';  }
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
            	$('.column').html('很抱歉，加载内容出错，我们及时修改问题。');
            }
        });
    }
</script>