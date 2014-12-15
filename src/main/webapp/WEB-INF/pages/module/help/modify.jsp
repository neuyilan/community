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
    <title>求助发布</title>
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
                    scope: {
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
                    scope: {
                        required: '请选择范围！'
                    },
                    helpContent: {
                        required: '请输入求助信息！'
                    }
                }
            });
        });

        //搜索用户
        function findUser() {
        	var tel = $('#tel').val();
        	if(tel != '') {
        		$.getJSON('${ctx}/app/appUser/getAppUserInfoByTel.do', {tel: $('#tel').val()}, function(data) {
        			if(data.success == 'true') {
                        $('#portrait').attr('src',data.portrait); //头像
                        $('#realname').text(data.realname); //真实姓名
                        $('#boundphone').text(data.boundphone); //绑定手机
                        $('#nickname').text(data.nickname); //昵称
                        $('#address').text(data.estateName+data.buildingName+data.unitName+data.houseNo); //地址
                        /*设置隐藏域*/
                        $('#helperId').val(data.userId);  //求助人ID
                        $('#helperName').val(data.realname); //求助人姓名
                        $('#estateId').val(data.estateId);  //求助人ID
                        $('#estateName').val(data.estateName); //求助人姓名
                        $('#publisherShow').text(data.realname);
                    }else{
                    	alert('该电话用户不存在');
                    	$('#portrait').attr('src',''); //头像
                        $('#realname').text(''); //真实姓名
                        $('#boundphone').text(''); //绑定手机
                        $('#nickname').text(''); //昵称
                        $('#address').text(''); //地址
                        /*设置隐藏域*/
                        $('#helperId').val('');  //求助人ID
                        $('#helperName').val(''); //求助人姓名
                        $('#estateId').val('');  //求助人ID
                        $('#estateName').val(''); //求助人姓名
                        $('#publisherShow').text('');
                    }
                });
        	}else{
        		alert('请输入注册时的手机号码');
        	}
        }
        
        function submitForm() {
            var content = ue.getContent();
            if(content != '') {
                //设置内容
                $('#helpContent').val(ue.getContent());
            }
            $('#ff').submit();
        }
        
        function checkedRadio(obj, name, display) {
        	if(obj.value == 0) {
        		$('#scopeTree').hide();
        	}else{
        		$('#scopeTree').show();
        	}
            $('#isExpend').val(obj.value);
            alert($('#isExpend').val());
            $('#scopeShow').text(display);
        }
    </script>
