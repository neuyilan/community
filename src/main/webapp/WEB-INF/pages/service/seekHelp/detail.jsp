<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>小区开聊详情</title> 
<link type="text/css" rel="stylesheet" href="${ctx }/tmp/css/style.css"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
</head>

<body>
    <header class="header">
        <h1>小区开聊</h1>      
        <a class="a-back"></a>
    </header>
    <div class="kl-content kl-div">
        <p class="kl-head">
            <img src="${ctx }/tmp/images/lt1.jpg"/>
            <span class="kl-name">${businessHelp.helperName}  </span>
            <span class="kl-time">${businessHelp.helpTime}  </span> 
        </p>
        <div class="kl-con">
            ${businessHelp.helpContent}
<!--              <p>我家门口墙上突然出现了奇怪的符号，比如叉子，一个长方形，什么意思呀？是不是被小偷惦记上了？</p> -->
<!--              <p>我家门口墙上突然出现了奇怪的符号，比如叉子，一个长方形，什么意思呀？是不是被小偷惦记上了？</p> -->
<%--              <img src="${ctx }/tmp/images/kl1.jpg"/> --%>
        </div>
        <p class="kl-zpl">
            <span class="kl-pl">
                <i class="bgpl"></i>
                <em>${businessHelp.visits} </em>
            </span>
            <span class="kl-z">
                <i class="bgz"></i>
                <em>${businessHelp.supports} </em>
            </span>
        </p>
    </div>
    <div class="kl-div kl-hf">
        <h2>全部评论</h2>
        <ul id="comments">
<!--             <li> -->
<!--                 <div class="kl-hftotal tab"> -->
<!--                     <p class="tleft kl-img"> -->
<%--                        <img src="${ctx }/tmp/images/lt1.jpg"/> --%>
<!--                     </p>   -->
<!--                     <div class="kl-user tleft"> -->
<!--                        <p class="kl-people">哈哈</p> -->
<!--                        <p class="kl-hfcon kl-top"><span class="kl-span">我家门口墙上突然出现了奇怪的符号，我家门口墙上突然出现了奇怪的符。</span></p> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <p class="kl-hftime kl-top"><time>2015-01-08  15:54</time></p> -->
<!--             </li> -->
<!--             <li> -->
<!--                 <div class="kl-hftotal tab"> -->
<!--                     <p class="tleft kl-img"> -->
<%--                        <img src="${ctx }/tmp/images/klh1.jpg"/> --%>
<!--                     </p>   -->
<!--                     <div class="kl-user tleft"> -->
<!--                        <p class="kl-people">小大虫</p> -->
<!--                        <p class="kl-hfcon kl-top"><span class="kl-span">回复 <em>哈哈：</em><span>有小偷了</span></span></p> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <p class="kl-hftime kl-top"><time>2015-01-08  15:54</time></p> -->
<!--             </li> -->
        </ul>
        <div class="c-more">
            <hr>
            <a>查看更多</a>
        </div>
    </div>
    <div class="fixed kl-bottom">
        <a><span>我要回复</span></a>
    </div>
    
    
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script src="${ctx }/js/jquery.showLoading.min.js"></script>    
<script>

