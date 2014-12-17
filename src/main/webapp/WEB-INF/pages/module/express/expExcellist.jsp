<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.text.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@ page import="com.community.framework.utils.CommonUtils" %>
<%@ page import="java.util.*" %>
<%@ page import="com.community.app.module.common.*" %>

<!DOCTYPE html>
<html>
    <head>
        <title>导出Excel预览</title>
        <%@include file="/common/meta.jsp"%>
        <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
        <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
        <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    	<script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
    	
		<script type="text/javascript">
			//获取多参数
			function getParams() {
				var params = {
					expState: $('#expState').val(),
					expCompanyID: $('#expCompanyID').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime:   $('#endTime').val(),
					curEstateId:   $('#curEstateId').val()
				};
				return params;
			}
		    
		    //跳转页面
		    function jump(pageNo) {
		    	var rowNum = '';
		    	$('.exp-exc').html('');
		    	var params = getParams();
		    	$.ajax({
		    		type: 'post',
		            url: '<%=path %>/business/businessExp/getExcelPageList.do',
		            dataType: 'json',
		            data: params,
		            cache: false,
		            success: function (data) {
		            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
		            	rowNum = data.total;
		                var rows = data.rows;
		                var addHtml = ''
		                	+'<table cellpadding="0" cellspacing="0">'
		                	+'<thead>'
		                	+'<tr>'
		                	+'<th>操作</th>'
		                	+'<th>日期</th>'
		                	+'<th>运单状态</th>'
		                	+'<th>客户姓名</th>'
		                	+'<th>运单号</th>'
		                	+'<th>地址</th>'
		                	+'<th>电话</th>'
		                	+'<th>备注(取)</th>'
		                	+'<th>领取时间</th>'
		                	+'<th>客户签字</th>'
		                	+'<th>快递员签字</th>'
		                	+'<th>驿站签字</th>'
		                	+'</tr>'
		                	+'</thead>'
		                	+'<tbody>';
		                	
		                	if(rows.length > 0) {
		                    	for(var i=0;i<rows.length;i++) {
		                        	var row = rows[i];  
		                        	addHtml +='<tr '+(i % 2 == 1? 'class=\"trtwo\"' : '')+'>'
					                	+'<td><input type="checkbox" name="expId" value="'+row.expId+'" checked /></td>'
					                	+'<td>';
				                	if(row.expState == 0 || row.expState == 1 || row.expState == 2){
				                		addHtml += (row.sendTime != '' && row.sendTime != 'null'?row.sendTime.substring(0, 10) : '')+'';
				                	}
				                	if(row.expState == 4 || row.expState == 3){
				                		addHtml += (row.checkInTime != '' && row.checkInTime != 'null'?row.checkInTime.substring(0, 10) : '')+'';
				                	}
				                	if(row.expState == 5 || row.expState == 6 || row.expState == 7 || row.expState == 8 || row.expState == 9){
				                		addHtml += (row.receiveTime != '' && row.receiveTime != 'null'? row.receiveTime.substring(0, 10) : '')+'';
				                	}
				                	addHtml += '</td>'
				                	+'<td>';
				                	if(row.expState == 0){
				                		addHtml += '上门取件';
				                	} else if(row.expState == 1){
				                		addHtml += '已上门取件';
				                	}  else if(row.expState == 2){
				                		addHtml += '已发送';
				                	}  else if(row.expState == 3){
				                		addHtml += '已入库';
				                	}  else if(row.expState == 4){
				                		addHtml += '自提';
				                	}  else if(row.expState == 5){
				                		addHtml += '上门送件';
				                	}  else if(row.expState == 6){
				                		addHtml += '已签收';
				                	}  else if(row.expState == 7){
				                		addHtml += '已退件';
				                	}  else if(row.expState == 8){
				                		addHtml += '已取消';
				                	}  else if(row.expState == 9){
				                		addHtml += '问题件';
				                	} 
				                	addHtml += '</td>'
				                	+'<td>';
				                	if(row.expState == 0 || row.expState == 1 || row.expState == 2){
				                		addHtml += row.senderName;
				                	}
				                	if(row.expState == 3 || row.expState == 4 || row.expState == 5 || row.expState == 6 || row.expState == 7 || row.expState == 8 || row.expState == 9){
				                		addHtml += row.receiverName;
				                	}
				                	addHtml += '</td>'
				                	+'<td>'+row.expCode+'</td>'
				                	+'<td>';
				                	if(row.expState == 0 || row.expState == 1 || row.expState == 2){
				                		addHtml += row.senderAddr;
				                	}
				                	if(row.expState == 3 || row.expState == 4 || row.expState == 5 || row.expState == 6 || row.expState == 7 || row.expState == 8 || row.expState == 9){
				                		addHtml += row.receiverAddr;
				                	}
				                	addHtml += '</td>'
				                	+'<td>';
				                	if(row.expState == 0 || row.expState == 1 || row.expState == 2){
				                		addHtml += row.senderTel;
				                	}
				                	if(row.expState == 3 || row.expState == 4 || row.expState == 5 || row.expState == 6 || row.expState == 7 || row.expState == 8 || row.expState == 9){
				                		addHtml += row.receiverTel;
				                	}
				                	addHtml += '</td>'
				                	+'<td></td>'
				                	+'<td>';
				                	if(row.expState == 3){
				                		addHtml += (row.signTime != '' && row.signTime != 'null'?row.signTime.substring(0, 10) : '')+'';
				                	}
				                	addHtml += '</td>'
				                	+'<td></td>'
				                	+'<td></td>'
				                	+'<td></td>'
				                	+'</tr>';
		                    	}
		                	}
			                addHtml += '</tbody>'
			                	+'</table>';
		                $('.exp-exc').append(addHtml);
		            },
		            error: function () {
		            	$('.exp-exc').html('很抱歉，加载内容出错，我们及时修改问题。');
		            }
		        });
		    }
	    	
	    	$(function(){
	    	    $("#selectAll").click(function(){
	       			$("input[type=checkbox]").attr("checked",true);
	            });
	    	    
	      		$("#deSelect").click(function(){ 			
	    	  		$("input[type=checkbox]").each(function(){
	    	   		$(this).attr("checked",!$(this).attr("checked"));
	    	    	});
	      		});
	      		
	      		$("#exportExcel").click(function(){
	      			var strIds=new Array();
	      			$("input[type=checkbox]").each(function (i,d){
	      				if (d.checked) {
	      					strIds.push(d.value);
	      				}
	      			});
	      			
	      			if(strIds.length<1)
	    				alert("您没有选中项!");
	    			else{
	    				//var ids=strIds.join("#");
	    				//alert("你选中的字符串有："+ids);
	    				var param = "?expIds="+strIds;
						
	    				if($('#curEstateId').val() != '' && $('#curEstateId').val() != null) {
	    					param += "&curEstateId="+$('#curEstateId').val();
	    				}
	    				if($('#expState').val() != '' && $('#expState').val() != null) {
	    					param += "&expState="+$('#expState').val();
	    				}
	    				if($('#expCompanyID').val() != '' && $('#expCompanyID').val() != null) {
	    					param += "&expCompanyID="+$('#expCompanyID').val();
	    				}
	    				if($('#timeScope').val() != '' && $('#timeScope').val() != null) {
	    					param += "&timeScope="+$('#timeScope').val();
	    				}
	    				if($('#startTime').val() != '' && $('#startTime').val() != null && $('#endTime').val() != '' && $('#endTime').val() != null) {
	    					param += "&startTime="+$('#startTime').val()+"&endTime="+$('#endTime').val();
	    				}
	    				window.location.href = '${ctx}/business/businessExp/exportExcel.do'+param;
	    			} 
	      		});
	    	});
		</script>	
    </head>
    <body>
	    <div>	
	        <div class="newsrel">  
	            <div class="header-public"><span class="return" onclick="window.location.href='${ctx }/business/businessExp/list.do'" ></span>导出Excel预览</div>      
	            <div class="content">
	                <div class="scroll">
	                    <div class="scroll-box">
	                        <ul id="oneul">
								<li id="curEstateId_" class="active navlist"><a href="javascript:;"><span>全部驿站</span><b class="donbut"><i></i></b></a>
			                    	<input type="hidden" name="curEstateId" id="curEstateId" value="" />
			                    	<ul class="erjnav">
						          	  	<c:forEach items="${estateList }" var="estateListBean" varStatus="key">
			                				<li id="curEstateId_${estateListBean.estateId }"><a href="javascript:;">${estateListBean.estateName }</a></li>
			                			</c:forEach>
			                        </ul>
			                    </li>
								
								<li id="expState_" class="active navlist"><a href="javascript:;"><span>全部快递</span><b class="donbut"><i></i></b></a>
			                    	<input type="hidden" name="expState" id="expState" value="" />
			                    	<ul class="erjnav">
			                            <li id="expState_0"><a href="javascript:;">上门取件</a></li>
			                            <li id="expState_1"><a href="javascript:;">已上门取件</a></li>
			                            <li id="expState_2"><a href="javascript:;">已发送</a></li>
			                            <li id="expState_3"><a href="javascript:;">已入库</a></li>
			                            <li id="expState_4"><a href="javascript:;">自提</a></li>
			                            <li id="expState_5"><a href="javascript:;">上门送件</a></li>
			                            <li id="expState_6"><a href="javascript:;">已签收</a></li>
			                            <li id="expState_7"><a href="javascript:;">已退件</a></li>
			                        	<li id="expState_8"><a href="javascript:;">已取消</a></li>
			                        	<li id="expState_9"><a href="javascript:;">问题件</a></li>
			                        </ul>
			                    </li>
			                    
		                        <li id="expCompanyID_" class="navlist"><a href="javascript:;"><span>所有快递公司</span><b class="donbut"><i></i></b></a>
			                    	<input type="hidden" name="expCompanyID" id="expCompanyID" value="" />
			                    	<ul class="erjnav">
			                			<c:forEach items="${expressList }" var="express" varStatus="key">
			                				<li id="expCompanyID_${express.expressId }"><a href="javascript:;">${express.expressComppay }快递</a></li>
			                			</c:forEach>
			                        </ul>
			                    </li>
			                    
			                    <li id="timeScope_" class="navlist"><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a>
			                   		<input type="hidden" name="timeScope" id="timeScope" value="" />
			                   		<input type="hidden" name="startTime" id="startTime" value="" />
			                   		<input type="hidden" name="endTime" id="endTime" value="" />
			                    	<ul class="erjnav">
			                    		<li id="timeScope_0"><a href="javascript:;">当日</a></li>
			                            <li id="timeScope_7"><a href="javascript:;">7天内</a></li>
			                            <li id="timeScope_30"><a href="javascript:;">30天内</a></li>
			                            <li id="timeScope_90"><a href="javascript:;">90天内</a></li>
			                            <li id="timeScope_365"><a href="javascript:;">365天内</a></li>
			                            <li id="timeScope_scope"><a href="javascript:;">选择时间范围</a></li>
			                        </ul>
			                    </li>
	                        </ul>
	                         <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${size }条</p>
	                    </div>
	                </div>
	                <div class="exp-exc">
	                    <table cellpadding="0" cellspacing="0">
	                        <thead>
	                          <tr>
	                            <th>操作</th>
	                            <th>日期</th>
	                            <th>运单状态</th>
	                            <th>客户姓名</th>
	                            <th>运单号</th>
								<th>地址</th>
	                            <th>电话</th>
	                            <th>备注(取)</th>
	                            <th>领取时间</th>
	                            <th>客户签字</th>
	                            <th>快递员签字</th>
	                            <th>驿站签字</th>
	                          </tr>
	                        </thead>
	                        <tbody>
		                        <c:forEach items="${list }" var="exp" varStatus="key">
		                          <tr <c:if test="${key.index % 2 == 1}" >class="trtwo"</c:if>>
		                            <td><input type="checkbox" name="expId" value="${exp.expId}" checked /></td>
		                            <td>
										<c:if test="${exp.expState == 0 || exp.expState == 1 || exp.expState == 2}" >
											<fmt:formatDate value="${exp.sendTime}" type="date"/>
										</c:if>
		
										<c:if test="${exp.expState == 3 || exp.expState == 4 }" >
											<fmt:formatDate value="${exp.checkInTime}" type="date"/>
										</c:if>
										
										<c:if test="${ exp.expState == 5 || exp.expState == 6 || exp.expState == 7 || exp.expState == 8 || exp.expState == 9}">
											<fmt:formatDate value="${exp.receiveTime}" type="date"/>
										</c:if>
									</td>
		                            <td>
										<c:choose>
											<c:when test="${exp.expState == 0}">
												上门取件
											</c:when>
											<c:when test="${exp.expState == 1}">
												已上门取件
											</c:when>
										    <c:when test="${exp.expState == 2}">
										    	已发送
											</c:when>
											<c:when test="${exp.expState == 3}">
												已入库
											</c:when>
											<c:when test="${exp.expState == 4}">
												自提
											</c:when>
											<c:when test="${exp.expState == 5}">
												上门送件
											</c:when>
											<c:when test="${exp.expState == 6}">
												已签收
											</c:when>
											<c:when test="${exp.expState == 7}">
												已退件
											</c:when>
											<c:when test="${exp.expState == 8}">
												已取消
											</c:when>
											<c:when test="${exp.expState == 9}">
												问题件
											</c:when>
										</c:choose>
		                            </td>
		                            <td>
		                            	<c:if test="${exp.expState == 0 || exp.expState == 1 || exp.expState == 2}" >
											${exp.senderName}
										</c:if>
										<c:if test="${exp.expState == 3 || exp.expState == 4 || exp.expState == 5 || exp.expState == 6 || exp.expState == 7 || exp.expState == 8 || exp.expState == 9}">
											${exp.receiverName}
										</c:if>
		                            </td>
		                            <td>${exp.expCode}</td>
		                            <td>
		                                <c:if test="${exp.expState == 0 || exp.expState == 1 || exp.expState == 2}" >
											${exp.senderAddr}
										</c:if>
										<c:if test="${exp.expState == 3 || exp.expState == 4 || exp.expState == 5 || exp.expState == 6 || exp.expState == 7 || exp.expState == 8 || exp.expState == 9}">
											${exp.receiverAddr}
										</c:if>
		                            </td>
		                            <td>
		                                <c:if test="${exp.expState == 0 || exp.expState == 1 || exp.expState == 2}" >
											${exp.senderTel}
										</c:if>
										<c:if test="${exp.expState == 3 || exp.expState == 4 || exp.expState == 5 || exp.expState == 6 || exp.expState == 7 || exp.expState == 8 || exp.expState == 9}">
											${exp.receiverTel}
										</c:if>
		                            </td>
		                            <td></td>
		                            <td>
		                            	<c:if test="${exp.expState == 6 }" >
											<fmt:formatDate value="${exp.signTime}" type="date"/>
										</c:if>
									</td>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                          </tr>                        
		                        </c:forEach>
	                       	</tbody>
	                    </table>
	                </div>
	                <div class="exp-footer">
	                    <span class="exp-che">
	                        <a class="che-fir" id="selectAll">全选</a> 
	                        <a  id="deSelect">反选</a>
	                    </span>
	                   <span class="exp-page">
		                    <a href="javascript:;" class="arrow" id="arrow-l"></a>
		                    <a href="javascript:;" id="old">1</a>
		                    <a href="javascript:;" id="curr">2</a>
		                    <a href="javascript:;">3</a>
		                    <a href="javascript:;">4</a>
		                    <a href="javascript:;">5</a>
		                    <a href="javascript:;">6</a>
		                    <a href="javascript:;">7</a>
		                    <a href="javascript:;">8</a>
		                    <a href="javascript:;">9</a>
		                    <a href="javascript:;">10</a>
		                    <a href="javascript:;" class="arrow" id="arrow-r"></a>
	                   </span>
	                   <span class="exp-exp">
							<a id="exportExcel">EXCEL 导出</a> 
	                   </span>
	                </div>
	            </div>     
	        </div>
	    </div>      
	</body>
</html>
<!-- 开始时间设置 -->
<div id="dateDialog" title="选择日期范围">
	<div>
		<label for="setStartTime">开始日期</label>
		<input type="text" class="iptnewtit" name="setStartTime" id="setStartTime" value="" />
		<label for="setEndTime">结束日期</label>
		<input type="text" class="iptnewtit" name="setEndTime" id="setEndTime" value="" />
	</div>
</div>
<!-- 开始时间设置 -->

<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>