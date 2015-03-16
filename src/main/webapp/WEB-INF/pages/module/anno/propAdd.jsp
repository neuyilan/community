<%--<!DOCTYPE html>--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>

<head>
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
</head>

<body class="bagcolr">
<form id="ff" action="${ctx}/business/businessAnno/savePropAnno.do" method="post">
<div class="wrapper wranews">
    <div class="newsrel">
        <div class="header-public"><span class="return" onclick="history.go(-1)" style="cursor: pointer;"></span>公告发布</div>
        <div class="cont-l">
            <h2 class="title" style="font-weight: bold;">公告标题<label for="annoTitle" class="error success"></label></h2>
            <input class="iptnewtit" type="text" id="annoTitle" name="annoTitle" placeholder='请输入公告标题24字以内' />
            <br /><br />
            <h2 class="brief" style="font-weight: bold;">公告简介<label for="brief" class="error success"></label></h2>
            <input class="iptnewtit" type="text" name="brief" id="brief" placeholder='请输入简介28字以内' />
            
            <h2 class="relran" style="font-weight: bold;">公告展示范围<label for="annoBuilding" class="error success"></label></h2>
            <div style="position:relative;">
	            <span class="ranbut radiusbox" id="showScopeLayer">点击选择范围</span>
            	<input type="hidden" id="scope" name="scope" value="" />
            	<input type="hidden" id="annoBuilding" name="annoBuilding" value="" />
            	<input type="hidden" id="annoScopeInfo" name="annoScopeInfo" value="" />
	            <lable style="position: absolute; top: 10px; left: 160px;"  id="scopeShow"></lable>
            </div>
		            
            <!-- <h2 class="relran" style="font-weight: bold;">公告类型<label for="annoType" class="error success"></label></h2>
            <div style="position:relative;">
	            <span class="ranbut radiusbox" id="annoTypeBtn">点击选择类型</span><em>可根据小区进行公告展示范围限定</em> -->
            	<input type="hidden" id="annoType" name="annoType" value="0"/>
	            <!-- <lable style="position: absolute; top: 10px; left: 160px;"  id="annoTypeShow"></lable>
            </div> -->
            
            <h2 class="newscont" style="font-weight: bold;">公告内容<label for="annoContent" class="error success"></label></h2>
            <%--文本编辑器--%>
            <!--style给定宽度可以影响编辑器的最终宽度-->
            <script type="text/plain" id="myEditor" style="width:840px;height:240px;"></script>
            <input type="hidden" id="annoContent" name="annoContent" value="" />
            
            <h2 class="relran" style="font-weight: bold;">公告列表大图<label for="annoPic" class="error success"></label></h2>
            <div style=" overflow:hidden;"><img id="annoPicBtn" src="${ctx}/images/icon/tp01.jpg" width="305" height="102" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽600PX、高250PX】jpg格式图片<br>图片大小不能超过100K!</div></div>
            <input type="hidden" name="annoPic" id="annoPic" value="">
            
            <%-- <h2 class="relran" style="font-weight: bold;">APP首页小图<label for="appPic" class="error success"></label></h2>
            <div style=" overflow:hidden;"><img id="appPicBtn" src="${ctx}/images/icon/add.jpg" width="100" height="100"  style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽170PX、高125PX】jpg格式图片<br>图片大小不能超过20K!</div></div>
            <input type="hidden" name="appPic" id="appPic" value="">  --%>

            <input type="hidden" name="uploadField" id="uploadField" value="">
            
            <div class="line2"></div>
            <h2 class="relstatus" style="font-weight: bold;">发布状态<label for="publishState" class="error success"></label></h2>
            <div class="options">
                <p>
                <shiro:hasPermission name="prop_anno_instant_publish">
                <label>
                        <input class="radiostyle" type="radio" name="publishState" value="0">
                        立即发布</label>
                    <br>
                </shiro:hasPermission>
                    <shiro:hasPermission name="prop_anno_audting_anno">
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
            <div  id="importantline2" class="line2"></div>
            <h2 id="importanth2" class="relstatus" style="font-weight: bold;">是否重要通知<label for="isImportant" class="error success"></label></h2>
            <div id="importantdiv" class="options">
                <p>
                    <label>
                        <input class="radiostyle"  type="radio" name="isImportant" value="0" checked id="RadioGroup1_1" onclick="importantSel(0)">
                        否</label>
                    <br><br>
                    <label>
                        <input class="radiostyle" type="radio" name="isImportant" value="1" id="RadioGroup1_0" onclick="importantSel(1)">
                        是</label>
                    
                    <br>
                </p>
            </div>
            <div id="setTimeDiv" style="display: none;">
	            <h2 class="relstatus" style="font-weight: bold;">定时推送<label for="setTime" class="error success"></label></h2>
	            <span class="timebut radiusbox" id="setTimeBtn" >点击设置时间</span>
	            <input type="hidden" name="setTime" id="setTime"/>
	            <span id="setTimeShow"></span>
			</div>
            <div class="submtpres">
                <input id="qrbut" type="button" value="确认提交" onclick="confirmPublish();"/>
            </div>
        </div>
    </div>
