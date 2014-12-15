<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/23
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>二手</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    <script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
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
        $(function () {
            $('input[name="typeID"]').click(function() {
                $('input[name="dealType"]').val($(this).val());
            });
            //验证表单
            $('#ff').validate({
                submitHandler:function(form){
                    $('#ff').form('submit', {
                        success:function(data){
                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                            window.location.href = '<%=ctx%>/business/businessProduct/list.do';
                        }
                    });
                },
                errorClass: "error",
                success: function(label) {
                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
                },
                rules: {
                    publisherId: {
                        required: true
                    },
                    dealType: {
                        required: true
                    },
                    title: {
                        required: true,
                        maxlength: 14
                    },
                    content: {
                        required: true
                    },
                    price: {
                        required: true,
                        number:true
                    },
                    isEstateAgent: {
                        required: true
                    },
                    contactName: {
                        required: true
                    },
                    contactTel: {
                        required: true
                    },
                    contactQQ: {
                        required: true
                    }
                },
                messages: {
                    publisherId: {
                        required: '请选择发布人！'
                    },
                    dealType: {
                        required: '请选择交易类型！'
                    },
                    title: {
                        required: '请填写信息标题！',
                        maxlength: '信息标题在14字以内'
                    },
                    content: {
                        required: '请填写信息描述！'
                    },
                    price: {
                        required: '请填写售价！',
                        number: '价格为数字类型'
                    },
                    isEstateAgent: {
                        required: '请选择委托驿站代售！'
                    },
                    contactName: {
                        required: '请填写联系人！',
                        maxlength: '联系人名称少于20字'
                    },
                    contactTel: {
                        required: '请填写电话！',
                        maxlength: '联系电话少于30字'
                    },
                    contactQQ: {
                        required: '请填写QQ/微信！',
                        maxlength: 'QQ/微信少于30字'
                    }
                }
            });
        });
        //提交表单
        function submitForm() {
            var ary = [];
            //获取图片值
            //$.each($('#multiPic').children(), function(i, item){
            //    ary.push(item.src);
            //});

            //$('#annoPic').val(ary.join(','));
            var content = ue.getContent();
            $('#content').val(ue.getContent());
            $('input[name="contactName"]').val($('#contactName').val());
            $('input[name="contactTel"]').val($('#contactTel').val());
            $('input[name="contactQq"]').val($('#contactQQ').val());
			
            $('#ff').submit();
        }
        //搜索用户
        function findUser() {
        	var tel = $('#tel').val();
        	if(tel != '') {
        		$.post('${ctx}/app/appUser/getAppUserInfoByTel.do', {tel: $('#tel').val()}, function(data) {
        			eval("data = "+data);
                    if(data != null) {
                        $('#portrait').html(
                                        '<img src="'+data.portrait+'" style="width:100%;">'
                        ); //头像
                        $('#userId').text(data.userId); //用户ID
                        $('#realname').text(data.realname); //真实姓名
                        $('#boundphone').text(data.boundphone); //绑定手机
                        $('#nickname').text(data.nickname); //昵称
                        $('#address').text(data.estateName+data.buildingName+data.unitName+data.houseNo); //地址
                        /*设置隐藏域*/
                        $('#publisherId').val(data.userId);  //求助人ID
                        $('#publisherName').val(data.realname); //求助人姓名
                        $('#estateId').val(data.estateId);  //求助人ID
                        $('#estateScope').val(data.estateName); //求助人姓名
                    }
                });
        	}else{
        		alert('请输入用户电话');
        	}
            
        }
    </script>
</head>
<body class="bagcolr">
<form id="ff" action="update.do" method="post">

