<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/25
  Time: 13:28
  To change this template use File | Settings | File Templates.
  中医养生
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布中医养生</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
    <script language="javascript" type="text/javascript" src="${ctx}/js/time/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
   	<script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    <script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>

    <style type="text/css">
        label.error
        {
            color:Red;
            font-size:13px;
            margin-left:5px;
            padding-left:16px;
        }
    </style>
    <script type="text/javascript">
	    $(document).keyup(function(event){
	    	 if(event.keyCode ==13){
				  submitForm();			
		 	 }
		});
    
        $(function () {
            $('input[name="typeID"]').click(function() {
                $('input[name="typeId"]').val($(this).val());
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
                            window.location.href = '<%=ctx%>/business/businessChinmedichenacare/list.do';
                        }
                    });
                },
                errorClass: "error",
                success: function(label) {
                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
                },
                rules: {
                	cmhcTitle: {
                        required: true,
                        maxlength: 24
                    },
                    brief: {
                    	required: true,
                    	maxlength: 28
                    },
                    cmhcContent: {
                        required: true
                    },
                    cmhcPic: {
                       required: true
                    },
                    appPic: {
                       required: true
                    },
                    publishState: {
                        required: true
                    }
                },
                messages: {
                	cmhcTitle: {
                        required: '请填写中医养生标题！',
                        maxlength: '中医养生标题在24字以内'
                    },
                    brief: {
                    	required: '请输入中医养生简介',
                    	maxlength: '中医养生简介在28字以内'
                    },
                    cmhcContent: {
                        required: '请填写中医养生内容！'
                    }, 
                    cmhcPic: {
                        required: '请选择列表页大图！'
                    },
                    appPic: {
                        required: '请选择APP首页小图！'
                    },
                    publishState: {
                        required: '请选择发布状态！'
                    }
                }
            });
        });
        //提交表单
        function submitForm() {
            var content = ue.getContent();
            if(content != '') {
                //设置内容
                $('#cmhcContent').val(ue.getContent());
            }
            $('#ff').submit();
        }
    </script>
