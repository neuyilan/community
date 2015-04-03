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
<link href="${ctx }/js/activity/css/idangerous.swiper.css" rel="stylesheet" type="text/css" />

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
            <c:if test="${download==1 }">
         	<div class="fxdown">
	            <a href="${phpIp}/wxokjia/downloadgoin.php">
	                <img src="${ctx }/images/click_1.png"/>
	            </a>    
	        </div>
	      </c:if>
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
   <div class="x-inp ex-inp">
        <div class="tab">
        	<span class="tleft" style="width:33px;"><i class="ex-show font-expre"></i></span>
           <span class="tleft">
  			<div style=" position:relative;">
           <input type="text"   name="comment" class="x-inc" id="comment" style=" position:absolute;top:0px; left:0; z-index:2;">
           <input type="text" placeholder="请输入您要评论的内容..." style="height: 33px; left: 0;padding-left: 8px;position: absolute;top:0px;width: 100%;z-index: 1;border:none;padding-top:2px;box-sizing: border-box;-webkit-box-sizing: border-box;background:#eeeeee;border-radius:3px;font-size:14px;" id="replaceinp">
 			 </div>
           </span>
           <span class="tleft"><input id="commentBtn" type="button" value=""></span>
        </div>
        <div class="exbottom inpbottom">
        <section class="expression">
            <div class="swiper-containerex">
                <ul class="swiper-wrapper">
                    <li class="swiper-slide"> 
                         <a><img data-icon="[/感动]" data-em="[d_f001]" src="${ctx }/js/activity/arclist/01.png"/></a>
                         <a><img data-icon="[/再见]" data-em="[d_f003]" src="${ctx }/js/activity/arclist/03.png"/></a>
                         <a><img data-icon="[/哭]" data-em="[d_f004]" src="${ctx }/js/activity/arclist/04.png"/></a>
                         <a><img data-icon="[/鄙视]" data-em="[d_f005]" src="${ctx }/js/activity/arclist/05.png"/></a>
                         <a><img data-icon="[/禁言]" data-em="[d_f006]" src="${ctx }/js/activity/arclist/06.png"/></a>
                         <a><img data-icon="[/馋]" data-em="[d_f007]" src="${ctx }/js/activity/arclist/07.png"/></a>
                         <a><img data-icon="[/惊讶]" data-em="[d_f008]" src="${ctx }/js/activity/arclist/08.png"/></a>
                         <a><img data-icon="[/困]" data-em="[d_f010]" src="${ctx }/js/activity/arclist/10.png"/></a>
                         <a><img data-icon="[/IOT]" data-em="[d_f011]" src="${ctx }/js/activity/arclist/11.png"/></a>
                         <a><img data-icon="[/感冒]" data-em="[d_f014]" src="${ctx }/js/activity/arclist/14.png"/></a>
                         <a><img data-icon="[/鼓掌]" data-em="[d_f015]" src="${ctx }/js/activity/arclist/15.png"/></a>
                         <a><img data-icon="[/大笑]" data-em="[d_f016]" src="${ctx }/js/activity/arclist/16.png"/></a>
                         <a><img data-icon="[/害羞]" data-em="[d_f017]" src="${ctx }/js/activity/arclist/17.png"/></a>
                         <a><img data-icon="[/流汗]" data-em="[d_f018]" src="${ctx }/js/activity/arclist/18.png"/></a>
                         <a><img data-icon="[/微笑]" data-em="[d_f019]" src="${ctx }/js/activity/arclist/19.png"/></a>
                         <a><img data-icon="[/左哼哼]" data-em="[d_f061]" src="${ctx }/js/activity/arclist/61.png"/></a>
                         <a><img data-icon="[/吓]" data-em="[d_f020]" src="${ctx }/js/activity/arclist/20.png"/></a>
                         <a><img data-icon="[/睡觉]" data-em="[d_f041]" src="${ctx }/js/activity/arclist/41.png"/></a>
                         <a><img data-icon="[/思考]" data-em="[d_f042]" src="${ctx }/js/activity/arclist/42.png"/></a>
                         <a><img data-icon="[/高兴]" data-em="[d_f043]" src="${ctx }/js/activity/arclist/43.png"/></a>
                         <a class="delete"><img src="${ctx }/js/activity/arclist/delete.png"/></a>
                    </li>      
                    <li class="swiper-slide">
                         <a><img data-icon="[/生气]" data-em="[d_f021]" src="${ctx }/js/activity/arclist/21.png"/></a>
                         <a><img data-icon="[/色]" data-em="[d_f022]" src="${ctx }/js/activity/arclist/22.png"/></a>
                         <a><img data-icon="[/调皮]" data-em="[d_f023]" src="${ctx }/js/activity/arclist/23.png"/></a>
                         <a><img data-icon="[/愉快]" data-em="[d_f024]" src="${ctx }/js/activity/arclist/24.png"/></a>
                         <a><img data-icon="[/可怜]" data-em="[d_f025]" src="${ctx }/js/activity/arclist/25.png"/></a>
                         <a><img data-icon="[/得意]" data-em="[d_f026]" src="${ctx }/js/activity/arclist/26.png"/></a>
                         <a><img data-icon="[/打哈欠]" data-em="[d_f027]" src="${ctx }/js/activity/arclist/27.png"/></a>
                         <a><img data-icon="[/傲慢]" data-em="[d_f028]" src="${ctx }/js/activity/arclist/28.png"/></a>
                         <a><img data-icon="[/流泪]" data-em="[d_f029]" src="${ctx }/js/activity/arclist/29.png"/></a>
                         <a><img data-icon="[/偷笑]" data-em="[d_f044]" src="${ctx }/js/activity/arclist/44.png"/></a>
                         <a><img data-icon="[/吐]" data-em="[d_f046]" src="${ctx }/js/activity/arclist/46.png"/></a>
                         <a><img data-icon="[/发怒]" data-em="[d_f032]" src="${ctx }/js/activity/arclist/32.png"/></a>
                         <a><img data-icon="[/咒骂]" data-em="[d_f033]" src="${ctx }/js/activity/arclist/33.png"/></a>
                         <a><img data-icon="[/抠鼻]" data-em="[d_f048]" src="${ctx }/js/activity/arclist/48.png"/></a>
                         <a><img data-icon="[/委屈]" data-em="[d_f049]" src="${ctx }/js/activity/arclist/49.png"/></a>
                         <a><img data-icon="[/财迷]" data-em="[d_f035]" src="${ctx }/js/activity/arclist/35.png"/></a>
                         <a><img data-icon="[/亲亲]" data-em="[d_f036]" src="${ctx }/js/activity/arclist/36.png"/></a>
                         <a><img data-icon="[/恶心]" data-em="[d_f037]" src="${ctx }/js/activity/arclist/37.png"/></a>
                         <a><img data-icon="[/难过]" data-em="[d_f039]" src="${ctx }/js/activity/arclist/39.png"/></a>
                         <a><img data-icon="[/呲牙]" data-em="[d_f051]" src="${ctx }/js/activity/arclist/51.png"/></a>
                         <a class="delete"><img src="${ctx }/js/activity/arclist/delete.png"/></a>
                    </li> 
                    <li class="swiper-slide"> 
                         <a><img data-icon="[/嘘]" data-em="[d_f052]" src="${ctx }/js/activity/arclist/52.png"/></a>
                         <a><img data-icon="[/邪恶]" data-em="[d_f053]" src="${ctx }/js/activity/arclist/53.png"/></a>
                         <a><img data-icon="[/疑问]" data-em="[d_f054]" src="${ctx }/js/activity/arclist/54.png"/></a>
                         <a><img data-icon="[/右哼哼]" data-em="[d_f055]" src="${ctx }/js/activity/arclist/55.png"/></a>
                         <a><img data-icon="[/晕]" data-em="[d_f056]" src="${ctx }/js/activity/arclist/56.png"/></a>
                         <a><img data-icon="[/抓狂]" data-em="[d_f058]" src="${ctx }/js/activity/arclist/58.png"/></a>
                         <a><img data-icon="[/衰]" data-em="[d_f040]" src="${ctx }/js/activity/arclist/40.png"/></a>
                         <a><img data-icon="[/NO]" data-em="[d_f069]" src="${ctx }/js/activity/arclist/69.png"/></a>
                         <a><img data-icon="[/赞]" data-em="[d_f070]" src="${ctx }/js/activity/arclist/70.png"/></a>
                         <a><img data-icon="[/爱你]" data-em="[d_f071]" src="${ctx }/js/activity/arclist/71.png"/></a>
                         <a><img data-icon="[/勾引]" data-em="[d_f072]" src="${ctx }/js/activity/arclist/72.png"/></a>
                         <a><img data-icon="[/OK]" data-em="[d_f073]" src="${ctx }/js/activity/arclist/73.png"/></a>
                         <a><img data-icon="[/弱]" data-em="[d_f074]" src="${ctx }/js/activity/arclist/74.png"/></a>
                         <a><img data-icon="[/握手]" data-em="[d_f075]" src="${ctx }/js/activity/arclist/75.png"/></a>
                         <a><img data-icon="[/胜利]" data-em="[d_f076]" src="${ctx }/js/activity/arclist/76.png"/></a>
                         <a><img data-icon="[/猪头]" data-em="[d_f059]" src="${ctx }/js/activity/arclist/59.png"/></a>
                         <a><img data-icon="[/蔑视]" data-em="[d_f060]" src="${ctx }/js/activity/arclist/60.png"/></a>
                         <a><img data-icon="[/热气球]" data-em="[d_f045]" src="${ctx }/js/activity/arclist/45.png"/></a>
                         <a><img data-icon="[/炸鸡啤酒]" data-em="[d_f057]" src="${ctx }/js/activity/arclist/57.png"/></a>
                         <a><img data-icon="[/哔哔]" data-em="[d_f02]" src="${ctx }/js/activity/arclist/02.png"/></a>
                         <a class="delete"><img src="${ctx }/js/activity/arclist/delete.png"/></a>
                    </li>
                    <li class="swiper-slide"> 
                         <a><img data-icon="[/给力]" data-em="[d_f062]" src="${ctx }/js/activity/arclist/62.png"/></a>
                         <a><img data-icon="[/囧]" data-em="[d_f063]" src="${ctx }/js/activity/arclist/63.png"/></a>
                         <a><img data-icon="[/萌]" data-em="[d_f064]" src="${ctx }/js/activity/arclist/64.png"/></a>
                         <a><img data-icon="[/神马]" data-em="[d_f065]" src="${ctx }/js/activity/arclist/65.png"/></a>
                         <a><img data-icon="[/V]" data-em="[d_f066]" src="${ctx }/js/activity/arclist/66.png"/></a>
                         <a><img data-icon="[/囍]" data-em="[d_f067]" src="${ctx }/js/activity/arclist/67.png"/></a>
                         <a><img data-icon="[/织]" data-em="[d_f068]" src="${ctx }/js/activity/arclist/68.png"/></a>
                         <a><img data-icon="[/熊猫]" data-em="[d_f050]" src="${ctx }/js/activity/arclist/50.png"/></a>
                         <a><img data-icon="[/兔子]" data-em="[d_f047]" src="${ctx }/js/activity/arclist/47.png"/></a>
                         <a><img data-icon="[/元宵]" data-em="[d_f009]" src="${ctx }/js/activity/arclist/09.png"/></a>
                         <a><img data-icon="[/木马]" data-em="[d_f012]" src="${ctx }/js/activity/arclist/12.png"/></a>
                         <a><img data-icon="[/香皂]" data-em="[d_f013]" src="${ctx }/js/activity/arclist/13.png"/></a>
                         <a><img data-icon="[/马]" data-em="[d_f030]" src="${ctx }/js/activity/arclist/30.png"/></a>
                         <a><img data-icon="[/男示爱]" data-em="[d_f031]" src="${ctx }/js/activity/arclist/31.png"/></a>
                         <a><img data-icon="[/女示爱]" data-em="[d_f034]" src="${ctx }/js/activity/arclist/34.png"/></a>
                         <a><img data-icon="[/草泥马]" data-em="[d_f038]" src="${ctx }/js/activity/arclist/38.png"/></a>
                         <a><img data-icon="[/心碎]" data-em="[d_f077]" src="${ctx }/js/activity/arclist/77.png"/></a>
                         <a><img data-icon="[/爱心]" data-em="[d_f078]" src="${ctx }/js/activity/arclist/78.png"/></a>
                         <a><img data-icon="[/蛋糕]"data-em="[d_f079]" src="${ctx }/js/activity/arclist/79.png"/></a>
                         <a><img data-icon="[/红包]" data-em="[d_f080]" src="${ctx }/js/activity/arclist/80.png"/></a>
                         <a class="delete"><img src="${ctx }/js/activity/arclist/delete.png"/></a>
                    </li>
                    <li class="swiper-slide"> 
                         <a><img data-icon="[/飞机]" data-em="[d_f081]" src="${ctx }/js/activity/arclist/81.png"/></a>
                         <a><img data-icon="[/啤酒]" data-em="[d_f082]" src="${ctx }/js/activity/arclist/82.png"/></a>
                         <a><img data-icon="[/烛光]" data-em="[d_f083]" src="${ctx }/js/activity/arclist/83.png"/></a>
                         <a><img data-icon="[/礼物]" data-em="[d_f084]" src="${ctx }/js/activity/arclist/84.png"/></a>
                         <a><img data-icon="[/云]" data-em="[d_f085]" src="${ctx }/js/activity/arclist/85.png"/></a>
                         <a><img data-icon="[/沙尘]" data-em="[d_f086]" src="${ctx }/js/activity/arclist/86.png"/></a>
                         <a><img data-icon="[/太阳]" data-em="[d_f087]" src="${ctx }/js/activity/arclist/87.png"/></a>
                         <a><img data-icon="[/玫瑰]" data-em="[d_f088]" src="${ctx }/js/activity/arclist/88.png"/></a>
                         <a><img data-icon="[/下雨]" data-em="[d_f089]" src="${ctx }/js/activity/arclist/89.png"/></a>
                         <a><img data-icon="[/月亮]" data-em="[d_f090]" src="${ctx }/js/activity/arclist/90.png"/></a>
                         <a class="delete"><img src="${ctx }/js/activity/arclist/delete.png"/></a>
                    </li>
                </ul>
            </div>
            <div class="expagination" style=""></div>
        </section>
    </div>
    </div>
     
