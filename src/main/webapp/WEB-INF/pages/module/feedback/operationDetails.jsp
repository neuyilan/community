<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/17
  Time: 14:33
  To change this template use File | Settings | File Templates.
  报修详情
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>建议投诉详情</title>
    <%@include file="/common/meta.jsp"%>
    <script type="text/javascript" src="<%=ctx%>/js/jquery.easyui.min.js"></script>
    <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
    <script>
	    $(document).ready(function(){
			$(".exp-r").css("height",parseInt($("body").height()-57)+"px");	  
			 $(".chatbox").css("height",parseInt($("body").height()- 185)+"px");
			$(".exp-l").css("min-height",$("body").height()+"px");
		});

	    $(function () {
	    	var flag = false;
		    $(document).keyup(function(event){
				  if(flag == false && event.keyCode ==13){
					  $("#submt").trigger("click");
				    flag = true;
				  }
			});
		});
	    
      //提交表单
        function saveComment(feedbackId) {
        	var fberId = $("input[name='fberId']").val().trim();
        	var fbState = $("input[name='fbState']").val().trim();
        	var fbType = $("input[name='fbType']").val().trim();
        	var comment = $("input[name='comment']").val().trim();
			if(comment == '') {
				alert("请输入建议投诉内容！");
        	} else {
                $.post('${ctx}/business/businessFeedbackComment/save.do', {
                	feedbackId: feedbackId,
                	fberId: fberId,
                	fbState: fbState,
                	fbType: fbType,
	        		comment: comment
	        		}, 
	        		function(data) {
          			 	var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                      	alert(data.message);
	                	window.location.reload();
	            });  
        	}
        }
        
        //处理问题
        function deal(id, fbState,fbType,fberId) {
            $.post('update.do', {feedbackId: id, fbState: fbState,fbType:fbType,fberId:fberId}, function(data) {
            	eval("data = "+data);
                alert(data.message);
                window.location.reload();
            });
        }
    </script>
</head>
<body style="background:#f1f1f1;">

