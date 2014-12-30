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
	<link rel="stylesheet" type="text/css" href="${ctx}/css/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
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
</head>

<body class="bagcolr">
	<form id="ff" action="${ctx}/business/businessAnno/saveOperationAnno.do" method="post">
		<div class="wrapper wranews">
		    <div class="newsrel">
		        <div class="header-public" style="cursor: pointer;"><span class="return" onclick="history.go(-1)" style="cursor: pointer;"></span>公告发布</div>
		        <div class="cont-l">
		            <h2 class="relran" style="font-weight: bold;">公告标题<label for="annoTitle" class="error success"></label></h2>
		            <input class="iptnewtit" type="text" name="annoTitle" placeholder='请输入公告标题24字以内' />
		            
		            <h2 class="relran" style="font-weight: bold;">公告简介<label for="brief" class="error success"></label></h2>
		            <input class="iptnewtit" type="text" name="brief" id="brief" placeholder='请输入简介28字以内' />
		            
		            <h2 class="relran" style="font-weight: bold;">公告类型<label for="annoType" class="error success"></label></h2>
		            <div style="position:relative;">
	            		<span class="ranbut radiusbox" id="showAnnoTypeLayer">点击选择类型</span>
			            <input type="hidden" name="annoType" id="annoType"/>
			            <lable style="position: absolute; top: 10px; left: 160px;" id="annoTypeShow"></lable>
		            </div>
		            <div class="line2"></div>
		            
		            <h2 class="relran" style="font-weight: bold;">公告范围<label for="scope" class="error success"></label></h2>
		            <div style="position:relative;">
			            <span class="ranbut radiusbox" id="showScopeLayer">点击选择范围</span><em>可根据小区进行公告展示范围限定</em>
			            <input type="hidden" id="scope" name="scope" value="" />
			            <input type="hidden" id="annoScopeInfo" name="annoScopeInfo" value="" />
			            <lable style="position: absolute; top: 10px; left: 160px;"  id="scopeShow"></lable>
		            </div>
		            <div class="line2"></div>
		            		            
		            <h2 id="userLevelh2" class="relran" style="font-weight: bold;">用户级别<label for="userLevel" class="error success"></label></h2>
		            <div id="userLeveldiv" style="position:relative;">
			            <span class="ranbut radiusbox" id="showUserLevelLayer">点击选择级别</span>
		            	<input type="hidden" name="userLevel" id="userLevel" value=""/>
			            <lable style="position: absolute; top: 10px; left: 160px;"  id="userLevelShow"></lable>
		            </div>
		            <div class="line2"></div>
		            
		            <h2 class="newscont" style="font-weight: bold;">公告内容<label for="annoContent" class="error success"></label></h2>
		            <%--文本编辑器--%>
		            <!-- <script type="text/plain" id="myEditor" style="width:840px;height:240px;"></script> -->
		            <textarea name="annoContent" id="annoContent" rows="5" cols="160"></textarea>
		            
		            <h2 class="relstatus" style="font-weight: bold;">是否推送<label for="isPush" class="error success"></label></h2>
		            <div class="options">
		                <p>
		                    <label><input class="radiostyle" type="radio" name="isPush" value="1" id="isPush_1" >&nbsp;是　　<em style="color:#e7402f;">选择推送后，将通过系统推送至手机用户，非重要信息请勿选择</em></label><br><br>
	                        <label><input class="radiostyle" type="radio" name="isPush" value="0" id="isPush_0" checked>&nbsp;否</label><br>
		                </p>
		            </div>
		            
		            <div class="line2"></div>
		            <h2 class="relstatus" style="font-weight: bold;">发布状态<label for="publishState" class="error success"></label></h2>
		            <div class="options">
		                <p>
		                <shiro:hasPermission name="anno_instant_publish">
		                <label>
		                        <input class="radiostyle" type="radio" name="publishState" value="0">
		                        立即发布</label>
		                    <br>
		                </shiro:hasPermission>
		                    <shiro:hasPermission name="anno_audting_anno">
		                    <br>
		                    <label>
		                        <input class="radiostyle" type="radio" name="publishState" value="1">
		                        暂缓发布</label>
		                    <br>
		                    </shiro:hasPermission>
		                    <br>
		                    <label>
		                        <input class="radiostyle" type="radio" name="publishState" value="2">
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
</body>

