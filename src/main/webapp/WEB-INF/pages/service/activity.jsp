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
<link href="${ctx }/js/activity/css/activityRegistrationStyle.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/showLoading.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id='wx_logo' style='margin:0 auto;display:none;'>
<img src='${ctx }${appPic}' width="400px" height="400px"/>
</div>
<div id="bodyDiv" class="x-main">
<div class="scroll">
    <div class="x-total">
        <div class="x-content">
            <div class="x-cx">
               <p>${actContent}</p>
            </div>
            <hr/>
            <div class="x-zs">
            <input type="hidden" name="ID" id="ID" value="${ID }" />
            <input type="hidden" name="rank" id="rank" value="${rank }" />
             <input type="hidden" name="replyId" id="replyId" value="" />
             <input type="hidden" name="state" id="state" value="${state }" />
             <input type="hidden" name="replyName" id="replyName" value="" />
            <input type="hidden" name="startTime" id="startTime" value="${startTime }" />
            <input type="hidden" name="endTime" id="endTime" value="${endTime }" />
            <input type="hidden" name="endTime" id="dateTime" value="${dateTime }" />
            <input type="hidden" name="time" id="dateTime" value="${dateTime}" />
            	
            	<a class="x-btn x-djs">
            		<span id="tpli_counter"></span>
            	</a>
                <a class="x-btn x-qg">
                	<span>立即开抢</span>
                </a>
                <a class="x-btn x-pm" id="seeRank">
                	<span>您当前的排名<i id="x-pmw"></i>位</span>
                </a>
                
                <!-- 点赞 -->
                <span class="x-z">
                    <a><img src="${ctx }/js/activity/images/zk.png" width="19" height="19"></a>
                    <em>${supports}</em>
                </span>
                
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
    <div class="x-total x-pl">
        <p class="x-pc">全部评论(<span id="commentsCount">${comments }</span>)</p>
        <div id="pos"></div>
        <a href="#pos" id="anchor_scroll"></a>
        <div id="comments">
        </div>
        <hr style="border: 1px solid #e8e8e8; margin:10px -10px;">
        <a class="more" id="nextBtn"><span id="curr">点击获取更多</span></a>
    </div>
    </div>
    <div class="x-inp">
       <div>
           <span>
  			<div style=" position:relative;">
           <input type="text"   name="comment" class="x-inc" id="comment" style=" position:absolute;top:0px; left:0; z-index:2;">
           <input type="text" placeholder="回复:" style="height: 32px; left: 0;padding-left: 40px;position: absolute;top:0px;width: 100%;z-index: 1;border:none;padding-top:2px;" id="replaceinp">
 			 </div>
           </span>
           <span><input id="commentBtn" type="button" value="发送"></span>
        </div>
    </div>
</div>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script src="${ctx }/js/activity/js/script.js"></script>
<script src="${ctx }/js/jquery.showLoading.min.js"></script>
</body>
</html>

