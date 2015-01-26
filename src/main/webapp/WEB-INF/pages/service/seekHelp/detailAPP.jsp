<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>小区开聊详情</title> 
<link href="${ctx }/js/activity/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/showLoading.css" rel="stylesheet" type="text/css" /> 
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
</head>

<body>
    <div class="kl-total">
    <div style="background-color: #fff;padding: 0 16px;">
       <input type="hidden" id="supTmp" value="">
       <input type="hidden" id="noZan" value="N">
        <p class="kl-head">
            <img src="${ctx }/${businessHelp.portrait}"/>
            <span class="kl-name">${businessHelp.helperName}</span>
            <span class="kl-time"><fmt:formatDate value="${businessHelp.helpTime }" pattern="yyyy-MM-dd HH:mm"/></span> 
        </p>
        <div id="conents"  style="margin:10px 0; line-height:22px;padding-bottom:15px;">
        </div>
    </div>
</div>
    
<script src="${ctx}/js/activity/js/jquery-2.1.1.min.js"></script>
<%-- <script src="${ctx}/js/jquery.showLoading.min.js"></script> --%>
     
<script>
/*赞*/
 var userId = '${userId}';//登录用户头像地址
 var protrait = '${protrait}';//登录用户头像地址
 var nickname = '${nickname}';//登录用户名称
 var replyId = 0;//点击回复人id
 var replyName ="";//点击回复人姓名
 var replyType =0;//点击回复人类型
 var publisherId = '${businessHelp.helperId}';
 var page = 0 ;//当前页面
 var PageState=false;//是否有下一页
 var screenHeight=document.documentElement.clientHeight;
 var dianZan=0;   //点赞次数
//  $('.kl-z em').text('${businessHelp.supports}'); 

$('#supports').text('${businessHelp.supports}'); 
 $("#supTmp").val('${businessHelp.supports}');
 
 //$('.kl-z em'). 
 var contents = '${businessHelp.helpContent}';
 var pics  = '${businessHelp.pics}';
 var imgs = new Array(); 
 if (pics != null && pics != '') 
{
	 imgs = pics.split(",");
	 for (var i=0;i<imgs.length ;i++ )
	 { 
		 contents += '<br/><img src="${ctx}/'+imgs[i]+'"/>'; 
	 }
} 

 $('#conents').append(contents);
//  alert($("#supTmp").attr("value"));   
 if("${ctx}"==protrait){
	 protrait = '${ctx}/images/morentouxiang.png';
}
 if(nickname==""){
	 nickname = '匿名';
}

</script>
</body>
</html>
