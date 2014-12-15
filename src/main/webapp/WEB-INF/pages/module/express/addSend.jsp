<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加客户发件</title>
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
		    		+'<input style="width:100px;" class="iptnewtit" type="text" id="payMount" name="payMount" placeholder="" value="" /> 元<br>';
            		$("#rankId").append(htmlDom);
        	}
        	
        	$("input[name='isPay']").change(function() {
        		var $isPay = $("input[name='isPay']:checked").val();
    			if ($isPay == 0) {
    				$("#rankId").empty();
    			} else {
    				var htmlDom = ''
    		    		+'<h2 class="relran">运费金额<label for="payMount" class="error success"></label></h2>'
    		    		+'<input style="width:100px;" class="iptnewtit" type="text" id="payMount" name="payMount" placeholder="" value="" /> 元<br>';
    		    		$("#rankId").append(htmlDom);
    			}
        	});
        	
        	// 联系电话选择，手机或座机
	    	if($("input[name='phoneType']:checked").val() == 1) {
	    		var htmlDom = ''
	    		+'<h2 class="relran">手机<label for="senderMobile" class="error success"></label></h2>'
	    		+'<div style="overflow: hidden;">'
	    		+'<div class="txtbtn" style="float:left;">'
	    		+'<input type="hidden" id="senderName1"  name="senderName1"  value=""/>'
	    		+'<input type="hidden" id="senderAddr1"  name="senderAddr1"  value=""/>'
	    		+'<input type="hidden" id="flag"  name="flag"  value="1"/>'
	    		+'<input name="senderMobile" placeholder="请输入手机号码(11位数字)" class="tbtxt valid" id="senderMobile" style="margin-left: 10px;" type="text"><input class="tbbtn" onclick="getMobile()" type="button" value="检索收货人信息>">'
	    		+'</div><label id="moileMsg" style="line-height: 40px; font-size:13px;"></label>'
	    		+'</div>';
	    		$("#phoneId").html(htmlDom);
	    	}
	    	
			$("#expCompanyID").change(function() {
				var expCompanyID =  $("#expCompanyID option:selected").text();
				$("input[name='estateScope']").val(expCompanyID); 
			});
	    	
	    	$("input[name='phoneType']").change(function() {
        		var $phoneType = $("input[name='phoneType']:checked").val();
    			if ($phoneType == 1) {
    				var htmlDom = ''
    		    		+'<h2 class="relran">手机<label for="senderMobile" class="error success"></label></h2>'
    		    		+'<div style="overflow: hidden;">'
    		    		+'<div class="txtbtn" style="float:left;">'
    		    		+'<input type="hidden" id="senderName1"  name="senderName1"  value=""/>'
    		    		+'<input type="hidden" id="senderAddr1"  name="senderAddr1"  value=""/>'
    		    		+'<input type="hidden" id="flag"  name="flag"  value="1"/>'
    		    		+'<input name="senderMobile" placeholder="请输入手机号码(11位数字)" class="tbtxt valid" id="senderMobile" style="margin-left: 10px;" type="text"><input class="tbbtn" onclick="getMobile()" type="button" value="检索收货人信息>">'
    		    		+'</div><label id="moileMsg" style="line-height: 40px; font-size:13px;"></label>'
    		    		+'</div>';
    		    	$("#phoneId").html(htmlDom);
    			} else if ($phoneType == 2) {
    	    		var htmlDom = ''
	    	    		+'<h2 class="relran">座机<label for="senderPhone" class="error success"></label></h2>'
	    	    		+'<input class="iptnewtit" type="text" id="senderPhone" name="senderPhone" placeholder="请输入座机号码(8位数字)"  style="width:300px;"/>';
	    	    	$("#phoneId").html(htmlDom);
    			}
        	});
        });
    
	  	//提交表单
        function submitForm() {
        	var $phoneType = $("input[name='phoneType']:checked").val();
			if ($phoneType == 1) {
				$("#senderTel").val($("#senderMobile").val());
			} else if ($phoneType == 2) {
				$("#senderTel").val($("#senderPhone").val());
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
                    senderName: {
                        required: true,
                        maxlength : 32
                    },
                    senderMobile: {
                        required: true,
                        minlength : 11,
                        maxlength : 11,
                        digits:true
                    },
                    senderPhone: {
                        required: true,
                        minlength : 8,
                        maxlength : 8,
                        digits:true
                    },
                    senderAddr: {
                        required: true,
                        maxlength : 500
                    },
                    isPay: {
                        required: true
                    },
                    payMount: {
                        required: true,
                        number:true,
                        min:1
                    }, 
                    receiverName: {
                        required: true,
                        maxlength: 30
                    },
                    receiverTel: {
                        required: true,
                        digits:true
                    },
                    receiverAddr: {
                        required: true,
                        maxlength: 500
                    }
                },
                messages: {
                	expCompanyID: {
                        required: '请选择快递公司！'
                    },
                    expCode: {
                        required: '请选择快递单号！',
                        maxlength: '快递单号64个字以内'
                    },
                    senderName: {
                        required: '请填写发件人！',
                        maxlength: '发件人姓名30个字以内'
                    },
                    senderMobile: {
                    	required: '请填写手机号码！',
                        minlength : '手机号码为11位数字',
                        maxlength : '手机号码为11位数字', 
                        digits: '手机号码只能为数字'
                    },
                    senderPhone: {
                    	required: '请填写座机号码！',
                        minlength : '座机号码为8位数字',
                        maxlength : '座机号码为8位数字', 
                        digits: '座机号码只能为数字'
                    },
                    senderAddr: {
                        required: '请填写发件地址！',
                        maxlength: '发件人地址200个字以内'
                    },
                    isPay: {
                        required: '请选择运费是否到付！'
                    },
                    payMount: {
                        required: '请填写运费金额！',
                        number: '运费金额只能为数字',
                        min: '运费金额必须大于0'
                    }, 
                    receiverName: {
                        required: '请填写收件人！',
                        maxlength: '收件人姓名30个字以内'
                    },
                    receiverTel: {
                        required: '请填写收件电话！'
                        
                    },
                    receiverAddr: {
                        required: '请填写收件地址！',
                        maxlength: '收件人地址200个字以内'
                    }
                }
            });
        });
		
        function checkedRadio(obj, name, display) {
            $('input[name="'+name+'"]').val(obj.value);
            $('#expCompanyShow').text(display);
        }
        
        function getMobile() {
        	 if($('#senderMobile').val() == "") {
        		 $("#moileMsg").html("<font color='red'>&nbsp;&nbsp;请填写联系手机！</font>"); 
        		 $("#senderMobile").focus(); 
        	} /* else if (!$("#senderMobile").val().match(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/)) { 
		        $("#moileMsg").html("<font color='red'>&nbsp;&nbsp;联系电话码格式不正确！请重新输入！</font>"); 
		        $("#senderMobile").focus(); 
		        return false; 
	        }  */else {
            	$('#moileMsg').html("");
        		checkMobile($('#senderMobile').val());
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
                $('#senderName1').val(data.contacts);		// 收件人
                $('#senderAddr1').val(data.address);			//收件地址
             });
        }
        
     	// 确认选择收件人
        function submitAddrass() {
     		$('input[name="senderName"]').val($('#senderName1').val());
     		$('input[name="senderAddr"]').val($('#senderAddr1').val());
     		$('#flag').val(0);		// 标识是否需要新增收件人
     		$('.delsjr').html("");
     		$('#positionLayer').fadeOut('slow');
	    }
        
        // 取消选择收件人
        function cancelSearch() {
    		// $('#senderMobile').val("");
    		$('#senderName').val("");
	     	$('#senderAddr').val("");
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
<form id="ff" action="${ctx}/business/businessExp/saveSend.do" method="post">
    <div class="wrapper wranews">
        <div class="newsrel">
            <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" style="cursor: pointer;"></span>添加客户发件</div>
            <div class="cont-l">
                
                <%-- <h2 class="relran">快递公司<label for="expCompanyID" class="error success"></label></h2>
                <input type="hidden" name="expCompanyID" id="expCompanyID" value="">
                <ul class="accordion3">
                <c:forEach items="${expressList}" var="exp">
                <label><li id="one2" class="files" style="margin-top:15px;"><input class="radiostyle2" type="radio" name="expCompany" onclick="checkedRadio(this,'expCompanyID','${exp.expressComppay}')" value="${exp.expressId}">&nbsp;${exp.expressComppay}</li></label>
                </c:forEach>
                </ul> --%>
                
                <h2 class="relstatus">快递公司<label for="expCompanyID" class="error success"></label></h2>
				<select id="expCompanyID" name="expCompanyID" style="width: 200px; height: 40px; font-size: 16px; color: #2a2a2a;">
					<option value="">请选择快递公司</option>
					<c:forEach items="${expressList}" var="expBean" varStatus="key">
						<option value="${expBean.expressId}">${expBean.expressComppay}快递</option>
					</c:forEach>
				</select>
                
                <h2 class="relran">快递单号<label for="expCode" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="expCode" name="expCode" placeholder='' />
				
				<h2 class="relstatus">电话类型<label for="phoneType" class="error success"></label></h2>
	            <label><input class="radiostyle2" type="radio"name="phoneType" value="1" checked >&nbsp;手机</label>　
	            <label><input class="radiostyle2" type="radio" name="phoneType" value="2"  >&nbsp;座机</label>　
	            <input type="hidden" id="senderTel" name="senderTel" value="" >
            	
            	 <!-- 联系电话 -->
                <div id="phoneId"></div>
                
                <h2 class="relran">发件人<label for="senderName" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="senderName" name="senderName" placeholder='' />
				
				
                <h2 class="relran">发件地址<label for="senderAddr" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="senderAddr" name="senderAddr" placeholder='' />
				
                <h2 class="relstatus">运费到付<label for="isPay" class="error success"></label></h2>
                <div class="options">
                    <p>
                        <label><input class="radiostyle" type="radio" id="isPay_0" name="isPay" value="0"  checked>&nbsp;否</label><br><br>
                        <label><input class="radiostyle" type="radio" id="isPay_1" name="isPay" value="1">&nbsp;是</label><br>
                    </p>
                </div>
                <br>
                
                <!-- 运费金额 -->
                <div id="rankId"></div>
                
                <h2 class="relran">收件人<label for="receiverName" class="error success"></label></h2>
                <input  class="iptnewtit" type="text" id="receiverName" name="receiverName" placeholder='' />
                <br>
                <h2 class="relran">收件电话<label for="receiverTel" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="receiverTel" name="receiverTel" placeholder='' />
                <br>
                <h2 class="relran">收件地址<label for="receiverAddr" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="receiverAddr" name="receiverAddr" placeholder='' />
                <br>
                <div class="submtpres">
                    <input id="qrbut" type="button" value="确认提交" onclick="submitForm();"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 权限选择开始 -->
    <div class="busswi3">
        <div class="sidebar3">
            <a id="close3" href="javascript:;"></a>
            <h2 class="tit3">类型列表</h2>
            <!--<hr class="link3">-->
            <div id="wrapper-250">
            </div>

        </div>
    </div>
    <%--快递类型 1为已发送--%>
    <input type="hidden" name="expState" value="1"/>
</form>

	<div id="positionLayer" class="busswi y-fbes-jm">
		<div id="positionBar" class="sidebar y-fbes-jms">
	    	<a id="y-fbes-close" class="close" title="关闭" href="javascript:;"  onclick="cancelSearch();"></a>
	    	<h2 class="tit">发件人信息选择</h2>
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