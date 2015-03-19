<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>物业建议投诉管理</title>
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
	                	<li id="fbState_" class="active navlist"><a href="javascript:;"><span>全部建议投诉</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="fbState" id="fbState" value="${fbState}" />
	                    	<ul class="erjnav">
	                            <li id="fbState_0"><a href="javascript:;">未回复</a></li>
	                            <li id="fbState_1"><a href="javascript:;">已回复</a></li>
	                            <li id="fbState_2"><a href="javascript:;">未解决</a></li>
	                            <li id="fbState_3"><a href="javascript:;">已解决</a></li>
	                            <li id="fbState_4"><a href="javascript:;">待评价</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="fbType_" class="navlist"><a href="javascript:;"><span>所有分类</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="fbType" id="fbType" value="" />
	                    	<ul class="erjnav">
	                    		<li id="fbType_0"><a href="javascript:;">物业投诉</a></li>
	                            <li id="fbType_1"><a href="javascript:;">物业建议</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="fbScore_" class="navlist"><a href="javascript:;"><span>所有星级</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="fbScore" id="fbScore" value="" />
	                    	<ul class="erjnav">
	                    		<li id="fbScore_0"><a href="javascript:;">未评星级</a></li>
	                            <li id="fbScore_1"><a href="javascript:;">1分</a></li>
	                    		<li id="fbScore_2"><a href="javascript:;">2分</a></li>
	                    		<li id="fbScore_3"><a href="javascript:;">3分</a></li>
	                    		<li id="fbScore_4"><a href="javascript:;">4分</a></li>
	                    		<li id="fbScore_5"><a href="javascript:;">5分</a></li>
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
	                            <li id="orderBy_fbReplies"><a href="javascript:;">回复量高到低</a></li>
	                            <li id="orderBy_fbScore"><a href="javascript:;">满意度高到低</a></li>
	                        </ul>
	                    </li>
	                </ul>
	                 <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='反馈人/受理人/反馈内容/真实姓名/昵称/电话搜索' /><input id="searbut" type="button" onclick="search()" value="" /></div></div>
	        </div>
	        
	        <div class="column">
	            <c:forEach items="${baseBean.list }" var="feedback" varStatus="key">
	        		<div class="manbox"  <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if> >
		            	<a class="nopotr2" href="javascript:;" style="height:296px;">
		                    <div class="info">
		                    	<p style="float:left;">建议投诉类型：
				                    <span style="color: #3EAF0E;">
										<c:choose>
										       <c:when test="${feedback.fbType == 0}">
										              	物业投诉
										       </c:when>
										       <c:when test="${feedback.fbType == 1}">
										              	物业建议
										       </c:when>
										       <c:when test="${feedback.fbType == 2}">
										              	使用反馈
										       </c:when>
										       <c:when test="${feedback.fbType == 3}">
										              	驿站建议
										       </c:when>
										       <c:when test="${feedback.fbType == 4}">
										              快递投诉
										       </c:when>
										</c:choose>
									</span>
								</p>
								<span class="s-xw-sq">所属范围：${feedback.estateName }</span>
							</div>
		                    <div class="info">
		                    	<span><time class="time"><fmt:formatDate value="${feedback.fbTime }" pattern="yyyy-MM-dd HH:mm"/></time></span> 
								<c:if test="${feedback.fbType == 4}">
									<p style="float:right">
										运单号：<span  style="color: #3EAF0E;">${feedback.expCode}</span>
									</p>
								</c:if>
							</div>
							
		                    <hr class="link2">
		                    
		                    <h2 class="title_h"><span class="poht"><img src="<%=ctx %>${feedback.portrait}" style="width:100%;"></span>
		                    <em style="font-style:normal; font-weight:bold; line-height:31px;">${feedback.fberName }</em><br> 
		                    <strong style="font-weight:normal; font-size:16px;">${feedback.address }</strong></h2>
		                    
		                    <div class="state">
		                    	<c:choose>
								       <c:when test="${feedback.fbState == 0}">
								              	<span class="relsta cred">未回复</span>
								       </c:when>
								       <c:when test="${feedback.fbState == 1}">
								              	<span class="relsta cgreen">已回复</span>
								       </c:when>
								       <c:when test="${feedback.fbState == 2}">
								              	<span class="relsta cyellow">未解决</span>
								       </c:when>
								       <c:when test="${feedback.fbState == 3}">
								              	<span class="relsta cgray">已解决</span>
								       </c:when>
								       <c:otherwise>
								              	<span class="relsta cblue">待评价</span>
								       </c:otherwise>
								</c:choose>
		                    	<c:if test="${feedback.fbState == 2 || feedback.fbState == 3}">
		                    		<c:if test="${feedback.fbScore != 0}">
			                    		<div class="other-r">
			                    			<img src="<%=ctx %>/images/icon/score<fmt:formatNumber type="number" value="${feedback.fbScore}" maxFractionDigits="0"/>.jpg"  />
										</div>
									</c:if>
								</c:if>
		                   </div>
		             		
		                    <p class="text2">
		                    	${fn:replace(feedback.fbContent, '\\r\\n', '<br />')}
		                    	<%-- <c:choose>
									<c:when test="${fn:length(feedback.fbContent) > 60}">
										<c:out value="${fn:substring(feedback.fbContent, 0, 59)}......" />
									</c:when>
									<c:otherwise>
										<c:out value="${feedback.fbContent}" />
									</c:otherwise>
								</c:choose> --%>
		                    </p>
		                    <div style="height:20px;">
			                    <c:if test="${feedback.fbState != 0 && feedback.fbReplies > 0}">
			                    	<span class="hf">已回复${feedback.fbReplies }条 最后时间 <fmt:formatDate value="${feedback.lastCommentTime }" pattern="yyyy-MM-dd HH:mm"/></span>
			                    </c:if>
		                    </div>
		                    <hr class="link y-qz-hr">
		                    <shiro:hasPermission name="prop_feedback_view_detail">
	                    	<div class="operate operate2 blop" style="margin:0;" >
								<span class="see" style="position:relative; height:50px;" id="block5" title="查看建议投诉详情" onclick="window.location.href='${ctx}/business/businessFeedback/getPropFeedDetails.do?feedbackId=${feedback.feedbackId}&estateId=${feedback.estateId}&fberId=${feedback.fberId}<c:if test="${feedback.newsCount > 0 }">&isNew=1</c:if>'">
									<c:if test="${feedback.newsCount > 0 }"><img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" /></c:if>
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
		<label for="setStartTime">开始日期</label>
		<input type="text" class="iptnewtit" name="setStartTime" id="setStartTime" value="" />
		<label for="setEndTime">结束日期</label>
		<input type="text" class="iptnewtit" name="setEndTime" id="setEndTime" value="" />
	</div>
