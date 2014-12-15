<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自提快件</title>
    <%@include file="/common/meta.jsp"%>
    <script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
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
        });

        //签收 修改状态为6 已签收
        function checkConfirm() {
            var expId = '${businessExp.expId}';
            var signname = $('#signname').val();
            if(signname == '') {
            	alert('请输入签收人姓名');return;
            }
            var isSelf = $('#isSelf').is(':checked');
            isSelf = (isSelf?'1':'0');
            if(confirm('确认自提吗?')) {
    			$.ajax({
    				url: 'saveSignedResolve.do',
    				dataType: 'json',
    				type: 'post',
    				cache: false,
    				data: {expId : expId, 
    			      	signname : signname, 
    			      	isSelf : isSelf
    			      },
    				success: function(data) {
    					if(data.success == 'true') {
    						var liDom = ''
    			      			+ '<li>'
    			      			+ '<time>'+(data.resolveTime != '' ? data.resolveTime.substring(0, 10) : '')+'<br />'+(data.resolveTime != '' ? data.resolveTime.substring(11, 16) : '')+'</time>'
    			      			+ '<span class="cirbag" id="y-kd-hq"></span>'
    			      			+ '<span class="stainfo">'
    			      			+ data.resolveMemo.replace("\r\n", "<br />");
    			      			+ '</span>'
    			      			+ '</li>';
    			      			$('#y-kd-lc').prepend(liDom);
    			      			$('#qsbtn').hide();
    			      			$("#y-kd-qsinfor").fadeOut("slow");
    			      			window.location.href = '${ctx}/business/businessExp/getDetails.do?expId=${businessExp.expId}&expState=6';
    					}else{
    						alert('自提失败');return;
    					}
    				},
    				error: function(data) {
    					alert(data.message);
    				}
    			});
    		}	
        }
        
        function quit() {
        	$("#y-kd-qsinfor").fadeOut("slow");
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

                    <div class="top-r">
                        <div class="cost">
                            <div class="costinfo">运费到付：<span>￥${businessExp.payMount}</span></div>
                            <div class="costinfo">代收金额：<span>￥${businessExp.agentMount}</span></div>
                            <c:if test="${businessExp.expState == 4 }">
                            <div class="y-kd-qot">
                                <input id="qsbtn" class="" type="button" name="" value="已签收" />
                            </div>
							</c:if>
                        </div>
                    </div>
                    <div class="no-float"></div>
                    <hr class="link">
                </div>
                <div class="no-float"></div>

                <div class="exp-l-bot">
                    <div class="detbox">
                        <ul class="detinfo">
							<c:forEach items="${resolveList }" var="resolve" varStatus="key">
							<li>
                            	<span>
                            		<fmt:formatDate value="${resolve.resolveTime }" pattern="yyyy-MM-dd"/><br />
                            		<fmt:formatDate value="${resolve.resolveTime }" pattern="HH:mm"/>
                            	</span>
                            	<c:if test="${key.index == 0 }"> <span class="cirbag" ></span> </c:if> 
                            	<c:if test="${key.index != 0 }"> <span class="cir" ></span> </c:if> 
                            	<i class="link"></i>
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
                    	<span>签收人：</span><input type="text" name="signname"  id="signname" class="y-kd-qsb">
                    	<input type="checkbox" name="isSelf"  id="isSelf" class="y-kd-qsc" value="1">
                    	<span>本人</span>
                    	</div>
                    </li>
                </ul>
            </ul>
        </div>
        <div class="w-gg-btn">
            <span class="w-gg-qr w-gg-total" style="cursor: pointer;" onclick="checkConfirm()">确认</span>
            <span class="w-gg-qx w-gg-total" style="cursor: pointer;" onclick="quit()">取消</span>
        </div>
    </div>
</div>
</body>
</html>