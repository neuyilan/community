<%--<!DOCTYPE html>--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>

<head>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
    <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx%>/js/jquery.confirm/jquery.confirm.css" />
    <script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
    <script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
    <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
	<script src="<%=ctx%>/js/jquery.confirm/jquery.confirm.js"></script>
    
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
        $(function() {
            //$( "#remindTime" ).datepicker();
        });
        
        function checkedRadio(obj, name, display) {
            $('input[name="'+name+'"]').val(obj.value);
            $('#annoTypeShow').text(display);
        }
    </script>
</head>

<body class="bagcolr">
<form id="ff" action="${ctx}/business/businessAnno/updateStationAnno.do" method="post">
<div class="wrapper wranews">
    <div class="newsrel">
        <div class="header-public"><span class="return" onclick="history.go(-1)" style="cursor: pointer;"></span>公告发布</div>
        <div class="cont-l">
        	<input type="hidden" name="annoId" id="annoId" value="${businessAnno.annoId }" />
            <h2 class="title" style="font-weight: bold;">公告标题<label for="annoTitle" class="error success"></label></h2>
            <input class="iptnewtit" type="text" name="annoTitle" placeholder='请输入公告标题24字以内' value="${businessAnno.annoTitle }" />
            
            <br /><br />
            <h2 class="brief" style="font-weight: bold;">公告简介<label for="brief" class="error success"></label></h2>
            <input class="iptnewtit" type="text" name="brief" id="brief" placeholder='请输入简介28字以内' value="${businessAnno.brief }" />
            
            <h2 class="relran" style="font-weight: bold;">公告范围<label for="annoBuilding" class="error success"></label></h2>
            <div style="position:relative;">
	            <span class="ranbut radiusbox" id="showScopeLayer">点击选择范围</span><em>可根据小区进行公告展示范围限定</em>
            	<input type="hidden" id="scope" name="scope" value="${scope}" />
            	<input type="hidden" id="annoBuilding" name="annoBuilding" value="${scope}" />
            	<input type="hidden" id="annoScopeInfo" name="annoScopeInfo" value="${businessAnno.annoScopeInfo }" />
	            <lable style="position: absolute; top: 10px; left: 160px;"  id="scopeShow">${businessAnno.annoScopeInfo }</lable>
            </div>
            
             <h2 class="newscont" style="font-weight: bold;">公告内容<label for="annoContent" class="error success"></label></h2>
            <%--文本编辑器--%>
            <!--style给定宽度可以影响编辑器的最终宽度-->
            <script type="text/plain" id="myEditor" style="width:840px;height:240px;">${businessAnno.annoContent }</script>
            <input type="hidden" id="annoContent" name="annoContent" value=""/>
            
			<h2 class="relran" style="font-weight: bold;">公告列表大图<label for="annoPic" class="error success"></label></h2>
            <div style=" overflow:hidden;"><img id="annoPicBtn" src="<%=ctx %><c:choose><c:when test="${businessAnno.annoPic==''}">/images/icon/tp01.jpg</c:when><c:otherwise>${businessAnno.annoPic}</c:otherwise></c:choose>" width="305" height="102"  style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽600PX、高250PX】jpg格式图片<br>图片大小不能超过100K!</div></div>
            <input type="hidden" name="annoPic" id="annoPic" value="${businessAnno.annoPic }"> 
            
            <h2 class="relran" style="font-weight: bold;">APP首页小图<label for="appPic" class="error success"></label></h2>
            <div style=" overflow:hidden;"><img id="appPicBtn" src="<%=ctx %><c:choose><c:when test="${businessAnno.appPic==''}">/images/icon/add.jpg</c:when><c:otherwise>${businessAnno.appPic}</c:otherwise></c:choose>" width="100" height="100"  style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽170PX、高125PX】jpg格式图片<br>图片大小不能超过20K!</div></div>
            <input type="hidden" name="appPic" id="appPic" value="${businessAnno.appPic }">
            
            <input type="hidden" name="uploadField" id="uploadField" value="">
            
            <div class="line2"></div>
            <h2 class="relstatus" style="font-weight: bold;">是否推送<label for="isPush" class="error success"></label></h2>
            <div class="options">
                <p>
                    <label>
                         <input class="radiostyle" type="radio" name="isPush" value="1" id="isPush_1" >
                       		 是</label>　　
                    <em style="color:#e7402f;">选择推送后，将通过系统推送至手机用户，非重要信息请勿选择</em><br><br>
                    <label>
                        <input class="radiostyle" type="radio" name="isPush" value="0" id="isPush_0" checked >
                        	否</label>
                    <br>
                </p>
            </div>
            
            <div class="line2"></div>
            <h2 class="relstatus" style="font-weight: bold;">推荐到焦点图<label for="isRecommend" class="error success"></label></h2>
            <div class="options">
                <p>
                    <label>
                        <input class="radiostyle" type="radio" name="isRecommend" value="1" id="isRecommend_1" <c:if test="${businessAnno.isRecommend == 1 }"> checked </c:if> >
                       		 是</label>　　
                    <em style="color:#000;">将推送至焦点图管理列表，在焦点图管理审核通过后发布至焦点图位置</em><br><br>
                    <label>
                        <input class="radiostyle" type="radio" name="isRecommend" value="0" id="isRecommend_0" <c:if test="${businessAnno.isRecommend == 0 }"> checked </c:if> >
                        	否</label>
                    <br>
                </p>
            </div>
            
            <div class="line2"></div>
            <h2 class="relstatus" style="font-weight: bold;">发布状态<label for="publishState" class="error success"></label></h2>
            <div class="options">
                <p>
                <shiro:hasPermission name="anno_instant_publish">
                <label>
                        <input class="radiostyle" type="radio" name="publishState" value="0" <c:if test="${businessAnno.publishState == 0 }"> checked </c:if> >
                        立即发布</label>
                    <br>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="anno_audting_anno">
                    <br>
                    <label>
                        <input class="radiostyle" type="radio" name="publishState" value="1" <c:if test="${businessAnno.publishState == 1 }"> checked </c:if> >
                        暂缓发布</label>
                    <br>
                    </shiro:hasPermission>
                    <br>
                    <label>
                        <input class="radiostyle" type="radio" name="publishState" value="2" <c:if test="${businessAnno.publishState == 2 }"> checked </c:if> >
                        待审核</label>
                    <br>
                </p>
            </div>
            
            <div class="submtpres">
                <input id="qrbut" type="button" value="确认提交" onclick="confirmPublish();"/>
            </div>
        </div>
    </div>
