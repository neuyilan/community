<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>修改社区报员工信息</title>
	<%@include file="/common/meta.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/style.css" >
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/adaptive-2.css" >
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
	<script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
	<script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
	<script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
	<style type="text/css"> 
		label.error { color:Red; font-size:13px; margin-left:5px;  padding-left:16px; } 
	</style> 
</head>
 
<body class="bagcolr">
<div class="wrapper wranews">
    <div class="newsrel">
        <form id="addForm" modelAttribute="businessUser" method="post" action="updateCommunity.do">
    	<div class="header-public"><span class="return" onclick="history.go(-1)"></span>修改社区报员工信息</div>
        <div class="cont-l">
        <input type="hidden" name="userId" id="userId" value="${businessUser.userId }" />
        	<h2 class="relran">公司邮箱<font color="red">*</font><label for="userEmail" class="error success"></label></h2>
            <input name="userEmail" style="width:300px;" class="iptnewtit" type="text" id="userEmail" placeholder='' value="${businessUser.userEmail }" />
            
            <h2 class="relran">密码<font color="red">*</font><label for="userPassword" class="error success"></label></h2>
            <input name="userPassword" class="iptnewtit" type="password" id="userPassword" placeholder='' value="${businessUser.userPassword }" />
            
            <h2 class="relran">员工姓名<font color="red">*</font><label for="userName" class="error success"></label></h2>
            <input name="userName" class="iptnewtit" type="text" id="userName" placeholder='' value="${businessUser.userName }" />
            
            <h2 class="relran">联系电话<font color="red">*</font><label for="userTel" class="error success"></label></h2>
            <input name="userTel" style="width:300px;" class="iptnewtit" type="text" name="userTel" id="userTel" placeholder='' value="${businessUser.userTel }" />
            
            <h2 class="relran">户籍地址<label for="fromAddress" class="error success"></label></h2>
            <input name="fromAddress" class="iptnewtit" type="text" id="fromAddress" placeholder='' value="${businessUser.fromAddress }" />
            
            <h2 class="relran">居住地址<label for="homeAddress" class="error success"></label></h2>
            <input name="homeAddress"  class="iptnewtit" type="text" id="homeAddress" placeholder='' value="${businessUser.homeAddress }" />
            
            <h2 class="relstatus">性别<label for="sex" class="error success"></label></h2>
            <div class="options">
            	  <p>
            	      <input type="radio" name="sex"  class="radiostyle" id="sex1" value="0" <c:if test="${businessUser.sex == 0 }"> checked </c:if> />男 <br><br>
            	      <input type="radio" name="sex" class="radiostyle"  id="sex2" value="1" <c:if test="${businessUser.sex == 1 }"> checked </c:if> />女<br>
          	      </p>
            </div>
			<div class="line2"></div>
            
            <h2 class="relran">年龄<label for="age" class="error success"></label></h2>
            <input  name="age" style="width:100px;" class="iptnewtit" type="text" id="age"  placeholder='' value="${businessUser.age }" /> 岁
            <div class="line2"></div>
            
            <h2 class="relstatus">婚姻状况<label for="isMarriage" class="error success"></label></h2>
            <div class="options">
            	  <p>
            	      <input type="radio" name="isMarriage" class="radiostyle" id="isMarriage1" value="0" <c:if test="${businessUser.isMarriage == 0 }"> checked </c:if> />已婚 <br><br>
            	      <input type="radio"  name="isMarriage" class="radiostyle" id="isMarriage2" value="1" <c:if test="${businessUser.isMarriage == 1 }"> checked </c:if> />未婚<br>
          	      </p>
            </div>
			<div class="line2"></div>
            
            <h2 class="relran">籍贯<label for="hometown" class="error success"></label></h2>
            <input  name="hometown" style="width:100px;" class="iptnewtit" type="text" id="hometown" placeholder='' value="${businessUser.hometown }" /><br>
            <div class="line2"></div>
            
            <h2 class="relran">民族<label for="nation" class="error success"></label></h2>
            <input  name="nation" style="width:100px;" class="iptnewtit" type="text" id="nation" placeholder='' value="${businessUser.nation }" />
            <div class="line2"></div>
            
            <h2 class="relran">所属职务<font color="red">*</font><label for="positionId" class="error success"></label></h2>
            <div style="position: relative;">
				<span class="ranbut radiusbox" id="showPositionLayer">点击绑定职务</span>
	            <input type="hidden" name="positionId" id="positionId" value="${businessUser.positionId }" />
				<span style="position: absolute; top: 10px; left: 160px;" id="position">${businessUser.posName}</span>
			</div>
            <div class="line2"></div>
            
            <h2 class="relran">负责范围<font color="red">*</font><label for="scope" class="error success"></label></h2>
            <div style="position: relative;">
				<span class="ranbut radiusbox" id="showScopeLayer">点击选择范围&nbsp;&nbsp;</span>
            	<input type="hidden" name="scope" id="scope" value="${businessUser.scope }" />
				<span style="position: absolute; top: 10px; left: 160px;" id="scopeShow">
					<c:forEach items="${comList}" var="com">
	                    ${com.comName}&nbsp;&nbsp;
	                </c:forEach>
				</span>
			</div>
            <div class="line2"></div>
            
            <h2 class="relran">权限设定<font color="red">*</font><label for="rights" class="error success"></label></h2>
            <div style="position: relative;">
				<span class="ranbut radiusbox" id="showRightLayer">点击设置权限</span>
	            <input type="hidden" id="rights" name="rights" value="${businessUser.rights }" />
	            <input type="hidden" id="modules" name="modules" value="" />
	            <input type="hidden" id="rightsInfo" name="rightsInfo" value="" />
				<span style="position: absolute; top: 10px; left: 160px;" id="rightShow">${businessUser.rightsInfo }</span>
			</div>
            <div class="line2"></div>
            
            <h2 class="relran">人员昵称<font color="red">*</font><label for="nickname" class="error success"></label></h2>
            <input  name="nickname" style="width:300px;" class="iptnewtit" type="text" id="nickname" placeholder='' value="${businessUser.nickname }" />
            
            <h2 class="newscont">交流话术<label for="comWord" class="error success"></label></h2>
            <textarea class="newtext" id="comWord" name="comWord" placeholder="">${businessUser.comWord }</textarea>
            
            <h2 class="relran">头像</h2>
            <div id="divImg" style=" overflow:hidden;"><img id="avatarBtn" src="<%=ctx %>${businessUser.avatar}" width="100" height="100" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽170PX、高125PX】jpg格式图片<br>图片大小不能超过20K!</div></div>
            <input type="hidden" name="avatar" id="avatar" value="${businessUser.avatar}"> <%--头像--%>
            
            <input type="hidden" name="uploadField" id="uploadField" value="">
            
            <h2 class="newscont">人员简介<font color="red">*</font><label for="userBrief" class="error success"></label></h2>
            <textarea name="userBrief" class="newtext" id="userBrief"  placeholder="">${businessUser.userBrief }</textarea>
           
            <div class="line2"></div>
            
            <h2 class="relstatus">员工状态<font color="red">*</font><label for="state" class="error success"></label></h2>
            <div class="options">
            	  <p>
            	      <input type="radio" name="state" class="radiostyle" id="state1" value="0" <c:if test="${businessUser.state == 0 }"> checked </c:if> />启用<br><br>
            	      <input type="radio" name="state"  class="radiostyle"  id="state2" value="1" <c:if test="${businessUser.state == 1 }"> checked </c:if> />停用<br>
          	      </p>
            </div>
            <div class="submtpres">
                <input id="qrbut" type="button" name="" value="确认提交"  onclick="submitForm();"/>
            </div>
        </div>
        <hidden name="userId"/>
    	</form>
    </div>
