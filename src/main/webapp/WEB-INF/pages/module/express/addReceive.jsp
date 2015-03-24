<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/22
  Time: 18:18
  To change this template use File | Settings | File Templates.
  快递收件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加客户收件</title>
    <%@include file="/common/meta.jsp"%>
    <script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
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
		.txtbtn{ width:300px; height:40px; border:1px solid #444444; border-radius:4px;}
		.txtbtn input{ margin:0; padding:0; border:0; height:40px; border-radius:4px;}
		.tbtxt{ width:170px;}
		.tbbtn{ width:120px; background-color:#e2e2e2; font-size:14px;}
		.delsjr li{ overflow:hidden; padding:16px 0; border-bottom:20px solid #fafafa;}
		.delsjr input{ float:left; vertical-align:middle; height:56px;}
		.delsjr .delinf{ float:left; margin-left:40px;}
		.delsjr p{ font-size:18px; line-height:28px;}
		.delinf a{ text-decoration:underline;}
		.delimg{ display:block; float:left; margin:20px 0 0 20px;}
    </style>
    <script type="text/javascript">
	    $(function () {
	    	$(document).keyup(function(event){
				  if(event.keyCode ==13){
						submitForm();			
				  }
			});
	    	
	    	if($("input[name='isPay']:checked").val() == 0) {
	    		$("#rankId").empty();
	    	} else {
	    		var htmlDom = ''
	    			+'<h2 class="relran">运费金额<label for="payMount" class="error success"></label></h2>'
		    		+'<input style="width:100px;" class="iptnewtit" type="text" id="payMount" name="payMount" /> 元<br>';
	        		$("#rankId").append(htmlDom);
	    	}
	    	
	    	$("input[name='isPay']").change(function() {
	    		var $isPay = $("input[name='isPay']:checked").val();
				if ($isPay == 0) {
					$("#rankId").empty();
				} else {
					var htmlDom = ''
			    		+'<h2 class="relran">运费金额<label for="payMount" class="error success"></label></h2>'
			    		+'<input style="width:100px;" class="iptnewtit" type="text" id="payMount" name="payMount" /> 元<br>';
			    		$("#rankId").append(htmlDom);
				}
	    	});
	    	
	    	// 联系电话选择，手机或座机
	    	if($("input[name='phoneType']:checked").val() == 1) {
	    		var htmlDom = ''
	    		+'<h2 class="relran">手机<label for="receiverMobile" class="error success"></label></h2>'
	    		+'<div style="overflow: hidden;">'
	    		+'<div class="txtbtn" style="float:left;">'
	    		+'<input type="hidden" id="receiverName1"  name="receiverName1"  value=""/>'
	    		+'<input type="hidden" id="receiverAddr1"  name="receiverAddr1"  value=""/>'
	    		+'<input type="hidden" id="flag"  name="flag"  value="1"/>'
	    		+'<input name="receiverMobile" placeholder="请输入手机号码(11位数字)" class="tbtxt valid" id="receiverMobile" style="margin-left: 10px;" type="text"><input class="tbbtn" onclick="getMobile()" type="button" value="检索收货人信息>">'
	    		+'</div><label id="moileMsg" style="line-height: 40px; font-size:13px;"></label>'
	    		+'</div>';
	    		$("#phoneId").html(htmlDom);
	    	}
	    	
	    	$("input[name='phoneType']").change(function() {
        		var $phoneType = $("input[name='phoneType']:checked").val();
    			if ($phoneType == 1) {
    				var htmlDom = ''
    		    		+'<h2 class="relran">手机<label for="receiverMobile" class="error success"></label></h2>'
    		    		+'<div style="overflow: hidden;">'
    		    		+'<div class="txtbtn" style="float:left;">'
    		    		+'<input type="hidden" id="receiverName1"  name="receiverName1"  value=""/>'
    		    		+'<input type="hidden" id="receiverAddr1"  name="receiverAddr1"  value=""/>'
    		    		+'<input type="hidden" id="flag"  name="flag"  value="1"/>'
    		    		+'<input name="receiverMobile" placeholder="请输入手机号码(11位数字)" class="tbtxt valid" id="receiverMobile" style="margin-left: 10px;" type="text"><input class="tbbtn" onclick="getMobile()" type="button" value="检索收货人信息>">'
    		    		+'</div><label id="moileMsg" style="line-height: 40px; font-size:13px;"></label>'
    		    		+'</div>';
    		    	$("#phoneId").html(htmlDom);
    			} else if ($phoneType == 2) {
    	    		var htmlDom = ''
	    	    		+'<h2 class="relran">座机<label for="receiverPhone" class="error success"></label></h2>'
	    	    		+'<input class="iptnewtit" type="text" id="receiverPhone" name="receiverPhone" placeholder="请输入座机号码(8位数字)"  style="width:300px;"/>';
	    	    	$("#phoneId").html(htmlDom);
    			}
        	});
	    	
	    	if($("input[name='isAgent']:checked").val() == 0) {
	    		$("#bmhdId").empty();
	    	} else {
	    		var htmlDom1 = ''
	    			+'<h2 class="relran">代收金额<label for="agentMount" class="error success"></label></h2>'
		    		+'<input style="width:100px;" class="iptnewtit" type="text" name="agentMount" /> 元<br>';
	        		$("#bmhdId").append(htmlDom1);
	    	}
	    	
	    	$("input[name='isAgent']").change(function() {
	    		var $isAgent = $("input[name='isAgent']:checked").val();
				if ($isAgent == 0) {
					$("#bmhdId").empty();
				} else {
					var htmlDom1 = ''
						+'<h2 class="relran">代收金额<label for="agentMount" class="error success"></label></h2>'
			    		+'<input style="width:100px;" class="iptnewtit" type="text" name="agentMount" /> 元<br>';
			    		$("#bmhdId").append(htmlDom1);
				}
	    	});
	    });
	    
	  	//提交表单
        function submitForm() {
        	var $phoneType = $("input[name='phoneType']:checked").val();
			if ($phoneType == 1) {
				$("#receiverTel").val($("#receiverMobile").val());
			} else if ($phoneType == 2) {
				$("#receiverTel").val($("#receiverPhone").val());
			}
            $('#ff').submit();
        }
	  
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
                            window.location.href = '<%=ctx%>/business/businessExp/list.do';
                        }
                    });
                },
                errorClass: "error",
                success: function(label) {
                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
                },
                rules: {
                	expCompanyID: {
                        required: true
                    },
                    expCode: {
                        required: true,
                        maxlength : 64
                    },
                    receiverName: {
                        required: true,
                        maxlength : 32
                    },
                    receiverMobile: {
                        required: true,
                        minlength : 11,
                        maxlength : 11,
                        digits:true
                    },
                    receiverPhone: {
                        required: true,
                        minlength : 8,
                        maxlength : 8,
                        digits:true
                    },
                    receiverAddr: {
                        required: true,
                    },
                    isPay: {
                        required: true
                    },
                    payMount: {
                    	required: true,
                        number:true,
                        min:1
                    },
                    isAgent: {
                        required: true
                    },
                    agentMount: {
                    	required: true,
                        number:true,
                        min:1
                    }
                },
                messages: {
                	expCompanyID: {
                        required: '请选择快递公司！'
                    },
                    expCode: {
                        required: '请输入快递单号！',
                        maxlength : '快递单号最长64位！'
                    },
                    receiverName: {
                        required: '请填写收货人！',
                        maxlength : '收货人姓名最长30位！'
                    },
                    receiverMobile: {
                    	required: '请填写手机号码！',
                        minlength : '手机号码为11位数字',
                        maxlength : '手机号码为11位数字', 
                        digits: '手机号码只能为数字'
                    },
                    receiverPhone: {
                    	required: '请填写座机号码！',
                        minlength : '座机号码为8位数字',
                        maxlength : '座机号码为8位数字', 
                        digits: '座机号码只能为数字'
                    },
                    receiverAddr: {
                        required: '请填写收货地址！'
                    },
                    isPay: {
                        required: '请选择运费是否到付！'
                    },
                    payMount: {
                        required: '请填写到付金额！',
                        number: '到付金额只能为数字',
                        min: '到付金额必须大于0'
                    },
                    isAgent: {
                        required: '请选择是否代收货款！'
                    },
                    agentMount: {
                        required: '请填写代收金额！',
                        number: '代收金额只能为数字',
                        min: '代收金额必须大于0'
                    }
                }
            });
        });

        function checkedRadio(obj, name, display) {
            $('input[name="'+name+'"]').val(obj.value);
            $('#expCompanyShow').text(display);
        }
        
        function getMobile() {
	       	 if($('#receiverMobile').val() == "") {
	       		 $("#moileMsg").html("<font color='red'>&nbsp;&nbsp;请填写联系电话！</font>"); 
	       		 $("#receiverMobile").focus(); 
	       	} /* else if (!$("#receiverMobile").val().match(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/)) { 
			        $("#moileMsg").html("<font color='red'>&nbsp;&nbsp;联系电话码格式不正确！请重新输入！</font>"); 
			        $("#receiverMobile").focus(); 
			        return false; 
	        }  */else {
	          	$('#moileMsg').html("");
	      		checkMobile($('#receiverMobile').val());
	       	}
       }
       
       function checkMobile(mobile) {
       	$.ajax({
   			type: 'post',
   	        url: '<%=path %>/business/businessAddress/list.do',
   	        dataType: 'json',
   	        data: {mobile: mobile},
   	        cache: false,
   	        success: function (data) {
   	            var rows = data.rows;
   	            if(rows.length > 0) {
   	            	for(var i=0;i<rows.length;i++) {
   	                	var row = rows[i];  
   	                	var htmlDom = ''
   	                	+'<li>'
   	                	+'<input type="radio" name="addrId" id="addrId'+row.addrId+'" value="'+row.addrId+'" onchange="getAddressById('+row.addrId+')"/>'
   	                	+'<div class="delinf">'
   	                	+'<p><a>'+row.contacts+'</a></p>'
   	                	+'<p><a>'+row.address+'</a></p>'
   	                	+'</div>'
   	                	+'<a class="delimg" title="删除该收件人" style="cursor:pointer;" onclick="deleteAddress('+row.addrId+', '+mobile+')"><img src="${ctx}/images/icon/add4_delet.jpg"/></a>'
   	                	+'</li>';
   	                	$('.delsjr').append(htmlDom);
   	                	$('#positionLayer').fadeIn('slow');
   	                }
   	            }else{
   	            	$('#moileMsg').css("display", "block");
   	            	$('#moileMsg').html("<font color='red'>&nbsp;&nbsp;尚无匹配信息，本次填写后，将自动保存相关信息！</font>");
   	            	$('#flag').val(1);	
   	            	$('#positionLayer').fadeOut('slow');
   	            }
   	        },
   	        error: function () {
   	        	$('.delsjr').html('很抱歉，加载内容出错，我们及时修改问题。');
   	        }
   	    });
       }
       
       function getAddressById(addrId) {
       	$.post("<%=path %>/business/businessAddress/getAddressDetail.do", {addrId : addrId}, function(data) {
           	eval("data = "+data);
               $('#receiverName1').val(data.contacts);		// 收件人
               $('#receiverAddr1').val(data.address);			//收件地址
            });
       }
       
    	// 确认选择收件人
       function submitAddrass() {
    		$('input[name="receiverName"]').val($('#receiverName1').val());
    		$('input[name="receiverAddr"]').val($('#receiverAddr1').val());
    		$('#flag').val(0);		// 标识是否需要新增收件人
    		$('.delsjr').html("");
    		$('#positionLayer').fadeOut('slow');
	    }
       
       // 取消选择收件人
       function cancelSearch() {
   		// $('#receiverMobile').val("");
   		$('#receiverName').val("");
	     	$('#receiverAddr').val("");
	     	$('#flag').val("1");		// 标识是否需要新增收件人
	     	$('.delsjr').html("");
		    $('#positionLayer').fadeOut('slow');
		}
       
	     //删除该收件人
	   	function deleteAddress(addrId, mobile) {
	   		var bool = window.confirm("您确定要删除该收件人？");
	   	    if(bool) {
	   	        $.post("<%=path %>/business/businessAddress/delete.do", {id : addrId}, function(data) {
	   	        	eval("data = "+data);
	       			alert(data.message);
	   	            // window.location.reload();
	   	            $('.delsjr').html("");
	       			$('#positionLayer').fadeIn('slow');
	       			checkMobile(mobile);
	   	        });
	   	    }
	   	}
    </script>
