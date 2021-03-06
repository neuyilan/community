<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>健康饮食</title>
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
	                	<li id="publishState_" class="active navlist"><a href="javascript:;"><span>全部健康饮食</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="publishState" id="publishState" value="" />
	                    	<ul class="erjnav">
	                            <li id="publishState_0"><a href="javascript:;">已发布</a></li>
	                            <li id="publishState_1"><a href="javascript:;">未发布</a></li>
	                            <li id="publishState_2"><a href="javascript:;">待审核</a></li>
	                            <li id="publishState_3"><a href="javascript:;">未通过</a></li>
	                            <li id="publishState_4"><a href="javascript:;">已通过</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="timeScope_" class="navlist"><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a>
                    		<input type="hidden" name="timeScope" id="timeScope" value="" />
                    		<input type="hidden" name="dateField" id="dateField" value="" />
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
	                 <p style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;" id="rowCount">共${pager.rowCount }条</p>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='标题/内容/发布人搜索' /><input id="searbut" type="button"  onclick="search()" value="" /></div></div>
	        </div>
	        
	        <div class="column">
	        	<shiro:hasPermission name="diet_publish">
	        	<div class="manbox" style="margin-left:0;">
	            	<a class="nopotr" href="javascript:window.location.href='<%=ctx %>/business/businessHealthydiet/add.do';" style="cursor:pointer;">
	                    <div class="relnews">
                            <img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" />
                        </div>
	                	<span class="tittex">发布健康饮食</span>
	                </a>
	            </div>
            	</shiro:hasPermission>
            	
	            <c:forEach items="${baseBean.list }" var="diet" varStatus="key">
	        			<shiro:lacksPermission name="diet_publish">
	        				<div class="manbox" <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if> >
	        			</shiro:lacksPermission>
	        			<shiro:hasPermission name="diet_publish">
	        				<div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> >
	        			</shiro:hasPermission>
		            	
		            	<a class="nopotr" href="javascript:;">
		                    <div class="info"></div>
		                    <time><fmt:formatDate value="${diet.publishTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    
		                    <hr class="link">
		                    <h2 class="title">${diet.healTitle }</h2>
		                    
		                    <div class="state">
		                    	<span class="relsta">
									<c:if test="${diet.publishState == 0 }"><span class="relsta cgreen">已发布</span></c:if>
									<c:if test="${diet.publishState == 1 }"><span class="relsta cgray">未发布</span></c:if>
									<c:if test="${diet.publishState == 2 }"><span class="relsta cyellow">待审核</span></c:if>
									<c:if test="${diet.publishState == 3 }"><span class="relsta cred">未通过</span></c:if>
									<c:if test="${diet.publishState == 4 }"><span class="relsta cblue">已通过</span></c:if>
								</span>
								<div class="other-r">
									<c:choose>
									       <c:when test="${diet.publishState == 0 && diet.comments!=0}">
									            <i class="revlight"  title="评论量" style="cursor:pointer;" onclick="window.location.href='getNewsCommentList.do?healId=${diet.healId}' ">${diet.comments }</i>
									       </c:when>
									       <c:otherwise>
									              <i class="rev" title="评论量">${diet.comments }</i>
									       </c:otherwise>
									</c:choose>
									<i class="look" title="浏览量">${diet.visits }</i>
									<i class="help" id="block6" title="点赞量">${diet.supports }</i>
								</div>
							</div>
		                    <div class="text">${diet.brief}</div>
		                    <hr class="link">
		                    <div class="operate">
		                    	<shiro:hasPermission name="diet_view_detail">
		                    	<span class="see s-xw-yfb" title="查看健康饮食详情" onclick="checkNewsDetail('${diet.healId}');"></span>
		                    	</shiro:hasPermission>
		                    	<shiro:hasPermission name="diet_edit">
		                    	<c:if test="${diet.publishState != 0 }">
									<span class="edit"  title="编辑健康饮食"  onclick="window.location.href='modify.do?healId=${diet.healId}' "></span>
								</c:if>
		                    	</shiro:hasPermission>
								<shiro:hasPermission name="diet_delete">
		                    	<span id="text1" class="del"  title="删除健康饮食"  onclick="deleteNews('${diet.healId}')"></span>
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
	
	<div id="newsInfoLayer" class="busswi5 s-xw-bu">
        <div id="newsInfoBar" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#newsInfoLayer').fadeOut('slow');"></a>
            <h2 class="tit5">健康饮食信息<em>【<span id="showstate"></span>】</em></h2>
            <div id="wrapper-250">
                <ul class="accordion5">
                    <li id="one5" class="files"><a href="#one"><lable id="title" style="color: #333;"></lable></a></li>
                    <div class="link5"></div>
                    <ul class="sub-menu5 s-xw-xx">
		                <li><span class="xxl">发布人：<lable id="publisherName"></lable></span><span class="xxr">发布时间：<lable id="publishTime"></lable></span></li>
		                <li><span class="xxl">审核人：<lable id="auditorName"></lable></span><span class="xxr">审核时间：<lable id="auditTime"></lable></span></li>
		                 <div class="s-xw-ic"><i class="rev"><lable id="comments"></lable></i><i class="look"><lable id="visits"></lable></i><i id="block6" class="help"><lable id="supports"></lable></i></div>
		                <div class="link5"></div>
		                 <li id="auditInfo1" style="color: #cc2510; margin:17px 0 10px 0; display:none;"><lable id="auditInfo2"></lable></li>
		                <div id="hr1" class="link5" style="display:none;"></div>
		                <li id="viewInter"></li>
		              	<div class="link5"></div>
		                <li><div class="s-xw-con"><lable id="content"></lable></div></li>
	              	</ul>
                </ul>
            </div>
            <div class="s-xw-zd">
         			<div class="link6"></div>
            		<div class="submtpres">
                		<lable id="ding"></lable>
            		</div>
        		</div>
        </div>
    </div>
    
    <div id="newsInfoLayer1" class="busswi5 s-xw-bu">
        <div id="newsInfoBar1" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#newsInfoLayer1').fadeOut('slow');"></a>
            <h2 class="tit5">健康饮食内容<em>【<span id="showstate2"></span>】</em></h2>
            <div id="wrapper-250">
                <ul class="accordion5">
                    <li id="one5" class="files"><a href="#one"><lable id="title2" style="color: #333;"></lable></a></li>
                    <div class="link5"></div>
                    <ul class="sub-menu5 s-xw-xx">
		                <li><span class="xxl">发布人：<lable id="publisherName2"></lable></span><span class="xxr">发布时间：<lable id="publishTime2"></lable></span></li>
		                <div class="link5"></div>
		                <li><div class="s-xw-con"><lable id="newsId2"></lable><textarea class="iptnewtit" id="auditInfo" name="auditInfo" style="width:435px;height:200px; font-size:14px; padding-top:5px; padding-left:5px;" placeholder="请输入拒绝原因，发送至提交人" ></textarea></div></li>
	              	</ul>
                </ul>
            </div>
            <div class="s-xw-zd">
	      		<div class="link6"></div>
	          	<div class="submtpres">
	                  <input id="qrbut7" type="button"  value="确定" onclick="updateNewsState()"/>
	                  <input id="zsbut7" type="button"  value="取消" onclick="$('#newsInfoLayer1').fadeOut('slow');"/>
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
	        url: '<%=path %>/business/businessHealthydiet/getPageList.do',
	        dataType: 'json',
	        data: params,
	        cache: false,
	        success: function (data) {
	        	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
	        	
	            var rows = data.rows;
	            <shiro:hasPermission name="diet_publish">
	            if(params.page == 1) {
	            	var addHtml = ''
	                + '<div class="manbox" style="margin-left:0;">'
	                + '<a class="nopotr" href="javascript:window.location.href=\'<%=ctx %>/business/businessHealthydiet/add.do\';" style="cursor:pointer;">'
	                + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div> '
	                + '<span class="tittex">发布健康饮食</span>'              
	                + '</a>'
	                + '</div>';
	            	$('.column').append(addHtml);
	            }
	            </shiro:hasPermission>
	            if(rows.length > 0) {
	            	for(var i=0;i<rows.length;i++) {
	                	var row = rows[i];  
	                	var styleStr = '';
	                	<shiro:lacksPermission name="diet_publish">
                    	if(params.page == 1 && i % 3 == 0) {
	   	        			styleStr = 'style="margin-left:0;"';
	   	        		}
                    	</shiro:lacksPermission>
                    	<shiro:hasPermission name="diet_publish">
                    	if(params.page == 1 && i % 3 == 2) {
	                		styleStr = 'style="margin-left:0;"';
	   	        		}
                    	</shiro:hasPermission>
       	        		if(params.page > 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
	                	var state = '';
	                	if(row.publishState == 0) {
	                		state = '<span class="relsta cgreen">已发布</span>';
			            }else if(row.publishState == 1) {
			            	state = '<span class="relsta cgray">未发布</span>';
			            }else if(row.publishState == 2) {
			            	state = '<span class="relsta cyellow">待审核</span>';
			            }else if(row.publishState == 3) {
			            	state = '<span class="relsta cred">未通过</span>';
			            }else if(row.publishState == 4) {
			            	state = '<span class="relsta cblue">已通过</span>';
			            }
	                	
	                	var edit = '';
	                	if(row.publishState != 0){
	                		edit = '<span class="edit" title="编辑健康饮食" onclick="window.location.href=\'modify.do?healId='+row.healId+'\' "></span>';
	                	}
	                	var htmlDom = ''
	              		+ '<div class="manbox"'
	    	        	+ styleStr
	    	        	+ '>'
	    	        	+ '<a class="nopotr" href="javascript:;">'
	                	+ '<div class="info"></div>'
	                	+ '<time>'+(row.publishTime != '' ? row.publishTime.substring(0, 16) : '')+'</time>'
	                	+ '<hr class="link">'
	                	+ '<h2 class="title">'+row.healTitle+'</h2>'
	                	+ '<div class="state">'+state+'<div class="other-r">'
	                	+'<i class="'+((row.publishState ==0 && row.comments!=0)?'revlight':'rev')+'" '
	                	+ 'title="评论量"  style="'+((row.publishState ==0 && row.comments!=0)?'cursor:pointer;':'')+'" '
	                	+'onclick="'+((row.publishState ==0 && row.comments!=0)?'window.location.href=\'getNewsCommentList.do?healId='+row.healId+'\' ':'')+'">'+row.comments+'</i><i class="look" title="浏览量">'+row.visits+'</i><i class="help" id="block6" title="点赞量">'+row.supports+'</i></div></div>'
	                	+ '<div class="text">'+row.brief +'</div>'
	                	+ '<hr class="link">'
	                	+ '<div class="operate">'
	                	<shiro:hasPermission name="diet_view_detail">
			            + '<span class="see s-xw-yfb"  title="查看健康饮食详情" onclick="checkNewsDetail('+row.healId+');"></span>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="diet_edit">
			            + edit
			            </shiro:hasPermission>
			            <shiro:hasPermission name="diet_delete">
			            + '<span id="text1" class="del"  title="删除健康饮食" onclick="deleteNews('+row.healId+')"></span>'
			            </shiro:hasPermission>
			            + '</div>'
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
	
	//删除健康饮食
	function deleteNews(healId) {
		var bool = window.confirm("您确定要删除该条健康饮食？");
	    if(bool) {
	        $.post("delete.do", {id : healId}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
	
	// 撤回发布该条健康饮食
	function cancelNewsPublishState(healId) {
		var bool = window.confirm("您确定撤回发布该条健康饮食？");
	    if(bool) {
	        $.post("cancelNewsPublishState.do", {id : healId}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
	
	// 立即发布该条健康饮食
	function cnChangeNewsState(healId) {
		var bool = window.confirm("您确定立即发布该条健康饮食？");
	    if(bool) {
	        $.post("updateNewsState.do", {id : healId, auditInfo : ''}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
	
	// 通过审核该条健康饮食
	function auditPassNewsState(healId) {
		var bool = window.confirm("您确定该条健康饮食通过审核？");
	    if(bool) {
	        $.post("updateNewsStatePassNews.do", {id : healId}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
	
	// 拒绝该条健康饮食
	function jjChangeNewsState(healId) {
		$('#newsInfoLayer1').fadeIn("slow");
        
        $.post("getNewsDetail.do", {healId : healId}, function(data) {
        	eval("data = "+data);
            $('#title2').html(data.healTitle);	//健康饮食标题
            $('#publisherName2').html(data.publisherName);	//发布人
            $('#publishTime2').html(new Date(data.publishTime.time).format('yyyy-MM-dd hh:mm'));	//发布日期
        	$('#newsId2').html("<input type=\"hidden\" id=\"healId\" value='"+data.healId+"'/>");
            //发布状态
            if(data.publishState == 0 ) {
            	$('#showstate2').html("已发布");
            } else if(data.publishState == 1 ) {
            	$('#showstate2').html("未发布");
            } else if(data.publishState == 2 ) {
            	$('#showstate2').html("待审核");
            }else if(data.publishState == 3 ) {
            	$('#showstate2').html("未通过");
            }
         });
	}
	
	Date.prototype.format = function(format)
	{
	    var o =
	    {
	        "M+" : this.getMonth()+1, //month
	        "d+" : this.getDate(),    //day
	        "h+" : this.getHours(),   //hour
	        "m+" : this.getMinutes(), //minute
	        "s+" : this.getSeconds(), //second
	        "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
	        "S" : this.getMilliseconds() //millisecond
	    }
	    if(/(y+)/.test(format))
	    format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
	    for(var k in o)
	    if(new RegExp("("+ k +")").test(format))
	    format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
	    return format;
	}
	
	function updateNewsState() {
		if(($('#auditInfo').val()).trim() == '') {
			alert("请填写拒绝原因!");
		} else {
			var bool = window.confirm("您确定拒绝该条健康饮食？");
		    if(bool) {
				$.post('updateNewsState.do', {
		    		id : $('#healId').val(),
		    		auditInfo : $('#auditInfo').val()
		    		}, 
		    		function(data) {
		    			eval("data = "+data);
		    			alert(data.message);
		            	window.location.reload();
		        }); 
		    } 
		}
    }
	
	 function checkNewsDetail(healId) {
		  	$('#newsInfoLayer').fadeIn("slow");
	        $.post("getNewsDetail.do", {healId : healId}, function(data) {
	        	eval("data = "+data);
	            $('#title').html(data.healTitle);	//健康饮食标题
	            $('#content').html(data.healContent);	//健康饮食内容
	            $('#publisherName').html(data.publisherName);	//发布人
	            $('#publishTime').html(new Date(data.publishTime.time).format('yyyy-MM-dd hh:mm'));	//发布日期
	            $('#auditorName').html(data.auditorName);	//审批人
	            $('#auditTime').html(data.auditTime== null?'':new Date(data.auditTime.time).format('yyyy-MM-dd hh:mm'));	//审批日期
	            $('#comments').html(data.comments);	//评论量
	            $('#visits').html(data.visits);	//浏览量
	            $('#supports').html(data.supports);	//支持量
	            $('#auditInfo2').html("批注：" +data.auditInfo);	//审批原因
	            $('#viewInter').html("预览地址：<%=ctx %>/service/healthydiet/<br>getDetailsById.json?ID="+data.healId+"&userId=0" );
	            //发布状态
	            if(data.publishState == 0 ) {
	            	$('#showstate').html("已发布");
	            	$('#ding').html("");
	            	<shiro:hasPermission name="diet_withdrawn">
	            	$('#ding').html("<input class=\"s-xw-btn1\" title=\" 撤回发布该条健康饮食\" type=\"button\" value=\"撤回发布\" onclick=\"cancelNewsPublishState("+data.healId+");\"/>");
	            	</shiro:hasPermission>
	            	$("#auditInfo1").css('display','none'); 
			         $("#hr1").css('display','none'); 
	            } else if(data.publishState == 1 ) {
	            	$('#showstate').html("未发布");
	            	// $('#ding').html("<input class=\"s-xw-btn2\" title=\"置顶该条健康饮食\" type=\"button\" value=\"设置为置顶\" />");
	            	$('#ding').html("");
	            	<shiro:hasPermission name="diet_edit">
	            	$('#ding').html("<input class=\"s-xw-btn1\" title=\"编辑健康饮食\" type=\"button\" value=\"编辑\" onclick=\"window.location.href='modify.do?healId="+data.healId+"' \"/>");
	            	</shiro:hasPermission>
	            	$("#auditInfo1").css('display','none'); 
			         $("#hr1").css('display','none'); 
	            } else if(data.publishState == 2 ) {
	            	$('#showstate').html("待审核");
	            	$('#ding').html("");
	            	<shiro:hasPermission name="diet_audit">
	            	$('#ding').html("<input id=\"qrbut5\" title=\"审核通过该条健康饮食\" type=\"submit\" value=\"审核通过\" onclick=\"auditPassNewsState("+data.healId+");\"/><input id=\"zsbut5\" title=\"拒绝该条健康饮食\" type=\"button\" value=\"拒绝\" onclick=\"jjChangeNewsState("+data.healId+");\"/>");
	            	</shiro:hasPermission>
	            	$("#auditInfo1").css('display','none'); 
			        $("#hr1").css('display','none'); 
	            } else if(data.publishState == 3 ) {
	            	$('#showstate').html("未通过");
	            	$('#ding').html("");
	            	<shiro:hasPermission name="diet_edit">
	            	$('#ding').html("<input class=\"s-xw-btn1\" title=\"编辑健康饮食\" type=\"button\" value=\"编辑\" onclick=\"window.location.href='modify.do?healId="+data.healId+"' \"/>");
	            	</shiro:hasPermission>
	            	$("#auditInfo1").css('display','block'); 
			         $("#hr1").css('display','block'); 
	            } else if(data.publishState == 4 ) {
	            	$('#showstate').html("已通过");
	            	$('#ding').html("");
	            	<shiro:hasPermission name="diet_instant_publish">
	            	$('#ding').html("<input class=\"s-xw-btn1\" title=\"立即发布该条健康饮食\" type=\"submit\" value=\"立即发布\" onclick=\"cnChangeNewsState("+data.healId+");\"/>");
	            	$("#auditInfo1").css('display','none'); 
			        $("#hr1").css('display','none'); 
			        </shiro:hasPermission>
	            }
	        });
	    }
	 
	// 获取多参数
	function getParams() {
		var params = '';
		var keyWord = $("input[name='keyWord']").val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					publishState: $('#publishState').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime: $('#endTime').val(),
					orderBy: $('#orderBy').val()
			};
		}
		return params;
	}     
</script>