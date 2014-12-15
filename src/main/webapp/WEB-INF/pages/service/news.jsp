<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<title>信息详情</title>
<link href="${ctx }/js/activity/css/style111.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="x-main">
<div class="scroll">
    <div class="x-total" id="content">
        <div class="x-infor">
            <p class="x-xt"><img src="${publisherProtrait}"><span class="x-xdd">${publisherName}</span> <span class="x-xsj"><fmt:formatDate value="${publishTime }" pattern="yyyy-MM-dd HH:mm"/></span></p>
            <div class="x-head">
    	        <a class="x-pto"></a>
                <p class="x-title"><span>${title}</span></p>
            </div>
        </div>
        
        <div class="x-content">
            <div class="x-cx">
                ${newsContent}
            </div>
        </div>
         <c:if test="${download==1 }">
         	<div class="fxdown">
	            <a href="${ctx }/download/index.html?id=12">
	                <i></i>
	                <span>下载OK家APP,了解更多精彩信息</span>
	            </a>    
	        </div></c:if>
    </div>
    
    </div>
</div>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script src="${ctx }/js/jquery.showLoading.min.js"></script>
<script>
 /*function pv_q(u,w,h){
	 var pv='';
	 pv += '<object width="'+w+'" height="'+h+'" classid="clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B" codebase="http://www.apple.com/qtactivex/qtplugin.cab">';
	 pv += '<param name="src" value="'+u+'">';
	 pv += '<param name="controller" value="true">';
	 pv += '<param name="type" value="video/quicktime">';
	 pv += '<param name="autoplay" value="true">';
	 pv += '<param name="target" value="myself">';
	 pv += '<param name="bgcolor" value="black">';
	 pv += '<param name="pluginspage" value="http://www.apple.com/quicktime/download/index.html">';
	 pv += '<embed src="'+u+'" width="'+w+'" height="'+h+'" controller="true" align="middle" bgcolor="black" target="myself" type="video/quicktime" pluginspage="http://www.apple.com/quicktime/download/index.html"></embed>';
	 pv += '</object>';
	 document.write(pv);
 }
 pv_q("http://10.1.17.210:8080/community/app/audio/2014-11-25/bqvoice1416899363213_10.amr", 500, 32);*/
</script>
</body>
</html>