<script>
var userId = '${userId}';//登录用户头像地址
var protrait = '${protrait}';//登录用户头像地址
var nickname = '${nickname}';//登录用户名称
var nickname1 = '${nickname}';//登录用户名称
var replyId = 0;//点击回复人id
var replyName ="";//点击回复人姓名
var replyType =0;//点击回复人类型
var page = 0 ;//当前页面
var PageState=false;//是否有下一页
if("${ctx}"==protrait){
	 protrait = '${ctx}/images/morentouxiang.png';
}
if(nickname==""){
	 nickname = '匿名';
}
$(document).ready(function(){
	//初始化展示状态
	var currRank = $('#rank').val();
	var currState = $('#state').val();
	//alert('currRank  '+currRank+' currState  '+currState);
		if(currState == 1) { //未开始
			$(".x-qg").css("display","none");//已结束
			$(".x-djs").css("display","block");//倒计时
			$(".x-pm").css("display","none");//排名
		}else if(currState == 0) {//已开始 抢票中
			if(currRank == 0) {//未投票
				$(".x-qg").css("display","block");//立即抢购
				$(".x-djs").css("display","none");//倒计时
				$(".x-pm").css("display","none");//排名
			}else{//已投票
				$(".x-qg").css("display","none");//已结束
				$(".x-djs").css("display","none");//倒计时
				$('.x-pm').html("<span>查看排名</span>");
				$(".x-pm").css("display","block");//排名
			}
		}else if(currState == 2) {//已结束
			if(currRank == 0) {//未投票
				//$(".x-djs").css("display","none");//倒计时
				//$(".x-pm").css("display","none");//排名
				//$(".x-djs").html("已结束")
				$('.x-pm').html("<span>查看排名</span>");
				$(".x-djs").css("display","none");
				$(".x-qg").css("display","none");
				$(".x-pm").css("display","block");
			}else{//已投票
				$('.x-pm').html("<span>查看排名</span>");
				$(".x-djs").css("display","none");
				$(".x-qg").css("display","none");
				$(".x-pm").css("display","block");
			}
		}      
	
	//参加活动
	$(".x-qg").click(function(e) {
		if(userId==0){
			if(window.confirm('为了确保您正常参与活动，请您填写相关信息。')){
				 window.location.href='${phpIp}/wxokjia/reggoin.php';
                //alert("确定");
                return null;
             }else{
                //alert("取消");
                return null;
            }
		}
		if(nickname1=="" || nickname1==" "){
			 msgbox('提示','抱歉，您需要去“个人中心”给自己起个昵称再来抢哦！','确认');
			 
			return;	
		}
		/* $(".x-qg").css("display","none");
	     $(".x-pm").css("display","block");
		$('#bodyDiv').showLoading();
         $(".x-qg").css("display","none");
	     $(".x-pm").css("display","block");*/
	     $.ajax({
	           url: '${ctx}/service/activities/participateActivites.json',
	           cache: false,
	           type: 'post',
	           dataType: 'json',
	           data: {
	           	ID: '${actId}',
	           	sessionid: '${sessionid}', 
	           	userId: '${userId}'
	           },
	           success: function (data) {
	        	   if(data.errorCode == '200') {
	        		    $("#seeRank").click();
						/*msgbox('提示',data.message);
						$(".x-djs").css("display","none");
						$(".x-pm").css("display","block");
						$(".x-qg").css("display","none");
						$(".x-pm").html("<span>您当前的排名<i id='x-pmw'>"+data.content.rank+"</i>位</span>");
						//$('#x-pmw').text(data.content.rank);
						$('#bodyDiv').hideLoading();*/
	        	   }else{
	        		   msgbox('提示',data.message,'确认');
	        		   
	        	   }
	           },
	           error: function() {
	               msgbox('提示','参与失败','确认');
	               
	               
	           }
	       });
     });
	
	//查看排名
	$("#seeRank").click(function(e) {
		window.location.href='${ctx}/service/activities/ranking.json?userId='+userId+"&ID="+"${ID}&ranks=${ranks}";
     });
	
	
	
	
	 $("#content").click(function(){
		 replyId = 0;//点击回复人id
		 replyName = "";//点击回复人姓名
		 replyType = 0;//点击回复人类型
		 $("#replaceinp").attr("placeholder","回复:");
	 });
	//点赞
	 $('.x-z a').click(function(){
		 /*if(userId==0){
				if(window.confirm('请您填写相关信息。')){
					 window.location.href='${phpIp}/wxokjia/reggoin.php';
	                //alert("确定");
	                return null;
	             }else{
	                //alert("取消");
	                return null;
	            }
			}*/
	 	$.ajax({
           url: '${ctx}/service/activities/supportActivities.json',
           cache: false,
           type: 'post',
           dataType: 'json',
           data: {
           	ID: '${ID}',
           	sessionid: '${sessionid}', 
           	userId: '${userId}'
           },
           success: function (data) {
        	   //eval('data=' + data);
        	   if(data.errorCode == 200) {
        		   $('.x-z a').unbind("click");
	       		    $('.x-z a').click(function(){
	       		    	msgbox('提示','已赞过了，再赞他会骄傲的…','确认');
	       		    });
        		   $('.x-z a').append('<em class="x-add">+1</em>');
					$('.x-z img').attr("src","${ctx }/js/activity/images/ze.png");
					$('.x-z em').css("color","#fd8b07");
			        $('.x-add').css({'position':'absolute', 'color':'#fd8b07','left':'0px','top':'0px'}).animate({top:'-30px',left:'0px'},'slow',function(){
			        $(this).fadeIn('fast').remove();
			        var Num = parseInt($('.x-z em').text());
			        Num++;
			        $('.x-z em').text(Num);
					$('.x-z img').attr("src","${ctx }/js/activity/images/zk.png");
					$('.x-z em').css("color","#030303");
			        });
			        //alert(data.message);
        	   }else{
        		   msgbox('提示',data.message,'确认');
        		   
        	   }
           },
           error: function() {
               msgbox('提示','评论失败','确认');
               
           }
       });
	 });
	
	//评论
	 $('#commentBtn').click(function() {
		 if(userId==0){
				if(window.confirm('为了确保您的信息正常发布，请您填写相关信息。')){
					 window.location.href='${phpIp}/wxokjia/reggoin.php';
	                //alert("确定");
	                return null;
	             }else{
	                //alert("取消");
	                return null;
	            }
			}
	 	var content = $('#comment').val();
	 	var reg=/^[\w\u4e00-\u9fa5`~!@#$%^&*()+=|{}':;,\t\r\n\s\[\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？～《》]+$/;
		if(!reg.test(content)){
			 msgbox('提示','不支持表情图片，您只能输入文字、数字、英文','确认');
			 
			return;
		}
	 	var url="";
	 	if(replyId==0){
	 		url = '${ctx}/service/activities/saveActivitiesReview.json';
	 	}else{
	 		url = '${ctx}/service/activities/saveActivitiesReply.json';
	 	}
	 	if(content != '') {
	 		$.ajax({
	 		    url: url,
	 		    cache: false,
	 		    data: {
	 		    	ID: '${ID}',
		           	sessionid: '${sessionid}', 
		           	userId: '${userId}',
		           	replyId:replyId ,
		           	replyName:replyName,
	 		    	content: content,
	 		    	replyType:replyType
	 		    },
	 		    type: 'post',
	            dataType: 'json',
	 		    success: function (data) {
	 		    	//alert('评论成功');
	 		    	//eval('data=' + data);
	 		    	//$('#comment').attr('disabled', true);
	 		    	/*var newContent = '';
	 		    	newContent+= '<dl class="s-clt">';
	 		    	newContent+= '<dt>';
	 		    	newContent+='<a href="#" class="pto"><img src="'+protrait+'"></a>';
	 		    	newContent+= '</dt>';
	 		    	newContent+= '<dd>';
	 		    	newContent+= '<div class="info">';
	 		    	newContent+= '<span class="nine">'+nickname+'</span>';
	 		    	newContent+= '<span class="time">'+(data.content.commentTime != '' ? data.content.commentTime.substring(0, 16) : '')+'</span>'
	 		    	newContent+= '</div>'
	 		    	if(replyId==0){
	 		    		newContent+= '<div class="one">'+data.content.content+'</div>'
	 		    	}else{
	 		    		if(replyType==1){
	 		    			newContent+= '<div class="one">'+ '<span <span>回复</sapn>' +'<span>'+replyName+'(官方):</span>' +data.content.content+'</div>'
	 		    		}else{
	 		    			newContent+= '<div class="one">'+ '<span <span>回复</sapn>' +'<span>'+replyName+':</span>' +data.content.content+'</div>'
	 		    		}
	 		    		
	 		    	}
	 		    	newContent+='</dd>'
	 		    	newContent+='</dl>';
	 				$('#comments').prepend(newContent);*/
	 				$('#comment').val("");
	 				$('#replaceinp').val("");
	 				replyId = 0;//点击回复人id
	 				replyName = "";//点击回复人姓名
	 				replyType = 0;//点击回复人类型
	 				$("#replaceinp").attr("placeholder","回复："+replyName);
	 				$("#commentsCount").text(data.content.comments);
	 				$('#comments').html("");
	 				jump(1);
	 				
	 			 	document.getElementById("anchor_scroll").click();
	 		    },
	 		    error: function () {
	 		       msgbox('提示','评论失败','确认');
	 		      
	 		    }
	 		});
	 	}else{
	 		 msgbox('提示','评论不能为空','确认');
	 		
	 		return;
	 	}
	 	$("#replaceinp").attr("placeholder","回复:");
	 });
	
	$('#nextBtn').click(function() {
	 	if(PageState) {
	 		page++;
	 		jump(page);
	 		return;
	 	}else{
	 		$('#curr').text('亲已经到底了');
	 		$('#nextBtn').attr('disabled', true);
	 		return;
	 	}
	});
	page++;
	jump(page);
	document.onkeydown = function(e){    
	    var ev = document.all ? window.event : e;  
	    if(ev.keyCode==13) {// 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
	        //要处理的事件  
	        $('#commentBtn').click();
	    }  
	  }  
	 //firefox下检测状态改变只能用oninput,且需要用addEventListener来注册事件。 
	 if(/msie/i.test(navigator.userAgent))    //ie浏览器 
	 {document.getElementById('replaceinp').onpropertychange=handle 
	 } 
	 else 
	 {//非ie浏览器，比如Firefox 
	 document.getElementById('comment').addEventListener("input",handle,false); 
	 } 
});

//当状态改变的时候执行的函数 
function handle() {
	//document.getElementById('msg').innerHTML='输入的文字长度为：'+document.getElementById('txt').value.length; 
	$("#replaceinp").val(" ");
	if($("#comment").val().length==0){
		$("#replaceinp").val("");
		$("#replaceinp").attr("placeholder","回复："+replyName);
	}
	/*if(document.getElementById('replaceinp').value.length>0){
		$("#comment").val($("#replaceinp").val());
		$("#replaceinp").attr("value","");
		$("#comment").focus();
	}*/

	
} 

//获取下页评论内容
function jump(nextNo) {
	$.ajax({
	    url: '${ctx}/service/activities/getActivitiesReviewById.json',
	    cache: false,
	    type: 'post',
        dataType: 'json',
	    data: {
	    	ID: '${ID}',
           	sessionid: '${sessionid}', 
           	userId: '${userId}',
	    	page: page
	    },
	    success: function (data) {
	    	//eval('data=' + data);
	    	PageState=data.content.PageState;
            var rows = data.content.reviewList;
            
            if(rows.length==0 && nextNo==1){
            	$('#curr').text('目前没有评论信息');
    	 		$('#nextBtn').attr('disabled', true);
            }else if(!PageState){
    	 		$('#nextBtn').hide();
            }
            
            if(rows.length==0 && nextNo==1){
            	$('#curr').text('目前没有评论信息');
    	 		$('#nextBtn').attr('disabled', true);
            }else if(!PageState){
    	 		$('#nextBtn').hide();
            }
            	
            
            if(rows.length > 0) {
            	for(var i=0;i<rows.length;i++) {
            		var row = rows[i];   
            		var newContent = '';
            		newContent+= '<dl class="s-clt">';
            		newContent+= '<dt>';
            		if("${ctx}"==row.avatar){
            			newContent+= '<span class="pto"><img src="${ctx }/images/morentouxiang.png"></span>';
            		}else{
            			newContent+= '<span class="pto"><img src="'+row.avatar+'" onerror="this.onerror=null; this.src=\'${ctx }/images/morentouxiang.png\'"></span>';
            		}
            		newContent+= '</dt>';
            		newContent+= '<dd>';
            		newContent+='<div class="info">';
       				if(row.name=="" || row.name==null){
       					if(row.userType==1){
       						newContent+= '<span class="nine">匿名(官方)</span>';
       					}else{
       						newContent+= '<span class="nine">匿名</span>';
       					}
       				}else{
       					if(row.userType==1){
       						newContent+= '<span class="nine">'+row.name+'(官方)</span>';
       					}else{
       						newContent+= '<span class="nine">'+row.name+'</span>';
       					}
       				}
        			newContent+='<span class="time">'+row.commentTime+'</span>';
        			newContent+= '</div>';
        			if(row.replyId==0){
        				newContent+= '<div class="one">'+row.content+'</div>';
        			}else{
        				if(row.replyType==1){
        					newContent+= '<div class="one">'+ '<span>回复</sapn>' +'<span>'+row.replyName+'(官方):</span>' +row.content+'</div>';
        				}else{
        					newContent+= '<div class="one">'+ '<span>回复</sapn>' +'<span>'+row.replyName+':</span>' +row.content+'</div>';
        				}
        			}
        			newContent+='</dd>';
        			newContent+='</dl>';
        			var div = $("<div></div>");
        			div.append(newContent);
        			$('#comments').append(div);
        			if(row.userId!=userId){
        				div.find("img").attr("replyId",row.userId);
        				if(row.name=="" || row.name==null){
        					div.find("img").attr("replyName","匿名");
        				}else{
        					div.find("img").attr("replyName",row.name);
        				}
        				div.find("img").attr("replyType",row.userType);
            			div.find("img").click(function(){
            				replyId = $(this).attr("replyId");//点击回复人id
            				replyName = $(this).attr("replyName");//点击回复人姓名
            				replyType = $(this).attr("replyType");//点击回复人类型
            				$("#replaceinp").attr("placeholder","回复："+replyName);
            				$("#comment").focus();
            			});
            			div.find("dd").click(function(){
              				 replyId = 0;//点击回复人id
              				 replyName = "";//点击回复人姓名
              				 $("#replaceinp").attr("placeholder","回复:");
              			 });
            			
        			}else{
            			div.find("img").click(function(){
          					msgbox('提示',"您不能自己回复自己",'确认');
          					
              			});
          			}
        			
            	}
            }
            
	    },
	    error: function () {
	        msgbox('提示','获取下页评论内容失败','确认');
	        
	    }
	});
}
function msgbox(title,content,btn,fun){
	 $(".tk").remove();
	 var tk=$("<div class='tk'></div>");
	 var tcontent=$("<div class='tcontent'></div>");
	 tk.append(tcontent);
	 if(title!=""){
		 tcontent.append("<p class='title'>"+title+"</p>");
	 }
	 tcontent.append("<div class='thead'><p>"+content+"</p></div>");
	 tcontent.append("<div class='tbtn'></div>");
	 var tbtn = $("<div class='tbtn'></div>");
	 tcontent.append(tbtn);
	 var btnA = $("<a>"+btn+"</a>");
	 tbtn.append(btnA);
	 $("body").append(tk);
	 $(".tcontent").css("margin-top","-"+parseInt($(".tcontent").height()/2)+"px");
	 btnA.click(function(){
		 $(".tk").remove();
	 });
	 btnA.click(fun);
}

var imgUrl = '${ctx }${appPic}';  
var lineLink = '${ctx }/service/commiunity/getActivitiesDetailsById.json?ID=${ID}&download=1';  
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

