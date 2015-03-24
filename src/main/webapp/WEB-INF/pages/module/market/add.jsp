<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/23
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
	    <title>发布跳蚤信息</title>
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
	                    $('#qrbut').attr("disabled","disabled");
	                    $('#ff').form('submit', {
	                        success:function(data){
	                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
	                            alert(data.message);
	                            window.location.href = '<%=ctx%>/business/businessProduct/list.do';
	                        }
	                    });
	                },
	                errorClass: "error",
	                success: function(label) {
	                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
	                },
	                rules: {
	                    publisherId: {
	                        required: true
	                    },
	                    dealType: {
	                        required: true
	                    },
	                    typeId: {
	                        required: true
	                    },/* 
	                    title: {
	                        required: true,
	                        maxlength: 32
	                    }, */
	                    content: {
	                        required: true
	                    }, 
	                    appPic: {
	                        required: true
	                    },
	                    estateId: {
	                        required: true
	                    },
	                    price: {
	                        required: true,
	                        number:true
	                    }
	                },
	                messages: {
	                    publisherId: {
	                        required: '请选择发布人！'
	                    },
	                    dealType: {
	                        required: '请选择交易类型！'
	                    },
	                    typeId: {
	                        required: '请选择出售商品分类！'
	                    },/* 
	                    title: {
	                        required: '请填写跳蚤标题！',
	                        maxlength: '请输入物品名称32个字以内'
	                    }, */
	                    content: {
	                        required: '请填写物品描述！'
	                    },
	                    appPic: {
	                        required:  '请填写物品图片！'
	                    },
	                    estateId: {
	                        required: '请选择一个小区！'
	                    },
	                    price: {
	                        required: '请填写价格！',
	                        number: '价格为数字类型'
	                    }
	                }
	            });
	        	
	          //验证表单2
	            $('#ff2').validate({
	                errorClass: "error",
	                success: function(label) {
	                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
	                },
	                submitHandler:function(form){
	                  
	                },
	                rules: {
	                	userId: {
	                        required: true
	                    },
	                    contactName: {
	                        required: true
	                    },
	                    contactTel: {
	                        required: true
	                    }/* ,
	                    contactQQ: {
	                        required: true
	                    } */
	                },
	                messages: {
	                	userId: {
	                        required: '请绑定发布人'
	                    },
	                    contactName: {
	                        required: '请填写联系人',
	                        maxlength: 32
	                    },
	                    contactTel: {
	                        required: '请填写电话',
	                        maxlength: 32
	                    }/* ,
	                    contactQQ: {
	                        required: '请填写QQ/微信！',
	                        maxlength: 32
	                    } */
	                }
	            });
	        });
	    </script>
	</head>
	<body class="bagcolr">
		<div class="wrapper wranews">
		    <div class="newsrel">
				<div class="header-public"><span class="return" onclick="history.go(-1)"></span>发布跳蚤信息</div>
		        <div class="cont-l">
					<form id="ff" action="save.do" method="post">
			            <h2 class="relran y-fbes-bdr">绑定发布人<label for="publisherId" class="error success"></label></h2>
			            <div style="position:relative;">
			            	<span class="ranbut radiusbox" id="showPositionLayer">点击选择居民</span>
			            	<lable style="position: absolute; top: 10px; left: 160px;" id="publisherName2"></lable>
			            </div>
			            <input type="hidden" class="iptnewtit" name="publisherId" /><%--发布人ID--%>
			            <input type="hidden" class="iptnewtit" name="publisherName" id="publisherName3" /><%--发布人--%>
			            <input type="hidden" class="iptnewtit" name="comId1" /><%--发布社区ID--%>
			            <input type="hidden" class="iptnewtit" name="estateId1" /><%--发布小区ID--%>
			            <input type="hidden" class="iptnewtit" name="estateScope1"/><%--发布小区--%>
			            <input type="hidden" class="iptnewtit" name="contactName"/><%--联系人--%>
			            <input type="hidden" class="iptnewtit" name="contactTel"/><%--电话--%>
			            <!-- <input type="hidden" class="iptnewtit" name="contactQq" /> --><%--QQ/微信 --%>
						
						<div id="comIdAndEstateId"> 
							<div class="line2"></div>
							<h2 class="relstatus">可发布小区<label for="estateId" class="error success"></label></h2>
							<select id="comId" name="comId" style="width: 200px; height: 40px; font-size: 16px; color: #2a2a2a;">
								<c:forEach items="${comList}" var="comBean" varStatus="key">
									<option value="${comBean.comId}">${comBean.comName}</option>
								</c:forEach>
							</select>&nbsp;&nbsp;
							<select id="estateId" name="estateId" style="width: 200px; height: 40px; font-size: 16px; color: #2a2a2a;"></select> 
							<input type="hidden" class="iptnewtit" name="estateScope"/><%--发布小区名称--%>
						</div>
						
			            <div class="line2"></div>
			            <h2 class="relstatus">交易类型<label for="dealType" class="error success"></label></h2>
			            <p>
			                  <label><input class="radiostyle" type="radio" name="dealType" value="0" id="dealType0" checked >&nbsp;出售</label>　　　
			                  <label><input class="radiostyle" type="radio" name="dealType" value="1" id="dealType1">&nbsp;求购</label>　　　
			                  <!-- <label for="dealType2"><input class="radiostyle" type="radio" name="dealType" value="2" id="dealType2" onclick="dealTypeState('2')">&nbsp;交换</label> -->　　　
			            </p>
			            
			            <!-- 出售商品分类 -->
			            <div id="productType"></div>
			            
			            <!-- <div class="line2"></div>
			            <h2 class="relran">物品标题<label for="title" class="error success"></label></h2>
			            <input class="iptnewtit" type="text" name="title" id="title" placeholder='请输入物品名称32个字以内' /> -->
			            
			            <h2 class="newscont">物品描述<label for="content" class="error success"></label></h2>
			            <textarea class="iptnewtit" id="content" name="content" style="width:624px;height:200px; padding-top:8px;"></textarea>
			            
			            <!-- 上传出售商品图片 -->
			            <div id="divAppPic"></div>
			            
			            <div class="line2"></div>
			            <h2 id="price2" class="newscont"><lable id="chaPrice">售价</lable><label id ="price3" for="price" class="error success"></label></h2>
			            <p class="y-fbes-sj">
			                <input id="price" class="iptnewtit" type="text" name="price" placeholder='请输入数字' /><span id="price0">元</span>
			            </p>
						
						<!-- <div class="line2"></div>
			            <h2 id="isEstateAgent1" class="relstatus">委托驿站代售<label for="isEstateAgent" class="error success"></label></h2>
			            <p id="isEstateAgent2">
			                  <input class="radiostyle" type="radio" name="isEstateAgent" value="0" id="RadioGroup1_0" checked>是<br><br>
			                  <input class="radiostyle" type="radio" name="isEstateAgent" value="1" id="RadioGroup1_1">否<br>
			            </p> -->
			            
			            <div class="submtpres">
			                <input id="qrbut" type="button" name="" value="确认提交"  onclick="submitForm()"/>
			            </div>
					</form>
		        </div>
		    </div>
		</div>
		
		<div id="positionLayer" class="busswi y-fbes-jm">
			<div id="positionBar" class="sidebar y-fbes-jms">
		    	<a id="y-fbes-close" class="close" title="关闭" href="javascript:;" onclick="cancelSearch();"></a>
		    	<h2 class="tit">居民选择<label id="moileMsg" class="error success"></label></h2>
		        <div id="wrapper-250">
			          <div class="y-fbes-s">
			                <input id="tel" type="text"  placeholder="请输入委托发布人的手机号进行搜索"  name="" class="y-fbes-st">
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
			          <div style="clear:both;"></div>
			          <div style=" width:91%; margin:0 auto; border-bottom:dashed 1px #999;"></div>
			          <h2 class="tit1">发布联系人信息</h2>
			          <form id="ff2" action="#" method="post">
				          <h2 class="tit1">联系人<label id="contactNameMsg" class="error success"></label></h2>
				          <input  id="contactName1"  type="text" class="y-fbes-st y-fbes-sl" name="" placeholder='请填写联系人名称' >
				          <h2 class="tit1">电话<label id="contactTelMsg" class="error success"></label></h2>
				          <input id="contactTel1" type="text" class="y-fbes-st y-fbes-sl" name="" placeholder='请填写联系人电话' >
				          <!-- <h2 class="tit1">其它<label id="contactQQMsg" class="error success"></label></h2>
				          <input id="contactQQ1" type="text" class="y-fbes-st y-fbes-sl" name=""> -->
			          </form>
		        </div>
		        <div class="w-gg-btn">
		            <input class="w-gg-qr w-gg-total" type="button"  value="确定" onclick="submitF();"/>
					<input class="w-gg-qx w-gg-total" type="button"  value="取消" onclick="cancelSearch();"/>
		        </div>
		    </div>
		</div>
		<label id="uploadPicjs">
			<jsp:include page="/common/uploadMultiPicJs.jsp"/>
		</label>
	</body>
	
	<script type="text/javascript">	
			$(function() {
				$(document).keyup(function(event){
			    	if(event.keyCode ==13){
						submitForm();			
				  	}
				});
				
				// 隐藏可选择的社区及旗下的小区
				$("#comIdAndEstateId").hide();
				
				// 根据所选社区联动更改所属小区
				$("#comId").change(function() {
					$('#estateId').html("");
					$.ajax({
						type: 'post',
				        url: '<%=path %>/manage/manageEstate/findEstateByComId.do',
				        dataType: 'json',
				        data: {comId : $("#comId").val()},
				        cache: false,
				        success: function (data) {
				            var rows = data.rows;
				            if(rows.length > 0) {
				            	for(var i=0;i<rows.length;i++) {
				                	var row = rows[i];  
				                	var htmlDom = '<option value="'+row.estateId+'">'+row.estateName+'</option>';
				                	$('#estateId').append(htmlDom);
				                }
				            	$("input[name='estateScope']").val(rows[0].estateName);  // 默认选中的小区赋上小区名称
				            }else{
				            	$("input[name='estateScope']").val("");  // 默认选中的小区赋上小区名称
				            	$('#estateId').html('很抱歉，没有相关记录。');
				            }
				        },
				        error: function () {
				        	$('.column').html('很抱歉，加载内容出错，我们及时修改问题。');
				        }
				    });
				});
				
				// 根据所选社区联动更改所属小区
				$("#estateId").change(function() {
					var estateId =  $("#estateId option:selected").text();
					$("input[name='estateScope']").val(estateId);  // 更改选中的小区赋上小区名称
				});
				
				if($("input[name='dealType']:checked").val() == 0) {
		    		var htmlDom = ''
		    		+'<h2 id="appPic1" class="relran">上传图片<label for="appPic" class="error success"></label></h2>'
		    		+'<div id="divImg" style=" overflow:hidden;"><img id="appPicBtn" src="${ctx}/images/icon/add.jpg" width="100" height="100"  style="float:left; padding-right:10px;"></div>'
		    		+'<input type="hidden" name="appPic" id="appPic">'
		    		+'<input type="hidden" name="uploadField" id="uploadField">';
		    		$("#divAppPic").append(htmlDom);
		    		
		    		var htmlDom1=''
	    			+'<div class="line2"></div>'
	    			+'<h2 class="relstatus">出售商品分类<label for="typeId" class="error success"></label></h2>'
	    			+'<input type="hidden" class="iptnewtit" id="typeName" name="typeName" />'
	    			+'<select id="typeId" name="typeId" style="width: 200px; height: 40px; font-size: 16px; color: #2a2a2a;">'
	    			+'<option value="">请选择分类</option>'
	    			+'<c:forEach items="${bpTypeList}" var="productType" varStatus="key">'
	    			+'<option value="${productType.typeId}">${productType.typeName}</option>'
	    			+'</c:forEach>'
	    			+'</select>';
	    			$("#productType").append(htmlDom1);
		    		
	    			$("#typeId").change(function(){
	    				var item = $("#typeId").find("option:selected").text();
	    		        $("#typeName").val(item);
	    		    });
	    			
		    		//app小图
					$('#appPicBtn').click(function() {
						$('#picUploadLayer').fadeIn('slow');
						//初始化上传
				    	uploadInit('product', 'appPic', '0', '0');
				    	$('#uploadField').val('appPic');
					});
		    	}
				
				// 活动类型 
			    $("input[name='dealType']").change(function() {
					var $dealType = $("input[name='dealType']:checked").val();
					if ($dealType == 0) {
						var htmlDom = ''
			        		+'<h2 id="appPic1" class="relran">上传图片<label for="appPic" class="error success"></label></h2>'
			        		+'<div id="divImg" style=" overflow:hidden;"><img id="appPicBtn" src="${ctx}/images/icon/add.jpg" width="100" height="100"  style="float:left; padding-right:10px;"></div>'
			        		+'<input type="hidden" name="appPic" id="appPic">'
			        		+'<input type="hidden" name="uploadField" id="uploadField">';
			        		$("#divAppPic").append(htmlDom);
			        		
		        		var htmlDom1=''
			    			+'<div class="line2"></div>'
			    			+'<h2 class="relstatus">出售商品分类<label for="typeId" class="error success"></label></h2>'
			    			+'<input type="hidden" class="iptnewtit" id="typeName" name="typeName" />'
			    			+'<select id="typeId" name="typeId" style="width: 200px; height: 40px; font-size: 16px; color: #2a2a2a;">'
			    			+'<option value="">请选择分类</option>'
			    			+'<c:forEach items="${bpTypeList}" var="productType" varStatus="key">'
			    			+'<option value="${productType.typeId}">${productType.typeName}</option>'
			    			+'</c:forEach>'
			    			+'</select>';
			    			$("#productType").append(htmlDom1);
				    		
			    			$("#typeId").change(function(){
			    				var item = $("#typeId").find("option:selected").text();
			    		        $("#typeName").val(item);
			    		    });
			    			
			        		//app小图
							$('#appPicBtn').click(function() {
								$('#picUploadLayer').fadeIn('slow');
								//初始化上传
						    	uploadInit('product', 'appPic', '0', '0');
						    	$('#uploadField').val('appPic');
							});
			        		
			        		$("#chaPrice").html("售价"); 
			        		$("#price0").html("元"); 
					} else if ($dealType == 1) {
							$("#productType").empty();
							$("#divAppPic").empty();
							$("#chaPrice").html("求购价");
							$("#price0").html("元以下"); 
					}
				});
			});
			
			 //提交表单
		     function submitForm() {
		         $('#ff').submit();
		     }
			
			 function submitF() {
		     	if($('#contactName1').val() == "") {
		     		// alert("请填写联系人名称！");
		     		$("#contactNameMsg").html("<font color='red'>请填写联系人名称！</font>"); 
		     		$("#contactName1").focus(); 
			        return false; 
		     	} else if($('#contactTel1').val() == "") {
		     		// alert("请填写联系人电话！");
		     		$("#contactTelMsg").html("<font color='red'>请填写联系人电话！</font>"); 
		     		$("#contactTel1").focus(); 
			        return false; 
		     	} /* else if($('#contactQQ1').val() == "") {
		     		// alert("请填写联系人QQ/微信！");
		     		$("#contactQQMsg").html("<font color='red'>请填写联系人QQ/微信！</font>"); 
		     		$("#contactQQ1").focus(); 
			        return false; 
		     	} */else {
		     		$('input[name="contactName"]').val($('#contactName1').val());
		     		$('input[name="contactTel"]').val($('#contactTel1').val());
		     		/* $('input[name="contactQq"]').val($('#contactQQ1').val()); */
		     		$('#publisherName2').html($('input[name="publisherName"]').val());
		     		$('#positionLayer').fadeOut('slow');
		     		
		     		// 根据当前居民所在的社区默认选中select option中对应的社区
		     		// 通过居民获取所归属的社区
		     		var comId = $("input[name='comId1']").val();
		     		
		     		//先清空可选小区
	     		   $('#estateId').html("");
		     		// 添加当前社区所有的小区
	     		    $.ajax({
						type: 'post',
				        url: '<%=path %>/manage/manageEstate/findEstateByComId.do',
				        dataType: 'json',
				        data: {comId : comId},
				        cache: false,
				        success: function (data) {
				            var rows = data.rows;
				            if(rows.length > 0) {
				            	for(var i=0;i<rows.length;i++) {
				                	var row = rows[i];  
				                	var htmlDom = '<option value="'+row.estateId+'">'+row.estateName+'</option>';
				                	$('#estateId').append(htmlDom);
				                }
				            	
					     		// 循环比对社区是否相等 选中
				     		    $("#comId option").each(function(){
				     		        if($(this).val() == comId){
				     		        	$(this).attr("selected",true);
				     		        }
				     		    });
					     		// 根据当前居民所在的小区默认选中select option中对应的小区
					     		// 通过居民获取所归属的小区
				     			var estateId = $("input[name='estateId1']").val();
					     		// 循环比对小区是否相等 选中
				     		    $("#estateId option").each(function(){
				     		        if($(this).val() == estateId){
				     		        	$(this).attr("selected",true);
				     		        	$("input[name='estateScope']").val($(this).text());  // 选中的小区赋上小区名称
				     		        }
				     		    });
				            }else{
				            	$('#estateId').html('很抱歉，没有相关记录。');
				            }
				        },
				        error: function () {
				        	$('.column').html('很抱歉，加载内容出错，我们及时修改问题。');
				        }
				    });
		     		
		     		// 隐藏可选择的社区及旗下的小区
					$("#comIdAndEstateId").show();
		     	}
		     }
			
			//显示职务层    
	        $("#showPositionLayer").click(function(){
	      		$("#positionLayer").fadeIn("slow");
	        });
			
	      //搜索用户
	        function findUser() {
	        	if ($("#tel").val() == "") { 
			        $("#moileMsg").html("<font color='red'>手机号码不能为空！</font>"); 
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
		                        
					            $('input[name="publisherId"]').val(data.userId);
					            $('input[name="publisherName"]').val(data.realname);
					            $('input[name="estateId1"]').val(data.estateId);
					            $('input[name="comId1"]').val(data.comId);
					            $('input[name="estateScope1"]').val(data.estateName);
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
	      
	        function cancelSearch() {
			     $('#positionLayer').fadeOut('slow');
	        	 $('#portrait').empty(); 	//头像
                 $('#userId').empty(); 		//用户ID
                 $('#realname').empty(); 			//真实姓名
                 $('#boundphone').empty(); 		//绑定手机
                 $('#nickname').empty(); 	//昵称
                 $('#address').empty(); 		//地址
                 
	            $('input[name="publisherId"]').val("");
	            $('input[name="publisherName"]').val("");
	            $('input[name="comId1"]').val("");
	            $('input[name="estateId1"]').val("");
	            $('input[name="estateScope1"]').val("");
	            $('input[name="contactName"]').val("");
	     		$('input[name="contactTel"]').val("");
	     		/* $('input[name="contactQq"]').val(""); */
	     		
	     		$('#tel').val("");
	     		$('#contactName1').val("");
		     	$('#contactTel1').val("");
		     	/* $('#contactQQ1').val(""); */
	     		$('#publisherName2').empty();
			}
	</script>
</html>