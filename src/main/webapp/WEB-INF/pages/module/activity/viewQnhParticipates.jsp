<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<title>青年汇活动参与人详情</title>

<%@include file="/common/meta.jsp"%>
<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
<style type="text/css">
    .review .review-b #commentDiv  .cominfo .replayinfo{position:absolute; top:0; left:62%; z-index:49;}
	.review .review-b #commentDiv  .cominfo .reply{ position:static;}
	.review .review-b #commentDiv  .cominfo .cominfobox{height:124px;}
	.review .review-b #commentDiv  .cominfo{ height:124px;}
	.review .review-b  #commentDiv .cominfo .rakin{ height:124px; line-height:124px;}
	.review .review-b  #commentDiv .cominfo .opera .arrow{ margin:42px auto 42px;}
	.review .review-b  #commentDiv .cominfo .opera{ height:124px;}
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
    		var params = {actId: '${businessActivity.actId}', keyWord: keyWord};
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
                url: '<%=path %>/business/businessActivityQnhInformation/list.do',
                dataType: 'json',
                data: params,
                cache: false,
                success: function (data) {
                    var rows = data.rows;
                    if(rows.length > 0) {
                    	$('#commentDiv').html('');
                    	for(var i=0;i<rows.length;i++) {
                        	var row = rows[i];  
                        	var htmlDom = ''
                        		+'<div id="comment_'+row.informationId+'" class="cominfo">'
                        		+'<a class="cominfobox" href="javascript:;"> '
                        		+'<span class="rakin">'+parseInt((pageNo-1)*pagesize +i+1) +'</span>'
                        		+'<div class="textinfo">'
                        		+'<p class="text">'
                        		+(row.realname !='null'?"真实姓名："+row.realname+"<br />":"")
                        		+(row.tel !='null'?"联系电话："+row.tel+"<br />":"")
                        		+(row.state !='null'?"状　　态："+(row.state==0?'已报名':'已签到')+"<br />":"")
                        		+'创建时间：<time>'+(row.createTime != null ? row.createTime.substring(0, 19) : "")+'</time>'
                        		+'</p>'
                        		+'</div>'
                        		+'</a>'
                        		+'</div>';
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
       /*  function exportExcelList() {
            window.location.href = '${ctx}/business/businessActivity/exportPublicParticipates.do?actId='+$('#actId').val();
        } */
    </script>
</head>

<body style="background: #fff;">
	<div class="wrapper" style="overflow:visible;">
		<div class="header-public">
			<span style="cursor: pointer;" class="return" onclick="history.go(-1)"></span>青年汇活动参与人
		</div>
		<div class="review" style="top:57px;  position:relative;">
			<div class="review-t">
				<div class="serachbox">
					<%-- <div class="scroll-box">
		                <ul id="oneul">
		                    <li id="timeSlotId_" class="navlist"><a href="javascript:;"><span style="color:#000000;  padding-right:10px;">全部报名名单</span><b class="donbut"><i></i></b></a>
		                    	<input type="hidden" name="timeSlotId" id="timeSlotId" value="" />
		                    	<ul class="erjnav">
		                    		<c:forEach items="${baseBean.list}" var="bean" varStatus="status">
		                            	<li id="timeSlotId_${bean.timeSlotId}"><a href="javascript:;">报名场次　${bean.timeSlotName}</a></li>
		                            </c:forEach>
		                        </ul>
		                    </li>
		                </ul>
		            </div> --%>
		            <!-- <a onclick="exportExcelList()" href="javascript:;" style="border: 1px solid rgb(207, 207, 207); color: rgb(51, 51, 51); display: inline-block; font-size: 14px; height: 30px; line-height: 30px; margin: 5px 5px 0px 20px; text-align: center; width: 100px; border-radius: 15px;">导出报名名单</a> -->
					<div class="bodrbox">
						<input id="serach" type="text" name="keyWord" placeholder="输入用户绑定的手机号查找" value="" /> 
						<input id="submt" type="button" name="" onclick="search()" value="" />
					</div>
				</div>
			</div>
			<input id="actId" type="hidden" name="actId"  value="${businessActivity.actId}" />
			<div class="review-b">
				<h2  id="rowCount"  class="comnum">青年汇活动:【${businessActivity.actName}】共计有${baseBean.pager.rowCount}个参与人</h2>
				<div id="commentDiv" style="margin-top:10px;">
					<c:forEach items="${baseBean.list}" var="bean" varStatus="status">
						<div id="comment_${bean.informationId }" class="cominfo">
							<a class="cominfobox" href="javascript:;"> 
								<span class="rakin">${status.index+1}</span>
								<div class="textinfo">
									<p class="text">
										<c:if test="${bean.realname != null}">真实姓名：${bean.realname}<br /></c:if>
										<c:if test="${bean.tel != null}">联系电话：${bean.tel}<br /></c:if>
										<c:if test="${bean.state != null}">状　　态：${bean.state==0?'已报名':'已签到'}<br /></c:if>
										创建时间：<time><fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></time>
									</p>
								</div>
							</a>
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