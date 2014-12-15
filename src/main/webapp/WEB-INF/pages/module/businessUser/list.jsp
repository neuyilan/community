<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>员工管理</title>
        <%@include file="/common/meta.jsp"%>
        <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
        <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
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
	                    
	                    	<li><span>共设立:${departments }个部门</span>&nbsp;&nbsp;</li>
	                    
	                </ul>
	                <p id="rowCount"  style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            	<shiro:hasPermission name="businessuser_add_department">
	            	<a class="scbox-btn" href="${ctx}/business/businessDepartment/list.do" >设立部门</a>
	            	</shiro:hasPermission>
	            </div>
	            
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='真实姓名/电话/email搜索'  /><input id="searbut" type="button"  onclick="search()" value="" /></div></div>
	        </div>
	        
	        <div class="column">
	        	<!-- 添加员工开始 -->
	        	<shiro:hasPermission name="businessuser_add">
	        	<div class="manbox" style="margin-left:0;">
	            	<a class="nopotr" href="javascript:window.location.href='<%=ctx %>/business/businessUser/add.do';" style="cursor:pointer;">
	                    <div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div>
	                	<span class="tittex">添加员工</span>
	                </a>
	            </div>
	            </shiro:hasPermission>
	        	<!-- 添加员工结束 -->
	        	
	        	<!-- 员工列表开始 -->
	            <c:forEach items="${baseBean.list }" var="user" varStatus="key">
	        		
	        		 	<shiro:lacksPermission name="businessuser_add">
	        				<div class="manbox" <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if> >
	        			</shiro:lacksPermission>
	        			<shiro:hasPermission name="businessuser_add">
	        				<div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> >
	        			</shiro:hasPermission>
            
		            	<a class="nopotr" href="javascript:;">
		            
		                    <div class="info"><p style=" float:left;">部门：<span>${user.depName}</span></p><p style="float:right;">职位：<span>${user.posName }</span></p></div>		  
		                    <time><fmt:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    
		                    <hr class="link">
		                    
		                    <h2 class="yggl_title"><span class="yggl_poht"><img src="<%=ctx %>${user.avatar}" style="width:100%;"></span>${user.userName }<br><em>编号${user.userCode }</em></h2>
		                    
		                    <div class="state">
		                    	<c:choose>
								       <c:when test="${user.state == 0}">
								              	<span class="yggl_relsta cgreen">启用</span>
								       </c:when>
								       <c:when test="${user.state == 1}">
								              	<span class="yggl_relsta cred">禁用</span>
								       </c:when>
								</c:choose>
		                    </div>
		                
		                    <p class="yggl_text">账号：<span>${user.userEmail }</span></p>
		                    <p class="yggl_text">最近登录：<span><fmt:formatDate value="${user.lastLoginTime }" pattern="yyyy-MM-dd HH:mm"/></span></p>
		
		                    <hr class="link">
		                
		                    <div class="operate">
                                <shiro:hasPermission name="businessuser_view_detail"><span class="see block11" title="查看员工详情" onclick="seeWorkerDetail('${user.userId}');"></span></shiro:hasPermission>
                                <shiro:hasPermission name="businessuser_edit"><span class="edit" title="编辑员工" onclick="window.location.href='modify.do?userId=${user.userId}' "></span></shiro:hasPermission>
                                <shiro:hasPermission name="businessuser_delete"><span class="del" title="删除员工" onclick="deleteUser('${user.userId}')"></span></shiro:hasPermission>
                            </div>
		                </a>
		            </div>
	        	</c:forEach>
	        	<!-- 员工列表结束 -->
	            <div class="no-float"></div>
	        </div>
			<div class="page">
				<div class="pagec">
	            	<input type="hidden" id="pageCount" value="${pager.pageCount}" />
	                <ul id="pageUl">
	                	<li><a id="arrow-l" class="arrow" href="javascript:prev();" <c:if test="${pager.pageId <= 1 }"> disabled </c:if> ></a></li>
	                	<c:forEach items="${pager.indexs }" var="pageNo">
	                		<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo });"><span id="page_${pageNo }">${pageNo }</span></a></li>
	                	</c:forEach>
	                	<li><a id="arrow-r" class="arrow" href="javascript:next();" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if> ></a></li>
	                </ul>
	        	</div>
	        </div>
			
            <div class="no-float"></div>
            <%@include file="/common/footer.jsp"%>
        </div>
        <!--右部主体内容结束-->
    </div>
    </div>
    
    <div id="userInfoLayer" class="busswi5 s-xw-bu">
        <div id="userInfoBar" class="sidebar5 s-xw-si">
             <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#userInfoLayer').fadeOut('slow');"></a>
            <h2 class="tit5">员工信息<em>【<span id="state"></span>】</em></h2>
            <div id="wrapper-250">
                <ul class="accordion5">
                    <li class="files" id="one11">
                        <img width="72" height="72" id="userPhoto">
  						<div style="margin-left: 90px;">
  							<p style=" width:100%; overflow:hidden;">
		                        <span style="display: block; float: left; width: 50%;">姓名：<lable id="userName"></lable></span>
		    					<span class="time2" style="display: block; float: right; width: 49%; margin-left:0px;">用户数量：<i id="userCount"></i>人</span></p>
		  					<p style="margin-top:15px;">
                        	<span>部门：<lable id="depName"></lable></span>
						    <span class="time2" style="display: block; float: right; width: 49%; margin-left:0px;">职位：<lable id="posName"></lable></span></p>
						  </div>
                    </li>
                    <li id="one11">
                        <a href="#">
                            <strong>服务范围：</strong><br>
                            <%--方丹苑 — 1号楼、2号楼、3号楼（1、2、3单元）--%>
                            <span id="serviceScope"></span>
                        </a>
                    </li>
                    <div class="link5"></div>
                    <ul class="sub-menu11">
                        <li id="one11">
                            <a href="#"><strong>个人介绍：</strong><br>
                                <span id="userBrief"></span>
                            </a>
                        </li>
                        <div class="link5"></div>
                        <li id="one11">
                            <a href="#">
                                <strong>所属权限：</strong>
                                <br>
                                <span id="auths"></span>
                                <br>

                            </a>
                        </li>
                        <div class="link5"></div>
                        <li id="one11">
                            <a href="#"><strong>个人信息：</strong><br>
                                账号：<span id="userEmail"></span><br>
                                最近登录：<span id="lastLoginTime"></span>
                            </a>
                        </li>
                    </ul>
                </ul>
            </div>
        </div>
    </div>
    </body>
