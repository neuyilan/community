<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/29
  Time: 10:30
  To change this template use File | Settings | File Templates.
  已入库 状态
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已入库</title>
    <%@include file="/common/meta.jsp"%>
    <script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script>
        $(document).ready(function(){
            var oWinH=$(window).height()+"px";
            $(".exp-r").css("height",$(window).height()+"px");
            if($(window).width()==768){
                $(".exp-l").css("min-height",$(window).height()+"px");
            };
            $(".exp-l").css("min-height",$(window).height()+"px");
        });

        function sendWrite(id) {
            window.location.href = '${ctx}/business/businessExp/getSendWrite.do?expId='+id;
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
                        <ul> <!--  id="y-kd-sjinfor" -->
                            <li>快递公司：<span class="contxt">${businessExp.expCompany}</span></li>
                            <li>快递单号：<span class="contxt">${businessExp.expCode}</span></li>
                            <li>收&nbsp;&nbsp;货&nbsp;&nbsp;人：<span class="contxt">${businessExp.receiverName}</span></li>
                            <li>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<span class="contxt">${businessExp.receiverTel}</span></li>
                            <li>收件地址：<span class="contxt">${businessExp.receiverAddr}</span></li>
                            <li>签收验证码：<span class="contxt">${businessExp.code}</span></li>
                        </ul>
                    </div>
                    <div class="y-kd-btnd">
                    	<c:if test="${businessExp.expState == 3 }" >
                        <input class="y-kd-btn" type="button" name="" value="自提" id="pickSelfBtn" style="margin-right:3%" />
                        <input class="y-kd-btn" type="button" name="" value="上门送件" id="sendHomeBtn" />
                    	</c:if>
                    </div>
                    <div class="no-float"></div>
                    <hr class="link">
                </div>
                <div class="no-float"></div>
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
                            		 ${fn:replace(resolve.resolveMemo, '\\r\\n', '<br />')}
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

</body>
</html>

<script type="text/javascript">

$(document).ready(function(){
	//自提操作
	$('#pickSelfBtn').click(function() {
		if(confirm('确认自提吗?')) {
			$.ajax({
	    		url: 'savePickResolve.do',
	    		dataType: 'json',
	    		data: {expId: '${businessExp.expId}'},
	    		method: 'post',
	    		cache: false,
	    		success: function(data) {
	    			 
	    			if(data.success == 'true') {
	    				var liDom = ''
	            			+ '<li>'
	            			+ '<span>'+(data.resolveTime != '' ? data.resolveTime.substring(0, 10) : '')+'<br />'+(data.resolveTime != '' ? data.resolveTime.substring(11, 16) : '')+'</span>'
	            			+ '<span class="cirbag" id="y-kd-hq"></span>'
	            			+ '<span class="stainfo">'
	            			+ data.resolveMemo.replace("\r\n", "<br />");
	            			+ '</span>'
	            			+ '</li>';
	            			$('#y-kd-lc').prepend(liDom);
	            			$('#pickSelfBtn').hide();
	            			$('#sendHomeBtn').hide();
	            			window.location.href = '${ctx}/business/businessExp/getDetails.do?expId=${businessExp.expId}&expState=4';
	    			}else{
	    				alert('取件失败');return;
	    			}
	    		},
	    		error: function(data) {
	    			alert(data.message);
	    		}
	    	});
		}		
	});
	
	//送货上门操作
	$('#sendHomeBtn').click(function() {
		if(confirm('确认上门送件吗?')) {
			$.ajax({
	    		url: 'saveSendHomeResolve.do',
	    		dataType: 'json',
	    		data: {expId: '${businessExp.expId}'},
	    		method: 'post',
	    		cache: false,
	    		success: function(data) {
	    			 
	    			if(data.success == 'true') {
	    				var liDom = ''
	            			+ '<li>'
	            			+ '<span>'+(data.resolveTime != '' ? data.resolveTime.substring(0, 10) : '')+'<br />'+(data.resolveTime != '' ? data.resolveTime.substring(11, 16) : '')+'</span>'
	            			+ '<span class="cirbag" id="y-kd-hq"></span>'
	            			+ '<span class="stainfo">'
	            			+ data.resolveMemo.replace("\r\n", "<br />");
	            			+ '</span>'
	            			+ '</li>';
	            			$('#y-kd-lc').prepend(liDom);
	            			$('#pickSelfBtn').hide();
	            			$('#sendHomeBtn').hide();
	            			window.location.href = '${ctx}/business/businessExp/getDetails.do?expId=${businessExp.expId}&expState=5';
	    			}else{
	    				alert('取件失败');return;
	    			}
	    		},
	    		error: function(data) {
	    			alert(data.message);
	    		}
	    	});
		}		
	});
});
</script>