/*赞*/
 var userId = '${userId}';//登录用户头像地址
 var protrait = '${protrait}';//登录用户头像地址
 var nickname = '${nickname}';//登录用户名称
 var replyId = 0;//点击回复人id
 var replyName ="";//点击回复人姓名
 var replyType =0;//点击回复人类型
 var page = 0 ;//当前页面
 var PageState=false;//是否有下一页
 var screenHeight=document.documentElement.clientHeight;
 if("${ctx}"==protrait){
	 protrait = '${ctx}/images/morentouxiang.png';
}
 if(nickname==""){
	 nickname = '匿名';
}
 $(document).ready(function(){
// 	 alert("ccc");           
	 //$("#comment").focus(function(){
	//		$(".scroll").css("bottom","357px");
	//		$(".x-inp").css("bottom","300px");
	//	 });
	///	 $("#comment").blur(function(){
	//		$(".scroll").css("bottom","57px");
	//		$(".x-inp").css("bottom","0px");
	//	 });
	 $("#content").click(function(){
		 replyId = 0;//点击回复人id
		 replyName = "";//点击回复人姓名
		 replyType = 0;//点击回复人类型
		 $("#replaceinp").attr("placeholder","回复:");
	 });
	 /* $('.x-z a').click(function(){
        $('.x-z a').append('<em class="x-add">+1</em>');
		$('.x-z img').attr("src","images/ze.png");
		$('.x-z em').css("color","#e41212");
        $('.x-add').css({'position':'absolute', 'color':'#FF0000','left':'0px','top':'0px'}).animate({top:'-30px',left:'0px'},'slow',function(){
          $(this).fadeIn('fast').remove();
          var Num = parseInt($('.x-z em').text());
          Num++;
          $('.x-z em').text(Num);
		  $('.x-z img').attr("src","images/zk.png");
		  $('.x-z em').css("color","#030303");
        });
	 }); */
	 

		//点赞
		 $('.x-z a').click(function(){
		 	$.ajax({
	           url: '${ctx}/service/commiunity/supportJournalism.json',
	           cache: false,
	           type: 'post',
	           dataType: 'json',
	           data: {
	           	ID: '${newsId}',
	           	sessionid: '${sessionid}', 
	           	userId: '${userId}'
	           },
	           success: function (data) {
	        	   //eval('data=' + data);
	        	   if(data.errorCode == 200) {
	        		    $('.x-z a').append('<em class="x-add">+1</em>');
						$('.x-z img').attr("src","${ctx }/js/activity/images/ze.png");
						$('.x-z img').attr("disabled",true);
						$('.x-z em').css("color","#e41212");
				        $('.x-add').css({'position':'absolute', 'color':'#FF0000','left':'0px','top':'0px'}).animate({top:'-30px',left:'0px'},'slow',function(){
				        $(this).fadeIn('fast').remove();
				        var Num = parseInt($('.x-z em').text());
				        Num++;
				        $('.x-z em').text(Num);
						$('.x-z img').attr("src","${ctx }/js/activity/images/zk.png");
						$('.x-z em').css("color","#030303");
				        });
				        //alert(data.message);
	        	   }else{
	        		   msgbox('提示',data.message);
	        	   }
	           },
	           error: function() {
	               msgbox('提示','点赞失败');
	           }
	       });
		 });
		
		//评论
		 $('#commentBtn').click(function() {
		 	var content = $('#comment').val();
		 	var reg=/^[\w\u4e00-\u9fa5`~!@#$%^&*()+=|{}':;",\t\r\n\s\[\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？～《》]+$/;
			if(!reg.test(content)){
				 msgbox('提示','不支持表情图片，您只能输入文字、数字、英文');
				return;
			}
		 	var url="";
		 	if(replyId==0){
		 		url = '${ctx}/service/commiunity/saveJournalismReview.json';
		 	}else{
		 		url = '${ctx}/service/commiunity/saveJournalismReply.json';
		 	}
		 	if(content != '') {
		 		$.ajax({
		 		    url: url,
		 		    cache: false,
		 		    data: {
		 		    	ID: '${newsId}',
			           	sessionid: '${sessionid}', 
			           	userId: '${userId}'
// 			           	replyId:replyId ,
// 			           	replyName:replyName,
// 		 		    	content: content,
// 		 		    	replyType:replyType
		 		    },
		 		    type: 'post',
		            dataType: 'json',
		 		    success: function (data) {
		 		    	//alert('评论成功');
		 		    	//eval('data=' + data);
		 		    	//$('#comment').attr('disabled', true);
		 		    	var newContent = '';
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
		 				$('#comments').prepend(newContent);
		 				$('#comment').val("");
		 				$('#replaceinp').val("");
		 				replyId = 0;//点击回复人id
		 				replyName = "";//点击回复人姓名
		 				replyType = 0;//点击回复人类型
		 				$("#replaceinp").attr("placeholder","回复："+replyName);
		 				$("#commentsCount").text(data.content.comments);
		 			 	document.getElementById("anchor_scroll").click();
		 		    },
		 		    error: function () {
		 		       msgbox('提示','评论失败');
		 		    }
		 		});
		 	}else{
		 		 msgbox('提示','评论不能为空');
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
		  };
		 //firefox下检测状态改变只能用oninput,且需要用addEventListener来注册事件。 
// 		 if(/msie/i.test(navigator.userAgent))    //ie浏览器 
// 		 {document.getElementById('replaceinp').onpropertychange=handle 
// 		 } 
// 		 else 
// 		 {//非ie浏览器，比如Firefox 
// 		 document.getElementById('comment').addEventListener("input",handle,false); 
// 		 } 
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
		    url: '${ctx}/service/seekHelp/getSeekHelpReviewById.json',
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
// 		    	$("#commentsCount").text(data.content.count);
		    	PageState=data.content.PageState;
                var rows = data.content.reviewList;
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                		var row = rows[i];   
                		var newContent = '';
                		newContent = '<li><div class="kl-hftotal tab"> <p class="tleft kl-img">';
                		if("${ctx}"==row.avatar)
                			newContent += '<img src="${ctx }/images/morentouxiang.png"/>';
                		else
                			newContent += '<img src="'+row.avatar+'" onerror="this.onerror=null; this.src=\'${ctx }/images/morentouxiang.png\'">';
               			newContent += '</p>  <div class="kl-user tleft"> <p class="kl-people">'+row.name+'</p>';
               			newContent += ' <p class="kl-hfcon kl-top"><span class="kl-span">回复<em>'+row.replyName+'</em><span>'+row.content+'</span></span></p></div></div>';
               			newContent += '<p class="kl-hftime kl-top"><time>'+row.commentTime+'</time></p></li>';
                	    $('#comments').append(newContent);	
                		
//                 		newContent+= '<dl class="s-clt">';
//                 		newContent+= '<dt>';
//                 		if("${ctx}"==row.avatar){
//                 			newContent+= '<span class="pto"><img src="${ctx }/images/morentouxiang.png"></span>';
//                 		}else{
//                 			newContent+= '<span class="pto"><img src="'+row.avatar+'" onerror="this.onerror=null; this.src=\'${ctx }/images/morentouxiang.png\'"></span>';
//                 		}
//                 		newContent+= '</dt>';
//                 		newContent+= '<dd>';
//                 		newContent+='<div class="info">';
//            				if(row.name=="" || row.name==null){
//            					if(row.userType==1){
//            						newContent+= '<span class="nine">匿名(官方)</span>';
//            					}else{
//            						newContent+= '<span class="nine">匿名</span>';
//            					}
//            				}else{
//            					if(row.userType==1){
//            						newContent+= '<span class="nine">'+row.name+'(官方)</span>';
//            					}else{
//            						newContent+= '<span class="nine">'+row.name+'</span>';
//            					}
//            				}
//             			newContent+='<span class="time">'+row.commentTime+'</span>';
//             			newContent+= '</div>';
//             			if(row.replyId==0){
//             				newContent+= '<div class="one">'+row.content+'</div>';
//             			}else{
//             				if(row.replyType==1){
//             					newContent+= '<div class="one">'+ '<span>回复</sapn>' +'<span>'+row.replyName+'(官方):</span>' +row.content+'</div>';
//             				}else{
//             					newContent+= '<div class="one">'+ '<span>回复</sapn>' +'<span>'+row.replyName+':</span>' +row.content+'</div>';
//             				}
//             			}
//             			newContent+='</dd>';
//             			newContent+='</dl>';
//             			var div = $("<div></div>");
//             			div.append(newContent);
//             			$('#comments').append(div);
            			
//             			if(row.userId!=userId){
//             				div.find("img").attr("replyId",row.userId);
//             				if(row.name=="" || row.name==null){
//             					div.find("img").attr("replyName","匿名");
//             				}else{
//             					div.find("img").attr("replyName",row.name);
//             				}
//             				div.find("img").attr("replyType",row.userType);
//                 			div.find("img").click(function(){
//                 				replyId = $(this).attr("replyId");//点击回复人id
//                 				replyName = $(this).attr("replyName");//点击回复人姓名
//                 				replyType = $(this).attr("replyType");//点击回复人类型
//                 				$("#replaceinp").attr("placeholder","回复："+replyName);
//                 				$("#comment").focus();
//                 			});
//                 			div.find("dd").click(function(){
//                   				 replyId = 0;//点击回复人id
//                   				 replyName = "";//点击回复人姓名
//                   				 $("#replaceinp").attr("placeholder","回复:");
//                   			 });
                			
//             			}else{
// 	            			div.find("img").click(function(){
// 	           					 msgbox('提示',"您不能自己回复自己");
// 	               			});
// 	           			}
            			
                	}
                }
                
		    },
		    error: function () {
		        msgbox('提示','获取下页评论内容失败');
		    }
		});
}
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
