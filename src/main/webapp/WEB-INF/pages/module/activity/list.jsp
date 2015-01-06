<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>活动管理</title>
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
	                	<li id="state_" class="active navlist"><a href="javascript:;"><span>全部活动</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="state" id="state" value="" />
	                    	<ul class="erjnav">
	                            <li id="state_0"><a href="javascript:;">已开始</a></li>
	                            <li id="state_1"><a href="javascript:;">未开始</a></li>
	                            <li id="state_2"><a href="javascript:;">已结束</a></li>
	                            <li id="state_3"><a href="javascript:;">待审核</a></li>
	                            <li id="state_4"><a href="javascript:;">未通过</a></li>
	                            <li id="state_5"><a href="javascript:;">待发布</a></li>
	                            <li id="state_6"><a href="javascript:;">定时发布</a></li>
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
	                            <li id="orderBy_particpates"><a href="javascript:;">参与人数高到低</a></li>
	                            <li id="orderBy_comments"><a href="javascript:;">评论量高到低</a></li>
	                            <li id="orderBy_visits"><a href="javascript:;">浏览量高到低</a></li>
	                            <li id="orderBy_supports"><a href="javascript:;">点赞量高到低</a></li>
	                        </ul>
	                    </li>
	                </ul>
	                 <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='标题/内容搜索' /><input id="searbut" type="button" onclick="search()" value="" /></div></div>
	        </div>
	        
	        <div class="column">
	        	<shiro:hasPermission name="activity_publish">
		        	<div class="manbox" style="margin-left:0;">
		            	<a class="nopotr2 s-baoliao-no" onclick="javascript:window.location.href='${ctx}/business/businessActivity/add.do'" style="cursor:pointer;" >
		                    <div class="relnews">
		                    	<img src="${ctx}/images/icon/relnews.png" style="width:100%;" />
		                    </div>
		                	<span class="tittex" >发布活动</span>
		                </a>
		            </div>
            	</shiro:hasPermission>            	
	        	
	            <c:forEach items="${baseBean.list }" var="act" varStatus="key">
	        		
	        			<shiro:lacksPermission name="activity_publish">
	        			<div class="manbox" <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if> >
	        			</shiro:lacksPermission>
	        			<shiro:hasPermission name="activity_publish">
	        			<div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> >
	        			</shiro:hasPermission> 
	        			
		            	<a class="nopotr2 s-baoliao-no" href="javascript:;">
		                    <div class="info">
		                    	<p style="float:left;">活动类型：<span style="color: #3EAF0E;">${act.typeName }</span></p>
		                    	<p style="float:right">活动范围：<span  style="color: #3EAF0E;">
			                    	<c:choose>
										<c:when test="${fn:length(act.actScope) > 11}">
											<c:out value="${fn:substring(act.actScope, 0, 10)}......" />
										</c:when>
										<c:otherwise>
											<c:out value="${act.actScope}" />
										</c:otherwise>
									</c:choose>
								</span></p>
		                    </div>
		                    <time><fmt:formatDate value="${act.createTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    <hr class="link">        
		                    
		                    <h2 class="y-shq-title title">${act.actName }</h2>
		                    <div class="state">
								<c:choose>
								       <c:when test="${act.state == 0}">
								             <span class="relsta cgreen" id="state_change_${act.actId }">已开始</span>
								       </c:when>
								       <c:when test="${act.state == 1}">
								             <span class="relsta cgray" id="state_change_${act.actId }">未开始</span>
								       </c:when>
								       <c:when test="${act.state == 2}">
								             <span class="relsta cblack" id="state_change_${act.actId }">已结束</span>
								       </c:when>
								       <c:when test="${act.state == 3}">
								             <span class="relsta cyellow" id="state_change_${act.actId }">待审核</span>
								       </c:when>
								       <c:when test="${act.state == 4}">
								             <span class="relsta cred" id="state_change_${act.actId }">未通过</span>
								       </c:when>
								       <c:when test="${act.state == 5}">
								             <span class="relsta cblue" id="state_change_${act.actId }">待发布</span>
								       </c:when>
								       <c:when test="${act.state == 6}">
								             <span class="relsta cblue" id="state_change_${act.actId }">定时发布</span>
								       </c:when>
								</c:choose>	
								<!-- 参与，查看，编辑，点赞 -->
								<div class="other-r">
									<c:choose>
										<c:when test="${act.typeId == 1}">
											<c:choose>
												<c:when test="${act.particpates != 0 && act.state < 3}">
													<i class="cyrh" title="参与人数" style="cursor:pointer;" onclick="window.location.href='${ctx}/business/businessActivity/viewParticipates.do?actId=${act.actId}' ">${act.particpates }</i>
												</c:when>
												<c:otherwise>
													<i class="cyr" title="参与人数">${act.particpates }</i>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:when test="${act.typeId == 2}">
											<c:choose>
												<c:when test="${act.particpates != 0 && act.state < 3}">
													<i class="cyrh" title="参与人数" style="cursor:pointer;" onclick="window.location.href='${ctx}/business/businessActivity/viewPublicParticipates.do?actId=${act.actId}' ">${act.particpates }</i>
												</c:when>
												<c:otherwise>
													<i class="cyr" title="参与人数">${act.particpates }</i>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:when test="${act.typeId == 3}">
											<c:choose>
												<c:when test="${act.particpates != 0 && act.state < 3}">
													<i class="cyrh" title="参与人数" style="cursor:pointer;" onclick="window.location.href='${ctx}/business/businessActivity/viewVoteTypeParticipates.do?actId=${act.actId}' ">${act.particpates }</i>
												</c:when>
												<c:otherwise>
													<i class="cyr" title="参与人数">${act.particpates }</i>
												</c:otherwise>
											</c:choose>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${act.comments != 0 && act.state < 3}">
											<i class="revlight" title="评论量" style="cursor:pointer;" onclick="window.location.href='${ctx}/business/businessActivity/viewComments.do?actId=${act.actId}' ">${act.comments }</i>
										</c:when>
										<c:otherwise>
											<i class="rev" title="评论量">${act.comments }</i>
										</c:otherwise>
									</c:choose>
									<i class="look" title="浏览量">${act.visits }</i>
									<i class="help" title="点赞量">${act.supports }</i>
								</div>
							</div>
	                		<img class="y-hdgl-img" src="<%=ctx %>${act.actPic}" style="height: 100px; "/>
		                    <p class="y-hdgl-dzinfor"><span>活动截止时间：${act.publishDate }&nbsp;&nbsp;${act.publishTime }</span></p>
		                    <hr class="link">
			                    
		                    <div class="operate">
		                    	<shiro:hasPermission name="activity_view_detail">
			                    <span class="see y-shq-yfb" title="查看活动详情" onclick="seeDetail('${act.actId}')" ></span>
			                    </shiro:hasPermission>
			                    <shiro:hasPermission name="activity_edit">
			                    	<c:if test="${act.state != 0 && act.state != 1&& act.state != 2}">
			                    		<span class="edit" title="编辑活动" onclick="toEdit('${act.actId}');"></span>
			                    	</c:if>
			                    </shiro:hasPermission>
			                    <shiro:hasPermission name="activity_delete">
			                    	<span class="del y-shq-sck" title="删除活动" onclick="delActivity('${act.actId}');"></span>
		                    	</shiro:hasPermission>
		                    </div>
		                    
		                	<c:if test="${act.isImportant == 1}">
		                   		<span class="gore goreblock" id="top_${act.actId }"><img src="<%=ctx %>/images/icon/gore.png" width="31" height="31" /><i>顶</i></span>
		                	</c:if>
		                </a>
		            </div>
	        	</c:forEach>
	            <div class="no-float"></div>
	        </div>
			<div class="page">
				<div class="pagec">
					<input type="hidden" id="pageCount" value="${pager.pageCount}" />
					<ul id="pageUl">
						<li><a id="arrow-l" class="arrow" href="javascript:prev();" <c:if test="${pager.pageId <= 1 }"> disabled </c:if>></a></li>
						<c:forEach items="${pager.indexs }" var="pageNo">
							<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo });"><span id="page_${pageNo }">${pageNo }</span></a></li>
						</c:forEach>
						<li><a id="arrow-r" class="arrow" href="javascript:next();" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if>></a></li>
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

