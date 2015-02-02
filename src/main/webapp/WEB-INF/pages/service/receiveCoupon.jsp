<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<title>领取优惠券</title>
<link href="${ctx }/js/activity/css/activityRegistrationStyle.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div class="lq-div">
        <p class="title">请您填写<span>手机号码</span>，通过<span>短信接收</span>优惠券</p>
        <form>
            <input type="text" id="cellphone" name="cellphone" />
            <p class="lq-btn"><input class="x-qg" type="button" id="ffSubmit" value="确认提交"/></p>
        </form>
    </div>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$("#ffSubmit").click(function(){
		var az=/^[0-9]{11}$/;
		if($("#cellphone").val()!=undefined){
			if(az.test($("#cellphone").val())!=true)
			{
				if($("#cellphone").val().length==0){
					msgbox('提示',"联系电话不能为空",'确定');
					close()
				}else{
					msgbox('提示',"请输入真实电话信息",'确定');
					

				}
				return false;
			}
		}
		$.ajax({
	           url: '${ctx}/service/activities/receiveCoupon.json',
	           cache: false,
	           type: 'post',
	           dataType: 'json',
	           data: {
	        	actId: '${actId}',
	        	userId: '${userId}',
	        	cellphone:$("#cellphone").val()
	           },
	           success: function (data) {
	        	   //eval('data=' + data);
	        	   if(data.errorCode == 200) {
	        		   msgbox('提示',data.message,'确定');
	        		   

	        		   self.location=document.referrer;
	        	   }else{
	        		   msgbox('提示',data.message,'确定');
	        		   

	        	   }
	           },
	           error: function() {
	               msgbox('提示','评论失败','确定');
	               
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