<!-- 公告类型选择开始 -->
<div id="annoTypeLayer" class="busswi y-fbes-jm">
	<div  id="annoTypeBar"  class="sidebar y-fbes-jms">
    	<a class="close" href="javascript:;" onclick="$('#annoTypeLayer').fadeOut('slow');"></a>
    	<h2 class="tit">公告类型选择</h2>
        <div id="wrapper-250">
	          <ul class="accordion5">
	          		<li id="one2" class="files"> 
	                    <input class="radiostyle2" type="radio" value="2" name="annoTypeRadio" onclick="checkedRadio(this, 'annoType','内部公告');">
	                    <a href="#one">内部公告</a>
	                </li>
	                <li id="two2" class="mail">
	                    <input class="radiostyle2" type="radio" value="3" name="annoTypeRadio" onclick="checkedRadio(this,'annoType','系统公告');">
	                    <a href="#two">系统公告</a>
	                </li>
	          </ul>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  value="确定"  onclick="$('#annoTypeLayer').fadeOut('slow');"/>
			<input class="w-gg-qx w-gg-total" type="button"  value="取消" id="annoTypeCancel" />
        </div>
    </div>
</div>
<!-- 公告类型选择结束 -->

<!-- 系统公告范围选择开始 -->
<div id="scopeLayer" class="busswi y-fbes-jm">
	<div id="scopeBar" class="sidebar y-fbes-jms">
    	<a id="y-fbes-close" class="close" href="javascript:;" onclick="$('#scopeLayer').fadeOut('slow');"></a>
    	<h2 class="tit">系统公告范围选择</h2>
        <div id="wrapper-250">
	          <ul id="scopeTree" style="font-size: 18px;"></ul>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  value="确定"  id="scopeOk" />
			<input class="w-gg-qx w-gg-total" type="button"  value="取消" onclick="$('#scopeLayer').fadeOut('slow');"/>
        </div>
    </div>
</div>
<!-- 系统公告范围选择结束 -->

<!-- 内部公告范围选择开始 -->
<div id="innerScopeLayer" class="busswi y-fbes-jm">
	<div id="innerScopeBar" class="sidebar y-fbes-jms">
    	<a id="closeInnerScope" class="close" href="javascript:;" onclick="$('#innerScopeLayer').fadeOut('slow');"></a>
    	<h2 class="tit">内部公告范围选择</h2>
        <div id="wrapper-250">
	          <ul id="departmentScopeTree" style="font-size: 18px;"></ul>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  value="确定"  id="innerScopeOk" />
			<input class="w-gg-qx w-gg-total" type="button"  value="取消" onclick="$('#innerScopeLayer').fadeOut('slow');"/>
        </div>
    </div>
</div>
<!-- 内部公告范围选择结束 -->

<!-- 用户级别选择开始 -->
<div id="userLevelLayer" class="busswi y-fbes-jm">
	<div id="userLevelBar" class="sidebar y-fbes-jms">
    	<a id="closeInnerScope" class="close" href="javascript:;" onclick="$('#userLevelLayer').fadeOut('slow');"></a>
    	<h2 class="tit">用户级别选择</h2>
        <div id="wrapper-250">
	          <ul class="accordion5">
	          		<li id="one2" class="files">
	                    <input class="radiostyle2" type="radio"  value="0" name="userLevel1" onclick="checkedRadio(this, 'userLevel','注册用户');">
	                    <a href="#one">注册用户</a>
	                </li>
	                <li id="two2" class="mail">
	                    <input class="radiostyle2" type="radio" value="1" name="userLevel1" onclick="checkedRadio(this,'userLevel','验证用户');">
	                    <a href="#two">验证用户</a>
	                </li>
	                <!-- 
	                <li id="two2" class="mail">
	                    <input class="radiostyle2" type="radio" value="2" name="userLevel1" onclick="checkedRadio(this,'userLevel','游客');">
	                    <a href="#two">游客</a>
	                </li>
	                 -->
	          </ul>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  value="确定"  id="userLevelOk" />
			<input class="w-gg-qx w-gg-total" type="button"  value="取消" onclick="$('#userLevelLayer').fadeOut('slow');"/>
        </div>
    </div>
