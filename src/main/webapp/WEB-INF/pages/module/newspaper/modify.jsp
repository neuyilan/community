
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增电子报</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
	<link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
    <script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
    <script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
    
    <style type="text/css">
        label.error
        {
            color:Red;
            font-size:13px;
            margin-left:5px;
            padding-left:16px;
        }
    </style>
</head>
<body class="bagcolr">
<form id="ff" action="update.do" method="post">
<input type="hidden" name="newspaperId" id="newspaperId" value="${businessNewspaper.newspaperId }">
<div class="wrapper wranews">
    <div class="newsrel">
        <div class="header-public"><span class="return" onclick="history.go(-1);"></span>编辑电子报</div>
        <div class="cont-l">
            <h2 class="relstatus" style="font-weight: bold;">选择发行日期<label for="title" class="error success"></label></h2>
            <div style="position:relative;">
	            <span class="ranbut radiusbox" id="setTimeBtn">点击设置时间</span>
            	<input type="hidden" id="title" name="title" value="${businessNewspaper.title}"/>
	            <lable style="position: absolute; top: 10px; left: 160px;"  id="titleShow">${businessNewspaper.title}</lable>
            </div>
            
            <h2 class="relstatus" style="font-weight: bold;">封面展示<label for="pic" class="error success"></label></h2>
            <div id="divImg" style=" overflow:hidden;"><img id="picBtn" src="<%=ctx %><c:choose><c:when test="${businessNewspaper.pic==''}">/images/icon/add.jpg</c:when><c:otherwise>${businessNewspaper.pic}</c:otherwise></c:choose>" width="100" height="100" style="float:left; padding-right:10px;"></div>
            <input type="hidden" name="pic" id="pic" value="${businessNewspaper.pic}"> 
            <input type="hidden" name="uploadField" id="uploadField" value=""><br>
            
            <h2 class="relran" style="font-weight: bold;">电子报URL<label for="url" class="error success"></label></h2>
            <input class="iptnewtit" type="text" id="url" name="url" value="${businessNewspaper.url}"/>
			
            <div class="submtpres">
                <input id="qrbut" type="button" value="确认提交" onclick="submitForm();"/>
            </div>
        </div>
    </div>
</div>

<link rel="stylesheet" type="text/css" href="${ctx}/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>

<!-- 设定时间开始 -->
<div id="setTimeLayer" class="busswi">
    <div id="setTimeBar" class="sidebar">
        <a id="close" title="关闭" class="closeSetTime" href="javascript:;"></a>
        <h2 class="tit">设定时间</h2>
        <hr class="link">
        <div id="wrapper-250">
            <ul style="font-size: 18px;">
            	<div id="datepicker"></div>
            </ul>
            <ul>
	          	<div class="w-gg-btn">
	            	<span class="w-gg-qr w-gg-total" id="setTimeOk" style="cursor: pointer;">确认</span>
	            	<span class="w-gg-qx w-gg-total" id="setTimeCancel" style="cursor: pointer;">取消</span>
	        	</div>
	        </ul>
        </div>
    </div>
</div>
<!-- 设定时间结束 -->
</form>

<jsp:include page="/common/uploadPicJs.jsp"/>

</body>
<%--初始化文本编辑器--%>
<script type="text/javascript">
    $(function () {
    	$(document).keyup(function(event){
			  if(event.keyCode ==13){
					  submitForm();			
			  }
		});
	    
    	//APP小图
    	$('#picBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('activity', 'pic', '0', '0');
        	$('#uploadField').val('pic');
    	});   
        
        //计划时间
        //定时提醒日期
        $("#datepicker").datepicker({
        	altFormat: 'yy-mm-dd',
        	dateFormat: 'yy-mm-dd',
			autoSize: true,
			changeMonth: true // ,
			// minDate: 0
		},
		$.datepicker.regional['zh-CN']);
        

    	//显示定时提醒
        $("#setTimeBtn").click(function(){
            $("#setTimeLayer").fadeIn("slow");
            $("#setTimeLayer").css("height",$(document.body).outerHeight(true)+'px');
            $("#setTimeBar").css("height",$(document.body).outerHeight(true)-40+'px');
        });

        //关闭时间设置
        $('#closeSetTime').click(function() {
            $("#setTimeLayer").fadeOut("slow");
        });
        
        //选择时间
        $('#setTimeOk').click(function() {
        	var date = $("#datepicker").datepicker("getDate");
        	if(date == '') {
        		alert('请选择日期');
        	} else{
        		//获得日期和时间
        		$('#title').val(formatDate(date));
        		$('#titleShow').text(formatDate(date));
        		$("#setTimeLayer").fadeOut("slow");
        	}
        });
        
      	//取消时间设置
        $('#setTimeCancel').click(function() {
            $("#setTimeLayer").fadeOut("slow");
        });
      	
      	$('.closeSetTime').click(function() {
      		$("#setTimeLayer").fadeOut("slow");
      	});
      	
      	var flag = false;
        //验证表单
        $('#ff').validate({
            submitHandler:function(form){
            	if(flag == true) {
            		return;
            	}else{
            		flag = true;
            	}
                $('#qrbut').attr("disabled","disabled");
                
                $('#ff').form('submit', {
                    success:function(data){
                        var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                        alert(data.message);
                        window.location.href = '<%=ctx%>/business/businessNewspaper/list.do';
                    }
                });
            },
            errorClass: "error",
            success: function(label) {
                label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
            },
            rules: {
                title: {
                    required: true
                },
                pic: {
                    required: true
                },
                url: {
                    required: true
                }
            },
            messages: {
            	title: {
                    required: '请填写发布时间！'
                },
                pic: {
                    required: '请选择封面展示图片！'
                },
                url: {
                    required: '请填写电子报URL！'
                }
            }
        });
    });
    
    //提交表单
    function submitForm() {
        $('#ff').submit();
    }
    
    //格式化日期
    function formatDate(date) { 
    	var year = date.getFullYear(); 
    	var month = date.getMonth() + 1; 
    	var day = date.getDate(); 
    	return year + "-" + formatTen(month) + "-" + formatTen(day); 
    }
    //格式化时间
    function formatTen(num) { 
    	return num > 9 ? (num + "") : ("0" + num); 
    }
</script>
</html>