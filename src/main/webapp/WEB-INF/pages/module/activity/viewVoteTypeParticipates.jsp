<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<title>投票活动参与人详情</title>

<%@include file="/common/meta.jsp"%>
<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
<style type="text/css">
    .replayinfo .replaycon {border: 1px solid #e4e4e4;border-radius: 5px;font-size: 12px;margin: 10px 0;padding: 10px;width: 200px;}
	.replaycon h1 {font-size: 12px;font-weight: bold;margin-bottom: 6px;}
	.replaycon p {color:#000;}
	.review .review-b #commentDiv  .cominfo .replayinfo{position:absolute; top:0; left:62%; z-index:49;}
	.review .review-b #commentDiv  .cominfo .reply{ position:static;}
	.review .review-b #commentDiv  .cominfo .cominfobox{height:124px;}
	.review .review-b #commentDiv  .cominfo{ height:124px;}
	.review .review-b  #commentDiv .cominfo .rakin{ height:124px; line-height:124px;}
	.review .review-b  #commentDiv .cominfo .opera .arrow{ margin:42px auto 42px;}
	.review .review-b  #commentDiv .cominfo .opera{ height:124px;}
	#oneul .navlist .erjnav{ position:absolute; z-index:999; top:30px; left:-16px; width:124px; border-radius:5px; overflow:hidden; display:none;}
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
    		var params = {actId: $('#actId').val(), keyWord: keyWord, optionsId: $('#optionsId').val()};
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
                url: '<%=path %>/business/businessActivityVoteInformation/list.do',
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
                        		+'<div id="comment__'+row.informationId+'" class="cominfo">'
                        		+'<a class="cominfobox" href="javascript:;"> '
                        		+'<span class="rakin">'+parseInt((pageNo-1)*pagesize +i+1) +'</span>'
                        		+'<div class="textinfo">'
                        		+'<p class="text">'
                        		+'<span class="aut">姓名：'+row.realname+'</span>'
                        		+'<time>参与时间：'
                        		+ (row.createTime != null ? row.createTime.substring(0, 16) : '')
                        		+'</time>'
                        		+'<span style="float:right;"></span>'
                        		+'</p>'
                        		+'<div class="no-float"></div>'
                        		+'<p class="text">'
                        		+'昵称：'+row.nickname+'<br />'
                        		+'电话：'+row.tel+'<br />'
                        		+'地址：'+row.estateName+row.buildingName+row.unitName+row.houseNo
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
    </script>
</head>

<body style="background: #fff;">
	<div class="wrapper" style="overflow:visible;">
		<div class="header-public">
			<span style="cursor: pointer;" class="return" onclick="history.go(-1)"></span>投票活动参与人
		</div>
		<div class="review" style="top:57px;  position:relative;">
			<div class="review-t">
				<div class="serachbox">
					<div class="scroll-box">
		                <ul id="oneul">
		                    <li id="optionsId_" class="navlist"><a href="javascript:;"><span style="color:#000000;  padding-right:10px;">全部投票名单</span><b class="donbut"><i></i></b></a>
		                    	<input type="hidden" name="optionsId" id="optionsId" value="" />
		                    	<ul class="erjnav">
		                    		<c:forEach items="${baseBean.list}" var="bean" varStatus="status">
		                            	<li id="optionsId_${bean.optionsId}"><a href="javascript:;">选项${status.index+1}</a></li>
		                            </c:forEach>
		                        </ul>
		                    </li>
		                </ul>
		            </div>
					<div class="bodrbox">
						<input id="serach" type="text" name="keyWord" placeholder="输入用户绑定的手机号查找" value="" /> 
						<input id="submt" type="button" name="" onclick="search()" value="" />
					</div>
				</div>
			</div>
			<input id="actId" type="hidden" name="actId"  value="${businessActivity.actId}" />
			<div class="review-b">
				<h2  id="rowCount"  class="comnum">投票活动:【${businessActivity.actName}】共计有${baseBean1.pager.rowCount}个参与人</h2>
				<div id="commentDiv" style="margin-top:10px;">
					<c:forEach items="${baseBean1.list}" var="bean" varStatus="status">
						<div id="comment_${bean.informationId }" class="cominfo">
							<a class="cominfobox" href="javascript:;"> 
								<span class="rakin">${status.index+1}</span>
								<div class="textinfo">
									<p class="text">
									<span class="aut">姓名：${bean.realname}</span>
									<time>参与时间：
										<fmt:formatDate value="${bean.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
									</time>
									<span style="float:right;"></span>
									</p>
									<div class="no-float"></div>
									<p class="text">
										昵称：${bean.nickname}<br />
										电话：${bean.tel}<br />
										地址：${bean.estateName}${bean.buildingName}${bean.unitName}${bean.houseNo}</p>
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