<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<title>排名列表</title>
<link href="${ctx }/js/activity/css/activityRegistrationStyle.css" rel="stylesheet" type="text/css" />
</head>

<body  class="sortb">
<c:choose>
      <c:when test="${businessActivityParticipate.rank <= ranks}">
      	<p class="sortdes">
		    您当前排名第<span>${businessActivityParticipate.rank}</span>位，恭喜您获得今天的奖品，请于次日尽快去您所属的驿站领取！
		</p>
      </c:when>
      <c:when test="${businessActivityParticipate.rank > ranks}">
      	<p class="sortdes">
		    您当前排名第<span>${businessActivityParticipate.rank}</span>位，未能获得今天的奖品，不要放弃哦！还有更多的奖品等着你哟！
		</p>
      </c:when>
      <c:when test="${businessActivityParticipate == null}">
      	<p class="sortdes">
		   看别人抢的东西是没有用的！天天关注我们发布的活动，更多的<span>惊喜奖品</span>等你拿！
		</p>
      </c:when>
</c:choose>
	<section class="sort">
    	<ul>
            <li class="s-tit">
            	<em>排名</em>
                <span>会员名称</span>
                <time>出手时间</time>
            </li>
            
            <c:forEach items="${list}" var="query" >
            	<c:choose>
			       <c:when test="${query.rank <= ranks}">
			       		<c:choose>
				       		<c:when test="${query.userId != userId}">
					            <li>
					            	<em class="s-whi winrank">NO.${query.rank}</em>
					                <span class="winname">${query.userName}</span>
					                <time><fmt:formatDate value="${query.joinTime}" pattern="HH:mm:ss"/></time>
					            </li>
					        </c:when>
					        <c:when test="${query.userId == userId}">
					          	<li class="s-active">
					            	<em class="s-whi winrank" style="background:none"><img src="${protrait}"/></em>
					                <span class="winname">${query.userName}</span>
					                <time><fmt:formatDate value="${query.joinTime}" pattern="HH:mm:ss"/></time>
					            </li>
					       </c:when>
			            </c:choose>
			       </c:when>
			       <c:when test="${query.rank > ranks}">
		          	<c:choose>
				       		<c:when test="${query.userId != userId}">
					            <li>
					            	<em <c:if test="${query.rank <= 3}">class="s-whi winrank"</c:if>>NO.${query.rank}</em>
					                <span>${query.userName}</span>
					                <time><fmt:formatDate value="${query.joinTime}" pattern="HH:mm:ss"/></time>
					            </li>
					        </c:when>
					        <c:when test="${query.userId == userId}">
					          	<li class="s-active">
					            	<em <c:if test="${query.rank <= 3}">class="s-whi winrank"</c:if>><img src="${protrait}"/></em>
					                <span>${query.userName}</span>
					                <time><fmt:formatDate value="${query.joinTime}" pattern="HH:mm:ss"/></time>
					            </li>
					       </c:when>
			            </c:choose>
			       </c:when>
				</c:choose>
	           
    		</c:forEach>
        </ul>
    </section>
</div>
</body>
</html>
