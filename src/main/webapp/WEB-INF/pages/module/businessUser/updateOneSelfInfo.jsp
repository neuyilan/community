<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>修改个人基本资料</title>
	<%@include file="/common/meta.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/style.css" >
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/adaptive-2.css" >
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
	<script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
	<script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
	<script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
	<script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
	<style type="text/css"> 
		label.error { color:Red; font-size:13px; margin-left:5px;  padding-left:16px; } 
	</style>
</head>
<body class="bagcolr">
<div class="wrapper wranews">
    <div class="newsrel">
        <form id="addForm" modelAttribute="businessUser" method="post" action="updateSelfInfo.do">
    	<div class="header-public"><span class="return" onclick="history.go(-1)"></span>修改个人基本资料</div>
        <div class="cont-l">
        	<input type="hidden" name="userId" id="userId" value="${businessUser.userId }" />
            <h2 class="relran">员工姓名<font color="red">*</font><label for="userName" class="error success"></label></h2>
            <input name="userName" class="iptnewtit" type="text" id="userName" placeholder='' value="${businessUser.userName }" />
            
            <h2 class="relran">联系电话<font color="red">*</font><label for="userTel" class="error success"></label></h2>
            <input name="userTel" style="width:300px;" class="iptnewtit" type="text" name="userTel" id="userTel" placeholder='' value="${businessUser.userTel }" />
            
            <h2 class="relran">户籍地址<label for="fromAddress" class="error success"></label></h2>
            <input name="fromAddress" class="iptnewtit" type="text" id="fromAddress" placeholder='' value="${businessUser.fromAddress }" />
            
            <h2 class="relran">居住地址<label for="homeAddress" class="error success"></label></h2>
            <input name="homeAddress"  class="iptnewtit" type="text" id="homeAddress" placeholder='' value="${businessUser.homeAddress }" />
            
            <h2 class="relstatus">性别<label for="sex" class="error success"></label></h2>
            <div class="options">
            	  <p>
            	      <label><input type="radio" name="sex"  class="radiostyle" id="sex1" value="0" <c:if test="${businessUser.sex == 0 }"> checked </c:if> />&nbsp;男 <br><br></label>
            	      <label><input type="radio" name="sex" class="radiostyle"  id="sex2" value="1" <c:if test="${businessUser.sex == 1 }"> checked </c:if> />&nbsp;女<br></label>
          	      </p>
            </div>
            <div class="line2"></div>
            
            <h2 class="relran">年龄<label for="age" class="error success"></label></h2>
            <input  name="age" style="width:100px;" class="iptnewtit" type="text" id="age"  placeholder='' value="${businessUser.age }" /> 岁
            <div class="line2"></div>
            
            <h2 class="relstatus">婚姻状况<label for="isMarriage" class="error success"></label></h2>
            <div class="options">
           	  	<p>
           	      <label><input type="radio" name="isMarriage" class="radiostyle" id="isMarriage1" value="0" <c:if test="${businessUser.isMarriage == 0 }"> checked </c:if> />&nbsp;已婚 <br><br></label>
           	      <label><input type="radio"  name="isMarriage" class="radiostyle" id="isMarriage2" value="1" <c:if test="${businessUser.isMarriage == 1 }"> checked </c:if> />&nbsp;未婚<br></label>
         	   	</p>
            </div>
            <div class="line2"></div>
            
            <h2 class="relran">籍贯<label for="hometown" class="error success"></label></h2>
            <input  name="hometown" style="width:100px;" class="iptnewtit" type="text" id="hometown" placeholder='' value="${businessUser.hometown }" /><br>
            <div class="line2"></div>
            
            <h2 class="relran">民族<label for="nation" class="error success"></label></h2>
            <input  name="nation" style="width:100px;" class="iptnewtit" type="text" id="nation" placeholder='' value="${businessUser.nation }" />
            <div class="line2"></div>
            
            <h2 class="relran">人员昵称<font color="red">*</font><label for="nickname" class="error success"></label></h2>
            <input  name="nickname" style="width:300px;" class="iptnewtit" type="text" id="nickname" placeholder='' value="${businessUser.nickname }" />
            
            <h2 class="newscont">人员简介<font color="red">*</font><label for="userBrief" class="error success"></label></h2>
            <textarea name="userBrief" class="newtext" id="userBrief"  placeholder="">${businessUser.userBrief }</textarea>
           
            <h2 class="newscont">交流话术<font color="red">*</font><label for="comWord" class="error success"></label></h2>
            <textarea class="newtext" id="comWord" name="comWord" placeholder="">${businessUser.comWord }</textarea>
           
            <div class="submtpres">
                <input id="qrbut" type="button" name="" value="确认提交"  onclick="submitForm()"/>
            </div>
        </div>
    	</form>
    </div>
</div>

</body>
</html>
<script type="text/javascript">
	$(document).keyup(function(event){
		if(event.keyCode ==13){
			submitForm();			
		}
	});
	
	//提交表单
	function submitForm() {
		$('#addForm').submit();
	}
	
    $(function() {
        var flag = false;
      	//初始化表单并验证
      	$('#addForm').validate({
            submitHandler:function(form){
              	if(flag == true) {
              		return;
              	}else{
              		flag = true;
              	}
                $('#qrbut').attr("disabled","disabled");
                $('#addForm').form('submit', {
                    success:function(data){
                        var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                        alert(data.message);
                        if(data.success == 'true') {
                        	window.location.href = '<%=ctx%>/business/businessUser/list.do';
                     }                            
                 }
             });
           },
       	   errorClass: "error",
			  success: function(label) {
			  label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
       	   },
   		rules: {
			userName: {
				required: true,
				maxlength: 32
			},
			userTel: {
				required: true,
				maxlength: 32
			},
			nickname: {
				required: true,
				maxlength: 32,
				remote: {
                    type: "post",
                    url: "<%=path %>/business/businessUser/checkExistNickName.do",
                    data: {
                    	nickname: function() {
                            return $("#nickname").val();
                        },
                 			userId: function() {
                      		return $("#userId").val();
                 		}
                    }
                }
			},
			userBrief: {
				required: true,
				maxlength: 1000
			},
			comWord: {
				required: true,
				maxlength: 2000
			}
   		},
   		messages: {
			userName: {
				required: "请输入员工姓名",
				maxlength: "员工姓名最多为32位"
			},
			userTel: {
				required: "请输入员工电话，可以输入多个",
				maxlength: "员工电话最多为32位"
			},
			nickname: {
				required: "请输入昵称",
				maxlength: "昵称最多为32位",
				remote: "该昵称已存在"
			},
			userBrief: {
				required: "请输入员工介绍",
				maxlength: "员工介绍最多为1000位"
			},
			comWord: {
				required: "请输入交流话术",
				maxlength: "交流话术最多为2000位"
			}
   		 }
   	  });
   });    
</script>   