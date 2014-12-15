<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/22
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>优惠设置</title>
    <%@include file="/common/meta.jsp"%>
    <script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
    <script language="javascript" type="text/javascript" src="${ctx}/js/time/WdatePicker.js"></script>
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
<form id="ff" action="${ctx}/business/businessExpFav/save.do" method="post">
    <div class="wrapper wranews">

        <div class="newsrel">

            <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" style="cursor: pointer;"></span>优惠设置</div>
            <div class="cont-l">
			<input type="hidden" name="favorableId" id="favorableId" value="<c:if test="${!empty businessExpFav}">${businessExpFav.favorableId }</c:if>" />
            <%-- <h2 class="title">优惠时间<label for="startDate" class="error success"></label><label for="endDate" class="error success"></label></h2>
            <span class="timebut radiusbox" id="startDateBtn" >点击设置时间</span>
            <input type="hidden" name="startDate" id="startDate" <c:if test="${!empty businessExpFav}">value="${businessExpFav.startDate }"</c:if> />
            <span id="startDateShow"><c:if test="${!empty businessExpFav}">${businessExpFav.startDate }</c:if></span>
                	至
            <span class="timebut radiusbox" id="endDateBtn" >点击设置时间</span>
            <input type="hidden" name="endDate" id="endDate" <c:if test="${!empty businessExpFav}">value="${businessExpFav.endDate }"</c:if> />
            <span id="endDateShow"><c:if test="${!empty businessExpFav}">${businessExpFav.endDate }</c:if></span>
             --%>
            <h2 class="title">优惠信息<label for="info" class="error success"></label></h2>
            <input class="iptnewtit" type="text"  name="info" id="info" placeholder='请输入去驿站发件的优惠政策信息'  <c:if test="${!empty businessExpFav}">value="${businessExpFav.info }"</c:if> />&nbsp;&nbsp;<font color="red">*</font>

            <div class="submtpres">
                <input id="qrbut" type="submit" value="确认提交" onclick=""/>
            </div>
            </div>
        </div>
    </div>
</form>

<!-- 优惠开始日期 -->
<div id="startDateLayer" class="busswi">
    <div id="startDateBar" class="sidebar">
        <a id="close" class="closeStartDate" href="javascript:;"></a>
        <h2 class="tit">设定时间</h2>
        <!--<hr class="link">-->
        <div id="wrapper-250">
            <ul style="font-size: 18px;">
            	<div id="startDatePicker"></div>
            </ul>
            <ul>默认自动获取当天日期</ul>
            <ul>
	          	<div class="w-gg-btn">
	            	<span class="w-gg-qr w-gg-total" id="startDateOk" style="cursor: pointer;">确认</span>
	            	<span class="w-gg-qx w-gg-total" id="startDateCancel" style="cursor: pointer;">取消</span>
	        	</div>
	        </ul>
        </div>
    </div>
</div>

<!-- 优惠结束日期 -->
<div id="endDateLayer" class="busswi">
    <div id="endDateBar" class="sidebar">
        <a id="close" class="closeEndDate" href="javascript:;"></a>
        <h2 class="tit">设定时间</h2>
        <!--<hr class="link">-->
        <div id="wrapper-250">
            <ul style="font-size: 18px;">
            	<div id="endDatePicker"></div>
            </ul>
            <ul>默认自动获取当天日期</ul>
            <ul>
	          	<div class="w-gg-btn">
	            	<span class="w-gg-qr w-gg-total" id="endDateOk" style="cursor: pointer;">确认</span>
	            	<span class="w-gg-qx w-gg-total" id="endDateCancel" style="cursor: pointer;">取消</span>
	        	</div>
	        </ul>
        </div>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
        $(function () {

            //计划时间
            //开始日期
            $("#startDatePicker").datepicker({
            	altFormat: 'yy-mm-dd',
            	dateFormat: 'yy-mm-dd',
    			autoSize: true,
    			changeMonth: true,
    			minDate: 0
    		},
    		$.datepicker.regional['zh-CN']);
          	//结束日期
            $("#endDatePicker").datepicker({
            	altFormat: 'yy-mm-dd',
            	dateFormat: 'yy-mm-dd',
    			autoSize: true,
    			changeMonth: true,
    			minDate: 0
    		},
    		$.datepicker.regional['zh-CN']);
           
            //开始日期展示
            $("#startDateBtn").click(function(){
                $("#startDateLayer").fadeIn("slow");
                $("#startDateLayer").css("height",$(document.body).outerHeight(true)+'px');
                $("#startDateBar").css("height",$(document.body).outerHeight(true)-40+'px');
            });
        	//结束日期展示
            $("#endDateBtn").click(function(){
                $("#endDateLayer").fadeIn("slow");
                $("#endDateLayer").css("height",$(document.body).outerHeight(true)+'px');
                $("#endDateBar").css("height",$(document.body).outerHeight(true)-40+'px');
            });

            //关闭开始时间设置
            $('#closeStartDate').click(function() {
                $("#startDateLayer").fadeOut("slow");
            });
            //选择开始时间
            $('#startDateOk').click(function() {
            	var date = $("#startDatePicker").datepicker("getDate");
            	if(date == '') {
            		alert('请选择日期');
            	}else{
            		//获得日期
            		$('#startDate').val(formatDate(date));
            		$('#startDateShow').text(formatDate(date));
            		$("#startDateLayer").fadeOut("slow");
            	}
            });
          	//取消开始时间设置
            $('#startDateCancel').click(function() {
                $("#startDateLayer").fadeOut("slow");
            });
          	$('.closeStartDate').click(function() {
          		$("#startDateLayer").fadeOut("slow");
          	});
          	
          //关闭结束时间设置
            $('#closeEndDate').click(function() {
                $("#endDateLayer").fadeOut("slow");
            });
            //选择结束时间
            $('#endDateOk').click(function() {
            	var date = $("#endDatePicker").datepicker("getDate");
            	if(date == '') {
            		alert('请选择日期');
            	}else{
            		//获得日期
            		$('#endDate').val(formatDate(date));
            		$('#endDateShow').text(formatDate(date));
            		$("#endDateLayer").fadeOut("slow");
            	}
            });
          	//取消结束时间设置
            $('#endDateCancel').click(function() {
                $("#endDateLayer").fadeOut("slow");
            });
          	$('.closeEndDate').click(function() {
          		$("#endDateLayer").fadeOut("slow");
          	});
          	
            //验证表单
            $('#ff').validate({
                submitHandler:function(form){
                    $('#ff').form('submit', {
                        success:function(data){
                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                            alert(data.message);
                            window.location.href = '<%=ctx%>/business/businessExp/list.do';
                        }
                    });
                },
                errorClass: "error",
                success: function(label) {
                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
                },
                rules: {
                    /* startDate: {
                        required: true
                    },
                    endDate: {
                        required: true
                    }, */
                    info: {
                        required: true,
                        maxlength: 20
                    }
                },
                messages: {
                    /* startDate: {
                        required: '请选择开始时间！'
                    },
                    endDate: {
                        required: '请选择结束时间！'
                    }, */
                    info: {
                        required: '请输入优惠信息！',
                        maxlength: '最长为20个字！'
                    }
                }
            });
        });
        
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
