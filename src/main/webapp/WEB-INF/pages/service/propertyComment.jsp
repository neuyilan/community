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
<link href="${ctx }/js/activity/css/style.css?t=20150211" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/showLoading.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="x-main">
<div class="scroll">
    <div class="blockdiv" id="content">
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
            <div class="x-zs1">
                <span class="x-z">
                    <a><img src="${ctx }/js/activity/images/zk.png"></a>
                    <em>${supports}</em>
                </span>
<!--                <span class="x-s1">
                    <a><img src="images/share.png"></a>
                    <em>123</em>
                </span>-->
            </div>
        </div>
    </div>
    <div class="blockdiv x-pl">
        <p class="x-pc">全部评论(<span id="commentsCount">${comments }</span>)</p>
        <div id="pos"></div>
        <a href="#pos" id="anchor_scroll"></a>
        <div id="comments">
        </div>
        <a class="more" id="nextBtn"><span id="curr">点击获取更多</span></a>
    </div>
    </div>
   <div class="x-inp">
        <div class="tab">
           <span class="tleft">
  			<div style=" position:relative;">
           <input type="text"   name="comment" class="x-inc" id="comment" style=" position:absolute;top:0px; left:0; z-index:2;">
           <input type="text" placeholder="请输入您要评论的内容..." style="height: 33px; left: 0;padding-left: 8px;position: absolute;top:0px;width: 100%;z-index: 1;border:none;padding-top:2px;box-sizing: border-box;-webkit-box-sizing: border-box;background:#eeeeee;border-radius:3px;font-size:14px;" id="replaceinp">
 			 </div>
           </span>
           <span class="tleft"><input id="commentBtn" type="button" value=""></span>
        </div>
    </div>
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
 if("${ctx}"==protrait){
	 protrait = '${ctx}/images/morentouxiang.png';
}
 if(nickname==""){
	 nickname = '匿名';
}
 $(document).ready(function(){
		 $("#content").click(function(){
			 replyId = 0;//点击回复人id
			 replyName = "";//点击回复人姓名
			 replyType = 0;//点击回复人类型
			 $("#replaceinp").attr("placeholder","请输入您要评论的内容...");
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
	           url: '${ctx}/service/property/supportProperty.json',
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
						$('.x-z em').css("color","#7c7c7c");
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
				 if(userId==0){
					 	msgbox('提示','为了确保您的信息正常发布，请您填写相关信息。','确定',function(){
					 		 window.location.href='${phpIp}/wxokjia/reggoin.php';
					 	},'取消');
					 	return;
					}
				}
			var ze = /(^\s*)|(\s*$)|(")|(\n)/g;
		 	var content = $('#comment').val();
		 	content = content.replace(ze,'');
		 	if(content.length==0){
		 		msgbox('提示','您好像忘记说点什么了。','确认');
				return;
		 	}
		 	var reg=/^[\w\u4e00-\u9fa5`~!@#$%^&*()+=|{}':;,\t \[\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？～《》]+$/;
			if(!reg.test(content)){
				 msgbox('提示','不支持表情图片，您只能输入文字、数字、英文','确认');
				return;
			}
		 	var url="";
		 	if(replyId==0){
		 		url = '${ctx}/service/property/savePopertyReview.json';
		 	}else{
		 		url = '${ctx}/service/property/savePropertyReply.json';
		 	}
		 	if(content != '') {
		 		$.ajax({
		 		    url: url,
		 		    cache: false,
		 		    data: {
		 		    	ID: '${newsId}',
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
		 				if(data.errorCode == 200) {
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
					        //alert(data.message);
		        	   }else{
		        		   msgbox('提示',data.message,'确认');
		        	   }
		 		    },
		 		    error: function () {
		 		       msgbox('提示','评论失败','确认');
		 		      
		 		    }
		 		});
		 	}else{
		 		 msgbox('提示','评论不能为空','确认');
		 		
		 		return;
		 	}
		 	$("#replaceinp").attr("placeholder","请输入您要评论的内容...");
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
		    url: '${ctx}/service/property/getPopertyReviewById.json',
		    cache: false,
		    type: 'post',
            dataType: 'json',
		    data: {
		    	ID: '${newsId}',
	           	sessionid: '${sessionid}', 
	           	userId: '${userId}',
		    	page: page
		    },
		    success: function (data) {
		    	//eval('data=' + data);
		    	$("#commentsCount").text(data.content.count);
		    	PageState=data.content.PageState;
                var rows = data.content.reviewList;
                
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
                  				 $("#replaceinp").attr("placeholder","请输入您要评论的内容...");
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
function msgbox(title,content,btn,fun,btn2){
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
	 if(btn2!=null && btn2!="" && btn2!=undefined){
		 var btnB = $("<a style='margin-left:20px'>"+btn2+"</a>");
		 tbtn.append(btnB);
		 btnB.click(function(){
			 $(".tk").remove();
		 });
	 }
	
	 $("body").append(tk);
	 $(".tcontent").css("margin-top","-"+parseInt($(".tcontent").height()/2)+"px");
	 btnA.click(function(){
		 $(".tk").remove();
	 });
	 btnA.click(fun);
}
</script>
</body>
</html>
