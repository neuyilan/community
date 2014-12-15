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
        <title>快递管理</title>
        <%@include file="/common/meta.jsp"%>
        <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
        <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
        <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    	<script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
    	
		<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
		<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
		<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>

	<script type="text/javascript">
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					expState: $('#expState').val(),
					expCompanyID: $('#expCompanyID').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime:   $('#endTime').val(),
					orderBy:   $('#orderBy').val()
			};
		}
		return params;
	}
    
    //跳转页面
    function jump(pageNo) {
    	$('.column').html('');
    	$('#loading').css('display', 'block');
    	var params = getParams();
    	if(pageNo != undefined && pageNo != 0) {
    		params.page = pageNo;
    	}else{
    		params.page = 1;
    	}
    	
    	$.ajax({
    		type: 'post',
            url: '<%=path %>/business/businessExp/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                var rows = data.rows;
                if(params.page == 1) {
                	var addHtml = ''         
                		+ '<div class="manbox" style="margin-left:0;">'
                		+ '<a class="nopotr y-kd-boxh y-kd-fb" href="javascript:;" style="cursor:pointer;">'
                		+ '<ul class="y-kd-kdzt">'
                		+ '<li class="y-kd-left y-kd-top y-kd-rightb">'
                		+ '<i class="y-kd-sj" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addReceive.do\';"></i><br>'
                		+ '<span onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addReceive.do\';">客户收件</span>'
                		+ '</li>'
                		+ '<li class="y-kd-right y-kd-top " >'
                		+ '<i class="y-kd-fj" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addSend.do\';"></i><br>'
                		+ '<span onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addSend.do\';">客户发件</span>'
                		+ '</li>'
                		+ '<li class="y-kd-left y-kd-bottom y-kd-rightb y-kd-topb" id="ztysbtn">'
                		+'<i class="y-kd-qs" ></i><br>'
                		+'<span>快速签收</span>'
                		+'</li>'
                		+'<li class="y-kd-right y-kd-bottom y-kd-topb">'
                		+'<i class="y-kd-yh" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addDiscount.do\';"></i><br>'
                		+'<span onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addDiscount.do\';">优惠设置</span>'
                		+'</li>'
                		+'<li class="y-kd-index">'
                		+'<i class="y-kd-qj" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addAppointment.do\';"></i><br>'
                		+'<span onclick="javascript:window.location.href=\'<%=ctx %>/business/businessExp/addAppointment.do\';">预约发件</span>'
                		+'</li>'
                		+'</ul>'
                		+'</a>'
                		+'</div>';
                	$('.column').append(addHtml);
                }
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                    	var row = rows[i];  
                    	var styleStr = '';
                    	var styleStr = '';
                    	if(params.page == 1 && i % 3 == 2) {
                    		styleStr = 'style="margin-left:0;"';
       	        		}else if(params.page > 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
                    	
                    	var expState = '';
                    	var userName = '';
                    	var userAddress = '';
                    	var userTel ='';
                    	var appointInfo = '';
                    	if(row.expState == 0) {
                    		expState = '<span class="yggl_relsta crosered">上门取件</span>';
                    		userName = row.senderName;
                    		userAddress = row.senderAddr;
                    		userTel = row.senderTel;
    		            }else if(row.expState == 1) {
    		            	expState = '<span class="yggl_relsta cdblue">已上门</span>';
    		            	userName = row.senderName;
    		            	userAddress = row.senderAddr;
    		            	userTel = row.senderTel;
    		            }else if(row.expState == 2) {
    		            	expState = '<span class="yggl_relsta cblue" >已发送</span>';
    		            	userName = row.senderName;
    		            	userAddress = row.senderAddr;
    		            	userTel = row.senderTel;
    		            }else if(row.expState == 3) {
    		            	expState = '<span class="yggl_relsta cyellow">已入库</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else if(row.expState == 4) {
    		            	expState = '<span class="yggl_relsta cpurple">自提</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else if(row.expState == 5) {
    		            	expState = '<span class="yggl_relsta ccyan">上门送件</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else if(row.expState == 6) {
    		            	expState = '<span class="yggl_relsta cgreen">已签收</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else if(row.expState == 7) {
    		            	expState = '<span class="yggl_relsta cblack">已退件</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else  if(row.expState == 8) {
    		            	expState = '<span class="yggl_relsta cgray">已取消</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }else  if(row.expState == 9) {
    		            	expState = '<span class="yggl_relsta cdred">问题件</span>';
    		            	userName = row.receiverName;
    		            	userAddress = row.receiverAddr;
    		            	userTel = row.receiverTel;
    		            }
                    	
                    	String.prototype.replaceAll  = function(s1,s2){    
                            return this.replace(new RegExp(s1,"gm"),s2);    
                        };
                    	var briefMessage = (row.briefMessage).replaceAll("\r\n", "<br>");
                    	
                    	var htmlDom = ''
                  		+ '<div class="manbox"'
        	        	+ styleStr
        	        	+ '>'
        	        	+ '<a class="nopotr y-kd-boxh" href="javascript:;">'
        	        	+ '<p class="y-kd-infor">'
        	        	+ '<span class="y-kd-yz">所属驿站：<lable  style="color: #3EAF0E;">'+row.station+'</lable></span>'
        	        	+ '<span class="y-kd-kjgs">快件公司：<lable  style="color: #3EAF0E;">'+row.expCompany+'快递</lable></span>'
        	        	+ '</p>'
        	        	+ '<time class="y-kd-time1">'+(row.createTime != '' ? row.createTime.substring(0, 16) : '')+'</time>'
        	        	+ '<hr class="link">'
        	        	+ '<p class="y-kd-infor1"><span class="y-kd-name">'+userName+'</span><span class="y-kd-address">'+userAddress+'</span></p>'
        	        	+ '<span class="y-kd-phone">'+userTel+'</span>'
        	        	+ '<div class="state">'
        	        	+ expState
        	        	+ '</div>'
        	        	+ '<div class="text">'
        	        	+ briefMessage
                    	+ '</div>'
        	        	+ '<hr class="link" style="margin:5px auto 0">'
        	        	<shiro:hasPermission name="exp_view_detail">
        	        	+ '<div class="operate operate2 blop" style="margin:0;">'
        	        	+ '<span class="see" style="position:relative; height:50px;" title="查看快递详情" onclick="seeExDetail('+row.expId+', '+row.expState+', '+row.newsCount+'); ">'
        	        	+ (row.newsCount>0?'<img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" />':'')
        	        	+ '</span></div>'
        	        	</shiro:hasPermission>
        	        	+ '</a>'                
                    	+ '</div>';
                    	$('.column').append(htmlDom);
                    }
                }else{
                	$('.column').html('很抱歉，没有相关记录。');
                }
                $('.column').append('<div class="no-float"></div>');
                $('#loading').css('display', 'none');
                
                var vis = $("#pageUl li:not(#pageUl :first,#pageUl :last):visible");//显示的数量
               	var liCount = '';  
                for(var pageno=1; pageno<=(data.pageCount); pageno++){
                	var flag=false;
                	for(var i=0;i<vis.size();i++){
                		if(vis.eq(i).find("span").text()==pageno){
                			flag=true;
                		}
                	}
                	if(flag){
                		liCount = liCount + '<li><a   href="javascript:jump('+pageno+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                	}else{
                		liCount = liCount + '<li style="display:none";><a  href="javascript:jump('+pageno+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                	}
                	
                }
                var boolnext = '';
                if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next();'; }
                var boolprev = '';
                if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev();';  }
	           	var pageDom = ''
	           		+ '<div class="pagec"><ul id="pageUl">'
	           		+ '<li><a id="arrow-l" class="arrow" href="'+boolprev+'"></a></li>'
	           		+ liCount
	           		+ '<li><a id="arrow-r" class="arrow" href="'+boolnext+'"></a></li>'
	           		+ '</ul></div>';
	           	$('.page').html('');
            	$('.page').html(pageDom);
	            setCurrPageNo(pageNo);
                
                var uw=$(".y-kd-kdzt").width() - 4;
                var uh=$(".y-kd-kdzt").height() - 4;
                setwh(uw,uh);
            },
            error: function () {
            	$('.column').html('很抱歉，加载内容出错，我们及时修改问题。');
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
    				alert(strIds.length);
    				alert(strIds);
    				var ids=strIds.join("#");
    				alert("你选中的字符串有："+ids);
    				 window.location.href = '${ctx}/business/businessExp/exportExcel.do';//?expIds='+strIds;
    			} ;

      		} );
    });

