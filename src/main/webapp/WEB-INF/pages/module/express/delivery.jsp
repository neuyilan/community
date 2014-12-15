<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>送货上门</title>
    <%@include file="/common/meta.jsp"%>
    <script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
    <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
    <script>

    $(document).ready(function(){
        var oWinH=$(window).height()+"px";
        $(".exp-r").css("height",$(window).height()+"px");
        if($(window).width()==768){
            $(".exp-l").css("min-height",$(window).height()+"px");
        };

        $(".exp-l").css("min-height",$(window).height()+"px");
        /*已签收*/
        $("#qsbtn").click(function(){
            $("#y-kd-qsinfor").fadeIn("slow");
            $("#y-kd-qsinfor").css("height",$(document.body).outerHeight(true)+'px');
            $("#qscon").css("height",$(document.body).outerHeight(true)-40+'px')
        });

        $("#closeqs").click(function(){
            $("#y-kd-qsinfor").fadeOut("slow");
        });
        
        $("#canelSignBtn").click(function(){
            $("#y-kd-qsinfor").fadeOut("slow");
        });
    });

    //签收 修改状态为 5 已签收
    function checkConfirm() {
            var expId = '${businessExp.expId}';
            var signname = $('#signname').val();
            if(signname == '') {
            	alert('请输入签收人姓名');return;
            }else if(signname.length > 32){
            	alert('签收人姓名在32字内');return;
            }
            var isSelf = $('#isSelf').is(':checked');
            isSelf = (isSelf?'1':'0');
            if(confirm('确认签收吗?')) {
    			$.ajax({
    				url: 'saveSignedResolve.do',
    				type: 'POST',
    				dataType: "json",
    				data: {expId : expId, 
    			      	signname : signname, 
    			      	isSelf : isSelf
    			      },
    				cache: false,
    				success: function(data) {
    					 
    					if(data.success == 'true') {
    			      			window.location.href = '${ctx}/business/businessExp/getDetails.do?expId=${businessExp.expId}&expState=6';
    					}else{
    						alert('签收失败');return;
    					}
    				},
    				error: function(data) {
    					alert(data.message);
    				}
    			});
    		}	
        }
    
    //开始配送 -- 向APP端推送提示信息
    function startDistribution() {
        var expId = '${businessExp.expId}';
        /* $.getJSON("${ctx}/business/businessExp/startDistribution.do", {id : expId}, function(data) {
            alert(data.message);
            $('#startSendBtn').hide();
        }); */
        if(confirm('确认配送吗?')) {
			$.ajax({
				url: 'startDistribution.do',
				dataType: 'json',
				data: {expId : expId},
				method: 'post',
				cache: false,
				success: function(data) {
					 
					if(data.success == 'true') {
			      			window.location.href = '${ctx}/business/businessExp/getDetails.do?expId=${businessExp.expId}&expState=1';
					}else{
						alert('配送失败');return;
					}
				},
				error: function(data) {
					alert(data.message);
				}
			});
		}	
    }
