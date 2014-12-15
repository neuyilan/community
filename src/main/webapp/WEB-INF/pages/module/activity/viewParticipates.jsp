<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<title>活动参与详情</title>
<style type="text/css">
       .replayinfo .replaycon {
		    border: 1px solid #e4e4e4;
		    border-radius: 5px;
		    font-size: 12px;
		    margin: 10px 0;
		    padding: 10px;
		    width: 200px;
		}
		
		.replaycon h1 {
		    font-size: 12px;
		    font-weight: bold;
		    margin-bottom: 6px;
		}
		
		.replaycon p {
		    color:#000;
		}
		
		
		.review .review-b #commentDiv  .cominfo .replayinfo{position:absolute; top:0; left:62%; z-index:49;}
		.review .review-b #commentDiv  .cominfo .reply{ position:static;}
		.review .review-b #commentDiv  .cominfo .cominfobox{height:124px;}
		.review .review-b #commentDiv  .cominfo{ height:124px;}
		.review .review-b  #commentDiv .cominfo .rakin{ height:124px; line-height:124px;}
		.review .review-b  #commentDiv .cominfo .opera .arrow{ margin:42px auto 42px;}
		.review .review-b  #commentDiv .cominfo .opera{ height:124px;}
</style>

<%@include file="/common/meta.jsp"%>
<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
<script type="text/javascript">
		$(function () {
			$(document).keyup(function(event){
				  if(event.keyCode ==13){
				    $("#subm").trigger("click");
				  }
			});
		});

        function submitForm(id) {
            $('#'+id).form('submit', {
                success:function(data){
                    alert(data.message);
                    location.reload();
                }
            });
        }
        
        function showReplyForm(memberId, userId, index, pageCount) {
        	for(var i=1; i<=pageCount; i ++) {
        		if(i==index){
        			$.ajax({
                		type: 'post',
                        url: '<%=path %>/business/businessActivityParticipate/getActivityNewsPageList.do',
                        dataType: 'json',
                        data: {userId: userId, id: memberId},
                        cache: false,
                        success: function (data) {
                            var rows = data.rows;
                            if(rows.length > 0) {
                            	$('#replaycon_' + index).html('');
                            	for(var j=0;j<rows.length;j++) {
                                	var row = rows[j];  
                                	var htmlDom = ''
                                		+ '<div class="replaycon">'
                                		+ '<h1><time>'+ (row.createTime != null ? row.createTime.substring(0, 16) : '')+ '</time></h1>'
                                		+ '<p style="color: rgb(0, 0, 0);">'+row.content+'</p>'
        							  	+ '</div>';
                                	$('#replaycon_' + index).append(htmlDom);
                                }
                            }else{
                            	var htmlDom = ''
                            		+ '<div class="replaycon">'
                            		+ '<h1></h1>'
                            		+ '<p style="color: rgb(0, 0, 0);">没有发送通知消息！</p>'
    							  	+ '</div>';
                            	$('#replaycon_' + index).html(htmlDom);
                            }
                        },
                        error: function () {
                        	var htmlDom = ''
                        		+ '<div class="replaycon">'
                        		+ '<h1></h1>'
                        		+ '<p style="color: rgb(0, 0, 0);">很抱歉，加载内容出错！</p>'
							  	+ '</div>';
                        	$('#replaycon_' + index).html(htmlDom);
                        }
                    });
        			
                	$('#replyForm_'+i+' .reply').css("display","block");
                	$('#replyForm_'+i).css("display","block");
        		} else {
        			$('#replyForm_'+i).css("display","none");
        			$('#replyForm_'+i+' .reply').css("display","none");
        			$("textarea[name='content']").val("");
        		}
        	}
        }
        
        function hiddenReplyForm(commentId, index) {
        	$('#replyForm_'+index).toggle('slow');
        	$('#content_'+commentId).val("");
        }
        
        function saveComment(userId, memberId) {
        	var content = $('#content_'+memberId).val();
        	if(content == '') {
        		alert('请输入消息内容');
        	}else{
               	$('.subm').attr("disabled","disabled");
        		$.ajax({
        	      	  url: '${ctx}/business/businessActivityParticipate/saveActivityNews.do',
        	      	  type: 'post',
        	      	  dataType: 'json',
        	      	  data: {userId: userId,
              			memberId: memberId,
                		content: content
                		},
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
                
        //搜索
        function search() {
        	jump(1,' ${pager.pageSize}');
        }
        
      //获取多参数
    	function getParams() {
    		var keyWord = $("input[name='keyWord']").val();
    		var params = {actId: '${businessActivity.actId}', keyWord: keyWord};
    		return params;
    	}
    	    
        //跳转页面
        function jump(pageNo, pageSize) {
        	var params = getParams();
        	if(pageNo != 0) {
        		params.page = pageNo;
        	}
        	$.ajax({
        		type: 'post',
                url: '<%=path %>/business/businessActivityParticipate/getPageList.do',
                dataType: 'json',
                data: params,
                cache: false,
                success: function (data) {

                	//$("#rowCount").html("共计有" + data.total + "个参与人");  // 根据查询条件更新总条数
                    var rows = data.rows;
                    if(rows.length > 0) {
                    	$('#commentDiv').html('');
                    	for(var i=0;i<rows.length;i++) {
                        	var row = rows[i];  
                        	var htmlDom = ''
                        		+ '<div id="comment_'+row.memberId+'" class="cominfo">'
                        		+ '<a class="cominfobox" href="javascript:;">' 
                        		+ '<span class="rakin">'+row.rank+'</span>'
                        		+ '<div class="textinfo">'
                        		+ '<p>'
                        		+ '<span class="aut">姓名：'+row.realname+'</span>'
                        		+ '<time>参与时间：'
                        		+ (row.joinTime != null ? row.joinTime.substring(0, 16) : '')
                        		+ '</time>'
                        		+ '<span style="float:right;">'+(row.isnotice == 1 ?'【已通知】' : '')+'</span>'
                        		+ '</p>'
                        		+ '<div class="no-float"></div>'
                        		+ '<p class="text">'
                        		+ '昵称：'+row.nickname+'<br />'
                        		+ '电话：'+row.tel+'<br />'
                        		+ '地址：'+row.estateName+row.buildingName+row.unitName+row.houseNo+'</p>'
                        		+ '</div>'
                        		+ '<div class="opera">'
                        		+ '<span class="arrow">'
                        		+ '<img src="${ctx}/images/icon/arrow1.png" title="回复该参与人通知" width="40" height="40" onclick="showReplyForm('+row.memberId+','+row.userId+','+parseInt((pageNo-1)*pageSize +i+1)+','+data.total+')" />'
                        		+ '</span>'
                        		+ '</div>'
                        		+ '</a>'
					            + '<div  id="replyForm_'+parseInt((pageNo-1)*pageSize +i+1)+'" class="replayinfo"  style="display:none;">'
                        		+ '<div  class="reply">'
                        		+ '<input id="memberId_'+row.memberId +'" type="hidden" name="memberId"  value="'+row.memberId+'" />'  
                        		+ '<textarea placeholder="请输入回复内容..." class="reptext" id="content_'+row.memberId+'" name="content"></textarea>'
                        		+ '<hr class="link">'
                        		+ '<a href="javascript:;" class="cancel" onclick="hiddenReplyForm('+row.memberId+','+parseInt((pageNo-1)*pageSize +i+1)+')">取消</a>'
                        		+ '<input class="subm" type="button" value="提交" onclick="saveComment('+row.userId+', '+row.memberId+')"/>'
                        		+ '</div>'
                        		/* + '<div class="replaycon">'
                        		+ '<h1>2014-10-29 10:27</h1>'
                        		+ '<p style="color: rgb(0, 0, 0);">发送内容，发送内容，发送内容，发送内容发送内容，发送内容，发送内容，发送内容</p>'
							  	+ '</div>' */
							  	+'<label id="replaycon'+parseInt((pageNo-1)*pageSize +i+1)+'"></label>'
                        		+ '</div>'
                        		+ '</div>';
                        	$('#commentDiv').append(htmlDom);
                        }
                    }else{
                    	$('#commentDiv').html('很抱歉，没有相关记录。');
                    }
                    $('#commentDiv').append('<div class="no-float"></div>');
                    
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
			<span style="cursor: pointer;" class="return" onclick="history.go(-1)"></span>活动参与人
		</div>
		<div class="review" style="top:57px;  position:relative;">
			<div class="review-t">
				<h2 class="tiele">${businessActivity.actName}</h2>
				<%-- <div class="newsinfo">
				<span>共计有${baseBean.pager.rowCount} 人参与活动</span> 				   
				</div> --%>
				<div class="serachbox">
					<div class="bodrbox">
						<input id="serach" type="text" name="keyWord" placeholder="输入用户绑定的手机号查找" value="" /> 
						<input id="submt" type="button" name="" onclick="search()" value="" />
					</div>
				</div>
			</div>
			<input id="annoId" type="hidden" name="actId"  value="${businessActivity.actId}" />
			<div class="review-b">
				<h2  id="rowCount"  class="comnum">共计有${baseBean.pager.rowCount}个参与人</h2>
				<div id="commentDiv">
					<c:forEach items="${baseBean.list}" var="bean" varStatus="status">
						<div id="comment_${bean.memberId }" class="cominfo">
							<a class="cominfobox" href="javascript:;"> 
								<span class="rakin">${bean.rank}</span>
								<div class="textinfo">
									<p>
									<span class="aut">姓名：${bean.realname}</span>
									
									<time>参与时间：
										<fmt:formatDate value="${bean.joinTime }" pattern="yyyy-MM-dd HH:mm:ss" />
									</time>
									<span style="float:right;"><c:if test="${bean.isnotice == 1}">【已通知】</c:if></span>
									</p>
									<div class="no-float"></div>
									<p class="text">
										昵称：${bean.nickname}<br />
										电话：${bean.tel}<br />
										小区：${bean.estateName}<br />
										地址：${bean.estateName}${bean.buildingName}${bean.unitName}${bean.houseNo}</p>
								</div>
								<div class="opera">
									<span class="arrow">
										<img src="${ctx}/images/icon/arrow1.png" title="回复该参与人通知"  width="40" height="40" onclick="showReplyForm(${bean.memberId},${bean.userId},${status.index+1},${pager.rowCount})" />
									</span>
								</div>
							</a>
							<div  id="replyForm_${status.index+1}" class="replayinfo"  style="display:none;">
								<div class="reply">
									<input id="memberId_${bean.memberId }" type="hidden" name="memberId"  value="${bean.memberId}" />  
					            	<textarea placeholder="请输入回复内容..." class="reptext" id="content_${bean.memberId}" name="content"></textarea>
					                <hr class="link">
					                <a href="javascript:;" class="cancel" onclick="hiddenReplyForm('${bean.memberId}','${status.index+1}')">取消</a>
					                <input class="subm" type="button" value="提交" onclick="saveComment(${bean.userId}, ${bean.memberId})"/>
					            </div>
					           <!--  <div class="replaycon">
								  	<h1 id="replyTime">2014-10-29 10:27</h1>
								  	<p id="replyContent" style="color: rgb(0, 0, 0);">发送内容，发送内容，发送内容，发送内容发送内容，发送内容，发送内容，发送内容</p>
								</div> -->
								<label id="replaycon_${status.index+1}"></label>
				            </div>
						</div>
					</c:forEach>
				</div>
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