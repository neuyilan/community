<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户登录</title>
<link type="text/css" rel="stylesheet" href="${ctx }/css/loginStyle.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
</head>

<body>
    <div class="inpform">
        <form>
            <div class="inptxt radius6">
                <div><p><span>账 户 名&nbsp;</span><input type="text" placeholder="请输入手机号" id="cellphone"/></p></div>
                <div><p><span>登录密码&nbsp;</span><input type="text" placeholder="请输登录密码" id="password"/></p></div>
            </div>
            <p class="logbtn">
                <span><a><input class="btn radius6 btgreen" type="button" value="快速注册" id="regist"/></a></span>
                <span><a><input class="btn radius6 btred" type="button" value="登 录" id="login"/></a></span>
            </p>
            <p class="logfp" id="forget">
                <a>忘记密码？</a>
            </p>
        </form>
    </div>
    <div class="share">
        <div class="stitle">
            <hr>
            <p>使用以下方式登录</p>
        </div>
        <div class="sharec">
            <a>
               <i></i>
               <span>QQ</span> 
            </a>
            <a>
               <i></i>
               <span>微信</span> 
            </a>
        </div>
    </div>
    <footer><a id="return"></a></footer>
<script type="text/javascript">
$(function(){
	$("#login").click(function(){
		$.ajax({
	           url: '${ctx }/service/user/login.json',
	           cache: false,
	           type: 'post',
	           dataType: 'json',
	           data: {
	        	cellphone: $("#cellphone").val(),
	        	password: $("#password").val()
	           },
	           success: function (data) {
	        	   console.log(data)
	        	   //eval('data=' + data);
	        	   if(data.errorCode == 200) {
	        		   window.location.href='${ctx}/${url}?ID=${ID}&userId='+data.content.userId+'&sessionid='+data.content.sessionid+'tel='+data.content.tel+'&download=0';
	        	   }else{
	        		   msgbox('提示',data.message);
	        	   }
	           },
	           error: function() {
	               msgbox('提示','登录失败');
	           }
	       });		
	});
	$("#return").click(function(){
		window.history.go(-1);
	});
	$("#regist").click(function(){
		window.location.href='${ctx}/service/commiunity/index.json?type=${type}&ID=${ID}';
	});
	$("#forget").click(function(){
		window.location.href='${ctx}/service/user/resetIndex.json?type=${type}&ID=${ID}';
	});
	
})
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