</head>
<body class="bagcolr">
<form id="ff" action="${ctx}/business/businessHelp/update.do" method="post">
    <div class="wrapper wranews">
        <div class="newsrel">
            <div class="header-public"><span class="return" onclick="history.go(-1)"></span>求助发布</div>
            <div class="cont-l">
                <h2 class="title">绑定居民<label for="helperId" class="error success"></label></h2>
                <span class="ranbut radiusbox" id="y-fbes-sjm">点击选择居民</span>
                <input type="hidden" name="helperId" id="helperId" value="${businessHelp.helperId }"> <%--求助人ID--%>
                <input type="hidden" name="helperName" id="helperName" value="${businessHelp.helperName }" > <%--求助人姓名--%>
                <input type="hidden" name="estateName" id="estateName" value="${businessHelp.estateName }" > <%--求助小区--%>
                <input type="hidden" name="estateId" id="estateId" value="${businessHelp.estateId }" > <%--求助小区ID--%>
                <span id="publisherShow"></span>
                
                <h2 class="title">求助范围<label for="scope" class="error success"></label></h2>
                <span class="ranbut radiusbox" id="showScopeLayer">点击选择范围</span>
                <input type="hidden" id="isExpend" name="isExpend" value="${businessHelp.isExpend }" />
                <span id="scopeShow">
                	<c:if test="${businessHelp.isExpend == 0 }">本小区</c:if>
                	<c:if test="${businessHelp.isExpend == 1 }">扩散发布</c:if>
                </span>
                <span id="estatesShow">
                <c:if test="${businessHelp.isExpend == 0 }">${businessHelp.estateName }</c:if>
                <c:if test="${businessHelp.isExpend == 1 }"></c:if>
                </span>
                
                <h2 class="newscont">求助内容<label for="helpContent" class="error success"></label></h2>
                <textarea id="helpContent" name="helpContent" type="text/plain" style="width:1024px;height:150px;">${businessHelp.helpContent }</textarea>
                
                <div class="submtpres">
                    <input id="qrbut" type="button" value="确认提交" onclick="submitForm();"/>
                </div>
            </div>
        </div>

    </div>
    <%--小区范围--%>
    <!-- 范围选择开始 -->
	<div id="scopeLayer" class="busswi">
	    <div id="scopeBar" class="sidebar">
	        <a id="close" href="javascript:;"></a>
	        <h2 class="tit">范围选择</h2>
	        <!--<hr class="link">-->
	        <div id="wrapper-250">
	        	<ul class="accordion3">
	                <li id="one2" class="files">
	                    <input class="radiostyle2" type="radio" value="0" name="isExpendSel" onclick="checkedRadio(this, 'isExpend','本小区');">
	                    <a href="#one">本小区</a>
	                </li>
	                <li id="two2" class="mail">
	                    <input class="radiostyle2" type="radio" value="1" name="isExpendSel" onclick="checkedRadio(this,'isExpend','扩散发布');">
	                    <a href="#two">扩散发布</a>
	                </li>
	            </ul>
	            <ul id="scopeTree" style="font-size: 18px;"></ul>
	            <ul>
		          	<div class="w-gg-btn">
		            	<span class="w-gg-qr w-gg-total" id="scopeOk" style="cursor: pointer;">确认</span>
		            	<span class="w-gg-qx w-gg-total" id="scopeCancel" style="cursor: pointer;">取消</span>
		        	</div>
		        </ul>
	        </div>
	    </div>
	</div>

	<!-- 居民选择 -->
    <div class="busswi y-fbes-jm">
        <div class="sidebar" id="y-fbes-jms">
            <a id="y-fbes-close" class="close" href="javascript:;"></a>
            <h2 class="tit">居民选择</h2>
            <div id="wrapper-250">
                <div class="y-fbes-s">
                    <input type="text" placeholder="请输入注册时的手机号码" name="tel" id="tel" class="y-fbes-st">
                    <input type="button" value="搜索" class="y-fbes-ss" onclick="findUser();">
                </div>

                <div class="y-fbes-xx">
                    <span class="xx-tp"><img id="portrait" style="width:100%;" src=""></span>
                    <p class="xx-wz">
                            <span>真实姓名：<i id="realname"></i></span> <br>
                            <span>绑定手机：<i id="boundphone"></i></span> <br>
                            <span>昵称：<i id="nickname"></i></span> <br>
                            <span>地址：<i id="address"></i></span> <br>

                    </p>
                </div>
            </div>
            <!--添加 20140717-->
            <%--<div class="w-gg-btn">
                <span class="w-gg-qr w-gg-total">确认</span>
                <span class="w-gg-qx w-gg-total">取消</span>
            </div>--%>
            <!-- 添加完毕-->

            <script type="text/javascript">
                $(document).ready(function() {
                    var accordion_head = $('.accordion2 > li > a'),
                            accordion_body = $('.accordion2 li > .sub-menu');
                    accordion_head.first().addClass('active').next().slideDown('normal');
                    accordion_head.on('click', function(event) {
                        event.preventDefault();
                        if ($(this).attr('class') != 'active'){
                            accordion_body.slideUp('normal');
                            $(this).next().stop(true,true).slideToggle('normal');
                            accordion_head.removeClass('active');
                            $(this).addClass('active');
                        }
                    });
                });
            </script>

        </div>

    </div>


</form>
<%--初始化文本编辑器--%>
<script type="text/javascript">
    //实例化编辑器
    var ue = UE.getEditor('helpContent');
    
    $(function() {

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
    	            url: '${ctx}/business/businessHelp/getExpendScopeTree.do',
    	            dataType: 'json',
    	            cache: false,
    	            success: function (data) {
    	                if(data.success == true){
    	                    var rows = data.result;
    	                    //alert('data.result   '+rows.length);
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
    });
    
</script>
</body>
</html>
