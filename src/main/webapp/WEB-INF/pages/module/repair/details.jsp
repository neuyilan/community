<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/17
  Time: 14:33
  To change this template use File | Settings | File Templates.
  报修详情
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报修详情</title>
    <%@include file="/common/meta.jsp"%>
    <script type="text/javascript" src="<%=ctx%>/js/jquery.easyui.min.js"></script>
    <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
    <script>
	    $(function () {
	    	var flag = false;
		    $(document).keyup(function(event){
				  if(flag == false && event.keyCode ==13){
					  $("#submt").trigger("click");
				    flag = true;
				  }
			});
		});
    
	    $(document).ready(function(){
			$(".exp-r").css("height",parseInt($("body").height()-57)+"px");	  
			 $(".chatbox").css("height",parseInt($("body").height()- 185)+"px");
			$(".exp-l").css("min-height",$("body").height()+"px");
		});
    
        //维修完成
        function repairFinish(repairId,reporterId) {
            $.post('${ctx}/business/businessRepair/repairFinish.do', {repairId : repairId,reporterId:reporterId}, function(data) {
            	eval("data = "+data);
                if(data.success) {
                    alert(data.message);
                    window.location.reload();
                } else {
                    alert(data.message);
                }
            });
        }
        
        //提交表单
        function saveComment(repairId) {
        	var reporterId = $("input[name='reporterId']").val().trim();
        	var repairState = $("input[name='repairState']").val().trim();
        	var comment = $("input[name='comment']").val().trim();
			if(comment == '') {
				alert("请输入报修内容！");
        	} else {
                $.post('${ctx}/business/businessRepairComment/save.do', {
                	repairId: repairId,
                	reporterId: reporterId,
                	repairState: repairState,
	        		comment: comment
	        		}, 
	        		function(data) {
          			 	var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                      	alert(data.message);
	                	window.location.reload();
	            });  
        	}
        }
    </script>
</head>
<body style="background:#f1f1f1;">

