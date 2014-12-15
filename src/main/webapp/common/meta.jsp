<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.community.framework.utils.CommonUtils" %>
<%@ page import="com.community.app.module.bean.ShiroUser" %>
<%@ page import="org.apache.shiro.SecurityUtils"%>
<%@ page import="org.apache.shiro.subject.Subject"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	//ShiroUser shiroUser = (ShiroUser)session.getAttribute("shiroUser");
	ShiroUser shiroUser = CommonUtils.getUser();
	Subject currentUser = SecurityUtils.getSubject();
	System.out.println("shiroUser    "+shiroUser + "auth   "+currentUser.isAuthenticated());
	if(shiroUser == null || !currentUser.isAuthenticated()) {
		response.sendRedirect(ctx+"/index/logout.do");
	}	 
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<input type="hidden" name="path" value="${ctx}">
<script type="text/javascript">
    var path = '${ctx}';
</script>
<meta charset="utf-8">

<title>首页</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="<%=ctx%>/css/style.css" >
<!--[if IE 7]> <link rel="stylesheet" type="text/css" href="css/ie7.css" /> <![endif]-->
<%-- 
<link rel="stylesheet" type="text/css" href="<%=ctx%>/css/adaptive1440-900.css" >
<link rel="stylesheet" type="text/css" href="<%=ctx%>/css/adaptive-2.css" > 
--%>
<script src="<%=ctx%>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
<%-- <script src="<%=ctx%>/js/coveragelayer.js" type="text/javascript"></script> --%>
<%--<script src="<%=ctx%>/js/jquery.kinMaxShow-1.0.min.js" type="text/javascript"></script>--%><%--注释原因：没有用到--%>
<script>
$(function(){
	//全局的ajax访问，处理ajax清求时sesion超时  
	$.ajaxSetup({   
	    contentType:"application/x-www-form-urlencoded;charset=utf-8",   
	    complete:function(XMLHttpRequest,textStatus){   
	            var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
	            if(sessionstatus=="timeout"){   
	            	window.location.replace("<%=ctx%>/index/logout.do");
	             }   
	    }   
	  });  
})

</script>


