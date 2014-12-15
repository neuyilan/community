<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/22
  Time: 20:51
  To change this template use File | Settings | File Templates.
  快递发件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
		    		+'<input style="width:100px;" class="iptnewtit" type="text" id="payMount" name="payMount" placeholder="" value="${businessExp.payMount }" /> 元<br>';
	        		$("#rankId").append(htmlDom);
	    	}
	    	
	    	$("input[name='isPay']").change(function() {
	    		var $isPay = $("input[name='isPay']:checked").val();
				if ($isPay == 0) {
					$("#rankId").empty();
				} else {
					var htmlDom = ''
			    		+'<h2 class="relran">运费金额<label for="payMount" class="error success"></label></h2>'
			    		+'<input style="width:100px;" class="iptnewtit" type="text" id="payMount" name="payMount" placeholder="" value="${businessExp.payMount }" /> 元<br>';
			    		$("#rankId").append(htmlDom);
				}
	    	});
	    	
	    	// 联系电话选择，手机或座机
	    	if($("input[name='phoneType']:checked").val() == 1) {
	    		var htmlDom = ''
	    		+'<h2 class="relran">手机<label for="senderMobile" class="error success"></label></h2>'
	    		+'<input style="width:300px;" class="iptnewtit" type="text" id="senderMobile" name="senderMobile" placeholder="请输入手机号码(11位数字)" value="${businessExp.senderTel }"/>&nbsp;&nbsp;<font color="red">*</font>';
	    		$("#phoneId").html(htmlDom);
	    	} else if($("input[name='phoneType']:checked").val() == 2) {
	    		var htmlDom = ''
    	    		+'<h2 class="relran">座机<label for="senderPhone" class="error success"></label></h2>'
    	    		+'<input class="iptnewtit" type="text" id="senderPhone" name="senderPhone" placeholder="请输入座机号码(8位数字)" value="${businessExp.senderTel }" style="width:300px;"/>';
    	    	$("#phoneId").html(htmlDom);
			}
	    	
	    	$("input[name='phoneType']").change(function() {
        		var $phoneType = $("input[name='phoneType']:checked").val();
    			if ($phoneType == 1) {
    				var htmlDom = ''
    		    		+'<h2 class="relran">手机<label for="senderMobile" class="error success"></label></h2>'
    		    		+'<input style="width:300px;" class="iptnewtit" type="text" id="senderMobile" name="senderMobile" placeholder="请输入手机号码(11位数字)" />&nbsp;&nbsp;<font color="red">*</font>';
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
                            window.location.href = '<%=ctx%>/business/businessExp/saveSendResolve.do?expId=${businessExp.expId}';
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
                        maxlength : 32
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
        
        $(function () {
        	if($("input[name='isPay']:checked").val() == 0) {
        		$("#sh_payMount").hide();
        		$("#payMount").val("");
        		
        	} else {
        		$("#sh_payMount").show();
        	}
        	
        	$("input[name='isPay']").change(function() {
        		var $isPay = $("input[name='isPay']:checked").val();
    			if ($isPay == 0) {
    				$("#sh_payMount").hide();
    				$("#payMount").val("");
    			} else {
    				$("#sh_payMount").show();
    			}
        	});
        });
    </script>
</head>
<body class="bagcolr">
<form id="ff" action="${ctx}/business/businessExp/updateSend.do" method="post">
    <div class="wrapper wranews">

        <div class="newsrel">
            <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" style="cursor: pointer;"></span>编辑客户发件</div>

            <div class="cont-l">
				<input type="hidden" name="expId" id="expId" value="${businessExp.expId }" />
                <%-- <h2 class="relran">快递公司<label for="expCompanyID" class="error success"></label></h2>
                <input type="hidden" name="expCompanyID" id="expCompanyID" <c:if test="${businessExp.expCompanyID != 0 }"> value="${businessExp.expCompanyID }" </c:if>>
                
                <ul class="accordion3">
	                 <c:forEach items="${expressList}" var="exp">
	                     <label><li id="one2" class="files" style="margin-top:15px;"><input class="radiostyle2" type="radio" <c:if test="${businessExp.expCompanyID == exp.expressId }"> checked </c:if> name="expCompany" onclick="checkedRadio(this,'expCompanyID','${exp.expressComppay}')" value="${exp.expressId}">&nbsp;${exp.expressComppay}</li></label>
	                 </c:forEach>
                </ul> --%>
                
                <h2 class="relstatus">快递公司<label for="expCompanyID" class="error success"></label></h2>
				<select id="expCompanyID" name="expCompanyID" style="width: 200px; height: 40px; font-size: 16px; color: #2a2a2a;">
					<option value="">请选择快递公司</option>
					<c:forEach items="${expressList}" var="expBean" varStatus="key">
						<option value="${expBean.expressId}" <c:if test="${businessExp.expCompanyID == expBean.expressId }"> selected </c:if>>${expBean.expressComppay}快递</option>
					</c:forEach>
				</select>
                
                <h2 class="relran">快递单号<label for="expCode" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="expCode" name="expCode" placeholder='' value="${businessExp.expCode }"/>&nbsp;&nbsp;<font color="red">*</font>

                <h2 class="relran">发件人<label for="senderName" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="senderName" name="senderName" placeholder='' value="${businessExp.senderName }"/>&nbsp;&nbsp;<font color="red">*</font>
				
				<h2 class="relstatus">电话类型<label for="phoneType" class="error success"></label></h2>
	            <label><input class="radiostyle2" type="radio"name="phoneType" value="1" <c:if test='${businessExp.phoneType == 1}'> checked </c:if> >&nbsp;手机</label>　
	            <label><input class="radiostyle2" type="radio" name="phoneType" value="2"  <c:if test='${businessExp.phoneType == 2}'> checked </c:if>>&nbsp;座机</label>　
	            <input type="hidden" id="senderTel" name="senderTel" value="" >
	            
	             <!-- 联系电话 -->
                <div id="phoneId"></div>
                
                <%-- <h2 class="relran">手机号<label for="senderTel" class="error success"></label></h2>
                <input style="width:300px;" class="iptnewtit" type="text" id="senderTel" name="senderTel" placeholder='' value="${businessExp.senderTel }"/>&nbsp;&nbsp;<font color="red">*</font> --%>

                <h2 class="relran">发件地址<label for="senderAddr" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="senderAddr" name="senderAddr" placeholder='' value="${businessExp.senderAddr }"/>

                <h2 class="relstatus">运费到付<label for="isPay" class="error success"></label></h2>
                <div class="options">
                    <p>
                        <label>
                            <input class="radiostyle" type="radio" id="isPay_0" name="isPay" value="0" <c:if test="${businessExp.isPay == 0 }"> checked </c:if> >
                            否</label>
                        <br><br>
                        <label>
                            <input class="radiostyle" type="radio" id="isPay_1" name="isPay" value="1" <c:if test="${businessExp.isPay == 1 }"> checked </c:if> >
                            是</label>
                        <br>
                    </p>
                </div>
                <br>
                <!-- 运费金额 -->
                <div id = "rankId"></div>
                
                <h2 class="relran">收件人<label for="receiverName" class="error success"></label></h2>
                <input  class="iptnewtit" type="text" id="receiverName" name="receiverName" placeholder='' value="${businessExp.receiverName }"  />
                <br>
                <h2 class="relran">收件电话<label for="receiverTel" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="receiverTel" name="receiverTel" placeholder='' value="${businessExp.receiverTel }"  />
                <br>
                <h2 class="relran">收件地址<label for="receiverAddr" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="receiverAddr" name="receiverAddr" placeholder='' value="${businessExp.receiverAddr }"  />
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
                <ul class="accordion3"></ul>
            </div>
        </div>
    </div>
    <%--快递类型 1为已发送--%>
    <input type="hidden" name="expState" value="1"/>
</form>
</body>
</html>