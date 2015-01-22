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
<!--     <header class="header"> -->
<!--         <h1>小区开聊</h1>       -->
<!--         <a class="a-back"></a> -->
<!--     </header> -->
    <div class="kl-content kl-div" >
       <input type="hidden" id="supTmp" value="">
       <input type="hidden" id="noZan" value="N">
        <p class="kl-head">
            <img src="${ctx }/${businessHelp.portrait}"/>
            <span class="kl-name">${businessHelp.helperName}  </span>
            <span class="kl-time">${businessHelp.helpTime}  </span> 
        </p>
        <div id="conents" class="kl-con">
           
        </div>
        <p class="kl-zpl">
            <span class="kl-pl">
                <i class="bgpl"></i>
                <em>${businessHelp.comments}</em>
            </span>
            <span class="kl-z" id="supportsaSpan">
                <a class="bgz" id="supportsa"></a>     
                <em id="supports"></em>
            </span>
        </p>
    </div>
    <div class="kl-div kl-hf">
        <h2>全部评论</h2>  
        <ul id="comments">
        </ul>
        <div class="c-more">
            <hr>
            <a>查看更多</a>
        </div>
    </div>
    <div class="fixed kl-bottom">
        <a class="kl-wyhf"><span>我要回复</span></a>  
    </div>
</div>
    
    <div class="kl-hfpage">
        <header class="header">
            <h1>回复</h1>
            <a class="a-back"></a>
            <a id="send" class="a-searchbtn radius10 a-hf">发 送</a>
        </header>
        <div class="bl-winp hf-winp">
            <div class="bl-ninp">
                <textarea id="CommentStr" placeholder="请输入回复内容..." maxlength="280"></textarea>
                <p class="bl-inpfont">还可以输入<span id="charNum">280</span>个汉字</p>
            </div>
        </div>
    </div>
    
<script src="${ctx}/js/activity/js/jquery-1.7.2.min.js"></script>
<script src="${ctx}/js/jquery.showLoading.min.js"></script>
    <script>
        $(".kl-wyhf").click(function(e) {
			$(".kl-total").css("display","none");
            $(".kl-hfpage").css("display","block");
           	replyId=0;
           	replyName="";
            replyType =0;
           	$("#CommentStr").attr("placeholder","请输入回复内容...");
            $("#CommentStr").val("");   
        });
		$(".kl-hfpage .a-back").click(function(e) {
			$(".kl-hfpage").css("display","none");
            $(".kl-total").css("display","block");
            $("#CommentStr").val("");   
            $("#CommentStr").attr("placeholder","回复："+replyName);
        });    
		


