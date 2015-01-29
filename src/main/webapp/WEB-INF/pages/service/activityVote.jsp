<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<title>活动详情</title>
<link href="${ctx }/js/activity/css/activityRegistrationStyle.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/showLoading.css" rel="stylesheet" type="text/css" />
</head>

<body>
<input type="hidden" name="ID" id="ID" value="${ID }" />
<input type="hidden" name="rank" id="rank" value="${rank }" />
 <input type="hidden" name="replyId" id="replyId" value="" />
 <input type="hidden" name="state" id="state" value="${state }" />
 <input type="hidden" name="replyName" id="replyName" value="" />
<input type="hidden" name="startTime" id="startTime" value="${startTime }" />
<input type="hidden" name="endTime" id="endTime" value="${endTime }" />
<input type="hidden" name="endTime" id="dateTime" value="${dateTime }" />
<input type="hidden" name="time" id="dateTime" value="${dateTime}" />
<input type="hidden" name="flag" id="flag" value="${flag}" />
<input type="hidden" name="partakeTimeSlotId" id="partakeTimeSlotId" value="${partakeTimeSlotId}" />
<div id="bodyDiv" class="x-main">
<div class="scroll">
    <div class="x-total">
    	<div class="x-infor">
            <div class="x-head">
                <p class="x-title"><span>${title}</span></p>
            </div>
            <div class="x-jop">参与人数<br><span>${count }</span></div>
        </div>
        <div class="x-content">
            <div class="x-cx">
               <p>${actContent}</p>
            </div>
        </div>
    </div>
    <div class="x-total x-tp">
     	<p class="tp-tit">距离投票结束时间：<br><span id="tpli_counter"></span></p>
     	<section class="tp-sort">
     		<c:if test="${rank == 0}">
	        	<h1>最多可以选择<i>${votes }</i>项，投票后才可以看到结果</h1>
	        	<ul class="tp-hh <c:if test="${voteType == 1}">tp-font</c:if><c:if test="${voteType == 2}">tp-photo</c:if>"> 
		        	<c:forEach items="${list}" var="businessActivityVoteOptions" varStatus="status">
		        		<c:if test="${voteType == 1}">
		        			<li>
	                          <section>
	                              <h2>${businessActivityVoteOptions.content}</h2>
	                          </section>
	                          <label><input type="checkbox" name="optionsId" value="${businessActivityVoteOptions.optionsId}"/></label>
	                       </li>
		        		</c:if>
		        		<c:if test="${voteType == 2}">
		        			<li>
	                          <section>
	                              <p><img src="${ctx }/${businessActivityVoteOptions.image}"/></p>
	                          </section>
	                          <label><input type="checkbox" name="optionsId" value="${businessActivityVoteOptions.optionsId}"/></label>
	                       </li>
		        		</c:if>
		        		<c:if test="${voteType == 3}">
		        			<li>
	                          <section>
	                              <h2>${businessActivityVoteOptions.content}</h2>
	                              <p><img src="${ctx }/${businessActivityVoteOptions.image}"/></p>
	                          </section>
	                          <label><input type="checkbox" name="optionsId" value="${businessActivityVoteOptions.optionsId}"/></label>
	                       </li>
		        		</c:if>
		        	</c:forEach>
	        	</ul>
	        </c:if> 
	        <c:if test="${rank != 0}">
	        	<h1 class="tp-center">这里是目前的投票结果</h1> 
                <ul class="tp-result <c:if test="${voteType == 1}">tp-restit</c:if>">
                	<c:forEach items="${list}" var="businessActivityVoteOptions" varStatus="status">
                		<li>
	                		<section>
	                			<c:if test="${voteType == 1}">
			        				<h2>${businessActivityVoteOptions.content}</h2>
			        				<div class="tp-rediv tp-ret">
	   									<p><i class="tp-reic reso" style="width:${businessActivityVoteOptions.percentage};background-color:<c:choose><c:when test="${status.index%5 == 0}">#a5ce45</c:when><c:when test="${status.index%5 == 1}">#e33e68</c:when><c:when test="${status.index%5 == 2}">#feb04f</c:when><c:when test="${status.index%5 == 3}">#25a4de</c:when><c:when test="${status.index%5 == 4}">#bf74d9</c:when></c:choose>"></i></p>
		                               	<p>票数：<span>${businessActivityVoteOptions.count}</span> (<span>${businessActivityVoteOptions.percentage}</span>)</p>
	                              	</div>
			        			</c:if>
			        			<c:if test="${voteType == 2}">
		                            <div class="tp-table">
		                                <p class="tp-rep tp-tc"><img src="${ctx }/${businessActivityVoteOptions.image}"/></p>
		                                <div class="tp-rediv tp-tc tp-re">
	   										<p><i class="tp-reic reso" style="width:${businessActivityVoteOptions.percentage};background-color:<c:choose><c:when test="${status.index%5 == 0}">#a5ce45</c:when><c:when test="${status.index%5 == 1}">#e33e68</c:when><c:when test="${status.index%5 == 2}">#feb04f</c:when><c:when test="${status.index%5 == 3}">#25a4de</c:when><c:when test="${status.index%5 == 4}">#bf74d9</c:when></c:choose>"></i></p>
		                                    <p>票数：<span>${businessActivityVoteOptions.count}</span> (<span>${businessActivityVoteOptions.percentage}</span>)</p>
		                                </div> 
		                            </div>
			        			</c:if>
			        			<c:if test="${voteType == 3}">
			        				<h2>${businessActivityVoteOptions.content}</h2>
		                            <div class="tp-table">
		                                <p class="tp-rep tp-tc"><img src="${ctx }/${businessActivityVoteOptions.image}"/></p>
		                                <div class="tp-rediv tp-tc tp-re">
	   										<p><i class="tp-reic reso" style="width:${businessActivityVoteOptions.percentage};background-color:<c:choose><c:when test="${status.index%5 == 0}">#a5ce45</c:when><c:when test="${status.index%5 == 1}">#e33e68</c:when><c:when test="${status.index%5 == 2}">#feb04f</c:when><c:when test="${status.index%5 == 3}">#25a4de</c:when><c:when test="${status.index%5 == 4}">#bf74d9</c:when></c:choose>"></i></p>
		                                    <p>票数：<span>${businessActivityVoteOptions.count}</span> (<span>${businessActivityVoteOptions.percentage}</span>)</p>
		                                </div> 
		                            </div>
			        			</c:if>
	                              
	                          </section>
                           </li>
                	</c:forEach>
                </ul>  
	        </c:if>
        </section>
                <div class="x-zs" style=" margin-top:10px;">
                    <a class="x-btn x-djs">
            			<span id="tpli_counter">报名已结束</span>
	            	</a>
	                <a class="x-btn x-qg">
	                	<span>我要投票</span>
	                </a>
	                <a class="x-btn x-pm" id="seeRank">
	                	<span>查看我的报名信息</span>
	                </a>
                    <span class="x-z">
                        <a><img src="${ctx }/js/activity/images/zk.png" width="23" height="30"></a>
                        <em>${supports}</em>
                    </span>
               </div>
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
<script src="${ctx }/js/activity/js/vote.js"></script>
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
	var flag = $('#flag').val();
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
				$(".x-djs").css("display","block");//倒计时
				$(".x-pm").css("display","none");//排名
				$(".x-djs").html("已投票");
			}
		}else if(currState == 2) {//已结束
			if(currRank == 0) {//未投票
				$(".x-djs").css("display","block");//倒计时
				$(".x-pm").css("display","none");//排名
				$(".x-djs").html("已结束");
			}else{//已投票
				$(".x-djs").css("display","block");//倒计时
				$(".x-pm").css("display","none");//排名
				$(".x-djs").html("已投票");
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
	     var optionsId = $("[name=optionsId]:checked"); 
	     var ids="";
	     if(optionsId.size()==0){
	    	 msgbox('提示','请选择投票项','确认');
	    	 close();
	    	 return false;
	     }
	     for(var i=0;i<optionsId.size();i++){
	    	 ids+=optionsId.eq(i).val()+",";
	     }
	     $.ajax({
	           url: '${ctx}/business/businessActivityVoteInformation/save.json',
	           cache: false,
	           type: 'post',
	           dataType: 'json',
	           data: {
	           	ID: '${actId}',
	           	tel: '${tel}', 
	           	userId: '${userId}',
	           	ids: ids.substr(0,ids.length-1)
	           },
	           success: function (data) {
	        	   //eval('data=' + data);
	        	   if(data.errorCode == 200) {
	        		   msgbox('提示',data.message,'确认');
	        		   close();
	        		   setTimeout(function(){
	        			   location.reload();
	        		   },1000);
	        		  
	        	   }else{
	        		   msgbox('提示',data.message,'确认');
	        		   close();
	        	   }
	           },
	           error: function() {
	               msgbox('提示','参与失败','确认');
	               close();
	           }
	       });
	
	});
	
	//查看排名
	$("#seeRank").click(function(e) {
		if(userId==0){
			if(window.confirm('参加活动需要登录！！是否进去登录页？')){
				 window.location.href='${ctx}/service/user/loginIndex.json?type=4&ID=${actId}';
                //alert("确定");
                return null;
             }else{
                //alert("取消");
                return null;
            }
		}
		var timeSlotId = $("#partakeTimeSlotId").val(); 
		window.location.href='${ctx}/service/activities/registrationInformation.json?ID=${actId}&userId=${userId}&tel=${tel}&timeSlotId='+timeSlotId;
     });
	
	
	
	
	 $("#content").click(function(){
		 replyId = 0;//点击回复人id
		 replyName = "";//点击回复人姓名
		 replyType = 0;//点击回复人类型
		 $("#replaceinp").attr("placeholder","回复:");
	 });
	//点赞
	 $('.x-z a').click(function(){
		 if(userId==0){
				if(window.confirm('点赞活动需要登录！！是否进去登录页？')){
					 window.location.href='http://10.1.17.210/wxokjia/reggoin.php';
	                //alert("确定");
	                return null;
	             }else{
	                //alert("取消");
	                return null;
	            }
			}
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
        		   msgbox('提示',data.message,'确认');
        		   close();
        	   }
           },
           error: function() {
               msgbox('提示','评论失败','确认');
               close();
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
			 close();
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
	 		      close();
	 		    }
	 		});
	 	}else{
	 		 msgbox('提示','评论不能为空','确认');
	 		close();
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
	 
	 $(".hd-sort li").click(function(e) {
		 if(!$(this).hasClass("hd-end")){
			 $(".hd-sort li").removeClass("hd-sel");
			 $(this).addClass("hd-sel");
			 $("#timeSlotId").val($(this).find("input").first().val()); 
		 }
     });
	 
	 $(".tp-hh li input").click(function(e) {
		 if($(".tp-hh li input:checked").size()>"${votes}"){
			 $(this).removeAttr("checked");
			 msgbox('提示',"最多可以选择${votes }项");
			 return null;
		 }
		 if($(this).attr("checked")=="checked"){
			 $(this).parent().css("background-image","url(${ctx }/js/activity/images/rc.jpg)");
			 $(this).parent().parent().addClass("hh-active");
		 }else{
			 $(this).parent().css("background-image","url(${ctx }/js/activity/images/rnc.jpg)");
			 $(this).parent().parent().removeClass("hh-active");
		 }
    });
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
          					close();
              			});
          			}
        			
            	}
            }
            
	    },
	    error: function () {
	        msgbox('提示','获取下页评论内容失败','确认');
	        close();
	    }
	});
}
function msgbox(title,content,btn){
	 var shtml="<div class='tk'><div class='tcontent'>";
	 if(title!=""){
	     shtml+="<p class='title'>"+title+"</p>";
	 }
	 shtml+="<div class='thead'><p>"+content+"</p></div>";
	 shtml += "<div class='tbtn'><a>"+btn+"</a></div>";
	 shtml += "</div></div>";
	 $("body").append(shtml);
	 $(".tcontent").css("margin-top","-"+parseInt($(".tcontent").height()/2)+"px");
}
function close(){
	$(".tbtn a").click(function(e) {
     $(".tk").remove();
 });

}

</script>