<div class="wrapper wranews">

    <div class="newsrel">

        <div class="header-public"><span class="return"></span>发布二手</div>

        <div class="cont-l">
            <h2 class="relran y-fbes-bdr">绑定发布人<label for="publisherId" class="error success"></label></h2>
			<input type="hidden" name="productId" id="productId" value="${businessProduct.productId }" />
            <span class="ranbut radiusbox" id="y-fbes-sjm">点击选择居民</span>
            <input type="hidden" name="publisherId" id="publisherId" value="${businessProduct.publisherId }"/><%--发布人ID--%>
            <input type="hidden" name="publisherName" id="publisherName"  value="${businessProduct.publisherName }"/><%--发布人--%>
            <input type="hidden" name="estateId" id="estateId" value="${businessProduct.estateId }"/><%--发布小区ID--%>
            <input type="hidden" name="estateScope" id="estateScope" value="${businessProduct.estateScope }"/><%--发布小区--%>
            <input type="hidden" name="contactName" value="${businessProduct.contactName }"/><%--联系人--%>
            <input type="hidden" name="contactTel" value="${businessProduct.contactTel }"/><%--电话--%>
            <input type="hidden" name="contactQq" value="${businessProduct.contactQq }"/><%--QQ/微信--%>

            <h2 class="relran">交易类型<label for="dealType" class="error success"></label></h2>
            <span class="ranbut radiusbox" id="block2">点击选择类型</span>
            <input type="hidden" name="dealType" id="dealType"  value="${businessProduct.dealType }" /><%--发布类型--%>
            
            <h2 class="title">信息标题<label for="title" class="error success"></label></h2>
            <input class="iptnewtit" type="text" name="title" id="title" placeholder='请输入新闻标题14字以内'  value="${businessProduct.title }"/>
            
            <h2 class="newscont">信息描述<label for="content" class="error success"></label></h2>
            <%--文本编辑器--%>
            <!--style给定宽度可以影响编辑器的最终宽度-->
            <script type="text/plain" id="myEditor" style="width:840px;height:240px;">${businessProduct.content }</script>
            <input type="hidden" name="content" id="content" value="${businessProduct.content }">

            <h2 class="relran">上传图片</h2>
            <span id="multiPic"></span>
            <img id="block4" src="${ctx}/images/icon/add.jpg" width="100" height="100" style="vertical-align: middle;">&nbsp;&nbsp;<em style="color:#e7402f;">请上传【宽170PX、高125PX】jpg格式图片</em>
            <input type="hidden" name="annoPic" id="annoPic"> <%--头像--%>
            
            <h2 class="newscont">售价<label for="price" class="error success"></label></h2>
            <p class="y-fbes-sj">
                <input class="iptnewtit" type="text" name="price" placeholder='请输入数字'  value="${businessProduct.price }"/>
                <span>元/元以下</span>
            </p>

            <h2 class="relstatus">委托驿站代售<label for="isEstateAgent" class="error success"></label></h2>
            <div class="options">

                <form name="form1" method="post" action="">
                    <p>
                        <label>
                            <input class="radiostyle" type="radio" name="isEstateAgent" value="0" id="RadioGroup1_0" <c:if test='${businessProduct.isEstateAgent==0}'> checked </c:if>>
                            是</label>
                        <br><br>
                        <label>
                            <input class="radiostyle" type="radio" name="isEstateAgent" value="1" id="RadioGroup1_1" <c:if test='${businessProduct.isEstateAgent==1}'> checked </c:if>>
                            否</label>
                        <br>
                    </p>
                </form>
            </div>
            <div class="submtpres">
                <input id="qrbut" type="button" name="" value="确认提交"  onclick="submitForm();"/>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){

        $(".icon").click(function(){

            var i= $(".icon").index($(this));

            if($(this).hasClass("add")){
                $(this).removeClass("add").addClass("add2");
                $(".accordion2").children("ul").eq(i).show();
            }else{
                $(this).removeClass("add2").addClass("add");
                $(".accordion2").children("ul").eq(i).hide();
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



        $(".sub-menu2 li").click(function(){
            //alert("ok")
            var i= $(".sub-menu2 li span").index($(this));
            $("li a span").addClass("gou2")
            $("li a span").removeClass("gou")
            $(this).children().children().addClass("gou")

            $(this).children().children().removeClass("gou2")
            $("sub-menu2 ul").eq(i).show();

            $("sub-menu2 ul").eq(i).hide();


        })

        $('#ff2').validate({
            errorClass: "error",
            success: function(label) {
                label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
            },
            submitHandler:function(form){
                <%-- $('#ff').form('submit', {
                    success:function(data){
                        var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                        alert(data.message);
                        window.location.href = '<%=ctx%>/business/businessNews/list.do';
                    }
                }); --%>
                alert('adfad');
            },
            rules: {
            	userId: {
                    required: true
                },
                contactName: {
                    required: true
                },
                contactTel: {
                    required: true
                },
                contactQQ: {
                    required: true
                }
            },
            messages: {
            	userId: {
                    required: '请绑定发布人'
                },
                contactName: {
                    required: '请填写联系人',
                    maxlength: 32
                },
                contactTel: {
                    required: '请填写电话',
                    maxlength: 32
                },
                contactQQ: {
                    required: '请填写QQ/微信！',
                    maxlength: 32
                }
            }
        });
    });
    function submitF() {
        //验证表单
        $('#ff2').submit();
        //$('#findUserLayer').fadeOut('slow');
    }
</script>
<div id="findUserLayer" class="busswi y-fbes-jm">

    <div class="sidebar" id="y-fbes-jms">

        <a id="y-fbes-close" class="close" href="javascript:;"></a>

        <h2 class="tit">居民选择</h2>
        <form id="ff2" >
            <div id="wrapper-250">

                <div class="y-fbes-s">
                    <input type="text" placeholder="请输手机号" id="tel" class="y-fbes-st">
                    <input type="button" value="搜索"  class="y-fbes-ss" onclick="findUser();">
                </div>
                <div class="y-fbes-xx">
                	<p><label for="userId" class="error success"></label></p>
                	<input type="hidden" name="userId" id="userId" value="" />
                    <span id="portrait" class="xx-tp"></span><br>
                    <p class="xx-wz">
                        <span>真实姓名：<span id="realname"></span></span>
                        <span>绑定手机：<span id="boundphone"></span></span>
                        <span>昵称：<span id="nickname"></span></span>
                        <span>地址：<span id="address"></span></span>


                    </p>
                </div>
                <div style="clear:both;"></div>
                
                <hr style="border: 1px dashed #999999;margin-bottom: 25px;margin-top: 50px;width: 100%;"/>
                <h2 class="tit">发布联系人信息：</h2>

                <h2 class="tit">联系人<label for="contactName" class="error success"></label></h2>
                <input type="text" class="y-fbes-st y-fbes-sl" id="contactName" value="${businessProduct.contactName }">
                
                <h2 class="tit">电话<label for="contactTel" class="error success"></label></h2>
                <input type="text" class="y-fbes-st y-fbes-sl" id="contactTel" value="${businessProduct.contactTel }">
                
                <h2 class="tit">QQ/微信<label for="contactQQ" class="error success"></label></h2>
                <input type="text" class="y-fbes-st y-fbes-sl"id="contactQQ" value="${businessProduct.contactQq }">
                
            </div>
            <div class="w-gg-btn">
                <span class="w-gg-qr w-gg-total" style="cursor: pointer;" onclick="submitF();">确认</span>
                <span class="w-gg-qx w-gg-total" style="cursor: pointer;" id="y-fbes-qxbtn">取消</span>
            </div>
        </form>

        <!-- 添加完毕-->

        <script type="text/javascript">
            $(document).ready(function() {
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
            });
        </script>

    </div>

</div>

<div class="busswi3">

    <div class="sidebar3">

        <a id="close3" href="javascript:;"></a>

        <h2 class="tit3">类型列表</h2>

        <!--<hr class="link3">-->

        <div id="wrapper-250">
            <ul class="accordion3">
                <li id="one2" class="files"><input class="radiostyle2" type="radio" name="typeID"  value="0"><a href="#one">出售</a></li>
                <li id="two2" class="mail"><input class="radiostyle2" type="radio" name="typeID" value="1"> <a href="#two">求购</a></li>
                <li id="two2" class="mail"><input class="radiostyle2" type="radio" name="typeID" value="2"> <a href="#two">交换</a></li>
            </ul>

        </div>

    </div>
</div>

</form>
<%-- <%@include file="/common/uploadMultiPicJs.jsp"%> --%>

</body>
<%--初始化文本编辑器--%>
<script type="text/javascript">
    //实例化编辑器
    var ue = UE.getEditor('myEditor');
</script>
</html>
