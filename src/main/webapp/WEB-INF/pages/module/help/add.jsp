<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/23
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布社区聊吧信息</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
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
                            window.location.href = '<%=ctx%>/business/businessHelp/list.do';
                        }
                    });
                },
                errorClass: "error",
                success: function(label) {
                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
                },
                rules: {
                    helperId: {
                        required: true
                    },
                    isExpend: {
                        required: true
                    },
                    helpContent: {
                        required: true,
                        maxlength:1000
                    }
                },
                messages: {
                    helperId: {
                        required: '请选择居民！'
                    },
                    isExpend: {
                        required: '请选择社区聊吧范围！'
                    },
                    helpContent: {
                        required: '请输入社区聊吧信息！'
                    }
                }
            });
        });
       
        function submitForm() {
            var content = ue.getContent();
            if(content != '') {
                //设置内容
                $('#helpContent').val(ue.getContent());
            }
            $('#ff').submit();
        }
    </script>
</head>
<body class="bagcolr">
    <div class="wrapper wranews">
        <div class="newsrel">
        <form id="ff" action="${ctx}/business/businessHelp/save.do" method="post">
            <div class="header-public"><span class="return" onclick="history.go(-1)"></span>社区聊吧发布</div>
            <div class="cont-l">                
                <h2 class="relran y-fbes-bdr">绑定居民<label for="helperId" class="error success"></label></h2>
	            <div style="position:relative;">
	            	<span class="ranbut radiusbox" id="showPeopleLayer">点击选择居民</span>
	            	<lable style="position: absolute; top: 10px; left: 160px;" id="publisherShow"></lable>
	            </div>
			    <input type="hidden" class="iptnewtit" name="helperId" id="helperId"> <%--社区聊吧人ID--%>
                <input type="hidden" class="iptnewtit" name="helperName" id="helperName"> <%--社区聊吧人姓名--%>
                <input type="hidden" class="iptnewtit" name="estateName" id="estateName"> <%--社区聊吧小区--%>
                <input type="hidden" class="iptnewtit" name="estateId" id="estateId"> <%--社区聊吧小区ID--%>      
			                    
                <h2 class="relran y-fbes-bdr">社区聊吧范围<label for="isExpend" class="error success"></label></h2>
	            <div style="position:relative;">
	            	<span class="ranbut radiusbox" id="showScopeLayer">点击选择社区聊吧范围</span>
	            	<lable style="position: absolute; top: 10px; left: 160px;" id="scopeShow"></lable>
	            	<lable style="position: absolute; top: 10px; left: 160px;" id="estatesShow"></lable>
	            </div>
			    <input type="hidden" class="iptnewtit" name="isExpend" id="isExpend"> 
                
                <h2 class="newscont">社区聊吧内容<label for="helpContent" class="error success"></label></h2>
                <textarea id="helpContent" name="helpContent" type="text/plain" style="width:1024px;height:150px;"></textarea>
                
                <div class="submtpres">
                    <input id="qrbut" type="button" value="确认提交" onclick="submitForm()"/>
                </div>
            </div>
            </form>
        </div>
    </div>

<!-- 居民选择开始 -->            
<div id="peopleLayer" class="busswi y-fbes-jm">
	<div id="peopleBar" class="sidebar y-fbes-jms">
    	<a id="y-fbes-close" class="close" href="javascript:;" onclick="cancelSearch();"></a>
    	<h2 class="tit">居民选择<label id="moileMsg" class="error success"></label></h2>
        <div id="wrapper-250">
	          <div class="y-fbes-s">
	                <input id="tel" type="text"  placeholder="请输手机号"  name="" class="y-fbes-st">
	                <input type="submit" value="搜索" name="" class="y-fbes-ss" onclick="findUser();">
	          </div>
	          
	          <div class="y-fbes-xx">
	          		<span><label for="userId" class="error success"></label></span>
		            <input type="hidden" name="userId" id="userId" value="" />
		            <span id="portrait"  class="xx-tp"></span>
		            <p class="xx-wz">
			            <span>真实姓名：<lable id="realname"></lable></span>
                        <span>绑定手机：<lable id="boundphone"></lable></span>
                        <span>昵称：<lable id="nickname"></lable></span>
                        <span>地址：<lable id="address"></lable></span>
		            </p>
	          </div>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  value="确定" onclick="submitF();"/>
			<input class="w-gg-qx w-gg-total" type="button"  value="取消" onclick="cancelSearch();"/>
        </div>
    </div>
