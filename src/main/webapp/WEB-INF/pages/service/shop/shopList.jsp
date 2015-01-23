<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>商铺列表</title>
<link type="text/css" rel="stylesheet" href="${ctx }/js/activity/css/style.css"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<script type="text/javascript">
    //删除用户
    function jump(shopId) {
//     	alert(shopId);
		document.getElementById("frm").action='${ctx}/service/shop/enterShop.json?shopId='+shopId;
		document.getElementById("frm").submit(); 
// 		window.location.href="http://10.1.17.210/wxokjia/reg.php";
    }
    </script>
</head>

<body>
    <header class="header">
        <h1>${typeName}</h1>
        <a class="a-back"></a>
    </header>
    <div class="jz-info">
    <form action="" id="frm" method="post" name="frm">
	   	<input type="hidden" name="userId"   id="userId" value="${userId}"/>
	   	<input type="hidden" name="estateId"   id="estateId" value="${estateId}"/>
	   	<input type="hidden" name="typeId"   id="typeId" value="${typeId}"/>
   	</form>
        <ul>
        	<c:forEach items="${shopList}" var="bean" varStatus="status">
            <li>
                 <a class="xf-detail l-detail" onclick="javascript:jump('${bean.shopId}');">
                     <div class="l-img">
                         <img src="${bean.shopImg }"/> 
                     </div>
                     <div class="l-info">
                         <p class="jz-cate">
                         ${bean.shopName }
<!--                              保姆月嫂 -->
<!--                              <span><em>30</em>元/小时</span> -->
                         </p>
                         <p class="jz-intro">${bean.shopDesc }</p>
                     </div>
                     <div class="xf-right">
                         <i class="rightgif"></i>    
                     </div>
                 </a>   
            </li>
        </c:forEach>
        </ul>
    </div>
</body>
</html>
