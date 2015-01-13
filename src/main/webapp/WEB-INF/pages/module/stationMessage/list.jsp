<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>留言墙管理</title>
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
	                </ul>
	                <p style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:10px;" id="rowCount">共${pager.rowCount}条</p>
	                <a class="scbox-btn" href="#" onclick="jumpUrl()">新增留言墙</a>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value=""  placeholder='留言内容搜索' /><input id="searbut" type="button"  onclick="search()" value="" /></div></div>
	        </div>
	        
	        <div class="review-b">
				<div id="commentDiv">
					<c:forEach items="${baseBean.list}" var="bean" varStatus="status">
						<div id="comment_${bean.commentId }" class="cominfo">
							<a class="cominfobox" href="javascript:;"> 
								<span class="rakin">${status.index+1}</span>
								<div class="textinfo">
									<span class="aut">${bean.commentorName==""?"匿名": bean.commentorName}</span>
									<time>
										<fmt:formatDate value="${bean.commentTime}" pattern="yyyy-MM-dd HH:mm" />
									</time>
									<div class="no-float"></div>
									<p class="text">${bean.content}</p>
								</div>
								<div class="opera">
									<span class="arrow">
										<img src="${ctx}/images/icon/arrow1.png" title="回复该评论"  width="40" height="40" onclick="showReplyForm(${bean.commentId},${status.index+1},${pager.rowCount})" />
									</span> 
									<span class="del1" onclick="deleteComment('${bean.commentId}')">
										<img src="${ctx}/images/icon/dels.png" title="删除该评论" width="22" height="25" />
									</span>
								</div>
							</a>
							<div  id="replyForm_${status.index+1}" class="reply" style="display:none;">
								<input id="replyId_${bean.commentId }" type="hidden" name="replyId"  value="${bean.commentorId}" /> 
								<input id="replyName_${bean.commentId }" type="hidden" name="replyName"  value="${bean.commentorName}" /> 
								<input id="replyState_${bean.commentId }" type="hidden" name="replyState"  value="${bean.replyState}" /> 
								<input id="commentorState_${bean.commentId }" type="hidden" name="commentorState"  value="${bean.commentorState}" /> 
				            	<textarea placeholder="请输入回复内容..." class="reptext" id="content_${bean.commentId}" name="content"></textarea>
				                <hr class="link">
				                <a href="javascript:;" class="cancel" onclick="hiddenReplyForm('${bean.commentId}','${status.index+1}')">取消</a>
				                <input class="subm" type="button" value="提交" onclick="saveComment('${bean.commentId}')"/>
				            </div>
						</div>
					</c:forEach>
				</div>
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
    <div id="msgInfoLayer" class="busswi5 s-xw-bu">
		<div id="msgInfoBar" class="sidebar5 s-xw-si">
			<a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#msgInfoLayer').fadeOut('slow');"></a>
            <h2 class="tit5">留言内容</h2>
			<div id="wrapper-250">
				<ul class="accordion5">
		            <div class="link5"></div>
					<ul class="sub-menu5 s-xw-xx">
		                <li><div class="s-xw-con"><textarea class="iptnewtit" id="content" name="content" style="width:435px;height:200px; font-size:14px; padding-top:5px; padding-left:5px;" placeholder="请输入留言内容" ></textarea></div></li>
	              	</ul>
                </ul>
            </div>
            <div class="s-xw-zd">
	      		<div class="link6"></div>
	          	<div class="submtpres">
	             	<input id="qrbut7" type="button" value="确定" onclick="saveStationMessage()"/>
	            	<input id="zsbut7" type="button" value="取消" onclick="$('#msgInfoLayer').fadeOut('slow');"/>
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
	
	function jumpUrl() {
		if(parseInt('${curEstateId}') == 0) {
			alert("请先切换到小区");return;
		}else{
			$('#msgInfoLayer').fadeIn('slow');
		}
	}
	
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $("input[name='keyWord']").val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
				timeScope: $('#timeScope').val(),
				startTime: $('#startTime').val(),
				endTime: $('#endTime').val()
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
	        url: '<%=path %>/business/businessStationMessage/getPageList.do',
	        dataType: 'json',
	        data: params,
	        cache: false,
	        success: function (data) {
	        	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数 
	            var rows = data.rows;
	            if(rows.length > 0) {
	            	for(var i=0;i<rows.length;i++) {
	                	var row = rows[i];  
	                	var htmlDom = '';
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
	
	function saveStationMessage() {
		if(($('#content').val()).trim() == '') {
			alert("请填写留言内容!");
		} else {
			$('#qrbut7').attr("disabled","disabled");
			$.post('save.do', {content:$('#content').val()}, 
    		function(data) {
    			eval("data = "+data);
    			alert(data.message);
            	window.location.reload();
	        }); 
		}
    }
	
	Date.prototype.format = function(format) {
	    var o = {
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
	
	// 删除留言
	function deleteStationMessage() {
		var bool = window.confirm("您确定要删除该条留言？");
	    if(bool) {
	        $.post("delete.do", function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
</script>