<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>密码填写</title>
<link type="text/css" rel="stylesheet" href="${ctx }/css/loginStyle.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
</head>

<body>
    <div class="inpform">
        <form>
            <div class="inptxt radius6">
                <div><p><input type="text" placeholder="请输入六位以上的数字或字母密码" id="password1"/></p></div>
                <div><p><input type="text" placeholder="请再次输入密码" id="password2"/></p>
                </div>
            </div>
            <p class="subbtn">
                <input class="btn radius6 btred" type="button" value="确认提交" id="btn"/>
            </p>       
        </form>
    </div>
    <footer><a  id="return"></a></footer>
<script type="text/javascript">
$(function(){
	$("#return").click(function(){
		window.history.go(-1);
	});
	$("#btn").click(function(){
		if($("#password1").val().length==0 || $("#password2").val().length==0){
			msgbox('提示','请输入密码');
			return;
		}
		if(!($("#password1").val()==$("#password2").val())){
			msgbox('提示','俩次密码不一致');
			return;
		}
		var isRegist="${isRegist}";
		if(isRegist==1){
			$.ajax({
		           url: '${ctx }/service/user/regist.json',
		           cache: false,
		           type: 'post',
		           dataType: 'json',
		           data: {
		        	   cellphone: '${cellphone}',
			        	password: $("#password1").val(),
			        	estateId: '${estateId}'
		           },
		           success: function (data) {
		        	   //eval('data=' + data);
		        	   if(data.errorCode == 200) {
		        		   window.location.href='${ctx}/${url}?ID=${ID}&userId='+data.content.userId+'&sessionid='+data.content.sessionid+'tel='+data.content.tel+'&download=0';
		        	   }else{
		        		   msgbox('提示',data.message);
		        	   }
		           },
		           error: function() {
		               msgbox('提示','获取验证失败');
		           }
		     });	
			return null;
		}
		
		if(isRegist==2){
			$.ajax({
		           url: '${ctx }/service/user/changePassword.json',
		           cache: false,
		           type: 'post',
		           dataType: 'json',
		           data: {
		        	   cellphone: '${cellphone}',
			        	password: $("#password1").val()
		           },
		           success: function (data) {
		        	   //eval('data=' + data);
		        	   if(data.errorCode == 200) {
		        		   login();
		        	   }else{
		        		   msgbox('提示',data.message);
		        	   }
		           },
		           error: function() {
		               msgbox('提示','获取验证失败');
		           }
		     });	
			return null;
		}
		
		
		
	});
});
function login(){
	$.ajax({
        url: '${ctx }/service/user/login.json',
        cache: false,
        type: 'post',
        dataType: 'json',
        data: {
     	cellphone: '${cellphone}',
     	password: $("#password1").val()
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
