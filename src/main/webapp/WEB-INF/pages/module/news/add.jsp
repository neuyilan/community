<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布新闻</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
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
                    
                    var isPush = document.getElementsByName("isPush");
                	if(isPush[0].checked) {
                        window.location.href = '<%=ctx%>/business/businessNews/list.do';
                        $('#ff').form('submit', {
                            success:function(data){
                                var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                                alert(data.message);
                            }
                        });
                	}else {
                		$('#ff').form('submit', {
                            success:function(data){
                                var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                                alert(data.message);
                                window.location.href = '<%=ctx%>/business/businessNews/list.do';
                            }
                        });
                	}
                },
                errorClass: "error",
                success: function(label) {
                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
                },
                rules: {
                    title: {
                        required: true,
                        maxlength: 28
                    },
                    brief: {
                    	required: true,
                    	maxlength: 28
                    },
                    content: {
                        required: true
                    },
                    newsScope: {
                    	required: true
                    },
                    /* subjectPic: {
                       required: true
                    }, */
                    appPic: {
                       required: true
                    },
                    isPush: {
                        required: true
                    },
                    state: {
                        required: true
                    }
                },
                messages: {
                    title: {
                        required: '请填写新闻标题！',
                        maxlength: '新闻标题在28字以内'
                    },
                    brief: {
                    	required: '请输入新闻简介',
                    	maxlength: '新闻简介在28字以内'
                    },
                    content: {
                        required: '请填写新闻内容！'
                    }, 
                    /* subjectPic: {
                        required: '请选择列表页大图！'
                    },  */
                    newsScope: {
                    	required: '请选择新闻范围'
                    },
                    appPic: {
                        required: '请选择APP首页小图！'
                    },
                    isPush: {
                        required: '请选择是否推送！'
                    },
                    state: {
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
                $('#content').val(ue.getContent());
            }
            $('#ff').submit();
        }
    </script>
</head>
<body class="bagcolr">
<form id="ff" action="save.do" method="post">
    <div class="wrapper wranews">
        <div class="newsrel">
            <div class="header-public"><span class="return" onclick="history.go(-1);"></span>新闻发布</div>
            <div class="cont-l">
                <input type="hidden" name="newsType" id="newsType" value="0">
                <input type="hidden" name="isHot" id="isHot" value="0">
                <input type="hidden" name="isAd" id="isAd" value="0">
                <input type="hidden" name="visits" id="visits" value="0">
                <input type="hidden" name="comments" id="comments" value="0">
                <input type="hidden" name="supports" id="supports" value="0">
                
                <h2 class="relran">新闻标题<label for="title" class="error success"></label></h2>
                <input class="iptnewtit" type="text" name="title" placeholder='请输入新闻标题28字以内' />
                
                <h2 class="relran">新闻简介<label for="brief" class="error success"></label></h2>
                <input class="iptnewtit" type="text" name="brief" id="brief" placeholder='请输入新闻简介28字以内' />
                
                <h2 class="relran">新闻内容<label for="content" class="error success"></label></h2>
                <%--文本编辑器--%>
                <!--style给定宽度可以影响编辑器的最终宽度-->
                <textarea id="content" name="content" type="text/plain" style="width:1024px;height:500px;"></textarea>
                
                <%-- <h2 class="relran">列表页大图<label for="subjectPic" class="error success"></label></h2>
                <div style=" overflow:hidden;"><img id="subjectPicBtn" src="${ctx}/images/icon/tp01.jpg" width="305" height="102" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽600PX、高250PX】jpg格式图片<br>图片大小不能超过100K!</div></div>
                <input type="hidden" name="subjectPic" id="subjectPic" value="" > --%> <%--头像--%>
                
                <h2 class="relran" >展示范围<label for="newsScope" class="error success"></label></h2>
	            <div style="position:relative;">
		            <span class="ranbut radiusbox" id="showScopeLayer">点击选择范围</span>
		            <input type="hidden" id="newsScope" name="newsScope" value="" />
		            <input type="hidden" id="newsScopeInfo" name="newsScopeInfo" value="" />
		            <lable style="position: absolute; top: 10px; left: 160px;"  id="scopeShow"></lable>
	            </div>
                
                <!-- <div class="line2"></div> -->
                <h2 class="relran">APP首页小图<label for="appPic" class="error success"></label></h2>
                <div style=" overflow:hidden;"><img id="appPicBtn" src="${ctx}/images/icon/add.jpg" width="100" height="100"  style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽170PX、高125PX】jpg格式图片<br>图片大小不能超过20K!</div></div>
                <input type="hidden" name="appPic" id="appPic" > <%--头像--%>
                <input type="hidden" name="uploadField" id="uploadField" value="" >
                
                <div class="line2"></div>
                <h2 class="relstatus">是否推送<label for="isPush" class="error success"></label></h2>
                <div class="options">
                    <p>
                        <label><input class="radiostyle" type="radio" name="isPush" value="1"  onclick="IsPash()">&nbsp;是</label>　　<em style="color:#e7402f;">选择推送后，将通过系统推送至手机用户，非重要信息请勿选择</em><br><br>
                        <label><input class="radiostyle" type="radio" name="isPush" value="0" checked >&nbsp;否<br></label>
                    </p>
                </div>
                
				<div class="line2"></div>
                <h2 class="relstatus">推荐到焦点图<label for="isRecommend" class="error success"></label></h2>
                <div class="options">
                    <p>
                        <label><input class="radiostyle" type="radio" name="isRecommend" value="0">&nbsp;首页焦点图</label>　　<em style="color:#000;">将推送至焦点图管理列表，在焦点图管理审核通过后发布至焦点图位置</em><br><br>
                        <label><input class="radiostyle" type="radio" name="isRecommend" value="1">&nbsp;首页新闻列表置顶<br><br></label>
                        <label><input class="radiostyle" type="radio" name="isRecommend" value="2"  checked>&nbsp;以上都不选<br></label>
                    </p>
                </div>
                
                <div class="line2"></div>
                <h2 class="relstatus">发布状态<label for="state" class="error success"></label></h2>
                <div class="options">
                    <p>
                        <shiro:hasPermission name="news_instant_publish">
                        <label><input class="radiostyle" type="radio" name="state" value="0">&nbsp;立即发布<br><br></label>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="news_wait_publish">
                        <label><input class="radiostyle" type="radio" name="state" value="1">&nbsp;暂存<br><br></label>
                        </shiro:hasPermission>
                        <label><input class="radiostyle" type="radio" name="state" value="2"  checked>&nbsp;提交审核<br><br></label>
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