</div>

<!-- 范围选择开始 -->
<div id="scopeLayer" class="busswi y-fbes-jm">
	<div id="scopeBar" class="sidebar y-fbes-jms">
    	<a id="y-fbes-close" class="close" href="javascript:;" onclick="$('#scopeLayer').fadeOut('slow');"></a>
    	<h2 class="tit">公告展示范围选择</h2>
        <div id="wrapper-250">
	          <ul id="scopeTree" style="font-size: 18px;"></ul>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  value="确定"  id="scopeOk" />
			<input class="w-gg-qx w-gg-total" type="button"  value="取消" onclick="$('#scopeLayer').fadeOut('slow');"/>
        </div>
    </div>
</div>
<!-- 范围选择结束 -->

<div id="annoTypeLayer" class="busswi y-fbes-jm">
	<div  id="annoTypeBar"  class="sidebar y-fbes-jms">
    	<a class="close" href="javascript:;" onclick="$('#annoTypeLayer').fadeOut('slow');"></a>
    	<h2 class="tit">公告类型选择</h2>
        <div id="wrapper-250">
	          <ul class="accordion5">
	          		<li id="one2" class="files">
	                    <input class="radiostyle2" type="radio" value="0" name="annoTypeRadio" onclick="checkedRadio(this, 'annoType','通知类公告');">
	                    <a href="#one">通知类公告</a>
	                </li>
	                <li id="two2" class="mail">
	                    <input class="radiostyle2" type="radio" value="1" name="annoTypeRadio" onclick="checkedRadio(this,'annoType','信息传达类公告');">
	                    <a href="#two">信息传达类公告</a>
	                </li>
	          </ul>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  value="确定"  onclick="$('#annoTypeLayer').fadeOut('slow');"/>
			<input class="w-gg-qx w-gg-total" type="button"  value="取消" id="annoTypeCancel" />
        </div>
    </div>
</div>

<!-- 设定时间开始 -->
<div id="setTimeLayer" class="busswi">
    <div id="setTimeBar" class="sidebar">
        <a id="close" class="close_effect" href="javascript:$('#setTimeLayer').fadeOut('slow');"></a>
        <h2 class="tit">类型列表</h2>
        <!--<hr class="link3">-->
        <div>
        	<ul style="font-size: 18px;">
            	<div id="datepicker"></div>
            </ul>
        	<ul>默认自动获取当天日期</ul>
            <ul class="accordion3">
                <div>&nbsp;</div>
            	<div><span>时间</span><span>
            		<select name="setHour" id="setHour">
            			<option value="">小时</option>
            			<option value="01">01</option>
            			<option value="02">02</option>
            			<option value="03">03</option>
            			<option value="04">04</option>
            			<option value="05">05</option>
            			<option value="06">06</option>
            			<option value="07">07</option>
            			<option value="08">08</option>
            			<option value="09">09</option>
            			<option value="10">10</option>
            			<option value="11">11</option>
            			<option value="12">12</option>
            			<option value="13">13</option>
            			<option value="14">14</option>
            			<option value="15">15</option>
            			<option value="16">16</option>
            			<option value="17">17</option>
            			<option value="18">18</option>
            			<option value="19">19</option>
            			<option value="20">20</option>
            			<option value="21">21</option>
            			<option value="22">22</option>
            			<option value="23">23</option>
            			<option value="00">00</option>
            		</select>
            		-
            		<select name="setMinute" id="setMinute">
            			<option value="">分钟</option>
            			<option value="00">00</option>
            			<option value="30">30</option>
            		</select>
            		</span>
            	</div>
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

</form>

<jsp:include page="/common/uploadPicJs.jsp"/>

