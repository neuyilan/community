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
	<div class="mineinfo">
        <div class="mineinfon">
         	<p>活动时间：<span>${time}:00</span></p>
			 <c:forEach items="${list}" var="businessActivityRegistrationInformation" >
				<c:if test="${!empty businessActivityRegistrationInformation.nickname}">
					<p>昵称：<span>${businessActivityRegistrationInformation.nickname}</span></p>
				</c:if>
				<c:if test="${!empty businessActivityRegistrationInformation.realname}">
					<p>真实姓名：<span>${businessActivityRegistrationInformation.realname}</span></p>
				</c:if>
				<c:if test="${!empty businessActivityRegistrationInformation.tel}">
					<p>联系电话：<span>${businessActivityRegistrationInformation.tel}</span></p>
				</c:if>
				<c:if test="${!empty businessActivityRegistrationInformation.birthday}">
					<p>生日：<span>${businessActivityRegistrationInformation.birthday}</span></p>
				</c:if>
				<c:if test="${!empty businessActivityRegistrationInformation.age}">
					<p>年龄：<span>${businessActivityRegistrationInformation.age}</span></p>
				</c:if>
				<c:if test="${!empty businessActivityRegistrationInformation.job}">
					<p>职业：<span>${businessActivityRegistrationInformation.job}</span></p>
				</c:if>
				<c:if test="${!empty businessActivityRegistrationInformation.ID}">
					<p>身份证：<span>${businessActivityRegistrationInformation.ID}</span></p>
				</c:if>
				<c:if test="${!empty businessActivityRegistrationInformation.email}">
					<p>邮箱：<span>${businessActivityRegistrationInformation.email}</span></p>
				</c:if>
				<c:if test="${!empty businessActivityRegistrationInformation.addr}">
					<p>地址：<span>${businessActivityRegistrationInformation.addr}</span></p>
				</c:if>
			 </c:forEach>	
        </div>
    </div>
</body>
</html>