<div class="wrapper" style="overflow:visible;">
        <div class="expdet">
            <div class="header-public"><span class="return" onclick="history.go(-1)"></span>物业报修详情</div>
            <div class="exp-cont">
                <div class="exp-l">
                    <div class="exp-l-top">
                        <div class="top-l">
                            <ul>
                                <li>真实姓名：<span class="contxt">${userVO.realname}</span></li>
                                <li>昵　　称：<span class="contxt">${userVO.nickname}</span></li>
                                <li>电　　话：<span class="contxt">${userVO.tel}</span></li>
                                <li>地　　址：<span class="contxt">${userVO.estateName}${userVO.buildingName}${userVO.houseNo}</span></li>
                                <li>报修时间：<span class="contxt"><fmt:formatDate value="${obj.repairTime }" pattern="yyyy-MM-dd HH:mm"/></span></li>
                            </ul>
                        </div>
                        <div class="top-r">
                        	
                            <div class="cost">
                                <c:choose>
                                    <c:when test="${obj.repairState == '3' || obj.repairState == '4'}">
                                        <input id="sign" style="cursor:default; background-color:#ccc;" type="button"  type="button" value="已维修" />
                                    </c:when>
                                    <c:otherwise>
                                    	<shiro:hasPermission name="repair_finish_repair">
                                        	<input id="sign" type="button"  value="维修完成" onclick="repairFinish('${obj.repairId}','${obj.reporterId}');"/>
                                    	</shiro:hasPermission>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            
                        </div>
                        <div class="no-float"></div>
                        <hr class="link">
                    </div>
                  	
                    <div class="exp-l-bot">
               				<div class="detbox"> 
		                        <div class="s-bl-xi">
		                        	<span style="color:#f00; font-size:21px; margin-bottom:10px;">
		                        		【<c:choose>
										       <c:when test="${obj.typeId == 1}">
										              	小修
										       </c:when>
										       <c:when test="${obj.typeId == 2}">
										              	大修
										       </c:when>
										       <c:when test="${obj.typeId == 3}">
										              	急修
										      </c:when>
										</c:choose>】
		                        	</span>
		                        	<p>${fn:replace(obj.repairContent, '\\r\\n', '<br />')}</p>
		                        	<div class="s-bl-img">
											<c:if test="${fn:length(obj.pics)>0 &&obj.pics != 'null'  && obj.audios != ''}">
				                        		<c:set value="${ fn:split(obj.pics, ',') }" var="pics" />
												<c:forEach items="${pics}" var="pic">
												 	<img  src="${ip}${pic}" style="max-width:500px; height:auto;"/><br />
												</c:forEach>
											</c:if>
											
											<c:if test="${fn:length(obj.audios)>0  && obj.audios != 'null' && obj.audios != ''}">
				                        		<c:set value="${ fn:split(obj.audios, ',') }" var="audios" />
												<c:forEach items="${audios}" var="audio" varStatus="status">
												 	<%-- <object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" id="MediaPlayer${status}" width="290" height="45">
														<!--是否自动播放-->
														<param name="AutoStart" value="">
														<!--播放的文件地址-->
														<param name="Filename" value="${ip}${audio}" valuetype="ref">
													</object> --%>
													<script type="text/javascript">pv_q("${ip}${audio}",100,32);</script>
												</c:forEach>
											</c:if>
		                        	</div>
		                        </div>
	                    	</div>
		           </div>
                </div>
                <div class="exp-r">
                    <div class="chatbox">
                        <c:forEach items="${replyList}" var="list">
                            <c:choose>
                                <c:when test="${list.commentorId == userVO.userId}">  <%--判断是否为用户， 如果报修用户与留言用户为同一个人，那么样式在右侧--%>
                                    <div class="chat-r chat">
                                    	<div class="chatcr">
                                        	<c:choose>
										       <c:when test="${list.contentType == 3 || list.contentType == 4}">
										              <p class="chatex-r">
										              	<c:choose>
										              		<c:when test="${list.comment == '0.0'}">
										              			未评价星级
										              		</c:when>
										              		<c:otherwise>
										              			<img src="<%=ctx %>/images/icon/score0<fmt:formatNumber type="number" value="${list.comment}" maxFractionDigits="0"/>.png"  /><i></i></p><%--星级--%>
										              		</c:otherwise>
										              	</c:choose>
										       </c:when>
										       <c:when test="${list.contentType == 1}">
										              <p class="chatex-r">${list.comment}<i></i></p><%--文字--%>
										       </c:when>
										       <c:when test="${list.contentType == 2}">
										              <p class="chatex-r">
										              		<%-- <object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" id="MediaPlayer${list.commentId}" width="290" height="45">
																<!--是否自动调整播放大小-->
																<param name="AutoStart" value="">
																<!--播放的文件地址-->
																<param name="Filename" value="${ip}${list.comment}" valuetype="ref">
															</object> --%>
															<script type="text/javascript">pv_q("${ip}${list.comment}",100,32);</script>
										              		<i></i>
										              </p><%--语音--%>
										       </c:when>
											</c:choose>
                                        </div>
                                        <span class="poht"><img src="${ctx}${list.portrait}" style="width:100%;"></span><%--头像--%>
                                    </div>
                                    <span class="chattime"><time><fmt:formatDate value="${list.commentTime}" pattern="yyyy-MM-dd HH:mm"/></time></span>
                                </c:when>
                                <c:otherwise>
                                    <div class="chat-l chat"> <%--左侧--%>
                                        <span class="poht"><img src="${ctx}${list.b_portrait}" style="width:100%;"></span><%--头像--%>
                                        <div class="chatcl">
	                                        <h3 class="name">${list.b_nickname}</h3><%--用户--%>
	                                        <p class="chatex-l">${list.comment}<i></i></p><%--留言--%>
                                    	</div>
                                    </div>
                                    <span class="chattime"><time><fmt:formatDate value="${list.commentTime}" pattern="yyyy-MM-dd HH:mm"/></time></span>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                    <shiro:hasPermission name="repair_publish_comment">
                    <div class="print">
                        <div style="margin-right: 85px;"><input id="charcont" type="text" name="comment" placeholder="请输入对居民的回复内容" /></div>
				        <input type="hidden" value="${obj.reporterId}" name="reporterId">
				        <input type="hidden" value="${obj.repairState}" name="repairState">
                        <input id="submt" type="button" value="提交" onclick="saveComment('${obj.repairId}')"/>
                    </div>
                    </shiro:hasPermission>
                </div>
            </div>
        </div><%-- 
        <input type="hidden" value="${obj.repairId}" name="repairId">
         <input type="hidden" value="${obj.reporterId}" name="reporterId">
         <input type="hidden" value="${obj.repairState}" name="repairState"> --%>
</div>
</body>
</html>