</head>
<body class="bagcolr">
<form id="ff" action="${ctx}/business/businessExp/saveReceive.do" method="post">
    <div class="wrapper wranews">

        <div class="newsrel">

                <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" style="cursor: pointer;"></span>添加客户收件</div>

                <div class="cont-l">
                    <%-- <h2 class="relran" style="font-weight: bold;">快递公司<label style="font-weight:normal;"  for="expCompanyID" class="error"></label></h2>
		            <div style="position:relative;">
		            	 <input type="hidden" id="expCompanyID" name="expCompanyID">
			            <c:forEach items="${expressList}" var="exp">
	                        <label><li id="one2" class="files" style="margin-top:15px;"><input class="radiostyle2" type="radio" name="expCompany" onclick="checkedRadio(this,'expCompanyID','${exp.expressComppay}')" value="${exp.expressId}">&nbsp;${exp.expressComppay}</li></label>
	                    </c:forEach>
		            </div> --%>
		            
		            <h2 class="relstatus">快递公司<label for="expCompanyID" class="error success"></label></h2>
					<select id="expCompanyID" name="expCompanyID" style="width: 200px; height: 40px; font-size: 16px; color: #2a2a2a;">
						<option value="">请选择快递公司</option>
						<c:forEach items="${expressList}" var="expBean" varStatus="key">
							<option value="${expBean.expressId}">${expBean.expressComppay}快递</option>
						</c:forEach>
					</select>
		            
                    <h2 class="relran">快递单号<label for="expCode" class="error success"></label></h2>
                    <input class="iptnewtit" type="text" id="expCode" name="expCode" placeholder='' />&nbsp;&nbsp;<font color="red">*</font>
					
					<h2 class="relstatus">电话类型<label for="phoneType" class="error success"></label></h2>
		            <label><input class="radiostyle2" type="radio"name="phoneType" value="1" checked >&nbsp;手机</label>　
		            <label><input class="radiostyle2" type="radio" name="phoneType" value="2"  >&nbsp;座机</label>　
		            <input type="hidden" id="receiverTel" name="receiverTel" value="" >
	            	
	            	 <!-- 联系电话 -->
	                <div id="phoneId"></div>
                
                   <!--  <h2 class="relran">联系电话<label for="receiverMobile" class="error success"></label></h2>
                    <input style="width:300px;" class="iptnewtit" type="text" id="receiverMobile" name="receiverMobile" placeholder='' />&nbsp;&nbsp;<font color="red">*</font>
					<div style="overflow: hidden;">
						<div class="txtbtn" style="float:left;">
			                <input type="hidden" id="receiverName1"  name="receiverName1"  value=""/>
							<input type="hidden" id="receiverAddr1"  name="receiverAddr1"  value=""/>
							<input type="hidden" id="flag"  name="flag"  value="1"/>
							<input name="receiverMobile" class="tbtxt valid" id="receiverMobile" style="margin-left: 10px;" type="text"><input class="tbbtn" onclick="getMobile()" type="button" value="检索收货人信息>">
						</div><label id="moileMsg" style="line-height: 40px; font-size:13px;"></label>
					</div> -->
					
                    <h2 class="relran">收货人<label for="receiverName" class="error success"></label></h2>
                    <input class="iptnewtit" type="text" id="receiverName" name="receiverName" placeholder='' />&nbsp;&nbsp;<font color="red">*</font>
					
                    <h2 class="relran">收货地址<label for="receiverAddr" class="error success"></label></h2>
                    <input class="iptnewtit" type="text" id="receiverAddr" name="receiverAddr" placeholder='' />

                    <h2 class="relstatus">运费到付<label for="isPay" class="error success"></label></h2>
                    <div class="options">
                        <label><input class="radiostyle" type="radio" id="isPay_0" name="isPay" value="0"  checked>&nbsp;否</label><br><br>
                        <label><input class="radiostyle" type="radio" id="isPay_1" name="isPay" value="1">&nbsp;是</label><br>
                    </div><br>
                    
                    <!-- 运费金额 -->
                	<div id="rankId"></div>

                    <h2 class="relstatus">代收货款<label for="isAgent" class="error success"></label></h2>
                    <div class="options">
	                    <label><input class="radiostyle" type="radio" name="isAgent" value="0" checked>&nbsp;否</label><br><br>
	                    <label><input class="radiostyle" type="radio" name="isAgent" value="1">&nbsp;是</label><br>
                    </div><br>
                    
                    <!-- 代收金额 -->
            		<div id="bmhdId"></div>
                    
                    <div class="submtpres">
                        <input id="qrbut" type="button" value="确认提交" onclick="submitForm()"/>
                    </div>
                </div>
        </div>
    </div>

	<!-- 快递列表 -->
    <div class="busswi3">
        <div class="sidebar3">
            <a id="close3" href="javascript:;"></a>
            <h2 class="tit3">快递列表</h2>
            <!--<hr class="link3">-->
            <div id="wrapper-250">
                <ul class="accordion3"></ul>
            </div>
        </div>
    </div>
    <%--快递类型 2为已入库--%>
    <input type="hidden" name="expState" value="2"/>
</form>
	<div id="positionLayer" class="busswi y-fbes-jm">
		<div id="positionBar" class="sidebar y-fbes-jms">
	    	<a id="y-fbes-close" class="close" title="关闭" href="javascript:;"  onclick="cancelSearch();"></a>
	    	<h2 class="tit">收货人信息选择</h2>
	        <div id="wrapper-250">
		    	<ul class="delsjr" style="margin:0 40px;"></ul>
	        </div>
	        <div class="w-gg-btn">
	            <input class="w-gg-qr w-gg-total" type="button"  value="确定" onclick="submitAddrass();"/>
				<input class="w-gg-qx w-gg-total" type="button"  value="取消" onclick="cancelSearch();"/>
	        </div>
	    </div>
	</div>
</body>
</html>