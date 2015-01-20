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
		  
 });
 
//当状态改变的时候执行的函数 
 function handle() {
	//document.getElementById('msg').innerHTML='输入的文字长度为：'+document.getElementById('txt').value.length; 
	$("#replaceinp").val(" ");
	if($("#CommentStr").val().length==0){
		$("#replaceinp").val("");
		$("#replaceinp").attr("placeholder","回复："+replyName);
	}
 } 
 
 function help_dianzhan()
 {
	    if($("#noZan").val() == 'Y')
	    {
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
             $('#plusOne').text('+1');
			 $('#supports').text(data.message);
     		 $("#supTmp").val( parseInt($("#supTmp").attr("value"))+1);
     	   }else{
     		  $("#supTmp").val( $("#supTmp").attr("value"));
 			 $('#supports').text(data.message);
     	   }
        },
        error: function() {
        	 $("#supTmp").val( $("#supTmp").attr("value"));
			 $('#supports').text('点赞失败');
        }
    });

}

//获取下页评论内容
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
