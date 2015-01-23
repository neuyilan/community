<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>商铺iframe页</title>
<link type="text/css" rel="stylesheet" href="${ctx }/js/activity/css/style.css"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
</head>
<body onLoad="iframeload()">
    <header class="header">
        <h1>必有我师</h1>
        <a class="a-back" onclick="history.go(-1)"></a>
    </header>
    <iframe id="myframe" src ="${shopURL}" frameborder="0" width="100%">
      <p>Your browser does not support iframes.</p>
    </iframe>
    <script  type="text/javascript">
    var frameh;
    if (document.compatMode == "BackCompat") {
        frameh = document.body.clientHeight-45;
    }
    else {
        frameh = document.documentElement.clientHeight-45;	
    }
    /*设置iframe高度*/
    function iframeload(){
        document.getElementById('myframe').height=frameh;
    }
    </script>
</body>
</html>
