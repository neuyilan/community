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
<link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
<script type="text/javascript">
		$(function () {
		    $(document).keyup(function(event){
				  if(event.keyCode ==13){
					  $("#submt").trigger("click");
				  }
			});
		});

        //删除评论
        function deleteComment(commentId, help) {
        	var bool = window.confirm("您确定要删除该条评论吗？");
    	    if(bool) {
    	    	$.post('${ctx}/business/businessHelpComment/delete.do', {id :commentId, help:help }, function(data) {
    	    		eval("data = "+data);
        			alert(data.message);
                    window.location.reload();
    	        });
    	    }
        }
       
        function delExpendestates(id) {
            var flag = window.confirm("是否删除此社区聊吧扩散信息！");
            if(flag) {
                $.getJSON('${ctx}/business/businessHelpExpendestates/delete.do', {id: id}, function(data) {
                    alert(data.message);
                    location.reload();
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
            	$.post('${ctx}/business/businessHelpComment/replySave.do', {
            		help: $('#help_'+commentId).val(),
            		replyId: $('#replyId_'+commentId).val(),
            		replyName: $('#replyName_'+commentId).val(),
            		replyState: $('#replyState_'+commentId).val(),
            		commentorState: $('#commentorState_'+commentId).val(),
            		content: $('#content_'+commentId).val()
            		}, 
            		function(data) {
           			eval("data = "+data);
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
    		var params = {help: '${businessHelp.helpId}', keyWord: keyWord};
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
                url: '<%=path %>/business/businessHelpComment/getPageList_manage.do',
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
                        	
                        	var name ='';
                            name =  (row.commentorName==""?"匿名": row.commentorName);
                        	if(row.commentorState == 1) {
                        		if(row.replyId != 0) {
                        			name += "【官方】 回复&nbsp;&nbsp; ";
                        			name += (row.replyName==""?"匿名": row.replyName);
                        			if(row.replyState == 1){
                        				name +=  "【官方】";
                        			}
                        		}
                        	}
                        	if(row.commentorState == 0) {
                        		if(row.replyId != 0) {
                        			name += "&nbsp;&nbsp;回复&nbsp;&nbsp; ";
                        			name += (row.replyName==""?"匿名": row.replyName);
                        			if(row.replyState == 1){
                        				name +=  "【官方】";
                        			}
                        		}
                        	}
                        	
                        	var htmlDom = ''
                        		+ '<div id="comment_'+row.commentId+'" class="cominfo">'
                        		+ '<a class="cominfobox" href="javascript:;">'
                        		+ '<span class="rakin">'+parseInt((pageNo-1)*pageSize +i+1) +'</span>'
                        		+ '<div class="textinfo">'
                        		+ '<span class="aut">'+ name +'</span>'
                        		+'<time>'+(row.commentTime != null ? row.commentTime.substring(0, 16) : '')+'</time>'
                        		+ '<div class="no-float"></div>'
                        		+ '<p class="text">'+row.content+'</p>'
                        		+ '</div>'
                        		+ '<div class="opera">'
                        		+ '<span class="arrow"><img src="<%=ctx %>/images/icon/arrow1.png" title="回复该评论" width="40" height="40" onclick="showReplyForm('+row.commentId+', '+parseInt((pageNo-1)*pageSize +i+1)+','+data.total+')"/></span>'
                        		+ '<span class="del1" title="删除该评论" onclick="deleteComment('+row.commentId+', '+row.help+')"><img src="<%=ctx %>/images/icon/dels.png" width="22" height="25" /></span>'
                        		+ '</div>'
                        		+ '</a>'
                        		+ '<div  id="replyForm_'+parseInt((pageNo-1)*pageSize +i+1)+'" class="reply" style="display:none;">'
                        		+ '<input id="help_'+row.commentId+'" type="hidden" name="help"  value="'+row.help+'" />' 
                        		+ '<input id="replyId_'+row.commentId+'" type="hidden" name="replyId"  value="'+row.commentorId+'" />' 
                        		+ '<input id="replyName_'+row.commentId+'" type="hidden" name="replyName"  value="'+row.commentorName+'" />'
                        		+ '<input id="replyState_'+row.commentId+'" type="hidden" name="replyState"  value="'+row.replyState+'" />'
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
			<span class="return" onclick="history.go(-1)"></span>社区聊吧详情
		</div>
		<div class="review" style="top:57px;  position:relative;">
			<div class="review-t">
				<h2 class="tiele">${businessHelp.helpTitle}</h2>
					<div style="margin-left:10px; font-size:16px; line-height:28px; color:#000; height:70px;" class="newsinfo">
					真实姓名：<span class="user" style="font-size:16px; color:#000;">${businessHelp.realname}</span> <br>
					昵　　称：<span class="user" style="font-size:16px; color:#000;">${businessHelp.nickname}</span><br> 
					电	　　话：<span class="user" style="font-size:16px; color:#000;">${businessHelp.tel}</span><br> 
					所属小区：<span class="com" style="font-size:16px; color:#000;">${businessHelp.estateName}</span><br>
					社区聊吧时间：<span class="com" style="font-size:16px; color:#000;"><time><fmt:formatDate value="${businessHelp.helpTime }" pattern="yyyy-MM-dd HH:mm" /></time></span><br>
					预览地址：<span class="com" style="font-size:16px; color:#000;">http://wx.bqsqcm.com/wxokjia/chat_info.php?ID=4863</span>
					</div>
					<p style="margin-top:60px;" class="newsdeta"></p>
					<hr style=" background: #9e9e9e; border: none; height: 1px; margin: 28px 0 18px; width: 100%;" class="link">
					<div style="margin-left:10px; margin-bottom:15px;">${businessHelp.helpContent}</div>
					<c:forEach items="${list}" var="list" varStatus="status">
						<div style="text-align:center;"><img src="<%=path %>${list.picUrl}"></div><br>
					</c:forEach>
				</p>
				<%-- <div class="y-qzxq-h1">
					<c:forEach items="${listExpend}" var="listExpend" varStatus="status">
							<label onclick="delExpendestates('${listExpend.expendEstatesId}')"><span class="y-qzxq-s2">${listExpend.estateName} <em>x&nbsp;</em></span></label>
					</c:forEach>
					<input type="hidden" id="helpArray" name="helpArray" value="${estateArr }">
					<shiro:hasPermission name="help_add_expand">
	                <i></i>
	                <a id="showScopeLayer" style="cursor:pointer;">点击添加扩散范围</a>
	                </shiro:hasPermission>
	            </div> --%>
            
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
									<span class="aut">${bean.commentorName==""?"匿名": bean.commentorName}
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
									<time><fmt:formatDate value="${bean.commentTime }" pattern="yyyy-MM-dd HH:mm" /></time><div class="no-float"></div>
									<p class="text">${bean.content}</p>
								</div>
								<div class="opera">
									<span class="arrow">
										<img src="${ctx}/images/icon/arrow1.png" title="回复该评论" width="40" height="40" onclick="showReplyForm(${bean.commentId},${status.index+1},${pager.rowCount})" />
									</span> 
									<span class="del1" title="删除该评论" onclick="deleteComment('${bean.commentId}', '${bean.help}')">
										<img src="${ctx}/images/icon/dels.png" width="22" height="25" />
									</span>
								</div>
							</a>
							<div  id="replyForm_${status.index+1}" class="reply" style="display:none;">
								<input id="help_${bean.commentId }" type="hidden" name="help"  value="${bean.help}" /> 
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
			
			<div class="no-float"></div>
			<div class="page">
				<div class="pagec">
	            	<input type="hidden" id="pageCount" value="${pager.pageCount}" />
	                <ul id="pageUl">
	                	<li><a id="arrow-l" class="arrow" href="javascript:prev(${pager.pageSize});"></a></li>
	                	<c:forEach items="${pager.indexs }" var="pageNo">
	                		<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo },${pager.pageSize});"><span id="page_${pageNo }">${pageNo }</span></a></li>
	                	</c:forEach>
	                	<li><a id="arrow-r" class="arrow" href="javascript:next(${pager.pageSize});" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if> ></a></li>
	                </ul>
	        	</div>
	        </div>
		</div>
	</div>
	
	<!-- 社区聊吧范围选择开始 -->
	<div id="scopeLayer" class="busswi3">
		<div id="scopeBar" class="sidebar3">
			<form action="">
		    	<a id="close3" href="javascript:;"  onclick="cancleExpendEstates()"></a>
		    	<h2 class="tit3">扩散范围选择</h2>
		    	<hr class="link3" >
		        <div id="wrapper-250">
			          <ul id="scopeTree" style="font-size: 18px; margin-top:10px;"></ul>
		        </div>
		        <div class="w-gg-btn">
		            <input id="qdee" class="w-gg-qr w-gg-total" type="button" style="width: 80px;" value="确定"  onclick="saveExpendEstates('${businessHelp.helpId}')"/>
					<input class="w-gg-qx w-gg-total" type="button" style="width: 80px;" value="取消"  onclick="cancleExpendEstates()"/>
		        </div>
	        </form>
	    </div>
	</div>
	<!-- 社区聊吧范围选择结束 -->
	
	<script type="text/javascript">
	    function saveExpendEstates(helpId) {
	    	// $('#qdee').attr("disabled","disabled");
	    	var scopeIds = '';
	        var scopeInfo = '';
	        var scopeArr = "";
	        var scopeNodes = $('#scopeTree').tree('getChecked');
	        if(scopeNodes != null && scopeNodes.length > 0) {
	            for(var i=0;i<scopeNodes.length;i++) {
	                var node = scopeNodes[i];
	                var idArr = node.id.split('_');
	                var typeid = idArr[0];
	                if(typeid == 'eatate') {
	                	scopeIds += idArr[1] + ':' + node.text + ',';
	                	scopeArr += $("#helpArray").val()+"," + idArr[1];
	                }
	            }
	            if(scopeIds != '') {
	                if(scopeIds.indexOf(',') > -1) {
		                $("#helpArray").val(scopeArr);
	                    scopeIds = scopeIds.substring(0, scopeIds.length-1);
	                	$.post('${ctx}/business/businessHelpExpendestates/save.do', {
	               			helpId: helpId,
	               			scope: scopeIds
	                   		}, 
	                   		function(data) {
	                  			eval("data = "+data);
	            				alert(data.message);
	                           	//window.location.reload();
	                           	//$("#scopeLayer").fadeOut("slow");
	            				window.location.href = '<%=ctx%>/business/businessHelp/getHelpCommentList.do?helpId='+helpId;
	                       }); 
	                }
	            } else {
	            	alert('请选择该社区无对应的小区');
	            }
	        }else{
	            alert('请选择扩散范围');
	        }
	    }
    	
	 	// 取消选择扩散范围
	 	function cancleExpendEstates() {
	 	    $("#scopeLayer").fadeOut("slow");
	 	}
	 	
		$(function() {
			// 显示社区聊吧范围层
		    $("#showScopeLayer").click(function(){
		   	        $("#scopeLayer").fadeIn("slow");
		   	        //显示楼栋数结构
		   	        $.ajax({
		   	        	type: 'post',
		   	            url: '${ctx}/business/businessHelp/getExpendScopeTree.do',
		   	            dataType: 'json',
		   	         	data: {helpArray: $("#helpArray").val()},
		   	            cache: false,
		   	            success: function (data) {
		   	                if(data.success == true){
		   	                    var rows = data.result;
		   	                    if(rows.length > 0) {
		   	                        $('#scopeTree').tree('loadData', data.result);
		   	                    }else{
		   	                        $('.accordion2').html('很抱歉，没有相关记录。');
		   	                    }
		   	                }else{
		   	                    $('.accordion2').html('很抱歉，加载内容出错，我们及时修改问题。');
		   	                }
		   	            },
		   	            error: function () {
		   	                $('.accordion2').html('很抱歉，加载内容出错，我们及时修改问题。');
		   	            }
		   	        });
		   	 });
			
		    // 选择社区聊吧范围结点
	        $('#scopeTree').tree({
	            checkbox: true,
	            onSelect: function(node){
	                var children = $('#scopeTree').tree('getChildren', node.target);
	                if(children.length != 0) {//无子元素加入子结点,已有则展开结点即可
	                	$('#scopeTree').tree('expend', node);
	                }
	            }
	        });
	   });
	</script>
</body>
</html>