</head>
<body class="bagcolr">
<form id="ff" action="update.do" method="post">
    <div class="wrapper wranews">
        <div class="newsrel">
            <div class="header-public"><span class="return" onclick="history.go(-1);"></span>编辑中医养生</div>
            <div class="cont-l">
                <input type="hidden" name="cmhcId" id="cmhcId" value="${businessChinmedichenacare.cmhcId }" />
                <h2 class="relran">中医养生标题<label for="cmhcTitle" class="error success"></label></h2>
                <input class="iptnewtit" type="text" name="cmhcTitle" id="cmhcTitle" placeholder='请输入中医养生标题24字以内' value="${businessChinmedichenacare.cmhcTitle }" />
                
                <h2 class="relran">中医养生简介<label for="brief" class="error success"></label></h2>
                <input class="iptnewtit" type="text" name="brief" id="brief" placeholder='请输入中医养生简介28字以内' value="${businessChinmedichenacare.brief }" />
                
                <h2 class="relran">中医养生内容<label for="cmhcContent" class="error success"></label></h2>
                <%--文本编辑器--%>
                <!--style给定宽度可以影响编辑器的最终宽度-->
                <textarea id="cmhcContent" name="cmhcContent" type="text/plain" style="width:1024px;height:500px;">${businessChinmedichenacare.cmhcContent }</textarea>
                
                <h2 class="relran">标签<label for="label" class="error success"></label></h2>
                <input class="iptnewtit" type="text" name="label" id="label" placeholder='请输入标签' value="${businessChinmedichenacare.label }" />
                <%-- 
                <h2 class="relran">中医养生缩略图<label for="cmhcPic" class="error success"></label></h2>
                <div style=" overflow:hidden;"><img id="cmhcPicBtn" src="${ctx}${businessChinmedichenacare.cmhcPic }" width="305" height="102" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽640PX、高198PX】jpg格式图片<br>图片大小不能超过100K!</div></div>
                <input type="hidden" name="cmhcPic" id="cmhcPic" value="${businessChinmedichenacare.cmhcPic }" >
                 --%>
                <div class="line2"></div>
                <h2 class="relran">APP首页小图<label for="appPic" class="error success"></label></h2>
                 <div style=" overflow:hidden;"><img id="appPicBtn" src="${ctx}${businessChinmedichenacare.appPic }" width="100" height="100"  style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽170PX、高125PX】jpg格式图片<br>图片大小不能超过20K!</div></div>
                <input type="hidden" name="appPic" id="appPic" value="${businessChinmedichenacare.appPic }"> <%--头像--%>
                
                 <input type="hidden" name="uploadField" id="uploadField" value="" >
                                
				<div class="line2"></div>
                <h2 class="relstatus">推荐到首页社区头条<label for="isRecommend" class="error success"></label></h2>
                <div class="options">
                    <p>
                        <label><input class="radiostyle" type="radio" name="isRecommend" value="0" <c:if test="${businessChinmedichenacare.isRecommend == 0 }"> checked </c:if> > 否</label><br><br>
                        <label><input class="radiostyle" type="radio" name="isRecommend" value="1" <c:if test="${businessChinmedichenacare.isRecommend == 1 }"> checked </c:if> > 是</label><br>
                    </p>
                </div>
                
                <div class="line2"></div>
                <h2 class="relran">医师姓名<label for="doctorName" class="error success"></label></h2>
                <input class="iptnewtit" type="text" name="doctorName" id="doctorName" value="${businessChinmedichenacare.doctorName }" placeholder='请输入医师姓名' />
                
                <h2 class="relran">医师简介<label for="doctorBrief" class="error success"></label></h2>
                <textarea id="doctorBrief" name="doctorBrief" type="text/plain" style="width:1024px;height:100px;">${businessChinmedichenacare.doctorBrief }</textarea>
                
                <h2 class="relran">医师头像<label for="avatar" class="error success"></label></h2>
                <div style=" overflow:hidden;"><img id="avatarBtn" src="${ctx}${businessChinmedichenacare.avatar }" width="100" height="100"  style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽100PX、高100PX】jpg格式图片<br>图片大小不能超过20K!</div></div>
                <input type="hidden" name="avatar" id="avatar" > <%--头像--%>
                
                <div class="line2"></div>
                <h2 class="relstatus">发布状态<label for="publishState" class="error success"></label></h2>
                <div class="options">
                    <p>
                    	<shiro:hasPermission name="care_instant_publish">
                        <label><input class="radiostyle" type="radio" name="publishState" value="0" <c:if test="${businessChinmedichenacare.publishState == 0 }"> checked </c:if> > 立即发布</label><br><br>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="care_wait_publish">
                        <label><input class="radiostyle" type="radio" name="publishState" value="1" <c:if test="${businessChinmedichenacare.publishState == 1 }"> checked </c:if> > 暂缓发布</label><br><br>
                        </shiro:hasPermission>
                        <label><input class="radiostyle" type="radio" name="publishState" value="2" <c:if test="${businessChinmedichenacare.publishState == 2 }"> checked </c:if> > 待审核</label><br><br>
                    </p>
                </div>

                <div class="submtpres">
                    <input id="qrbut" type="button" name="" value="确认提交"  onclick="submitForm();"/>
                </div>
                
            </div>
        </div>
    </div>
</form>
<jsp:include page="/common/uploadPicJs.jsp"/>
</body>
<%--初始化文本编辑器--%>
    
<script type="text/javascript">
    //实例化编辑器
    var ue = UE.getEditor('cmhcContent');
    
    $(function() {
    	//大图
    	
    	$('#cmhcPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('care', 'cmhcPic', '0', '0');
    		$('#uploadField').val('cmhcPic');
    	});
    	//app小图
    	
    	$('#appPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('care', 'appPic', '1', '0');
        	$('#uploadField').val('appPic');
    	});
    	
    	//医师头像
    	$('#avatarBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('care', 'avatar', '0', '0');
        	$('#uploadField').val('avatar');
    	});
    });
</script>
</html>