<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jian.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="textml;charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
	
<script type="text/javascript">
var win;
var grid;
$(function() {
	
	grid = $('#grid').datagrid({
        title: 'ManageOrg管理',
        iconCls: 'icon-save',
        url: '<%=path %>/manage/manageOrg/list.do',
        fit: true,
        fitColumns: true,
        queryParams:{
        	name:function(){
        		console.log($("#name").val());
        		return $("#name").val();
        	}
        },
		resize: true,
        sortOrder: 'orgId',
        idField: 'orgId',
        pageSize:30,
        frozenColumns: [[
                         { field: 'orgId', checkbox: true }
        		]],
        columns: [[
    		          { field: 'orgName', title: '机构名称', width: 150, align:'center' },
    		          { field: 'orgDesc', title: '机构介绍', width: 150, align:'center' },
    		          { field: 'parentId', title: '父机构ID', width: 150, align:'center' },
    		          { field: 'orgCode', title: '机构编码', width: 150, align:'center' },
    		          { field: 'orgState', title: '机构状态', width: 150, align:'center' },
    		          { field: 'orgTypeCode', title: '机构类型编码', width: 150, align:'center' },
    		          { field: 'orgLongitude', title: '机构经度', width: 150, align:'center' },
    		          { field: 'orgLatitude', title: '机构纬度', width: 150, align:'center' },
    		          { field: 'orgIcon', title: '机构图标', width: 150, align:'center' },
    		          { field: 'orgTel', title: '机构电话', width: 150, align:'center' },
    		          { field: 'orgEmail', title: '机构邮箱', width: 150, align:'center' },
    		          { field: 'orgWeixin', title: '机构微信', width: 150, align:'center' },
    		          { field: 'orgSubType', title: '关联机构类型', width: 150, align:'center' },
    		          { field: 'createTime', title: '创建时间', width: 150, align:'center' },
    		          { field: 'editTime', title: '编辑时间', width: 150, align:'center' },
    		          { field: 'editor', title: '编辑人', width: 150, align:'center' },
    		          { field: 'leaf', title: '1为父节点0为叶子节点', width: 150, align:'center' },
    		          { field: 'ord', title: '排序', width: 150, align:'center' },
                ]],
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10,20,30,40,50],
        nowrap:false,
        striped: true,
        loadMsg:'数据装载中......',
        rownumbers: true,
        singleSelect: false,
        toolbar: [{
            text: '新增',
            iconCls: 'icon-add',
            handler: add
        }, '-', {
            text: '修改',
            iconCls: 'icon-edit',
            handler: edit
        }, '-', {
            text: '删除',
            iconCls: 'icon-remove',
            handler: del
        }, '-', {
            text: '查找',
            iconCls: 'icon-search',
            handler: OpensearchWin
        }, '-', {
            text: '所有',
            iconCls: 'icon-search',
            handler: showAll
        }]
    });

	var p = $('#grid').datagrid('getPager');
	if (p){                
		$(p).pagination({                    
			onSelectPage: function(pageNumber, pageSize) {
				$(this).pagination('loading');
				var queryParams = {pageNo: pageNumber, pageSize: pageSize};
				grid.datagrid('reload', queryParams);
			}               
		});            
	}

    $('#btn-search, #btn-search-cancel').linkbutton();
    $('body').layout();
});

function getSelectedArr() {
    var ids = [];
    var rows = grid.datagrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
         ids.push(rows[i].orgId);
    }
    return ids;
}

function getSelectedID() {
    var ids = getSelectedArr();
    return ids.join(',');
}

function arr2str(arr) {
    return arr.join(',');
}

function add() {
	win = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: '<%=path %>/manage/manageOrg/add.do'
    });
    $('#add-window').window('open');
    $('#add-window').window('resize');
}

function edit() {
    var rows = grid.datagrid('getSelections');
    var num = rows.length;
    if (num == 0) {
        $.messager.alert('提示', '请选择一条记录进行操作!', 'info');
        return;
    } else if (num > 1) {
        $.messager.alert('提示', '您选择了多条记录,只能选择一条记录进行修改!', 'info');
        return;
    }
    else{
    	win = $('#edit-window').window({
            closed: true,
            modal: true,
            shadow: false,
            cache: false,
            href: '<%=path %>/manage/manageOrg/modify.do?orgId='+rows[0].orgId
            
        });
    	$('#edit-window').window('open');
    }
}