</div>
<!-- 用户级别选择结束 -->

<%--初始化文本编辑器--%>
<script type="text/javascript">
    //实例化编辑器
    var um = UE.getEditor('myEditor',{
   	toolbars: [[
   				'undo', 'redo', '|', 'bold', 'underline', 'forecolor', 'backcolor', 'simpleupload', 'justifyleft', 'justifycenter', 'justifyright'
   	    	]]
   	    });
    
    $(function() {
    	$(document).keyup(function(event){
			  if(event.keyCode ==13){
				  confirmPublish();				
			  }
		});
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
    
    function checkedRadio(obj, name, display) {
		if(name == "annoType" && obj.value==2){
			$('#userLevelh2').css('display','none');
			$('#userLeveldiv').css('display','none');
		} else {
			 $('#userLevelh2').css('display','block');
 			 $('#userLeveldiv').css('display','block');
		}
		$('#'+name).val(obj.value);
	    $('input[name="'+name+'"]').val(obj.value);
	    $('#'+name+'Show').text(display);
	    $("#userLevelLayer").fadeOut("slow");
	}
    
    $(function() {
    	//关闭类型层
    	$('#annoTypeCancel').click(function() {
    		 $('#annoTypeShow').html('');
    		 $("#annoType").attr("value","");
    		 $("input[name='annoTypeRadio']").attr("checked",false); 
    		 
    		 $('#userLevelh2').css('display','block');
 			 $('#userLeveldiv').css('display','block');
 			
    		$('#annoTypeLayer').fadeOut('slow');
    	});
    	
    	//显示公告类型层
        $("#showAnnoTypeLayer").click(function(){
            $("#annoTypeLayer").fadeIn("slow");
            $("#annoTypeLayer").css("height",$(document.body).outerHeight(true)+'px');
            $("#annoTypeBar").css("height",$(document.body).outerHeight(true)-40+'px');
        });
    	
      	//显示范围层
        $("#showScopeLayer").click(function(){
        	var annoType = $('#annoType').val();
        	if(annoType == '' || annoType == null) {alert('请先选择公告类型');return;}
        	if(annoType == 2) {//内部公告
        		$("#innerScopeLayer").fadeIn("slow");
                $("#innerScopeLayer").css("height",$(document.body).outerHeight(true)+'px');
                $("#innerScopeBar").css("height",$(document.body).outerHeight(true)-40+'px');
                //显示部门小区结构
                $.ajax({
                    url: '${ctx}/manage/manageEstate/getAllDepartmentEstateTree.do',
                    dataType: 'json',
                    cache: false,
                    success: function (data) {
                         
                        if(data.success == true){
                            var rows = data.result;
                            if(rows.length > 0) {
                                $('#departmentScopeTree').tree('loadData', data.result);
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
        	}else{//系统公告
        		$("#scopeLayer").fadeIn("slow");
                $("#scopeLayer").css("height",$(document.body).outerHeight(true)+'px');
                $("#scopeBar").css("height",$(document.body).outerHeight(true)-40+'px');
                //显示小区结构
                $.ajax({
                    url: '${ctx}/manage/manageEstate/getAllEstateTree.do',
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
        	}
        });
    	
    	//用户级别选择
    	$('#showUserLevelLayer').click(function() {
    		var annoType = $("input[name='annoTypeRadio']:checked").val();
    		if(annoType == undefined) {
    			alert('请选择公告类型'); 
    		}else{
    			$("#userLevelLayer").fadeIn("slow");
    			$("#userLevelLayer").css("height",$(document.body).outerHeight(true)+'px');
    	        $("#userLevelBar").css("height",$(document.body).outerHeight(true)-40+'px');
    		}
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
    	
      //选择范围结点
        $('#departmentScopeTree').tree({
            checkbox: true,
            onSelect: function(node){
                var children = $('#scopeTree').tree('getChildren', node.target);
                if(children.length != 0) {//无子元素加入子结点,已有则展开结点即可
                	$('#scopeTree').tree('expend', node);
                }
            }
        });

        //选择系统公告范围
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
                $('#scope').val(scopeIds);
                $('#annoScopeInfo').val(scopeInfo);
                
                $('#scopeShow').html(scopeInfo);
                $('#scopeShow').focus();
                
                $("#scopeLayer").fadeOut("slow");
            }else{
                alert('请选择发布范围');
            }
        });

        //取消选择系统公告范围
        $('#scopeCancel').click(function() {
            $("#scopeLayer").fadeOut("slow");
        });

        //选择内部公告范围
        $('#innerScopeOk').click(function() {
            var scopeIds = '';
            var scopeAry = [];
            var scopeInfo = '';
            var scopeNodes = $('#departmentScopeTree').tree('getChecked');
            if(scopeNodes != null && scopeNodes.length > 0) {
                for(var i=0;i<scopeNodes.length;i++) {
                    var node = scopeNodes[i];
                    var idArr = node.id.split('_');
                    var typeid = idArr[0];
                    if(typeid == 'estate') {
                    	scopeIds += idArr[1] + ':' + node.text + ':' + idArr[2] + ',';
                        scopeInfo += node.text + ',';
                    }
                }
                if(scopeIds != '') {
                    if(scopeIds.indexOf(',') > -1) {
                        scopeIds = scopeIds.substring(0, scopeIds.length-1);
                        scopeInfo = scopeInfo.substring(0, scopeInfo.length-1);
                    }
                }
                $('#scope').val(scopeIds);
                $('#annoScopeInfo').val(scopeInfo);
                
                $('#scopeShow').html(scopeInfo);
                $('#scopeShow').focus();
                
                $("#innerScopeLayer").fadeOut("slow");
            }else{
                alert('请选择发布范围');
            }
        });

        //取消选择内部公告范围
        $('#innerScopeCancel').click(function() {
            $("#innerScopeLayer").fadeOut("slow");
        });
        
        //取消选择用户级别
        $('#userLevelCancel').click(function() {
            $("#userLevelLayer").fadeOut("slow");
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
            /* success: function(label) {
                label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
            }, */
            rules: {
                annoTitle: {
                    required: true,
                    maxlength:24
                },
                brief: {
                    required: true,
                    maxlength:28
                },
                annoType: {
                    required: true
                },
                scope: {
                    required: true
                },
               /*  userLevel: {
                    required: true
                }, */
                annoContent: {
                    required: true
                },
                isPush: {
                    required: true
                },
                publishState: {
                    required: true
                }
            },
            messages: {
                annoTitle: {
                    required: "请输入新闻标题",
                    maxlength: "公告标题最多24个字"
                },
                brief: {
                    required: "请输入新闻简介",
                    maxlength: "公告简介最多28个字"
                },
                annoType: {
                    required: '请选择公告类型'
                },
                scope: {
                    required: '请选择公告范围'
                },
                /* userLevel: {
                    required: '请选择用户级别'
                }, */
                 annoContent: {
                     required: "请输入公告内容"
                 },
                 isPush: {
                     required: "请选择是否推送"
                 },
                 publishState: {
                    required: "请选择发布状态"
                 }
            }
        });
      	
    });
    
  //提交表单
    function confirmPublish() {
        /* var content = um.getContent();
        var temp = '';
        if(content != temp) {
            $('input[name="annoContent"]').val(um.getContent());
        } */
        var ff = $('#ff');
        ff.submit();
    }
</script>
</html>