</div>
<!-- 开始时间设置 -->
<script type="text/javascript"  src="<%=ctx%>/js/jquery.min.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
<script type="text/javascript">
	$(function () {
		$(document).keyup(function(event){
			  if(event.keyCode ==13){
			    $("#searbut").trigger("click");
			  }
		});
	});

	//初始化判断是否首页跳转过来的链接并更改默认搜索条件
	$(function(){  
		if($('#fbState').val() != undefined && $('#fbState').val() != '') {
			var objId = 'fbState_'+$('#fbState').val();
			bindChange($('#'+objId));
		}
	}); 

	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					fbState: $('#fbState').val(),
					fbType: $('#fbType').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime: $('#endTime').val(),
					orderBy: $('#orderBy').val(),
					fbScore: $('#fbScore').val()
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
            url: '<%=path %>/business/businessFeedback/getPropPageList.do',
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
                    	var fbState = '';
                    	if(row.fbState == 0) {
                    		fbState = '<span class="relsta cred">未回复</span>';
    		            }else if(row.fbState == 1) {
    		            	fbState = '<span class="relsta cgreen">已回复</span>';
    		            }else if(row.fbState == 2) {
    		            	fbState = '<span class="relsta cyellow">未解决</span>';
    		            }else  if(row.fbState == 3) {
    		            	fbState = '<span class="relsta cgray">已解决</span>';
    		            }else  {
    		            	fbState = '<span class="relsta cblue">待评价</span>';
    		            }
                    	var fbType = '';
                    	var fbType1 = '';
                    	if(row.fbType == 0) {
                    		fbType = '物业投诉';
    		            }else if(row.fbType == 1) {
    		            	fbType = '物业建议';
    		            }else if(row.fbType == 2) {
    		            	fbType = '使用反馈';
    		            }else if(row.fbType == 3) {
    		            	fbType = '驿站建议';
    		            }else if(row.fbType == 4){
    		            	fbType = '快递投诉';
    		            	fbType1 = '<p style="float:right">运单号：<span  style="color: #3EAF0E;">'+row.expCode+'</span></p>';
    		            }
                    	var state = '';
                    	if(row.fbState  != 0 && row.fbReplies > 0) {
                    		 state = '<span class="hf">已回复'+row.fbReplies+'条 最后时间'+(row.lastCommentTime != 'null' ? (row.lastCommentTime.substring(0, 16)) : '')+'</span>';
                    	} 
                    	var score = '';
                    	if(row.fbState == 2 || row.fbState == 3) {
                    		if(row.fbScore != 0) {
                    			score ='<img src="<%=ctx %>/images/icon/score'+parseInt(row.fbScore)+'.jpg"  />';
                    		}
                    	}
                    	var htmlDom = ''
                    	+ '<div class="manbox"' 
						+ styleStr
                    	+ '>'
                    	+ '<a class="nopotr2" href="javascript:;" style="height:296px;">'
                    	+ '<div class="info">'
                    	+ '<p style="float:left;">建议投诉类型：<span style="color: #3EAF0E;">'+fbType+'</span></p>' 
                    	+ '<span class="s-xw-sq">所属范围：'+row.estateName+'</span>'
                    	+ '</div>'
                    	+ '<div class="info"><time>'+(row.fbTime != null ? row.fbTime.substring(0, 16) : '')+'</time>'+fbType1+'</div>'
                    	+ '<hr class="link2">'
                    	+ '<h2 class="title_h"><span class="poht"><img src="<%=ctx%>'+row.portrait+'" style="width:100%;"></span><em style="font-style:normal; font-weight:bold; line-height:31px;">'+row.fberName+'</em><br> <strong style="font-weight:normal; font-size:16px;">'+row.address+'</strong></h2>'
                    	+ '<div class="state">'
                    	+ fbState
                    	+ '<div class="other-r">'+score
                    	+'</div></div>'
                    	+ '<p class="text2">'
                    	+ row.fbContent.replace("\r\n", "<br />")
                    	+ '</p>'
                    	+'<div style="height:20px;">'+state+'</div>'
                    	+ '<hr class="link y-qz-hr">'
                    	<shiro:hasPermission name="prop_feedback_view_detail">
                    	+ '<div class="operate operate2 blop" style="margin:0;" >'
                    	+'<span class="see" style="position:relative; height:50px;" title="查看建议投诉详情" id="block5" onclick="window.location.href=\'<%=ctx%>/business/businessFeedback/getPropFeedDetails.do?feedbackId='+row.feedbackId+'&estateId='+row.estateId+'&fberId='+row.fberId+(row.newsCount>0?'&isNew=1':'')+'\'">'
                    	+ (row.newsCount>0?'<img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" />':'')
                    	+'</span>'
                    	+'</div>'
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