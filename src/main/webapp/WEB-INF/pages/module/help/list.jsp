<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>社区开聊管理</title>
	<%@include file="/common/meta.jsp"%>
    <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
    <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
	<script type="text/javascript">
			$(function () {
				$(document).keyup(function(event){
					  if(event.keyCode ==13){
					    $("#searbut").trigger("click");
					  }
				});
			});
	
            function delHelp(id) {
                var flag = window.confirm("是否删除此社区开聊信息！");
                if(flag) {
                    $.getJSON('${ctx}/business/businessHelp/delete.do', {id: id}, function(data) {
                        alert(data.message);
                        location.reload();
                    });
                }
            }
	</script>
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
						<li id="state_" class="active navlist"><a href="javascript:;"><span>全部社区开聊</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="state" id="state" value="" />
	                    	<ul class="erjnav">
	                            <li id="state_0"><a href="javascript:;">未回复</a></li>
	                            <li id="state_1"><a href="javascript:;">已回复</a></li>
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
								<li id="orderBy_comments"><a href="javascript:;">评论量高到低</a></li>
	                            <li id="orderBy_supports"><a href="javascript:;">点赞量高到低</a></li>
	                            <li id="orderBy_visits"><a href="javascript:;">浏览量高到低</a></li>
							</ul>
						</li>
					</ul>
					<p id="rowCount"  style="float: left; line-height: 52px; color: #cc2510; font-weight: bold; margin-left: 20px;">共${pager.rowCount }条</p>
				</div>

				<div id="search">
					<div class="borbox">
						<input id="searbox" type="text" name="keyWord" value="" placeholder='标题/内容/真实姓名/昵称/电话搜索'  /><input id="searbut" type="button" onclick="search()" />
					</div>
				</div>
			</div>
			
			<div class="column">
	        	<%-- <div class="manbox" style="margin-left:0;">
	            	<a class="nopotr" href="javascript:window.location.href='<%=ctx %>/business/businessHelp/add.do';" style="cursor:pointer;">
	                    <div class="relnews">
                            <img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" />
                        </div>
	                	<span class="tittex">发布社区开聊</span>
	                </a>
	            </div> --%>
            	
	            <c:forEach items="${baseBean.list }" var="help" varStatus="key">
	        		<%-- <div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> > --%>
	        		<div class="manbox" <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if>>
		            	<a class="nopotr" href="javascript:;">
		                    <time><fmt:formatDate value="${help.helpTime}" pattern="yyyy-MM-dd HH:mm"/></time>
		                    <hr class="link">
		                    <h2 class="title_h">
								<span class="poht"><img style="width: 100%;" src="<%=ctx %>${help.portrait}"></span>
								<em style="font-style: normal; line-height: 31px;">${help.helperName }</em><br>
								<strong style="font-weight: normal; font-size: 14px;">${help.estateName }</strong>
							</h2>
		                    <div class="state">
									<c:choose>
										<c:when test="${help.state == 0}">
								              	<span class="relsta cred">未回复</span>
								       </c:when>
										<c:when test="${help.state == 1}">
								              	<span class="relsta cgreen">已回复</span>
								       </c:when>
									</c:choose>
								<div class="other-r">
									<c:choose>
									      <c:when test="${help.state == 1 && help.comments!=0}"> 
									      <i class="revlight"  title="评论量" style="cursor:pointer;" onclick="window.location.href='getHelpCommentList.do?helpId=${help.helpId}' ">${help.comments }</i>
									     </c:when>
									       <c:otherwise>
									              <i class="rev"  title="评论量">${help.comments }</i>
									       </c:otherwise>
									</c:choose>
									<i class="look" title="浏览量">${help.visits }</i>
									<i class="help" title="点赞量">${help.supports }</i>
								</div>
							</div>
							<div class="text2">
		                    	${fn:replace(help.helpContent, '\\r\\n', '<br />')}
		                    </div>
		                    <div style="height:20px;">
		                    	<c:if test="${help.state != 0 && help.comments  > 0}">
			                 		<span class="hf">已回复${help.comments }条 最后时间 <fmt:formatDate value="${help.lastCommentTime }" pattern="yyyy-MM-dd HH:mm"/></span>
		                    	</c:if>
		                    </div>
		                    <hr class="link y-qz-hr">
							<div class="operate">
								<shiro:hasPermission name="help_view_detail">
									<span class="see" id="block5"  title="查看社区开聊详情"  onclick="javascript: window.location.href='getHelpCommentList.do?helpId=${help.helpId }'"></span>
								</shiro:hasPermission>
								<shiro:hasPermission name="help_delete">
									<span id="text1" class="del" title="删除社区开聊" onclick="delHelp('${help.helpId}');"></span>
		                    	</shiro:hasPermission>
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
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					state: $('#state').val(),
					helpType: $('#helpType').val(),
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
    		type: 'post',
            url: '<%=path %>/business/businessHelp/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                var rows = data.rows;
               <%--  if(params.page == 1) {
                	var addHtml = ''
					+ '<div class="manbox" style="margin-left:0;">'
					+ '<a class="nopotr" href="javascript:window.location.href=\'<%=ctx %>/business/businessHelp/add.do\';" style="cursor:pointer;">'
					+ '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div>'
					+ '<span class="tittex">发布社区开聊</span>'
					+ '</a></div>';
					$('.column').append(addHtml);
				} --%>
					if (rows.length > 0) {
						/* var length = 0;
						if(params.page == 1) {
		            		if(rows.length > 5) {length = rows.length - 1;}
		            		else{length = rows.length;}
		            	}else{
		            		length = rows.length;
		            	} */
						for (var i = 0; i < rows.length; i++) {
							var row = rows[i];
							var styleStr = '';
							/* if(params.page == 1 && i % 3 == 2) {
		                		styleStr = 'style="margin-left:0;"';
		   	        		}else if(params.page > 1 && i % 3 == 0) {
		   	        			styleStr = 'style="margin-left:0;"';
		   	        		} */
		   	        		if(i % 3 == 0) {
	                    		styleStr = 'style="margin-left:0;"';
	                    	}
							var isCommtent = '';
	                    	if(row.state  != 0 && row.comments > 0) {
	                    		isCommtent = '<span class="hf">已回复'+row.comments+'条 最后时间'+(row.lastCommentTime != 'null' ? (row.lastCommentTime.substring(0, 16)) : '')+'</span>';
	                    	} 
							var state = '';
							if (row.state == 0) {
								state = '<span class="relsta cred">未回复</span>';
							} else {
								state = '<span class="relsta cgreen">已回复</span>';
							}
							
							var htmlDom = ''
									+'<div class="manbox"' + styleStr + '>'
									+'<a class="nopotr" href="javascript:;">'
									+'<time>'
									+ (row.helpTime != '' ? row.helpTime.substring(0, 16) : '')
									+ '</time>'
									+'<hr class="link">'
									+'<h2 class="title_h">'
									+'<span class="poht"><img style="width: 100%;" src="<%=ctx %>'+row.portrait+'"></span>'
									+'<em style="font-style: normal; line-height: 31px;">'+row.helperName+'</em><br>'
									+'<strong style="font-weight: normal; font-size: 14px;">'+row.estateName+'</strong>'
									+'</h2>'
									+'<div class="state">'
									+ state
									+'<div class="other-r">'
				                	+'<i class="'+((row.state ==1 && row.comments!=0)?'revlight':'rev')+'" '
				                	+' title="评论量" style="'+((row.state ==1 && row.comments!=0)?'cursor:pointer;':'')+'" '
				                	+'onclick="'+((row.state ==1 && row.comments!=0)?'window.location.href=\'getHelpCommentList.do?helpId='+row.helpId+'\' ':'')+'">'+row.comments+'</i>'
									+'<i class="look" title="浏览量">'+row.visits+'</i>'
									+'<i class="help" title="点赞量">'+row.supports+'</i>'
									+'</div>'
									+'</div>'
									+'<div class="text2">'
									+ row.helpContent
									+'</div>'
									+'<div style="height:20px;">'
									+isCommtent
									+'</div>'
									+'<hr class="link y-qz-hr">'
									+'<div class="operate">'
									<shiro:hasPermission name="help_view_detail">
									+'<span class="see" id="block5" title="查看社区开聊详情"  onclick="window.location.href=\'getHelpCommentList.do?helpId='+row.helpId+'\'"></span>'
									</shiro:hasPermission>
									<shiro:hasPermission name="help_delete">
									+'<span id="text1" class="del" title="删除社区开聊" onclick="delHelp('+row.helpId+');"></span>'
									</shiro:hasPermission>
									+'</div>'
									+'</a>'
									+'</div>';
							$('.column').append(htmlDom);
						}
					} else {
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
				error : function() {
					$('.column').html('很抱歉，加载内容出错，我们及时修改问题。');
				}
			});
	}
</script>