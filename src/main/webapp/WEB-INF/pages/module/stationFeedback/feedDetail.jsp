<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<title>小区投票情况</title>
	<%@include file="/common/meta.jsp"%>
	<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
	<link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
	<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
	
	<style type="text/css">
	    .replayinfo .replaycon {border: 1px solid #e4e4e4;border-radius: 5px;font-size: 12px;margin: 10px 0;padding: 10px;width: 200px;}
		.replaycon h1 {font-size: 12px;font-weight: bold;margin-bottom: 6px;}
		.replaycon p {color:#000;}
		.review .review-b #commentDiv  .cominfo .replayinfo{position:absolute; top:0; left:62%; z-index:49;}
		.review .review-b #commentDiv  .cominfo .reply{ position:static;}
		.review .review-b #commentDiv  .cominfo .cominfobox{height:220px;}
		.review .review-b #commentDiv  .cominfo{ height:220px;}
		.review .review-b  #commentDiv .cominfo .rakin{ height:220px; line-height:220px;}
		.review .review-b  #commentDiv .cominfo .opera .arrow{ margin:42px auto 42px;}
		.review .review-b  #commentDiv .cominfo .opera{ height:220px;}
		#oneul .navlist .erjnav{ position:absolute; z-index:999; top:30px; left:-16px; width:220px; border-radius:5px; overflow:hidden; display:none;}
		.review .review-t .serachbox{ height:40px;}
		.review .review-t .serachbox .scroll-box{float: left;border: 1px solid #dcdcdc;padding: 10px;border-radius: 4px;background-color: #ffffff;}
		.review .review-t .serachbox .scroll-box .donbut i{width: 0;height: 0;border-top: 11px solid #bebebe;border-right: 6px solid transparent;border-left: 6px solid transparent;display: inline-block; float:right; margin-top:6px;}
		.review .review-t .serachbox .bodrbox{float: right; width:300px;}
		.review .review-t .serachbox input#serach{ width:250px;}
		.review .review-t .serachbox .scroll-box .navlist{ position:relative;}
	</style>
	<script type="text/javascript">
		$(function () {
			$(document).keyup(function(event){
				  if(event.keyCode ==13){
				    $("#submt").trigger("click");
				  }
			});
		});
                
        //搜索
        function search() {
        	jump(1,' ${pager.pageSize}');
        }
        
      //获取多参数
    	function getParams() {
    		var keyWord = $("input[name='keyWord']").val();
    		var params = {feedId: '${businessStationFeedback.feedId}', keyWord: keyWord, source: $('#source').val()};
    		return params;
    	}
    	    
        //跳转页面
        function jump(pageNo, pageSize) {
        	var params = getParams();
        	if(pageNo != 0) {
        		params.page = pageNo;
        	}
        	var pagesize = '';
        	if(pageSize == undefined){
        		 pagesize = '${pager.pageSize}';
        	} else {
        		pagesize = pageSize;
        	}
        	$.ajax({
        		type: 'post',
                url: '<%=path %>/business/businessStationFeedbackInformation/list.do',
                dataType: 'json',
                data: params,
                cache: false,
                success: function (data) {
                	$("#rowCount").html("<em>"+data.total+"</em>票");  // 根据查询条件更新总条数
                    var rows = data.rows;
                    if(rows.length > 0) {
                    	$('#review2-b').html('');
                    	for(var i=0;i<rows.length;i++) {
                        	var row = rows[i];  
                        	var push = "";
                        	if(i == 0) {
                        		push += '<div class="tp-message">';
                        		if(data.state == 0) {
                        			push += '<textarea placeholder="请输入通知内容，消息将推送给投票人。" id="pushMessage" name="pushMessage" class="reptext"></textarea>'
                        			+ '<a style="cursor:pointer;" class="green" onclick="pushMessage('+row.feedId+')">一键开通告知</a>';
                        		} else if(data.state == 1) {
                        			push += ' <a class="gray">已通知过</a>';
                        		}
                        		push += '</div>';
                        	}
                        	var source = "";
                        	if(row.source == 0) {
                        		source = "快递代收";
                        	} else if(row.source == 1) {
                        		source = "驿站公告";
                        	} else if(row.source == 2) {
                        		source = "驿站女孩";
                        	} 
                        	var htmlDom = ''
                        		+ '<div class="cominfo">'
                        		+ '<a class="cominfobox tpbox" href="javascript:;">'
                        		+ '<span class="rakin">'+parseInt((pageNo-1)*pagesize +i+1) +'</span>'
                        		+ '<div class="textinfo tpinfo">'
                        		+ '<p>真实姓名：<span>'+row.realName+'</span></p>'
                        		+ '<p>昵   称：<span>'+row.nickName+'</span></p>'
                        		+ '<p>联系电话：<span>'+row.tel+'</span></p>'
                        		+ '<p>投票时间：<time>'+(row.feedTime != null ? row.feedTime.substring(0, 16) : '')+'</time></p>'
                        		+ '</div>'
                        		+ '<p class="red">'
                        		+ source
                        		+ '</p>'
                        		+ '</a>'
                        		+ push
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
                    		liCount = liCount + '<li><a   href="javascript:jump('+pageno+','+data.pageSize+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                    	}else{
                    		liCount = liCount + '<li style="display:none";><a  href="javascript:jump('+pageno+','+data.pageSize+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                    	}
                    	
                    }
                    var boolnext = '';
                    if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next('+data.pageSize+');'; }
                    var boolprev = '';
                    if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev('+data.pageSize+');';  }
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
                	$('#commentDiv').html('很抱歉，加载内容出错，我们及时修改问题。');
                }
            });
        }
        
        function pushMessage(feedId1) {
    	    var pushMessage = $("#pushMessage").val();
    	    if(pushMessage != '') {
    	    	var flag = window.confirm("请慎重选择, 点击确认后将给用户发送系统推送消息！");
    		    if(flag) {
	    	    	$.ajax({
	    	    		type: 'post',
	                    dataType: 'json',
	    	            url: '<%=path %>/business/businessStationFeedback/sendMessage.do',
	    	            cache: false,
	    	            data: {feedId:feedId1, pushMessage:pushMessage},
	    	            success: function (data) {
	                        alert(data.message);
	                        window.location.href = '${ctx}/business/businessStationFeedback/getFeedDetail.do?feedId='+feedId1;
	    	            },
	    	            error: function() {
	    	            	alert("传递参数错误！");
	    	            }
	    	        });
    		    }
    	    } else {
    	    	alert("请输入通知内容，消息将推送给投票人。");
    	    }
    	}
        
      	//上一页
        function prev(pageSize) {
        	var currNo = $('#curr').first().text();
        	var prevNo = parseInt(currNo) - 1;
        	if(prevNo <= 0) {
        		prevNo = 1;
        	}
        	jump(prevNo, pageSize);
        }
        
        //下一页
        function next(pageSize) {
        	var currNo = $('#curr').first().text();
        	var nextNo = parseInt(currNo) + 1;
        	var pageCount = $('#pageCount').val();
        	if(nextNo > pageCount) {
        		nextNo = pageCount;
        	}
        	jump(nextNo, pageSize);
        }
    </script>
</head>

<body style="background: #fff;">
	<div class="wrapper" style="overflow:visible;">
		<div class="header-public">
			<span style="cursor: pointer;" class="return" onclick="history.go(-1)"></span>小区投票情况
		</div>
		<div class="review" style="top:57px;  position:relative;">
	        <div class="review-t">
	        	<h2 class="tiele">${businessStationFeedback.estateName}</h2>
	            <div class="serachbox">
					<div class="scroll-box" style="width:100px;">
		                <ul id="oneul">
		                    <li id="source_" class="navlist"><a href="javascript:;"><span style="color:#000000; padding-right:10px;">全部功能</span><b class="donbut"><i></i></b></a>
		                    	<input type="hidden" name="source" id="source" value="" />
		                    	<ul class="erjnav">
		                           <li id="source_0"><a href="javascript:;">快递代收</a></li>
		                           <li id="source_1"><a href="javascript:;">驿站公告</a></li>
		                           <li id="source_2"><a href="javascript:;">驿站女孩</a></li>
		                        </ul>
		                    </li>
		                </ul>
		            </div>
		            <span id="rowCount" style="color:rgb(51, 51, 51); display:inline-block;font-size: 18px;height:30px; line-height:30px; margin-top:6px; text-align:center; width:100px; "><em>${pager.rowCount}</em>票</span>
					<div class="bodrbox">
						<input id="serach" type="text" name="keyWord" placeholder="请输入搜索关键字" value="" /> 
						<input id="submt" type="button" name="" onclick="search()" value="" />
						<input type="hidden" name="state" id="state" value="${businessStationFeedback.state}" />
						<input type="hidden" name="flagNew" id="flagNew" value="${flagNew}" />
						<input type="hidden" name="sbFlagNew" id="sbFlagNew" value="${sbFlagNew}" />
					</div>
				</div>
	        </div>
	        
	        <div id="review2-b" class="review-b">
	        	<c:forEach items="${baseBean.list}" var="bean" varStatus="status">
	        		<div class="cominfo">
		                <a class="cominfobox tpbox" href="javascript:;">
		                    <span class="rakin">${status.index+1}</span>
		                    <div class="textinfo tpinfo">
		                        <p>真实姓名：<span>${bean.realName}</span></p>
		                        <p>昵   称：<span>${bean.nickName}</span></p>
		                        <p>联系电话：<span>${bean.tel}</span></p>
		                        <p>投票时间：<time><fmt:formatDate value="${bean.feedTime}" pattern="yyyy-MM-dd HH:mm" /></time></p>
		                    </div>
		                    <p class="red">
								<c:choose>
									<c:when test="${bean.source==0}">快递代收</c:when>
									<c:when test="${bean.source==1}">驿站公告</c:when>
									<c:when test="${bean.source==2}">驿站女孩</c:when>
								</c:choose>
							</p>
		            	</a>
		            	<c:if test="${status.index == 0}">
		            		<div class="tp-message">
		            			<c:if test="${businessStationFeedback.state == 0}">
				                    <textarea placeholder="请输入通知内容，消息将推送给投票人。" id="pushMessage" name="pushMessage" class="reptext"></textarea>
				                    <a style="cursor:pointer;" class="green" onclick="pushMessage('${bean.feedId}')">一键开通告知</a>
			                    </c:if>
			                    <c:if test="${businessStationFeedback.state == 1}">
			                    	<a class="gray">已通知过</a>
			                    </c:if>
				                <input type="hidden" name="sbFlagNew" id="sbFlagNew" value="${sbFlagNew}" />
			                </div>
		            	</c:if>
		            </div>
	        	</c:forEach>
	        </div>
			
			<div class="no-float"></div>
			<div class="page">
				<div class="pagec">
	            	<input type="hidden" id="pageCount" value="${pager.pageCount}" />
	                <ul id="pageUl">
	                	<li><a id="arrow-l" class="arrow" href="javascript:prev(${pager.pageSize});" <c:if test="${pager.pageId <= 1 }"> disabled </c:if> ></a></li>
	                	<c:forEach items="${pager.indexs }" var="pageNo">
	                		<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo },${pager.pageSize});"><span id="page_${pageNo }">${pageNo }</span></a></li>
	                	</c:forEach>
	                	<li><a id="arrow-r" class="arrow" href="javascript:next(${pager.pageSize});" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if> ></a></li>
	                </ul>
	        	</div>
	        </div>
		</div>
	</div>
</body>
</html>