</script>	
    	
    </head>
    <body>
    <div>	
        <div class="newsrel">  
            <div class="header-public"><span class="return" onclick="window.location.href='<%=ctx %>/business/businessExp/list.do'" ></span>导出Excel预览</div>      
            <div class="content">
                <div class="scroll">
                    <div class="scroll-box">
                        <ul id="oneul">
						
						<li id="expEstate_" class="active navlist"><a href="javascript:;"><span>全部驿站</span><b class="donbut"><i></i></b></a>
<%-- 	                    	<input type="hidden" name="expState" id="expState" value="${expState }" /> --%>
	                    	<ul class="erjnav">
				          	  	<%
				          	  	List estateBeanList = CommonUtils.getUser().getEstateBeanList();
				          	  	for(int j=0;j<estateBeanList.size();j++) {
				          	  		EstateBean estateBean = (EstateBean)estateBeanList.get(j);
				          	  		%>
										<li id="expEstate_<%=j %>>"><a href="javascript:;"><%=estateBean.getEstateName() %></a></li>
				          	  		<%
				          	  	}
				          	  	%>
	                        </ul>
	                    </li>
						
						<li id="expState_" class="active navlist"><a href="javascript:;"><span>全部快递</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="expState" id="expState" value="${expState }" />
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
	                        	<li id="expState_10"><a href="javascript:;">被投诉快递</a></li>
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
                         <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共196条</p>
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
                          <tr 
                           <c:if test="${key.index % 2 == 1}" >class="trtwo"</c:if>   
                          >
                            <td><input type="checkbox" value="${exp.expId}"/></td>
                            <td>
								<c:if test="${exp.expState == 0 || exp.expState == 1 || exp.expState == 2}" >
									<fmt:formatDate value="${exp.sendTime}" type="date"/>
								</c:if>

								<c:if test="${exp.expState == 3 }" >
									<fmt:formatDate value="${exp.checkInTime}" type="date"/>
								</c:if>
								
								<c:if test="${ exp.expState == 4 || exp.expState == 5 || exp.expState == 6 || exp.expState == 7 || exp.expState == 8 || exp.expState == 9}">
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
									<c:when test="${exp.expState == 10}">
										被投诉快递
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
                            <td></td>
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
                   
                   
                   <sapn class="exp-exp">
							<a id="exportExcel">EXCEL 导出</a> 
                   </span>
                </div>
            </div>     
        </div>
    </div>      
</body>
</html>