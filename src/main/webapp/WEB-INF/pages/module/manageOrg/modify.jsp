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

</head>
<body>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="modifyForm" method="post" action="<%=path %>/manage/manageOrg/update.do">
            <table>
						<input type="hidden" id="orgId" name="orgId" value="{manageOrg.orgId}" />
					<tr>
			          <td>机构名称：</td>
			          <td>
			          	<input name="orgName" id="orgName" type="text" style="width: 150px;" value="{manageOrg.orgName}" class="easyui-validatebox" required="true" missingMessage="请输入机构名称" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构介绍：</td>
			          <td>
			          	<input name="orgDesc" id="orgDesc" type="text" style="width: 150px;" value="{manageOrg.orgDesc}" class="easyui-validatebox" required="true" missingMessage="请输入机构介绍" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>父机构ID：</td>
			          <td>
			          	<input name="parentId" id="parentId" type="text" style="width: 150px;" value="{manageOrg.parentId}" class="easyui-validatebox" required="true" missingMessage="请输入父机构ID" validType="[0,100000]" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="parentId" id="parentId" class="selectwidth easyui-validatebox" required="true" missingMessage="请选择父机构ID">
			          		<option value="">请选择</option>
			          		<option value="0" <c:if test="{manageOrg.parentId} == 0 "> selected </c:if> >是</option>
			          		<option value="1" <c:if test="{manageOrg.parentId} == 1 "> selected </c:if> >否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>机构编码：</td>
			          <td>
			          	<input name="orgCode" id="orgCode" type="text" style="width: 150px;" value="{manageOrg.orgCode}" class="easyui-validatebox" required="true" missingMessage="请输入机构编码" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构状态：</td>
			          <td>
			          	<input name="orgState" id="orgState" type="text" style="width: 150px;" value="{manageOrg.orgState}" class="easyui-validatebox" required="true" missingMessage="请输入机构状态" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构类型编码：</td>
			          <td>
			          	<input name="orgTypeCode" id="orgTypeCode" type="text" style="width: 150px;" value="{manageOrg.orgTypeCode}" class="easyui-validatebox" required="true" missingMessage="请输入机构类型编码" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构经度：</td>
			          <td>
			          	<input name="orgLongitude" id="orgLongitude" type="text" style="width: 150px;" value="{manageOrg.orgLongitude}" class="easyui-validatebox" required="true" missingMessage="请输入机构经度" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构纬度：</td>
			          <td>
			          	<input name="orgLatitude" id="orgLatitude" type="text" style="width: 150px;" value="{manageOrg.orgLatitude}" class="easyui-validatebox" required="true" missingMessage="请输入机构纬度" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构图标：</td>
			          <td>
			          	<input name="orgIcon" id="orgIcon" type="text" style="width: 150px;" value="{manageOrg.orgIcon}" class="easyui-validatebox" required="true" missingMessage="请输入机构图标" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构电话：</td>
			          <td>
			          	<input name="orgTel" id="orgTel" type="text" style="width: 150px;" value="{manageOrg.orgTel}" class="easyui-validatebox" required="true" missingMessage="请输入机构电话" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构邮箱：</td>
			          <td>
			          	<input name="orgEmail" id="orgEmail" type="text" style="width: 150px;" value="{manageOrg.orgEmail}" class="easyui-validatebox" required="true" missingMessage="请输入机构邮箱" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构微信：</td>
			          <td>
			          	<input name="orgWeixin" id="orgWeixin" type="text" style="width: 150px;" value="{manageOrg.orgWeixin}" class="easyui-validatebox" required="true" missingMessage="请输入机构微信" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>关联机构类型：</td>
			          <td>
			          	<input name="orgSubType" id="orgSubType" type="text" style="width: 150px;" value="{manageOrg.orgSubType}" class="easyui-validatebox" required="true" missingMessage="请输入关联机构类型" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>创建时间：</td>
			          <td>
			          	<input name="createTime" id="createTime" type="text" style="width: 150px;" value="{manageOrg.createTime}" class="easyui-validatebox" required="true" missingMessage="请输入创建时间" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>编辑时间：</td>
			          <td>
			          	<input name="editTime" id="editTime" type="text" style="width: 150px;" value="{manageOrg.editTime}" class="easyui-validatebox" required="true" missingMessage="请输入编辑时间" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>编辑人：</td>
			          <td>
			          	<input name="editor" id="editor" type="text" style="width: 150px;" value="{manageOrg.editor}" class="easyui-validatebox" required="true" missingMessage="请输入编辑人" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>1为父节点0为叶子节点：</td>
			          <td>
			          	<input name="leaf" id="leaf" type="text" style="width: 150px;" value="{manageOrg.leaf}" class="easyui-validatebox" required="true" missingMessage="请输入1为父节点0为叶子节点" validType="[0,100000]" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="leaf" id="leaf" class="selectwidth easyui-validatebox" required="true" missingMessage="请选择1为父节点0为叶子节点">
			          		<option value="">请选择</option>
			          		<option value="0" <c:if test="{manageOrg.leaf} == 0 "> selected </c:if> >是</option>
			          		<option value="1" <c:if test="{manageOrg.leaf} == 1 "> selected </c:if> >否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>排序：</td>
			          <td>
			          	<input name="ord" id="ord" type="text" style="width: 150px;" value="{manageOrg.ord}" class="easyui-validatebox" required="true" missingMessage="请输入排序" validType="[0,100000]" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="ord" id="ord" class="selectwidth easyui-validatebox" required="true" missingMessage="请选择排序">
			          		<option value="">请选择</option>
			          		<option value="0" <c:if test="{manageOrg.ord} == 0 "> selected </c:if> >是</option>
			          		<option value="1" <c:if test="{manageOrg.ord} == 1 "> selected </c:if> >否</option>
			          	</select>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
</body>
</html>