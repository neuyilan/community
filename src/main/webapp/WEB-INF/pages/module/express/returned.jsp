<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/29
  Time: 10:41
  To change this template use File | Settings | File Templates.
  已退件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已退件</title>
    <%@include file="/common/meta.jsp"%>
    <script>
        $(document).ready(function(){
            var oWinH=$(window).height()+"px";
            $(".exp-r").css("height",$(window).height()+"px");
            if($(window).width()==768){
                $(".exp-l").css("min-height",$(window).height()+"px");
            };
            $(".exp-l").css("min-height",$(window).height()+"px");
        });
    </script>
</head>

<body style="background:#f1f1f1;">
<div class="wrapper">
    <div class="expdet">
        <%-- <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" style="cursor: pointer;"></span>快递详情</div> --%>
        <div class="header-public"><span class="return" onclick="history.go(-1)"  style="cursor: pointer;"></span>快递详情</div>
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
                    <div class="top-r">
                        <div class="cost">
                            <div class="costinfo">运费到付：<span>￥${businessExp.payMount}</span></div>
                            <div class="costinfo">代收金额：<span>￥${businessExp.agentMount}</span></div>
                        </div>
                    </div>
                    <div class="no-float"></div>
                    <hr class="link">
                </div>

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
</body>
</html>