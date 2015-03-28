<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>驿站开通需求票数</title>
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
	                    <li id="state_" class="navlist"><a href="javascript:;"><span>反馈情况</span><b class="donbut"><i></i></b></a>
                    		<input type="hidden" name="state" id="state" value="" />
	                    	<ul class="erjnav">
	                    		<li id="state_0"><a href="javascript:;">投票未开通</a></li>
	                            <li id="state_1"><a href="javascript:;">投票已开通</a></li>
	                        </ul>
	                    </li>
	                    <!-- <li id="source_" class="navlist"><a href="javascript:;"><span>全部来源</span><b class="donbut"><i></i></b></a> 
							<input type="hidden" name="source" id="source" value="" /> 
							<ul class="erjnav">
								<li id="source_1"><a href="javascript:;">驿站女孩</a></li>
		                        <li id="source_2"><a href="javascript:;">快递代收</a></li>
		                        <li id="source_3"><a href="javascript:;">驿站公告</a></li>
		                    </ul>
						</li> -->
	                	<li id="comId_" class="active navlist"><a href="javascript:;"><span>所有社区</span><b class="donbut"><i></i></b></a> 
	                    	<input type="hidden" name="comId" id="comId" value="" />
	                    	<ul class="erjnav">
	                            <c:forEach items="${comList}" var="comBean" varStatus="key">
	                            	<li id="comId_${comBean.comId}"><a href="javascript:;">${comBean.comName}</a></li>
								</c:forEach>
	                        </ul>
	                    </li>
	                    <li id="estateId_" class="navlist"><a href="javascript:;"><span>所有小区</span><b class="donbut"><i></i></b></a> 
							<input type="hidden" name="estateId" id="estateId" value="" /> 
							<ul id="estateUL" class="erjnav"></ul>
						</li>
	                </ul>
	                <p style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:10px;" id="rowCount">共${pager.rowCount}条</p>
	            </div>
	        	<!-- <div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value=""  placeholder='调查反馈搜索' /><input id="searbut" type="button"  onclick="search()" value="" /></div></div> -->
	        </div>
            <div class="exp-exc">
	            <table cellpadding="0" cellspacing="0">
	                <thead>
	                  <tr>
	                    <th>投票名次</th>
	                    <th>社区</th>
	                    <th>小区名称</th>
	                    <th>投票比例</th>
	                    <th>操作</th>
	                  </tr>
	                </thead>
	                <tbody class="column">
	                	<c:forEach items="${baseBean.list}" var="bean" varStatus="status">
		                  <tr class="${(status.index+1)%2 == 0?'':'trtwo'}">
		                    <td class="red">${status.index+1}</td>
		                    <td>${bean.comName}</td>
		                    <td>${bean.estateName}</td>
		                    <td>
		                    	驿站女孩:<fmt:formatNumber value="${(bean.yznh/bean.totalPoll)*100}" pattern="##" minFractionDigits="0" ></fmt:formatNumber>% 
		                                                                        快递代收:<fmt:formatNumber value="${(bean.kdds/bean.totalPoll)*100}" pattern="##" minFractionDigits="0" ></fmt:formatNumber>%  
		                                                                        驿站公告:<fmt:formatNumber value="${(bean.yzgg/bean.totalPoll)*100}" pattern="##" minFractionDigits="0" ></fmt:formatNumber>%  
		                    </td>
		                    <td><a class="bluea" style="cursor:pointer;" onclick="window.location.href='${ctx}/business/businessStationFeedback/getFeedDetail.do?feedId=${bean.feedId}'">查看</a></td>
		                  </tr>
		                 </c:forEach>
	                </tbody>
	            </table>
	        </div>
			<div class="page">
				<div class="pagec">
					<input type="hidden" id="pageCount" value="${pager.pageCount}" />
					<ul id="pageUl">
						<li><a id="arrow-l" class="arrow" href="javascript:prev();" <c:if test="${pager.pageId <= 1 }"> disabled </c:if>></a></li>
						<c:forEach items="${pager.indexs }" var="pageNo">
							<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo });"><span id="page_${pageNo }">${pageNo }</span></a></li>
						</c:forEach>
						<li><a id="arrow-r" class="arrow" href="javascript:next();" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if>></a></li>
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

<script type="text/javascript">
	$(function () {
		$(document).keyup(function(event){
			  if(event.keyCode ==13){
			    $("#searbut").trigger("click");
			  }
		});
	});
	
	//获取多参数
	function getParams() {
		var params = '';
		params = {
			state: $('#state').val(),
			source: $('#source').val(),
			comId: $('#comId').val(),
			estateId: $('#estateId').val()
		};
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
        url: '<%=path %>/business/businessStationFeedback/getPageList.do',
        type: 'post',
        dataType: 'json', 
        data: params,
        cache: false,
        success: function (data) {
        	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
            var rows = data.rows;
            
            if(rows.length > 0) {
            	for(var i=0;i<rows.length;i++) {
                	var row = rows[i];   
                	var htmlDom = ''
	              		+ '<tr class="'+((i+1)%2==0?'':'trtwo')+'">'
	              		+ '<td class="red">'+(i+1) +'</td>'
	              		+ '<td>'+row.comName+'</td>'
	              		+ '<td>'+row.estateName+'</td>'
	              		+ '<td>'
	              		+ '驿站女孩:'+Math.round((row.yznh/row.totalPoll)*100)+'%'
	              		+ '快递代收:'+Math.round((row.kdds/row.totalPoll)*100)+'%' 
	              		+ '驿站公告:'+Math.round((row.yzgg/row.totalPoll)*100)+'%' 
						+ '</td>'
	              		+ '<td><a class="bluea" onclick="window.location.href=\'getFeedDetail.do?feedId='+row.feedId+'\'">查看</a></td>'
	              		+ '</tr>';
                  	$('.column').append(htmlDom);
                }
            }else{
            	$('.column').html('很抱歉，没有相关记录。');
            }
				
         	// 获取社区下对于的所有小区
          	$('.erjnav').eq(3).html('');
          	var comId = $("#comId").val();
          	$.ajax({
			type: 'post',
	        url: '<%=path %>/manage/manageEstate/findEstateByComId.do',
	        dataType: 'json',
	        data: {comId : comId},
	 		cache: false,
	        success: function (data) {
	            var rows = data.rows;
               	var estateId = $("#estateId").val();
            	var htmlDom = "";
            	
               	if(estateId != "") {
                	htmlDom = '<li id="estateId_"><a href="javascript:;">所有小区</a></li>';
                	$('.erjnav').eq(3).append(htmlDom);
               	}
               	
	            if(rows.length > 0 && comId != "") {
	            	for(var i=0;i<rows.length;i++) {
	                	var row = rows[i];  
	                	if(row.estateId != estateId) {
		                	htmlDom = '<li id="estateId_'+row.estateId+'"><a href="javascript:;">'+row.estateName+'</a></li>';
		                	$('.erjnav').eq(3).append(htmlDom);
	                	}
	            	}
	            	$('#oneul').find('.erjnav:eq(3)>li').each(function(index, obj) {
						bindClick($(obj));
					});
	            }else {
	            	$('.erjnav').eq(3).html('');
	            }
	        },
	        error: function () {
	        	$('.erjnav:eq(3)').html('很抱歉，加载小区内容出错，我们及时修改问题。');
	        }
	    });
          	
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
</script>