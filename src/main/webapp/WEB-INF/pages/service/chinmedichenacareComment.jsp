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
<link href="${ctx }/js/activity/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/showLoading.css" rel="stylesheet" type="text/css" />
</head>

<body>
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
        <%-- <div class="x-intro">
            <p class="x-itname"><span>${publisherName}</span>介绍：</p>
            <p class="x-itcon">${doctorBrief}</p>
        </div> --%>
        
        <div class="x-content">
            <div class="x-cx">
                ${newsContent}
            </div>
            <hr/>
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
    <div class="x-news x-pl">
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
			 $("#replaceinp").attr("placeholder","回复:");
		 });
		//点赞
		 $('.x-z a').click(function(){
			 if(userId==0){
					if(window.confirm('请您填写相关信息。')){
						 window.location.href='${phpIp}/wxokjia/reggoin.php';
		                //alert("确定");
		                return null;
		             }else{
		                //alert("取消");
		                return null;
		            }
				}
		 	$.ajax({
	           url: '${ctx}/service/chinmedichenacare/support.json',
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
	               msgbox('提示','评论失败');
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
		 	var reg=/^[\w\u4e00-\u9fa5`~!@#$%^&*()+=|{}':;",\t\r\n\s\[\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？～《》]+$/;
			if(!reg.test(content)){
				 msgbox('提示','不支持表情图片，您只能输入文字、数字、英文');
				return;
			}
		 	var url="";
		 	if(replyId==0){
		 		url = '${ctx}/service/chinmedichenacare/saveReview.json';
		 	}else{
		 		url = '${ctx}/service/chinmedichenacare/saveReply.json';
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
		    url: '${ctx}/service/chinmedichenacare/getReviewByUserId.json',
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
		    	PageState=data.content.PageState;
                var rows = data.content.reviewList;
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
	           					 msgbox('提示',"您不能自己回复自己");
	               			});
	           			}
            			
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
