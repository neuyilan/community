<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>部门管理</title>
        <%@include file="/common/meta.jsp"%>
        <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
        <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
        <script type="text/javascript">
           

        </script>
    </head>
    <body>
    <div class="max-height">
    <div class="wrapper wrapos">
        <!--左导航开始-->
        <%@include file="/common/leftNav.jsp"%>
        <!--左导航结束-->

        <!--右部主体内容开始-->
        <div class="mainr">
            <%@include file="/common/header.jsp"%>
            <!--下拉显示导航-->
            <div class="scroll">
	        	<div class="scroll-box">
	                <ul id="oneul">
	                	<li class="active"><span>全部员工:${users }人</span>&nbsp;&nbsp;</li>
	                    <li ><span>共设立:${departments }个部门</span>&nbsp;&nbsp;</li>
	                </ul>
	                 <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            	 <a class="scbox-btn" href="<%=ctx %>/business/businessUser/list.do" >设置员工</a>
	            </div>
	        	<!-- <div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" /><input id="searbut" type="button"  onclick="search()" value="" /></div></div> -->
	        </div>
	        
	        <div class="column">
	        	<!-- 添加账号开始 -->
	        	<div class="manbox" style="margin-left:0;">
            
	            	<a class="nopotr" href="javascript:window.location.href='<%=ctx %>/business/businessDepartment/add.do';" style="cursor:pointer;">
	            
	                    <div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div>
	                
	                	<span class="tittex">添加部门</span>
	                
	                </a>
	                
	            </div>
	        	<!-- 添加账号结束 -->
	        	
	        	<!-- 账号列表开始 -->
	            <c:forEach items="${baseBean.list }" var="dep" varStatus="key">
	        		<div class="manbox"
	        		 <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> 
	        		  >
            
		            	<a class="nopotr" href="javascript:;">
		            
		                    <div class="info">部门：<span>${dep.depName}</span><!-- <strong style="font-weight:normal; float:right; margin-right:67px;">已绑定员工：0 人</strong> --></div>
		                    
		                    <hr class="link">
		                    
		                    <h2 class="yggl_title"><em>部门介绍</em></h2>
		                    <div class="text">
		                    ${dep.depDesc}
		                    </div>
		                    <hr class="link">
		                
		                    <div class="operate">
                                <span class="see block11" onclick="window.location.href='<%=ctx %>/business/businessPosition/list.do?depId=${dep.depId}&level=1' "></span>
                                <span class="edit" onclick="window.location.href='modify.do?depId=${dep.depId}' "></span>
                                <span class="del" onclick="deleteDep('${dep.depId}')"></span>
                            </div>
		                </a>
		            </div>
	        	</c:forEach>
	        	<!-- 账号列表结束 -->
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
    
    <!-- <div id="dialog1" title="提示信息">
        <span>是否删除！</span>
    </div> -->
    </body>
</html>
<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
<script type="text/javascript">
    //删除用户
    function deleteDep(depId) {
    	
    	var bool = window.confirm("您确定要删除该部门吗？");
        if(bool) {
            $.getJSON("delete.do", {id : depId}, function(data) {
            	if(data.success == 'true') {
                	alert(data.message);
                    window.location.reload();
                }else{
                	alert(data.message);
                }            	
            });
        }
    }
    
	//获取多参数
	function getParams() {
		var params = '';
		// var keyWord = $('#keyWord').val();
		var keyWord = $("input[name='keyWord']").val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {orgType: '${orgType}'};
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
            url: '<%=path %>/business/businessDepartment/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
            	//alert('data   '+data);
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                var rows = data.rows;
                if(params.page == 1) {
                	var addHtml = ''
                	+ '<div class="manbox" style="margin-left:0;">'
            		+ '<a class="nopotr" href="javascript:window.location.href=\'<%=ctx %>/business/businessDepartment/add.do\';" style="cursor:pointer;">'
	                + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div>'
	                + '<span class="tittex">添加部门</span>'
	                + '</a>'
	                + '</div>';
                	$('.column').append(addHtml);
                }
                if(rows.length > 0) {
                	var length = 0;
                	if(params.page == 1) {
                		if(rows.length > 5) {length = rows.length - 1;}else{
                			length = rows.length;
                		}
                	}else{
                		length = rows.length;
                	}
                	
                	for(var i=0;i<length;i++) {
                    	var row = rows[i];  
                    	var styleStr = '';
                    	if(params.page == 1 && i % 3 == 2) {
                    		styleStr = 'style="margin-left:0;"';
       	        		}else if(params.page > 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
                    	var state = '';
                    	if(row.state == 0) {
                    		state = '启用';
    		            }else{
    		            	state = '禁用';
    		            }  
                    	var htmlDom = ''
                    		+ '<div class="manbox"'
           	        		+ styleStr
           	        		+ '>'
           	        		+ '<a class="nopotr" href="javascript:;">'
           	        		+ '<hr class="link">'
           	        		+ '<h2 class="yggl_title">'+row.depName+'<br><em>'+row.depDesc+'</em></h2>'
           	        		+ '<hr class="link">'
           	        		+ '<div class="operate">'
           	        		+ '<span class="see block11" onclick="window.location.href=\'<%=ctx %>/business/businessPosition/list.do?depId='+row.depId+'&level=1\'"></span>'
           	        		+ '<span class="edit" onclick="window.location.href=\'modify.do?userId='+row.depId+'\'"></span>'
           	        		+ '<span class="del" onclick="deleteDep('+row.depId+')"></span>'
           	        		+ '</div>'
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