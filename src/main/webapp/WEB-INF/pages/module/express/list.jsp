<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.text.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>快递管理</title>
        <%@include file="/common/meta.jsp"%>
        <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
        <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
        <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    	<script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
        <!--设置图标位置-->
    <script type="text/javascript">
	    $(function () {
			$(document).keyup(function(event){
				  if(event.keyCode ==13){
				    $("#searbut").trigger("click");
				  }
			});
		});
	    
        $(document).ready(function(){
            var uw=$(".y-kd-kdzt").width() - 4;
            var uh=$(".y-kd-kdzt").height() - 4;
            setwh(uw,uh);

          //验证表单
          /* var form = $('#codeForm');
          alert('form   '+form.attr('action'));
            $('#codeForm').validate({
                submitHandler:function(form){
                    $('#codeForm').form('submit', {
                        success:function(data){
                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                            //alert(data.message);
                            $("#takeAuditShow").css("display","block");
                        }
                    });
                },
                errorClass: "error",
                success: function(label) {
                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
                },
                rules: {
                	code: {
                        required: true,
                        length: 6,
                        digits: true
                    }
                },
                messages: {
                	code: {
                        required: '请选择快递公司！',
                        length: '验证码为6位数字！',
                        digits: '验证码为6位数字！'
                    }
                }
            }); */
            
            $('#ztysbtn').click(function() {
            	if(parseInt('${curEstateId}') == 0) {
        			alert("请先切换到小区");return;
        		}else if(parseInt('${curStateId}') == 0) {
           			alert("当前小区没有服务驿站");return;
           		}
            	$('#y-kd-ztysin').fadeIn('slow');
            });

            $("#takeAuditBtn").click(function(e) {
            	//$('#codeForm').submit();
            	var code = $('#code').val();
            	if(code == '') {
            		alert('请输入6位数字验证码');return;
            	}else{
            		$.ajax({
            			url: 'findExpByCode.do',
            			dataType: 'json',
            			data: {code: code},
            			cache: false,
            			success: function(data) {
            				if(data.success == 'true') {
            					$('#expId').val(data.expId);
            					$('#expCompany').text(data.expCompany);
            					$('#receiverName').text(data.receiverName);
            					$('#receiverTel').text(data.receiverTel);
            					$('#takeAuditShow').show();
            				}else{
            					alert(data.message);return;
            				}
            				$('#code').val('');
            			},
            			error: function(data) {
            				alert('查询失败');return;
            				$('#code').val('');
            			}
            		});
            	}
            });
            
            //签收成功
            $("#signReceiveBtn").click(function(e) {
            	var expId = $('#expId').val();
            	if(expId == '') {
            		alert('请先使用验证码查询快件');return;
            	}else{
            		$.ajax({
            			url: 'signExp.do',
            			dataType: 'json',
            			data: {expId: expId},
            			cache: false,
            			type: 'post',
            			success: function(data) {
            				if(data.success == 'true') {
            					alert('已签收成功');
            					$('#y-kd-ztysin').fadeOut('slow');
            					$('#code').val('');
            					$('#expId').val('');
            					$('#expCompany').text('');
            					$('#receiverName').text('');
            					$('#receiverTel').text('');
            				}else{
            					alert(data.message);return;
            				}
            			},
            			error: function(data) {
            				alert('查询失败');return;
            			}
            		});
            	}
            });
            
        });

        $(window).resize(function(){
            var uw=$(".y-kd-kdzt").width();
            var uh=$(".y-kd-kdzt").height();
            setwh(uw,uh);
        });

        function setwh(uw,uh){
            var lw=parseInt((uw-3)/2);
            var lh=parseInt((uh-3)/2);
            $(".y-kd-kdzt li").css({"width":lw,"height":lh});
            if(lw>=lh){
                var lh1=lh*0.8;
                var ll=parseInt(((2*lw+1)-lh1)/2);
                var lt=parseInt((310-lh1)/2);
                $(".y-kd-kdzt .y-kd-index").css({"width":lh1,"height":lh1,"border-radius":lh1,"left":ll,"top":lt});
            }
            else{
                var lw1=lw*0.8;
                var ll=parseInt(((2*lw+1)-lw1)/2);
                var lt=parseInt((310-lw1)/2);
                $(".y-kd-kdzt .y-kd-index").css({"width":lw1,"height":lw1,"border-radius":lw1,"left":ll,"top":lt});
            }

            var cw=$(".y-kd-kdzt .y-kd-index").width();
            var iw=$(".y-kd-kdzt i").width();
            var sw=$(".y-kd-kdzt span").width();
            var lm=parseInt(cw/2+1);
            var im=parseInt(lm+(sw-iw)/2);
            var ih=$(".y-kd-kdzt i").height();
            var sh=$(".y-kd-kdzt span").height();
            var imt=parseInt((lh-ih-sh)/2);
            var indext=parseInt((cw-ih-sh)/2);
            $(".y-kd-kdzt .y-kd-left span").css("margin-right",lm);
            $(".y-kd-kdzt .y-kd-right span").css("margin-left",lm);
            $(".y-kd-kdzt .y-kd-left i").css({"margin-right":im,"margin-top":imt});
            $(".y-kd-kdzt .y-kd-right i").css({"margin-left":im,"margin-top":imt});
            $(".y-kd-kdzt .y-kd-index i").css({"margin-top":indext});
        }

        function seeExDetail(id, expState, newsCount) {
            window.location.href = '${ctx}/business/businessExp/getDetails.do?expId='+id+'&expState='+expState+'&newsCount='+newsCount;
        }
        
        function exportExcelList() {
            window.location.href = '${ctx}/business/businessExp/findExcelAllExp.do';
        }
        
        function jumpUrl(url) {
    		if(parseInt('${curEstateId}') == 0) {
    			alert("请先切换到小区");return;
    		}else if(parseInt('${curStateId}') == 0) {
       			alert("当前小区没有服务驿站");return;
       		}else{
    			window.location.href = url;
    		}
    	}
    </script>
        
    </head>

    <div class="max-height">

    <div class="wrapper wrapos">

        <!--左导航开始-->
        <%@include file="/common/leftNav.jsp"%>
        <!--左导航结束-->

        <!--右部主体内容开始-->
        <div class="mainr">
            <%@include file="/common/header.jsp"%>
            <div class="scroll">
	        	<div class="scroll-box">
	                <ul id="oneul">
	                	<li id="expState_" class="active navlist"><a href="javascript:;"><span>全部快递</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="expState" id="expState" value="${expState }" />
	                    	<ul class="erjnav">
	                            <li id="expState_0"><a href="javascript:;">上门取件</a></li>
	                            <li id="expState_1"><a href="javascript:;">已上门取件</a></li>
	                            <li id="expState_2"><a href="javascript:;">已发送</a></li>
	                            <li id="expState_3"><a href="javascript:;">已入库</a></li>
	                            <li id="expState_4"><a href="javascript:;">自提</a></li>
	                            <li id="expState_5"><a href="javascript:;">上门送件</a></li>
	                            <li id="expState_6"><a href="javascript:;">已签收</a></li>
	                            <li id="expState_7"><a href="javascript:;">已退件</a></li>
	                        	<li id="expState_8"><a href="javascript:;">已取消</a></li>
	                        	<li id="expState_9"><a href="javascript:;">问题件</a></li>
	                        	<li id="expState_10"><a href="javascript:;">被投诉快递</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="expCompanyID_" class="navlist"><a href="javascript:;"><span>所有快递公司</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="expCompanyID" id="expCompanyID" value="" />
	                    	<ul class="erjnav">
	                			<c:forEach items="${expressList }" var="express" varStatus="key">
	                				<li id="expCompanyID_${express.expressId }"><a href="javascript:;">${express.expressComppay }快递</a></li>
	                			</c:forEach>
	                        </ul>
	                    </li>
	                    
	                    <li id="timeScope_" class="navlist"><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a>
	                   		<input type="hidden" name="timeScope" id="timeScope" value="" />
	                   		<input type="hidden" name="startTime" id="startTime" value="" />
	                   		<input type="hidden" name="endTime" id="endTime" value="" />
	                    	<ul class="erjnav">
	                    		<li id="timeScope_0"><a href="javascript:;">当日</a></li>
	                            <li id="timeScope_7"><a href="javascript:;">7天内</a></li>
	                            <li id="timeScope_30"><a href="javascript:;">30天内</a></li>
	                            <li id="timeScope_90"><a href="javascript:;">90天内</a></li>
	                            <li id="timeScope_365"><a href="javascript:;">365天内</a></li>
	                            <li id="timeScope_scope"><a href="javascript:;">选择时间范围</a></li>
	                        </ul>
	                    </li>
	                </ul>
	            <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            <a onclick="exportExcelList()" href="javascript:;" style="border: 1px solid rgb(207, 207, 207); color: rgb(51, 51, 51); display: inline-block; font-size: 14px; height: 30px; line-height: 30px; margin: 0px 5px 0px 20px; text-align: center; width: 100px; border-radius: 15px;">导出运单</a>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='快递单号/收发件电话搜索' /><input id="searbut" type="button" onclick="search()" value="" /></div></div>
	        </div>

	        <div class="column">
	        	<div class="manbox" style="margin-left:0;">
	            	<a class="nopotr y-kd-boxh y-kd-fb" href="javascript:;" style="cursor:pointer;">
	                    <ul class="y-kd-kdzt">
	                        <li class="y-kd-left y-kd-top y-kd-rightb">
	                            <i class="y-kd-sj" onclick="jumpUrl('${ctx}/business/businessExp/addReceive.do')"></i><br>
	                            <span onclick="jumpUrl('${ctx}/business/businessExp/addReceive.do')">客户收件</span>
	                        </li>
	                        <li class="y-kd-right y-kd-top " >
	                           <i class="y-kd-fj" onclick="jumpUrl('${ctx}/business/businessExp/addSend.do')"></i><br>
	                           <span onclick="jumpUrl('${ctx}/business/businessExp/addSend.do')">客户发件</span>
	                        </li>
	                        <li class="y-kd-left y-kd-bottom y-kd-rightb y-kd-topb" id="ztysbtn">
	                           <i class="y-kd-qs" ></i><br>
	                           <span>快速签收</span>
	                        </li>
	                        <li class="y-kd-right y-kd-bottom y-kd-topb">
	                           <i class="y-kd-yh" onclick="jumpUrl('${ctx}/business/businessExp/addDiscount.do')"></i><br>
	                           <span onclick="jumpUrl('${ctx}/business/businessExp/addDiscount.do')">优惠设置</span>
	                        </li>
	                        <li class="y-kd-index">
                           <i class="y-kd-qj" onclick="jumpUrl('${ctx}/business/businessExp/addAppointment.do')"></i><br>
                           <span onclick="jumpUrl('${ctx}/business/businessExp/addAppointment.do')">预约发件</span>
                        </li>
                    </ul>
                </a>
            </div>
            	
	            <c:forEach items="${baseBean.list }" var="exp" varStatus="key">
	        		<div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> >
		            	<a class="nopotr y-kd-boxh" href="javascript:;">
		                    <p class="y-kd-infor">
		                        <span class="y-kd-yz">所属驿站：<lable  style="color: #3EAF0E;">${exp.station }</lable></span>
		                        <span class="y-kd-kjgs">快件公司：<lable  style="color: #3EAF0E;">${exp.expCompany }快递</lable></span>
		                    </p>
		                    <time class="y-kd-time1"><fmt:formatDate value="${exp.createTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    <hr class="link">
		                    
								<c:if test="${exp.expState == 0 || exp.expState == 1 || exp.expState == 2}" >
									<p class="y-kd-infor1"><span class="y-kd-name">${exp.senderName }</span><span class="y-kd-address">${exp.senderAddr }</span></p>
									<span class="y-kd-phone">${exp.senderTel }</span>
								</c:if>
								<c:if test="${exp.expState == 3 || exp.expState == 4 || exp.expState == 5 || exp.expState == 6 || exp.expState == 7 || exp.expState == 8}" >
									<p class="y-kd-infor1"><span class="y-kd-name">${exp.receiverName }</span><span class="y-kd-address">${exp.receiverAddr }</span></p>
									<span class="y-kd-phone">${exp.receiverTel }</span>
								</c:if>
								<c:if test="${exp.expState == 9}" >
									<p class="y-kd-infor1"><span class="y-kd-name">${exp.receiverName }</span><span class="y-kd-address">${exp.receiverAddr }</span></p>
									<span class="y-kd-phone">${exp.receiverTel }</span>
								</c:if>
		                    <div class="state">
								<c:if test="${exp.expState == 0}"><span class="yggl_relsta crosered">上门取件</span></c:if>
								<c:if test="${exp.expState == 1}"><span class="yggl_relsta cdblue">已上门</span></c:if>
								<c:if test="${exp.expState == 2}"><span class="yggl_relsta cblue">已发送</span></c:if>
								<c:if test="${exp.expState == 3}"><span class="yggl_relsta cyellow">已入库</span></c:if>
								<c:if test="${exp.expState == 4}"><span class="yggl_relsta cpurple">自提</span></c:if>
								<c:if test="${exp.expState == 5}"><span class="yggl_relsta ccyan">上门送件</span></c:if>
								<c:if test="${exp.expState == 6}"><span class="yggl_relsta cgreen">已签收</span></c:if>
								<c:if test="${exp.expState == 7}"><span class="yggl_relsta cblack">已退件</span></c:if>
								<c:if test="${exp.expState == 8}"><span class="yggl_relsta cgray">已取消</span></c:if>
								<c:if test="${exp.expState == 9}"><span class="yggl_relsta cdred">问题件</span></c:if>
		                    </div>
		                    
		                    <div class="text">
		                    	${fn:replace(exp.briefMessage, '\\r\\n', '<br />')}
		                    </div>
		                    <!-- <time class="y-kd-time2">2014-04-30  8:31</time>
		                    <p class="yggl_text"><span>预约 明天  10:00 — 11:00   上门取件</span></p>
		                    <p class="yggl_text y-qz-hide"><span>选择去服务站发送快件</span></p> -->
		                    <hr class="link" style="margin:5px auto 0">
		                    <shiro:hasPermission name="exp_view_detail">
		                    <div class="operate operate2 blop" style="margin:0;" >
								<span class="see" style="position:relative; height:50px;" id="block5" title="查看快递详情"  onclick="seeExDetail('${exp.expId}','${exp.expState}', '${exp.newsCount}');">
									<c:if test="${exp.newsCount > 0 }"><img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" /></c:if>
								</span>
							</div>
							</shiro:hasPermission>
		                </a>
		            </div>
	        	</c:forEach>
	        	
	            <div class="no-float"></div>
	        </div>
	        
			<div class="page">
				<div class="pagec">
	            	<input type="hidden" id="pageCount" value="${pager.pageCount}" />
	                <ul id="pageUl">
	                	<li><a id="arrow-l" class="arrow" href="javascript:prev();" ></a></li>
	                	<c:forEach items="${pager.indexs }" var="pageNo">
	                		<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo });"><span id="page_${pageNo }">${pageNo }</span></a></li>
	                	</c:forEach>
	                	<li><a id="arrow-r" class="arrow" href="javascript:next();" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if> ></a></li>
	                </ul>
	        	</div>
	        </div>
            <div class="no-float"></div>

            <%@include file="/common/footer.jsp"%>

        </div>
        <!--右部主体内容结束-->
    </div>

    </div>
    <div id="y-kd-ztysin" class="busswi5 s-xw-bu">
        <div id="y-kd-ztyscon" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#y-kd-ztysin').fadeOut('slow');"></a>
			<!-- <form id="codeForm" method="post" action="findExpByCode.do"> -->
            <h2 class="tit5">自提验证<label for="code" class="error success"></label></h2>
            <input type="text" placeholder="请输入自提验证码" name="code" id="code" class="y-zt-input1">
            <input type="button" value="自提验证" name="" class="y-zt-btn1" id="takeAuditBtn">
           <!--  </form> -->
            <hr class="hline" />
            <div id="takeAuditShow" style=" display:none;">
                <div class="y-fbes-xx y-fbes-qs">
                    <span class="xx-qsi"><img src="<%=request.getContextPath()%>/images/icon/qs.jpg"></span>
                    <p class="xx-wz">
                    	<input type="hidden" name="expId" id="expId" value="" />
                        <span>快递公司:<i><span id="expCompany"></span></i></span>
                        <span>收货人：<i><span id="receiverName"></span></i></span>
                        <span>电话：<i><span id="receiverTel"></span></i></span>
                    </p>
                </div>
                <div class="y-kd-ztqr"><input type="button" class="y-zt-qr" name="" id="signReceiveBtn" value="确认签收"></div>
            </div>
        </div>
    </div>