</div>

<!-- 职务选择开始 -->
	<div id="positionLayer" class="busswi5 s-xw-bu">
        <div id="positionBar" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#positionLayer').hide();"></a>
            <h2 class="tit5">职务选择</h2>
            <div id="wrapper-250">
            	<ul style="font-size: 18px; margin-left: 20px;">选择部门展开下级职位列表(只能选择一个职位)</ul>
                <ul id="positionTree" style="font-size: 18px;"></ul>
            </div>
            <div class="s-xw-zd">
         		<div class="link6"></div>
	            <div class="submtpres">
	                   <input id="qrbut7" type="button"  value="确定" onclick="selectPosition()"/>
                       <input id="zsbut7" type="button"  value="取消" onclick="$('#positionLayer').hide();"/>
	            </div>
        	</div>
        </div>
    </div>
<!-- 职务选择开始 -->

<!-- 范围选择开始 -->
	<div id="scopeLayer" class="busswi5 s-xw-bu">
        <div id="scopeBar" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#scopeLayer').hide();"></a>
            <h2 class="tit5">范围选择</h2>
            <div id="wrapper-250">
                <ul id="scopeTree" style="font-size: 18px;"></ul>
            </div>
            <div class="s-xw-zd">
         		<div class="link6"></div>
	            <div class="submtpres">
	                	<input id="qrbut7" type="button"  value="确定" onclick="selectScope()"/>
                       <input id="zsbut7" type="button"  value="取消" onclick="$('#scopeLayer').hide();"/>
	            </div>
        	</div>
        </div>
    </div>