</body>
<link rel="stylesheet" type="text/css" href="${ctx}/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<%--初始化文本编辑器--%>
<script type="text/javascript">
    //实例化编辑器
    var um = UE.getEditor('myEditor');
    
    $(function() {
    	$(document).keyup(function(event){
			  if(event.keyCode ==13){
					   confirmPublish();			
			  }
		});
    });
    
    function checkedRadio(obj, name, display) {
    	if(name == "annoType" && obj.value==0){
			$('#importantline2').css('display','block');
			 $('#importanth2').css('display','block');
			 $('#importantdiv').css('display','block');
		} else {
			$('#importantline2').css('display','none');
			$('#importanth2').css('display','none');
			$('#importantdiv').css('display','none');
			$("input[name='isImportant']").attr("checked",false); 
			$('#setTimeDiv').css('display','none');
		}
        $('input[name="'+name+'"]').val(obj.value);
        $('#annoTypeShow').text(display);
    }
    
    $(function() {
    	//关闭类型层
       	$('#annoTypeCancel').click(function() {
       		 $('#annoTypeShow').html('');
       		 $("#annoType").attr("value","");
       		 $("input[name='annoTypeRadio']").attr("checked",false); 
       		
       		 $('#importantline2').css('display','none');
       		$('#importanth2').css('display','none');
    		$('#importantdiv').css('display','none');
    		
    		$("input[name='isImportant']").attr("checked",false); 
    		$('#setTimeDiv').css('display','none');
    		
       		$('#annoTypeLayer').fadeOut('slow');
       	});
    	
    	//app小图
    	$('#annoPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('anno', 'annoPic', '2', '1');
        	$('#uploadField').val('annoPic');
    	});
    	
    	//app小图
    	/* $('#appPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('anno', 'appPic', '1', '1');
        	$('#uploadField').val('appPic');
    	});     */	
    	
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
            //显示小区结构
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
        
        //公告类型展示
        $('#annoTypeBtn').click(function() {
        	$("#annoTypeLayer").fadeIn("slow");
        });
    	
    	//定时提醒日期
        $("#datepicker").datepicker({
        	altFormat: 'yy-mm-dd',
        	dateFormat: 'yy-mm-dd',
			autoSize: true,
			changeMonth: true,
			minDate: 0
		},
		$.datepicker.regional['zh-CN']);
    	
    	$('#annoTypeOk').click(function() {
    		var annoType = $("input[name='annoTypeRadio']:checked").val();
    		if(annoType == undefined) {
    			alert('请选择公告类型');return;
    		}else{
    			$("#annoTypeLayer").fadeOut("slow");
    		}
    	});
    	
    	//显示定时提醒
        $("#setTimeBtn").click(function(){
            $("#setTimeLayer").fadeIn("slow");
            $("#setTimeLayer").css("height",$(document.body).outerHeight(true)+'px');
            $("#setTimeBar").css("height",$(document.body).outerHeight(true)-40+'px');
        });

        //关闭时间设置
        $('#closeSetTime').click(function() {
            $("#setTimeLayer").fadeOut("slow");
            $('#setHour').val('');
    		$('#setMinute').val('');
        });
        
        //选择时间
        $('#setTimeOk').click(function() {
        	var date = $("#datepicker").datepicker("getDate");
        	if(date == '') {
        		alert('请选择日期');
        	}else if($('#setHour').val() == '' || $('#setMinute').val() == '') {
        		alert('请选择小时和分钟');
        	}else{
        		//获得日期和时间
        		var hour = $('#setHour').val();
        		var minute = $('#setMinute').val();
        		$('#setTime').val(formatDate(date)+' '+hour+':'+minute);
        		$('#setTimeShow').text(formatDate(date)+' '+hour+':'+minute);
        		$("#setTimeLayer").fadeOut("slow");
        	}
        });
        
      	//取消时间设置
        $('#setTimeCancel').click(function() {
            $("#setTimeLayer").fadeOut("slow");
            $('#setHour').val('');
    		$('#setMinute').val('');
        });
      	$('.closeSetTime').click(function() {
      		$("#setTimeLayer").fadeOut("slow");
      		$('#setHour').val('');
    		$('#setMinute').val('');
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
                        if(data.success == 'true') {
                        	alert(data.message);
                        	window.location.href = '<%=ctx%>/business/businessAnno/propList.do';
                        }else{
                        	alert(data.message);
                        }
                    }
                });
            },
            errorClass: "error",
            success: function(label) {
                label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
            },
            rules: {
                annoTitle: {
                    required: true,
                    maxlength:24
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
                }, 
                appPic: {
                    required: true
                },*/
                publishState: {
                    required: true
                },
               /*  isImportant: {
                    required: true
                }, */
                annoType: {
                    required: true
                }
            },
            messages: {
                annoTitle: {
                    required: "请输入公告标题",
                    maxlength: "公告最多24个字"
                },
                brief: {
                	required: '请输入公告简介',
                	maxlength: '公告简介在28字以内'
                },
                annoBuilding: {
                    required: "请选择管理范围"
                 },
                 annoType: {
                    required: "请选择公告类型"
                 },
                 annoContent: {
                    required: "请输入公告内容"
                 },
                /*  annoPic: {
                 	required: "请选择公告列表大图"
                 }, 
                 appPic: {
                     required: "请选择APP首页小图"
                 },*/
                 publishState: {
                    required: "请选择发布状态"
                 }/* ,
                 isImportant: {
                    required: "请选择是否重要通知"
                 } */
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
  
  //删除图片
    function delImg(o) {
        //删除页面元素
        $(o).parent().remove();
        //删除后台数据及图片
    }
    
  	//时间选择显示
    function importantSel(idvalue) {
    	var important = $("input[name='isImportant']:checked").val();
    	if(important == 1) {
    		$('#setTimeDiv').show();
    	}else{
    		$('#setTimeDiv').hide();
    	}
    }
    
    function formatDate(date) { 
    	var year = date.getFullYear(); 
    	var month = date.getMonth() + 1; 
    	var day = date.getDate(); 
    	return year + "-" + formatTen(month) + "-" + formatTen(day); 
    }
    
    function formatTen(num) { 
    	return num > 9 ? (num + "") : ("0" + num); 
    }
    
</script>
</html>
