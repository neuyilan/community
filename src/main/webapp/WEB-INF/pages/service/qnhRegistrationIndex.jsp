<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<title>排名列表</title>
<link href="${ctx }/js/activity/css/activityRegistrationStyle.css?t=20150211" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="hdjs">
		<p>您好，您参加的活动是<span>【<i>${title}</i>活动】</span></p>   
	</div>
	<form action="${ctx}/business/activities/savebusinessActivityQnhInformation.json" method="post" id="ff">
		<input type="hidden" name="actId" value="${ID}" id="actId">
		<input type="hidden" name="userId" value="${userId}" id="userId">
		<section class="hdinfo">
	 		<ul>
				<li>
                    <div><p><span>真实姓名</span><input type="text"  name="realname" value="${realname}" id="realname"/></p></div>  
                </li>
	            <li>
                    <div><p><span>联系电话</span><input type="text"  name="tel" value="${tel}" id="tel"/></p></div>  
                </li>
            </ul>    
		</section>
		<p class="hdsub"><input type="button" value="确认提交"  id="ffSubmit"/></p>
	</form>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$("#ffSubmit").click(function(){
		var az=/^\S{1,32}$/;
		if($("#realname").val()!=undefined){
			if(az.test($("#realname").val())!=true)
			{
				if($("#realname").val().length==0){
					msgbox('提示',"真实姓名不能为空",'确认');
					
				}else{
					msgbox('提示',"真实姓名过长",'确认');
					
				}
				return false;
			}
		}
		az=/^\S[\d-]{8,11}$/;
		if($("#tel").val()!=undefined){
			if(az.test($("#tel").val())!=true)
			{
				if($("#tel").val().length==0){
					msgbox('提示',"联系电话不能为空",'确认');
					
				}else{
					msgbox('提示',"请输入真实电话信息",'确认');
					
				}
				return false;
			}
		}
		$.ajax({
	           url: '${ctx}/service/activities/savebusinessActivityQnhInformation.json',
	           cache: false,
	           type: 'post',
	           dataType: 'json',
	           data: {
	        	actId: $("#actId").val(),
	        	userId: $("#userId").val(),
	        	realname: $("#realname").val(),
	        	tel: $("#tel").val()
	           },
	           success: function (data) {
	        	   //eval('data=' + data);
	        	   if(data.errorCode == 200) {
	        		   msgbox('提示',"您的报名已成功，时间为【${time}】,请牢记时间准时参加！",'确认',function(){
	                       window.location.href = '${ctx}/service/activities/getActivitiesDetailsById.json?ID=${ID}&userId=${userId}&tel=${tel}';
	        		   });
	        	   }else{
	        		   msgbox('提示',data.message,'确认');
	        		   
	        	   }
	           },
	           error: function() {
	               msgbox('提示','评论失败','确认');
	               
	           }
	       });
	})
function msgbox(title,content,btn,fun){
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
