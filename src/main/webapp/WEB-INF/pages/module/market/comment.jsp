<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/15
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<title>评论详情</title>
<%@include file="/common/meta.jsp"%>
<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js"
	type="text/javascript"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
		$(function () {
		    $(document).keyup(function(event){
				  if(event.keyCode ==13){
					  $("#submt").trigger("click");
				  }
			});
		});
		
        //删除评论
        function deleteComment(commentId, productId) {
        	var bool = window.confirm("您确定要删除该条评论吗？");
    	    if(bool) {
    	    	$.post('${ctx}/business/businessProductComment/delete.do', {id :commentId, productId:productId }, function(data) {
    	    		 var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                     alert(data.message);
                    window.location.reload();
    	        });
    	    }
        }
        	    
        function submitForm(id) {
            $('#'+id).form('submit', {
                success:function(data){
                    location.reload();
                }
            });
        }
        
        function showReplyForm(commentId, index, pageCount) {
        	for(var i=1; i<=pageCount; i ++) {
        		if(i==index){
                	$('#replyForm_'+i).show();
        		} else {
        			$('#replyForm_'+i).hide();
        			$("textarea[name='content']").val("");
        		}
        	}
        }
        
        function hiddenReplyForm(commentId, index) {
        	$('#replyForm_'+index).toggle('slow');
        	$('#content_'+commentId).val("");
        }
        
        function saveComment(commentId) {
        	var content = $('#content_'+commentId).val();
        	if(content == ''){
        		alert("请输入回复内容!");
        	} else {
               	$('.subm').attr("disabled","disabled");
            	$.post('${ctx}/business/businessProductComment/replySave.do', {
            		productId: $('#productId_'+commentId).val(),
            		replyId: $('#replyId_'+commentId).val(),
            		replyState: $('#replyState_'+commentId).val(),
            		replyName: $('#replyName_'+commentId).val(),
            		commentorState: $('#commentorState_'+commentId).val(),
            		content: $('#content_'+commentId).val()
            		}, 
            		function(data) {
          			 	var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                      	alert(data.message);
                    	window.location.reload();
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
    		var params = {productId: '${businessProduct.productId}', keyWord: keyWord};
    		return params;
    	}
    	    
        //跳转页面
        function jump(pageNo, pageSize) {
        	var params = getParams();
        	if(pageNo != undefined && pageNo != 0) {
        		params.page = pageNo;
        	}else{
        		params.page = 1;
        	}
        	$.ajax({
        		type: 'post',
                url: '<%=path %>/business/businessProductComment/list.do',
                dataType: 'json',
                data: params,
                cache: false,
                success: function (data) {
                	$("#rowCount").html("共计有" + data.total + "条评论");  // 根据查询条件更新总条数
                    var rows = data.rows;
                    if(rows.length > 0) {
                    	$('#commentDiv').html('');
                    	for(var i=0;i<rows.length;i++) {
                        	var row = rows[i];  
                        	
                        	var condition = '';
                   			if(row.commentorState == 1) {
                           		if(row.replyId != 0) {
                           			condition += "【官方】 回复&nbsp;&nbsp; ";
                           			condition += (row.replyName==""?"匿名": row.replyName);
                           			if(row.replyState == 1){
                           				condition +=  "【官方】";
                           			}
                           		}
                           	}
                           	if(row.commentorState == 0) {
                           		if(row.replyId != 0) {
                           			condition += "&nbsp;&nbsp;回复&nbsp;&nbsp; ";
                           			condition += (row.replyName==""?"匿名": row.replyName);
                           			if(row.replyState == 1){
                           				condition +=  "【官方】";
                           			}
                           		}
                           	}
                    		
                        	var htmlDom = ''
                        		+ '<div id="comment_'+row.commentId+'" class="cominfo">'
                        		+ '<a class="cominfobox" href="javascript:;">'
                        		+ '<span class="rakin">'+parseInt((pageNo-1)*pageSize +i+1) +'</span>'
                        		+ '<div class="textinfo">'
                        		+ '<span class="aut">'+  (row.commentor==""?"匿名": row.commentor) +condition
                        		+'</span>'
                        		+'<time>'+(row.commentTime != null ? row.commentTime.substring(0, 16) : '')+'</time>'
                        		+ '<div class="no-float"></div>'
                        		+ '<p class="text">'+row.content+'</p>'
                        		+ '</div>'
                        		+ '<div class="opera">'
                        		+ '<span class="arrow"><img src="<%=ctx %>/images/icon/arrow1.png" title="回复该评论" width="40" height="40" onclick="showReplyForm('+row.commentId+', '+parseInt((pageNo-1)*pageSize +i+1)+','+data.total+')"/></span>'
                        		+ '<span class="del1" title="删除该评论" onclick="deleteComment('+row.commentId+', '+row.productId+')"><img src="<%=ctx %>/images/icon/dels.png" width="22" height="25" /></span>'
                        		+ '</div>'
                        		+ '</a>'
                        		+ '<div  id="replyForm_'+parseInt((pageNo-1)*pageSize +i+1)+'" class="reply" style="display:none;">'
                        		+ '<input id="productId_'+row.commentId+'" type="hidden" name="productId"  value="'+row.productId+'" />' 
                        		+ '<input id="replyId_'+row.commentId+'" type="hidden" name="replyId"  value="'+row.commentorId+'" />'
                        		+ '<input id="replyState_'+row.commentId+'" type="hidden" name="replyState"  value="'+row.replyState+'" />'
                        		+ '<input id="replyName_'+row.commentId+'" type="hidden" name="replyName"  value="'+row.commentor+'" />'
                        		+ '<input id="commentorState_'+row.commentId+'" type="hidden" name="commentorState"  value="'+row.commentorState+'" />'
                        		+ '<textarea placeholder="请输入回复内容..." class="reptext" id="content_'+row.commentId+'" name="content"></textarea>'
                        		+ '<hr class="link">'
                        		+ '<a href="javascript:;" class="cancel" onclick="hiddenReplyForm('+row.commentId+', '+parseInt((pageNo-1)*pageSize +i+1)+') ">取消</a>'
                        		+ '<input class="subm" type="button" value="提交" onclick="saveComment('+row.commentId+')"/>'
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
			<span class="return" onclick="history.go(-1)"></span>评论详情
		</div>
		<div class="review" style="top:57px;  position:relative;">
			<div class="review-t">
				<h2 class="tiele">${businessProduct.title}</h2>
				<div class="newsinfo">
					类型：
						<span class="user">
							<c:if test="${businessProduct.dealType == 0 }">出售</c:if>
							<c:if test="${businessProduct.dealType == 1 }">求购</c:if>
							<c:if test="${businessProduct.dealType == 2 }">交换</c:if>
						</span> 
					来源：
						<span class="com">${businessProduct.estateScope}</span> 
					发布时间：
						<span class="com"><time><fmt:formatDate value="${businessProduct.publishTime }" pattern="yyyy-MM-dd HH:mm" /></time></span>
				</div>
				<p class="newsdeta">${businessProduct.content}</p>
				
				<div class="serachbox">
					<div class="bodrbox">
						<input id="serach" type="text" name="keyWord" placeholder="请输入搜索关键字" value="" /> 
						<input id="submt" type="button" name="" onclick="search()" value="" />
					</div>
				</div>
			</div>
			
			<div class="review-b">
				<h2 id="rowCount"  class="comnum">共计有${pager.rowCount}条评论</h2>
				<div id="commentDiv">
					<c:forEach items="${baseBean.list}" var="bean" varStatus="status">
						<div id="comment_${bean.commentId }" class="cominfo">
							<a class="cominfobox" href="javascript:;"> 
								<span class="rakin">${status.index+1}</span>
								<div class="textinfo">
									<span class="aut">${bean.commentor==""?"匿名": bean.commentor}
										<c:if test="${bean.commentorState == 0}">
											<c:if test="${bean.replyId != 0}">&nbsp;&nbsp;回复&nbsp;&nbsp; ${bean.replyName==""?"匿名": bean.replyName}
												<c:if test="${bean.replyState == 1}">【官方】</c:if>
											</c:if>
										</c:if>
										<c:if test="${bean.commentorState == 1}">
											<c:if test="${bean.replyId != 0}">【官方】 回复&nbsp;&nbsp; ${bean.replyName==""?"匿名": bean.replyName}
												<c:if test="${bean.replyState == 1}">【官方】</c:if>
											</c:if>
										</c:if>
									</span>
									<time>
										<fmt:formatDate value="${bean.commentTime }" pattern="yyyy-MM-dd HH:mm" />
									</time>
									<div class="no-float"></div>
									<p class="text">${bean.content}</p>
								</div>
								<div class="opera">
									<span class="arrow">
										<img src="${ctx}/images/icon/arrow1.png" title="回复该评论" width="40" height="40" onclick="showReplyForm(${bean.commentId},${status.index+1},${pager.rowCount})" />
									</span> 
									<span class="del1" title="删除该评论" onclick="deleteComment('${bean.commentId}', '${bean.productId}')">
										<img src="${ctx}/images/icon/dels.png" width="22" height="25" />
									</span>
								</div>
							</a>
							<div  id="replyForm_${status.index+1}" class="reply" style="display:none;">
								<input id="productId_${bean.commentId }" type="hidden" name="productId"  value="${bean.productId}" /> 
								<input id="replyId_${bean.commentId }" type="hidden" name="replyId"  value="${bean.commentorId}" /> 
								<input id="replyName_${bean.commentId }" type="hidden" name="replyName"  value="${bean.commentor}" /> 
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
			
			<div class="no-float"></div>
			<div class="page">
				<div class="pagec">
	            	<input type="hidden" id="pageCount" value="${pager.pageCount}" />
	                <ul id="pageUl">
	                	<li><a id="arrow-l" class="arrow" href="javascript:prev(${pager.pageSize});" ></a></li>
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