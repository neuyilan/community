<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>添加部门</title>
	<%@include file="/common/meta.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/style.css" >
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/adaptive-2.css" >
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
	<script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
	<%-- <script src="<%=ctx %>/js/coveragelayer.js" type="text/javascript"></script> --%>
	<script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
	<script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
	<style type="text/css"> 
		label.error  { 
			color:Red; 
			font-size:13px; 
			margin-left:5px; 
			padding-left:16px; 
		} 
	</style> 
</head>
<body class="bagcolr">
<div class="wrapper wranews">
    <div class="newsrel">
        <form id="addForm" method="post" action="<%=ctx %>/business/businessDepartment/save.do">
    	<div class="header-public"><span class="return" style="cursor: pointer;" onclick="history.go(-1)"></span>添加部门</div>
        <div class="cont-l">
        <input type="hidden" name="orgId" id="orgId" value="${orgId }"/>
        <input type="hidden" name="orgType" id="orgType" value="${orgType }"/>
         	<h2 class="title">部门名称<label for="depName" class="error success"></label></h2>
            <input style="width:300px;" class="iptnewtit" type="text" id="depName" name="depName" placeholder='' />
            <br>
            <h2 class="title">部门描述<label for="depDesc" class="error success"></label></h2>
            <input class="iptnewtit" type="text" id="depDesc" name="depDesc" placeholder='' />
            
            <div class="submtpres">
                <input id="qrbut" type="submit" name="" value="确认提交" />
            </div>
        </div>
    	</form>
    </div>
</div>

</body>
</html>
<script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
		
$(function () {
	
	//初始化表单并验证
	$('#addForm').validate({
		//debug:true,	 
		/* errorPlacement: function(error, element) {
        	error.after(element.parent());
    	}, */
        submitHandler:function(form){
            $('#addForm').form('submit', {
                success:function(data){
                    var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                    alert(data.message);
                    window.location.href = '<%=ctx%>/business/businessDepartment/list.do';
                }
            });
        },
    	errorClass: "error",
		//event:"keyup" || "blur", 
        success: function(label) {
			//alert('a');
    		label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
    	},
		rules: {
			depName: {
				required: true
			}
		},
		messages: {
			depName: {
					required: "请输入部门名称"
			}
		}
	});
	
});
		
</script>        