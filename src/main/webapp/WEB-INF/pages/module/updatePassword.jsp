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
        			oldpassword: {
        				required: true,
        				regexPassword: true,
        				remote: {
       	                    type: "post",
       	                    url: "<%=path %>/index/getCurrUserOldPassword.do",
       	                    data: {
       	                    	oldpassword: function() {
       	                            return $("#oldpassword").val();
       	                        }
       	                    }
       	                }
        			},
        			newpassword: {
        				required: true,
        				regexPassword: true,
       					same:true
        			},
        			valipassword: {
        				required: true, 
        				rangelength: [6, 8], 
        				equalTo: "#newpassword"
       				}
        		},
        		messages: {
        			oldpassword: {
        				required: "请输入原密码",
        				regexPassword: '原密码只能输入数字和字母，长度应为6~8位!',  
        				remote: "原密码不正确，请重新输入！"
        			},
        			newpassword: {
        				required: "请输入新密码",
        				regexPassword: '新密码只能输入数字和字母，长度应为6~8位!',  
       					same:'新密码不能与老密码一样'
        			},
        			valipassword: {
       					required: "请输入确认密码",
                        rangelength: "确认密码应为6~8位",  
                        equalTo: "两次输入密码不一致"  
       				}
        		}
        	});
	    });
	    
	    function same(pwd) {  
            var oldPwd = $("#oldpassword").val();  
            if (oldPwd == pwd)  
                return false;  
            else  
                return true;  
        }  
	    
	    jQuery.validator.addMethod("same", function(value, element) {  
            return this.optional(element) || same(value);  
        }, "新密码不能与老密码重复");
	    
	    jQuery.validator.addMethod("regexPassword", function(value, element) {  
	        // return this.optional(element) || /^(?=^.{6,8}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[a-z]).*$/.test(value);
	    	return this.optional(element) || /^(?=^.{6,8}$)([a-zA-Z0-9]+)$/.test(value);  
	    }, "只能输入数字和字母(字符A-Z, a-z, 0-9)");
	    
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
					<div><input class="updatePwd y-x-xmm" type="password" id="oldpassword"  name="oldpassword" placeholder='请输入您的原密码' /><label for="oldpassword" class="error success">系统初始设置原密码为六个1!</label></div>
					<div><input class="updatePwd y-x-xmm" type="password" id="newpassword"  name="newpassword" placeholder='请输入您的新密码' /><label for="newpassword" class="error success">新密码只能输入数字和字母，长度应为6~8位!</label></div>
					<div><input class="updatePwd y-x-xmm" type="password" id="valipassword" name="valipassword" placeholder='请再次输入您的新密码' /><label for="valipassword" class="error success">确认密码需与新密码一致！</label></div>
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