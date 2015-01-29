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
<link href="${ctx }/js/activity/css/activityRegistrationStyle.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="hdjs">
		<p>您好，您参加的活动是<span>【<i>${title}</i>活动】</span></p>   
		<p>您报名的场次入场时间为：</p>
		<span class="hdtime">${time}</span>
	</div>
	<form action="${ctx}/business/businessActivityRegistrationInformation/save.json" method="post" id="ff">
		<input type="hidden" name="actId" value="${ID}" id="actId">
		<input type="hidden" name="timeSlotId" value="${timeSlotId}" id="timeSlotId">
		<input type="hidden" name="userId" value="${userId}" id="userId">
		<section class="hdinfo">
	 		<ul>
	 			<c:forEach items="${AttributeValues}" var="value" >
				 	<c:choose>
						<c:when test="${value == 1}">
							<li>
				                <div><p><span>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</span><input type="text" name="nickname" value="${nickname}" id="nickname"/></p></div>  
				            </li>
						</c:when>
						<c:when test="${value == 2}">
							<li>
			                    <div><p><span>真实姓名</span><input type="text"  name="realname" value="${realname}" id="realname"/></p></div>  
			                </li>
						</c:when>
						<c:when test="${value == 3}">
							<li>
			                    <div><p><span>联系电话</span><input type="text"  name="tel" value="${tel}" id="tel"/></p></div>  
			                </li>
						</c:when>
						<c:when test="${value == 4}">
							<li>
			                    <div><p><span>生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span><input type="text"  name="birthday" id="birthday"/></p></div>  
			                </li>
						</c:when>
						<c:when test="${value == 5}">
							<li>
			                    <div><p><span>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</span><input type="text"  name="age" id="age"/></p></div>  
			                </li>
						</c:when>
						<c:when test="${value == 6}">
							<li>
			                    <div><p><span>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</span><input type="text"  name="job" id="job"/></p></div>  
			                </li>
						</c:when>
						<c:when test="${value == 7}">
							<li>
			                    <div><p><span>身&nbsp;份 &nbsp;证</span><input type="text"  name="ID" id="ID"/></p></div>  
			                </li>
						</c:when>
						<c:when test="${value == 8}">
							<li>
			                    <div><p><span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</span><input type="text"  name="email" id="email"/></p></div>  
			                </li>
						</c:when>
						<c:when test="${value == 9}">
							<li>
			                    <div><p><span>小&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</span><input type="text"  name="addr" id="addr"/></p></div>  
			                </li>
						</c:when>
					</c:choose>
				</c:forEach>	
            </ul>    
		</section>
		<p class="hdsub"><input type="button" value="确认提交"  id="ffSubmit"/></p>
	</form>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$("#ffSubmit").click(function(){
		var az=/^\S{1,32}$/;
		if($("#nickname").val()!=undefined){
			if(az.test($("#nickname").val())!=true)
			{
				if($("#nickname").val().length==0){
					msgbox('提示',"昵称不能为空",'确认');
					close();
				}else{
					msgbox('提示',"昵称过长",'确认');
					close();
				}
				return false;
			}
		}
		if($("#realname").val()!=undefined){
			if(az.test($("#realname").val())!=true)
			{
				if($("#realname").val().length==0){
					msgbox('提示',"真实姓名不能为空",'确认');
					close();
				}else{
					msgbox('提示',"真实姓名过长",'确认');
					close();
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
					close();
				}else{
					msgbox('提示',"请输入真实电话信息",'确认');
					close();
				}
				return false;
			}
		}
		az=/^\S{1,32}$/;
		if($("#birthday").val()!=undefined){
			if(az.test($("#birthday").val())!=true)
			{
				if($("#birthday").val().length==0){
					msgbox('提示',"生日不能为空",'确认');
					close();
				}else{
					msgbox('提示',"生日过长",'确认');
					close();
				}
				return false;
			}
		}
		az=/^[\d]{1,11}$/;
		if($("#age").val()!=undefined){
			if(az.test($("#age").val())!=true)
			{
				if($("#age").val().length==0){
					msgbox('提示',"年龄不能为空",'确认');
					close();
				}else{
					msgbox('提示',"请输入真实年龄",'确认');
					close();
				}
				return false;
			}
		}
		az=/^\S{1,32}$/;
		if($("#job").val()!=undefined){
			if(az.test($("#job").val())!=true)
			{
				if($("#job").val().length==0){
					msgbox('提示',"职业不能为空",'确认');
					close();
				}else{
					msgbox('提示',"职业过长",'确认');
					close();
				}
				return false;
			}
		}
		az=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if($("#ID").val()!=undefined){
			if(az.test($("#ID").val())!=true)
			{
				if($("#ID").val().length==0){
					msgbox('提示',"身份证不能为空",'确认');
					close();
				}else{
					msgbox('提示',"请输入您的真实身份证号",'确认');
					close();
				}
				return false;
			}
		}
		az= /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if($("#email").val()!=undefined){
			if(az.test($("#email").val())!=true)
			{
				if($("#email").val().length==0){
					msgbox('提示',"邮箱不能为空",'确认');
					close();
				}else{
					msgbox('提示',"邮箱格式不正确",'确认');
					close();
				}
				return false;
			}
		}
		az=/^\S{1,32}$/;
		if($("#addr").val()!=undefined){
			if(az.test($("#addr").val())!=true)
			{
				if($("#addr").val().length==0){
					msgbox('提示',"地址不能为空",'确认');
					close();
				}else{
					msgbox('提示',"地址过长",'确认');
					close();
				}
				return false;
			}
		}
		$.ajax({
	           url: '${ctx}/business/businessActivityRegistrationInformation/save.json',
	           cache: false,
	           type: 'post',
	           dataType: 'json',
	           data: {
	        	actId: $("#actId").val(),
	        	timeSlotId: $("#timeSlotId").val(), 
	        	userId: $("#userId").val(),
	        	nickname: $("#nickname").val(),
	        	realname: $("#realname").val(),
	        	tel: $("#tel").val(),
	        	birthday: $("#birthday").val(),
	        	age: $("#age").val(),
	        	job: $("#job").val(),
	        	ID: $("#ID").val(),
	        	email: $("#email").val(),
	        	addr: $("#addr").val(),
	        	title:"您的报名已成功，时间为【${time}】,请牢记时间准时参加！"
	           },
	           success: function (data) {
	        	   //eval('data=' + data);
	        	   if(data.errorCode == 200) {
	        		   alert("您的报名已成功，时间为【${time}】,请牢记时间准时参加！");
                       window.location.href = '${ctx}/service/activities/getActivitiesDetailsById.json?ID=${ID}&userId=${userId}&tel=${tel}';
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
	})
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
</body>
</html>
