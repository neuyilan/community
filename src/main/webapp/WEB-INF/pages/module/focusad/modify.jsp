<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/25
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑广告焦点图</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
    <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
	<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
	<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
	<script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
	<link rel="stylesheet" type="text/css" href="${ctx}/css/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
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
	    $(function () {
	    	$(document).keyup(function(event){
				  if(event.keyCode ==13){
						  submitForm();			
				  }
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
	                        window.location.href = '<%=ctx%>/business/businessFocusAd/list.do';
	                    }
	                });
	            },
	            errorClass: "error",
	            success: function(label) {
	                label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
	            },
	            rules: {
	                title: {
	                    required: true,
	                    maxlength : 64
	                },
	                focusAdScope: {
	                    required: true
	                },
	                picUrl: {
	                    required: true
	                },
	                pageUrl: {
	                    required: true
	                },
                    state: {
                        required: true
                    }
	            },
	            messages: {
	                title: {
	                	required: '请填写广告焦点图名称！'
	                },
	                focusAdScope: {
	                    required: '请选择展示范围！'
	                },
	                picUrl: {
	                    required: '请选择图片！'
	                },
	                pageUrl: {
	                    required: '请填写链接地址！'
	                },
                    state: {
                        required: '请选择发布状态！'
                    }
	            }
	        });
	    });
	    //提交表单
	    function submitForm() {
	        //设置内容
	        $('#ff').submit();
	    }
    </script>
</head>
<body class="bagcolr">
<form id="ff"  action="update.do" method="post">
	<input type="hidden" name="focusAdId" id="focusAdId" value="${businessFocusAd.focusAdId }" />
	<input type="hidden" name="scope" id="scope" value="${scope1 }" />
    <div class="wrapper wranews">
        <div class="newsrel">
            <div class="header-public"><span class="return" onclick="history.go(-1);"></span>编辑广告焦点图</div>
            <div class="cont-l">
                <h2 class="relran" style="font-weight: bold;">广告焦点图名称<label for="title" class="error success"></label></h2>
                <input class="iptnewtit" type="text" name="title" placeholder='请输入广告焦点图名称'  value="${businessFocusAd.title}"/>
                
                <h2 class="relran" style="font-weight: bold;">展示范围<label for="focusAdScope" class="error success"></label></h2>
	            <div style="position:relative;">
		            <span class="ranbut radiusbox" id="showScopeLayer">点击选择范围</span>
		            <input type="hidden" id="focusAdScope" name="focusAdScope" value="${scope}" />
		            <input type="hidden" id="focusAdScopeInfo" name="focusAdScopeInfo" value="${businessFocusAd.focusAdScope}" />
		            <lable style="position: absolute; top: 10px; left: 160px;"  id="scopeShow">${businessFocusAd.focusAdScope}</lable>
	            </div> 
                 
                <h2 class="relstatus" style="font-weight: bold;">广告焦点图<label for="picUrl" class="error success"></label></h2>
                <div style=" overflow:hidden;"><img id="picUrlBtn" src="<%=ctx %><c:choose><c:when test="${businessFocusAd.picUrl=='' && businessFocusAd.picUrl=='/images/icon/tp01.jpg'}">/images/icon/tp01.jpg</c:when><c:otherwise>${businessFocusAd.picUrl}</c:otherwise></c:choose>" width="305" height="102" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽640PX、高198PX】jpg格式图片<br>图片大小不能超过100K!</div></div>
                <input type="hidden" name="picUrl" id="picUrl"  value="${businessFocusAd.picUrl=='/images/icon/tp01.jpg'?'':businessFocusAd.picUrl}">
                <input type="hidden" name="uploadField" id="uploadField" value="" >
                  
                <c:if test="${businessFocusAd.ishtml==1}">   
	                <h2 class="relran" style="font-weight: bold;">链接地址<label for="pageUrl" class="error success"></label></h2>
	                <input class="iptnewtit" type="text" name="pageUrl" placeholder='请输入展示内容的链接地址'  value="${businessFocusAd.pageUrl}"/>
                </c:if>
                <h2 class="relstatus" style="font-weight: bold;">发布状态<label for="state" class="error success"></label></h2>
                <div class="options">
                    <p>
                        <shiro:hasPermission name="focus_ad_instant_publish">
                        <label><input class="radiostyle" type="radio" name="state" value="0" <c:if test='${businessFocusAd.state==0}'> checked </c:if> >&nbsp;立即发布<br><br></label>
                     	</shiro:hasPermission>
                     	<shiro:hasPermission name="focus_ad_wait_publish">
                     	<label><input class="radiostyle" type="radio" name="state" value="1" <c:if test='${businessFocusAd.state==1}'> checked </c:if> >&nbsp;暂缓发布<br><br></label>
                       	</shiro:hasPermission>
                       	<label><input class="radiostyle" type="radio" name="state" value="2" <c:if test='${businessFocusAd.state==2}'> checked </c:if> >&nbsp;待审核<br><br></label>
                    </p>
                </div>
                
                <div class="submtpres">
                    <input id="qrbut" type="button" name="" value="确认提交"  onclick="submitForm()"/>
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
	    	<a id="close3" href="javascript:;"  onclick="cancleFocusAdScope()"></a>
	    	<h2 class="tit3">展示范围选择</h2>
	    	<hr class="link3" >
	        <div id="wrapper-250">
		          <ul id="scopeTree" style="font-size: 18px; margin-top:10px;"></ul>
	        </div>
	        <div class="w-gg-btn">
	            <input class="w-gg-qr w-gg-total" type="button" style="width: 80px;" value="确定"  id="scopeOk"/>
				<input class="w-gg-qx w-gg-total" type="button" style="width: 80px;" value="取消"  onclick="cancleFocusAdScope()"/>
	        </div>
        </form>
    </div>
</div>
<!-- 展示范围选择结束 -->
</body>

<script type="text/javascript">
	//取消展示扩散范围
	function cancleFocusAdScope() {
	    $("#scopeLayer").fadeOut("slow");
	}

	$(function() {
		//app小图
		$('#picUrlBtn').click(function() {
			$('#picUploadLayer').fadeIn('slow');
			//初始化上传
	    	uploadInit('news', 'picUrl', '1', '0');
	    	$('#uploadField').val('picUrl');
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
	                if(typeid == 'estate') {
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
	            $('#focusAdScope').val(scopeIds);
	            $('#focusAdScopeInfo').val(scopeInfo);
	            
	            $('#scopeShow').html(scopeInfo);
	            $('#scopeShow').focus();
	            
	            $("#scopeLayer").fadeOut("slow");
	        }else{
	            alert('请选择展示范围');
	        }
	    });
		
		// 显示展示范围层
	    $("#showScopeLayer").click(function(){
	   	        $("#scopeLayer").fadeIn("slow");
	   	        //显示楼栋数结构
	   	        $.ajax({
	   	            url: '${ctx}/business/businessFocusAd/getExpendScopeTree.do',
	   	            dataType: 'json',
	   	         	data: {flag: 'update', scope: $('#scope').val()},
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
		
	    // 选择求助范围结点
	    $('#scopeTree').tree({
	        checkbox: true,
	        onSelect: function(node){
	            var children = $('#scopeTree').tree('getChildren', node.target);
	            if(children.length != 0) {//无子元素加入子结点,已有则展开结点即可
	            	$('#scopeTree').tree('expend', node);
	            }
	        }
	    });
	});
</script>
</html>