<!-- 展示范围选择开始 -->
<div id="scopeLayer" class="busswi3">
	<div id="scopeBar" class="sidebar3">
		<form action="">
	    	<a id="close3" href="javascript:;"  onclick="cancleFocusScope()"></a>
	    	<h2 class="tit3">展示范围选择</h2>
	    	<hr class="link3" >
	        <div id="wrapper-250">
		          <ul id="scopeTree" style="font-size: 18px; margin-top:10px;"></ul>
	        </div>
	        <div class="w-gg-btn">
	            <input class="w-gg-qr w-gg-total" type="button" style="width: 80px;" value="确定"  id="scopeOk"/>
				<input class="w-gg-qx w-gg-total" type="button" style="width: 80px;" value="取消"  onclick="cancleFocusScope()"/>
	        </div>
        </form>
    </div>
</div>
<!-- 展示范围选择结束 -->

</body>
<%--初始化文本编辑器--%>
    
<script type="text/javascript">
    //实例化编辑器
    var ue = UE.getEditor('content',{
    	toolbars: [[
			'undo', 'redo', '|', 'bold', 'underline', 'forecolor', 'backcolor', 'simpleupload', 'justifyleft', 'justifycenter', 'justifyright'
    	]]
    });
    
    function IsPash() {
		var isPush = document.getElementsByName("isPush");
    	if(confirm("是否选择推送，如果点击'确定'将通过系统推送至手机用户，'取消'则不发送系统推送！")){
    		isPush[0].checked = true;
    		 return true;
    	}else {
    		isPush[0].checked = false;
    		isPush[1].checked = true;
    		return false;
    	} 
    }
    
    $(function() {
    	//大图
    	
    	$('#subjectPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('news', 'subjectPic', '1','0');
    		$('#uploadField').val('subjectPic');
    	});
    	//app小图
    	
    	$('#appPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('news', 'appPic', '0', '0'); 
        	$('#uploadField').val('appPic');
    	});
    	
    	// 显示展示范围层
	    $("#showScopeLayer").click(function(){
	   	        $("#scopeLayer").fadeIn("slow");
	   	        //显示楼栋数结构
	   	        $.ajax({
	   	            url: '${ctx}/business/businessNews/getExpendScopeTree.do',
	   	            dataType: 'json',
	   	            cache: false,
	   	            success: function (data) {
	   	                if(data.success == true){
	   	                    var rows = data.result;
	   	                    if(rows.length > 0) {
	   	                        $('#scopeTree').tree('loadData', data.result);
	   	                    }else{
	   	                        $('.accordion2').html('很抱歉，没有相关记录。');
	   	                    }
	   	                }else{
	   	                    $('.accordion2').html('很抱歉，加载内容出错，我们及时修改问题。');
	   	                }
	   	            },
	   	            error: function () {
	   	                $('.accordion2').html('很抱歉，加载内容出错，我们及时修改问题。');
	   	            }
	   	        });
	   	 });
    	
	  //选择展示范围
        $('#scopeOk').click(function() {
            var scopeIds = '';
            var scopeInfo = '';
            var scopeNodes = $('#scopeTree').tree('getChecked');
            if(scopeNodes != null && scopeNodes.length > 0) {
                for(var i=0;i<scopeNodes.length;i++) {
                    var node = scopeNodes[i];
                    var idArr = node.id.split('_');
                    var typeid = idArr[0];
                    if(typeid == 'com') {
                    	scopeIds += idArr[1] + ':' + node.text + ',';
                        scopeInfo += node.text + ',';
                    }
                }
                
                if(scopeIds != '') {
                    if(scopeIds.indexOf(',') > -1) {
                        scopeIds = scopeIds.substring(0, scopeIds.length-1);
                        scopeInfo = scopeInfo.substring(0, scopeInfo.length-1);
                    }
                }
                $('#newsScope').val(scopeIds);
                $('#newsScopeInfo').val(scopeInfo);
                
                $('#scopeShow').html(scopeInfo);
                $('#scopeShow').focus();
                
                $("#scopeLayer").fadeOut("slow");
            }else{
                alert('请选择展示范围');
            }
        });
		
	    // 选择范围结点
        $('#scopeTree').tree({
            checkbox: true,
            onSelect: function(node){
                var children = $('#scopeTree').tree('getChildren', node.target);
                if(children.length != 0) {
                	$('#scopeTree').tree('expend', node);
                }
            }
        });
    	
    });
    
 // 取消展示扩散范围
 	function cancleFocusScope() {
 	    $("#scopeLayer").fadeOut("slow");
 	}
</script>
</html>