</div>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script src="${ctx }/js/jquery.showLoading.min.js"></script>
<script src="${ctx }/js/activity/js/idangerous.swiper-2.1.min.js"></script>
<script src="${ctx }/js/activity/js/expression.js"></script>

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
		 $("#replaceinp").attr("placeholder","请输入您要评论的内容...");
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
	 //点击输入框判断登录状态
	 $('#comment').click(function(){
		 if(userId==0){
				if(userId==0){
					$("#comment").blur();
				 	msgbox('提示','为了确保您的信息正常发布，请您填写相关信息。','确定',function(){
				 		 window.location.href='${phpIp}/wxokjia/reggoin.php';
				 	},'取消');
				 	return;
				}
			}
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
	        		    $('.x-z a').unbind("click");
	        		    $('.x-z a').click(function(){
	        		    	msgbox('提示','已赞过了，再赞他会骄傲的…','确认');
	        		    });
	        		    $('.x-z a').append('<em class="x-add">+1</em>');
						$('.x-z img').attr("src","${ctx }/js/activity/images/ze.png");
						$('.x-z em').css("color","#fd8b07");
				        $('.x-add').css({'position':'absolute', 'color':'#fd8b07','left':'0px','top':'0px'}).animate({top:'-30px',left:'0px'},'slow',function(){
				        $(this).fadeIn('fast').remove();
				        //var Num = parseInt($('.x-z em').text());
				        //Num++;
				        $('.x-z em').text(data.content.supports);
						$('.x-z img').attr("src","${ctx }/js/activity/images/zk.png");
						$('.x-z em').css("color","#7c7c7c");
				        });
				        //alert(data.message);
	        	   }else{
	        		   msgbox('提示',data.message,'确认');
	        	   }
	           },
	           error: function() {
	               msgbox('提示','点赞失败','确认');
	           }
	       });
		 });
		
		//评论
		 $('#commentBtn').click(function(){
	 		comment();
	 	});
		
		 $('#comment').click(function(){
			 if(userId==0){
					if(userId==0){
						 	msgbox('提示','简单注册一下吧，注册会员才有发布信息和参与活动的权利噢！','确定',function(){
						 		 window.location.href='${phpIp}/wxokjia/reggoin.php';
						 	},'取消');
						 	return;
					}
				}
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
function comment(){
		if(userId==0){
			if(userId==0){
				 	msgbox('提示','简单注册一下吧，注册会员才有发布信息和参与活动的权利噢！','确定',function(){
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
	 	var reg=/^[\w\u4e00-\u9fa5`~!@#$%^&*()+=|{}':;,\t// \[\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？～《》]+$/;
		if(!reg.test(content)){
			 msgbox('提示','不支持表情图片，您只能输入文字、数字、英文','确认');
			return;
		}
	 	var url="";
	 	if(replyId==0){
	 		url = '${ctx}/service/commiunity/saveJournalismReview.json';
	 	}else{
	 		url = '${ctx}/service/commiunity/saveJournalismReply.json';
	 	}
	 	if(content != '') {
	 		$('#commentBtn').unbind("click");
			for(var i=0; i<emperssion.length; i++){
				content=content.replace(emperssion[i][0], emperssion[i][1]);
			}
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
	 		    	$('#commentBtn').click(function(){
	 					comment();
	 				 });
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
	 					font();
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
}
 
//获取下页评论内容
function jump(nextNo) {
	$.ajax({
		    url: '${ctx}/service/commiunity/getJournalismReviewById.json',
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
            				newContent+= '<div class="one ex-four">'+replace_em(row.content)+'</div>';
            			}else{
            				if(row.replyType==1){
            					newContent+= '<div class="one ex-four">'+ '<span>回复</sapn>' +'<span>'+row.replyName+'(官方):</span>' +replace_em(row.content)+'</div>';
            				}else{
            					newContent+= '<div class="one ex-four">'+ '<span>回复</sapn>' +'<span>'+row.replyName+':</span>' +replace_em(row.content)+'</div>';
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
	 var ttotal=$("<div class='ttotal'></div>");
	 var tcontent=$("<div class='tcontent'></div>");
	 tk.append(ttotal);
	 ttotal.append(tcontent)
	 
	 tcontent.append("<div class='thead'><p>"+content+"</p></div>");
	 
	 var tbtn = $("<div class='tbtn'></div>");
	 tcontent.append(tbtn);
	 var btnA = $("<a>"+btn+"</a>");
	 
	 if(btn2!=null && btn2!="" && btn2!=undefined){
		 var btnB = $("<a class='cancel' style=' background-color:#b7b7b7'>"+btn2+"</a>");
		 tbtn.append(btnB);
		 btnB.click(function(){
			 $(".tk").remove();
		 });
		 
		 var btnA = $("<a style='margin-left: 20px;'>"+btn+"</a>");
	 }
	 tbtn.append(btnA);
	 
	 tcontent.append("<i class='tkt'></i><i class='tkr'></i>")
	 $(".ttotal").css("margin-top","-"+parseInt($(".tcontent").height()/2)+"px");
	
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