</html>

<!-- 开始时间设置 -->
<div id="dateDialog" title="选择日期范围">
	<div>
		<label for="setStartTime">开始日期</label>
		<input type="text" class="iptnewtit" name="setStartTime" id="setStartTime" value="" />
		<label for="setEndTime">结束日期</label>
		<input type="text" class="iptnewtit" name="setEndTime" id="setEndTime" value="" />
	</div>
</div>
<!-- 开始时间设置 -->

<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
<script type="text/javascript">
    
	//初始化判断是否首页跳转过来的链接并更改默认搜索条件
	$(function(){  
		if($('#expState').val() != undefined && $('#expState').val() != '') {
			var objId = 'expState_'+$('#expState').val();
			bindChange($('#'+objId));
		}
	}); 
    
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					expState: $('#expState').val(),
					expCompanyID: $('#expCompanyID').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime: $('#endTime').val(),
					orderBy: $('#orderBy').val()
			};
		}
		return params;
	}
    
    //跳转页面
    function jump(pageNo) {
    	$('.column').html('');
    	$('#loading').css('display', 'block');
    	var params = getParams();
    	if(pageNo != undefined && pageNo != 0) {
    		params.page = pageNo;
    	}else{
    		params.page = 1;
    	}
    	
    	$.ajax({
    		type: 'post',
            url: '<%=path %>/business/businessExp/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                var rows = data.rows;
                if(params.page == 1) {
                	var addHtml = ''         
                		+ '<div class="manbox" style="margin-left:0;">'
                		+ '<a class="nopotr y-kd-boxh y-kd-fb" href="javascript:;" style="cursor:pointer;">'
                		+ '<ul class="y-kd-kdzt">'
                		+ '<li class="y-kd-left y-kd-top y-kd-rightb">'
                		+ '<i class="y-kd-sj" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addReceive.do\';"></i><br>'
                		+ '<span onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addReceive.do\';">客户收件</span>'
                		+ '</li>'
                		+ '<li class="y-kd-right y-kd-top " >'
                		+ '<i class="y-kd-fj" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addSend.do\';"></i><br>'
                		+ '<span onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addSend.do\';">客户发件</span>'
                		+ '</li>'
                		+ '<li class="y-kd-left y-kd-bottom y-kd-rightb y-kd-topb" id="ztysbtn">'
                		+'<i class="y-kd-qs" ></i><br>'
                		+'<span>快速签收</span>'
                		+'</li>'
                		+'<li class="y-kd-right y-kd-bottom y-kd-topb">'
                		+'<i class="y-kd-yh" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addDiscount.do\';"></i><br>'
                		+'<span onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addDiscount.do\';">优惠设置</span>'
                		+'</li>'
                		+'<li class="y-kd-index">'
                		+'<i class="y-kd-qj" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addAppointment.do\';"></i><br>'
                		+'<span onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addAppointment.do\';">预约发件</span>'
                		+'</li>'
                		+'</ul>'
                		+'</a>'
                		+'</div>';
                	$('.column').append(addHtml);
                }
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                    	var row = rows[i];  
                    	var styleStr = '';
                    	var styleStr = '';
                    	if(params.page == 1 && i % 3 == 2) {
                    		styleStr = 'style="margin-left:0;"';
       	        		}else if(params.page > 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
                    	
                    	var expState = '';
                    	var userName = '';
                    	var userAddress = '';
                    	var userTel ='';
                    	var appointInfo = '';
                    	if(row.expState == 0) {
                    		expState = '<span class="yggl_relsta crosered">上门取件</span>';
                    		userName = row.senderName;
                    		userAddress = row.senderAddr;
                    		userTel = row.senderTel;
    		            }else if(row.expState == 1) {
    		            	expState = '<span class="yggl_relsta cdblue">已上门</span>';
    		            	userName = row.senderName;
    		            	userAddress = row.senderAddr;
    		            	userTel = row.senderTel;
    		            }else if(row.expState == 2) {
    		            	expState = '<span class="yggl_relsta cblue" >已发送</span>';
    		            	userName = row.senderName;
    		            	userAddress = row.senderAddr;
    		            	userTel = row.senderTel;
    		            }else if(row.expState == 3) {
    		            	expState = '<span class="yggl_relsta cyellow">已入库</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else if(row.expState == 4) {
    		            	expState = '<span class="yggl_relsta cpurple">自提</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else if(row.expState == 5) {
    		            	expState = '<span class="yggl_relsta ccyan">上门送件</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else if(row.expState == 6) {
    		            	expState = '<span class="yggl_relsta cgreen">已签收</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else if(row.expState == 7) {
    		            	expState = '<span class="yggl_relsta cblack">已退件</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else  if(row.expState == 8) {
    		            	expState = '<span class="yggl_relsta cgray">已取消</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else  if(row.expState == 9) {
    		            	expState = '<span class="yggl_relsta cdred">问题件</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }
                    	
                    	String.prototype.replaceAll  = function(s1,s2){    
                            return this.replace(new RegExp(s1,"gm"),s2);    
                        };
                    	var briefMessage = (row.briefMessage).replaceAll("\r\n", "<br>");
                    	
                    	var htmlDom = ''
                  		+ '<div class="manbox"'
        	        	+ styleStr
        	        	+ '>'
        	        	+ '<a class="nopotr y-kd-boxh" href="javascript:;">'
        	        	+ '<p class="y-kd-infor">'
        	        	+ '<span class="y-kd-yz">所属驿站：<lable  style="color: #3EAF0E;">'+row.station+'</lable></span>'
        	        	+ '<span class="y-kd-kjgs">快件公司：<lable  style="color: #3EAF0E;">'+row.expCompany+'快递</lable></span>'
        	        	+ '</p>'
        	        	+ '<time class="y-kd-time1">'+(row.createTime != '' ? row.createTime.substring(0, 16) : '')+'</time>'
        	        	+ '<hr class="link">'
        	        	+ '<p class="y-kd-infor1"><span class="y-kd-name">'+userName+'</span><span class="y-kd-address">'+userAddress+'</span></p>'
        	        	+ '<span class="y-kd-phone">'+userTel+'</span>'
        	        	+ '<div class="state">'
        	        	+ expState
        	        	+ '</div>'
        	        	+ '<div class="text">'
        	        	+ briefMessage
                    	+ '</div>'
        	        	+ '<hr class="link" style="margin:5px auto 0">'
        	        	<shiro:hasPermission name="exp_view_detail">
        	        	+ '<div class="operate operate2 blop" style="margin:0;">'
        	        	+ '<span class="see" style="position:relative; height:50px;" title="查看快递详情" onclick="seeExDetail('+row.expId+', '+row.expState+', '+row.newsCount+'); ">'
        	        	+ (row.newsCount>0?'<img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" />':'')
        	        	+ '</span></div>'
        	        	</shiro:hasPermission>
        	        	+ '</a>'                
                    	+ '</div>';
                    	$('.column').append(htmlDom);
                    }
                }else{
                	$('.column').html('很抱歉，没有相关记录。');
                }
                $('.column').append('<div class="no-float"></div>');
                $('#loading').css('display', 'none');
                
                var vis = $("#pageUl li:not(#pageUl :first,#pageUl :last):visible");//显示的数量
               	var liCount = '';  
                for(var pageno=1; pageno<=(data.pageCount); pageno++){
                	var flag=false;
                	for(var i=0;i<vis.size();i++){
                		if(vis.eq(i).find("span").text()==pageno){
                			flag=true;
                		}
                	}
                	if(flag){
                		liCount = liCount + '<li><a   href="javascript:jump('+pageno+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                	}else{
                		liCount = liCount + '<li style="display:none";><a  href="javascript:jump('+pageno+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                	}
                	
                }
                var boolnext = '';
                if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next();'; }
                var boolprev = '';
                if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev();';  }
	           	var pageDom = ''
	           		+ '<div class="pagec"><ul id="pageUl">'
	           		+ '<li><a id="arrow-l" class="arrow" href="'+boolprev+'"></a></li>'
	           		+ liCount
	           		+ '<li><a id="arrow-r" class="arrow" href="'+boolnext+'"></a></li>'
	           		+ '</ul></div>';
	           	$('.page').html('');
            	$('.page').html(pageDom);
	            setCurrPageNo(pageNo);
                
                var uw=$(".y-kd-kdzt").width() - 4;
                var uh=$(".y-kd-kdzt").height() - 4;
                setwh(uw,uh);
            },
            error: function () {
            	$('.column').html('很抱歉，加载内容出错，我们及时修改问题。');
            }
        });
    }
</script>