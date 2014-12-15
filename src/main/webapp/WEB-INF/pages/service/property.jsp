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
<link href="${ctx }/css/showLoading.css" rel="stylesheet" type="text/css" />
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
	            <a href="${ctx }/download/index.html?id=14">
	                <i></i>
	                <span>下载OK家APP,了解更多精彩信息</span>
	            </a>    
	        </div>
		</c:if>
    </div>
    </div>
</div>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script src="${ctx }/js/jquery.showLoading.min.js"></script>
<script>
/*赞*/
function msgbox(title,content){
	 var shtml="<div class='tk'><div class='tcontent'><div class='thead'>";
	 shtml+="<p>"+content+"</p>";
	 shtml +="</div>";
	  shtml += "<div class='tbtn'><p>确定</p></div>";
	 shtml += "</div>";
	 $("body").append(shtml);
	 $(".tbtn p").click(function(e) {
		    $(".tk").remove();
	});
}
</script>
</body>
</html>