<div class="wrapper" style="overflow:visible;">
    <%-- <form action="${ctx}/business/businessFeedbackComment/save.do" method="post" id="ff"> --%>
        <div class="expdet">
            <div class="header-public"><span class="return" onclick="history.go(-1)"></span>建议投诉详情</div>
            <div class="exp-cont">
                <div class="exp-l">
                    <div class="exp-l-top">
                        <div class="top-l">
                            <ul>
                                <li>真实姓名：<span class="contxt">${userVO.realname}</span></li>
                                <li>昵　　称：<span class="contxt">${userVO.nickname}</span></li>
                                <li>电　　话：<span class="contxt">${userVO.tel}</span></li>
                                <li>地　　址：<span class="contxt">${userVO.estateName}${userVO.buildingName}${userVO.houseNo}</span></li>
                                <li>反馈时间：<span class="contxt"><fmt:formatDate value="${obj.fbTime }" pattern="yyyy-MM-dd HH:mm"/></span></li>
                            </ul>
                        </div>
                        <div class="top-r">
                            <div class="cost">
                                <%--如果类型为物业投诉 0--%>
                                <c:if test="${obj.fbType == 0}">
                                    <c:choose>
                                        <c:when test="${obj.fbState == 3 || obj.fbState == 4}">
                                            <input id="sign" style="cursor:default; background-color:#ccc;" type="button" value="处理完成" />
                                        </c:when>
                                        <c:otherwise>
                                        	<shiro:hasPermission name="operation_feedback_finish_feedback">
                                            <input id="sign" type="button"  value="已处理" onclick="deal('${obj.feedbackId}','4','${obj.fbType}','${obj.fberId}');"/>
                                        	</shiro:hasPermission>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                                <c:if test="${obj.fbType == 4}">
                                    <c:choose>
                                        <c:when test="${obj.fbState == 3  || obj.fbState == 4}">
                                            <input id="sign" style="cursor:default; background-color:#ccc;" type="button" value="处理完成" />
                                        </c:when>
                                        <c:otherwise>
                                        	<shiro:hasPermission name="operation_feedback_finish_feedback">
                                            <input id="sign" type="button"  value="已处理" onclick="deal('${obj.feedbackId}','4','${obj.fbType}','${obj.fberId}');"/>
                                       		</shiro:hasPermission>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
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
                                            <c:when test="${obj.fbType == 0}">
                                                		物业投诉
                                            </c:when>
                                            <c:when test="${obj.fbType == 1}">
										              	物业建议
										       </c:when>
										       <c:when test="${obj.fbType == 2}">
										              	使用反馈
										       </c:when>
										       <c:when test="${obj.fbType == 3}">
										              	驿站建议
										       </c:when>
										       <c:when test="${obj.fbType == 4}">
										              快递投诉
										       </c:when>
                                    </c:choose>】
                                    </span>
		                        	<p>${fn:replace(obj.fbContent, '\\r\\n', '<br />')}</p>
		                        	<div class="s-bl-img">
											<c:if test="${fn:length(obj.pics)>0 &&obj.pics != 'null'  && obj.audios != ''}">
				                        		<c:set value="${ fn:split(obj.pics, ',') }" var="pics" />
												<c:forEach items="${pics}" var="pic">
												 	<img src="${ctx}${pic}" style="max-width:500px; height:auto;"/><br />
												</c:forEach>
											</c:if>
											<c:if test="${fn:length(obj.audios)>0  && obj.audios != 'null' && obj.audios != ''}">
				                        		<c:set value="${ fn:split(obj.audios, ',') }" var="audios" />
												<c:forEach items="${audios}" var="audio"  varStatus="status">
												 	<%-- <object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" id="MediaPlayer${status}" width="290" height="45">
												 		<!--是否自动播放-->
														<param name="AutoStart" value="">
														<!--播放的文件地址-->
														<param name="Filename" value="${ctx}${audio}" valuetype="ref">
													</object> --%>
													<script type="text/javascript">pv_q("${ctx}${audio}",100,32);</script>
												</c:forEach>
											</c:if>
		                        	</div>
		                        </div>
	                    	</div>
		                </div>
                </div>
				
				<div class="exp-r">
					<div class="chatbox">
						<c:forEach items="${list}" var="list">
                            <c:choose>
                                <c:when test="${list.commentorId == userVO.userId}">  <%--判断是否为用户， 如果报修用户与留言用户为同一个人，那么样式在右侧--%>
                                    <div class="chat-r chat"> <%--右侧为用户留言--%>
                                        <div class="chatcr">
                                        	<c:choose>
										       <c:when test="${list.contentType == 3 || list.contentType == 4}">
									       		  <c:choose>
									              		<c:when test="${list.comment == '0.0'}">
									              			<p class="chatex-r">未评价星级<i></i></p>
									              		</c:when>
									              		<c:otherwise>
									              			<p class="chatex-r"><img src="<%=ctx %>/images/icon/score0<fmt:formatNumber type="number" value="${list.comment}" maxFractionDigits="0"/>.png"  /><i></i></p><%--星级--%>
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
																<param name="Filename" value="${ctx}${list.comment}" valuetype="ref">
															</object> --%>
															<script type="text/javascript">pv_q("${ctx}${list.comment}",100,32);</script>
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
                    <shiro:hasPermission name="operation_feedback_publish_feedback">
                    <div class="print">
        				<input type="hidden" value="${obj.fbState}" name="fbState">
        				<input type="hidden" value="${obj.fberId}" name="fberId">
        				<input type="hidden" value="${obj.fbType}" name="fbType">
                    	<div style="margin-right: 107px;">
                        	<input id="charcont" type="text" name="comment" placeholder="请输入对居民的回复内容" />
                    	</div>
                    	<input id="submt" type="button" value="提交" onclick="saveComment('${obj.feedbackId}')"/>
                    </div>
                    </shiro:hasPermission>
                </div>
					</div>
					<%-- <div class="print">
						
        				<div style="margin-right: 107px;">
							<input id="charcont" type="text" name="comment" placeholder="请输入对居民的回复内容" />
						</div>
						<input id="submt" type="button" name="" value="提交"  onclick="submitForm('ff');"/>
					</div> --%>
				</div>
            </div>
        </div>
    <!-- </form> -->
</div>
</body>
</html>