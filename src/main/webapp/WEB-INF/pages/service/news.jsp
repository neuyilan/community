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
</head>

<body>
<div id='wx_logo' style='margin:0 auto;display:none;'>
<img src='${ctx }${appPic}' width="400px" height="400px"/>
</div>

<div class="x-main">
<div class="scroll">
    <div class="x-news" id="content">
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
	                <img src="${ctx }/images/click.png"/>
	            </a>    
	        </div>
	      </c:if>
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
 var imgUrl = '${ctx }${appPic}';  
 var lineLink = '${ctx }/service/commiunity/getJournalismDetailsById.json?userId=${userId}&ID=${newsId}&download=1';  
 var descContent = "${title}";  
 var shareTitle = '【OK家】小区生活 OK到家';  
 var appid = '';  
   
 function shareFriend() {  
     WeixinJSBridge.invoke('sendAppMessage',{  
                             "appid": appid,  
                             "img_url": imgUrl,  
                             "img_width": "640",  
                             "img_height": "640",  
                             "link": lineLink,  
                             "desc": descContent,  
                             "title": shareTitle  
                             }, function(res) {  
                             _report('send_msg', res.err_msg);  
                             })  
 }  
 function shareTimeline() {  
     WeixinJSBridge.invoke('shareTimeline',{  
                             "img_url": imgUrl,  
                             "img_width": "640",  
                             "img_height": "640",  
                             "link": lineLink,  
                             "desc": descContent,  
                             "title": "【OK家】"+descContent  
                             }, function(res) {  
                             _report('timeline', res.err_msg);  
                             });  
 }  
 function shareWeibo() {  
     WeixinJSBridge.invoke('shareWeibo',{  
                             "content": descContent,  
                             "url": lineLink,  
                             }, function(res) {  
                             _report('weibo', res.err_msg);  
                             });  
 }  
 // 当微信内置浏览器完成内部初始化后会触发WeixinJSBridgeReady事件。  
 document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {  
   
         // 发送给好友  
         WeixinJSBridge.on('menu:share:appmessage', function(argv){  
             shareFriend();  
             });  
   
         // 分享到朋友圈  
         WeixinJSBridge.on('menu:share:timeline', function(argv){  
             shareTimeline();  
             });  
   
         // 分享到微博  
         WeixinJSBridge.on('menu:share:weibo', function(argv){  
             shareWeibo();  
             });  
         }, false);  
</script>
</body>
</html>
