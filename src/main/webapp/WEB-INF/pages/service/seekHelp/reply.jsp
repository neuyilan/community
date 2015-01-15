<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>回复</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
</head>

<body>
    <header class="header">
        <h1>回复</h1>
        <a class="a-back"></a>
        <a class="a-searchbtn radius10 a-hf">发 送</a>
    </header>
    <div class="bl-winp hf-winp">
        <div class="bl-ninp">
            <textarea placeholder="请输入回复内容..."></textarea>
            <p class="bl-inpfont">还可以输入<span>280</span>个汉字</p>
        </div>
    </div>
</body>
</html>
