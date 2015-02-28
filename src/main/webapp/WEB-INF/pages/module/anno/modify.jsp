<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/15
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title></title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
    <script type="text/javascript" src="<%=ctx%>/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
    <script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
    <script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
    <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    <style type="text/css">
        label.error
        {
            color:Red;
            font-size:13px;
            margin-left:5px;
            padding-left:16px;
        }
    </style>
    <script type="text/javascript">
        $(function() {
            $( "#remindTime" ).datepicker();

            var accordion_head = $('.accordion2 > li > a'),
                    accordion_body = $('.accordion2 li > .sub-menu');
            accordion_head.first().addClass('active').next().slideDown('normal');
            accordion_head.on('click', function(event) {
                event.preventDefault();
                if ($(this).attr('class') != 'active'){
                    accordion_body.slideUp('normal');
                    $(this).next().stop(true,true).slideToggle('normal');
                    accordion_head.removeClass('active');
                    $(this).addClass('active');
                }
            });


            //------------------------------------------------------
            $(".icon").click(function(){

                var i= $(".icon").index($(this));

                if($(this).hasClass("add")){
                    $(this).removeClass("add").addClass("add2");
                    $(".accordion2 ul").eq(i).show();
                }else{
                    $(this).removeClass("add2").addClass("add");
                    $(".accordion2 ul").eq(i).hide();

                }

            });

            $(".sub-menu2 li").click(function(){
                //alert("ok")
                var i= $(".sub-menu2 li span").index($(this));
                $("li a span").addClass("gou2")
                $("li a span").removeClass("gou")
                $(this).children().children().addClass("gou")

                $(this).children().children().removeClass("gou2")

            });
        });
        function setDDTime() {
            //日期选择表单
            $( "#dateDialog").dialog({
                autoOpen: false,
                height: 300,
                width: 500,
                modal: true,
                buttons: {
                    "确定": function() {

                    },
                    "取消": function() {
                        $( this ).dialog( "close" );
                    }
                },
                close: function() {
                }
            });

            //弹出时间范围选择框
            $( "#dateDialog" ).dialog( "open" );
        }
    </script>
</head>
<body class="bagcolr">
<form:form  id="ff"  modelAttribute="businessAnno" action="${ctx}/business/businessAnno/update.do" method="post">
    <div class="wrapper wranews">
        <div class="newsrel">
            <div class="header-public"><span class="return" onclick="history.go(-1)"></span>公告发布</div>
            <div class="cont-l">
                <h2 class="title">公告标题</h2>
                <form:input path="annoTitle" class="iptnewtit" type="text" placeholder='请输入公告标题20字以内' />
                <h2 class="relran">公告范围</h2>
                <span class="ranbut radiusbox" id="showScopeLayer">点击选择范围</span>
                <input type="hidden" id="scope" name="scope" value="" />
                <span id="scopeShow"></span>
                <h2 class="relran">公告类型</h2>
                <span class="ranbut radiusbox" id="block2">点击选择类型</span>
                <h2 class="newscont">公告内容</h2>
                    <%--<textarea class="newtext2" placeholder="" name="annoContent"></textarea>
                    <div class="top_1"><img src="${ctx}/images/icon/icon_1.jpg" width="30" height="30"><img src="${ctx}/images/icon/icon_2.jpg" width="30" height="30"><img src="${ctx}/images/icon/icon_3.jpg" width="30" height="30"><img src="${ctx}/images/icon/icon_4.jpg" width="30" height="30"><img src="${ctx}/images/icon/icon_5.jpg" width="30" height="30"><img src="${ctx}/images/icon/icon_6.jpg" width="30" height="30"></div>
                    --%>
                    <%--文本编辑器--%>
                <!--style给定宽度可以影响编辑器的最终宽度-->
                <script type="text/plain" id="myEditor" style="width:840px;height:240px;">
                </script>
                <input type="hidden" name="annoContent">
                <h2 class="relran">展示小图</h2>
                <c:choose>
                    <c:when test="${businessAnno.annoPic != null}">
                        <img id="block4" src="${businessAnno.annoPic}" width="100" height="100">
                    </c:when>
                    <c:otherwise>
                        <img id="block4" src="${ctx}/images/icon/add.jpg" width="100" height="100">
                    </c:otherwise>
                </c:choose>
                <input type="hidden" name="annoPic" id="annoPic"> <%--头像--%>
                <h2 class="relstatus">发布状态</h2>
                <div class="options">
                    <p>
                        <label>
                            <form:radiobutton path="publishState" class="radiostyle"   value="1"/>
                            立即发布</label>
                        <br><br>
                        <label>
                            <form:radiobutton path="publishState" class="radiostyle"  value="2"/>
                            暂缓发布</label>
                        <br><br>
                        <label>
                            <form:radiobutton path="publishState" class="radiostyle"  value="3"/>
                            待审核</label>
                        <br>
                    </p>
                </div>
                <div class="line2"></div>
                <h2 class="relstatus">是否重要通知</h2>
                <div class="options">
                    <p>
                        <label>
                            <form:radiobutton path="isImportant"  value="1"/>
                            是</label>
                        <br><br>
                        <label>
                            <form:radiobutton class="radiostyle"  path="isImportant" value="2"/>
                            否</label>
                        <br>
                    </p>
                </div>
                <h2 class="relstatus">定时提醒</h2>
                <%--<span class="timebut radiusbox" id="block3">点击设置时间</span>--%>
                <input type="text" class="iptnewtit" name="setTime" id="remindTime" value="" />

                <div class="submtpres">
                    <input id="qrbut" type="button" value="确认提交" onclick="confirmPublish();"/>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/common/scopeJS.jsp"%>
    <div class="busswi3">
        <div class="sidebar3">
            <a id="close3" href="javascript:;"></a>
            <h2 class="tit3">类型列表</h2>
            <!--<hr class="link3">-->
            <div>
                <ul class="accordion3">
                    <li id="one2" class="files">
                        <form:radiobutton class="radiostyle2"  path="annoType" value="1"/>
                        <a href="#one">通知类公告</a>
                    </li>
                    <li id="two2" class="mail">
                        <form:radiobutton class="radiostyle2"  path="annoType" value="2"/>
                        <a href="#two">信息传达类公告</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <form:hidden path="annoId"/>
</form:form>
<%-- <%@include file="/common/uploadPicJs.jsp"%> --%>
</body>
<%--初始化文本编辑器--%>
<script type="text/javascript">
    //实例化编辑器
    var um = UM.getEditor('myEditor');
    um.setContent('${businessAnno.annoContent}');
</script>
</html>