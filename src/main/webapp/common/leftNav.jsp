<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="com.community.app.module.common.UserMenuBean" %>
<%@ page import="java.util.*" %>
<%@ page import="com.community.app.module.bean.ShiroUser" %>
<%@ page import="com.community.framework.utils.CommonUtils" %>
<html>
<head>
    <title>导航菜单</title>
</head>
<body>
    <!--左导航开始-->
    <div class="navl">
        	<div class="logo"><img src="${ctx}/images/logo.png" style="width:100%;"></div>
        	<div class="msg">
        		<%if(CommonUtils.getUser().getCurOrgType().equals("property") ||CommonUtils.getUser().getOrgType().equals("property") ) {%>
        			物业管理
        			<br /><shiro:principal property="curEstateName"/>
        		<%} %>
        		<%if(CommonUtils.getUser().getCurOrgType().equals("station") ||CommonUtils.getUser().getOrgType().equals("station") ) {%>
        			驿站管理
        			<br /><shiro:principal property="curEstateName"/>
        		<%} %>
        		<%if(CommonUtils.getUser().getCurOrgType().equals("community") ||CommonUtils.getUser().getOrgType().equals("community") ) {%>
        			社区报管理
        			<br /><shiro:principal property="curComName"/>
        		<%} %>
        		<%if(CommonUtils.getUser().getOrgType().equals("operation") 
        				&& (CommonUtils.getUser().getCurOrgType().equals("operation")
        				|| CommonUtils.getUser().getCurOrgType().equals(""))) {%>
        			运营管理
        		<%} %>
        	</div>
        	<ul id="menuLi">
	        	<li class="divider-vertical"></li>
	        	<li class="selected"><a href="<%=ctx %>/index/main.do"><i class="caret nav-1"></i>首页</a></li>
	        	
	        	<%
	        		List menuList = CommonUtils.getUser().getMenuList();
	        		//Collections.sort(menuList);
	        		for(int i=0;i<menuList.size();i++) {
	        			UserMenuBean bean = (UserMenuBean)menuList.get(i);
	        			%>
	        				<li class="divider-vertical"></li>
		            		<li class="selected"><a href="<%=ctx + bean.getMenuPath() %>"><i class="caret <%=bean.getIcon()%>"></i><%=bean.getMenuName() %></a></li>
	        			<%
	        		}
	        	%>
	        	
	        	<%-- <li class="divider-vertical"></li>
		            <li class="selected"><a href="<%=ctx %>/business/businessChinmedichenacare/list.do"><i class="caret nav-2"></i>医疗护理</a></li>
		            <li class="divider-vertical"></li>
		            <li class="selected"><a href="<%=ctx %>/business/businessHealthydiet/list.do"><i class="caret nav-2"></i>健康饮食</a></li> --%>
	        	
	        	<%-- 
	            <shiro:hasAnyRoles name="property, community, station, operation">
		            <li class="divider-vertical"></li>
		            <li class="selected"><a href="<%=ctx %>/business/businessUser/list.do"><i class="caret nav-9"></i>员工</a></li>
	            </shiro:hasAnyRoles>
	            
	            <shiro:hasRole name="community">
		        	<li class="divider-vertical"></li>
		        	<li class="selected"><a href="<%=ctx %>/business/businessNews/list.do"><i class="caret nav-11"></i>新闻</a></li>
	        	</shiro:hasRole>
	        	
	        	<shiro:hasRole name="community">
		        	<li class="divider-vertical"></li>
		        	<li class="selected"><a href="<%=ctx %>/business/businessBreak/list.do"><i class="caret nav-10"></i>爆料</a></li>
	        	</shiro:hasRole>
	        	
	            <shiro:hasRole name="station">
		            <li class="divider-vertical"></li>
		        	<li class="selected"><a href="<%=ctx %>/business/businessExp/list.do"><i class="caret nav-3"></i>快递</a></li>
	        	</shiro:hasRole>
	        	
	            <shiro:hasAnyRoles name="property, station, operation">
		            <li class="divider-vertical"></li>
		            <li class="selected"><a href="<%=ctx %>/business/businessAnno/list.do"><i class="caret nav-2"></i>公告</a></li>
	           </shiro:hasAnyRoles>
	        	
	        	<shiro:hasAnyRoles name="station, community">
		        	<li class="divider-vertical"></li>
		        	<li class="selected"><a href="<%=ctx %>/business/businessProduct/list.do"><i class="caret nav-8"></i>跳蚤市场</a></li>
	        	</shiro:hasAnyRoles>
	            
	             <shiro:hasAnyRoles name="property, station, operation">
		            <li class="divider-vertical"></li>
		            <li class="selected"><a href="<%=ctx %>/business/businessFeedback/list.do"><i class="caret nav-5"></i>反馈</a></li>
	            </shiro:hasAnyRoles>
	            
	            <shiro:hasRole name="property">
		            <li class="divider-vertical"></li>
		            <li class="selected"><a href="<%=ctx %>/business/businessRepair/list.do"><i class="caret nav-14"></i>报修</a></li>
	            </shiro:hasRole>
	        	
	        	<shiro:hasAnyRoles name="station, community">
		        	<li class="divider-vertical"></li>
		        	<li class="selected"><a href="<%=ctx %>/business/businessActivity/list.do"><i class="caret nav-7"></i>活动</a></li>
	        	</shiro:hasAnyRoles>
	            
	            <shiro:hasAnyRoles name="property, operation">
		            <li class="divider-vertical"></li>
		            <li class="selected"><a href="<%=ctx %>/app/appUser/list.do"><i class="caret nav-15"></i>居民</a></li>
	            </shiro:hasAnyRoles>
	          	
	        	<shiro:hasRole name="station">
		        	<li class="divider-vertical"></li>
		        	<li class="selected"><a href="<%=ctx %>/business/businessHelp/list.do"><i class="caret nav-4"></i>求助</a></li>
	        	</shiro:hasRole>
	        	
	        	<shiro:hasAnyRoles name="operation, community">
		        	<li class="divider-vertical"></li>
		        	<li class="selected"><a href="<%=ctx %>/business/businessFocus/list.do"><i class="caret nav-12"></i>焦点图</a></li>
	        	</shiro:hasAnyRoles>
	            
	            <shiro:hasRole name="property">
		            <li class="divider-vertical"></li>
		            <li class="selected"><a href="<%=ctx %>/business/businessChargeAnno/list.do"><i class="caret nav-13"></i>缴费</a></li>
	            </shiro:hasRole>
	        	
	        	<shiro:hasAnyRoles name="station, community">
		        	<li class="divider-vertical"></li>
		        	<li class="selected"><a href="<%=ctx %>/business/businessLife/list.do"><i class="caret nav-6"></i>生活圈</a></li>
	        	</shiro:hasAnyRoles> --%>
	        	
	        	
	        	
	        </ul>
    </div>
    <!--左导航结束-->
</body>
</html>

<script type="text/javascript">
$(function() {
		var url = window.location.pathname;
		if(url.indexOf('businessDepartment') > -1) {
			url = url.replace('businessDepartment', 'businessUser');
		}else if(url.indexOf('businessPosition') > -1) {
			url = url.replace('businessPosition', 'businessUser');
		}
    $('.wrapper .navl').css("min-height", $("body").height());  
    var len = $('#menuLi').find("a[href*='" + url + "']").length;
    if(len == 0) {
    	$('.selected').first().addClass('active');
    }else{
    	$('#menuLi').find("li").removeClass('active');
        $('#menuLi').find("a[href*='" + url + "']").parent().addClass('active');  
    }         
});

</script>