<div id="actDetailLayer" class="busswi5 s-xw-bu">
    <div id="actDetailBar" class="sidebar5 s-xw-si">
        <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#actDetailLayer').fadeOut('slow');"></a>
        <h2 class="tit5">活动内容<em>【<span id="state1"></span>】</em></h2>
        <div id="wrapper-250">
            <ul class="accordion5">
                <li id="one5" class="files"><a href="#one"><lable id="actName" style="color: #333;"></lable></a></li>
                <div class="link5"></div>
                <ul class="sub-menu5 s-xw-xx">
		              <li><span class="xxl">活动类型：<lable id="typeName"></lable></span><span class="xxr">活动范围：<lable id="actScope"></lable></span></li>
		              <li><span class="xxl">活动截止时间：<lable id="actTime"></lable></span></li>
		              <li><span class="xxl">发布人：<lable id="editor"></lable></span><span class="xxr">发布时间：<lable id="createTime"></lable></span></li>
		              <li id="auditLi"><span class="xxl">审核人：<lable id="auditorName"></lable></span><span class="xxr">审核时间：<lable id="auditTime"></lable></span></li>
		              <li id="viewComponent"></li>
		              <div class="link5"></div>
		              <li id="viewInter"></li>
		              <div class="link5"></div>
		              <li id="auditInfo1" style="color: #cc2510; margin:17px 0 10px 0; display:none;"><lable id="auditInfo2"></lable></li>
		               <div id="hr1" class="link5" style="display:none;"></div>
		              <li id="actContentLi"><lable id="actContent"></lable></li>
		              <li id="rejectMemoLi" style="display: none;">
							<textarea name="refulseMemo" id="refuseMemo" style="width:440px;height:200px;"></textarea>
					  </li>
	           	</ul>
            </ul>
        </div>
        <div class="s-xw-zd">
    		<div class="link6"></div>
       		<div class="submtpres"></div>
   		</div>
    </div>