function del() {
    var arr = getSelectedArr();
    if (arr.length>0) {
        $.messager.confirm('提示信息', '您确认要删除吗?', function (data) {
            if (data) {
                $.ajax({
                    url: '<%=path %>/manage/manageOrg/delete.do?id=' + arr2str(arr),
                    dataType: 'json',
                    cache: false,
                    success: function (data) {
                        grid.datagrid('reload');
                        grid.datagrid('clearSelections');
                    },
                    error: function () {
                        $.messager.alert('错误', '删除失败!', 'error');
                    }
                });
            }
        });
    } else {
        $.messager.show({
            title: '警告',
            msg: '请先选择要删除的记录。'
        });
    }
}

function showAll() {
	$('#searchForm').form('clear');
	grid.datagrid('reload',{});
}

function saveData(oper, formId) {
	$('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
                grid.datagrid('reload');
                win.window('close');
                $('#'+formId).form('clear');
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}

function modifyDate() {
	$('#modifyForm').form('submit', {
		url: $('#modifyForm').attr('action'),
		success: function(data) {
			eval('data=' + data);
			if(data.success) {
				grid.dataGrid(reload);
				$('#edit-window').window('close');
				form.form('clear');
			}
		}
	});
}
function closeWindow() {
	win.window('close');
}

function OpensearchWin() {
	win = $('#search-window').window({
		closed: true,
		modal: true
	});
	$('#search-window').window('open');
	
}

function SearchOK() {
	grid.datagrid('reload');
    $('#search-window').window('close');
}

function closeSearchWindow() {
    $('#search-window').window('close');
}

</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;">
 
    <div region="center" style="width: 500px; height: 300px; padding: 1px; background: #eee;
        overflow-y: hidden">
        <div id="grid" fit="true">
        </div>
    </div>
    <div id="add-window" title="新增窗口" style="width: 350px; height: 300px;"></div>
    <div id="edit-window" title="编辑窗口" style="width: 350px; height: 300px;"></div>
    <div id="search-window" title="查询窗口" style="width: 400px; height: 300px;">
        <div style="padding: 20px 20px 40px 80px;">
            <form id="searchForm" method="post" action="<%=path %>/manage/manageOrg/list.do">
            <table>
					<tr>
			          <td>机构名称：</td>
			          <td>
			          	<input name="orgName" id="orgName" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>机构介绍：</td>
			          <td>
			          	<input name="orgDesc" id="orgDesc" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>父机构ID：</td>
			          <td>
			          	<input name="parentId" id="parentId" type="text" style="width: 150px;" value=""/>
			          	<select name="parentId" id="parentId" class="selectwidth">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>机构编码：</td>
			          <td>
			          	<input name="orgCode" id="orgCode" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>机构状态：</td>
			          <td>
			          	<input name="orgState" id="orgState" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>机构类型编码：</td>
			          <td>
			          	<input name="orgTypeCode" id="orgTypeCode" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>机构经度：</td>
			          <td>
			          	<input name="orgLongitude" id="orgLongitude" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>机构纬度：</td>
			          <td>
			          	<input name="orgLatitude" id="orgLatitude" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>机构图标：</td>
			          <td>
			          	<input name="orgIcon" id="orgIcon" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>机构电话：</td>
			          <td>
			          	<input name="orgTel" id="orgTel" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>机构邮箱：</td>
			          <td>
			          	<input name="orgEmail" id="orgEmail" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>机构微信：</td>
			          <td>
			          	<input name="orgWeixin" id="orgWeixin" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>关联机构类型：</td>
			          <td>
			          	<input name="orgSubType" id="orgSubType" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>创建时间：</td>
			          <td>
			          	<input name="createTime" id="createTime" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>编辑时间：</td>
			          <td>
			          	<input name="editTime" id="editTime" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>编辑人：</td>
			          <td>
			          	<input name="editor" id="editor" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>1为父节点0为叶子节点：</td>
			          <td>
			          	<input name="leaf" id="leaf" type="text" style="width: 150px;" value=""/>
			          	<select name="leaf" id="leaf" class="selectwidth">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>排序：</td>
			          <td>
			          	<input name="ord" id="ord" type="text" style="width: 150px;" value=""/>
			          	<select name="ord" id="ord" class="selectwidth">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="SearchOK()" id="btn-search" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>确定</a>
            <a href="javascript:void(0)" onclick="closeSearchWindow()" id="btn-search-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>
                取消</a>
        </div>
    </div>
</body>

</html>