<!-- 范围选择开始 -->

<!-- 权限选择开始 -->
	<div id="rightLayer" class="busswi5 s-xw-bu">
        <div id="rightBar" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#rightLayer').hide();"></a>
            <h2 class="tit5">权限选择</h2>
            <div id="wrapper-250">
                <ul id="rightTree" style="font-size: 18px;"></ul>
            </div>
            <div class="s-xw-zd">
         		<div class="link6"></div>
	            <div class="submtpres">
	                   <input id="qrbut7" type="button"  value="确定" onclick="selectRight()"/>
                       <input id="zsbut7" type="button"  value="取消" onclick="$('#rightLayer').hide();"/>
	            </div>
        	</div>
        </div>
    </div>
<!-- 权限选择开始 -->

<div class="busswi3">

	<div class="sidebar3">
    
    	<a id="close3" title="关闭"  href="javascript:;"></a>
    
    	<h2 class="tit3">类型列表</h2>
        
        <!--<hr class="link3">-->
        
        <div id="wrapper-250">
        
          <ul class="accordion3">
          
            <li id="one2" class="files"><input class="radiostyle2" type="radio" name="RadioGroup1" value="记住密码" id="RadioGroup1_0"><a href="#one">通知类公告</a></li>
                   
            <li id="two2" class="mail"><input class="radiostyle2" type="radio" name="RadioGroup1" value="记住密码" id="RadioGroup1_0"> <a href="#two">信息传达类公告</a></li>
          
          </ul>
          
       </div>
        
   </div>
</div>
 <%--图片上传--%>
