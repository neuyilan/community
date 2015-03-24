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
<link href="${ctx }/js/activity/css/activityRegistrationStyle.css?t=20150211" rel="stylesheet" type="text/css" />
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
	           url: '${activityIp}/service/activities/receiveCoupon.json',
	           cache: false,
	           data: {
	        	actId: '${actId}',
	        	userId: '${userId}',
	        	cellphone:$("#cellphone").val()
	           },
	           type: 'get',
	           dataType: 'jsonp',
	           jsonp: "jsoncallback",
	           jsonpCallback:"ajaxTestFn",
	           success: function (data) {
	        	   //eval('data=' + data);
	        	   if(data.errorCode == 200) {
	        		   msgbox('提示',data.message,'确定',function(){
	        			   self.location='${ctx}/service/activities/getActivitiesDetailsById.json?ID=${actId}&userId=${userId}&tel=${tel}';
	        		   });
	        	   }else{
	        		   msgbox('提示',data.message,'确定');
	        		   

	        	   }
	           },
	           error: function() {
	               msgbox('提示','评论失败','确定');
	               
	           }
	       });
	})
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
function ajaxTestFn(date){
}	

</script>
</body>
</html>
