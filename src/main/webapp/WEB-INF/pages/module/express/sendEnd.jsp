<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>已发送</title>
<%@include file="/common/meta.jsp"%>
<script>
	$(document).ready(function() {
		//var oWinH = $(window).height() + "px";
		$(".exp-r").css("height", $(window).height() + "px");
		if ($(window).width() == 768) {
			$(".exp-l").css("min-height", $(window).height() + "px");
		};
		$(".exp-l").css("min-height", $(window).height() + "px");
	});
	function sendWrite() {
		window.location.href = '${ctx}/business/businessExp/getSendWrite.do?expId=${businessExp.expId}&expState=${businessExp.expState}';
	}
</script>
</head>

<body style="background: #f1f1f1;">
	<div class="wrapper nohidden">
		<div class="expdet">
			<%-- <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" style="cursor: pointer;"></span>快递详情</div> --%>
			<div class="header-public">
				<span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" 
					style="cursor: pointer;"></span>快递详情
			</div>

			<div class="exp-cont">
				<div class="exp-l  y-kd-nor">
					<div class="exp-l-top">
						<div class="top-l">
							<ul>
								<li>快递公司：<span class="contxt">${businessExp.expCompany}快递</span></li>
								<li>快递单号：<span class="contxt">${businessExp.expCode}</span></li>
								<li>收&nbsp;&nbsp;货&nbsp;&nbsp;人：<span class="contxt">${businessExp.receiverName}</span></li>
								<li>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<span class="contxt">${businessExp.receiverTel}</span></li>
								<li>收件地址：<span class="contxt">${businessExp.receiverAddr}</span></li>
							</ul>
						</div>

						<div class="top-r">
							<div class="cost">
								<div class="costinfo">
									运费金额：<span>￥<c:choose>
											<c:when test="${businessExp.payMount =='0.0'}">0</c:when>
											<c:otherwise>${businessExp.payMount}</c:otherwise>
										</c:choose></span>
								</div>
								<div class="costinfo">
									到付<span></span>
								</div>
							</div>
						</div>
						<div class="y-kd-btnd">
							<input class="y-kd-btn" type="button" name="" value="修改发件信息"
								onclick="sendWrite();" />
						</div>
						<div class="no-float"></div>
						<hr class="link">
					</div>
					
					<div class="exp-l-bot">
						<div class="detbox">
							<ul class="detinfo">
								<c:forEach items="${resolveList }" var="resolve" varStatus="key">
									<li><span> <fmt:formatDate
												value="${resolve.resolveTime }" pattern="yyyy-MM-dd" /><br />
											<fmt:formatDate value="${resolve.resolveTime }"
												pattern="HH:mm" />
									</span> <c:if test="${key.index == 0 }">
											<span id="y-kd-hq" class="cirbag"></span>
										</c:if> <c:if test="${key.index != 0 }">
											<span class="cir"></span>
										</c:if> <c:if test="${key.index < fn:length(resolveList)-1}">
											<i class="link"></i>
										</c:if> <span class="stainfo"> <c:choose>
												<c:when test="${resolve.type == 1}">
													<object
														classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95"
														id="MediaPlayer${status}" width="290" height="45">
														<!--是否自动播放-->
														<param name="AutoStart" value="">
														<!--播放的文件地址-->
														<param name="Filename" value="${ip}${resolve.resolveMemo}"
															valuetype="ref">
													</object>
												</c:when>
												<c:otherwise>
												${fn:replace(resolve.resolveMemo, '\\r\\n', '<br />')}
										</c:otherwise>
											</c:choose>
									</span></li>
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