<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>电子报管理</title>
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
	                	<li id="comId_" class="active navlist"><a href="javascript:;"><span>全部电子报</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="comId" id="comId" value="" />
	                    	<ul class="erjnav">
	                    		 <c:forEach items="${list}" var="com" varStatus="key">
	                    		 		<li id="comId_${com.comId}"><a href="javascript:;">${com.comName}</a></li>
	                    		 </c:forEach>
	                        </ul>
	                    </li>
	                    
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
	                 <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value=""  placeholder='标题搜索' /><input id="searbut" type="button" onclick="search()" value="" /></div></div>
	        </div>
	        
	        <div class="column">
	        	<shiro:hasPermission name="dzb_publish_dzb">
	        	<div class="manbox" style="margin-left:0;">
	            	<a class="nopotr" onclick="javascript:window.location.href='${ctx}/business/businessNewspaper/add.do'" style="cursor:pointer;" >
	                    <div class="relnews">
	                    	<img src="${ctx}/images/icon/relnews.png" style="width:100%;" />
	                    </div>
	                	<span class="tittex" >添加电子报</span>
	                </a>
	            </div>
	        	</shiro:hasPermission>
	        	
	            <c:forEach items="${baseBean.list }" var="newspaper" varStatus="key">
	        		<div class="manbox" 
	        			<shiro:lacksPermission name="dzb_publish_dzb">
	        			<div class="manbox" <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if>
	        			</shiro:lacksPermission>
	        			<shiro:hasPermission name="dzb_publish_dzb">
	        			<div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if>
	        			</shiro:hasPermission>
	        		>
		            	<a class="nopotr" href="javascript:;">
		                    <div class="info">
		                    	<p style="float:left;">所属社区：<span style="color: #3EAF0E;">${newspaper.comName }</span></p>
		                    </div>
		                    <time><fmt:formatDate value="${newspaper.createTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    <hr class="link">        
		                    
		                    <h2 class="y-shq-title title">${newspaper.title }&nbsp;&nbsp;发行</h2>
	                		<div style="text-align:center;"><img class="y-hdgl-img" src="<%=ctx %>${newspaper.pic}" style="height: 100px; width:90px;"/></div>
		                    
		                    <hr class="link">
			                    
		                    <div class="operate">
		                    	<shiro:hasPermission name="dzb_view_detail">
			                    	<span class="see y-shq-yfb" title="查看电子报详情" onclick="showNewWindow('${newspaper.url}')" ></span>
	                    		</shiro:hasPermission>
	                    		<shiro:hasPermission name="dzb_edit_dzb">
	                    			<span class="edit" title="编辑电子报" onclick="toEdit('${newspaper.newspaperId}');"></span>
			                    </shiro:hasPermission>
			                    <shiro:hasPermission name="dzb_delete_dzb">
			                    	<span class="del y-shq-sck" title="删除电子报" onclick="delNewspaper('${newspaper.newspaperId}');"></span>
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

	function showNewWindow(url){
		 if(url!== undefined && url!== null && url !== ''){
		     var scrWidth=screen.availWidth;
		     var scrHeight=screen.availHeight;
		     var self=window.open(url,"resizable=yes,toolbar=yes, menubar=yes,   scrollbars=yes,location=yes, status=yes,top=0,left=0,width="+scrWidth+",height="+scrHeight);
		     self.resizeTo(scrWidth,scrHeight);
		     self.moveTo(0,0);
		 }
	 }
	 
	function delNewspaper(id) {
	    var flag = window.confirm("是否删除该电子报！");
	    if(flag) {
	        $.post('delete.do', {id : id}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
	
	function toEdit(id) {
	    window.location.href = '${ctx}/business/businessNewspaper/modify.do?newspaperId='+id;
	}
	
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					comId: $('#comId').val(),
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
        url: '<%=path %>/business/businessNewspaper/getPageList.do',
        dataType: 'json', 
        data: params,
        cache: false,
        success: function (data) {
        	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
            var rows = data.rows;
            <shiro:hasPermission name="dzb_publish_dzb">
            if(params.page == 1) {
            	var addHtml = ''	                
                    + '<div class="manbox" style="margin-left:0;">'
                    + '<a class="nopotr" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessNewspaper/add.do\';" style="cursor:pointer;">'
                    + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div>'
                    + '<span class="tittex">添加电子报</span>'
                    + '</a>'
                    + '</div>';
                   	$('.column').append(addHtml);
            }
            </shiro:hasPermission>
            if(rows.length > 0) {
            	for(var i=0;i<rows.length;i++) {
                	var row = rows[i];   
                	var styleStr = '';
                	<shiro:lacksPermission name="dzb_publish_dzb">
                	if(params.page == 1 && i % 3 == 0) {
   	        			styleStr = 'style="margin-left:0;"';
   	        		}
                	</shiro:lacksPermission>
                	<shiro:hasPermission name="dzb_publish_dzb">
                	if(params.page == 1 && i % 3 == 2) {
                		styleStr = 'style="margin-left:0;"';
   	        		}
                	</shiro:hasPermission>
					if(params.page > 1 && i % 3 == 0) {
   	        			styleStr = 'style="margin-left:0;"';
   	        		}              	
                	var htmlDom = ''
	              		+ '<div class="manbox"'
	    	        	+ styleStr
	    	        	+ '>'                    	
	                	+ '<a class="nopotr" href="javascript:;">'
	                	+'<div class="info">'
	                	+'<p style="float:left;">所属社区：<span style="color: #3EAF0E;">'+row.comName+'</span></p>'
	                	+'</div>'
	                	+'<time>'+(row.creatTime != '' ? row.createTime.substring(0, 16) : '')+'</time>'
	                	+'<hr class="link">'
	                	+'<h2 class="y-shq-title title">'+row.title+'&nbsp;&nbsp;发行</h2>'
	                	+'<div style="text-align:center;"><img class="y-hdgl-img" src="<%=ctx %>'+row.pic+'" style="height: 100px; width:90px;"/></div>'
	                	+'<hr class="link">'
	                	+'<div class="operate">'
	                	<shiro:hasPermission name="dzb_view_detail">
	                	+'<span class="see y-shq-yfb" title="查看电子报详情" onclick="showNewWindow(\''+row.url+'\');" ></span>'
	                	</shiro:hasPermission>
	                	<shiro:hasPermission name="dzb_edit_dzb">
	                	+'<span class="edit" title="编辑电子报" onclick="toEdit('+row.newspaperId+');"></span>'
	                	</shiro:hasPermission>
	                	<shiro:hasPermission name="dzb_delete_dzb">
	                	+'<span class="del y-shq-sck" title="删除电子报" onclick="delNewspaper('+row.newspaperId+');"></span>'
	                	</shiro:hasPermission>
	                	+'</div>'
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
</script>