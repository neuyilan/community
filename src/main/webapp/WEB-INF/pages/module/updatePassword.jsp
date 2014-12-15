<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>修改密码</title>
	<link rel="stylesheet" type="text/css" href="<%=ctx%>/css/style.css" >
    <script src="<%=ctx%>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
   	<script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    <script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
	<style type="text/css"> 
		label.error  { 
			color:Red; 
			font-size:13px; 
			margin-left:5px; 
			padding-left:16px; 
		} 
		input::-ms-reveal{ display:none;}
	</style> 
    <script type="text/javascript" >
	    $(function () {
	    	//初始化表单并验证
        	$('#updateForm').validate({
                submitHandler:function(form){
                    $('#updateForm').form('submit', {
                        success:function(data){
                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                            alert(data.message);
                            window.location.href = '<%=ctx%>/index/main.do';
                        }
                    });
                },
            	errorClass: "error",
                success: function(label) {
            		label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
            	},
        		rules: {
        			newpassword: {
        				required: true,
       					minlength: 6
        			},
        			valipassword: {
       					required: true,
       					minlength: 6
       				}
        		},
        		messages: {
        			newpassword: {
        				required: "请输入新密码",
       					minlength: "新密码最少为6位"
        			},
        			valipassword: {
       					required: "请输入确认密码",
       					minlength: "确认密码最少为6位"
       				}
        		}
        	});
	    });
	    
	    function submitForm() {
	    	$('#updateForm').submit();
	    }
	</script>
</head>
<body class="bagcolr" style=" height:auto;">
<form id="updateForm" method="post" action="<%=ctx %>/business/businessUser/updateUserPassword.do" >
	<div class="wrapper wranews"  style=" overflow:visible;">
		<div class="newsrel">
			<div class="header-public"><span class="return" onclick="history.go(-1)"></span>修改密码</div>
				<div class="cont-l_1" id="cont-l_1" style="position:relative; top:57px;">
					<h2 class="title" id="jg">修改密码</h2>
					<div class="line3"></div>
					<div class="ip_1"><input class="iptnewtit" type="password" id="newpassword"  name="newpassword" placeholder='请输入您的新密码' /><label for="newpassword" class="error success" style=" display:block; float:right; margin-top:68px"></label></div>
					<br>
					<div class="ip_1"><input class="iptnewtit y-x-xmm" type="password" id="valipassword" name="valipassword" placeholder='请再次输入您的新密码' /><label for="valipassword" class="error success" style=" display:block; float:right; margin-top:40px"
					></label></div>
					<div class="no-float"></div>
					<div class="submtpres" id="submtpres_1">
						<input class="y-x-qrxg" type="button" name="" value="确认修改" onclick="submitForm();"/>
					</div>
				</div>
		</div>
	</div>
</form>
</body>
</html>