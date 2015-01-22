<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<title>OK家 ${title}</title>
<link href="${ctx }/js/activity/css/style111.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/showLoading.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id='wx_logo' style='margin:0 auto;display:none;'>
<img src='${ctx }${appPic}' width="400px" height="400px"/>
</div>
<div class="x-main">
    <div class="x-news">
        <div class="x-infor">
            <p class="x-xt"><span class="x-xdd">${publisherName}</span> <span class="x-xsj"><fmt:formatDate value="${publishTime }" pattern="yyyy-MM-dd HH:mm"/></span></p>
            <hr class="x-line">
            <div class="x-head">
    	        <a class="x-pto"><img src="${ctx }/js/activity/images/tx.jpg"></a>
                <p class="x-title"><span>${title}</span></p>
            </div>
        </div>
        <div class="x-content">
            <div class="x-cx">
                ${newsContent}
            </div>
        </div>
    </div>
</div>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script src="${ctx }/js/activity/js/script.js"></script>
<script src="${ctx }/js/jquery.showLoading.min.js"></script>
<script>
/*赞*/
$(document).ready(function(){
		
 });
 
</script>
</body>
</html>
