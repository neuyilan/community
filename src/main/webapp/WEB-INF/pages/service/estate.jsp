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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
</head>

<body class="bgf">
	<form method="post" action="${ctx}/service/user/cellphone.json" id="ff">
		<input type="hidden" name="estateId" id="estateId">
		<input type="hidden" name="estateName" id="estateName">
		<input type="hidden" name="comName" id="comName">
		<input type="hidden"  name="type" value="${type }"/>
	    <input type="hidden"  name="ID" value="${ID }"/>
    </form> 
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
        <section class="selcont selxq">
            <h1>请选择您所在的小区</h1>
            <div class="selcon radius6">
                <ul>
                	<c:forEach items="${list}" var="manageEstate" varStatus="status">
                   		 <li estateId="${manageEstate.estateId }" estateName="${manageEstate.estateName }" comName="${manageEstate.comName }">
	                        <span>${manageEstate.estateName }</span>
	                        <a><i></i></a>
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
		$("#estateId").val($(this).attr("estateId"));
		$("#estateName").val($(this).attr("estateName"));
		$("#comName").val($(this).attr("comName"));
		$("#ff").submit();
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
