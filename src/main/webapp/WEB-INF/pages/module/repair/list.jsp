<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
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
	                
	                	<li id="repairState_" class="active navlist"><a href="javascript:;"><span>全部报修</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="repairState" id="repairState" value="${repairState}" />
	                    	<ul class="erjnav">
	                            <li id="repairState_0"><a href="javascript:;">未处理</a></li>
	                            <li id="repairState_1"><a href="javascript:;">处理中</a></li>
	                            <li id="repairState_2"><a href="javascript:;">未解决</a></li>
	                            <li id="repairState_3"><a href="javascript:;">已解决</a></li>
	                            <li id="repairState_4"><a href="javascript:;">待评价</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="typeId_" class="navlist"><a href="javascript:;"><span>所有分类</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="typeId" id="typeId" value="" />
	                    	<ul class="erjnav">
	                            <li id="typeId_1"><a href="javascript:;">小修</a></li>
	                            <li id="typeId_2"><a href="javascript:;">大修</a></li>
	                            <li id="typeId_3"><a href="javascript:;">急修</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="repairScore_" class="navlist"><a href="javascript:;"><span>所有评分</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="repairScore" id="repairScore" value="" />
	                    	<ul class="erjnav">
	                    		<li id="repairScore_0"><a href="javascript:;">未评分</a></li>
	                            <li id="repairScore_1"><a href="javascript:;">1分</a></li>
	                            <li id="repairScore_2"><a href="javascript:;">2分</a></li>
	                            <li id="repairScore_3"><a href="javascript:;">3分</a></li>
	                            <li id="repairScore_4"><a href="javascript:;">4分</a></li>
	                            <li id="repairScore_5"><a href="javascript:;">5分</a></li>
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
	                            <li id="orderBy_repairReplies"><a href="javascript:;">评论量排序</a></li>
	                            <li id="orderBy_repairScore"><a href="javascript:;">满意度排序</a></li>
	                        </ul>
	                    </li>
	                </ul>
	                <p id="rowCount"  style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='报修内容/受理人/真实姓名/昵称/电话搜索' /><input id="searbut" type="button" onclick="search()" value="" /></div></div>
	        </div>
	        <div class="column">
	            <c:forEach items="${baseBean.list }" var="repair" varStatus="key">
	        		<div class="manbox"  <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if> >
		            	<a class="nopotr2" href="javascript:;" style="height:296px;">
		                    <div class="info">报修类型：
			                    <span style="color: #3EAF0E;">
									<c:choose>
									       <c:when test="${repair.typeId == 1}">
									              	小修
									       </c:when>
									       <c:when test="${repair.typeId == 2}">
									              	大修
									       </c:when>
									       <c:when test="${repair.typeId == 3}">
									              	急修
									      </c:when>
									</c:choose>
								</span>
							</div>
		                    <time class="time"><fmt:formatDate value="${repair.repairTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    
		                    <hr class="link2">
		                    
		                    <h2 class="title_h"><span class="poht"><img src="<%=ctx %>${repair.portrait}" style="width:100%;"></span>
		                    <em style="font-style:normal; font-weight:bold; line-height:31px;">${repair.reporterName }</em><br> 
		                    <strong style="font-weight:normal; font-size:16px;">${repair.address }</strong></h2>
		                    
		                    <div class="state">
		                    	<c:choose>
								       <c:when test="${repair.repairState == 0}">
								              	<span class="relsta cgray">未处理</span>
								       </c:when>
								       <c:when test="${repair.repairState == 1}">
								              	<span class="relsta cblue">处理中</span>
								       </c:when>
								       <c:when test="${repair.repairState == 2}">
								              	<span class="relsta cred">未解决</span>
								       </c:when>
								       <c:when test="${repair.repairState == 3}">
								              	<span class="relsta cgreen">已解决</span>
								       </c:when>
								       <c:otherwise>
								              	<span class="relsta cyellow">待评价</span>
								       </c:otherwise>
								</c:choose>
			                    <c:if test="${repair.repairState == 2 || repair.repairState == 3}">
		                    		<c:if test="${repair.repairScore != 0}">
			                    		<div class="other-r">
			                    			<img src="<%=ctx %>/images/icon/score<fmt:formatNumber type="number" value="${repair.repairScore}" maxFractionDigits="0"/>.jpg"  />
										</div>
									</c:if>
								</c:if>
		                    </div>
		             
		                    <p class="text2">
		                    	${fn:replace(repair.repairContent, '\\r\\n', '<br />')}
		                    	<%-- <c:choose>
									<c:when test="${fn:length(repair.repairContent) > 60}">
										<c:out value="${fn:substring(repair.repairContent, 0, 59)}......" />
									</c:when>
									<c:otherwise>
										<c:out value="${repair.repairContent}" />
									</c:otherwise>
								</c:choose> --%>
		                    </p>
		                    <div style="height:20px;">
			                    <c:if test="${repair.repairState != 0 && repair.repairReplies > 0}">
		                    		<span class="hf">已回复${repair.repairReplies }条 最后时间<fmt:formatDate value="${repair.lastCommentTime }" pattern="yyyy-MM-dd HH:mm"/></span>
		                    	</c:if>
		                    </div>
		                    <hr class="link y-qz-hr">
	                    	<div class="operate operate2 blop" style="margin:0;">
								<span class="see" style="position:relative; height:50px;" id="block5" title="查看报修详情"  onclick="window.location.href='${ctx}/business/businessRepair/getDetails.do?repairId=${repair.repairId}&reporterId=${repair.reporterId}<c:if test="${repair.newsCount > 0 }">&isNew=1</c:if>'">
									<c:if test="${repair.newsCount > 0 }"><img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" /></c:if>
								</span>
							</div>
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

