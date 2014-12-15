<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%   
  String path = request.getContextPath();   
  String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>登陆</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/style.css" >
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/adaptive-2.css" >
	<script type="text/javascript" src="<%=ctx %>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=ctx %>/js/jquery.validate.min.js"></script>
		<!--<script>
		window.onload=function(){
			var oWranews=document.getElementsByClassName('wranews')[0];
			var oBusswi=document.getElementsByClassName('busswi')[0];
			var oClose=document.getElementById('close');
			var oBlock=document.getElementById('block');
			var oSidebar=document.getElementsByClassName('sidebar')[0]
			var oHeigth=document.body.scrollHeight;
			
			oBlock.onclick=function(){
			
				oSidebar.style.height=oHeigth-40+'px';
				
				oBusswi.style.display='block';
			}
			
			oClose.onclick=function(){
				blocks();
			}
		
			function blocks(){
			oBusswi.style.display='none';
			}
			blocks();
		}
		</script>-->
		<style type="text/css"> 
			* { 
			font-size: 14px; 
			} 
			#loginForm label.error 
			{ 
			color:Red; 
			font-size:13px; 
			margin-left:5px; 
			padding-left:16px; 
			background:url("error.png") left no-repeat; 
			} 
			input::-ms-reveal{ display:none;}
		</style> 
</head>
<body class="bg">                      
	<div class="zj">
		<form name="loginForm" id="loginForm" method="post" action="<%=ctx %>/index/login.do">
		    <p>OK家社区管理后台</p>
		    <input class="name" type="text" id="userEmail" name="userEmail" placeholder='请输入邮箱' />
			 <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" class="keyword">
		    <!-- 
			    <div class="keyword"><input id="searbox2" type="password" id="userPassword" name="userPassword" placeholder='请输入密码' /> 
				<input id="searbut2" type="button" value="" /></div>
			-->
			<!--
				<div><label class="re">
					<input class="radiostyle" type="radio" name="remember" value="下次自动登录" id="remember">下次自动登录</label>
					<span class="wm">忘记密码？</span>
				</div> 
			-->
			<div id="message" style="text-align: center;"></div>
			<div class="line"></div>
			<input id="qrbut2" type="button" value="登 录" />
		</form>
	</div>
	
	<div class="footer">
	    <div class="keep">京ICP备11017824号-4 / 京ICP证130164号</div>
	    <div class="footer-nav">
	        <ul>
	            <li class="copyright">Copyright &copy;2006-2014<i>zhangjia</i></li>
	            <li><a href="#">关于我们</a></li>
	            <li><a href="#">联系我们</a></li>
	            <li><a href="#">版权声明</a></li>
	            <li><a href="#">免责声明</a></li>
	            <li><a href="#">关于隐私</a></li>
	            <li><a href="#">帮助</a></li>
	        </ul>
	    </div>
	</div>
</body>
</html>
<script type="text/javascript">
        $(function() {
        	$(document).keyup(function(event){
        		  if(event.keyCode ==13){
        		    $("#qrbut2").trigger("click");
        		  }
        	});
        	
        	//初始化表单并验证
        	$('#loginForm').validate({
        		//debug:true,	 
				event:"keyup" || "blur", 
				//手动设置错误信息的显示方式 
                errorPlacement: function(error, element) { 
                    //error.appendTo(element.parent()); 
                    $('#message').html('');
                	$('#message').append(error);
                }, 
        		rules: {
        			userEmail: {
        				required: true,
        				email: true
        			},
       				userPassword: {
       					required: true,
       					minlength: 6,
       					maxlength: 8
       				}
        		},
        		messages: {
        			userEmail: {
       					required: "请输入邮箱",
       					email: "请输入正确的邮箱格式"
        			},
       				userPassword: {
       					required: "请输入密码",
       					minlength: "密码最少为6位",
       					maxlength: "密码最多为8位"
       				}
        		}
        	});
        	$('#qrbut2').click(function() {
        		$('#loginForm').submit();
        	});
        	$('#searbut2').click(function() {
        		$('#loginForm').submit();
        	});
        });
</script>        