<jsp:include page="/common/uploadPicJs.jsp"/>
</body>
</html>
<script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
		$(document).keyup(function(event){
			  if(event.keyCode ==13){
					  submitForm();			
			  }
		});

		//提交表单
        function submitForm() {
            $('#addForm').submit();
        }
		
		//选择职务
		function selectPosition() {
			var positionNodes = $('#positionTree').tree('getChecked');
			if(positionNodes != null && positionNodes.length == 1) {
				var idArr = positionNodes[0].id.split('_');
				if(idArr[0] == 'position') {
					$('#positionId').val(idArr[1]);
					$('#position').text(positionNodes[0].text);
					$("#positionLayer").fadeOut("slow");
					$('#position').focus();
				}else{
					alert('请您选择一个职位');
				}        			
			}else{
				alert('您只能选择一个职位');
			}
		}

		 //选择范围
    	function selectScope() {
    		var scopeStr = '';//显示字符串
    		var scopeIds = '';
            var scopeAry = [];
            var estateName = '';
    		var scopeNodes = $('#scopeTree').tree('getChecked');
    		if(scopeNodes != null && scopeNodes.length > 0) {//选择了范围
    			var orgType = $('#orgType').val();
    			if(orgType == 'property') {//物业的选择
    				
    			}else{//社区报和驿站的选择
    				
    			}
     			for(var i=0;i<scopeNodes.length;i++) {
    				var node = scopeNodes[i];
    				scopeIds += node.id + ',';
    				var idArr = node.id.split('_');
                    var typeid = idArr[0];
                    if(typeid == 'com') { //如果是社区
                        if($('#scopeTree').tree('isLeaf', node.target)) {
                            scopeAry.push(node.id+"|"+node.text);
                        }
                        scopeStr += node.text + '&nbsp;&nbsp;';
                    }
    			}
    			
    			if(scopeIds != '') {
    				if(scopeIds.indexOf(',') > -1) {
    					scopeIds = scopeIds.substring(0, scopeIds.length-1);
    				}
    				$('#scope').val(scopeIds);
    				$('#scope').val(scopeAry.join(','));

    				$('#scopeShow').html(scopeStr);
    				$('#scopeShow').focus();
    			}
    			
				$("#scopeLayer").fadeOut("slow");
    		}else{
    			alert('请选择负责范围');
    		}
    	}
		
    	//选择权限
    	function selectRight() {
    		var rightNodes = $('#rightTree').tree('getChecked');
    		if(rightNodes != null && rightNodes.length > 0) {
    			moduleShow = new Array();
    	    	menuShow = new Array();
    	    	functionShow = new Array();
    			var rightStr = '';
    			var right = '';
                var modulAry = [];
    			for(var i=0;i<rightNodes.length;i++) {
    				var rightNode = rightNodes[i];
    				//获取所属模块ID
                    var moduleid = getNodeRoot(rightNode);
                    modulAry.push(moduleid);
                    //获取所属模块ID
                    var idArr = rightNode.id.split('_');
        			if(idArr[0] == 'function') {
        				right += idArr[1] + ',';
        				//构建展示集合
                        assemble(rightNode);        			
        			}
    			}
    			if(right != '') {
    				if(right.indexOf(',') > -1) {
    					right = right.substring(0, right.length-1);
    				}
    				$('#rights').val(right);
                    $('#modules').val(uniqueAry(modulAry));
                    //$('#rightShow').html('权限已设置');
                    //展示权限功能集合
                    var content = showRights();
                    $('#rightsInfo').val(content);
                    $('#rightShow').html(content);
    			}
				$("#rightLayer").fadeOut("slow");
    		}else{
    			alert('请选择权限');
    		}
    	}
    	
    	//构建权限显示数据数据 三维：模块-菜单-功能，例子：moduleId|moduleName,menuId|menuName,functionId|functionName
    	var moduleShow = new Array();
    	var menuShow = new Array();
    	var functionShow = new Array();
    	function assemble(functionNode) {        	
    		var menuNode = $('#rightTree').tree('getParent', functionNode.target);//菜单结点
    		var moduleNode = $('#rightTree').tree('getParent', menuNode.target);//模块结点
    		var hasModule = false;
    		var hasMenu = false;
    		var hasFunction = false;
    		for(var i=0;i<moduleShow.length;i++) {
    			//是否已有模块判断
    			var showArr = moduleShow[i].split('|');
    			if(moduleNode.id == showArr[0]) {
    				hasModule = true;break;
    			}
    		}
    		if(!hasModule) {moduleShow.push(moduleNode.id+'|'+moduleNode.text);}
    		for(var i=0;i<menuShow.length;i++) {
    			//是否已有菜单判断
    			var showArr = menuShow[i].split('|');
    			var showArr_temp = showArr[0].split(',');
    			if(menuNode.id == showArr_temp[1]) {
    				hasMenu = true;break;
    			}
    		}
    		if(!hasMenu) {
    			menuShow.push(moduleNode.id+','+menuNode.id+'|'+menuNode.text);
    		}
    		for(var i=0;i<functionShow.length;i++) {
    			//是否已有功能判断
    			var showArr = functionShow[i].split('|');
    			var showArr_temp = showArr[0].split(',');
    			if(functionNode.id == showArr_temp[1]) {
    				hasFunction = true;break;
    			}
    		}
    		if(!hasFunction) {
    			functionShow.push(menuNode.id+','+functionNode.id+'|'+functionNode.text);
    		}
    	}
    	//展示权限集合
    	function showRights() {
    		var showStr = '';
    		for(var i=0;i<moduleShow.length;i++) {//模块展示
    			var moduleId = (moduleShow[i].split('|'))[0];
    			showStr += '模块：'+(moduleShow[i].split('|'))[1]+'<br />';
    			//菜单遍历展示
    			
    			for(var j=0;j<menuShow.length;j++) {//菜单展示
	    			var menuId = (menuShow[j].split('|'))[0];
    				var moduleId_temp = (menuId.split(','))[0];
    				var menuId_cur = (menuId.split(','))[1];
    				if(moduleId == moduleId_temp) {
    					showStr += '&nbsp;&nbsp;'+(menuShow[j].split('|'))[1]+' : ';
    					//功能遍历展示
    	    			for(var k=0;k<functionShow.length;k++) {//功能展示
    	    				var functionId = (functionShow[k].split('|'))[0];
    	    				var menuId_temp = (functionId.split(','))[0];
    	    				if(menuId_cur == menuId_temp) {
    	    					showStr += (functionShow[k].split('|'))[1]+',  ';
    	    				}
    	    			}
    	    			if(showStr.length > 0) {
    	    				showStr = showStr.substring(0, showStr.length-1);
    	    			}
    	    			showStr = showStr + '<br />';
    				}	    			
	    		}
    			showStr = showStr + '<br />';
    		}
    		//if(showStr != '') {showStr = showStr.substring(0, showStr.length-1);}
    		return showStr;
    	}

        $(function() {        	
        	//头像
        	$('#avatarBtn').click(function() {
        		$('#picUploadLayer').fadeIn('slow');
        		//初始化上传
            	uploadInit('user', 'avatar', '0', '1');
            	$('#uploadField').val('avatar');
        	});
        	
        	//选择职位结点
        	$('#positionTree').tree({
        		checkbox: true,
        		cascadeCheck: false,
        		onSelect: function(node){
        			var children = $('#positionTree').tree('getChildren', node.target);
        			if(children.length == 0) {//无子元素加入子结点,已有则展开结点即可
        				var idArr = node.id.split('_');
            			if(idArr[0] == 'department') {//加载部门下的职位
            				$.ajax({
            	                url: '<%=path %>/business/businessUser/getPositionByDep.do',
            	                dataType: 'json',
            	                data: {depId: idArr[1]},
            	                cache: false,
            	                success: function (data) {
            	                	 
            	                	if(data.success == true){
            	                		$('#positionTree').tree('append', {
            	        					parent: node.target,
            	        					data: data.result
            	        				});
            	        				$('#positionTree').tree('expend', node);
            	                	}else{
            	                		//$('#dep_'+depId).html('很抱歉，没有相关记录。');
            	                	}
            	                },
            	                error: function () {
            	                	//$('#dep_'+depId).html('很抱歉，加载内容出错，我们及时修改问题。');
            	                }
            	            });
            				
            			}else if(idArr[0] == 'position') {//加载职位下的职位
            				$.ajax({
            	                url: '<%=path %>/business/businessUser/getPositionByParent.do',
            	                dataType: 'json',
            	                data: {positionId: idArr[1]},
            	                cache: false,
            	                success: function (data) {
            	                	 
            	                	if(data.success == true){
            	                		$('#positionTree').tree('append', {
            	        					parent: node.target,
            	        					data: data.result
            	        				});
            	        				$('#positionTree').tree('expend', node);
            	                	}else{
            	                		$('#position_'+positionId).html('很抱歉，没有相关记录。');
            	                	}
            	                },
            	                error: function () {
            	                	$('#position_'+positionId).html('很抱歉，加载内容出错，我们及时修改问题。');
            	                }
            	            });
            			}
        			}else{
        				$('#positionTree').tree('expend', node);
        			}        			
        		}
        	});
        	        	
	        //显示职务层    
            $("#showPositionLayer").click(function(){
          		$("#positionLayer").fadeIn("slow");
        		$("#positionLayer").css("height",$(document.body).outerHeight(true)+'px');
        		$("#positionBar").css("height",$(document.body).outerHeight(true)-40+'px');
        		//显示部门列表
        		$.ajax({
                    url: '<%=path %>/business/businessUser/getDepartmentsByUser.do',
                    dataType: 'json', 
                    cache: false,
                    success: function (data) {
                    	 
                    	if(data.success == true){
                    		var rows = data.result;
                            if(rows.length > 0) {
                            	$('#positionTree').tree('loadData', data.result);
                            }else{
                            	$('#positionTree').html('&nbsp;&nbsp;&nbsp;&nbsp;很抱歉，没有相关部门。');
                            }
                    	}else{
                    		//$('.accordion2').html('很抱歉，没有相关记录。');
                    	}
                    },
                    error: function () {
                    	//$('.accordion2').html('很抱歉，加载内容出错，我们及时修改问题。');
                    }
                });
            });
	        
	      //选择范围结点
        	$('#scopeTree').tree({
        		checkbox: true
        	});
	        
	      //显示范围层    
            $("#showScopeLayer").click(function(){
          		$("#scopeLayer").fadeIn("slow");
        		$("#scopeLayer").css("height",$(document.body).outerHeight(true)+'px');
        		$("#scopeBar").css("height",$(document.body).outerHeight(true)-40+'px');
        		//显示楼栋列表
        		$.ajax({
                    url: '<%=path %>/business/businessUser/getComsScopeTree.do',
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
                    		$('.accordion2').html('很抱歉，没有相关记录。');
                    	}
                    },
                    error: function () {
                    	//$('.accordion2').html('很抱歉，加载内容出错，我们及时修改问题。');
                    }
                });
            });
	        
	      //选择权限结点
        	$('#rightTree').tree({
        		checkbox: true
        	});
	        
	      //显示权限层    
            $("#showRightLayer").click(function(){
          		$("#rightLayer").fadeIn("slow");
        		$("#rightLayer").css("height",$(document.body).outerHeight(true)+'px');
        		$("#rightBar").css("height",$(document.body).outerHeight(true)-40+'px');
        		//显示权限列表
        		$.ajax({
                    url: '<%=path %>/business/businessUser/getRightsByUser.do',
                    dataType: 'json',
                    cache: false,
                    success: function (data) {
                    	 
                    	$('#rightTree').tree('loadData', data);
                    },
                    error: function () {
                    	//$('.accordion2').html('很抱歉，加载内容出错，我们及时修改问题。');
                    }
                });
            });
	      
            var flag = false;
        	//初始化表单并验证
        	$('#addForm').validate({
                submitHandler:function(form){
                	if(flag == true) {
                		return;
                	}else{
                		flag = true;
                	}
                    $('#qrbut').attr("disabled","disabled");
                    
                    $('#addForm').form('submit', {
                        success:function(data){
                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                            alert(data.message);
                            if(data.success == 'true') {
                            	window.location.href = '<%=ctx%>/business/businessUser/list.do';
                            }                            
                        }
                    });
                },
            	errorClass: "error",
                success: function(label) {
            		label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
            	},
        		rules: {
        			userEmail: {
        				required: true,
        				email: true,
       					remote: {
       	                    type: "post",
       	                    url: "<%=path %>/business/businessUser/checkEmailExist.do",
       	                    data: {
       	                    	userEmail: function() {
       	                            return $("#userEmail").val();
       	                        },
       	                 		userId: function() {
		                            return $("#userId").val();
		                       	}
       	                    }
       	                }
        			},
        			userPassword: {
       					required: true,
       					minlength: 6
       				},
       				userName: {
       					required: true,
       					maxlength: 32
       				},
       				userTel: {
       					required: true,
       					maxlength: 32
       				},
       				/*age: {
       					digits:true
       				}, */
       				positionId: {
       					required: true
       				},
       				scope: {
       					required: true
       				}, 
       				rights: {
       					required: true
       				} ,
       				nickname: {
       					required: true,
       					maxlength: 32,
       					remote: {
       	                    type: "post",
       	                    url: "<%=path %>/business/businessUser/checkExistNickName.do",
       	                    data: {
       	                        nickname: function() {
       	                            return $("#nickname").val();
       	                        },
       	                 		userId: function() {
		                            return $("#userId").val();
		                       	}
       	                    }
       	                }
       				},
       				avatar: {
       					required: true
       				},
       				userBrief: {
       					required: true,
       					maxlength: 1000
       				},
       				state: {
       					required: true
       				}
        		},
        		messages: {
        			userEmail: {
       					required: "请输入邮箱",
       					email: '邮箱格式不正确',
       					remote: "该邮箱已存在"
        			},
       				userPassword: {
       					required: "请输入密码",
       					minlength: "密码最少为6位"
       				},
       				userName: {
       					required: "请输入员工姓名",
       					maxlength: "员工姓名最多为32位"
       				},
       				userTel: {
       					required: "请输入员工电话，可以输入多个",
       					maxlength: "员工电话最多为32位"
       				},
       				/* age: {
       					digits:'年龄只能为整数'
       				}, */
       				positionId: {
       					required: "请选择职位"
       				},
       				scope: {
       					required: "请选择管理范围"
       				}, 
       				rights: {
       					required: "请选择权限"
       				},
       				nickname: {
       					required: "请输入昵称",
       					maxlength: "昵称最多为32位",
       					remote: "该昵称已存在"
       				},
       				avatar: {
       					required: "请选择头像"
       				},
       				userBrief: {
       					required: "请输入员工介绍",
       					maxlength: "员工介绍最多为1000位"
       				},
       				state: {
       					required: "请选择员工状态"
       				}
        		}
        	});
        });
      	
        //数组去重
        function uniqueAry(arr) {
            var ary = [];
            $.each(arr, function(i, el){
                if($.inArray(el, ary) === -1) ary.push(el);
            });
            return ary.join(',');
        }

        //递归查找模块ID
        function getNodeRoot(node) {
            var flag = $('#rightTree').tree('isLeaf', node.target);
            var nodename = node.id;
            if(nodename.indexOf("module") > -1) {
                var id = nodename.split('_')[1];
                return id;
            } else {
                var pnode = $('#rightTree').tree('getParent', node.target);
                return getNodeRoot(pnode);
            }
        }        
</script>   