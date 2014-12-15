<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>快递详情</title>
    <style type="text/css">
    	.loading { 
			display: block; 
			width: 100%; 
			height: 100%; 
			opacity: 0.4; 
			filter: alpha(opacity=40); 
			background: url(../../images/loading.gif) no-repeat center center #dddddd; 
			position: absolute; 
			top: 0; 
			left: 0; 
			z-index: 2000; 
		} 
    </style>
    <%@include file="/common/meta.jsp"%>
    <script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
    <%-- <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script> --%>
    <script>
        $(document).ready(function(){
            $(".exp-r").css("height",$(window).height()+"px");
            if($(window).width()==768){
                $(".exp-l").css("min-height",$(window).height()+"px");
            };
            $(".exp-l").css("min-height",$(window).height()+"px");
            
            //开始取件处理
            $('#startGetBtn').click(function() {
            	$('#startGetBtn').attr("disabled","disabled");
            	$.ajax({
            		url: 'saveGetResolve.do',
            		dataType: 'json',
            		data: {expId: '${businessExp.expId}'},
            		method: 'post',
            		cache: false,
            		beforeSend:function(){
            	    	$("#loading").addClass("loading");
            	    },
            		success: function(data) {
            			if(data.success == 'true') {
            				location.reload();
            				var liDom = ''
                    			+ '<li>'
                    			+ '<span>'+(data.resolveTime != '' ? data.resolveTime.substring(0, 10) : '')+'<br />'+(data.resolveTime != '' ? data.resolveTime.substring(11, 16) : '')+'</span>'
                    			+ '<span class="cirbag" id="y-kd-hq"></span>'
                    			+ '<span class="stainfo">'
                    			+ data.resolveMemo.replace("\r\n", "<br />");
                    			+ '</span>'
                    			+ '</li>';
                    			$('#y-kd-lc').prepend(liDom);
                    			$('#startGetBtn').hide();
            			}else{
            				alert('取件失败');return;
            			}
            		},
            		complete: function() {
            			$("#loading").removeClass("loading");
                    },
            		error: function(data) {
            			alert(data.message);
            		}
            	});
            });
        });

        function sendWrite(id) {
            window.location.href = '${ctx}/business/businessExp/getSendWrite.do?expId=${businessExp.expId}&expState=${businessExp.expState}';
        }
    </script>
</head>

<body style="background:#f1f1f1;">
<div id="loading">
</div>
<div class="wrapper">
    <div class="expdet">
        <%-- <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" style="cursor: pointer;"></span>快递详情</div> --%>
        <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'"  style="cursor: pointer;"></span>快递详情</div>
        <div class="exp-cont">
            <div class="exp-l y-kd-nor">
                <div class="exp-l-top">
                    <div class="top-l">
                        <ul>
                        	<li>真实姓名：<span class="contxt">${businessExp.realname }</span></li>
                       	 	<li>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<span class="contxt">${businessExp.nickname }</span></li>
                        	<li>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<span class="contxt">${businessExp.tel }</span></li>
                            <li>发&nbsp;&nbsp;件&nbsp;&nbsp;人：<span class="contxt">${businessExp.senderName }</span></li>
                            <li>发件人电话：<span class="contxt">${businessExp.senderTel }</span></li>
                            <li>发件地址：<span class="contxt">${businessExp.senderAddr }</span></li>
                        </ul>
                    </div>
                    <div class="y-kd-btnd">
                    	<c:if test="${businessExp.expState == 0 }">
                        <input class="y-kd-btn" type="button" name="" id="startGetBtn" value="开始取件" style="margin-right:3%" />
                        </c:if>
                        <input class="y-kd-btn" type="button" name="" value="发件录入" onclick="sendWrite('${param.expId}');" />
                    </div>
                    <div class="no-float"></div>
                    <hr class="link">
                </div>
                <div class="exp-l-bot">
                    <div class="detbox">
                        <ul class="detinfo" id="y-kd-lc">
                        	<c:forEach items="${resolveList }" var="resolve" varStatus="key">
                        	<li>
                            	<span>
                            		<fmt:formatDate value="${resolve.resolveTime }" pattern="yyyy-MM-dd"/><br />
                            		<fmt:formatDate value="${resolve.resolveTime }" pattern="HH:mm"/>
                            	</span>                          	 
                            	<c:if test="${key.index == 0 }"> <span id="y-kd-hq" class="cirbag" ></span> </c:if> 
                            	<c:if test="${key.index != 0 }"> <span class="cir" ></span> </c:if> 
                            	<c:if test="${key.index < fn:length(resolveList)-1}"><i class="link"></i></c:if>
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
											<!-- <script type="text/javascript">pv_q("${ip}${resolve.resolveMemo}",100,32);</script> -->
											<object width="100" height="32" classid="clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B" codebase="http://www.apple.com/qtactivex/qtplugin.cab"> 
												<param name="src" value="${ip}${resolve.resolveMemo}"> 
												<param name="controller" value="true"> 
												<param name="type" value="video/quicktime"> 
												<param name="autoplay" value="false"> 
												<param name="target" value="myself"> 
												<param name="bgcolor" value="black"> 
												<param name="pluginspage" value="http://www.apple.com/quicktime/download/index.html"> 
												<embed src="${ip}${resolve.resolveMemo}" width="100" height="32" controller="true" align="middle" bgcolor="black" target="myself" type="video/quicktime" pluginspage="http://www.apple.com/quicktime/download/index.html"></embed> 
											</object> 
										</c:when>
										<c:otherwise>
												${fn:replace(resolve.resolveMemo, '\\r\\n', '<br />')}
										</c:otherwise>
									</c:choose>
                            	</span>
							</li>
                        	</c:forEach>
                        	<!-- 
                        	<li><time>2014-4-30<br/>14:38</time><span class="cirbag"></span><i class="link"></i><span class="stainfo">金亮  13910830458<br/>已确认自提取件</span></li>
                            <li><time>2014-4-30<br/>14:38</time><span class="cir"></span><span class="stainfo">金亮  13910830458<br/>已确认自提取件</span></li>
                            <li><time>2014-4-30<br/>14:38</time><span class="cir"></span><span class="stainfo">金亮  13910830458<br/>已确认自提取件</span></li>
                            <li><time>2014-4-30<br/>14:38</time><span class="cir"></span><span class="stainfo">金亮  13910830458<br/>已确认自提取件</span></li>
                        	  -->
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>