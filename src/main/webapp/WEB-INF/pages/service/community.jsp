<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>社区小区选择</title>
<link type="text/css" rel="stylesheet" href="${ctx }/css/loginStyle.css"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
</head>

<body class="bgf">
    <div class="commsel">
        <div class="commfin">
        	<form method="post" action="${ctx}/service/estate/searchIndex.json" id="f">
	            <p class="selq">
	                <a id="search"></a>
	                <input type="hidden"  name="type" value="${type }"/>
	                <input type="hidden"  name="ID" value="${ID }"/>
	                <span><input type="text" placeholder="输入社区关键字进行查找" name="keyword"/></span>
	            </p>  
            </form>
        </div> 
        <section class="selcont">
            <h1>根据您选择的所在小区，您可随时接收小区周边发生的最新动态信息。</h1>
            <div class="selcon radius6">
                <ul>
                	<c:forEach items="${list}" var="businessCommunity" varStatus="status">
                		<li comId="${businessCommunity.comId }" >
	                        <span>${businessCommunity.comName }</span>
	                        <a>${businessCommunity.countyName }<i></i></a>
                   		 </li>
                	</c:forEach>
                </ul>        
            </div>
        </section>
    </div>
    <footer><a  id="return"></a></footer>
<script type="text/javascript">
$(function(){
	$("#return").click(function(){
		window.history.go(-1);
	});
	$("ul li").click(function(){
		window.location.href='${ctx}/service/commiunity/findByComIndex.json?comId='+$(this).attr("comId")+'&type=${type}&ID=${ID}';
	})
	$("#search").click(function(){
		$("#f").submit();
	})
})
function msgbox(title,content){
	 var shtml="<div class='tk'><div class='tcontent'><div class='thead'>";
	 shtml+="<p>"+content+"</p>";
	 shtml +="</div>";
	  shtml += "<div class='tbtn'><p>确定</p></div>";
	 shtml += "</div>";
	 $("body").append(shtml);
	 $(".tbtn p").click(function(e) {
		    $(".tk").remove();
	});
}
</script>
</body>
</html>
