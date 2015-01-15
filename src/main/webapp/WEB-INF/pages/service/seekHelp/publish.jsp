<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我有事说</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
</head>

<body>
    <header class="header">
        <h1>我有事说</h1>
        <a class="a-back"></a>
        <a class="a-searchbtn radius10 a-hf">发 送</a>
    </header>
    <div class="bl-winp hf-winp">
        <div class="bl-ninp">
            <textarea placeholder="请输入回复内容..."></textarea>
            <p class="bl-inpfont">还可以输入<span>280</span>个汉字</p>
        </div>
    </div>
    <div class="kl-select">
        <p class="kl-spread">
            <label><input class="kl-check" type="checkbox" checked/></label>
            <img src="images/select.png"/>
            <span class="kl-spanf">求扩散</span>
            <span class="kl-spans">扩大发布范围</span>
        </p>
        <p class="kl-anonymous">
           <label><input class="kl-check" type="checkbox"/></label>
           <img src="images/nosel.png"/>
           <span class="kl-spanf">匿名</span>
        </p>
    </div>
        <div class="bl-pz">
        <ul class="clearfix">
            <li>
                <div class="bl-photo">
                    <img src="images/pz1.png"/>
                    <a></a>
                </div>
            </li>
            <li>
                <div class="bl-photo">
                    <img src="images/pz2.png"/>
                    <a></a>
                </div>
            </li>
            <li>
                <div class="bl-photo">
                    <img src="images/pz3.jpg"/>
                    <a></a>
                </div>
            </li>
             <li>
                <div class="bl-photo">
                    <img src="images/pz1.png"/>
                    <a></a>
                </div>
            </li>
            <li>
                <div class="bl-photo">
                    <img src="images/pz2.png"/>
                    <a></a>
                </div>
            </li>
            <li>
                <div class="bl-photo">
                    <img src="images/pz3.jpg"/>
                    <a></a>
                </div>
            </li>
        </ul> 
        <div class="bl-cam">
            <a></a>
        </div> 
    </div>
    <script src="js/jquery-2.1.1.min.js"></script>
    <script>
        $(document).ready(function(e) {
            $(".kl-check").click(function(e) {
				if($(this).attr("checked")){
                    $(this).parent().next("img").attr("src","images/nosel.png");
					$(this).removeAttr("checked");
				}
				else{
				    $(this).parent().next("img").attr("src","images/select.png");
					$(this).attr("checked","checked");
				}
            });
        });
    </script>
</body>
</html>