<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
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
		if($('#repairState').val() != undefined && $('#repairState').val() != '') {
			var objId = 'repairState_'+$('#repairState').val();
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
					repairState: $('#repairState').val(),
					repairScore: $('#repairScore').val(),
					typeId: $('#typeId').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime: $('#endTime').val(),
					orderBy: $('#orderBy').val()
			};
		}
		return params;
	}
    
    //跳转页面
    function jump(pageNo) {
    	$('.column').html('');
    	$('#loading').css('display', 'block');
    	var params = getParams();
    	if(pageNo != 0) {
    		params.page = pageNo;
    	}
    	$.ajax({
    		type: 'post',
            url: '<%=path %>/business/businessRepair/getPageList.do',
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
                    	var repairState = '';
                    	if(row.repairState == 0) {
                    		repairState = '<span class="relsta cgray">未处理</span>';
    		            }else if(row.repairState == 1) {
    		            	repairState = '<span class="relsta cblue">处理中</span>';
    		            }else if(row.repairState == 2) {
    		            	repairState = '<span class="relsta cred">未解决</span>';
    		            }else if(row.repairState == 3) {
    		            	repairState = '<span class="relsta cgreen">已解决</span>';
    		            }else{
    		            	repairState = '<span class="relsta cyellow">待评价</span>';
    		            }
                    	var typeId = '';
                    	if(row.typeId == 1) {
                    		typeId = '小修';
    		            }else if(row.typeId == 2) {
    		            	typeId = '大修';
    		            }else if(row.typeId == 3) {
    		            	typeId = '急修';
    		            }
                    	
                    	var state = '';
                    	if(row.repairState  != 0 && row.repairReplies > 0) {
                    		 state =  '<span class="hf">已回复'+row.repairReplies+'条 最后时间 '+(row.lastCommentTime != 'null' ? row.lastCommentTime.substring(0, 16) : '')+'</span>';
                    	} 
                    	
                    	var score = '';
                    	if(row.repairState == 2 || row.repairState == 3) {
                    		if(row.repairScore != 0) {
                    			score ='<img src="<%=ctx %>/images/icon/score'+parseInt(row.repairScore)+'.jpg"  />';
                    		}
                    	}
                    	
                    	var htmlDom = ''
                    	+ '<div class="manbox" '+styleStr+'>'
                    	+ '<a class="nopotr2" href="javascript:;" style="height:296px;">'
                    	+ '<div class="info">报修类型：<span style="color: #3EAF0E;">'+typeId+'</span></div>'
                    	+ '<time>'+(row.repairTime != null ? row.repairTime.substring(0, 16) : '')+'</time>'
                    	+ '<hr class="link2">'
                    	+ '<h2 class="title_h"><span class="poht"><img src="<%=ctx%>'+row.portrait+'" style="width:100%;"></span><em style="font-style:normal; font-weight:bold; line-height:31px;">'+row.reporterName+'</em><br> <strong style="font-weight:normal; font-size:16px;">'+row.address+'</strong></h2>'
                    	+ '<div class="state">'
                    	+ repairState
                    	+ '<div class="other-r">'+score
                    	+'</div></div>'
                    	+ '<p class="text2">'
                    	+ row.repairContent.replace("\r\n", "<br />")
                    	+ '</p>'
                    	+'<div style="height:20px;">'+state+'</div>'
                    	+ '<hr class="link y-qz-hr">'
                    	+ '<div class="operate operate2 blop" style="margin:0;">'
                    	+'<span class="see" style="position:relative; height:50px;" title="查看报修详情" id="block5" onclick="window.location.href=\'<%=ctx %>/business/businessRepair/getDetails.do?repairId='+row.repairId+'&reporterId='+row.reporterId+(row.newsCount>0?'&isNew=1':'')+'\'">'
                    	+ (row.newsCount>0?'<img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" />':'')
                    	+'</span></div>'
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