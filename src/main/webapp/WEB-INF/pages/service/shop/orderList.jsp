<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我的订单列表</title>
<link type="text/css" rel="stylesheet" href="${ctx }/js/activity/css/style.css"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<script type="text/javascript">
    //删除用户
    function jump(shopId) {
//     	alert(shopId);
		document.getElementById("frm").action='${ctx}/service/shop/myOrder.json?shopId='+shopId;
		document.getElementById("frm").submit(); 
// 		window.location.href="http://10.1.17.210/wxokjia/reg.php";
    }
    </script>
</head>
<body>
    <header class="header">
        <h1>我的快件</h1>
        <a class="a-back"></a>
    </header>
    <div class="kj-search kj-div">
    
    <form action="" id="frm" method="post" name="frm">
	   	<input type="hidden" name="userId"   id="userId" value="${userId}"/>
	   	<input type="hidden" name="estateId"   id="estateId" value="${estateId}"/>
	   	<input type="hidden" name="typeId"   id="typeId" value="${typeId}"/>
   	</form>
   	    <a href="#" onclick="javascript:jump('${bean.shopId}');" > 
            <div class="tleft kj-simg">
                <img src="${ctx }/js/activity/images/jj.jpg"/>
            </div>
            <div class="tleft">
                <span class="l-search">家教订单查询</span><span class="l-from">由师全师美提供</span>
            </div>
            <i class="tleft rightgif"></i>
        </a>
        <a href="#">
            <div class="tleft kj-simg">
                <img src="${ctx }/js/activity/images/fj.jpg"/>
            </div>
            <div class="tleft">
                <span class="l-search">机票订单查询</span><span class="l-from">由去哪网提供</span>
            </div>
            <i class="tleft rightgif"></i>
        </a>
         <a href="#">
            <div class="tleft kj-simg">
                <img src="${ctx }/js/activity/images/jd.jpg"/>
            </div>
            <div class="tleft">
                <span class="l-search">酒店订单查询</span><span class="l-from">由去哪网提供</span>
            </div>
            <i class="tleft rightgif"></i>
        </a>
         <a href="#">
            <div class="tleft kj-simg">
                <img src="${ctx }/js/activity/images/jz.jpg"/>
            </div>
            <div class="tleft">
                <span class="l-search">家政订单查询</span><span class="l-from">由云家政提供</span>
            </div>
            <i class="tleft rightgif"></i>
        </a>
    </div>
</body>
</html>
