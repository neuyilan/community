<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/18
  Time: 10:26
  To change this template use File | Settings | File Templates.
  居民沟通
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>居民沟通</title>
    <%@include file="/common/meta.jsp"%>
    <script type="text/javascript" src="<%=ctx%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        function submitform(id) {
            $('#'+id).form('submit', {
                success:function(data){
                    location.reload();
                }
            });
        }

    </script>
</head>
<body style="background:#f1f1f1;">
<form id="ff" action="${ctx}/business/businessUserPropertyCom/save.do" method="post">
    <div class="wrapper">
        <div class="expdet">
            <div class="header-public"><span class="return" onclick="history.go(-1)"></span>居民沟通</div>
            <div class="exp-cont_1">
                <div class="exp-l_1">
                    <div class="exp-l-top">
                        <div class="top-l">
                            <ul>
                                <li>居民级别：<span class="contxt">${data.type == 0 ? '注册用户' : '验证用户'}</span></li>
                                <li>电话：<span class="contxt">${data.tel}</span></li>
                                <li>姓名：<span class="contxt">${data.realname}</span></li>
                                <li>地址：<span class="contxt">${data.estateName}${data.buildingName}${data.unitName}${data.houseNo}</span></li>
                                <li>昵称：<span class="contxt">${data.nickname}</span></li>
                            </ul>
                        </div>
                        <div class="top-r">
                        </div>
                        <div class="no-float"></div>
                    </div>
                    <hr class="jmgt_link">
                    <div class="no-float"></div>
                </div>
                <div class="exp-r_1">
                    <div class="chatbox">
                        <c:forEach items="${list}" var="chat">
                            <c:choose>
                                <c:when test="${chat.direction == 0}"> <%--居民发给管理员--%>
                                    <div class="chat-l chat">
                                </c:when>
                                <c:otherwise>
                                    <div class="chat-r chat">
                                </c:otherwise>
                            </c:choose>
                        <span class="poht">
                            <c:choose>
                                <c:when test="${chat.direction == 0}"> <%--居民发给管理员--%>
                                    <img src="${data.portrait}" style="width:100%;"><%--居民头像--%>
                                </c:when>
                                <c:otherwise>
                                    <img src="${worker.avatar}" style="width:100%;"><%--头像--%>
                                </c:otherwise>
                            </c:choose>
                        </span>
                                <h3 class="name">${chat.userName}</h3><br/><%--真实姓名--%>
                                <c:choose>
                                    <c:when test="${chat.direction == 0}"> <%--居民发给管理员--%>
                                        <p class="chatex-l">
                                                ${chat.content}<i></i> <%--内容--%>
                                        </p>
                                    </c:when>
                                    <c:otherwise>
                                        <p class="chatex-r">
                                                ${chat.content}<i></i> <%--内容--%>
                                        </p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            </c:forEach>
                        </div>
                        <div class="print">
                            <input id="charcont" name="content" type="text" placeholder="请输入20字以内"/>
                            <input id="submt" type="button" value="提交" onclick="submitform('ff');"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" name="userId" value="${data.userId}"/>
        <input type="hidden" name="userName" value="${data.realname}"/>
</form>

</body>
</html>
