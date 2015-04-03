<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
	    <title>报名人编辑</title>
	    <%@include file="/common/meta.jsp"%>
	    <%@include file="/common/editorJs.jsp"%>
	    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
	    <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
	    <script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
	    <style type="text/css">
	        label.error  { color:Red; font-size:13px; margin-left:5px; padding-left:16px; }
	    </style>
	    <script type="text/javascript">
		    $(function () {
		    	$(document).keyup(function(event){
					  if(event.keyCode ==13){
							  submitForm();			
					  }
				});
		    	
		    	// 上传个人图片到相册
				$('#picUrlImg').click(function() {
					$('#picUploadLayer').fadeIn('slow');
					//初始化上传
			    	uploadInit('actReg', 'picUrl', '0', '0');
			    	$('#uploadField').val('picUrl');
				});
			});
	    	
	        $(function () {
	        	var flag = false;
	            //验证表单
	            $('#ff').validate({
	                submitHandler:function(form){
	                	if(flag == true) {
	                		return;
	                	}else{
	                		flag = true;
	                	}
	                    $('#qrbutSave').attr("disabled","disabled");
	                    $('#qrbutSaveStart').attr("disabled","disabled");
	                    $('#ff').form('submit', {
	                        success:function(data){
	                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
	                            alert(data.message);
	                            window.location.href = '<%=ctx%>/business/businessActivity/viewJPTPInformation.do?actId=' + $("#actId").val();
	                        }
	                    });
	                },
	                errorClass: "error",
	                success: function(label) {
	                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
	                },
	                rules: {
	                    content: {
	                        required: true
	                    },
	                    picUrl: {
	                        required: true
	                    }
	                },
	                messages: {
	                	content: {
	                        required: '请输入个人介绍！'
	                    },
	                    picUrl: {
	                    	required: '请上传个人相册！'
	                    }
	                }
	            });
	        });
	        
	       	//提交表单
		  	function submitForm() {
		         $('#ff').submit();
		    }
	       	
		  	//查看投票详情 
			function startTPZinfo(regId) {
				if($('#content').val() != "" && $('#picUrl').val() != "") {
					$('#picUploadLayerAvatar').fadeIn('slow');
					//初始化上传
		        	uploadInitAvatar('avatar', 'savevote', regId); 
		  		} else {
		  			alert("请输入个人介绍和上传个人相册！");
		  		}
			}
	    </script>
	</head>
	<body class="bagcolr">
		<div class="wrapper wranews">
		    <div class="newsrel">
		    	<div class="header-public"><span class="return" onclick="history.go(-1);"></span>报名人编辑</div>
		        <div class="cont-l">
		        	<h2 class="title">基本信息</h2>
		        	<div  style="border:dashed 1px #999999; width:70%; margin-top:8px; margin-bottom:12px;"></div> 
		            <div class="bj-jbinfo">
		                <p><span class="bj-jbtit">报名编号：</span><span style="font-size:22px; color:#ff3300; padding-right:10px;">${businessActReg.code}号</span></p>
		                <p><span class="bj-jbtit">昵　　称：</span><span>${businessActReg.nickName}</span></p>
		                <p><span class="bj-jbtit">真实姓名：</span><span>${businessActReg.realName}</span></p>
		                <p><span class="bj-jbtit">所属小区：</span><span>${businessActReg.estateName}</span></p>
		                <p><span class="bj-jbtit">联系电话：</span><span>${businessActReg.tel}</span></p>
		                <p><span class="bj-jbtit">提交时间：</span><span><time><fmt:formatDate value="${businessActReg.regTime}" pattern="yyyy-MM-dd HH:mm" /></time></span></p>
		            </div>
		            <form id="ff" action="saveActReg.do" method="post">
			            <input type="hidden" name="actId" id="actId" value="${businessActReg.actId}">
			            <input type="hidden" name="regId" id="regId" value="${businessActReg.regId}">
			            <h2 class="relran">个人介绍<label for="content" class="error success"></label></h2>  
			            <div  style="border:dashed 1px #999999; width:70%; margin-top:8px;"></div>  
			            <textarea id="content"  name="content" class="bj-intro">${businessActReg.content}</textarea>  
			            
			            <h2 class="relran">个人相册<label for="picUrl" class="error success"></label></h2>
			            <div  style="border:dashed 1px #999999; width:70%; margin-top:8px; margin-bottom:18px;"></div>  
						<div id="picUrlDiv">
							<span id="picUrlSpan">
								<div id="picUrlImgDiv" style=" overflow:hidden;">
									<img id="picUrlImg" src="${ctx}/images/icon/add.jpg" width="130" height="130" style="float:left; padding-top:20px; padding-right:40px;">
									<c:forEach var="bean" items="${regPicList}" varStatus="status"> 
										<c:set var="img1" value="${bean.picUrl}" />
										<c:set var="img2" value="${ fn:split(img1, '/') }" />
										<c:set var="img3" value="${img2[3]}" />
										<c:set var="img4" value="${ fn:split(img3, \'.\') }" />
										<label id="img_${img4[0]}"><img class="lilabel" src="<%=ctx%>${bean.picUrl}" width="190" height="250"  style="float:left; padding-top:20px; padding-right:40px;"></label>
									</c:forEach>
								</div>
								<input type="hidden" name="picUrl" id="picUrl" value="${imgJoin}"> 
								<input type="hidden" name="uploadField" id="uploadField">
							</span>
						</div>
			            <div class="bj-btn" style="margin-top:80px;">
			                <input id="qrbutSave" class="bj-btnsave" type="button" value="保存" onclick="submitForm()"/>
			                <c:if test="${businessActReg.flag == 2}">
			                	<input id="qrbutSaveStart" class="bj-btnst" type="button" value="保存并开始投票" onclick="startTPZinfo('${businessActReg.regId}')"/>
			                </c:if>
			            </div>
		            </form>
		        </div>
		    </div> 
		</div>
		<jsp:include page="/common/uploadActRegMultiPicJsUpdate.jsp"/>
		<jsp:include page="/common/uploadAvatarJs.jsp" />
	</body>
</html>