</div>
<!-- 居民选择结束 -->            

<!-- 社区聊吧范围选择开始 -->
<div id="scopeLayer" class="busswi y-fbes-jm">
	<div id="scopeBar" class="sidebar y-fbes-jms">
    	<a id="y-fbes-close" class="close" href="javascript:;" onclick="$('#scopeLayer').fadeOut('slow');"></a>
    	<h2 class="tit">社区聊吧范围选择</h2>
        <div id="wrapper-250">
	          <ul class="accordion5">
                <li id="one2" class="files">
                    <input class="radiostyle2" type="radio" value="0" name="isExpendSel" onclick="checkedRadio(this, 'isExpend','本小区');">
                    <a href="#one">本小区</a>
                </li>
                <li id="two2" class="mail">
                    <input class="radiostyle2" type="radio" value="1" name="isExpendSel" onclick="checkedRadio(this,'isExpend','扩散发布');">
                    <a href="#two">扩散发布</a><br>
                	<ul id="scopeTree"></ul>
                </li>
            </ul>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  id="scopeOk"  value="确定" />
			<input class="w-gg-qx w-gg-total" type="button"  id="scopeCancel" value="取消" />
        </div>
    </div>
</div>
<!-- 社区聊吧范围选择结束 -->
	
<%--初始化文本编辑器--%>
<script type="text/javascript">
    //实例化编辑器
    var ue = UE.getEditor('helpContent',{
    	toolbars: [[
			'undo', 'redo', '|', 'bold', 'underline', 'forecolor', 'backcolor', 'simpleupload', 'justifyleft', 'justifycenter', 'justifyright'
    	]]
    });
    
    //搜索居民
    function findUser() {
    	if ($("#tel").val() == "") { 
	        $("#moileMsg").html("<font color='red'>请填写居民注册手机！</font>"); 
	        $("#tel").focus(); 
	        return false; 
        } else if (!$("#tel").val().match(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/)) { 
	        $("#moileMsg").html("<font color='red'>手机号码格式不正确！请重新输入！</font>"); 
	        $("#tel").focus(); 
	        return false; 
        } else {
        	$.post('${ctx}/app/appUser/getAppUserInfoByTel.do', {tel: $('#tel').val()}, function(data) {
    			eval("data = "+data);
                if(data != null) {
                	if(data.userId != undefined) {
                		$('#portrait').html('<img src="<%=ctx %>'+data.portrait+'" style="width:100%;">'); //头像
                        $('#userId').html(data.userId); 	//用户ID
                        $('#realname').html(data.realname); 	//真实姓名
                        $('#boundphone').html(data.boundphone); 		//绑定手机
                        $('#nickname').html(data.nickname); 	//昵称
                        $('#address').html(data.estateName+data.buildingName+data.unitName+data.houseNo); 	//地址
                        
			            $('input[name="helperId"]').val(data.userId);
			            $('input[name="helperName"]').val(data.realname);
			            $('input[name="estateId"]').val(data.estateId);
			            $('input[name="estateName"]').val(data.estateName);
			            $("#moileMsg").html("<font color='red'>填写正确！</font>"); 
                	} else {
                		$("#moileMsg").html("<font color='red'>该手机号码注册用户不存在！</font>"); 
    			        $("#tel").focus(); 
    			        return false; 
                	}	                        
                }
            });
        	return true; 
        }
    }
    
    // 取消选择居民
    function cancelSearch() {
	    $('#peopleLayer').fadeOut('slow');
   	    $('#portrait').empty(); 	//头像
        $('#userId').empty(); 		//用户ID
        $('#realname').empty(); 			//真实姓名
        $('#boundphone').empty(); 		//绑定手机
        $('#nickname').empty(); 	//昵称
        $('#address').empty(); 		//地址
        $("#moileMsg").empty(); 	
        
       	$('input[name="helperId"]').val("");
       	$('input[name="helperName"]').val("");
       	$('input[name="estateId"]').val("");
       	$('input[name="estateName"]').val("");
		
        $('#publisherShow').empty(); 	
		$('#tel').val("");
	}
    
    // 确认选择居民
    function submitF() {
    	if ($("#tel").val() == "") { 
	        $("#moileMsg").html("<font color='red'>请填写居民注册手机！</font>"); 
	        $("#tel").focus(); 
	        return false; 
        } else if (!$("#tel").val().match(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/)) { 
	        $("#moileMsg").html("<font color='red'>手机号码格式不正确！请重新输入！</font>"); 
	        $("#tel").focus(); 
	        return false; 
        } else {
        	$.post('${ctx}/app/appUser/getAppUserInfoByTel.do', {tel: $('#tel').val()}, function(data) {
    			eval("data = "+data);
                if(data != null) {
                	if(data.userId != undefined) {
                		$('#portrait').html('<img src="<%=ctx %>'+data.portrait+'" style="width:100%;">'); //头像
                        $('#userId').html(data.userId); 	//用户ID
                        $('#realname').html(data.realname); 	//真实姓名
                        $('#boundphone').html(data.boundphone); 		//绑定手机
                        $('#nickname').html(data.nickname); 	//昵称
                        $('#address').html(data.estateName+data.buildingName+data.unitName+data.houseNo); 	//地址
                        
			            $('input[name="helperId"]').val(data.userId);
			            $('input[name="helperName"]').val(data.realname);
			            $('input[name="estateId"]').val(data.estateId);
			            $('input[name="estateName"]').val(data.estateName);
			            $("#moileMsg").html("<font color='red'>填写正确！</font>"); 
			            
			            $('#publisherShow').html($('input[name="helperName"]').val());
			     		$('#peopleLayer').fadeOut('slow');
                	} else {
                		//alert("该手机号码注册用户不存在！");	
                		$("#moileMsg").html("<font color='red'>该手机号码注册用户不存在！</font>"); 
    			        $("#tel").focus(); 
    			        return false; 
                	}	                        
                }
            });
        	return true; 
        }
     }
    
    function checkedRadio(obj, name, display) {
    	if(obj.value == 0) {
    		$('#scopeTree').hide();
    	}else{
    		$('#scopeTree').show();
    	}
        $('#isExpend').val(obj.value);
        $('#scopeShow').text(display);
    }
    
    $(function() {
    	//显示居民层    
        $("#showPeopleLayer").click(function(){
      		$("#peopleLayer").fadeIn("slow");
        });
    	
        //选择社区聊吧范围结点
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
    	
	    //显示社区聊吧范围层
	    $("#showScopeLayer").click(function(){
	   	        $("#scopeLayer").fadeIn("slow");
	   	        //显示楼栋数结构
	   	        $.ajax({
	   	            url: '${ctx}/business/businessHelp/getExpendScopeTree.do',
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
		
	    //选择社区聊吧范围
	    $('#scopeOk').click(function() {
    		if($('input[name="isExpendSel"]:checked').val() == 0){
    			$("#scopeLayer").fadeOut("slow");
    		} else if($('input[name="isExpendSel"]:checked').val() == 1){
    			var scopeIds = '';
    	        var scopeInfo = '';
    	        var scopeNodes = $('#scopeTree').tree('getChecked');
    	        if(scopeNodes != null && scopeNodes.length > 0) {
    	            for(var i=0;i<scopeNodes.length;i++) {
    	                var node = scopeNodes[i];
    	                var idArr = node.id.split('_');
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
    	            alert('请选择社区聊吧范围');
    	        }
    		} else {
    			alert('请选择社区聊吧范围');
    		}
	    });
		
	    //取消选择社区聊吧范围
	    $('#scopeCancel').click(function() {
	        $("#scopeLayer").fadeOut("slow");
	    });
    });
</script>
</body>
</html>