</div>

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

	function delActivity(id) {
	    var flag = window.confirm("是否删除活动！");
	    if(flag) {
	        $.getJSON('${ctx}/business/businessActivity/delete.do', {id : id}, function(data) {
	            alert(data.message);
	        });
	    }
	}
	
	function toEdit(id) {
	    window.location.href = '${ctx}/business/businessActivity/modify.do?actId='+id;
	}
	
	//查看公告信息
	function seeDetail(actId) {
		$('#actDetailLayer').fadeIn('slow');
	    //异步查询公告信息
	    $.ajax({
	  	  url: 'getActivityByActId.do',
	  	  dataType: 'json',
	  	  data: {actId: actId},
	  	  method: 'post',
	  	  cache: false, 
	  	  async: false,
	  	  success: function(data) {
	      		$('#actName').text(data.actName);
      			$('#actTime').text(data.publishDate+' '+data.publishTime);
	            $('#actContent').html(data.actContent);
	            $('#actScope').text(data.actScope);
	            $('#editor').text(data.editor);
	            $('#createTime').text(data.createTime != "null" ? data.createTime.substring(0, 16) : '');
	            $('#typeName').text(data.typeName);
	            $('#auditorName').text(data.auditorName != "null" ? data.auditorName : '');
	            $('#auditTime').text(data.auditTime != "null" ? data.auditTime.substring(0, 16) : '');
	            if(data.refuseMemo != 'null' &&  data.state == 4) {
	            	 $('#auditInfo2').html("批注：" +data.refuseMemo);	//审批原因
	            } else {
	            	$("#auditInfo1").css('display','none'); 
			         $("#hr1").css('display','none'); 
	            }
	            $('#viewInter').html("预览地址：<%=ctx %>/service/activities/<br>getActivitiesDetailsById.json?ID="+data.actId+"&userId=161" );
	            
	          	//参与，查看，编辑，点赞
	            var comStr = '<div class="s-xw-ic"><i class="cyr">'+data.particpates+'</i><i class="rev">'+data.comments+'</i><i class="look">'+data.visits+'</i><i id="block6" class="help">'+data.supports+'</i></div>';
	            $('#viewComponent').html(comStr);
	            
	            $('#auditLi').show();
	    	  	$('#viewComponent').show();
	    		$('#actContentLi').show();
	    		$('#rejectMemoLi').hide();
	    	  	$('#refuseMemo').val('');
	    	  	
	            var publishState = data.state;
	            if(publishState == 1) {
	            	publishState = '未开始';
	            	if(data.isImportant == "null" || data.isImportant == 0 ) {
	            		// $('.submtpres').html("<input class=\"s-xw-btn1\" title=\"置顶该条活动\" type=\"button\" value=\"设置为置顶\" onclick=\"setTopBtn("+data.actId+");\"/>");
	            		
	            		var rightStr = "";
		            	<shiro:hasPermission name="activity_settop">
		            		rightStr += "<input id=\"qrbut5\" title=\"置顶该条活动\" type=\"submit\" value=\"设置为置顶\" onclick=\"setTopBtn("+data.actId+");\"/>";
		            	</shiro:hasPermission>
		            	<shiro:hasPermission name="activity_withdrawn">
		            		rightStr += "<input id=\"zsbut5\" title=\" 撤回发布该条活动\" type=\"button\" value=\"撤回发布\" onclick=\"cancelActivePublishState("+data.actId+");\"/>";
		            	</shiro:hasPermission>
		            	$('.submtpres').html(rightStr);
	            	}else {
	            		// $('.submtpres').html("<input class=\"s-xw-btn2\" title=\"已置顶\" type=\"button\" value=\"已置顶\" />");
	            		<shiro:hasPermission name="activity_withdrawn">
	            		$('.submtpres').html("<input class=\"s-xw-btn1\" title=\" 撤回发布该条活动\" type=\"button\" value=\"撤回发布\" onclick=\"cancelActivePublishState("+data.actId+");\"/>");
	            		</shiro:hasPermission>
	            	}
	            } else if(publishState == 5) {
	            	publishState = '待发布';
	            	<shiro:hasPermission name="activity_edit">
	            	$('.submtpres').html("<input class=\"s-xw-btn1\" title=\"编辑活动\" type=\"button\" value=\"编辑\" onclick=\"editAct("+data.actId+");\"/>");
	            	</shiro:hasPermission>
	            } else if(publishState == 2) {
	            	publishState = '已结束';
	            	<shiro:hasPermission name="activity_delete">
	                $('.submtpres').html("<input class=\"s-xw-btn1\" title=\"删除活动\" type=\"button\" value=\"删除\" onclick=\"deleteAct("+data.actId+", '"+data.actName+"');\"/>");
	                </shiro:hasPermission>
	            } else if(publishState == 3) {
	            	publishState = '待审核';
	            	<shiro:hasPermission name="activity_audit">
	                $('.submtpres').html("<input id=\"qrbut5\" title=\"立即发布该条活动\" type=\"submit\" value=\"立即发布\" onclick=\"acceptbtn("+data.actId+");\"/><input id=\"zsbut5\" title=\"拒绝该条活动\" type=\"button\" value=\"拒绝\" onclick=\"refusebtn("+data.actId+");\"/>");
	           		</shiro:hasPermission>
	            } else if(publishState == 4) {
	            	publishState = '未通过';
	            	<shiro:hasPermission name="activity_edit">
	                $('.submtpres').html("<input class=\"s-xw-btn1\" title=\"编辑活动\" type=\"button\" value=\"编辑\" onclick=\"editAct("+data.actId+");\"/>");
	                </shiro:hasPermission>
	                $("#auditInfo1").css('display','block'); 
			         $("#hr1").css('display','block'); 
	            } else if(publishState == 0) {
	            	publishState = '已开始';
	            	$('.submtpres').html("");
	            } else if(publishState == 6) {
	            	publishState = '定时发布';
	            	<shiro:hasPermission name="activity_edit">
	                $('.submtpres').html("<input class=\"s-xw-btn1\" title=\"编辑活动\" type=\"button\" value=\"编辑\" onclick=\"editAct("+data.actId+");\"/>");
	                </shiro:hasPermission>
	                $("#auditInfo1").css('display','block'); 
			         $("#hr1").css('display','block'); 
	            }
	            $('#state1').text(publishState);
	  	  }
	    });
	}
	
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					state: $('#state').val(),
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
   	if(pageNo != undefined && pageNo != 0) {
		params.page = pageNo;
	}else{
		params.page = 1;
	}
   	$.ajax({
        url: '<%=path %>/business/businessActivity/getPageList.do',
        type: 'post',
        dataType: 'json', 
        data: params,
        cache: false,
        success: function (data) {
        	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
            var rows = data.rows;
            <shiro:hasPermission name="activity_publish">
            if(params.page == 1) {
            	var addHtml = ''	                
                    + '<div class="manbox" style="margin-left:0;">'
                    + '<a class="nopotr s-baoliao-no" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessActivity/add.do\';" style="cursor:pointer;">'
                    + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div>'
                    + '<span class="tittex">发布活动</span>'
                    + '</a>'
                    + '</div>';
                   	$('.column').append(addHtml);
            }
            </shiro:hasPermission>
            if(rows.length > 0) {
            	for(var i=0;i<rows.length;i++) {
                	var row = rows[i];   
                	var styleStr = '';
                	/* <shiro:lacksPermission name="activity_publish">
                	if(params.page == 1 && i % 3 == 0) {
   	        			styleStr = 'style="margin-left:0;"';
   	        		}
                	</shiro:lacksPermission>
                	<shiro:hasPermission name="activity_publish">
                	if(params.page == 1 && i % 3 == 2) {
                		styleStr = 'style="margin-left:0;"';
   	        		}
                	</shiro:hasPermission>
					if(params.page > 1 && i % 3 == 0) {
   	        			styleStr = 'style="margin-left:0;"';
   	        		} */
   	        		<shiro:lacksPermission name="activity_publish">
                	if(params.page == 1 && i % 3 == 0) {
   	        			styleStr = 'style="margin-left:0;"';
   	        		}
                	</shiro:lacksPermission>
                	<shiro:hasPermission name="activity_publish">
                	if(params.page == 1 && i % 3 == 2) {
                		styleStr = 'style="margin-left:0;"';
   	        		}
                	</shiro:hasPermission>
					if(params.page > 1 && i % 3 == 0) {
   	        			styleStr = 'style="margin-left:0;"';
   	        		}
                	var state = '';
                	if(row.state == 0) {
                		state = '<span class="relsta cgreen" id="state_change_'+row.actId+'">已开始</span>';
		            }else if(row.state == 1) {
		            	state = '<span class="relsta cgray" id="state_change_'+row.actId+'">未开始</span>';
		            }else if(row.state == 2) {
		            	state = '<span class="relsta cblack" id="state_change_'+row.actId+'">已结束</span>';
		            }else if(row.state == 3) {
		            	state = '<span class="relsta cyellow" id="state_change_'+row.actId+'">待审核</span>';
		            }else if(row.state == 4) {
		            	state = '<span class="relsta cred" id="state_change_'+row.actId+'">未通过</span>';
		            }else  if(row.state == 5) {
		            	state='<span class="relsta cblue" id="state_change_'+row.actId+'">待发布</span>';
		            }else  if(row.state == 6) {
		            	state='<span class="relsta cblue" id="state_change_'+row.actId+'">定时发布</span>';
		            }
                	
                	var edit = '';
                	if(row.state != 0 && row.state != 1 && row.state != 2) {
                		<shiro:hasPermission name="activity_edit">
                		edit='<span class="edit" title="编辑活动" onclick="toEdit('+row.actId+');"></span>';
                		</shiro:hasPermission>
                	}
                	var particpate = '';
                	if(row.typeId == 1) {
                    	if(row.particpates != 0 && row.state < 3){
                    		particpate = '<i class="cyrh" title="参与人数" style="cursor:pointer;" onclick="window.location.href=\'viewParticipates.do?actId='+row.actId+'\' ">'+row.particpates+'</i>';
                    	} else {
                    		particpate = '<i class="cyr" title="参与人数">'+row.particpates+'</i>';
                    	}
                	} else if(row.typeId == 2) {
                    	if(row.particpates != 0 && row.state < 3){
                    		particpate = '<i class="cyrh" title="参与人数" style="cursor:pointer;" onclick="window.location.href=\'viewPublicParticipates.do?actId='+row.actId+'\' ">'+row.particpates+'</i>';
                    	} else {
                    		particpate = '<i class="cyr" title="参与人数">'+row.particpates+'</i>';
                    	}
                	} else if(row.typeId == 3) {
                    	if(row.particpates != 0 && row.state < 3){
                    		particpate = '<i class="cyrh" title="参与人数" style="cursor:pointer;" onclick="window.location.href=\'viewVoteTypeParticipates.do?actId='+row.actId+'\' ">'+row.particpates+'</i>';
                    	} else {
                    		particpate = '<i class="cyr" title="参与人数">'+row.particpates+'</i>';
                    	}
                	}
                	
                	var comment = '';
                	if(row.comments != 0 && row.state < 3){
                		comment = '<i class="revlight" title="评论量" style="cursor:pointer;" onclick="window.location.href=\'viewComments.do?actId='+row.actId+'\' ">'+row.comments+'</i>';
                	} else {
                		comment = '<i class="rev" title="评论量">'+row.comments+'</i>';
                	}
                	
                	var htmlDom = ''
	              		+ '<div class="manbox"'
	    	        	+ styleStr
	    	        	+ '>'                    	
	                	+ '<a class="nopotr s-baoliao-no" href="javascript:;">'
	                	+ '<div class="info"><p style="float:left;">活动类型：<span style="color: #3EAF0E;">'+row.typeName+'</span></p><p style="float:right">活动范围：<span  style="color: #3EAF0E;">'+(row.actScope.length >11 ? row.actScope.substring(0, 10)+"......" : row.actScope)+'</span></p></div>'
	                	+ '<time>'+(row.creatTime != '' ? row.createTime.substring(0, 16) : '')+'</time>'
	                	+ '<hr class="link">'
	                	+ '<h2 class="y-shq-title title">'+row.actName+'</h2>'
	                	+ '<div class="state">'+state
	                	+'<div class="other-r">'
	                	+particpate
	                	+comment
	                	+'<i class="look" title="浏览量">'+row.visits+'</i>'
	                	+ '<i class="help" title="点赞量">'+row.supports+'</i>'
	                	+'</div>'
	                	+'</div>'
	                	+ '<img class="y-hdgl-img" src="<%=ctx%>'+row.actPic+'" style="height: 100px; "/>'
                    	+ '<p class="y-hdgl-dzinfor">'
                    	+ '<span>活动截止时间：'+row.publishDate+'&nbsp;&nbsp;'+row.publishTime+' </span></p>'
                    	+ '<hr class="link">'
                    	+ '<div class="operate">'
                    	<shiro:hasPermission name="activity_view_detail">
                    	+'<span class="see y-shq-yfb" title="查看活动详情" onclick="seeDetail('+row.actId+')"></span>'
                    	</shiro:hasPermission>
                    	<shiro:hasPermission name="activity_edit">
                    	+ edit
                    	</shiro:hasPermission>
                    	<shiro:hasPermission name="activity_delete">
                    	+ '<span class="del y-shq-sck"  title="删除活动" onclick="delActivity('+row.actId+');"></span>'
                    	</shiro:hasPermission>
                    	+ '</div>'
                    	+(row.isImportant == 1?'<span class="gore goreblock" id="top_${act.actId }"><img src="<%=ctx %>/images/icon/gore.png" width="31" height="31" /><i>顶</i></span>':'')
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
    
  //编辑
    function editAct(actId) {
    	window.location.href = "modify.do?actId="+actId;
    }
   
 	// 置顶
	function setTopBtn(actId) {
        $.post("setTop.do", {actId: actId}, function(data) {
        	eval("data = "+data);
        	var bool ="";
        	if(data.oldacttitle == "") {
	        	bool = window.confirm("您确认要置顶显示：\n\""+data.acttitle+"\"");
        	} else {
        		bool = window.confirm("您确认要置顶显示：\n\""+data.acttitle+"\"\n将替换掉\n\""+data.oldacttitle+"\"");
        	}
    	    if(bool) {
    	    	$.post("updateActImportantState.do", {id : actId,oldactId : data.oldactId}, function(data1) {
    	    		eval("data1 = "+data1);
	    			alert(data1.message);
    	            window.location.reload();
    	        });
    	    }
        });
	}
   
 	/* //置顶
    function setTopBtn(actId) {
    	$.ajax({
      	  url: 'setTop.do',
      	  dataType: 'json',
      	  data: {actId: actId},
      	  method: 'post',
      	  success: function(data) {
      		   
      		  if(data.success == 'true') {
      			  alert(data.message);
      			  $("#actDetailLayer").fadeOut("slow");
      			  window.location.reload();
      		  }else{
      			  alert(data.message);
      		  }
      	  }
        });
    } */

 	// 撤回发布该条活动
	function cancelActivePublishState(actId) {
		var bool = window.confirm("您确定撤回发布该条活动？");
	    if(bool) {
	        $.post("cancelActivePublishState.do", {actId : actId}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
    
  //接受
  function acceptbtn(actId) {
      $.ajax({
    	  url: 'acceptAct.do',
    	  data: {actId: actId},
    	  dataType: 'json',
    	  method: 'post',
    	  success: function(data) {
    		  if(data.success == 'true') {
    			  alert(data.message);
    			  $('#state_change_'+actId).text('未开始');
    			  $("#actDetailLayer").fadeOut("slow");
    		  }else{
    			  alert(data.message);
    		  }
    	  }
      });
  }

  //拒绝
  function refusebtn(actId) {
	  	$('#auditLi').hide();
	  	$('#viewComponent').hide();
		$('#actContentLi').hide();
		$('#rejectMemoLi').show();
		$('.submtpres').empty();
		$('.submtpres').html('<input id="qrbut5" type="button" value="确认" onclick="refuseOk('+actId+')"/>'+
                '<input id="zsbut5" type="button" value="取消" onclick="refuseCancel('+actId+')"/>');
  }
  
  //拒绝成功
  function refuseOk(actId) {
	  var refuseMemo = $('#refuseMemo').val();
	  if(refuseMemo != '') {
		  $.ajax({
	    	  url: 'refuseAct.do',
	    	  dataType: 'json',
	    	  data: {actId: actId, refuseMemo: refuseMemo},
	    	  method: 'post',
	    	  success: function(data) {
	    		   
	    		  if(data.success == 'true') {
	    			  alert(data.message);
	    			  $('#state_change_'+actId).text('未通过');
	    			  $("#actDetailLayer").fadeOut("slow");
	    		  }else{
	    			  alert(data.message);
	    		  }
	    	  }
	      });
	  }else{
		  alert('请填写批注内容');
	  }
  }
  
  //拒绝取消
  function refuseCancel(actId) {
	  	$('#auditLi').show();
	  	$('#viewComponent').show();
		$('#actContentLi').show();
		$('#rejectMemoLi').hide();
	  	$('#refuseMemo').val('');
		$('.submtpres').empty();
		$('.submtpres').html("<input id=\"qrbut5\" title=\"立即发布该条活动\" type=\"submit\" value=\"立即发布\" onclick=\"acceptbtn("+actId+");\"/><input id=\"zsbut5\" title=\"拒绝该条活动\" type=\"button\" value=\"拒绝\" onclick=\"refusebtn("+actId+");\"/>");
  }

  //删除
  function deleteAct(actId, actName) {
      var bool = window.confirm("您确定要删除：" + actName);
      if(bool) {
          $.ajax({
        	  url: 'delete.do',
        	  data: {id: actId},
        	  dataType: 'json',
        	  method: 'post',
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
</script>