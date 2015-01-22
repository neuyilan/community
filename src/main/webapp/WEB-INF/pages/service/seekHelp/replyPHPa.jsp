<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>回复</title>
<link href="${ctx }/js/activity/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/showLoading.css" rel="stylesheet" type="text/css" /> 
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
</head>
<body>
	<header class="header">
		<h1>回复</h1>
		<a class="a-back"></a> 
		<a class="a-searchbtn radius10 a-hf" id="send">发 送</a>
	</header>
	<div class="bl-winp hf-winp">
		<div class="bl-ninp">
			<textarea placeholder="请输入回复内容..." id="CommentStr"></textarea>
			<p class="bl-inpfont">
				还可以输入<span>280</span>个汉字
			</p>
		</div>
	</div>
<script src="${ctx}/js/activity/js/jquery-1.7.2.min.js"></script>
<script src="${ctx}/js/jquery.showLoading.min.js"></script>
<script>    

$(function(){
	   alert("dddd");

});
$(document).ready(function(){
	
	 $('#send').click(function() {		
		 
			$.ajax({
	 		    url: 'http://wx.bqsqcm.com/okjiashop/mobile/mindex.php',
	 		    cache: false,
	 		    data: {},
	 		    type: 'get', 
	            dataType: 'json',
	 		    success: function (data) {
	            	for(var i=0;i<data.length;i++) {
	            		$("#thumb").val(data[i].id);
	            		$("#publisherId").val(data[i].name); 
	            	}
	 		    },
	 		    error: function () {
	 		       msgbox('提示','评论失败');
	 		    }
	 		});
			
			
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
			           	publisherId : '${publisherId}',
			           	replyId: '${replyId}' ,
			           	replyName: '${replyName}',
		 		    	replyType: '${replyType}'
		 		    },
		 		    type: 'post',
		            dataType: 'json',
		 		    success: function (data) {
		 	     	   if(data.errorCode == 200) {
		 	     		 msgbox('提示','评论成功');
		 	      	   }else{
		 	      		 msgbox('提示','评论失败'); 
		 	      	   }
		 		    	
		 		    },
		 		    error: function () {
		 		       msgbox('提示','评论失败');
		 		    }
		 		});
		 	}else{
		 		 msgbox('提示','评论不能为空');
		 		return;
		 	}
		 });
	
	$("#CommentStr").keyup(function(){
	     var length = 280;
	     var content_len = $("#CommentStr").val().length;
	     var in_len = length-content_len;    
	     if(in_len >=0){
	         $(".bl-inpfont").html('您还可以输入'+in_len+'字');
	     }else{
	         $(".bl-inpfont").html('您还可以输入'+in_len+'字');
	        return false;
	     }
	});
});


$(".a-back").click(function(e) {
	window.history.go(-1);
});

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
