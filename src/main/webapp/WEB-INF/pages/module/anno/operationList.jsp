<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>运营公告管理</title>
        <%@include file="/common/meta.jsp"%>
        <script src="<%=ctx%>/js/anno/anno.js" type="text/javascript"></script>
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
            <!--下拉显示导航-->
            
            <div class="scroll">
	        	<div class="scroll-box">
	                <ul id="oneul">
	                	<li id="publishState_" class="active navlist"><a href="javascript:;"><span>全部公告</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="publishState" id="publishState" value="${publishState}" />
	                    	<ul class="erjnav">
	                            <li id="publishState_0"><a href="javascript:;">已发布</a></li>
	                            <li id="publishState_1"><a href="javascript:;">待发布</a></li>
	                            <li id="publishState_2"><a href="javascript:;">待审核</a></li>
	                            <li id="publishState_3"><a href="javascript:;">未通过</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="annoType_" class="active navlist"><a href="javascript:;"><span>全部类型</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="annoType" id="annoType" value="" />
	                    	<ul class="erjnav">
	                    		<li id="annoType_2"><a href="javascript:;">内部公告</a></li>
	                            <li id="annoType_3"><a href="javascript:;">外部公告</a></li>
	                        </ul>
	                    </li>
	                       
	                    <li id="timeScope_" class="navlist" ><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a>
                    		<input type="hidden" name="timeScope" id="timeScope" value="${timeScope }" />
                    		<input type="hidden" name="dateField" id="dateField" value="${sort}" />
                    		<input type="hidden" name="startTime" id="startTime" value="" />
                    		<input type="hidden" name="endTime" id="endTime" value="" />
	                    	<ul class="erjnav" >
	                    		<li id="timeScope_0"><a href="javascript:;">当日</a></li>
	                            <li id="timeScope_7"><a href="javascript:;">7天内</a></li>
	                            <li id="timeScope_30"><a href="javascript:;">30天内</a></li>
	                            <li id="timeScope_90"><a href="javascript:;">90天内</a></li>
	                            <li id="timeScope_365"><a href="javascript:;">365天内</a></li>
	                            <li id="timeScope_scope"><a href="javascript:;">选择时间范围</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="orderBy_" class="navlist" ><a href="javascript:;"><span>最新时间排序</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="orderBy" id="orderBy" value="${sort}" />
	                    	<ul class="erjnav" >
	                        	<li id="orderBy_comments"><a href="javascript:;">评论量高到低</a></li>
	                            <li id="orderBy_visits"><a href="javascript:;">浏览量高到低</a></li>
	                            <li id="orderBy_supports"><a href="javascript:;">点赞量高到低</a></li>
	                        </ul>
	                    </li>
	                </ul>
	                <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='标题/内容/发布人搜索' /><input id="searbut" type="button" onclick="search()" value="" /></div></div>
	        </div>
	        
	        <div class="column">
	        	<!-- 发布公告开始 -->
	        	<shiro:hasPermission name="operation_anno_add_anno">
	        	<div class="manbox" style="margin-left:0;">
	            	<a class="nopotr" href="javascript:window.location.href='<%=ctx %>/business/businessAnno/operationAdd.do';" style="cursor:pointer;">
	                    <div class="relnews">
                            <img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" />
                        </div>
	                	<span class="tittex">发布公告</span>
	                </a>
	            </div>
	            </shiro:hasPermission>
	        	<!-- 发布公告结束 -->
	        	
	        	<!-- 公告内容开始 -->
	            <c:forEach items="${baseBean.list }" var="anno" varStatus="key">
	        		 
	        			<shiro:lacksPermission name="operation_anno_add_anno">
	        			<div class="manbox" <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if> >
	        			</shiro:lacksPermission>
	        			<shiro:hasPermission name="operation_anno_add_anno">
	        			<div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> >
	        			</shiro:hasPermission>
	        			
		            	<a class="nopotr" href="javascript:;">
		                    <div class="info">公告范围：<span>
		                    	<c:choose>
									<c:when test="${fn:length(anno.annoScopeInfo) > 23}">
										<c:out value="${fn:substring(anno.annoScopeInfo, 0, 22)}......" />
									</c:when>
									<c:otherwise>
										<c:out value="${anno.annoScopeInfo}" />
									</c:otherwise>
								</c:choose></span></div>
		                    <time><fmt:formatDate value="${anno.publishTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    <hr class="link">
		                    <h2 class="title">${anno.annoTitle }</h2>
		                    
		                    <div class="state">
								<c:choose>
								       <c:when test="${anno.publishState == 0}">
								              	<span class="relsta cgreen" id="publishState_${anno.annoId }">已发布</span>
								       </c:when>
								       <c:when test="${anno.publishState == 1}">
								              	<span class="relsta cgray" id="publishState_${anno.annoId }">待发布</span>
								       </c:when>
								       <c:when test="${anno.publishState == 2}">
								              	<span class="relsta cyellow" id="publishState_${anno.annoId }">待审核</span>
								       </c:when>
								       <c:when test="${anno.publishState == 3}">
								              	<span class="relsta cred" id="publishState_${anno.annoId }">未通过</span>
								       </c:when>
								</c:choose>
                            <div class="other-r">
                            	<c:choose>
							       <c:when test="${anno.comments != 0 && anno.publishState == 0}">
							            <i class="revlight" title="评论量" style="cursor:pointer;" onclick="window.location.href='${ctx}/business/businessAnnoComment/list.do?annoId=${anno.annoId}' ">${anno.comments }</i>
							       </c:when>
							       <c:otherwise>
							              <i class="rev" title="评论量">${anno.comments }</i>
							       </c:otherwise>
								</c:choose>
                            	<%--评论详情--%>
                                <i class="look" title="浏览量">${anno.visits }</i><%--浏览量--%>
                                <i class="help" id="block6" title="点赞量">${anno.supports }</i> <%--点赞量--%>
                            </div>
                            </div>
		                    <div class="text">${anno.brief}</div>
		                    <hr class="link">
		                    
		                    <div class="operate">
		                    	<shiro:hasPermission name="operation_anno_view_detail">
		                    		<span class="see"  title="查看公告详情"  id="block5" onclick="seeDetail('${anno.annoId}')"></span>
		                    	</shiro:hasPermission>
		                    	<c:if test="${anno.publishState != 0 }">
		                    		<shiro:hasPermission name="operation_anno_edit_anno">
		                    			<span class="edit" title="编辑公告" onclick="window.location.href='${ctx}/business/businessAnno/operationModify.do?annoId=${anno.annoId}'"></span>
		                    		</shiro:hasPermission>
		                    	</c:if>
		                    	<shiro:hasPermission name="operation_anno_delete_anno">
		                    		<span class="del" title="删除公告"  onclick="deleteAnno('${anno.annoId}', '${anno.annoTitle}');"></span>
		                    	</shiro:hasPermission>
		                    </div>
		                	<c:if test="${anno.isImportant == 1}">
		                   		<span class="gore goreblock" id="top_${anno.annoId }"><img src="<%=ctx %>/images/icon/gore.png" width="31" height="31" /><i>顶</i></span>
		                	</c:if>
		                </a>
		                
		            </div>
	        	</c:forEach>
	        	<!-- 公告内容结束 -->
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

	<div id="annoInfoLayer" class="busswi5 s-xw-bu">
        <div id="annoInfoBar" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#annoInfoLayer').fadeOut('slow');"></a>
            <h2 class="tit5">公告内容<em>【<span id="publishState1"></span>】</em></h2>
            <div id="wrapper-250">
                <ul class="accordion5">
                    <li id="one5" class="files"><a href="#one"><lable id="annoTitle" style="color: #333;"></lable></a></li>
                    <div class="link5"></div>
                    <ul class="sub-menu5 s-xw-xx">
		                <li><span>公告范围：<lable id="annoScope"></lable></span></li>
		                <li><span class="xxl">发布人：<lable id="publisherName"></lable></span><span class="xxr">发布时间：<lable id="publishTime"></lable></span></li>
		                <li id="auditLi"><span class="xxl">审核人：<lable id="auditorName"></lable></span><span class="xxr">审核时间：<lable id="auditTime"></lable></span></li>
		                <div class="link5"></div>
		                <li id="auditInfo1" style="color: #cc2510; margin:17px 0 10px 0; display:none;"><lable id="auditInfo2"></lable></li>
		                <div id="hr1" class="link5" style="display:none;"></div>
		                <li id="viewInter"></li>
		              	<div id="hr2" class="link5"></div>
		                <li id="annoContentLi"><div class="s-xw-con"><lable id="annoContent"></lable></div></li>
		                
		                <li id="rejectMemoLi" style="display: none;">
							<textarea name="refulseMemo" id="refuseMemo" style="width:435px;height:200px; font-size:14px; padding-top:5px; padding-left:5px;" placeholder="请输入拒绝原因，发送至提交人" ></textarea>
						</li>
	              	</ul>
                </ul>
            </div>
            <div class="s-xw-zd">
         			<div class="link6"></div>
            		<div class="submtpres">
                		
            		</div>
        		</div>
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
<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
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
		if($('#orderBy').val() != undefined && $('#orderBy').val() != '') {
			var objId = 'orderBy_'+$('#orderBy').val();
			bindChange($('#'+objId));
		}
		
		if($('#publishState').val() != undefined && $('#publishState').val() != '') {
			var objId = 'publishState_'+$('#publishState').val();
			bindChange($('#'+objId));
		}
		
		if($('#timeScope').val() != undefined && $('#timeScope').val() != '') {
			var objId = 'timeScope_'+$('#timeScope').val();
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
					publishState: $('#publishState').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime: $('#endTime').val(),
					annoType: $('#annoType').val(),
					orderBy: $('#orderBy').val(),
					dateField: $('#dateField').val()
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
            url: '<%=path %>/business/businessAnno/getOperationPageList.do',
            type: 'post',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
            	//alert(data.total);
            	//pageShow(data.total);
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
            	
                var rows = data.rows;
                <shiro:hasPermission name="operation_anno_add_anno">
                if(params.page == 1) {
                	var addHtml = ''
	                + '<div class="manbox" style="margin-left:0;">'
	                + '<a class="nopotr" href="javascript:window.location.href=\'<%=ctx %>/business/businessAnno/operationAdd.do\';" style="cursor:pointer;">'
	                + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div> '
	                + '<span class="tittex">发布公告</span>'              
	                + '</a>'
	                + '</div>';	                
                	$('.column').append(addHtml);
                }
                </shiro:hasPermission>
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                    	var row = rows[i];   
                    	var styleStr = '';
                    	<shiro:lacksPermission name="operation_anno_add_anno">
                    	if(params.page == 1 && i % 3 == 0) {
	   	        			styleStr = 'style="margin-left:0;"';
	   	        		}
                    	</shiro:lacksPermission>
                    	<shiro:hasPermission name="operation_anno_add_anno">
                    	if(params.page == 1 && i % 3 == 2) {
	                		styleStr = 'style="margin-left:0;"';
	   	        		}
                    	</shiro:hasPermission>
						if(params.page > 1 && i % 3 == 0) {
	   	        			styleStr = 'style="margin-left:0;"';
	   	        		}
                    	var publishState = '';
                    	if(row.publishState == 0) {
                    		publishState = '<span class="relsta cgreen" id="publishState_'+row.annoId+'">已发布</span>';
    		            }else if(row.publishState == 1) {
    		            	publishState = '<span class="relsta cgray" id="publishState_'+row.annoId+'">待发布</span>';
    		            }else if(row.publishState == 2) {
    		            	publishState = '<span class="relsta cyellow" id="publishState_'+row.annoId+'">待审核</span>';
    		            }else{
    		            	publishState = '<span class="relsta cred" id="publishState_'+row.annoId+'">未通过</span>';
    		            }  
                    	var annoContent = '';
                    	if(annoContent!= '' && annoContent.length > 59) {
                    		annoContent = annoContent.substring(0, 59) + '......';
                    	}
                    	var important = '';
                    	if(row.isImportant == 1) {
                    		important = '<span class="gore goreblock"><img src="<%=ctx %>/images/icon/gore.png" width="31" height="31" /><i>顶</i></span>';
                    	}
                        var commentsView = '';
                    	if(row.comments != 0) {
                    		commentsView = '<i class="revlight" title="评论量" onclick="'+row.annoId+')" style="cursor: pointer">'+row.comments+'</i>';
                    	}else{
                    		commentsView = '<i class="rev" title="评论量">'+row.comments+'</i>';
                    	}
                    	var htmlDom = ''
                    	+ '<div class="manbox"'
    	        		+ styleStr 
    	        		+ '>'
                        + '<a class="nopotr" href="javascript:;">'
    		            + '<div class="info">公告范围：<span>'+(row.annoScopeInfo.length >23 ? row.annoScopeInfo.substring(0, 22)+"......" : row.annoScopeInfo)+'</span></div>'
    		            + '<time>'+(row.publishTime != '' ? row.publishTime.substring(0, 16) : '')+'</time>'
    		            + '<hr class="link">'
    		            + '<h2 class="title">'+row.annoTitle+'</h2>'
    		            + '<div class="state">'
    					+ publishState
                        + '<div class="other-r">'
                        + commentsView
                        + '<i class="look" title="浏览量" style="cursor: pointer">'+row.visits+'</i>'
                        + '<i class="help" id="block6" title="点赞量" style="cursor: pointer">'+row.supports+'</i>'
                        + '</div>'
                        + '</div>'
    		            + '<p class="text">'
    		            + row.brief
    					+ '</p>'
    		            + '<hr class="link">'
    		            <shiro:hasPermission name="operation_anno_view_detail">
    		            + '<div class="operate"><span class="see" title="查看公告详情" id="block5" onclick="seeDetail('+row.annoId+')"></span>'
    		            </shiro:hasPermission>
    		            <shiro:hasPermission name="operation_anno_edit_anno">
    		            +(row.publishState != 0?'<span class="edit" title="编辑公告" onclick="window.location.href=\'${ctx}/business/businessAnno/operationModify.do?annoId='+row.annoId+'\'"></span>':'')
    		            </shiro:hasPermission>
    		            <shiro:hasPermission name="operation_anno_delete_anno">
    		            +'<span class="del" title="删除公告" onclick="deleteAnno('+row.annoId+', "'+row.annoTitle+'");"></span>'
    		            </shiro:hasPermission>
    		            +'</div>'
    		            +  important
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
    
  	//关闭浏览量
    function closeVisitDiv() {
    	$("#visitDiv").fadeOut("slow");
    	$("#visitUl").html("");
    }
    
    //关闭点赞量
    function closeSupportDiv() {
    	$("#supportDiv").fadeOut("slow");
    	$("#supportUl").html("");
    }
  
    function jumpComment(annoId) {
    	window.location.href = '<%=ctx %>/business/businessAnnoComment/list.do?annoId='+annoId;
    }
    
    //查看公告信息
    function seeDetail(annoId) {
        //异步查询公告信息
        $.ajax({
      	  url: 'getAnnoJson.do',
      	  data: {annoId: annoId},
      	 dataType: 'json',
      	  method: 'post',
      	  cache: false, 
      	  async: false,
      	  success: function(data) {
      		   
	      		$('#annoTitle').text(data.annoTitle);
	            $('#annoContent').html(data.annoContent);
	            $('#annoScope').text(data.annoScope);
	            $('#publisherName').text(data.publisherName);
	            $('#publishTime').text(data.publishTime != '' ? data.publishTime.substring(0, 16) : '');
	            
	            if(data.delMemo != '' &&  data.publishState == 3) {
	            	$('#auditInfo2').html("批注：" +data.delMemo);	//审批原因
	            } else {
	            	$("#auditInfo1").css('display','none'); 
			         $("#hr1").css('display','none'); 
	            }
	            
	            if(data.annoType == 4){
	            	$('#viewInter').html("预览地址：http://wx.bqsqcm.com/wxokjia/gonggao_info.php?userId=0&ID=63");
	            }else if(data.annoType == 0){
	            	$('#viewInter').html("预览地址：http://wx.bqsqcm.com/wxokjia/wuye_info.php?userId=0&ID=152");
	            } else {
	            	$("#viewInter").css('display','none'); 
			         $("#hr2").css('display','none'); 
	            }
	            var publishState = data.publishState;
	            $('#publishState1').text('');
	            $('#annoContentLi').show();
        		$('#rejectMemoLi').hide();
        		$('.submtpres').empty();
	            if(publishState == 0) {
	            	publishState = '已发布';
	            	if( data.annoType == 4){
		            	if(data.isImportant == "null" || data.isImportant == 0 ) {
		            		//$('.submtpres').html("<input class=\"s-xw-btn1\" title=\"置顶该条公告\" type=\"button\" value=\"设置为置顶\" onclick=\"setTopBtn("+annoId+");\"/>");
		            		var rightHtml = '';
		            		<shiro:hasPermission name="operation_anno_settop_anno">
		            			rightHtml += "<input id=\"qrbut5\" title=\"置顶该条公告\" type=\"submit\" value=\"设置为置顶\" onclick=\"setTopBtn("+annoId+");\"/>";
		            		</shiro:hasPermission>
		            		<shiro:hasPermission name="operation_anno_withdraw_anno">
		            			rightHtml += "<input id=\"zsbut5\" title=\" 撤回发布该条公告\" type=\"button\" value=\"撤回发布\" onclick=\"cancelAnnoPublishState("+annoId+");\"/>";	
		            		</shiro:hasPermission>
		            		$('.submtpres').html(rightHtml);
		            	}else {
		            		// $('.submtpres').html("<input class=\"s-xw-btn2\" title=\"已置顶\" type=\"button\" value=\"已置顶\" />");
		            		<shiro:hasPermission name="operation_anno_withdraw_anno">
		            			$('.submtpres').html("<input class=\"s-xw-btn1\" title=\" 撤回发布该条公告\" type=\"button\" value=\"撤回发布\" onclick=\"cancelAnnoPublishState("+annoId+");\"/>");
		            		</shiro:hasPermission>
		            	} 
	            	} else {
	            		<shiro:hasPermission name="operation_anno_withdraw_anno">
	            			$('.submtpres').html("<input class=\"s-xw-btn1\" title=\" 撤回发布该条公告\" type=\"button\" value=\"撤回发布\" onclick=\"cancelAnnoPublishState("+annoId+");\"/>");
	            		</shiro:hasPermission>
	            	}
	            } else if(publishState == 1) {
	            	publishState = '待发布';
	            	<shiro:hasPermission name="operation_anno_edit_anno">
	            	$('.submtpres').html("<input class=\"s-xw-btn1\" title=\"编辑公告\" type=\"button\" value=\"编辑\" onclick=\"editAnno("+annoId+");\"/>");
	            	</shiro:hasPermission>
	            } else if(publishState == 2) {
	            	publishState = '待审核';
	            	<shiro:hasPermission name="operation_anno_audit_anno">
	                $('.submtpres').html("<input id=\"qrbut5\" title=\"采纳该条公告\" type=\"submit\" value=\"采纳\" onclick=\"acceptbtn("+annoId+");\"/><input id=\"zsbut5\" title=\"拒绝该条公告\" type=\"button\" value=\"拒绝\" onclick=\"refusebtn("+annoId+");\"/>");
	            	</shiro:hasPermission>
	            } else {
	            	publishState = '未通过';
	            	<shiro:hasPermission name="operation_anno_edit_anno">
	                $('.submtpres').html("<input class=\"s-xw-btn1\" title=\"编辑公告\" type=\"button\" value=\"编辑\" onclick=\"editAnno("+annoId+");\"/>");
	                </shiro:hasPermission>
	                $("#auditInfo1").css('display','block'); 
			         $("#hr1").css('display','block'); 
	            }
	            $('#publishState1').text(publishState);
      	  }
        });
        
        $("#annoInfoLayer").fadeIn("slow");
        $("#annoInfoLayer").css("height",$(document.body).outerHeight(true)+'px');
        $("#annoInfoBar").css("height",$(document.body).outerHeight(true)-40+'px');
    }
    
    //编辑
    function editAnno(annoId) {
    	window.location.href = "operationModify.do?annoId="+annoId;
    }
   
 	// 置顶
	function setTopBtn(annoId) {
        $.post("setTop.do", {annoId: annoId}, function(data) {
        	eval("data = "+data);
        	var bool ="";
        	if(data.oldannotitle == "") {
	        	bool = window.confirm("您确认要置顶显示：\n\""+data.annotitle+"\"");
        	} else {
        		bool = window.confirm("您确认要置顶显示：\n\""+data.annotitle+"\"\n将替换掉\n\""+data.oldannotitle+"\"");
        	}
    	    if(bool) {
    	    	$.post("updateAnnoImportantState.do", {id : annoId,oldannoId : data.oldannoId}, function(data1) {
    	    		eval("data1 = "+data1);
	    			alert(data1.message);
    	            window.location.reload();
    	        });
    	    }
        });
	}
 
    //置顶
    /* function setTopBtn(annoId) {
    	$.ajax({
      	  url: 'setTop.do',
      	  data: {annoId: annoId},
      	  method: 'post',
      	  success: function(data) {
      		   
      		  if(data.success == 'true') {
      			  alert(data.message);
      			  $(".busswi5").fadeOut("slow");
      			  window.location.reload();
      		  }else{
      			  alert(data.message);
      		  }
      	  }
        });
    } */

	 // 撤回发布该条公告
	function cancelAnnoPublishState(annoId) {
		var bool = window.confirm("您确定撤回发布该条公告？");
	    if(bool) {
	        $.post("cancelAnnoPublishState.do", {annoId: annoId}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
    
  //接受
  function acceptbtn(annoId) {
      $.ajax({
    	  url: 'acceptAnno.do',
    	  data: {annoId: annoId},
    	  method: 'post',
    	  dataType: 'json',
    	  success: function(data) {
    		   
    		  if(data.success == 'true') {
    			  alert(data.message);
    			  //$('#publishState_'+annoId).text('已发布');
    			  //$(".busswi5").fadeOut("slow");
    			  window.location.reload();
    		  }else{
    			  alert(data.message);
    		  }
    	  }
      });
  }

   // 拒绝
  function refusebtn(annoId) {
		$('#annoContentLi').hide();
		$('#rejectMemoLi').show();
		$('.submtpres').empty();
		$('.submtpres').html('<input id="qrbut5" type="button" value="确认" onclick="refuseOk('+annoId+')"/>'+
                '<input id="zsbut5" type="button" value="取消" onclick="refuseCancel('+annoId+')"/>');
  }
  
  function refuseOk(annoId) {
	  var refuseMemo = $('#refuseMemo').val();
	  if(refuseMemo != '') {
		  $.ajax({
	    	  url: 'refuseAnno.do',
	    	  data: {annoId: annoId, refuseMemo: refuseMemo},
	    	  method: 'post',
	    	  dataType: 'json',
	    	  success: function(data) {
	    		   
	    		  if(data.success == 'true') {
	    			  alert(data.message);
	    			  //$('#publishState_'+annoId).text('未通过');
	    			  //$(".busswi5").fadeOut("slow");
	    			  window.location.reload();
	    		  }else{
	    			  alert(data.message);
	    		  }
	    	  }
	      });
	  }else{
		  alert('请填写批注内容');
	  }
  }
  
  function refuseCancel() {
	  $(".busswi5").fadeOut("slow");
	  $('#refuseMemo').val('');
  }

  //删除
  function deleteAnno(annoId, annoName) {
      var bool = window.confirm("您确定要删除：" + annoName);
      if(bool) {
          $.ajax({
        	  url: 'delete.do',
        	  data: {id: annoId},
        	  method: 'post',
        	  dataType: 'json',
        	  success: function(data) {
        		   
        		  if(data.success == 'true') {
        			  alert(data.message);
        			  window.location.reload();
        		  }else{
        			  alert(data.message);
        		  }
        	  }
          });
      }
  }
//全局的ajax访问，处理ajax清求时sesion超时  
 /* $.ajaxSetup({   
      contentType:"application/x-www-form-urlencoded;charset=utf-8",   
      complete:function(XMLHttpRequest,textStatus){   
    	  alert(1111)
              var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
              if(sessionstatus=="timeout"){   
            	  alert(222)
                          //如果超时就处理 ，指定要跳转的页面  
                                  window.location.replace("${path}/common/login.do");   
               }   
      }   
    });  */
</script>