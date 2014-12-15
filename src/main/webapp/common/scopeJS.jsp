<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 范围选择开始 -->
<div id="scopeLayer" class="busswi">
    <div id="scopeBar" class="sidebar">
        <a id="closeScope" class="close_effect" href="javascript:;"></a>
        <h2 class="tit">范围选择</h2>
        <!--<hr class="link">-->
        <div id="wrapper-250">
            <ul id="scopeTree" style="font-size: 18px;"></ul>
            <ul>
                <input type="button" id="scopeOk" value="确定" />
                &nbsp;&nbsp;
                <input type="button" id="scopeCancel" value="取消" />
            </ul>
        </div>
    </div>
</div>
<link rel="stylesheet" type="text/css" href="${ctx}/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<!-- 范围选择开始 -->
<script type="text/javascript">
    $(function() {
        //选择范围结点
        $('#scopeTree').tree({
            checkbox: true,
            onSelect: function(node){
                var children = $('#scopeTree').tree('getChildren', node.target);
                if(children.length == 0) {//无子元素加入子结点,已有则展开结点即可
                    var idArr = node.id.split('_');
                    if(idArr[0] == 'building') {//加载楼栋下的单元
                        $.ajax({
                            url: '${ctx}/business/businessUser/getUnitsByBuilding.do',
                            data: {buildingId: idArr[1]},
                            cache: false,
                            success: function (data) {
                                eval('data=' + data);
                                if(data.success == true){
                                    $('#scopeTree').tree('append', {
                                        parent: node.target,
                                        data: data.result
                                    });
                                    $('#scopeTree').tree('expend', node);
                                }else{
                                    //$('#dep_'+depId).html('很抱歉，没有相关记录。');
                                }
                            },
                            error: function () {
                                //$('#dep_'+depId).html('很抱歉，加载内容出错，我们及时修改问题。');
                            }
                        });

                    }
                }else{
                    $('#scopeTree').tree('expend', node);
                }
            }
        });

        //显示范围层
        $("#showScopeLayer").click(function(){
            $("#scopeLayer").fadeIn("slow");
            $("#scopeLayer").css("height",$(document.body).outerHeight(true)+'px');
            $("#scopeBar").css("height",$(document.body).outerHeight(true)-40+'px');
            //显示楼栋列表
            $.ajax({
                url: '${ctx}/business/businessUser/getBuildingsByUser.do',
                cache: false,
                success: function (data) {
                    eval('data=' + data);
                    if(data.success == true){
                        var rows = data.result;
                        //alert('data.result   '+rows.length);
                        if(rows.length > 0) {
                            $('#scopeTree').tree('loadData', data.result);
                        }else{
                            //$('.accordion2').html('很抱歉，没有相关记录。');
                        }
                    }else{
                        //$('.accordion2').html('很抱歉，没有相关记录。');
                    }
                },
                error: function () {
                    //$('.accordion2').html('很抱歉，加载内容出错，我们及时修改问题。');
                }
            });
        });

        //关闭范围层
        $('#closeScope').click(function() {
            $("#scopeLayer").fadeOut("slow");
        });

        //选择范围
        $('#scopeOk').click(function() {
            var scopeStr = '';//显示字符串
            var scopeIds = '';
            var scopeAry = [];
            var scopeNodes = $('#scopeTree').tree('getChecked');
            if(scopeNodes != null && scopeNodes.length > 0) {
                for(var i=0;i<scopeNodes.length;i++) {
                    var node = scopeNodes[i];
                    scopeIds += node.id + ',';
                    var idArr = node.id.split('_');
                    var typeid = idArr[0];
                    if(typeid == 'building') {//选中了楼栋则直接保存楼栋下的所有单元
                        scopeStr += node.text + '&nbsp;&nbsp;';
                        var childrens = $('#scopeTree').tree('getChildren', node.target);
                        if(childrens.length == 0) {
                            var unitPNode =  $('#scopeTree').tree('getParent', node.target);
                            scopeAry.push(node.id+"|"+node.text+ "&" +unitPNode.id+"|"+unitPNode.text);
                        }

                    }else if(typeid == 'unit') {//选中了单元则直接保存单元
                        //取得楼栋名称
                        var buildgingNode = $('#scopeTree').tree('getParent', node.target);
                        scopeStr += buildgingNode.text + '-' + node.text + '&nbsp;&nbsp;';
                        var unitNode =  $('#scopeTree').tree('getParent', buildgingNode.target);
                        scopeAry.push(unitNode.id+"|"+unitNode.text + "&" +buildgingNode.id+"|"+buildgingNode.text + "&" +node.id+"|"+node.text); //保存楼栋
                    } else if(typeid == 'eatate') { //如果是小区
                        if($('#scopeTree').tree('isLeaf', node.target)) {
                            scopeAry.push(node.id+"|"+node.text);
                        }
                    }
                }

                if(scopeIds != '') {
                    if(scopeIds.indexOf(',') > -1) {
                        scopeIds = scopeIds.substring(0, scopeIds.length-1);
                    }
                    //$('#scope').val(scopeIds);
                    $('#scope').val(scopeAry.join(','));

                    $('#scopeShow').html(scopeStr);
                    $('#scopeShow').focus();
                }

                $("#scopeLayer").fadeOut("slow");
            }else{
                alert('请选择负责范围');
            }
        });

        //取消选择范围
        $('#scopeCancel').click(function() {
            $("#scopeLayer").fadeOut("slow");
        });
    });
</script>