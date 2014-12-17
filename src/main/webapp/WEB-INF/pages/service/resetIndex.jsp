<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>手机号验证</title>
<link type="text/css" rel="stylesheet" href="${ctx }/css/loginStyle.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
</head>

<body>
    <div class="inpform">
        <form>
            <div class="inptxt radius6">
                <div><p><input type="text" id="cellphone" name="cellphone" placeholder="请输入手机号"/></p></div>
                <div>
                    <p class="inpvai">
                        <input type="text" placeholder="请填写验证码" name="verifyCode" id="verifyCode"/>
                        <span><input class="btn radius6 btgreen getyzm" type="button" value="获取验证码" id="getCode"/><input class="btn radius6 btgray repget" type="button" value="重新获取(60)"/></span>
                    </p>
                </div>
            </div>
            <p class="subbtn">
                <input class="btn radius6 btred" type="button" value="重置密码" id="btn"/>
            </p>
        </form>
    </div>
    <footer><a  id="return"></a></footer>
<script type="text/javascript">
$(function(){
	$("#return").click(function(){
		window.history.go(-1);
	});
	$("#getCode").click(function(){
		var ze=/^[0-9]{11}$/
		if(!ze.test($("#cellphone").val())){
			msgbox('提示','请输入正确手机号');
			return;
		}
		$(".getyzm").css("display","none");
		$(".repget").css("display","inline");
		time=$(".repget").val().substr(5,2);
		int=setInterval(djs,1000);
		$.ajax({
	           url: '${ctx }/service/verify/getCode.json',
	           cache: false,
	           type: 'post',
	           dataType: 'json',
	           data: {
	        	cellphone: $("#cellphone").val(),
	        	type: 1
	           },
	           success: function (data) {
	        	   //eval('data=' + data);
	        	   if(data.errorCode == 200) {
	        	   }else{
	        		   msgbox('提示',data.message);
	        	   }
	           },
	           error: function() {
	               msgbox('提示','获取验证失败');
	           }
	       });		
	})
	$("#btn").click(function(){
		var ze=/^[0-9]{11}$/
		if(!ze.test($("#cellphone").val())){
			msgbox('提示','请输入正确手机号');
			return;
		}
		if($("#verifyCode").val().length==0){
			msgbox('提示','请输入验证码');
			return;
		}
		$.ajax({
	           url: '${ctx }/service/verify/verifyCode.json',
	           cache: false,
	           type: 'post',
	           dataType: 'json',
	           data: {
	        	cellphone: $("#cellphone").val(),
	        	verifyCode: $("#verifyCode").val()
	           },
	           success: function (data) {
	        	   //eval('data=' + data);
	        	   if(data.errorCode == 200) {
	        		   window.location.href='${ctx}/service/user/passwordIndex.json?cellphone='+$("#cellphone").val()+'&type=${type}&ID=${ID}&isRegist=2';
	        	   }else{
	        		   msgbox('提示',data.message);
	        	   }
	           },
	           error: function() {
	               msgbox('提示','获取验证失败');
	           }
	       });		
		
	})
	   
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
var time,int;
function djs(){
	if(time>0){
	    time--;
		$(".repget").val("重新获取("+time+")");
	}
	else if(time==0){
		clearInterval(int);
	    $(".getyzm").css("display","inline");
	    $(".repget").css("display","none");
		$(".repget").val("重新获取(60)");
	}
}

</script>
</body>
</html>