</div>
</form>
<!-- 范围选择开始 -->
<div id="scopeLayer" class="busswi y-fbes-jm">
	<div id="scopeBar" class="sidebar y-fbes-jms">
    	<a id="y-fbes-close" class="close" href="javascript:;" onclick="$('#scopeLayer').fadeOut('slow');"></a>
    	<h2 class="tit">公告范围选择</h2>
        <div id="wrapper-250">
	          <ul id="scopeTree" style="font-size: 18px;"></ul>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  value="确定"  id="scopeOk" />
			<input class="w-gg-qx w-gg-total" type="button"  value="取消" onclick="$('#scopeLayer').fadeOut('slow');"/>
        </div>
    </div>
</div>
<jsp:include page="/common/uploadPicJs.jsp"/>

</body>
<link rel="stylesheet" type="text/css" href="${ctx}/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<%--初始化文本编辑器--%>
<script type="text/javascript">
    //实例化编辑器
    var um = UE.getEditor('myEditor',{
    	toolbars: [[
    				'undo', 'redo', '|', 'bold', 'underline', 'forecolor', 'backcolor', 'simpleupload', 'justifyleft', 'justifycenter', 'justifyright'
    	    	]]
    	    });
    
    /* function IsPash() {
		var isPush = document.getElementsByName("isPush");
    	if(confirm("是否选择推送，如果点击'确定'将通过系统推送至手机用户，'取消'则不发送系统推送！")){
    		isPush[0].checked = true;
    		 return true;
    	}else {
    		isPush[0].checked = false;
    		isPush[1].checked = true;
    		return false;
    	} 
    } */
    
    $(document).ready(function(){
		var isPush = document.getElementsByName("isPush");
    	$('#isPush_1').change(function(){
    		$.confirm({
    			'title'		: '选择推送重要提示',
    			'message'	: '<font color="red"><b>请慎重选择推送！</b></font><br/>选择推送，会将此条公告推送至<font color="red"><b>所有注册用户</b></font>手机桌面。<br/>如本篇公告已进行过推送操作，<font color="red"><b>切勿再次推送！</b></font>否则会造成频繁推送！<br/>如确认推送，请选择【确定】，否则，请点击【取消】',
    			'buttons'	: {
    				'确定'	: {
    					'class'	: 'blue',
    					'action': function(){
    						isPush[0].checked = true;
    					}
    				},
    				'取消'	: {
    					'class'	: 'gray',
    					'action': function(){
    						isPush[0].checked = false;
    			    		isPush[1].checked = true;
    					}	
    				}
    			}
    		});
    	});
    });
    
    $(function() {
    	$(document).keyup(function(event){
			  if(event.keyCode ==13){
				  confirmPublish();		
			  }
		});
    });
    
    $(function() {
    	
    	//app小图
    	$('#annoPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('anno', 'annoPic', '2', '1');
        	$('#uploadField').val('annoPic');
    	});
    	
    	//app小图
    	$('#appPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('anno', 'appPic', '1', '1');
        	$('#uploadField').val('appPic');
    	});    	
    	

    	//选择范围结点
        $('#scopeTree').tree({
            checkbox: true,
            onSelect: function(node){
                var children = $('#scopeTree').tree('getChildren', node.target);
                if(children.length != 0) {//无子元素加入子结点,已有则展开结点即可
                	$('#scopeTree').tree('expend', node);
                }
            }
        });

        //显示范围层
        $("#showScopeLayer").click(function(){
            $("#scopeLayer").fadeIn("slow");
            $("#scopeLayer").css("height",$(document.body).outerHeight(true)+'px');
            $("#scopeBar").css("height",$(document.body).outerHeight(true)-40+'px');
            //显示楼栋数结构
            $.ajax({
                url: '${ctx}/business/businessAnno/getBuildingsByUser.do',
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

        //关闭范围层
        $('#closeScope').click(function() {
            $("#scopeLayer").fadeOut("slow");
        });

        //选择范围
        $('#scopeOk').click(function() {
            var scopeIds = '';
            var scopeAry = [];
            var scopeInfo = '';
            var scopeNodes = $('#scopeTree').tree('getChecked');
            if(scopeNodes != null && scopeNodes.length > 0) {
                for(var i=0;i<scopeNodes.length;i++) {
                    var node = scopeNodes[i];
                    var idArr = node.id.split('_');
                    var typeid = idArr[0];
                    scopeIds += idArr[1] + ':' + node.text + ',';
                    scopeInfo += node.text + ',';
                }
                if(scopeIds != '') {
                    if(scopeIds.indexOf(',') > -1) {
                        scopeIds = scopeIds.substring(0, scopeIds.length-1);
                        scopeInfo = scopeInfo.substring(0, scopeInfo.length-1);
                    }
                }
                $('#annoBuilding').val(scopeIds);
                $('#annoScopeInfo').val(scopeInfo);
                
                $('#scopeShow').html(scopeInfo);
                $('#scopeShow').focus();
                
                $("#scopeLayer").fadeOut("slow");
            }else{
                alert('请选择负责范围');
            }
        });

        //取消选择范围
        $('#scopeCancel').click(function() {
            $("#scopeLayer").fadeOut("slow");
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
                    window.location.href = '<%=ctx%>/business/businessAnno/list.do';
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
                            window.location.href = '<%=ctx%>/business/businessAnno/list.do';
                        }
                    });
            	}
            },
            errorClass: "error",
            success: function(label) {
                label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
            },
            rules: {
                annoTitle: {
                    required: true,
                    maxlength: 24
                },
                brief: {
                	required: true,
                	maxlength: 28
                },
                annoBuilding: {
                    required: true
                },
                annoContent: {
                    required: true
                },
                /* annoPic: {
                    required: true
                }, */
               appPic: {
                    required: true
                }, 
                isPush: {
                    required: true
                },
                isRecommend: {
                    required: true
                },
                publishState: {
                    required: true
                }
            },
            messages: {
                annoTitle: {
                    required: "请输入公告标题",
                    maxlength: "公告标题最多24个字"
                },
                brief: {
                	required: "请输入公告简介",
                	maxlength: "公告简介最多28个字"
                },
                annoBuilding: {
                    required: "请选择管理范围"
                 },
                 annoContent: {
                     required: "请输入公告内容"
                 },
                 /* annoPic: {
                 	required: "请选择公告列表大图"
                 }, */
                 appPic: {
                     required: "请选择APP首页小图"
                 },
                 isPush: {
                     required: "请选择是否推送"
                 },
                 isRecommend: {
                     required: "请选择是否推荐到焦点图"
                 },
                 publishState: {
                    required: "请选择发布状态"
                 }
            }
        });
    	
    });

//提交表单
function confirmPublish() {
    var content = um.getContent();
    var temp = '<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>';
    if(content != temp) {
        $('input[name="annoContent"]').val(um.getContent());
    }

    var ff = $('#ff');
    /*$.each($('input[name="annoPic"]'), function(i, n) {
        var v = $(this).val();
        ff.append('<input type="hidden" name="annoPic" value="'+v+'">');
    });*/
    ff.submit();
}
    
</script>
</html>