</script>
</head>
<body style="background:#f1f1f1;">
<div class="wrapper">
    <div class="expdet">
        <%-- <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" style="cursor: pointer;"></span>快递详情</div> --%>
        <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'"  style="cursor: pointer;"></span>快递详情</div>
        <div class="exp-cont">
            <div class="exp-l  y-kd-nor">
                <div class="exp-l-top">
                   <div class="top-l">
                        <ul>
                            <li>快递公司：<span class="contxt">${businessExp.expCompany}</span></li>
                            <li>快递单号：<span class="contxt">${businessExp.expCode}</span></li>
                            <li>收&nbsp;&nbsp;货&nbsp;&nbsp;人：<span class="contxt">${businessExp.receiverName}</span></li>
                            <li>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<span class="contxt">${businessExp.receiverTel}</span></li>
                            <li>收件地址：<span class="contxt">${businessExp.receiverAddr}</span></li>
                       		<li>签收验证码：<span class="contxt">${businessExp.code}</span></li>
                        </ul>
                    </div>
                    <form id="ff" method="post" action="${ctx}/business/businessExp/update.do">
                        <div class="top-r">
                            <div class="cost">
                                <div class="costinfo">运费到付：<span>￥${businessExp.payMount}</span></div>
                                <div class="costinfo">代收金额：<span>￥${businessExp.agentMount}</span></div>
                               <%--  <c:if test="${businessExp.expState == 5 }"> --%>
                                <div class="y-kd-qot">
                                <c:if test="${businessExp.isDistributed == 0 }">
                                    <input class="y-kd-qt" type="button" name="" id="startSendBtn" value="开始配送" onclick="startDistribution();"/><%--向前台推送信息--%>
                                 </c:if>
                                    <input id="qsbtn" class="" type="button" name="" value="已签收" />
                                </div>
                            	<%-- </c:if> --%>
                            </div>
                        </div>
                        <input type="hidden" name="expId" value="${businessExp.expId}"/> <%--快递ID--%>
                    </form>
                    <div class="no-float"></div>
                    <hr class="link">
                </div>
                <div class="no-float"></div>
                <div class="exp-l-bot">
                    <div class="detbox">
                        <ul class="detinfo">
                            <!-- <li><time>2014-4-30<br/>14:38</time><span class="cirbag"></span><i class="link"></i><span class="stainfo">金亮  13910830458<br/>已确认自提取件</span></li>
                            <li><time>2014-4-30<br/>14:38</time><span class="cir"></span><i class="link"></i><span class="stainfo">金亮  13910830458<br/>已确认自提取件</span></li>
                            <li><time>2014-4-30<br/>14:38</time><span class="cir"></span><i class="link"></i><span class="stainfo">金亮  13910830458<br/>已确认自提取件</span></li>
                            <li><time>2014-4-30<br/>14:38</time><span class="cir"></span><span class="stainfo">金亮  13910830458<br/>已确认自提取件</span></li> -->
                            <c:forEach items="${resolveList }" var="resolve" varStatus="key">
							<li>
                            	<span>
                            		<fmt:formatDate value="${resolve.resolveTime }" pattern="yyyy-MM-dd"/><br />
                            		<fmt:formatDate value="${resolve.resolveTime }" pattern="HH:mm"/>
                            	</span>
                            	<c:if test="${key.index == 0 }"> <span id="y-kd-hq" class="cirbag" ></span> </c:if> 
                            	<c:if test="${key.index != 0 }"> <span class="cir" ></span> </c:if> 
                            	<i class="link"></i>
                            	<span class="stainfo">
                            		<%-- ${fn:replace(resolve.resolveMemo, '\\r\\n', '<br />')} --%>
                            		<c:choose>
										<c:when test="${resolve.type == 1}">
											<%-- <object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" id="MediaPlayer${status}" width="290" height="45">
										 		<!--是否自动播放-->
												<param name="AutoStart" value="">
												<!--播放的文件地址-->
												<param name="Filename" value="${ip}${resolve.resolveMemo}" valuetype="ref">
											</object> --%>
											<script type="text/javascript">pv_q("${ip}${resolve.resolveMemo}",100,32);</script>
										</c:when>
										<c:otherwise>
												${fn:replace(resolve.resolveMemo, '\\r\\n', '<br />')}
										</c:otherwise>
									</c:choose>
                            	</span>
                            </li>
							</c:forEach> 
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="y-kd-qsinfor" class="popup-box">
    <div id="qscon" class="box-con">
        <a id="closeqs" class="box-close" href="javascript:;"></a>
        <h2 class="box-tit">签收信息确认</h2>
        <div id="wrapper-250">
            <ul class="box-infor">
                <div class="hline"></div>
                <ul class="box-menu">
                    <li>收&nbsp;&nbsp;货&nbsp;&nbsp;人：<span class="contxt">${businessExp.receiverName}</span></li>
                    <li>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<span class="contxt">${businessExp.receiverTel}</span></li>
                    <li>收件地址：<span class="contxt">${businessExp.receiverAddr}</span></li>
                    <div class="hline"></div>
                    <li><div class="y-kd-yqs">
                    	<span>签收人：</span>
                    	<input type="text" name="signname"  id="signname" class="y-kd-qsb">
                    	<input type="checkbox" name="isSelf"  id="isSelf" class="y-kd-qsc" value="1">
                    	<span>本人</span></div></li>
                </ul>
            </ul>
        </div>
        <div class="w-gg-btn">
            <span class="w-gg-qr w-gg-total" style="cursor: pointer;" onclick="checkConfirm();">确认</span>
            <span class="w-gg-qx w-gg-total" id="canelSignBtn">取消</span>
        </div>
    </div>
</div>
</body>
</html>