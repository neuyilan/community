<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>回复</title>
<link href="${ctx }/js/activity/css/style.css" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
</head>

<body>
	<header class="header">
		<h1>回复</h1>
		<a class="a-back"></a> 
		<a class="a-searchbtn radius10 a-hf">发 送</a>
	</header>
	<div class="bl-winp hf-winp">
		<div class="bl-ninp">
			<textarea placeholder="请输入回复内容..." id="CommentStr"></textarea>
			<p class="bl-inpfont">
				还可以输入<span>280</span>个汉字
			</p>
		</div>
	</div>

	<script src="${ctx}/js/activity/js/jquery-1.7.2.min.js"></script>
	<script src="${ctx}/js/jquery.showLoading.min.js"></script>
<script>    
$(document).ready(function(){
	
	$("#CommentStr").keyup(function(){
	     var length = 280;
	     var content_len = $("#CommentStr").val().length;
	     var in_len = length-content_len;    
	     if(in_len >=0){
	         $(".bl-inpfont").html('您还可以输入'+in_len+'字');
	     }else{
	         $(".bl-inpfont").html('您还可以输入'+in_len+'字');
	        return false;
	     }
	});
	
});
</script>

</body>
</html>
