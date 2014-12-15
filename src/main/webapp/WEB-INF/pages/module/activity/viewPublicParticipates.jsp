<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<title>报名活动参与人详情</title>

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
    		var params = {actId: $('#actId').val(), keyWord: keyWord, timeSlotId: $('#timeSlotId').val()};
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
                url: '<%=path %>/business/businessActivityRegistrationInformation/list.do',
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
                        		+(row.nickname !='null'?"昵　　称："+row.nickname+"<br />":"")
                        		+(row.realname !='null'?"真实姓名："+row.realname+"<br />":"")
                        		+(row.tel !='null'?"联系电话："+row.tel+"<br />":"")
                        		+(row.birthday !='null'?"生　　日："+row.birthday+"<br />":"")
                        		+(row.age !='null'?"年　　龄："+row.age+"<br />":"")
                        		+(row.job !='null'?"职　　业："+row.job+"<br />":"")
                        		+(row.ID !='null' && row.ID !=undefined?"身  份  证："+row.ID+"<br />":"")
                        		+(row.email !='null'?"邮　　箱："+row.email+"<br />":"")
                        		+(row.addr !='null'?"地　　址："+row.addr+"<br />":"")
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
    </script>
</head>

<body style="background: #fff;">
	<div class="wrapper" style="overflow:visible;">
		<div class="header-public">
			<span style="cursor: pointer;" class="return" onclick="history.go(-1)"></span>报名活动参与人
		</div>
		<div class="review" style="top:57px;  position:relative;">
			<div class="review-t">
				<div class="serachbox">
					<div class="scroll-box">
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
		            </div>
					<div class="bodrbox">
						<input id="serach" type="text" name="keyWord" placeholder="输入用户绑定的手机号查找" value="" /> 
						<input id="submt" type="button" name="" onclick="search()" value="" />
					</div>
				</div>
			</div>
			<input id="actId" type="hidden" name="actId"  value="${businessActivity.actId}" />
			<div class="review-b">
				<h2  id="rowCount"  class="comnum">报名活动:【${businessActivity.actName}】共计有${baseBean1.pager.rowCount}个参与人</h2>
				<div id="commentDiv" style="margin-top:10px;">
					<c:forEach items="${baseBean1.list}" var="bean" varStatus="status">
						<div id="comment_${bean.informationId }" class="cominfo">
							<a class="cominfobox" href="javascript:;"> 
								<span class="rakin">${status.index+1}</span>
								<div class="textinfo">
									<p class="text">
										<c:if test="${bean.nickname != null}">昵　　称：${bean.nickname}<br /></c:if>
										<c:if test="${bean.realname != null}">真实姓名：${bean.realname}<br /></c:if>
										<c:if test="${bean.tel != null}">联系电话：${bean.tel}<br /></c:if>
										<c:if test="${bean.birthday != null}">生　　日：${bean.birthday}<br /></c:if>
										<c:if test="${bean.age != null}">年　　龄：${bean.age}<br /></c:if>
										<c:if test="${bean.job != null}">职　　业：${bean.job}<br /></c:if>
										<c:if test="${bean.ID != null}">身  份  证：${bean.ID}<br /></c:if>
										<c:if test="${bean.email != null}">邮　　箱：${bean.email}<br /></c:if>
										<c:if test="${bean.addr != null}">地　　址：${bean.addr}<br /></c:if>
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