<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/25
  Time: 13:28
  To change this template use File | Settings | File Templates.
  新闻爆料
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
	<head>
		<title>新闻爆料</title>
		<%@include file="/common/meta.jsp"%>
		<script type="text/javascript" src="<%=ctx%>/js/jquery-easyui/jquery.easyui.min.js"></script>
		<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
		<%@include file="/common/editorJs.jsp"%>
		
		<script>			
			$(function () {
				var flag = false;
			    $(document).keyup(function(event){
					  if(flag == false && event.keyCode ==13){
						  $("#submt").trigger("click");
						  $("input[name='content']").focus(); 
					      flag = true;
					  }
				});
			});
		
			$(document).ready(function(){
				$(".exp-r").css("height",parseInt($("body").height()-57)+"px");	  
				 $(".chatbox").css("height",parseInt($("body").height()- 185)+"px");
				$(".exp-l").css("min-height",$("body").height()+"px");
			});
			
			// 爆料选为置新闻
			function selectSave(breakId) {
				var bool = window.confirm("您确定要将该条爆料置为新闻？");
			    if(bool) {
			        $.post("selectSave.do", {id : breakId}, function(data) {
          			 	var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                      	alert(data.message);
			        	 window.location.reload();
			        });
			    }
			}
			
			// 保存回复
			function saveComment(breakId) {
				var content = $("input[name='content']").val().trim();
				if(content == '') {
					alert("请输入回复内容！");
				}else {
					$.post('${ctx}/business/businessBreakComment/replySave.do', {
		        		breakId: breakId,
		        		content: content,
		        		breakerId:'${businessBreak.breakerId}'
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
	<body style="background: #f1f1f1;">
		<div class="wrapper" style="overflow:visible;">
			<div class="expdet">
				<%-- <div class="header-public"><span class="return" onclick="window.location.href = '<%=ctx%>/business/businessBreak/list.do';"></span>新闻爆料</div> --%>
				<div class="header-public"><span class="return" onclick="history.go(-1)"></span>新闻爆料</div>
				<div class="exp-cont">
					<div class="exp-l">
						<div class="exp-l-top">
							<div class="top-l">
								<ul>
									<li>真实姓名：<span class="contxt">${businessBreak.realname}</span></li>
									<li>昵　　称：<span class="contxt">${businessBreak.breakerName}</span></li>
									<li>爆料时间：<span class="contxt"><time><fmt:formatDate value="${businessBreak.breakTime}" pattern="yyyy-MM-dd HH:mm"/></time></span></li>
									<li>地址信息：<span class="contxt">${businessBreak.address}</span></li>
									<li>绑定手机：<span class="contxt">${businessBreak.tel}</span></li>
								</ul>
							</div>
	
							<div class="top-r">
								<div class="cost">
									<h2 class="s-bl-xq">已被选用: <span class="s-bl-wxy">${businessBreak.selectedNum}</span></h2>
									<shiro:hasPermission name="break_select_news">
									<input id="sign" type="button"  value="选用至新闻列表" onclick="selectSave(${businessBreak.breakId})" title=" 爆料选用后，请进入新闻管理中，进行编辑后才会进行发布。"/><br>
									<em style="color:#e7402f;"> 爆料选用后，请进入新闻管理中，进行编辑后才会进行发布。</em>
									</shiro:hasPermission>
								</div>
							</div>
							
							<div class="no-float"></div>
							<hr class="link">
						</div>
						
						<div class="exp-l-bot">
               				<div class="detbox"> 
		                        <div class="s-bl-xi">
		                        	<p>${businessBreak.breakContent}</p>
		                        	<div class="s-bl-img">
		                        		<c:if test="${fn:length(businessBreakPicList)>0 && businessBreakPicList != 'null'}">
											<c:forEach items="${businessBreakPicList}" var="businessBreakPic" >
			                             		<img id="${businessBreakPic.picId}"  src="${ip}${businessBreakPic.picUrl}" style="max-width:500px; height:auto;"/>
			                        		</c:forEach>
										</c:if>
		                        	</div>
		                        	<c:if test="${fn:length(businessBreakAudioList)>0 && businessBreakAudioList != 'null'}">										
			                        	<c:forEach items="${businessBreakAudioList}" var="businessBreakAudio"   varStatus="status">
												<%-- <object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" id="MediaPlayer${status}" width="290" height="45">
														<!--是否自动播放-->
														<param name="AutoStart" value="">
														<!--播放的文件地址-->
														<param name="Filename" value="${ip}${businessBreakAudio.picUrl}" valuetype="ref">
												</object> --%>
												<script type="text/javascript">pv_q("${ip}${businessBreakAudio.picUrl}",100,32);</script>
			                        	</c:forEach>
			                        </c:if>
		                        </div>
		                        <hr class="link">
		                        <p class="s-bl-jl">选用记录：</p>
		                        <div class="s-bl-u1">
		                        	<table>
		                        	<c:forEach items="${businessBreakSelectList}" var="businessBreakSelect" varStatus="key">
		                             	<tr>
		                             		 <td><time><fmt:formatDate value="${businessBreakSelect.selectTime}" pattern="yyyy-MM-dd HH:mm"/></time></td>
		                             		 <td>选用人：${businessBreakSelect.selectorName} </td>
		                             		 <c:if test="${businessBreakSelect.newsState==0}">
			                             		 <td>|</td>
			                             		 <td>新闻：${businessBreakSelect.title}</td>
		                             		 </c:if>
		                             	</tr>
		                        	</c:forEach>
		                        	</table>
		                        </div>
	                    	</div>
		                </div>
					</div>
					
					<div class="exp-r">
						<div class="chatbox">
							<c:forEach items="${businessBreakCommentList}" var="businessBreakComment" varStatus="key">
		                    		<c:choose>
									       <c:when test="${businessBreakComment.to == 0}">
									            <div class="chat-r chat">
									            	<div class="chatcr">
														<c:choose>
													       <c:when test="${businessBreakComment.contentType == 1}">
													              <p class="chatex-r">${businessBreakComment.content}<i></i></p><%--文字--%>
													       </c:when>
													       <c:when test="${businessBreakComment.contentType == 2}">
													              <p class="chatex-r">
													              		<%-- <object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" id="MediaPlayer${businessBreakComment.commentId}" width="290" height="45">
																			<!--是否自动调整播放大小-->
																			<param name="AutoStart" value="">
																			<!--播放的文件地址-->
																			<param name="Filename" value="${ip}${businessBreakComment.content}" valuetype="ref">
																		</object> --%>
																		<script type="text/javascript">pv_q("${ip}${businessBreakComment.content}",100,32);</script>
													              		<i></i>
													              </p><%--语音--%>
													       </c:when>
														</c:choose>
													</div>
													<span class="poht"><img src="<%=ctx%>${businessBreakComment.portrait}" style="width: 100%;"></span>
												</div>
												<span class="chattime"><time><fmt:formatDate value="${businessBreakComment.commentTime}" pattern="yyyy-MM-dd HH:mm"/></time></span>
									       </c:when>
									       <c:when test="${businessBreakComment.to == 1}">
												<div class="chat-l chat">
													<span class="poht"><img src="<%=ctx%>${businessBreakComment.b_portrait}" style="width: 100%;"></span>
													<div class="chatcl">
														<h3 class="name">${businessBreakComment.b_nickname}</h3>
														<p class="chatex-l">${businessBreakComment.content}<i></i></p>
													</div>
												</div>
												<span class="chattime"><time><fmt:formatDate value="${businessBreakComment.commentTime}" pattern="yyyy-MM-dd HH:mm"/></time></span>
									       </c:when>
									</c:choose>
		                   	</c:forEach>
						</div>
						<shiro:hasPermission name="break_reply_break">
						<div class="print">
							<div style="margin-right: 85px;">
								<input id="charcont" type="text" name="content" placeholder="请输入对居民的回复内容" />
							</div>
							<input id="submt" type="button" name="" value="提交"  onclick="saveComment('${businessBreak.breakId}')"/>
						</div>
						</shiro:hasPermission>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>