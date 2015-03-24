<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/25
  Time: 13:28
  To change this template use File | Settings | File Templates.
  新鲜事
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑新鲜事</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx%>/js/jquery.confirm/jquery.confirm.css" />
    <script language="javascript" type="text/javascript" src="${ctx}/js/time/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
   	<script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    <script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
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
        $(function () {
        	$(document).keyup(function(event){
				  if(event.keyCode ==13){
						  submitForm();			
				  }
			});
        	
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
                        /* required: true, */
                        maxlength: 28
                    },
                    /* brief: {
                    	required: true,
                    	maxlength: 28
                    }, */
                    content: {
                        /* required: true */
                    },
                    /* subjectPic: {
                        required: true
                     }, */
                     newsScope: {
                     	required: true
                     },
                     tag: {
                         /* required: true */
                     },
                     appPic: {
                        /* required: true */
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
                        /* required: '请填写新鲜事标题！', */
                        maxlength: '新鲜事标题在28字以内'
                    },
                    /*  brief: {
                    	required: '请输入新鲜事简介',
                    	maxlength: '新鲜事简介在28字以内'
                    },  */
                    content: {
                        /* required: '请填写新鲜事内容！' */
                    },
                   /*  subjectPic: {
                        required: '请选择列表页大图！'
                    },  */
                    newsScope: {
                    	required: '请选择新鲜事范围'
                    },
                    tag: {
                    	/* required:  '请选择新鲜事标签' */
                    },
                    appPic: {
                        /* required: '请选择分享展示图！' */
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
<form id="ff" action="update.do" method="post" enctype="multipart/form-data">
    <div class="wrapper wranews">
        <div class="newsrel">
            <div class="header-public"><span class="return" onclick="history.go(-1);"></span>编辑新鲜事</div>
            <div class="cont-l">
                <input type="hidden" name="newsId" id="newsId" value="${businessNews.newsId }">
                <input type="hidden" name="newsType" id="newsType" value="${businessNews.newsType }">
                <input type="hidden" name="breakId" id="breakId" value="${businessNews.breakId }">
            	<input type="hidden" name="scope" id="scope" value="${scope }" />
                <h2 class="relran">新鲜事标题<label for="title" class="error success"></label></h2>
                <input class="iptnewtit" type="text" name="title" placeholder='请输入新鲜事标题28字以内' value="${businessNews.title }" />
                
                <%-- <h2 class="relran">新鲜事简介<label for="brief" class="error success"></label></h2>
                <input class="iptnewtit" type="text" name="brief" id="brief" placeholder='请输入新鲜事简介28字以内' value="${businessNews.brief }" /> --%>
                
                
                <h2 class="relran">新鲜事内容<label for="content" class="error success"></label></h2>
                <%--文本编辑器--%>
                <!--style给定宽度可以影响编辑器的最终宽度-->
                <textarea id="content" name="content" type="text/plain" style="width:1024px;height:500px;">${businessNews.content }</textarea>
                
                <%-- <h2 class="relran">列表页大图<label for="subjectPic" class="error success"></label></h2>
                <div style=" overflow:hidden;"><img id="subjectPicBtn" src="<%=ctx %><c:choose><c:when test="${businessNews.subjectPic==''}">/images/icon/tp01.jpg</c:when><c:otherwise>${businessNews.subjectPic}</c:otherwise></c:choose>" width="305" height="102" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽600PX、高250PX】jpg格式图片<br>图片大小不能超过100K!</div></div>
                <input type="hidden" name="subjectPic" id="subjectPic" value="${businessNews.subjectPic}" /> --%> <%--头像--%>
                
                 <h2 class="relran" >展示范围<label for="newsScope" class="error success"></label></h2>
	            <div style="position:relative;">
		            <span class="ranbut radiusbox" id="showScopeLayer">点击选择范围</span>
		            <input type="hidden" id="newsScope" name="newsScope" value="${newsScope }" />
		            <input type="hidden" id="newsScopeInfo" name="newsScopeInfo" value="" />
		            <lable style="position: absolute; top: 10px; left: 160px;"  id="scopeShow">
		            <c:forEach items="${scopeList }" var="scope">
		            		${scope.comName }&nbsp;&nbsp;
		            	</c:forEach>
		            </lable>
	            </div>
                <div class="line2"></div>
                
                <h2 class="relran">
					新鲜事标签<label for="tag" class="error success"></label>
				</h2>
				<div style="position: relative;">
					<span class="ranbut radiusbox" id="showTagLayer">点击选择标签</span> 
					<input type="hidden" id="tag" name="tag" value="${businessNews.tag }" /> 
					<input type="hidden" id="tagInfo" name="tagInfo" value="${tagInfo }" />
					<lable style="position: absolute; top: 10px; left: 160px;" id="tagShow">${tagInfo }</lable>
				</div>
				<div class="line2"></div>
					
                <h2 class="relran">分享展示图<span style="font-weight:normal;font-size: 16px;">【用于微信分享时使用！】</span><label for="appPic" class="error success"></label></h2>
                <div style=" overflow:hidden;"><img id="appPicBtn" src="<%=ctx %><c:choose><c:when test="${businessNews.appPic==''}">/images/icon/add.jpg</c:when><c:otherwise>${businessNews.appPic}</c:otherwise></c:choose>" width="100" height="100"  style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽170PX、高125PX】jpg格式图片<br>图片大小不能超过20K!</div></div>
                <input type="hidden" name="appPic" id="appPic" value="${businessNews.appPic}" > <%--头像--%>
                
                <input type="hidden" name="uploadField" id="uploadField" value="" >
                
                <div class="line2"></div>
                <h2 class="relstatus">是否推送<label for="isPush" class="error success"></label></h2>
                <div class="options">
                    <p>
                        <label><input id="isPush1"  class="radiostyle" type="radio" name="isPush" value="1">&nbsp;是</label>　　<em style="color:#e7402f;">选择推送后，将通过系统推送至手机用户，非重要信息请勿选择</em><br><br>
                        <label><input class="radiostyle" type="radio" name="isPush" value="0"  checked>&nbsp;否<br></label>
                    </p>
                </div>
				
				<div class="line2"></div>
                <h2 class="relstatus">推荐到焦点图<label for="isRecommend" class="error success"></label></h2>
                <div class="options">
                    <p>
                        <label><input class="radiostyle" type="radio" name="isRecommend" value="0" <c:if test='${businessNews.isRecommend==0}'>checked="checked"</c:if> >&nbsp;首页焦点图</label>
                        <em style="color:#000;">将推送至焦点图管理列表，在焦点图管理中进行焦点图制作上传，审核通过后发布至焦点图位置</em><br><br>
                        <label><input class="radiostyle" type="radio" name="isRecommend" value="3" <c:if test='${businessNews.isRecommend==3}'>checked="checked"</c:if> >&nbsp;首页全网焦点图</label>
                        <em style="color: #000;">　将推送至全网焦点图管理列表，在全网焦点图管理中进行全网焦点图制作上传，审核通过后发布至全网焦点图位置</em><br><br>
                        <%-- <label><input class="radiostyle" type="radio" name="isRecommend" value="1" <c:if test='${businessNews.isRecommend==1}'>checked="checked"</c:if> >&nbsp;首页新鲜事列表置顶<br><br></label> --%>
                        <label><input class="radiostyle" type="radio" name="isRecommend" value="2" <c:if test='${businessNews.isRecommend==2}'>checked="checked"</c:if> >&nbsp;以上都不选</label><br>
                    </p>
                </div>
                
                <div class="line2"></div>
                <h2 class="relstatus">发布状态<label for="state" class="error success"></label></h2>
                <div class="options">
                    <p>
                    	 <shiro:hasPermission name="news_instant_publish">
                        <label><input class="radiostyle" type="radio" name="state" value="0" <c:if test='${businessNews.state==0}'> checked </c:if> >&nbsp;立即发布<br><br></label>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="news_wait_publish">
                        <label><input class="radiostyle" type="radio" name="state" value="1" <c:if test='${businessNews.state==1}'> checked </c:if> >&nbsp;暂存<span style="color: #e7402f; margin-left:20px; font-weight:normal;font-size: 16px;">暂存的【展示范围】是必选项！</span><br><br></label>
                        </shiro:hasPermission>
                        <label><input class="radiostyle" type="radio" name="state" value="2" <c:if test='${businessNews.state==2}'> checked </c:if> >&nbsp;提交审核<br><br></label>
                    </p>
                </div>

                <div class="submtpres">
                    <input id="qrbut" type="button" name="" value="确认编辑"  onclick="submitForm()"/>
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

<!-- 新鲜事标签选择开始 -->
<div id="tagLayer" class="busswi3">
	<div id="tagBar" class="sidebar3">
		<form action="">
			<a id="close3" href="javascript:;" onclick="cancleTag()"></a>
			<h2 class="tit3">新鲜事标签选择</h2>
			<hr class="link3">
			<div id="wrapper-250">
				<ul id="tagTree" style="font-size: 18px; margin-top: 10px;"></ul>
			</div>
			<div class="w-gg-btn">
				<input class="w-gg-qr w-gg-total" type="button" style="width: 80px;" value="确定" id="tagOk" /> 
				<input class="w-gg-qx w-gg-total" type="button" style="width: 80px;" value="取消" onclick="cancleTag()" />
			</div>
		</form>
	</div>
</div>
<!-- 新鲜事标签选择结束 -->
	
</body>
<%--初始化文本编辑器--%>
    
<script type="text/javascript">
    //实例化编辑器
    var ue = UE.getEditor('content');
    
    $(document).ready(function(){
		var isPush = document.getElementsByName("isPush");
    	$('#isPush1').change(function(){
    		$.confirm({
    			'title'		: '选择推送重要提示',
    			'message'	: '<font color="red"><b>请慎重选择推送！</b></font><br/>选择推送，会将此条新鲜事推送至<font color="red"><b>所有注册用户</b></font>手机桌面。<br/>如本篇新鲜事已进行过推送操作，<font color="red"><b>切勿再次推送！</b></font>否则会造成频繁推送！<br/>如确认推送，请选择【确定】，否则，请点击【取消】',
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
    	//大图
    	$('#subjectPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('news', 'subjectPic', '1', '0');
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
	   	         	data: {flag: 'update',scope: $('#scope').val()},
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
		
     	// 显示选择新鲜事标签层
	    $("#showTagLayer").click(function(){
	   	        $("#tagLayer").fadeIn("slow");
	   	        $.ajax({
	   	            url: '${ctx}/business/businessNews/getTagTree.do',
	   	            dataType: 'json',
	   	            cache: false,
	   	            success: function (data) {
	   	                if(data.success == true){
	   	                    var rows = data.result;
	   	                    if(rows.length > 0) {
	   	                        $('#tagTree').tree('loadData', data.result);
	   	                    }else{
	   	                        $('#tagTree').html('很抱歉，没有相关记录。');
	   	                    }
	   	                }else{
	   	                    $('#tagTree').html('很抱歉，加载内容出错，我们及时修改问题。');
	   	                }
	   	            },
	   	            error: function () {
	   	                $('#tagTree').html('很抱歉，加载内容出错，我们及时修改问题。');
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
	    
     // 选择新鲜事标签
        $('#tagOk').click(function() {
            var tagIds = '';
            var tagInfo = '';
            var tagNodes = $('#tagTree').tree('getChecked');
            if(tagNodes != null && tagNodes.length > 0) {
                for(var i=0;i<tagNodes.length;i++) {
                    var node = tagNodes[i];
                    var idArr = node.id.split('_');
                    var typeid = idArr[0];
                    if(typeid == 'tag') {
                    	tagIds += idArr[1] + ':' + node.text + ',';
                        tagInfo += node.text + ',';
                    }
                }
                
                if(tagIds != '') {
                    if(tagIds.indexOf(',') > -1) {
                        tagIds = tagIds.substring(0, tagIds.length-1);
                        tagInfo = tagInfo.substring(0, tagInfo.length-1);
                    }
                }
                $('#tag').val(tagIds);
                $('#tagInfo').val(tagInfo);
                
                $('#tagShow').html(tagInfo);
                $('#tagShow').focus();
                
                $("#tagLayer").fadeOut("slow");
            }else{
                alert('请选择展示范围');
            }
        });
      	
        // 选择新鲜事标签
        $('#tagTree').tree({
            checkbox: true,
            onSelect: function(node){
                var children = $('#tagTree').tree('getChildren', node.target);
                if(children.length != 0) {
                	$('#tagTree').tree('expend', node);
                }
            }
        });
    });
    
 	// 取消展示扩散范围
 	function cancleFocusScope() {
 	    $("#scopeLayer").fadeOut("slow");
 	}
    
 	 // 取消选择新鲜事标签
 	function cancleTag() {
 	    $("#tagLayer").fadeOut("slow");
 	}
</script>
</html>