</script>
     
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
 imgs = pics.split(",");
 if (pics != null && pics != '') 
{
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
 $(document).ready(function(){
// 	 $("#content").click(function(){
// 		 replyId = 0;//点击回复人id
// 		 replyName = "";//点击回复人姓名
// 		 replyType = 0;//点击回复人类型
// 		 $("#replaceinp").attr("placeholder","回复:");
// 	 });
	 //点赞
	 $('#supportsa').click(function(){
//		 	$('#supportsa').append('<em id="plusOne" class="x-add">+1</em>');  
		    $('#supportsa').append('<em id="plusOne" class="x-add"></em>');
		 	help_dianzhan();
// 			if (dianZan != 0)
// 				$('#plusOne').text('');
			dianZan++;
		    $('#supportsa').css("background-image","url(${ctx}/images/zyellow.png)");
		    $('#supports').css("color","#fd8b07");
		    $('.x-add').css({'position':'absolute', 'color':'#fd8b07','left':'0px','top':'0px'}).animate({top:'-30px',left:'0px'},'slow',function(){
			   
			$(this).fadeIn('fast').remove();        
			var Num = parseInt($("#supTmp").attr("value")); 

// 			   alert($('#plusOne').val());
// 			   alert($('.x-add').text("")); 
// 			   Num++;
// 			   $('.kl-z em').text(Num);
		    $('#supports').text(Num);
			$('#supportsa').css("background-image","url(${ctx}/images/zgray.png)");
// 			   $('.kl-z em').css("color","#7c7c7c");
			$('#supports').css("color","#7c7c7c");
		   });
		   
	    });
	 
		//评论
		 $('#send').click(function() {
			
		 	var content = $('#CommentStr').val();
		 	var reg=/^[\w\u4e00-\u9fa5`~!@#$%^&*()+=|{}':;",\t\r\n\s\[\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？～《》]+$/;
			if(!reg.test(content)){
				 msgbox('提示','不支持表情图片，您只能输入文字、数字、英文');
				return;
			}
		 	var url="";
		 	url = '${ctx}/service/seekHelp/saveSeekHelpReply.json';
		 	if(content != '') {
		 		$.ajax({
		 		    url: url,
		 		    cache: false,
		 		    data: {
		 		    	ID: '${ID}',
			           	sessionid: '${sessionid}', 
			           	content: content,
			           	userId: '${userId}',
			           	publisherId : publisherId,
			           	replyId:replyId ,
			           	replyName:replyName,
		 		    	replyType:replyType
		 		    },
		 		    type: 'post',
		            dataType: 'json',
		 		    success: function (data) {
		 	     	   if(data.errorCode == 200) {
		 	     		 msgbox('提示','评论成功');
		 	     		$(".kl-hfpage").css("display","none");
		 	            $(".kl-total").css("display","block");
// 		 	           $('#comments').append(newContent);
					   $('#comments').html("");
		 	           page=1;
		 	           jump(1); 
		 	      	   }else{
		 	      		 msgbox('提示','评论失败'); 
		 	      		$(".kl-hfpage").css("display","none");
		 	            $(".kl-total").css("display","block");
		 	      	   }
		 		    	
		 		    },
		 		    error: function () {
		 		       msgbox('提示','评论失败');
		 		      
		 		      $(".kl-hfpage").css("display","none");
		 	          $(".kl-total").css("display","block");
		 		    }
		 		});
		 	}else{
		 		 msgbox('提示','评论不能为空');
		 		$(".kl-hfpage").css("display","none");
	            $(".kl-total").css("display","block");
		 		return;
		 	}
		 });
		
		
		  $("#CommentStr").keyup(function(){
		         var length = 280;
		         var content_len = $("#CommentStr").val().length;
		         var in_len = length-content_len;    
		         // 当用户输入的字数大于制定的数时
		         if(in_len >=0){
 		            $(".bl-inpfont").html('您还可以输入'+in_len+'字');
//  				     $("#btn").attr("disabled",false);
		            // 可以继续执行其他操作
		         }else{
 		            $(".bl-inpfont").html('您还可以输入'+in_len+'字');
		            return false;
		         }
		    });
		
		$('.c-more a').click(function() {
		 	if(PageState) {
		 		page++;
		 		jump(page);
		 		return;
		 	}else{
		 		$('.c-more a').text('亲已经到底了');
		 		$('.c-more a').attr('disabled', true);
		 		return;
		 	}
		});
		page++;
		jump(page);
		document.onkeydown = function(e){    
		    var ev = document.all ? window.event : e;  
		    if(ev.keyCode==13) {// 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
		        //要处理的事件  
		        $('.c-more a').click();
		    }  
		  };
		  
		 //firefox下检测状态改变只能用oninput,且需要用addEventListener来注册事件。 
// 		 if(/msie/i.test(navigator.userAgent))    //ie浏览器 
// 		 {
// 			 document.getElementById('replaceinp').onpropertychange=handle ;
// 		 } 
// 		 else 
// 		 {//非ie浏览器，比如Firefox 
// 		 	document.getElementById('comment').addEventListener("input",handle,false); 
// 		 }
 });
 
//当状态改变的时候执行的函数 
 function handle() {
	//document.getElementById('msg').innerHTML='输入的文字长度为：'+document.getElementById('txt').value.length; 
	$("#replaceinp").val(" ");
	if($("#CommentStr").val().length==0){
		$("#replaceinp").val("");
		$("#replaceinp").attr("placeholder","回复："+replyName);
	}
	/*if(document.getElementById('replaceinp').value.length>0){
		$("#comment").val($("#replaceinp").val());
		$("#replaceinp").attr("value","");
		$("#comment").focus();
	}*/
 } 
 
 function help_dianzhan()
 {
	    if($("#noZan").val() == 'Y')
	    {
// 	    		$('.kl-z em').text('已赞过了，再赞他会骄傲的…');
	    		$('#supports').text('已赞过了，再赞他会骄傲的…');
	    		return ;
	    }
	    $("#noZan").val('Y');
	    
		$.ajax({
        url: '${ctx}/service/seekHelp/supportSeekHelp.json',
        cache: false,
        type: 'post',
        dataType: 'json',
        data: {
		    	ID: '${ID}',
	           	sessionid: '${sessionid}', 
	           	userId: '${userId}'
        },
        
        success: function (data) {
     	   if(data.errorCode == 200) {
//      	 $('.kl-z em').text(data.message);
// 			 $('#supportsa').append('<em id="plusOne" class="x-add">+1</em>');
             $('#plusOne').text('+1');
			 $('#supports').text(data.message);
     		 $("#supTmp").val( parseInt($("#supTmp").attr("value"))+1);
     	   }else{
     		  $("#supTmp").val( $("#supTmp").attr("value"));
//       	 $('.kl-z em').text(data.message);
 			 $('#supports').text(data.message);
     	   }
        },
        error: function() {
        	 $("#supTmp").val( $("#supTmp").attr("value"));
//      	 $('.kl-z em').text('点赞失败');
			 $('#supports').text('点赞失败');
        }
    });

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
		    	PageState=data.content.PageState;
                var rows = data.content.reviewList;
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                		var row = rows[i];   
                		var newContent = '';
                		newContent = '<div class="kl-hftotal tab"  > <p class="tleft kl-img">';
                		if("${ctx}"==row.avatar)
                			newContent += '<img src="${ctx }/images/morentouxiang.png"/>';
                		else
                			newContent += '<img src="'+row.avatar+'" onerror="this.onerror=null; this.src=\'${ctx }/images/morentouxiang.png\'">';
                	  
                	   var uname = "";
	           		   if(row.name=="" || row.name==null){
	       					if(row.userType==1){
								 uname = "匿名(官方)";
	       					}else{
	       						 uname = '匿名';
	       					}
	       				}else{
	       					if(row.userType==1){
	       						 uname = row.name+'(官方)';
	       					}else{
	       						 uname = row.name;
	       					}
	       				}
               			newContent += '</p>  <div class="kl-user tleft"> <p class="kl-people">'+uname+'</p>';

               			if(row.replyId==0){
                   			newContent += ' <p class="kl-hfcon kl-top"><span class="kl-span">'+row.content+'</span></span></p></div></div>';
            			}else{
            				if(row.replyType==1){
                       			newContent += ' <p class="kl-hfcon kl-top"><span class="kl-span">回复  <em>'+row.replyName+'(官方)：</em>'+row.content+'</span></span></p></div></div>';
//             					newContent+= '<div class="one">'+ '<span>回复</sapn>' +'<span>'+row.replyName+'(官方):</span>' +row.content+'</div>';
            				}else{
                       			newContent += ' <p class="kl-hfcon kl-top"><span class="kl-span">回复  <em>'+row.replyName+'：</em>'+row.content+'</span></span></p></div></div>';
            				}
            			}
               			
//                			newContent += ' <p class="kl-hfcon kl-top"><span>'+row.content+'</span></span></p></div></div>';
	
               			newContent += '<p class="kl-hftime kl-top"><time>'+row.commentTime+'</time></p>';
               			var div = $('<li></li>');
						div.append(newContent);
                	    $('#comments').append(div);	
                	    
//                 	    var div = $('#comments');  </ul> 
						
            			if(row.userId!=userId){
            				div.find("img").attr("replyId",row.userId);
            				if(row.name=="" || row.name==null){
            					div.find("img").attr("replyName","匿名");
            				}else{
            					div.find("img").attr("replyName",row.name);
            				}
            				div.find("img").attr("replyType",row.userType);  

                			div.click(function(){
                				
                				replyId = $(this).find("img").attr("replyId");//点击回复人id
                				replyName = $(this).find("img").attr("replyName");//点击回复人姓名
                				replyType = $(this).find("img").attr("replyType");//点击回复人类型
//                 				alert(replyName);
                				$("#CommentStr").attr("placeholder","回复："+replyName);
                				$(".kl-total").css("display","none");
                	            $(".kl-hfpage").css("display","block");

                  			 });
            			}else{
            				
            				div.click(function(){
//                				 alert("ddd");
//                  				 replyId = 0;//点击回复人id
//                  				 replyName = "";//点击回复人姓名
//                  				 $("#replaceinp").attr("placeholder","回复:");
								replyId = 0;
               					replyName = "";
//                			    replyType = "";
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
	 shtml += "<p>"+content+"</p>";
	 shtml += "</div>";
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
