<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>编辑职位</title>
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
        <form id="addForm" method="post" action="<%=ctx %>/business/businessPosition/update.do">
    	<div class="header-public"><span class="return" style="cursor: pointer;" onclick="history.go(-1)"></span>添加职位</div>
        <div class="cont-l">
        <input type="hidden" name="positionId" id="positionId" value="${businessPosition.positionId }"/>
        <input type="hidden" name="orgId" id="orgId" value="${businessPosition.orgId }"/>
        <input type="hidden" name="orgName" id="orgName" value="${businessPosition.orgName }"/>
        <input type="hidden" name="parentId" id="parentId" value="${businessPosition.parentId }" />
        <input type="hidden" name="parentName" id="parentName" value="${businessPosition.parentName }" />
        <input type="hidden" name="depId" id="depId" value="${businessPosition.depId }"/>
        <input type="hidden" name="depName" id="depName" value="${businessPosition.depName }"/>
        <input type="hidden" name="level" id="level" value="${businessPosition.level }" />
        
         	<h2 class="title">职位名称<label for="positionName" class="error success"></label></h2>
            <input style="width:300px;" class="iptnewtit" type="text" id="positionName" name="positionName" placeholder='' value="${businessPosition.positionName }" />
            
            <h2 class="title">职位描述<label for="positionDesc" class="error success"></label></h2>
            <input style="width:300px;" class="iptnewtit" type="text" id="positionDesc" name="positionDesc" placeholder='' value="${businessPosition.positionDesc }" />

            <div class="submtpres">
                <input id="qrbut" type="submit" name="" value="添加" />
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
                    if(data.success == 'true') {
                    	alert(data.message);
                    	var idValue = '';
                        var parentId = $('#parentId').val();
                        var depId = $('#depId').val();
                        var level = $('#level').val();
                        if(level != 1) {
                        	idValue = 'parentId='+parentId+'&level='+$('#level').val();
                        }else{
                        	idValue = 'depId='+depId+'&level=1';
                        }
                        window.location.href = '<%=ctx%>/business/businessPosition/list.do?'+idValue;
                    }else{
                    	alert(data.message);
                    }
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
			positionName: {
				required: true
			}
		},
		messages: {
			positionName: {
					required: "请输入职位名称"
			}
		}
	});
	
});
		
</script>        