</html>
<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
<script type="text/javascript">
	$(function () {
		$(document).keyup(function(event){
			  if(event.keyCode ==13){
			    $("#searbut").trigger("click");
			  }
		});
	});

    //删除用户
    function deleteUser(userId) {
    	
    	var bool = window.confirm("您确定要删除该员工吗？");
        if(bool) {
            $.getJSON("delete.do", {id : userId}, function(data) {
                alert(data.message);
                window.location.reload();
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
			params = {};
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
            url: '<%=path %>/business/businessUser/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
            	//alert('data   '+data);
            	 
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                var rows = data.rows;
                <shiro:hasPermission name="businessuser_add">
                if(params.page == 1) {
                	var addHtml = ''
                	+ '<div class="manbox" style="margin-left:0;">'
            		+ '<a class="nopotr" href="javascript:window.location.href=\'<%=ctx %>/business/businessUser/add.do\';" style="cursor:pointer;">'
	                + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div>'
	                + '<span class="tittex">添加员工</span>'
	                + '</a>'
	                + '</div>';
                	$('.column').append(addHtml);
                }
                </shiro:hasPermission>
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                    	var row = rows[i];  
                    	var styleStr = '';
                    	<shiro:lacksPermission name="businessuser_add">
                    	if(params.page == 1 && i % 3 == 0) {
	   	        			styleStr = 'style="margin-left:0;"';
	   	        		}
                    	</shiro:lacksPermission>
                    	<shiro:hasPermission name="businessuser_add">
                    	if(params.page == 1 && i % 3 == 2) {
	                		styleStr = 'style="margin-left:0;"';
	   	        		}
                    	</shiro:hasPermission>
       	        		if(params.page > 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
                    	var state = '';
                    	if(row.state == 0) {
                    		state = '<span class="yggl_relsta cgreen">启用</span>';
    		            }else{
    		            	state = '<span class="yggl_relsta cred">禁用</span>';
    		            }  
                    	var htmlDom = ''
                    		+ '<div class="manbox"'
           	        		+ styleStr
           	        		+ '>'
                    		+ '<a class="nopotr" href="javascript:;">'
           		            + '<div class="info">部门：<span>'+row.depName+'</span><strong style="font-weight:normal; float:right; margin-right:67px;">职业：</strong><em style="font-style:normal; float:right; margin-right:-98px;">'+row.posName+'</em></div>'
           		            + '<time>'+(row.createTime != '' ? row.createTime.substring(0, 16) : '')+'</time>'
           		            + '<hr class="link">'
           		            + '<h2 class="yggl_title"><span class="yggl_poht"><img src="<%=ctx %>'+row.avatar+'" style="width:100%;"></span>'+row.userName+'<br><em>编号'+row.userCode+'</em></h2>'
           		         	+ '<div class="state">'
        		            + state     	
        		            + '</div>'
        		            + '<div class="yggl_text">账号：<span>'+row.userEmail+'</span></div>'
        		            + '<div class="yggl_text">最近登录：<span>'+(row.lastLoginTime != '' ? row.lastLoginTime.substring(0, 16) : '')+'</span></div>'
        		            + '<hr class="link">'
        		            + '<div class="operate">'
        		            <shiro:hasPermission name="businessuser_view_detail">
        		            + '<span class="see s-xw-yfb" title="查看员工详情" onclick="seeWorkerDetail('+row.userId+');"></span>'
        		            </shiro:hasPermission>
        		            <shiro:hasPermission name="businessuser_edit">
        		            + '<span class="edit" title="编辑员工" onclick="window.location.href=\'modify.do?userId='+row.userId+'\' "></span>'
        		            </shiro:hasPermission>
        		            <shiro:hasPermission name="businessuser_delete">
        		            + '<span class="del" title="删除员工" onclick="deleteUser('+row.userId+')"></span>'
        		            </shiro:hasPermission>
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
    
    function seeWorkerDetail(userId) {
    	
	  	$('#userInfoLayer').fadeIn("slow");
	  	$("#userInfoLayer").css("height",$(document.body).outerHeight(true)+'px');
        $("#userInfoBar").css("height",$(document.body).outerHeight(true)-40+'px');
	  
        $.getJSON("getWorkerDetail.do", {userId : userId}, function(data) {
            $('#userName').text(data.userName);//姓名
            $('#posName').text(data.posName);//职位
            $('#lastLoginTime').text(data.lastLoginTime != '' ? data.lastLoginTime.substring(0, 16) : '');//最后登录时间
            $('#userEmail').text(data.userEmail);//员工 邮箱
            $('#userBrief').text(data.userBrief);//个人介绍
            $('#depName').text(data.depName);//部门
            $('#serviceScope').text(data.serviceScope);//服务范围
            $('#auths').text(data.auths);//服务范围
            $('#userCount').text(data.userCount);//服务范围
            $('#userPhoto').attr("src", '<%=ctx%>'+data.avatar);//服务范围
            $('#state').text(data.state == '0'?'启用':'停用');
        });

    }
    
</script>