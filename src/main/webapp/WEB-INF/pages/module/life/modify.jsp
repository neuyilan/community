<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/24
  Time: 9:03
  To change this template use File | Settings | File Templates.
  生活圈更新
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>生活圈</title>
    <%@include file="/common/meta.jsp"%>
    <script src="<%=ctx %>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    <script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
    <link rel="stylesheet" type="text/css" href="http://developer.amap.com/Public/css/demo.Default.css" />
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
        	var flag = false;
            //验证表单
            $('#ff').validate({
                submitHandler:function(form){
                	if(flag == true) {
                		return;
                	}else{
                		flag = true;
                	}
                    $('#qrbut').attr("disabled","disabled");
                    $('#ff').form('submit', {
                        success:function(data){
                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                            alert(data.message);
                            window.location.href = '<%=ctx%>/business/businessLife/list.do';
                        }
                    });
                },
                errorClass: "error",
                success: function(label) {
                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
                },
                rules: {
                    serviceName: {
                        required: true,
                        maxlength : 64
                    },
                    typeId: {
                        required: true
                    },
                    estateLongitude: {
                        required: true,
                        number: true
                    },
                    estateLatitude: {
                        required: true,
                        number: true
                    },
                    tel: {
                        required: true,
                        minlength : 6,
                        maxlength : 32
                    }
                },
                messages: {
                    serviceName: {
                        required: '请填写生活信息！'
                    },
                    typeId: {
                        required: '请选择生活分类！'
                    },
                    estateLongitude: {
                        required: '请输入经度',
                        number: '坐标经度为数值类型'
                    },
                    estateLatitude: {
                        required: '请输入纬度',
                        number: '坐标纬度为数值类型'
                    },
                    tel: {
                        required: '请填写电话信息！'
                    }
                }
            });

            //生活分类
            $('input[name="type"]').click(function() {
                var id = $(this).val();
                //生活属性
                var html = "";
                $.getJSON('${ctx}/business/businessTypeProperty/getTypePropertyJSON.do', {typeId: id}, function(data) {
                    $.each(data, function(i, item) {
                        html = html +' <h2 class="title">'+item.propName+'</h2><input class="iptnewtit" type="text" id="'+item.propId+'&'+item.propName+'&'+item.propType+'" name="temp"/>';
                    });
                    $('#attrDiv').html(html);
                });
            });
        });

        function submitForm() {
            var ary = [];
            var temps = $('input[name="temp"]');
            $.each(temps, function(i, item) {
                ary.push(item.id + '|' + item.value);
            });
            $('#values').val((ary.join(',')));
            $('#ff').submit();
        }

        function checkedRadio(obj, name, display) {
            $('#typeId').val(obj.value);
            $('#typeName').val(display);
            $('#spanType').text(display);
        }
    </script>
</head>
<body class="bagcolr">
<form id="ff" action="${ctx}/business/businessLife/update.do" method="post">
    <div class="wrapper wranews">
        <div class="newsrel">
            <div class="header-public"><span class="return" onclick="history.go(-1)"></span>周边信息发布</div>
            <div class="cont-l">
                <h2 class="title">信息名称<label for="serviceName" class="error success"></label></h2>
                <input class="iptnewtit" type="text" id="serviceName" name="serviceName" placeholder='' value="${businessLife.serviceName}"/>
                
                <h2 class="title">生活分类<label for="typeId" class="error success"></label></h2>
                <span class="ranbut radiusbox" id="block2">点击选择分类</span>
                <input type="hidden" name="typeId" value="${businessLife.typeId}">
                <input type="hidden" name="typeName" id="typeName" value="${businessLife.typeName}" />
                <span id="spanType">${businessLife.typeName}</span>
                
                <h2 class="title">地址信息<label for="estateLongitude" class="error success"></label><label for="estateLatitude" class="error success"></label></h2>
                <span class="ranbut radiusbox" id="block" >点击进行定位</span>
                <input style="width:300px;" class="iptnewtit" type="text" name="estateLongitude" id="estateLongitude" placeholder='输入经度' value="${businessLife.estateLongitude}" />
                <input style="width:300px;" class="iptnewtit" type="text" name="estateLatitude" id="estateLatitude" placeholder='输入纬度' value="${businessLife.estateLatitude}" />
                
                <h2 class="title">电话<label for="tel" class="error success"></label></h2>
                <input style="width:300px;" class="iptnewtit" type="text"  name="tel" placeholder='' value="${businessLife.tel}"/>
                <div id="attrDiv">
                    <c:forEach items="${proplist}" var="prop">
                        <h2 class="title">${prop.propName}</h2>
                        <input class="iptnewtit" type="text" id="${prop.propId}&${prop.propName}&${prop.propType}" value="${prop.propValue}" name="temp"/>'
                    </c:forEach>
                </div>
                
                <div class="submtpres">
                    <input id="qrbut" type="button" value="确认提交" onclick="submitForm()"/>
                </div>
            </div>
        </div>
    </div>

    <div class="busswi3">
        <div class="sidebar3">
            <a id="close3" href="javascript:;"></a>
            <h2 class="tit3">类型列表</h2>
            <div id="wrapper-250">
                <ul class="accordion3">
                    <c:forEach items="${lifeList}" var="lifeList">
                        <li id="two2" class="mail">
                            <input class="radiostyle2" type="radio" name="type" value="${lifeList.typeId}"
                                    <c:if test="${lifeList.typeId == businessLife.typeId}">checked</c:if>
                                    checkedRadio(this, 'typeId', '${lifeList.typeName}');>
                            <a href="#two">${lifeList.typeName}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <input type="hidden" name="values" id="values" value="1"/>
    <input type="hidden" name="serviceId" id="serviceId" value="${businessLife.serviceId}"/>
</form>
<jsp:include page="/common/mapJS1.2.jsp"/>
<input type="hidden" id="Lng" value="${businessLife.estateLongitude}"/>
<input type="hidden" id="Lat" value="${businessLife.estateLatitude}"/>

</body>
</html>
