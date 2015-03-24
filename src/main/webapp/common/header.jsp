<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="com.community.framework.utils.CommonUtils" %>
<%@ page import="java.util.*" %>
<%@ page import="com.community.app.module.common.*" %>
<%@ page import="com.community.app.module.bean.ShiroUser" %>

<%
	// ShiroUser shiroUser = CommonUtils.getUser();
%>
<html>
<head>
    <title>导航菜单</title>
    <script type="text/javascript">
        var popUpWin = 0;
        function PopUpWindow(URLStr, left, top, width, height, newWin, scrollbars) {
            if (typeof (newWin) == "undefined")
                newWin = false;

            if (typeof (left) == "undefined")
                left = 100;

            if (typeof (top) == "undefined")
                top = 0;

            if (typeof (width) == "undefined")
                width = 800;

            if (typeof (height) == "undefined")
                height = 760;

            if (newWin) {
                open(URLStr, '', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=' + scrollbars + ',resizable=yes,copyhistory=yes,width=' + width + ',height=' + height + ',left=' + left + ', top=' + top + ',screenX=' + left + ',screenY=' + top + '');
                return;
            }

            if (typeof (scrollbars) == "undefined") {
                scrollbars = 0;
            }

            if (popUpWin) {
                if (!popUpWin.closed) popUpWin.close();
            }
            popUpWin = open(URLStr, 'popUpWin', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=' + scrollbars + ',resizable=yes,copyhistory=yes,width=' + width + ',height=' + height + ',left=' + left + ', top=' + top + ',screenX=' + left + ',screenY=' + top + '');
            popUpWin.focus();
        }
    </script>
</head>
<body>

<div class="header">
	<div class="status">
		<div>欢迎你：<span class="name"><shiro:principal property="userName"/></span><span class="dpm"><shiro:principal property="posName"/></span></div>
		<div>上次登录时间：<time><shiro:principal property="lastLoginTime"/></time></div>
	</div>
	<div class="submenu">
          <span class="rfloat">
				<!-- <shiro:hasRole name="operation"> -->
				<%-- <%if(CommonUtils.getUser().getOrgType().equals("operation")) {%>
					<a href="javascript:;" onclick="$('#bizChgLayer').fadeIn('slow');">业务切换</a>
				<%} %> --%>
				<!-- </shiro:hasRole> -->
				<%-- <%if(CommonUtils.getUser().getCurOrgType().equals("property") ||CommonUtils.getUser().getOrgType().equals("property") ) {%> --%>
	        		<%if(shiroUser.getIsEstate() == 0) {%>
	        		<a href="javascript:;" onclick="$('#estateChgLayer').fadeIn('slow');">小区切换</a>
	        		<%} %>
	        		<%if(shiroUser.getIsCom() == 0) {%>
	        		<a href="javascript:;" onclick="$('#communityChgLayer').fadeIn('slow');">社区切换</a>
	        		<%} %>
	        	<%-- <%} %>	 --%>
	        	<!-- <shiro:hasAnyRoles name="community, operation"> -->
	        	<%-- <%if(CommonUtils.getUser().getCurOrgType().equals("community") ||CommonUtils.getUser().getOrgType().equals("community") ) {%> --%>
	        		
	        	<%-- <%} %>	 --%>
	        	<!-- </shiro:hasAnyRoles> -->
	        	<!-- <shiro:hasAnyRoles name="station, operation"> -->
	        	<%-- <%if(CommonUtils.getUser().getCurOrgType().equals("station") ||CommonUtils.getUser().getOrgType().equals("station") ) {%>
	        		<a href="javascript:;" onclick="$('#stationChgLayer').fadeIn('slow');">驿站切换</a>
	        	<%} %> --%>	
	        	<!-- </shiro:hasAnyRoles> -->
	        	<a href="javascript:;" id="showCountLayer">账号管理</a>
		  </span>
	</div>       
</div>
        
<div id="countLayer" class="busswi3">
    <div id="countBar" class="sidebar3">
        <a id="close3" href="javascript:;"  onclick="$('#countLayer').fadeOut('slow');"></a>
        <h2 class="tit3">账号操作</h2>
        <!--<hr class="link3">-->
        <div>
        	<span style="margin-left:15px;">
            	<%-- <a href="javascript:void(0);" onclick="javascript:PopUpWindow('<%=ctx %>/common/uploadimage.jsp',100,100,600,500);"><img alt="修改头像" src="<%=ctx %><%=shiroUser.getAvatar() %>" width="100" height="100"/></a> --%>
            	<img alt="修改头像" src="<%=ctx %><%=shiroUser.getAvatar() %>" width="100" height="100"/>
            </span>
            <span>
	            <ul class="accordion3">
	            	<li id="one2" class="files">
	                    <a href="<%=ctx %>/business/businessUser/modifySelfInfo.do?userId=<%=shiroUser.getUserId() %>">修改资料</a>
	                </li>
	                <li id="one2" class="files">
	                    <a href="<%=ctx %>/index/getBusinessUserInfo.do">修改密码</a>
	                </li>
	                <li id="one2" class="files">
	                    <shiro:user><a href="<%=ctx %>/index/logout.do">退出登录</a></shiro:user>
	                </li>
	            </ul>
            </span>
        </div>
    </div>
</div>

<!-- <shiro:hasRole name="operation"> -->
<!-- 业务切换开始 -->
<%-- <%if(CommonUtils.getUser().getOrgType().equals("operation")) {%>
<div id="bizChgLayer" class="busswi y-fbes-jm">
	<div  id="bizChgBar"  class="sidebar y-fbes-jms" style="width:300px;">
    	<a class="close" href="javascript:;" onclick="$('#bizChgLayer').fadeOut('slow');"></a>
    	<h2 class="tit">业务切换</h2>
        <div id="wrapper-250">
	          <ul class="accordion5">
	          		<li id="one2" class="files">
	                    <a href="javascript:pathChange('<%=ctx%>/index/businessChange.do?orgType=property');">物业管理</a>
	                </li>
	                <li id="two2" class="mail">
	                    <a href="javascript:pathChange('<%=ctx%>/index/businessChange.do?orgType=station');">驿站管理</a>
	                </li>
	                <li id="two2" class="mail">
	                    <a href="javascript:pathChange('<%=ctx%>/index/businessChange.do?orgType=community');">社区报管理</a>
	                </li>
	                <li id="two2" class="mail">
	                    <a href="javascript:pathChange('<%=ctx%>/index/businessChange.do?orgType=operation');">运营管理</a>
	                </li>
	          </ul>
        </div>
    </div>
</div>
<%} %> --%>
<!-- 业务切换结束 -->
<!-- </shiro:hasRole> -->

<!-- 社区切换开始 -->

<div id="communityChgLayer" class="busswi y-fbes-jm">
	<div  id="communityChgBar"  class="sidebar y-fbes-jms" style="width:300px;">
    	<a class="close" href="javascript:;" onclick="$('#communityChgLayer').fadeOut('slow');"></a>
    	<h2 class="tit">社区切换</h2>
        <div id="wrapper-250">
	          <ul class="accordion5">
	          		<li id="one2" class="files">
	                    <a href="javascript:pathChange('<%=ctx%>/index/communityChange.do?comId=0');">全部社区</a>
	                </li>
	          	<%
	          	  	List comList = CommonUtils.getUser().getComList();
	          	  	for(int i=0;i<comList.size();i++) {
	          	  		CommunityBean communityBean = (CommunityBean)comList.get(i);
	          	  		%>
	          		<li id="one2" class="files">
	                    <a href="javascript:pathChange('<%=ctx%>/index/communityChange.do?comId=<%=communityBean.getComId()%>');"><%=communityBean.getComName() %></a>
	                </li>
	                <%
	          	  	}
	          	  	%>
	          </ul>
        </div>
    </div>
</div>

<!-- 社区切换结束 -->


<!-- <shiro:hasAnyRoles name="station, operation"> -->
<!-- 驿站切换开始 -->
<%-- <%if(CommonUtils.getUser().getCurOrgType().equals("station") ||CommonUtils.getUser().getOrgType().equals("station") ) {%>
<div id="stationChgLayer" class="busswi y-fbes-jm">
	<div  id="stationChgBar"  class="sidebar y-fbes-jms" style="width:300px;">
    	<a class="close" href="javascript:;" onclick="$('#stationChgLayer').fadeOut('slow');"></a>
    	<h2 class="tit">驿站切换</h2>
        <div id="wrapper-250">
	          <ul class="accordion5">
	          		<li id="one2" class="files">
	                    	<a href="javascript:pathChange('<%=ctx%>/index/estateChange.do?estateId=0');">全部小区</a>
	                	</li>
	          	  	<%
	          	  	List estateBeanList = CommonUtils.getUser().getEstateBeanList();
	          	  	for(int j=0;j<estateBeanList.size();j++) {
	          	  		EstateBean estateBean = (EstateBean)estateBeanList.get(j);
	          	  		%>
	          	  		<li id="one2" class="files">
	                    	<a href="javascript:pathChange('<%=ctx%>/index/estateChange.do?estateId=<%=estateBean.getEstateId()%>');"><%=estateBean.getEstateName() %></a>
	                	</li>
	          	  		<%
	          	  	}
	          	  	%>
	          </ul>
        </div>
    </div>
</div>
<%} %> --%>
<!-- 驿站切换结束 -->
<!-- </shiro:hasAnyRoles> -->

<!-- 小区切换开始 -->
<%-- <%if(CommonUtils.getUser().getCurOrgType().equals("property") ||CommonUtils.getUser().getOrgType().equals("property") ) {%> --%>
<div id="estateChgLayer" class="busswi y-fbes-jm">
	<div  id="estateChgBar"  class="sidebar y-fbes-jms" style="width:300px;">
    	<a class="close" href="javascript:;" onclick="$('#estateChgLayer').fadeOut('slow');"></a>
    	<h2 class="tit">小区切换</h2>
        <div id="wrapper-250">
	          <ul class="accordion5">
	          		<li id="one2" class="files">
	                    	<a href="javascript:pathChange('<%=ctx%>/index/estateChange.do?estateId=0');">全部小区</a>
	                	</li>
	          	  	<%
	          	  	List estateBeanList = CommonUtils.getUser().getEstateBeanList();
	          	  	for(int j=0;j<estateBeanList.size();j++) {
	          	  		EstateBean estateBean = (EstateBean)estateBeanList.get(j);
	          	  		%>
	          	  		<li id="one2" class="files">
	                    	<a href="javascript:pathChange('<%=ctx%>/index/estateChange.do?estateId=<%=estateBean.getEstateId()%>');"><%=estateBean.getEstateName() %></a>
	                	</li>
	          	  		<%
	          	  	}
	          	  	%>
	          </ul>
        </div>
    </div>
</div>
<%-- <%} %> --%>
<!-- 小区切换结束 -->

</body>
</html>
<script>
$(function() {
	//显示用户级别层
	$("#showCountLayer").click(function(){
	    $("#countLayer").fadeIn("slow");
	    $("#countLayer").css("height",$(document.body).outerHeight(true)+'px');
	    $("#countBar").css("height",$(document.body).outerHeight(true)-40+'px');
	});

	//关闭用户级别层
	$('#closeCountLayer').click(function() {
	    $("#countLayer").fadeOut("slow");
	});

	//取消选择用户级别
	$('#countLayerCancel').click(function() {
	    $("#countLayer").fadeOut("slow");
	});
});

//路径切换
function pathChange(path) {
	window.location.href = path+'&jump='+window.location.href;
}
</script>